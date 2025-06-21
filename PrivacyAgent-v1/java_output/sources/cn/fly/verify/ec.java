package cn.fly.verify;

/* loaded from: classes.dex */
public class ec extends java.lang.Thread {
    private android.os.Looper c;
    private int b = -1;
    private int a = 0;

    /* renamed from: cn.fly.verify.ec$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ec {
        final /* synthetic */ java.lang.Runnable a;
        final /* synthetic */ android.os.Handler[] b;
        final /* synthetic */ android.os.Handler.Callback c;

        public AnonymousClass1(java.lang.Runnable runnable, android.os.Handler[] handlerArr, android.os.Handler.Callback callback) {
            this.a = runnable;
            this.b = handlerArr;
            this.c = callback;
        }

        @Override // cn.fly.verify.ec
        public void a(android.os.Looper looper) {
            synchronized (this.b) {
                this.b[0] = new android.os.Handler(looper, this.c);
                this.b.notifyAll();
            }
        }

        @Override // cn.fly.verify.ec, java.lang.Thread, java.lang.Runnable
        public void run() {
            java.lang.Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            super.run();
        }
    }

    public static android.os.Handler a(java.lang.String str, android.os.Handler.Callback callback) {
        return a(str, null, callback);
    }

    public static android.os.Handler a(java.lang.String str, java.lang.Runnable runnable, android.os.Handler.Callback callback) {
        android.os.Handler[] handlerArr = new android.os.Handler[1];
        cn.fly.verify.ec.AnonymousClass1 anonymousClass1 = new cn.fly.verify.ec.AnonymousClass1(runnable, handlerArr, callback);
        synchronized (handlerArr) {
            if (str != null) {
                try {
                    anonymousClass1.setName(str);
                } finally {
                    return handlerArr[0];
                }
            }
            anonymousClass1.start();
            handlerArr.wait();
        }
        return handlerArr[0];
    }

    public void a() {
    }

    public void a(android.os.Looper looper) {
    }

    @java.lang.Deprecated
    public void b() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            b();
            this.b = android.os.Process.myTid();
            android.os.Looper.prepare();
            synchronized (this) {
                this.c = android.os.Looper.myLooper();
                notifyAll();
            }
            android.os.Process.setThreadPriority(this.a);
            a(this.c);
            a();
            android.os.Looper.loop();
            this.b = -1;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }
}
