package com.zilingyao.core.dagger2;

import android.content.Context;

/**
 * 创建时间：2017/5/10
 * 编写人：qingfeng
 * 全局 注射器
 */

public class GlobalAppComponent {

    private volatile static ApplicationComponent mAppComponent;

    /**
     * 初始化全局AppComponent
     * @param context applicationContext
     */
    public static void init(Context context){
        if(mAppComponent == null){
            synchronized (GlobalAppComponent.class){
                if(mAppComponent == null){
                    mAppComponent = DaggerApplicationComponent.builder()
                            .applicationModule(new ApplicationModule(context.getApplicationContext()))
                            .build();
                }
            }
        }
    }

    public static ApplicationComponent getAppComponent() {
        if(mAppComponent == null){
            throw (new NullPointerException("GlobalAppComponent必须在application中进行init初始化"));
        }
        return mAppComponent;
    }
}
