package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EffectWordsSummedValue extends FeatureGeneratorBase {
    private static final String             filePath = "lexicons/MPQAA/effect_words/EffectWordNet.tff";
    private final        List<LexiconEntry> lexiconEntries;

    public EffectWordsSummedValue() {
        this.lexiconEntries = readLexiconFile();
    }

    private List<LexiconEntry> parseLine(String line) {
        var retList = new ArrayList<LexiconEntry>();
        var split = line.split("\t");
        String effect = split[1];
        String word = split[2];
        var multiWordSplit = word.split(",");

        for (String s : multiWordSplit) {
            retList.add(new LexiconEntry(s, effect));
        }
        return retList;
    }

    private List<LexiconEntry> readLexiconFile() {
        List<String> lines = this.readFile(filePath);

        var entries = lines.parallelStream()
                           .flatMap(s -> parseLine(s).stream())
                           .filter(lexiconEntry -> !lexiconEntry.label.equals("Null"))
                           .toList();

        return entries;
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        var featureRes = this.getTermCount(document, this.lexiconEntries);

        long nPos = featureRes.annotation.stream().filter(s -> s.equals("+Effect")).count();
        long nNeg = featureRes.annotation.stream().filter(s -> s.equals("-Effect")).count();
        featureRes.featureValue = nPos - nNeg;
        featureRes.featureValue /= document.tokens().size();
        return featureRes;
    }
}
