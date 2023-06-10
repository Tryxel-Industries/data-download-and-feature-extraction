package no.tryxelindustries.java_feature_gen.features;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.DebugLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public abstract class MPQAArguingGeneratorBase extends FeatureGeneratorBase {


    protected static final String[] wordClassFiles = {
            "lexicons/MPQAA/arg_lex/modals.tff",
            "lexicons/MPQAA/arg_lex/spoken.tff",
            "lexicons/MPQAA/arg_lex/pronoun.tff",
            "lexicons/MPQAA/arg_lex/wordclasses.tff",
            "lexicons/MPQAA/arg_lex/intensifiers.tff"
    };

    protected static final Map<String, String> wordClassMap = getWordClasses();

    protected String expandRegex(String regex) {
        for (String key : wordClassMap.keySet()) {
            if (regex.contains(key)) {
//                dbl.log(regex);
                String expansion = wordClassMap.get(key);
                regex = regex.replace(key, expansion);
//                dbl.log(regex);
            }
        }
        return regex;

    }

    private static Map<String, String> getWordClasses() {
        Map<String, String> wordClassEntries = new HashMap<>();

        for (String fp : wordClassFiles) {
            readWordClassFile(fp, wordClassEntries);
        }
        return wordClassEntries;
    }


    private static void readWordClassFile(String fileName, Map<String, String> wordClassEntries) {
        /*
        the format of the word class files are:
        @<KEY>={<ENTRY>,<ENTRY>...}
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else if (!line.startsWith("#")) {
                    String[] parts = line.split("=\\{");
                    String key = parts[0];
                    String[] vals = parts[1].substring(0, parts[1].length() - 2).split(",");
                    String valuesAsRegex = String.join("|", vals);
                    wordClassEntries.put(key, valuesAsRegex);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<String> readRegexFile(String fileName) {
        /*
        the format of the word class files are:
        @<KEY>={<ENTRY>,<ENTRY>...}
         */
        List<String> regexList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;

                } else if (!line.startsWith("#") && !line.isBlank()) {
                    if (line.contains("@")) {
                        regexList.add(this.expandRegex(line));
                    } else {
                        regexList.add(line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return regexList;
    }


    protected FeatureResult getRegexTermFrequency(CoreDocument document, List<String> regexTerms) {
        int termCount = 0;
        List<String> annotationMap = new ArrayList<>(Collections.nCopies(document.tokens().size(), "Na"));
        for (String term : regexTerms) {
            Pattern pattern = Pattern.compile(term);
            var matcher = pattern.matcher(document.text());
            termCount += (int) matcher.results().count();
        }
        return new FeatureResult(annotationMap, termCount);

    }
}
