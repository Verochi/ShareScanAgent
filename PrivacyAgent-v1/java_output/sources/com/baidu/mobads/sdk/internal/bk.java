package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
final class bk implements java.lang.Runnable {
    final /* synthetic */ java.lang.Runnable a;

    public bk(java.lang.Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
