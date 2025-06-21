package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class Utils implements com.alimm.tanx.core.utils.NotConfused {
    public static java.lang.String formatTimeInMillis(long j, java.lang.String str) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new java.text.SimpleDateFormat(str).format(calendar.getTime());
    }
}
