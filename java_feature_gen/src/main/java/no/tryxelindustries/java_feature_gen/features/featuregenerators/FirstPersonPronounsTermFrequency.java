package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;

import java.util.List;

public class FirstPersonPronounsTermFrequency extends FeatureGeneratorBase {

    private static       DebugLogger        dbl      = new DebugLogger(true);
    private static final String             filePath = "./lexicons/first_person_pronouns";
    private final        List<LexiconEntry> lexicon;

    public FirstPersonPronounsTermFrequency() {
        lexicon = this.readLexiconFile(filePath);
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        return this.getTermCount(document, lexicon);
    }
}
