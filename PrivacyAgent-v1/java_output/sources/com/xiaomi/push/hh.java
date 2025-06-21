package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hh implements com.xiaomi.push.hw<com.xiaomi.push.hh, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im i = new com.xiaomi.push.im("XmPushActionContainer");
    private static final com.xiaomi.push.ie j = new com.xiaomi.push.ie("", (byte) 8, 1);
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 2, 2);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 2, 3);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 6);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 12, 7);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 12, 8);
    public com.xiaomi.push.gk a;
    public java.nio.ByteBuffer d;
    public java.lang.String e;
    public java.lang.String f;
    public com.xiaomi.push.gz g;
    public com.xiaomi.push.gx h;
    private java.util.BitSet r = new java.util.BitSet(2);
    public boolean b = true;
    public boolean c = true;

    private boolean b() {
        return this.a != null;
    }

    private boolean c() {
        return this.r.get(0);
    }

    private void d() {
        this.r.set(0, true);
    }

    private boolean e() {
        return this.r.get(1);
    }

    private void f() {
        this.r.set(1, true);
    }

    private boolean g() {
        return this.d != null;
    }

    private boolean h() {
        return this.e != null;
    }

    private boolean i() {
        return this.f != null;
    }

    private boolean j() {
        return this.g != null;
    }

    private boolean k() {
        return this.h != null;
    }

    private void l() {
        if (this.a == null) {
            throw new com.xiaomi.push.ii("Required field 'action' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d == null) {
            throw new com.xiaomi.push.ii("Required field 'pushAction' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.g != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'target' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.hh a(boolean z) {
        this.b = z;
        d();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                if (!c()) {
                    throw new com.xiaomi.push.ii("Required field 'encryptAction' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                if (e()) {
                    l();
                    return;
                } else {
                    throw new com.xiaomi.push.ii("Required field 'isRequest' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
            }
            switch (b.c) {
                case 1:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.a = com.xiaomi.push.gk.a(ihVar.i());
                        break;
                    }
                case 2:
                    if (b2 != 2) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.b = ihVar.f();
                        d();
                        break;
                    }
                case 3:
                    if (b2 != 2) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.c = ihVar.f();
                        f();
                        break;
                    }
                case 4:
                    if (b2 != 11) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.d = ihVar.m();
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
                    if (b2 != 12) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                        this.g = gzVar;
                        gzVar.a(ihVar);
                        break;
                    }
                case 8:
                    if (b2 != 12) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.gx gxVar = new com.xiaomi.push.gx();
                        this.h = gxVar;
                        gxVar.a(ihVar);
                        break;
                    }
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
            }
        }
    }

    public final byte[] a() {
        java.nio.ByteBuffer a = com.xiaomi.push.hx.a(this.d);
        this.d = a;
        return a.array();
    }

    public final com.xiaomi.push.hh b(boolean z) {
        this.c = z;
        f();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        l();
        if (this.a != null) {
            ihVar.a(j);
            ihVar.a(this.a.L);
        }
        ihVar.a(k);
        ihVar.a(this.b);
        ihVar.a(l);
        ihVar.a(this.c);
        if (this.d != null) {
            ihVar.a(m);
            ihVar.a(this.d);
        }
        if (this.e != null && h()) {
            ihVar.a(n);
            ihVar.a(this.e);
        }
        if (this.f != null && i()) {
            ihVar.a(o);
            ihVar.a(this.f);
        }
        if (this.g != null) {
            ihVar.a(p);
            this.g.b(ihVar);
        }
        if (this.h != null && k()) {
            ihVar.a(q);
            this.h.b(ihVar);
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
        com.xiaomi.push.hh hhVar = (com.xiaomi.push.hh) obj;
        if (!com.xiaomi.push.hh.class.equals(hhVar.getClass())) {
            return com.xiaomi.push.hh.class.getName().compareTo(com.xiaomi.push.hh.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hhVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a8 = com.xiaomi.push.hx.a(this.a, hhVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hhVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a7 = com.xiaomi.push.hx.a(this.b, hhVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hhVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a6 = com.xiaomi.push.hx.a(this.c, hhVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hhVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a5 = com.xiaomi.push.hx.a(this.d, hhVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hhVar.h()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (h() && (a4 = com.xiaomi.push.hx.a(this.e, hhVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hhVar.i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (i() && (a3 = com.xiaomi.push.hx.a(this.f, hhVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hhVar.j()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (j() && (a2 = com.xiaomi.push.hx.a(this.g, hhVar.g)) != 0) {
            return a2;
        }
        int compareTo8 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hhVar.k()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!k() || (a = com.xiaomi.push.hx.a(this.h, hhVar.h)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hh)) {
            com.xiaomi.push.hh hhVar = (com.xiaomi.push.hh) obj;
            boolean b = b();
            boolean b2 = hhVar.b();
            if (((b || b2) && (!b || !b2 || !this.a.equals(hhVar.a))) || this.b != hhVar.b || this.c != hhVar.c) {
                return false;
            }
            boolean g = g();
            boolean g2 = hhVar.g();
            if ((g || g2) && !(g && g2 && this.d.equals(hhVar.d))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hhVar.h();
            if ((h || h2) && !(h && h2 && this.e.equals(hhVar.e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hhVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f.equals(hhVar.f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hhVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.g.a(hhVar.g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hhVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.h.a(hhVar.h);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        com.xiaomi.push.gk gkVar = this.a;
        if (gkVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(gkVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("pushAction:");
        java.nio.ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            com.xiaomi.push.hx.a(byteBuffer, sb);
        }
        if (h()) {
            sb.append(", ");
            sb.append("appid:");
            java.lang.String str = this.e;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            java.lang.String str2 = this.f;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        com.xiaomi.push.gz gzVar = this.g;
        if (gzVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(gzVar);
        }
        if (k()) {
            sb.append(", ");
            sb.append("metaInfo:");
            com.xiaomi.push.gx gxVar = this.h;
            if (gxVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gxVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
