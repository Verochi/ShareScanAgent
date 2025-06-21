package com.aliyun.svideo.base.ui;

/* loaded from: classes29.dex */
public class SdkVersionActivity extends androidx.appcompat.app.AppCompatActivity {
    public static java.lang.String DEBUG_DEVELOP_URL = "debug_develop_url";
    public static java.lang.String DEBUG_PARAMS = "DebugParams";

    /* renamed from: com.aliyun.svideo.base.ui.SdkVersionActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ android.widget.RadioButton val$developRadioButton;
        final /* synthetic */ android.widget.RadioButton val$prereleaseRadioButton;

        public AnonymousClass1(android.widget.RadioButton radioButton, android.widget.RadioButton radioButton2) {
            this.val$developRadioButton = radioButton;
            this.val$prereleaseRadioButton = radioButton2;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.base.ui.SdkVersionActivity.this.setLicenseDebugParams(this.val$developRadioButton.isChecked() ? 1 : this.val$prereleaseRadioButton.isChecked() ? 2 : 0);
            android.widget.Toast.makeText(com.aliyun.svideo.base.ui.SdkVersionActivity.this, "设置成功", 0).show();
            com.aliyun.svideo.base.ui.SdkVersionActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private int getIntValue(java.lang.String str) {
        return getSharedPreferences(DEBUG_PARAMS, 0).getInt(str, 0);
    }

    private void initDebugParams() {
        android.widget.RadioButton radioButton = (android.widget.RadioButton) findViewById(com.aliyun.svideo.base.R.id.btn_develop_url);
        android.widget.RadioButton radioButton2 = (android.widget.RadioButton) findViewById(com.aliyun.svideo.base.R.id.btn_pre_release_url);
        android.widget.RadioButton radioButton3 = (android.widget.RadioButton) findViewById(com.aliyun.svideo.base.R.id.btn_release_url);
        int intValue = getIntValue(DEBUG_DEVELOP_URL);
        if (intValue == 1) {
            radioButton.setChecked(true);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
        } else if (intValue == 2) {
            radioButton.setChecked(false);
            radioButton2.setChecked(true);
            radioButton3.setChecked(false);
        } else {
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(true);
        }
        findViewById(com.aliyun.svideo.base.R.id.btn_sure).setOnClickListener(new com.aliyun.svideo.base.ui.SdkVersionActivity.AnonymousClass1(radioButton, radioButton2));
    }

    @android.annotation.SuppressLint({"SetTextI18n"})
    private void showVersionInfo() {
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_version)).setText("VERSION :3.32.1");
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_module)).setText("MODULE :svideo_pro");
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_build_id)).setText("BUILD_ID :15462250");
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_src_commit_id)).setText("SRC_COMMIT_ID :0");
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_alivc_commit_id)).setText("ALIVC_COMMIT_ID :8bb55f7");
        ((android.widget.TextView) findViewById(com.aliyun.svideo.base.R.id.tv_android_commit_id)).setText("ANDROID_COMMIT_ID :2d04d4b");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.base.R.layout.activity_sdk_version);
        showVersionInfo();
        initDebugParams();
    }

    public void setLicenseDebugParams(int i) {
        android.content.SharedPreferences.Editor edit = getSharedPreferences(DEBUG_PARAMS, 0).edit();
        edit.putInt(DEBUG_DEVELOP_URL, i);
        edit.apply();
    }
}
