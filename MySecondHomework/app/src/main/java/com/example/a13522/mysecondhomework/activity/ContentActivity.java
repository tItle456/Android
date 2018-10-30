package com.example.a13522.mysecondhomework.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.a13522.mysecondhomework.R;
import com.example.a13522.mysecondhomework.dao.PageDao;
import com.example.a13522.mysecondhomework.domain.Page;

public class ContentActivity extends AppCompatActivity {
    private EditText editText;
    private PageDao pageDao;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        editText = findViewById(R.id.editText);
        pageDao = new PageDao(this);
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        id = sharedPreferences.getInt("id", 0);
        Page page = pageDao.selectPage(id);
        editText.setText(page.getContent());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                pageDao.update(editText.getText().toString(), id);
                startActivity(new Intent(ContentActivity.this, MainActivity.class));
                break;
            case R.id.delete:
                pageDao.delete(id);
                startActivity(new Intent(ContentActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
