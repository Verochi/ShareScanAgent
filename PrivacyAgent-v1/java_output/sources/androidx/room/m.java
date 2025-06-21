package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ android.content.ContentValues c;
    public final /* synthetic */ java.lang.String d;
    public final /* synthetic */ java.lang.Object[] e;

    public /* synthetic */ m(java.lang.String str, int i, android.content.ContentValues contentValues, java.lang.String str2, java.lang.Object[] objArr) {
        this.a = str;
        this.b = i;
        this.c = contentValues;
        this.d = str2;
        this.e = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Integer lambda$update$6;
        lambda$update$6 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$update$6(this.a, this.b, this.c, this.d, this.e, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$update$6;
    }
}
