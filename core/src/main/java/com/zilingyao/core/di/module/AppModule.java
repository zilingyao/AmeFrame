package com.zilingyao.core.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 创建时间：2017/6/17
 * 编写人：qingfeng
 * 需要Module注解   Module其实是一个简单工厂模式，Module里面的方法基本都是创建类实例的方法。
 *
 * 解释:
 * 首先我们需要明确一个点，就是Module的作用是用来提供生成依赖对象的，
 * 比如我要注入DaggerPresenter，那么这个Module的作用就是需要生成一个DaggerPresenter的对象，
 * 来让Dagger2注入到DaggerActivity中。
 *
 * 简而言之 就是生成对象给dagger注入
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

//    Module中的创建类实例方法用Provides进行标注，
//    Component在搜索到目标类中用Inject注解标注的属性后，
//    Component就会去Module中去查找用Provides标注的对应的创建类实例方法，
//    这样就可以解决第三方类库用dagger2实现依赖注入了。

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }



}
