package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class go implements com.xiaomi.push.hw<com.xiaomi.push.go, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im l = new com.xiaomi.push.im("ClientUploadDataItem");
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 2);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 10, 4);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 10, 5);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 2, 6);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f470s = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 13, 10);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 11, 11);
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public long d;
    public long e;
    public boolean f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.util.Map<java.lang.String, java.lang.String> j;
    public java.lang.String k;
    private java.util.BitSet x = new java.util.BitSet(3);

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
        return this.x.get(0);
    }

    private void e() {
        this.x.set(0, true);
    }

    private boolean f() {
        return this.x.get(1);
    }

    private void g() {
        this.x.set(1, true);
    }

    private boolean h() {
        return this.x.get(2);
    }

    private void i() {
        this.x.set(2, true);
    }

    private boolean j() {
        return this.g != null;
    }

    private boolean k() {
        return this.h != null;
    }

    private boolean l() {
        return this.i != null;
    }

    private boolean m() {
        return this.j != null;
    }

    private boolean n() {
        return this.k != null;
    }

    public final com.xiaomi.push.go a(long j) {
        this.d = j;
        e();
        return this;
    }

    public final com.xiaomi.push.go a(boolean z) {
        this.f = z;
        i();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 != 0) {
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
                        if (b2 == 11) {
                            this.b = ihVar.l();
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
                        if (b2 == 10) {
                            this.d = ihVar.j();
                            e();
                            break;
                        } else {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        }
                    case 5:
                        if (b2 == 10) {
                            this.e = ihVar.j();
                            g();
                            break;
                        } else {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        }
                    case 6:
                        if (b2 == 2) {
                            this.f = ihVar.f();
                            i();
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
                        if (b2 == 11) {
                            this.h = ihVar.l();
                            break;
                        } else {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        }
                    case 9:
                        if (b2 == 11) {
                            this.i = ihVar.l();
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
                    default:
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                }
            } else {
                return;
            }
        }
    }

    public final com.xiaomi.push.go b(long j) {
        this.e = j;
        g();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        if (this.a != null && a()) {
            ihVar.a(m);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(n);
            ihVar.a(this.b);
        }
        if (this.c != null && c()) {
            ihVar.a(o);
            ihVar.a(this.c);
        }
        if (d()) {
            ihVar.a(p);
            ihVar.a(this.d);
        }
        if (f()) {
            ihVar.a(q);
            ihVar.a(this.e);
        }
        if (h()) {
            ihVar.a(r);
            ihVar.a(this.f);
        }
        if (this.g != null && j()) {
            ihVar.a(f470s);
            ihVar.a(this.g);
        }
        if (this.h != null && k()) {
            ihVar.a(t);
            ihVar.a(this.h);
        }
        if (this.i != null && l()) {
            ihVar.a(u);
            ihVar.a(this.i);
        }
        if (this.j != null && m()) {
            ihVar.a(v);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.j.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.j.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (this.k != null && n()) {
            ihVar.a(w);
            ihVar.a(this.k);
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
        com.xiaomi.push.go goVar = (com.xiaomi.push.go) obj;
        if (!com.xiaomi.push.go.class.equals(goVar.getClass())) {
            return com.xiaomi.push.go.class.getName().compareTo(com.xiaomi.push.go.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(goVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = com.xiaomi.push.hx.a(this.a, goVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(goVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = com.xiaomi.push.hx.a(this.b, goVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(goVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = com.xiaomi.push.hx.a(this.c, goVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(goVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = com.xiaomi.push.hx.a(this.d, goVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(goVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a7 = com.xiaomi.push.hx.a(this.e, goVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(goVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a6 = com.xiaomi.push.hx.a(this.f, goVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(goVar.j()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (j() && (a5 = com.xiaomi.push.hx.a(this.g, goVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(goVar.k()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (k() && (a4 = com.xiaomi.push.hx.a(this.h, goVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(goVar.l()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (l() && (a3 = com.xiaomi.push.hx.a(this.i, goVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(goVar.m()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m() && (a2 = com.xiaomi.push.hx.a(this.j, goVar.j)) != 0) {
            return a2;
        }
        int compareTo11 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(goVar.n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!n() || (a = com.xiaomi.push.hx.a(this.k, goVar.k)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.go)) {
            com.xiaomi.push.go goVar = (com.xiaomi.push.go) obj;
            boolean a = a();
            boolean a2 = goVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(goVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = goVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(goVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = goVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(goVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = goVar.d();
            if ((d || d2) && !(d && d2 && this.d == goVar.d)) {
                return false;
            }
            boolean f = f();
            boolean f2 = goVar.f();
            if ((f || f2) && !(f && f2 && this.e == goVar.e)) {
                return false;
            }
            boolean h = h();
            boolean h2 = goVar.h();
            if ((h || h2) && !(h && h2 && this.f == goVar.f)) {
                return false;
            }
            boolean j = j();
            boolean j2 = goVar.j();
            if ((j || j2) && !(j && j2 && this.g.equals(goVar.g))) {
                return false;
            }
            boolean k = k();
            boolean k2 = goVar.k();
            if ((k || k2) && !(k && k2 && this.h.equals(goVar.h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = goVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.i.equals(goVar.i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = goVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.j.equals(goVar.j))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = goVar.n();
            if (n2 || n3) {
                return n2 && n3 && this.k.equals(goVar.k);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (a()) {
            sb.append("channel:");
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
            sb.append("data:");
            java.lang.String str2 = this.b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            java.lang.String str3 = this.c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.d);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.e);
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f);
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            java.lang.String str4 = this.g;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            java.lang.String str5 = this.h;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (l()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            java.lang.String str6 = this.i;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (m()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            java.util.Map<java.lang.String, java.lang.String> map = this.j;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (n()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            java.lang.String str7 = this.k;
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
