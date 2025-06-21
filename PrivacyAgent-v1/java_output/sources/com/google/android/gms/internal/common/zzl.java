package com.google.android.gms.internal.common;

/* loaded from: classes22.dex */
public final class zzl {
    public static volatile boolean a = !zza();

    @androidx.annotation.GuardedBy("DirectBootUtils.class")
    public static boolean b = false;

    @androidx.annotation.RequiresApi(24)
    @android.annotation.TargetApi(24)
    public static android.content.Context zza(android.content.Context context) {
        boolean isDeviceProtectedStorage;
        android.content.Context createDeviceProtectedStorageContext;
        isDeviceProtectedStorage = context.isDeviceProtectedStorage();
        if (isDeviceProtectedStorage) {
            return context;
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    public static boolean zza() {
        return android.os.Build.VERSION.SDK_INT >= 24;
    }
}
