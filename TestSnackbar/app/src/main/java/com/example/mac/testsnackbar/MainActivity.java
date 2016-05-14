package com.example.mac.testsnackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rl_root)
    CoordinatorLayout mRootLayout;

    @BindView(R.id.bt_simple)
    Button mSimpleSnackbar;

    @BindView(R.id.bt_action)
    Button mSnackbarAction;

    @BindView(R.id.bt_changed_color)
    Button mSnackbarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initButtonOclick();
    }


    private void initButtonOclick() {
        mSimpleSnackbar.setOnClickListener(o -> {
                    Snackbar.make(mRootLayout, "提示信息", Snackbar.LENGTH_SHORT).show();
                }
        );

        mSnackbarAction.setOnClickListener(o -> {
            Snackbar snackbar = Snackbar.make(mRootLayout, "提示信息", Snackbar.LENGTH_SHORT);
            Snackbar snackbar1 = Snackbar.make(mRootLayout, "提示信息1", Snackbar.LENGTH_SHORT)
                    .setAction("TODO", o1 -> {
                        snackbar.show();
                        Toast.makeText(this, "我是一个toast", Toast.LENGTH_SHORT).show();
                    });

            snackbar1.show();
        });

        mSnackbarColor.setOnClickListener(o -> {
            Snackbar snackbar = Snackbar.make(mRootLayout, "提示信息", Snackbar.LENGTH_SHORT)
                    .setAction("TODO", O1 -> {
                        Toast.makeText(this, "我是一个toast", Toast.LENGTH_SHORT).show();
                    });
            //改变ActionText颜色
            snackbar.setActionTextColor(Color.GRAY);
            //改变TextView颜色
            View view = snackbar.getView();
            TextView textView = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.BLUE);
            snackbar.show();
        });
    }

}
