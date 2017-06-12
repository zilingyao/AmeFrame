package com.zilingyao.core.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * 创建时间：2017/5/10
 * 编写人：qingfeng
 * 全局module
 */

@Module
public class ApplicationModule {
    private final Context mContext;
    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

}
