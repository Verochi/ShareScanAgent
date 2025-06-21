package com.google.android.gms.common.wrappers;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class Wrappers {
    public static com.google.android.gms.common.wrappers.Wrappers b = new com.google.android.gms.common.wrappers.Wrappers();

    @androidx.annotation.Nullable
    public com.google.android.gms.common.wrappers.PackageManagerWrapper a = null;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.wrappers.PackageManagerWrapper packageManager(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        return b.a(context);
    }

    @com.google.android.gms.common.util.VisibleForTesting
    public final synchronized com.google.android.gms.common.wrappers.PackageManagerWrapper a(android.content.Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new com.google.android.gms.common.wrappers.PackageManagerWrapper(context);
        }
        return this.a;
    }
}
