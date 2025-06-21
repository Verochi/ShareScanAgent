package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseShakeView extends android.widget.LinearLayout {
    protected android.widget.ImageView a;
    protected android.widget.ImageView b;
    android.animation.ValueAnimator c;
    protected int d;
    protected java.lang.String e;
    protected java.lang.String f;
    protected java.lang.String g;
    protected java.lang.String h;
    protected android.graphics.Bitmap i;
    com.anythink.basead.c.h j;
    private int k;
    private com.anythink.basead.ui.BaseShakeView.a l;

    /* renamed from: com.anythink.basead.ui.BaseShakeView$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.c.h {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.c.h
        public final boolean a() {
            if (com.anythink.basead.ui.BaseShakeView.this.isShown() && com.anythink.basead.ui.BaseShakeView.this.l != null) {
                return com.anythink.basead.ui.BaseShakeView.this.l.a();
            }
            return false;
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$10, reason: invalid class name */
    public class AnonymousClass10 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass10() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.anythink.basead.ui.BaseShakeView.this.a.setRotation(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$11, reason: invalid class name */
    public class AnonymousClass11 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass11() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.anythink.basead.ui.BaseShakeView.b(com.anythink.basead.ui.BaseShakeView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$12, reason: invalid class name */
    public class AnonymousClass12 implements android.view.animation.Interpolator {
        public AnonymousClass12() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if ((com.anythink.basead.ui.BaseShakeView.this.k / 2) % 3 == 0) {
                return 0.0f;
            }
            return f;
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        public AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseShakeView.this.a.setPivotX((int) (com.anythink.basead.ui.BaseShakeView.this.a.getWidth() * 0.8d));
            com.anythink.basead.ui.BaseShakeView.this.a.setPivotY((int) (com.anythink.basead.ui.BaseShakeView.this.a.getHeight() * 0.8d));
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$14, reason: invalid class name */
    public class AnonymousClass14 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass14() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.anythink.basead.ui.BaseShakeView.this.a.setRotation(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.anythink.basead.ui.BaseShakeView.b(com.anythink.basead.ui.BaseShakeView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.animation.Interpolator {
        public AnonymousClass3() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (com.anythink.basead.ui.BaseShakeView.this.k % 3 == 2) {
                return 0.0f;
            }
            return f;
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseShakeView.this.a.setPivotX((int) (com.anythink.basead.ui.BaseShakeView.this.a.getWidth() * 0.5d));
            com.anythink.basead.ui.BaseShakeView.this.a.setPivotY((int) (com.anythink.basead.ui.BaseShakeView.this.a.getHeight() * 0.5d));
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            try {
                i = java.lang.Math.min(com.anythink.basead.ui.BaseShakeView.this.getResources().getDisplayMetrics().widthPixels, com.anythink.basead.ui.BaseShakeView.this.getResources().getDisplayMetrics().heightPixels) / 2;
            } catch (java.lang.Throwable unused) {
                i = 0;
            }
            com.anythink.basead.ui.BaseShakeView baseShakeView = com.anythink.basead.ui.BaseShakeView.this;
            baseShakeView.i = com.anythink.core.common.res.b.a(baseShakeView.getContext()).b(new com.anythink.core.common.res.e(3, com.anythink.basead.ui.BaseShakeView.this.e), i, i);
            com.anythink.basead.ui.BaseShakeView.this.c();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseShakeView baseShakeView = com.anythink.basead.ui.BaseShakeView.this;
            android.widget.ImageView imageView = baseShakeView.a;
            if (imageView != null) {
                android.graphics.Bitmap bitmap = baseShakeView.i;
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    imageView.setImageResource(com.anythink.core.common.o.i.a(baseShakeView.getContext(), "myoffer_shake_icon", com.anythink.expressad.foundation.h.i.c));
                }
            }
            com.anythink.basead.ui.BaseShakeView baseShakeView2 = com.anythink.basead.ui.BaseShakeView.this;
            android.widget.ImageView imageView2 = baseShakeView2.b;
            if (imageView2 != null) {
                android.graphics.Bitmap bitmap2 = baseShakeView2.i;
                if (bitmap2 != null) {
                    imageView2.setImageBitmap(bitmap2);
                } else {
                    imageView2.setImageResource(com.anythink.core.common.o.i.a(baseShakeView2.getContext(), "myoffer_shake_icon", com.anythink.expressad.foundation.h.i.c));
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass7() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.anythink.basead.ui.BaseShakeView.this.a.setTranslationX(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$8, reason: invalid class name */
    public class AnonymousClass8 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass8() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.anythink.basead.ui.BaseShakeView.b(com.anythink.basead.ui.BaseShakeView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseShakeView$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.animation.Interpolator {
        public AnonymousClass9() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (com.anythink.basead.ui.BaseShakeView.this.k % 3 == 2) {
                return 0.0f;
            }
            return f;
        }
    }

    public interface a {
        boolean a();
    }

    public BaseShakeView(android.content.Context context) {
        super(context);
        this.k = 0;
        this.j = new com.anythink.basead.ui.BaseShakeView.AnonymousClass1();
        a();
    }

    public BaseShakeView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        this.j = new com.anythink.basead.ui.BaseShakeView.AnonymousClass1();
        a();
    }

    public BaseShakeView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        this.j = new com.anythink.basead.ui.BaseShakeView.AnonymousClass1();
        a();
    }

    @androidx.annotation.RequiresApi(api = 21)
    public BaseShakeView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.k = 0;
        this.j = new com.anythink.basead.ui.BaseShakeView.AnonymousClass1();
        a();
    }

    public static /* synthetic */ int b(com.anythink.basead.ui.BaseShakeView baseShakeView) {
        int i = baseShakeView.k;
        baseShakeView.k = i + 1;
        return i;
    }

    private void b() {
        if (this.a != null) {
            android.animation.ValueAnimator a2 = a(this.d);
            this.c = a2;
            if (a2 != null) {
                a2.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.BaseShakeView.AnonymousClass6());
    }

    public android.animation.ValueAnimator a(int i) {
        if (i == 2) {
            int a2 = com.anythink.core.common.o.i.a(getContext(), 8.0f);
            float f = a2;
            float f2 = -a2;
            android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, f, f2, f, f2, a2 / 2, r7 / 2, a2 / 4, r7 / 4, 0.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass7());
            ofFloat.addListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass8());
            ofFloat.setInterpolator(new com.anythink.basead.ui.BaseShakeView.AnonymousClass9());
            return ofFloat;
        }
        if (i != 3) {
            android.animation.ValueAnimator ofFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, -25.0f, 0.0f, 25.0f, 0.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setRepeatCount(-1);
            ofFloat2.addUpdateListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass14());
            ofFloat2.addListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass2());
            ofFloat2.setInterpolator(new com.anythink.basead.ui.BaseShakeView.AnonymousClass3());
            this.a.post(new com.anythink.basead.ui.BaseShakeView.AnonymousClass4());
            return ofFloat2;
        }
        android.animation.ValueAnimator ofFloat3 = android.animation.ValueAnimator.ofFloat(-10.0f, 10.0f);
        ofFloat3.setDuration(150L);
        ofFloat3.setRepeatMode(2);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.addUpdateListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass10());
        ofFloat3.addListener(new com.anythink.basead.ui.BaseShakeView.AnonymousClass11());
        ofFloat3.setInterpolator(new com.anythink.basead.ui.BaseShakeView.AnonymousClass12());
        this.a.post(new com.anythink.basead.ui.BaseShakeView.AnonymousClass13());
        return ofFloat3;
    }

    public abstract void a();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            android.animation.ValueAnimator a2 = a(this.d);
            this.c = a2;
            if (a2 != null) {
                a2.start();
            }
        }
        com.anythink.expressad.shake.a.a().a(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.anythink.expressad.shake.a.a().b(this.j);
    }

    public void setOnShakeListener(com.anythink.basead.ui.BaseShakeView.a aVar, com.anythink.core.common.f.n nVar) {
        this.j.a(nVar.R(), nVar.S());
        this.l = aVar;
    }

    public void setShakeSetting(com.anythink.core.common.f.n nVar) {
        this.d = nVar.a();
        this.e = nVar.b();
        this.f = nVar.c();
        this.g = nVar.d();
        this.h = nVar.e();
        if (android.text.TextUtils.isEmpty(this.e)) {
            c();
        } else {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.ui.BaseShakeView.AnonymousClass5(), 2, true);
        }
    }
}
