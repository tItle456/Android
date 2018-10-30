package com.example.a13522.mythirdhomework.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class YoudaoAPI {
    URL url;
    String word;
    String url1;
    String url2;
    HttpURLConnection urlCon;

    public YoudaoAPI(String word) {
        try {
            this.word = word;
            url1 = "http://dict.youdao.com/suggest?q=";
            url2 = "&le=eng&num=15&ver=2.0&doctype=json&keyfrom=mdict.7.2.0.android";
            url = new URL(url1 + word + url2);
            urlCon = null;
        } catch (Exception e) {
        }
    }

    public String getJSON() {
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            urlCon = (HttpURLConnection) url.openConnection();
            InputStreamReader inReader = new InputStreamReader(urlCon.getInputStream(), "utf-8");
            BufferedReader buffer = new BufferedReader(inReader);
            stringBuilder = new StringBuilder("");
            String s;
            while ((s = buffer.readLine()) != null) {
                stringBuilder.append(s);
            }
        } catch (Exception e) {
        }
        urlCon.disconnect();
        return stringBuilder.toString();
    }
}
