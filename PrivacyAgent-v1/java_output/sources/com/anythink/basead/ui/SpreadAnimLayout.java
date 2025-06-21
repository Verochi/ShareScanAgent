package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class SpreadAnimLayout extends android.widget.FrameLayout {
    private android.graphics.Paint a;
    private android.animation.ValueAnimator b;
    private com.anythink.basead.ui.SpreadAnimLayout.a c;
    private android.graphics.RectF d;
    private android.graphics.RectF e;
    private int f;
    private int g;
    private int h;
    private android.graphics.Paint i;
    private boolean j;
    private boolean k;

    /* renamed from: com.anythink.basead.ui.SpreadAnimLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.SpreadAnimLayout.this.startSpreadAnimation();
        }
    }

    /* renamed from: com.anythink.basead.ui.SpreadAnimLayout$2, reason: invalid class name */
    public class AnonymousClass2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.anythink.basead.ui.SpreadAnimLayout.this.c.b = (int) ((1.0f - floatValue) * 255.0f);
            com.anythink.basead.ui.SpreadAnimLayout.this.c.a.set(com.anythink.basead.ui.SpreadAnimLayout.this.d);
            float f = -((int) (com.anythink.basead.ui.SpreadAnimLayout.this.g * floatValue));
            com.anythink.basead.ui.SpreadAnimLayout.this.c.a.inset(f, f);
            com.anythink.basead.ui.SpreadAnimLayout.this.postInvalidate();
        }
    }

    public static class a {
        android.graphics.RectF a;
        int b;
    }

    public SpreadAnimLayout(android.content.Context context) {
        this(context, null, 0);
    }

    public SpreadAnimLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadAnimLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = true;
        setWillNotDraw(false);
        int color = getResources().getColor(com.anythink.core.common.o.i.a(context, "color_spread", "color"));
        this.g = getResources().getDimensionPixelSize(com.anythink.core.common.o.i.a(getContext(), "myoffer_spread_max_distance_normal", "dimen"));
        this.f = com.anythink.core.common.o.i.a(context, 4.0f);
        this.h = 1000;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setAlpha(255);
        this.a.setColor(color);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.i = paint2;
        paint2.setColor(-1);
        this.i.setStyle(android.graphics.Paint.Style.FILL);
        this.i.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        if (!this.j || !this.k) {
            super.draw(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.a.setAlpha(this.c.b);
        android.graphics.RectF rectF = this.c.a;
        int i = this.f;
        canvas.drawRoundRect(rectF, i, i, this.a);
        android.graphics.RectF rectF2 = this.d;
        int i2 = this.f;
        canvas.drawRoundRect(rectF2, i2, i2, this.i);
        canvas.restoreToCount(saveLayer);
        super.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.g;
        setPadding(i3, i3, i3, i3);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.j) {
            if (i == 0) {
                post(new com.anythink.basead.ui.SpreadAnimLayout.AnonymousClass1());
                return;
            }
            android.animation.ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
        }
    }

    public void setMaxSpreadDistance(int i) {
        this.g = i;
    }

    public void setRoundRadius(int i) {
        this.f = i;
    }

    public void startSpreadAnimation() {
        android.view.View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.j = true;
        if (!this.k) {
            this.d = new android.graphics.RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            this.e = new android.graphics.RectF(this.d);
            com.anythink.basead.ui.SpreadAnimLayout.a aVar = new com.anythink.basead.ui.SpreadAnimLayout.a();
            this.c = aVar;
            aVar.b = 255;
            aVar.a = this.e;
            this.g = java.lang.Math.min(this.g, java.lang.Math.min((getWidth() - childAt.getWidth()) / 2, (getHeight() - childAt.getHeight()) / 2));
            android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.b = ofFloat;
            ofFloat.setDuration(this.h);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
            this.b.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
            this.b.addUpdateListener(new com.anythink.basead.ui.SpreadAnimLayout.AnonymousClass2());
            this.k = true;
        }
        this.b.start();
    }
}
