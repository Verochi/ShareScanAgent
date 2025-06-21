package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hf implements com.xiaomi.push.hw<com.xiaomi.push.hf, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im k = new com.xiaomi.push.im("XmPushActionCommand");
    private static final com.xiaomi.push.ie l = new com.xiaomi.push.ie("", (byte) 12, 2);
    private static final com.xiaomi.push.ie m = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie n = new com.xiaomi.push.ie("", (byte) 11, 4);
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 15, 6);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 9);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f477s = new com.xiaomi.push.ie("", (byte) 2, 10);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 2, 11);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 10, 12);
    public com.xiaomi.push.gz a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.util.List<java.lang.String> e;
    public java.lang.String f;
    public java.lang.String g;
    public long j;
    private java.util.BitSet v = new java.util.BitSet(3);
    public boolean h = false;
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
        return this.v.get(0);
    }

    private boolean i() {
        return this.v.get(1);
    }

    private boolean j() {
        return this.v.get(2);
    }

    private void k() {
        if (this.b == null) {
            throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.c == null) {
            throw new com.xiaomi.push.ii("Required field 'appId' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.d != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'cmdName' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                k();
                return;
            }
            switch (b.c) {
                case 2:
                    if (b2 == 12) {
                        com.xiaomi.push.gz gzVar = new com.xiaomi.push.gz();
                        this.a = gzVar;
                        gzVar.a(ihVar);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.b = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.c = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.d = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 15) {
                        com.xiaomi.push.Cif d = ihVar.d();
                        this.e = new java.util.ArrayList(d.b);
                        for (int i = 0; i < d.b; i++) {
                            this.e.add(ihVar.l());
                        }
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 8:
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.g = ihVar.l();
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 2) {
                        this.h = ihVar.f();
                        this.v.set(0, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.i = ihVar.f();
                        this.v.set(1, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.j = ihVar.j();
                        this.v.set(2, true);
                        break;
                    } else {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    }
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        k();
        if (this.a != null && a()) {
            ihVar.a(l);
            this.a.b(ihVar);
        }
        if (this.b != null) {
            ihVar.a(m);
            ihVar.a(this.b);
        }
        if (this.c != null) {
            ihVar.a(n);
            ihVar.a(this.c);
        }
        if (this.d != null) {
            ihVar.a(o);
            ihVar.a(this.d);
        }
        if (this.e != null && e()) {
            ihVar.a(p);
            ihVar.a(new com.xiaomi.push.Cif((byte) 11, this.e.size()));
            java.util.Iterator<java.lang.String> it = this.e.iterator();
            while (it.hasNext()) {
                ihVar.a(it.next());
            }
        }
        if (this.f != null && f()) {
            ihVar.a(q);
            ihVar.a(this.f);
        }
        if (this.g != null && g()) {
            ihVar.a(r);
            ihVar.a(this.g);
        }
        if (h()) {
            ihVar.a(f477s);
            ihVar.a(this.h);
        }
        if (i()) {
            ihVar.a(t);
            ihVar.a(this.i);
        }
        if (j()) {
            ihVar.a(u);
            ihVar.a(this.j);
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
        com.xiaomi.push.hf hfVar = (com.xiaomi.push.hf) obj;
        if (!com.xiaomi.push.hf.class.equals(hfVar.getClass())) {
            return com.xiaomi.push.hf.class.getName().compareTo(com.xiaomi.push.hf.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(hfVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a10 = com.xiaomi.push.hx.a(this.a, hfVar.a)) != 0) {
            return a10;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(hfVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = com.xiaomi.push.hx.a(this.b, hfVar.b)) != 0) {
            return a9;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hfVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = com.xiaomi.push.hx.a(this.c, hfVar.c)) != 0) {
            return a8;
        }
        int compareTo4 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hfVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = com.xiaomi.push.hx.a(this.d, hfVar.d)) != 0) {
            return a7;
        }
        int compareTo5 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(hfVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = com.xiaomi.push.hx.a(this.e, hfVar.e)) != 0) {
            return a6;
        }
        int compareTo6 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(hfVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = com.xiaomi.push.hx.a(this.f, hfVar.f)) != 0) {
            return a5;
        }
        int compareTo7 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(hfVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = com.xiaomi.push.hx.a(this.g, hfVar.g)) != 0) {
            return a4;
        }
        int compareTo8 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(hfVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = com.xiaomi.push.hx.a(this.h, hfVar.h)) != 0) {
            return a3;
        }
        int compareTo9 = java.lang.Boolean.valueOf(i()).compareTo(java.lang.Boolean.valueOf(hfVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a2 = com.xiaomi.push.hx.a(this.i, hfVar.i)) != 0) {
            return a2;
        }
        int compareTo10 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(hfVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a = com.xiaomi.push.hx.a(this.j, hfVar.j)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.hf)) {
            com.xiaomi.push.hf hfVar = (com.xiaomi.push.hf) obj;
            boolean a = a();
            boolean a2 = hfVar.a();
            if ((a || a2) && !(a && a2 && this.a.a(hfVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = hfVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(hfVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = hfVar.c();
            if ((c || c2) && !(c && c2 && this.c.equals(hfVar.c))) {
                return false;
            }
            boolean d = d();
            boolean d2 = hfVar.d();
            if ((d || d2) && !(d && d2 && this.d.equals(hfVar.d))) {
                return false;
            }
            boolean e = e();
            boolean e2 = hfVar.e();
            if ((e || e2) && !(e && e2 && this.e.equals(hfVar.e))) {
                return false;
            }
            boolean f = f();
            boolean f2 = hfVar.f();
            if ((f || f2) && !(f && f2 && this.f.equals(hfVar.f))) {
                return false;
            }
            boolean g = g();
            boolean g2 = hfVar.g();
            if ((g || g2) && !(g && g2 && this.g.equals(hfVar.g))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hfVar.h();
            if ((h || h2) && !(h && h2 && this.h == hfVar.h)) {
                return false;
            }
            boolean i = i();
            boolean i2 = hfVar.i();
            if ((i || i2) && !(i && i2 && this.i == hfVar.i)) {
                return false;
            }
            boolean j = j();
            boolean j2 = hfVar.j();
            if (j || j2) {
                return j && j2 && this.j == hfVar.j;
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
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionCommand(");
        if (a()) {
            sb.append("target:");
            com.xiaomi.push.gz gzVar = this.a;
            if (gzVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gzVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        java.lang.String str = this.b;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        java.lang.String str3 = this.d;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            java.util.List<java.lang.String> list = this.e;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
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
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.h);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
