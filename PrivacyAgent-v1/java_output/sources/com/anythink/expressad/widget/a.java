package com.anythink.expressad.widget;

/* loaded from: classes12.dex */
public abstract class a implements android.view.View.OnClickListener {
    public static final int d = 2000;
    private long a = 0;

    public abstract void a(android.view.View view);

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        long timeInMillis = java.util.Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.a > 2000) {
            this.a = timeInMillis;
            a(view);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
