package com.example.aplikasialumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] type= new String[]{"Fakulitas Ilmu Eksakta", "Fakulitas Agama Islam", "Fakultas Ilmu Sosial dan Pendidikan"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.drop_down_items,type);

        AutoCompleteTextView fakulitas= findViewById(R.id.filled_exposed);
        fakulitas.setAdapter(adapter);

        fakulitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,fakulitas.getText().toString(),Toast.LENGTH_SHORT).show();
                if (i==0){
                    startActivity(new Intent(MainActivity.this,FIE_Activity.class));
                }else if (i==1){
                    startActivity(new Intent(MainActivity.this,FAI_Activity.class));
                }else if (i==2){
                    startActivity(new Intent(MainActivity.this,FIPS_Activity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"MOHON PILIH DENGAN BIJAK!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}