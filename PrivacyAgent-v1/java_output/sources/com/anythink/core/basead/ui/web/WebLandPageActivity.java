package com.anythink.core.basead.ui.web;

/* loaded from: classes29.dex */
public class WebLandPageActivity extends android.app.Activity implements com.anythink.core.basead.ui.web.b {
    private static final int e = 343452;
    private java.lang.String A;
    private com.anythink.core.api.IOfferClickHandler B;
    private com.anythink.core.basead.ui.web.c C;
    private int D;
    org.json.JSONArray b;
    private com.anythink.core.basead.ui.web.WebProgressBarView j;
    private android.webkit.WebView k;
    private android.widget.ImageView l;
    private android.widget.ImageView m;
    private android.widget.TextView n;
    private boolean o;
    private android.animation.ValueAnimator p;
    private java.util.Random q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private long f159s;
    private java.util.Map<java.lang.String, org.json.JSONArray> t;
    private com.anythink.core.basead.ui.web.WebLoadFailRefrshView w;
    private android.widget.RelativeLayout x;
    private com.anythink.core.common.f.l y;
    private com.anythink.core.common.f.m z;
    private final int f = 1;
    private final int g = 2;
    private final int h = 3;
    private final int i = 0;
    int a = 8;
    private java.lang.String u = "";
    private int v = 0;
    private android.webkit.ValueCallback<android.net.Uri[]> E = null;
    private final int F = 512;
    int c = 0;
    int d = 0;

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.w.a(com.anythink.core.basead.ui.web.WebLandPageActivity.this.w);
            if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.k != null) {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.k.reload();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.webkit.DownloadListener {
        public AnonymousClass2() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.y == null || com.anythink.core.basead.ui.web.WebLandPageActivity.this.z == null || android.text.TextUtils.isEmpty(com.anythink.core.basead.ui.web.WebLandPageActivity.this.y.E())) {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.a = 11;
                com.anythink.core.common.o.m.a(str);
            } else if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.B != null && (com.anythink.core.basead.ui.web.WebLandPageActivity.this.B instanceof com.anythink.core.api.IOfferClickHandler) && com.anythink.core.basead.ui.web.WebLandPageActivity.this.B.startDownloadApp(com.anythink.core.basead.ui.web.WebLandPageActivity.this.getApplicationContext(), com.anythink.core.basead.ui.web.WebLandPageActivity.this.y, com.anythink.core.basead.ui.web.WebLandPageActivity.this.z, str)) {
                com.anythink.core.basead.ui.web.WebLandPageActivity webLandPageActivity = com.anythink.core.basead.ui.web.WebLandPageActivity.this;
                webLandPageActivity.a = 6;
                webLandPageActivity.d = 1;
            } else {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.d = 2;
                com.anythink.core.common.o.m.a(str);
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.a = 7;
            }
            com.anythink.core.basead.ui.web.WebLandPageActivity.f(com.anythink.core.basead.ui.web.WebLandPageActivity.this);
            com.anythink.core.basead.ui.web.WebLandPageActivity.this.e();
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.k == null || !com.anythink.core.basead.ui.web.WebLandPageActivity.this.k.canGoBack()) {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.finish();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.k.goBack();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.basead.ui.web.WebLandPageActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$5, reason: invalid class name */
    public class AnonymousClass5 extends android.webkit.WebChromeClient {

        /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.j.setVisibility(8);
            }
        }

        public AnonymousClass5() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
            com.anythink.core.basead.ui.a.a.a(com.anythink.core.basead.ui.web.WebLandPageActivity.this, str, callback);
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(android.webkit.WebView webView, int i) {
            if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.j != null) {
                if (!com.anythink.core.basead.ui.web.WebLandPageActivity.this.p.isRunning()) {
                    com.anythink.core.basead.ui.web.WebLandPageActivity.this.j.setProgress(((i * 30) / 100) + 70);
                }
                if (i == 100) {
                    if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.p.isRunning()) {
                        com.anythink.core.basead.ui.web.WebLandPageActivity.this.p.cancel();
                        com.anythink.core.basead.ui.web.WebLandPageActivity.this.j.setProgress(100);
                    }
                    com.anythink.core.common.b.o.a().a(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass5.AnonymousClass1(), 200L);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (android.text.TextUtils.isEmpty(str) || com.anythink.core.basead.ui.web.WebLandPageActivity.this.n == null || com.anythink.core.basead.ui.web.WebLandPageActivity.this.n.getText().toString().length() != 0) {
                return;
            }
            com.anythink.core.basead.ui.web.WebLandPageActivity.this.n.setText(str);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri[]> valueCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
            try {
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.E = valueCallback;
                android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType("*/*");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                com.anythink.core.basead.ui.web.WebLandPageActivity.this.startActivityForResult(android.content.Intent.createChooser(intent, "File Chooser"), 512);
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            java.lang.String str = com.anythink.core.basead.ui.web.WebLandPageActivity.this.z.b;
            java.lang.String str2 = com.anythink.core.basead.ui.web.WebLandPageActivity.this.z.d;
            int d = com.anythink.core.basead.ui.web.WebLandPageActivity.this.y.d();
            java.lang.String s2 = com.anythink.core.basead.ui.web.WebLandPageActivity.this.y.s();
            com.anythink.core.basead.ui.web.WebLandPageActivity webLandPageActivity = com.anythink.core.basead.ui.web.WebLandPageActivity.this;
            com.anythink.core.common.n.c.a(str, str2, d, s2, webLandPageActivity.b, webLandPageActivity.u, 1);
            com.anythink.core.basead.ui.web.WebLandPageActivity.this.e();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements android.content.DialogInterface.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.content.DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            java.lang.String str = com.anythink.core.basead.ui.web.WebLandPageActivity.this.z.b;
            java.lang.String str2 = com.anythink.core.basead.ui.web.WebLandPageActivity.this.z.d;
            int d = com.anythink.core.basead.ui.web.WebLandPageActivity.this.y.d();
            java.lang.String s2 = com.anythink.core.basead.ui.web.WebLandPageActivity.this.y.s();
            com.anythink.core.basead.ui.web.WebLandPageActivity webLandPageActivity = com.anythink.core.basead.ui.web.WebLandPageActivity.this;
            com.anythink.core.common.n.c.a(str, str2, d, s2, webLandPageActivity.b, webLandPageActivity.u, 0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    /* renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$8, reason: invalid class name */
    public class AnonymousClass8 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass8() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            int intValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            if (com.anythink.core.basead.ui.web.WebLandPageActivity.this.j == null || intValue % com.anythink.core.basead.ui.web.WebLandPageActivity.this.r != 0) {
                return;
            }
            com.anythink.core.basead.ui.web.WebLandPageActivity webLandPageActivity = com.anythink.core.basead.ui.web.WebLandPageActivity.this;
            webLandPageActivity.r = webLandPageActivity.q.nextInt(12) + 3;
            com.anythink.core.basead.ui.web.WebLandPageActivity.this.j.setProgress(intValue);
        }
    }

    private android.widget.ImageView a(android.graphics.drawable.Drawable drawable) {
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(this, 48.0f), com.anythink.core.common.o.i.a(this, 48.0f));
        layoutParams.gravity = 16;
        layoutParams.rightMargin = com.anythink.core.common.o.i.a(this, 6.0f);
        imageView.setLayoutParams(layoutParams);
        int a = com.anythink.core.common.o.i.a(this, 16.0f);
        imageView.setPadding(a, a, a, a);
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private void a() {
        android.content.Intent intent = getIntent();
        if (intent != null) {
            try {
                java.io.Serializable serializableExtra = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.c);
                if (serializableExtra != null && (serializableExtra instanceof com.anythink.core.common.f.l)) {
                    com.anythink.core.common.f.l lVar = (com.anythink.core.common.f.l) serializableExtra;
                    this.y = lVar;
                    this.C = new com.anythink.core.basead.ui.web.c(lVar);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            try {
                java.io.Serializable serializableExtra2 = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof com.anythink.core.common.f.m)) {
                    this.z = (com.anythink.core.common.f.m) serializableExtra2;
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                java.io.Serializable serializableExtra3 = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof com.anythink.core.api.IOfferClickHandler)) {
                    this.B = (com.anythink.core.api.IOfferClickHandler) serializableExtra3;
                }
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.A = intent.getStringExtra(com.anythink.core.basead.a.C0161a.j);
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            try {
                this.D = intent.getIntExtra(com.anythink.core.basead.a.C0161a.q, -1);
            } catch (java.lang.Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void a(android.content.Context context, com.anythink.core.basead.b.c cVar) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.anythink.core.basead.ui.web.WebLandPageActivity.class);
        intent.putExtra(com.anythink.core.basead.a.C0161a.c, cVar.c);
        intent.putExtra(com.anythink.core.basead.a.C0161a.e, cVar.h);
        intent.putExtra(com.anythink.core.basead.a.C0161a.j, cVar.f);
        intent.putExtra(com.anythink.core.basead.a.C0161a.q, cVar.i);
        com.anythink.core.api.IOfferClickHandler iOfferClickHandler = cVar.g;
        if (iOfferClickHandler != null) {
            intent.putExtra(com.anythink.core.basead.a.C0161a.l, iOfferClickHandler);
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        cVar.f = str;
        a(context, cVar);
    }

    private void a(java.lang.String str) {
        com.anythink.core.basead.ui.a.a.a(this.k, this, this);
        this.k.setDownloadListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass2());
        com.anythink.core.common.f.ba a = com.anythink.core.basead.a.a.a(str);
        this.a = a.l;
        android.webkit.WebView webView = this.k;
        java.lang.String str2 = a.o;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
        webView.loadUrl(str2);
        recordRedirectUrl(this.k.getUrl());
    }

    private static void b() {
    }

    private static void c() {
    }

    private void d() {
        this.l.setOnClickListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass3());
        this.m.setOnClickListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ((android.view.ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    public static /* synthetic */ int f(com.anythink.core.basead.ui.web.WebLandPageActivity webLandPageActivity) {
        webLandPageActivity.v = 2;
        return 2;
    }

    private android.widget.RelativeLayout f() {
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        linearLayout.setId(e);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(this, 55.0f));
        layoutParams.addRule(10);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF"));
        int a = com.anythink.core.common.o.i.a(this, 16.0f);
        linearLayout.setPadding(a, 0, a, 0);
        relativeLayout.addView(linearLayout);
        this.l = a(getResources().getDrawable(com.anythink.core.common.o.i.a(this, "browser_left_icon", com.anythink.expressad.foundation.h.i.c)));
        this.m = a(getResources().getDrawable(com.anythink.core.common.o.i.a(this, "browser_close_icon", com.anythink.expressad.foundation.h.i.c)));
        linearLayout.addView(this.l);
        linearLayout.addView(this.m);
        android.widget.TextView textView = new android.widget.TextView(this);
        new android.widget.LinearLayout.LayoutParams(0, -2, 1.0f);
        textView.setPadding(com.anythink.core.common.o.i.a(this, 20.0f), 0, 0, com.anythink.core.common.o.i.a(this, 2.0f));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(android.graphics.Color.parseColor("#666666"));
        textView.setMaxLines(1);
        textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.n = textView;
        linearLayout.addView(textView);
        try {
            this.k = new com.anythink.core.basead.ui.web.BaseWebView(this);
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, e);
            this.k.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.k);
            android.view.View view = new android.view.View(this);
            view.setBackgroundColor(-2434342);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(this, 1.0f));
            layoutParams3.addRule(3, e);
            view.setLayoutParams(layoutParams3);
            relativeLayout.addView(view);
            com.anythink.core.basead.ui.web.WebProgressBarView webProgressBarView = new com.anythink.core.basead.ui.web.WebProgressBarView(this);
            this.j = webProgressBarView;
            webProgressBarView.setProgress(0);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(this, 4.0f));
            layoutParams4.addRule(3, e);
            relativeLayout.addView(this.j, layoutParams4);
            java.util.Random random = new java.util.Random();
            this.q = random;
            this.r = random.nextInt(12) + 3;
            android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(0, 70);
            this.p = ofInt;
            ofInt.setDuration(1000L);
            this.p.addUpdateListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass8());
            this.p.start();
            return relativeLayout;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private android.widget.TextView g() {
        android.widget.TextView textView = new android.widget.TextView(this);
        new android.widget.LinearLayout.LayoutParams(0, -2, 1.0f);
        textView.setPadding(com.anythink.core.common.o.i.a(this, 20.0f), 0, 0, com.anythink.core.common.o.i.a(this, 2.0f));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(android.graphics.Color.parseColor("#666666"));
        textView.setMaxLines(1);
        textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
        return textView;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void callbackClickResult(com.anythink.core.common.f.ba baVar) {
        this.a = baVar.l;
        if (baVar.n) {
            if (!baVar.m) {
                this.c = 2;
                return;
            }
            this.c = 1;
            this.v = 2;
            e();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        com.anythink.core.common.f.n nVar;
        com.anythink.core.common.f.m mVar = this.z;
        if (mVar != null && (nVar = mVar.n) != null && nVar.f() == 1) {
            try {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this, com.anythink.core.common.o.i.a(this, "system_dialog", com.anythink.expressad.foundation.h.i.e));
                builder.setMessage(getString(com.anythink.core.common.o.i.a(this, "web_land_page_dialog_title", com.anythink.expressad.foundation.h.i.g))).setCancelable(true).setPositiveButton(getString(com.anythink.core.common.o.i.a(this, "web_land_page_dialog_stay", com.anythink.expressad.foundation.h.i.g)), new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass7()).setNegativeButton(getString(com.anythink.core.common.o.i.a(this, "web_land_page_dialog_yes", com.anythink.expressad.foundation.h.i.g)), new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass6());
                builder.create().show();
                return;
            } catch (java.lang.Throwable unused) {
            }
        }
        e();
    }

    @Override // com.anythink.core.basead.ui.web.b
    public com.anythink.core.basead.ui.web.WebProgressBarView getWebProgressBarView() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        android.net.Uri[] uriArr;
        android.content.ClipData clipData;
        if (i == 512) {
            if (this.E == null) {
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
            this.E.onReceiveValue(uriArr);
            this.E = null;
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        android.webkit.WebView webView = this.k;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.k.goBack();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.f159s = android.os.SystemClock.elapsedRealtime();
        this.t = new java.util.LinkedHashMap();
        setResult(-1);
        boolean requestFeature = getWindow().requestFeature(2);
        this.o = requestFeature;
        if (requestFeature) {
            getWindow().setFeatureInt(2, -1);
        }
        android.content.Intent intent = getIntent();
        if (intent != null) {
            try {
                java.io.Serializable serializableExtra = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.c);
                if (serializableExtra != null && (serializableExtra instanceof com.anythink.core.common.f.l)) {
                    com.anythink.core.common.f.l lVar = (com.anythink.core.common.f.l) serializableExtra;
                    this.y = lVar;
                    this.C = new com.anythink.core.basead.ui.web.c(lVar);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            try {
                java.io.Serializable serializableExtra2 = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof com.anythink.core.common.f.m)) {
                    this.z = (com.anythink.core.common.f.m) serializableExtra2;
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                java.io.Serializable serializableExtra3 = intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof com.anythink.core.api.IOfferClickHandler)) {
                    this.B = (com.anythink.core.api.IOfferClickHandler) serializableExtra3;
                }
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.A = intent.getStringExtra(com.anythink.core.basead.a.C0161a.j);
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            try {
                this.D = intent.getIntExtra(com.anythink.core.basead.a.C0161a.q, -1);
            } catch (java.lang.Throwable th5) {
                th5.printStackTrace();
            }
        }
        java.lang.String str = this.A;
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.core.common.f.l lVar2 = this.y;
            str = lVar2 != null ? lVar2.D() : "";
        }
        android.content.Context applicationContext = getApplicationContext();
        if (android.text.TextUtils.isEmpty(str)) {
            android.widget.Toast.makeText(applicationContext, com.anythink.core.common.o.i.a(applicationContext, "basead_click_empty", com.anythink.expressad.foundation.h.i.g), 0).show();
            this.v = 3;
            e();
            return;
        }
        com.anythink.core.common.f.ba a = com.anythink.core.basead.a.a.a(applicationContext, str);
        if (a.m) {
            callbackClickResult(a);
            return;
        }
        callbackClickResult(a);
        android.widget.RelativeLayout f = f();
        this.x = f;
        if (f == null) {
            com.anythink.core.common.o.m.a(str);
            e();
            return;
        }
        setContentView(f);
        this.l.setOnClickListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass3());
        this.m.setOnClickListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass4());
        com.anythink.core.basead.ui.a.a.a(this);
        com.anythink.core.basead.ui.a.a.a(this.k, this, this);
        this.k.setDownloadListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass2());
        com.anythink.core.common.f.ba a2 = com.anythink.core.basead.a.a.a(str);
        this.a = a2.l;
        android.webkit.WebView webView = this.k;
        java.lang.String str2 = a2.o;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
        webView.loadUrl(str2);
        recordRedirectUrl(this.k.getUrl());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.anythink.core.common.f.m mVar;
        super.onDestroy();
        android.animation.ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.p = null;
        }
        android.webkit.WebView webView = this.k;
        if (webView != null) {
            webView.setDownloadListener(null);
            this.k.destroy();
        }
        this.k = null;
        com.anythink.core.common.f.l lVar = this.y;
        if (lVar == null || (mVar = this.z) == null) {
            return;
        }
        java.lang.String str = mVar.b;
        java.lang.String str2 = mVar.d;
        int d = lVar.d();
        java.lang.String s2 = this.y.s();
        java.util.Map<java.lang.String, org.json.JSONArray> map = this.t;
        int i = this.c;
        int i2 = this.d;
        int i3 = this.a;
        java.lang.String str3 = this.A;
        int i4 = this.z.j;
        int i5 = this.D;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.f159s;
        java.lang.String str4 = this.u;
        int i6 = this.v;
        com.anythink.core.common.n.c.a(str, str2, d, s2, map, i, i2, i3, str3, i4, i5, elapsedRealtime, str4, i6 == 0 ? 1 : i6);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        android.webkit.CookieSyncManager.getInstance().stopSync();
        android.webkit.WebView webView = this.k;
        if (webView != null) {
            webView.setWebChromeClient(null);
            com.anythink.core.basead.ui.a.a.a(this.k, isFinishing());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        android.webkit.CookieSyncManager.getInstance().startSync();
        android.webkit.WebView webView = this.k;
        if (webView != null) {
            webView.setWebChromeClient(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass5());
            this.k.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebFinish() {
        e();
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageFinish(android.webkit.WebView webView, java.lang.String str) {
        android.webkit.WebView webView2;
        com.anythink.core.basead.ui.web.WebLoadFailRefrshView webLoadFailRefrshView = this.w;
        if (webLoadFailRefrshView != null && webLoadFailRefrshView.getParent() == null && (webView2 = this.k) != null) {
            webView2.setVisibility(0);
        }
        webView.canGoBack();
        webView.canGoForward();
        if (!android.text.TextUtils.isEmpty(str) && this.v != 3 && android.text.TextUtils.equals(this.u, str) && !isFinishing()) {
            this.v = 2;
            org.json.JSONArray jSONArray = this.t.get(str);
            if (jSONArray != null) {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(java.lang.System.currentTimeMillis());
                    jSONArray.put(1, sb.toString());
                    this.t.put(str, jSONArray);
                } catch (org.json.JSONException unused) {
                }
            }
        }
        com.anythink.core.basead.ui.web.c cVar = this.C;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageLoadError(android.webkit.WebView webView, java.lang.String str) {
        if (android.text.TextUtils.equals(this.u, str)) {
            this.v = 3;
        }
        com.anythink.core.basead.ui.web.WebLoadFailRefrshView webLoadFailRefrshView = this.w;
        if (webLoadFailRefrshView != null) {
            com.anythink.core.common.o.w.a(webLoadFailRefrshView);
        } else {
            com.anythink.core.basead.ui.web.WebLoadFailRefrshView webLoadFailRefrshView2 = new com.anythink.core.basead.ui.web.WebLoadFailRefrshView(this);
            this.w = webLoadFailRefrshView2;
            android.webkit.WebView webView2 = this.k;
            if (webView2 != null) {
                webLoadFailRefrshView2.setLayoutParams(webView2.getLayoutParams());
            }
            this.w.setOnRefreshListener(new com.anythink.core.basead.ui.web.WebLandPageActivity.AnonymousClass1());
        }
        android.webkit.WebView webView3 = this.k;
        if (webView3 != null) {
            webView3.setVisibility(8);
        }
        this.x.addView(this.w);
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageStart(android.webkit.WebView webView, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.equals(this.u, str)) {
                this.v = 1;
            }
            org.json.JSONArray jSONArray = this.t.get(str);
            if (jSONArray != null) {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(java.lang.System.currentTimeMillis());
                    jSONArray.put(0, sb.toString());
                    jSONArray.put(1, "");
                    this.t.put(str, jSONArray);
                } catch (org.json.JSONException unused) {
                }
            }
        }
        com.anythink.core.basead.ui.web.WebLoadFailRefrshView webLoadFailRefrshView = this.w;
        if (webLoadFailRefrshView != null) {
            com.anythink.core.common.o.w.a(webLoadFailRefrshView);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void recordRedirectUrl(java.lang.String str) {
        if (this.b == null) {
            this.b = new org.json.JSONArray();
        }
        this.b.put(str);
        if (this.t.size() > 0) {
            org.json.JSONArray jSONArray = this.t.get(this.u);
            try {
                if (this.v == 0 && jSONArray != null) {
                    if (android.text.TextUtils.isEmpty(jSONArray.getString(1))) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(java.lang.System.currentTimeMillis());
                        jSONArray.put(1, sb.toString());
                    }
                    this.t.put(this.u, jSONArray);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(java.lang.System.currentTimeMillis());
        jSONArray2.put(sb2.toString());
        jSONArray2.put("");
        this.t.put(str, jSONArray2);
        this.u = str;
        this.v = 0;
    }
}
