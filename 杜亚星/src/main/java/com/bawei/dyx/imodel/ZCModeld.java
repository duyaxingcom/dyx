package com.bawei.dyx.imodel;

import com.bawei.dyx.HttpUtil;

public class ZCModeld implements ZcImodel {
    private  String Zcurl="http://172.17.8.100/small/user/v1/register";


    @Override
    public void Requestdata(String phone, String pwd, String pwd1, final Callback callback) {
          HttpUtil.ZcpostAsynTack(Zcurl, phone, pwd, pwd1, new HttpUtil.CallbackString() {
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
