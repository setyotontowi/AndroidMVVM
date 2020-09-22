package com.trials.projectmvvm;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PasienRepo {
    private List<Pasien> listPasien;
    private final String TAG = getClass().getSimpleName();

    PasienRepo(){

    }

    public MutableLiveData<List<Pasien>> requestPasien(Application application) {
        final MutableLiveData<List<Pasien>> mutableLiveData = new MutableLiveData<>();
        String url = "https://my-json-server.typicode.com/setyotontowi/edoc_db/pasien";
        listPasien = new ArrayList<>();
        // Volley
        RequestQueue requestQueue = Volley.newRequestQueue(application.getApplicationContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                // Proses Volley
                int i = 0;
                //Parsing JSON
                while(i < response.length()) {
                    try {
                        JSONObject json = response.getJSONObject(i);

                        String nama = json.getString("nama");
                        String noRM = json.getString("no_rm");
                        String tanggalLahir = json.getString("tanggal_lahir");
                        String clinic = json.getString("poli");
                        Date tl = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(tanggalLahir);

                        Pasien pasien = new Pasien(nama, noRM, clinic, tl);
                        Log.e("Data Pasien", pasien.getNama() + " : " + pasien.getClinic());

                        listPasien.add(pasien);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    i++;
                } //End While

                mutableLiveData.setValue(listPasien);

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: "+error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);

        return mutableLiveData;
    }
}
