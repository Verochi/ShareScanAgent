package com.igexin.push.core;

/* loaded from: classes23.dex */
public abstract class a extends java.lang.Thread {
    public abstract void a();

    public abstract java.lang.String b();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.Thread.currentThread().setName(b());
        if (android.os.Looper.myLooper() == null) {
            android.os.Looper.prepare();
            android.os.Looper.loop();
        }
    }
}
