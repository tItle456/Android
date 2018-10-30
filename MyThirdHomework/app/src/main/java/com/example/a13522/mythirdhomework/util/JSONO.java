package com.example.a13522.mythirdhomework.util;

import com.example.a13522.mythirdhomework.domain.Words;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class JSONO {
    String data;

    public JSONO() {
        data = null;
    }

    public LinkedList<Words> getData(String data) {
        LinkedList<Words> words = new LinkedList<>();
        try {
            StringBuilder sb = new StringBuilder(data);
            while (sb.charAt(0) != '[') {
                sb.delete(0, 1);
            }
            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Words word = new Words();
                word.setWord(jsonObject.getString("entry"));
                word.setTranslate(jsonObject.getString("explain"));
                words.addLast(word);
            }
        } catch (Exception e) {
        }
        return words;
    }
}