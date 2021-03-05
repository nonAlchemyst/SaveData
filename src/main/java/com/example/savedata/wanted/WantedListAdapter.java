package com.example.savedata.wanted;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.savedata.R;

public class WantedListAdapter extends ArrayAdapter {

    int resource;
    WantedResponseData[] data;

    public WantedListAdapter(@NonNull Context context, int resource, @NonNull WantedResponseData[] data) {
        super(context, resource, data);
        this.data = data;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(resource, null);
        }
        TextView id = convertView.findViewById(R.id.id);
        id.setText(data[position].id);
        TextView detective = convertView.findViewById(R.id.Detective);
        detective.setText(data[position].detective);
        TextView createDate = convertView.findViewById(R.id.create_date);
        createDate.setText(data[position].create_date);
        TextView description = convertView.findViewById(R.id.criminal_description);
        description.setText(data[position].description);

        return convertView;
    }
}
