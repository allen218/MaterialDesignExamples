package com.example.mac.testcardview;

import android.widget.ImageView;

/**
 * Created by allen on 16/5/15.
 */
public class DataInfo {

    private ImageView headerIv;
    private String name;
    private String email;

    public ImageView getHeaderIv() {
        return headerIv;
    }

    public void setHeaderIv(ImageView headerIv) {
        this.headerIv = headerIv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
