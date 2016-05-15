package com.example.mac.testcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView mList;

    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mList.setLayoutManager(manager);

        mList.setHasFixedSize(true);

        if (mDataAdapter == null) {
            mDataAdapter = new DataAdapter(this, null);
        }
        mList.setAdapter(mDataAdapter);

        mList.setVisibility(View.VISIBLE);
    }
}
