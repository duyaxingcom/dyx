package com.bawei.dyx.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author：Lenovo
 * @E-mail：
 * @Date：2019/2/15 19:33
 * @Description：描述信息
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(), container, false);

    }
    protected abstract int bindLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initData();
        bindEvent();
    }
    protected  abstract  void  initView();
    protected  abstract  void  initData();
    protected  abstract  void  bindEvent();
     protected <T extends View> T bindView(int relsd){
         return (T) getView().findViewById(relsd);
     }
}
