/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zilingyao.core.permission.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

/**
 * <p>Request permission.</p>
 * Created by Yan Zhenjie on 2017/4/27.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public final class PermissionActivity extends Activity {

    static final String KEY_INPUT_PERMISSIONS = "KEY_INPUT_PERMISSIONS";

    private static PermissionListener mPermissionListener;

    public static void setPermissionListener(PermissionListener permissionListener) {
        mPermissionListener = permissionListener;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String[] permissions = intent.getStringArrayExtra(KEY_INPUT_PERMISSIONS);
        if (mPermissionListener == null || permissions == null)
            finish();
        else
            requestPermissions(permissions, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mPermissionListener != null)
            mPermissionListener.onRequestPermissionsResult(permissions, grantResults);
        finish();
    }

    interface PermissionListener {
        void onRequestPermissionsResult(@NonNull String[] permissions, @NonNull int[] grantResults);
    }
}
