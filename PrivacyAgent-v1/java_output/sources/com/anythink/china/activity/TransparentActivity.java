package com.anythink.china.activity;

/* loaded from: classes29.dex */
public class TransparentActivity extends android.app.Activity {
    public static final java.lang.String a = "type";
    public static final java.lang.String b = "request_code";
    public static final int c = 1000;
    public static final java.lang.String d = "permission_list";
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.anythink.china.common.d.a> e = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        if (intent.getIntExtra("type", 0) == 1000) {
            androidx.core.app.ActivityCompat.requestPermissions(this, intent.getStringArrayExtra(d), intent.getIntExtra(b, 0));
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.anythink.china.common.d.a> concurrentHashMap = e;
        if (concurrentHashMap.get(java.lang.Integer.valueOf(i)) != null) {
            concurrentHashMap.remove(java.lang.Integer.valueOf(i));
        }
        finish();
    }
}
