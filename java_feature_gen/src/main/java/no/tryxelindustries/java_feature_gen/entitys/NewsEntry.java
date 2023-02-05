package no.tryxelindustries.java_feature_gen.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.stanford.nlp.pipeline.CoreDocument;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import no.tryxelindustries.java_feature_gen.enums.Feature;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NewsEntry {
    public final int id;

    public final String title;

    @JsonIgnore
    public final String rawText;

    @JsonIgnore
    public CoreDocument document;

    public int publishDate;

    @Getter
    @Setter
    private Map<Feature, FeatureResult> resultMap;

    @Getter
    @Setter
    @JsonIgnore
    private List<String> sentences;

    @Getter
    @Setter
    private String label;

    public NewsEntry(int id, String title, String rawText, String label) {
        this.id = id;
        this.title = title;
        this.rawText = stripUrl(rawText);
        this.label = label;
        resultMap = new HashMap<>();
        sentences = new ArrayList<>();
    }

    private String stripUrl(String inp) {
        return inp.replaceAll("http(s|)://[^ \\n]*", "<url>");
    }

    public record EntrySentences(int id, List<String> sentences) {
    }

    public record EntryText(int id, String text) {
    }

    @JsonIgnore
    public EntrySentences getAsEntrySentence() {
        return new EntrySentences(id, sentences);
    }

    @JsonIgnore
    public EntryText getAsEntryText() {
        return new EntryText(id, rawText);
    }
}
