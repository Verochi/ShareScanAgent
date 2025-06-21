package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements androidx.arch.core.util.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ g(int i) {
        this.a = i;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Boolean lambda$needUpgrade$9;
        lambda$needUpgrade$9 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$needUpgrade$9(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$needUpgrade$9;
    }
}
