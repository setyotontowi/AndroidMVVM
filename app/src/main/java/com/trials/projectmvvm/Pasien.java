package com.trials.projectmvvm;

import java.util.Date;

public class Pasien {
    private String nama;
    private String noRM;
    private String clinic;
    private Date tangggalLahir;

    public Pasien(String nama, String noRM, String clinic, Date tangggalLahir) {
        this.nama = nama;
        this.noRM = noRM;
        this.clinic = clinic;
        this.tangggalLahir = tangggalLahir;
    }

    public String getNama() {
        return nama;
    }

    public String getNoRM() {
        return noRM;
    }

    public String getClinic() {
        return clinic;
    }

    public Date getTangggalLahir() {
        return tangggalLahir;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoRM(String noRM) {
        this.noRM = noRM;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public void setTangggalLahir(Date tangggalLahir) {
        this.tangggalLahir = tangggalLahir;
    }
}
