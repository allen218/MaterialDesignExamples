package com.example.mac.testtextinputlayout;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.register_btn)
    Button mRegisterBtn;

    @BindView(R.id.username_et)
    EditText mUsername;

    @BindView(R.id.pass_et)
    EditText mPass;

    @BindView(R.id.email_et)
    EditText mEmail;

    @BindView(R.id.username_input_layout)
    TextInputLayout mUsernameLayout;

    @BindView(R.id.pass_input_layout)
    TextInputLayout mPassLayout;

    @BindView(R.id.email_input_layout)
    TextInputLayout mEmailLayout;

    @BindView(R.id.root_view)
    CoordinatorLayout mRootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        initClick();


    }

    private void initClick() {
        mRegisterBtn.setOnClickListener(o -> {
            if (!validateUsername()) {
                return;
            }

            if (!validatePassword()) {
                return;
            }

            if (!validateEmail()) {
                return;
            }

            Snackbar.make(mRootView, "注册成功!", Snackbar.LENGTH_SHORT).show();
        });
    }

    private void initView() {
        setSupportActionBar(mToolbar);
    }

    /**
     * 验证用户名是否合法
     *
     * @return
     */
    private boolean validateUsername() {
        if (TextUtils.isEmpty(mUsername.getText().toString().trim())) {
            mUsernameLayout.setError(getString(R.string.username_not_null));
            mUsername.requestFocus();
        } else {
            mUsernameLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * 验证密码是否合法
     *
     * @return
     */
    private boolean validatePassword() {
        if (TextUtils.isEmpty(mPass.getText().toString().trim())) {
            mPassLayout.setError(getString(R.string.pass_not_null));
            mPass.requestFocus();
        } else {
            mPassLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * 验证邮箱是否合法
     *
     * @return
     */
    private boolean validateEmail() {
        if (TextUtils.isEmpty(mEmail.getText().toString().trim())) {
            mEmailLayout.setError(getString(R.string.email_not_null));
            mEmail.requestFocus();
        } else {
            mEmailLayout.setErrorEnabled(false);
        }
        return true;
    }
}
