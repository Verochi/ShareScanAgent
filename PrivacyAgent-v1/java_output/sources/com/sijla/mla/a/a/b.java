package com.sijla.mla.a.a;

/* loaded from: classes19.dex */
public final class b {
    private java.io.DataOutputStream d;
    private boolean a = false;
    private int b = 0;
    private int c = 8;
    private boolean e = true;
    private int f = 0;

    private b(java.io.OutputStream outputStream) {
        this.d = new java.io.DataOutputStream(outputStream);
    }

    public static int a(com.sijla.mla.a.w wVar, java.io.OutputStream outputStream) {
        com.sijla.mla.a.a.b bVar = new com.sijla.mla.a.a.b(outputStream);
        bVar.d.write(com.sijla.mla.a.c.a);
        bVar.d.write(82);
        bVar.d.write(0);
        bVar.d.write(0);
        bVar.d.write(4);
        bVar.d.write(4);
        bVar.d.write(4);
        bVar.d.write(bVar.c);
        bVar.d.write(0);
        bVar.d.write(com.sijla.mla.a.c.b);
        bVar.e(wVar);
        return 0;
    }

    private void a(int i) {
        this.d.write(i);
    }

    private void a(com.sijla.mla.a.n nVar) {
        int p = nVar.M().p();
        b(p + 1);
        this.d.write(nVar.b, nVar.c, p);
        this.d.write(0);
    }

    private void a(com.sijla.mla.a.w wVar) {
        int[] iArr = wVar.b;
        b(iArr.length);
        for (int i : iArr) {
            b(i);
        }
    }

    private void b(int i) {
        this.d.writeInt(i);
    }

    private void b(com.sijla.mla.a.w wVar) {
        com.sijla.mla.a.r[] rVarArr = wVar.a;
        b(rVarArr.length);
        for (com.sijla.mla.a.r rVar : rVarArr) {
            int a_ = rVar.a_();
            if (a_ == 0) {
                this.d.write(0);
            } else if (a_ == 1) {
                this.d.write(1);
                a(rVar.f() ? 1 : 0);
            } else if (a_ == 3) {
                this.d.write(3);
                this.d.writeLong(java.lang.Double.doubleToLongBits(rVar.o()));
            } else {
                if (a_ != 4) {
                    throw new java.lang.IllegalArgumentException("bad type for ".concat(java.lang.String.valueOf(rVar)));
                }
                this.d.write(4);
                a((com.sijla.mla.a.n) rVar);
            }
        }
        int length = wVar.c.length;
        b(length);
        for (int i = 0; i < length; i++) {
            e(wVar.c[i]);
        }
    }

    private void c(com.sijla.mla.a.w wVar) {
        int length = wVar.f.length;
        b(length);
        for (int i = 0; i < length; i++) {
            this.d.writeByte(wVar.f[i].b ? 1 : 0);
            this.d.writeByte(wVar.f[i].c);
        }
    }

    private void d(com.sijla.mla.a.w wVar) {
        if (this.e) {
            b(0);
        } else {
            a(wVar.g);
        }
        int length = this.e ? 0 : wVar.d.length;
        b(length);
        for (int i = 0; i < length; i++) {
            b(wVar.d[i]);
        }
        int length2 = this.e ? 0 : wVar.e.length;
        b(length2);
        for (int i2 = 0; i2 < length2; i2++) {
            com.sijla.mla.b bVar = wVar.e[i2];
            a(bVar.a);
            b(bVar.b);
            b(bVar.c);
        }
        int length3 = this.e ? 0 : wVar.f.length;
        b(length3);
        for (int i3 = 0; i3 < length3; i3++) {
            a(wVar.f[i3].a);
        }
    }

    private void e(com.sijla.mla.a.w wVar) {
        b(wVar.h);
        b(wVar.i);
        a(wVar.j);
        a(wVar.k);
        a(wVar.l);
        a(wVar);
        b(wVar);
        c(wVar);
        d(wVar);
    }
}
