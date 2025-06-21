package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class s {
    public static java.lang.Boolean a;

    public static final boolean a(android.content.Context context) {
        java.lang.Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            java.lang.Boolean valueOf = java.lang.Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            a = valueOf;
            return valueOf.booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
