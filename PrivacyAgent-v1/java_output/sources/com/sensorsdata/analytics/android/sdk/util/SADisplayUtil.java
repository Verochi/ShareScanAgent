package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SADisplayUtil {
    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static java.lang.String getStringResource(android.content.Context context, int i) {
        try {
            return context.getString(i);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }
}
