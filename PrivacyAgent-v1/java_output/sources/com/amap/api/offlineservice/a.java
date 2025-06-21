package com.amap.api.offlineservice;

/* loaded from: classes12.dex */
public abstract class a {
    protected com.amap.api.maps.offlinemap.OfflineMapActivity a = null;

    public final int a(float f) {
        return this.a != null ? (int) ((f * (r0.getResources().getDisplayMetrics().densityDpi / 160.0f)) + 0.5f) : (int) f;
    }

    public final void a() {
        this.a.showScr();
    }

    public abstract void a(android.view.View view);

    public final void a(com.amap.api.maps.offlinemap.OfflineMapActivity offlineMapActivity) {
        this.a = offlineMapActivity;
    }

    public abstract void b();

    public boolean c() {
        return true;
    }

    public abstract android.widget.RelativeLayout d();

    public abstract void e();
}
