package com.trials.projectmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PasienViewModel pasienViewModel;
    private List<Pasien> listPasien;
    private PasienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pasienViewModel = new ViewModelProvider(this).get(PasienViewModel.class);
        ListView listView = findViewById(R.id.list);
        listPasien = new ArrayList<>();

        adapter = new PasienAdapter(this, android.R.layout.simple_list_item_1, listPasien);
        listView.setAdapter(adapter);
    }



    @Override
    protected void onStart() {
        super.onStart();
        pasienViewModel.getAllPatient().observe(this, new Observer<List<Pasien>>() {
            @Override
            public void onChanged(List<Pasien> pasiens) {
                listPasien.clear();
                listPasien.addAll(pasiens);
                adapter.notifyDataSetChanged();
            }
        });
    }
}