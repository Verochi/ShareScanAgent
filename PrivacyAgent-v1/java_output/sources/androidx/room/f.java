package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements androidx.arch.core.util.Function {
    public final /* synthetic */ long a;

    public /* synthetic */ f(long j) {
        this.a = j;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Long lambda$setMaximumSize$2;
        lambda$setMaximumSize$2 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaximumSize$2(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setMaximumSize$2;
    }
}
