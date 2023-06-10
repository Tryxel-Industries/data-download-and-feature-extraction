package no.tryxelindustries.java_feature_gen.features;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class FeatureResult {
    @JsonIgnore
    public final List<String> annotation;
    public       double       featureValue;

    public FeatureResult(List<String> annotation, double featureValue) {
        this.annotation = annotation;
        this.featureValue = featureValue;
    }

    @Override
    public String toString() {
        return "FeatureResult{" +
                "featureValue=" + featureValue +
                '}';
    }
}
