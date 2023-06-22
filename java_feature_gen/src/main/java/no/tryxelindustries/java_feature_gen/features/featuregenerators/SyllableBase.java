package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class SyllableBase extends FeatureGeneratorBase {
    private static final String             filePath = "lexicons/cmudict-0.7b";
    private final        List<LexiconEntry> lexiconEntries;


    public SyllableBase() {
        this.lexiconEntries = readLexiconFile();
    }

    private Optional<LexiconEntry> parseLine(String line) {
        if (line.startsWith(";;;")) {
            return Optional.empty();
        }

        var split = line.split(" ");

        String base_word = split[0];
        int nSyllables = 0;
        for (int i = 1; i < split.length; i++) {
            String word = split[i];
            if (word.length() > 0) {
                if (Character.isDigit(word.charAt(word.length() - 1))) {
                    nSyllables += 1;
                }
            }
        }


        if (true) {
            return Optional.of(new LexiconEntry(base_word, Integer.toString(nSyllables)));
        } else {
            return Optional.empty();
        }

    }

    private List<LexiconEntry> readLexiconFile() {
        List<String> lines = this.readFile(filePath);

        var entries = lines.parallelStream()
                           .map(this::parseLine)
                           .filter(Optional::isPresent)
                           .map(Optional::get)
                           .toList();

        return entries;
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        var res = this.getTermCount(document, this.lexiconEntries);
        double nSentences = document.sentences().size();
        double nWords = document.tokens().size();
        Object NumberUtils;
        double nSyllables = res.annotation.parallelStream()
                                          .filter(StringUtils::isNumeric)
                                          .mapToInt(Integer::valueOf)
                                          .sum();

        double fkLevel = (0.39 * (nWords / nSentences)) + (11.8 * (nSyllables / nWords)) - 15.59;
        res.featureValue = fkLevel;
        return res;
    }
}
