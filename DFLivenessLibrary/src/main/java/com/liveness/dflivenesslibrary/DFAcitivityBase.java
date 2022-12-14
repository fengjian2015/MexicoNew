package com.liveness.dflivenesslibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.liveness.dflivenesslibrary.callback.DFLivenessErrorInterface;
import com.liveness.dflivenesslibrary.fragment.DFProductFragmentBase;
import com.liveness.dflivenesslibrary.utils.StatusBarCompat;

@SuppressLint("NewApi")
public abstract class DFAcitivityBase extends Activity implements DFLivenessErrorInterface {
    private static final String TAG = "DFAcitivityBase";
    /**
     * No permission to access camera
     */
    public static final int RESULT_CAMERA_ERROR_NOPRERMISSION_OR_USED = 2;
    public static final int RESULT_BACK_PRESSED = 3;

    public static final String KEY_RESULT_ERROR_CODE = "key_result_error_code";

    protected DFProductFragmentBase mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_activity_main);
//        initBaseView();
        mFragment = getFrament();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, mFragment);
        fragmentTransaction.commit();
        StatusBarCompat.translucentStatusBar(this, false);
    }

    protected abstract DFProductFragmentBase getFrament();

    private void initBaseView() {
        findViewById(R.id.id_ll_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onErrorHappen(RESULT_BACK_PRESSED);
            }
        });
    }

    protected String getActivityTitle() {
        return "";
    }

    @Override
    public void onBackPressed() {
        onErrorHappen(RESULT_BACK_PRESSED);
    }

    @Override
    public void onErrorHappen(int errorCode) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        intent.putExtra(KEY_RESULT_ERROR_CODE, errorCode);
        finish();
    }

}
