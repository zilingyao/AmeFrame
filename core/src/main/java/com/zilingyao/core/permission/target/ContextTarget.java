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
package com.zilingyao.core.permission.target;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * <p>Context Wrapper.</p>
 * Created by Yan Zhenjie on 2017/5/1.
 */
public class ContextTarget implements Target {

    private Context mContext;

    public ContextTarget(Context context) {
        this.mContext = context;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public boolean shouldShowRationalePermissions(@NonNull String... permissions) {
        return false;
    }

    @Override
    public void startActivity(Intent intent) {
        mContext.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        mContext.startActivity(intent);
    }
}
