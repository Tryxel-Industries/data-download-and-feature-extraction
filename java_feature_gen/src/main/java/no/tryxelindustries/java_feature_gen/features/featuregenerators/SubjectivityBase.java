package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectivityBase extends FeatureGeneratorBase {
    private static final String             filePath = "lexicons/MPQAA/subjectivity/subjclueslen1-HLTEMNLP05.tff";
    private final        List<LexiconEntry> lexiconEntries;

    private Runtype runtype;

    public enum Runtype {
        StrongSubPos,
        StrongSubNeg,
        StrongSub,


    }

    public SubjectivityBase(Runtype runtype) {
        this.runtype = runtype;
        this.lexiconEntries = readLexiconFile();
    }

    private Optional<LexiconEntry> parseLine(String line) {
        var split = line.split(" ");
        String subjectivityType = split[0].substring(5);
        String word = split[2].substring(6);
        String polarity = split[split.length - 1].substring(14);

        var keep = switch (this.runtype) {
            case StrongSubPos -> subjectivityType.equals("strongsubj") && polarity.equals("positive");
            case StrongSubNeg -> subjectivityType.equals("strongsubj") && polarity.equals("negative");
            case StrongSub -> subjectivityType.equals("strongsubj");
        };


        if (keep) {
            return Optional.of(new LexiconEntry(word, subjectivityType + " " + polarity));
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
        return this.getTermCount(document, this.lexiconEntries);
    }
}
