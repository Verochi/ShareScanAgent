package com.umeng.powersdk;

import com.umeng.powersdk.c.AnonymousClass1;
import com.umeng.powersdk.c.AnonymousClass2;

/* loaded from: classes19.dex */
public class PowerManager {
    public static final java.lang.String TAG = "PowerManager";
    private static android.content.Context a = null;
    private static boolean b = false;
    private static com.efs.sdk.base.EfsReporter c = null;
    private static com.umeng.powersdk.PowerConfigManager d = null;
    public static boolean isDebug = true;

    public static android.content.Context getApplicationContext() {
        return a;
    }

    public static com.umeng.powersdk.PowerConfigManager getPowerConfigManager() {
        return d;
    }

    public static com.efs.sdk.base.EfsReporter getReporter() {
        return c;
    }

    public static void init(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        com.umeng.powersdk.c cVar;
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    return;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            return;
        }
        a = context.getApplicationContext();
        c = efsReporter;
        d = new com.umeng.powersdk.PowerConfigManager(context, efsReporter);
        b = true;
        cVar = com.umeng.powersdk.c.a.a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer()) {
                return;
            }
            android.content.SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("efs_power", 0);
            if (sharedPreferences != null) {
                cVar.b = sharedPreferences.getInt("apm_powerperf_collect_interval", 5);
                cVar.c = sharedPreferences.getInt("apm_powerperf_collect_max_period_sec", 100);
            }
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("power-info");
            handlerThread.start();
            com.umeng.powersdk.c.AnonymousClass1 anonymousClass1 = cVar.new AnonymousClass1(handlerThread.getLooper(), handlerThread);
            anonymousClass1.post(cVar.new AnonymousClass2(anonymousClass1));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean isInit() {
        return b;
    }

    public static void onActivityResumed(android.app.Activity activity) {
        com.umeng.powersdk.c cVar;
        cVar = com.umeng.powersdk.c.a.a;
        try {
            if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer()) {
                cVar.d = new java.lang.ref.WeakReference<>(activity);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void onActivityStarted(android.app.Activity activity) {
        com.umeng.powersdk.c cVar;
        cVar = com.umeng.powersdk.c.a.a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer() || activity == null) {
                return;
            }
            if (cVar.g) {
                cVar.g = false;
                return;
            }
            int i = cVar.f + 1;
            cVar.f = i;
            if (i == 1) {
                cVar.e = true;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void onActivityStopped(android.app.Activity activity) {
        com.umeng.powersdk.c cVar;
        cVar = com.umeng.powersdk.c.a.a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer() || activity == null) {
                return;
            }
            if (activity.isChangingConfigurations()) {
                cVar.g = true;
                return;
            }
            int i = cVar.f - 1;
            cVar.f = i;
            if (i == 0) {
                cVar.e = false;
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
