package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gx implements com.xiaomi.push.hw<com.xiaomi.push.gx, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private java.util.BitSet B;
    public java.lang.String a;
    public long b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public int f;
    public java.lang.String g;
    public int h;
    public int i;
    public java.util.Map<java.lang.String, java.lang.String> j;
    public java.util.Map<java.lang.String, java.lang.String> k;
    public boolean l;
    public java.util.Map<java.lang.String, java.lang.String> m;
    private static final com.xiaomi.push.im n = new com.xiaomi.push.im("PushMetaInfo");
    private static final com.xiaomi.push.ie o = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie p = new com.xiaomi.push.ie("", (byte) 10, 2);
    private static final com.xiaomi.push.ie q = new com.xiaomi.push.ie("", (byte) 11, 3);
    private static final com.xiaomi.push.ie r = new com.xiaomi.push.ie("", (byte) 11, 4);

    /* renamed from: s, reason: collision with root package name */
    private static final com.xiaomi.push.ie f474s = new com.xiaomi.push.ie("", (byte) 11, 5);
    private static final com.xiaomi.push.ie t = new com.xiaomi.push.ie("", (byte) 8, 6);
    private static final com.xiaomi.push.ie u = new com.xiaomi.push.ie("", (byte) 11, 7);
    private static final com.xiaomi.push.ie v = new com.xiaomi.push.ie("", (byte) 8, 8);
    private static final com.xiaomi.push.ie w = new com.xiaomi.push.ie("", (byte) 8, 9);
    private static final com.xiaomi.push.ie x = new com.xiaomi.push.ie("", (byte) 13, 10);
    private static final com.xiaomi.push.ie y = new com.xiaomi.push.ie("", (byte) 13, 11);
    private static final com.xiaomi.push.ie z = new com.xiaomi.push.ie("", (byte) 2, 12);
    private static final com.xiaomi.push.ie A = new com.xiaomi.push.ie("", (byte) 13, 13);

    public gx() {
        this.B = new java.util.BitSet(5);
        this.l = false;
    }

    public gx(com.xiaomi.push.gx gxVar) {
        java.util.BitSet bitSet = new java.util.BitSet(5);
        this.B = bitSet;
        bitSet.clear();
        this.B.or(gxVar.B);
        if (gxVar.b()) {
            this.a = gxVar.a;
        }
        this.b = gxVar.b;
        if (gxVar.e()) {
            this.c = gxVar.c;
        }
        if (gxVar.f()) {
            this.d = gxVar.d;
        }
        if (gxVar.g()) {
            this.e = gxVar.e;
        }
        this.f = gxVar.f;
        if (gxVar.j()) {
            this.g = gxVar.g;
        }
        this.h = gxVar.h;
        this.i = gxVar.i;
        if (gxVar.o()) {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : gxVar.j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.j = hashMap;
        }
        if (gxVar.p()) {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : gxVar.k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.k = hashMap2;
        }
        this.l = gxVar.l;
        if (gxVar.s()) {
            java.util.HashMap hashMap3 = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry3 : gxVar.m.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.m = hashMap3;
        }
    }

    private boolean b() {
        return this.a != null;
    }

    private boolean c() {
        return this.B.get(0);
    }

    private void d() {
        this.B.set(0, true);
    }

    private boolean e() {
        return this.c != null;
    }

    private boolean f() {
        return this.d != null;
    }

    private boolean g() {
        return this.e != null;
    }

    private boolean h() {
        return this.B.get(1);
    }

    private void i() {
        this.B.set(1, true);
    }

    private boolean j() {
        return this.g != null;
    }

    private boolean k() {
        return this.B.get(2);
    }

    private void l() {
        this.B.set(2, true);
    }

    private boolean m() {
        return this.B.get(3);
    }

    private void n() {
        this.B.set(3, true);
    }

    private boolean o() {
        return this.j != null;
    }

    private boolean p() {
        return this.k != null;
    }

    private boolean q() {
        return this.B.get(4);
    }

    private void r() {
        this.B.set(4, true);
    }

    private boolean s() {
        return this.m != null;
    }

    private void t() {
        if (this.a != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'id' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.gx a() {
        return new com.xiaomi.push.gx(this);
    }

    public final com.xiaomi.push.gx a(int i) {
        this.f = i;
        i();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            int i = 0;
            if (b2 == 0) {
                if (c()) {
                    t();
                    return;
                } else {
                    throw new com.xiaomi.push.ii("Required field 'messageTs' was not found in serialized data! Struct: " + toString(), (byte) 0);
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
                    if (b2 != 10) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.b = ihVar.j();
                        d();
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
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.f = ihVar.i();
                        i();
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
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.h = ihVar.i();
                        l();
                        break;
                    }
                case 9:
                    if (b2 != 8) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.i = ihVar.i();
                        n();
                        break;
                    }
                case 10:
                    if (b2 != 13) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.ig c = ihVar.c();
                        this.j = new java.util.HashMap(c.c * 2);
                        while (i < c.c) {
                            this.j.put(ihVar.l(), ihVar.l());
                            i++;
                        }
                        break;
                    }
                case 11:
                    if (b2 != 13) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.ig c2 = ihVar.c();
                        this.k = new java.util.HashMap(c2.c * 2);
                        while (i < c2.c) {
                            this.k.put(ihVar.l(), ihVar.l());
                            i++;
                        }
                        break;
                    }
                case 12:
                    if (b2 != 2) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        this.l = ihVar.f();
                        r();
                        break;
                    }
                case 13:
                    if (b2 != 13) {
                        com.xiaomi.push.ik.a(ihVar, b2);
                        break;
                    } else {
                        com.xiaomi.push.ig c3 = ihVar.c();
                        this.m = new java.util.HashMap(c3.c * 2);
                        while (i < c3.c) {
                            this.m.put(ihVar.l(), ihVar.l());
                            i++;
                        }
                        break;
                    }
                default:
                    com.xiaomi.push.ik.a(ihVar, b2);
                    break;
            }
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (this.j == null) {
            this.j = new java.util.HashMap();
        }
        this.j.put(str, str2);
    }

    public final boolean a(com.xiaomi.push.gx gxVar) {
        if (gxVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = gxVar.b();
        if (((b || b2) && !(b && b2 && this.a.equals(gxVar.a))) || this.b != gxVar.b) {
            return false;
        }
        boolean e = e();
        boolean e2 = gxVar.e();
        if ((e || e2) && !(e && e2 && this.c.equals(gxVar.c))) {
            return false;
        }
        boolean f = f();
        boolean f2 = gxVar.f();
        if ((f || f2) && !(f && f2 && this.d.equals(gxVar.d))) {
            return false;
        }
        boolean g = g();
        boolean g2 = gxVar.g();
        if ((g || g2) && !(g && g2 && this.e.equals(gxVar.e))) {
            return false;
        }
        boolean h = h();
        boolean h2 = gxVar.h();
        if ((h || h2) && !(h && h2 && this.f == gxVar.f)) {
            return false;
        }
        boolean j = j();
        boolean j2 = gxVar.j();
        if ((j || j2) && !(j && j2 && this.g.equals(gxVar.g))) {
            return false;
        }
        boolean k = k();
        boolean k2 = gxVar.k();
        if ((k || k2) && !(k && k2 && this.h == gxVar.h)) {
            return false;
        }
        boolean m = m();
        boolean m2 = gxVar.m();
        if ((m || m2) && !(m && m2 && this.i == gxVar.i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = gxVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.j.equals(gxVar.j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = gxVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.k.equals(gxVar.k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = gxVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.l == gxVar.l)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = gxVar.s();
        if (s2 || s3) {
            return s2 && s3 && this.m.equals(gxVar.m);
        }
        return true;
    }

    public final com.xiaomi.push.gx b(int i) {
        this.h = i;
        l();
        return this;
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        t();
        if (this.a != null) {
            ihVar.a(o);
            ihVar.a(this.a);
        }
        ihVar.a(p);
        ihVar.a(this.b);
        if (this.c != null && e()) {
            ihVar.a(q);
            ihVar.a(this.c);
        }
        if (this.d != null && f()) {
            ihVar.a(r);
            ihVar.a(this.d);
        }
        if (this.e != null && g()) {
            ihVar.a(f474s);
            ihVar.a(this.e);
        }
        if (h()) {
            ihVar.a(t);
            ihVar.a(this.f);
        }
        if (this.g != null && j()) {
            ihVar.a(u);
            ihVar.a(this.g);
        }
        if (k()) {
            ihVar.a(v);
            ihVar.a(this.h);
        }
        if (m()) {
            ihVar.a(w);
            ihVar.a(this.i);
        }
        if (this.j != null && o()) {
            ihVar.a(x);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.j.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.j.entrySet()) {
                ihVar.a(entry.getKey());
                ihVar.a(entry.getValue());
            }
        }
        if (this.k != null && p()) {
            ihVar.a(y);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.k.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.k.entrySet()) {
                ihVar.a(entry2.getKey());
                ihVar.a(entry2.getValue());
            }
        }
        if (q()) {
            ihVar.a(z);
            ihVar.a(this.l);
        }
        if (this.m != null && s()) {
            ihVar.a(A);
            ihVar.a(new com.xiaomi.push.ig((byte) 11, (byte) 11, this.m.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry3 : this.m.entrySet()) {
                ihVar.a(entry3.getKey());
                ihVar.a(entry3.getValue());
            }
        }
        ihVar.a();
    }

    public final com.xiaomi.push.gx c(int i) {
        this.i = i;
        n();
        return this;
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
        com.xiaomi.push.gx gxVar = (com.xiaomi.push.gx) obj;
        if (!com.xiaomi.push.gx.class.equals(gxVar.getClass())) {
            return com.xiaomi.push.gx.class.getName().compareTo(com.xiaomi.push.gx.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(gxVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a13 = com.xiaomi.push.hx.a(this.a, gxVar.a)) != 0) {
            return a13;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gxVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a12 = com.xiaomi.push.hx.a(this.b, gxVar.b)) != 0) {
            return a12;
        }
        int compareTo3 = java.lang.Boolean.valueOf(e()).compareTo(java.lang.Boolean.valueOf(gxVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a11 = com.xiaomi.push.hx.a(this.c, gxVar.c)) != 0) {
            return a11;
        }
        int compareTo4 = java.lang.Boolean.valueOf(f()).compareTo(java.lang.Boolean.valueOf(gxVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a10 = com.xiaomi.push.hx.a(this.d, gxVar.d)) != 0) {
            return a10;
        }
        int compareTo5 = java.lang.Boolean.valueOf(g()).compareTo(java.lang.Boolean.valueOf(gxVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a9 = com.xiaomi.push.hx.a(this.e, gxVar.e)) != 0) {
            return a9;
        }
        int compareTo6 = java.lang.Boolean.valueOf(h()).compareTo(java.lang.Boolean.valueOf(gxVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a8 = com.xiaomi.push.hx.a(this.f, gxVar.f)) != 0) {
            return a8;
        }
        int compareTo7 = java.lang.Boolean.valueOf(j()).compareTo(java.lang.Boolean.valueOf(gxVar.j()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (j() && (a7 = com.xiaomi.push.hx.a(this.g, gxVar.g)) != 0) {
            return a7;
        }
        int compareTo8 = java.lang.Boolean.valueOf(k()).compareTo(java.lang.Boolean.valueOf(gxVar.k()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (k() && (a6 = com.xiaomi.push.hx.a(this.h, gxVar.h)) != 0) {
            return a6;
        }
        int compareTo9 = java.lang.Boolean.valueOf(m()).compareTo(java.lang.Boolean.valueOf(gxVar.m()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m() && (a5 = com.xiaomi.push.hx.a(this.i, gxVar.i)) != 0) {
            return a5;
        }
        int compareTo10 = java.lang.Boolean.valueOf(o()).compareTo(java.lang.Boolean.valueOf(gxVar.o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (o() && (a4 = com.xiaomi.push.hx.a(this.j, gxVar.j)) != 0) {
            return a4;
        }
        int compareTo11 = java.lang.Boolean.valueOf(p()).compareTo(java.lang.Boolean.valueOf(gxVar.p()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (p() && (a3 = com.xiaomi.push.hx.a(this.k, gxVar.k)) != 0) {
            return a3;
        }
        int compareTo12 = java.lang.Boolean.valueOf(q()).compareTo(java.lang.Boolean.valueOf(gxVar.q()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (q() && (a2 = com.xiaomi.push.hx.a(this.l, gxVar.l)) != 0) {
            return a2;
        }
        int compareTo13 = java.lang.Boolean.valueOf(s()).compareTo(java.lang.Boolean.valueOf(gxVar.s()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!s() || (a = com.xiaomi.push.hx.a(this.m, gxVar.m)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gx)) {
            return a((com.xiaomi.push.gx) obj);
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PushMetaInfo(");
        sb.append("id:");
        java.lang.String str = this.a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.b);
        if (e()) {
            sb.append(", ");
            sb.append("topic:");
            java.lang.String str2 = this.c;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("title:");
            java.lang.String str3 = this.d;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("description:");
            java.lang.String str4 = this.e;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f);
        }
        if (j()) {
            sb.append(", ");
            sb.append("url:");
            java.lang.String str5 = this.g;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.h);
        }
        if (m()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("extra:");
            java.util.Map<java.lang.String, java.lang.String> map = this.j;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("internal:");
            java.util.Map<java.lang.String, java.lang.String> map2 = this.k;
            if (map2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map2);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.l);
        }
        if (s()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            java.util.Map<java.lang.String, java.lang.String> map3 = this.m;
            if (map3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
