package com.igexin.c.a.b.a.a;

/* loaded from: classes22.dex */
public final class d {
    static final java.lang.Object j = new java.lang.Object();
    private static final java.lang.String n = "GS-M";
    java.net.Socket a;
    com.igexin.c.a.b.a.a.e b;
    com.igexin.c.a.b.a.a.g c;
    com.igexin.c.a.b.a.a.b d;
    final android.os.Handler e;
    boolean f;
    protected java.util.concurrent.locks.Lock g;
    protected java.util.concurrent.locks.Condition h;
    final java.util.List<com.igexin.c.a.b.a.a.f> i;
    protected java.util.concurrent.ConcurrentLinkedQueue<com.igexin.c.a.b.a.a.f> k;
    long l;
    final java.util.Comparator<com.igexin.c.a.b.a.a.f> m;
    private com.igexin.c.a.b.d o;
    private final java.util.concurrent.atomic.AtomicBoolean p;

    /* renamed from: com.igexin.c.a.b.a.a.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.igexin.c.a.b.a.a.a.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            com.igexin.c.a.c.a.a(com.igexin.c.a.b.a.a.d.n, "connect hand INTERRUPT_SUCCESS");
            com.igexin.c.a.b.a.a.d.this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(java.lang.Exception exc) {
            com.igexin.c.a.c.a.a(com.igexin.c.a.b.a.a.d.n, "connect exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|c ex = " + exc.toString(), new java.lang.Object[0]);
            com.igexin.c.a.b.a.a.d.this.c();
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(java.net.Socket socket) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = socket;
            obtain.what = com.igexin.c.a.b.a.a.j.c - 1;
            com.igexin.c.a.b.a.a.d.this.e.sendMessage(obtain);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void b() {
            com.igexin.c.a.b.a.a.d.this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.e - 1);
        }
    }

    /* renamed from: com.igexin.c.a.b.a.a.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.igexin.c.a.b.a.a.a.b {
        public AnonymousClass2() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            com.igexin.c.a.b.a.a.d.this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void a(java.lang.Exception exc) {
            com.igexin.c.a.c.a.a(com.igexin.c.a.b.a.a.d.n, "readTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|r ex = " + exc.toString(), new java.lang.Object[0]);
            if (exc.getMessage() == null || !exc.getMessage().equals("end of stream")) {
                com.igexin.c.a.b.a.a.d.this.c();
            } else {
                com.igexin.push.d.c.b.a.c();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void b() {
        }
    }

    /* renamed from: com.igexin.c.a.b.a.a.d$3, reason: invalid class name */
    public class AnonymousClass3 implements com.igexin.c.a.b.a.a.a.c {
        public AnonymousClass3() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            com.igexin.c.a.b.a.a.d.this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(com.igexin.c.a.b.a.a.f fVar) {
            com.igexin.c.a.b.a.a.d dVar = com.igexin.c.a.b.a.a.d.this;
            if (fVar.B <= 0 || fVar.G == null) {
                fVar.l();
                return;
            }
            fVar.z = java.lang.System.currentTimeMillis();
            synchronized (com.igexin.c.a.b.a.a.d.j) {
                dVar.i.add(fVar);
                java.util.Collections.sort(dVar.i, dVar.m);
                fVar.d.getClass();
                long millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(dVar.i.get(0).B);
                dVar.l = millis;
                if (millis > 0 && dVar.i.size() == 1) {
                    fVar.d.getClass();
                    com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + dVar.l, new java.lang.Object[0]);
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = com.igexin.c.a.b.a.a.j.h - 1;
                    obtain.obj = fVar.d.getClass().getSimpleName();
                    dVar.e.sendMessageDelayed(obtain, dVar.l);
                }
                dVar.i.size();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(java.lang.Exception exc) {
            com.igexin.c.a.c.a.a(com.igexin.c.a.b.a.a.d.n, "writeTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|w ex = " + exc.toString(), new java.lang.Object[0]);
            com.igexin.c.a.b.a.a.d.this.c();
        }
    }

