package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
abstract class a extends com.anythink.expressad.exoplayer.ae {
    private final int b;
    private final com.anythink.expressad.exoplayer.h.aa c;
    private final boolean d;

    public a(boolean z, com.anythink.expressad.exoplayer.h.aa aaVar) {
        this.d = z;
        this.c = aaVar;
        this.b = aaVar.a();
    }

    private int a(int i, boolean z) {
        if (z) {
            return this.c.a(i);
        }
        if (i < this.b - 1) {
            return i + 1;
        }
        return -1;
    }

    private int b(int i, boolean z) {
        if (z) {
            return this.c.b(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract int a(int i);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(int i, int i2, boolean z) {
        if (this.d) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int b = b(i);
        int e = e(b);
        int a = c(b).a(i - e, i2 != 2 ? i2 : 0, z);
        if (a != -1) {
            return e + a;
        }
        int a2 = a(b, z);
        while (a2 != -1 && c(a2).a()) {
            a2 = a(a2, z);
        }
        if (a2 != -1) {
            return e(a2) + c(a2).b(z);
        }
        if (i2 == 2) {
            return b(z);
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(java.lang.Object obj) {
        int a;
        if (!(obj instanceof android.util.Pair)) {
            return -1;
        }
        android.util.Pair pair = (android.util.Pair) obj;
        java.lang.Object obj2 = pair.first;
        java.lang.Object obj3 = pair.second;
        int b = b(obj2);
        if (b == -1 || (a = c(b).a(obj3)) == -1) {
            return -1;
        }
        return d(b) + a;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(boolean z) {
        int i = this.b;
        if (i == 0) {
            return -1;
        }
        if (this.d) {
            z = false;
        }
        int b = z ? this.c.b() : i - 1;
        while (c(b).a()) {
            b = b(b, z);
            if (b == -1) {
                return -1;
            }
        }
        return e(b) + c(b).a(z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
        int a = a(i);
        int e = e(a);
        c(a).a(i - d(a), aVar, z);
        aVar.c += e;
        if (z) {
            aVar.b = android.util.Pair.create(f(a), aVar.b);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
        int b = b(i);
        int e = e(b);
        int d = d(b);
        c(b).a(i - e, bVar, z, j);
        bVar.f += d;
        bVar.g += d;
        return bVar;
    }

    public abstract int b(int i);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(int i, int i2, boolean z) {
        if (this.d) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int b = b(i);
        int e = e(b);
        int b2 = c(b).b(i - e, i2 != 2 ? i2 : 0, z);
        if (b2 != -1) {
            return e + b2;
        }
        int b3 = b(b, z);
        while (b3 != -1 && c(b3).a()) {
            b3 = b(b3, z);
        }
        if (b3 != -1) {
            return e(b3) + c(b3).a(z);
        }
        if (i2 == 2) {
            return a(z);
        }
        return -1;
    }

    public abstract int b(java.lang.Object obj);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(boolean z) {
        if (this.b == 0) {
            return -1;
        }
        if (this.d) {
            z = false;
        }
        int c = z ? this.c.c() : 0;
        while (c(c).a()) {
            c = a(c, z);
            if (c == -1) {
                return -1;
            }
        }
        return e(c) + c(c).b(z);
    }

    public abstract com.anythink.expressad.exoplayer.ae c(int i);

    public abstract int d(int i);

    public abstract int e(int i);

    public abstract java.lang.Object f(int i);
}
