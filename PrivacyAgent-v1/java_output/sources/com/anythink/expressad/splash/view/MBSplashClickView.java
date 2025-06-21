package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class MBSplashClickView extends android.widget.RelativeLayout {
    private static final java.lang.String a = "MBSplashClickView";
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;
    private final java.lang.String g;
    private final java.lang.String h;
    private final java.lang.String i;
    private java.lang.String j;
    private int k;
    private android.widget.ImageView l;
    private android.widget.ImageView m;
    private final android.graphics.RectF n;
    private final android.graphics.Paint o;
    private final android.graphics.Paint p;

    /* renamed from: com.anythink.expressad.splash.view.MBSplashClickView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ android.view.animation.ScaleAnimation a;

        /* renamed from: com.anythink.expressad.splash.view.MBSplashClickView$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02241 implements java.lang.Runnable {
            public RunnableC02241() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.splash.view.MBSplashClickView.this.m.startAnimation(com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass1.this.a);
            }
        }

        public AnonymousClass1(android.view.animation.ScaleAnimation scaleAnimation) {
            this.a = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.expressad.splash.view.MBSplashClickView.this.m.setVisibility(4);
            com.anythink.expressad.splash.view.MBSplashClickView.this.m.postDelayed(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass1.RunnableC02241(), 700L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
            com.anythink.expressad.splash.view.MBSplashClickView.this.m.setVisibility(0);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.MBSplashClickView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.view.animation.ScaleAnimation a;

        public AnonymousClass2(android.view.animation.ScaleAnimation scaleAnimation) {
            this.a = scaleAnimation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.view.MBSplashClickView.this.m.startAnimation(this.a);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.MBSplashClickView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.animation.Animation.AnimationListener {

        /* renamed from: com.anythink.expressad.splash.view.MBSplashClickView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.view.animation.Animation a;

            public AnonymousClass1(android.view.animation.Animation animation) {
                this.a = animation;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.splash.view.MBSplashClickView.this.l.startAnimation(this.a);
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.expressad.splash.view.MBSplashClickView.this.l.setVisibility(4);
            com.anythink.expressad.splash.view.MBSplashClickView.this.l.postDelayed(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass3.AnonymousClass1(animation), 2000L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
            com.anythink.expressad.splash.view.MBSplashClickView.this.l.setVisibility(0);
        }
    }

    public MBSplashClickView(android.content.Context context) {
        super(context);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "anythink_splash_btn_arrow_right";
        this.f = "anythink_splash_btn_circle";
        this.g = "anythink_splash_btn_finger";
        this.h = "anythink_splash_btn_go";
        this.i = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.n = new android.graphics.RectF();
        this.o = new android.graphics.Paint();
        this.p = new android.graphics.Paint();
        a();
    }

    public MBSplashClickView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "anythink_splash_btn_arrow_right";
        this.f = "anythink_splash_btn_circle";
        this.g = "anythink_splash_btn_finger";
        this.h = "anythink_splash_btn_go";
        this.i = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.n = new android.graphics.RectF();
        this.o = new android.graphics.Paint();
        this.p = new android.graphics.Paint();
        a();
    }

    public MBSplashClickView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "anythink_splash_btn_arrow_right";
        this.f = "anythink_splash_btn_circle";
        this.g = "anythink_splash_btn_finger";
        this.h = "anythink_splash_btn_go";
        this.i = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.n = new android.graphics.RectF();
        this.o = new android.graphics.Paint();
        this.p = new android.graphics.Paint();
        a();
    }

    @androidx.annotation.RequiresApi(api = 21)
    public MBSplashClickView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "anythink_splash_btn_arrow_right";
        this.f = "anythink_splash_btn_circle";
        this.g = "anythink_splash_btn_finger";
        this.h = "anythink_splash_btn_go";
        this.i = "anythink_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.n = new android.graphics.RectF();
        this.o = new android.graphics.Paint();
        this.p = new android.graphics.Paint();
    }

    private void a() {
        this.o.setAntiAlias(true);
        this.o.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        this.p.setAntiAlias(true);
        this.p.setColor(-1);
        this.b = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_click_default_view", com.anythink.expressad.foundation.h.i.g));
        this.c = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_click_default_open", com.anythink.expressad.foundation.h.i.g));
        this.d = getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_shake_view_click_default_inst", com.anythink.expressad.foundation.h.i.g));
    }

    private void a(int i) {
        int parseColor = android.graphics.Color.parseColor("#666666");
        int parseColor2 = android.graphics.Color.parseColor("#8FC31F");
        int parseColor3 = android.graphics.Color.parseColor("#000000");
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        if (i == 2) {
            gradientDrawable.setColor(parseColor2);
        } else {
            gradientDrawable.setColor(parseColor3);
            gradientDrawable.setStroke(2, parseColor);
        }
        gradientDrawable.setCornerRadius(200.0f);
        setBackgroundDrawable(gradientDrawable);
    }

    private boolean a(java.lang.String str) {
        if (android.text.TextUtils.equals(str, this.b)) {
            this.k = 2;
            return true;
        }
        if (android.text.TextUtils.equals(str, this.d)) {
            this.k = 3;
            return true;
        }
        if (!android.text.TextUtils.equals(str, this.c)) {
            return false;
        }
        this.k = 1;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        boolean z;
        int i;
        int i2;
        android.widget.RelativeLayout.LayoutParams layoutParams;
        java.lang.String str = this.j;
        int i3 = 0;
        if (android.text.TextUtils.equals(str, this.b)) {
            this.k = 2;
        } else if (android.text.TextUtils.equals(str, this.d)) {
            this.k = 3;
        } else {
            if (!android.text.TextUtils.equals(str, this.c)) {
                z = false;
                if (!z) {
                    if (android.text.TextUtils.isEmpty(this.j)) {
                        this.j = this.b;
                    }
                    this.k = 2;
                }
                i = this.k;
                int parseColor = android.graphics.Color.parseColor("#666666");
                int parseColor2 = android.graphics.Color.parseColor("#8FC31F");
                int parseColor3 = android.graphics.Color.parseColor("#000000");
                android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                if (i != 2) {
                    gradientDrawable.setColor(parseColor2);
                } else {
                    gradientDrawable.setColor(parseColor3);
                    gradientDrawable.setStroke(2, parseColor);
                }
                gradientDrawable.setCornerRadius(200.0f);
                setBackgroundDrawable(gradientDrawable);
                android.widget.TextView textView = new android.widget.TextView(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(15);
                textView.setLayoutParams(layoutParams2);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setTextColor(-1);
                textView.setText(this.j);
                this.l = new android.widget.ImageView(getContext());
                i2 = this.k;
                if (i2 != 2) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_go", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 35.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 35.0f));
                    layoutParams.addRule(11);
                    layoutParams.addRule(15);
                    layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
                } else if (i2 == 1) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_light", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
                    layoutParams.leftMargin = 20;
                    layoutParams.rightMargin = 20;
                    android.widget.ImageView imageView = new android.widget.ImageView(getContext());
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -1);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(15);
                    layoutParams3.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    imageView.setImageResource(getResources().getIdentifier("anythink_splash_btn_arrow_right", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
                    imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER);
                    imageView.setLayoutParams(layoutParams3);
                    addView(imageView);
                } else if (i2 == 3) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_finger", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 25.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 25.0f));
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 18.0f);
                    this.m = new android.widget.ImageView(getContext());
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f));
                    layoutParams4.addRule(11);
                    layoutParams4.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    layoutParams4.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 5.0f);
                    this.m.setLayoutParams(layoutParams4);
                    this.m.setImageResource(getResources().getIdentifier("anythink_splash_btn_circle", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
                    addView(this.m);
                } else {
                    layoutParams = null;
                }
                this.l.setLayoutParams(layoutParams);
                this.l.setImageResource(i3);
                addView(textView);
                addView(this.l);
                invalidate();
            }
            this.k = 1;
        }
        z = true;
        if (!z) {
        }
        i = this.k;
        int parseColor4 = android.graphics.Color.parseColor("#666666");
        int parseColor22 = android.graphics.Color.parseColor("#8FC31F");
        int parseColor32 = android.graphics.Color.parseColor("#000000");
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        if (i != 2) {
        }
        gradientDrawable2.setCornerRadius(200.0f);
        setBackgroundDrawable(gradientDrawable2);
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams22 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams22.addRule(15);
        textView2.setLayoutParams(layoutParams22);
        textView2.setGravity(17);
        textView2.setTextSize(20.0f);
        textView2.setTextColor(-1);
        textView2.setText(this.j);
        this.l = new android.widget.ImageView(getContext());
        i2 = this.k;
        if (i2 != 2) {
        }
        this.l.setLayoutParams(layoutParams);
        this.l.setImageResource(i3);
        addView(textView2);
        addView(this.l);
        invalidate();
    }

    private void c() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        android.view.animation.ScaleAnimation scaleAnimation2 = new android.view.animation.ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setAnimationListener(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass1(scaleAnimation2));
        this.m.setVisibility(4);
        this.l.startAnimation(scaleAnimation);
        this.m.postDelayed(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass2(scaleAnimation2), 500L);
    }

    private void d() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass3());
        this.l.startAnimation(translateAnimation);
    }

    private void e() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        this.l.startAnimation(scaleAnimation);
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        canvas.saveLayer(this.n, this.p, 31);
        canvas.drawRoundRect(this.n, 200.0f, 200.0f, this.p);
        canvas.saveLayer(this.n, this.o, 31);
        super.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initView(java.lang.String str) {
        boolean z;
        int i;
        int i2;
        android.widget.RelativeLayout.LayoutParams layoutParams;
        this.j = str;
        int i3 = 0;
        if (android.text.TextUtils.equals(str, this.b)) {
            this.k = 2;
        } else if (android.text.TextUtils.equals(str, this.d)) {
            this.k = 3;
        } else {
            if (!android.text.TextUtils.equals(str, this.c)) {
                z = false;
                if (!z) {
                    if (android.text.TextUtils.isEmpty(this.j)) {
                        this.j = this.b;
                    }
                    this.k = 2;
                }
                i = this.k;
                int parseColor = android.graphics.Color.parseColor("#666666");
                int parseColor2 = android.graphics.Color.parseColor("#8FC31F");
                int parseColor3 = android.graphics.Color.parseColor("#000000");
                android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                if (i != 2) {
                    gradientDrawable.setColor(parseColor2);
                } else {
                    gradientDrawable.setColor(parseColor3);
                    gradientDrawable.setStroke(2, parseColor);
                }
                gradientDrawable.setCornerRadius(200.0f);
                setBackgroundDrawable(gradientDrawable);
                android.widget.TextView textView = new android.widget.TextView(getContext());
                android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(15);
                textView.setLayoutParams(layoutParams2);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setTextColor(-1);
                textView.setText(this.j);
                this.l = new android.widget.ImageView(getContext());
                i2 = this.k;
                if (i2 != 2) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_go", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 35.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 35.0f));
                    layoutParams.addRule(11);
                    layoutParams.addRule(15);
                    layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
                } else if (i2 == 1) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_light", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
                    layoutParams.leftMargin = 20;
                    layoutParams.rightMargin = 20;
                    android.widget.ImageView imageView = new android.widget.ImageView(getContext());
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -1);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(15);
                    layoutParams3.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    imageView.setImageResource(getResources().getIdentifier("anythink_splash_btn_arrow_right", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
                    imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER);
                    imageView.setLayoutParams(layoutParams3);
                    addView(imageView);
                } else if (i2 == 3) {
                    i3 = getResources().getIdentifier("anythink_splash_btn_finger", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a());
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 25.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 25.0f));
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 18.0f);
                    this.m = new android.widget.ImageView(getContext());
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 30.0f));
                    layoutParams4.addRule(11);
                    layoutParams4.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f);
                    layoutParams4.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 5.0f);
                    this.m.setLayoutParams(layoutParams4);
                    this.m.setImageResource(getResources().getIdentifier("anythink_splash_btn_circle", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
                    addView(this.m);
                } else {
                    layoutParams = null;
                }
                this.l.setLayoutParams(layoutParams);
                this.l.setImageResource(i3);
                addView(textView);
                addView(this.l);
                invalidate();
            }
            this.k = 1;
        }
        z = true;
        if (!z) {
        }
        i = this.k;
        int parseColor4 = android.graphics.Color.parseColor("#666666");
        int parseColor22 = android.graphics.Color.parseColor("#8FC31F");
        int parseColor32 = android.graphics.Color.parseColor("#000000");
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        if (i != 2) {
        }
        gradientDrawable2.setCornerRadius(200.0f);
        setBackgroundDrawable(gradientDrawable2);
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams22 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams22.addRule(15);
        textView2.setLayoutParams(layoutParams22);
        textView2.setGravity(17);
        textView2.setTextSize(20.0f);
        textView2.setTextColor(-1);
        textView2.setText(this.j);
        this.l = new android.widget.ImageView(getContext());
        i2 = this.k;
        if (i2 != 2) {
        }
        this.l.setLayoutParams(layoutParams);
        this.l.setImageResource(i3);
        addView(textView2);
        addView(this.l);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.k;
        if (i == 2) {
            android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.l.startAnimation(scaleAnimation);
            return;
        }
        if (i == 1) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass3());
            this.l.startAnimation(translateAnimation);
            return;
        }
        if (i == 3) {
            android.view.animation.ScaleAnimation scaleAnimation2 = new android.view.animation.ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            android.view.animation.ScaleAnimation scaleAnimation3 = new android.view.animation.ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass1(scaleAnimation3));
            this.m.setVisibility(4);
            this.l.startAnimation(scaleAnimation2);
            this.m.postDelayed(new com.anythink.expressad.splash.view.MBSplashClickView.AnonymousClass2(scaleAnimation3), 500L);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.n.set(0.0f, 0.0f, getWidth(), getHeight());
    }
}
