package com.huawei.hms.aaid.init;

/* loaded from: classes22.dex */
public class AutoInitHelper {
    public static void doAutoInit(android.content.Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                com.huawei.hms.support.log.HMSLog.i("AutoInit", "Push init start");
                new java.lang.Thread(new com.huawei.hms.opendevice.f(context)).start();
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.e("AutoInit", "Push init failed", e);
        }
    }

    public static boolean isAutoInitEnabled(android.content.Context context) {
        com.huawei.hms.opendevice.i a = com.huawei.hms.opendevice.i.a(context);
        if (a.containsKey("push_kit_auto_init_enabled")) {
            return a.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(android.content.Context context, boolean z) {
        com.huawei.hms.opendevice.i a = com.huawei.hms.opendevice.i.a(context);
        boolean z2 = a.getBoolean("push_kit_auto_init_enabled");
        a.saveBoolean("push_kit_auto_init_enabled", z);
        if (!z || z2) {
            return;
        }
        doAutoInit(context);
    }
}
