package com.example.interpark.myapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public void setData(){
            Event event = arrayList.get(getAdapterPosition());
            textView.setText(event.getTitle());

        }

    }

    static LayoutInflater layoutInflater;
    static ArrayList<Event> arrayList;

    public EventAdapter(Context context, ArrayList<Event> arrayList){
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
