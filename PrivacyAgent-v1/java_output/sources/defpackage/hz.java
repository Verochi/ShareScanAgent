package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class hz implements java.util.concurrent.Executor {
    public final /* synthetic */ android.os.Handler n;

    public /* synthetic */ hz(android.os.Handler handler) {
        this.n = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(java.lang.Runnable runnable) {
        this.n.post(runnable);
    }
}
