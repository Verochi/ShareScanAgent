package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public class i {
    public static final java.lang.String a = "ending_page_source";
    public static final java.lang.String b = "ending_page_save_time";
    private static final java.lang.String c = "H5DownLoadManager";
    private static volatile com.anythink.expressad.videocommon.b.i f;
    private java.util.concurrent.CopyOnWriteArrayList<java.lang.String> d;
    private java.util.concurrent.ConcurrentMap<java.lang.String, com.anythink.expressad.videocommon.b.d> e;
    private com.anythink.expressad.videocommon.b.m g;
    private com.anythink.expressad.videocommon.b.j h;
    private boolean i = false;

    /* renamed from: com.anythink.expressad.videocommon.b.i$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.foundation.g.g.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.expressad.videocommon.b.i.a e;

        /* renamed from: com.anythink.expressad.videocommon.b.i$1$1, reason: invalid class name and collision with other inner class name */
        public class C02321 implements com.anythink.expressad.videocommon.b.i.c {
            public C02321() {
            }

            @Override // com.anythink.expressad.videocommon.b.i.c
            public final void a() {
            }

            @Override // com.anythink.expressad.videocommon.b.i.c
            public final void a(java.lang.String str) {
                try {
                    com.anythink.expressad.videocommon.b.i.this.d.remove(com.anythink.expressad.videocommon.b.i.AnonymousClass1.this.a);
                    com.anythink.expressad.videocommon.b.i.AnonymousClass1 anonymousClass1 = com.anythink.expressad.videocommon.b.i.AnonymousClass1.this;
                    com.anythink.expressad.videocommon.b.i.a aVar = anonymousClass1.e;
                    if (aVar != null) {
                        aVar.a(anonymousClass1.a, str);
                    }
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                    com.anythink.expressad.videocommon.b.i.AnonymousClass1 anonymousClass12 = com.anythink.expressad.videocommon.b.i.AnonymousClass1.this;
                    com.anythink.expressad.videocommon.b.i.a aVar2 = anonymousClass12.e;
                    if (aVar2 != null) {
                        aVar2.a(anonymousClass12.a, str);
                    }
                }
            }

            @Override // com.anythink.expressad.videocommon.b.i.c
            public final void a(byte[] bArr, java.lang.String str) {
                try {
                    com.anythink.expressad.videocommon.b.i.this.d.remove(str);
                    if (bArr == null || bArr.length <= 0) {
                        return;
                    }
                    if (com.anythink.expressad.videocommon.b.i.this.h.a(str, bArr)) {
                        com.anythink.expressad.videocommon.b.i.a aVar = com.anythink.expressad.videocommon.b.i.AnonymousClass1.this.e;
                        if (aVar != null) {
                            aVar.a(str);
                            return;
                        }
                        return;
                    }
                    com.anythink.expressad.videocommon.b.i.a aVar2 = com.anythink.expressad.videocommon.b.i.AnonymousClass1.this.e;
                    if (aVar2 != null) {
                        aVar2.a(str, "save file failed");
                    }
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                    com.anythink.expressad.videocommon.b.i.a aVar3 = com.anythink.expressad.videocommon.b.i.AnonymousClass1.this.e;
                    if (aVar3 != null) {
                        aVar3.a(str, e.getMessage());
                    }
                }
            }
        }

        public AnonymousClass1(java.lang.String str, com.anythink.expressad.videocommon.b.i.a aVar) {
            this.a = str;
            this.e = aVar;
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            if (android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.this.h.b(this.a))) {
                com.anythink.expressad.videocommon.b.g.a(this.a, new com.anythink.expressad.videocommon.b.i.AnonymousClass1.C02321());
                return;
            }
            com.anythink.expressad.videocommon.b.i.this.d.remove(this.a);
            com.anythink.expressad.videocommon.b.i.a aVar = this.e;
            if (aVar != null) {
                aVar.a(this.a);
            }
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    public interface a {
        void a(java.lang.String str);

        void a(java.lang.String str, java.lang.String str2);
    }

    public interface b extends com.anythink.expressad.videocommon.b.i.a {
    }

    public interface c {
        void a();

        void a(java.lang.String str);

        void a(byte[] bArr, java.lang.String str);
    }

    public interface d extends com.anythink.expressad.videocommon.b.i.a {
    }

    private i() {
        try {
            this.g = com.anythink.expressad.videocommon.b.m.a();
            this.h = com.anythink.expressad.videocommon.b.j.a.a;
            this.d = new java.util.concurrent.CopyOnWriteArrayList<>();
            this.e = new java.util.concurrent.ConcurrentHashMap();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static com.anythink.expressad.videocommon.b.i a() {
        if (f == null) {
            synchronized (com.anythink.expressad.videocommon.b.i.class) {
                if (f == null) {
                    f = new com.anythink.expressad.videocommon.b.i();
                }
            }
        }
        return f;
    }

    private void a(java.lang.String str, com.anythink.expressad.videocommon.b.i.d dVar) {
        try {
            if (!android.text.TextUtils.isEmpty(this.g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else if (!this.e.containsKey(str)) {
                com.anythink.expressad.videocommon.b.d dVar2 = new com.anythink.expressad.videocommon.b.d(this.e, this.g, dVar, str);
                this.e.put(str, dVar2);
                com.anythink.expressad.videocommon.b.g.a(str, dVar2);
            } else {
                com.anythink.expressad.videocommon.b.d dVar3 = this.e.get(str);
                if (dVar3 != null) {
                    dVar3.a(dVar);
                }
            }
        } catch (java.lang.Exception e) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        try {
            com.anythink.expressad.foundation.h.v.a(com.anythink.expressad.foundation.b.a.b().d(), a.concat(java.lang.String.valueOf(str2)), str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void b(java.lang.String str, com.anythink.expressad.videocommon.b.i.d dVar) {
        try {
            if (!android.text.TextUtils.isEmpty(this.g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else if (!this.e.containsKey(str)) {
                com.anythink.expressad.videocommon.b.d dVar2 = new com.anythink.expressad.videocommon.b.d(this.e, this.g, dVar, str);
                this.e.put(str, dVar2);
                com.anythink.expressad.videocommon.b.g.a(str, dVar2);
            } else {
                com.anythink.expressad.videocommon.b.d dVar3 = this.e.get(str);
                if (dVar3 != null) {
                    dVar3.a(dVar);
                }
            }
        } catch (java.lang.Exception e) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }

    private void c(java.lang.String str, com.anythink.expressad.videocommon.b.i.a aVar) {
        try {
            if (this.d.contains(str)) {
                return;
            }
            this.d.add(str);
            com.anythink.expressad.videocommon.b.h.a.a.a(new com.anythink.expressad.videocommon.b.i.AnonymousClass1(str, aVar));
        } catch (java.lang.Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }

    private java.lang.String d(java.lang.String str) {
        com.anythink.expressad.videocommon.b.j jVar = this.h;
        return jVar != null ? jVar.a(str) : str;
    }

    private static java.lang.String e(java.lang.String str) {
        try {
            java.lang.Object b2 = com.anythink.expressad.foundation.h.v.b(com.anythink.expressad.foundation.b.a.b().d(), a.concat(java.lang.String.valueOf(str)), "");
            if (b2 == null || !(b2 instanceof java.lang.String)) {
                return null;
            }
            java.lang.String str2 = (java.lang.String) b2;
            if (com.anythink.expressad.foundation.h.w.b(str2)) {
                return str2;
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static long f(java.lang.String str) {
        try {
            java.lang.Object b2 = com.anythink.expressad.foundation.h.v.b(com.anythink.expressad.foundation.b.a.b().d(), b.concat(java.lang.String.valueOf(str)), 0L);
            if (b2 != null && (b2 instanceof java.lang.Long)) {
                return ((java.lang.Long) b2).longValue();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    private static void g(java.lang.String str) {
        try {
            com.anythink.expressad.foundation.h.v.a(com.anythink.expressad.foundation.b.a.b().d(), b.concat(java.lang.String.valueOf(str)), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void h(java.lang.String str) {
        b(str, (com.anythink.expressad.videocommon.b.i.a) null);
    }

    public final java.lang.String a(java.lang.String str) {
        com.anythink.expressad.videocommon.b.m mVar = this.g;
        if (mVar != null) {
            return mVar.a(str);
        }
        return null;
    }

    public final void a(java.lang.String str, com.anythink.expressad.videocommon.b.i.a aVar) {
        c(str, aVar);
    }

    public final void b(java.lang.String str) {
        c(str, null);
    }

    public final void b(java.lang.String str, com.anythink.expressad.videocommon.b.i.a aVar) {
        try {
            if (android.util.Patterns.WEB_URL.matcher(str).matches() || android.webkit.URLUtil.isValidUrl(str)) {
                java.lang.String path = android.net.Uri.parse(str).getPath();
                if (!android.text.TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        a(str, (com.anythink.expressad.videocommon.b.i.d) aVar);
                        return;
                    } else {
                        c(str, aVar);
                        return;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (aVar != null) {
            aVar.a(str, "The URL does not contain a path ");
        }
    }

    public final java.lang.String c(java.lang.String str) {
        try {
            if (android.util.Patterns.WEB_URL.matcher(str).matches() || android.webkit.URLUtil.isValidUrl(str)) {
                android.net.Uri parse = android.net.Uri.parse(str);
                java.lang.String path = parse.getPath();
                if (android.text.TextUtils.isEmpty(path) || !android.text.TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return a(str);
                }
                com.anythink.expressad.videocommon.b.j jVar = this.h;
                return jVar != null ? jVar.a(str) : str;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
