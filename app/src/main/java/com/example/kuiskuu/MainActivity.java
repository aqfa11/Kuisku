package com.example.kuiskuu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
//    adalah pilihan untuk mengeklik jawaban yang benar
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
//    memampilakn hasil soal,jumlah benarnya ,dan juamlah salahnya
    public static int hasil, benar, salah;

    //pertanyaan di kelompokan menjadi satu
    String[] pertanyaan_kuis = new String[]{
            "1. Ctrl+P adalah shortcut untuk memunculkan dialog....",
            "2. Rukun Islam ada ?",
            "3. Ibukota Indonesia adalah",
            "4. Virus Corona muncul di Indonesia mulai tahun?",
            "5. Bendera Negara Indonesia adalah"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Print", "Customize", "Heater", "Page setup",
            "2", "3", "4", "5",
            "Jakarta", "Bogor", "Tangerang", "Bekasi",
            "2021", "2020", "2019", "2018",
            "Merah Biru Putih", "Merah Putih", "Putih Merah", "Belang-belang"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "Print",
            "5",
            "Jakarta",
            "2019",
            "Merah Putih"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        untuk mejalankan perintah
        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), com.example.kuiskuu.HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Kamu Jawab Dulu",Toast.LENGTH_LONG).show();
        }
    }
}
