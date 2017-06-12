package com.zilingyao.core.dagger2;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建时间：2017/5/10
 * 编写人：qingfeng
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getContext();

}
