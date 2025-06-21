package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hq implements com.xiaomi.push.hw<com.xiaomi.push.hq, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im j = new com.xiaomi.push.im("XmPushActionSubscriptionResult");
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 10, 6);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 8);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 9);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f483s = new com.xiaomi.push.ie("", (byte) 11, 10);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public long e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    private java.util.BitSet t = new java.util.BitSet(1);

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
        return this.t.get(0);
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

    private void j() {
        if (this.c != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                j();
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
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 6:
                    if (b2 != 10) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.e = ihVar.j();
                        this.t.set(0, true);
                        break;
                    }
                case 7:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.f = ihVar.l();
                        break;
                    }
                case 8:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.g = ihVar.l();
                        break;
                    }
                case 9:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.h = ihVar.l();
                        break;
                    }
                case 10:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.i = ihVar.l();
                        break;
                    }
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        j();
        if (this.a != null && a()) {
            ihVar.a(k);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(l);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(m);
            ihVar.a(this.c);
        }
        if (this.d != null && d()) {
            ihVar.a(n);
            ihVar.a(this.d);
        }
        if (e()) {
            ihVar.a(o);
            ihVar.a(this.e);
        }
        if (this.f != null && f()) {
            ihVar.a(p);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(q);
            ihVar.a(this.g);
        }
        if (this.h != null && h()) {
            ihVar.a(r);
            ihVar.a(this.h);
        }
        if (this.i != null && i()) {
            ihVar.a(f483s);
            ihVar.a(this.i);
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
        com.xiaomi.push.hq hqVar = (com.xiaomi.push.hq) obj;
        if (!com.xiaomi.push.hq.class.equals(hqVar.getClass())) {
            return com.xiaomi.push.hq.class.getName().compareTo(com.xiaomi.push.hq.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hqVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a9 = com.xiaomi.push.hx.a(this.a, hqVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hqVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = com.xiaomi.push.hx.a(this.b, hqVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hqVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = com.xiaomi.push.hx.a(this.c, hqVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = com.xiaomi.push.hx.a(this.d, hqVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = com.xiaomi.push.hx.a(this.e, hqVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = com.xiaomi.push.hx.a(this.f, hqVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hqVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = com.xiaomi.push.hx.a(this.g, hqVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hqVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a2 = com.xiaomi.push.hx.a(this.h, hqVar.h)) != 0) {
            return a2;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hqVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a = com.xiaomi.push.hx.a(this.i, hqVar.i)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hq)) {
            com.xiaomi.push.hq hqVar = (com.xiaomi.push.hq) obj;
            boolean a = a();
            boolean a2 = hqVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(hqVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hqVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(hqVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hqVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hqVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hqVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(hqVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hqVar.e();
            if ((e || e2) && !(e && e2 && this.e == hqVar.e)) {
                return false;
            }
            boolean f = f();
            boolean f2 = hqVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hqVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hqVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(hqVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hqVar.h();
            if ((h || h2) && !(h && h2 && this.h.equals(hqVar.h))) {
                return false;
            }
            boolean i = i();
            boolean i2 = hqVar.i();
            if (i || i2) {
                return i && i2 && this.i.equals(hqVar.i);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionSubscriptionResult(");
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
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            java.lang.String str3 = this.d;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            java.lang.String str4 = this.f;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str6 = this.h;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            java.lang.String str7 = this.i;
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
