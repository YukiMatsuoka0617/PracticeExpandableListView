package com.example.practiceexpandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ExpandableListView.OnGroupClickListener,
        ExpandableListView.OnChildClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> makers = getParentList();

        List<List<String>> cars = getChileList();

        ExpandableListView expandableListView = findViewById(R.id.expandable_list_view);
        MyAdapter adapter = new MyAdapter(this, makers, cars);

        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(this);
        expandableListView.setOnGroupClickListener(this);

    }

    List<String> getParentList(){
        List<String> makers = new ArrayList<>();
        makers.add("TOYOTA");
        makers.add("MAZDA");
        makers.add("HONDA");
        return makers;
    }

    List<List<String>> getChileList(){
        List<String> cars_toyota = new ArrayList<>();
        cars_toyota.add("CROWN");
        cars_toyota.add("PRIUS");
        cars_toyota.add("COROLLA");
        cars_toyota.add("VITZ");
        List<String> cars_mazda = new ArrayList<>();
        cars_mazda.add("ATENZA");
        cars_mazda.add("AXELA");
        cars_mazda.add("DEMIO");
        List<String> cars_honda = new ArrayList<>();
//        cars_honda.add("LEGEND");
//        cars_honda.add("CIVIC");
//        cars_honda.add("FIT");
        List<List<String>> cars = new ArrayList<>();
        cars.add(cars_toyota);
        cars.add(cars_mazda);
        cars.add(cars_honda);
        return cars;
    }

    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
        MyAdapter adapter = (MyAdapter) expandableListView.getExpandableListAdapter();
        if(adapter.getChildrenCount(i) == 0){
            String makerName =  (String)adapter.getGroup(i);
            Toast.makeText(getApplicationContext(), makerName , Toast.LENGTH_SHORT).show();
        } else{
            //do nothing
        }
        return false;
    }

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
        MyAdapter adapter = (MyAdapter) expandableListView.getExpandableListAdapter();
        String makerName =  (String)adapter.getGroup(i);
        String carName = (String)adapter.getChild(i, i1);
        Toast.makeText(getApplicationContext(), makerName + " : " + carName, Toast.LENGTH_SHORT).show();
        return false;
    }


}