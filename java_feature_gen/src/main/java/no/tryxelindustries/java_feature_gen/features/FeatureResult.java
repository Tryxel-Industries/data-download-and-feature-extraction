package no.tryxelindustries.java_feature_gen.features;

import java.util.List;

public class FeatureResult {
    public final List<String> annotation;
    public final double       featureValue;

    public FeatureResult(List<String> annotation, double featureValue) {
        this.annotation = annotation;
        this.featureValue = featureValue;
    }
}
