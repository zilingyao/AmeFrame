package com.zilingyao.ameframe;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zilingyao.core.permission.PermissionRequest;
import com.zilingyao.uimodule.widget.colorsnackbar.Prompt;
import com.zilingyao.uimodule.widget.colorsnackbar.TSnackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.test)
    Button mTest;
    @BindView(R.id.permission)
    Button mPermission;
    private TSnackbar snackBar;

    private PermissionRequest permissionRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        permissionRequest = new PermissionRequest(this, new PermissionRequest.PermissionCallback() {
            @Override
            public void onSuccessful() {
                Toast.makeText(MainActivity.this, "成功修改", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure() {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_LONG).show();

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.test, R.id.permission})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.test:
                final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content).getRootView();
                TSnackbar.make(viewGroup, "成功...", TSnackbar.LENGTH_LONG, TSnackbar.APPEAR_FROM_TOP_TO_DOWN)
                        .setPromptThemBackground(Prompt.ERROR)
                        .show();
                break;
            case R.id.permission:
                permissionRequest.requestStorage();

                break;
        }
    }


}
