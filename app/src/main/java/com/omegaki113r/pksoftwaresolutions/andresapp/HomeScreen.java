package com.omegaki113r.pksoftwaresolutions.andresapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeScreen extends AppCompatActivity {

    private WebView webView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.terraria:
                    pageLoad("http://blog.andrejarrell.com",webView);
                    return true;
                case R.id.dontstarve:
                    pageLoad("https://www.andrejarrell.com",webView);
                    return true;
                case R.id.minecraft:
                    pageLoad("https://guides.andrejarrell.com",webView);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
/*
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-6784086459955376~4905536420");
        AdView adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
*/
        webView = (WebView) findViewById(R.id.webView);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        pageLoad("https://www.andrejarrell.com",webView);


    }


    private void pageLoad(String url,WebView web){
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        webView.onPause();
    }

}
