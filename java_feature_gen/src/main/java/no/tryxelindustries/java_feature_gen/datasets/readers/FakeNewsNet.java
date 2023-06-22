package no.tryxelindustries.java_feature_gen.datasets.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import no.tryxelindustries.java_feature_gen.datasets.DatasetReader;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public abstract class FakeNewsNet extends DatasetReader {


    private String stripSurroundingQuotes(String inp) {
        if (inp.startsWith("\"")) {
            return inp.substring(1, inp.length() - 1);
        } else {
            return inp;
        }
    }


    @Data
    @AllArgsConstructor
    public static class FNNPolitifactEntry {
        int id;
        public String url;
        public String text;
        public String title;
        public int    publish_date;

        public NewsEntry get_as_news_entry(int label) {
            return new NewsEntry(id, title, text, Integer.toString(label));
        }
    }

    private FNNPolitifactEntry read_politifact_entry(File file) {
//        politifact4926
//        int id = Integer.parseInt(file.getParentFile().getName().substring(10));
        int id = this.getNextId();
        try {

            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree = mapper.readTree(file);

            String url = tree.get("url").toString();
            String text = tree.get("text").toString();
            String title = tree.get("title").toString();
            int publish_date = tree.get("publish_date").intValue();

            FNNPolitifactEntry entry = new FNNPolitifactEntry(id, url, text, title, publish_date);
            return entry;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<FNNPolitifactEntry> getPolitifactEntries(String entry_dir_name) {

        File entry_type_dir = new File(this.getDatasetInDir(), entry_dir_name);
        List<FNNPolitifactEntry> politifactEntries = Stream.of(entry_type_dir.listFiles())
                                                           .map(file -> new File(file, "news content.json"))
                                                           .map(this::read_politifact_entry)
                                                           .toList();


        return politifactEntries;
    }

    protected List<FNNPolitifactEntry> getGossipCopEntries(String entry_dir_name) {

        File entry_type_dir = new File(this.getDatasetInDir(), entry_dir_name);
        List<FNNPolitifactEntry> politifactEntries = Stream.of(entry_type_dir.listFiles())
                                                           .map(file -> new File(file, "news content.json"))
                                                           .map(this::read_politifact_entry)
                                                           .toList();


        return politifactEntries;
    }


}
