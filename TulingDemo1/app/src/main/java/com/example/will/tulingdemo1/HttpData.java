package com.example.will.tulingdemo1;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Will on 2015/7/13.
 */
public class HttpData extends AsyncTask<String,Void,String> {

    private HttpClient myHttpClient;
    private HttpGet myHttpGet;
    private HttpResponse myHttpResponse;
    private HttpEntity myHttpEntity;
    private InputStream in;
    private HttpGetDateListener listener;


    private String  url;
    public HttpData(String url, HttpGetDateListener listener){
        this.url = url;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            myHttpClient = new DefaultHttpClient();
            myHttpGet = new HttpGet(url);
            myHttpResponse = myHttpClient.execute(myHttpGet);
            myHttpEntity = myHttpResponse.getEntity();
            in = myHttpEntity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();

        }catch (Exception e){
        }
        return null;
    }
    protected void onPostExecute(String result){
        listener.getDataUrl(result);
        super.onPostExecute(result);
    }
}
