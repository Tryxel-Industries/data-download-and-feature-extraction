package no.tryxelindustries.java_feature_gen.datasets.readers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import no.tryxelindustries.java_feature_gen.datasets.DatasetReader;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Buzzfeed extends DatasetReader {

    @Override
    public String getDatasetName() {
        return "buzfeed";
    }


    private String stripSurroundingQuotes(String inp) {
        if (inp.startsWith("\"")) {
            return inp.substring(1, inp.length() - 1);
        } else {
            return inp;
        }
    }

    private File getArticlesDir() {
        return new File(this.getDatasetInDir(), "articles");
    }


    @Data
    @AllArgsConstructor
    private static class BuzzfeedEntry {
        int id;
        public String author;
        public String mainText;
        public String orientation;
        public String title;
        public String veracity;
        public String uri;

        public NewsEntry get_as_news_entry() {
            var label = switch (veracity) {
                case "mostly true" -> 0;
                case "mostly false" -> 1;
                case "mixture of true and false" -> 2;
                case "no factual content" -> 3;
                default -> -1;
            };

            if (label == -1) {
                System.out.println(veracity);
            }
            return new NewsEntry(id, title, mainText, Integer.toString(label));
        }
    }

    private BuzzfeedEntry read_buzfeed_entry(File file) {
//        politifact4926
//        int id = Integer.parseInt(file.getParentFile().getName().substring(10));
        int id = this.getNextId();


        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String author = null;
            String mainText = null;
            String orientation = null;
            String title = null;
            String veracity = null;
            String uri = null;

            var rootNode = doc.getElementsByTagName("article").item(0);
            var children = rootNode.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                var childNode = children.item(i);
                String nodeName = childNode.getNodeName();

                switch (nodeName) {
                    case "author":
                        author = childNode.getTextContent();
                        break;
                    case "mainText":
                        mainText = childNode.getTextContent();
                        break;

                    case "orientation":
                        orientation = childNode.getTextContent();
                        break;

                    case "title":
                        title = childNode.getTextContent();
                        break;

                    case "veracity":
                        veracity = childNode.getTextContent();
                        break;
                    case "uri":
                        uri = childNode.getTextContent();
                        break;
                }

            }
//            System.out.printf("author is %s\n", author);
//            System.out.printf("orientation is %s\n", orientation);
//            System.out.printf("title is %s\n", title);
//            System.out.printf("veracity is %s\n", veracity);

            return new BuzzfeedEntry(id, author, mainText, orientation, title, veracity, uri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    private List<FNNPolitifactEntry> getPolitifactEntries(String entry_dir_name) {
//
//        File entry_type_dir = new File(this.getArticlesDir(), entry_dir_name);
//        List<FNNPolitifactEntry> politifactEntries = Stream.of(entry_type_dir.listFiles())
//                                                           .map(file -> new File(file, "news content.json"))
//                                                           .map(this::read_politifact_entry)
//                                                           .toList();
//
//
//        return politifactEntries;
//    }
//

    @Override
    public List<NewsEntry> readDataset() {
        var articles_dir = getArticlesDir();
        List<NewsEntry> buzzfeedEntries = Stream.of(articles_dir.listFiles())
                                                .map(this::read_buzfeed_entry)
                                                .map(BuzzfeedEntry::get_as_news_entry)
                                                .toList();


        return buzzfeedEntries;
//        return Stream.concat(real_news, false_news).toList();
    }
}
