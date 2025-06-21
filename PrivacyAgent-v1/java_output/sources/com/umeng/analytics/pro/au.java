package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class au {
    public static final java.lang.String a = "cl_count";
    public static final java.lang.String b = "interval_";
    public static final java.lang.String c = "config_ts";
    public static final java.lang.String d = "iucc_s1";
    public static final java.lang.String e = "iucc_s2";
    public static final java.lang.String f = "sdk_type_ver";
    public static final java.lang.String g = "should_fetch";
    public static final java.lang.String h = "last_type_index";
    private static final java.lang.String i = "ccg_sp_config_file";

    private au() {
    }

    public static android.content.SharedPreferences a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(i, 0);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
