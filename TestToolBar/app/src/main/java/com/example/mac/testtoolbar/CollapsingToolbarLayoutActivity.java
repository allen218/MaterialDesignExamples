package com.example.mac.testtoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/20.
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_list)
    RecyclerView mList;

    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_layout);
        ButterKnife.bind(this);

        initView();

        initData();
    }

    private void initView() {

        mToolbar.setLogo(R.drawable.aa12);  //设置logo
        mToolbar.setTitle("测试Toolbar");  //这里是标题
        mToolbar.setSubtitle("github");  //这里是副标题  这个没有效果

//        mToolbar.inflateMenu(R.menu.menu_main);  //设置menu菜单
        //这个设置需要在设置title后
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.aa17);  //设置导航图标
        //设置menu菜单的点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.action_edit:
                        msg += "Click edit";
                        break;
                    case R.id.action_share:
                        msg += "Click share";
                        break;
                    case R.id.action_settings:
                        msg += "Click setting";
                        break;
                }

                if (!msg.equals("")) {
                    Toast.makeText(CollapsingToolbarLayoutActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
