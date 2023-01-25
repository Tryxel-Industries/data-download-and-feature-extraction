package no.tryxelindustries.java_feature_gen.features;

import edu.stanford.nlp.pipeline.CoreDocument;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


public class NewsEntry {
    public final int          id;
    public final String       rawText;
    public final CoreDocument document;
    public final int          publishDate;

    @Getter
    @Setter
    private Map<String, FeatureResult> resultMap;

    @Getter
    @Setter
    private List<String> sentences;

    public NewsEntry(int id, String rawText, CoreDocument document, int publishDate) {
        this.id = id;
        this.rawText = rawText;
        this.publishDate = publishDate;
        this.document = document;
    }
}
