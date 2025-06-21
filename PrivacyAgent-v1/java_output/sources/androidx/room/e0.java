package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorStatement n;

    public /* synthetic */ e0(androidx.room.QueryInterceptorStatement queryInterceptorStatement) {
        this.n = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$execute$0();
    }
}
