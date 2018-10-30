package com.example.a13522.mythirdhomework.domain;

public class Words {
    private String word;
    private String translate;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "|" + word + "|" + translate + "|";
    }
}
