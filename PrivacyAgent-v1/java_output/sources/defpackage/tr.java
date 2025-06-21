package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class tr implements java.util.concurrent.Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(java.lang.Runnable runnable) {
        kotlinx.coroutines.CommonPool.m(runnable);
    }
}
