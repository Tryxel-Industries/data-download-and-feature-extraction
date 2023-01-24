package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.util.StringUtils;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordCount extends FeatureGeneratorBase {

    private static DebugLogger dbl = new DebugLogger(true);

    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        List<String> annotation = new ArrayList<>();

        double numberOfCapWords = 0.0;
        for (CoreLabel token : document.tokens()) {
            String word = token.word();
            if (StringUtils.isAllUpperCase(word)) {
                annotation.add("True");
                numberOfCapWords += 1;
            } else {
                annotation.add("False");
            }
        }

        return new FeatureResult(annotation, numberOfCapWords);
    }
}
