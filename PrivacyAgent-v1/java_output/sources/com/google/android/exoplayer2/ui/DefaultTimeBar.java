package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class DefaultTimeBar extends android.view.View implements com.google.android.exoplayer2.ui.TimeBar {
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    public final android.graphics.Paint A;
    public final android.graphics.Paint B;

    @androidx.annotation.Nullable
    public final android.graphics.drawable.Drawable C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final java.lang.StringBuilder L;
    public final java.util.Formatter M;
    public final java.lang.Runnable N;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.ui.TimeBar.OnScrubListener> O;
    public final android.graphics.Point P;
    public final float Q;
    public int R;
    public long S;
    public int T;
    public android.graphics.Rect U;
    public android.animation.ValueAnimator V;
    public float W;
    public boolean a0;
    public long b0;
    public long c0;
    public long d0;
    public long e0;
    public int f0;

    @androidx.annotation.Nullable
    public long[] g0;

    @androidx.annotation.Nullable
    public boolean[] h0;
    public final android.graphics.Rect n;
    public final android.graphics.Rect t;
    public final android.graphics.Rect u;
    public final android.graphics.Rect v;
    public final android.graphics.Paint w;
    public final android.graphics.Paint x;
    public final android.graphics.Paint y;
    public final android.graphics.Paint z;

    public DefaultTimeBar(android.content.Context context) {
        this(context, null);
    }

    public DefaultTimeBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, @androidx.annotation.Nullable android.util.AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, @androidx.annotation.Nullable android.util.AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.n = new android.graphics.Rect();
        this.t = new android.graphics.Rect();
        this.u = new android.graphics.Rect();
        this.v = new android.graphics.Rect();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.w = paint;
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.x = paint2;
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.y = paint3;
        android.graphics.Paint paint4 = new android.graphics.Paint();
        this.z = paint4;
        android.graphics.Paint paint5 = new android.graphics.Paint();
        this.A = paint5;
        android.graphics.Paint paint6 = new android.graphics.Paint();
        this.B = paint6;
        paint6.setAntiAlias(true);
        this.O = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.P = new android.graphics.Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.Q = f;
        this.K = c(f, -50);
        int c = c(f, 4);
        int c2 = c(f, 26);
        int c3 = c(f, 4);
        int c4 = c(f, 12);
        int c5 = c(f, 0);
        int c6 = c(f, 16);
        if (attributeSet2 != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar, i, i2);
            try {
                android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_scrubber_drawable);
                this.C = drawable;
                if (drawable != null) {
                    m(drawable);
                    c2 = java.lang.Math.max(drawable.getMinimumHeight(), c2);
                }
                this.D = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_bar_height, c);
                this.E = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_touch_target_height, c2);
                this.F = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_ad_marker_width, c3);
                this.G = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_scrubber_enabled_size, c4);
                this.H = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_scrubber_disabled_size, c5);
                this.I = obtainStyledAttributes.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_scrubber_dragged_size, c6);
                int i3 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_played_color, -1);
                int i4 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i5 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_buffered_color, DEFAULT_BUFFERED_COLOR);
                int i6 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_unplayed_color, DEFAULT_UNPLAYED_COLOR);
                int i7 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_ad_marker_color, DEFAULT_AD_MARKER_COLOR);
                int i8 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.DefaultTimeBar_played_ad_marker_color, DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.D = c;
            this.E = c2;
            this.F = c3;
            this.G = c4;
            this.H = c5;
            this.I = c6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.C = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        this.L = sb;
        this.M = new java.util.Formatter(sb, java.util.Locale.getDefault());
        this.N = new defpackage.tz(this);
        android.graphics.drawable.Drawable drawable2 = this.C;
        if (drawable2 != null) {
            this.J = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.J = (java.lang.Math.max(this.H, java.lang.Math.max(this.G, this.I)) + 1) / 2;
        }
        this.W = 1.0f;
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        this.V = valueAnimator;
        valueAnimator.addUpdateListener(new defpackage.uz(this));
        this.c0 = -9223372036854775807L;
        this.S = -9223372036854775807L;
        this.R = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static int c(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        q(false);
    }

    private long getPositionIncrement() {
        long j = this.S;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.c0;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.R;
    }

    private java.lang.String getProgressText() {
        return com.google.android.exoplayer2.util.Util.getStringForTime(this.L, this.M, this.d0);
    }

    private long getScrubberPosition() {
        if (this.t.width() <= 0 || this.c0 == -9223372036854775807L) {
            return 0L;
        }
        return (this.v.width() * this.c0) / this.t.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(android.animation.ValueAnimator valueAnimator) {
        this.W = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.n);
    }

    public static int j(float f, int i) {
        return (int) (i / f);
    }

    public static boolean n(android.graphics.drawable.Drawable drawable, int i) {
        boolean layoutDirection;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            layoutDirection = drawable.setLayoutDirection(i);
            if (layoutDirection) {
                return true;
            }
        }
        return false;
    }

    private void update() {
        this.u.set(this.t);
        this.v.set(this.t);
        long j = this.a0 ? this.b0 : this.d0;
        if (this.c0 > 0) {
            int width = (int) ((this.t.width() * this.e0) / this.c0);
            android.graphics.Rect rect = this.u;
            android.graphics.Rect rect2 = this.t;
            rect.right = java.lang.Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.t.width() * j) / this.c0);
            android.graphics.Rect rect3 = this.v;
            android.graphics.Rect rect4 = this.t;
            rect3.right = java.lang.Math.min(rect4.left + width2, rect4.right);
        } else {
            android.graphics.Rect rect5 = this.u;
            int i = this.t.left;
            rect5.right = i;
            this.v.right = i;
        }
        invalidate(this.n);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(com.google.android.exoplayer2.ui.TimeBar.OnScrubListener onScrubListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(onScrubListener);
        this.O.add(onScrubListener);
    }

    public final void d(android.graphics.Canvas canvas) {
        if (this.c0 <= 0) {
            return;
        }
        android.graphics.Rect rect = this.v;
        int constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(rect.right, rect.left, this.t.right);
        int centerY = this.v.centerY();
        if (this.C == null) {
            canvas.drawCircle(constrainValue, centerY, (int) ((((this.a0 || isFocused()) ? this.I : isEnabled() ? this.G : this.H) * this.W) / 2.0f), this.B);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.W)) / 2;
        int intrinsicHeight = ((int) (this.C.getIntrinsicHeight() * this.W)) / 2;
        this.C.setBounds(constrainValue - intrinsicWidth, centerY - intrinsicHeight, constrainValue + intrinsicWidth, centerY + intrinsicHeight);
        this.C.draw(canvas);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r();
    }

    public final void e(android.graphics.Canvas canvas) {
        int height = this.t.height();
        int centerY = this.t.centerY() - (height / 2);
        int i = height + centerY;
        if (this.c0 <= 0) {
            android.graphics.Rect rect = this.t;
            canvas.drawRect(rect.left, centerY, rect.right, i, this.y);
            return;
        }
        android.graphics.Rect rect2 = this.u;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int max = java.lang.Math.max(java.lang.Math.max(this.t.left, i3), this.v.right);
        int i4 = this.t.right;
        if (max < i4) {
            canvas.drawRect(max, centerY, i4, i, this.y);
        }
        int max2 = java.lang.Math.max(i2, this.v.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.x);
        }
        if (this.v.width() > 0) {
            android.graphics.Rect rect3 = this.v;
            canvas.drawRect(rect3.left, centerY, rect3.right, i, this.w);
        }
        if (this.f0 == 0) {
            return;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.g0);
        boolean[] zArr = (boolean[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.h0);
        int i5 = this.F / 2;
        for (int i6 = 0; i6 < this.f0; i6++) {
            int width = ((int) ((this.t.width() * com.google.android.exoplayer2.util.Util.constrainValue(jArr[i6], 0L, this.c0)) / this.c0)) - i5;
            android.graphics.Rect rect4 = this.t;
            canvas.drawRect(rect4.left + java.lang.Math.min(rect4.width() - this.F, java.lang.Math.max(0, width)), centerY, r10 + this.F, i, zArr[i6] ? this.A : this.z);
        }
    }

    public final boolean f(float f, float f2) {
        return this.n.contains((int) f, (int) f2);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int j = j(this.Q, this.t.width());
        if (j != 0) {
            long j2 = this.c0;
            if (j2 != 0 && j2 != -9223372036854775807L) {
                return j2 / j;
            }
        }
        return Long.MAX_VALUE;
    }

    public void hideScrubber() {
        hideScrubber(0L);
    }

    public void hideScrubber(long j) {
        if (this.V.isStarted()) {
            this.V.cancel();
        }
        this.V.setFloatValues(this.W, 0.0f);
        this.V.setDuration(j);
        this.V.start();
    }

    public final void i(float f) {
        android.graphics.Rect rect = this.v;
        android.graphics.Rect rect2 = this.t;
        rect.right = com.google.android.exoplayer2.util.Util.constrainValue((int) f, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.graphics.drawable.Drawable drawable = this.C;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final android.graphics.Point k(android.view.MotionEvent motionEvent) {
        this.P.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.P;
    }

    public final boolean l(long j) {
        long j2 = this.c0;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.a0 ? this.b0 : this.d0;
        long constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(j3 + j, 0L, j2);
        if (constrainValue == j3) {
            return false;
        }
        if (this.a0) {
            s(constrainValue);
        } else {
            p(constrainValue);
        }
        update();
        return true;
    }

    public final boolean m(android.graphics.drawable.Drawable drawable) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 23 && n(drawable, getLayoutDirection());
    }

    @androidx.annotation.RequiresApi(29)
    public final void o(int i, int i2) {
        android.graphics.Rect rect = this.U;
        if (rect != null && rect.width() == i && this.U.height() == i2) {
            return;
        }
        android.graphics.Rect rect2 = new android.graphics.Rect(0, 0, i, i2);
        this.U = rect2;
        setSystemGestureExclusionRects(java.util.Collections.singletonList(rect2));
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @androidx.annotation.Nullable android.graphics.Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.a0 || z) {
            return;
        }
        q(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.c0 <= 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21) {
            accessibilityNodeInfo.addAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (l(positionIncrement)) {
                            removeCallbacks(this.N);
                            postDelayed(this.N, 1000L);
                            break;
                        }
                        break;
                    case 22:
                        if (l(positionIncrement)) {
                        }
                        break;
                }
                return true;
            }
            if (this.a0) {
                q(false);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = (i6 - this.E) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i8 = this.E;
        int i9 = ((i8 - this.D) / 2) + i7;
        this.n.set(paddingLeft, i7, paddingRight, i8 + i7);
        android.graphics.Rect rect = this.t;
        android.graphics.Rect rect2 = this.n;
        int i10 = rect2.left;
        int i11 = this.J;
        rect.set(i10 + i11, i9, rect2.right - i11, this.D + i9);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 29) {
            o(i5, i6);
        }
        update();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.E;
        } else if (mode != 1073741824) {
            size = java.lang.Math.min(this.E, size);
        }
        setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), size);
        r();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        android.graphics.drawable.Drawable drawable = this.C;
        if (drawable == null || !n(drawable, i)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (isEnabled() && this.c0 > 0) {
            android.graphics.Point k = k(motionEvent);
            int i = k.x;
            int i2 = k.y;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (this.a0) {
                            if (i2 < this.K) {
                                int i3 = this.T;
                                i(i3 + ((i - i3) / 3));
                            } else {
                                this.T = i;
                                i(i);
                            }
                            s(getScrubberPosition());
                            update();
                            invalidate();
                            return true;
                        }
                    }
                }
                if (this.a0) {
                    q(motionEvent.getAction() == 3);
                    return true;
                }
            } else {
                float f = i;
                if (f(f, i2)) {
                    i(f);
                    p(getScrubberPosition());
                    update();
                    invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    public final void p(long j) {
        this.b0 = j;
        this.a0 = true;
        setPressed(true);
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        java.util.Iterator<com.google.android.exoplayer2.ui.TimeBar.OnScrubListener> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().onScrubStart(this, j);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.c0 <= 0) {
            return false;
        }
        if (i == 8192) {
            if (l(-getPositionIncrement())) {
                q(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (l(getPositionIncrement())) {
                q(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public final void q(boolean z) {
        removeCallbacks(this.N);
        this.a0 = false;
        setPressed(false);
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        java.util.Iterator<com.google.android.exoplayer2.ui.TimeBar.OnScrubListener> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().onScrubStop(this, this.b0, z);
        }
    }

    public final void r() {
        android.graphics.drawable.Drawable drawable = this.C;
        if (drawable != null && drawable.isStateful() && this.C.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void removeListener(com.google.android.exoplayer2.ui.TimeBar.OnScrubListener onScrubListener) {
        this.O.remove(onScrubListener);
    }

    public final void s(long j) {
        if (this.b0 == j) {
            return;
        }
        this.b0 = j;
        java.util.Iterator<com.google.android.exoplayer2.ui.TimeBar.OnScrubListener> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().onScrubMove(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(@androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable boolean[] zArr, int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i == 0 || !(jArr == null || zArr == null));
        this.f0 = i;
        this.g0 = jArr;
        this.h0 = zArr;
        update();
    }

    public void setAdMarkerColor(@androidx.annotation.ColorInt int i) {
        this.z.setColor(i);
        invalidate(this.n);
    }

    public void setBufferedColor(@androidx.annotation.ColorInt int i) {
        this.x.setColor(i);
        invalidate(this.n);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long j) {
        this.e0 = j;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long j) {
        this.c0 = j;
        if (this.a0 && j == -9223372036854775807L) {
            q(true);
        }
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.a0 || z) {
            return;
        }
        q(true);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyCountIncrement(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        this.R = i;
        this.S = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyTimeIncrement(long j) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j > 0);
        this.R = -1;
        this.S = j;
    }

    public void setPlayedAdMarkerColor(@androidx.annotation.ColorInt int i) {
        this.A.setColor(i);
        invalidate(this.n);
    }

    public void setPlayedColor(@androidx.annotation.ColorInt int i) {
        this.w.setColor(i);
        invalidate(this.n);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long j) {
        this.d0 = j;
        setContentDescription(getProgressText());
        update();
    }

    public void setScrubberColor(@androidx.annotation.ColorInt int i) {
        this.B.setColor(i);
        invalidate(this.n);
    }

    public void setUnplayedColor(@androidx.annotation.ColorInt int i) {
        this.y.setColor(i);
        invalidate(this.n);
    }

    public void showScrubber() {
        showScrubber(0L);
    }

    public void showScrubber(long j) {
        if (this.V.isStarted()) {
            this.V.cancel();
        }
        this.V.setFloatValues(this.W, 1.0f);
        this.V.setDuration(j);
        this.V.start();
    }
}
