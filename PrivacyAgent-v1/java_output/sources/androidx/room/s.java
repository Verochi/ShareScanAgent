package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ s(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase, java.lang.String str) {
        this.n = queryInterceptorDatabase;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$execSQL$10(this.t);
    }
}
