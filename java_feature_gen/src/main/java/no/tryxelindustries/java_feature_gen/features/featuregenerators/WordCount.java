package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.util.StringUtils;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordCount extends FeatureGeneratorBase {

    private static DebugLogger dbl = new DebugLogger(true);

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {

        List<String> annotationMap = new ArrayList<>(Collections.nCopies(document.tokens().size(), "Na"));
        return new FeatureResult(annotationMap, document.tokens().size());
    }
}
