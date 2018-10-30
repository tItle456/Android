package com.example.a13522.mythirdhomework.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.a13522.mythirdhomework.R;
import com.example.a13522.mythirdhomework.adapter.WordsAdapter;
import com.example.a13522.mythirdhomework.dao.WordsDao;
import com.example.a13522.mythirdhomework.domain.Words;
import com.example.a13522.mythirdhomework.util.JSONO;
import com.example.a13522.mythirdhomework.util.YoudaoAPI;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private LinkedList<Words> wordsList;
    private Handler handler;
    private EditText editText;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            WordsDao wordsDao = new WordsDao(MainActivity.this);
            WordsAdapter adapter = new WordsAdapter(MainActivity.this, R.layout.word_item, wordsList);
            ListView listView = findViewById(R.id.list_view);
            listView.setAdapter(adapter);
            wordsDao.insert(wordsList);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordsList = new LinkedList<>();
        WordsAdapter adapter = new WordsAdapter(MainActivity.this, R.layout.word_item, wordsList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        handler = new Handler();
        editText = findViewById(R.id.search_bar);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("word", wordsList.get(i).getWord());
        editor.apply();
        startActivity(new Intent(MainActivity.this, ContentActivity.class));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_button:
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        String word = editText.getText().toString();
                        YoudaoAPI youdaoAPI = new YoudaoAPI(word);
                        JSONO jsono = new JSONO();
                        wordsList = jsono.getData(youdaoAPI.getJSON());
                        handler.post(runnable);
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
