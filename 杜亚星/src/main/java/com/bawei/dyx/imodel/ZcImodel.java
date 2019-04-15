package com.bawei.dyx.imodel;

public interface ZcImodel {
    void  Requestdata(String phone, String pwd,String pwd1, Callback callback);
    interface  Callback{
        void onSuccess(String data);
        void onFail(Exception e);
    }
}
