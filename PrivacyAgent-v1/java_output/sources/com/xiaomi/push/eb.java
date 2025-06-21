package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class eb implements com.xiaomi.push.hw<com.xiaomi.push.eb, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im d = new com.xiaomi.push.im("StatsEvents");
    private static final com.xiaomi.push.ie e = new com.xiaomi.push.ie("", (byte) 11, 1);
    private static final com.xiaomi.push.ie f = new com.xiaomi.push.ie("", (byte) 11, 2);
    private static final com.xiaomi.push.ie g = new com.xiaomi.push.ie("", (byte) 15, 3);
    public java.lang.String a;
    public java.lang.String b;
    public java.util.List<com.xiaomi.push.ea> c;

    public eb() {
    }

    public eb(java.lang.String str, java.util.List<com.xiaomi.push.ea> list) {
        this();
        this.a = str;
        this.c = list;
    }

    private boolean a() {
        return this.a != null;
    }

    private boolean b() {
        return this.b != null;
    }

    private boolean c() {
        return this.c != null;
    }

    private void d() {
        if (this.a == null) {
            throw new com.xiaomi.push.ii("Required field 'uuid' was not present! Struct: " + toString(), (byte) 0);
        }
        if (this.c != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'events' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b = ihVar.b();
            byte b2 = b.b;
            if (b2 == 0) {
                d();
                return;
            }
            short s2 = b.c;
            if (s2 != 1) {
                if (s2 != 2) {
                    if (s2 == 3 && b2 == 15) {
                        com.xiaomi.push.Cif d2 = ihVar.d();
                        this.c = new java.util.ArrayList(d2.b);
                        for (int i = 0; i < d2.b; i++) {
                            com.xiaomi.push.ea eaVar = new com.xiaomi.push.ea();
                            eaVar.a(ihVar);
                            this.c.add(eaVar);
                        }
                    }
                    com.xiaomi.push.ik.a(ihVar, b2);
                } else if (b2 == 11) {
                    this.b = ihVar.l();
                } else {
                    com.xiaomi.push.ik.a(ihVar, b2);
                }
            } else if (b2 == 11) {
                this.a = ihVar.l();
            } else {
                com.xiaomi.push.ik.a(ihVar, b2);
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        d();
        if (this.a != null) {
            ihVar.a(e);
            ihVar.a(this.a);
        }
        if (this.b != null && b()) {
            ihVar.a(f);
            ihVar.a(this.b);
        }
        if (this.c != null) {
            ihVar.a(g);
            ihVar.a(new com.xiaomi.push.Cif((byte) 12, this.c.size()));
            java.util.Iterator<com.xiaomi.push.ea> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().b(ihVar);
            }
        }
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        int a3;
        com.xiaomi.push.eb ebVar = (com.xiaomi.push.eb) obj;
        if (!com.xiaomi.push.eb.class.equals(ebVar.getClass())) {
            return com.xiaomi.push.eb.class.getName().compareTo(com.xiaomi.push.eb.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(ebVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a3 = com.xiaomi.push.hx.a(this.a, ebVar.a)) != 0) {
            return a3;
        }
        int compareTo2 = java.lang.Boolean.valueOf(b()).compareTo(java.lang.Boolean.valueOf(ebVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a2 = com.xiaomi.push.hx.a(this.b, ebVar.b)) != 0) {
            return a2;
        }
        int compareTo3 = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(ebVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a = com.xiaomi.push.hx.a(this.c, ebVar.c)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.eb)) {
            com.xiaomi.push.eb ebVar = (com.xiaomi.push.eb) obj;
            boolean a = a();
            boolean a2 = ebVar.a();
            if ((a || a2) && !(a && a2 && this.a.equals(ebVar.a))) {
                return false;
            }
            boolean b = b();
            boolean b2 = ebVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(ebVar.b))) {
                return false;
            }
            boolean c = c();
            boolean c2 = ebVar.c();
            if (c || c2) {
                return c && c2 && this.c.equals(ebVar.c);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("StatsEvents(");
        sb.append("uuid:");
        java.lang.String str = this.a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            java.lang.String str2 = this.b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        java.util.List<com.xiaomi.push.ea> list = this.c;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
