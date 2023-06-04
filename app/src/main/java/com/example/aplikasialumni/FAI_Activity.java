package com.example.aplikasialumni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class FAI_Activity extends AppCompatActivity {
private EditText nama, nim, angkatan, lulus;
private Button btSimpan;
private RadioGroup Gradio;
private RadioButton Rlaki, Rperem;
private TextView output;
String Rhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fai);

        String[] type= new String[]{"Ilmu Al-Qur'an dan Tafsir", "Psikologi Islam", "Perbankan Syariah", "Hukum Keluarga Islam", "Komunikasi Penyiaran Islam", "Pendidikan Islam Anak Usia Dini"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.drop_down_items,type);

        AutoCompleteTextView prodi= findViewById(R.id.filled_exposed);
        prodi.setAdapter(adapter);

        nama = (EditText) findViewById(R.id.IDnama1);
        nim = (EditText) findViewById(R.id.IDnim1);
        angkatan = (EditText) findViewById(R.id.IDangkatan1);
        lulus = (EditText) findViewById(R.id.IDlulus1);
        Gradio = (RadioGroup) findViewById(R.id.radioGroup2);
        btSimpan = (Button) findViewById(R.id.btnSimpan1);
        output = (TextView) findViewById(R.id.output);


        Gradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int check) {
                if(check==R.id.laki){
                    Rhasil = "Laki-laki";
                }else{
                    Rhasil = "Perempuan";
                }
            }
        });
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(nama.getText().toString()))
                    Toast.makeText(getApplicationContext(),"nama Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(nim.getText().toString()))
                    Toast.makeText(getApplicationContext(),"NIM Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(angkatan.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Angkatan Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(lulus.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Tahun Lulus Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data terkirim",Toast.LENGTH_SHORT).show();
                    output.setText("Nama anda : " + nama.getText() + "\n" +"NIM Anda : " + nim.getText() + "\n"+"Kelamin Anda : " + Rhasil
                            + "\n"+"Prodi Anda : " + prodi.getText().toString() + "\n"+"Anda Angkatan : " + angkatan.getText() + "\n"+"Tahun Lulus Anda : " + lulus.getText());
            }

        });

    }
}