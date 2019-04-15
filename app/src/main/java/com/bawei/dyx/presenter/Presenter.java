package com.bawei.dyx.presenter;

import com.bawei.dyx.imodel.Imodel;
import com.bawei.dyx.imodel.Model;
import com.bawei.dyx.iview.Iview;

public class Presenter implements Ipresenter {

    private Model model;
    private Iview iview;

    @Override
    public void attchView(Iview iview) {
        model = new Model();
        this.iview=iview;
    }

    @Override
    public void datechView() {
         if (iview!=null){
             iview=null;
         }
         if (model!=null){
             model=null;
         }
         System.gc();
    }

    @Override
    public void getData(String phone, String pwd) {
       model.Requestdata(phone, pwd, new Imodel.Callback() {
           @Override
           public void onSuccess(String data) {
               iview.getData(data);
           }

           @Override
           public void onFail(Exception e) {

           }
       });
    }


}
