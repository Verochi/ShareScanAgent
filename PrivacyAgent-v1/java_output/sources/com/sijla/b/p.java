package com.sijla.b;

/* loaded from: classes19.dex */
final class p implements java.lang.Runnable {
    private /* synthetic */ long a;
    private /* synthetic */ com.sijla.b.m b;

    public p(com.sijla.b.m mVar, long j) {
        this.b = mVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.List list;
        java.util.List list2;
        list = this.b.h;
        if (list != null) {
            list2 = this.b.h;
            java.util.Iterator it = list2.iterator();
            while (it.hasNext()) {
                ((com.sijla.e.c) it.next()).a(this.a);
            }
        }
    }
}
