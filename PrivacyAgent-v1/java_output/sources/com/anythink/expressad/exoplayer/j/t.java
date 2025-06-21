package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class t implements com.anythink.expressad.exoplayer.j.u {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private final java.util.concurrent.ExecutorService e;
    private com.anythink.expressad.exoplayer.j.t.b<? extends com.anythink.expressad.exoplayer.j.t.c> f;
    private java.io.IOException g;

    public interface a<T extends com.anythink.expressad.exoplayer.j.t.c> {
        int a(T t, long j, long j2, java.io.IOException iOException);

        void a(T t, long j, long j2);

        void a(T t, long j, long j2, boolean z);
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public final class b<T extends com.anythink.expressad.exoplayer.j.t.c> extends android.os.Handler implements java.lang.Runnable {
        private static final java.lang.String c = "LoadTask";
        private static final int d = 0;
        private static final int e = 1;
        private static final int f = 2;
        private static final int g = 3;
        private static final int h = 4;
        public final int a;
        private final T i;
        private final long j;

        @androidx.annotation.Nullable
        private com.anythink.expressad.exoplayer.j.t.a<T> k;
        private java.io.IOException l;
        private int m;
        private volatile java.lang.Thread n;
        private volatile boolean o;
        private volatile boolean p;

        public b(android.os.Looper looper, T t, com.anythink.expressad.exoplayer.j.t.a<T> aVar, int i, long j) {
            super(looper);
            this.i = t;
            this.k = aVar;
            this.a = i;
            this.j = j;
        }

        private void a() {
            this.l = null;
            com.anythink.expressad.exoplayer.j.t.this.e.execute(com.anythink.expressad.exoplayer.j.t.this.f);
        }

        private void b() {
            com.anythink.expressad.exoplayer.j.t.this.f = null;
        }

        private long c() {
            return java.lang.Math.min((this.m - 1) * 1000, 5000);
        }

        public final void a(int i) {
            java.io.IOException iOException = this.l;
            if (iOException != null && this.m > i) {
                throw iOException;
            }
        }

        public final void a(long j) {
            com.anythink.expressad.exoplayer.k.a.b(com.anythink.expressad.exoplayer.j.t.this.f == null);
            com.anythink.expressad.exoplayer.j.t.this.f = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                a();
            }
        }

        public final void a(boolean z) {
            this.p = z;
            this.l = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.o = true;
                this.i.a();
                if (this.n != null) {
                    this.n.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                this.k.a((com.anythink.expressad.exoplayer.j.t.a<T>) this.i, elapsedRealtime, elapsedRealtime - this.j, true);
                this.k = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (this.p) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                a();
                return;
            }
            if (i == 4) {
                throw ((java.lang.Error) message.obj);
            }
            b();
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.j;
            if (this.o) {
                this.k.a((com.anythink.expressad.exoplayer.j.t.a<T>) this.i, elapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.k.a((com.anythink.expressad.exoplayer.j.t.a<T>) this.i, elapsedRealtime, j, false);
                return;
            }
            if (i2 == 2) {
                try {
                    this.k.a(this.i, elapsedRealtime, j);
                    return;
                } catch (java.lang.RuntimeException e2) {
                    com.anythink.expressad.exoplayer.j.t.this.g = new com.anythink.expressad.exoplayer.j.t.g(e2);
                    return;
                }
            }
            if (i2 != 3) {
                return;
            }
            java.io.IOException iOException = (java.io.IOException) message.obj;
            this.l = iOException;
            int a = this.k.a((com.anythink.expressad.exoplayer.j.t.a<T>) this.i, elapsedRealtime, j, iOException);
            if (a == 3) {
                com.anythink.expressad.exoplayer.j.t.this.g = this.l;
            } else if (a != 2) {
                this.m = a == 1 ? 1 : this.m + 1;
                a(java.lang.Math.min((r12 - 1) * 1000, 5000));
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.n = java.lang.Thread.currentThread();
                if (!this.o) {
                    com.anythink.expressad.exoplayer.k.ad.a("load:" + this.i.getClass().getSimpleName());
                    try {
                        this.i.b();
                        com.anythink.expressad.exoplayer.k.ad.a();
                    } catch (java.lang.Throwable th) {
                        com.anythink.expressad.exoplayer.k.ad.a();
                        throw th;
                    }
                }
                if (this.p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (java.io.IOException e2) {
                if (this.p) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (java.lang.Error e3) {
                if (!this.p) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (java.lang.InterruptedException unused) {
                com.anythink.expressad.exoplayer.k.a.b(this.o);
                if (this.p) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (java.lang.Exception e4) {
                if (this.p) {
                    return;
                }
                obtainMessage(3, new com.anythink.expressad.exoplayer.j.t.g(e4)).sendToTarget();
            } catch (java.lang.OutOfMemoryError e5) {
                if (this.p) {
                    return;
                }
                obtainMessage(3, new com.anythink.expressad.exoplayer.j.t.g(e5)).sendToTarget();
            }
        }
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void g();
    }

    public static final class e implements java.lang.Runnable {
        private final com.anythink.expressad.exoplayer.j.t.d a;

        public e(com.anythink.expressad.exoplayer.j.t.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g();
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface f {
    }

    public static final class g extends java.io.IOException {
        public g(java.lang.Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public t(java.lang.String str) {
        this.e = com.anythink.expressad.exoplayer.k.af.a(str);
    }

    private void d() {
        a((com.anythink.expressad.exoplayer.j.t.d) null);
    }

    public final <T extends com.anythink.expressad.exoplayer.j.t.c> long a(T t, com.anythink.expressad.exoplayer.j.t.a<T> aVar, int i) {
        android.os.Looper myLooper = android.os.Looper.myLooper();
        com.anythink.expressad.exoplayer.k.a.b(myLooper != null);
        this.g = null;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        new com.anythink.expressad.exoplayer.j.t.b(myLooper, t, aVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void a(int i) {
        java.io.IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
        com.anythink.expressad.exoplayer.j.t.b<? extends com.anythink.expressad.exoplayer.j.t.c> bVar = this.f;
        if (bVar != null) {
            if (i == Integer.MIN_VALUE) {
                i = bVar.a;
            }
            bVar.a(i);
        }
    }

    public final void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.j.t.d dVar) {
        com.anythink.expressad.exoplayer.j.t.b<? extends com.anythink.expressad.exoplayer.j.t.c> bVar = this.f;
        if (bVar != null) {
            bVar.a(true);
        }
        if (dVar != null) {
            this.e.execute(new com.anythink.expressad.exoplayer.j.t.e(dVar));
        }
        this.e.shutdown();
    }

    public final boolean a() {
        return this.f != null;
    }

    public final void b() {
        this.f.a(false);
    }

    @Override // com.anythink.expressad.exoplayer.j.u
    public final void c() {
        a(Integer.MIN_VALUE);
    }
}
