package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements androidx.arch.core.util.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$setVersion$1;
        lambda$setVersion$1 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setVersion$1(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setVersion$1;
    }
}
