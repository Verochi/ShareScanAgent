package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorStatement n;

    public /* synthetic */ f0(androidx.room.QueryInterceptorStatement queryInterceptorStatement) {
        this.n = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$executeInsert$2();
    }
}
