package com.igexin.c.a.b;

/* loaded from: classes22.dex */
public class e extends com.igexin.c.a.d.g {
    private static volatile com.igexin.c.a.b.e J;
    public volatile long a;
    public volatile long b;
    public volatile long c;
    public volatile long d;
    public byte[] e;
    public byte[] f;
    public com.igexin.c.a.d.a.b<java.lang.String, java.lang.Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> g;

    private e() {
    }

    public static com.igexin.c.a.b.e a() {
        if (J == null) {
            synchronized (com.igexin.c.a.b.e.class) {
                if (J == null) {
                    J = new com.igexin.c.a.b.e();
                }
            }
        }
        return J;
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar) {
        return a(str, i, dVar, null, false, -1, -1L, (byte) 0, null, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj) {
        return a(str, i, dVar, obj, false, -1, -1L, (byte) 0, null, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, byte b) {
        return a(str, i, dVar, obj, false, -1, -1L, b, null, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, int i2) {
        return a(str, i, dVar, obj, false, i2, -1L, (byte) 0, null, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, long j) {
        return a(str, i, dVar, obj, false, -1, j, (byte) 0, null, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, com.igexin.c.a.d.a.d dVar2) {
        return a(str, i, dVar, obj, false, -1, -1L, (byte) 0, null, dVar2);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, java.lang.Object obj2) {
        return a(str, i, dVar, obj, false, -1, -1L, (byte) 0, obj2, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, boolean z, int i2, long j, byte b, java.lang.Object obj2, com.igexin.c.a.d.a.d dVar2) {
        return a(str, i, dVar, obj, z, i2, j, b, obj2, dVar2, 0, null);
    }

    private com.igexin.c.a.b.f a(java.lang.String str, int i, com.igexin.c.a.b.d dVar, java.lang.Object obj, boolean z, int i2, long j, byte b, java.lang.Object obj2, com.igexin.c.a.d.a.d dVar2, int i3, com.igexin.c.a.d.a.g gVar) {
        com.igexin.c.a.b.f a;
        com.igexin.c.a.d.a.b<java.lang.String, java.lang.Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> bVar = this.g;
        if (bVar == null || (a = bVar.a(str, dVar)) == null || a.n()) {
            return null;
        }
        if (gVar != null) {
            a.a(i3, gVar);
        }
        a(a, obj, z, i2, j, b, obj2, dVar2);
        return a;
    }

    private void a(com.igexin.c.a.d.a.b<java.lang.String, java.lang.Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> bVar) {
        this.g = bVar;
    }

    private void a(byte[] bArr) {
        this.e = bArr;
        byte[] a = com.igexin.c.b.a.a(bArr);
        this.f = a;
        if (a != null) {
            new java.lang.String(a);
        }
    }

    private boolean a(com.igexin.c.a.b.f fVar, java.lang.Object obj, boolean z, int i, long j, byte b, java.lang.Object obj2, com.igexin.c.a.d.a.d dVar) {
        fVar.d = obj;
        fVar.a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
        fVar.A = i;
        fVar.a((int) b);
        fVar.F = obj2;
        fVar.a(dVar);
        return a(fVar, z);
    }

    public static void c() {
        J.a = 0L;
        J.c = 0L;
        J.b = 0L;
        J.d = 0L;
    }

    private byte[] g() {
        return this.e;
    }

    private byte[] h() {
        return this.f;
    }

    private static void i() {
        J = null;
    }

    public final com.igexin.c.a.b.f a(java.lang.String str, com.igexin.c.a.b.d dVar, java.lang.Object obj) {
        return a(str, 3, dVar, obj, true, -1, -1L, (byte) 0, null, null);
    }

    public final com.igexin.c.a.b.f a(java.lang.String str, com.igexin.c.a.b.d dVar, java.lang.Object obj, int i, com.igexin.c.a.d.a.g gVar) {
        return a(str, 3, dVar, obj, true, -1, -1L, (byte) 0, null, null, i, gVar);
    }

    public final void b() {
        e();
    }
}
