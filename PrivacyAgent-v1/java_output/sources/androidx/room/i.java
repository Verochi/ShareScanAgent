package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements androidx.arch.core.util.Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ i(boolean z) {
        this.a = z;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$setForeignKeyConstraintsEnabled$12;
        lambda$setForeignKeyConstraintsEnabled$12 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setForeignKeyConstraintsEnabled$12(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setForeignKeyConstraintsEnabled$12;
    }
}
