package com.example.hp.androidbootstrap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BlankActivity extends AppCompatActivity {

    static int REQUEST_CODE=7;
    private ImageView imageView;
    private TextView textView;
    private String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_loader);
        imageView=(ImageView)findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BlankActivity.this,MainActivity.class));
    }
}
