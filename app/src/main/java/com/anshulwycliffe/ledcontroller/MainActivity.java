package com.anshulwycliffe.ledcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        webView = findViewById(R.id.webView);
        cardView = findViewById(R.id.cardView);

        EditText ipAddress = findViewById(R.id.ip_box);
        Button continuebtn = findViewById(R.id.continueBtn);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ipAddress.getText().toString();
                if(text.isEmpty()){
                    Toast.makeText(MainActivity.this, "Address Cannot Be Empty", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Processing", Toast.LENGTH_SHORT).show();
                    cardView.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(text);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(webView.getVisibility() == View.VISIBLE){
            webView.setVisibility(View.GONE);
            cardView.setVisibility(View.VISIBLE);
        }else{
            super.onBackPressed();
        }

    }
}