package com.example.a13522.mythirdhomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.a13522.mythirdhomework.R;
import com.example.a13522.mythirdhomework.domain.Words;

public class WordsAdapter extends ArrayAdapter<Words> {
    private int resourceId;

    public WordsAdapter(Context context, int textViewResourceId, List<Words> object) {
        super(context, textViewResourceId, object);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Words words = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView word = view.findViewById(R.id.word);
        word.setText(words.getWord());
        return view;
    }
}
