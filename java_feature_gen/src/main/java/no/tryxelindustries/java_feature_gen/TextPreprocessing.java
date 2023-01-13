package no.tryxelindustries.java_feature_gen;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;
import java.util.stream.Collectors;

public class TextPreprocessing {

    public void testiTest(String text){
        Properties props = new Properties();
        props.setProperty("annotators","tokenize, ssplit, pos, lemma, ner");
        setTokenizeProps(props);
        setSentenceSplitProps(props);
        setNamedEntityRecognitionProps(props);
        props.list(System.out);

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        CoreDocument document = pipeline.processToCoreDocument(text);
    // annotate the document
    // view results
//        printNamedEntityInfo(document);

//        document.quotes().forEach(System.out::println);
//        document.tokens().forEach(token -> {
//            System.out.printf("%10s %10s %10s\n", token.word(), token.lemma(), token.ner());
//        });

//        System.out.printf("%10s %10s %10s\n", token.word(), token.lemma(), token.ner());
//        var last_s = document.sentences().get(document.sentences().size()-1);

//        util.showTextWithAnno(document.tokens().stream().map(CoreLabel::word).toList(), document.tokens().stream().map(CoreLabel::tag).toList());
        util.showTextWithAnno(document.tokens().stream().map(CoreLabel::word).toList(), document.tokens().stream().map(CoreLabel::ner).toList());
//        util.showTextWithAnno(document.tokens().stream().map(CoreLabel::word).toList(), document.tokens().stream().map(CoreLabel::lemma).toList());
//        System.out.println(last_s.lemmas());
//        System.out.println(last_s.nerTags());
//        System.out.println(last_s.posTags());
//        document.sentences().forEach(System.out::println);
    }

    private void printNamedEntityInfo(CoreDocument doc){
        System.out.println("---");
        System.out.println("entities found");
        for (CoreEntityMention em : doc.entityMentions())
            System.out.println("\tdetected entity: \t"+em.text()+"\t"+em.entityType());
        System.out.println("---");
        System.out.println("tokens and ner tags");
        String tokensAndNERTags = doc.tokens().stream().map(token -> "("+token.word()+","+token.ner()+")").collect(
                Collectors.joining(" "));
        System.out.println(tokensAndNERTags);
    }
    private void setTokenizeProps(Properties props){
        /*
        https://stanfordnlp.github.io/CoreNLP/tokenize.html

         */
        props.setProperty("tokenize.options","quotes=ascii, dashes=ptb3");

    }
    private void setSentenceSplitProps(Properties props){
        /*
        how to treat newlines, three options:
        always: always splitt at newline
        never: ignore newline
        two: when 2 or more newlines are encountered
         */
        props.setProperty("ner.combinationMode","HIGH_RECALL");
    }

    private void setNamedEntityRecognitionProps(Properties props){

        props.setProperty("ner.combinationMode","");
    }
}
