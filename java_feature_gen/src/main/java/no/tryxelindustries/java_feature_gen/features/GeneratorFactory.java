package no.tryxelindustries.java_feature_gen.features;

import no.tryxelindustries.java_feature_gen.enums.Feature;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.featuregenerators.*;

public class GeneratorFactory {

    public FeatureGeneratorBase getGenerator(Feature feature) {
        return switch (feature) {
            case SWEAR_WORDS -> null;
            case FIRST_PERSON_PRONOUNS -> new FirstPersonPronounsTermFrequency();
            case SECOND_PERSON_PRONOUNS -> new SecondPersonPronounsTermFrequency();
            case MODAL_ADVERBS -> null;
            case ACTION_ADVERBS -> null;
            case MANNER_ADVERBS -> null;
            case SUPERLATIVE_FORMS -> null;
            case COMPARATIVE_FORMS -> null;
            case STRONGLY_SUBJECTIVE_WORDS -> null;
            case NEGATIONS -> null;
            case NEGATIVE_OPINION_WORDS -> null;
            case POSITIVE_OPINION_WORDS -> null;
            case NUMBERS -> new NumberCount();
            case EXCLAMATION_AND_QUESTION_MARKS -> new ExclamationsCount();
            case QUOTATION_MARKS -> null;
            case WORD_COUNT -> null;
            case DIVISIVE_TOPICS -> null;
            case EFFECT_WORD_SUM -> null;
            case CAPITALIZED_WORDS -> new CapitalizedWordCount();
            case INTENSIFIER_ADVERBS -> null;
            case EMPHASIS -> null;
            case GENERALISATION -> null;
        };
    }
}
