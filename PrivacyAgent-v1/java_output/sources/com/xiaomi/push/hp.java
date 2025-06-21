package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hp implements com.xiaomi.push.hw<com.xiaomi.push.hp, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im i = new com.xiaomi.push.im("XmPushActionSubscription");
    private static final com.xiaomi.push.ie j = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 15, 8);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.util.List<java.lang.String> h;

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

    private void i() {
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d == null) {
            throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.e != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'topic' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                i();
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
                    if (b2 == 15) {
                        com.xiaomi.push.Cif d = ihVar.d();
                        this.h = new java.util.ArrayList(d.b);
                        for (int i2 = 0; i2 < d.b; i2++) {
                            this.h.add(ihVar.l());
                        }
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

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        i();
        if (this.a != null && a()) {
            ihVar.a(j);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(k);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(l);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(m);
            ihVar.a(this.d);
        }
        if (this.e != null) {
            ihVar.a(n);
            ihVar.a(this.e);
        }
        if (this.f != null && f()) {
            ihVar.a(o);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(p);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(q);
            ihVar.a(new com.xiaomi.push.Cif((byte) 11, this.h.size()));
            java.util.Iterator<java.lang.String> it = this.h.iterator();
            while (it.hasNext()) {
                ihVar.a(it.next());
            }
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
        com.xiaomi.push.hp hpVar = (com.xiaomi.push.hp) obj;
        if (!com.xiaomi.push.hp.class.equals(hpVar.getClass())) {
            return com.xiaomi.push.hp.class.getName().compareTo(com.xiaomi.push.hp.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hpVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a8 = com.xiaomi.push.hx.a(this.a, hpVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hpVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = com.xiaomi.push.hx.a(this.b, hpVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hpVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = com.xiaomi.push.hx.a(this.c, hpVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hpVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = com.xiaomi.push.hx.a(this.d, hpVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = com.xiaomi.push.hx.a(this.e, hpVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = com.xiaomi.push.hx.a(this.f, hpVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hpVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a2 = com.xiaomi.push.hx.a(this.g, hpVar.g)) != 0) {
            return a2;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hpVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a = com.xiaomi.push.hx.a(this.h, hpVar.h)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hp)) {
            com.xiaomi.push.hp hpVar = (com.xiaomi.push.hp) obj;
            boolean a = a();
            boolean a2 = hpVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(hpVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hpVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(hpVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hpVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hpVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hpVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(hpVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hpVar.e();
            if ((e || e2) && !(e && e2 && this.e.equals(hpVar.e))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hpVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hpVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hpVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(hpVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hpVar.h();
            if (h || h2) {
                return h && h2 && this.h.equals(hpVar.h);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionSubscription(");
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
        sb.append(", ");
        sb.append("topic:");
        java.lang.String str4 = this.e;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str5 = this.f;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str6 = this.g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            java.util.List<java.lang.String> list = this.h;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
