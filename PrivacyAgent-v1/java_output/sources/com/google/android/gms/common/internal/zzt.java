package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzt {
    public static java.lang.Object a = new java.lang.Object();

    @javax.annotation.concurrent.GuardedBy("sLock")
    public static boolean b;

    @androidx.annotation.Nullable
    public static java.lang.String c;
    public static int d;

    public static void a(android.content.Context context) {
        android.os.Bundle bundle;
        synchronized (a) {
            if (b) {
                return;
            }
            b = true;
            try {
                bundle = com.google.android.gms.common.wrappers.Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                android.util.Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            c = bundle.getString("com.google.app.id");
            d = bundle.getInt("com.google.android.gms.version");
        }
    }

    @androidx.annotation.Nullable
    public static java.lang.String zza(android.content.Context context) {
        a(context);
        return c;
    }

    public static int zzb(android.content.Context context) {
        a(context);
        return d;
    }
}
