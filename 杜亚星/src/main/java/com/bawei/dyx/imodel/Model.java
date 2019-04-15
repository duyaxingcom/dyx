package com.bawei.dyx.imodel;

import com.bawei.dyx.HttpUtil;

public class Model implements Imodel {
    private  String url="http://172.17.8.100/small/user/v1/login";
    @Override
    public void Requestdata(String phone, String pwd, final Callback callback) {
     HttpUtil.getInstance().postAsynTack(url, phone, pwd, new HttpUtil.CallbackString() {
         @Override
         public void onSuccess(String jsonBean) {
             callback.onSuccess(jsonBean);
         }

         @Override
         public void onshibai(int result, String message) {

         }
     });
    }
}
