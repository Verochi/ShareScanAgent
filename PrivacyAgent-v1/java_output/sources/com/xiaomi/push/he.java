package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class he implements com.xiaomi.push.hw<com.xiaomi.push.he, java.lang.Object>, java.io.Serializable, java.lang.Cloneable {
    private static final com.xiaomi.push.im b = new com.xiaomi.push.im("XmPushActionCollectData");
    private static final com.xiaomi.push.ie c = new com.xiaomi.push.ie("", (byte) 15, 1);
    public java.util.List<com.xiaomi.push.gs> a;

    private boolean a() {
        return this.a != null;
    }

    private void b() {
        if (this.a != null) {
            return;
        }
        throw new com.xiaomi.push.ii("Required field 'dataCollectionItems' was not present! Struct: " + toString(), (byte) 0);
    }

    @Override // com.xiaomi.push.hw
    public final void a(com.xiaomi.push.ih ihVar) {
        while (true) {
            com.xiaomi.push.ie b2 = ihVar.b();
            byte b3 = b2.b;
            if (b3 == 0) {
                b();
                return;
            }
            if (b2.c == 1 && b3 == 15) {
                com.xiaomi.push.Cif d = ihVar.d();
                this.a = new java.util.ArrayList(d.b);
                for (int i = 0; i < d.b; i++) {
                    com.xiaomi.push.gs gsVar = new com.xiaomi.push.gs();
                    gsVar.a(ihVar);
                    this.a.add(gsVar);
                }
            } else {
                com.xiaomi.push.ik.a(ihVar, b3);
            }
        }
    }

    @Override // com.xiaomi.push.hw
    public final void b(com.xiaomi.push.ih ihVar) {
        b();
        if (this.a != null) {
            ihVar.a(c);
            ihVar.a(new com.xiaomi.push.Cif((byte) 12, this.a.size()));
            java.util.Iterator<com.xiaomi.push.gs> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(ihVar);
            }
        }
        ihVar.a();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(java.lang.Object obj) {
        int a;
        com.xiaomi.push.he heVar = (com.xiaomi.push.he) obj;
        if (!com.xiaomi.push.he.class.equals(heVar.getClass())) {
            return com.xiaomi.push.he.class.getName().compareTo(com.xiaomi.push.he.class.getName());
        }
        int compareTo = java.lang.Boolean.valueOf(a()).compareTo(java.lang.Boolean.valueOf(heVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!a() || (a = com.xiaomi.push.hx.a(this.a, heVar.a)) == 0) {
            return 0;
        }
        return a;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof com.xiaomi.push.he)) {
            com.xiaomi.push.he heVar = (com.xiaomi.push.he) obj;
            boolean a = a();
            boolean a2 = heVar.a();
            if (a || a2) {
                return a && a2 && this.a.equals(heVar.a);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        java.util.List<com.xiaomi.push.gs> list = this.a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
