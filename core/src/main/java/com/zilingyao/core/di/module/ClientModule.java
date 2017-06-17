package com.zilingyao.core.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 创建时间：2017/6/17
 * 编写人：qingfeng
 * 提供网络框架 等相关配置
 */

@Module
public class ClientModule {

    private static final int TIME_OUT = 10;

    /**
     * 提供retrofit
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(Application application,
                             @Nullable RetrofitConfiguration configuration,
                             Retrofit.Builder builder,
                             OkHttpClient client,
                             HttpUrl httpUrl) {

        builder.baseUrl(httpUrl)//域名
                .client(client)//设置okhttp
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create());//使用Gson

        if (configuration != null)
            configuration.configRetrofit(application, builder);
        return builder.build();
    }



    /**
     * 提供OkhttpClient
     */
    @Singleton
    @Provides
    OkHttpClient provideClient(Application application,
                               @Nullable OkhttpConfiguration configuration,
                               OkHttpClient.Builder builder,
                               Interceptor intercept
            , @Nullable List<Interceptor> interceptors
//            , @Nullable GlobalHttpHandler handler
    ) {
        //设置超时时间  拦截器
        builder .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(intercept);

//      if (handler != null)
//            builder.addInterceptor(chain -> chain.proceed(handler.onHttpRequestBefore(chain, chain.request())));

        if (interceptors != null) {//如果外部提供了interceptor的集合则遍历添加
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        if (configuration != null)
            configuration.configOkhttp(application, builder);
        return builder.build();
    }


    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }

//    @Singleton
//    @Provides
//    Interceptor provideInterceptor(RequestInterceptor intercept) {
//        return intercept;//打印请求信息的拦截器
//    }



    public interface RetrofitConfiguration {
        void configRetrofit(Context context, Retrofit.Builder builder);
    }
    public interface OkhttpConfiguration {
        void configOkhttp(Context context, OkHttpClient.Builder builder);
    }



}
