package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText Note1 = findViewById(R.id.note1);
        EditText Note2 = findViewById(R.id.note2);
        Button btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String image = getIntent().getStringExtra("image");
                String name = getIntent().getStringExtra("name");
                String username = getIntent().getStringExtra("user");
                String nt1 = Note1.getText().toString();
                String nt2 = Note2.getText().toString();

                if (!nt1.isEmpty() && !nt2.isEmpty()) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("image", image);
                    intent.putExtra("name", name);
                    intent.putExtra("user",username);
                    intent.putExtra("NOTE1", nt1);
                    intent.putExtra("NOTE2", nt2);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "Harap isi kedua kolom", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}