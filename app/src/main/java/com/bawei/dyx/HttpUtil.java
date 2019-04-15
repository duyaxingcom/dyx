package com.bawei.dyx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    //单列模式
    private HttpUtil(){};
    private  static  HttpUtil httpUtil;
      private static HttpUtil getInstance(){
           if (httpUtil==null){
               synchronized (HttpUtil.class){
                   if (httpUtil==null){
                       httpUtil=new HttpUtil();
                   }
               }
           }
         return null;
      }

    public  boolean isNet(Context context){
        if (context!=null){
            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return  false;
    }
    public static void postAsynTack(String strUrl, String phone, String pwd, final CallbackString callbackString){
          new AsyncTask<String, Integer, String>() {
              @Override
              protected String doInBackground(String... strings) {
                  return httpGet(strings[0]);
              }

              @Override
              protected void onPostExecute(String s) {
                  super.onPostExecute(s);
                 if (!TextUtils.isEmpty(s)){
                     callbackString.onSuccess(s);
                 }
                else {
                     callbackString.onshibai(504, "请求未找到");
                 }
              }
          }.execute(strUrl,phone,pwd);
    }
    public static void ZcpostAsynTack(String strUrl, String phone, String pwd,String pwd1, final CallbackString callbackString){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return httpGet(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (!TextUtils.isEmpty(s)){
                    callbackString.onSuccess(s);
                }
                else {
                    callbackString.onshibai(504, "请求未找到");
                }
            }
        }.execute(strUrl,phone,pwd);
    }
    public interface CallbackString{
        void onSuccess(String jsonBean);
        void onshibai(int result,String message);
    }
    public static String httpGet(String strUrl){
        try {
            URL url=new URL(strUrl);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            InputStream stream=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(stream,"utf-8"));
            StringBuilder builder=new StringBuilder();
            String str="";
            while((str=reader.readLine())!=null){
                builder.append(str);
            }
            connection.disconnect();
          return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
