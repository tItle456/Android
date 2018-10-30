package com.example.a13522.mythirdhomework.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a13522.mythirdhomework.R;
import com.example.a13522.mythirdhomework.dao.WordsDao;
import com.example.a13522.mythirdhomework.domain.Words;
import com.example.a13522.mythirdhomework.util.Music;

public class ContentActivity extends AppCompatActivity {
    Music music;
    TextView textViewWord;
    TextView textViewTranslate;
    WordsDao wordsDao;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        music = new Music();
        textViewWord = findViewById(R.id.word);
        textViewTranslate = findViewById(R.id.translate);
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        word = sharedPreferences.getString("word", "没有");
        wordsDao = new WordsDao(this);
        Words words = wordsDao.selectWord(word);
        textViewWord.setText(words.getWord());
        textViewTranslate.setText(words.getTranslate());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_button:
                startActivity(new Intent(ContentActivity.this, MainActivity.class));
                break;
            case R.id.play:
                music.play(this, textViewWord.getText().toString());
                break;
            default:
                break;
        }
    }
}
