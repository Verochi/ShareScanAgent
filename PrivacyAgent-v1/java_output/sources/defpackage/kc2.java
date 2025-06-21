package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class kc2 implements androidx.arch.core.util.Function {
    public final /* synthetic */ androidx.room.RoomDatabase a;

    public /* synthetic */ kc2(androidx.room.RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$beginTransaction$0;
        lambda$beginTransaction$0 = this.a.lambda$beginTransaction$0((androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$beginTransaction$0;
    }
}
