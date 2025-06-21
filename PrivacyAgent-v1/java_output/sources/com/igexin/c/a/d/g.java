package com.igexin.c.a.d;

/* loaded from: classes22.dex */
public class g extends android.content.BroadcastReceiver implements java.util.Comparator<com.igexin.c.a.d.f> {
    public static final long E = java.util.concurrent.TimeUnit.SECONDS.toMillis(2);
    protected static final java.lang.String F = "AlarmTaskSchedule.";
    protected static final java.lang.String G = "AlarmTaskScheduleBak.";
    protected static final java.lang.String H = "AlarmNioTaskSchedule.";
    public static final java.lang.String h = "TaskService";
    public static final java.lang.String i = "com.igexin.c.a.d.g";
    static final byte j = -1;
    static final byte k = 0;
    static final byte l = 1;
    static final byte m = 2;
    static final byte n = Byte.MIN_VALUE;
    static final byte o = 7;
    public android.app.PendingIntent A;
    public java.lang.String B;
    volatile long C;
    public volatile boolean D;
    public boolean t;
    public android.os.PowerManager v;
    public android.app.AlarmManager w;
    public android.content.Intent x;
    public android.app.PendingIntent y;
    public android.content.Intent z;
    final java.util.concurrent.locks.ReentrantLock u = new java.util.concurrent.locks.ReentrantLock();
    public boolean I = false;
    final java.util.HashMap<java.lang.Long, com.igexin.c.a.d.a.c> q = new java.util.HashMap<>(7);

    /* renamed from: s, reason: collision with root package name */
    public final com.igexin.c.a.d.e<com.igexin.c.a.d.f> f381s = new com.igexin.c.a.d.e<>(this, this);
    final com.igexin.c.a.d.d r = new com.igexin.c.a.d.d();
    public final com.igexin.c.a.d.g.b p = new com.igexin.c.a.d.g.b();

    /* renamed from: com.igexin.c.a.d.g$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.IntentFilter {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
            addAction(com.igexin.c.a.d.g.F + context.getPackageName());
            addAction(com.igexin.c.a.d.g.G + context.getPackageName());
            addAction("android.intent.action.SCREEN_OFF");
            addAction("android.intent.action.SCREEN_ON");
        }
    }

    public final class a {
        volatile int g;
        final java.util.concurrent.locks.ReentrantLock c = new java.util.concurrent.locks.ReentrantLock();
        final java.util.concurrent.BlockingQueue<com.igexin.c.a.d.f> a = new java.util.concurrent.SynchronousQueue();
        final java.util.HashMap<java.lang.Integer, com.igexin.c.a.d.g.a.RunnableC0369a> b = new java.util.HashMap<>();
        volatile long e = java.util.concurrent.TimeUnit.SECONDS.toNanos(60);
        volatile int f = 0;
        java.util.concurrent.ThreadFactory d = new com.igexin.c.a.d.g.a.b();
        volatile int h = Integer.MAX_VALUE;

        /* renamed from: com.igexin.c.a.d.g$a$a, reason: collision with other inner class name */
        public final class RunnableC0369a implements java.lang.Runnable {
            final java.util.concurrent.BlockingQueue<com.igexin.c.a.d.f> a = new java.util.concurrent.LinkedBlockingQueue();
            com.igexin.c.a.d.f b;
            com.igexin.c.a.d.f c;
            volatile int d;
            volatile boolean e;

            public RunnableC0369a(com.igexin.c.a.d.f fVar) {
                this.b = fVar;
            }

            private void a() {
                this.a.clear();
                this.c = null;
            }

            private void a(com.igexin.c.a.d.f fVar) {
                if (this.d == 0) {
                    this.d = fVar.C;
                }
                boolean z = true;
                while (z) {
                    try {
                        try {
                            fVar.b_();
                            fVar.o();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h + e.toString(), new java.lang.Object[0]);
                            fVar.v = true;
                            fVar.E = e;
                            fVar.p();
                            fVar.l();
                            com.igexin.c.a.d.g.this.a((java.lang.Object) fVar);
                            com.igexin.c.a.d.g.this.e();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            if (!fVar.m && fVar.p && fVar.w != 0) {
                            }
                        }
                    } finally {
                    }
                    if (!fVar.m && fVar.p && fVar.w != 0) {
                    }
                    fVar = null;
                    z = false;
                }
            }

