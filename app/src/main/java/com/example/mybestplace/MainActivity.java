package com.example.mybestplace;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long mBackPressed;
    private WebView mywebview;
    private static final int TIME_INTERVAL = 1000; // # milliseconds, desired time passed between two back presses.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebview = findViewById(R.id.webview);
        WebSettings webSettings = mywebview.getSettings();
        mywebview.loadUrl("https://mybestplace.org/");
        webSettings.setJavaScriptEnabled(true);
        mywebview.setWebViewClient( new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed(){

        if (mywebview.canGoBack()) {
            mywebview.goBack();
        } else{
                super.onBackPressed();
            }
        }
    }

