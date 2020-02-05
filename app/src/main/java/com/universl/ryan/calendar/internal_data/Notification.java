package com.universl.ryan.calendar.internal_data;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universl.ryan.calendar.R;

import java.util.ArrayList;

public class Notification extends BaseAdapter {

    private Activity context;
    private ArrayList<Details> alCustom;


    public Notification(Activity context, ArrayList<Details> alCustom) {
        this.context = context;
        this.alCustom = alCustom;

    }

    @Override
    public int getCount() {
        return alCustom.size();

    }

    @Override
    public Object getItem(int i) {
        return alCustom.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View listViewItem = inflater.inflate(R.layout.details_adapter, null, true);

        TextView tvTitle = listViewItem.findViewById(R.id.title);
        TextView month = listViewItem.findViewById(R.id.month);

        tvTitle.setText(alCustom.get(position).getTitles());
        month.setText(alCustom.get(position).getDescripts());
        return  listViewItem;
    }
}
