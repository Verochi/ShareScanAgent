package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class v implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ v(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase, java.lang.String str, java.util.List list) {
        this.n = queryInterceptorDatabase;
        this.t = str;
        this.u = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$query$7(this.t, this.u);
    }
}
