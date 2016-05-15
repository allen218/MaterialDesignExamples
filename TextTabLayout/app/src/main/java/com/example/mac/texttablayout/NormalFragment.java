package com.example.mac.texttablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by allen on 16/5/14.
 */
public class NormalFragment extends Fragment {
    @BindView(R.id.fragment_tv)
    TextView mTv;

    private static boolean isFromNewInstance;  //是否是通过newInstance创建的


    public NormalFragment() {
        if (!isFromNewInstance) {
            throw new RuntimeException("请通过newInstance()方法来创建");
        }

        isFromNewInstance = false;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_layout, null);
        ButterKnife.bind(this, view);

        String currentContent = handleGetParams(getArguments());

        if (!TextUtils.isEmpty(currentContent)) {
            mTv.setText(currentContent);
        }

        return view;
    }

    private String handleGetParams(Bundle arguments) {
        return arguments.getString("content");
    }

    /**
     * 创建fragment实例
     *
     * @param content
     * @return
     */
    public static NormalFragment newInstance(String content) {
        isFromNewInstance = true;

        NormalFragment normalFragment = new NormalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("content", content);

        normalFragment.setArguments(bundle);
        return normalFragment;
    }
}
