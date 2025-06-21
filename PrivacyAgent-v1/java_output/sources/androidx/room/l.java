package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements androidx.arch.core.util.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ l(int i) {
        this.a = i;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$setMaxSqlCacheSize$11;
        lambda$setMaxSqlCacheSize$11 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaxSqlCacheSize$11(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setMaxSqlCacheSize$11;
    }
}
