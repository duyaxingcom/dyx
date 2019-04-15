package com.bawei.dyx.presenter;

import com.bawei.dyx.iview.Iview;

public interface Zpresenter {
    void attchView(Iview iview);
    void datechView();
    void getData(String phone, String pwd,String pwd1);
}
