package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements androidx.arch.core.util.Function {
    public final /* synthetic */ long a;

    public /* synthetic */ h(long j) {
        this.a = j;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$setPageSize$3;
        lambda$setPageSize$3 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setPageSize$3(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setPageSize$3;
    }
}
