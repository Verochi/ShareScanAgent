package com.tanx.exposer.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_for {
    public static java.lang.String tanxc_do(long j, java.lang.String str) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new java.text.SimpleDateFormat(str).format(calendar.getTime());
    }
}