            private com.igexin.c.a.d.f b() {
                com.igexin.c.a.d.f poll;
                while (this.d != 0) {
                    try {
                        poll = this.a.poll(com.igexin.c.a.d.g.a.this.e, java.util.concurrent.TimeUnit.NANOSECONDS);
                    } catch (java.lang.InterruptedException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                    if (poll != null) {
                        return poll;
                    }
                    if (this.a.isEmpty()) {
                        java.util.concurrent.locks.ReentrantLock reentrantLock = com.igexin.c.a.d.g.a.this.c;
                        reentrantLock.lock();
                        try {
                            if (this.a.isEmpty()) {
                                com.igexin.c.a.d.g.a.this.b.remove(java.lang.Integer.valueOf(this.d));
                                this.d = 0;
                                return null;
                            }
                        } finally {
                            reentrantLock.unlock();
                        }
                    } else {
                        continue;
                    }
                }
                return null;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z = true;
                while (z) {
                    try {
                        try {
                            com.igexin.c.a.d.f fVar = this.b;
                            this.b = null;
                            while (true) {
                                if (fVar == null) {
                                    fVar = b();
                                    if (fVar == null && (fVar = com.igexin.c.a.d.g.a.this.b()) == null) {
                                        z = com.igexin.c.a.d.g.a.this.a(this);
                                        if (!z) {
                                        }
                                    }
                                }
                                this.c = null;
                                if (this.d == 0) {
                                    this.d = fVar.C;
                                }
                                com.igexin.c.a.d.f fVar2 = fVar;
                                boolean z2 = true;
                                while (z2) {
                                    try {
                                        try {
                                            fVar2.b_();
                                            fVar2.o();
                                            if (!fVar2.v) {
                                                fVar2.d_();
                                            }
                                        } catch (java.lang.Exception e) {
                                            com.igexin.c.a.c.a.a(e);
                                            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h + e.toString(), new java.lang.Object[0]);
                                            fVar2.v = true;
                                            fVar2.E = e;
                                            fVar2.p();
                                            fVar2.l();
                                            com.igexin.c.a.d.g.this.a((java.lang.Object) fVar2);
                                            com.igexin.c.a.d.g.this.e();
                                            if (!fVar2.v) {
                                                fVar2.d_();
                                            }
                                            if (!fVar2.m && fVar2.p && fVar2.w != 0) {
                                            }
                                        }
                                    } catch (java.lang.Throwable th) {
                                        if (!fVar2.v) {
                                            fVar2.d_();
                                        }
                                        if (fVar2.m || !fVar2.p || fVar2.w == 0) {
                                            throw th;
                                        }
                                    }
                                    if (!fVar2.m && fVar2.p && fVar2.w != 0) {
                                    }
                                    fVar2 = null;
                                    z2 = false;
                                }
                                this.c = fVar;
                                fVar = null;
                            }
                            throw th;
                        } catch (java.lang.Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            com.igexin.c.a.c.a.a("TaskService|Worker|run()|error" + e2.toString(), new java.lang.Object[0]);
                            z = com.igexin.c.a.d.g.a.this.a(this);
                            if (!z) {
                                a();
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        if (!com.igexin.c.a.d.g.a.this.a(this)) {
                            a();
                        }
                        throw th2;
                    }
                }
            }
        }

        public final class b implements java.util.concurrent.ThreadFactory {
            final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

            public b() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final java.lang.Thread newThread(java.lang.Runnable runnable) {
                return new java.lang.Thread(runnable, "TS-pool-" + this.a.incrementAndGet());
            }
        }

        public a() {
        }

        private void c(com.igexin.c.a.d.f fVar) {
            fVar.getClass();
            if (fVar.C != 0) {
                java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
                reentrantLock.lock();
                try {
                    com.igexin.c.a.d.g.a.RunnableC0369a runnableC0369a = this.b.get(java.lang.Integer.valueOf(fVar.C));
                    if (runnableC0369a != null) {
                        runnableC0369a.a.offer(fVar);
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (this.g >= this.f || !a(fVar)) {
                if (!this.a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private void d(com.igexin.c.a.d.f fVar) {
            if (this.g >= this.f || !a(fVar)) {
                if (!this.a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private java.lang.Thread e(com.igexin.c.a.d.f fVar) {
            int i;
            com.igexin.c.a.d.g.a.RunnableC0369a runnableC0369a = new com.igexin.c.a.d.g.a.RunnableC0369a(fVar);
            if (fVar != null && (i = fVar.C) != 0) {
                this.b.put(java.lang.Integer.valueOf(i), runnableC0369a);
            }
            java.lang.Thread newThread = this.d.newThread(runnableC0369a);
            if (newThread != null) {
                this.g++;
            }
            return newThread;
        }

        public final void a() {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread thread = null;
                if (this.g < java.lang.Math.max(this.f, 1) && !this.a.isEmpty()) {
                    thread = e(null);
                }
                if (thread != null) {
                    thread.start();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean a(com.igexin.c.a.d.f fVar) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread e = this.g < this.f ? e(fVar) : null;
                if (e == null) {
                    return false;
                }
                e.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean a(com.igexin.c.a.d.g.a.RunnableC0369a runnableC0369a) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                int i = this.g - 1;
                this.g = i;
                if (i == 0 && !this.a.isEmpty()) {
                    java.lang.Thread e = e(null);
                    if (e != null) {
                        e.start();
                    }
                } else if (!runnableC0369a.a.isEmpty()) {
                    return true;
                }
                this.b.remove(java.lang.Integer.valueOf(runnableC0369a.d));
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final com.igexin.c.a.d.f b() {
            com.igexin.c.a.d.f poll;
            while (true) {
                try {
                    poll = this.g > this.f ? this.a.poll(this.e, java.util.concurrent.TimeUnit.NANOSECONDS) : this.a.take();
                } catch (java.lang.InterruptedException e) {
                    com.igexin.c.a.c.a.a(e);
                }
                if (poll != null) {
                    return poll;
                }
                if (this.a.isEmpty()) {
                    return null;
                }
            }
        }

        public final boolean b(com.igexin.c.a.d.f fVar) {
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                java.lang.Thread e = this.g < this.h ? e(fVar) : null;
                if (e == null) {
                    return false;
                }
                e.start();
                return true;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final class b extends java.lang.Thread {
        volatile boolean a = true;
        long b;
        long c;
        com.igexin.c.a.d.g.a d;

        public b() {
            setName("TS-processor");
        }

        private static void a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:(1:(4:(3:31|32|(2:35|20)(4:34|26|27|28))|10|11|(3:13|(2:18|19)(3:21|22|23)|20)(4:25|26|27|28)))(3:68|69|(5:78|79|(1:81)|82|(5:84|85|86|88|(4:112|113|114|115)(2:90|91))(1:121))(2:71|(4:75|76|77|28)))|36|37|38|(1:40)|41|(1:43)|46|10|11|(0)(0)) */
        /* JADX WARN: Can't wrap try/catch for region: R(13:6|(1:(4:(3:31|32|(2:35|20)(4:34|26|27|28))|10|11|(3:13|(2:18|19)(3:21|22|23)|20)(4:25|26|27|28)))(3:68|69|(5:78|79|(1:81)|82|(5:84|85|86|88|(4:112|113|114|115)(2:90|91))(1:121))(2:71|(4:75|76|77|28)))|36|37|38|(1:40)|41|(1:43)|46|10|11|(0)(0)|4) */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x0083, code lost:
        
            r4.b(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x007d, code lost:
        
            if (r4.g != 0) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x007f, code lost:
        
            r4.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e1, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00e2, code lost:
        
            com.igexin.c.a.c.a.a(r4);
            com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h, r4.toString());
            com.igexin.c.a.c.a.a("TaskService|SERVICE_PROCESSING|error|" + r4.toString(), new java.lang.Object[0]);
            r5.v = true;
            r5.E = r4;
            r5.p();
            r5.l();
            r13.e.r.a(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
        
            r13.e.f();
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x011b, code lost:
        
            if (r5.v == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x011d, code lost:
        
            r5.d_();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0122, code lost:
        
            if (r5.m == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0126, code lost:
        
            if (r5.q == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x006b, code lost:
        
            if (r4.g >= r4.f) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0071, code lost:
        
            if (r4.a(r5) != false) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0079, code lost:
        
            if (r4.a.offer(r5) == false) goto L108;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0143 A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            android.os.Process.setThreadPriority(-2);
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.d.g.this.f381s;
            while (true) {
                com.igexin.c.a.d.f fVar = null;
                while (true) {
                    char c = 1;
                    while (this.a) {
                        try {
                            if (c == 65535) {
                                try {
                                    fVar.d();
                                    fVar.hashCode();
                                } catch (java.lang.Exception e) {
                                    com.igexin.c.a.c.a.a(e);
                                    com.igexin.c.a.c.a.a("TaskService|TASK_INIT|error|" + e.toString(), new java.lang.Object[0]);
                                }
                                if (fVar.m()) {
                                    if (this.d == null) {
                                        this.d = com.igexin.c.a.d.g.this.new a();
                                    }
                                    com.igexin.c.a.d.g.a aVar = this.d;
                                    if (fVar.C == 0) {
                                        break;
                                    }
                                    java.util.concurrent.locks.ReentrantLock reentrantLock = aVar.c;
                                    reentrantLock.lock();
                                    try {
                                        com.igexin.c.a.d.g.a.RunnableC0369a runnableC0369a = aVar.b.get(java.lang.Integer.valueOf(fVar.C));
                                        if (runnableC0369a != null) {
                                            runnableC0369a.a.offer(fVar);
                                            reentrantLock.unlock();
                                        } else {
                                            reentrantLock.unlock();
                                        }
                                    } catch (java.lang.Throwable th) {
                                        reentrantLock.unlock();
                                        throw th;
                                    }
                                } else if (fVar.p && fVar.w == 0) {
                                    com.igexin.c.a.c.a.a(com.igexin.c.a.d.g.h, fVar + "|isBlock = false|cycyle = true|doTime = 0, invalid ###########");
                                    com.igexin.c.a.c.a.a("TaskService|" + fVar + "|isBlock = false|cycyle = true|doTime = 0, invalid ###########", new java.lang.Object[0]);
                                }
                            } else if (c != 0) {
                                if (c != 1) {
                                    if (c == 2) {
                                        com.igexin.c.a.d.g.this.f();
                                    }
                                }
                                fVar = eVar.a();
                                fVar.getClass();
                                if (fVar != null) {
                                    com.igexin.c.a.d.g.this.f();
                                } else if (fVar.m || fVar.n) {
                                    fVar = null;
                                } else {
                                    c = 65535;
                                }
                            }
                            fVar.b_();
                            fVar.o();
                            fVar = null;
                            c = 1;
                            fVar = eVar.a();
                            fVar.getClass();
                            if (fVar != null) {
                            }
                        } finally {
                            com.igexin.c.a.d.g.this.f();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            if (!fVar.m && !fVar.q) {
                                fVar.D = 0;
                                eVar.a((com.igexin.c.a.d.e<com.igexin.c.a.d.f>) fVar);
                            }
                        }
                    }
                    eVar.c.clear();
                    return;
                }
            }
        }
    }

    public g() {
        com.igexin.c.a.d.f.H = this;
    }

    private static int a(com.igexin.c.a.d.f fVar, com.igexin.c.a.d.f fVar2) {
        if (fVar.w < fVar2.w) {
            return -1;
        }
        if (fVar.w > fVar2.w) {
            return 1;
        }
        int i2 = fVar.D;
        int i3 = fVar2.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar.x < fVar2.x) {
            return -1;
        }
        if (fVar.x > fVar2.x) {
            return 1;
        }
        return fVar.hashCode() - fVar2.hashCode();
    }

    private void a() {
        try {
            android.app.PendingIntent pendingIntent = this.y;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private void a(int i2, java.util.concurrent.TimeUnit timeUnit) {
        this.p.b = java.util.concurrent.TimeUnit.MILLISECONDS.convert(i2, timeUnit);
    }

    private void a(android.content.Context context) {
        if (this.I) {
            return;
        }
        if (!com.igexin.push.h.n.l()) {
            this.v = (android.os.PowerManager) context.getSystemService("power");
            this.D = true;
            this.w = (android.app.AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            try {
                if (android.os.Build.VERSION.SDK_INT >= 31) {
                    this.t = ((java.lang.Boolean) android.app.AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", new java.lang.Class[0]).invoke(this.w, new java.lang.Object[0])).booleanValue();
                } else {
                    this.t = true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            com.igexin.c.a.d.g.AnonymousClass1 anonymousClass1 = new com.igexin.c.a.d.g.AnonymousClass1(context);
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 > 33) {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null);
            }
            this.B = H + context.getPackageName();
            if (i2 > 33) {
                context.registerReceiver(this, new android.content.IntentFilter(this.B), com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, new android.content.IntentFilter(this.B), com.igexin.push.core.e.ac, null);
            }
            int i3 = (com.igexin.push.h.n.a(context) < 31 || i2 < 30) ? 134217728 : 201326592;
            this.x = new android.content.Intent(F + context.getPackageName());
            this.y = android.app.PendingIntent.getBroadcast(context, hashCode(), this.x, i3);
            hashCode();
            this.z = new android.content.Intent(this.B);
            this.A = android.app.PendingIntent.getBroadcast(context, hashCode() + 2, this.z, i3);
            hashCode();
        }
        this.p.start();
        try {
            java.lang.Thread.yield();
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        this.I = true;
    }

    private static boolean a(com.igexin.c.a.d.a.e eVar, com.igexin.c.a.d.a.c cVar) {
        int c = eVar.c();
        if (c <= Integer.MIN_VALUE || c >= 0) {
            if (c < 0 || c >= Integer.MAX_VALUE) {
                return false;
            }
            return cVar.a(eVar);
        }
        com.igexin.c.a.d.f fVar = (com.igexin.c.a.d.f) eVar;
        boolean a2 = fVar.v ? false : cVar.a(eVar);
        if (a2) {
            fVar.d_();
        }
        return a2;
    }

    private boolean a(com.igexin.c.a.d.f fVar) {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.f381s;
        return eVar != null && eVar.c(fVar);
    }

    private boolean a(com.igexin.c.a.d.f fVar, boolean z, int i2, long j2, byte b2, java.lang.Object obj, com.igexin.c.a.d.a.d dVar, int i3, com.igexin.c.a.d.a.g gVar) {
        fVar.getClass();
        fVar.A = i2;
        fVar.a((int) b2);
        fVar.F = obj;
        fVar.O = dVar;
        fVar.a(j2, java.util.concurrent.TimeUnit.MILLISECONDS);
        fVar.a(i3, gVar);
        return a(fVar, z);
    }

    private boolean a(java.lang.Class cls) {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.f381s;
        return eVar != null && eVar.a(cls);
    }

    @android.annotation.TargetApi(19)
    private void b(long j2) {
        if (com.igexin.push.h.n.l()) {
            return;
        }
        com.igexin.c.a.c.a.a("setnioalarm|" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j2)), new java.lang.Object[0]);
        if (j2 < 0) {
            j2 = java.lang.System.currentTimeMillis() + E;
        }
        try {
            int i2 = android.os.Build.VERSION.SDK_INT;
            try {
                if (this.t) {
                    this.w.setExact(0, j2, this.A);
                } else if (i2 > 23) {
                    this.w.setAndAllowWhileIdle(0, j2, this.y);
                } else {
                    this.w.set(0, j2, this.A);
                }
            } catch (java.lang.Exception unused) {
                this.w.set(0, j2, this.A);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private boolean b() {
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.f381s;
        if (eVar == null) {
            return false;
        }
        eVar.c.clear();
        return true;
    }

    @android.annotation.TargetApi(19)
    public final void a(long j2) {
        if (this.D) {
            com.igexin.c.a.c.a.a("setalarm|" + new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(j2)), new java.lang.Object[0]);
            if (j2 < 0) {
                j2 = java.lang.System.currentTimeMillis() + E;
            }
            try {
                android.app.PendingIntent pendingIntent = this.y;
                if (pendingIntent != null) {
                    int i2 = android.os.Build.VERSION.SDK_INT;
                    try {
                        if (this.t) {
                            this.w.setExact(0, j2, pendingIntent);
                        } else if (i2 > 23) {
                            this.w.setAndAllowWhileIdle(0, j2, pendingIntent);
                        } else {
                            this.w.set(0, j2, pendingIntent);
                        }
                    } catch (java.lang.Throwable unused) {
                        this.w.set(0, j2, this.y);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(h, th.toString());
                com.igexin.c.a.c.a.a(h + th.toString(), new java.lang.Object[0]);
            }
        }
    }

    public final boolean a(com.igexin.c.a.d.a.c cVar) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.u;
        if (reentrantLock.tryLock()) {
            try {
                if (this.q.containsKey(java.lang.Long.valueOf(cVar.g()))) {
                    return false;
                }
                this.q.put(java.lang.Long.valueOf(cVar.g()), cVar);
                reentrantLock.unlock();
                return true;
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new java.lang.Object[0]);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return false;
    }

    public final boolean a(com.igexin.c.a.d.f fVar, boolean z) {
        fVar.getClass();
        int i2 = 0;
        if (fVar.q || fVar.m) {
            return false;
        }
        com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = this.f381s;
        if ((fVar instanceof com.igexin.c.a.b.f) && (((com.igexin.c.a.b.f) fVar).d instanceof com.igexin.push.d.c.o)) {
            if (z) {
                i2 = Integer.MAX_VALUE;
            }
        } else if (z) {
            i2 = eVar.d.incrementAndGet();
        }
        fVar.D = i2;
        return eVar.a((com.igexin.c.a.d.e<com.igexin.c.a.d.f>) fVar);
    }

    public final boolean a(com.igexin.c.a.d.f fVar, boolean z, boolean z2) {
        fVar.getClass();
        boolean z3 = false;
        if (fVar.n) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(fVar, z3);
        }
        fVar.d();
        try {
            try {
                fVar.b_();
                fVar.o();
                if (!fVar.v) {
                    fVar.d_();
                }
                return true;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                fVar.v = true;
                fVar.E = e;
                fVar.l();
                fVar.p();
                a((java.lang.Object) fVar);
                e();
                if (!fVar.v) {
                    fVar.d_();
                }
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (!fVar.v) {
                fVar.d_();
            }
            throw th;
        }
    }

    public final boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        obj.hashCode();
        try {
            if (obj instanceof com.igexin.push.d.c.n) {
                obj.hashCode();
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        obj.hashCode();
        com.igexin.c.a.c.a.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new java.lang.Object[0]);
        if (!(obj instanceof com.igexin.c.a.d.a.e)) {
            throw new java.lang.ClassCastException("response Obj is not a TaskResult ");
        }
        com.igexin.c.a.d.a.e eVar = (com.igexin.c.a.d.a.e) obj;
        if (eVar.j()) {
            return false;
        }
        eVar.a(false);
        if ((obj instanceof com.igexin.push.d.b.a) || (obj instanceof com.igexin.push.d.b.b)) {
            this.r.a();
            com.igexin.c.a.c.a.a("TaskService|change to primaryQueue", new java.lang.Object[0]);
        }
        this.r.a(eVar);
        return true;
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(com.igexin.c.a.d.f fVar, com.igexin.c.a.d.f fVar2) {
        com.igexin.c.a.d.f fVar3 = fVar;
        com.igexin.c.a.d.f fVar4 = fVar2;
        if (fVar3.w < fVar4.w) {
            return -1;
        }
        if (fVar3.w > fVar4.w) {
            return 1;
        }
        int i2 = fVar3.D;
        int i3 = fVar4.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar3.x < fVar4.x) {
            return -1;
        }
        if (fVar3.x > fVar4.x) {
            return 1;
        }
        return fVar3.hashCode() - fVar4.hashCode();
    }

    public final void d() {
        try {
            android.app.PendingIntent pendingIntent = this.A;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    public final void e() {
        com.igexin.c.a.d.g.b bVar = this.p;
        if (bVar == null || bVar.isInterrupted()) {
            return;
        }
        this.p.interrupt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        if (r4 < 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
    
        ((com.igexin.c.a.d.f) r0).d_();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a5, code lost:
    
        if (r4 < 0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0000 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        com.igexin.c.a.d.a.e d;
        boolean z;
        int c;
        boolean z2;
        while (!this.r.c() && (d = this.r.d()) != null) {
            d.a(true);
            java.util.concurrent.locks.ReentrantLock reentrantLock = this.u;
            reentrantLock.lock();
            try {
            } catch (java.lang.Throwable th) {
                th = th;
                z = false;
            }
            if (!this.q.isEmpty()) {
                long k2 = d.k();
                if (k2 != 0) {
                    com.igexin.c.a.d.a.c cVar = this.q.get(java.lang.Long.valueOf(k2));
                    if (cVar != null) {
                        z2 = a(d, cVar);
                    }
                } else {
                    java.util.Iterator<com.igexin.c.a.d.a.c> it = this.q.values().iterator();
                    z = false;
                    while (it.hasNext() && !(z = a(d, it.next()))) {
                        try {
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            try {
                                com.igexin.c.a.c.a.a(th);
                                com.igexin.c.a.c.a.a(h, th.toString());
                                com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new java.lang.Object[0]);
                                if (!z) {
                                    int c2 = d.c();
                                    if (c2 > Integer.MIN_VALUE) {
                                    }
                                }
                                reentrantLock.unlock();
                                if (d instanceof com.igexin.push.d.c.k) {
                                }
                            } catch (java.lang.Throwable th3) {
                                if (!z && (c = d.c()) > Integer.MIN_VALUE && c < 0) {
                                    ((com.igexin.c.a.d.f) d).d_();
                                }
                                reentrantLock.unlock();
                                throw th3;
                            }
                        }
                    }
                    z2 = z;
                }
                if (!z2) {
                    int c3 = d.c();
                    if (c3 > Integer.MIN_VALUE) {
                    }
                }
                reentrantLock.unlock();
                if (d instanceof com.igexin.push.d.c.k) {
                    this.r.b();
                    com.igexin.c.a.c.a.a("TaskService|queue -> secondRespQueue", new java.lang.Object[0]);
                }
            }
            z2 = false;
            if (!z2) {
            }
            reentrantLock.unlock();
            if (d instanceof com.igexin.push.d.c.k) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.D = true;
            com.igexin.c.a.c.a.a("screenoff", new java.lang.Object[0]);
            if (this.f381s.g.get() > 0) {
                a(this.f381s.g.get());
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.D = false;
            com.igexin.c.a.c.a.a("screenon", new java.lang.Object[0]);
            return;
        }
        if (intent.getAction().startsWith(F) || intent.getAction().startsWith(G)) {
            java.util.Calendar.getInstance().getTime().toLocaleString();
            com.igexin.c.a.c.a.a("receivealarm|" + this.D, new java.lang.Object[0]);
            e();
            return;
        }
        if (this.B.equals(intent.getAction())) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            com.igexin.c.a.c.a.b(i, "CPU ON + NioAlarmReceiver:-> cTime; " + calendar.getTime().toLocaleString());
            try {
                com.igexin.c.a.c.a.a(h, " alarm time out #######");
                com.igexin.c.a.c.a.a("TaskService|alarm time out #######", new java.lang.Object[0]);
                com.igexin.c.a.b.a.a.d.a().f();
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }
}
