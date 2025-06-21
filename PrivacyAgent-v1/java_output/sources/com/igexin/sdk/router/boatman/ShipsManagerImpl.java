package com.igexin.sdk.router.boatman;

/* loaded from: classes23.dex */
public final class ShipsManagerImpl implements com.igexin.sdk.router.boatman.IShips {
    private final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
    private final java.util.Map<java.lang.String, com.igexin.sdk.router.boatman.receive.Site> subMaps = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.Map<java.lang.String, java.util.List<com.igexin.sdk.router.boatman.BoatBean>> cacheMaps = new java.util.HashMap();

    @Override // com.igexin.sdk.router.boatman.IShips
    public final boolean isRegistered(com.igexin.sdk.router.boatman.receive.Site site) {
        return this.subMaps.containsKey(site.getTag());
    }

    public final <B, V> void postASync(com.igexin.sdk.router.boatman.Boater<B, V> boater, B b, com.igexin.sdk.router.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.sdk.router.boatman.receive.Site site = this.subMaps.get(boater.getTag());
        if (site == null) {
            return;
        }
        site.onArrived(b, iBoatResult);
    }

    public final <B, V> void postSticky(com.igexin.sdk.router.boatman.Boater<B, V> boater, B b, com.igexin.sdk.router.boatman.receive.IBoatResult<V> iBoatResult) {
        java.lang.String tag = boater.getTag();
        this.lock.lock();
        try {
            boolean containsKey = this.subMaps.containsKey(boater.getTag());
            if (!containsKey) {
                if (this.cacheMaps.get(tag) == null) {
                    this.cacheMaps.put(tag, new java.util.ArrayList());
                }
                this.cacheMaps.get(tag).add(new com.igexin.sdk.router.boatman.BoatBean(b, iBoatResult));
            }
            if (containsKey) {
                postASync(boater, b, iBoatResult);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public final <B, V> V postSync(com.igexin.sdk.router.boatman.Boater<B, V> boater, B b) {
        com.igexin.sdk.router.boatman.receive.Site site = this.subMaps.get(boater.getTag());
        if (site == null) {
            return null;
        }
        return (V) site.onArrived(b);
    }

    @Override // com.igexin.sdk.router.boatman.IShips
    public final void register(com.igexin.sdk.router.boatman.receive.Site site) {
        java.lang.String tag = site.getTag();
        this.lock.lock();
        try {
            this.subMaps.put(tag, site);
            java.util.List<com.igexin.sdk.router.boatman.BoatBean> list = this.cacheMaps.get(tag);
            if (list != null && list.size() > 0) {
                java.util.Iterator<com.igexin.sdk.router.boatman.BoatBean> it = list.iterator();
                while (it.hasNext()) {
                    com.igexin.sdk.router.boatman.BoatBean next = it.next();
                    if (next.getListener() != null) {
                        site.onArrived(next.getBag(), next.getListener());
                    }
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public final boolean removeSticky(com.igexin.sdk.router.boatman.Boater boater, java.lang.Object obj) {
        java.lang.String tag = boater.getTag();
        this.lock.lock();
        try {
            java.util.List<com.igexin.sdk.router.boatman.BoatBean> list = this.cacheMaps.get(tag);
            boolean z = false;
            if (list == null) {
                return false;
            }
            java.util.Iterator<com.igexin.sdk.router.boatman.BoatBean> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getBag() == obj) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.igexin.sdk.router.boatman.IShips
    public final void unRegister(com.igexin.sdk.router.boatman.receive.Site site) {
        this.lock.lock();
        try {
            this.subMaps.remove(site.getTag());
        } finally {
            this.lock.unlock();
        }
    }
}
