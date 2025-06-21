package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public final class b {
    private android.view.ViewGroup a;
    private android.widget.ImageView b;
    private int c;

    /* renamed from: com.anythink.basead.ui.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.basead.ui.b.this.a instanceof android.widget.RelativeLayout) {
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.basead.ui.b.this.c, com.anythink.basead.ui.b.this.c);
                    layoutParams.addRule(13);
                    com.anythink.basead.ui.b.this.a.addView(com.anythink.basead.ui.b.this.b, layoutParams);
                } else if (com.anythink.basead.ui.b.this.a instanceof android.widget.FrameLayout) {
                    android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(com.anythink.basead.ui.b.this.c, com.anythink.basead.ui.b.this.c);
                    layoutParams2.gravity = 17;
                    com.anythink.basead.ui.b.this.a.addView(com.anythink.basead.ui.b.this.b, layoutParams2);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.basead.ui.b.this.b.setAlpha(1.0f);
                android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setInterpolator(new android.view.animation.LinearInterpolator());
                rotateAnimation.setRepeatCount(-1);
                com.anythink.basead.ui.b.this.b.startAnimation(rotateAnimation);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.basead.ui.b.this.b.clearAnimation();
                com.anythink.basead.ui.b.this.b.setAlpha(0.0f);
                com.anythink.basead.ui.b.this.a.removeView(com.anythink.basead.ui.b.this.b);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public b(android.view.ViewGroup viewGroup) {
        this.a = viewGroup;
        android.widget.ImageView imageView = new android.widget.ImageView(this.a.getContext());
        this.b = imageView;
        imageView.setId(com.anythink.core.common.o.i.a(this.a.getContext(), "myoffer_loading_id", "id"));
        this.b.setImageResource(com.anythink.core.common.o.i.a(this.a.getContext(), "myoffer_loading", com.anythink.expressad.foundation.h.i.c));
        this.c = (int) android.util.TypedValue.applyDimension(1, 50.0f, this.a.getResources().getDisplayMetrics());
    }

    private void d() {
        android.widget.ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new com.anythink.basead.ui.b.AnonymousClass1());
    }

    public final void a() {
        this.c = (int) android.util.TypedValue.applyDimension(1, 30.0f, this.a.getResources().getDisplayMetrics());
    }

    public final void b() {
        android.widget.ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new com.anythink.basead.ui.b.AnonymousClass1());
        this.b.post(new com.anythink.basead.ui.b.AnonymousClass2());
    }

    public final void c() {
        if (this.b != null) {
            this.a.post(new com.anythink.basead.ui.b.AnonymousClass3());
        }
    }
}
