package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ho implements com.xiaomi.push.hw<com.xiaomi.push.ho, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im m = new com.xiaomi.push.im("XmPushActionSendMessage");
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 5);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f482s = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 12, 8);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 2, 9);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 13, 10);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 11, 11);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 11, 12);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public com.xiaomi.push.gw h;
    public java.util.Map<java.lang.String, java.lang.String> j;
    public java.lang.String k;
    public java.lang.String l;
    private java.util.BitSet z = new java.util.BitSet(1);
    public boolean i = true;

    private boolean a() {
        return this.a != null;
    }

    private boolean b() {
        return this.b != null;
    }

    private boolean c() {
        return this.c != null;
    }

    private boolean d() {
        return this.d != null;
    }

    private boolean e() {
        return this.e != null;
    }

    private boolean f() {
        return this.f != null;
    }

    private boolean g() {
        return this.g != null;
    }

    private boolean h() {
        return this.h != null;
    }

    private boolean i() {
        return this.z.get(0);
    }

    private void j() {
        this.z.set(0, true);
    }

    private boolean k() {
        return this.j != null;
    }

    private boolean l() {
        return this.k != null;
    }

    private boolean m() {
        return this.l != null;
    }

    private void n() {
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                n();
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
                    if (b2 == 11) {
                        this.f = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.g = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        com.xiaomi.push.gw gwVar = new com.xiaomi.push.gw();
                        this.h = gwVar;
                        gwVar.a(ihVar);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 2) {
                        this.i = ihVar.f();
                        j();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        com.xiaomi.push.ig c = ihVar.c();
                        this.j = new java.util.HashMap(c.c * 2);
                        for (int i = 0; i < c.c; i++) {
                            this.j.put(ihVar.l(), ihVar.l());
                        }
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.k = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.l = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
            }
        }
    }

    public final boolean a(com.xiaomi.push.ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hoVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hoVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hoVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hoVar.b))) {
            return false;
        }
        boolean c = c();
        boolean c2 = hoVar.c();
        if ((c || c2) && !(c && c2 && this.c.equals(hoVar.c))) {
            return false;
        }
        boolean d = d();
        boolean d2 = hoVar.d();
        if ((d || d2) && !(d && d2 && this.d.equals(hoVar.d))) {
            return false;
        }
        boolean e = e();
        boolean e2 = hoVar.e();
        if ((e || e2) && !(e && e2 && this.e.equals(hoVar.e))) {
            return false;
        }
        boolean f = f();
        boolean f2 = hoVar.f();
        if ((f || f2) && !(f && f2 && this.f.equals(hoVar.f))) {
            return false;
        }
        boolean g = g();
        boolean g2 = hoVar.g();
        if ((g || g2) && !(g && g2 && this.g.equals(hoVar.g))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hoVar.h();
        if ((h || h2) && !(h && h2 && this.h.a(hoVar.h))) {
            return false;
        }
        boolean i = i();
        boolean i2 = hoVar.i();
        if ((i || i2) && !(i && i2 && this.i == hoVar.i)) {
            return false;
        }
        boolean k = k();
        boolean k2 = hoVar.k();
        if ((k || k2) && !(k && k2 && this.j.equals(hoVar.j))) {
            return false;
        }
        boolean l = l();
        boolean l2 = hoVar.l();
        if ((l || l2) && !(l && l2 && this.k.equals(hoVar.k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hoVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.l.equals(hoVar.l);
        }
        return true;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        n();
        if (this.a != null && a()) {
            ihVar.a(n);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(o);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(p);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(q);
            ihVar.a(this.d);
        }
        if (this.e != null && e()) {
            ihVar.a(r);
            ihVar.a(this.e);
        }
        if (this.f != null && f()) {
            ihVar.a(f482s);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(t);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(u);
            this.h.b(ihVar);
        }
        if (i()) {
            ihVar.a(v);
            ihVar.a(this.i);
        }
        if (this.j != null && k()) {
            ihVar.a(w);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.j.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.j.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (this.k != null && l()) {
            ihVar.a(x);
            ihVar.a(this.k);
        }
        if (this.l != null && m()) {
            ihVar.a(y);
            ihVar.a(this.l);
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
        int a11;
        int a12;
        com.xiaomi.push.ho hoVar = (com.xiaomi.push.ho) obj;
        if (!com.xiaomi.push.ho.class.equals(hoVar.getClass())) {
            return com.xiaomi.push.ho.class.getName().compareTo(com.xiaomi.push.ho.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hoVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a12 = com.xiaomi.push.hx.a(this.a, hoVar.a)) != 0) {
            return a12;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hoVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a11 = com.xiaomi.push.hx.a(this.b, hoVar.b)) != 0) {
            return a11;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hoVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a10 = com.xiaomi.push.hx.a(this.c, hoVar.c)) != 0) {
            return a10;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hoVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a9 = com.xiaomi.push.hx.a(this.d, hoVar.d)) != 0) {
            return a9;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hoVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a8 = com.xiaomi.push.hx.a(this.e, hoVar.e)) != 0) {
            return a8;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hoVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = com.xiaomi.push.hx.a(this.f, hoVar.f)) != 0) {
            return a7;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hoVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = com.xiaomi.push.hx.a(this.g, hoVar.g)) != 0) {
            return a6;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hoVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = com.xiaomi.push.hx.a(this.h, hoVar.h)) != 0) {
            return a5;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hoVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = com.xiaomi.push.hx.a(this.i, hoVar.i)) != 0) {
            return a4;
        }
        int compareTo10 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hoVar.k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (k() && (a3 = com.xiaomi.push.hx.a(this.j, hoVar.j)) != 0) {
            return a3;
        }
        int compareTo11 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hoVar.l()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (l() && (a2 = com.xiaomi.push.hx.a(this.k, hoVar.k)) != 0) {
            return a2;
        }
        int compareTo12 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(hoVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!m() || (a = com.xiaomi.push.hx.a(this.l, hoVar.l)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.ho)) {
            return a((com.xiaomi.push.ho) obj);
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (a()) {
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
        if (b()) {
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
        sb.append(", ");
        sb.append("appId:");
        java.lang.String str3 = this.d;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            java.lang.String str5 = this.f;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str6 = this.g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            com.xiaomi.push.gw gwVar = this.h;
            if (gwVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gwVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.i);
        }
        if (k()) {
            sb.append(", ");
            sb.append("params:");
            java.util.Map<java.lang.String, java.lang.String> map = this.j;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str7 = this.k;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("userAccount:");
            java.lang.String str8 = this.l;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
