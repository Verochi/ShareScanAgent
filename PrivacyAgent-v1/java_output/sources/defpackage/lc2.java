package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class lc2 implements androidx.arch.core.util.Function {
    public final /* synthetic */ androidx.room.RoomDatabase a;

    public /* synthetic */ lc2(androidx.room.RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$endTransaction$1;
        lambda$endTransaction$1 = this.a.lambda$endTransaction$1((androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$endTransaction$1;
    }
}
