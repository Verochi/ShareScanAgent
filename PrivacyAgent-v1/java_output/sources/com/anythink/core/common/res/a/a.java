package com.anythink.core.common.res.a;

/* loaded from: classes12.dex */
public class a extends com.anythink.core.common.res.image.b {
    final java.lang.String a;
    public com.anythink.core.common.res.a.b b;
    public java.util.List<com.anythink.core.common.res.a.a.AbstractC0171a> j;
    public com.anythink.core.common.res.a.a.b k;
    int l;
    private final int m;
    private final int n;
    private int o;
    private int p;
    private long q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f185s;

    /* renamed from: com.anythink.core.common.res.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0171a {
        public abstract void a(java.lang.String str, java.lang.String str2);

        public abstract boolean a(int i, long j, long j2);
    }

    public static abstract class b {
        public abstract void a(long j, long j2, long j3, long j4, long j5);

        public abstract void a(java.lang.String str, java.lang.String str2, long j, long j2, long j3, long j4);
    }

    public a(java.lang.String str) {
        super(str);
        this.a = com.anythink.core.common.res.a.a.class.getSimpleName();
        this.m = 0;
        this.n = 1;
        this.l = -1;
        this.j = new java.util.ArrayList();
        this.b = new com.anythink.core.common.res.a.b();
        this.p = 0;
        this.q = 0L;
        this.f185s = false;
        this.o = 0;
    }

    private void a(int i) {
        this.o = i;
    }

    private synchronized void a(int i, long j) {
        if (this.l != i) {
            this.l = i;
        }
        java.util.Iterator<com.anythink.core.common.res.a.a.AbstractC0171a> it = this.j.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().a(i, j, this.i)) {
                z = i != 100;
                it.remove();
            }
        }
        com.anythink.core.common.a.k.a().a(this.c, this.r, this.i, j, i, z);
    }

    private void a(com.anythink.core.common.res.a.a.b bVar) {
        this.k = bVar;
    }

    private void b(int i, long j) {
        if (i == 100) {
            com.anythink.core.common.a.k.a().a(this.c, this.r, this.i, j, i, true);
            com.anythink.core.common.res.a.a.b bVar = this.k;
            if (bVar != null) {
                bVar.a(this.i, this.e, this.g, this.f, this.h);
            }
        }
    }

    private synchronized void b(java.lang.String str, java.lang.String str2) {
        this.o = 0;
        java.util.Iterator<com.anythink.core.common.res.a.a.AbstractC0171a> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
        j();
        com.anythink.core.common.res.a.a.b bVar = this.k;
        if (bVar != null) {
            bVar.a(str, str2, this.i, this.e, this.f, this.h);
        }
    }

    private synchronized boolean b(int i) {
        if (this.f185s) {
            return true;
        }
        com.anythink.core.common.res.a.b bVar = this.b;
        if (bVar.c == 2) {
            if (i >= bVar.a) {
                return false;
            }
        }
        return true;
    }

    private int g() {
        return this.o;
    }

    private void h() {
        java.lang.String a = com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(4);
        if (android.text.TextUtils.isEmpty(a)) {
            b("", "without saveDirectory");
            return;
        }
        java.io.File file = new java.io.File(a);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.r = com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).c(4, com.anythink.core.common.o.g.a(this.c));
        java.io.File file2 = new java.io.File(this.r);
        if (file2.exists()) {
            this.q = file2.length();
        }
    }

    private boolean i() {
        int i = this.p;
        if (i != 100) {
            return this.o == 0 && i < 100;
        }
        a(i, this.q);
        b(this.p, this.q);
        return false;
    }

    private synchronized void j() {
        this.j.clear();
    }

    @Override // com.anythink.core.common.res.image.b
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.o.b.d dVar) {
        com.anythink.core.common.o.b.b.a().a(dVar, 4);
    }

    public final synchronized void a(com.anythink.core.common.res.a.a.AbstractC0171a abstractC0171a) {
        if (!this.j.contains(abstractC0171a)) {
            this.j.add(abstractC0171a);
        }
    }

    public final synchronized void a(com.anythink.core.common.res.a.b bVar) {
        int i = bVar.a;
        int i2 = bVar.c;
        com.anythink.core.common.res.a.b bVar2 = this.b;
        if (bVar2.a < i) {
            bVar2.a = i;
        }
        if (bVar2.c != 1) {
            bVar2.c = i2;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(java.lang.String str, java.lang.String str2) {
        b(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1, types: [long] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // com.anythink.core.common.res.image.b
    public final boolean a(java.io.InputStream inputStream) {
        java.io.FileOutputStream fileOutputStream;
        boolean z = false;
        int i = 0;
        if (!android.text.TextUtils.isEmpty(this.r)) {
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                ?? r4 = this.q;
                try {
                    if (r4 > 0) {
                        inputStream.skip(r4);
                        fileOutputStream = new java.io.FileOutputStream(this.r, true);
                        long j = this.q;
                        int i2 = (int) (((j * 1.0d) / this.i) * 100.0d);
                        this.p = i2;
                        a(i2, j);
                    } else {
                        fileOutputStream = new java.io.FileOutputStream(this.r);
                        this.p = 0;
                    }
                    fileOutputStream2 = fileOutputStream;
                    r4 = 2048;
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1 || !b(this.p)) {
                            break;
                        }
                        fileOutputStream2.write(bArr, i, read);
                        long j2 = this.q + read;
                        this.q = j2;
                        int i3 = (int) (((j2 * 1.0d) / this.i) * 100.0d);
                        this.p = i3;
                        a(i3, j2);
                        bArr = bArr;
                        i = 0;
                    }
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (java.lang.Throwable unused) {
                    }
                    z = true;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream2 = r4;
                    try {
                        th.printStackTrace();
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        z = false;
                        b(this.p, this.q);
                        return z;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        b(this.p, this.q);
        return z;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
        this.o = 0;
    }

    public final void e() {
        i();
        if (i()) {
            h();
            this.o = 1;
            d();
        }
    }

    public final void f() {
        i();
        this.f185s = true;
        if (i()) {
            h();
            this.o = 1;
            d();
        }
    }
}
