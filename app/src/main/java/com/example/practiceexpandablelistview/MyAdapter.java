package com.example.practiceexpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseExpandableListAdapter {
    List<String> mListMaker;
    List<List<String>> mListCar;
    Context mContext;

    MyAdapter(Context context, List<String> listMaker, List<List<String>> listCar) {
        mContext = context;
        mListMaker = listMaker;
        mListCar = listCar;
    }

    @Override
    public int getGroupCount() {
        return mListMaker.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mListCar.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return mListMaker.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mListCar.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item_makers_layout, viewGroup, false);

        TextView textView = view.findViewById(R.id.list_item_makers_name);
        textView.setText(mListMaker.get(i));

        ImageView imageView = view.findViewById(R.id.arrow);
        if (mListCar.get(i).size() != 0) {
            imageView.setImageResource(R.drawable.ic_under_arrow);
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item_cars_layout, viewGroup, false);

        TextView textView = view.findViewById(R.id.list_item_cars_name);
        textView.setText(mListCar.get(i).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
