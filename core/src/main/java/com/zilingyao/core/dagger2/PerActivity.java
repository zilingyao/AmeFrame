package com.zilingyao.core.dagger2;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 创建时间：2017/5/10
 * 编写人：qingfeng
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
