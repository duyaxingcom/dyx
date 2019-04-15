package com.bawei.dyx.presenter;

import com.bawei.dyx.imodel.Imodel;
import com.bawei.dyx.imodel.Model;
import com.bawei.dyx.imodel.ZCModeld;
import com.bawei.dyx.imodel.ZcImodel;
import com.bawei.dyx.iview.Iview;

public class Zpresenterd implements Zpresenter {


    private ZCModeld modeld;
    private Iview iview;

    @Override
    public void attchView(Iview iview) {
        modeld = new ZCModeld();
        this.iview=iview;
    }

    @Override
    public void datechView() {
       if (iview!=null){
           iview=null;
       }
       if (modeld!=null){
           modeld=null;
       }
    }

    @Override
    public void getData(String phone, String pwd, String pwd1) {
     modeld.Requestdata(phone, pwd1, pwd1, new ZcImodel.Callback() {
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
