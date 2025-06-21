package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hk implements com.xiaomi.push.hw<com.xiaomi.push.hk, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private java.util.BitSet F;
    public java.lang.String a;
    public com.xiaomi.push.gz b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public boolean f;
    public java.lang.String g;
    public java.util.Map<java.lang.String, java.lang.String> h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public java.nio.ByteBuffer m;
    public long n;
    public boolean o;
    private static final com.xiaomi.push.im p = new com.xiaomi.push.im("XmPushActionNotification");
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 12, 2);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f479s = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 2, 6);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 13, 8);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 11, 9);
    private static final com.xiaomi.push.ie z = new com.xiaomi.push.ie("", (byte) 11, 10);
    private static final com.xiaomi.push.ie A = new com.xiaomi.push.ie("", (byte) 11, 12);
    private static final com.xiaomi.push.ie B = new com.xiaomi.push.ie("", (byte) 11, 13);
    private static final com.xiaomi.push.ie C = new com.xiaomi.push.ie("", (byte) 11, 14);
    private static final com.xiaomi.push.ie D = new com.xiaomi.push.ie("", (byte) 10, 15);
    private static final com.xiaomi.push.ie E = new com.xiaomi.push.ie("", (byte) 2, 20);

    public hk() {
        this.F = new java.util.BitSet(3);
        this.f = true;
        this.o = false;
    }

    public hk(java.lang.String str, boolean z2) {
        this();
        this.c = str;
        this.f = z2;
        h();
    }

    private boolean b() {
        return this.a != null;
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
        return this.e != null;
    }

    private boolean g() {
        return this.F.get(0);
    }

    private void h() {
        this.F.set(0, true);
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

    private boolean m() {
        return this.k != null;
    }

    private boolean n() {
        return this.l != null;
    }

    private boolean o() {
        return this.m != null;
    }

    private boolean p() {
        return this.F.get(1);
    }

    private boolean q() {
        return this.F.get(2);
    }

    private void r() {
        if (this.c != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.hk a(boolean z2) {
        this.f = z2;
        h();
        return this;
    }

    public final com.xiaomi.push.hk a(byte[] bArr) {
        this.m = java.nio.ByteBuffer.wrap(bArr);
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                if (!g()) {
                    throw new com.xiaomi.push.ii("Required field 'requireAck' was not found in serialized data! Struct: " + toString(), (byte) 0);
                }
                r();
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
                    if (b2 == 2) {
                        this.f = ihVar.f();
                        h();
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
                case 9:
                    if (b2 == 11) {
                        this.i = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.j = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 12:
                    if (b2 == 11) {
                        this.k = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.l = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.m = ihVar.m();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 10) {
                        this.n = ihVar.j();
                        this.F.set(1, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.o = ihVar.f();
                        this.F.set(2, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
            }
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (this.h == null) {
            this.h = new java.util.HashMap();
        }
        this.h.put(str, str2);
    }

    public final byte[] a() {
        java.nio.ByteBuffer a = com.xiaomi.push.hx.a(this.m);
        this.m = a;
        return a.array();
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        r();
        if (this.a != null && b()) {
            ihVar.a(q);
            ihVar.a(this.a);
        }
        if (this.b != null && c()) {
            ihVar.a(r);
            this.b.b(ihVar);
        }
        if (this.c != null) {
            ihVar.a(f479s);
            ihVar.a(this.c);
        }
        if (this.d != null && e()) {
            ihVar.a(t);
            ihVar.a(this.d);
        }
        if (this.e != null && f()) {
            ihVar.a(u);
            ihVar.a(this.e);
        }
        ihVar.a(v);
        ihVar.a(this.f);
        if (this.g != null && i()) {
            ihVar.a(w);
            ihVar.a(this.g);
        }
        if (this.h != null && j()) {
            ihVar.a(x);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.h.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.h.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (this.i != null && k()) {
            ihVar.a(y);
            ihVar.a(this.i);
        }
        if (this.j != null && l()) {
            ihVar.a(z);
            ihVar.a(this.j);
        }
        if (this.k != null && m()) {
            ihVar.a(A);
            ihVar.a(this.k);
        }
        if (this.l != null && n()) {
            ihVar.a(B);
            ihVar.a(this.l);
        }
        if (this.m != null && o()) {
            ihVar.a(C);
            ihVar.a(this.m);
        }
        if (p()) {
            ihVar.a(D);
            ihVar.a(this.n);
        }
        if (q()) {
            ihVar.a(E);
            ihVar.a(this.o);
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
        int a13;
        int a14;
        int a15;
        com.xiaomi.push.hk hkVar = (com.xiaomi.push.hk) obj;
        if (!com.xiaomi.push.hk.class.equals(hkVar.getClass())) {
            return com.xiaomi.push.hk.class.getName().compareTo(com.xiaomi.push.hk.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hkVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a15 = com.xiaomi.push.hx.a(this.a, hkVar.a)) != 0) {
            return a15;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hkVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a14 = com.xiaomi.push.hx.a(this.b, hkVar.b)) != 0) {
            return a14;
        }
        int compareTo3 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hkVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a13 = com.xiaomi.push.hx.a(this.c, hkVar.c)) != 0) {
            return a13;
        }
        int compareTo4 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hkVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a12 = com.xiaomi.push.hx.a(this.d, hkVar.d)) != 0) {
            return a12;
        }
        int compareTo5 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hkVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a11 = com.xiaomi.push.hx.a(this.e, hkVar.e)) != 0) {
            return a11;
        }
        int compareTo6 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hkVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a10 = com.xiaomi.push.hx.a(this.f, hkVar.f)) != 0) {
            return a10;
        }
        int compareTo7 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hkVar.i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (i() && (a9 = com.xiaomi.push.hx.a(this.g, hkVar.g)) != 0) {
            return a9;
        }
        int compareTo8 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hkVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a8 = com.xiaomi.push.hx.a(this.h, hkVar.h)) != 0) {
            return a8;
        }
        int compareTo9 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(hkVar.k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (k() && (a7 = com.xiaomi.push.hx.a(this.i, hkVar.i)) != 0) {
            return a7;
        }
        int compareTo10 = java.lang.Boolean.valueOf(l()).compareTo(java.lang.Boolean.valueOf(hkVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (l() && (a6 = com.xiaomi.push.hx.a(this.j, hkVar.j)) != 0) {
            return a6;
        }
        int compareTo11 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(hkVar.m()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m() && (a5 = com.xiaomi.push.hx.a(this.k, hkVar.k)) != 0) {
            return a5;
        }
        int compareTo12 = java.lang.Boolean.valueOf(n()).compareTo(java.lang.Boolean.valueOf(hkVar.n()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (n() && (a4 = com.xiaomi.push.hx.a(this.l, hkVar.l)) != 0) {
            return a4;
        }
        int compareTo13 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(hkVar.o()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (o() && (a3 = com.xiaomi.push.hx.a(this.m, hkVar.m)) != 0) {
            return a3;
        }
        int compareTo14 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(hkVar.p()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (p() && (a2 = com.xiaomi.push.hx.a(this.n, hkVar.n)) != 0) {
            return a2;
        }
        int compareTo15 = java.lang.Boolean.valueOf(q()).compareTo(java.lang.Boolean.valueOf(hkVar.q()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!q() || (a = com.xiaomi.push.hx.a(this.o, hkVar.o)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hk)) {
            com.xiaomi.push.hk hkVar = (com.xiaomi.push.hk) obj;
            boolean b = b();
            boolean b2 = hkVar.b();
            if ((b || b2) && !(b && b2 && this.a.equals(hkVar.a))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hkVar.c();
            if ((c || c2) && !(c && c2 && this.b.a(hkVar.b))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hkVar.d();
            if ((d || d2) && !(d && d2 && this.c.equals(hkVar.c))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hkVar.e();
            if ((e || e2) && !(e && e2 && this.d.equals(hkVar.d))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hkVar.f();
            if (((f || f2) && !(f && f2 && this.e.equals(hkVar.e))) || this.f != hkVar.f) {
                return false;
            }
            boolean i = i();
            boolean i2 = hkVar.i();
            if ((i || i2) && !(i && i2 && this.g.equals(hkVar.g))) {
                return false;
            }
            boolean j = j();
            boolean j2 = hkVar.j();
            if ((j || j2) && !(j && j2 && this.h.equals(hkVar.h))) {
                return false;
            }
            boolean k = k();
            boolean k2 = hkVar.k();
            if ((k || k2) && !(k && k2 && this.i.equals(hkVar.i))) {
                return false;
            }
            boolean l = l();
            boolean l2 = hkVar.l();
            if ((l || l2) && !(l && l2 && this.j.equals(hkVar.j))) {
                return false;
            }
            boolean m = m();
            boolean m2 = hkVar.m();
            if ((m || m2) && !(m && m2 && this.k.equals(hkVar.k))) {
                return false;
            }
            boolean n = n();
            boolean n2 = hkVar.n();
            if ((n || n2) && !(n && n2 && this.l.equals(hkVar.l))) {
                return false;
            }
            boolean o = o();
            boolean o2 = hkVar.o();
            if ((o || o2) && !(o && o2 && this.m.equals(hkVar.m))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hkVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.n == hkVar.n)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hkVar.q();
            if (q2 || q3) {
                return q2 && q3 && this.o == hkVar.o;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        boolean z2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionNotification(");
        boolean z3 = false;
        if (b()) {
            sb.append("debug:");
            java.lang.String str = this.a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (c()) {
            if (!z2) {
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
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            java.lang.String str3 = this.d;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("type:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f);
        if (i()) {
            sb.append(", ");
            sb.append("payload:");
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
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            java.lang.String str8 = this.k;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("aliasName:");
            java.lang.String str9 = this.l;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            java.nio.ByteBuffer byteBuffer = this.m;
            if (byteBuffer == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                com.xiaomi.push.hx.a(byteBuffer, sb);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.n);
        }
        if (q()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.o);
        }
        sb.append(")");
        return sb.toString();
    }
}
