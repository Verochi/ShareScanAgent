package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ a0(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase, java.lang.String str) {
        this.n = queryInterceptorDatabase;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$query$6(this.t);
    }
}
