package no.tryxelindustries.java_feature_gen.features;

import java.util.ArrayList;
import java.util.List;

public class LexiconEntry {
    public final String       baseWord;
    public final List<String> splitWord = new ArrayList<>();
    public final Boolean      isMultiword;


    public LexiconEntry(String baseWord) {
        this.baseWord = baseWord;
        if (baseWord.contains("-")) {
            int splitAt = baseWord.indexOf("-");

            splitWord.add(baseWord.substring(0, splitAt));
            splitWord.add("-");
            splitWord.add(baseWord.substring(splitAt + 1));
            this.isMultiword = true;
        } else if (baseWord.contains(" ")) {
            int splitAt = baseWord.indexOf(" ");
            splitWord.add(baseWord.substring(0, splitAt));
            splitWord.add(baseWord.substring(splitAt + 1));
            this.isMultiword = true;
        } else {
            isMultiword = false;
            splitWord.add(baseWord);
        }
    }

    public List<String> getAsMultiword() {
        return null;
    }
}
