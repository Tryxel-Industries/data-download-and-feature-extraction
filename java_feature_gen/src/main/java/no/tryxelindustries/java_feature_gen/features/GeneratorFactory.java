package no.tryxelindustries.java_feature_gen.features;

import no.tryxelindustries.java_feature_gen.enums.Feature;
import no.tryxelindustries.java_feature_gen.features.FeatureGeneratorBase;
import no.tryxelindustries.java_feature_gen.features.featuregenerators.*;

public class GeneratorFactory {

    public FeatureGeneratorBase getGenerator(Feature feature) {
        return switch (feature) {
            case SWEAR_WORDS -> new SwearWords();
            case FIRST_PERSON_PRONOUNS -> new FirstPersonPronounsTermFrequency();
            case SECOND_PERSON_PRONOUNS -> new SecondPersonPronounsTermFrequency();
            case ACTION_ADVERBS -> new ActionAdverbsTermFrequency();
            case SUPERLATIVE_FORMS -> null;
            case COMPARATIVE_FORMS -> null;
            case STRONGLY_SUBJECTIVE_NEG -> new SubjectivityBase(SubjectivityBase.Runtype.StrongSubNeg);
            case STRONGLY_SUBJECTIVE_POS -> new SubjectivityBase(SubjectivityBase.Runtype.StrongSubPos);
            case STRONGLY_SUBJECTIVE -> new SubjectivityBase(SubjectivityBase.Runtype.StrongSub);
            case NEGATIONS -> null;
            case NEGATIVE_OPINION_WORDS -> null;
            case POSITIVE_OPINION_WORDS -> null;
            case NUMBERS -> new NumberCount();
            case EXCLAMATION_AND_QUESTION_MARKS -> new ExclamationsCount();
            case QUOTATION_MARKS -> new QuotationCount();
            case WORD_COUNT -> new WordCount();
            case DIVISIVE_TOPICS -> null;
            case EFFECT_WORD_SUM -> new EffectWordsSummedValue();
            case CAPITALIZED_WORDS -> new CapitalizedWordCount();
            case INTENSIFIER_ADVERBS -> null;
            case EMPHASIS -> new MPQAEmphasisTermFrequency();
            case RHETORICAL_QUESTIONS -> new MPQARhetoricalQuestionsTermFrequency();
            case GENERALISATION -> new MPQAGeneralizationTermFrequency();
            case INCONSISTENCY -> new MPQAInconsistencyTermFrequency();
            case CONDITIONALS -> new MPQAConditionalsTermFrequency();
            case NECESSITY -> new MPQANecessityTermFrequency();
            case FK_GRADE_LEVEL -> new SyllableBase();

        };
    }
}
