package com.trials.projectmvvm;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PasienViewModel extends AndroidViewModel {
    private PasienRepo pasienRepo;
    private MutableLiveData<List<Pasien>> listPasien;

    public PasienViewModel(Application application){
        super(application);
        pasienRepo = new PasienRepo();
        listPasien = pasienRepo.requestPasien(application);
    }

    MutableLiveData<List<Pasien>> getAllPatient(){
        return listPasien;
    }
}
