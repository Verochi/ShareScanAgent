package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public class WebLandpagePlayerView extends com.anythink.basead.ui.animplayerview.BaseAnimPlayerView implements com.anythink.core.basead.ui.web.b {
    int A;
    com.anythink.core.api.IOfferClickHandler B;
    int C;
    java.lang.String D;
    boolean E;
    private final int F;
    private final int G;
    private final int H;
    private final int I;
    private android.view.animation.TranslateAnimation J;
    private android.view.animation.TranslateAnimation K;
    private android.view.animation.TranslateAnimation L;
    private android.webkit.WebView M;
    private com.anythink.core.basead.ui.web.c N;
    private android.webkit.ValueCallback<android.net.Uri[]> O;
    private final int P;
    private java.lang.String Q;
    private int R;
    private java.util.Map<java.lang.String, org.json.JSONArray> S;
    android.widget.LinearLayout y;
    int z;

    /* renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this, this.a);
            com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.animation.Animation.AnimationListener {
        public AnonymousClass2() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
            if (com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.M != null) {
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.M.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.webkit.DownloadListener {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass3(android.content.Context context) {
            this.a = context;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
            com.anythink.core.common.f.l lVar = webLandpagePlayerView.w;
            if (lVar == null || webLandpagePlayerView.x == null || android.text.TextUtils.isEmpty(lVar.E())) {
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.z = 11;
                com.anythink.core.common.o.m.a(str);
            } else {
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView2 = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
                com.anythink.core.api.IOfferClickHandler iOfferClickHandler = webLandpagePlayerView2.B;
                if (iOfferClickHandler != null && (iOfferClickHandler instanceof com.anythink.core.api.IOfferClickHandler) && iOfferClickHandler.startDownloadApp(this.a, webLandpagePlayerView2.w, webLandpagePlayerView2.x, str)) {
                    com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView3 = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
                    webLandpagePlayerView3.z = 6;
                    webLandpagePlayerView3.A = 1;
                } else {
                    com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.A = 2;
                    com.anythink.core.common.o.m.a(str);
                    com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.z = 7;
                }
            }
            com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.c(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$4, reason: invalid class name */
    public class AnonymousClass4 extends android.webkit.WebChromeClient {
        public AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
            com.anythink.core.basead.ui.a.a.a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.getContext(), str, callback);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri[]> valueCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
            try {
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.O = valueCallback;
                android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.getContext() instanceof android.app.Activity) {
                    ((android.app.Activity) com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.getContext()).startActivityForResult(android.content.Intent.createChooser(intent, "File Chooser"), 512);
                }
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.M != null) {
                com.anythink.core.common.f.ba a = com.anythink.core.basead.a.a.a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.D);
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
                webLandpagePlayerView.z = a.l;
                android.webkit.WebView webView = webLandpagePlayerView.M;
                java.lang.String str = a.o;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
                webView.loadUrl(str);
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView2 = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
                webLandpagePlayerView2.recordRedirectUrl(webLandpagePlayerView2.M.getUrl());
                if (com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.y.getAnimation() != null) {
                    com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.y.getAnimation().cancel();
                }
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView3 = com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this;
                webLandpagePlayerView3.y.startAnimation(webLandpagePlayerView3.K);
                com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.M.startAnimation(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.this.L);
            }
        }
    }

    public WebLandpagePlayerView(android.content.Context context) {
        super(context, null);
        this.F = 1;
        this.G = 2;
        this.H = 3;
        this.I = 0;
        this.z = 8;
        this.A = 0;
        this.O = null;
        this.P = 512;
        this.C = 0;
        this.E = false;
        this.Q = "";
        this.R = 0;
    }

    public WebLandpagePlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.F = 1;
        this.G = 2;
        this.H = 3;
        this.I = 0;
        this.z = 8;
        this.A = 0;
        this.O = null;
        this.P = 512;
        this.C = 0;
        this.E = false;
        this.Q = "";
        this.R = 0;
    }

    public WebLandpagePlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = 1;
        this.G = 2;
        this.H = 3;
        this.I = 0;
        this.z = 8;
        this.A = 0;
        this.O = null;
        this.P = 512;
        this.C = 0;
        this.E = false;
        this.Q = "";
        this.R = 0;
    }

    private void a(android.content.Context context) {
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels - com.anythink.core.common.o.i.a(context, 40.0f));
        this.S = new java.util.LinkedHashMap();
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.y = linearLayout;
        linearLayout.setGravity(1);
        this.y.setOrientation(1);
        this.y.setBackgroundColor(-1);
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(context);
        recycleImageView.setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_arrow_up", com.anythink.expressad.foundation.h.i.c));
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(context, 9.0f), com.anythink.core.common.o.i.a(context, 9.0f));
        layoutParams.topMargin = com.anythink.core.common.o.i.a(context, 3.0f);
        this.y.addView(recycleImageView, layoutParams);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_slide_hint", com.anythink.expressad.foundation.h.i.g));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(android.graphics.Color.parseColor("#000000"));
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.anythink.core.common.o.i.a(context, 1.0f);
        this.y.addView(textView, layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.y, layoutParams3);
        if (this.J == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, com.anythink.core.common.o.i.a(context, 18.0f), 0.0f);
            this.J = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.J.setRepeatMode(2);
            this.J.setRepeatCount(-1);
            this.J.setInterpolator(new android.view.animation.AnticipateInterpolator());
            this.J.setDuration(600L);
        }
        this.y.startAnimation(this.J);
        post(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass1(context));
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView) {
        if (webLandpagePlayerView.K == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, -webLandpagePlayerView.getMeasuredHeight());
            webLandpagePlayerView.K = translateAnimation;
            translateAnimation.setFillAfter(true);
            webLandpagePlayerView.K.setDuration(1200L);
        }
        if (webLandpagePlayerView.L == null) {
            android.view.animation.TranslateAnimation translateAnimation2 = new android.view.animation.TranslateAnimation(0.0f, 0.0f, webLandpagePlayerView.getMeasuredHeight(), 0.0f);
            webLandpagePlayerView.L = translateAnimation2;
            translateAnimation2.setFillAfter(true);
            webLandpagePlayerView.L.setDuration(1200L);
            webLandpagePlayerView.L.setAnimationListener(webLandpagePlayerView.new AnonymousClass2());
        }
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView, android.content.Context context) {
        try {
            webLandpagePlayerView.M = new com.anythink.core.basead.ui.web.BaseWebView(context);
            webLandpagePlayerView.N = new com.anythink.core.basead.ui.web.c(webLandpagePlayerView.w);
            webLandpagePlayerView.M.setBackgroundColor(-1);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, webLandpagePlayerView.getMeasuredHeight());
            webLandpagePlayerView.M.setVisibility(8);
            webLandpagePlayerView.addView(webLandpagePlayerView.M, layoutParams);
            com.anythink.core.basead.ui.a.a.a(context);
            com.anythink.core.basead.ui.a.a.a(webLandpagePlayerView.M, context, webLandpagePlayerView);
            webLandpagePlayerView.M.setDownloadListener(webLandpagePlayerView.new AnonymousClass3(context));
            webLandpagePlayerView.E = true;
        } catch (java.lang.Throwable unused) {
            webLandpagePlayerView.E = false;
        }
    }

    private void b(android.content.Context context) {
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.y = linearLayout;
        linearLayout.setGravity(1);
        this.y.setOrientation(1);
        this.y.setBackgroundColor(-1);
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(context);
        recycleImageView.setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_arrow_up", com.anythink.expressad.foundation.h.i.c));
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(context, 9.0f), com.anythink.core.common.o.i.a(context, 9.0f));
        layoutParams.topMargin = com.anythink.core.common.o.i.a(context, 3.0f);
        this.y.addView(recycleImageView, layoutParams);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_slide_hint", com.anythink.expressad.foundation.h.i.g));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(android.graphics.Color.parseColor("#000000"));
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.anythink.core.common.o.i.a(context, 1.0f);
        this.y.addView(textView, layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.y, layoutParams3);
        if (this.J == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, com.anythink.core.common.o.i.a(context, 18.0f), 0.0f);
            this.J = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.J.setRepeatMode(2);
            this.J.setRepeatCount(-1);
            this.J.setInterpolator(new android.view.animation.AnticipateInterpolator());
            this.J.setDuration(600L);
        }
        this.y.startAnimation(this.J);
    }

    public static /* synthetic */ int c(com.anythink.basead.ui.animplayerview.WebLandpagePlayerView webLandpagePlayerView) {
        webLandpagePlayerView.R = 2;
        return 2;
    }

    private void c(android.content.Context context) {
        try {
            this.M = new com.anythink.core.basead.ui.web.BaseWebView(context);
            this.N = new com.anythink.core.basead.ui.web.c(this.w);
            this.M.setBackgroundColor(-1);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, getMeasuredHeight());
            this.M.setVisibility(8);
            addView(this.M, layoutParams);
            com.anythink.core.basead.ui.a.a.a(context);
            com.anythink.core.basead.ui.a.a.a(this.M, context, this);
            this.M.setDownloadListener(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass3(context));
            this.E = true;
        } catch (java.lang.Throwable unused) {
            this.E = false;
        }
    }

    private void d(android.content.Context context) {
        com.anythink.core.basead.ui.a.a.a(this.M, context, this);
        this.M.setDownloadListener(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass3(context));
    }

    private void j() {
        if (this.K == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, -getMeasuredHeight());
            this.K = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.K.setDuration(1200L);
        }
        if (this.L == null) {
            android.view.animation.TranslateAnimation translateAnimation2 = new android.view.animation.TranslateAnimation(0.0f, 0.0f, getMeasuredHeight(), 0.0f);
            this.L = translateAnimation2;
            translateAnimation2.setFillAfter(true);
            this.L.setDuration(1200L);
            this.L.setAnimationListener(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass2());
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void callbackClickResult(com.anythink.core.common.f.ba baVar) {
        this.z = baVar.l;
        if (baVar.n) {
            if (!baVar.m) {
                this.C = 2;
            } else {
                this.C = 1;
                this.R = 2;
            }
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void g() {
        com.anythink.core.common.f.m mVar;
        super.g();
        android.webkit.WebView webView = this.M;
        if (webView != null) {
            webView.setDownloadListener(null);
            this.M.destroy();
        }
        this.M = null;
        com.anythink.core.common.f.l lVar = this.w;
        if (lVar == null || (mVar = this.x) == null) {
            return;
        }
        java.lang.String str = mVar.b;
        java.lang.String str2 = mVar.d;
        int d = lVar.d();
        java.lang.String s2 = this.w.s();
        java.util.Map<java.lang.String, org.json.JSONArray> map = this.S;
        int i = this.C;
        int i2 = this.A;
        int i3 = this.z;
        java.lang.String str3 = this.D;
        int i4 = this.x.j;
        java.lang.String str4 = this.Q;
        int i5 = this.R;
        com.anythink.core.common.n.c.a(str, str2, d, s2, map, i, i2, i3, str3, i4, 1, 0L, str4, i5 == 0 ? 1 : i5);
    }

    @Override // com.anythink.core.basead.ui.web.b
    public com.anythink.core.basead.ui.web.WebProgressBarView getWebProgressBarView() {
        return null;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        super.init(lVar, mVar, z, list);
        android.content.Context context = getContext();
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels - com.anythink.core.common.o.i.a(context, 40.0f));
        this.S = new java.util.LinkedHashMap();
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.y = linearLayout;
        linearLayout.setGravity(1);
        this.y.setOrientation(1);
        this.y.setBackgroundColor(-1);
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(context);
        recycleImageView.setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_arrow_up", com.anythink.expressad.foundation.h.i.c));
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(context, 9.0f), com.anythink.core.common.o.i.a(context, 9.0f));
        layoutParams.topMargin = com.anythink.core.common.o.i.a(context, 3.0f);
        this.y.addView(recycleImageView, layoutParams);
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_slide_hint", com.anythink.expressad.foundation.h.i.g));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(android.graphics.Color.parseColor("#000000"));
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.anythink.core.common.o.i.a(context, 1.0f);
        this.y.addView(textView, layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.y, layoutParams3);
        if (this.J == null) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, com.anythink.core.common.o.i.a(context, 18.0f), 0.0f);
            this.J = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.J.setRepeatMode(2);
            this.J.setRepeatCount(-1);
            this.J.setInterpolator(new android.view.animation.AnticipateInterpolator());
            this.J.setDuration(600L);
        }
        this.y.startAnimation(this.J);
        post(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass1(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        android.net.Uri[] uriArr;
        android.content.ClipData clipData;
        if (i == 512) {
            try {
                if (this.O == null) {
                    return;
                }
                if (i2 != -1 || intent == null) {
                    uriArr = null;
                } else {
                    java.lang.String dataString = intent.getDataString();
                    try {
                        clipData = intent.getClipData();
                    } catch (java.lang.Throwable unused) {
                    }
                    if (clipData != null) {
                        uriArr = new android.net.Uri[clipData.getItemCount()];
                        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                            try {
                                uriArr[i3] = clipData.getItemAt(i3).getUri();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        if (dataString != null) {
                            uriArr = new android.net.Uri[]{android.net.Uri.parse(dataString)};
                        }
                    }
                    uriArr = null;
                    if (dataString != null) {
                    }
                }
                this.O.onReceiveValue(uriArr);
                this.O = null;
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebFinish() {
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageFinish(android.webkit.WebView webView, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.R != 3) {
            this.R = 2;
            org.json.JSONArray jSONArray = this.S.get(str);
            if (jSONArray != null) {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(java.lang.System.currentTimeMillis());
                    jSONArray.put(1, sb.toString());
                    this.S.put(str, jSONArray);
                } catch (org.json.JSONException unused) {
                }
            }
        }
        com.anythink.core.basead.ui.web.c cVar = this.N;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageLoadError(android.webkit.WebView webView, java.lang.String str) {
        this.R = 3;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageStart(android.webkit.WebView webView, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.R = 1;
        org.json.JSONArray jSONArray = this.S.get(str);
        if (jSONArray != null) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.lang.System.currentTimeMillis());
                jSONArray.put(0, sb.toString());
                jSONArray.put(1, "");
                this.S.put(str, jSONArray);
            } catch (org.json.JSONException unused) {
            }
        }
    }

    public synchronized boolean openInternalWebView(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
        if (android.text.TextUtils.isEmpty(this.D)) {
            this.D = str;
            this.B = iOfferClickHandler;
            post(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass5());
        }
        return this.E;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        super.pause();
        if (this.M != null) {
            android.webkit.CookieSyncManager.getInstance().stopSync();
            this.M.setWebChromeClient(null);
            com.anythink.core.basead.ui.a.a.a(this.M, getContext() instanceof android.app.Activity ? ((android.app.Activity) getContext()).isFinishing() : false);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void recordRedirectUrl(java.lang.String str) {
        if (this.S.size() > 0) {
            org.json.JSONArray jSONArray = this.S.get(this.Q);
            try {
                if (this.R == 0 && jSONArray != null) {
                    if (android.text.TextUtils.isEmpty(jSONArray.getString(1))) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(java.lang.System.currentTimeMillis());
                        jSONArray.put(1, sb.toString());
                    }
                    this.S.put(this.Q, jSONArray);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(java.lang.System.currentTimeMillis());
        jSONArray2.put(sb2.toString());
        jSONArray2.put("");
        this.S.put(str, jSONArray2);
        this.Q = str;
        this.R = 0;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        super.start();
        if (this.M != null) {
            android.webkit.CookieSyncManager.getInstance().startSync();
            this.M.setWebChromeClient(new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.AnonymousClass4());
            this.M.onResume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        super.stop();
    }
}
