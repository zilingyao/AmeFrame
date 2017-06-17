package com.zilingyao.uimodule;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 创建时间：2017/6/14
 * 编写人：qingfeng
 */

public class WidgetFragment extends Fragment {

    @BindView(R2.id.button)
    Button mButton;
    @BindView(R2.id.button2)
    Button mButton2;
    @BindView(R2.id.button3)
    Button mButton3;
    @BindView(R2.id.button4)
    Button mButton4;
    @BindView(R2.id.button5)
    Button mButton5;
    Unbinder unbinder;

    public static WidgetFragment newInstance() {
        return new WidgetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ui, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R2.id.button, R2.id.button2, R2.id.button3, R2.id.button4, R2.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R2.id.button:
                break;
            case R2.id.button2:
                break;
            case R2.id.button3:
                break;
            case R2.id.button4:
                break;
            case R2.id.button5:
                break;
        }
    }
}
