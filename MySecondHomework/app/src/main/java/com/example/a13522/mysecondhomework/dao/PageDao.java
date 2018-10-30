package com.example.a13522.mysecondhomework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a13522.mysecondhomework.domain.Page;
import com.example.a13522.mysecondhomework.util.DataBase;

import java.util.ArrayList;
import java.util.List;

public class PageDao {
    private Context context;
    private DataBase dataBase;
    private SQLiteDatabase sqLiteDatabase;

    public PageDao(Context context) {
        this.context = context;
        dataBase = new DataBase(context, "Page.db", null, 1);
        sqLiteDatabase = dataBase.getWritableDatabase();
    }

    public void insert(String content) {
        Page page = new Page();
        page = page.toPage(content);
        sqLiteDatabase.execSQL("INSERT INTO Page (title, date, content) VALUES(?, ?, ?)", new String[]{page.getTitle(), page.getDate(), page.getContent()});
    }

    public void update(String content, int id) {
        Page page = new Page();
        page = page.toPage(content);
        sqLiteDatabase.execSQL("UPDATE Page SET title = ?, date = ?, content = ? WHERE id = ?", new String[]{page.getTitle(), page.getDate(), page.getContent(), id + ""});
    }

    public void delete(int id) {
        sqLiteDatabase.execSQL("DELETE FROM Page WHERE id = ?", new String[]{id + ""});
    }

    public List<Page> selectAll() {
        List<Page> pageList = new ArrayList<>();
        Page page;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Page ORDER BY date DESC", null);
        if (cursor.moveToFirst()) {
            do {
                page = new Page();
                page.setId(cursor.getInt(cursor.getColumnIndex("id")));
                page.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                page.setDate(cursor.getString(cursor.getColumnIndex("date")));
                page.setContent(cursor.getString(cursor.getColumnIndex("content")));
                pageList.add(page);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return pageList;
    }

    public Page selectPage(int id) {
        Page page = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Page WHERE id = ?", new String[]{id + ""});
        if (cursor.moveToFirst()) {
            do {
                page = new Page();
                page.setId(cursor.getInt(cursor.getColumnIndex("id")));
                page.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                page.setDate(cursor.getString(cursor.getColumnIndex("date")));
                page.setContent(cursor.getString(cursor.getColumnIndex("content")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return page;
    }
}
