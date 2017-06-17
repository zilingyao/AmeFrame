package com.zilingyao.core.di.component;

import java.io.File;

import javax.inject.Singleton;

/**
 * 创建时间：2017/6/17
 * 编写人：qingfeng
 * 全局注射器
 *
 *  * 解释:
 * 另外一个名字注入器（Injector）
 * Component也是一个注解类，一个类要想是Component，必须用Component注解来标注该类，
 * 并且该类是接口或抽象类
 */
@Singleton
public interface AppComponent {

    //缓存文件根目录(RxCache和Glide的的缓存都已经作为子文件夹在这个目录里),应该将所有缓存放到这个根目录里,便于管理和清理,可在GlobeConfigModule里配置
    File cacheFile();


}
