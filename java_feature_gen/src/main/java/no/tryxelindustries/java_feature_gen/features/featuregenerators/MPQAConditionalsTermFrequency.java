package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.MPQAArguingGeneratorBase;

import java.util.List;

public class MPQAConditionalsTermFrequency extends MPQAArguingGeneratorBase {

    private static final String       filePath = "lexicons/MPQAA/arg_lex/conditionals.tff";
    private final        List<String> regexLexicon;

    public MPQAConditionalsTermFrequency() {
        regexLexicon = this.readRegexFile(filePath);
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        return getRegexTermFrequency(document, regexLexicon);
    }
}
