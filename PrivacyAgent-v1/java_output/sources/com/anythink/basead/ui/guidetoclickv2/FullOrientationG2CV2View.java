package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class FullOrientationG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    android.animation.ValueAnimator c;
    android.widget.ImageView d;
    com.anythink.basead.ui.guidetoclickv2.d e;
    private int f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            if (com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.d != null) {
                float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.f % 4;
                if (i == 1) {
                    com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.d.setTranslationY(floatValue);
                    return;
                }
                if (i == 2) {
                    com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.d.setTranslationX(-floatValue);
                } else if (i != 3) {
                    com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.d.setTranslationY(-floatValue);
                } else {
                    com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.d.setTranslationX(floatValue);
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(android.animation.Animator animator) {
            super.onAnimationRepeat(animator);
            com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.b(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.ui.guidetoclickv2.c {
        public AnonymousClass3() {
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.c
        public final boolean a(android.view.MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.g = motionEvent.getX();
                com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.h = motionEvent.getY();
                return false;
            }
            if (action == 1) {
                if (com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.i + com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.j <= com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.k) {
                    return false;
                }
                com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.b;
                if (aVar != null) {
                    aVar.a(11, 21);
                }
                return true;
            }
            if (action != 2) {
                return false;
            }
            float x = motionEvent.getX() - com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.g;
            float y = motionEvent.getY() - com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.h;
            com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.c(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this, java.lang.Math.abs(x));
            com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.d(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this, java.lang.Math.abs(y));
            com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.g = motionEvent.getX();
            com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.this.h = motionEvent.getY();
            return false;
        }
    }

    public FullOrientationG2CV2View(android.content.Context context) {
        super(context);
        this.f = 0;
    }

    public static /* synthetic */ int b(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View fullOrientationG2CV2View) {
        int i = fullOrientationG2CV2View.f;
        fullOrientationG2CV2View.f = i + 1;
        return i;
    }

    public static /* synthetic */ float c(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View fullOrientationG2CV2View, float f) {
        float f2 = fullOrientationG2CV2View.i + f;
        fullOrientationG2CV2View.i = f2;
        return f2;
    }

    private void c() {
        if (this.c == null) {
            android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, com.anythink.core.common.o.i.a(getContext(), 12.0f), 0.0f);
            this.c = ofFloat;
            ofFloat.setDuration(500L);
            this.c.setRepeatCount(-1);
            this.c.addUpdateListener(new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.AnonymousClass1());
            this.c.addListener(new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.AnonymousClass2());
        }
    }

    public static /* synthetic */ float d(com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View fullOrientationG2CV2View, float f) {
        float f2 = fullOrientationG2CV2View.j + f;
        fullOrientationG2CV2View.j = f2;
        return f2;
    }

    private com.anythink.basead.ui.guidetoclickv2.d d() {
        for (android.view.ViewParent parent = getParent(); parent.getParent() != null; parent = parent.getParent()) {
            if (parent instanceof com.anythink.basead.ui.guidetoclickv2.d) {
                return (com.anythink.basead.ui.guidetoclickv2.d) parent;
            }
        }
        return null;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a() {
        super.a();
        android.animation.ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_full_orientation", "layout"), this);
        this.k = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.d = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_fullori_finger", "id"));
        if (this.c == null) {
            android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.0f, com.anythink.core.common.o.i.a(getContext(), 12.0f), 0.0f);
            this.c = ofFloat;
            ofFloat.setDuration(500L);
            this.c.setRepeatCount(-1);
            this.c.addUpdateListener(new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.AnonymousClass1());
            this.c.addListener(new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.AnonymousClass2());
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void b() {
        super.b();
        android.animation.ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        com.anythink.basead.ui.guidetoclickv2.d dVar;
        super.onAttachedToWindow();
        android.view.ViewParent parent = getParent();
        while (true) {
            if (parent.getParent() == null) {
                dVar = null;
                break;
            } else {
                if (parent instanceof com.anythink.basead.ui.guidetoclickv2.d) {
                    dVar = (com.anythink.basead.ui.guidetoclickv2.d) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.e = dVar;
        if (dVar != null) {
            dVar.setCallback(new com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.AnonymousClass3());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.anythink.basead.ui.guidetoclickv2.d dVar = this.e;
        if (dVar != null) {
            dVar.setCallback(null);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        android.animation.ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
