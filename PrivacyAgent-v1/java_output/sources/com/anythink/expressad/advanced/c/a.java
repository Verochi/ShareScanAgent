package com.anythink.expressad.advanced.c;

/* loaded from: classes12.dex */
public final class a {
    private static java.lang.String a = "NativeAdvancedLoadManager";
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private static final int m = 4;
    private static final int n = 5;
    private int A;
    private java.lang.String b;
    private java.lang.String c;
    private long d;
    private com.anythink.expressad.advanced.b.a e;
    private com.anythink.expressad.advanced.view.ATNativeAdvancedView g;
    private com.anythink.expressad.d.c h;
    private com.anythink.expressad.foundation.d.c i;
    private int o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f196s;
    private int t;
    private boolean u;
    private volatile boolean v;
    private com.anythink.expressad.videocommon.d.b w;
    private com.anythink.expressad.videocommon.b.i.d x;
    private com.anythink.expressad.videocommon.b.i.d y;
    private java.lang.String z;
    private java.lang.String B = "";
    private android.os.Handler C = new com.anythink.expressad.advanced.c.a.AnonymousClass1(android.os.Looper.getMainLooper());
    private java.lang.Runnable D = new com.anythink.expressad.advanced.c.a.AnonymousClass3();
    private android.content.Context f = com.anythink.core.common.b.o.a().f();

