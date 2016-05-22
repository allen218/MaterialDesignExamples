package com.example.mac.testtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.collapsing_btn)
    Button mCollapsingLayout;

    @BindView(R.id.Coordinator_btn)
    Button mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mCollapsingLayout.setOnClickListener(o ->
                startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class))
        );

        mCoordinatorLayout.setOnClickListener(o ->
                startActivity(new Intent(this, CoordinatorToolbarLayoutActivity.class))
        );
    }

}
