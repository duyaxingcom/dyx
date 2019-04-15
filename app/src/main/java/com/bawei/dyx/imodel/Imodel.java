package com.bawei.dyx.imodel;

import javax.security.auth.callback.Callback;

public interface Imodel {
    void  Requestdata(String phone,String pwd,Callback callback);
    interface  Callback{
        void onSuccess(String data);
        void onFail(Exception e);
    }
}
