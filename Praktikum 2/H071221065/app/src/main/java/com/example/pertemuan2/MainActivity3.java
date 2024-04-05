package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView1 = findViewById(R.id.Text1);
        textView1.setText(getIntent().getStringExtra("name"));

        TextView textView2 = findViewById(R.id.Text2);
        textView2.setText(getIntent().getStringExtra("user"));

        TextView textView3 = findViewById(R.id.Text3);
        textView3.setText(getIntent().getStringExtra("NOTE1"));

        TextView textView4 = findViewById(R.id.Text4);
        textView4.setText(getIntent().getStringExtra("NOTE2"));

        ImageView imageView = findViewById(R.id.imageView2);
        String imageUriString = getIntent().getStringExtra("image");


//    memastikan lagi klo terinput gambarnya/ harus ada gambar
        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            imageView.setImageURI(imageUri);
        }


    }
}