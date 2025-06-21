package com.google.android.gms.common.wrappers;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class InstantApps {
    public static android.content.Context a;

    @androidx.annotation.Nullable
    public static java.lang.Boolean b;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static synchronized boolean isInstantApp(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        boolean isInstantApp;
        java.lang.Boolean bool;
        synchronized (com.google.android.gms.common.wrappers.InstantApps.class) {
            android.content.Context applicationContext = context.getApplicationContext();
            android.content.Context context2 = a;
            if (context2 != null && (bool = b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            b = null;
            if (com.google.android.gms.common.util.PlatformVersion.isAtLeastO()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                b = java.lang.Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    b = java.lang.Boolean.TRUE;
                } catch (java.lang.ClassNotFoundException unused) {
                    b = java.lang.Boolean.FALSE;
                }
            }
            a = applicationContext;
            return b.booleanValue();
        }
    }
}