    /* renamed from: com.igexin.c.a.b.a.a.d$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.Comparator<com.igexin.c.a.b.a.a.f> {
        public AnonymousClass4() {
        }

        private static int a(com.igexin.c.a.b.a.a.f fVar, com.igexin.c.a.b.a.a.f fVar2) {
            if (fVar == null) {
                return 1;
            }
            if (fVar2 == null) {
                return -1;
            }
            return java.lang.Long.compare(fVar.B + fVar.z, fVar2.B + fVar2.z);
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.igexin.c.a.b.a.a.f fVar, com.igexin.c.a.b.a.a.f fVar2) {
            com.igexin.c.a.b.a.a.f fVar3 = fVar;
            com.igexin.c.a.b.a.a.f fVar4 = fVar2;
            if (fVar3 == null) {
                return 1;
            }
            if (fVar4 == null) {
                return -1;
            }
            return java.lang.Long.compare(fVar3.B + fVar3.z, fVar4.B + fVar4.z);
        }
    }

    public static class a {
        private static final com.igexin.c.a.b.a.a.d a = new com.igexin.c.a.b.a.a.d((byte) 0);

        private a() {
        }
    }

    private d() {
        this.p = new java.util.concurrent.atomic.AtomicBoolean(false);
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.g = reentrantLock;
        this.h = reentrantLock.newCondition();
        this.i = new java.util.ArrayList();
        this.k = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.m = new com.igexin.c.a.b.a.a.d.AnonymousClass4();
        this.e = com.igexin.push.core.d.a.a.e;
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static com.igexin.c.a.b.a.a.d a() {
        return com.igexin.c.a.b.a.a.d.a.a;
    }

    private void a(java.lang.Object obj) {
        com.igexin.c.a.c.a.b(n, ((java.lang.String) obj) + " write task response timeout");
        c();
    }

    private void b(com.igexin.c.a.b.a.a.f fVar) {
        if (fVar.B <= 0 || fVar.G == null) {
            fVar.l();
            return;
        }
        fVar.z = java.lang.System.currentTimeMillis();
        synchronized (j) {
            this.i.add(fVar);
            java.util.Collections.sort(this.i, this.m);
            fVar.d.getClass();
            long millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(this.i.get(0).B);
            this.l = millis;
            if (millis > 0 && this.i.size() == 1) {
                fVar.d.getClass();
                com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + this.l, new java.lang.Object[0]);
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = com.igexin.c.a.b.a.a.j.h - 1;
                obtain.obj = fVar.d.getClass().getSimpleName();
                this.e.sendMessageDelayed(obtain, this.l);
            }
            this.i.size();
        }
    }

    private void b(java.net.Socket socket) throws java.lang.Exception {
        com.igexin.c.a.b.a.a.e eVar = new com.igexin.c.a.b.a.a.e(new com.igexin.c.a.b.a.a.h(socket.getInputStream()), this.o);
        this.b = eVar;
        eVar.k = new com.igexin.c.a.b.a.a.d.AnonymousClass2();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
    }

    private void c(java.net.Socket socket) throws java.lang.Exception {
        com.igexin.c.a.b.a.a.g gVar = new com.igexin.c.a.b.a.a.g(new com.igexin.c.a.b.a.a.i(socket.getOutputStream()), this.o);
        this.c = gVar;
        gVar.j = new com.igexin.c.a.b.a.a.d.AnonymousClass3();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.c, true);
    }

    private static void k() {
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.e.a.a(com.igexin.c.a.b.a.a.j.a);
    }

    private void l() {
        j();
        if ((this.d == null && this.c == null && this.b == null) || i()) {
            b();
        } else {
            h();
        }
    }

    private void m() {
        java.net.Socket socket = this.a;
        boolean z = (socket == null || socket.isClosed()) ? false : true;
        if (!z && this.d == null) {
            com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new java.lang.Object[0]);
            this.d = new com.igexin.c.a.b.a.a.b(new com.igexin.c.a.b.a.a.d.AnonymousClass1());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.d, true);
        } else {
            com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + this.d, new java.lang.Object[0]);
        }
    }

    private void n() {
        com.igexin.c.a.b.a.a.g gVar = this.c;
        if (gVar != null) {
            gVar.l = null;
            this.c = null;
        }
        com.igexin.c.a.b.a.a.e eVar = this.b;
        if (eVar != null) {
            eVar.j = null;
            this.b = null;
        }
        this.d = null;
        this.a = null;
    }

    private void o() {
        if (!i() || this.f) {
            return;
        }
        b();
        this.f = true;
    }

    private boolean p() {
        java.net.Socket socket = this.a;
        return (socket == null || socket.isClosed()) ? false : true;
    }

    public final void a(com.igexin.c.a.b.a.a.f fVar) {
        try {
            try {
                this.g.lock();
                this.k.offer(fVar);
                this.h.signalAll();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                try {
                    this.g.unlock();
                } catch (java.lang.Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
            }
        } finally {
            try {
                this.g.unlock();
            } catch (java.lang.Exception e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
    }

    public final void a(com.igexin.c.a.b.d dVar) {
        this.o = dVar;
        com.igexin.c.a.b.a.a.e eVar = this.b;
        if (eVar != null) {
            eVar.l = dVar;
        }
        com.igexin.c.a.b.a.a.g gVar = this.c;
        if (gVar != null) {
            gVar.k = dVar;
        }
    }

    public final void a(java.lang.String str) {
        boolean z;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        synchronized (j) {
            com.igexin.c.a.c.a.a("GS-M|" + str + " -- resp,no timeout", new java.lang.Object[0]);
            this.l = 0L;
            java.util.Iterator<com.igexin.c.a.b.a.a.f> it = this.i.iterator();
            java.lang.String str2 = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.igexin.c.a.b.a.a.f next = it.next();
                if (next.G.a(currentTimeMillis, next)) {
                    next.l();
                    next.G.c();
                    it.remove();
                    z = true;
                    break;
                }
                long b = next.G.b(currentTimeMillis, next);
                long j2 = this.l;
                if (j2 < 0 || j2 > b) {
                    this.l = b;
                    str2 = next.d.getClass().getSimpleName();
                }
            }
            android.os.Handler handler = this.e;
            int i = com.igexin.c.a.b.a.a.j.h;
            handler.removeMessages(i - 1);
            if (z) {
                com.igexin.c.a.c.a.a("GS-M|timeout", new java.lang.Object[0]);
                f();
                return;
            }
            if (this.i.size() > 0) {
                com.igexin.c.a.b.a.a.f fVar = this.i.get(0);
                fVar.l();
                com.igexin.c.a.b.e.a().a((java.lang.Object) fVar);
                this.i.remove(fVar);
                fVar.d.getClass();
                com.igexin.c.a.c.a.a("GS-M|remove : " + fVar.toString() + " -- " + fVar.d.getClass().getSimpleName(), new java.lang.Object[0]);
            }
            int size = this.i.size();
            com.igexin.c.a.c.a.a("GS-M|r, size = ".concat(java.lang.String.valueOf(size)), new java.lang.Object[0]);
            if (size > 0 && this.l > 0 && !android.text.TextUtils.isEmpty(str2)) {
                com.igexin.c.a.c.a.a("GS-M|" + str2 + " , set  response timeout = " + this.l, new java.lang.Object[0]);
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = i - 1;
                obtain.obj = str2;
                this.e.sendMessageDelayed(obtain, this.l);
            }
        }
    }

    public final void a(java.net.Socket socket) {
        try {
            if (this.d.g()) {
                return;
            }
            this.a = socket;
            com.igexin.c.a.b.a.a.e eVar = new com.igexin.c.a.b.a.a.e(new com.igexin.c.a.b.a.a.h(socket.getInputStream()), this.o);
            this.b = eVar;
            eVar.k = new com.igexin.c.a.b.a.a.d.AnonymousClass2();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
            com.igexin.c.a.b.a.a.g gVar = new com.igexin.c.a.b.a.a.g(new com.igexin.c.a.b.a.a.i(socket.getOutputStream()), this.o);
            this.c = gVar;
            gVar.j = new com.igexin.c.a.b.a.a.d.AnonymousClass3();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.c, true);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a("GS-M|" + e.toString(), new java.lang.Object[0]);
            com.igexin.c.a.c.a.a(n, "tcpConnect exception =" + e.toString());
            c();
        }
    }

    public final void b() {
        this.p.set(false);
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.e.a.a(com.igexin.c.a.b.a.a.j.b);
    }

    public final void c() {
        if (this.p.getAndSet(true)) {
            return;
        }
        this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.a - 1);
    }

    public final synchronized void d() {
        com.igexin.c.a.c.a.a(n, "disConnect, hand TCP_DISCONNECT");
        this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.g - 1);
    }

    public final synchronized void e() {
        this.e.sendEmptyMessage(com.igexin.c.a.b.a.a.j.d - 1);
        this.f = false;
    }

    public final synchronized void f() {
        com.igexin.c.a.c.a.a(n, "alarm timeout disconnect");
        com.igexin.c.a.c.a.a("GS-M|alarm timeout disconnect", new java.lang.Object[0]);
        c();
    }

    public final synchronized void g() {
        com.igexin.c.a.c.a.a(n, "redirect disconnect");
        com.igexin.c.a.c.a.a("GS-M|redirect disconnect", new java.lang.Object[0]);
        c();
    }

    public final void h() {
        com.igexin.c.a.c.a.a(n, "disconnect");
        com.igexin.c.a.c.a.a("GS-M|disconnect", new java.lang.Object[0]);
        com.igexin.c.a.b.a.a.b bVar = this.d;
        if (bVar != null) {
            bVar.c_();
        }
        com.igexin.c.a.b.a.a.g gVar = this.c;
        if (gVar != null) {
            gVar.c_();
        }
        com.igexin.c.a.b.a.a.e eVar = this.b;
        if (eVar != null) {
            eVar.c_();
        }
        java.net.Socket socket = this.a;
        if (socket != null) {
            try {
                if (socket.isClosed()) {
                    return;
                }
                this.a.close();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    public final boolean i() {
        com.igexin.c.a.b.a.a.b bVar = this.d;
        if (bVar != null && !bVar.f) {
            return false;
        }
        com.igexin.c.a.b.a.a.e eVar = this.b;
        if (eVar != null && !eVar.f) {
            return false;
        }
        com.igexin.c.a.b.a.a.g gVar = this.c;
        if (gVar != null && !gVar.f) {
            return false;
        }
        n();
        return true;
    }

    public final void j() {
        this.e.removeMessages(com.igexin.c.a.b.a.a.j.h - 1);
        com.igexin.c.a.b.e.a().d();
        com.igexin.c.a.c.a.a("GS-M|cancel alarm", new java.lang.Object[0]);
        synchronized (j) {
            if (!this.i.isEmpty()) {
                java.util.Iterator<com.igexin.c.a.b.a.a.f> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
                this.i.clear();
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        java.util.Iterator<com.igexin.c.a.b.a.a.f> it2 = this.k.iterator();
        while (it2.hasNext()) {
            it2.next().l();
        }
        this.k.clear();
    }
}
