package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class ev {
    public static boolean a;
    private static final java.util.concurrent.atomic.AtomicInteger r = new java.util.concurrent.atomic.AtomicInteger(0);
    protected com.xiaomi.push.fi j;
    protected com.xiaomi.push.ew o;
    protected com.xiaomi.push.service.c p;
    protected int b = 0;
    protected long c = -1;
    protected volatile long d = 0;
    protected volatile long e = 0;
    public java.util.LinkedList<android.util.Pair<java.lang.Integer, java.lang.Long>> f = new java.util.LinkedList<>();
    public final java.util.Collection<com.xiaomi.push.ey> g = new java.util.concurrent.CopyOnWriteArrayList();
    protected final java.util.Map<com.xiaomi.push.fb, com.xiaomi.push.ev.a> h = new java.util.concurrent.ConcurrentHashMap();
    protected final java.util.Map<com.xiaomi.push.fb, com.xiaomi.push.ev.a> i = new java.util.concurrent.ConcurrentHashMap();
    protected java.lang.String k = "";
    protected java.lang.String l = "";
    int m = 2;
    protected final int n = r.getAndIncrement();

    /* renamed from: s, reason: collision with root package name */
    private long f464s = 0;
    protected long q = 0;

    public static class a {
        com.xiaomi.push.fb a;
        private com.xiaomi.push.fj b;

        public a(com.xiaomi.push.fb fbVar, com.xiaomi.push.fj fjVar) {
            this.a = fbVar;
            this.b = fjVar;
        }

        public final void a(com.xiaomi.push.ek ekVar) {
            this.a.a(ekVar);
        }
    }

    static {
        a = false;
        try {
            a = java.lang.Boolean.getBoolean("smack.debugEnabled");
        } catch (java.lang.Exception unused) {
        }
        com.xiaomi.push.fc.a();
    }

    public ev(com.xiaomi.push.service.c cVar, com.xiaomi.push.ew ewVar) {
        java.lang.String str;
        java.lang.Class<?> cls = null;
        this.j = null;
        this.o = ewVar;
        this.p = cVar;
        if (ewVar.f && this.j == null) {
            try {
                str = java.lang.System.getProperty("smack.debuggerClass");
            } catch (java.lang.Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = java.lang.Class.forName(str);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.j = new com.xiaomi.push.et(this);
                return;
            }
            try {
                this.j = (com.xiaomi.push.fi) cls.getConstructor(com.xiaomi.push.ev.class, java.io.Writer.class, java.io.Reader.class).newInstance(this);
            } catch (java.lang.Exception e2) {
                throw new java.lang.IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    private static java.lang.String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DISCONNECTED : "unknown";
    }

    public final void a(int i, int i2, java.lang.Exception exc) {
        int i3 = this.m;
        if (i != i3) {
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.an.a(i2)));
        }
        if (com.xiaomi.push.ai.a(this.p)) {
            synchronized (this.f) {
                if (i == 1) {
                    this.f.clear();
                } else {
                    this.f.add(new android.util.Pair<>(java.lang.Integer.valueOf(i), java.lang.Long.valueOf(java.lang.System.currentTimeMillis())));
                    if (this.f.size() > 6) {
                        this.f.remove(0);
                    }
                }
            }
        }
        if (i == 1) {
            this.p.a(10);
            if (this.m != 0) {
                com.xiaomi.channel.commonutils.logger.b.a("try set connected while not connecting.");
            }
            this.m = i;
            java.util.Iterator<com.xiaomi.push.ey> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i == 0) {
            if (this.m != 2) {
                com.xiaomi.channel.commonutils.logger.b.a("try set connecting while not disconnected.");
            }
            this.m = i;
            java.util.Iterator<com.xiaomi.push.ey> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i == 2) {
            this.p.a(10);
            int i4 = this.m;
            if (i4 == 0) {
                java.util.Iterator<com.xiaomi.push.ey> it3 = this.g.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new java.util.concurrent.CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                java.util.Iterator<com.xiaomi.push.ey> it4 = this.g.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i2, exc);
                }
            }
            this.m = i;
        }
    }

    public final void a(com.xiaomi.push.fb fbVar, com.xiaomi.push.fj fjVar) {
        if (fbVar == null) {
            throw new java.lang.NullPointerException("Packet listener is null.");
        }
        this.h.put(fbVar, new com.xiaomi.push.ev.a(fbVar, fjVar));
    }

    public abstract void a(com.xiaomi.push.fn fnVar);

    public abstract void a(com.xiaomi.push.service.aj.b bVar);

    public final synchronized void a(java.lang.String str) {
        if (this.m != 0) {
            com.xiaomi.channel.commonutils.logger.b.a("ignore setChallenge because connection was disconnected");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("setChallenge hash = " + com.xiaomi.push.an.a(str).substring(0, 8));
        this.k = str;
        a(1, 0, null);
    }

    public abstract void a(java.lang.String str, java.lang.String str2);

    public abstract void a(com.xiaomi.push.ek[] ekVarArr);

    public final synchronized boolean a(long j) {
        return this.f464s >= j;
    }

    public abstract void b(int i, java.lang.Exception exc);

    public abstract void b(com.xiaomi.push.ek ekVar);

    public final void b(com.xiaomi.push.fb fbVar, com.xiaomi.push.fj fjVar) {
        if (fbVar == null) {
            throw new java.lang.NullPointerException("Packet listener is null.");
        }
        this.i.put(fbVar, new com.xiaomi.push.ev.a(fbVar, fjVar));
    }

    public abstract void b(boolean z);

    public boolean b() {
        return false;
    }

    public final com.xiaomi.push.ew d() {
        return this.o;
    }

    public java.lang.String e() {
        return this.o.c();
    }

    public final java.lang.String f() {
        return this.o.g;
    }

    public final long g() {
        return this.e;
    }

    public final java.util.Map<com.xiaomi.push.fb, com.xiaomi.push.ev.a> h() {
        return this.h;
    }

    public final boolean i() {
        return this.m == 0;
    }

    public final boolean j() {
        return this.m == 1;
    }

    public final int k() {
        return this.b;
    }

    public final synchronized void l() {
        this.f464s = android.os.SystemClock.elapsedRealtime();
    }
}
