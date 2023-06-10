package no.tryxelindustries.java_feature_gen.features;

import java.util.ArrayList;
import java.util.List;

public class LexiconEntry {

    public final         String       label;
    private static final boolean      includeSeparators = false;
    public final         String       baseWord;
    public final         List<String> splitWord         = new ArrayList<>();
    public final         Boolean      isMultiword;


    private void addMultiword(String base, String sep) {
        String[] words = base.split(sep);

        if (includeSeparators) {
            for (String subWord : words) {
                splitWord.add(subWord);
                splitWord.add(sep);
            }
            if (splitWord.size() > 1 && splitWord.get(splitWord.size() - 1).equals(sep)) {
                splitWord.remove(splitWord.size() - 1);
            }
        } else {
            splitWord.addAll(List.of(words));
        }
    }

    public LexiconEntry(String baseWord) {
        this.label = "True";
        this.baseWord = baseWord;
        if (baseWord.contains("-")) {
            addMultiword(baseWord, "-");
            this.isMultiword = true;
        } else if (baseWord.contains(" ")) {
            addMultiword(baseWord, " ");
            this.isMultiword = true;
        } else if (baseWord.contains("_")) {
            addMultiword(baseWord, "_");
            this.isMultiword = true;
        } else {
            isMultiword = false;
            splitWord.add(baseWord);
        }
    }

    public LexiconEntry(String baseWord, String label) {
        this.label = label;
        this.baseWord = baseWord;
        if (baseWord.contains("-")) {
            addMultiword(baseWord, "-");
            this.isMultiword = true;
        } else if (baseWord.contains(" ")) {
            addMultiword(baseWord, " ");
            this.isMultiword = true;
        } else if (baseWord.contains("_")) {
            addMultiword(baseWord, "_");
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
