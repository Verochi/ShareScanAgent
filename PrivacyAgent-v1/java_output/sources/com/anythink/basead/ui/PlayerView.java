package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class PlayerView extends com.anythink.basead.ui.animplayerview.BasePlayerView {
    public static final java.lang.String TAG = "PlayerView";
    private java.lang.String A;
    private java.lang.String B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private android.os.Handler P;
    private boolean Q;
    private java.lang.Thread R;
    private boolean S;
    private boolean T;
    private android.view.View U;
    private com.anythink.expressad.exoplayer.w.c V;
    private com.anythink.expressad.exoplayer.l.g W;
    int a;
    private final long aa;
    private long ab;
    int b;
    int c;
    boolean d;
    java.lang.String e;
    java.lang.String f;
    private com.anythink.expressad.exoplayer.ad g;
    private com.anythink.expressad.exoplayer.h.s y;
    private android.view.TextureView z;

    /* renamed from: com.anythink.basead.ui.PlayerView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v == null) {
                return;
            }
            com.anythink.basead.ui.PlayerView.this.C = message.what;
            if (!com.anythink.basead.ui.PlayerView.this.L && !com.anythink.basead.ui.PlayerView.this.M) {
                com.anythink.basead.ui.PlayerView.d(com.anythink.basead.ui.PlayerView.this);
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.a();
                }
            }
            if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.a(com.anythink.basead.ui.PlayerView.this.C);
            }
            if (!com.anythink.basead.ui.PlayerView.this.H && com.anythink.basead.ui.PlayerView.this.C >= com.anythink.basead.ui.PlayerView.this.E) {
                com.anythink.basead.ui.PlayerView.l(com.anythink.basead.ui.PlayerView.this);
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.a(25);
                }
            } else if (!com.anythink.basead.ui.PlayerView.this.I && com.anythink.basead.ui.PlayerView.this.C >= com.anythink.basead.ui.PlayerView.this.F) {
                com.anythink.basead.ui.PlayerView.q(com.anythink.basead.ui.PlayerView.this);
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.a(50);
                }
            } else if (!com.anythink.basead.ui.PlayerView.this.J && com.anythink.basead.ui.PlayerView.this.C >= com.anythink.basead.ui.PlayerView.this.G) {
                com.anythink.basead.ui.PlayerView.v(com.anythink.basead.ui.PlayerView.this);
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.a(75);
                }
            }
            if (com.anythink.basead.ui.PlayerView.this.T) {
                int i = com.anythink.basead.ui.PlayerView.this.C;
                com.anythink.basead.ui.PlayerView playerView = com.anythink.basead.ui.PlayerView.this;
                if (i < playerView.a || ((com.anythink.basead.ui.animplayerview.BasePlayerView) playerView).v == null) {
                    return;
                }
                com.anythink.basead.ui.PlayerView.this.T = false;
                ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.g();
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.PlayerView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.d();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.PlayerView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {

        /* renamed from: com.anythink.basead.ui.PlayerView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.PlayerView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "Video player error!Buffer timeout"));
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (com.anythink.basead.ui.PlayerView.this.K) {
                if (com.anythink.basead.ui.PlayerView.this.M || !com.anythink.basead.ui.PlayerView.this.isPlaying() || com.anythink.basead.ui.PlayerView.this.P == null) {
                    if (com.anythink.basead.ui.PlayerView.this.ab == 0) {
                        com.anythink.basead.ui.PlayerView.this.ab = android.os.SystemClock.elapsedRealtime();
                    }
                    try {
                        java.lang.Thread.sleep(10L);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                    if (android.os.SystemClock.elapsedRealtime() - com.anythink.basead.ui.PlayerView.this.ab > 5000) {
                        if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                            com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.PlayerView.AnonymousClass3.AnonymousClass1());
                        }
                        com.anythink.basead.ui.PlayerView.this.d();
                    }
                } else {
                    com.anythink.basead.ui.PlayerView.this.ab = 0L;
                    try {
                        com.anythink.basead.ui.PlayerView.this.P.sendEmptyMessage((int) com.anythink.basead.ui.PlayerView.this.g.t());
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

    /* renamed from: com.anythink.basead.ui.PlayerView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.expressad.exoplayer.w.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
            boolean z;
            long j;
            java.lang.String str;
            super.onPlayerError(gVar);
            java.lang.String str2 = "Play error and ExoPlayer have not message.";
            if (gVar != null) {
                int i = gVar.d;
                z = true;
                if (i != 0) {
                    if (i == 1) {
                        str2 = "Play error, because have a RendererException.";
                    } else if (i == 2) {
                        str2 = "Play error, because have a UnexpectedException.";
                    }
                    z = false;
                } else {
                    str2 = "Play error, because have a SourceException.";
                }
                if (gVar.getCause() != null && !android.text.TextUtils.isEmpty(gVar.getCause().getMessage())) {
                    str2 = str2 + ",eception:" + gVar.getCause().getMessage();
                }
            } else {
                z = false;
            }
            com.anythink.basead.ui.PlayerView playerView = com.anythink.basead.ui.PlayerView.this;
            if (playerView.d && z) {
                playerView.f = str2;
                java.lang.String str3 = com.anythink.basead.ui.PlayerView.TAG;
                com.anythink.basead.ui.PlayerView playerView2 = com.anythink.basead.ui.PlayerView.this;
                playerView2.d = false;
                com.anythink.basead.ui.PlayerView.J(playerView2);
                return;
            }
            playerView.d();
            if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                try {
                    j = com.anythink.basead.ui.PlayerView.this.g.t();
                } catch (java.lang.Throwable unused) {
                    j = 0;
                }
                java.lang.String str4 = j <= 0 ? com.anythink.basead.c.f.p : com.anythink.basead.c.f.k;
                java.lang.String str5 = "videoUrl:" + com.anythink.basead.ui.PlayerView.this.B + ",readyRate:" + com.anythink.basead.ui.PlayerView.this.c + ",cdRate:" + com.anythink.basead.ui.PlayerView.this.b + ",play process:" + j;
                if (android.text.TextUtils.isEmpty(com.anythink.basead.ui.PlayerView.this.f)) {
                    str = str5 + ",localFileErrorMsg:" + str2;
                } else {
                    str = str5 + ",localFileErrorMsg:" + com.anythink.basead.ui.PlayerView.this.f + ",errorMsg:" + str2;
                }
                if (com.anythink.basead.ui.PlayerView.this.N) {
                    com.anythink.basead.ui.PlayerView.this.a(com.anythink.basead.c.f.a(str4, com.anythink.basead.c.f.D.concat(java.lang.String.valueOf(str))));
                } else {
                    com.anythink.basead.ui.PlayerView.this.a(com.anythink.basead.c.f.a(str4, com.anythink.basead.c.f.L.concat(java.lang.String.valueOf(str))));
                }
            }
        }

        @Override // com.anythink.expressad.exoplayer.w.a, com.anythink.expressad.exoplayer.w.c
        public final void onPlayerStateChanged(boolean z, int i) {
            super.onPlayerStateChanged(z, i);
            java.lang.String str = com.anythink.basead.ui.PlayerView.TAG;
            if (i == 2) {
                if (com.anythink.basead.ui.PlayerView.this.O) {
                    return;
                }
                com.anythink.basead.ui.PlayerView.this.O = true;
                com.anythink.basead.ui.PlayerView.O(com.anythink.basead.ui.PlayerView.this);
                return;
            }
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                com.anythink.basead.ui.PlayerView.this.d();
                if (com.anythink.basead.ui.PlayerView.this.M) {
                    return;
                }
                com.anythink.basead.ui.PlayerView.T(com.anythink.basead.ui.PlayerView.this);
                com.anythink.basead.ui.PlayerView playerView = com.anythink.basead.ui.PlayerView.this;
                playerView.C = playerView.D;
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.c();
                }
                com.anythink.basead.ui.PlayerView.this.i();
                return;
            }
            if (!com.anythink.basead.ui.PlayerView.this.N) {
                com.anythink.basead.ui.PlayerView.P(com.anythink.basead.ui.PlayerView.this);
                com.anythink.basead.ui.PlayerView.this.O = false;
                com.anythink.basead.ui.PlayerView playerView2 = com.anythink.basead.ui.PlayerView.this;
                playerView2.D = (int) playerView2.g.s();
                if (((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v != null) {
                    ((com.anythink.basead.ui.animplayerview.BasePlayerView) com.anythink.basead.ui.PlayerView.this).v.b(com.anythink.basead.ui.PlayerView.this.D);
                }
                com.anythink.basead.ui.PlayerView.this.E = java.lang.Math.round(r6.D * 0.25f);
                com.anythink.basead.ui.PlayerView.this.F = java.lang.Math.round(r6.D * 0.5f);
                com.anythink.basead.ui.PlayerView.this.G = java.lang.Math.round(r6.D * 0.75f);
                com.anythink.basead.ui.PlayerView playerView3 = com.anythink.basead.ui.PlayerView.this;
                int i2 = playerView3.c;
                if (i2 <= 0 || i2 >= 100) {
                    playerView3.T = false;
                } else {
                    if (playerView3.b > i2) {
                        playerView3.b = i2 / 2;
                    }
                    playerView3.a = java.lang.Math.round(((playerView3.b * 1.0f) / 100.0f) * playerView3.D);
                    r6.a -= 2000;
                    com.anythink.basead.ui.PlayerView.this.T = true;
                }
            }
            if (com.anythink.basead.ui.PlayerView.this.C <= 0 || java.lang.Math.abs(com.anythink.basead.ui.PlayerView.this.C - com.anythink.basead.ui.PlayerView.this.g.t()) <= 500) {
                return;
            }
            com.anythink.basead.ui.PlayerView.this.g.a(com.anythink.basead.ui.PlayerView.this.C);
        }
    }

    /* renamed from: com.anythink.basead.ui.PlayerView$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.expressad.exoplayer.l.g {
        public AnonymousClass5() {
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.l.g
        public final void a(int i, int i2) {
            com.anythink.basead.ui.PlayerView playerView = com.anythink.basead.ui.PlayerView.this;
            playerView.autoFitVideoSize(i, i2, playerView.z);
        }
    }

    public static class a extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.anythink.basead.ui.PlayerView.a> CREATOR = new com.anythink.basead.ui.PlayerView.a.AnonymousClass1();
        int a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;

        /* renamed from: com.anythink.basead.ui.PlayerView$a$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.anythink.basead.ui.PlayerView.a> {
            private static com.anythink.basead.ui.PlayerView.a a(android.os.Parcel parcel) {
                return new com.anythink.basead.ui.PlayerView.a(parcel);
            }

            private static com.anythink.basead.ui.PlayerView.a[] a(int i) {
                return new com.anythink.basead.ui.PlayerView.a[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.anythink.basead.ui.PlayerView.a createFromParcel(android.os.Parcel parcel) {
                return new com.anythink.basead.ui.PlayerView.a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ com.anythink.basead.ui.PlayerView.a[] newArray(int i) {
                return new com.anythink.basead.ui.PlayerView.a[i];
            }
        }

        public a(android.os.Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            boolean[] zArr = new boolean[7];
            parcel.readBooleanArray(zArr);
            this.b = zArr[0];
            this.c = zArr[1];
            this.d = zArr[2];
            this.e = zArr[3];
            this.f = zArr[4];
            this.g = zArr[5];
            this.h = zArr[6];
        }

        public a(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public final java.lang.String a() {
            return "SavedState(\nsavePosition - " + this.a + "\nsaveVideoPlay25 - " + this.b + "\nsaveVideoPlay50 - " + this.c + "\nsaveVideoPlay75 - " + this.d + "\nsaveIsVideoStart - " + this.e + "\nsaveIsVideoPlayCompletion - " + this.f + "\nsaveIsMute - " + this.g + "\nsaveVideoNeedResumeByCdRate - " + this.h + "\n)";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeBooleanArray(new boolean[]{this.b, this.c, this.d, this.e, this.f, this.g, this.h});
        }
    }

    public PlayerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = "";
        this.B = "";
        this.C = -1;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = "";
        this.f = "";
        this.aa = 5000L;
        this.ab = 0L;
        setSaveEnabled(true);
        this.P = new com.anythink.basead.ui.PlayerView.AnonymousClass1(android.os.Looper.getMainLooper());
        setBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
    }

    public static /* synthetic */ void J(com.anythink.basead.ui.PlayerView playerView) {
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = playerView.v;
        if (aVar != null) {
            aVar.g();
        }
        playerView.g.a(playerView.y);
    }

    public static /* synthetic */ void O(com.anythink.basead.ui.PlayerView playerView) {
        android.view.View view = playerView.U;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static /* synthetic */ boolean P(com.anythink.basead.ui.PlayerView playerView) {
        playerView.N = true;
        return true;
    }

    public static /* synthetic */ boolean T(com.anythink.basead.ui.PlayerView playerView) {
        playerView.M = true;
        return true;
    }

    private void a() {
        android.view.View view = this.U;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void a(java.lang.String str, boolean z) {
        while (true) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.g == null) {
                    a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "Player show fail with some internal error"));
                    return;
                }
                this.d = android.text.TextUtils.equals(str, this.A);
                if (android.text.TextUtils.equals(str, this.B) && this.c > 0) {
                    if (z) {
                        com.anythink.core.common.n.c.a("Video Play Fail:Play Network Url", "AdxPlayer videoUrl:" + str + ",readyRate:" + this.c + ",maxVideoCacheSize:" + com.anythink.core.common.a.k.a().c() + ",lastRecycleCheckDownloadedFileSize:" + com.anythink.core.common.a.k.a().d() + ",isChaoDi:true,ChaoDiThrowableMsg:" + this.e, com.anythink.core.common.b.o.a().q());
                    } else {
                        com.anythink.core.common.n.c.a("Video Play Fail:Play Network Url", "AdxPlayer videoUrl:" + str + ",readyRate:" + this.c + ",maxVideoCacheSize:" + com.anythink.core.common.a.k.a().c() + ",lastRecycleCheckDownloadedFileSize:" + com.anythink.core.common.a.k.a().d(), com.anythink.core.common.b.o.a().q());
                    }
                }
                android.net.Uri parse = android.net.Uri.parse(str);
                if (str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q)) {
                    this.y = new com.anythink.expressad.exoplayer.h.o.c(new com.anythink.expressad.exoplayer.j.q("Anythink_ExoPlayer")).b(parse);
                } else {
                    this.y = new com.anythink.expressad.exoplayer.h.o.c(new com.anythink.expressad.exoplayer.j.o(getContext(), "Anythink_ExoPlayer")).b(parse);
                }
                this.g.a(this.z);
                this.g.a(this.y);
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                if (android.text.TextUtils.equals(str, this.B) || z) {
                    a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, th.getMessage()));
                } else {
                    this.e = th.getMessage();
                    str = this.B;
                    z = true;
                }
            }
        }
        a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, th.getMessage()));
    }

    private void a(boolean z) {
        boolean z2;
        if (new java.io.File(this.A).exists() || !android.text.TextUtils.isEmpty(this.B)) {
            this.S = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.basead.c.f.K));
            return;
        }
        if (this.z == null) {
            android.view.TextureView textureView = new android.view.TextureView(getContext());
            this.z = textureView;
            textureView.setKeepScreenOn(true);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.z, layoutParams);
        }
        if (this.g == null) {
            this.g = com.anythink.expressad.exoplayer.i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            com.anythink.basead.ui.PlayerView.AnonymousClass4 anonymousClass4 = new com.anythink.basead.ui.PlayerView.AnonymousClass4();
            this.V = anonymousClass4;
            this.g.a(anonymousClass4);
            com.anythink.basead.ui.PlayerView.AnonymousClass5 anonymousClass5 = new com.anythink.basead.ui.PlayerView.AnonymousClass5();
            this.W = anonymousClass5;
            this.g.a(anonymousClass5);
            this.g.a(this.Q ? 0.0f : 1.0f);
            this.g.a(z);
            a(new java.io.File(this.A).exists() ? this.A : this.B, false);
        }
        setOnClickListener(new com.anythink.basead.ui.PlayerView.AnonymousClass2());
    }

    private void b() {
        android.view.View view = this.U;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void b(boolean z) {
        if (this.g == null) {
            this.g = com.anythink.expressad.exoplayer.i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            com.anythink.basead.ui.PlayerView.AnonymousClass4 anonymousClass4 = new com.anythink.basead.ui.PlayerView.AnonymousClass4();
            this.V = anonymousClass4;
            this.g.a(anonymousClass4);
            com.anythink.basead.ui.PlayerView.AnonymousClass5 anonymousClass5 = new com.anythink.basead.ui.PlayerView.AnonymousClass5();
            this.W = anonymousClass5;
            this.g.a(anonymousClass5);
            this.g.a(this.Q ? 0.0f : 1.0f);
            this.g.a(z);
            a(new java.io.File(this.A).exists() ? this.A : this.B, false);
        }
    }

    private void c() {
        if (this.R != null) {
            return;
        }
        this.K = true;
        this.ab = 0L;
        java.lang.Thread thread = new java.lang.Thread(new com.anythink.basead.ui.PlayerView.AnonymousClass3());
        this.R = thread;
        thread.setName("anythink_type_player_progress");
        this.R.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.K = false;
        this.R = null;
    }

    public static /* synthetic */ boolean d(com.anythink.basead.ui.PlayerView playerView) {
        playerView.L = true;
        return true;
    }

    private boolean e() {
        if (!new java.io.File(this.A).exists() && android.text.TextUtils.isEmpty(this.B)) {
            return true;
        }
        this.S = true;
        return false;
    }

    private java.lang.String f() {
        return new java.io.File(this.A).exists() ? this.A : this.B;
    }

    private void g() {
        if (this.z == null) {
            android.view.TextureView textureView = new android.view.TextureView(getContext());
            this.z = textureView;
            textureView.setKeepScreenOn(true);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.z, layoutParams);
        }
    }

    private void h() {
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
        if (aVar != null) {
            aVar.g();
        }
        this.g.a(this.y);
    }

    public static /* synthetic */ boolean l(com.anythink.basead.ui.PlayerView playerView) {
        playerView.H = true;
        return true;
    }

    public static /* synthetic */ boolean q(com.anythink.basead.ui.PlayerView playerView) {
        playerView.I = true;
        return true;
    }

    public static /* synthetic */ boolean v(com.anythink.basead.ui.PlayerView playerView) {
        playerView.J = true;
        return true;
    }

    public void autoFitVideoSize(int i, int i2, android.view.View view) {
        float max = java.lang.Math.max(i / view.getMeasuredWidth(), i2 / view.getMeasuredHeight());
        int ceil = (int) java.lang.Math.ceil(r4 / max);
        int ceil2 = (int) java.lang.Math.ceil(r5 / max);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = ceil;
        layoutParams.height = ceil2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getCurrentPosition() {
        return java.lang.Math.max(this.C, 0);
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public long getVideoLength() {
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        return adVar != null ? adVar.s() : this.D;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean hasVideo() {
        return this.S;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        super.init(lVar, mVar, z, list);
        initMuteStatus(z);
        setVideoRateConfig(lVar.n().W(), lVar.n().X());
        load(lVar.A(), false);
    }

    public void initMuteStatus(boolean z) {
        this.Q = z;
    }

    public boolean isComplete() {
        return this.M;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isMute() {
        return this.Q;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public boolean isPlaying() {
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        return adVar != null && adVar.J();
    }

    public void load(java.lang.String str, boolean z) {
        boolean z2;
        this.B = str;
        com.anythink.basead.a.e.a();
        this.A = com.anythink.basead.a.e.a(4, str);
        if (new java.io.File(this.A).exists() || !android.text.TextUtils.isEmpty(this.B)) {
            this.S = true;
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.basead.c.f.K));
            return;
        }
        if (this.z == null) {
            android.view.TextureView textureView = new android.view.TextureView(getContext());
            this.z = textureView;
            textureView.setKeepScreenOn(true);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            removeAllViews();
            addView(this.z, layoutParams);
        }
        if (this.g == null) {
            this.g = com.anythink.expressad.exoplayer.i.a(new com.anythink.expressad.exoplayer.f(getContext()), new com.anythink.expressad.exoplayer.i.c(), new com.anythink.expressad.exoplayer.d());
            com.anythink.basead.ui.PlayerView.AnonymousClass4 anonymousClass4 = new com.anythink.basead.ui.PlayerView.AnonymousClass4();
            this.V = anonymousClass4;
            this.g.a(anonymousClass4);
            com.anythink.basead.ui.PlayerView.AnonymousClass5 anonymousClass5 = new com.anythink.basead.ui.PlayerView.AnonymousClass5();
            this.W = anonymousClass5;
            this.g.a(anonymousClass5);
            this.g.a(this.Q ? 0.0f : 1.0f);
            this.g.a(z);
            a(new java.io.File(this.A).exists() ? this.A : this.B, false);
        }
        setOnClickListener(new com.anythink.basead.ui.PlayerView.AnonymousClass2());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.anythink.basead.ui.PlayerView.a aVar = (com.anythink.basead.ui.PlayerView.a) parcelable;
        aVar.a();
        super.onRestoreInstanceState(aVar.getSuperState());
        this.C = aVar.a;
        this.H = aVar.b;
        this.I = aVar.c;
        this.J = aVar.d;
        this.L = aVar.e;
        this.M = aVar.f;
        boolean z = aVar.g;
        this.Q = z;
        this.T = aVar.h;
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        if (adVar != null) {
            adVar.a(z ? 0.0f : 1.0f);
        }
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.anythink.basead.ui.PlayerView.a aVar = new com.anythink.basead.ui.PlayerView.a(super.onSaveInstanceState());
        aVar.a = this.C;
        aVar.b = this.H;
        aVar.c = this.I;
        aVar.d = this.J;
        aVar.e = this.L;
        aVar.f = this.M;
        aVar.g = this.Q;
        aVar.h = this.T;
        aVar.a();
        return aVar;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        d();
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        if (adVar != null) {
            adVar.a(false);
        }
    }

    public void release() {
        d();
        i();
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        if (adVar != null) {
            if (adVar.J()) {
                this.g.m();
            }
            com.anythink.expressad.exoplayer.w.c cVar = this.V;
            if (cVar != null) {
                this.g.b(cVar);
            }
            com.anythink.expressad.exoplayer.l.g gVar = this.W;
            if (gVar != null) {
                this.g.b(gVar);
            }
            this.g.n();
            this.g = null;
        }
        android.os.Handler handler = this.P;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.N = false;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setListener(com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar) {
        this.v = aVar;
    }

    public void setLoadingView(android.view.View view) {
        this.U = view;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void setMute(boolean z) {
        this.Q = z;
        if (z) {
            com.anythink.expressad.exoplayer.ad adVar = this.g;
            if (adVar != null) {
                adVar.a(0.0f);
            }
            com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
            if (aVar != null) {
                aVar.e();
                return;
            }
            return;
        }
        com.anythink.expressad.exoplayer.ad adVar2 = this.g;
        if (adVar2 != null) {
            adVar2.a(1.0f);
        }
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.f();
        }
    }

    public void setVideoRateConfig(int i, int i2) {
        this.c = i;
        this.b = i2;
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        android.view.View view = this.U;
        if (view != null) {
            view.setVisibility(8);
        }
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        if (adVar != null) {
            adVar.a(true);
        }
        if (this.R == null) {
            this.K = true;
            this.ab = 0L;
            java.lang.Thread thread = new java.lang.Thread(new com.anythink.basead.ui.PlayerView.AnonymousClass3());
            this.R = thread;
            thread.setName("anythink_type_player_progress");
            this.R.start();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        com.anythink.expressad.exoplayer.ad adVar = this.g;
        if (adVar != null) {
            adVar.m();
        }
        com.anythink.basead.ui.animplayerview.BasePlayerView.a aVar = this.v;
        if (aVar != null) {
            aVar.b();
        }
        i();
    }
}
