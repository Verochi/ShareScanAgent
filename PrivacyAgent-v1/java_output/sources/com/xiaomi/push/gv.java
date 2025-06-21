package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gv implements com.xiaomi.push.hw<com.xiaomi.push.gv, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im h = new com.xiaomi.push.im("OnlineConfigItem");
    private static final com.xiaomi.push.ie i = new com.xiaomi.push.ie("", (byte) 8, 1);
    private static final com.xiaomi.push.ie j = new com.xiaomi.push.ie("", (byte) 8, 2);
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 2, 3);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 8, 4);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 10, 5);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 2, 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public java.lang.String f;
    public boolean g;
    private java.util.BitSet p = new java.util.BitSet(6);

    private boolean a() {
        return this.p.get(0);
    }

    private boolean b() {
        return this.p.get(1);
    }

    private boolean c() {
        return this.p.get(2);
    }

    private boolean d() {
        return this.p.get(3);
    }

    private boolean e() {
        return this.p.get(4);
    }

    private boolean f() {
        return this.f != null;
    }

    private boolean g() {
        return this.p.get(5);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        java.util.BitSet bitSet;
        int i2;
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 != 0) {
                switch (b.c) {
                    case 1:
                        if (b2 != 8) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.a = ihVar.i();
                            bitSet = this.p;
                            i2 = 0;
                            bitSet.set(i2, true);
                            break;
                        }
                    case 2:
                        if (b2 != 8) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.b = ihVar.i();
                            this.p.set(1, true);
                            break;
                        }
                    case 3:
                        if (b2 != 2) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.c = ihVar.f();
                            this.p.set(2, true);
                            break;
                        }
                    case 4:
                        if (b2 != 8) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.d = ihVar.i();
                            bitSet = this.p;
                            i2 = 3;
                            bitSet.set(i2, true);
                            break;
                        }
                    case 5:
                        if (b2 != 10) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.e = ihVar.j();
                            bitSet = this.p;
                            i2 = 4;
                            bitSet.set(i2, true);
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
                        if (b2 != 2) {
                            com.xiaomi.push.ik.a(ihVar, b2);
                            break;
                        } else {
                            this.g = ihVar.f();
                            bitSet = this.p;
                            i2 = 5;
                            bitSet.set(i2, true);
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

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        if (a()) {
            ihVar.a(i);
            ihVar.a(this.a);
        }
        if (b()) {
            ihVar.a(j);
            ihVar.a(this.b);
        }
        if (c()) {
            ihVar.a(k);
            ihVar.a(this.c);
        }
        if (d()) {
            ihVar.a(l);
            ihVar.a(this.d);
        }
        if (e()) {
            ihVar.a(m);
            ihVar.a(this.e);
        }
        if (this.f != null && f()) {
            ihVar.a(n);
            ihVar.a(this.f);
        }
        if (g()) {
            ihVar.a(o);
            ihVar.a(this.g);
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
        com.xiaomi.push.gv gvVar = (com.xiaomi.push.gv) obj;
        if (!com.xiaomi.push.gv.class.equals(gvVar.getClass())) {
            return com.xiaomi.push.gv.class.getName().compareTo(com.xiaomi.push.gv.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(gvVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a7 = com.xiaomi.push.hx.a(this.a, gvVar.a)) != 0) {
            return a7;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(gvVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = com.xiaomi.push.hx.a(this.b, gvVar.b)) != 0) {
            return a6;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = com.xiaomi.push.hx.a(this.c, gvVar.c)) != 0) {
            return a5;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(gvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = com.xiaomi.push.hx.a(this.d, gvVar.d)) != 0) {
            return a4;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(gvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = com.xiaomi.push.hx.a(this.e, gvVar.e)) != 0) {
            return a3;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(gvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a2 = com.xiaomi.push.hx.a(this.f, gvVar.f)) != 0) {
            return a2;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(gvVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a = com.xiaomi.push.hx.a(this.g, gvVar.g)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gv)) {
            com.xiaomi.push.gv gvVar = (com.xiaomi.push.gv) obj;
            boolean a = a();
            boolean a2 = gvVar.a();
            if ((a || a2) && !(a && a2 && this.a == gvVar.a)) {
                return false;
            }
            boolean b = b();
            boolean b2 = gvVar.b();
            if ((b || b2) && !(b && b2 && this.b == gvVar.b)) {
                return false;
            }
            boolean c = c();
            boolean c2 = gvVar.c();
            if ((c || c2) && !(c && c2 && this.c == gvVar.c)) {
                return false;
            }
            boolean d = d();
            boolean d2 = gvVar.d();
            if ((d || d2) && !(d && d2 && this.d == gvVar.d)) {
                return false;
            }
            boolean e = e();
            boolean e2 = gvVar.e();
            if ((e || e2) && !(e && e2 && this.e == gvVar.e)) {
                return false;
            }
            boolean f = f();
            boolean f2 = gvVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(gvVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = gvVar.g();
            if (g || g2) {
                return g && g2 && this.g == gvVar.g;
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (a()) {
            sb.append("key:");
            sb.append(this.a);
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z = false;
        }
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.c);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.d);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.e);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            java.lang.String str = this.f;
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (g()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.g);
        }
        sb.append(")");
        return sb.toString();
    }
}
