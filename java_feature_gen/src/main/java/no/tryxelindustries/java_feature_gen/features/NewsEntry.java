package no.tryxelindustries.java_feature_gen.features;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.stanford.nlp.pipeline.CoreDocument;
import lombok.Getter;
import lombok.Setter;
import no.tryxelindustries.java_feature_gen.enums.Feature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NewsEntry {
    public final int id;

    public final String       title;
    public final String       rawText;
    @JsonIgnore
    public final CoreDocument document;
    public final int          publishDate;

    @Getter
    @Setter
    private Map<Feature, FeatureResult> resultMap;

    @Getter
    @Setter
    private List<String> sentences;

    public NewsEntry(int id, String title, String rawText, CoreDocument document, int publishDate) {
        this.id = id;
        this.title = title;
        this.rawText = rawText;
        this.publishDate = publishDate;
        this.document = document;
        resultMap = new HashMap<>();
        sentences = new ArrayList<>();
    }
}
