package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.util.StringUtils;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class NumberCount extends FeatureGeneratorBase {


    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        List<String> annotation = new ArrayList<>();

        double numberOfNumbers = 0.0;
        boolean isInNumber = false;
        for (CoreLabel token : document.tokens()) {
            String word = token.word();
            if (NumberUtils.isNumber(word)) {
                annotation.add("True");
                isInNumber = true;
            } else {
                if (isInNumber) {
                    numberOfNumbers += 1;
                }
                isInNumber = false;
                annotation.add("False");
            }
        }

        if (isInNumber) {
            numberOfNumbers += 1;
        }


        return new FeatureResult(annotation, numberOfNumbers);
    }
}
