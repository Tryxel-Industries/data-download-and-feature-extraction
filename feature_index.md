# Feature index

notes:
Husk named enty recognition for embedding ai's en så "Per liker ikker kari" kan feedes inn som "PERSON liker ikke
PERSON" så sjekker man om enty 1 og 2 matcher etterpå. da ungår vi problemer med å må forholde oss til navn i embeding
spacet

### NEW ADDED NOT IN OVERLEAF

retotical questions
inconsitency
neccesity
conditionals
----- 

## Java features:

---

## Python features:

---

#### Unclassified:

## Swear Words

\label{sec:model_used_features_semantic_f1_swear_words}
The swear word lexicon used in \simensPaper had some significant issues. Some examples of words classified as swear
words in the paper was: \textit{women's, UK, sick, refugee, gun, fire}. The generality of many of the words in this
lexicon may explain why the feature received such a low feature value in \simensPaper and was discarded.
For the proposed algorithm a new and vetted bad word list will be used. Self censored swear word will also be considered
swear words e.g. f**k, s**t.

## First Person Pronouns

\label{sec:model_used_features_semantic_f2_first_person_pronouns}
No modification was made to the lexicon of this feature: \textit{I, me, my, mine, myself}. One thing not controlled for
in \simensPaper is if the pronouns detected are inside a quote. In the proposed implementation only pronouns outside
quoted text will be included.
Not controlling for quoted or not quoted text may explain the low score this feature achieved in \simensPaper. Because
the feature cannot see the difference between a objective 3-person article and a subjective 1-person article
% mabye plural and plural: \textit{we, us, our, ours, ourselves}

## second person pronouns

No modification was made to the lexicon of this feature: \textit{you, your, yours, yourself and yourselves}. The feature
performed OK in \simensPaper. The proposed implementation will control for quoted text.

## modal adverbs

This feature performed poorly in \simensPaper and was not included in the proposed algorithm. There are multiple
under-space separated lexicon entries that weren't correctly split, this invalidates ~15\% of the lexicon used and may
have contributed to the low score.

## Action Adverbs

This feature performed well and was included with the same lexicon as used in \simensPaper

## Manner Adverbs

This feature performed poorly in \simensPaper and was not included

## Superlative Forms

Although the set did not perform well in \simensPaper, the lexicon looks interesting and the feature will be retested
and potentially used.

## Comparative Forms

Although the set did not perform well in \simensPaper, the lexicon looks interesting and the feature will be retested
and potentially used.

## Strongly Subjective Words

While the feature performed well and the lexicon is of high quality, some changes to the implementation was done.
The primary change is to more finely sample the lexicon. in \simensPaper the all strongly subjective entries no matter
if they are positive, negative or neutral. This leads neutral words like \textit{aware, baby, air, fact} to be counted.
To avoid this, this feature will be split into positive and negative strongly subjective words.
Another important consideration is whether or not the lexicon words are stemmed. In \simensPaper this information is
ignored so words like \textit{abuse, disgust, condescend} are not matched to all stemmed variants of the word as the
lexicon describes. This results in words intended to be in the lexicon not being matched like \textit{abusing,
disgusting, condescending}. To fix this the implementation will use the methods described in the lexicon's read-me to
implement this feature.

## Numbers

This feature performed well and will be included. The algorithm will also allow for numbers with commas <,> Thousands
separators and spaced numbers so \textit{the project cost 400,000,000\$}

## Negations

even tho this feature suffer from the short form issues described in section \ref{sec:
model_used_features_asymmetric_prepossessing}. Witch invalidates 46\% of the lexicon, the feature still preformed well.
Some modification to the lexicon will be done to account for the short form words.

## Negative Opinion Words

This feature is not used because it performed poorly and is a less precise version of feature 9.

## Positive Opinion Words

This feature is not used because it performed poorly and is a less precise version of feature 9.

## Exclamation and Question Marks

\simensPaper did not use regex as stated but matched only \textit{!, ?, !!, !?, ?!, ??, !!!, ???}. With the simple
matching used an over excessive use of ether symbol wold not be counted. This means the quote \textit{VACCINES
FAKE!!!!!!!} is counted as having 0 exclamation.
The presented algorithm will instead look at excessive exclamations. Excessive is defined as a set of ? or !, ether with
a length greater than 2, or multiple repeated symbols. Meaning ?!, ?, ?!, ?, and ! is not counted but ??, !!, ??!, ?!?
and similar is. the number of excessive instances are counted.

## Quotation Marks

The quotation mark feature performed well and will be used.

## Divisive Topics

The divisive topic feature works well. The implementation is somewhat crude, with simply checking the hand made lexicon
of divisive word. The proposed algorithm will \todo{we'll probably redo the frequent term findy thingy in some
reproducable way, maybe also use his list idk}

## Word Count

This feature works well and will be used.

## Flesch-Kincaid Grade Level and Reading Ease

\simensPaper uses the Latin letter spelling for finding the syllable count. This is an issue in English where words are
often spelled differently than they are pronounced, which in turn leads to unstable results. even so the feature
preformed well so it will be used in the presented algorithm.
One change the the presented algorithm will have is using phonetic transcriptions to find the number of syllables.

## Sentence Embeddings

Word- and sentence embeddings are powerful tools for NLP tasks. It is therefore a good idea to find ways to use these in
the model. The way it is done in \cite{sverdrup-thygeson_artificial_2021} is to simply append a vector of length 768 (
the length of the BERT-base output vector). This is not a very good approach, as it disproportionately weights the
importance of the sentence embeddings compared to the other features and greatly increases the dimensionality of the
shape-space.

Another change from \simensPaper is that the proposed algorithm uses the embedding from all the sentences of each
article. Better use of caching and a more optimised implementation should to some degree mitigate the performance issues
brought up in \simensPaper.

## Sentiment Analysis

Even though the sentiment analysis features presented in \simensPaper did not preform well, this is a feature that will
be worked on and tested.
Some of the changes are, running the analysis on the entire article not just the head and tail. another is using
multiple different kinds of models like BERT.
The compute cost discussed in \simensPaper is solvable with optimisation and caching.

\subsection{new features}
%se litt på term frequency

## Quoted content exclusion

% test om funke, kansje også på bert modellen
To avoid situations where a cited paragraph may sway real article to be mis-classified as fake, sentences in quotes more
than 5 words long are stripped before semantic analysis. \todo{Test maybe not do, but maybe smart, who knows}

## intensifier adverbs

% http://mpqa.cs.pitt.edu/lexicons/effect_lexicon/
Sums up the positive and negative effect words from the MPQA effect lexicon. This feature may give a crude indication of
sentiment.

## Capitalised words title \& text}

% https://en.wikipedia.org/wiki/Lists_of_acronyms
% https://en.wikipedia.org/wiki/Lists_of_abbreviations
Count the number of capitalised words in the title and text. To avoid flagging acronyms and abbreviations the Wikipedia
list of acronyms and abbreviations are used

## intensifier adverbs

% http://mpqa.cs.pitt.edu/lexicons/arg_lexicon/
Counts the frequency of intensifier adverbs. The lexicon used is the MPQA Arguing Lexicon. some examples are:
\textit{absolutely, absurdly, amazingly, awfully, extremely, completely}

## Emphasis

Counts the frequency of emphasis words/phrases in the text, e.g.: \textit{when you think about it, i bet that, bound to,
no doubt about it}. The data is taken from the MPQA Arguing lexicon. Some modifications will be applied.

## Generalisation

Counts the frequency of generalisation words/phrases in the text. E.g.: \textit{everybody, nothing, everything, of all
times, in the world}. The data is taken from the MPQA Arguing lexicon. Some modifications will be applied 
