package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ android.content.ContentValues c;

    public /* synthetic */ k(java.lang.String str, int i, android.content.ContentValues contentValues) {
        this.a = str;
        this.b = i;
        this.c = contentValues;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Long lambda$insert$4;
        lambda$insert$4 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$insert$4(this.a, this.b, this.c, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$insert$4;
    }
}
