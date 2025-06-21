package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gz implements com.xiaomi.push.hw<com.xiaomi.push.gz, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im g = new com.xiaomi.push.im("Target");
    private static final com.xiaomi.push.ie h = new com.xiaomi.push.ie("", (byte) 10, 1);
    private static final com.xiaomi.push.ie i = new com.xiaomi.push.ie("", (byte) 11, 2);
    private static final com.xiaomi.push.ie j = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie k = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 2, 5);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 7);
    public java.lang.String b;
    public java.lang.String f;
    private java.util.BitSet n = new java.util.BitSet(2);
    public long a = 5;
    public java.lang.String c = "xiaomi.com";
    public java.lang.String d = "";
    public boolean e = false;

    private boolean a() {
        return this.n.get(0);
    }

    private void b() {
        this.n.set(0, true);
    }

    private boolean c() {
        return this.b != null;
    }

    private boolean d() {
        return this.c != null;
    }

    private boolean e() {
        return this.d != null;
    }

    private boolean f() {
        return this.n.get(1);
    }

    private void g() {
        this.n.set(1, true);
    }

    private boolean h() {
        return this.f != null;
    }

    private void i() {
        if (this.b != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'userId' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                break;
            }
            short s2 = b.c;
            if (s2 != 1) {
                if (s2 != 2) {
                    if (s2 != 3) {
                        if (s2 != 4) {
                            if (s2 != 5) {
                                if (s2 == 7 && b2 == 11) {
                                    this.f = ihVar.l();
                                }
                                com.xiaomi.push.ik.a(ihVar, b2);
                            } else if (b2 == 2) {
                                this.e = ihVar.f();
                                g();
                            } else {
                                com.xiaomi.push.ik.a(ihVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.d = ihVar.l();
                        } else {
                            com.xiaomi.push.ik.a(ihVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.c = ihVar.l();
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                    }
                } else if (b2 == 11) {
                    this.b = ihVar.l();
                } else {
                    com.xiaomi.push.ik.a(ihVar, b2);
                }
            } else if (b2 == 10) {
                this.a = ihVar.j();
                b();
            } else {
                com.xiaomi.push.ik.a(ihVar, b2);
            }
        }
        if (a()) {
            i();
        } else {
            throw new com.xiaomi.push.ii("Required field 'channelId' was not found in serialized data! Struct: " + toString(), (byte) 0);
        }
    }

    public final boolean a(com.xiaomi.push.gz gzVar) {
        if (gzVar == null || this.a != gzVar.a) {
            return false;
        }
        boolean c = c();
        boolean c2 = gzVar.c();
        if ((c || c2) && !(c && c2 && this.b.equals(gzVar.b))) {
            return false;
        }
        boolean d = d();
        boolean d2 = gzVar.d();
        if ((d || d2) && !(d && d2 && this.c.equals(gzVar.c))) {
            return false;
        }
        boolean e = e();
        boolean e2 = gzVar.e();
        if ((e || e2) && !(e && e2 && this.d.equals(gzVar.d))) {
            return false;
        }
        boolean f = f();
        boolean f2 = gzVar.f();
        if ((f || f2) && !(f && f2 && this.e == gzVar.e)) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gzVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f.equals(gzVar.f);
        }
        return true;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        i();
        ihVar.a(h);
        ihVar.a(this.a);
        if (this.b != null) {
            ihVar.a(i);
            ihVar.a(this.b);
        }
        if (this.c != null && d()) {
            ihVar.a(j);
            ihVar.a(this.c);
        }
        if (this.d != null && e()) {
            ihVar.a(k);
            ihVar.a(this.d);
        }
        if (f()) {
            ihVar.a(l);
            ihVar.a(this.e);
        }
        if (this.f != null && h()) {
            ihVar.a(m);
            ihVar.a(this.f);
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
        com.xiaomi.push.gz gzVar = (com.xiaomi.push.gz) obj;
        if (!com.xiaomi.push.gz.class.equals(gzVar.getClass())) {
            return com.xiaomi.push.gz.class.getName().compareTo(com.xiaomi.push.gz.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(gzVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a6 = com.xiaomi.push.hx.a(this.a, gzVar.a)) != 0) {
            return a6;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gzVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a5 = com.xiaomi.push.hx.a(this.b, gzVar.b)) != 0) {
            return a5;
        }
        int compareTo3 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(gzVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a4 = com.xiaomi.push.hx.a(this.c, gzVar.c)) != 0) {
            return a4;
        }
        int compareTo4 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(gzVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a3 = com.xiaomi.push.hx.a(this.d, gzVar.d)) != 0) {
            return a3;
        }
        int compareTo5 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(gzVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a2 = com.xiaomi.push.hx.a(this.e, gzVar.e)) != 0) {
            return a2;
        }
        int compareTo6 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(gzVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!h() || (a = com.xiaomi.push.hx.a(this.f, gzVar.f)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gz)) {
            return a((com.xiaomi.push.gz) obj);
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("userId:");
        java.lang.String str = this.b;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (d()) {
            sb.append(", ");
            sb.append("server:");
            java.lang.String str2 = this.c;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("resource:");
            java.lang.String str3 = this.d;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.e);
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            java.lang.String str4 = this.f;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
