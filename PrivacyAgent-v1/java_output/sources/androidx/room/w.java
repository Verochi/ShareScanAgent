package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class w implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;

    public /* synthetic */ w(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase) {
        this.n = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$setTransactionSuccessful$5();
    }
}
