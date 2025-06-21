package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ java.lang.Object[] c;

    public /* synthetic */ e(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        this.a = str;
        this.b = str2;
        this.c = objArr;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Integer lambda$delete$5;
        lambda$delete$5 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$delete$5(this.a, this.b, this.c, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$delete$5;
    }
}
