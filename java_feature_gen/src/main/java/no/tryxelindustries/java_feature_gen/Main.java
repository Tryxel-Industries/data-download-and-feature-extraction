package no.tryxelindustries.java_feature_gen;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.nlp.ling.CoreLabel;
import no.tryxelindustries.java_feature_gen.datasets.DatasetReader;
import no.tryxelindustries.java_feature_gen.datasets.readers.*;
import no.tryxelindustries.java_feature_gen.entitys.ProtoBuilder;
import no.tryxelindustries.java_feature_gen.enums.Feature;
import no.tryxelindustries.java_feature_gen.features.FeatureResult;
import no.tryxelindustries.java_feature_gen.features.GeneratorFactory;
import no.tryxelindustries.java_feature_gen.entitys.NewsEntry;
import no.tryxelindustries.java_feature_gen.features.featuregenerators.SubjectivityBase;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    private static DebugLogger dbl       = new DebugLogger(true);
    public static  String      withQuote = "Muslim convert and would-be domestic terrorist Everitt Aaron Jameson, who planned to carry out a Christmas Day massacre on Pier 39 in San Francisco, was a supporter of Antifa and counted amongst his favourite news organisations CNN, BuzzFeed and Al-Jazeera.\n\nThe former US Marine was arrested after he told the FBI of his plan to carry out the atrocity, noting that December 25 would be \u201cthe perfect day to commit the attack\u201d because Pier 39 would be crowded with people.\n\nMedia reports confirmed that Jameson \u201chad recently been posting and liking pro-terrorism content on Facebook\u201d and had expressed support for the ISIS-inspired Halloween truck attack in New York. He converted to Islam two years ago.\n\nHowever, what those reports don\u2019t mention is that the would-be terrorist also \u2018liked\u2019 numerous Antifa pages, suggesting he supported the movement.\n\nJameson liked Berkeley Antifa, Antifa California, Antifa Scaramento and White Rose Antifa Portland, an archived version of his Facebook profile confirms.\n\nHe also liked a number of other far-left pages, including \u2018Trump Resistance Movement\u2019, \u2018Things Trump Supporters Say\u2019, \u2018US Democratic Socialists\u2019, \u2018Progressive Politics\u2019, and \u2018Jeremy Corbyn\u2019.\n\nSome of Jameson\u2019s favorite news organisations were The Young Turks, CNN, BuzzFeed and Al Jazeera. He also liked a number of pro-vegan pages.\n\nThe jihadist also sympathised with a number of pro-Muslim pages, including \u2018Documenting Oppression Against Muslims, \u2018Islam \u2013 Religion of Peace\u2019 and \u2018Stunning Hijabs\u2019, as well as numerous anti-Israel activist pages.\n\nJameson\u2019s Facebook likes confirm that his political leanings were a mixture of radical far-left ideology and Islamism.\n\nAs we have documented, ISIS has previously attempted to reach out to those on the far-left as part of an attempt to create militant offshoot cells within the United States and Western Europe.\n\nA passage from the ISIS manifesto Black Flags from Rome entitled \u2018European Muslims allying with Left-Wing activists\u2019 details a plan to recruit those on the far left because they broadly share the same goals as radical Islamists.\n\nDuring the anti-Trump inauguration riots back in January, one Antifa supporter was seen displaying an ISIS flag and beheading videos on his phone in an effort to intimidate Trump supporters in Washington, DC.\n\nAccording to a recently revealed FBI field report, Antifa supporters have stored improvised explosives on college campuses. Members of Antifa have also met with Islamic terrorists to obtain weapons & training.\n\nFBI field report: Antifa has improvised explosives stored on college campuses. Members of Antifa have met with Islamic terrorists to obtain weapons & training. This is why the DHS now lists Antifa as a terror group. pic.twitter.com/TkbL3BRCgu \u2014 Paul Joseph Watson (@PrisonPlanet) November 30, 2017\n\nAntifa radicals are meeting with ISIS. This is directly from an FBI field report. pic.twitter.com/XpW2ngV3Z5 \u2014 Paul Joseph Watson (@PrisonPlanet) December 2, 2017\n\nGiven all this, it\u2019s unsurprising that the Department of Homeland Security has formally classified Antifa\u2019s activities as \u201cdomestic terrorist violence,\u201d with federal authorities warning state and local officials that the group is becoming increasingly dangerous and confrontational.\n\nSUBSCRIBE on YouTube:\n\nFollow on Twitter: Follow @PrisonPlanet\n\nFacebook: https://www.facebook.com/paul.j.watson.71\n\n*********************\n\nPaul Joseph Watson is the editor at large of Infowars.com and Prison Planet.com.";
    public static  String      txt       = "- Advertisement Above - - Advertisement Above -\n\nRepublican attacks on transgendered Americans and the religious fight to keep gender a binary delineation took a turn for the bizarre this week when Virginia Republican Mark Cole filed a bill that would force schools to check the genitals of their students in order to ensure that they are using facilities reserved for their \u201canatomical sex:\u201d\n\nLocal school boards shall develop and implement policies that require every school restroom, locker room, or shower room that is designated for use by a specific gender to solely be used by individuals whose anatomical sex matches such gender designation. Such policies may also provide that a student may, upon request, be granted access, to the extent reasonable, to a single stall restroom or shower, a unisex bathroom, or controlled individual use of a restroom, locker room, or shower. Any student who willfully and knowingly violates this section shall be liable for a civil penalty not to exceed $50. Civil penalties assessed under this section shall be paid into the Literary Fund. Any law-enforcement officer may issue a summons regarding a violation of this section.\n\nHe did not deign to inform us how this would be accomplished, but it\u2019s hard to imagine any scenario that did not involve adults inspecting the genitals of children before using the bathroom. Notably, it also provides for stigmatizing transgendered children by isolating them in a single person bathroom, which the Department of Justice ruled in June was a violation of the student\u2019s rights. It is a disgusting show of transphobia that has no place in our public schools; the GOP must accept that America is a multi-gendered, multi-ethnic nation, and no amount of perverted laws is going to change that.\n\nThe Occupy Democrats Election Fund is a political organization\n\nthat supports ONLY good Democratic candidates Please consider supporting the fund. Thank you! Click here to leave a comment\n\nColin Taylor Opinion columnist and former editor-in-chief of Occupy Democrats. He graduated from Bennington College with a Bachelor's degree in history and political science. He now focuses on advancing the cause of social justice and equality in America. Latest Posts";
    public static  String      txt2      = "U.S.A yeaahhh!!!!. i am confident that Bob rigged the ugandan election last tuesday. is this — real??????. really 100 000 dollas tells me no way any1 cold do that 360 kick-flip?. thight-lipped! .idk means I dont know - mine my opinion you yours opinion. if this ain't “posible” \"to\" 'tokenize' (good) for organizations e.g. c.i.a. nsa, federal bureau of investigation and other. Earlier today Josh Caplan at The Gateway Pundit posted on Gloria Allred\u2019s last ditch effort to swing the Alabama senate race to Democrat Doug Moore.\n\nWE CALLED IT! Gloria Allred Accuser **ADMITS** She Tampered With Roy Moore\u2019s Yearbook \u2018Signature\u2019 ";//(VIDEO)\n\nAllred dragged out discredited Moore accuser Beverly Nelson to Good Morning America to hit Judge Roy Moore one last time before Tuesday\u2019s vote.\n\nNelson admitted on ABC\u2019s \u201cGood Morning America\u201d on Friday that she tampered with and added \u201cnotes\u201d to what she claims is Moore\u2019s signature inside her yearbook.\n\nTRENDING: In Ukraine, \u201cThere\u2019s Something Happening There\u201d\n\nThe story is solid. The statements were made by Beverly Nelson this morning. The yearbook signature has been discredited as reported by ABC\u2019s GMA this morning.\n\nBut after we posted the story this morning Facebook shut down our story.\n\nThe far left website Politifact said our story was not accurate and Facebook the shut it down. No one will be able to see our story on Facebook.\n\nBreitbart wrote a similar post and it was also blocked by Facebook.\n\nFacebook is TRASH. pic.twitter.com/KHy5Qfykg6 \u2014 Gab: Free Speech Social Network (@getongab) December 8, 2017\n\nSo Facebook shut down the story on Judge Roy Moore\u2019s accuser.\n\nFacebook is picking sides.";

    public static void main(String[] args) {
//        Main.testSimpleFeatureGen();

//        {
//            var dataset = new Buzzfeed();
//            gen_dataset(dataset);
//        }
//
//        {
//            var dataset = new Kaggle();
//            gen_dataset(dataset);
//        }

        {
            var dataset = new Gosipcop();
            gen_dataset(dataset);
        }

        {
            var dataset = new Politifact();
            gen_dataset(dataset);
        }


//        List<NewsEntry> datasetEntries = dataset.readDataset();
//        DataProcessing processing = new DataProcessing(false);
//
//        var testEntry = datasetEntries.get(0);
//        processing.processNewsEntry(testEntry);
//
//        var test_gen = new StrongSubNegative();
//        var result = test_gen.getFeatureValue(testEntry.document);
////
//        util.showTextWithAnno(testEntry.document.tokens().stream().map(CoreLabel::word).toList(),
//                              result.annotation);
//        System.out.printf("the feature count is %s\n", result.featureValue);
//

//        dataset.readDataset();


//        gen_dataset(dataset);
//        testProtoB();
//        inspect_dataset_id();
//        dupe_test(fnn);


//        var t0 = System.nanoTime();
//        testKaggleGen();
//        var t1 = System.nanoTime();
//
//        Duration runtime = Duration.ofNanos(t1 - t0);
//        dbl.log("runtime: ",
//                runtime.toSecondsPart(),
//                " seconds ",
//                runtime.toMinutesPart(),
//                " minutes ",
//                runtime.toHoursPart(),
//                " hours");
    }

    public static void testProtoB() {
        DataProcessing processing = new DataProcessing(false);
        Kaggle kg = new Kaggle();
        List<NewsEntry> kaggleEntries = kg.readDataset();
//        var test_l = kaggleEntries.subList(0, 1);
        var test_l = kaggleEntries;


        dbl.log("Processing news entries");
        test_l.parallelStream().forEach(processing::processNewsEntry);

        ProtoBuilder.writeSentencesToDisk("kaggle", test_l);
    }

    public static void dupe_test(DatasetReader datasetReader) {
        DataProcessing processing = new DataProcessing(false);
        List<NewsEntry> entries = datasetReader.readDataset();
        HashSet<String> hashSet = new HashSet<>();

        entries.parallelStream().forEach(processing::processNewsEntry);

        int collision_counter = 0;
        int non_collision_counter = 0;
        for (NewsEntry entry : entries) {
            for (String sentence : entry.getSentences()) {
                if (hashSet.contains(sentence)) {
                    collision_counter += 1;
                    System.out.printf("colission number: %s\n", collision_counter);
                } else {
                    non_collision_counter += 1;
                    hashSet.add(sentence);
                }
            }
        }

        System.out.printf("num not colision: %s  num collisions: %s, fraction: %s\n",
                          non_collision_counter,
                          collision_counter,
                          collision_counter / non_collision_counter);


    }

    public static void inspect_dataset_id() {
        DataProcessing processing = new DataProcessing(false);
        Kaggle kg = new Kaggle();
        List<NewsEntry> kaggleEntries = kg.readDataset();
        int targetId = 120;
        var test_l = kaggleEntries.stream().filter(newsEntry -> newsEntry.id == targetId).toList();

        if (test_l.size() > 0) {
            NewsEntry article = test_l.get(0);
            System.out.printf("article id: %s\n", article.id);
            System.out.printf("article title: %s\n", article.title);
            System.out.printf("article text: \n%s\n", article.rawText);
        }

    }

    private static Pipeline getFeaturePipeline() {
        List<Feature> featuresUsed = new ArrayList<>(List.of(
                Feature.SWEAR_WORDS,
                Feature.FIRST_PERSON_PRONOUNS,
                Feature.SECOND_PERSON_PRONOUNS,
                Feature.ACTION_ADVERBS,
                Feature.STRONGLY_SUBJECTIVE_NEG,
                Feature.STRONGLY_SUBJECTIVE_POS,
                Feature.STRONGLY_SUBJECTIVE,
                Feature.NUMBERS,
                Feature.EXCLAMATION_AND_QUESTION_MARKS,
                Feature.QUOTATION_MARKS,
                Feature.WORD_COUNT,
                Feature.EFFECT_WORD_SUM,
                Feature.CAPITALIZED_WORDS,
                Feature.EMPHASIS,
                Feature.RHETORICAL_QUESTIONS,
                Feature.GENERALISATION,
                Feature.INCONSISTENCY,
                Feature.CONDITIONALS,
                Feature.NECESSITY,
                Feature.FK_GRADE_LEVEL));
        Pipeline pipe = new Pipeline(featuresUsed);
        return pipe;
    }

    public static void gen_dataset(DatasetReader datasetReader) {
        DataProcessing processing = new DataProcessing(false);

        List<NewsEntry> datasetEntries = datasetReader.readDataset();
        dbl.log("Processing news entries");
        datasetEntries.parallelStream().forEach(processing::processNewsEntry);


        dbl.log("Processing news features");
        var pipe = getFeaturePipeline();
        var res = datasetEntries.parallelStream().map(pipe::runAll).toList();

        datasetReader.writeDatasetEntries(res);

        ProtoBuilder.writeSentencesToDisk(datasetReader.getDatasetName(), res);
        System.out.printf("num res is %s\n", res.size());
        var resEntry = res.get(0);
        dbl.log(resEntry);
        dbl.log(resEntry.getResultMap());


//        util.showTextWithAnno(entry.document.tokens().stream().map(CoreLabel::word).toList(),
//                              result.annotation);
//        System.out.printf("the feature count is %s\n", result.featureValue);
    }

    public static void testSimpleFeatureGen() {
        DataProcessing processing = new DataProcessing(false);

        NewsEntry entry = processing.processNewsData(txt2);

        GeneratorFactory factory = new GeneratorFactory();

        var generator = factory.getGenerator(Feature.EMPHASIS);
        FeatureResult result = generator.getFeatureValue(entry.document);

        util.showTextWithAnno(entry.document.tokens().stream().map(CoreLabel::word).toList(),
                              result.annotation);
        System.out.printf("the feature count is %s\n", result.featureValue);

    }

    public static void genJavaFeatures() {

        DataProcessing processing = new DataProcessing(false);
        NewsEntry entry = processing.processNewsData(txt2);

        List<Feature> featuresUsed = new ArrayList<>(List.of(Feature.FIRST_PERSON_PRONOUNS,
                                                             Feature.SECOND_PERSON_PRONOUNS,
                                                             Feature.ACTION_ADVERBS,
                                                             Feature.STRONGLY_SUBJECTIVE_NEG,
                                                             Feature.STRONGLY_SUBJECTIVE_POS,
                                                             Feature.STRONGLY_SUBJECTIVE,
                                                             Feature.NUMBERS,
                                                             Feature.EXCLAMATION_AND_QUESTION_MARKS,
                                                             Feature.QUOTATION_MARKS,
                                                             Feature.WORD_COUNT,
                                                             Feature.EFFECT_WORD_SUM,
                                                             Feature.CAPITALIZED_WORDS,
                                                             Feature.EMPHASIS,
                                                             Feature.RHETORICAL_QUESTIONS,
                                                             Feature.GENERALISATION,
                                                             Feature.INCONSISTENCY,
                                                             Feature.CONDITIONALS,
                                                             Feature.NECESSITY));


        Pipeline pipe = new Pipeline(featuresUsed);

        NewsEntry res = pipe.runAll(entry);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("test.json"), res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
