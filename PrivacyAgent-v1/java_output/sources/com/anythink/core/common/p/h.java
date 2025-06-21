package com.anythink.core.common.p;

/* loaded from: classes12.dex */
public final class h {
    private java.util.List<com.anythink.core.common.f.au> a;

    public h(java.util.List<com.anythink.core.common.f.au> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    private static void a(int i, java.util.List<com.anythink.core.common.f.au> list) {
        if (list != null && i < list.size()) {
            while (i < list.size()) {
                com.anythink.core.common.f.au auVar = list.get(i);
                if (auVar != null) {
                    auVar.C(i);
                }
                i++;
            }
        }
    }

    private void a(com.anythink.core.common.f.au auVar, int i, com.anythink.core.common.f.au auVar2) {
        com.anythink.core.common.f.q M;
        com.anythink.core.common.f.q M2;
        if (auVar.k() && (M2 = auVar.M()) != null) {
            if (auVar2 != null) {
                M2.q = com.anythink.core.common.o.h.a(auVar2);
            } else {
                M2.q = com.anythink.core.common.o.h.a(auVar);
            }
        }
        if (i > 0) {
            com.anythink.core.common.f.au auVar3 = this.a.get(i - 1);
            if (!auVar3.k() || (M = auVar3.M()) == null) {
                return;
            }
            M.q = com.anythink.core.common.o.h.a(auVar);
        }
    }

    public final synchronized java.util.List<com.anythink.core.common.f.au> a() {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        arrayList.addAll(this.a);
        return arrayList;
    }

    public final synchronized void a(com.anythink.core.common.f.au auVar) {
        java.util.List<com.anythink.core.common.f.au> list = this.a;
        if (list != null) {
            if (list.size() == 0) {
                auVar.C(0);
                this.a.add(auVar);
                a(auVar, 0, null);
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                com.anythink.core.common.f.au auVar2 = this.a.get(i);
                if (com.anythink.core.common.o.h.a(auVar) > com.anythink.core.common.o.h.a(auVar2)) {
                    auVar.C(i);
                    this.a.add(i, auVar);
                    a(auVar, i, auVar2);
                    int i2 = i + 1;
                    java.util.List<com.anythink.core.common.f.au> list2 = this.a;
                    if (list2 != null && i2 < list2.size()) {
                        while (i2 < list2.size()) {
                            com.anythink.core.common.f.au auVar3 = list2.get(i2);
                            if (auVar3 != null) {
                                auVar3.C(i2);
                            }
                            i2++;
                        }
                    }
                    return;
                }
            }
            auVar.C(this.a.size());
            this.a.add(auVar);
            a(auVar, this.a.size() - 1, null);
        }
    }
}
