package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.LexiconEntry;
import no.tryxelindustries.java_feature_gen.features.MPQAArguingGeneratorBase;

import java.util.List;

public class MPQAEmphasisTermFrequency extends MPQAArguingGeneratorBase {

    private static final String       filePath = "lexicons/MPQAA/arg_lex/emphasis.tff";
    private final        List<String> regexLexicon;

    public MPQAEmphasisTermFrequency() {
        regexLexicon = this.readRegexFile(filePath);
    }

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        return getRegexTermFrequency(document, regexLexicon);
    }
}
