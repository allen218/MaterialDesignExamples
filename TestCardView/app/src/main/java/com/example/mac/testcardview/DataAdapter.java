package com.example.mac.testcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/15.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private Context mContext;
    private List<DataInfo> mDatas;

    public DataAdapter(Context context, List<DataInfo> datas) {
        this.mContext = context;
        this.mDatas = datas;

    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);

        return new DataViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        ImageView mHeaderView;
        String name;
        String email;


        public DataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
