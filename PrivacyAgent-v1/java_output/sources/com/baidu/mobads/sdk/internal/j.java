package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public abstract class j<T> implements java.lang.Runnable {
    private static final java.lang.String b = "BaseTask";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static com.baidu.mobads.sdk.internal.j.b j;
    protected java.util.concurrent.Future<T> a;
    private java.lang.String f;
    private long g;
    private long h;
    private long i;

    public static class a<T> {
        final com.baidu.mobads.sdk.internal.j a;
        final T b;

        public a(com.baidu.mobads.sdk.internal.j jVar, T t) {
            this.a = jVar;
            this.b = t;
        }
    }

    public static class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.baidu.mobads.sdk.internal.j.a aVar = (com.baidu.mobads.sdk.internal.j.a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.a.a((com.baidu.mobads.sdk.internal.j) aVar.b);
            } else if (i == 2) {
                aVar.a.a((java.lang.Throwable) aVar.b);
            } else {
                if (i != 3) {
                    return;
                }
                aVar.a.j();
            }
        }
    }

    public j() {
        this.f = "default";
    }

    public j(java.lang.String str) {
        this.f = str;
    }

    private static android.os.Handler k() {
        com.baidu.mobads.sdk.internal.j.b bVar;
        synchronized (com.baidu.mobads.sdk.internal.j.class) {
            if (j == null) {
                j = new com.baidu.mobads.sdk.internal.j.b(android.os.Looper.getMainLooper());
            }
            bVar = j;
        }
        return bVar;
    }

    public java.lang.String a() {
        return this.f;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public void a(T t) {
    }

    public void a(java.lang.Throwable th) {
    }

    public void a(java.util.concurrent.Future future) {
        this.a = future;
    }

    public void a(boolean z) {
        java.util.concurrent.Future<T> future = this.a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new com.baidu.mobads.sdk.internal.j.a(this, null)).sendToTarget();
        }
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        java.util.concurrent.Future<T> future = this.a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        java.util.concurrent.Future<T> future = this.a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.h - this.g;
    }

    public long f() {
        return this.i - this.g;
    }

    public long g() {
        return this.i - this.h;
    }

    public com.baidu.mobads.sdk.internal.j h() {
        try {
            this.h = java.lang.System.currentTimeMillis();
            k().obtainMessage(1, new com.baidu.mobads.sdk.internal.j.a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public abstract T i();

    public void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }
}
