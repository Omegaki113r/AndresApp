package com.omegaki113r.pksoftwaresolutions.andresapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeScreen extends AppCompatActivity {

    private WebView webView;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        webView = (WebView) findViewById(R.id.webView);
        pageLoad("https://www.andrejarrell.com",webView);


        tabLayout=findViewById(R.id.tb_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1:
                        pageLoad("https://andrejarrell.tumblr.com",webView);
                        break;
                    case 0:
                        pageLoad("https://www.andrejarrell.com",webView);
                        break;
                    case 2:
                        pageLoad("https://guides.andrejarrell.com",webView);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
