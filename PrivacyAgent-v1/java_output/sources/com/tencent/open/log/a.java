package com.tencent.open.log;

/* loaded from: classes19.dex */
public class a extends com.tencent.open.log.Tracer implements android.os.Handler.Callback {
    private com.tencent.open.log.b a;
    private java.io.FileWriter b;
    private java.io.FileWriter c;
    private java.io.File d;
    private java.io.File e;
    private char[] f;
    private volatile com.tencent.open.log.f g;
    private volatile com.tencent.open.log.f h;
    private volatile com.tencent.open.log.f i;
    private volatile com.tencent.open.log.f j;
    private volatile boolean k;
    private android.os.HandlerThread l;
    private android.os.Handler m;

    public a(int i, boolean z, com.tencent.open.log.g gVar, com.tencent.open.log.b bVar) {
        super(i, z, gVar);
        this.k = false;
        a(bVar);
        this.g = new com.tencent.open.log.f();
        this.h = new com.tencent.open.log.f();
        this.i = this.g;
        this.j = this.h;
        this.f = new char[bVar.d()];
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(bVar.c(), bVar.f());
        this.l = handlerThread;
        handlerThread.start();
        if (!this.l.isAlive() || this.l.getLooper() == null) {
            return;
        }
        this.m = new android.os.Handler(this.l.getLooper(), this);
    }

    public a(com.tencent.open.log.b bVar) {
        this(com.tencent.open.log.c.b, true, com.tencent.open.log.g.a, bVar);
    }

    private void a(java.lang.String str) {
        this.i.a(str);
        if (this.i.a() >= c().d()) {
            a();
        }
    }

    private void f() {
        if (java.lang.Thread.currentThread() == this.l && !this.k) {
            this.k = true;
            j();
            try {
                try {
                    this.j.a(g(), this.f);
                } catch (java.io.IOException e) {
                    com.tencent.open.log.SLog.e("FileTracer", "flushBuffer exception", e);
                }
                this.k = false;
            } finally {
                this.j.b();
            }
        }
    }

    private java.io.Writer[] g() {
        java.io.File[] a = c().a();
        if (a != null && a.length >= 2) {
            java.io.File file = a[0];
            if ((file != null && !file.equals(this.d)) || (this.b == null && file != null)) {
                this.d = file;
                h();
                try {
                    this.b = new java.io.FileWriter(this.d, true);
                } catch (java.io.IOException unused) {
                    this.b = null;
                    com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "-->obtainFileWriter() old log file permission denied");
                }
            }
            java.io.File file2 = a[1];
            if ((file2 != null && !file2.equals(this.e)) || (this.c == null && file2 != null)) {
                this.e = file2;
                i();
                try {
                    this.c = new java.io.FileWriter(this.e, true);
                } catch (java.io.IOException unused2) {
                    this.c = null;
                    com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
                }
            }
        }
        return new java.io.Writer[]{this.b, this.c};
    }

    private void h() {
        try {
            java.io.FileWriter fileWriter = this.b;
            if (fileWriter != null) {
                fileWriter.flush();
                this.b.close();
            }
        } catch (java.io.IOException e) {
            com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "-->closeFileWriter() exception:", e);
        }
    }

    private void i() {
        try {
            java.io.FileWriter fileWriter = this.c;
            if (fileWriter != null) {
                fileWriter.flush();
                this.c.close();
            }
        } catch (java.io.IOException e) {
            com.tencent.open.log.SLog.e(com.tencent.open.log.SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.i == this.g) {
                this.i = this.h;
                this.j = this.g;
            } else {
                this.i = this.g;
                this.j = this.h;
            }
        }
    }

    public void a() {
        if (this.m.hasMessages(1024)) {
            this.m.removeMessages(1024);
        }
        this.m.sendEmptyMessage(1024);
    }

    public void a(com.tencent.open.log.b bVar) {
        this.a = bVar;
    }

    public void b() {
        h();
        i();
        this.l.quit();
    }

    public com.tencent.open.log.b c() {
        return this.a;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(e().a(i, thread, j, str, str2, th));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 1024) {
            return true;
        }
        f();
        return true;
    }
}
