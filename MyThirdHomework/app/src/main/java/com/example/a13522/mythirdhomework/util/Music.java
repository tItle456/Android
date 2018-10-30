package com.example.a13522.mythirdhomework.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class Music {
    public void play(Context context, String word) {
        if (word != null) {
            Uri location = Uri.parse("http://dict.youdao.com/dictvoice?audio=" + word);
            MediaPlayer mediaPlayer = MediaPlayer.create(context, location);
            mediaPlayer.start();
        }
    }
}