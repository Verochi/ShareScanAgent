package com.anythink.basead.ui.animplayerview.viewpager;

/* loaded from: classes12.dex */
public class VpMainImgAnimatorView extends android.widget.RelativeLayout implements com.anythink.basead.ui.animplayerview.c {
    private static final java.lang.String a = "VpMainImgView";
    private static final int b = 100;
    private static final int c = 1500;
    private static final int d = 500;
    private static final int e = 8;
    private com.anythink.basead.ui.WrapRoundImageView f;
    private com.anythink.basead.ui.WrapRoundImageView g;
    private com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView h;
    private com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView i;
    private int j;
    private float k;
    private float l;
    private final android.os.Handler m;
    private android.animation.ObjectAnimator n;
    private android.animation.ObjectAnimator o;
    private android.animation.AnimatorSet p;

    /* renamed from: com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message.what == 100) {
                com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.a(com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.d();
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.animation.Animator.AnimatorListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.b();
            if (com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.m != null) {
                com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.m.removeMessages(100);
                com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.m.sendEmptyMessageDelayed(100, 1500L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(android.animation.Animator animator) {
        }
    }

    public class a implements android.animation.Animator.AnimatorListener {
        private final android.view.View b;

        public a(android.view.View view) {
            this.b = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            android.view.View view = this.b;
            if (view == null || view.getTranslationX() >= 0.0f) {
                return;
            }
            this.b.setTranslationX(com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.this.l);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(android.animation.Animator animator) {
        }
    }

    public VpMainImgAnimatorView(android.content.Context context) {
        this(context, null);
    }

    public VpMainImgAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VpMainImgAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.AnonymousClass1(android.os.Looper.getMainLooper());
    }

    private android.animation.ObjectAnimator a(android.animation.ObjectAnimator objectAnimator, android.view.View view, float f, float f2) {
        if (objectAnimator == null) {
            objectAnimator = new android.animation.ObjectAnimator();
            objectAnimator.setPropertyName("translationX");
            objectAnimator.addListener(new com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.a(view));
        }
        objectAnimator.setTarget(view);
        objectAnimator.setFloatValues(f, f2);
        return objectAnimator;
    }

    private void a() {
        this.h = new com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView(getContext());
        this.i = new com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView(getContext());
        int a2 = com.anythink.core.common.o.i.a(getContext(), 8.0f);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
        linearLayout.setOrientation(0);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(a2, a2);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(a2, a2);
        layoutParams2.leftMargin = com.anythink.core.common.o.i.a(getContext(), 4.0f);
        linearLayout.addView(this.h, layoutParams);
        linearLayout.addView(this.i, layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(14);
        layoutParams3.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 3.0f);
        addView(linearLayout, layoutParams3);
        b();
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView vpMainImgAnimatorView) {
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = vpMainImgAnimatorView.f;
        if (wrapRoundImageView == null || vpMainImgAnimatorView.g == null) {
            return;
        }
        if (vpMainImgAnimatorView.j == 0) {
            wrapRoundImageView.post(vpMainImgAnimatorView.new AnonymousClass2());
        } else {
            vpMainImgAnimatorView.d();
        }
    }

    private float[] a(android.view.View view) {
        float[] fArr = new float[2];
        float translationX = view.getTranslationX();
        float f = this.k;
        if (translationX != f) {
            f = this.l;
        }
        fArr[0] = f;
        float translationX2 = view.getTranslationX();
        float f2 = this.k;
        if (translationX2 == f2) {
            f2 = -this.l;
        }
        fArr[1] = f2;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView;
        if (this.h == null || this.i == null || (wrapRoundImageView = this.f) == null) {
            return;
        }
        if (wrapRoundImageView.getTranslationX() == this.k) {
            this.h.setSelectStatus(true);
            this.i.setSelectStatus(false);
        } else {
            this.h.setSelectStatus(false);
            this.i.setSelectStatus(true);
        }
    }

    private void c() {
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = this.f;
        if (wrapRoundImageView == null || this.g == null) {
            return;
        }
        if (this.j == 0) {
            wrapRoundImageView.post(new com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.AnonymousClass2());
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        float[] a2 = a(this.f);
        float[] a3 = a(this.g);
        this.n = a(this.n, this.f, a2[0], a2[1]);
        this.o = a(this.o, this.g, a3[0], a3[1]);
        if (this.p == null) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            this.p = animatorSet;
            animatorSet.playTogether(this.n, this.o);
            this.p.setDuration(500L);
            this.p.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
            this.p.addListener(new com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView.AnonymousClass3());
        }
        this.p.start();
    }

    @Override // com.anythink.basead.ui.animplayerview.c
    public void addMainView(android.graphics.Bitmap bitmap, com.anythink.basead.ui.WrapRoundImageView... wrapRoundImageViewArr) {
        if (wrapRoundImageViewArr == null || bitmap == null || wrapRoundImageViewArr.length < 2) {
            return;
        }
        removeAllViews();
        this.f = wrapRoundImageViewArr[0];
        this.g = wrapRoundImageViewArr[1];
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        layoutParams2.addRule(13);
        this.f.setLayoutParams(layoutParams);
        this.g.setLayoutParams(layoutParams2);
        addView(this.f);
        addView(this.g);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int i2 = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f.setBitmapAndResize(bitmap, i, i2);
        this.g.setBitmapAndResize(bitmap, i, i2);
        android.view.ViewGroup.LayoutParams layoutParams3 = this.f.getLayoutParams();
        this.j = layoutParams3.width;
        int i3 = layoutParams3.height;
        android.view.ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
        layoutParams4.width = this.j;
        layoutParams4.height = i3;
        setLayoutParams(layoutParams4);
        float translationX = this.f.getTranslationX();
        this.k = translationX;
        float f = translationX + this.j;
        this.l = f;
        this.g.setTranslationX(f);
        this.h = new com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView(getContext());
        this.i = new com.anythink.basead.ui.animplayerview.viewpager.CircleIndicatorView(getContext());
        int a2 = com.anythink.core.common.o.i.a(getContext(), 8.0f);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
        linearLayout.setOrientation(0);
        android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(a2, a2);
        android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(a2, a2);
        layoutParams6.leftMargin = com.anythink.core.common.o.i.a(getContext(), 4.0f);
        linearLayout.addView(this.h, layoutParams5);
        linearLayout.addView(this.i, layoutParams6);
        android.widget.RelativeLayout.LayoutParams layoutParams7 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(12);
        layoutParams7.addRule(14);
        layoutParams7.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 3.0f);
        addView(linearLayout, layoutParams7);
        b();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        android.animation.AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.c
    public void release() {
        stop();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        android.animation.AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.resume();
            return;
        }
        android.os.Handler handler = this.m;
        if (handler != null) {
            handler.removeMessages(100);
            this.m.sendEmptyMessageDelayed(100, 1500L);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void start() {
        if (this.p != null) {
            resume();
            return;
        }
        android.os.Handler handler = this.m;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(100, 1500L);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        android.os.Handler handler = this.m;
        if (handler != null) {
            handler.removeMessages(100);
        }
        android.animation.ObjectAnimator objectAnimator = this.n;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.n = null;
        }
        android.animation.ObjectAnimator objectAnimator2 = this.o;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
            this.o = null;
        }
        android.animation.AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.p.cancel();
            this.p = null;
        }
    }
}
