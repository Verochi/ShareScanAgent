package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public abstract class a {
    boolean isRefresh;
    protected java.lang.ref.WeakReference<android.app.Activity> mActivityRef;
    private com.anythink.core.common.f.h mTrackingInfo;
    private com.anythink.core.common.f.au mUnitGroupInfo;

    public final com.anythink.core.common.f.h getTrackingInfo() {
        return this.mTrackingInfo;
    }

    public final com.anythink.core.common.f.au getUnitGroupInfo() {
        return this.mUnitGroupInfo;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void postOnMainThread(java.lang.Runnable runnable) {
        com.anythink.core.common.b.o.a().b(runnable);
    }

    public final void postOnMainThreadDelayed(java.lang.Runnable runnable, long j) {
        com.anythink.core.common.b.o.a().a(runnable, j);
    }

    public final void refreshActivityContext(android.app.Activity activity) {
        this.mActivityRef = new java.lang.ref.WeakReference<>(activity);
    }

    public final void runOnNetworkRequestThread(java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            com.anythink.core.common.o.b.b.a().c(runnable);
        } else {
            runnable.run();
        }
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    public final void setTrackingInfo(com.anythink.core.common.f.h hVar) {
        this.mTrackingInfo = hVar;
    }

    public final void setUnitGroupInfo(com.anythink.core.common.f.au auVar) {
        this.mUnitGroupInfo = auVar;
    }
}
