package com.example.a13522.mythirdhomework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a13522.mythirdhomework.domain.Words;
import com.example.a13522.mythirdhomework.util.DataBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordsDao {
    private Context context;
    private DataBase dataBase;
    private SQLiteDatabase sqLiteDatabase;

    public WordsDao(Context context) {
        this.context = context;
        dataBase = new DataBase(context, "Words.db", null, 1);
        sqLiteDatabase = dataBase.getWritableDatabase();
    }

    public boolean select(String word) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Words WHERE word = ?", new String[]{word});
        return cursor.moveToFirst();
    }

    public void insert(LinkedList<Words> words) {
        String word;
        String translate;
        for(int i=0;i<words.size();i++){
            word = words.get(i).getWord();
            if (!select(word)) {
                translate = words.get(0).getTranslate();
                sqLiteDatabase.execSQL("INSERT INTO Words (word, translate) VALUES(?, ?)", new String[]{word, translate});
            }
        }
    }

    public Words selectWord(String word) {
        Words words = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Words WHERE word = ?", new String[]{word});
        if (cursor.moveToFirst()) {
            words = new Words();
            words.setWord(cursor.getString(cursor.getColumnIndex("word")));
            words.setTranslate(cursor.getString(cursor.getColumnIndex("translate")));
        }
        cursor.close();
        return words;
    }
    public LinkedList<Words> selectAll() {
        LinkedList<Words> wordsList = new LinkedList<>();
        Words page;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Words", null);
        if (cursor.moveToFirst()) {
            do {
                Words word = new Words();
                word.setWord(cursor.getString(cursor.getColumnIndex("word")));
                word.setTranslate(cursor.getString(cursor.getColumnIndex("translate")));
                wordsList.add(word);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return wordsList;
    }
}
