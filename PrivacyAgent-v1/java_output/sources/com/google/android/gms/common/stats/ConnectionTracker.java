package com.google.android.gms.common.stats;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class ConnectionTracker {
    public static final java.lang.Object b = new java.lang.Object();

    @javax.annotation.Nullable
    public static volatile com.google.android.gms.common.stats.ConnectionTracker c;

    @com.google.android.gms.common.util.VisibleForTesting
    public java.util.concurrent.ConcurrentHashMap<android.content.ServiceConnection, android.content.ServiceConnection> a = new java.util.concurrent.ConcurrentHashMap<>();

    public static boolean b(android.content.ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof com.google.android.gms.common.internal.zzk);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.stats.ConnectionTracker getInstance() {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new com.google.android.gms.common.stats.ConnectionTracker();
                }
            }
        }
        return (com.google.android.gms.common.stats.ConnectionTracker) com.google.android.gms.common.internal.Preconditions.checkNotNull(c);
    }

    @android.annotation.SuppressLint({"UntrackedBindService"})
    public final boolean a(android.content.Context context, java.lang.String str, android.content.Intent intent, android.content.ServiceConnection serviceConnection, int i, boolean z) {
        android.content.ComponentName component = intent.getComponent();
        if (component == null ? false : com.google.android.gms.common.util.ClientLibraryUtils.zza(context, component.getPackageName())) {
            return false;
        }
        if (!b(serviceConnection)) {
            return context.bindService(intent, serviceConnection, i);
        }
        android.content.ServiceConnection putIfAbsent = this.a.putIfAbsent(serviceConnection, serviceConnection);
        if (putIfAbsent != null && serviceConnection != putIfAbsent) {
            java.lang.String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction());
        }
        try {
            boolean bindService = context.bindService(intent, serviceConnection, i);
            return !bindService ? bindService : bindService;
        } finally {
            this.a.remove(serviceConnection, serviceConnection);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean bindService(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.SuppressLint({"UntrackedBindService"})
    public void unbindService(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection) {
        if (!b(serviceConnection) || !this.a.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (java.lang.IllegalArgumentException | java.lang.IllegalStateException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService(this.a.get(serviceConnection));
                } catch (java.lang.IllegalArgumentException | java.lang.IllegalStateException unused2) {
                }
            } finally {
                this.a.remove(serviceConnection);
            }
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.SuppressLint({"UntrackedBindService"})
    public void unbindServiceSafe(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (java.lang.IllegalArgumentException unused) {
        }
    }

    @androidx.annotation.RecentlyNonNull
    public final boolean zza(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull int i) {
        return a(context, str, intent, serviceConnection, i, true);
    }
}
