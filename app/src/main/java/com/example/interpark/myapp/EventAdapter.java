package com.example.interpark.myapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            view.setOnClickListener(this);
            checkBox = view.findViewById(R.id.checkBox);
            textView.setOnClickListener(this);
            checkBox.setOnCheckedChangeListener(this);
        }

        public void setData() {
            Event event = arrayList.get(getAdapterPosition());
            textView.setText(event.getTitle());
            checkBox.setChecked(event.isChecked());
        }

        @Override
        public void onClick(View view) {
            Event event = arrayList.get(super.getAdapterPosition());
            String s = String.format("index: %d,  title: %s", super.getAdapterPosition(), event.getTitle());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            Event event = arrayList.get(super.getAdapterPosition());
            event.setChecked(isChecked);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Event> arrayList;

    public EventAdapter(Context context, ArrayList<Event> arrayList) {
        this.arrayList = arrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
