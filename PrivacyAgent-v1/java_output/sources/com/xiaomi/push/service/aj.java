package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class aj {
    private static com.xiaomi.push.service.aj a;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b>> b = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.List<com.xiaomi.push.service.aj.a> c = new java.util.ArrayList();

    public interface a {
        void a();
    }

    public static class b {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public boolean e;
        public java.lang.String f;
        public java.lang.String g;
        public java.lang.String h;
        public java.lang.String i;
        public java.lang.String j;
        public com.xiaomi.push.service.cf k;
        public android.content.Context l;
        com.xiaomi.push.service.c p;
        android.os.Messenger r;
        com.xiaomi.push.service.aj.c m = com.xiaomi.push.service.aj.c.unbind;
        int n = 0;
        public java.util.List<com.xiaomi.push.service.aj.b.a> o = new java.util.ArrayList();
        com.xiaomi.push.service.aj.c q = null;

        /* renamed from: s, reason: collision with root package name */
        boolean f487s = false;
        com.xiaomi.push.service.c.C0535c t = new com.xiaomi.push.service.c.C0535c(this);
        android.os.IBinder.DeathRecipient u = null;
        final com.xiaomi.push.service.aj.b.C0533b v = new com.xiaomi.push.service.aj.b.C0533b();

        public interface a {
            void a(com.xiaomi.push.service.aj.c cVar, com.xiaomi.push.service.aj.c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.aj$b$b, reason: collision with other inner class name */
        public class C0533b extends com.xiaomi.push.service.c.j {
            int a;
            int b;
            java.lang.String c;
            java.lang.String d;

            public C0533b() {
                super(0);
            }

            public final com.xiaomi.push.service.c.j a(int i, int i2, java.lang.String str, java.lang.String str2) {
                this.a = i;
                this.b = i2;
                this.d = str2;
                this.c = str;
                return this;
            }

            @Override // com.xiaomi.push.service.c.j
            public final void a() {
                boolean z;
                java.lang.StringBuilder sb;
                com.xiaomi.push.service.aj.b bVar = com.xiaomi.push.service.aj.b.this;
                com.xiaomi.push.service.aj.c cVar = bVar.q;
                boolean z2 = true;
                if (cVar != null && (z = bVar.f487s)) {
                    if (cVar == bVar.m) {
                        sb = new java.lang.StringBuilder(" status recovered, don't notify client:");
                    } else if (bVar.r == null || !z) {
                        sb = new java.lang.StringBuilder("peer died, ignore notify ");
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + bVar.h);
                    }
                    sb.append(bVar.h);
                    com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
                    z2 = false;
                }
                if (z2) {
                    com.xiaomi.push.service.aj.b.this.a(this.a, this.b, this.c, this.d);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + com.xiaomi.push.service.aj.b.this.h);
            }

            @Override // com.xiaomi.push.service.c.j
            public final java.lang.String b() {
                return "notify job";
            }
        }

        public class c implements android.os.IBinder.DeathRecipient {
            final com.xiaomi.push.service.aj.b a;
            final android.os.Messenger b;

            public c(com.xiaomi.push.service.aj.b bVar, android.os.Messenger messenger) {
                this.a = bVar;
                this.b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.a.h);
                com.xiaomi.push.service.aj.b.this.p.a(new com.xiaomi.push.service.al(this), 0L);
                if ("9".equals(this.a.h) && "com.xiaomi.xmsf".equals(com.xiaomi.push.service.aj.b.this.p.getPackageName())) {
                    com.xiaomi.push.service.aj.b.this.p.a(new com.xiaomi.push.service.am(this), 60000L);
                }
            }
        }

        public b() {
        }

        public b(com.xiaomi.push.service.c cVar) {
            this.p = cVar;
            a(new com.xiaomi.push.service.ak(this));
        }

        private static java.lang.String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        public static java.lang.String a(java.lang.String str) {
            int lastIndexOf;
            return (android.text.TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        private boolean a(int i, int i2, java.lang.String str) {
            return i != 1 ? i != 2 ? i == 3 && !"wait".equals(str) : this.p.b() : (this.m == com.xiaomi.push.service.aj.c.binded || !this.p.b() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
        }

        public final void a() {
            try {
                android.os.Messenger messenger = this.r;
                if (messenger != null && this.u != null) {
                    messenger.getBinder().unlinkToDeath(this.u, 0);
                }
            } catch (java.lang.Exception unused) {
            }
            this.q = null;
        }

        public final void a(int i, int i2, java.lang.String str, java.lang.String str2) {
            com.xiaomi.push.service.aj.c cVar = this.m;
            this.q = cVar;
            if (i == 2) {
                com.xiaomi.push.service.cf.a(this.l, this, i2);
                return;
            }
            if (i == 3) {
                com.xiaomi.push.service.cf.a(this.l, this, str2, str);
                return;
            }
            if (i == 1) {
                boolean z = cVar == com.xiaomi.push.service.aj.c.binded;
                if (!z && "wait".equals(str2)) {
                    this.n++;
                } else if (z) {
                    this.n = 0;
                    if (this.r != null) {
                        try {
                            this.r.send(android.os.Message.obtain(null, 16, this.p.f));
                        } catch (android.os.RemoteException unused) {
                        }
                    }
                }
                com.xiaomi.push.service.cf.a(this.p, this, z, i2, str);
            }
        }

        public final void a(android.os.Messenger messenger) {
            a();
            try {
                if (messenger == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.h);
                } else {
                    this.r = messenger;
                    this.f487s = true;
                    this.u = new com.xiaomi.push.service.aj.b.c(this, messenger);
                    messenger.getBinder().linkToDeath(this.u, 0);
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.r = null;
                this.f487s = false;
            }
        }

        public final void a(com.xiaomi.push.service.aj.b.a aVar) {
            synchronized (this.o) {
                this.o.add(aVar);
            }
        }

        public final void a(com.xiaomi.push.service.aj.c cVar, int i, int i2, java.lang.String str, java.lang.String str2) {
            boolean z;
            synchronized (this.o) {
                java.util.Iterator<com.xiaomi.push.service.aj.b.a> it = this.o.iterator();
                while (it.hasNext()) {
                    it.next().a(this.m, cVar, i2);
                }
            }
            com.xiaomi.push.service.aj.c cVar2 = this.m;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), com.xiaomi.push.service.an.a(i2), str, str2, this.h));
                this.m = cVar;
            }
            if (this.k == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == com.xiaomi.push.service.aj.c.binding) {
                return;
            }
            if (this.q != null && (z = this.f487s)) {
                i3 = (this.r == null || !z) ? 10100 : 1000;
            }
            this.p.a(this.v);
            if (a(i, i2, str2)) {
                a(i, i2, str, str2);
            } else {
                this.p.a(this.v.a(i, i2, str, str2), i3);
            }
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private aj() {
    }

    public static synchronized com.xiaomi.push.service.aj a() {
        com.xiaomi.push.service.aj ajVar;
        synchronized (com.xiaomi.push.service.aj.class) {
            if (a == null) {
                a = new com.xiaomi.push.service.aj();
            }
            ajVar = a;
        }
        return ajVar;
    }

    private static java.lang.String d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public final synchronized void a(int i) {
        java.util.Iterator<java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b>> it = this.b.values().iterator();
        while (it.hasNext()) {
            java.util.Iterator<com.xiaomi.push.service.aj.b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(com.xiaomi.push.service.aj.c.unbind, 2, i, null, null);
            }
        }
    }

    public final synchronized void a(com.xiaomi.push.service.aj.a aVar) {
        this.c.add(aVar);
    }

    public final synchronized void a(com.xiaomi.push.service.aj.b bVar) {
        java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b> hashMap = this.b.get(bVar.h);
        if (hashMap == null) {
            hashMap = new java.util.HashMap<>();
            this.b.put(bVar.h, hashMap);
        }
        hashMap.put(d(bVar.b), bVar);
        com.xiaomi.channel.commonutils.logger.b.a("add active client. " + bVar.a);
        java.util.Iterator<com.xiaomi.push.service.aj.a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final synchronized void a(java.lang.String str) {
        java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b> hashMap = this.b.get(str);
        if (hashMap != null) {
            java.util.Iterator<com.xiaomi.push.service.aj.b> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashMap.clear();
            this.b.remove(str);
        }
        java.util.Iterator<com.xiaomi.push.service.aj.a> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b> hashMap = this.b.get(str);
        if (hashMap != null) {
            com.xiaomi.push.service.aj.b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.a();
            }
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.b.remove(str);
            }
        }
        java.util.Iterator<com.xiaomi.push.service.aj.a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final synchronized com.xiaomi.push.service.aj.b b(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b> hashMap = this.b.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(d(str2));
    }

    public final synchronized java.util.ArrayList<com.xiaomi.push.service.aj.b> b() {
        java.util.ArrayList<com.xiaomi.push.service.aj.b> arrayList;
        arrayList = new java.util.ArrayList<>();
        java.util.Iterator<java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b>> it = this.b.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    public final synchronized java.util.List<java.lang.String> b(java.lang.String str) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b>> it = this.b.values().iterator();
        while (it.hasNext()) {
            for (com.xiaomi.push.service.aj.b bVar : it.next().values()) {
                if (str.equals(bVar.a)) {
                    arrayList.add(bVar.h);
                }
            }
        }
        return arrayList;
    }

    public final synchronized int c() {
        return this.b.size();
    }

    public final synchronized java.util.Collection<com.xiaomi.push.service.aj.b> c(java.lang.String str) {
        if (this.b.containsKey(str)) {
            return ((java.util.HashMap) this.b.get(str).clone()).values();
        }
        return new java.util.ArrayList();
    }

    public final synchronized void d() {
        java.util.Iterator<com.xiaomi.push.service.aj.b> it = b().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.b.clear();
    }

    public final synchronized void e() {
        java.util.Iterator<java.util.HashMap<java.lang.String, com.xiaomi.push.service.aj.b>> it = this.b.values().iterator();
        while (it.hasNext()) {
            java.util.Iterator<com.xiaomi.push.service.aj.b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(com.xiaomi.push.service.aj.c.unbind, 1, 3, null, null);
            }
        }
    }

    public final synchronized void f() {
        this.c.clear();
    }
}
