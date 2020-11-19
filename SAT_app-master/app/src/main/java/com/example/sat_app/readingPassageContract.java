package com.example.sat_app;

import android.provider.BaseColumns;

public class readingPassageContract {
    private readingPassageContract() {}

    public static class passageTable implements BaseColumns{
        public static final String TABLE_NAME = "passage_table";
        public static final String COLUMN_SYNOPSIS = "synopsis";
        public static final String COLUMN_PASSAGE = "passage";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_SECONDPASSAGE = "second_passage";
        public static final String COLUMN_LINE = "line";
        public static final String COLUMN_TWOPASSAGELINE = "two_passage_line";
        public static final String COLUMN_SYNOPSISPADDING= "synopsis_padding";
        public static final String COLUMN_ID = "id";
    }
}
