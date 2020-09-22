package com.trials.projectmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PasienViewModel pasienViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pasienViewModel = new ViewModelProvider(this).get(PasienViewModel.class);

        pasienViewModel.getAllPatient().observe(this, new Observer<List<Pasien>>() {
            @Override
            public void onChanged(List<Pasien> pasiens) {
                for(Pasien pasien: pasiens){
                    System.out.println(pasien.toString());
                }
            }
        });
    }
}