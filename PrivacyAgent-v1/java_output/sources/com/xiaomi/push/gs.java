package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gs implements com.xiaomi.push.hw<com.xiaomi.push.gs, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im d = new com.xiaomi.push.im("DataCollectionItem");
    private static final com.xiaomi.push.ie e = new com.xiaomi.push.ie("", (byte) 10, 1);
    private static final com.xiaomi.push.ie f = new com.xiaomi.push.ie("", (byte) 8, 2);
    private static final com.xiaomi.push.ie g = new com.xiaomi.push.ie("", (byte) 11, 3);
    public long a;
    public com.xiaomi.push.gm b;
    public java.lang.String c;
    private java.util.BitSet h = new java.util.BitSet(1);

    private boolean a() {
        return this.h.get(0);
    }

    private void b() {
        this.h.set(0, true);
    }

    private boolean c() {
        return this.b != null;
    }

    private boolean d() {
        return this.c != null;
    }

    private void e() {
        if (this.b == null) {
            throw new com.xiaomi.push.ii("Required field 'collectionType' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.c != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'content' was not present! Struct: " + toString(), (byte) 0);
    }

    public final com.xiaomi.push.gs a(long j) {
        this.a = j;
        b();
        return this;
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
                    if (s2 == 3 && b2 == 11) {
                        this.c = ihVar.l();
                    }
                    com.xiaomi.push.ik.a(ihVar, b2);
                } else if (b2 == 8) {
                    this.b = com.xiaomi.push.gm.a(ihVar.i());
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
            e();
        } else {
            throw new com.xiaomi.push.ii("Required field 'collectedAt' was not found in serialized data! Struct: " + toString(), (byte) 0);
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        e();
        ihVar.a(e);
        ihVar.a(this.a);
        if (this.b != null) {
            ihVar.a(f);
            ihVar.a(this.b.y);
        }
        if (this.c != null) {
            ihVar.a(g);
            ihVar.a(this.c);
        }
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        int a3;
        com.xiaomi.push.gs gsVar = (com.xiaomi.push.gs) obj;
        if (!com.xiaomi.push.gs.class.equals(gsVar.getClass())) {
            return com.xiaomi.push.gs.class.getName().compareTo(com.xiaomi.push.gs.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(gsVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a3 = com.xiaomi.push.hx.a(this.a, gsVar.a)) != 0) {
            return a3;
        }
        int compareTo2 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(gsVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a2 = com.xiaomi.push.hx.a(this.b, gsVar.b)) != 0) {
            return a2;
        }
        int compareTo3 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(gsVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!d() || (a = com.xiaomi.push.hx.a(this.c, gsVar.c)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.gs)) {
            com.xiaomi.push.gs gsVar = (com.xiaomi.push.gs) obj;
            if (this.a != gsVar.a) {
                return false;
            }
            boolean c = c();
            boolean c2 = gsVar.c();
            if ((c || c2) && !(c && c2 && this.b.equals(gsVar.b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = gsVar.d();
            if (d2 || d3) {
                return d2 && d3 && this.c.equals(gsVar.c);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("collectionType:");
        com.xiaomi.push.gm gmVar = this.b;
        if (gmVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(gmVar);
        }
        sb.append(", ");
        sb.append("content:");
        java.lang.String str = this.c;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
