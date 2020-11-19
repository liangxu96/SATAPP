package com.example.sat_app;

import android.provider.BaseColumns;

public class readingQuestionContract implements BaseColumns {
    private readingQuestionContract() {

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "question_table";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_EXPLANATION = "explanation";
        public static final String COLUMN_CORRECTANSWER = "correct_answer";
        public static final String COLUMN_ID = "id";
    }

}
