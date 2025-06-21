package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class rr implements java.util.concurrent.ThreadFactory {
    public final /* synthetic */ java.util.concurrent.atomic.AtomicInteger n;

    public /* synthetic */ rr(java.util.concurrent.atomic.AtomicInteger atomicInteger) {
        this.n = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread f;
        f = kotlinx.coroutines.CommonPool.f(this.n, runnable);
        return f;
    }
}
