package com.sijla.b;

/* loaded from: classes19.dex */
final class s implements java.lang.Runnable {
    private /* synthetic */ com.sijla.b.m a;

    public s(com.sijla.b.m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.List list;
        java.util.List list2;
        list = this.a.h;
        if (list != null) {
            list2 = this.a.h;
            java.util.Iterator it = list2.iterator();
            while (it.hasNext()) {
                ((com.sijla.e.c) it.next()).d();
            }
        }
    }
}
