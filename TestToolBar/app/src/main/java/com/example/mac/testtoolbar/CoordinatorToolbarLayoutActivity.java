package com.example.mac.testtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/20.
 */
public class CoordinatorToolbarLayoutActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    @BindView(R.id.rl_list)
//    RecyclerView mList;

    @BindView(R.id.tab_layout)
    TabLayout mTablayout;

    @BindView(R.id.vp_pager)
    ViewPager mViewPager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        setSupportActionBar(mToolbar);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NormalFragment(), "ONE");
        adapter.addFragment(new NormalFragment(), "TWO");
        adapter.addFragment(new NormalFragment(), "THREE");
        adapter.addFragment(new NormalFragment(), "FOUR");
        mViewPager.setAdapter(adapter);

        mTablayout.setupWithViewPager(mViewPager);
    }



    static class ViewPagerAdapter extends FragmentPagerAdapter {


        private List<Fragment> mFragmentLists = new ArrayList<>();
        private List<String> mTitles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentLists.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentLists.size();
        }

        public void addFragment(Fragment oneFragment, String title) {
            mFragmentLists.add(oneFragment);
            mTitles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}
