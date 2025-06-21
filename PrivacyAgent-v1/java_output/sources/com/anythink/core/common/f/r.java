package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class r {
    java.util.HashMap<java.lang.String, java.util.List<com.anythink.core.common.f.q>> a = new java.util.HashMap<>(2);

    public final synchronized com.anythink.core.common.f.q a(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.util.List<com.anythink.core.common.f.q>> hashMap = this.a;
        com.anythink.core.common.f.q qVar = null;
        if (hashMap == null) {
            return null;
        }
        java.util.List<com.anythink.core.common.f.q> list = hashMap.get(str);
        if (list != null && list.size() != 0) {
            for (com.anythink.core.common.f.q qVar2 : list) {
                double d = qVar2.price;
                if (qVar != null && d <= qVar.price) {
                }
                qVar = qVar2;
            }
            if (qVar != null) {
                list.remove(qVar);
            }
            return qVar;
        }
        return null;
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.common.f.q qVar) {
        java.util.List<com.anythink.core.common.f.q> list = this.a.get(str);
        if (list == null) {
            list = new java.util.ArrayList<>();
            this.a.put(str, list);
        }
        list.add(qVar);
    }
}
