package com.igexin.push.g;

import com.igexin.push.core.e.f.AnonymousClass25;

/* loaded from: classes23.dex */
public class f implements com.igexin.push.g.b.c {
    private static volatile com.igexin.push.g.f a = null;
    private static java.lang.String b = "Type10Task";
    private java.text.SimpleDateFormat c = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA);

    /* renamed from: com.igexin.push.g.f$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.g.b.f {
        final /* synthetic */ long a;
        final /* synthetic */ java.lang.String b;

        /* renamed from: com.igexin.push.g.f$1$1, reason: invalid class name and collision with other inner class name */
        public class C03731 extends com.igexin.push.core.h.d {
            final /* synthetic */ java.util.ArrayList c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03731(java.lang.String str, byte[] bArr, java.util.ArrayList arrayList) {
                super(str, bArr, 10);
                this.c = arrayList;
            }

            @Override // com.igexin.push.core.h.d, com.igexin.push.g.a.d
            public final void a(byte[] bArr) throws java.lang.Exception {
                super.a(bArr);
                com.igexin.push.core.c.a.a();
                java.util.ArrayList arrayList = this.c;
                com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{"id"}, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, java.lang.String str) {
            super(j, (byte) 0);
            this.a = j2;
            this.b = str;
        }

        @Override // com.igexin.c.a.d.a.e
        public final int c() {
            return 0;
        }

        @Override // com.igexin.push.g.b.f
        public final void h() {
            try {
                synchronized (com.igexin.push.g.f.class) {
                    if (this.a - com.igexin.push.core.e.ax <= 60000) {
                        com.igexin.c.a.c.a.b(com.igexin.push.g.f.b, "upload type10 in 1m");
                        return;
                    }
                    com.igexin.push.core.e.ax = this.a;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass25(), false, true);
                    com.igexin.push.core.c.a.a();
                    java.lang.String a = com.igexin.push.g.f.a(this.b);
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("type", (java.lang.Integer) 10);
                    contentValues.put("data", a);
                    contentValues.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, contentValues);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    com.igexin.push.core.c.a.a();
                    java.util.List<com.igexin.push.core.b.c> c = com.igexin.push.core.c.a.c();
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (com.igexin.push.core.b.c cVar : c) {
                        arrayList.add(java.lang.String.valueOf(cVar.a));
                        sb.append(cVar.b);
                        sb.append("\n");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    com.igexin.c.a.c.a.b(com.igexin.push.g.f.b, "upload type10 data = ".concat(java.lang.String.valueOf(sb)));
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.g.a.a(new com.igexin.push.g.f.AnonymousClass1.C03731(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes(), arrayList)), false, true);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    public static com.igexin.push.g.f a() {
        if (a == null) {
            synchronized (com.igexin.push.g.f.class) {
                if (a == null) {
                    a = new com.igexin.push.g.f();
                }
            }
        }
        return a;
    }

    public static /* synthetic */ java.lang.String a(java.lang.String str) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + com.igexin.push.core.ServiceManager.getInstance().initType.first;
    }

    private static java.lang.String b(java.lang.String str) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + com.igexin.push.core.ServiceManager.getInstance().initType.first;
    }

    private void f() {
        if (com.igexin.push.core.e.ax == 0) {
            return;
        }
        try {
            java.lang.String format = this.c.format(new java.util.Date(com.igexin.push.core.e.ax));
            java.lang.String format2 = this.c.format(new java.util.Date());
            java.util.Date parse = this.c.parse(format);
            java.util.Date parse2 = this.c.parse(format2);
            com.igexin.c.a.c.a.b(b, " lastDateString = " + format + " ; nowDateString = " + format2);
            if (parse2.after(parse)) {
                d();
            }
        } catch (java.text.ParseException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.g.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.g.b.c
    public final void b() {
        if (com.igexin.push.core.e.ax != 0) {
            try {
                java.lang.String format = this.c.format(new java.util.Date(com.igexin.push.core.e.ax));
                java.lang.String format2 = this.c.format(new java.util.Date());
                java.util.Date parse = this.c.parse(format);
                java.util.Date parse2 = this.c.parse(format2);
                com.igexin.c.a.c.a.b(b, " lastDateString = " + format + " ; nowDateString = " + format2);
                if (parse2.after(parse)) {
                    d();
                }
            } catch (java.text.ParseException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.push.g.b.c
    public final boolean c() {
        return com.igexin.push.config.d.q;
    }

    public final void d() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis));
        if (!com.igexin.push.config.d.q) {
            com.igexin.c.a.c.a.b(b, "upload type10 enable false");
            return;
        }
        int i = android.text.TextUtils.isEmpty(com.igexin.push.core.e.A) ? com.igexin.push.config.d.ag * 1000 : 0;
        com.igexin.c.a.c.a.b(b, "upload type10 delay time = ".concat(java.lang.String.valueOf(i)));
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.core.d.a((com.igexin.push.g.b.f) new com.igexin.push.g.f.AnonymousClass1(i, currentTimeMillis, format));
    }
}
