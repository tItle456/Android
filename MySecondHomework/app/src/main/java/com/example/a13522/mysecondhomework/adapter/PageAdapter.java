package com.example.a13522.mysecondhomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a13522.mysecondhomework.R;
import com.example.a13522.mysecondhomework.domain.Page;

import java.util.List;

public class PageAdapter extends ArrayAdapter<Page> {
    private int resourceId;

    public PageAdapter(Context context, int textViewResourceId, List<Page> object) {
        super(context, textViewResourceId, object);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Page page = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView pageTitle = view.findViewById(R.id.page_title);
        TextView pageDate = view.findViewById(R.id.page_date);
        pageTitle.setText(page.getTitle());
        pageDate.setText(page.getDate());
        return view;
    }
}
