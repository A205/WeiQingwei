package com.example.will.tulingdemo1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.TypeVariable;
import java.util.List;

public class TextAdapter extends BaseAdapter{
    private List<ListData> lists;
    private Context myContext;
    RelativeLayout layoout;

    public  TextAdapter(List<ListData> lists, Context myContext){
        this.lists = lists;
        this.myContext = myContext;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        if(lists.get(position).getFlag()==ListData.RECEIVER ){
            layoout = (RelativeLayout)inflater.inflate(R.layout.leftiem,null);
        }else  if(lists.get(position).getFlag()==ListData.SEND ){
            layoout = (RelativeLayout)inflater.inflate(R.layout.rightitem,null);
        }
        TextView tv = (TextView)layoout.findViewById(R.id.tv);
        TextView time = (TextView)layoout.findViewById(R.id.time);
        tv.setText(lists.get(position).getContent());
        time.setText(lists.get(position).getTime());

        return layoout;
    }

}
