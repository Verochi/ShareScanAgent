package com.umeng.commonsdk.statistics.internal;

/* loaded from: classes19.dex */
public class PreferenceWrapper {
    private static final java.lang.String DEFAULT_PREFERENCE = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.j);

    private PreferenceWrapper() {
    }

    public static android.content.SharedPreferences getDefault(android.content.Context context) {
        if (context != null) {
            return context.getSharedPreferences(DEFAULT_PREFERENCE, 0);
        }
        return null;
    }

    public static android.content.SharedPreferences getInstance(android.content.Context context, java.lang.String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
