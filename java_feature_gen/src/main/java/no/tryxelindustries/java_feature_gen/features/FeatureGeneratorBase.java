package no.tryxelindustries.java_feature_gen.features;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import no.tryxelindustries.java_feature_gen.DebugLogger;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FeatureGeneratorBase {
    private static final Path lexiconBasePath = Path.of("./lexicons");

    protected static DebugLogger dbl = new DebugLogger(true);

    protected List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    lines.add(line);

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    protected List<LexiconEntry> readLexiconFile(String fileName) {
        var lines = readFile(fileName);
        return lines.stream().map(LexiconEntry::new).collect(Collectors.toList());
    }


    protected FeatureResult getTermCount(CoreDocument document, List<LexiconEntry> terms) {
        // a sexy O(A*B) solution, its not bad if you recognize it
        int termCount = 0;
        List<CoreLabel> tokens = document.tokens();

        List<String> annotationMap = new ArrayList<>(Collections.nCopies(tokens.size(), "-"));

        for (int i = 0; i < terms.size(); i++) {
            LexiconEntry term = terms.get(i);
            if (term.isMultiword) {

                for (int j = 0; j < tokens.size(); j++) {
                    boolean doMatch = true;
                    int skipIndex = 0;
                    for (String termPart : term.splitWord) {
                        if (j < tokens.size()) {
                            String word = tokens.get(j).word();
                            if (!termPart.equals(word)) {
                                doMatch = false;
                                break;
                            } else {
                                j += 1;
                                skipIndex += 1;
                            }
                        } else {
                            doMatch = false;
                            break;
                        }
                    }
                    if (doMatch) {
                        for (int k = skipIndex - 1; k >= 0; k--) {
                            annotationMap.set(j - k, term.label);
                            termCount += 1;
                        }
                    }
                }
            } else {
                for (int j = 0; j < tokens.size(); j++) {
                    String word = tokens.get(j).word();
                    if (word.equals(term.baseWord)) {
                        termCount += 1;
                        annotationMap.set(j, term.label);
                    }
                }
            }


        }
        return new FeatureResult(annotationMap, termCount);

    }


    public abstract FeatureResult getFeatureValue(CoreDocument document);


}
