package com.igexin.push.a;

/* loaded from: classes.dex */
public final class d extends android.widget.ImageView {
    private static final int e = 1000;
    android.graphics.Movie a;
    long b;
    int c;
    volatile boolean d;
    private float f;
    private float g;
    private float h;

    public d(android.content.Context context) {
        super(context, null);
        this.d = true;
    }

    private d(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
    }

    private void a(android.graphics.Canvas canvas) {
        this.a.setTime(this.c);
        canvas.save();
        float f = this.h;
        canvas.scale(f, f);
        android.graphics.Movie movie = this.a;
        float f2 = this.f;
        float f3 = this.h;
        movie.draw(canvas, f2 / f3, this.g / f3);
        canvas.restore();
    }

    private boolean a() {
        return !this.d;
    }

    private void b() {
        if (this.d) {
            this.d = false;
            if (this.a != null) {
                this.b = android.os.SystemClock.uptimeMillis() - this.c;
                invalidate();
            }
        }
    }

    private void c() {
        if (this.d) {
            return;
        }
        this.d = true;
        if (this.a != null) {
            invalidate();
        }
    }

    private void d() {
        if (getVisibility() == 0) {
            postInvalidateOnAnimation();
        }
    }

    private void e() {
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        if (this.b == 0) {
            this.b = uptimeMillis;
        }
        int duration = this.a.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.c = (int) ((uptimeMillis - this.b) % duration);
    }

    private void setGifMovie$304a7d5c(android.graphics.Movie movie) {
        this.a = movie;
        this.b = 0L;
        this.c = 0;
        setLayerType(1, null);
        setImageDrawable(null);
        requestLayout();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.a != null) {
            if (this.d) {
                a(canvas);
                return;
            }
            long uptimeMillis = android.os.SystemClock.uptimeMillis();
            if (this.b == 0) {
                this.b = uptimeMillis;
            }
            int duration = this.a.duration();
            if (duration == 0) {
                duration = 1000;
            }
            this.c = (int) ((uptimeMillis - this.b) % duration);
            a(canvas);
            d();
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a != null) {
            int width = getWidth();
            int height = getHeight();
            this.h = 1.0f / java.lang.Math.max(width != 0 ? this.a.width() / width : 1.0f, height != 0 ? this.a.height() / height : 1.0f);
            this.f = (width - ((int) (r6 * r8))) / 2.0f;
            this.g = (height - ((int) (r7 * r8))) / 2.0f;
        }
    }

    @Override // android.view.View
    public final void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        d();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        d();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        d();
    }
}
