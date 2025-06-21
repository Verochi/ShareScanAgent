package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ea implements com.xiaomi.push.hw<com.xiaomi.push.ea, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im k = new com.xiaomi.push.im("StatsEvent");
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 3, 1);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 8, 2);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 8, 3);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 8, 6);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 7);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f463s = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 8, 9);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 8, 10);
    public byte a;
    public int b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public int f;
    public java.lang.String g;
    public java.lang.String h;
    public int i;
    public int j;
    private java.util.BitSet v = new java.util.BitSet(6);

    private boolean a() {
        return this.v.get(0);
    }

    private void b() {
        this.v.set(0, true);
    }

    private boolean c() {
        return this.v.get(1);
    }

    private void d() {
        this.v.set(1, true);
    }

    private boolean e() {
        return this.v.get(2);
    }

    private void f() {
        this.v.set(2, true);
    }

    private boolean g() {
        return this.d != null;
    }

    private boolean h() {
        return this.e != null;
    }

    private boolean i() {
        return this.v.get(3);
    }

    private void j() {
        this.v.set(3, true);
    }

    private boolean k() {
        return this.g != null;
    }

    private boolean l() {
        return this.h != null;
    }

    private boolean m() {
        return this.v.get(4);
    }

    private void n() {
        this.v.set(4, true);
    }

    private boolean o() {
        return this.v.get(5);
    }

    private void p() {
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'connpt' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.ea a(byte b) {
        this.a = b;
        b();
        return this;
    }

    public final com.xiaomi.push.ea a(int i) {
        this.b = i;
        d();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                if (!a()) {
                    throw new com.xiaomi.push.ii("Required field 'chid' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                if (!c()) {
                    throw new com.xiaomi.push.ii("Required field 'type' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                if (e()) {
                    p();
                    return;
                } else {
                    throw new com.xiaomi.push.ii("Required field 'value' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
            }
            switch (b.c) {
                case 1:
                    if (b2 != 3) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.a = ihVar.g();
                        b();
                        break;
                    }
                case 2:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.b = ihVar.i();
                        d();
                        break;
                    }
                case 3:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.c = ihVar.i();
                        f();
                        break;
                    }
                case 4:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.d = ihVar.l();
                        break;
                    }
                case 5:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.e = ihVar.l();
                        break;
                    }
                case 6:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.f = ihVar.i();
                        j();
                        break;
                    }
                case 7:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.g = ihVar.l();
                        break;
                    }
                case 8:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.h = ihVar.l();
                        break;
                    }
                case 9:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.i = ihVar.i();
                        n();
                        break;
                    }
                case 10:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.j = ihVar.i();
                        this.v.set(5, true);
                        break;
                    }
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
            }
        }
    }

    public final com.xiaomi.push.ea b(int i) {
        this.c = i;
        f();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        p();
        ihVar.a(l);
        ihVar.a(this.a);
        ihVar.a(m);
        ihVar.a(this.b);
        ihVar.a(n);
        ihVar.a(this.c);
        if (this.d != null) {
            ihVar.a(o);
            ihVar.a(this.d);
        }
        if (this.e != null && h()) {
            ihVar.a(p);
            ihVar.a(this.e);
        }
        if (i()) {
            ihVar.a(q);
            ihVar.a(this.f);
        }
        if (this.g != null && k()) {
            ihVar.a(r);
            ihVar.a(this.g);
        }
        if (this.h != null && l()) {
            ihVar.a(f463s);
            ihVar.a(this.h);
        }
        if (m()) {
            ihVar.a(t);
            ihVar.a(this.i);
        }
        if (o()) {
            ihVar.a(u);
            ihVar.a(this.j);
        }
        ihVar.a();
    }

    public final com.xiaomi.push.ea c(int i) {
        this.f = i;
        j();
        return this;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        com.xiaomi.push.ea eaVar = (com.xiaomi.push.ea) obj;
        if (!com.xiaomi.push.ea.class.equals(eaVar.getClass())) {
            return com.xiaomi.push.ea.class.getName().compareTo(com.xiaomi.push.ea.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(eaVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a10 = com.xiaomi.push.hx.a(this.a, eaVar.a)) != 0) {
            return a10;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(eaVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a9 = com.xiaomi.push.hx.a(this.b, eaVar.b)) != 0) {
            return a9;
        }
        int compareTo3 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(eaVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a8 = com.xiaomi.push.hx.a(this.c, eaVar.c)) != 0) {
            return a8;
        }
        int compareTo4 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(eaVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a7 = com.xiaomi.push.hx.a(this.d, eaVar.d)) != 0) {
            return a7;
        }
        int compareTo5 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(eaVar.h()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (h() && (a6 = com.xiaomi.push.hx.a(this.e, eaVar.e)) != 0) {
            return a6;
        }
        int compareTo6 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(eaVar.i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (i() && (a5 = com.xiaomi.push.hx.a(this.f, eaVar.f)) != 0) {
            return a5;
        }
        int compareTo7 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(eaVar.k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (k() && (a4 = com.xiaomi.push.hx.a(this.g, eaVar.g)) != 0) {
            return a4;
        }
        int compareTo8 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(eaVar.l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (l() && (a3 = com.xiaomi.push.hx.a(this.h, eaVar.h)) != 0) {
            return a3;
        }
        int compareTo9 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(eaVar.m()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m() && (a2 = com.xiaomi.push.hx.a(this.i, eaVar.i)) != 0) {
            return a2;
        }
        int compareTo10 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(eaVar.o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!o() || (a = com.xiaomi.push.hx.a(this.j, eaVar.j)) == 0) {
            return 0;
        }
        return a;
    }

    public final com.xiaomi.push.ea d(int i) {
        this.i = i;
        n();
        return this;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.ea)) {
            com.xiaomi.push.ea eaVar = (com.xiaomi.push.ea) obj;
            if (this.a != eaVar.a || this.b != eaVar.b || this.c != eaVar.c) {
                return false;
            }
            boolean g = g();
            boolean g2 = eaVar.g();
            if ((g || g2) && !(g && g2 && this.d.equals(eaVar.d))) {
                return false;
            }
            boolean h = h();
            boolean h2 = eaVar.h();
            if ((h || h2) && !(h && h2 && this.e.equals(eaVar.e))) {
                return false;
            }
            boolean i = i();
            boolean i2 = eaVar.i();
            if ((i || i2) && !(i && i2 && this.f == eaVar.f)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = eaVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.g.equals(eaVar.g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = eaVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.h.equals(eaVar.h))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = eaVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.i == eaVar.i)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = eaVar.o();
            if (o2 || o3) {
                return o2 && o3 && this.j == eaVar.j;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("connpt:");
        java.lang.String str = this.d;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (h()) {
            sb.append(", ");
            sb.append("host:");
            java.lang.String str2 = this.e;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("annotation:");
            java.lang.String str3 = this.g;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("user:");
            java.lang.String str4 = this.h;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
