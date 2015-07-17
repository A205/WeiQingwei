package com.example.will.tulingdemo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.String;


import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.logging.SimpleFormatter;

import android.view.View;


public class mainActivity extends ActionBarActivity implements  HttpGetDateListener,View.OnClickListener {

    private  HttpData httpData;
    private List<ListData> lists;
    private ListView lv;
    private EditText sendText;
    private Button sendBtn;
    private String content_str;
    private  TextAdapter adapter;
    String[] welcomeArray;
    private double currentTime,oldTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Intent intent = new Intent(mainActivity.this,FirstPage.class);
       // startActivity(intent);
        initView();
    }
    private void initView(){
        lv = (ListView)findViewById(R.id.lv);
        sendBtn = (Button)findViewById(R.id.sendBtn);
        sendText = (EditText)findViewById(R.id.sendText);
        lists = new ArrayList<ListData>();
        sendBtn.setOnClickListener(this);
        adapter = new TextAdapter(lists,this);
        lv.setAdapter(adapter);
        ListData listData = new ListData(getRandomWelcomeTips(),ListData.RECEIVER,getTiem());
        lists.add(listData);
    }


    private String getRandomWelcomeTips(){
        String welcomeTips = null;
        welcomeArray = this.getResources().getStringArray(R.array.welcome_tips);
        int index = (int)(Math.random()*(welcomeArray.length-1));
        welcomeTips = welcomeArray[index];
        return welcomeTips;
    }

    public void getDataUrl(String data){
        System.out.println(data);
        parseText(data);
    }
    public void parseText(String str){
        try{
            JSONObject jb = new JSONObject(str);
            ListData listData;
            listData = new ListData(jb.getString("text"),ListData.RECEIVER,getTiem());
            lists.add(listData);
            adapter.notifyDataSetChanged();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        content_str = sendText.getText().toString();
        String dropk =content_str.replace(" ","");
        String droph = dropk.replace("\n","");
        if (droph.length() == 0){
            sendText.setHint("输入不能为空");

            //try{Thread.sleep(10000);/*sendText.setText("");*/}catch (Exception e){}

        }else {
            sendText.setText(null);
            ListData listData;
            listData = new ListData(content_str, ListData.SEND, getTiem());
            lists.add(listData);
            adapter.notifyDataSetChanged();
            httpData = (HttpData) new HttpData(
                    "http://www.tuling123.com/openapi/api?key=75363d7baa3f205fc25a902cb0ac518a&info=" + droph
                    , this).execute();
        }
    }
    private  String getTiem(){
        currentTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss");
        Date cdata = new Date();
        String str = format.format(cdata);
        if(currentTime-oldTime >1*60*1000 ){
            oldTime = currentTime;
            return str;
        }else {
            return "";
        }

    }
}
