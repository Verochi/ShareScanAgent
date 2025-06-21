package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cl {
    private static long c;
    private static long d;
    private static long e;
    final com.xiaomi.push.service.cl.c a;
    final com.xiaomi.push.service.cl.a b;

    public static final class a {
        private final com.xiaomi.push.service.cl.c a;

        public a(com.xiaomi.push.service.cl.c cVar) {
            this.a = cVar;
        }

        public final void finalize() {
            try {
                synchronized (this.a) {
                    com.xiaomi.push.service.cl.c.a(this.a);
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements java.lang.Runnable {
        protected int f;

        public b(int i) {
            this.f = i;
        }
    }

    public static final class c extends java.lang.Thread {
        private boolean d;
        private boolean e;
        volatile long a = 0;
        volatile boolean b = false;
        private long c = 50;
        private com.xiaomi.push.service.cl.c.a f = new com.xiaomi.push.service.cl.c.a((byte) 0);

        public static final class a {
            com.xiaomi.push.service.cl.d[] a;
            int b;
            private int c;
            private int d;

            private a() {
                this.c = 256;
                this.a = new com.xiaomi.push.service.cl.d[256];
                this.b = 0;
                this.d = 0;
            }

            public /* synthetic */ a(byte b) {
                this();
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        com.xiaomi.push.service.cl.d[] dVarArr = this.a;
                        if (dVarArr[i4].c < dVarArr[i2].c) {
                            i2 = i4;
                        }
                    }
                    com.xiaomi.push.service.cl.d[] dVarArr2 = this.a;
                    com.xiaomi.push.service.cl.d dVar = dVarArr2[i];
                    long j = dVar.c;
                    com.xiaomi.push.service.cl.d dVar2 = dVarArr2[i2];
                    if (j < dVar2.c) {
                        return;
                    }
                    dVarArr2[i] = dVar2;
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public final int a(com.xiaomi.push.service.cl.d dVar) {
                int i = 0;
                while (true) {
                    com.xiaomi.push.service.cl.d[] dVarArr = this.a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            public final void a() {
                this.a = new com.xiaomi.push.service.cl.d[this.c];
                this.b = 0;
            }

            public final void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    com.xiaomi.push.service.cl.d dVar = this.a[i2];
                    if (dVar.e == i) {
                        dVar.a();
                    }
                }
                b();
            }

            public final void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.a[i].b) {
                        this.d++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            public final void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                com.xiaomi.push.service.cl.d[] dVarArr = this.a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }

            public final void b(com.xiaomi.push.service.cl.d dVar) {
                android.content.Intent intent;
                com.xiaomi.push.service.cl.b bVar = dVar.d;
                int i = bVar.f;
                if (i == 8) {
                    com.xiaomi.push.service.c.d dVar2 = (com.xiaomi.push.service.c.d) bVar;
                    com.xiaomi.push.service.s sVar = dVar2.a.e;
                    if (sVar != null) {
                        sVar.f = java.lang.System.currentTimeMillis();
                        dVar2.a.e.b = a(dVar);
                        return;
                    }
                    return;
                }
                if (i == 15 && (intent = ((com.xiaomi.push.service.c.i) bVar).a) != null && com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("enqueue", java.lang.System.currentTimeMillis());
                    intent.putExtra("num", a(dVar));
                }
            }
        }

        public c(java.lang.String str) {
            setName(str);
            setDaemon(false);
            start();
        }

        public static /* synthetic */ void a(com.xiaomi.push.service.cl.c cVar, com.xiaomi.push.service.cl.d dVar) {
            com.xiaomi.push.service.cl.c.a aVar = cVar.f;
            com.xiaomi.push.service.cl.d[] dVarArr = aVar.a;
            int length = dVarArr.length;
            int i = aVar.b;
            if (length == i) {
                com.xiaomi.push.service.cl.d[] dVarArr2 = new com.xiaomi.push.service.cl.d[i * 2];
                java.lang.System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                aVar.a = dVarArr2;
            }
            com.xiaomi.push.service.cl.d[] dVarArr3 = aVar.a;
            int i2 = aVar.b;
            int i3 = i2 + 1;
            aVar.b = i3;
            dVarArr3[i2] = dVar;
            int i4 = i3 - 1;
            int i5 = (i4 - 1) / 2;
            while (true) {
                com.xiaomi.push.service.cl.d[] dVarArr4 = aVar.a;
                com.xiaomi.push.service.cl.d dVar2 = dVarArr4[i4];
                long j = dVar2.c;
                com.xiaomi.push.service.cl.d dVar3 = dVarArr4[i5];
                if (j >= dVar3.c) {
                    aVar.b(dVar);
                    cVar.notify();
                    return;
                } else {
                    dVarArr4[i4] = dVar3;
                    dVarArr4[i5] = dVar2;
                    i4 = i5;
                    i5 = (i5 - 1) / 2;
                }
            }
        }

        public static /* synthetic */ boolean a(com.xiaomi.push.service.cl.c cVar) {
            cVar.e = true;
            return true;
        }

        public final synchronized void a() {
            this.d = true;
            this.f.a();
            notify();
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
        
            r12.a = android.os.SystemClock.uptimeMillis();
            r12.b = true;
            r0.d.run();
            r12.b = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
        
            monitor-enter(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
        
            r12.d = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a8, code lost:
        
            throw r0;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            while (true) {
                synchronized (this) {
                    if (this.d) {
                        return;
                    }
                    if (!(this.f.b == 0)) {
                        long a2 = com.xiaomi.push.service.cl.a();
                        com.xiaomi.push.service.cl.d dVar = this.f.a[0];
                        synchronized (dVar.a) {
                            if (dVar.b) {
                                this.f.b(0);
                            } else {
                                long j = dVar.c - a2;
                                if (j > 0) {
                                    long j2 = this.c;
                                    if (j > j2) {
                                        j = j2;
                                    }
                                    long j3 = j2 + 50;
                                    this.c = j3;
                                    if (j3 > 500) {
                                        this.c = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.c = 50L;
                                    synchronized (dVar.a) {
                                        com.xiaomi.push.service.cl.c.a aVar = this.f;
                                        int a3 = aVar.a[0].c != dVar.c ? aVar.a(dVar) : 0;
                                        if (dVar.b) {
                                            com.xiaomi.push.service.cl.c.a aVar2 = this.f;
                                            aVar2.b(aVar2.a(dVar));
                                        } else {
                                            long j4 = dVar.c;
                                            synchronized (dVar.a) {
                                                dVar.f = j4;
                                            }
                                            this.f.b(a3);
                                            dVar.c = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.e) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (java.lang.InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public static class d {
        final java.lang.Object a = new java.lang.Object();
        boolean b;
        long c;
        com.xiaomi.push.service.cl.b d;
        int e;
        long f;

        public final boolean a() {
            boolean z;
            synchronized (this.a) {
                z = !this.b && this.c > 0;
                this.b = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() > 0 ? android.os.SystemClock.elapsedRealtime() : 0L;
        c = elapsedRealtime;
        d = elapsedRealtime;
    }

    private cl() {
        this("Timer-" + c());
    }

    private cl(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        com.xiaomi.push.service.cl.c cVar = new com.xiaomi.push.service.cl.c(str);
        this.a = cVar;
        this.b = new com.xiaomi.push.service.cl.a(cVar);
    }

    public cl(java.lang.String str, byte b2) {
        this(str);
    }

    public static synchronized long a() {
        long j;
        synchronized (com.xiaomi.push.service.cl.class) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j2 = d;
            if (elapsedRealtime > j2) {
                c += elapsedRealtime - j2;
            }
            d = elapsedRealtime;
            j = c;
        }
        return j;
    }

    private void b(com.xiaomi.push.service.cl.b bVar, long j) {
        synchronized (this.a) {
            if (this.a.d) {
                throw new java.lang.IllegalStateException("Timer was canceled");
            }
            long a2 = j + a();
            if (a2 < 0) {
                throw new java.lang.IllegalArgumentException("Illegal delay to start the TimerTask: ".concat(java.lang.String.valueOf(a2)));
            }
            com.xiaomi.push.service.cl.d dVar = new com.xiaomi.push.service.cl.d();
            dVar.e = bVar.f;
            dVar.d = bVar;
            dVar.c = a2;
            com.xiaomi.push.service.cl.c.a(this.a, dVar);
        }
    }

    private static synchronized long c() {
        long j;
        synchronized (com.xiaomi.push.service.cl.class) {
            j = e;
            e = 1 + j;
        }
        return j;
    }

    public final void a(int i) {
        synchronized (this.a) {
            this.a.f.a(i);
        }
    }

    public final void a(com.xiaomi.push.service.cl.b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.b() > 0 || java.lang.Thread.currentThread() == this.a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new java.util.concurrent.RejectedExecutionException("Run job outside job thread");
        }
    }

    public final void a(com.xiaomi.push.service.cl.b bVar, long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("delay < 0: ".concat(java.lang.String.valueOf(j)));
        }
        b(bVar, j);
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            com.xiaomi.push.service.cl.c.a aVar = this.a.f;
            z = false;
            int i = 0;
            while (true) {
                if (i >= aVar.b) {
                    break;
                }
                if (aVar.a[i].e == 1) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        return z;
    }
}
