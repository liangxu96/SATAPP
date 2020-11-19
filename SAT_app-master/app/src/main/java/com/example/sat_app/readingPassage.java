package com.example.sat_app;

public class readingPassage {
    private String synopsis;
    private String passage;
    private String image;
    private String secondPassage;
    private int lines;
    private int twoPassageLine;
    private int synopsisPadding;
    private String id;

    public readingPassage() {}

    public readingPassage(String synopsis, String passage, String image, String secondPassage, int lines, int twoPassageLine, int synopsisPadding, String id) {
        this.synopsis = synopsis;
        this.passage = passage;
        this.image = image;
        this.secondPassage = secondPassage;
        this.lines = lines;
        this.twoPassageLine = twoPassageLine;
        this.synopsisPadding = synopsisPadding;
        this.id = id;
    }

    public int getTwoPassageLine() {
        return twoPassageLine;
    }

    public void setTwoPassageLine(int twoPassageLine) {
        this.twoPassageLine = twoPassageLine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSecondPassage() {
        return secondPassage;
    }

    public void setSecondPassage(String secondPassage) {
        this.secondPassage = secondPassage;
    }

    public int getSynopsisPadding() {
        return synopsisPadding;
    }

    public void setSynopsisPadding(int synopsisPadding) {
        this.synopsisPadding = synopsisPadding;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage;
    }

}
