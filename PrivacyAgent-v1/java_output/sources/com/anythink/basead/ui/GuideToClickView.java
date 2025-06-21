package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class GuideToClickView extends android.widget.RelativeLayout {
    com.anythink.basead.ui.WaveAnimImageView a;
    com.anythink.basead.ui.WaveAnimImageView b;
    android.widget.ImageView c;
    android.widget.TextView d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    final int k;
    final int l;
    final float m;
    android.animation.ValueAnimator n;
    android.animation.ValueAnimator o;
    android.view.animation.ScaleAnimation p;

    /* renamed from: com.anythink.basead.ui.GuideToClickView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ com.anythink.basead.ui.WaveAnimImageView a;

        public AnonymousClass1(com.anythink.basead.ui.WaveAnimImageView waveAnimImageView) {
            this.a = waveAnimImageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float f;
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue > 0.71428573f) {
                this.a.setVisibility(4);
                return;
            }
            float f2 = floatValue / 0.71428573f;
            com.anythink.basead.ui.GuideToClickView guideToClickView = com.anythink.basead.ui.GuideToClickView.this;
            float f3 = guideToClickView.i;
            float f4 = ((guideToClickView.j - f3) * f2) + f3;
            float f5 = guideToClickView.g + ((guideToClickView.h - f3) * f2);
            double d = f2;
            if (d < 0.2d) {
                f = (float) (guideToClickView.e + ((1.0d - ((f2 * 1.0f) / 0.2d)) * (guideToClickView.f - r1)));
            } else {
                f = (float) (guideToClickView.e + ((((d - 0.2d) * 1.0d) / 0.8d) * (guideToClickView.f - r13)));
            }
            try {
                if (guideToClickView.getVisibility() == 0) {
                    this.a.setWaveAnimParams(new com.anythink.basead.ui.WaveAnimImageView.a(f4, f5, f));
                    if (this.a.getVisibility() != 0) {
                        this.a.setVisibility(0);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        public static final int a = 501;
        public static final int b = 502;
        public static final int c = 503;
        public static final int d = 504;
        public static final int e = 505;
        public static final int f = 506;
        public static final int g = 507;
    }

    public GuideToClickView(android.content.Context context) {
        super(context);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    public GuideToClickView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 1000;
        this.l = 200;
        this.m = 0.71428573f;
        a(context);
    }

    private void a() {
        startAnim(this.n, this.a, 0L);
        startAnim(this.o, this.b, 800L);
        this.c.startAnimation(this.p);
    }

    private void a(android.content.Context context) {
        android.view.LayoutInflater.from(context).inflate(com.anythink.core.common.o.i.a(context, "myoffer_guide_to_click", "layout"), this);
        setBackgroundColor(android.graphics.Color.parseColor("#66000000"));
        this.e = 0.8f;
        this.f = 0.05f;
        this.g = com.anythink.core.common.o.i.a(context, 4.0f);
        this.h = com.anythink.core.common.o.i.a(context, 18.0f);
        this.i = com.anythink.core.common.o.i.a(context, 2.0f);
        this.j = com.anythink.core.common.o.i.a(context, 40.0f);
        this.a = (com.anythink.basead.ui.WaveAnimImageView) findViewById(com.anythink.core.common.o.i.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (com.anythink.basead.ui.WaveAnimImageView) findViewById(com.anythink.core.common.o.i.a(context, "myoffer_wave_anim_image2", "id"));
        this.n = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.c = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide_to_click_finger", "id"));
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.p = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.p.setRepeatCount(-1);
        this.p.setDuration(333L);
        this.d = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(context, "myoffer_guide_to_click_hint", "id"));
    }

    private void b() {
        android.animation.ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        android.view.animation.ScaleAnimation scaleAnimation = this.p;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim(this.n, this.a, 0L);
        startAnim(this.o, this.b, 800L);
        this.c.startAnimation(this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        android.view.animation.ScaleAnimation scaleAnimation = this.p;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void setFingerImageResource(android.graphics.Bitmap bitmap) {
        android.widget.ImageView imageView = this.c;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    public void setFingerViewMode(int i) {
        int a2;
        int a3;
        setBackgroundColor(0);
        com.anythink.core.common.o.i.a(getContext(), 200.0f);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.a.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.b.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.c.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.d.getLayoutParams();
        switch (i) {
            case 501:
            case com.anythink.basead.ui.GuideToClickView.a.g /* 507 */:
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                break;
            case 502:
            case 503:
                if (i == 502) {
                    a2 = com.anythink.core.common.o.i.a(getContext(), 100.0f);
                    this.d.setTextSize(1, 14.0f);
                    this.h = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                    this.j = com.anythink.core.common.o.i.a(getContext(), 30.0f);
                } else {
                    a2 = com.anythink.core.common.o.i.a(getContext(), 160.0f);
                    this.d.setTextSize(1, 16.0f);
                }
                layoutParams.width = a2;
                layoutParams.height = a2;
                layoutParams.addRule(14);
                layoutParams.addRule(13, 0);
                layoutParams2.width = a2;
                layoutParams2.height = a2;
                layoutParams2.addRule(14);
                layoutParams2.addRule(13, 0);
                int i2 = a2 / 2;
                layoutParams3.width = i2;
                layoutParams3.height = (int) ((a2 / 2.0d) * 1.1d);
                layoutParams3.setMargins(i2, i2, 0, 0);
                break;
            case 504:
            case com.anythink.basead.ui.GuideToClickView.a.e /* 505 */:
            case com.anythink.basead.ui.GuideToClickView.a.f /* 506 */:
                if (i == 505 || i == 504) {
                    a3 = com.anythink.core.common.o.i.a(getContext(), 50.0f);
                    this.h = com.anythink.core.common.o.i.a(getContext(), 6.0f);
                    this.j = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                } else {
                    a3 = com.anythink.core.common.o.i.a(getContext(), 120.0f);
                    this.h = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                    this.j = com.anythink.core.common.o.i.a(getContext(), 24.0f);
                }
                layoutParams.width = a3;
                layoutParams.height = a3;
                layoutParams.addRule(15);
                layoutParams.addRule(13, 0);
                this.a.setLayoutParams(layoutParams);
                layoutParams2.width = a3;
                layoutParams2.height = a3;
                layoutParams2.addRule(15);
                layoutParams2.addRule(13, 0);
                this.b.setLayoutParams(layoutParams2);
                int i3 = a3 / 2;
                layoutParams3.width = i3;
                layoutParams3.height = (int) ((a3 / 2.0d) * 1.1d);
                layoutParams3.setMargins(i3, i3, 0, 0);
                this.c.setLayoutParams(layoutParams3);
                layoutParams4.addRule(14, 0);
                layoutParams4.addRule(3, 0);
                layoutParams4.addRule(15);
                layoutParams4.addRule(1, this.a.getId());
                layoutParams4.setMargins(com.anythink.core.common.o.i.a(getContext(), 6.0f), 0, com.anythink.core.common.o.i.a(getContext(), 10.0f), 0);
                this.d.setLayoutParams(layoutParams4);
                this.d.setTextSize(1, 12.0f);
                break;
        }
    }

    public void startAnim(android.animation.ValueAnimator valueAnimator, com.anythink.basead.ui.WaveAnimImageView waveAnimImageView, long j) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new com.anythink.basead.ui.GuideToClickView.AnonymousClass1(waveAnimImageView));
            valueAnimator.setStartDelay(j);
            valueAnimator.start();
        }
    }
}
