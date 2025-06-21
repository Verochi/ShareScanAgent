package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class GestureG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    android.widget.ImageView c;
    android.widget.ImageView d;
    android.widget.TextView e;
    android.view.animation.Animation f;
    int g;
    android.widget.RelativeLayout h;
    com.anythink.basead.ui.guidetoclickv2.d i;
    private boolean j;
    private float k;
    private float l;
    private int m;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.getMeasuredWidth() < com.anythink.core.common.o.i.a(com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.getContext(), 182.0f)) {
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.d.getLayoutParams();
                layoutParams.width = -1;
                com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.d.setLayoutParams(layoutParams);
            }
            com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.d.setVisibility(0);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.ui.guidetoclickv2.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.c
        public final boolean a(android.view.MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.k = motionEvent.getX();
                return false;
            }
            if (action == 1) {
                if (com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.l <= com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.m) {
                    return false;
                }
                com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.b;
                if (aVar != null) {
                    aVar.a(11, 15);
                }
                return true;
            }
            if (action != 2) {
                return false;
            }
            com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.b(com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this, java.lang.Math.abs(motionEvent.getX() - com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.k));
            com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.this.k = motionEvent.getX();
            return false;
        }
    }

    public GestureG2CV2View(android.content.Context context) {
        super(context);
        this.j = false;
    }

    public static /* synthetic */ float b(com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View gestureG2CV2View, float f) {
        float f2 = gestureG2CV2View.l + f;
        gestureG2CV2View.l = f2;
        return f2;
    }

    private void c() {
        if (this.f == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, -this.g, 0.0f, 0.0f);
            this.f = translateAnimation;
            translateAnimation.setDuration(1000L);
            this.f.setRepeatCount(-1);
            this.f.setRepeatMode(2);
            this.c.startAnimation(this.f);
        }
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
        android.view.animation.Animation animation = this.f;
        if (animation != null) {
            animation.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_gesture", "layout"), this);
        this.m = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.c = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_slide_finger", "id"));
        this.d = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_white_line", "id"));
        this.e = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_slide_hint", "id"));
        this.h = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.g = com.anythink.core.common.o.i.a(getContext(), 36.0f);
        if (i == 1 || i == 3) {
            this.h.setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_gesture_bg", com.anythink.expressad.foundation.h.i.c));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 270.0f), com.anythink.core.common.o.i.a(getContext(), 100.0f));
            layoutParams.addRule(13);
            this.h.setLayoutParams(layoutParams);
            this.d.setVisibility(0);
        } else if (i == 2) {
            this.h.setBackgroundColor(android.graphics.Color.parseColor("#80000000"));
            this.d.setVisibility(0);
            if (this.j) {
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams2.width = com.anythink.core.common.o.i.a(getContext(), 240.0f);
                this.d.setLayoutParams(layoutParams2);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams3 = this.c.getLayoutParams();
            layoutParams3.height = com.anythink.core.common.o.i.a(getContext(), 24.0f);
            layoutParams3.width = com.anythink.core.common.o.i.a(getContext(), 24.0f);
            this.g = com.anythink.core.common.o.i.a(getContext(), 24.0f);
            this.c.setLayoutParams(layoutParams3);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams4.width = com.anythink.core.common.o.i.a(getContext(), 150.0f);
            layoutParams4.height = com.anythink.core.common.o.i.a(getContext(), 4.0f);
            layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, com.anythink.core.common.o.i.a(getContext(), 8.0f));
            this.d.setLayoutParams(layoutParams4);
            android.widget.LinearLayout.LayoutParams layoutParams5 = (android.widget.LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams5.setMargins(com.anythink.core.common.o.i.a(getContext(), 8.0f), layoutParams5.topMargin, layoutParams5.rightMargin, layoutParams5.bottomMargin);
            this.e.setTextSize(1, 10.0f);
            setBackgroundColor(android.graphics.Color.parseColor("#80000000"));
            post(new com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.AnonymousClass1());
        }
        if (this.f == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, -this.g, 0.0f, 0.0f);
            this.f = translateAnimation;
            translateAnimation.setDuration(1000L);
            this.f.setRepeatCount(-1);
            this.f.setRepeatMode(2);
            this.c.startAnimation(this.f);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void b() {
        super.b();
        android.view.animation.Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
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
        this.i = dVar;
        if (dVar != null) {
            dVar.setCallback(new com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View.AnonymousClass2());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.anythink.basead.ui.guidetoclickv2.d dVar = this.i;
        if (dVar != null) {
            dVar.setCallback(null);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        android.view.animation.Animation animation = this.f;
        if (animation != null) {
            animation.cancel();
        }
    }

    public void setVerticalLandscape(boolean z) {
        this.j = z;
    }
}
