package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;

import java.util.List;
import java.util.Optional;

public class SwearWords extends FeatureGeneratorBase {
    private static final String             filePath = "lexicons/profanity_en.csv";
    private final        List<LexiconEntry> lexiconEntries;


    public SwearWords() {
        this.lexiconEntries = readLexiconFile();
    }

    private Optional<LexiconEntry> parseLine(String line) {
        var split = line.split(",");
        String word = split[0];

        String severity = split[split.length - 1];


        if (true) {
            return Optional.of(new LexiconEntry(word, severity));
        } else {
            return Optional.empty();
        }

    }

    private List<LexiconEntry> readLexiconFile() {
        List<String> lines = this.readFile(filePath);
        lines.remove(0);

        var entries = lines.parallelStream()
                           .map(this::parseLine)
                           .filter(Optional::isPresent)
                           .map(Optional::get)
                           .toList();

        return entries;
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        return this.getTermCount(document, this.lexiconEntries);
    }
}
