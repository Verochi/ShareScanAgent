package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ java.lang.Object[] b;

    public /* synthetic */ j(java.lang.String str, java.lang.Object[] objArr) {
        this.a = str;
        this.b = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$execSQL$8;
        lambda$execSQL$8 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$8(this.a, this.b, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$execSQL$8;
    }
}
