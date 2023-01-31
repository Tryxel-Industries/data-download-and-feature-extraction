package no.tryxelindustries.java_feature_gen.features.featuregenerators;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class QuotationCount extends FeatureGeneratorBase {


    @Override
    public FeatureResult getFeatureValue(CoreDocument document) {
        List<String> annotation = new ArrayList<>();


//        dbl.log(document.quotes().size());
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

        return new FeatureResult(annotation, numberOfExclamations);
    }
}
