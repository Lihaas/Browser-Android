package com.stwalkerster.android.apps.allinone;

import android.widget.ImageView;

public class list {

    int imageView;
    String urll;

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public int getImageView() {
        return imageView;
    }

    public String getUrll() {
        return urll;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public void setUrll(String urll) {
        this.urll = urll;
    }

    public list(int imageView, String urll,String name) {
        this.imageView = imageView;
        this.urll = urll;
        this.name = name;
    }
}
