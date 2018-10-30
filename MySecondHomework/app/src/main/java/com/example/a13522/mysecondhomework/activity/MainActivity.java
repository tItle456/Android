package com.example.a13522.mysecondhomework.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a13522.mysecondhomework.dao.PageDao;
import com.example.a13522.mysecondhomework.adapter.PageAdapter;
import com.example.a13522.mysecondhomework.R;
import com.example.a13522.mysecondhomework.domain.Page;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Page> pageList;
    private PageDao pageDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pageDao = new PageDao(this);
        pageList = pageDao.selectAll();
        PageAdapter adapter = new PageAdapter(MainActivity.this, R.layout.page_item, pageList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putInt("id", pageList.get(i).getId());
        editor.apply();
        startActivity(new Intent(MainActivity.this, ContentActivity.class));
    }

    public void onClick(View view) {
        pageDao.insert("");
        pageList = pageDao.selectAll();
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putInt("id", pageList.get(0).getId());
        editor.apply();
        startActivity(new Intent(MainActivity.this, ContentActivity.class));
    }
}
