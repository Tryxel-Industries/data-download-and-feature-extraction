package no.tryxelindustries.java_feature_gen.datasets;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.tryxelindustries.java_feature_gen.DebugLogger;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class DatasetReader {
    public static DebugLogger dbl         = new DebugLogger(true);
    private final String      rawBasePath = "./data_in/";

    private final String transformedBasePath = "./data_out/";

    private final String sentenceSplitPattern = "sentence_split_%s.json";

    private final String processedTextPattern = "processed_text_%s.json";

    private final String semanticFeaturePattern = "semantic_features_%s.json";

    private int id_counter = 0;

    protected int getNextId() {
        int id = id_counter;
        id_counter += 1;
        return id;
    }

    protected DatasetReader() {
        File outDir = getDatasetOutDir();
        if (!outDir.exists()) {
            outDir.mkdir();
        }
        if (!getDatasetInDir().exists()) {
            throw new RuntimeException("Provided reader path does not exist");
        }


    }

    public void writeDatasetEntries(List<NewsEntry> newsEntries) {
        writeSentenceData(newsEntries);
        writeSemanticData(newsEntries);
        writeSentenceTextData(newsEntries);
    }

    private void writeSemanticData(List<NewsEntry> newsEntries) {
        String fileName = String.format(semanticFeaturePattern, getDatasetName());
        File filePath = new File(getDatasetOutDir(), fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(filePath, newsEntries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void writeSentenceData(List<NewsEntry> newsEntries) {
        String fileName = String.format(sentenceSplitPattern, getDatasetName());
        File filePath = new File(getDatasetOutDir(), fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        var sentenceEntries = newsEntries.stream().map(NewsEntry::getAsEntrySentence).toList();
        try {
            objectMapper.writeValue(filePath, sentenceEntries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void writeSentenceTextData(List<NewsEntry> newsEntries) {
        String fileName = String.format(processedTextPattern, getDatasetName());
        File filePath = new File(getDatasetOutDir(), fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        var sentenceEntries = newsEntries.stream().map(NewsEntry::getAsEntryText).toList();
        try {
            objectMapper.writeValue(filePath, sentenceEntries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected File getDatasetOutDir() {
        return new File(transformedBasePath, getDatasetName());
    }

    protected File getDatasetInDir() {
        return new File(rawBasePath, getDatasetName());
    }

    public abstract String getDatasetName();


    public abstract List<NewsEntry> readDataset();
}
