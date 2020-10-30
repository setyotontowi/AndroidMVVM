package com.trials.projectmvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PasienAdapter extends ArrayAdapter<Pasien> {

    private final List<Pasien> pasiens;
    private final Context context;

    public PasienAdapter(@NonNull Context context, int resource, @NonNull List<Pasien> pasiens) {
        super(context, resource);
        this.pasiens = pasiens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pasiens.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pasien pasien = pasiens.get(position);
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            holder.textView = convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(pasien.getNama());
        return convertView;
    }

    public static final class ViewHolder{
        TextView textView;
    }

}
