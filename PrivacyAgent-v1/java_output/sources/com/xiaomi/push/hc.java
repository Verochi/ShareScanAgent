package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hc implements com.xiaomi.push.hw<com.xiaomi.push.hc, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im k = new com.xiaomi.push.im("XmPushActionAckNotification");
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 10, 7);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 8);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f476s = new com.xiaomi.push.ie("", (byte) 13, 9);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 11);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String g;
    public java.util.Map<java.lang.String, java.lang.String> h;
    public java.lang.String i;
    public java.lang.String j;
    private java.util.BitSet v = new java.util.BitSet(1);
    public long f = 0;

    private boolean c() {
        return this.a != null;
    }

    private boolean d() {
        return this.b != null;
    }

    private boolean e() {
        return this.c != null;
    }

    private boolean f() {
        return this.d != null;
    }

    private boolean g() {
        return this.e != null;
    }

    private boolean h() {
        return this.v.get(0);
    }

    private boolean i() {
        return this.g != null;
    }

    private boolean j() {
        return this.h != null;
    }

    private boolean k() {
        return this.i != null;
    }

    private boolean l() {
        return this.j != null;
    }

    private void m() {
        if (this.c != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.hc a() {
        this.f = 0L;
        b();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                m();
                return;
            }
            switch (b.c) {
                case 1:
                    if (b2 == 11) {
                        this.a = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                        this.b = gzVar;
                        gzVar.a(ihVar);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.c = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.d = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.e = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 6:
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f = ihVar.j();
                        b();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.g = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 13) {
                        com.xiaomi.push.ig c = ihVar.c();
                        this.h = new java.util.HashMap(c.c * 2);
                        for (int i = 0; i < c.c; i++) {
                            this.h.put(ihVar.l(), ihVar.l());
                        }
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.i = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.j = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
            }
        }
    }

    public final void b() {
        this.v.set(0, true);
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        m();
        if (this.a != null && c()) {
            ihVar.a(l);
            ihVar.a(this.a);
        }
        if (this.b != null && d()) {
            ihVar.a(m);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(n);
            ihVar.a(this.c);
        }
        if (this.d != null && f()) {
            ihVar.a(o);
            ihVar.a(this.d);
        }
        if (this.e != null && g()) {
            ihVar.a(p);
            ihVar.a(this.e);
        }
        if (h()) {
            ihVar.a(q);
            ihVar.a(this.f);
        }
        if (this.g != null && i()) {
            ihVar.a(r);
            ihVar.a(this.g);
        }
        if (this.h != null && j()) {
            ihVar.a(f476s);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.h.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.h.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (this.i != null && k()) {
            ihVar.a(t);
            ihVar.a(this.i);
        }
        if (this.j != null && l()) {
            ihVar.a(u);
            ihVar.a(this.j);
        }
        ihVar.a();
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
        com.xiaomi.push.hc hcVar = (com.xiaomi.push.hc) obj;
        if (!com.xiaomi.push.hc.class.equals(hcVar.getClass())) {
            return com.xiaomi.push.hc.class.getName().compareTo(com.xiaomi.push.hc.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hcVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c() && (a10 = com.xiaomi.push.hx.a(this.a, hcVar.a)) != 0) {
            return a10;
        }
        int compareTo2 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hcVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (d() && (a9 = com.xiaomi.push.hx.a(this.b, hcVar.b)) != 0) {
            return a9;
        }
        int compareTo3 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hcVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a8 = com.xiaomi.push.hx.a(this.c, hcVar.c)) != 0) {
            return a8;
        }
        int compareTo4 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hcVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a7 = com.xiaomi.push.hx.a(this.d, hcVar.d)) != 0) {
            return a7;
        }
        int compareTo5 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hcVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a6 = com.xiaomi.push.hx.a(this.e, hcVar.e)) != 0) {
            return a6;
        }
        int compareTo6 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hcVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a5 = com.xiaomi.push.hx.a(this.f, hcVar.f)) != 0) {
            return a5;
        }
        int compareTo7 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hcVar.i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (i() && (a4 = com.xiaomi.push.hx.a(this.g, hcVar.g)) != 0) {
            return a4;
        }
        int compareTo8 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hcVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a3 = com.xiaomi.push.hx.a(this.h, hcVar.h)) != 0) {
            return a3;
        }
        int compareTo9 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hcVar.k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (k() && (a2 = com.xiaomi.push.hx.a(this.i, hcVar.i)) != 0) {
            return a2;
        }
        int compareTo10 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hcVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!l() || (a = com.xiaomi.push.hx.a(this.j, hcVar.j)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hc)) {
            com.xiaomi.push.hc hcVar = (com.xiaomi.push.hc) obj;
            boolean c = c();
            boolean c2 = hcVar.c();
            if ((c || c2) && !(c && c2 && this.a.equals(hcVar.a))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hcVar.d();
            if ((d || d2) && !(d && d2 && this.b.a(hcVar.b))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hcVar.e();
            if ((e || e2) && !(e && e2 && this.c.equals(hcVar.c))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hcVar.f();
            if ((f || f2) && !(f && f2 && this.d.equals(hcVar.d))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hcVar.g();
            if ((g || g2) && !(g && g2 && this.e.equals(hcVar.e))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hcVar.h();
            if ((h || h2) && !(h && h2 && this.f == hcVar.f)) {
                return false;
            }
            boolean i = i();
            boolean i2 = hcVar.i();
            if ((i || i2) && !(i && i2 && this.g.equals(hcVar.g))) {
                return false;
            }
            boolean j = j();
            boolean j2 = hcVar.j();
            if ((j || j2) && !(j && j2 && this.h.equals(hcVar.h))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hcVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.i.equals(hcVar.i))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hcVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.j.equals(hcVar.j);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (c()) {
            sb.append("debug:");
            java.lang.String str = this.a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            com.xiaomi.push.gz gzVar = this.b;
            if (gzVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gzVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appId:");
            java.lang.String str3 = this.d;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("type:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f);
        }
        if (i()) {
            sb.append(", ");
            sb.append("reason:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            java.util.Map<java.lang.String, java.lang.String> map = this.h;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str6 = this.i;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str7 = this.j;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
