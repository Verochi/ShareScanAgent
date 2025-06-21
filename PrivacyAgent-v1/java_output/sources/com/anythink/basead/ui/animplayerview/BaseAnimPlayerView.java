package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public abstract class BaseAnimPlayerView extends com.anythink.basead.ui.animplayerview.BasePlayerView {
    protected final java.lang.String a;
    long b;
    long c;
    protected java.util.List<android.graphics.Bitmap> d;
    protected java.lang.String e;
    protected com.anythink.core.common.res.image.RecycleImageView f;
    protected com.anythink.basead.ui.WrapRoundImageView g;
    private boolean y;
    private boolean z;

    /* renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.v;
            if (aVar != null) {
                aVar.d();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            if (baseAnimPlayerView.v == null) {
                return;
            }
            long elapsedRealtime = baseAnimPlayerView.b + android.os.SystemClock.elapsedRealtime();
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView2 = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            baseAnimPlayerView.i = elapsedRealtime - baseAnimPlayerView2.c;
            if (!baseAnimPlayerView2.r && !baseAnimPlayerView2.f152s) {
                baseAnimPlayerView2.r = true;
                com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = baseAnimPlayerView2.v;
                if (aVar != null) {
                    aVar.a();
                }
            }
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView3 = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar2 = baseAnimPlayerView3.v;
            if (aVar2 != null) {
                aVar2.a(baseAnimPlayerView3.i);
            }
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView4 = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            if (!baseAnimPlayerView4.m && baseAnimPlayerView4.i >= baseAnimPlayerView4.j) {
                baseAnimPlayerView4.m = true;
                com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar3 = baseAnimPlayerView4.v;
                if (aVar3 != null) {
                    aVar3.a(25);
                }
            } else if (!baseAnimPlayerView4.n && baseAnimPlayerView4.i >= baseAnimPlayerView4.k) {
                baseAnimPlayerView4.n = true;
                com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar4 = baseAnimPlayerView4.v;
                if (aVar4 != null) {
                    aVar4.a(50);
                }
            } else if (!baseAnimPlayerView4.o && baseAnimPlayerView4.i >= baseAnimPlayerView4.l) {
                baseAnimPlayerView4.o = true;
                com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar5 = baseAnimPlayerView4.v;
                if (aVar5 != null) {
                    aVar5.a(75);
                }
            }
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView5 = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            if (baseAnimPlayerView5.f152s || baseAnimPlayerView5.i < baseAnimPlayerView5.h) {
                return;
            }
            baseAnimPlayerView5.l();
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.b(com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this);
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView6 = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
            baseAnimPlayerView6.f152s = true;
            com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar6 = baseAnimPlayerView6.v;
            if (aVar6 != null) {
                aVar6.c();
            }
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.i();
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Handler handler;
            while (true) {
                com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView = com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this;
                if (!baseAnimPlayerView.q) {
                    return;
                }
                if (baseAnimPlayerView.f152s || (handler = baseAnimPlayerView.u) == null) {
                    try {
                        java.lang.Thread.sleep(10L);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                } else {
                    try {
                        handler.sendEmptyMessage(1);
                    } catch (java.lang.Throwable unused) {
                    }
                    try {
                        java.lang.Thread.sleep(200L);
                    } catch (java.lang.Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        /* renamed from: com.anythink.basead.ui.animplayerview.BaseAnimPlayerView$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.common.o.c.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.f.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass4(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, com.anythink.basead.c.f.O));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.e)) {
                com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.g.setBitmapAndResize(bitmap, this.a, this.b);
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.getContext(), bitmap, new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass4.AnonymousClass1());
                android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.3f, 1.0f);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(100L);
                com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.g.startAnimation(alphaAnimation);
                com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.this.f.startAnimation(alphaAnimation);
            }
        }
    }

    public BaseAnimPlayerView(android.content.Context context) {
        super(context);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.y = false;
        this.z = false;
        j();
    }

    public BaseAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.y = false;
        this.z = false;
        j();
    }

    public BaseAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getClass().getSimpleName();
        this.b = 0L;
        this.c = 0L;
        this.e = "";
        this.y = false;
        this.z = false;
        j();
    }

    public static /* synthetic */ boolean b(com.anythink.basead.ui.animplayerview.BaseAnimPlayerView baseAnimPlayerView) {
        baseAnimPlayerView.y = false;
        return false;
    }

    private void j() {
        this.u = new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass2(android.os.Looper.getMainLooper());
    }

    private void k() {
        if (this.t != null) {
            return;
        }
        this.q = true;
        java.lang.Thread thread = new java.lang.Thread(new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass3());
        this.t = thread;
        thread.setName("anythink_type_anim_player_progress");
        this.t.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.q = false;
        this.t = null;
    }

    public abstract void a();

    public final void a(int i, int i2) {
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(getContext());
        this.f = recycleImageView;
        recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        addView(this.f, -1, -1);
        this.g = new com.anythink.basead.ui.WrapRoundImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        addView(this.g, layoutParams);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), i, i2, new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass4(i, i2));
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public final void a(com.anythink.basead.c.e eVar) {
        this.z = true;
        super.a(eVar);
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public int e() {
        return 0;
    }

    public void f() {
        if (android.text.TextUtils.isEmpty(this.e)) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, com.anythink.basead.c.f.O));
        }
    }

    public void g() {
        l();
        i();
        android.os.Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        d();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return this.i;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        return this.h;
    }

    public final void h() {
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.w != null;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        super.init(lVar, mVar, z, list);
        this.d = list;
        this.e = lVar.x();
        long max = java.lang.Math.max(this.x.n.ai(), e());
        this.h = max;
        this.j = java.lang.Math.round(max * 0.25f);
        this.k = java.lang.Math.round(this.h * 0.5f);
        this.l = java.lang.Math.round(this.h * 0.75f);
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
        if (aVar != null) {
            aVar.b(this.h);
        }
        setOnClickListener(new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass1());
        f();
        java.util.List<android.graphics.Bitmap> list2 = this.d;
        java.util.Objects.toString(list2 == null ? com.igexin.push.core.b.m : java.lang.Integer.valueOf(list2.size()));
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.p;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        return this.y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        this.y = false;
        this.b += android.os.SystemClock.elapsedRealtime() - this.c;
        l();
        b();
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setListener(com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar) {
        this.v = aVar;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.p = z;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        if (this.z) {
            return;
        }
        this.y = !this.f152s;
        this.c = android.os.SystemClock.elapsedRealtime();
        if (this.t == null) {
            this.q = true;
            java.lang.Thread thread = new java.lang.Thread(new com.anythink.basead.ui.animplayerview.BaseAnimPlayerView.AnonymousClass3());
            this.t = thread;
            thread.setName("anythink_type_anim_player_progress");
            this.t.start();
        }
        if (this.y) {
            a();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        this.y = false;
        l();
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
        if (aVar != null) {
            aVar.b();
        }
        c();
        i();
    }
}
