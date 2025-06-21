package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hn implements com.xiaomi.push.hw<com.xiaomi.push.hn, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im h = new com.xiaomi.push.im("XmPushActionSendFeedbackResult");
    private static final com.xiaomi.push.ie i = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie j = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 10, 6);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 8);
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public long e;
    public java.lang.String f;
    public java.lang.String g;
    private java.util.BitSet p = new java.util.BitSet(1);

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
        return this.p.get(0);
    }

    private boolean f() {
        return this.f != null;
    }

    private boolean g() {
        return this.g != null;
    }

    private void h() {
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
                if (e()) {
                    h();
                    return;
                } else {
                    throw new com.xiaomi.push.ii("Required field 'errorCode' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
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
                        this.p.set(0, true);
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
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        h();
        if (this.a != null && a()) {
            ihVar.a(i);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(j);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(k);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(l);
            ihVar.a(this.d);
        }
        ihVar.a(m);
        ihVar.a(this.e);
        if (this.f != null && f()) {
            ihVar.a(n);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
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
        com.xiaomi.push.hn hnVar = (com.xiaomi.push.hn) obj;
        if (!com.xiaomi.push.hn.class.equals(hnVar.getClass())) {
            return com.xiaomi.push.hn.class.getName().compareTo(com.xiaomi.push.hn.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hnVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a7 = com.xiaomi.push.hx.a(this.a, hnVar.a)) != 0) {
            return a7;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = com.xiaomi.push.hx.a(this.b, hnVar.b)) != 0) {
            return a6;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = com.xiaomi.push.hx.a(this.c, hnVar.c)) != 0) {
            return a5;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hnVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = com.xiaomi.push.hx.a(this.d, hnVar.d)) != 0) {
            return a4;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hnVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = com.xiaomi.push.hx.a(this.e, hnVar.e)) != 0) {
            return a3;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a2 = com.xiaomi.push.hx.a(this.f, hnVar.f)) != 0) {
            return a2;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hnVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a = com.xiaomi.push.hx.a(this.g, hnVar.g)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hn)) {
            com.xiaomi.push.hn hnVar = (com.xiaomi.push.hn) obj;
            boolean a = a();
            boolean a2 = hnVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(hnVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hnVar.b();
            if ((b || b2) && !(b && b2 && this.b.a(hnVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hnVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hnVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hnVar.d();
            if (((d || d2) && !(d && d2 && this.d.equals(hnVar.d))) || this.e != hnVar.e) {
                return false;
            }
            boolean f = f();
            boolean f2 = hnVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hnVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hnVar.g();
            if (g || g2) {
                return g && g2 && this.g.equals(hnVar.g);
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionSendFeedbackResult(");
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
        sb.append("errorCode:");
        sb.append(this.e);
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
            sb.append("category:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
