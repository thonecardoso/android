package com.example.javajavascript;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;
    WebAppInterface(Context c){
        mContext = c;

    }

    @android.webkit.JavascriptInterface
    public void showToast(String str){
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }
}
