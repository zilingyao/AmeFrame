package com.zilingyao.core.widget.autolayout;

import android.view.View;

import com.zhy.autolayout.utils.AutoUtils;
import com.zilingyao.core.quickadapter.BaseQuickAdapter;
import com.zilingyao.core.quickadapter.BaseViewHolder;

/**
 * 创建时间：2017/6/17
 * 编写人：qingfeng
 */
public class AutoBaseHolder extends BaseViewHolder{


    public AutoBaseHolder(View view) {
        super(view);
        AutoUtils.autoSize(view);
    }

    @Override
    protected BaseViewHolder setAdapter(BaseQuickAdapter adapter) {
        return super.setAdapter(adapter);
    }


}
