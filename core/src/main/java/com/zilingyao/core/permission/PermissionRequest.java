package com.zilingyao.core.permission;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.zilingyao.core.permission.core.AndPermission;
import com.zilingyao.core.permission.core.PermissionNo;
import com.zilingyao.core.permission.core.PermissionYes;

import java.util.List;

/**
 * 创建时间：2017/5/17
 * 编写人：qingfeng
 */

public class PermissionRequest {
    private Context mContext;
    private PermissionCallback mCallback;

    public PermissionRequest(Context context, PermissionCallback callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    //请求储存权限
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void requestStorage() {
        AndPermission.with(mContext)
                .requestCode(110)
                .permission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .callback(this)
                .start();
    }

    @PermissionYes(110)
    public void storageYes(List<String> permissions) {
        this.mCallback.onSuccessful();
    }

    @PermissionNo(110)
    public void storageNo(List<String> permissions) {
        this.mCallback.onFailure();
    }


    public void requestPhoneState() {
        AndPermission.with(mContext)
                .requestCode(120)
                .permission(Manifest.permission.READ_PHONE_STATE)
                .callback(this)
                .start();
    }

    @PermissionYes(120)
    public void phoneStateYes(List<String> permissions) {
        this.mCallback.onSuccessful();
    }

    @PermissionNo(120)
    public void phoneStateNo(List<String> permissions) {
        this.mCallback.onFailure();
    }




    public interface PermissionCallback {
        void onSuccessful();

        void onFailure();
    }

}
