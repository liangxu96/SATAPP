package com.example.sat_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.sat_app.readingQuestionContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class readingQuestionDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "englishQuestions.db";
    private static final int DATABASE_VERSION = 9;

    private SQLiteDatabase db;

    public readingQuestionDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " (" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_EXPLANATION + " TEXT, " +
                QuestionsTable.COLUMN_CORRECTANSWER + " INTEGER, " +
                QuestionsTable.COLUMN_ID + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {

        /*

        readingQuestion example = new readingQuestion( //change tag
                "", //paste question here
                "", //Option A
                "", //Option B
                "", //Option C
                "", //Option D
                "", //Explanation
                0, //Correct Answer [1 = A] [2 = B] [3 = C] [4 = D]
                "P1RP3"); //practice 1 reading passage 3
        addQuestion(example); //use the same tag

        */

        readingQuestion q0 = new readingQuestion(
                "Which choice best describes what happens in the\n" +
                "passage?",
                "One character argues with another character\n" +
                "who intrudes on her home.",
                "One character receives a surprising request from\n" +
                "another character.",
                "One character reminisces about choices she has\n" +
                "made over the years.",
                "One character criticizes another character for\n" +
                "pursuing an unexpected course of action.",
                "In the passage, a young man (Akira) asks\n" +
                        "a mother (Chie) for permission to marry her daughter (Naomi). The\n" +
                        "request was certainly surprising to the mother, as can be seen from\n" +
                        "line 47, which states that prior to Akira’s question Chie “had no idea”\n" +
                        "the request was coming.\n" +
                        "\n" +
                        "Choice A is incorrect because the passage depicts two characters\n" +
                        "engaged in a civil conversation, with Chie being impressed with\n" +
                        "Ankira's \"sincerity\" and finding herself \"starting to like him.\" Choice C\n" +
                        "is incorrect because the passage is focused on the idea of Akira’s\n" +
                        "and Naomi’s present lives and possible futures. Choice D is incorrect\n" +
                        "because the interactions between Chie and Akira are polite, not critical;\n" +
                        "for example, Chie views Akira with “amusement,” not animosity.",
                2,
                "P1RP1");
        addQuestion(q0);
        readingQuestion q1 = new readingQuestion(
                "Which choice best describes the developmental\n" +
                        "pattern of the passage?",
                "A careful analysis of a traditional practice",
                "A detailed depiction of a meaningful encounter",
                "A definitive response to a series of questions",
                "A cheerful recounting of an amusing anecdote",
                "Choice B is the best answer. The passage centers on a night when\n" +
                        "a young man tries to get approval to marry a woman’s daughter. The\n" +
                        "passage includes detailed descriptions of setting (a “winter’s eve” and\n" +
                        "a \"cold rain,\" lines 5-6); character (Akira's \"soft, refined\" voice, line 33;\n" +
                        "Akira's eye \"sh[ining] with sincerity,\" liune 35); and plot (\"Namomi was\n" +
                        "silent. She stood a full half minute looking straight into Chie’s eyes.\n" +
                        "Finally, she spoke,” lines 88-89).\n" +
                        "\n" +
                        "Choice A is incorrect because the passage focuses on a nontraditional\n" +
                        "marriage proposal. Choice C is incorrect because the passage\n" +
                        "concludes without resolution to the question of whether Akira and\n" +
                        "Naomi will receive permission to marry. Choice D is incorrect because\n" +
                        "the passage repeatedly makes clear that for Chie, her encounter with\n" +
                        "Akira is momentous and unsettling, as when Akira acknowledges in\n" +
                        "line 73 that he has \"startled\" her.",
                1,
                "P1RP1");
        addQuestion(q1);
        readingQuestion q2 = new readingQuestion(
                "As used in line 1 and line 65, “directly” most\n" +
                        "nearly means",
                "frankly.",
                "confidently",
                "without mediation",
                "with precision",
                "Choice C is the best answer. Akira “came directly, breaking all\n" +
                        "tradition,” (line 1) when he approached Chie and asked to marry her\n" +
                        "daughter, and he “ask[ed] directly,” without “a go-between” (line 65) or\n" +
                        "“mediation,” because doing otherwise would have taken too much time.\n" +
                        "\n" +
                        "Choices A, B, and D are incorrect because in these contexts, “directly”\n" +
                        "does not mean in a frank, confident, or precise manner. ",
                1,
                "P1RP1");
        addQuestion(q2);
        readingQuestion q3 = new readingQuestion(
                "Which reaction does Akira most fear from Chie?",
                "She will consider his proposal inappropriate.",
                "She will mistake his earnestness for immaturity.",
                "She will consider his unscheduled visit an\n" +
                        "imposition.",
                "She will underestimate the sincerity of his\n" +
                        "emotions.",
                "Choice A is the best answer.Akira is very concerned Chie will find his\n" +
                        "marriage proposal inappropriate because he did not follow traditional\n" +
                        "protocol and use a \"go-between\" (line 65). This is clear in lines 63-64,\n" +
                        "when Akira says to Chie “Please don’t judge my candidacy by the\n" +
                        "unseemliness of this proposal.”\n" +
                        "\n" +
                        "Choice B is incorrect because there is no evidence in the passage that\n" +
                        "Akira worries that Chie will mistake his earnestness for immaturity.\n" +
                        "Choice C is incorrect because while Akira recognizes that his\n" +
                        "unscheduled visit is a nuisance, his larger concern is that Chie will\n" +
                        "reject him due to the inappropriateness of his proposal. Choice D\n" +
                        "is incorrect because there is no evidence in the passage that Akira\n" +
                        "worries Chie will underestimate the sincerity of his emotions. ",
                1,
                "P1RP1");
        addQuestion(q3);
        readingQuestion q4 = new readingQuestion(
                "Which choice provides the best evidence for the\n" +
                        "answer to the previous question?",
                "Line 33 (“His voice... refined”)",
                "Lines 49-51 (“You... mind”)",
                "Lines 63-64 (“Please... proposal”)",
                "Lines 71-72 (“Eager... face”)",
                "Choice C is the best answer. In lines 63-64, Akira says to Chie,\n" +
                        "“Please don’t judge my candidacy by the unseemliness of this\n" +
                        "proposal.” This reveals Akira’s concern that Chie may say no to the\n" +
                        "proposal simply because Akira did not follow traditional practices.\n" +
                        "\n" +
                        "Choices A, B, and D do not provide the best evidence for the answer\n" +
                        "to the previous question. Choice A is incorrect because line 33 merely\n" +
                        "describes Akira's voice as \"soft, refined.\" Choice B is incorrect because\n" +
                        "lines 49-51 reflect Choie's persepective, not Akira's. Choice D is incorrect\n" +
                        "because lines 71-72 indicate only that Akira was speaking in an eager\n" +
                        "and forthright matter. ",
                3,
                "P1RP1");
        addQuestion(q4);
        readingQuestion q5 = new readingQuestion(
                "In the passage, Akira addresses Chie with",
                "affection but not genuine love.",
                "objectivity but not complete impartiality.",
                "amusement but not mocking disparagement.",
                "respect but not utter deference.",
                "Choice D is the best answer because Akira clearly treats Chie with\n" +
                        "respect, including “bow[ing]” (line 26) to her, calling her “Madame”\n" +
                        "(line 31), and looking at her with \"a deferential peek\" (line 34). Akira\n" +
                        "does not offer Chie utter deference, though, as he asks to marry Naomi\n" +
                        "after he concedes that he is not following protocol and admits to being\n" +
                        "a \"disruption\" (line 31)\n" +
                        "\n" +
                        "Choice A is incorrect because while Akira conveys respect to Chie, there\n" +
                        "is no evidence in the passage that he feels affection for her. Choice B is\n" +
                        "incorrect because neither objectivity nor impartiality accurately describes\n" +
                        "how Akira addresses Chie. Choice C is incorrect because Akira conveys\n" +
                        "respect to Chie and takes the conversation seriously. ",
                4,
                "P1RP1");
        addQuestion(q5);
        readingQuestion q6 = new readingQuestion(
                "The main purpose of the first paragraph is to",
                "describe a culture.",
                "criticize a tradition.",
                "question a suggestion.",
                "analyze a reaction.",
                "Choice D is the best answer.The first paragraph (lines 1-4) reflect on\n" +
                        "how Akira approached Chie to ask for her daughter’s hand in marriage.\n" +
                        "In these lines, the narrator is wondering whether Chie would have\n" +
                        "been more likely to say yes to Akira’s proposal if Akira had followed\n" +
                        "tradition: “Akira came directly, breaking all tradition. Was that it? Had\n" +
                        "he followed form — had he asked his mother to speak to his father\n" +
                        "to approach a go-between — would Chie have been more receptive?”\n" +
                        "Thus, the main purpose of the first paragraph is to examine why Chie\n" +
                        "reacted a certain way to Akira’s proposal.\n" +
                        "\n" +
                        "Choice A is incorrect because the first paragraph describes only one\n" +
                        "aspect of Japanese culture (marriage proposals) but not the culture\n" +
                        "as a whole. Choice B is incorrect because the first paragraph implies\n" +
                        "a criticism of Akira’s individual marriage proposal but not the entire\n" +
                        "tradition of Japanese marriage proposals. Choice C is incorrect\n" +
                        "because the narrator does not question a suggestion. ",
                4,
                "P1RP1");
        addQuestion(q6);
        readingQuestion q7 = new readingQuestion(
                "As used in line 2, “form” most nearly means",
                "appearance.",
                "custom.",
                "structure.",
                "nature.",
                "Choice D is the best answer. The first paragraph (lines 1-4) reflects on\n" +
                        "how Akira approached Chie to ask for her daughter’s hand in marriage.\n" +
                        "In these lines, the narrator is wondering whether Chie would have\n" +
                        "been more likely to say yes to Akira’s proposal if Akira had followed\n" +
                        "tradition: “Akira came directly, breaking all tradition. Was that it? Had\n" +
                        "he followed form — had he asked his mother to speak to his father\n" +
                        "to approach a go-between — would Chie have been more receptive?”\n" +
                        "Thus, the main purpose of the first paragraph is to examine why Chie\n" +
                        "reacted a certain way to Akira’s proposal.\n" +
                        "\n" +
                        "Choice A is incorrect because the first paragraph describes only one\n" +
                        "aspect of Japanese culture (marriage proposals) but not the culture\n" +
                        "as a whole. Choice B is incorrect because the first paragraph implies\n" +
                        "a criticism of Akira’s individual marriage proposal but not the entire\n" +
                        "tradition of Japanese marriage proposals. Choice C is incorrect\n" +
                        "because the narrator does not question a suggestion. ",
                2, "P1RP1");
        addQuestion(q7);
        readingQuestion q8 = new readingQuestion(
                "Why does Akira say his meeting with Chie is\n" +
                        "“a matter of urgency” (line 32)?",
                "He fears that his own parents will disapprove of\n" +
                        "Naomi.",
                "He worries that Naomi will reject him and marry\n" +
                        "someone else.",
                "He has been offered an attractive job in another\n" +
                        "country.",
                "He knows that Chie is unaware of his feelings for\n" +
                        "Naomi.",
                "Choice C is the best answer. Akira states that his unexpected meeting\n" +
                        "with Chie occurred only because of a “matter of urgency,” which he\n" +
                        "explains as “an opportunity to go to America, as dentist for Seattle’s\n" +
                        "Japanese community” (lines 41-42). Akira decides to directly speak to\n" +
                        "\n" +
                        "Choice A is incorrect because there is no evidence in the passage that\n" +
                        "Akira is worried his parents will not approve of Naomi. Choice B is\n" +
                        "Choice D is incorrect; while Akira may know that Chie is unaware\n" +
                        "of his feelings for Naomi, this is not what he is referring to when he\n" +
                        "mentions “a matter of urgency.” ",
                3,
                "P1RP1");
        addQuestion(q8);
        readingQuestion q9 = new readingQuestion(
                "Which choice provides the best evidence for the\n" +
                        "answer to the previous question?",
                "Line 39 (“I don’t... you”).",
                "Lines 39-42 (“Normally... community”)",
                "Lines 58-59 (“Depending... Japan”)",
                "Lines 72-73 (“I see... you”)",
                "Choice B is the best answer. In lines 39-42, Akira clarifies that the \"matter\n" +
                        "of urgency” is that he has “an opportunity to go to America, as dentist for\n" +
                        "Seattle’s Japanese community.” Akira needs Chie’s answer to his marriage\n" +
                        "proposal so he can decide whether to accept the job in Seattle. \n" +
                        "\n" +
                        "Choices A, C, and D do not provide the best evidence for the answer to\n" +
                        "the previous question. Choice A is incorrect because in line 39 Akira\n" +
                        "apologizes for interrupting Chie’s quiet evening. Choice C is incorrect\n" +
                        "because lines 58-59 address the seriousness of Akira’s request, not its\n" +
                        "urgency. Choice D is incorrect because line 73 shows only that Akira's\n" +
                        "proposal has “startled” Chie and does not explain why his request is\n" +
                        "time-sensitive. ",
                2,
                "P1RP1");
        addQuestion(q9);
        readingQuestion q10 = new readingQuestion(
                "The authors most likely use the examples in lines 1-9\n" +
                        "of the passage (“Every... showers”) to highlight the",
                "regularity with which people shop for gifts.",
                "recent increase in the amount of money spent on\n" +
                        "gifts.",
                "anxiety gift shopping causes for consumers.",
                "number of special occasions involving\n" +
                        "gift-giving.",
                "Choice A is the best answer. Lines 1-9 include examples of how many\n" +
                        "people shop (“millions of shoppers”), how much money they spend\n" +
                        "(\"over $30 billion at retail stores in the month of December alone\"),\n" +
                        "and the many occasions that lead to shopping for gifts (“including\n" +
                        "weddings, birthdays, anniversaries, graduations, and baby showers.”).\n" +
                        "Combined, these examples show how frequently people in the US shop\n" +
                        "for gifts.\n" +
                        "Choice B is incorrect because even though the authors mention that\n" +
                        "\"$30 billion\" had been spent in retail stores in one month, that figure\n" +
                        "is never discussed as an increase (or a decrease). Choice C is incorrect\n" +
                        "because lines 1-9 provide a context for the amount of shopping that\n" +
                        "occurs in the US, but the anxiety (or “dread”) it might cause is not\n" +
                        "introduced until later in the passage. Choice D is incorrect because\n" +
                        "lines 1-9 do more than highlight the number of different occasions that lead to \n" +
                        "lead to gift-giving.",
                1,
                "P1RP2");
        addQuestion(q10);
        readingQuestion q11 = new readingQuestion(
                "In line 10, the word “ambivalent” most nearly means",
                "unrealistic.",
                "conflicted.",
                "apprehensive.",
                "supportive.",
                "Choice B is the best answer.Lines 9-10 state \"This frequent experience\n" +
                        "of gift-giving can engender ambivalent feelings in gift-givers.” In\n" +
                        "the subsequent sentences, those “ambivalent” feelings are further\n" +
                        "exemplified as conflicted feelings, as shopping is said to be seomthing\n" +
                        "that \"[m]any relish\" (lines 10-11) and \"many dread\" (line 14).\n" +
                        "Choices A, C, and D are incorrect because in this context, “ambivalent”\n" +
                        "does not mean feelings that are unrealistic, apprehensive, or supportive. ",
                2,
                "P1RP2");
        addQuestion(q11);
        readingQuestion q12 = new readingQuestion(
                "The authors indicate that people value gift-giving\n" +
                        "because they feel it",
                "functions as a form of self-expression.",
                "is an inexpensive way to show appreciation.",
                "requires the gift-recipient to reciprocate.",
                "can serve to strengthen a relationship.",
                "Choice D is the best answer. In lines 10-13, the authors clearly state that\n" +
                        "some people believe gift-giving can help a relationship because it \"offers\n" +
                        "a powerful means to build stronger bonds with one’s closest peers.”\n" +
                        "Choice A is incorrect because even though the authors state that some\n" +
                        "shoppers make their choices based on \"egocentrism,\" (line 33) there\n" +
                        "is no evidence in the passage that people view shopping as a form of\n" +
                        "self-expression. Choice B is incorrect because the passage implies\n" +
                        "that shopping is an expensive habit. Choice C is incorrect because the\n" +
                        "passage states that most people have purchased and received gifts,\n" +
                        "but it never implies that people are required(<- ITALICS) to reciprocate the\n" +
                        "gift-giving process.",
                4,
                "P1RP2");
        addQuestion(q12);
        readingQuestion q13 = new readingQuestion(
                "Which choice provides the best evidence for the\n" +
                        "answer to the previous question?",
                "Lines 10-13 (“Many... peers”)",
                "Lines 22-23 (“People... own”)",
                "Lines 31-32 (“Research... perspectives”)",
                "Lines 44-47 (“Although... unfounded”)",
                "Choice A is the best answer. In lines 10-13, the authors suggest that\n" +
                        "people value gift-giving because it may strengthen their relationships\n" +
                        "with others: “Many relish the opportunity to buy presents because\n" +
                        "gift-giving offers a powerful means to build stronger bonds with one's \n" +
                        "closest peers.”\n" +
                        "Choices B, C, and D do not provide the best evidence for the answer\n" +
                        "to the previous question. Choice B is incorrect because lines 22-23 \n" +
                        "discuss how people often buy gifts that the recipients would not\n" +
                        "purchase. Choice C is incorrect because lines 31-32 explain how gift-\n" +
                        "givers often fail to consider the recipients’ preferences. Choice D is\n" +
                        "incorrect because lines 44-47 suggest that the cost of a gift may not\n" +
                        "correlate to a recipient’s appreciation of it.",
                1,
                "P1RP2");
        addQuestion(q13);
        readingQuestion q14 = new readingQuestion(
                "The “social psychologists” mentioned in paragraph 2\n" +
                        "(lines 17-34) would likely describe the “deadweight\n" +
                        "loss” phenomenon as",
                "predictable.",
                "questionable.",
                "disturbing.",
                "unprecedented.",
                "Choice A is the best answer. The “deadweight loss” mentioned in the\n" +
                        "second paragraph is the significant monetary difference between what \n" +
                        "a gift-giver would pay for something and what a gift-recipient would\n" +
                        "pay for the same item. The difference would be predictable to social\n" +
                        "psychologists, whose research “has found that people often struggle\n" +
                        "to take account of others’ perspectives — their insights are subject\n" +
                        "to egocentrism, social projection, and multiple attribution errors”\n" +
                        "(lines 31-34).\n" +
                        "Choices B, C, and D are all incorrect because lines 31-34 make clear\n" +
                        "that social psychologists would expect a disconnect between giftgivers and gift-\n" +
                        "recipients, not that they would question it, be disturbed\n" +
                        "by it, or find it surprising or unprecedented.",
                1,
                "P1RP2");
        addQuestion(q14);
        readingQuestion q15 = new readingQuestion(
                "The passage indicates that the assumption made by\n" +
                        "gift-givers in lines 41-44 may be",
                "insincere.",
                "unreasonable.",
                "incorrect",
                "substantiated.",
                "Choice C is the best answer. Lines 41-44 suggest that gift-givers\n" +
                        "assume a correlation between the cost of a gift and how well-received\n" +
                        "it will be: “. . . gift-givers equate how much they spend with how\n" +
                        "much recipients will appreciate the gift (the more expensive the gift,\n" +
                        "the stronger a gift-recipient’s feelings of appreciation).” However, the\n" +
                        "authors suggest this assumption may be incorrect or “unfounded”\n" +
                        "(line 47), as gift-recipients “may not construe smaller and larger gifts\n" +
                        "as representing smaller and larger signals of thoughtfulness and\n" +
                        "consideration\" (lines 63-65).\n" +
                        "Choices A, B, and D are all incorrect because the passage neither\n" +
                        "states nor implies that the gift-givers’ assumption is insincere,\n" +
                        "unreasonable, or substantiated.",
                3,
                "P1RP2");
        addQuestion(q15);
        readingQuestion q16 = new readingQuestion(
                "Which choice provides the best evidence for the\n" +
                        "answer to the previous question?",
                "Lines 53-55 (“Perhaps... consideration”)",
                "Lines 55-60 (“According... relationship”)",
                "Lines 63-65 (“As... consideration”)",
                "Lines 75-78 (“In... relations”)",
                "Choice C is the best answer.Lines 63-65 suggest that the assumption\n" +
                        "made by gift-givers in lines 41-44 may be incorrect. The gift-givers\n" +
                        "assume that recipients will have a greater appreciation for costly gifts \n" +
                        "than for less costly gifts, but the authors suggest this relationship may\n" +
                        "be incorrect, as gift-recipients “may not construe smaller and larger\n" +
                        "gifts as representing smaller and larger signals of thoughtfulness and\n" +
                        "consideration\" (lines 63-65)\n" +
                        "Choices A and D are incorrect because line 53-55 and 75-78 address\n" +
                        "the question of \"why\" gift-givers make specific assumptions rather\n" +
                        "than addressing the validity of these assumptions. Choice B is\n" +
                        "incorrect because lines 55-60 focus on the reasons people give gifts to\n" +
                        "others.",
                3,
                "P1RP2");
        addQuestion(q16);
        readingQuestion q17 = new readingQuestion(
                "As it is used in line 54, “convey” most nearly means",
                "transport.",
                "counteract.",
                "exchange.",
                "communicate.",
                "Choice D is the best answer.Lines 53-55 state that \"Perhaps givers\n" +
                        "believe that bigger (i.e., more expensive) gifts convey stronger signals\n" +
                        "of thoughtfulness and consideration.” In this context, saying that more\n" +
                        "expensive gifts “convey” stronger signals means the gifts send, or\n" +
                        "communicate, stronger signals to the recipients.\n" +
                        "Choices A, B, and C are incorrect because in this context, to “convey”\n" +
                        "something does not mean to transport it (physically move something),\n" +
                        "counteract it (act in opposition to something), or exchange it (trade one\n" +
                        "thing for another).",
                4,
                "P1RP2");
        addQuestion(q17);
        readingQuestion q18 = new readingQuestion(
                "The authors refer to work by Camerer and others\n" +
                        "(line 56) in order to",
                " offer an explanation.",
                "introduce an argument.",
                "question a motive.\n",
                "support a conclusion.",
                "Choice A is the best answer. The paragraph examines how gift-givers\n" +
                        "believe expensive gifts are more thoughtful than less expensive gifts\n" +
                        "and will be more valued by recipients. The work of Camerer and\n" +
                        "others offers an explanation for the gift-givers' reasoning:\"gift-givers\n" +
                        "attempt to signal their positive attitudes toward the intended recipient\n" +
                        "and their willingness to invest resources in a future relationship”\n" +
                        "(lines 57-60).\n" +
                        "Choices B, C, and D are incorrect because the theory articulated\n" +
                        "by Camerer and others is used to explain an idea put forward by\n" +
                        "the authors (“givers believe that bigger . . . gifts convey stronger\n" +
                        "signals”), not to introduce an argument, question a motive, or support\n" +
                        "a conclusion.",
                1,
                "P1RP2");
        addQuestion(q18);
        readingQuestion q19 = new readingQuestion(
                "The graph following the passage offers evidence that\n" +
                        "gift-givers base their predictions of how much a gift\n" +
                        "will be appreciated on",
                "the appreciation level of the gift-recipients.",
                "the monetary value of the gift.",
                "their own desires for the gifts they purchase.",
                "their relationship with the gift-recipients.",
                "Choice B is the best answer. The graph clearly shows that gift-givers\n" +
                        "believe that a “more valuable” gift will be more appreciated than\n" +
                        "a “less valuable gift.” According to the graph, gift-givers believe\n" +
                        "the monetary value of a gift will determine whether that gift is well\n" +
                        "received or not.\n" +
                        "Choice A is incorrect because the graph does not suggest that giftgivers are\n" +
                        "aware of gift-recipients’ appreciation levels. Choices C and\n" +
                        "D are incorrect because neither the gift-givers’ desire for the gifts they\n" +
                        "purchase nor the gift-givers’ relationship with the gift-recipients is\n" +
                        "addressed in the graph.",
                2,
                "P1RP2");
        addQuestion(q19);
        readingQuestion q20 = new readingQuestion(
                "The authors would likely attribute the differences in\n" +
                        "gift-giver and recipient mean appreciation as\n" +
                        "represented in the graph to",
                " an inability to shift perspective.",
                "an increasingly materialistic culture.",
                "a growing opposition to gift-giving.",
                "a misunderstanding of intentions.",
                "Choice A is the best answer. Lines 69-75 explain that while people\n" +
                        "are often both gift-givers and gift-receivers, they struggle to apply\n" +
                        "information they learned as a gift-giver to a time when they were a giftreceiver: \n" +
                        "“Yet, despite the extensive experience that people have as both\n" +
                        "givers and receivers, they often struggle to transfer information gained\n" +
                        "from one role (e.g., as a giver) and apply it in another, complementary\n" +
                        "role (e.g., as a receiver).” The authors suggest that the disconnect\n" +
                        "between how much appreciation a gift-giver thinks a gift merits and how\n" +
                        "much appreciation a gift-recipient displays for the gift may be caused by\n" +
                        "both individuals’ inability to comprehend the other’s perspective.\n" +
                        "Choices B and C are incorrect because neither the passage nor the\n" +
                        "graph addresses the idea that society has become more materialistic or\n" +
                        "that there is a growing opposition to gift-giving. Choice D is incorrect\n" +
                        "because the passage emphasizes that gift-givers and gift-recipients\n" +
                        "fail to understand each other's perspective, but it offers no evidence\n" +
                        "that the disconnect results only from a failure to understand the\n" +
                        "other’s intentions.",
                1,
                "P1RP2");
        addQuestion(q20);
        readingQuestion q21 = new readingQuestion(
                "FILLER QUESTION",
                "A",
                "B",
                "C",
                "D.",
                "Explain",
                1,
                "P1RP3");
        addQuestion(q21);








        readingQuestion P1GP1Q1 = new readingQuestion(
                null,
                "NO CHANGE",
                "defeat",
                "outperform",
                "outweigh",
                "Choice D is the best answer because “outweigh” is the only choice\n" +
                        "that appropriately reflects the relationship the sentence sets up\n" +
                        "between “advantages” and “drawbacks.”\n" +
                        "Choices A, B, and C are incorrect because each implies a competitive\n" +
                        "relationship that is inappropriate in this context. ",
                4,
                "P1GP1");
        addQuestion(P1GP1Q1);
        readingQuestion P1GP1Q2 = new readingQuestion(
                "Which choice provides the most relevant detail?",
                "NO CHANGE",
                "supplement and convert it into gas to use as fuel\n" +
                        "in electricity production.",
                "supplement, while sweet whey is more desirable\n" +
                        "as a food additive for humans.",
                "supplement, which provides an important\n" +
                        "element of their diet.",
                "Choice B is the best answer because it offers a second action that\n" +
                        "farmers can undertake to address the problem of acid whey disposal,\n" +
                        "thus supporting the claim made in the previous sentence (“To address\n" +
                        "the problem of disposal, farmers have found a number of uses for\n" +
                        "acid whey”).\n" +
                        "Choices A, C, and D are incorrect because they do not offer examples\n" +
                        "of how farmers could make use of acid whey. ",
                2,
                "P1GP1");
        addQuestion(P1GP1Q2);
        readingQuestion P1GP1Q3 = new readingQuestion(
                null,
                "NO CHANGE",
                "can pollute waterway’s,",
                "could have polluted waterways,",
                "has polluted waterway’s,",
                "Choice A is the best answer because it results in a sentence that is\n" +
                        "grammatically correct and coherent. In choice A, “waterways,” the\n" +
                        "correct plural form of “waterway,” conveys the idea that acid whey could\n" +
                        "impact multiple bodies of water. Additionally, the compound verb “can\n" +
                        "pollute” suggests that acid whey presents an ongoing, potential problem.\n" +
                        "Choices B and D are incorrect because both use the possessive form\n" +
                        "of “waterway.” Choice C is incorrect because it creates an unnecessary\n" +
                        "shift in verb tense. The present tense verb “can pollute” should be used\n" +
                        "instead, as it is consistent with the other verbs in the paragraph. ",
                1,
                "P1GP1");
        addQuestion(P1GP1Q3);
        readingQuestion P1GP1Q4 = new readingQuestion(
                null,
                "NO CHANGE",
                "scientists: and",
                "scientists, and",
                "scientists, and,",
                "Choice C is the best answer because it utilizes proper punctuation\n" +
                        "for items listed in a series. In this case those items are nouns: “Yogurt\n" +
                        "manufacturers, food scientists, and government officials”.\n" +
                        "Choices A and B are incorrect because both fail to recognize\n" +
                        "that the items are a part of a series. Since a comma is used after\n" +
                        "“manufacturers,” a semicolon or colon should not be used after\n" +
                        "“scientists.” Choice D is incorrect because the comma after “and” is\n" +
                        "unnecessary and deviates from grammatical conventions for presenting\n" +
                        "items in a series. ",
                3,
                "P1GP1");
        addQuestion(P1GP1Q4);
        readingQuestion P1GP1Q5 = new readingQuestion(
                "To make this paragraph most logical, sentence 5\n" +
                        "should be placed",
                "where it is now.",
                "after sentence 1.",
                "after sentence 2.",
                "after sentence 3.",
                "Choice C is the best answer because sentence 5 logically links\n" +
                        "sentence 2, which explains why Greek yogurt production yields large\n" +
                        "amounts of acid whey, and sentence 3, which mentions the need to\n" +
                        "dispose of acid whey properly.\n" +
                        "Choices A, B, and D are incorrect because each would result in an\n" +
                        "illogical progression of sentences for this paragraph. If sentence 5 were\n" +
                        "left where it is or placed after sentence 3, it would appear illogically\n" +
                        "after the discussion of “the problem of disposal.” If sentence 5 were\n" +
                        "placed after sentence 1, it would illogically discuss “acid-whey runoff”\n" +
                        "before the mention of acid whey being “difficult to dispose of.”",
                3,
                "P1GP1");
        addQuestion(P1GP1Q5);
        readingQuestion P1GP1Q6 = new readingQuestion(
                "The writer is considering deleting the underlined\n" +
                        "sentence. Should the writer do this?",
                " Yes, because it does not provide a transition\n" +
                        "from the previous paragraph.",
                "Yes, because it fails to support the main\n" +
                        "argument of the passage as introduced in the\n" +
                        "first paragraph.",
                "No, because it continues the explanation of how\n" +
                        "acid whey can be disposed of safely.",
                "No, because it sets up the argument in the\n" +
                        "paragraph for the benefits of Greek yogurt",
                "Choice D is the best answer because the paragraph includes several\n" +
                        "benefits of consuming Greek yogurt, particularly in regard to nutrition\n" +
                        "and satisfying hunger, to support the sentence’s claim that the\n" +
                        "conservation efforts are “well worth the effort.” This transition echoes\n" +
                        "the passage’s earlier claim that “the advantages of Greek yogurt\n" +
                        "outweigh the potential drawbacks of its production.”\n" +
                        "Choices A, B, and C are incorrect because they inaccurately describe\n" +
                        "the sentence in question. ",
                4,
                "P1GP1");
        addQuestion(P1GP1Q6);
        readingQuestion P1GP1Q7 = new readingQuestion(
                null,
                "NO CHANGE",
                "as",
                "like",
                "for",
                "Choice B is the best answer because it provides a grammatically\n" +
                        "standard preposition that connects the verb “serves” and noun\n" +
                        "“digestive aid” and accurately depicts their relationship.\n" +
                        "Choice A is incorrect because the infinitive form “to be” yields a\n" +
                        "grammatically incorrect verb construction: “serves to be.” Choices C\n" +
                        "and D are incorrect because both present options that deviate from\n" +
                        "standard English usage. ",
                2,
                "P1GP1");
        addQuestion(P1GP1Q7);
        readingQuestion P1GP1Q8 = new readingQuestion(
                null,
                "NO CHANGE",
                "containing",
                "contains",
                "will contain",
                "Choice C is the best answer because it presents a verb tense that is\n" +
                        "consistent in the context of the sentence. The choice is also free of the\n" +
                        "redundant “it.”\n" +
                        "Choice A is incorrect because the subject “it” creates a redundancy.\n" +
                        "Choices B and D are incorrect because they present verb tenses that\n" +
                        "are inconsistent in the context of the sentence. \n",
                3,
                "P1GP1");
        addQuestion(P1GP1Q8);
        readingQuestion P1GP1Q9 = new readingQuestion(
                null,
                "NO CHANGE",
                "In other words,",
                "Therefore,",
                "For instance,",
                "Choice A is the best answer because it properly introduces an\n" +
                        "additional health benefit in a series of sentences that list health benefits.\n" +
                        "“Also” is the logical and coherent choice to communicate an addition.\n" +
                        "Choices B, C, and D are incorrect because none of the transitions they\n" +
                        "offer logically fits the content that precedes or follows the proposed\n" +
                        "choice.",
                1,
                "P1GP1");
        addQuestion(P1GP1Q9);
        readingQuestion P1GP1Q10 = new readingQuestion(
                null,
                "NO CHANGE",
                "fulfilled",
                "complacent",
                "sufficient",
                "Choice A is the best answer because “satiated” is the only choice that\n" +
                        "communicates effectively that Greek yogurt will satisfy hunger for a\n" +
                        "longer period of time.\n" +
                        "Choices B, C, and D are incorrect because each is improper usage in\n" +
                        "this context. A person can be “fulfilled” spiritually or in other ways,\n" +
                        "but a person who has eaten until he or she is no longer hungry cannot\n" +
                        "be described as fulfilled. Neither can he or she be described as being\n" +
                        "“complacent” or “sufficient.”",
                4,
                "P1GP1");
        addQuestion(P1GP1Q10);
        readingQuestion P1GP1Q = new readingQuestion(
                null,
                "NO CHANGE",
                "it, farmers",
                "it, so farmers",
                "it: farmers",
                "Choice B is the best answer because it provides a syntactically\n" +
                        "coherent and grammatically correct sentence.\n" +
                        "Choices A and C are incorrect because the adverbial conjunctions\n" +
                        "“therefore” and “so,” respectively, are unnecessary following\n" +
                        "“Because.” Choice D is incorrect because it results in a grammatically\n" +
                        "incomplete sentence (the part of the sentence before the colon must be\n" +
                        "an independent clause). \n",
                2,
                "P1GP1");
        addQuestion(P1GP1Q);

        //Practice test 1 - GRAMMAR - Passage 2
        readingQuestion P1GP2Q12 = new readingQuestion(
                "Which choice most accurately and effectively\n" +
                        "represents the information in the graph?",
                "NO CHANGE",
                "to 12 degrees Fahrenheit." +
                        "in electricity production.",
                "to their lowest point on December 13.",
                "to 10 degrees Fahrenheit and stay there for\n" +
                        "months.",
                "Choice B is the best answer. “This frequent experience\n" +
                        "of gift-giving can engender ambivalent feelings in gift-givers.” In\n" +
                        "the subsequent sentences, those “ambivalent” feelings are further\n" +
                        "exemplified as conflicted feelings, as shopping is said to be something\n" +
                        "that “[m]any relish” (line 10-11) and “many dread” (line 14).\n" +
                        "Choices A, C, and D are incorrect because in this context, “ambivalent”\n" +
                        "does not mean feelings that are unrealistic, apprehensive, or supportive. ",
                2,
                "P1GP2");
        addQuestion(P1GP2Q12);
        readingQuestion P1GP2Q13 = new readingQuestion(
                "Which choice most effectively combines the two\n" +
                        "sentences at the underlined portion?",
                "summer, following",
                "summer, and this thawing follows",
                "summer, and such thawing follows",
                "summer and this evidence follows",
                "Choice A is the best answer because it concisely combines the two\n" +
                        "sentences while maintaining the original meaning.\n" +
                        "Choices B, C, and D are incorrect because each is unnecessarily wordy,\n" +
                        "thus undermining one purpose of combining two sentences: to make\n" +
                        "the phrasing more concise. ",
                1,
                "P1GP2");
        addQuestion(P1GP2Q13);
        readingQuestion P1GP2Q14 = new readingQuestion(
                null,
                "NO CHANGE",
                "However,",
                "As such,",
                "Moreover,",
                "Choice B is the best answer because it provides a conjunctive adverb\n" +
                        "that accurately represents the relationship between the two sentences.\n" +
                        "“However” signals an exception to a case stated in the preceding sentence.\n" +
                        "Choices A, C, and D are incorrect because each provides a transition\n" +
                        "that does not accurately represent the relationship between the two\n" +
                        "sentences, and as a result each compromises the logical coherence of\n" +
                        "these sentences.",
                2,
                "P1GP2");
        addQuestion(P1GP2Q14);
        readingQuestion P1GP2Q15 = new readingQuestion(
                null,
                "NO CHANGE",
                "Box an associate professor of geology at\n" +
                        "Ohio State,",
                "Box, an associate professor of geology at\n" +
                        "Ohio State,",
                "Box, an associate professor of geology, at\n" +
                        "Ohio State",
                "Choice C is the best answer because it provides commas to offset the\n" +
                        "nonrestrictive modifying clause “an associate professor of geology at\n" +
                        "Ohio State\n" +
                        "Choices A, B, and D are incorrect because each provides punctuation\n" +
                        "that does not adequately separate the nonrestrictive modifying clause\n" +
                        "about Jason Box from the main clause.",
                3,
                "P1GP2");
        addQuestion(P1GP2Q15);
        readingQuestion P1GP2Q16 = new readingQuestion(
                null,
                "NO CHANGE",
                "thaw; and it was",
                "thaw:",
                "thaw: being",
                "Choice C is the best answer because the colon signals that the other\n" +
                        "factor that contributed to the early thaw is about to be provided.\n" +
                        "Choice A is incorrect because it results in a sentence that deviates\n" +
                        "from grammatical standards: a semicolon should be used to separate\n" +
                        "two independent clauses, but in choice A the second clause only has\n" +
                        "a subject, not a verb. Choice B is incorrect because it is unnecessarily\n" +
                        "wordy. Choice D is incorrect because “being” is unnecessary and\n" +
                        "creates an incoherent clause.",
                3,
                "P1GP2");
        addQuestion(P1GP2Q16);
        readingQuestion P1GP2Q17 = new readingQuestion(
                null,
                "NO CHANGE",
                "soot",
                "of which",
                "DELETE the underlined portion.",
                "Choice C is the best answer because it provides the correct\n" +
                        "preposition (“of”) and relative pronoun (“which”) that together create a\n" +
                        "dependent clause following the comma.\n" +
                        "Choices A, B, and D are incorrect because each results in a comma\n" +
                        "splice. Two independent clauses cannot be joined with only a comma. ",
                3,
                "P1GP2");
        addQuestion(P1GP2Q17);
        readingQuestion P1GP2Q18 = new readingQuestion(
                null,
                "NO CHANGE",
                "falls",
                "will fall",
                "had fallen",
                "Choice A is the best answer because the verb tense is consistent with\n" +
                        "the preceding past tense verbs in the sentence, specifically “produced”\n" +
                        "and “drifted.”\n" +
                        "Choices B, C, and D are incorrect because each utilizes a verb tense\n" +
                        "that is not consistent with the preceding past tense verbs in the\n" +
                        "sentence. ",
                1,
                "P1GP2");
        addQuestion(P1GP2Q18);
        readingQuestion P1GP2Q19 = new readingQuestion(
                null,
                "NO CHANGE",
                "its",
                "there",
                "their",
                "Choice D is the best answer because “their” is the possessive form of\n" +
                        "a plural noun. In this case, the noun is plural: “snow and ice.”\n" +
                        "Choices A and B are incorrect because the possessive pronoun must\n" +
                        "refer to a plural noun, “snow and ice,” rather than a singular noun.\n" +
                        "Choice C is incorrect because “there” would result in an incoherent\n" +
                        "sentence. ",
                4,
                "P1GP2");
        addQuestion(P1GP2Q19);
        readingQuestion P1GP2Q20 = new readingQuestion(
                "Which choice best completes the description of a\n" +
                        "self-reinforcing cycle?",
                "NO CHANGE",
                "raises the surface temperature.",
                "begins to cool at a certain point.",
                "leads to additional melting.",
                "Choice D is the best answer. The preceding sentences in the paragraph\n" +
                        "have established that a darker surface of soot-covered snow leads to\n" +
                        "more melting because this darker surface absorbs heat, whereas a\n" +
                        "whiter surface, free of soot, would deflect heat. As the passage points\n" +
                        "out, exposed land and water are also dark and cannot deflect heat the\n" +
                        "way ice and snow can.\n" +
                        "that the preceding sentences already imply.\n" +
                        "Choices A, B, and C are incorrect because the information each\n" +
                        "provides fails to support the previous claim that the “result” of the soot\n" +
                        "“is a self-reinforcing cycle.” ",
                4,
                "P1GP2");
        addQuestion(P1GP2Q20);
        readingQuestion P1GP2Q21 = new readingQuestion(
                null,
                "NO CHANGE",
                "itself,",
                "itself, with damage and",
                "itself possibly,",
                "Choice B is the best answer because it is free of redundancies.\n" +
                        "Choices A, C, and D are incorrect because each of the three presents\n" +
                        "a redundancy: Choice A uses “repeat” and “again”; Choice C uses\n" +
                        "“damage” and “harmful effects”; and Choice D uses “many” and\n" +
                        "“possibly.”",
                4,
                "P1GP2");
        addQuestion(P1GP2Q21);
        readingQuestion P1GP2Q22 = new readingQuestion(
                "To make this paragraph most logical, sentence 4\n" +
                        "should be placed",
                "where it is now.",
                "after sentence 1.",
                "after sentence 2.",
                "after sentence 5.",
                "Choice D is the best answer because sentence 5 describes the\n" +
                        "information Box seeks: “to determine just how much the soot is\n" +
                        "contributing to the melting of the ice sheet.” Unless sentence 4 comes\n" +
                        "after sentence 5, readers will not know what the phrase “this crucial\n" +
                        "information” in sentence 4 refers to.\n" +
                        "Choices A, B, and C are incorrect because each results in an illogical\n" +
                        "sentence progression. None of the sentences that would precede\n" +
                        "sentence 4 provides details that could be referred to as “this crucial\n" +
                        "information.” ",
                4,
                "P1GP2");
        addQuestion(P1GP2Q22);


    }

    private void addQuestion(readingQuestion readingQuestion) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, readingQuestion.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, readingQuestion.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, readingQuestion.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, readingQuestion.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, readingQuestion.getOption4());
        cv.put(QuestionsTable.COLUMN_EXPLANATION, readingQuestion.getExplanation());
        cv.put(QuestionsTable.COLUMN_CORRECTANSWER, readingQuestion.getCorrectAnswer());
        cv.put(QuestionsTable.COLUMN_ID, readingQuestion.getId());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);

    }

    public List<readingQuestion> getAllQuestions() {
        List<readingQuestion> readingQuestionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                readingQuestion readingQuestion = new readingQuestion();
                readingQuestion.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                readingQuestion.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                readingQuestion.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                readingQuestion.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                readingQuestion.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                readingQuestion.setExplanation(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLANATION)));
                readingQuestion.setCorrectAnswer(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CORRECTANSWER)));
                readingQuestion.setId(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ID)));
                readingQuestionList.add(readingQuestion);

            } while (c.moveToNext());
        }
        c.close();
        return readingQuestionList;

    }
}
