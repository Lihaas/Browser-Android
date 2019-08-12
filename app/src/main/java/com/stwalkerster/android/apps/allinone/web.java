package com.stwalkerster.android.apps.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class web extends AppCompatActivity {
    WebView web;
    ProgressBar pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web = findViewById(R.id.webb);
        pr = findViewById(R.id.progressBar);
        String url = getIntent().getStringExtra("Url");
        if(url.equals("https://www.whatsapp.com")){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }
       if(url.equals("https://Www.chrome.com")){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            if (launchIntent != null) {
                startActivity(launchIntent);           }
        }
       if(url.equals("https://www.youtube.com")){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }

        else if(url!="https://www.whatsapp.com" && url!="https://Www.chrome.com" && url!="https://www.youtube.com"){
        web.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pr.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pr.setVisibility(View.GONE);
            }
        });
        web.setWebChromeClient(new WebChromeClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(url);

    }
    }


}