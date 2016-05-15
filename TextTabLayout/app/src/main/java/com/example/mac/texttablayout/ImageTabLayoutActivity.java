package com.example.mac.texttablayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/14.
 * 只带图标的tablayout显示
 */
public class ImageTabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tab)
    TabLayout mTabLayout;

    @BindView(R.id.content_vp)
    ViewPager mViewPager;

    private List<Drawable> mDrawables;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_tab_layout);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        initDrawable();

        setupViewPager();

        mTabLayout.setupWithViewPager(mViewPager);

        setTabLayoutIcon();

    }

    private void initDrawable() {
        if (mDrawables == null) {
            mDrawables = new ArrayList<>();
        }
        for (int x = 0; x < 3; x++) {
            mDrawables.add(getResources().getDrawable(R.drawable.a1));
        }
    }

    /**
     * 给每个tab设置图标
     */
    private void setTabLayoutIcon() {
        /*for (int x = 0; x < mTabLayout.getTabCount(); x++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(x);
            tab.setCustomView(adapter.getPagerView(x));
        }*/
        mTabLayout.getTabAt(0).setIcon(R.drawable.a1);
        mTabLayout.getTabAt(1).setIcon(R.drawable.a1);
        mTabLayout.getTabAt(2).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(3).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(4).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(5).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(6).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(7).setIcon(R.drawable.a2);
        mTabLayout.getTabAt(8).setIcon(R.drawable.a2);
    }

    private void setupViewPager() {
        if (adapter == null) {
            adapter = new ViewPagerAdapter(getSupportFragmentManager());
        }
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

        @BindView(R.id.icon)
        ImageView mIcon;

        @BindView(R.id.title)
        TextView mTv;

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

       /* @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
*/

        /**
         * 处理文字带图标的tab显示
         *
         * @param position
         * @return
         */
        public View getPagerView(int position) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.pager_title_image, null);
            ButterKnife.bind(this, view);

            mIcon.setImageDrawable(mDrawables.get(position));
            mTv.setText(mTitles.get(position));
            return view;
        }

    }

}
