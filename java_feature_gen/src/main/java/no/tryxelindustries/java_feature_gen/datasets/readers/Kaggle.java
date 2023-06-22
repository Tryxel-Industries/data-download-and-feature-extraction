package no.tryxelindustries.java_feature_gen.datasets.readers;

import no.tryxelindustries.java_feature_gen.datasets.DatasetReader;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kaggle extends DatasetReader {

    @Override
    public String getDatasetName() {
        return "kaggle";
    }


    private String stripSurroundingQuotes(String inp) {
        if (inp.startsWith("\"")) {
            return inp.substring(1, inp.length() - 1);
        } else {
            return inp;
        }
    }

    @Override
    public List<NewsEntry> readDataset() {
        // this is why you do not fucking use csv for data with littered with commas
        String sep = "¦";
        File datasetFile = new File(getDatasetInDir(), "train_non_shit_formating.csv");

        List<NewsEntry> newsEntries = new ArrayList<>();

        int entryNmr = 0;
        int shittynessOfDataset = 0;
        try (Scanner scanner = new Scanner(new FileReader(datasetFile))) {
            scanner.useDelimiter(sep);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                int article_id = scanner.nextInt();
                int id = this.getNextId();

                String title = this.stripSurroundingQuotes(scanner.next());
                String author = scanner.next();
                String text = this.stripSurroundingQuotes(scanner.next());

                String sLabel = scanner.next();
                String blank = scanner.next();
                scanner.nextLine();


                if (!NumberUtils.isNumber(sLabel)) {
                    shittynessOfDataset += 1;
                    continue;
                }
                int label = Integer.parseInt(sLabel);

                NewsEntry entry = new NewsEntry(id, title, text, Integer.toString(label));
                newsEntries.add(entry);
                System.out.printf("on entry %s            \r", entryNmr);
                entryNmr++;

//                if (entryNmr > 100) {
//                    break;
//                }

            }
        } catch (FileNotFoundException e) {
            System.out.println();
            throw new RuntimeException(e);
        }
        dbl.log("found ", shittynessOfDataset, " malformed entries.");


        return newsEntries;

    }
}
