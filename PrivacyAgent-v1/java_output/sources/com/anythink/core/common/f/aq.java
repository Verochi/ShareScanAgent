package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class aq {
    private java.lang.String a;
    private java.util.List<com.anythink.core.common.f.b> b;

    public aq(java.lang.String str, java.util.List<com.anythink.core.common.f.b> list) {
        this.a = str;
        this.b = list;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final synchronized void a(int i) {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().d().getUnitGroupInfo().n = i;
            }
        }
    }

    public final synchronized void a(com.anythink.core.common.f.b bVar) {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public final synchronized int b() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final synchronized com.anythink.core.common.f.b c() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.b.get(0);
    }

    public final synchronized boolean d() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        com.anythink.core.common.f.b bVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    public final synchronized double e() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        com.anythink.core.common.f.b bVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (bVar != null) {
            return com.anythink.core.common.o.h.a(bVar.d().getUnitGroupInfo());
        }
        return 0.0d;
    }

    public final synchronized long f() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        com.anythink.core.common.f.b bVar = (list == null || list.size() <= 0) ? null : this.b.get(0);
        if (bVar != null) {
            return bVar.b();
        }
        return 0L;
    }

    public final synchronized void g() {
        java.util.List<com.anythink.core.common.f.b> list = this.b;
        if (list == null) {
            return;
        }
        for (com.anythink.core.common.f.b bVar : list) {
            if (bVar != null) {
                com.anythink.core.b.d.b.a(bVar, true);
                bVar.l();
            }
        }
    }
}
