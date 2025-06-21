package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hr implements com.xiaomi.push.hw<com.xiaomi.push.hr, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im m = new com.xiaomi.push.im("XmPushActionUnRegistration");
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 5);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f484s = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 2, 11);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 10, 12);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public long l;
    private java.util.BitSet z = new java.util.BitSet(2);
    public boolean k = true;

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
        return this.i != null;
    }

    private boolean j() {
        return this.j != null;
    }

    private boolean k() {
        return this.z.get(0);
    }

    private boolean l() {
        return this.z.get(1);
    }

    private void m() {
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
                m();
                return;
            }
            switch (b.c) {
                case 1:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.a = ihVar.l();
                        break;
                    }
                case 2:
                    if (b2 != 12) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                        this.b = gzVar;
                        gzVar.a(ihVar);
                        break;
                    }
                case 3:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.c = ihVar.l();
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
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.f = ihVar.l();
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
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.i = ihVar.l();
                        break;
                    }
                case 10:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.j = ihVar.l();
                        break;
                    }
                case 11:
                    if (b2 != 2) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.k = ihVar.f();
                        this.z.set(0, true);
                        break;
                    }
                case 12:
                    if (b2 != 10) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.l = ihVar.j();
                        this.z.set(1, true);
                        break;
                    }
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        m();
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
            ihVar.a(f484s);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(t);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(u);
            ihVar.a(this.h);
        }
        if (this.i != null && i()) {
            ihVar.a(v);
            ihVar.a(this.i);
        }
        if (this.j != null && j()) {
            ihVar.a(w);
            ihVar.a(this.j);
        }
        if (k()) {
            ihVar.a(x);
            ihVar.a(this.k);
        }
        if (l()) {
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
        com.xiaomi.push.hr hrVar = (com.xiaomi.push.hr) obj;
        if (!com.xiaomi.push.hr.class.equals(hrVar.getClass())) {
            return com.xiaomi.push.hr.class.getName().compareTo(com.xiaomi.push.hr.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hrVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a12 = com.xiaomi.push.hx.a(this.a, hrVar.a)) != 0) {
            return a12;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hrVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a11 = com.xiaomi.push.hx.a(this.b, hrVar.b)) != 0) {
            return a11;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hrVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a10 = com.xiaomi.push.hx.a(this.c, hrVar.c)) != 0) {
            return a10;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hrVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a9 = com.xiaomi.push.hx.a(this.d, hrVar.d)) != 0) {
            return a9;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hrVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a8 = com.xiaomi.push.hx.a(this.e, hrVar.e)) != 0) {
            return a8;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hrVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = com.xiaomi.push.hx.a(this.f, hrVar.f)) != 0) {
            return a7;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hrVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = com.xiaomi.push.hx.a(this.g, hrVar.g)) != 0) {
            return a6;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hrVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = com.xiaomi.push.hx.a(this.h, hrVar.h)) != 0) {
            return a5;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hrVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = com.xiaomi.push.hx.a(this.i, hrVar.i)) != 0) {
            return a4;
        }
        int compareTo10 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hrVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = com.xiaomi.push.hx.a(this.j, hrVar.j)) != 0) {
            return a3;
        }
        int compareTo11 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hrVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a2 = com.xiaomi.push.hx.a(this.k, hrVar.k)) != 0) {
            return a2;
        }
        int compareTo12 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hrVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a = com.xiaomi.push.hx.a(this.l, hrVar.l)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hr)) {
            com.xiaomi.push.hr hrVar = (com.xiaomi.push.hr) obj;
            boolean a = a();
            boolean a2 = hrVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(hrVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hrVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(hrVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hrVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hrVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hrVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(hrVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hrVar.e();
            if ((e || e2) && !(e && e2 && this.e.equals(hrVar.e))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hrVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hrVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hrVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(hrVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hrVar.h();
            if ((h || h2) && !(h && h2 && this.h.equals(hrVar.h))) {
                return false;
            }
            boolean i = i();
            boolean i2 = hrVar.i();
            if ((i || i2) && !(i && i2 && this.i.equals(hrVar.i))) {
                return false;
            }
            boolean j = j();
            boolean j2 = hrVar.j();
            if ((j || j2) && !(j && j2 && this.j.equals(hrVar.j))) {
                return false;
            }
            boolean k = k();
            boolean k2 = hrVar.k();
            if ((k || k2) && !(k && k2 && this.k == hrVar.k)) {
                return false;
            }
            boolean l = l();
            boolean l2 = hrVar.l();
            if (l || l2) {
                return l && l2 && this.l == hrVar.l;
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionUnRegistration(");
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
            sb.append("regId:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            java.lang.String str5 = this.f;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str6 = this.g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            java.lang.String str7 = this.h;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            java.lang.String str8 = this.i;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str9 = this.j;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.l);
        }
        sb.append(")");
        return sb.toString();
    }
}
