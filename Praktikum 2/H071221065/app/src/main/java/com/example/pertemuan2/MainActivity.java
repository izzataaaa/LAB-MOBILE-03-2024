package com.example.pertemuan2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mengambil konten
        ImageView foto = findViewById(R.id.image);
        EditText input_nama = findViewById(R.id.editTextText1);
        EditText input_username = findViewById(R.id.editTextText2);
        Button tombol = findViewById(R.id.button);


//        tangani hasil dari memilih gambar                   untuk menerima hasil dri akt lain(pilih gambar dari galeri)
        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        image = data.getData();
                        foto.setImageURI(image);
                    }
                }
        );

//        menginten ke open galeri
        foto.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = input_nama.getText().toString();
                String username = input_username.getText().toString();

                if(!nama.isEmpty() && !username.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", nama);
                    intent.putExtra("user", username);

                    if(image != null){
                        intent.putExtra("image", image.toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Harap isi gambar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Harap isi kedua kolom", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}