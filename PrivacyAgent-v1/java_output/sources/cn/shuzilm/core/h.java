package cn.shuzilm.core;

/* loaded from: classes.dex */
class h implements cn.shuzilm.core.Listener {
    final /* synthetic */ java.util.concurrent.atomic.AtomicReference a;
    final /* synthetic */ java.util.concurrent.CountDownLatch b;

    public h(java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.CountDownLatch countDownLatch) {
        this.a = atomicReference;
        this.b = countDownLatch;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(java.lang.String str) {
        this.a.set(str);
        this.b.countDown();
    }
}
