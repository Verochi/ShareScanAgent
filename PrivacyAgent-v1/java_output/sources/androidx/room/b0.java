package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;

    public /* synthetic */ b0(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase) {
        this.n = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$endTransaction$4();
    }
}
