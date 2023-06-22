package no.tryxelindustries.java_feature_gen.datasets.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import no.tryxelindustries.java_feature_gen.datasets.DatasetReader;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Politifact extends FakeNewsNet {

    @Override
    public String getDatasetName() {
        return "politifact";
    }


    @Override
    public List<NewsEntry> readDataset() {
        Stream<NewsEntry> real_news = this.getPolitifactEntries("real")
                                          .stream()
                                          .map(entry -> entry.get_as_news_entry(1));
        Stream<NewsEntry> false_news = this.getPolitifactEntries("fake")
                                           .stream()
                                           .map(entry -> entry.get_as_news_entry(0));

        return Stream.concat(real_news, false_news).toList();
    }
}
