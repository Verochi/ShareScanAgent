package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class k13 implements java.util.concurrent.ThreadFactory {
    public final /* synthetic */ kotlinx.coroutines.ThreadPoolDispatcher n;

    public /* synthetic */ k13(kotlinx.coroutines.ThreadPoolDispatcher threadPoolDispatcher) {
        this.n = threadPoolDispatcher;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread d;
        d = kotlinx.coroutines.ThreadPoolDispatcher.d(this.n, runnable);
        return d;
    }
}
