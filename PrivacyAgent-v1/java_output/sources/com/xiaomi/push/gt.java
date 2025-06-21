package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gt implements com.xiaomi.push.hw<com.xiaomi.push.gt, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im d = new com.xiaomi.push.im("NormalConfig");
    private static final com.xiaomi.push.ie e = new com.xiaomi.push.ie("", (byte) 8, 1);
    private static final com.xiaomi.push.ie f = new com.xiaomi.push.ie("", (byte) 15, 2);
    private static final com.xiaomi.push.ie g = new com.xiaomi.push.ie("", (byte) 8, 3);
    public int a;
    public java.util.List<com.xiaomi.push.gv> b;
    public com.xiaomi.push.gq c;
    private java.util.BitSet h = new java.util.BitSet(1);

    private boolean a() {
        return this.h.get(0);
    }

    private boolean b() {
        return this.b != null;
    }

    private boolean c() {
        return this.c != null;
    }

    private void d() {
        if (this.b != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'configItems' was not present! Struct: " + toString(), (byte) 0);
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
                    if (s2 == 3 && b2 == 8) {
                        this.c = com.xiaomi.push.gq.a(ihVar.i());
                    }
                    com.xiaomi.push.ik.a(ihVar, b2);
                } else if (b2 == 15) {
                    com.xiaomi.push.Cif d2 = ihVar.d();
                    this.b = new java.util.ArrayList(d2.b);
                    for (int i = 0; i < d2.b; i++) {
                        com.xiaomi.push.gv gvVar = new com.xiaomi.push.gv();
                        gvVar.a(ihVar);
                        this.b.add(gvVar);
                    }
                } else {
                    com.xiaomi.push.ik.a(ihVar, b2);
                }
            } else if (b2 == 8) {
                this.a = ihVar.i();
                this.h.set(0, true);
            } else {
                com.xiaomi.push.ik.a(ihVar, b2);
            }
        }
        if (!a()) {
            throw new com.xiaomi.push.ii("Required field 'version' was not found in serialized data! Struct: " + toString(), (byte) 0);
        }
        d();
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        d();
        ihVar.a(e);
        ihVar.a(this.a);
        if (this.b != null) {
            ihVar.a(f);
            ihVar.a(new com.xiaomi.push.Cif((byte) 12, this.b.size()));
            java.util.Iterator<com.xiaomi.push.gv> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().b(ihVar);
            }
        }
        if (this.c != null && c()) {
            ihVar.a(g);
            ihVar.a(this.c.c);
        }
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        int a3;
        com.xiaomi.push.gt gtVar = (com.xiaomi.push.gt) obj;
        if (!com.xiaomi.push.gt.class.equals(gtVar.getClass())) {
            return com.xiaomi.push.gt.class.getName().compareTo(com.xiaomi.push.gt.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(gtVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a3 = com.xiaomi.push.hx.a(this.a, gtVar.a)) != 0) {
            return a3;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(gtVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a2 = com.xiaomi.push.hx.a(this.b, gtVar.b)) != 0) {
            return a2;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gtVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a = com.xiaomi.push.hx.a(this.c, gtVar.c)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gt)) {
            com.xiaomi.push.gt gtVar = (com.xiaomi.push.gt) obj;
            if (this.a != gtVar.a) {
                return false;
            }
            boolean b = b();
            boolean b2 = gtVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(gtVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = gtVar.c();
            if (c || c2) {
                return c && c2 && this.c.equals(gtVar.c);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        java.util.List<com.xiaomi.push.gv> list = this.b;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            com.xiaomi.push.gq gqVar = this.c;
            if (gqVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gqVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
