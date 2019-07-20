package com.stwalkerster.android.apps.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class web extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web = findViewById(R.id.webb);
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
        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(url);
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
    }
    }
}