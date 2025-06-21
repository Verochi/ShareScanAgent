package com.igexin.base.boatman;

/* loaded from: classes22.dex */
public final class b {
    public final java.util.concurrent.locks.ReentrantLock a = new java.util.concurrent.locks.ReentrantLock();
    public final java.util.Map<java.lang.String, com.igexin.base.boatman.receive.Site> b = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.Map<java.lang.String, java.util.List<com.igexin.base.boatman.a>> c = new java.util.HashMap();

    public final <B, V> void a(com.igexin.base.boatman.Boater<B, V> boater, B b, com.igexin.base.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.base.boatman.receive.Site site = this.b.get(boater.getTag());
        if (site == null) {
            return;
        }
        site.onArrived(b, iBoatResult);
    }

    public final boolean a(com.igexin.base.boatman.Boater boater, java.lang.Object obj) {
        java.lang.String tag = boater.getTag();
        this.a.lock();
        try {
            java.util.List<com.igexin.base.boatman.a> list = this.c.get(tag);
            boolean z = false;
            if (list == null) {
                return false;
            }
            java.util.Iterator<com.igexin.base.boatman.a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a == obj) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        } finally {
            this.a.unlock();
        }
    }
}
