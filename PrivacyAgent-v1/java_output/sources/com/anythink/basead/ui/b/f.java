package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public final class f extends com.anythink.basead.ui.b.b {
    com.anythink.basead.ui.BaseShakeView i;
    com.anythink.basead.ui.BaseShakeView j;
    private boolean p = false;
    final long k = 3000;
    final long l = 500;
    boolean m = false;
    boolean n = false;
    boolean o = false;

    /* renamed from: com.anythink.basead.ui.b.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.anythink.basead.ui.b.f$1$1, reason: invalid class name and collision with other inner class name */
        public class C01491 implements android.animation.ValueAnimator.AnimatorUpdateListener {
            public C01491() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                if (com.anythink.basead.ui.b.f.this.i.getVisibility() == 0) {
                    com.anythink.basead.ui.b.f.this.i.setAlpha(floatValue);
                }
                com.anythink.basead.ui.BaseShakeView baseShakeView = com.anythink.basead.ui.b.f.this.j;
                if (baseShakeView == null || baseShakeView.getVisibility() != 0) {
                    return;
                }
                com.anythink.basead.ui.b.f.this.j.setAlpha(floatValue);
            }
        }

        /* renamed from: com.anythink.basead.ui.b.f$1$2, reason: invalid class name */
        public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(android.animation.Animator animator) {
                super.onAnimationRepeat(animator);
                com.anythink.basead.ui.b.f.this.i.setVisibility(8);
                com.anythink.basead.ui.b.f fVar = com.anythink.basead.ui.b.f.this;
                if (fVar.j == null || !fVar.g()) {
                    return;
                }
                com.anythink.basead.ui.b.f.this.j.setAlpha(0.2f);
                com.anythink.basead.ui.b.f.this.j.setVisibility(0);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.b.f.this.g()) {
                try {
                    android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.2f);
                    ofFloat.setDuration(500L);
                    ofFloat.setRepeatCount(1);
                    ofFloat.setRepeatMode(2);
                    ofFloat.addUpdateListener(new com.anythink.basead.ui.b.f.AnonymousClass1.C01491());
                    ofFloat.addListener(new com.anythink.basead.ui.b.f.AnonymousClass1.AnonymousClass2());
                    ofFloat.start();
                } catch (java.lang.Throwable unused) {
                    com.anythink.basead.ui.b.f.this.i.setVisibility(8);
                    com.anythink.basead.ui.b.f fVar = com.anythink.basead.ui.b.f.this;
                    if (fVar.j == null || !fVar.g()) {
                        return;
                    }
                    com.anythink.basead.ui.b.f.this.j.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.b.f$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.b.f.this.h;
            if (aVar != null) {
                aVar.a(1, 5);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.b.f$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.ui.BaseShakeView.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.basead.ui.BaseShakeView.a
        public final boolean a() {
            if (!com.anythink.basead.ui.b.f.this.b()) {
                return false;
            }
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.b.f.this.h;
            if (aVar == null) {
                return true;
            }
            aVar.a(4, 5);
            return true;
        }
    }

    private void a(com.anythink.basead.ui.BaseShakeView baseShakeView) {
        baseShakeView.setOnClickListener(new com.anythink.basead.ui.b.f.AnonymousClass2());
        baseShakeView.setOnShakeListener(new com.anythink.basead.ui.b.f.AnonymousClass3(), this.c.n);
    }

    private void c() {
        android.widget.RelativeLayout relativeLayout;
        android.view.View view = this.g;
        int indexOfChild = (view == null || this.d.indexOfChild(view) <= 0) ? -1 : this.d.indexOfChild(this.g);
        if (this.e == 3) {
            com.anythink.basead.ui.BaseShakeView baseShakeView = this.i;
            if (baseShakeView != null) {
                com.anythink.core.common.o.w.a(baseShakeView);
                this.i.setVisibility(0);
                this.d.addView(this.i, indexOfChild);
                return;
            }
            return;
        }
        try {
            relativeLayout = (android.widget.RelativeLayout) this.d.findViewById(com.anythink.core.common.o.i.a(this.a, "myoffer_end_card_id", "id"));
        } catch (java.lang.Throwable unused) {
            relativeLayout = null;
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView2 = this.i;
        if (baseShakeView2 != null) {
            com.anythink.core.common.o.w.a(baseShakeView2);
            this.i.setVisibility(8);
            if (relativeLayout != null) {
                relativeLayout.addView(this.i);
            } else {
                this.d.addView(this.i, indexOfChild);
            }
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView3 = this.j;
        if (baseShakeView3 != null) {
            com.anythink.core.common.o.w.a(baseShakeView3);
            this.j.setVisibility(8);
            if (relativeLayout != null) {
                relativeLayout.addView(this.j);
            } else {
                this.d.addView(this.j, indexOfChild);
            }
        }
    }

    private void d() {
        if (this.i == null || this.j == null || this.p || !g()) {
            return;
        }
        this.p = true;
        this.i.setVisibility(0);
        this.i.postDelayed(new com.anythink.basead.ui.b.f.AnonymousClass1(), 3000L);
    }

    private void e() {
        f();
        if (this.j == null || this.e != 1 || com.anythink.basead.a.d.b(this.b) || com.anythink.basead.a.d.a(this.b) || this.c.n.D() != 0) {
            return;
        }
        this.j.setAlpha(1.0f);
        this.j.setVisibility(0);
    }

    private void f() {
        com.anythink.basead.ui.BaseShakeView baseShakeView = this.i;
        if (baseShakeView != null) {
            baseShakeView.setVisibility(8);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView2 = this.j;
        if (baseShakeView2 != null) {
            baseShakeView2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return (this.e == 1 && com.anythink.basead.a.d.a(this.b, this.c) && this.m) ? false : true;
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a() {
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        boolean z = false;
        if (i == 102) {
            this.m = true;
            if (this.e == 1 && com.anythink.basead.a.d.a(this.b, this.c)) {
                f();
                if (this.j == null || this.e != 1 || com.anythink.basead.a.d.b(this.b) || com.anythink.basead.a.d.a(this.b) || this.c.n.D() != 0) {
                    return;
                }
                this.j.setAlpha(1.0f);
                this.j.setVisibility(0);
                return;
            }
            return;
        }
        if (i == 105) {
            f();
            return;
        }
        if (i == 106) {
            if (this.e == 3 && com.anythink.basead.a.d.b(this.b)) {
                c();
                return;
            }
            return;
        }
        if (i == 110) {
            this.n = true;
            return;
        }
        if (i == 111) {
            this.n = false;
            return;
        }
        switch (i) {
            case 114:
                if (this.e == 1) {
                    c();
                    d();
                }
                if (map != null) {
                    java.lang.Object obj = map.get(com.anythink.basead.ui.b.e.a.a);
                    if ((obj instanceof java.lang.Integer) && ((java.lang.Integer) obj).intValue() == 1) {
                        z = true;
                    }
                }
                if (z || (this.e == 2 && !com.anythink.basead.a.d.a(this.b))) {
                    c();
                    d();
                    break;
                }
                break;
            case 115:
                this.o = true;
                break;
            case 116:
                if (this.e == 3 && !com.anythink.basead.a.d.b(this.b)) {
                    c();
                    break;
                }
                break;
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.view.View view, int i, com.anythink.basead.ui.b.b.a aVar) {
        super.a(context, lVar, mVar, viewGroup, relativeLayout, view, i, aVar);
        boolean z = true;
        if (this.e != 3) {
            this.i = new com.anythink.basead.ui.ShakeThumbView(context);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.i.setLayoutParams(layoutParams);
            this.j = new com.anythink.basead.ui.ShakeBorderThumbView(context);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            if (i == 1 && com.anythink.core.common.o.e.g(context) == 2) {
                layoutParams2.addRule(12);
                layoutParams2.setMargins(0, 0, 0, com.anythink.core.common.o.i.a(context, 192.0f));
            } else {
                layoutParams2.addRule(15);
            }
            this.j.setLayoutParams(layoutParams2);
            a(this.i);
            a(this.j);
        } else {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if ((this.c.n.ao() != 1 || android.text.TextUtils.isEmpty(this.c.n.aq())) && !this.c.n.ab() && !this.c.n.al()) {
                z = false;
            }
            if (this.b.j()) {
                if (z) {
                    this.i = new com.anythink.basead.ui.ShakeBorderThumbView(context);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(15);
                } else {
                    this.i = new com.anythink.basead.ui.ShakeThumbView(context);
                    layoutParams3.addRule(13);
                    this.i.setPadding(0, 0, 0, com.anythink.core.common.o.i.a(context, 26.0f));
                }
            } else if (com.anythink.basead.ui.BaseSdkSplashATView.isSinglePicture(this.b, this.c.n)) {
                this.i = new com.anythink.basead.ui.ShakeView(context);
                layoutParams3.addRule(14);
                layoutParams3.addRule(12);
                int a = this.c.n.w() == 2 ? com.anythink.core.common.o.i.a(context, 46.0f) : com.anythink.core.common.o.i.a(context, 63.0f);
                if (this.c.n.al()) {
                    a = com.anythink.core.common.o.i.a(context, 100.0f);
                }
                ((com.anythink.basead.ui.ShakeView) this.i).setNeedHideShakeIcon(z);
                layoutParams3.setMargins(0, 0, 0, a);
                if (lVar.d() == 4) {
                    java.lang.String directlySplashAdShakeIconString = com.anythink.core.api.ATSDKGlobalSetting.getDirectlySplashAdShakeIconString();
                    if (!android.text.TextUtils.isEmpty(directlySplashAdShakeIconString)) {
                        ((com.anythink.basead.ui.ShakeView) this.i).setShakeHintText(directlySplashAdShakeIconString);
                    }
                }
            } else if (z) {
                this.i = new com.anythink.basead.ui.ShakeBorderThumbView(context);
                layoutParams3.addRule(11);
                layoutParams3.addRule(15);
            } else {
                this.i = new com.anythink.basead.ui.ShakeThumbView(context);
                layoutParams3.addRule(13);
                if (this.c.n.w() == 2) {
                    this.i.setPadding(0, 0, 0, com.anythink.core.common.o.i.a(context, 26.0f));
                } else {
                    this.i.setPadding(0, 0, 0, com.anythink.core.common.o.i.a(context, 92.0f));
                }
            }
            this.i.setLayoutParams(layoutParams3);
            a(this.i);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView = this.i;
        if (baseShakeView != null) {
            baseShakeView.setShakeSetting(this.c.n);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView2 = this.j;
        if (baseShakeView2 != null) {
            baseShakeView2.setShakeSetting(this.c.n);
        }
    }

    public final boolean b() {
        int i = this.e;
        if (i == 3 || !this.n) {
            return i == 3 && !this.o;
        }
        return true;
    }
}
