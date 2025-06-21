package com.alipay.apmobilesecuritysdk.f;

/* loaded from: classes.dex */
public final class b {
    public static com.alipay.apmobilesecuritysdk.f.b a = new com.alipay.apmobilesecuritysdk.f.b();
    public java.lang.Thread b = null;
    public java.util.LinkedList<java.lang.Runnable> c = new java.util.LinkedList<>();

    public static com.alipay.apmobilesecuritysdk.f.b a() {
        return a;
    }

    public static /* synthetic */ java.lang.Thread b(com.alipay.apmobilesecuritysdk.f.b bVar) {
        bVar.b = null;
        return null;
    }

    public final synchronized void a(java.lang.Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            java.lang.Thread thread = new java.lang.Thread(new com.alipay.apmobilesecuritysdk.f.c(this));
            this.b = thread;
            thread.start();
        }
    }
}
