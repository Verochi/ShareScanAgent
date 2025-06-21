package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class d0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorStatement n;

    public /* synthetic */ d0(androidx.room.QueryInterceptorStatement queryInterceptorStatement) {
        this.n = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$executeUpdateDelete$1();
    }
}
