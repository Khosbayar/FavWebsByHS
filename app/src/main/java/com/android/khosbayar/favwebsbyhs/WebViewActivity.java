package com.android.khosbayar.favwebsbyhs;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.khosbayar.favwebsbyhs.model.WebLink;

public class WebViewActivity extends AppCompatActivity {


    private WebView mFavLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Bundle bundle = getIntent().getExtras();

        WebLink webLink = (WebLink) bundle.getParcelable("weblink");
        Log.i("WebViewActivity", webLink.getTitle());
        setTitle(webLink.getTitle());

        mFavLink = (WebView) findViewById(R.id.wvFavLinks);
        WebSettings webSettings = mFavLink.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        mFavLink.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(getApplicationContext(), "Page loading is started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "And here you are", Toast.LENGTH_SHORT).show();
            }
        });
        mFavLink.loadUrl(webLink.getLink());


    }
}
