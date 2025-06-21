package com.bytedance.pangle.util.b.b;

/* loaded from: classes.dex */
public final class a {
    public java.util.List<com.bytedance.pangle.util.b.b.c> a = new java.util.ArrayList();

    public final void a(java.util.Set<java.lang.String> set) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.bytedance.pangle.util.b.b.c cVar : this.a) {
            if (!set.contains(cVar.h)) {
                arrayList.add(cVar);
            }
        }
        this.a = arrayList;
    }
}
