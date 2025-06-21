package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hd implements com.xiaomi.push.hw<com.xiaomi.push.hd, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im c = new com.xiaomi.push.im("XmPushActionCheckClientInfo");
    private static final com.xiaomi.push.ie d = new com.xiaomi.push.ie("", (byte) 8, 1);
    private static final com.xiaomi.push.ie e = new com.xiaomi.push.ie("", (byte) 8, 2);
    public int a;
    public int b;
    private java.util.BitSet f = new java.util.BitSet(2);

    private boolean c() {
        return this.f.get(0);
    }

    private boolean d() {
        return this.f.get(1);
    }

    public final void a() {
        this.f.set(0, true);
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
                if (s2 == 2 && b2 == 8) {
                    this.b = ihVar.i();
                    b();
                }
                com.xiaomi.push.ik.a(ihVar, b2);
            } else if (b2 == 8) {
                this.a = ihVar.i();
                a();
            } else {
                com.xiaomi.push.ik.a(ihVar, b2);
            }
        }
        if (!c()) {
            throw new com.xiaomi.push.ii("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString(), (byte) 0);
        }
        if (d()) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString(), (byte) 0);
    }

    public final void b() {
        this.f.set(1, true);
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        ihVar.a(d);
        ihVar.a(this.a);
        ihVar.a(e);
        ihVar.a(this.b);
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        int a2;
        com.xiaomi.push.hd hdVar = (com.xiaomi.push.hd) obj;
        if (!com.xiaomi.push.hd.class.equals(hdVar.getClass())) {
            return com.xiaomi.push.hd.class.getName().compareTo(com.xiaomi.push.hd.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(c()).compareTo(java.lang.Boolean.valueOf(hdVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c() && (a2 = com.xiaomi.push.hx.a(this.a, hdVar.a)) != 0) {
            return a2;
        }
        int compareTo2 = java.lang.Boolean.valueOf(d()).compareTo(java.lang.Boolean.valueOf(hdVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!d() || (a = com.xiaomi.push.hx.a(this.b, hdVar.b)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.xiaomi.push.hd)) {
            return false;
        }
        com.xiaomi.push.hd hdVar = (com.xiaomi.push.hd) obj;
        return this.a == hdVar.a && this.b == hdVar.b;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.a + ", pluginConfigVersion:" + this.b + ")";
    }
}
