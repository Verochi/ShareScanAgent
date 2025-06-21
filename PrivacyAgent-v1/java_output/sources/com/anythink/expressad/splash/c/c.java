package com.anythink.expressad.splash.c;

/* loaded from: classes12.dex */
public final class c {
    private static java.lang.String c = "SplashLoadManager";
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private int B;
    com.anythink.expressad.foundation.d.c b;
    private java.lang.String d;
    private java.lang.String e;
    private long f;
    private long g;
    private com.anythink.expressad.splash.b.c h;
    private com.anythink.expressad.splash.view.ATSplashView j;
    private com.anythink.expressad.d.c k;
    private boolean o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f258s;
    private int t;
    private boolean u;
    private volatile boolean v;
    private com.anythink.expressad.videocommon.d.b w;
    private com.anythink.expressad.videocommon.b.i.d x;
    private java.lang.String y;
    private int z;
    private java.lang.String A = "";
    private android.os.Handler C = new com.anythink.expressad.splash.c.c.AnonymousClass1(android.os.Looper.getMainLooper());
    private java.lang.Runnable D = new com.anythink.expressad.splash.c.c.AnonymousClass2();
    boolean a = false;
    private android.content.Context i = com.anythink.core.common.b.o.a().f();

    /* renamed from: com.anythink.expressad.splash.c.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                java.lang.Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof com.anythink.expressad.foundation.d.c) {
                    com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj;
                    com.anythink.expressad.splash.c.c.a(com.anythink.expressad.splash.c.c.this, com.anythink.expressad.videocommon.b.i.a().c(cVar.c()), cVar, i2);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                java.lang.Object obj2 = message.obj;
                if (obj2 instanceof com.anythink.expressad.foundation.d.c) {
                    com.anythink.expressad.splash.c.c cVar2 = com.anythink.expressad.splash.c.c.this;
                    cVar2.b((com.anythink.expressad.foundation.d.c) obj2, cVar2.t);
                    return;
                }
                return;
            }
            java.lang.Object obj3 = message.obj;
            if (obj3 instanceof java.lang.String) {
                com.anythink.expressad.splash.c.c cVar3 = com.anythink.expressad.splash.c.c.this;
                java.lang.String obj4 = obj3.toString();
                java.lang.String unused = com.anythink.expressad.splash.c.c.this.f258s;
                int unused2 = com.anythink.expressad.splash.c.c.this.t;
                cVar3.a(obj4);
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
            java.lang.String unused = cVar.f258s;
            int unused2 = com.anythink.expressad.splash.c.c.this.t;
            cVar.a("load timeout");
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.splash.view.a {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        public AnonymousClass3(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.splash.view.a
        public final void a() {
            if (this.a.j() && com.anythink.expressad.splash.c.c.this.j != null) {
                com.anythink.expressad.splash.c.c.this.j.setImageReady(true);
                com.anythink.expressad.splash.c.c.b(com.anythink.expressad.splash.c.c.this, this.a, this.b);
            }
            com.anythink.expressad.splash.c.c.this.b(this.a, this.b);
        }

        @Override // com.anythink.expressad.splash.view.a
        public final void b() {
            if (!this.a.j() || com.anythink.expressad.splash.c.c.this.j == null) {
                return;
            }
            com.anythink.expressad.splash.c.c.this.j.setImageReady(false);
            com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
            java.lang.String unused = cVar.f258s;
            cVar.a("Image resource load faile");
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        /* renamed from: com.anythink.expressad.splash.c.c$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.File a;

            public AnonymousClass1(java.io.File file) {
                this.a = file;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
                java.lang.String str = "file:////" + this.a.getAbsolutePath();
                com.anythink.expressad.splash.c.c.AnonymousClass4 anonymousClass4 = com.anythink.expressad.splash.c.c.AnonymousClass4.this;
                com.anythink.expressad.splash.c.c.a(cVar, str, anonymousClass4.a, anonymousClass4.b);
            }
        }

        public AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
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
                                            com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
                                            java.lang.String unused = cVar.f258s;
                                            cVar.a("html file write failed");
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
                    } catch (java.lang.Exception e4) {
                        com.anythink.expressad.splash.c.c cVar2 = com.anythink.expressad.splash.c.c.this;
                        java.lang.String message = e4.getMessage();
                        java.lang.String unused2 = com.anythink.expressad.splash.c.c.this.f258s;
                        cVar2.a(message);
                        return;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                file = null;
            }
            if (!file2.exists() && file2.isFile() && file2.canRead()) {
                this.a.b(file2.getAbsolutePath());
                com.anythink.core.common.b.o.a().b(new com.anythink.expressad.splash.c.c.AnonymousClass4.AnonymousClass1(file2));
            } else {
                com.anythink.expressad.splash.c.c cVar3 = com.anythink.expressad.splash.c.c.this;
                java.lang.String unused3 = cVar3.f258s;
                cVar3.a("html file write failed");
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.expressad.videocommon.b.i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        public AnonymousClass5(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            obtain.obj = this.a;
            obtain.arg1 = this.b;
            com.anythink.expressad.splash.c.c.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
            java.lang.String unused = cVar.f258s;
            cVar.a(str);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            com.anythink.expressad.splash.c.c.this.C.sendMessage(obtain);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.splash.b.a {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        public AnonymousClass6(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(android.view.View view) {
            if (com.anythink.expressad.splash.c.c.this.j != null) {
                com.anythink.expressad.splash.c.c.this.j.setDynamicView(true);
                com.anythink.expressad.splash.c.c.this.j.setSplashNativeView(view);
                com.anythink.expressad.splash.c.c.this.b(this.a, this.b);
            }
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(java.lang.String str) {
            com.anythink.expressad.splash.c.c cVar = com.anythink.expressad.splash.c.c.this;
            java.lang.String unused = cVar.f258s;
            cVar.a(str);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$7, reason: invalid class name */
    public class AnonymousClass7 implements com.anythink.expressad.splash.c.e.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        public AnonymousClass7(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a() {
            if (this.a.s()) {
                return;
            }
            com.anythink.expressad.splash.c.c.c(com.anythink.expressad.splash.c.c.this, this.a, this.b);
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(int i) {
            if (i == 1) {
                com.anythink.expressad.splash.c.c.c(com.anythink.expressad.splash.c.c.this, this.a, this.b);
            } else {
                com.anythink.expressad.splash.c.c.this.a("readyState 2");
            }
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(java.lang.String str) {
            com.anythink.expressad.splash.c.c.this.a(str);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$8, reason: invalid class name */
    public class AnonymousClass8 implements com.anythink.expressad.videocommon.d.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str) {
            com.anythink.expressad.splash.c.c.this.j.setVideoReady(true);
            java.lang.String unused = com.anythink.expressad.splash.c.c.c;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = this.a;
            obtain.what = 3;
            com.anythink.expressad.splash.c.c.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.splash.c.c.this.j.setVideoReady(false);
            java.lang.String unused = com.anythink.expressad.splash.c.c.c;
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = str;
            obtain.what = 2;
            com.anythink.expressad.splash.c.c.this.C.sendMessage(obtain);
        }
    }

    public c(java.lang.String str, java.lang.String str2, long j) {
        this.e = str;
        this.d = str2;
        this.g = j;
    }

    private void a(long j) {
        this.C.postDelayed(this.D, j);
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.j;
        if (aTSplashView != null) {
            aTSplashView.setDynamicView(false);
        }
        if (cVar.j()) {
            d(cVar, i);
        }
        if (com.anythink.expressad.splash.c.b.a(this.j, cVar)) {
            b(cVar, i);
            return;
        }
        this.j.clearResState();
        if (!android.text.TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.x = new com.anythink.expressad.splash.c.c.AnonymousClass5(cVar, i);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (cVar.j()) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.splash.c.c.AnonymousClass4(cVar, i));
        }
        if (!android.text.TextUtils.isEmpty(cVar.S())) {
            this.w = new com.anythink.expressad.splash.c.c.AnonymousClass8(cVar);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.d, cVar.A())) {
                this.j.setVideoReady(true);
                b(cVar, i);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (android.text.TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i);
    }

    private void a(com.anythink.expressad.foundation.d.d dVar, int i) {
        java.util.ArrayList arrayList;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new java.util.ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.d);
            this.y = dVar.c();
            if (cVar.O() != 99 && (!android.text.TextUtils.isEmpty(cVar.c()) || !android.text.TextUtils.isEmpty(cVar.d()))) {
                if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                    cVar.i(com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() == 1 || !com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba())) {
                    arrayList.add(cVar);
                } else if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            a("invalid  campaign");
            return;
        }
        g();
        arrayList.size();
        com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
        if (!android.text.TextUtils.isEmpty(cVar2.c()) || (!android.text.TextUtils.isEmpty(cVar2.d()) && cVar2.d().contains("<MBTPLMARK>"))) {
            cVar2.a(true);
            cVar2.b(false);
        } else {
            cVar2.a(false);
            cVar2.b(true);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.j;
        if (aTSplashView != null) {
            aTSplashView.setDynamicView(false);
        }
        if (cVar2.j()) {
            d(cVar2, i);
        }
        if (com.anythink.expressad.splash.c.b.a(this.j, cVar2)) {
            b(cVar2, i);
            return;
        }
        this.j.clearResState();
        if (!android.text.TextUtils.isEmpty(cVar2.c()) && !cVar2.j()) {
            this.x = new com.anythink.expressad.splash.c.c.AnonymousClass5(cVar2, i);
            com.anythink.expressad.videocommon.b.i.a().b(cVar2.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (cVar2.j()) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cVar2.d())) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.splash.c.c.AnonymousClass4(cVar2, i));
        }
        if (!android.text.TextUtils.isEmpty(cVar2.S())) {
            this.w = new com.anythink.expressad.splash.c.c.AnonymousClass8(cVar2);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(cVar2);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList2, com.anythink.expressad.foundation.g.a.aV, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.d, cVar2.A())) {
                this.j.setVideoReady(true);
                b(cVar2, i);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (android.text.TextUtils.isEmpty(cVar2.be())) {
            return;
        }
        d(cVar2, i);
    }

    public static /* synthetic */ void a(com.anythink.expressad.splash.c.c cVar, java.lang.String str, com.anythink.expressad.foundation.d.c cVar2, int i) {
        com.anythink.expressad.splash.c.e.c cVar3 = new com.anythink.expressad.splash.c.e.c();
        cVar3.c(cVar.d);
        cVar3.b(cVar.e);
        cVar3.a(cVar2);
        cVar3.a(str);
        cVar3.b(cVar.o);
        cVar3.a(cVar.p);
        cVar3.a(cVar.a);
        com.anythink.expressad.splash.c.e.a.a.a(cVar.j, cVar3, cVar.new AnonymousClass7(cVar2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        if (this.u) {
            this.u = false;
        } else {
            b(str);
        }
    }

    private void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.splash.c.e.c cVar2 = new com.anythink.expressad.splash.c.e.c();
        cVar2.c(this.d);
        cVar2.b(this.e);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(this.o);
        cVar2.a(this.p);
        cVar2.a(this.a);
        com.anythink.expressad.splash.c.e.a.a.a(this.j, cVar2, new com.anythink.expressad.splash.c.c.AnonymousClass7(cVar, i));
    }

    private java.util.List<com.anythink.expressad.foundation.d.c> b(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null || dVar.J == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
        cVar.l(this.d);
        this.y = dVar.c();
        if (cVar.O() == 99) {
            return arrayList;
        }
        if (android.text.TextUtils.isEmpty(cVar.c()) && android.text.TextUtils.isEmpty(cVar.d())) {
            return arrayList;
        }
        if (com.anythink.expressad.foundation.h.t.a(cVar)) {
            cVar.i(com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba()) ? 1 : 2);
        }
        if (cVar.ae() == 1 || !com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba())) {
            arrayList.add(cVar);
            return arrayList;
        }
        if (!com.anythink.expressad.foundation.h.t.a(cVar)) {
            return arrayList;
        }
        arrayList.add(cVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (!com.anythink.expressad.splash.c.b.a(this.j, cVar) || this.v) {
            return;
        }
        l();
        this.b = cVar;
        this.v = true;
        com.anythink.expressad.splash.b.c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(cVar, i);
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.splash.c.c cVar, com.anythink.expressad.foundation.d.c cVar2, int i) {
        if (cVar2.j()) {
            com.anythink.expressad.splash.a.b.a aVar = new com.anythink.expressad.splash.a.b.a();
            aVar.b(cVar.d).a(cVar.e).a(cVar.o).a(cVar2).a(cVar.p).h(cVar.B);
            try {
                if (!android.text.TextUtils.isEmpty(cVar2.c())) {
                    android.net.Uri parse = android.net.Uri.parse(cVar2.c());
                    java.lang.String queryParameter = parse.getQueryParameter("hdbtn");
                    java.lang.String queryParameter2 = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.L);
                    java.lang.String queryParameter3 = parse.getQueryParameter("hdinfo");
                    java.lang.String queryParameter4 = parse.getQueryParameter("shake_show");
                    java.lang.String queryParameter5 = parse.getQueryParameter("shake_strength");
                    java.lang.String queryParameter6 = parse.getQueryParameter("shake_time");
                    java.lang.String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!android.text.TextUtils.isEmpty(queryParameter)) {
                        aVar.b(java.lang.Integer.parseInt(queryParameter));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(java.lang.Integer.parseInt(queryParameter2));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(java.lang.Integer.parseInt(queryParameter3));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(java.lang.Integer.parseInt(queryParameter4));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(java.lang.Integer.parseInt(queryParameter5));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(java.lang.Integer.parseInt(queryParameter6));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(java.lang.Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            com.anythink.expressad.splash.c.a unused = com.anythink.expressad.splash.c.a.C0222a.a;
            com.anythink.expressad.splash.c.a.a(cVar.j, new com.anythink.expressad.splash.a.b(aVar), cVar.new AnonymousClass6(cVar2, i));
        }
    }

    private void b(java.lang.String str) {
        if (this.v) {
            return;
        }
        l();
        this.v = true;
        com.anythink.expressad.splash.b.c cVar = this.h;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar, int i) {
        this.j.clearResState();
        if (!android.text.TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.x = new com.anythink.expressad.splash.c.c.AnonymousClass5(cVar, i);
            com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (cVar.j()) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.splash.c.c.AnonymousClass4(cVar, i));
        }
        if (!android.text.TextUtils.isEmpty(cVar.S())) {
            this.w = new com.anythink.expressad.splash.c.c.AnonymousClass8(cVar);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.d, cVar.A())) {
                this.j.setVideoReady(true);
                b(cVar, i);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (android.text.TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i);
    }

    public static /* synthetic */ void c(com.anythink.expressad.splash.c.c cVar, com.anythink.expressad.foundation.d.c cVar2, int i) {
        if (cVar.j.isH5Ready()) {
            return;
        }
        cVar.j.setH5Ready(true);
        cVar.b(cVar2, i);
    }

    private void c(java.lang.String str) {
        a(str);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.expressad.splash.c.b.a(this.j, cVar, new com.anythink.expressad.splash.c.c.AnonymousClass3(cVar, i));
    }

    private void e(com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.splash.c.c.AnonymousClass4(cVar, i));
    }

    private boolean e() {
        return this.o;
    }

    private int f() {
        return this.p;
    }

    private void f(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar.j()) {
            return;
        }
        this.x = new com.anythink.expressad.splash.c.c.AnonymousClass5(cVar, i);
        com.anythink.expressad.videocommon.b.i.a().b(cVar.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
    }

    private void g() {
        try {
            int i = this.z + 1;
            this.z = i;
            com.anythink.expressad.d.c cVar = this.k;
            if (cVar == null || i > cVar.t()) {
                this.z = 0;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void g(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar.j()) {
            com.anythink.expressad.splash.a.b.a aVar = new com.anythink.expressad.splash.a.b.a();
            aVar.b(this.d).a(this.e).a(this.o).a(cVar).a(this.p).h(this.B);
            try {
                if (!android.text.TextUtils.isEmpty(cVar.c())) {
                    android.net.Uri parse = android.net.Uri.parse(cVar.c());
                    java.lang.String queryParameter = parse.getQueryParameter("hdbtn");
                    java.lang.String queryParameter2 = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.L);
                    java.lang.String queryParameter3 = parse.getQueryParameter("hdinfo");
                    java.lang.String queryParameter4 = parse.getQueryParameter("shake_show");
                    java.lang.String queryParameter5 = parse.getQueryParameter("shake_strength");
                    java.lang.String queryParameter6 = parse.getQueryParameter("shake_time");
                    java.lang.String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!android.text.TextUtils.isEmpty(queryParameter)) {
                        aVar.b(java.lang.Integer.parseInt(queryParameter));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(java.lang.Integer.parseInt(queryParameter2));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(java.lang.Integer.parseInt(queryParameter3));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(java.lang.Integer.parseInt(queryParameter4));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(java.lang.Integer.parseInt(queryParameter5));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(java.lang.Integer.parseInt(queryParameter6));
                    }
                    if (!android.text.TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(java.lang.Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            com.anythink.expressad.splash.c.a unused = com.anythink.expressad.splash.c.a.C0222a.a;
            com.anythink.expressad.splash.c.a.a(this.j, new com.anythink.expressad.splash.a.b(aVar), new com.anythink.expressad.splash.c.c.AnonymousClass6(cVar, i));
        }
    }

    private static void h() {
    }

    private void h(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (this.j.isH5Ready()) {
            return;
        }
        this.j.setH5Ready(true);
        b(cVar, i);
    }

    private static void i() {
    }

    private void i(com.anythink.expressad.foundation.d.c cVar, int i) {
        this.w = new com.anythink.expressad.splash.c.c.AnonymousClass8(cVar);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar);
        com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.w);
        if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.d, cVar.A())) {
            com.anythink.expressad.videocommon.b.e.a().d(this.d);
        } else {
            this.j.setVideoReady(true);
            b(cVar, i);
        }
    }

    private void j() {
        this.z = 0;
    }

    private static void k() {
    }

    private void l() {
        this.C.removeCallbacks(this.D);
    }

    public final java.lang.String a() {
        return this.A;
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.q = i2;
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.k = cVar;
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList arrayList;
        this.v = false;
        this.f258s = "";
        this.t = 2;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new java.util.ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.d);
            this.y = dVar.c();
            if (cVar.O() != 99 && (!android.text.TextUtils.isEmpty(cVar.c()) || !android.text.TextUtils.isEmpty(cVar.d()))) {
                if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                    cVar.i(com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() == 1 || !com.anythink.expressad.foundation.h.t.a(this.i, cVar.ba())) {
                    arrayList.add(cVar);
                } else if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            a("invalid  campaign");
            return;
        }
        g();
        arrayList.size();
        com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
        if (!android.text.TextUtils.isEmpty(cVar2.c()) || (!android.text.TextUtils.isEmpty(cVar2.d()) && cVar2.d().contains("<MBTPLMARK>"))) {
            cVar2.a(true);
            cVar2.b(false);
        } else {
            cVar2.a(false);
            cVar2.b(true);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.j;
        if (aTSplashView != null) {
            aTSplashView.setDynamicView(false);
        }
        if (cVar2.j()) {
            d(cVar2, 2);
        }
        if (com.anythink.expressad.splash.c.b.a(this.j, cVar2)) {
            b(cVar2, 2);
            return;
        }
        this.j.clearResState();
        if (!android.text.TextUtils.isEmpty(cVar2.c()) && !cVar2.j()) {
            this.x = new com.anythink.expressad.splash.c.c.AnonymousClass5(cVar2, 2);
            com.anythink.expressad.videocommon.b.i.a().b(cVar2.c(), (com.anythink.expressad.videocommon.b.i.a) this.x);
        }
        if (cVar2.j()) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cVar2.d())) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.splash.c.c.AnonymousClass4(cVar2, 2));
        }
        if (!android.text.TextUtils.isEmpty(cVar2.S())) {
            this.w = new com.anythink.expressad.splash.c.c.AnonymousClass8(cVar2);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            arrayList2.add(cVar2);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList2, com.anythink.expressad.foundation.g.a.aV, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.d, cVar2.A())) {
                this.j.setVideoReady(true);
                b(cVar2, 2);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (android.text.TextUtils.isEmpty(cVar2.be())) {
            return;
        }
        d(cVar2, 2);
    }

    public final void a(com.anythink.expressad.splash.b.c cVar) {
        this.h = cVar;
    }

    public final void a(com.anythink.expressad.splash.view.ATSplashView aTSplashView) {
        this.j = aTSplashView;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void b() {
        if (this.h != null) {
            this.h = null;
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.x != null) {
            this.x = null;
        }
    }

    public final void b(int i) {
        this.p = i;
    }

    public final void b(boolean z) {
        this.o = z;
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.b;
    }
}
