package no.tryxelindustries.java_feature_gen;

import java.util.List;
import java.util.Objects;

public class util {

    public static void showTextWithAnno(List<? extends Object> text, List<? extends Object> annotations) {
        int maxWitdth = 150;

        StringBuilder fullBuilder = new StringBuilder();

        StringBuilder textLineBuilder = new StringBuilder();
        StringBuilder annotationLineBuilder = new StringBuilder();

        int currentLineLength = 0;
        for (int i = 0; i < text.size(); i++) {
            String word = text.get(i).toString();
            Object anno = annotations.get(i);
            String annotation = anno == null ? "null" : anno.toString();
            int usedWidth = Math.max(word.length(), annotation.length());
            String formatS = "%-" + usedWidth + "s ";

            if (usedWidth + 1 + currentLineLength > maxWitdth) {
                fullBuilder.append(textLineBuilder);
                fullBuilder.append("\n");
                fullBuilder.append(annotationLineBuilder);
                fullBuilder.append("\n\n");
                textLineBuilder = new StringBuilder();
                annotationLineBuilder = new StringBuilder();
                currentLineLength = 0;
            }

            textLineBuilder.append(String.format(formatS, word));
            annotationLineBuilder.append(String.format(formatS, annotation));

            currentLineLength += usedWidth + 1;
        }
        fullBuilder.append(textLineBuilder);
        fullBuilder.append("\n");
        fullBuilder.append(annotationLineBuilder);
        fullBuilder.append("\n\n");
        System.out.println(fullBuilder);
    }

}
