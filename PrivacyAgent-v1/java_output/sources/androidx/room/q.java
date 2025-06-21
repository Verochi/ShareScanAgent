package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class q implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;

    public /* synthetic */ q(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase) {
        this.n = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$beginTransactionNonExclusive$1();
    }
}
