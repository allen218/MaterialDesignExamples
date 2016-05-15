package com.example.mac.texttablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.simple_tab_layout)
    Button mSimpleTabLayout;

    @BindView(R.id.scroll_tab_layout)
    Button mScrollTabLayout;

    @BindView(R.id.image_text_tab_layout)
    Button mImageAndTextTabLayout;

    @BindView(R.id.image_tab_layout)
    Button mImageTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initOnClick();

    }

    private void initOnClick() {
        mScrollTabLayout.setOnClickListener(o ->
                jumpAction(ScrollTabLayoutActivity.class)
        );

        mSimpleTabLayout.setOnClickListener(o ->
                jumpAction(SimpleTabLayoutActivity.class)
        );

        mImageAndTextTabLayout.setOnClickListener(O ->
                jumpAction(ImageAndTextTabLayoutActivity.class)
        );

        mImageTabLayout.setOnClickListener(o ->
                jumpAction(ImageTabLayoutActivity.class)
        );
    }

    private void jumpAction(Class ActivityClass) {
        startActivity(new Intent(this, ActivityClass));
    }


}
