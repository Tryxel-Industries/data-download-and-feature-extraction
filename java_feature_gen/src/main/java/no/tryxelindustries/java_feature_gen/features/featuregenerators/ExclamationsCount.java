package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.util.StringUtils;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExclamationsCount extends FeatureGeneratorBase {


    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        List<String> annotation = new ArrayList<>();
        Pattern pattern = Pattern.compile("[!|?]{2,}");

        double numberOfExclamations = 0.0;
        for (CoreLabel token : document.tokens()) {
            String word = token.word();
            if (pattern.matcher(word).find()) {
                annotation.add("True");
                numberOfExclamations += 1;
            } else {
                annotation.add("False");
            }
        }

        return new FeatureResult(annotation, (double) numberOfExclamations / document.tokens().size());
//        return new FeatureResult(annotation, numberOfExclamations);
    }
}
