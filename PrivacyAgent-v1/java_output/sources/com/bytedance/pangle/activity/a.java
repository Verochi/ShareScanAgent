package com.bytedance.pangle.activity;

/* loaded from: classes12.dex */
public final class a implements android.view.View.OnClickListener {
    private final android.app.Activity a;
    private final java.lang.String b;
    private final int c;
    private java.lang.reflect.Method d;

    public a(@androidx.annotation.NonNull android.app.Activity activity, int i, @androidx.annotation.NonNull java.lang.String str) {
        this.a = activity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public final void onClick(@androidx.annotation.NonNull android.view.View view) {
        if (this.d == null) {
            try {
                java.lang.reflect.Method method = this.a.getClass().getMethod(this.b, android.view.View.class);
                if (method != null) {
                    this.d = method;
                }
            } catch (java.lang.NoSuchMethodException unused) {
            }
            java.lang.IllegalStateException illegalStateException = new java.lang.IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.c);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            throw illegalStateException;
        }
        try {
            this.d.invoke(this.a, view);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } catch (java.lang.IllegalAccessException e) {
            java.lang.IllegalStateException illegalStateException2 = new java.lang.IllegalStateException("Could not execute non-public method for android:onClick", e);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            throw illegalStateException2;
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.IllegalStateException illegalStateException3 = new java.lang.IllegalStateException("Could not execute method for android:onClick", e2);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            throw illegalStateException3;
        }
    }
}
