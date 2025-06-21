package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class AnythinkBTVideoView extends com.anythink.expressad.video.bt.module.BTBaseView {
    private static boolean H = false;
    private static final java.lang.String N = "2";
    private static final java.lang.String p = "anythink_reward_videoview_item";
    private com.anythink.expressad.video.bt.module.AnythinkBTVideoView.a A;
    private int B;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private java.lang.String G;
    private boolean I;
    private boolean J;
    private boolean K;
    private android.widget.RelativeLayout L;
    private android.widget.ProgressBar M;
    private com.anythink.expressad.playercommon.PlayerView q;
    private com.anythink.expressad.video.widget.SoundImageView r;

    /* renamed from: s, reason: collision with root package name */
    private android.widget.TextView f265s;
    private android.view.View t;
    private com.anythink.expressad.widget.FeedBackButton u;
    private android.webkit.WebView v;
    private com.anythink.expressad.videocommon.b.c w;
    private int x;
    private int y;
    private int z;

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTVideoView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.q.isSilent();
            if (com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.d);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("mute", com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.B);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v, "onPlayerMuteBtnClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    int unused = com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.B;
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v, e.getMessage());
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTVideoView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v != null) {
                com.anythink.expressad.video.bt.module.BTBaseView.a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v, "onPlayerCloseBtnClicked", com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.d);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTVideoView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.d);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("x", java.lang.String.valueOf(view.getX()));
                    jSONObject2.put("y", java.lang.String.valueOf(view.getY()));
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v, "onClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                } catch (java.lang.Exception unused) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.v, "onClicked", com.anythink.expressad.video.bt.module.AnythinkBTVideoView.this.d);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class a extends com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener {
        private com.anythink.expressad.video.bt.module.AnythinkBTVideoView a;
        private android.webkit.WebView b;
        private java.lang.String c;
        private java.lang.String d;
        private int e;
        private int f;
        private boolean g;
        private int k;
        private int l;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private boolean m = false;

        public a(com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView, android.webkit.WebView webView) {
            this.a = anythinkBTVideoView;
            this.b = webView;
            this.c = anythinkBTVideoView.d;
            this.d = anythinkBTVideoView.c;
        }

        private int a() {
            return this.e;
        }

        private void b() {
            this.a = null;
            this.b = null;
            boolean unused = com.anythink.expressad.video.bt.module.AnythinkBTVideoView.H = false;
        }

        public final void a(int i, int i2) {
            this.k = i;
            this.l = i2;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(java.lang.String str) {
            try {
                super.onBufferingStart(str);
                if ((str.equals(com.anythink.expressad.playercommon.PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals("play buffering tiemout")) && this.b != null) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                        jSONObject.put("id", this.c);
                        jSONObject.put("data", new org.json.JSONObject());
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(this.b, "onPlayerTimeout", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (java.lang.Exception e) {
                        com.anythink.expressad.video.bt.a.c.a();
                        com.anythink.expressad.video.bt.a.c.a(this.b, e.getMessage());
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() {
            super.onPlayCompleted();
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView = this.a;
            com.anythink.expressad.foundation.d.c cVar = anythinkBTVideoView.b;
            if (cVar == null) {
                anythinkBTVideoView.f265s.setText("0");
            } else if (cVar.i() > 0) {
                this.a.f265s.setText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
            } else {
                this.a.f265s.setText("0");
            }
            this.a.q.setClickable(false);
            android.webkit.WebView webView = this.b;
            if (webView != null) {
                com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerFinish", this.c);
            }
            this.e = this.f;
            boolean unused = com.anythink.expressad.video.bt.module.AnythinkBTVideoView.H = true;
            this.a.stop();
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayError(java.lang.String str) {
            super.onPlayError(str);
            if (this.b != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.o);
                    jSONObject.put("id", this.c);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.c);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(this.b, "onPlayerFailed", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(this.b, e.getMessage());
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x01b2 A[Catch: Exception -> 0x01b9, TRY_LEAVE, TryCatch #0 {Exception -> 0x01b9, blocks: (B:24:0x0122, B:26:0x0128, B:31:0x012f, B:33:0x0133, B:35:0x0138, B:37:0x0144, B:40:0x0151, B:41:0x01a6, B:43:0x01b2, B:47:0x017c), top: B:23:0x0122 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onPlayProgress(int i, int i2) {
            int i3;
            java.lang.String str;
            com.anythink.expressad.videocommon.b.c a;
            int i4;
            java.lang.String str2;
            super.onPlayProgress(i, i2);
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView = this.a;
            if (anythinkBTVideoView.h) {
                com.anythink.expressad.foundation.d.c cVar = anythinkBTVideoView.b;
                if (cVar != null) {
                    i4 = cVar.i();
                    com.anythink.expressad.foundation.f.b.a().a(this.a.b.K() + "_1", i);
                } else {
                    i4 = 0;
                }
                if (i4 > i2) {
                    i4 = i2;
                }
                int i5 = i4 <= 0 ? i2 - i : i4 - i;
                if (i5 <= 0) {
                    str2 = i4 <= 0 ? "0" : (java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_complete", com.anythink.expressad.foundation.h.i.g));
                } else if (i4 <= 0) {
                    str2 = java.lang.String.valueOf(i5);
                } else {
                    str2 = i5 + ((java.lang.String) this.a.getContext().getResources().getText(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_view_reward_time_left", com.anythink.expressad.foundation.h.i.g)));
                }
                this.a.f265s.setText(str2);
            }
            this.f = i2;
            this.e = i;
            this.a.M.setMax(this.f);
            this.a.M.setProgress(this.e);
            if (this.b != null) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                    jSONObject.put("id", this.c);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("id", this.c);
                    jSONObject2.put(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, com.anythink.expressad.video.bt.module.AnythinkBTVideoView.b(i, i2));
                    jSONObject2.put("time", java.lang.String.valueOf(i));
                    jSONObject2.put("duration", java.lang.String.valueOf(i2));
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a(this.b, "onPlayerProgressChanged", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.video.bt.a.c.a();
                    com.anythink.expressad.video.bt.a.c.a(this.b, e.getMessage());
                }
            }
            try {
                int i6 = this.k;
                if (i6 == 100 || this.m || i6 == 0 || (i3 = this.l) < 0 || i < (i2 * i3) / 100) {
                    return;
                }
                if (this.a.b.w() != 94 && this.a.b.w() != 287) {
                    str = this.a.b.aZ() + this.a.b.S() + this.a.b.B();
                    a = com.anythink.expressad.videocommon.b.e.a().a(this.d, str);
                    if (a == null) {
                        a.i();
                        this.m = true;
                        return;
                    }
                    return;
                }
                str = this.a.b.Z() + this.a.b.aZ() + this.a.b.S();
                a = com.anythink.expressad.videocommon.b.e.a().a(this.d, str);
                if (a == null) {
                }
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(java.lang.String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onPlayStarted(int i) {
            super.onPlayStarted(i);
            if (!this.g) {
                this.a.M.setMax(i);
                android.webkit.WebView webView = this.b;
                if (webView != null) {
                    com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerPlay", this.c);
                }
                this.g = true;
            }
            boolean unused = com.anythink.expressad.video.bt.module.AnythinkBTVideoView.H = false;
        }

        @Override // com.anythink.expressad.playercommon.DefaultVideoPlayerStatusListener, com.anythink.expressad.playercommon.VideoPlayerStatusListener
        public final void onVideoDownloadResume() {
            java.lang.String str;
            if (this.a.b.w() == 94 || this.a.b.w() == 287) {
                str = this.a.b.Z() + this.a.b.aZ() + this.a.b.S();
            } else {
                str = this.a.b.aZ() + this.a.b.S() + this.a.b.B();
            }
            com.anythink.expressad.videocommon.b.c a = com.anythink.expressad.videocommon.b.e.a().a(this.d, str);
            if (a != null) {
                a.i();
                this.m = true;
            }
        }
    }

    public AnythinkBTVideoView(android.content.Context context) {
        super(context);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    public AnythinkBTVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.B = 2;
        this.D = false;
        this.E = 2;
        this.F = 1;
        this.I = false;
        this.J = false;
        this.K = false;
    }

    private int a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null && cVar.ao() != -1) {
            return cVar.ao();
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.c, false).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(int i, int i2) {
        if (i2 != 0) {
            double d = i / i2;
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.anythink.expressad.foundation.h.t.a(java.lang.Double.valueOf(d)));
                return sb.toString();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return java.lang.String.valueOf(i2);
    }

    private boolean b() {
        try {
            this.q = (com.anythink.expressad.playercommon.PlayerView) findViewById(findID("anythink_vfpv"));
            this.r = (com.anythink.expressad.video.widget.SoundImageView) findViewById(findID("anythink_sound_switch"));
            this.f265s = (android.widget.TextView) findViewById(findID("anythink_tv_count"));
            this.t = findViewById(findID("anythink_rl_playing_close"));
            this.L = (android.widget.RelativeLayout) findViewById(findID("anythink_top_control"));
            this.M = (android.widget.ProgressBar) findViewById(findID("anythink_video_progress_bar"));
            this.q.setIsBTVideo(true);
            this.u = (com.anythink.expressad.widget.FeedBackButton) findViewById(findID("anythink_native_endcard_feed_btn"));
            return isNotNULL(this.q, this.r, this.f265s, this.t);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void c() {
        java.lang.String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        com.anythink.expressad.videocommon.b.c a2 = com.anythink.expressad.videocommon.b.e.a().a(this.c, str);
        if (a2 != null) {
            this.w = a2;
        }
    }

    private java.lang.String d() {
        java.lang.String str = "";
        try {
            str = this.b.S();
            com.anythink.expressad.videocommon.b.c cVar = this.w;
            if (cVar == null || cVar.k() != 5) {
                return str;
            }
            java.lang.String e = this.w.e();
            return !com.anythink.expressad.foundation.h.w.a(e) ? new java.io.File(e).exists() ? e : str : str;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return str;
        }
    }

    private static int e() {
        try {
            com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
            if (b == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            if (b != null) {
                return (int) b.g();
            }
            return 5;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private int f() {
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.c, false).x();
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public final void a() {
        super.a();
        if (this.h) {
            this.r.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTVideoView.AnonymousClass1());
            this.t.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTVideoView.AnonymousClass2());
            setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTVideoView.AnonymousClass3());
        }
    }

    public int getMute() {
        return this.B;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(android.content.Context context) {
        int findLayout = findLayout(p);
        if (findLayout > 0) {
            this.f.inflate(findLayout, this);
            this.h = b();
            a();
        }
        H = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.K) {
            com.anythink.expressad.video.bt.a.c.a();
            this.E = com.anythink.expressad.video.bt.a.c.e(this.c);
        }
        android.view.View view = this.t;
        if (view != null) {
            view.setVisibility(this.y == 0 ? 8 : 0);
        }
        com.anythink.expressad.video.widget.SoundImageView soundImageView = this.r;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.z == 0 ? 8 : 0);
        }
        android.widget.TextView textView = this.f265s;
        if (textView != null) {
            textView.setVisibility(this.x != 0 ? 0 : 8);
            if (this.f265s.getVisibility() == 0 && com.anythink.expressad.foundation.f.b.a().b()) {
                this.b.l(this.c);
                com.anythink.expressad.foundation.f.b.a().a(this.c + "_1", this.b);
                com.anythink.expressad.foundation.f.b.a().a(this.c + "_1", this.u);
            }
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView != null) {
                playerView.setOnClickListener(null);
                this.q.release();
                this.q = null;
            }
            com.anythink.expressad.video.widget.SoundImageView soundImageView = this.r;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(null);
            }
            android.view.View view = this.t;
            if (view != null) {
                view.setOnClickListener(null);
            }
            if (this.v != null) {
                this.v = null;
            }
            setOnClickListener(null);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void onPause() {
        com.anythink.expressad.playercommon.PlayerView playerView = this.q;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.J = isPlayIng;
            this.q.setIsBTVideoPlaying(isPlayIng);
            this.q.onPause();
        }
    }

    public void onResume() {
        com.anythink.expressad.playercommon.PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setDesk(true);
            this.q.setIsCovered(false);
            if (this.J) {
                this.q.onResume();
            }
        }
    }

    public void onStop() {
        com.anythink.expressad.playercommon.PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView != null) {
                playerView.pause();
                android.webkit.WebView webView = this.v;
                if (webView != null) {
                    com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerPause", this.d);
                }
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void play() {
        com.anythink.expressad.video.bt.module.AnythinkBTVideoView.a aVar;
        try {
            if (this.K) {
                if (this.D) {
                    this.q.playVideo(0);
                    this.D = false;
                } else {
                    this.q.start(false);
                }
                android.webkit.WebView webView = this.v;
                if (webView != null) {
                    com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerPlay", this.d);
                    return;
                }
                return;
            }
            if (this.E == 1) {
                playMute();
            } else {
                playUnMute();
            }
            if (!this.q.playVideo() && (aVar = this.A) != null) {
                aVar.onPlayError("play video failed");
            }
            this.K = true;
            android.webkit.WebView webView2 = this.v;
            if (webView2 != null) {
                com.anythink.expressad.video.bt.module.BTBaseView.a(webView2, "onPlayerPlay", this.d);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public boolean playMute() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView != null && this.v != null) {
                playerView.closeSound();
                this.r.setSoundStatus(false);
                this.B = 1;
                com.anythink.expressad.video.bt.module.BTBaseView.a(this.v, "onPlayerMute", this.d);
                return true;
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView == null || this.v == null) {
                return false;
            }
            playerView.openSound();
            this.r.setSoundStatus(true);
            this.B = 2;
            com.anythink.expressad.video.bt.module.BTBaseView.a(this.v, "onUnmute", this.d);
            return true;
        } catch (java.lang.Exception e) {
            e.getMessage();
            return false;
        }
    }

    public void preLoadData() {
        java.lang.String str;
        if (this.b.w() == 94 || this.b.w() == 287) {
            str = this.b.Z() + this.b.aZ() + this.b.S();
        } else {
            str = this.b.aZ() + this.b.S() + this.b.B();
        }
        com.anythink.expressad.videocommon.b.c a2 = com.anythink.expressad.videocommon.b.e.a().a(this.c, str);
        if (a2 != null) {
            this.w = a2;
        }
        this.C = e();
        java.lang.String d = d();
        this.G = d;
        if (this.h && !android.text.TextUtils.isEmpty(d) && this.b != null) {
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView.a aVar = new com.anythink.expressad.video.bt.module.AnythinkBTVideoView.a(this, this.v);
            this.A = aVar;
            com.anythink.expressad.foundation.d.c cVar = this.b;
            aVar.a(cVar != null ? cVar.ao() != -1 ? cVar.ao() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.c, false).v() : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.c, false).v(), com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.c, false).x());
            this.q.setDesk(false);
            this.q.initBufferIngParam(this.C);
            this.q.initVFPData(this.G, this.b.S(), this.b.ao(), this.A);
            soundOperate(this.B, -1, null);
        }
        H = false;
    }

    public void resume() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView != null) {
                if (this.D) {
                    playerView.playVideo(0);
                    this.D = false;
                } else {
                    playerView.onResume();
                }
                android.webkit.WebView webView = this.v;
                if (webView != null) {
                    com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerResume", this.d);
                }
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        super.setCampaign(cVar);
        if (cVar == null || cVar.i() <= 0) {
            this.f265s.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_shape_progress", com.anythink.expressad.foundation.h.i.c));
            this.f265s.setWidth(com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 30.0f));
            return;
        }
        this.f265s.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_reward_video_time_count_num_bg", com.anythink.expressad.foundation.h.i.c));
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 30.0f));
        int b = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 5.0f);
        layoutParams.setMargins(b, 0, 0, 0);
        this.f265s.setPadding(b, 0, b, 0);
        this.f265s.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i) {
        this.t.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i) {
        this.f265s.setVisibility(i == 0 ? 4 : 0);
    }

    public void setCreateWebView(android.webkit.WebView webView) {
        this.v = webView;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            i = this.L.getPaddingLeft();
        }
        if (i2 <= 0) {
            i2 = this.L.getPaddingRight();
        }
        if (i3 <= 0) {
            i3 = this.L.getPaddingTop();
        }
        if (i4 <= 0) {
            i4 = this.L.getPaddingBottom();
        }
        java.lang.String.format("%1s-%2s-%3s-%4s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        this.L.setPadding(i, i3, i2, i4);
    }

    public void setOrientation(int i) {
        this.F = i;
    }

    public void setPlaybackParams(float f) {
        com.anythink.expressad.playercommon.PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setPlaybackParams(f);
        }
    }

    public void setProgressBarState(int i) {
        android.widget.ProgressBar progressBar = this.M;
        if (progressBar != null) {
            progressBar.setVisibility(i == 0 ? 8 : 0);
        }
    }

    public void setShowClose(int i) {
        this.y = i;
    }

    public void setShowMute(int i) {
        this.z = i;
    }

    public void setShowTime(int i) {
        this.x = i;
    }

    public void setSoundImageViewVisble(int i) {
        this.r.setVisibility(i == 0 ? 4 : 0);
    }

    public void setVolume(float f, float f2) {
        com.anythink.expressad.playercommon.PlayerView playerView = this.q;
        if (playerView != null) {
            playerView.setVolume(f, f2);
        }
    }

    public void soundOperate(int i, int i2, java.lang.String str) {
        if (this.h) {
            this.B = i;
            if (i == 1) {
                this.r.setSoundStatus(false);
                this.q.closeSound();
            } else if (i == 2) {
                this.r.setSoundStatus(true);
                this.q.openSound();
            }
            if (i2 == 1) {
                this.r.setVisibility(8);
            } else if (i2 == 2) {
                this.r.setVisibility(0);
            }
        }
    }

    public void stop() {
        try {
            com.anythink.expressad.playercommon.PlayerView playerView = this.q;
            if (playerView != null) {
                playerView.pause();
                this.q.stop();
                try {
                    this.q.prepare();
                    this.q.justSeekTo(0);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                android.webkit.WebView webView = this.v;
                if (webView != null) {
                    com.anythink.expressad.video.bt.module.BTBaseView.a(webView, "onPlayerStop", this.d);
                }
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }
}
