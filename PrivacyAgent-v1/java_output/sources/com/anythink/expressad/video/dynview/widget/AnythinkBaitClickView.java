package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class AnythinkBaitClickView extends android.widget.RelativeLayout {
    public static final int ANIMATION_TYPE_DOUBLE_CLICK = 4;
    public static final int ANIMATION_TYPE_FAST_SCALE = 1;
    public static final int ANIMATION_TYPE_ROTATE = 5;
    public static final int ANIMATION_TYPE_SLOW_SCALE = 2;
    public static final int ANIMATION_TYPE_SLOW_SCALE_WITH_PAUSE = 3;
    private static final java.lang.String a = "MBridgeAnimationClickView";
    private com.anythink.expressad.video.dynview.widget.ATImageView b;
    private com.anythink.expressad.video.dynview.widget.ATImageView c;
    private android.widget.TextView d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private int h;
    private int i;
    private android.view.animation.Animation j;
    private android.view.animation.Animation k;
    private android.view.animation.Animation l;
    private android.view.animation.Animation m;

    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap.isRecycled()) {
                return;
            }
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c.setImageResource(this.a);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap.isRecycled()) {
                return;
            }
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b.setImageResource(this.a);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.animation.Animation.AnimationListener {
        public AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            if (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c != null) {
                com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
            if (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c != null) {
                com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ android.view.animation.AnimationSet a;

        /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c != null) {
                    com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.c.startAnimation(com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass4.this.a);
                }
            }
        }

        /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$4$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b != null) {
                    com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b.startAnimation(com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.j);
                }
            }
        }

        public AnonymousClass4(android.view.animation.AnimationSet animationSet) {
            this.a = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.postDelayed(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass4.AnonymousClass2(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.postDelayed(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass4.AnonymousClass1(), 550L);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.animation.Animation.AnimationListener {

        /* renamed from: com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b != null) {
                    com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.b.startAnimation(com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.j);
                }
            }
        }

        public AnonymousClass5() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.this.postDelayed(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass5.AnonymousClass1(), 1000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public AnythinkBaitClickView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    public AnythinkBaitClickView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    public AnythinkBaitClickView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    @androidx.annotation.RequiresApi(api = 21)
    public AnythinkBaitClickView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = "";
        this.f = "";
        this.g = "Click now for details";
        this.h = 1;
        this.i = 1342177280;
    }

    private void a() {
        try {
            this.g = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_click_for_detail", com.anythink.expressad.foundation.h.i.g));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void b() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(2);
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.b;
        if (aTImageView != null) {
            aTImageView.startAnimation(this.j);
        }
        android.view.animation.ScaleAnimation scaleAnimation2 = new android.view.animation.ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation2;
        scaleAnimation2.setDuration(400L);
        this.k.setRepeatCount(-1);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.3f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(400L);
        this.l.setRepeatCount(-1);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.c;
        if (aTImageView2 != null) {
            aTImageView2.startAnimation(animationSet);
        }
    }

    private void c() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(2);
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.b;
        if (aTImageView != null) {
            aTImageView.startAnimation(this.j);
        }
    }

    private void d() {
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.c;
        if (aTImageView != null) {
            aTImageView.setVisibility(4);
        }
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.j.setRepeatCount(1);
        this.j.setRepeatMode(2);
        android.view.animation.ScaleAnimation scaleAnimation2 = new android.view.animation.ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation2;
        scaleAnimation2.setDuration(1000L);
        this.k.setRepeatCount(0);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(1000L);
        this.l.setRepeatCount(0);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        this.k.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass3());
        this.j.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass4(animationSet));
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.b;
        if (aTImageView2 != null) {
            aTImageView2.startAnimation(this.j);
        }
    }

    private void e() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.j = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.j.setRepeatCount(1);
        this.j.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass5());
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.b;
        if (aTImageView != null) {
            aTImageView.startAnimation(this.j);
        }
    }

    private void f() {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.m.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.k.setRepeatCount(-1);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(600L);
        this.l.setRepeatCount(-1);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.addAnimation(this.k);
        animationSet.addAnimation(this.l);
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.b;
        if (aTImageView != null) {
            aTImageView.startAnimation(this.m);
        }
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.c;
        if (aTImageView2 != null) {
            aTImageView2.startAnimation(animationSet);
        }
    }

    public void init() {
        try {
            setBackgroundColor(this.i);
            try {
                this.g = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_click_for_detail", com.anythink.expressad.foundation.h.i.g));
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
            int b = com.anythink.expressad.foundation.h.t.b(getContext(), 55.0f);
            int b2 = com.anythink.expressad.foundation.h.t.b(getContext(), 33.0f);
            this.c = new com.anythink.expressad.video.dynview.widget.ATImageView(getContext());
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(b, b);
            layoutParams.setMargins(b2, b2, 0, 0);
            this.c.setLayoutParams(layoutParams);
            int a2 = com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_icon_click_circle", com.anythink.expressad.foundation.h.i.c);
            if (android.text.TextUtils.isEmpty(this.f)) {
                this.c.setImageResource(a2);
            } else {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.e, new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass1(a2));
            }
            int b3 = com.anythink.expressad.foundation.h.t.b(getContext(), 108.0f);
            int b4 = com.anythink.expressad.foundation.h.t.b(getContext(), 35.0f);
            int b5 = com.anythink.expressad.foundation.h.t.b(getContext(), 43.0f);
            this.b = new com.anythink.expressad.video.dynview.widget.ATImageView(getContext());
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(b3, b3);
            layoutParams2.setMargins(b4, b5, 0, 0);
            this.b.setLayoutParams(layoutParams2);
            int a3 = com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_icon_click_hand", com.anythink.expressad.foundation.h.i.c);
            if (android.text.TextUtils.isEmpty(this.e)) {
                this.b.setImageResource(a3);
            } else {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.e, new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass2(a3));
            }
            relativeLayout.addView(this.c);
            relativeLayout.addView(this.b);
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.addView(relativeLayout);
            this.d = new android.widget.TextView(getContext());
            this.d.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
            this.d.setText(this.g);
            this.d.setTextColor(-1);
            this.d.setGravity(14);
            linearLayout.addView(this.d);
            addView(linearLayout);
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    public void init(int i) {
        this.h = i;
        init();
    }

    public void init(int i, int i2) {
        this.i = i;
        this.h = i2;
        init();
    }

    public void init(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.i = i;
        this.h = i2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
        android.view.animation.Animation animation = this.j;
        if (animation != null) {
            animation.cancel();
        }
        android.view.animation.Animation animation2 = this.k;
        if (animation2 != null) {
            animation2.cancel();
        }
        android.view.animation.Animation animation3 = this.l;
        if (animation3 != null) {
            animation3.cancel();
        }
        android.view.animation.Animation animation4 = this.m;
        if (animation4 != null) {
            animation4.cancel();
        }
    }

    public void startAnimation() {
        int i = this.h;
        if (i == 2) {
            this.c.setVisibility(4);
            android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation;
            scaleAnimation.setDuration(500L);
            this.j.setRepeatCount(-1);
            this.j.setRepeatMode(2);
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.b;
            if (aTImageView != null) {
                aTImageView.startAnimation(this.j);
                return;
            }
            return;
        }
        if (i == 3) {
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.c;
            if (aTImageView2 != null) {
                aTImageView2.setVisibility(4);
            }
            android.view.animation.ScaleAnimation scaleAnimation2 = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation2;
            scaleAnimation2.setDuration(500L);
            this.j.setRepeatCount(1);
            this.j.setRepeatMode(2);
            android.view.animation.ScaleAnimation scaleAnimation3 = new android.view.animation.ScaleAnimation(0.0f, 1.5f, 0.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            this.k = scaleAnimation3;
            scaleAnimation3.setDuration(1000L);
            this.k.setRepeatCount(0);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            this.l = alphaAnimation;
            alphaAnimation.setDuration(1000L);
            this.l.setRepeatCount(0);
            android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
            animationSet.addAnimation(this.k);
            animationSet.addAnimation(this.l);
            this.k.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass3());
            this.j.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass4(animationSet));
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView3 = this.b;
            if (aTImageView3 != null) {
                aTImageView3.startAnimation(this.j);
                return;
            }
            return;
        }
        if (i == 4) {
            this.c.setVisibility(4);
            android.view.animation.ScaleAnimation scaleAnimation4 = new android.view.animation.ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation4;
            scaleAnimation4.setDuration(200L);
            this.j.setRepeatCount(1);
            this.j.setAnimationListener(new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView.AnonymousClass5());
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView4 = this.b;
            if (aTImageView4 != null) {
                aTImageView4.startAnimation(this.j);
                return;
            }
            return;
        }
        if (i != 5) {
            android.view.animation.ScaleAnimation scaleAnimation5 = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            this.j = scaleAnimation5;
            scaleAnimation5.setDuration(200L);
            this.j.setRepeatCount(-1);
            this.j.setRepeatMode(2);
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView5 = this.b;
            if (aTImageView5 != null) {
                aTImageView5.startAnimation(this.j);
            }
            android.view.animation.ScaleAnimation scaleAnimation6 = new android.view.animation.ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
            this.k = scaleAnimation6;
            scaleAnimation6.setDuration(400L);
            this.k.setRepeatCount(-1);
            android.view.animation.AlphaAnimation alphaAnimation2 = new android.view.animation.AlphaAnimation(1.0f, 0.3f);
            this.l = alphaAnimation2;
            alphaAnimation2.setDuration(400L);
            this.l.setRepeatCount(-1);
            android.view.animation.AnimationSet animationSet2 = new android.view.animation.AnimationSet(true);
            animationSet2.addAnimation(this.k);
            animationSet2.addAnimation(this.l);
            com.anythink.expressad.video.dynview.widget.ATImageView aTImageView6 = this.c;
            if (aTImageView6 != null) {
                aTImageView6.startAnimation(animationSet2);
                return;
            }
            return;
        }
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(-10.0f, 30.0f, 1, 0.5f, 1, 0.5f);
        this.m = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.m.setRepeatMode(2);
        this.m.setRepeatCount(-1);
        android.view.animation.ScaleAnimation scaleAnimation7 = new android.view.animation.ScaleAnimation(0.0f, 1.2f, 0.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation7;
        scaleAnimation7.setDuration(600L);
        this.k.setRepeatCount(-1);
        android.view.animation.AlphaAnimation alphaAnimation3 = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
        this.l = alphaAnimation3;
        alphaAnimation3.setDuration(600L);
        this.l.setRepeatCount(-1);
        android.view.animation.AnimationSet animationSet3 = new android.view.animation.AnimationSet(true);
        animationSet3.addAnimation(this.k);
        animationSet3.addAnimation(this.l);
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView7 = this.b;
        if (aTImageView7 != null) {
            aTImageView7.startAnimation(this.m);
        }
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView8 = this.c;
        if (aTImageView8 != null) {
            aTImageView8.startAnimation(animationSet3);
        }
    }
}
