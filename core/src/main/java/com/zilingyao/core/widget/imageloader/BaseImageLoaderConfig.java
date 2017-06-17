package com.zilingyao.core.widget.imageloader;

import android.content.Context;

/**
 * 创建时间：2017/6/17
 * 编写人：qingfeng
 * 加载框架 基类接口
 */

public interface BaseImageLoaderConfig<T extends ImageConfig> {
    void loadImage(Context ctx, T config);
    void clear(Context ctx, T config);
}
