package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class f {
    protected java.util.List<com.anythink.core.common.f.b> a;
    protected com.anythink.core.common.f.b b;
    protected boolean c;

    public final com.anythink.core.common.f.b a() {
        java.util.List<com.anythink.core.common.f.b> list = this.a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.a.get(0);
    }

    public final com.anythink.core.common.f.b b() {
        java.util.List<com.anythink.core.common.f.b> list = this.a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.a.get(r0.size() - 1);
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        java.util.List<com.anythink.core.common.f.b> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final com.anythink.core.common.f.b e() {
        return this.b;
    }

    public final java.util.List<com.anythink.core.common.f.ay.a> f() {
        java.util.List<com.anythink.core.common.f.b> list = this.a;
        if (list == null || list.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.anythink.core.common.f.b> it = this.a.iterator();
        while (it.hasNext()) {
            com.anythink.core.common.f.au unitGroupInfo = it.next().d().getUnitGroupInfo();
            arrayList.add(new com.anythink.core.common.f.ay.a(unitGroupInfo, unitGroupInfo.M()));
        }
        return arrayList;
    }
}
