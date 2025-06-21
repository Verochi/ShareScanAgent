package com.xiaomi.push;

/* loaded from: classes19.dex */
final class bk extends com.xiaomi.push.m.a {
    final /* synthetic */ com.xiaomi.push.bj a;

    public bk(com.xiaomi.push.bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        java.util.ArrayList arrayList3;
        java.util.ArrayList arrayList4;
        com.xiaomi.push.bh bhVar;
        java.util.ArrayList arrayList5;
        java.util.ArrayList<com.xiaomi.push.bj.a> arrayList6;
        arrayList = this.a.f;
        synchronized (arrayList) {
            arrayList2 = this.a.f;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f;
                if (arrayList3.size() > 1) {
                    com.xiaomi.push.bj bjVar = this.a;
                    arrayList6 = bjVar.f;
                    bjVar.a(arrayList6);
                } else {
                    com.xiaomi.push.bj bjVar2 = this.a;
                    arrayList4 = bjVar2.f;
                    com.xiaomi.push.bj.a aVar = (com.xiaomi.push.bj.a) arrayList4.get(0);
                    if (aVar != null) {
                        if (bjVar2.b == null) {
                            throw new java.lang.IllegalStateException("should exec init method first!");
                        }
                        java.lang.String str = aVar.d;
                        synchronized (bjVar2.c) {
                            bhVar = bjVar2.c.get(str);
                            if (bhVar == null) {
                                bhVar = bjVar2.b.a();
                                bjVar2.c.put(str, bhVar);
                            }
                        }
                        if (!bjVar2.d.isShutdown()) {
                            aVar.a(bhVar, bjVar2.a);
                            bjVar2.a((java.lang.Runnable) aVar);
                        }
                    }
                }
                arrayList5 = this.a.f;
                arrayList5.clear();
                java.lang.System.gc();
            }
        }
    }
}
