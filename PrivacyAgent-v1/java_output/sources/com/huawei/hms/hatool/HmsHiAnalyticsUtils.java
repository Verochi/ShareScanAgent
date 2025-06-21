package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        com.huawei.hms.hatool.n1.a();
    }

    public static boolean getInitFlag() {
        return com.huawei.hms.hatool.l1.b();
    }

    public static void init(android.content.Context context, boolean z, boolean z2, boolean z3, java.lang.String str, java.lang.String str2) {
        new com.huawei.hms.hatool.m1(context).a(z).c(z2).b(z3).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(int i, java.lang.String str, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        com.huawei.hms.hatool.l1.a(i, str, linkedHashMap);
    }

    public static void onEvent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.l1.a(context, str, str2);
    }

    public static void onReport() {
        com.huawei.hms.hatool.l1.c();
    }
}
