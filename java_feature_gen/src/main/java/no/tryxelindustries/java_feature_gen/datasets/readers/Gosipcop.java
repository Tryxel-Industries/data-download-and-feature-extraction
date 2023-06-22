package no.tryxelindustries.java_feature_gen.datasets.readers;

import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;

import java.util.List;
import java.util.stream.Stream;

public class Gosipcop extends FakeNewsNet {

    @Override
    public String getDatasetName() {
        return "gosipcop";
    }


    @Override
    public List<NewsEntry> readDataset() {
        Stream<NewsEntry> real_news = this.getGossipCopEntries("real")
                                          .stream()
                                          .map(entry -> entry.get_as_news_entry(1));
        Stream<NewsEntry> false_news = this.getGossipCopEntries("fake")
                                           .stream()
                                           .map(entry -> entry.get_as_news_entry(0));

        return Stream.concat(real_news, false_news).toList();
    }
}
