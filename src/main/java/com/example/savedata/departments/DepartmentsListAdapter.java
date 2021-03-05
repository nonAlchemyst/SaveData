package com.example.savedata.departments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.savedata.R;

public class DepartmentsListAdapter extends ArrayAdapter {

    DepartmentResponseData[] data;
    Context context;
    int resource;


    public DepartmentsListAdapter(@NonNull Context context, int resource, @NonNull DepartmentResponseData[] data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(resource, null);
        }
        TextView id = convertView.findViewById(R.id.id);
        id.setText(data[position].id);
        TextView address = convertView.findViewById(R.id.address);
        address.setText(data[position].address);
        TextView name = convertView.findViewById(R.id.name);
        name.setText(data[position].name);
        TextView boss = convertView.findViewById(R.id.boss);
        boss.setText(data[position].boss);
        TextView phone = convertView.findViewById(R.id.phone);
        phone.setText(data[position].phone);
        TextView email = convertView.findViewById(R.id.email);
        email.setText(data[position].email);
        TextView description = convertView.findViewById(R.id.description);
        description.setText(data[position].description);
        TextView coords = convertView.findViewById(R.id.coords);
        coords.setText(data[position].coords);

        return convertView;
    }
}
