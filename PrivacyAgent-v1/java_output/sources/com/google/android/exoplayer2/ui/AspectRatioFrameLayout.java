package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final class AspectRatioFrameLayout extends android.widget.FrameLayout {
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;
    public final com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatioUpdateDispatcher n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatioListener t;
    public float u;
    public int v;

    public interface AspectRatioListener {
        void onAspectRatioUpdated(float f, float f2, boolean z);
    }

    public final class AspectRatioUpdateDispatcher implements java.lang.Runnable {
        public float n;
        public float t;
        public boolean u;
        public boolean v;

        public AspectRatioUpdateDispatcher() {
        }

        public /* synthetic */ AspectRatioUpdateDispatcher(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(float f, float f2, boolean z) {
            this.n = f;
            this.t = f2;
            this.u = z;
            if (this.v) {
                return;
            }
            this.v = true;
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.v = false;
            if (com.google.android.exoplayer2.ui.AspectRatioFrameLayout.this.t == null) {
                return;
            }
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout.this.t.onAspectRatioUpdated(this.n, this.t, this.u);
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(android.content.Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = 0;
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.exoplayer2.ui.R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.v = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.n = new com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatioUpdateDispatcher(this, null);
    }

    public int getResizeMode() {
        return this.v;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.u <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f3 = measuredWidth;
        float f4 = measuredHeight;
        float f5 = f3 / f4;
        float f6 = (this.u / f5) - 1.0f;
        if (java.lang.Math.abs(f6) <= 0.01f) {
            this.n.a(this.u, f5, false);
            return;
        }
        int i3 = this.v;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f = this.u;
                } else if (i3 == 4) {
                    if (f6 > 0.0f) {
                        f = this.u;
                    } else {
                        f2 = this.u;
                    }
                }
                measuredWidth = (int) (f4 * f);
            } else {
                f2 = this.u;
            }
            measuredHeight = (int) (f3 / f2);
        } else if (f6 > 0.0f) {
            f2 = this.u;
            measuredHeight = (int) (f3 / f2);
        } else {
            f = this.u;
            measuredWidth = (int) (f4 * f);
        }
        this.n.a(this.u, f5, true);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f) {
        if (this.u != f) {
            this.u = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        this.t = aspectRatioListener;
    }

    public void setResizeMode(int i) {
        if (this.v != i) {
            this.v = i;
            requestLayout();
        }
    }
}
