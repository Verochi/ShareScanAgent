package com.tramini.plugin.a.b;

/* loaded from: classes19.dex */
public class c {
    private static com.tramini.plugin.a.b.c b;
    private android.content.Context c;
    private android.content.BroadcastReceiver e;
    private android.content.BroadcastReceiver f;
    private java.lang.String[] g;
    boolean a = false;
    private android.os.Handler d = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.tramini.plugin.a.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tramini.plugin.a.c.c a = com.tramini.plugin.a.c.c.a(this.a);
            try {
                a.b().execSQL("DROP TABLE IF EXISTS 'il'");
                a.b().execSQL("DROP TABLE IF EXISTS 'il_all'");
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.tramini.plugin.a.b.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.tramini.plugin.b.b a;

        public AnonymousClass2(com.tramini.plugin.b.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tramini.plugin.a.h.b.a().a(this.a);
        }
    }

    /* renamed from: com.tramini.plugin.a.b.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        /* renamed from: com.tramini.plugin.a.b.c$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.tramini.plugin.a.e.c {
            public AnonymousClass1() {
            }

            @Override // com.tramini.plugin.a.e.c
            public final void a(com.tramini.plugin.b.b bVar) {
                com.tramini.plugin.a.b.c.this.b(bVar);
            }
        }

        public AnonymousClass3(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.tramini.plugin.b.c.a(this.a).a()) {
                com.tramini.plugin.b.c.a(this.a).a(new com.tramini.plugin.a.b.c.AnonymousClass3.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.tramini.plugin.a.b.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.tramini.plugin.b.b a;

        public AnonymousClass4(com.tramini.plugin.b.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int size;
            try {
                if (com.tramini.plugin.a.b.c.this.c == null) {
                    return;
                }
                try {
                    if (com.tramini.plugin.a.b.c.this.e != null) {
                        com.tramini.plugin.a.b.b.a(com.tramini.plugin.a.b.c.this.c).a(com.tramini.plugin.a.b.c.this.e);
                        com.tramini.plugin.a.b.c.this.e = null;
                    }
                } catch (java.lang.Throwable unused) {
                }
                com.tramini.plugin.a.b.c.this.e = new com.tramini.plugin.a.b();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                com.tramini.plugin.b.b bVar = this.a;
                java.util.List<java.lang.String> e = bVar != null ? bVar.e() : null;
                if (e != null && (size = e.size()) > 0) {
                    for (int i = 0; i < size; i++) {
                        intentFilter.addAction(e.get(i));
                    }
                }
                com.tramini.plugin.a.b.b.a(com.tramini.plugin.a.b.c.this.c).a(com.tramini.plugin.a.b.c.this.e, intentFilter);
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    /* renamed from: com.tramini.plugin.a.b.c$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.this.c, "tramini", com.tramini.plugin.a.b.a.d.c, "");
            com.tramini.plugin.a.h.c.c(this.a);
            com.tramini.plugin.a.b.c cVar = com.tramini.plugin.a.b.c.this;
            com.tramini.plugin.a.b.c.a(cVar, cVar.c);
        }
    }

    /* renamed from: com.tramini.plugin.a.b.c$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass6(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tramini.plugin.a.h.d.a = new org.json.JSONObject(this.a);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static com.tramini.plugin.a.b.c a() {
        if (b == null) {
            synchronized (com.tramini.plugin.a.b.c.class) {
                b = new com.tramini.plugin.a.b.c();
            }
        }
        return b;
    }

    public static /* synthetic */ void a(com.tramini.plugin.a.b.c cVar, android.content.Context context) {
        cVar.b(com.tramini.plugin.b.c.a(context).b());
        cVar.b(context);
    }

    public static void a(java.lang.Runnable runnable) {
        com.tramini.plugin.a.h.b.a.a().a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tramini.plugin.b.b bVar) {
        b(new com.tramini.plugin.a.b.c.AnonymousClass4(bVar));
    }

    private void b(java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            runnable.run();
        } else {
            this.d.post(runnable);
        }
    }

    private static void b(java.lang.Runnable runnable, long j) {
        com.tramini.plugin.a.h.b.a.a().a(runnable, j);
    }

    private static void c() {
    }

    private void c(android.content.Context context) {
        this.c = context;
    }

    private void c(java.lang.Runnable runnable) {
        this.d.removeCallbacks(runnable);
    }

    private void d(android.content.Context context) {
        b(com.tramini.plugin.b.c.a(context).b());
        b(context);
    }

    public final void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            this.c = context.getApplicationContext();
            com.tramini.plugin.a.h.b.a.a().a(new com.tramini.plugin.a.b.c.AnonymousClass1(context));
            if (com.tramini.plugin.a.h.h.a(context)) {
                return;
            }
            try {
                if (this.f != null) {
                    com.tramini.plugin.a.b.b.a(this.c).a(this.f);
                    this.f = null;
                }
            } catch (java.lang.Throwable unused) {
            }
            this.f = new com.tramini.plugin.a.c();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            java.lang.String packageName = this.c.getPackageName();
            intentFilter.addAction(com.tramini.plugin.a.h.f.a(packageName + packageName));
            com.tramini.plugin.a.b.b.a(this.c).a(this.f, intentFilter);
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final synchronized void a(com.tramini.plugin.b.b bVar) {
        if (this.a) {
            return;
        }
        if (bVar != null) {
            this.a = true;
            com.tramini.plugin.a.h.b.a().a(bVar);
            a().a(new com.tramini.plugin.a.b.c.AnonymousClass2(bVar), com.igexin.push.config.c.l);
        }
    }

    public final void a(java.lang.Runnable runnable, long j) {
        this.d.postDelayed(runnable, j);
    }

    public final void a(java.lang.String[] strArr) {
        this.g = strArr;
    }

    public final boolean a(java.lang.String str) {
        java.lang.String[] strArr = this.g;
        if (strArr == null) {
            return false;
        }
        for (java.lang.String str2 : strArr) {
            if (android.text.TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public final android.content.Context b() {
        return this.c;
    }

    public final void b(android.content.Context context) {
        com.tramini.plugin.a.h.b.a.a().a(new com.tramini.plugin.a.b.c.AnonymousClass3(context));
    }

    public final void b(java.lang.String str) {
        com.tramini.plugin.a.h.b.a.a().a(new com.tramini.plugin.a.b.c.AnonymousClass5(str));
    }

    public final void c(java.lang.String str) {
        com.tramini.plugin.a.h.b.a.a().a(new com.tramini.plugin.a.b.c.AnonymousClass6(str));
    }
}
