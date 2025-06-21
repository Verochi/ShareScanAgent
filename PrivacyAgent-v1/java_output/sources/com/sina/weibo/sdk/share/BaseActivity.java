package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public class BaseActivity extends android.app.Activity {
    private boolean l() {
        java.lang.Exception e;
        boolean z;
        java.lang.reflect.Method method;
        try {
            android.content.res.TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) java.lang.Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = android.content.pm.ActivityInfo.class.getMethod("isTranslucentOrFloating", android.content.res.TypedArray.class);
            method.setAccessible(true);
            z = ((java.lang.Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (java.lang.Exception e2) {
            e = e2;
            z = false;
        }
        try {
            method.setAccessible(false);
        } catch (java.lang.Exception e3) {
            e = e3;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    private boolean m() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((android.content.pm.ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT == 26 && l()) {
            m();
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (android.os.Build.VERSION.SDK_INT == 26 && l()) {
            return;
        }
        super.setRequestedOrientation(i);
    }
}
