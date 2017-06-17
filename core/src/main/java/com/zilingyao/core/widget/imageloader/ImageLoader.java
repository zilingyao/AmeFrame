package com.zilingyao.core.widget.imageloader;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jess on 8/5/16 15:57
 * contact with jess.yan.effort@gmail.com
 */
@Singleton
public final class ImageLoader {
    private BaseImageLoaderConfig mStrategy;

    @Inject
    public ImageLoader(BaseImageLoaderConfig strategy) {
        setLoadImgStrategy(strategy);
    }


    public <T extends ImageConfig> void loadImage(Context context, T config) {
        this.mStrategy.loadImage(context, config);
    }

    public <T extends ImageConfig> void clear(Context context, T config) {
        this.mStrategy.clear(context, config);
    }


    public void setLoadImgStrategy(BaseImageLoaderConfig strategy) {
        this.mStrategy = strategy;
    }

}
