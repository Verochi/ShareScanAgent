package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ c0(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase, java.lang.String str, java.util.List list) {
        this.n = queryInterceptorDatabase;
        this.t = str;
        this.u = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$execSQL$11(this.t, this.u);
    }
}
