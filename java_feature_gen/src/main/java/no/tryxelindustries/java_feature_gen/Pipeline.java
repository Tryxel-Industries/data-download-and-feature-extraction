package no.tryxelindustries.java_feature_gen;

import no.tryxelindustries.java_feature_gen.enums.Feature;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.GeneratorFactory;
import no.tryxelindustries.java_feature_gen.features.NewsEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pipeline {
    private final List<Feature>                      featuresUsed;
    private final Map<Feature, FeatureGeneratorBase> generatorMap;

    private final GeneratorFactory factory = new GeneratorFactory();

    public Pipeline(List<Feature> featuresUsed) {
        generatorMap = new HashMap<>();
        this.featuresUsed = featuresUsed;
        for (Feature f : featuresUsed) {
            FeatureGeneratorBase generator = factory.getGenerator(f);
            generatorMap.put(f, generator);
        }
    }

    public NewsEntry run(NewsEntry entry, Feature feature) {
        var resMap = entry.getResultMap();
        if (!resMap.containsKey(feature)) {
            resMap.put(feature, generatorMap.get(feature).getFeatureValue(entry.document));
        }
        return entry;
    }

    public NewsEntry runAll(NewsEntry entry) {
        for (Feature f : featuresUsed) {
            this.run(entry, f);
        }
        return entry;

    }
}
