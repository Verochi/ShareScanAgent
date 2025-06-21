package com.anythink.expressad.mbbanner.a.d;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String a = "b";
    private android.content.Context b;
    private com.anythink.expressad.mbbanner.a.b.e d;
    private com.anythink.expressad.mbbanner.a.e.a e;
    private com.anythink.expressad.mbbanner.a.c.b f;
    private com.anythink.expressad.mbbanner.a.c.d g;
    private int c = 0;
    private volatile boolean h = false;
    private java.util.Timer i = new java.util.Timer();
    private volatile java.util.List<java.lang.String> j = new java.util.ArrayList();
    private volatile boolean k = false;
    private volatile boolean l = false;
    private volatile boolean m = false;

    /* renamed from: com.anythink.expressad.mbbanner.a.d.b$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.mbbanner.a.d.b.this.h) {
                return;
            }
            com.anythink.expressad.mbbanner.a.d.b.b(com.anythink.expressad.mbbanner.a.d.b.this);
            com.anythink.expressad.mbbanner.a.d.b.this.a(this.a, -1, "", false);
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.d a;

        public AnonymousClass2(com.anythink.expressad.foundation.d.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
            java.lang.String unused = com.anythink.expressad.mbbanner.a.d.b.a;
            com.anythink.expressad.foundation.d.d dVar = this.a;
            if (dVar != null && (arrayList = dVar.J) != null && arrayList.size() > 0) {
                android.content.Context unused2 = com.anythink.expressad.mbbanner.a.d.b.this.b;
                com.anythink.expressad.mbbanner.a.e.b.a();
            }
            java.lang.String unused3 = com.anythink.expressad.mbbanner.a.d.b.a;
        }
    }

    public b(android.content.Context context, com.anythink.expressad.mbbanner.a.b.e eVar, com.anythink.expressad.mbbanner.a.c.b bVar, com.anythink.expressad.mbbanner.a.e.a aVar) {
        this.b = context.getApplicationContext();
        this.d = eVar;
        this.f = bVar;
        this.e = aVar;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.io.File file;
        java.io.File file2;
        java.io.FileOutputStream fileOutputStream;
        java.lang.String str3 = "";
        if (!android.text.TextUtils.isEmpty(str2)) {
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    java.lang.String b = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                    java.lang.String a2 = com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str2));
                    if (android.text.TextUtils.isEmpty(a2)) {
                        a2 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                    }
                    file2 = new java.io.File(b, a2.concat(".html"));
                    android.net.Uri.parse(str2).getPath();
                    fileOutputStream = new java.io.FileOutputStream(file2);
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                java.lang.String absolutePath = file2.getAbsolutePath();
                try {
                    fileOutputStream.close();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                str3 = absolutePath;
            } catch (java.lang.Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                }
                file = new java.io.File(str3);
                if (!file.exists()) {
                }
                a(str, 2, str2, false);
                return str3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            file = new java.io.File(str3);
            if (!file.exists() && file.isFile() && file.canRead()) {
                a(str, 2, str2, true);
            } else {
                a(str, 2, str2, false);
            }
        }
        return str3;
    }

    private java.util.List<com.anythink.expressad.foundation.d.c> a(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (dVar != null) {
            try {
                java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = dVar.J;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList3 = dVar.J;
                    arrayList3.size();
                    for (int i = 0; i < arrayList3.size(); i++) {
                        com.anythink.expressad.foundation.d.c cVar = arrayList3.get(i);
                        if (cVar != null && cVar.O() != 99 && (!android.text.TextUtils.isEmpty(cVar.p()) || !android.text.TextUtils.isEmpty(cVar.q()) || !android.text.TextUtils.isEmpty(cVar.be()))) {
                            if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                                cVar.i(com.anythink.expressad.foundation.h.t.a(this.b, cVar.ba()) ? 1 : 2);
                            }
                            if (cVar.ae() != 1 && com.anythink.expressad.foundation.h.t.a(this.b, cVar.ba())) {
                                if (com.anythink.expressad.foundation.h.t.a(cVar)) {
                                    arrayList.add(cVar);
                                }
                            }
                            arrayList.add(cVar);
                        }
                    }
                    arrayList.size();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    private void a(java.lang.String str) {
        if (this.m) {
            return;
        }
        if ((this.k || this.l) && this.j.size() == 0) {
            this.h = true;
            this.m = true;
            this.i.cancel();
            this.e.a(this.f, str);
            this.g.a(str);
        }
    }

    private void a(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!android.text.TextUtils.isEmpty(cVar.be())) {
                this.j.add(cVar.be());
                com.anythink.expressad.foundation.g.d.b.a(this.b).a(cVar.be(), new com.anythink.expressad.mbbanner.a.c.g(this, str));
            }
        }
    }

    private java.lang.String b() {
        return this.d.a();
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        new java.lang.Thread(new com.anythink.expressad.mbbanner.a.d.b.AnonymousClass2(dVar)).start();
    }

    private void b(java.lang.String str) {
        this.h = true;
        this.e.b(this.f, str);
        this.g.a(str);
    }

    private void b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.anythink.expressad.videocommon.b.i.a().a(str2, new com.anythink.expressad.mbbanner.a.c.f(this, str));
    }

    private void b(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        int i = this.c;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    i += list.size();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i > this.d.c()) {
            i = 0;
        }
        if (com.anythink.expressad.foundation.h.w.b(str)) {
            this.d.a(i);
        }
    }

    public static /* synthetic */ boolean b(com.anythink.expressad.mbbanner.a.d.b bVar) {
        bVar.h = true;
        return true;
    }

    private int c() {
        try {
            int b = this.d.b();
            if (b > this.d.c()) {
                return 0;
            }
            return b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void c(java.lang.String str) {
        this.i.schedule(new com.anythink.expressad.mbbanner.a.d.b.AnonymousClass1(str), 60000L);
    }

    private void d(java.lang.String str) {
        this.d.a(str);
    }

    public final void a(java.lang.String str, int i, java.lang.String str2, boolean z) {
        if (!z) {
            this.i.cancel();
            this.h = true;
            this.e.b(this.f, str);
            this.g.a(str);
            return;
        }
        if (i == 1) {
            synchronized (this) {
                this.j.remove(str2);
                if (this.j.size() == 0) {
                    a(str);
                }
            }
            return;
        }
        if (i == 2) {
            this.l = true;
            a(str);
        } else if (i == 3) {
            this.k = true;
            a(str);
        }
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.d.d dVar, com.anythink.expressad.mbbanner.a.c.d dVar2) {
        this.g = dVar2;
        if (dVar == null) {
            this.e.a(this.f, "campaignUnit is NULL!", str);
            this.g.a(str);
            return;
        }
        java.util.List<com.anythink.expressad.foundation.d.c> a2 = a(dVar);
        new java.lang.Thread(new com.anythink.expressad.mbbanner.a.d.b.AnonymousClass2(dVar)).start();
        if (a2.size() == 0) {
            this.e.a(this.f, com.anythink.expressad.reward.a.d.a, str);
            this.g.a(str);
            return;
        }
        this.i.schedule(new com.anythink.expressad.mbbanner.a.d.b.AnonymousClass1(str), 60000L);
        this.d.a(dVar.c());
        int i = this.c;
        int i2 = 0;
        try {
            if (a2.size() > 0) {
                i += a2.size();
            }
            if (i > this.d.c()) {
                i = 0;
            }
            if (com.anythink.expressad.foundation.h.w.b(str)) {
                this.d.a(i);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.anythink.expressad.foundation.d.c cVar = a2.get(0);
        java.lang.String trim = cVar.p().trim();
        if (android.text.TextUtils.isEmpty(trim)) {
            java.lang.String trim2 = cVar.q().trim();
            if (android.text.TextUtils.isEmpty(trim2)) {
                this.l = true;
                this.k = true;
            } else {
                java.lang.String a3 = a(str, trim2);
                if (a2.size() > 0) {
                    while (i2 < a2.size()) {
                        a2.get(i2).e(a3);
                        a2.get(i2).a(trim2.contains("<MBTPLMARK>"));
                        i2++;
                    }
                }
            }
        } else {
            if (!android.text.TextUtils.isEmpty(trim)) {
                com.anythink.expressad.videocommon.b.i.a().a(trim, new com.anythink.expressad.mbbanner.a.c.f(this, str));
            }
            if (a2.size() > 0) {
                while (i2 < a2.size()) {
                    a2.get(i2).d(cVar.p());
                    a2.get(i2).a(true);
                    i2++;
                }
            }
        }
        a(str, a2);
    }
}
