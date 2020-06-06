package com.example.interpark.myapp;

import android.os.MemoryFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.ListIterator;

public class EventActivity extends AppCompatActivity {

    EventAdapter eventAdapter;
    ArrayList<Event> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        arrayList = new ArrayList<Event>();
        arrayList.add(new Event("OOO 만나기"));
        arrayList.add(new Event("과제하기"));

        eventAdapter = new EventAdapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(eventAdapter);

        Button btAdd = (Button) findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e = (EditText) findViewById(R.id.editText);
                String s = e.getText().toString();
                e.setText("");
                arrayList.add(new Event(s));
                eventAdapter.notifyDataSetChanged();
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_event, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_delete) {
//            ListIterator<Event> iterator = arrayList.listIterator();
//            while (iterator.hasNext()) {
//                if (iterator.next().isChecked())
//                    iterator.remove();
//            }
//            eventAdapter.notifyDataSetChanged();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


}
