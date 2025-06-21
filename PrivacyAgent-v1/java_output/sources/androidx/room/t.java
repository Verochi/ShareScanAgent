package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;

    public /* synthetic */ t(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase) {
        this.n = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$beginTransactionWithListener$2();
    }
}