    /* renamed from: com.anythink.expressad.advanced.c.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            java.lang.Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                java.lang.Object obj2 = message.obj;
                int i2 = message.arg1;
                if (obj2 == null || !(obj2 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj2;
                com.anythink.expressad.advanced.c.a.a(com.anythink.expressad.advanced.c.a.this, com.anythink.expressad.videocommon.b.i.a().c(cVar.c()), cVar, i2);
                return;
            }
            if (i == 2) {
                java.lang.Object obj3 = message.obj;
                if (obj3 == null || !(obj3 instanceof java.lang.String)) {
                    return;
                }
                com.anythink.expressad.advanced.c.a aVar = com.anythink.expressad.advanced.c.a.this;
                java.lang.String obj4 = obj3.toString();
                java.lang.String unused = com.anythink.expressad.advanced.c.a.this.f196s;
                aVar.b(obj4, com.anythink.expressad.advanced.c.a.this.t);
                return;
            }
            if (i == 3) {
                java.lang.Object obj5 = message.obj;
                if (obj5 == null || !(obj5 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                com.anythink.expressad.advanced.c.a aVar2 = com.anythink.expressad.advanced.c.a.this;
                aVar2.a((com.anythink.expressad.foundation.d.c) obj5, aVar2.t);
                return;
            }
            if (i != 4) {
                if (i == 5 && (obj = message.obj) != null && (obj instanceof com.anythink.expressad.foundation.d.c)) {
                    if (com.anythink.expressad.advanced.c.a.this.g != null) {
                        com.anythink.expressad.advanced.c.a.this.g.setVideoReady(true);
                    }
                    com.anythink.expressad.advanced.c.a aVar3 = com.anythink.expressad.advanced.c.a.this;
                    aVar3.a((com.anythink.expressad.foundation.d.c) obj, aVar3.t);
                    return;
                }
                return;
            }
            java.lang.Object obj6 = message.obj;
            if (obj6 == null || !(obj6 instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            if (com.anythink.expressad.advanced.c.a.this.g != null) {
                com.anythink.expressad.advanced.c.a.this.g.setEndCardReady(true);
            }
            com.anythink.expressad.advanced.c.a aVar4 = com.anythink.expressad.advanced.c.a.this;
            aVar4.a((com.anythink.expressad.foundation.d.c) obj6, aVar4.t);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.advanced.view.ATNativeAdvancedWebview a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass10(com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview, java.lang.String str) {
            this.a = aTNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.a;
            java.lang.String c = com.anythink.expressad.foundation.h.x.c(this.b);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(aTNativeAdvancedWebview, c);
            aTNativeAdvancedWebview.loadUrl(c);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.videocommon.d.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass2(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = this.a;
            obtain.what = 5;
            com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = str;
            obtain.what = 2;
            com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.c.a aVar = com.anythink.expressad.advanced.c.a.this;
            java.lang.String unused = aVar.f196s;
            aVar.b("load timeout", com.anythink.expressad.advanced.c.a.this.t);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        /* renamed from: com.anythink.expressad.advanced.c.a$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.c.a.AnonymousClass4 anonymousClass4 = com.anythink.expressad.advanced.c.a.AnonymousClass4.this;
                com.anythink.expressad.advanced.c.a.this.a(anonymousClass4.a, anonymousClass4.b);
            }
        }

        /* renamed from: com.anythink.expressad.advanced.c.a$4$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.c.a.AnonymousClass4 anonymousClass4 = com.anythink.expressad.advanced.c.a.AnonymousClass4.this;
                com.anythink.expressad.advanced.c.a.this.a(anonymousClass4.a, anonymousClass4.b);
            }
        }

        public AnonymousClass4(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.C != null) {
                com.anythink.expressad.advanced.c.a.this.C.post(new com.anythink.expressad.advanced.c.a.AnonymousClass4.AnonymousClass1());
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.C != null) {
                com.anythink.expressad.advanced.c.a.this.C.post(new com.anythink.expressad.advanced.c.a.AnonymousClass4.AnonymousClass2());
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.expressad.videocommon.b.i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        public AnonymousClass5(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.C != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 4;
                obtain.obj = this.a;
                obtain.arg1 = this.b;
                com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.g != null) {
                com.anythink.expressad.advanced.c.a.this.g.setEndCardReady(false);
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        /* renamed from: com.anythink.expressad.advanced.c.a$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.c.a.AnonymousClass6 anonymousClass6 = com.anythink.expressad.advanced.c.a.AnonymousClass6.this;
                com.anythink.expressad.advanced.c.a.this.a(anonymousClass6.a, anonymousClass6.b);
            }
        }

        /* renamed from: com.anythink.expressad.advanced.c.a$6$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.c.a.AnonymousClass6 anonymousClass6 = com.anythink.expressad.advanced.c.a.AnonymousClass6.this;
                com.anythink.expressad.advanced.c.a.this.a(anonymousClass6.a, anonymousClass6.b);
            }
        }

        public AnonymousClass6(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.C != null) {
                com.anythink.expressad.advanced.c.a.this.C.post(new com.anythink.expressad.advanced.c.a.AnonymousClass6.AnonymousClass1());
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            if (com.anythink.expressad.advanced.c.a.this.C != null) {
                com.anythink.expressad.advanced.c.a.this.C.post(new com.anythink.expressad.advanced.c.a.AnonymousClass6.AnonymousClass2());
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        /* renamed from: com.anythink.expressad.advanced.c.a$7$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.File a;

            public AnonymousClass1(java.io.File file) {
                this.a = file;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.c.a aVar = com.anythink.expressad.advanced.c.a.this;
                java.lang.String str = "file:////" + this.a.getAbsolutePath();
                com.anythink.expressad.advanced.c.a.AnonymousClass7 anonymousClass7 = com.anythink.expressad.advanced.c.a.AnonymousClass7.this;
                com.anythink.expressad.advanced.c.a.a(aVar, str, anonymousClass7.a, anonymousClass7.b);
            }
        }

        public AnonymousClass7(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.io.File file;
            java.io.File file2;
            java.io.FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        file2 = new java.io.File(this.a.d());
                        try {
                            if (!file2.exists()) {
                                java.lang.String b = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                                java.lang.String a = com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(this.a.d()));
                                if (android.text.TextUtils.isEmpty(a)) {
                                    a = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                                }
                                file = new java.io.File(b, a.concat(".html"));
                                try {
                                    if (!file.exists()) {
                                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                                        try {
                                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                            sb.append("<script>");
                                            com.anythink.expressad.d.b.a.a();
                                            sb.append(com.anythink.expressad.d.b.a.b());
                                            sb.append("</script>");
                                            sb.append(this.a.d());
                                            fileOutputStream2.write(sb.toString().getBytes());
                                            fileOutputStream2.flush();
                                            fileOutputStream = fileOutputStream2;
                                        } catch (java.lang.Exception e) {
                                            e = e;
                                            fileOutputStream = fileOutputStream2;
                                            e.printStackTrace();
                                            this.a.j("");
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            file2 = file;
                                            if (!file2.exists()) {
                                            }
                                            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
                                            com.anythink.expressad.advanced.c.a aVar = com.anythink.expressad.advanced.c.a.this;
                                            java.lang.String unused2 = aVar.f196s;
                                            aVar.b("html file write failed", this.b);
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    file2 = file;
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            file = file2;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    file = null;
                }
                if (!file2.exists() && file2.isFile() && file2.canRead()) {
                    this.a.b(file2.getAbsolutePath());
                    java.lang.String unused3 = com.anythink.expressad.advanced.c.a.a;
                    com.anythink.core.common.b.o.a().b(new com.anythink.expressad.advanced.c.a.AnonymousClass7.AnonymousClass1(file2));
                } else {
                    java.lang.String unused4 = com.anythink.expressad.advanced.c.a.a;
                    com.anythink.expressad.advanced.c.a aVar2 = com.anythink.expressad.advanced.c.a.this;
                    java.lang.String unused22 = aVar2.f196s;
                    aVar2.b("html file write failed", this.b);
                }
            } catch (java.lang.Exception e5) {
                com.anythink.expressad.advanced.c.a aVar3 = com.anythink.expressad.advanced.c.a.this;
                java.lang.String message = e5.getMessage();
                java.lang.String unused5 = com.anythink.expressad.advanced.c.a.this.f196s;
                aVar3.b(message, this.b);
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$8, reason: invalid class name */
    public class AnonymousClass8 implements com.anythink.expressad.videocommon.b.i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        public AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            obtain.obj = this.a;
            obtain.arg1 = this.b;
            com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.advanced.c.a.a;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            com.anythink.expressad.advanced.c.a.this.C.sendMessage(obtain);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.a$9, reason: invalid class name */
    public class AnonymousClass9 extends com.anythink.expressad.atsignalcommon.a.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        public AnonymousClass9(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (!this.a.s()) {
                com.anythink.expressad.advanced.c.a.this.g.setH5Ready(true);
                com.anythink.expressad.advanced.a.a.a(this.a.Z());
                com.anythink.expressad.advanced.c.a.b(com.anythink.expressad.advanced.c.a.this, this.a, this.b);
            }
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.advanced.c.a.this.b(str, this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslError.getPrimaryError();
            com.anythink.expressad.advanced.c.a.this.b("onReceivedSslError:" + sslError.getUrl(), this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
            if (i != 1) {
                com.anythink.expressad.advanced.c.a.this.b("readyState 2", this.b);
                return;
            }
            com.anythink.expressad.advanced.c.a.this.g.setH5Ready(true);
            com.anythink.expressad.advanced.a.a.a(this.a.Z());
            com.anythink.expressad.advanced.c.a.b(com.anythink.expressad.advanced.c.a.this, this.a, this.b);
        }
    }

    public a(java.lang.String str, java.lang.String str2) {
        this.c = str;
        this.b = str2;
    }

    private void a(long j2) {
        this.C.postDelayed(this.D, j2);
    }

    public static /* synthetic */ void a(com.anythink.expressad.advanced.c.a aVar, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = aVar.g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl(aVar.g.getContext(), aVar.c, aVar.b);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(aVar.o);
        nativeAdvancedJSBridgeImpl.setCountdownS(aVar.p);
        aVar.g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        java.lang.System.currentTimeMillis();
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview advancedNativeWebview = aVar.g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            aVar.b("webview is null", i);
            return;
        }
        if (advancedNativeWebview.isDestroyed()) {
            aVar.b("webview is destroyed", i);
            return;
        }
        advancedNativeWebview.setWebViewListener(aVar.new AnonymousClass9(cVar, i));
        if (advancedNativeWebview.isDestroyed()) {
            aVar.b("webview has destory", i);
            return;
        }
        android.os.Handler handler = aVar.C;
        if (handler != null) {
            handler.post(aVar.new AnonymousClass10(advancedNativeWebview, str));
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.i = cVar;
        if (com.anythink.expressad.advanced.c.c.a(this.g, cVar)) {
            a(cVar, 2);
            return;
        }
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!android.text.TextUtils.isEmpty(cVar.c())) {
            cVar.c();
            this.x = new com.anythink.expressad.advanced.c.a.AnonymousClass8(cVar);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (!android.text.TextUtils.isEmpty(cVar.d())) {
            cVar.d();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.advanced.c.a.AnonymousClass7(cVar));
        }
        if (!android.text.TextUtils.isEmpty(cVar.S())) {
            cVar.S();
            this.w = new com.anythink.expressad.advanced.c.a.AnonymousClass2(cVar);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
                this.g.setVideoReady(true);
                a(cVar, 2);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.b);
            }
        }
        if (!android.text.TextUtils.isEmpty(cVar.be())) {
            cVar.be();
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.be(), new com.anythink.expressad.advanced.c.a.AnonymousClass6(cVar));
        }
        if (!android.text.TextUtils.isEmpty(cVar.I())) {
            cVar.I();
            this.y = new com.anythink.expressad.advanced.c.a.AnonymousClass5(cVar);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.I(), (com.anythink.expressad.videocommon.b.i.a) this.y);
        }
        if (android.text.TextUtils.isEmpty(cVar.y())) {
            return;
        }
        cVar.y();
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.y(), new com.anythink.expressad.advanced.c.a.AnonymousClass4(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (!com.anythink.expressad.advanced.c.c.a(this.g, cVar) || this.v) {
            return;
        }
        i();
        this.v = true;
        com.anythink.expressad.advanced.b.a aVar = this.e;
        if (aVar != null) {
            aVar.a(cVar, i);
        }
    }

    private void a(java.lang.String str, int i) {
        b(str, i);
    }

    private void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl(this.g.getContext(), this.c, this.b);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(this.o);
        nativeAdvancedJSBridgeImpl.setCountdownS(this.p);
        this.g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        java.lang.System.currentTimeMillis();
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview advancedNativeWebview = this.g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            b("webview is null", i);
            return;
        }
        if (advancedNativeWebview.isDestroyed()) {
            b("webview is destroyed", i);
            return;
        }
        advancedNativeWebview.setWebViewListener(new com.anythink.expressad.advanced.c.a.AnonymousClass9(cVar, i));
        if (advancedNativeWebview.isDestroyed()) {
            b("webview has destory", i);
            return;
        }
        android.os.Handler handler = this.C;
        if (handler != null) {
            handler.post(new com.anythink.expressad.advanced.c.a.AnonymousClass10(advancedNativeWebview, str));
        }
    }

    private java.util.List<com.anythink.expressad.foundation.d.c> b(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null || dVar.J == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
        cVar.l(this.b);
        this.z = dVar.c();
        if (cVar.O() == 99) {
            return arrayList;
        }
        if (android.text.TextUtils.isEmpty(cVar.c()) && android.text.TextUtils.isEmpty(cVar.d())) {
            return arrayList;
        }
        if (com.anythink.expressad.foundation.h.t.a(cVar)) {
            cVar.i(com.anythink.expressad.foundation.h.t.a(this.f, cVar.ba()) ? 1 : 2);
        }
        if (cVar.ae() == 1 || !com.anythink.expressad.foundation.h.t.a(this.f, cVar.ba())) {
            arrayList.add(cVar);
            return arrayList;
        }
        cVar.bb();
        if (!com.anythink.expressad.foundation.h.t.a(cVar)) {
            return arrayList;
        }
        arrayList.add(cVar);
        return arrayList;
    }

    private void b(int i) {
        this.p = i;
    }

    public static /* synthetic */ void b(com.anythink.expressad.advanced.c.a aVar, com.anythink.expressad.foundation.d.c cVar, int i) {
        if (aVar.g.isH5Ready()) {
            aVar.a(cVar, i);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!android.text.TextUtils.isEmpty(cVar.c())) {
            cVar.c();
            this.x = new com.anythink.expressad.advanced.c.a.AnonymousClass8(cVar);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (!android.text.TextUtils.isEmpty(cVar.d())) {
            cVar.d();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.advanced.c.a.AnonymousClass7(cVar));
        }
        if (!android.text.TextUtils.isEmpty(cVar.S())) {
            cVar.S();
            this.w = new com.anythink.expressad.advanced.c.a.AnonymousClass2(cVar);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
                this.g.setVideoReady(true);
                a(cVar, 2);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.b);
            }
        }
        if (!android.text.TextUtils.isEmpty(cVar.be())) {
            cVar.be();
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.be(), new com.anythink.expressad.advanced.c.a.AnonymousClass6(cVar));
        }
        if (!android.text.TextUtils.isEmpty(cVar.I())) {
            cVar.I();
            this.y = new com.anythink.expressad.advanced.c.a.AnonymousClass5(cVar);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.I(), (com.anythink.expressad.videocommon.b.i.a) this.y);
        }
        if (android.text.TextUtils.isEmpty(cVar.y())) {
            return;
        }
        cVar.y();
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.y(), new com.anythink.expressad.advanced.c.a.AnonymousClass4(cVar));
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (this.g.isH5Ready()) {
            a(cVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str, int i) {
        if (this.v) {
            return;
        }
        i();
        this.v = true;
        com.anythink.expressad.advanced.b.a aVar = this.e;
        if (aVar != null) {
            aVar.a(str, i);
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.y(), new com.anythink.expressad.advanced.c.a.AnonymousClass4(cVar));
    }

    private void c(java.lang.String str, int i) {
        b(str, i);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        this.y = new com.anythink.expressad.advanced.c.a.AnonymousClass5(cVar);
        com.anythink.expressad.videocommon.b.i.a().b(cVar.I(), (com.anythink.expressad.videocommon.b.i.a) this.y);
    }

    private int e() {
        return this.p;
    }

    private void e(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.be(), new com.anythink.expressad.advanced.c.a.AnonymousClass6(cVar));
    }

    private void f() {
        try {
            int i = this.A + 1;
            this.A = i;
            com.anythink.expressad.d.c cVar = this.h;
            if (cVar == null || i > cVar.t()) {
                this.A = 0;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void f(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.advanced.c.a.AnonymousClass7(cVar));
    }

    private static void g() {
    }

    private void g(com.anythink.expressad.foundation.d.c cVar) {
        this.x = new com.anythink.expressad.advanced.c.a.AnonymousClass8(cVar);
        com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
    }

    private void h() {
        this.A = 0;
    }

    private void h(com.anythink.expressad.foundation.d.c cVar) {
        this.w = new com.anythink.expressad.advanced.c.a.AnonymousClass2(cVar);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar);
        com.anythink.expressad.videocommon.b.e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.w);
        if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
            com.anythink.expressad.videocommon.b.e.a().d(this.b);
        } else {
            this.g.setVideoReady(true);
            a(cVar, 2);
        }
    }

    private void i() {
        this.C.removeCallbacks(this.D);
    }

    private static void j() {
    }

    public final java.lang.String a() {
        return this.B;
    }

    public final java.lang.String a(java.lang.String str) {
        if (this.i == null) {
            return "";
        }
        try {
            com.anythink.expressad.videocommon.b.c a2 = com.anythink.expressad.videocommon.b.e.a().a(this.b, this.i.aZ() + this.i.S() + this.i.B());
            if (a2 == null || a2.k() != 5) {
                return str;
            }
            java.lang.String e = a2.e();
            return new java.io.File(e).exists() ? e : str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.q = i2;
    }

    public final void a(com.anythink.expressad.advanced.b.a aVar) {
        this.e = aVar;
    }

    public final void a(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView) {
        this.g = aTNativeAdvancedView;
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.h = cVar;
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList arrayList;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new java.util.ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.b);
            this.z = dVar.c();
            if (cVar.O() != 99 && (!android.text.TextUtils.isEmpty(cVar.c()) || !android.text.TextUtils.isEmpty(cVar.d()))) {
                if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                    cVar.i(com.anythink.expressad.foundation.h.t.a(this.f, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() == 1 || !com.anythink.expressad.foundation.h.t.a(this.f, cVar.ba())) {
                    arrayList.add(cVar);
                } else {
                    cVar.bb();
                    if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                        arrayList.add(cVar);
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            b("invalid  campaign", 2);
            return;
        }
        try {
            int i = this.A + 1;
            this.A = i;
            com.anythink.expressad.d.c cVar2 = this.h;
            if (cVar2 == null || i > cVar2.t()) {
                this.A = 0;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        arrayList.size();
        com.anythink.expressad.foundation.d.c cVar3 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
        if (!android.text.TextUtils.isEmpty(cVar3.c()) || (!android.text.TextUtils.isEmpty(cVar3.d()) && cVar3.d().contains("<MBTPLMARK>"))) {
            cVar3.a(true);
            cVar3.b(false);
        } else {
            cVar3.a(false);
            cVar3.b(true);
        }
        this.i = cVar3;
        if (com.anythink.expressad.advanced.c.c.a(this.g, cVar3)) {
            a(cVar3, 2);
            return;
        }
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!android.text.TextUtils.isEmpty(cVar3.c())) {
            cVar3.c();
            this.x = new com.anythink.expressad.advanced.c.a.AnonymousClass8(cVar3);
            com.anythink.expressad.videocommon.b.i.a().b(cVar3.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (!android.text.TextUtils.isEmpty(cVar3.d())) {
            cVar3.d();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.advanced.c.a.AnonymousClass7(cVar3));
        }
        if (!android.text.TextUtils.isEmpty(cVar3.S())) {
            cVar3.S();
            this.w = new com.anythink.expressad.advanced.c.a.AnonymousClass2(cVar3);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(cVar3);
            com.anythink.expressad.videocommon.b.e.a().a(this.b, arrayList2, com.anythink.expressad.foundation.g.a.aX, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar3.A())) {
                this.g.setVideoReady(true);
                a(cVar3, 2);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.b);
            }
        }
        if (!android.text.TextUtils.isEmpty(cVar3.be())) {
            cVar3.be();
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar3.be(), new com.anythink.expressad.advanced.c.a.AnonymousClass6(cVar3));
        }
        if (!android.text.TextUtils.isEmpty(cVar3.I())) {
            cVar3.I();
            this.y = new com.anythink.expressad.advanced.c.a.AnonymousClass5(cVar3);
            com.anythink.expressad.videocommon.b.i.a().b(cVar3.I(), (com.anythink.expressad.videocommon.b.i.a) this.y);
        }
        if (android.text.TextUtils.isEmpty(cVar3.y())) {
            return;
        }
        cVar3.y();
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar3.y(), new com.anythink.expressad.advanced.c.a.AnonymousClass4(cVar3));
    }

    public final void b() {
        if (this.e != null) {
            this.e = null;
        }
        b("LoadManager release", this.t);
        if (this.w != null) {
            this.w = null;
        }
        if (this.x != null) {
            this.x = null;
        }
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.i;
    }
}
