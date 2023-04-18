package no.tryxelindustries.java_feature_gen.entitys;

import no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSentences;
import no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySentences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtoBuilder {

    private static final String DATASET_SAVE_DIR = "./data_out";

    public static void writeSentencesToDisk(String dataset_name, List<NewsEntry> entryList) {
        File save_dir = new File(DATASET_SAVE_DIR, dataset_name);
        File save_path = new File(save_dir, "sentences_proto.bin");
        if (!save_dir.exists()) {
            save_dir.mkdir();
        }

        var datasetBuilder = DatasetSentences.newBuilder();
        List<NewsEntrySentences> entrySentences = entryList.parallelStream().map(newsEntry -> NewsEntrySentences.
                newBuilder()
                .setId(newsEntry.id)
                .setLabel(newsEntry.getLabel())
                .setPublishDate(newsEntry.publishDate)
                .addAllSentences(newsEntry.getSentences())
                .build()).toList();

        datasetBuilder.setDatasetName(dataset_name);
        datasetBuilder.addAllNewsEntries(entrySentences);


        DatasetSentences dataset = datasetBuilder.build();
        try (FileOutputStream output = new FileOutputStream(save_path)) {
            dataset.writeTo(output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
