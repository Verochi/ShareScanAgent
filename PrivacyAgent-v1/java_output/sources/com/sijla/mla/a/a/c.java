package com.sijla.mla.a.a;

/* loaded from: classes19.dex */
public final class c extends com.sijla.mla.a.a.a {
    com.sijla.mla.a.w b;
    com.sijla.mla.a.a.c c;
    com.sijla.mla.a.a.f d;
    com.sijla.mla.a.a.c.a e;
    int f;
    int g;
    com.sijla.mla.a.a.e h;
    int i;
    int j;
    int k;
    short l;
    short m;
    short n;
    short o;
    private java.util.Hashtable p;

    public static class a {
        com.sijla.mla.a.a.c.a a;
        short b;
        short c;
        short d;
        boolean e;
        boolean f;
    }

    public static int a(com.sijla.mla.a.a.c cVar, com.sijla.mla.a.n nVar, com.sijla.mla.a.a.f.i iVar, int i) {
        int i2;
        if (cVar == null) {
            return 0;
        }
        int i3 = cVar.m - 1;
        while (true) {
            i2 = -1;
            if (i3 < 0) {
                i3 = -1;
                break;
            }
            if (nVar.c((com.sijla.mla.a.r) cVar.n(i3).a)) {
                break;
            }
            i3--;
        }
        if (i3 >= 0) {
            iVar.a(7, i3);
            if (i == 0) {
                com.sijla.mla.a.a.c.a aVar = cVar.e;
                while (aVar.d > i3) {
                    aVar = aVar.a;
                }
                aVar.e = true;
            }
            return 7;
        }
        com.sijla.h.f[] fVarArr = cVar.b.f;
        int i4 = 0;
        while (true) {
            if (i4 >= cVar.n) {
                break;
            }
            if (fVarArr[i4].a.c((com.sijla.mla.a.r) nVar)) {
                i2 = i4;
                break;
            }
            i4++;
        }
        if (i2 < 0) {
            if (a(cVar.c, nVar, iVar, 0) == 0) {
                return 0;
            }
            i2 = cVar.a(nVar, iVar);
        }
        iVar.a(8, i2);
        return 8;
    }

