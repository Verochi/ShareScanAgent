package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ c(java.lang.String str) {
        this.a = str;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$execSQL$7;
        lambda$execSQL$7 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$7(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$execSQL$7;
    }
}
