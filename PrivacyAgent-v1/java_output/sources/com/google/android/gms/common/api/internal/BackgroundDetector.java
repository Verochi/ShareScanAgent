package com.google.android.gms.common.api.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class BackgroundDetector implements android.app.Application.ActivityLifecycleCallbacks, android.content.ComponentCallbacks2 {
    public static final com.google.android.gms.common.api.internal.BackgroundDetector w = new com.google.android.gms.common.api.internal.BackgroundDetector();
    public final java.util.concurrent.atomic.AtomicBoolean n = new java.util.concurrent.atomic.AtomicBoolean();
    public final java.util.concurrent.atomic.AtomicBoolean t = new java.util.concurrent.atomic.AtomicBoolean();

    @javax.annotation.concurrent.GuardedBy("sInstance")
    public final java.util.ArrayList<com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener> u = new java.util.ArrayList<>();

    @javax.annotation.concurrent.GuardedBy("sInstance")
    public boolean v = false;

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface BackgroundStateChangeListener {
        @com.google.android.gms.common.annotation.KeepForSdk
        void onBackgroundStateChanged(@androidx.annotation.RecentlyNonNull boolean z);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public BackgroundDetector() {
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.api.internal.BackgroundDetector getInstance() {
        return w;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public static void initialize(@androidx.annotation.RecentlyNonNull android.app.Application application) {
        com.google.android.gms.common.api.internal.BackgroundDetector backgroundDetector = w;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.v) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.v = true;
            }
        }
    }

    public final void a(boolean z) {
        synchronized (w) {
            java.util.ArrayList<com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener> arrayList = this.u;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i);
                i++;
                backgroundStateChangeListener.onBackgroundStateChanged(z);
            }
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void addListener(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (w) {
            this.u.add(backgroundStateChangeListener);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final boolean isInBackground() {
        return this.n.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
        boolean compareAndSet = this.n.compareAndSet(true, false);
        this.t.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
        boolean compareAndSet = this.n.compareAndSet(true, false);
        this.t.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@androidx.annotation.RecentlyNonNull android.app.Activity activity, @androidx.annotation.RecentlyNonNull android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@androidx.annotation.RecentlyNonNull android.app.Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@androidx.annotation.RecentlyNonNull android.content.res.Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(@androidx.annotation.RecentlyNonNull int i) {
        if (i == 20 && this.n.compareAndSet(false, true)) {
            this.t.set(true);
            a(true);
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @android.annotation.TargetApi(16)
    public final boolean readCurrentStateIfPossible(@androidx.annotation.RecentlyNonNull boolean z) {
        if (!this.t.get()) {
            if (!com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new android.app.ActivityManager.RunningAppProcessInfo();
            android.app.ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.t.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.n.set(true);
            }
        }
        return isInBackground();
    }
}
