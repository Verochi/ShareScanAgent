package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class u implements java.lang.Runnable {
    public final /* synthetic */ androidx.room.QueryInterceptorDatabase n;
    public final /* synthetic */ androidx.sqlite.db.SupportSQLiteQuery t;
    public final /* synthetic */ androidx.room.QueryInterceptorProgram u;

    public /* synthetic */ u(androidx.room.QueryInterceptorDatabase queryInterceptorDatabase, androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, androidx.room.QueryInterceptorProgram queryInterceptorProgram) {
        this.n = queryInterceptorDatabase;
        this.t = supportSQLiteQuery;
        this.u = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.lambda$query$9(this.t, this.u);
    }
}
