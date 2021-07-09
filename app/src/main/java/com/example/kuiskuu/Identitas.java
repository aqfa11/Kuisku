package com.example.kuiskuu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Identitas extends AppCompatActivity {
//    button untuk mengeklik page berikutnya
    Button btnKerjakan;
//    text nama
    EditText ednama, ednim;

    String nama, nim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);

//        memanggil
        btnKerjakan = findViewById(R.id.btnmasuk);
        ednama = findViewById(R.id.isinama);
        ednim = findViewById(R.id.isinim);

        btnKerjakan.setOnClickListener(new View.OnClickListener() {
            String nama, nim;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
//                nama = "aqfa";
//                nim = "090";
//
//                nama = ednama.getText().toString();
//                nim = ednim.getText().toString();
//
//                if (nama.equals(nama) && nim.equals(nim)) {
//                    Toast benar2 = Toast.makeText(getApplicationContext(),
//                            "Login BERHASIL", Toast.LENGTH_LONG);
//                    benar2.show();
//                } else if (nama.equals(nama)) {
//                    Toast namabenar = Toast.makeText(getApplicationContext(),
//                            "nim SALAH", Toast.LENGTH_LONG);
//                    namabenar.show();
//                } else if (nim.equals(nim)) {
//                    Toast nimbenar = Toast.makeText(getApplicationContext(),
//                            "nama SALAH", Toast.LENGTH_LONG);
//                    nimbenar.show();
//                } else {
//                    Toast semuasalah = Toast.makeText(getApplicationContext(),
//                            "nama dan nim", Toast.LENGTH_LONG);
//                    semuasalah.show();
//                }

//                Toast t =Toast.makeText(getApplicationContext(),
//                        "E-Mail anda: " + nama +" dan Password anda: "+password,Toast.LENGTH_LONG);
//                t.show();
            }
        });


    }
}
