package com.getui.gtc.extension.distribution.gbd.m.b;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String i = "Up_R";
    protected com.getui.gtc.extension.distribution.gbd.m.a.a a;
    protected java.util.concurrent.locks.ReentrantReadWriteLock b;
    protected java.util.concurrent.locks.Lock c;
    protected java.util.concurrent.locks.Lock d;
    protected volatile boolean e;
    protected com.getui.gtc.extension.distribution.gbd.m.e.b f;
    protected final java.util.Map<java.net.NetworkInterface, com.getui.gtc.extension.distribution.gbd.m.e.a> g;
    protected final java.util.Map<java.net.InetAddress, com.getui.gtc.extension.distribution.gbd.m.e.c> h;

    public a(com.getui.gtc.extension.distribution.gbd.m.a.a aVar) {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock(false);
        this.b = reentrantReadWriteLock;
        this.c = reentrantReadWriteLock.readLock();
        this.d = this.b.writeLock();
        this.g = new java.util.HashMap();
        this.h = new java.util.HashMap();
        this.a = aVar;
    }

    private void a(java.util.List<java.net.NetworkInterface> list) {
        for (java.net.NetworkInterface networkInterface : list) {
            com.getui.gtc.extension.distribution.gbd.m.e.a aVar = new com.getui.gtc.extension.distribution.gbd.m.e.a(java.net.InetAddress.getByName("239.255.255.250"));
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Init multicast receiver on interface: " + networkInterface.getDisplayName());
                aVar.a(networkInterface);
                this.g.put(networkInterface, aVar);
            } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.b e) {
                throw e;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(i, "multicastReceivers size = " + this.g.size());
        for (java.util.Map.Entry<java.net.NetworkInterface, com.getui.gtc.extension.distribution.gbd.m.e.a> entry : this.g.entrySet()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "For starting multicast receiver on interface: " + entry.getKey().getDisplayName());
            this.a.a.execute(entry.getValue());
        }
    }

    private static void a(java.util.concurrent.locks.Lock lock) {
        try {
            if (!lock.tryLock(6000L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                throw new com.getui.gtc.extension.distribution.gbd.m.c.a.e("Router wasn't available exclusively after waiting 6000ms, lock failed: " + lock.getClass());
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Acquired router lock: " + lock.getClass());
        } catch (java.lang.InterruptedException e) {
            throw new com.getui.gtc.extension.distribution.gbd.m.c.a.e("Interruption while waiting for exclusive access: " + lock.getClass().getSimpleName(), e);
        }
    }

    private void b(java.util.List<java.net.InetAddress> list) {
        for (java.net.InetAddress inetAddress : list) {
            com.getui.gtc.extension.distribution.gbd.m.e.c cVar = new com.getui.gtc.extension.distribution.gbd.m.e.c();
            try {
                cVar.a(inetAddress);
                this.h.put(inetAddress, cVar);
            } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.b e) {
                throw e;
            }
        }
        java.util.Iterator<java.util.Map.Entry<java.net.InetAddress, com.getui.gtc.extension.distribution.gbd.m.e.c>> it = this.h.entrySet().iterator();
        while (it.hasNext()) {
            this.a.a.execute(it.next().getValue());
        }
    }

    private static void b(java.util.concurrent.locks.Lock lock) {
        a(lock);
    }

    private static int c() {
        return com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR;
    }

    private static void c(java.util.concurrent.locks.Lock lock) {
        lock.unlock();
    }

    private void d() {
        b();
    }

    public final void a() {
        a(this.d);
        try {
            if (!this.e) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Router enable, Starting networking services.");
                com.getui.gtc.extension.distribution.gbd.m.e.b bVar = new com.getui.gtc.extension.distribution.gbd.m.e.b();
                this.f = bVar;
                if (!bVar.c()) {
                    throw new com.getui.gtc.extension.distribution.gbd.m.c.a.d("No usable network interface and/or addresses available, check the log for errors.");
                }
                for (java.net.NetworkInterface networkInterface : this.f.a()) {
                    com.getui.gtc.extension.distribution.gbd.m.e.a aVar = new com.getui.gtc.extension.distribution.gbd.m.e.a(java.net.InetAddress.getByName("239.255.255.250"));
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Init multicast receiver on interface: " + networkInterface.getDisplayName());
                        aVar.a(networkInterface);
                        this.g.put(networkInterface, aVar);
                    } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.b e) {
                        throw e;
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "multicastReceivers size = " + this.g.size());
                for (java.util.Map.Entry<java.net.NetworkInterface, com.getui.gtc.extension.distribution.gbd.m.e.a> entry : this.g.entrySet()) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "For starting multicast receiver on interface: " + entry.getKey().getDisplayName());
                    this.a.a.execute(entry.getValue());
                }
                b(this.f.b());
                this.e = true;
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.m.f.a aVar) {
        a(this.c);
        try {
            if (this.e) {
                java.util.Iterator<com.getui.gtc.extension.distribution.gbd.m.e.c> it = this.h.values().iterator();
                while (it.hasNext()) {
                    it.next().a(aVar);
                }
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "upnp discover udp message send not enable. ");
            }
        } finally {
            this.c.unlock();
        }
    }

    public final boolean b() {
        a(this.d);
        try {
            if (!this.e) {
                return false;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Disabling network services...");
            for (java.util.Map.Entry<java.net.NetworkInterface, com.getui.gtc.extension.distribution.gbd.m.e.a> entry : this.g.entrySet()) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "Stopping multicast receiver on interface: " + entry.getKey().getDisplayName());
                entry.getValue().a();
            }
            this.g.clear();
            java.util.Iterator<java.util.Map.Entry<java.net.InetAddress, com.getui.gtc.extension.distribution.gbd.m.e.c>> it = this.h.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
            this.h.clear();
            this.f = null;
            this.e = false;
            this.d.unlock();
            return true;
        } finally {
            this.d.unlock();
        }
    }
}
