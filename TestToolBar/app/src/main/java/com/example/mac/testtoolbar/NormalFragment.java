package com.example.mac.testtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/20.
 */
public class NormalFragment extends Fragment {

    @BindView(R.id.rv_list)
    RecyclerView mList;

    private DataAdapter mDataAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mList.setLayoutManager(manager);

        mList.setHasFixedSize(true);

        if (mDataAdapter == null) {
            mDataAdapter = new DataAdapter(getActivity(), null);
        }
        mList.setAdapter(mDataAdapter);

        mList.setVisibility(View.VISIBLE);
    }
}
