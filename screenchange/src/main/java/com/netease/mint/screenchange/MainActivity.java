package com.netease.mint.screenchange;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import pw.qlm.inputmethodholder.InputMethodHolder;
import pw.qlm.inputmethodholder.OnInputMethodListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private ImageView imageView;
    private TextView tv_change_screen_orientation;
    private EditText editText;
    private ScrollView scv_input;
    private OnInputMethodListener onInputMethodListener;
    private boolean isInputShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
        tv_change_screen_orientation = (TextView) findViewById(R.id.tv_change_screen_orientation);

        tv_change_screen_orientation.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.editText);
        editText.setOnClickListener(this);
        scv_input = (ScrollView) findViewById(R.id.scv_input);
        scv_input.setOnClickListener(this);

        onInputMethodListener = new OnInputMethodListener() {
            @Override
            public void onShow(boolean result) {
                Toast.makeText(MainActivity.this, "Show input method! " + result, Toast.LENGTH_SHORT).show();
                isInputShow = true;
            }

            @Override
            public void onHide(boolean result) {
                Toast.makeText(MainActivity.this, "Hide input method! " + result, Toast.LENGTH_SHORT).show();
            }
        };
        InputMethodHolder.registerListener(onInputMethodListener);
    }

    public static void hideSoftKey(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);//强制隐藏键盘
    }


    public static void showSoftKey(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);   //强制显示键盘
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_change_screen_orientation:
                changeScreen();
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            //切换到竖屏
            //修改布局文件
//            setContentView(R.layout.activity_main);
            //findViewById ....
            //TODO something
            onChangeLandScape();
            Log.d(TAG, " -- onConfigurationChanged  可以在竖屏方向 to do something");
        } else {
            //切换到横屏
            //修改布局文件
//            setContentView(R.layout.activity_main);
            //findViewById ....
            //TODO something
            onChangePortrait();
            Log.d(TAG, " -- onConfigurationChanged  可以在横屏方向 to do something");
        }

    }

    public void changeScreen() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            //切换竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            //切换横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    protected void onChangePortrait() {
    }

    protected void onChangeLandScape() {

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart() called");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        InputMethodHolder.unregisterListener(onInputMethodListener);
        super.onDestroy();
    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "editTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
