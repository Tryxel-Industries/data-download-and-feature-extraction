package no.tryxelindustries.java_feature_gen;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import no.tryxelindustries.java_feature_gen.features.NewsEntry;

import java.util.Properties;

public class DataProcessing {
    private StanfordCoreNLP pipeline;
    private boolean         findQuotes;

    public DataProcessing(boolean findQuotes) {
        this.findQuotes = findQuotes;
        pipeline = generatePipeline();

    }

    private StanfordCoreNLP generatePipeline() {
        Properties props = new Properties();
        if (findQuotes) {
            props.setProperty("annotators",
                              "tokenize, ssplit, pos, lemma, ner, depparse, coref"); // needed for quoutes but slow so maby regex qoutes insead
        } else {
            props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        }

        props.setProperty("tokenize.options", "quotes=ascii, dashes=ptb3");
        props.setProperty("ssplit.newlineIsSentenceBreak", "two");

        return new StanfordCoreNLP(props);
    }

    public NewsEntry processNewsData(String rawData) {

        CoreDocument document = pipeline.processToCoreDocument(rawData);

        NewsEntry entry = new NewsEntry(-1, "bipbop", rawData, document, -1);
        entry.setSentences(document.sentences()
                                   .stream()
                                   .map(CoreSentence::text)
                                   .filter(s -> s.length() > 1)
                                   .toList()); // for the embedding and stuff

        return entry;
    }
}
