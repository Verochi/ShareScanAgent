package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class u implements java.lang.Runnable {
    public final /* synthetic */ java.io.File a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ java.io.File c;
    public final /* synthetic */ java.io.File d;

    public u(com.zx.a.I8b7.v vVar, java.io.File file, java.lang.String str, java.io.File file2, java.io.File file3) {
        this.a = file;
        this.b = str;
        this.c = file2;
        this.d = file3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.Thread.sleep(1000L);
            this.a.delete();
            new java.io.File(this.b).delete();
            this.c.delete();
            this.d.delete();
            com.zx.a.I8b7.m0.a(this.d);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
