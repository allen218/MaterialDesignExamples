package com.example.mac.texttablayout;

import android.os.Bundle;
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
 * Created by allen on 16/5/14.
 * 滑动tablayout显示
 */
public class ScrollTabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tab)
    TabLayout mTabLayout;

    @BindView(R.id.content_vp)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_tab_layout);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        setupViewPager();

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(NormalFragment.newInstance("ONE"), "ONE");
        adapter.addFragment(NormalFragment.newInstance("TWO"), "TWO");
        adapter.addFragment(NormalFragment.newInstance("THREE"), "THREE");
        adapter.addFragment(NormalFragment.newInstance("FOUR"), "FOUR");
        adapter.addFragment(NormalFragment.newInstance("FIVE"), "FIVE");
        adapter.addFragment(NormalFragment.newInstance("SIX"), "SIX");
        adapter.addFragment(NormalFragment.newInstance("SENVEN"), "SENVEN");
        adapter.addFragment(NormalFragment.newInstance("EIGHT"), "EIGHT");
        adapter.addFragment(NormalFragment.newInstance("NINE"), "NINE");
        mViewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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
