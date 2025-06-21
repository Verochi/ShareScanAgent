package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
final class FakeDrag {
    private final com.baidu.mobads.sdk.internal.widget.ViewPager2 a;
    private final com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter b;
    private final androidx.recyclerview.widget.RecyclerView c;
    private android.view.VelocityTracker d;
    private int e;
    private float f;
    private int g;
    private long h;

    public FakeDrag(com.baidu.mobads.sdk.internal.widget.ViewPager2 viewPager2, com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter scrollEventAdapter, androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.a = viewPager2;
        this.b = scrollEventAdapter;
        this.c = recyclerView;
    }

    private void a(long j, int i, float f, float f2) {
        android.view.MotionEvent obtain = android.view.MotionEvent.obtain(this.h, j, i, f, f2, 0);
        this.d.addMovement(obtain);
        obtain.recycle();
    }

    private void d() {
        android.view.VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.d = android.view.VelocityTracker.obtain();
            this.e = android.view.ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    public boolean a() {
        return this.b.g();
    }

    @androidx.annotation.UiThread
    public boolean a(float f) {
        if (!this.b.g()) {
            return false;
        }
        float f2 = this.f - f;
        this.f = f2;
        int round = java.lang.Math.round(f2 - this.g);
        this.g += round;
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        boolean z = this.a.getOrientation() == 0;
        int i = z ? round : 0;
        int i2 = z ? 0 : round;
        float f3 = z ? this.f : 0.0f;
        float f4 = z ? 0.0f : this.f;
        this.c.scrollBy(i, i2);
        a(uptimeMillis, 2, f3, f4);
        return true;
    }

    @androidx.annotation.UiThread
    public boolean b() {
        if (this.b.f()) {
            return false;
        }
        this.g = 0;
        this.f = 0;
        this.h = android.os.SystemClock.uptimeMillis();
        d();
        this.b.b();
        if (!this.b.e()) {
            this.c.stopScroll();
        }
        a(this.h, 0, 0.0f, 0.0f);
        return true;
    }

    @androidx.annotation.UiThread
    public boolean c() {
        if (!this.b.g()) {
            return false;
        }
        this.b.c();
        android.view.VelocityTracker velocityTracker = this.d;
        velocityTracker.computeCurrentVelocity(1000, this.e);
        if (this.c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.a.d();
        return true;
    }
}