    private void a(int i, int i2, com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2) {
        int i3 = i(iVar);
        int i4 = i(iVar2);
        l(iVar2);
        l(iVar);
        if (i2 == 0 && i != 24) {
            i2 = 1;
            i4 = i3;
            i3 = i4;
        }
        iVar.b.d = c(i, i2, i3, i4);
        iVar.a = 10;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2, int i2) {
        boolean z;
        com.sijla.mla.a.r e;
        if (iVar.b() && iVar2.b() && ((i != 16 && i != 17) || !iVar2.b.a().c(com.sijla.mla.a.r.o))) {
            com.sijla.mla.a.r a2 = iVar.b.a();
            com.sijla.mla.a.r a3 = iVar2.b.a();
            switch (i) {
                case 13:
                    e = a2.e(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                        iVar.b.a(e);
                        z = true;
                        break;
                    }
                    break;
                case 14:
                    e = a2.f(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 15:
                    e = a2.g(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 16:
                    e = a2.i(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 17:
                    e = a2.j(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 18:
                    e = a2.h(a3);
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 19:
                    e = a2.r();
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 20:
                default:
                    com.sijla.mla.a.a.a.a(false);
                    e = null;
                    if (!java.lang.Double.isNaN(e.o())) {
                    }
                    break;
                case 21:
                    break;
            }
            if (z) {
                int i3 = (i == 19 || i == 21) ? 0 : i(iVar2);
                int i4 = i(iVar);
                if (i4 > i3) {
                    l(iVar);
                    l(iVar2);
                } else {
                    l(iVar2);
                    l(iVar);
                }
                iVar.b.d = b(i, 0, i4, i3);
                iVar.a = 11;
                r(i2);
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    private void b(com.sijla.mla.a.a.f.i iVar, int i) {
        int i2;
        d(iVar);
        int i3 = iVar.a;
        if (i3 != 11) {
            switch (i3) {
                case 1:
                    b(i, 1);
                    break;
                case 2:
                case 3:
                    b(3, i, i3 != 2 ? 0 : 1, 0);
                    break;
                case 4:
                    i2 = iVar.b.d;
                    b(1, i, i2);
                    break;
                case 5:
                    i2 = b(iVar.b.a());
                    b(1, i, i2);
                    break;
                case 6:
                    int i4 = iVar.b.d;
                    if (i != i4) {
                        b(0, i, i4, 0);
                        break;
                    }
                    break;
                default:
                    com.sijla.mla.a.a.a.a(i3 == 0 || i3 == 10);
                    break;
            }
            return;
        }
        com.sijla.mla.a.a.a.a(a(iVar), i);
        iVar.b.d = i;
        iVar.a = 6;
    }

    private int c(int i, int i2, int i3) {
        c();
        return b(3, i, i2, i3);
    }

    private int c(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4);
        return b();
    }

    private void c(com.sijla.mla.a.a.f.i iVar, int i) {
        int c;
        int c2;
        b(iVar, i);
        if (iVar.a == 10) {
            a(iVar.c, iVar.b.d);
        }
        if (iVar.a()) {
            if (u(iVar.c.a) || u(iVar.d.a)) {
                int b = iVar.a == 10 ? -1 : b();
                c = c(i, 0, 1);
                c2 = c(i, 1, 0);
                o(b);
            } else {
                c2 = -1;
                c = -1;
            }
            int c3 = c();
            d(iVar.d.a, c3, i, c);
            d(iVar.c.a, c3, i, c2);
        }
        com.sijla.mla.a.a.e eVar = iVar.d;
        iVar.c.a = -1;
        eVar.a = -1;
        iVar.b.d = i;
        iVar.a = 6;
    }

    private int d(com.sijla.mla.a.a.f.i iVar, int i) {
        if (iVar.a == 11) {
            int b = b(iVar);
            if ((b & 63) == 20) {
                this.f--;
                return c(27, com.sijla.mla.a.e.d(b), 0, i != 0 ? 0 : 1);
            }
        }
        m(iVar);
        l(iVar);
        return c(28, 255, iVar.b.d, i);
    }

    private void d(int i, int i2, int i3) {
        int i4 = ((i2 - 1) / 50) + 1;
        int i5 = i3 == -1 ? 0 : i3;
        com.sijla.mla.a.a.a.a(i3 != 0);
        if (i4 <= 511) {
            b(36, i, i5, i4);
        } else {
            b(36, i, i5, 0);
            h(i4, this.d.b);
        }
        this.o = (short) (i + 1);
    }

    private void d(int i, int i2, int i3, int i4) {
        while (i != -1) {
            int s2 = s(i);
            if (g(i, i3)) {
                f(i, i2);
            } else {
                f(i, i4);
            }
            i = s2;
        }
    }

    private void f(int i, int i2) {
        com.sijla.mla.a.a.d dVar = new com.sijla.mla.a.a.d(this.b.b, i);
        int i3 = i2 - (i + 1);
        com.sijla.mla.a.a.a.a(i2 != -1);
        if (java.lang.Math.abs(i3) > 131071) {
            this.d.b("control structure too long");
        }
        dVar.a((((i3 + 131071) << 14) & (-16384)) | (dVar.a() & 16383));
    }

    private boolean g(int i, int i2) {
        com.sijla.mla.a.a.d t = t(i);
        if ((t.a() & 63) != 28) {
            return false;
        }
        if (i2 == 255 || i2 == com.sijla.mla.a.e.d(t.a())) {
            t.a(com.sijla.mla.a.a.a.a(27, com.sijla.mla.a.e.d(t.a()), 0, com.sijla.mla.a.e.e(t.a())));
            return true;
        }
        com.sijla.mla.a.a.a.a(t, i2);
        return true;
    }

    private int h(int i, int i2) {
        com.sijla.mla.a.w wVar = this.b;
        int i3 = this.h.a;
        int i4 = this.f;
        d(i3, i4, 255, i4);
        this.h.a = -1;
        int[] iArr = wVar.b;
        if (iArr == null || this.f + 1 > iArr.length) {
            wVar.b = com.sijla.mla.a.a.a.a(iArr, (this.f << 1) + 1);
        }
        int[] iArr2 = wVar.b;
        int i5 = this.f;
        iArr2[i5] = i;
        int[] iArr3 = wVar.d;
        if (iArr3 == null || i5 + 1 > iArr3.length) {
            wVar.d = com.sijla.mla.a.a.a.a(iArr3, (i5 << 1) + 1);
        }
        int[] iArr4 = wVar.d;
        int i6 = this.f;
        iArr4[i6] = i2;
        this.f = i6 + 1;
        return i6;
    }

    private void l(com.sijla.mla.a.a.f.i iVar) {
        if (iVar.a == 6) {
            w(iVar.b.d);
        }
    }

    private void m(com.sijla.mla.a.a.f.i iVar) {
        if (iVar.a != 6) {
            q(1);
            b(iVar, this.o - 1);
        }
    }

    private void n(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.a.d t = t(iVar.b.d);
        com.sijla.mla.a.a.a.a((!com.sijla.mla.a.e.m(t.a() & 63) || (t.a() & 63) == 28 || (t.a() & 63) == 27) ? false : true);
        com.sijla.mla.a.a.a.a(t, com.sijla.mla.a.e.b(t.a()) != 0 ? 0 : 1);
    }

    private int s(int i) {
        int g = com.sijla.mla.a.e.g(this.b.b[i]);
        if (g == -1) {
            return -1;
        }
        return i + 1 + g;
    }

    private com.sijla.mla.a.a.d t(int i) {
        com.sijla.mla.a.a.d dVar = new com.sijla.mla.a.a.d(this.b.b, i);
        return (i <= 0 || !com.sijla.mla.a.e.m(dVar.a[dVar.b + (-1)] & 63)) ? dVar : new com.sijla.mla.a.a.d(dVar.a, dVar.b - 1);
    }

    private boolean u(int i) {
        while (i != -1) {
            if ((t(i).a() & 63) != 28) {
                return true;
            }
            i = s(i);
        }
        return false;
    }

    private void v(int i) {
        while (i != -1) {
            g(i, 255);
            i = s(i);
        }
    }

    private void w(int i) {
        if (com.sijla.mla.a.e.h(i) || i < this.m) {
            return;
        }
        short s2 = (short) (this.o - 1);
        this.o = s2;
        com.sijla.mla.a.a.a.a(i == s2);
    }

    public final int a(int i, int i2) {
        return b(i, i2, 131070);
    }

    public final int a(com.sijla.mla.a.n nVar, com.sijla.mla.a.a.f.i iVar) {
        a(this.n + 1, 255, com.sijla.mla.L2.s1252431261());
        com.sijla.mla.a.w wVar = this.b;
        com.sijla.h.f[] fVarArr = wVar.f;
        if (fVarArr == null || this.n + 1 > fVarArr.length) {
            short s2 = this.n;
            wVar.f = com.sijla.mla.a.a.a.a(fVarArr, s2 > 0 ? s2 << 1 : 1);
        }
        this.b.f[this.n] = new com.sijla.h.f(nVar, iVar.a == 7, iVar.b.d);
        short s3 = this.n;
        this.n = (short) (s3 + 1);
        return s3;
    }

    public final int a(com.sijla.mla.a.r rVar) {
        java.util.Hashtable hashtable = this.p;
        if (hashtable == null) {
            this.p = new java.util.Hashtable();
        } else if (hashtable.containsKey(rVar)) {
            return ((java.lang.Integer) this.p.get(rVar)).intValue();
        }
        int i = this.i;
        this.p.put(rVar, java.lang.Integer.valueOf(i));
        com.sijla.mla.a.w wVar = this.b;
        com.sijla.mla.a.r[] rVarArr = wVar.a;
        if (rVarArr == null || this.i + 1 >= rVarArr.length) {
            wVar.a = com.sijla.mla.a.a.a.a(rVarArr, (this.i << 1) + 1);
        }
        com.sijla.mla.a.r[] rVarArr2 = wVar.a;
        int i2 = this.i;
        this.i = i2 + 1;
        rVarArr2[i2] = rVar;
        return i;
    }

    public final com.sijla.mla.a.a.d a(com.sijla.mla.a.a.f.i iVar) {
        return new com.sijla.mla.a.a.d(this.b.b, iVar.b.d);
    }

    public final void a() {
        short s2;
        java.lang.StringBuilder sb;
        com.sijla.mla.a.a.c.a aVar = this.e;
        if (aVar.a != null && aVar.e) {
            int b = b();
            e(b, aVar.d);
            o(b);
        }
        if (aVar.f) {
            com.sijla.mla.a.a.f fVar = this.d;
            com.sijla.mla.a.n c = com.sijla.mla.a.n.c(com.sijla.mla.L2.s1270569563());
            com.sijla.mla.a.a.f.b bVar = fVar.d;
            com.sijla.mla.a.a.f.d[] a2 = com.sijla.mla.a.a.a.a(bVar.e, bVar.f + 1);
            bVar.e = a2;
            com.sijla.mla.a.a.f.b bVar2 = fVar.d;
            int i = bVar2.f;
            bVar2.f = i + 1;
            fVar.a(fVar.d.e[fVar.a(a2, i, c, 0, fVar.c.f)]);
        }
        this.e = aVar.a;
        short s3 = aVar.d;
        this.d.d.b -= this.m - s3;
        while (true) {
            s2 = this.m;
            if (s2 <= s3) {
                break;
            }
            short s4 = (short) (s2 - 1);
            this.m = s4;
            n(s4).c = this.f;
        }
        com.sijla.mla.a.a.a.a(aVar.d == s2);
        this.o = this.m;
        com.sijla.mla.a.a.f fVar2 = this.d;
        com.sijla.mla.a.a.f.b bVar3 = fVar2.d;
        bVar3.f = aVar.b;
        if (aVar.a != null) {
            int i2 = aVar.c;
            com.sijla.mla.a.a.f.d[] dVarArr = bVar3.c;
            while (i2 < this.d.d.d) {
                com.sijla.mla.a.a.f.d dVar = dVarArr[i2];
                int i3 = dVar.d;
                int i4 = aVar.d;
                if (i3 > i4) {
                    if (aVar.e) {
                        e(dVar.b, i4);
                    }
                    dVar.d = aVar.d;
                }
                if (!this.d.n(i2)) {
                    i2++;
                }
            }
            return;
        }
        short s5 = aVar.c;
        if (s5 < bVar3.d) {
            com.sijla.mla.a.a.f.d dVar2 = bVar3.c[s5];
            if (com.sijla.mla.a.a.f.a(dVar2.a.g())) {
                sb = new java.lang.StringBuilder("<");
                sb.append(dVar2.a);
                sb.append("> at line ");
                sb.append(dVar2.c);
                sb.append(" not inside a loop");
            } else {
                sb = new java.lang.StringBuilder("no visible label '");
                sb.append(dVar2.a);
                sb.append("' for <goto> at line ");
                sb.append(dVar2.c);
            }
            fVar2.c(sb.toString());
        }
    }

    public final void a(int i, int i2, java.lang.String str) {
        java.lang.StringBuilder sb;
        if (i > i2) {
            if (this.b.h == 0) {
                sb = new java.lang.StringBuilder("main function has more than ");
            } else {
                sb = new java.lang.StringBuilder("function at line ");
                sb.append(this.b.h);
                sb.append(" has more than ");
            }
            sb.append(i2);
            sb.append(" ");
            sb.append(str);
            this.d.a(sb.toString(), 0);
        }
    }

    public final void a(int i, com.sijla.mla.a.a.f.i iVar) {
        if (i == 13) {
            j(iVar);
            return;
        }
        if (i == 14) {
            k(iVar);
            return;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (!iVar.b()) {
                    i(iVar);
                    break;
                }
                break;
            case 6:
                e(iVar);
                break;
            default:
                i(iVar);
                break;
        }
    }

    public final void a(int i, com.sijla.mla.a.a.f.i iVar, int i2) {
        com.sijla.mla.a.a.f.i iVar2 = new com.sijla.mla.a.a.f.i();
        iVar2.a(5, 0);
        if (i == 0) {
            if (iVar.b()) {
                com.sijla.mla.a.a.f.i.a aVar = iVar.b;
                aVar.a(aVar.a().r());
                return;
            } else {
                f(iVar);
                b(19, iVar, iVar2, i2);
                return;
            }
        }
        if (i != 1) {
            if (i != 2) {
                com.sijla.mla.a.a.a.a(false);
                return;
            } else {
                f(iVar);
                b(21, iVar, iVar2, i2);
                return;
            }
        }
        d(iVar);
        int i3 = iVar.a;
        if (i3 != 10) {
            if (i3 != 11) {
                switch (i3) {
                    case 1:
                    case 3:
                        iVar.a = 2;
                        break;
                    case 2:
                    case 4:
                    case 5:
                        iVar.a = 3;
                        break;
                    case 6:
                        break;
                    default:
                        com.sijla.mla.a.a.a.a(false);
                        break;
                }
            }
            m(iVar);
            l(iVar);
            com.sijla.mla.a.a.f.i.a aVar2 = iVar.b;
            aVar2.d = b(20, 0, aVar2.d, 0);
            iVar.a = 11;
        } else {
            n(iVar);
        }
        com.sijla.mla.a.a.e eVar = iVar.d;
        int i4 = eVar.a;
        com.sijla.mla.a.a.e eVar2 = iVar.c;
        eVar.a = eVar2.a;
        eVar2.a = i4;
        v(eVar.a);
        v(iVar.c.a);
    }

    public final void a(int i, com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2, int i2) {
        switch (i) {
            case 0:
                b(13, iVar, iVar2, i2);
                break;
            case 1:
                b(14, iVar, iVar2, i2);
                break;
            case 2:
                b(15, iVar, iVar2, i2);
                break;
            case 3:
                b(16, iVar, iVar2, i2);
                break;
            case 4:
                b(17, iVar, iVar2, i2);
                break;
            case 5:
                b(18, iVar, iVar2, i2);
                break;
            case 6:
                h(iVar2);
                if (iVar2.a != 11 || (b(iVar2) & 63) != 22) {
                    e(iVar2);
                    b(22, iVar, iVar2, i2);
                    break;
                } else {
                    com.sijla.mla.a.a.a.a(iVar.b.d == com.sijla.mla.a.e.d(b(iVar2)) - 1);
                    l(iVar);
                    com.sijla.mla.a.a.a.b(a(iVar2), iVar.b.d);
                    iVar.a = 11;
                    iVar.b.d = iVar2.b.d;
                    break;
                }
                break;
            case 7:
                a(24, 0, iVar, iVar2);
                break;
            case 8:
                a(24, 1, iVar, iVar2);
                break;
            case 9:
                a(25, 1, iVar, iVar2);
                break;
            case 10:
                a(26, 1, iVar, iVar2);
                break;
            case 11:
                a(25, 0, iVar, iVar2);
                break;
            case 12:
                a(26, 0, iVar, iVar2);
                break;
            case 13:
                com.sijla.mla.a.a.a.a(iVar.c.a == -1);
                d(iVar2);
                a(iVar2.d, iVar.d.a);
                iVar.a(iVar2);
                break;
            case 14:
                com.sijla.mla.a.a.a.a(iVar.d.a == -1);
                d(iVar2);
                a(iVar2.c, iVar.c.a);
                iVar.a(iVar2);
                break;
            default:
                com.sijla.mla.a.a.a.a(false);
                break;
        }
    }

    public final void a(com.sijla.mla.a.a.c.a aVar, boolean z) {
        aVar.f = z;
        short s2 = this.m;
        aVar.d = s2;
        com.sijla.mla.a.a.f.b bVar = this.d.d;
        aVar.b = (short) bVar.f;
        aVar.c = (short) bVar.d;
        aVar.e = false;
        aVar.a = this.e;
        this.e = aVar;
        com.sijla.mla.a.a.a.a(this.o == s2);
    }

    public final void a(com.sijla.mla.a.a.e eVar, int i) {
        if (i == -1) {
            return;
        }
        int i2 = eVar.a;
        if (i2 == -1) {
            eVar.a = i;
            return;
        }
        while (true) {
            int s2 = s(i2);
            if (s2 == -1) {
                f(i2, i);
                return;
            }
            i2 = s2;
        }
    }

    public final void a(com.sijla.mla.a.a.f.a aVar) {
        com.sijla.mla.a.a.f.i iVar = aVar.a;
        if (iVar.a == 0) {
            return;
        }
        e(iVar);
        aVar.a.a = 0;
        int i = aVar.e;
        if (i == 50) {
            d(aVar.b.b.d, aVar.d, i);
            aVar.e = 0;
        }
    }

    public final void a(com.sijla.mla.a.a.f.i iVar, int i) {
        int i2 = iVar.a;
        if (i2 == 12) {
            com.sijla.mla.a.a.a.c(a(iVar), i + 1);
        } else if (i2 == 13) {
            com.sijla.mla.a.a.a.b(a(iVar), i + 1);
            com.sijla.mla.a.a.a.a(a(iVar), this.o);
            q(1);
        }
    }

    public final void a(com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2) {
        int i = iVar.a;
        if (i == 7) {
            l(iVar2);
            c(iVar2, iVar.b.d);
            return;
        }
        if (i == 8) {
            b(9, f(iVar2), iVar.b.d, 0);
        } else if (i != 9) {
            com.sijla.mla.a.a.a.a(false);
        } else {
            int i2 = iVar.b.c == 7 ? 10 : 8;
            int i3 = i(iVar2);
            com.sijla.mla.a.a.f.i.a aVar = iVar.b;
            b(i2, aVar.b, aVar.a, i3);
        }
        l(iVar2);
    }

    public final int b() {
        com.sijla.mla.a.a.e eVar = this.h;
        int i = eVar.a;
        eVar.a = -1;
        com.sijla.mla.a.a.e eVar2 = new com.sijla.mla.a.a.e(a(23, 0));
        a(eVar2, i);
        return eVar2.a;
    }

    public final int b(int i, int i2, int i3) {
        int i4 = com.sijla.mla.a.e.a[i];
        boolean z = false;
        com.sijla.mla.a.a.a.a((i4 & 3) == 1 || (i4 & 3) == 2);
        com.sijla.mla.a.a.a.a(com.sijla.mla.a.e.k(i) == 0);
        if (i3 >= 0 && i3 <= 262143) {
            z = true;
        }
        com.sijla.mla.a.a.a.a(z);
        return h(com.sijla.mla.a.a.a.a(i, i2, i3), this.d.b);
    }

    public final int b(int i, int i2, int i3, int i4) {
        boolean z = true;
        com.sijla.mla.a.a.a.a((com.sijla.mla.a.e.a[i] & 3) == 0);
        com.sijla.mla.a.a.a.a(com.sijla.mla.a.e.j(i) != 0 || i3 == 0);
        if (com.sijla.mla.a.e.k(i) == 0 && i4 != 0) {
            z = false;
        }
        com.sijla.mla.a.a.a.a(z);
        return h(com.sijla.mla.a.a.a.a(i, i2, i3, i4), this.d.b);
    }

    public final int b(com.sijla.mla.a.a.f.i iVar) {
        return this.b.b[iVar.b.d];
    }

    public final int b(com.sijla.mla.a.r rVar) {
        if (rVar instanceof com.sijla.mla.a.h) {
            double o = rVar.o();
            int i = (int) o;
            if (o == i) {
                rVar = com.sijla.mla.a.k.c_(i);
            }
        }
        return a(rVar);
    }

    public final void b(int i, int i2) {
        int i3 = (i + i2) - 1;
        int i4 = this.f;
        if (i4 > this.g && i4 > 0) {
            int i5 = this.b.b[i4 - 1];
            if ((i5 & 63) == 4) {
                int b = com.sijla.mla.a.e.b(i5);
                int d = com.sijla.mla.a.e.d(i5) + b;
                if ((b <= i && i <= d + 1) || (i <= b && b <= i3 + 1)) {
                    if (b < i) {
                        i = b;
                    }
                    if (d > i3) {
                        i3 = d;
                    }
                    com.sijla.mla.a.a.d dVar = new com.sijla.mla.a.a.d(this.b.b, this.f - 1);
                    com.sijla.mla.a.a.a.a(dVar, i);
                    com.sijla.mla.a.a.a.b(dVar, i3 - i);
                    return;
                }
            }
        }
        b(4, i, i2 - 1, 0);
    }

    public final void b(com.sijla.mla.a.a.f.a aVar) {
        if (aVar.e == 0) {
            return;
        }
        com.sijla.mla.a.a.f.i iVar = aVar.a;
        int i = iVar.a;
        if (i == 12 || i == 13) {
            a(iVar, -1);
            d(aVar.b.b.d, aVar.d, -1);
            aVar.d--;
        } else {
            if (i != 0) {
                e(iVar);
            }
            d(aVar.b.b.d, aVar.d, aVar.e);
        }
    }

    public final void b(com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2) {
        f(iVar);
        l(iVar);
        short s2 = this.o;
        q(2);
        b(12, s2, iVar.b.d, i(iVar2));
        l(iVar2);
        iVar.b.d = s2;
        iVar.a = 6;
    }

    public final int c() {
        int i = this.f;
        this.g = i;
        return i;
    }

    public final void c(int i, int i2) {
        b(31, i, i2 + 1, 0);
    }

    public final void c(com.sijla.mla.a.a.f.i iVar) {
        int i = iVar.a;
        if (i == 12) {
            iVar.a = 6;
            iVar.b.d = com.sijla.mla.a.e.b(b(iVar));
        } else if (i == 13) {
            com.sijla.mla.a.a.a.b(a(iVar), 2);
            iVar.a = 11;
        }
    }

    public final void c(com.sijla.mla.a.a.f.i iVar, com.sijla.mla.a.a.f.i iVar2) {
        com.sijla.mla.a.a.f.i.a aVar = iVar.b;
        aVar.b = (short) aVar.d;
        aVar.a = (short) i(iVar2);
        int i = iVar.a;
        boolean z = true;
        if (i != 8) {
            if (!(i == 6 || i == 7)) {
                z = false;
            }
        }
        com.sijla.mla.a.a.a.a(z);
        iVar.b.c = (short) (iVar.a == 8 ? 8 : 7);
        iVar.a = 9;
    }

    public final void d(int i, int i2) {
        int i3 = this.f;
        if (i2 == i3) {
            o(i);
        } else {
            com.sijla.mla.a.a.a.a(i2 < i3);
            d(i, i2, 255, i2);
        }
    }

    public final void d(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.a.f.i.a aVar;
        int b;
        int i = iVar.a;
        int i2 = 6;
        if (i == 7) {
            iVar.a = 6;
            return;
        }
        if (i == 8) {
            aVar = iVar.b;
            b = b(5, 0, aVar.d, 0);
        } else {
            if (i != 9) {
                if (i == 12 || i == 13) {
                    c(iVar);
                    return;
                }
                return;
            }
            w(iVar.b.a);
            com.sijla.mla.a.a.f.i.a aVar2 = iVar.b;
            if (aVar2.c == 7) {
                w(aVar2.b);
                i2 = 7;
            }
            aVar = iVar.b;
            b = b(i2, 0, aVar.b, aVar.a);
        }
        aVar.d = b;
        iVar.a = 11;
    }

    public final void e(int i, int i2) {
        int i3 = i2 + 1;
        while (i != -1) {
            int s2 = s(i);
            int i4 = this.b.b[i];
            com.sijla.mla.a.a.a.a((i4 & 63) == 23 && (com.sijla.mla.a.e.b(i4) == 0 || com.sijla.mla.a.e.b(this.b.b[i]) >= i3));
            com.sijla.mla.a.a.a.a(this.b.b, i, i3);
            i = s2;
        }
    }

    public final void e(com.sijla.mla.a.a.f.i iVar) {
        d(iVar);
        l(iVar);
        q(1);
        c(iVar, this.o - 1);
    }

    public final int f(com.sijla.mla.a.a.f.i iVar) {
        d(iVar);
        if (iVar.a == 6) {
            if (iVar.a()) {
                int i = iVar.b.d;
                if (i >= this.m) {
                    c(iVar, i);
                }
            }
            return iVar.b.d;
        }
        e(iVar);
        return iVar.b.d;
    }

    public final void g(com.sijla.mla.a.a.f.i iVar) {
        if (iVar.a != 8 || iVar.a()) {
            f(iVar);
        }
    }

    public final void h(com.sijla.mla.a.a.f.i iVar) {
        if (iVar.a()) {
            f(iVar);
        } else {
            d(iVar);
        }
    }

    public final int i(com.sijla.mla.a.a.f.i iVar) {
        com.sijla.mla.a.r rVar;
        h(iVar);
        int i = iVar.a;
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                if (i == 5) {
                    com.sijla.mla.a.a.f.i.a aVar = iVar.b;
                    aVar.d = b(aVar.a());
                    iVar.a = 4;
                }
            }
            int i2 = iVar.b.d;
            if (i2 <= 255) {
                return i2 | 256;
            }
        } else if (this.i <= 255) {
            com.sijla.mla.a.a.f.i.a aVar2 = iVar.b;
            if (i == 1) {
                rVar = com.sijla.mla.a.r.k;
            } else {
                rVar = i == 2 ? com.sijla.mla.a.r.l : com.sijla.mla.a.r.m;
            }
            aVar2.d = a(rVar);
            iVar.a = 4;
            return iVar.b.d | 256;
        }
        return f(iVar);
    }

    public final void j(com.sijla.mla.a.a.f.i iVar) {
        int i;
        d(iVar);
        int i2 = iVar.a;
        if (i2 != 2) {
            if (i2 == 10) {
                n(iVar);
                i = iVar.b.d;
            } else if (i2 != 4 && i2 != 5) {
                i = d(iVar, 0);
            }
            a(iVar.d, i);
            o(iVar.c.a);
            iVar.c.a = -1;
        }
        i = -1;
        a(iVar.d, i);
        o(iVar.c.a);
        iVar.c.a = -1;
    }

    public final void k(com.sijla.mla.a.a.f.i iVar) {
        d(iVar);
        int i = iVar.a;
        a(iVar.c, (i == 1 || i == 3) ? -1 : i != 10 ? d(iVar, 1) : iVar.b.d);
        o(iVar.d.a);
        iVar.d.a = -1;
    }

    public final com.sijla.mla.b n(int i) {
        short s2 = this.d.d.a[this.k + i].a;
        com.sijla.mla.a.a.a.a(s2 < this.l);
        return this.b.e[s2];
    }

    public final void o(int i) {
        c();
        a(this.h, i);
    }

    public final void p(int i) {
        int i2 = this.o + i;
        if (i2 > this.b.l) {
            if (i2 >= 250) {
                this.d.b("function or expression too complex");
            }
            this.b.l = i2;
        }
    }

    public final void q(int i) {
        p(i);
        this.o = (short) (this.o + i);
    }

    public final void r(int i) {
        this.b.d[this.f - 1] = i;
    }
}
