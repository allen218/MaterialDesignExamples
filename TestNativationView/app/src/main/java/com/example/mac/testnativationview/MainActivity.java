package com.example.mac.testnativationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @BindView(R.id.root)
    DrawerLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        initNavigationItemClick();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initNavigationItemClick() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main:
                        mRoot.closeDrawers();
                        showSnackbar("点击了首页");
                        break;

                    case R.id.share:
                        mRoot.closeDrawers();
                        showSnackbar("点击了分享");

                        break;

                    case R.id.news:
                        mRoot.closeDrawers();
                        showSnackbar("点击了新闻");

                        break;

                    case R.id.active:
                        mRoot.closeDrawers();
                        showSnackbar("点击了活动");

                        break;

                    case R.id.buy:
                        mRoot.closeDrawers();
                        showSnackbar("点击了导购");

                        break;

                    case R.id.other:
                        mRoot.closeDrawers();
                        showSnackbar("点击了其它");

                        break;

                }
                return false;
            }
        });

    }

    /**
     * 提示
     *
     * @param text
     */
    public void showSnackbar(String text) {
        Snackbar.make(mRoot, text, Snackbar.LENGTH_SHORT).show();
    }
}
