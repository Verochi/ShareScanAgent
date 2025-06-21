package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements androidx.arch.core.util.Function {
    public final /* synthetic */ java.util.Locale a;

    public /* synthetic */ n(java.util.Locale locale) {
        this.a = locale;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$setLocale$10;
        lambda$setLocale$10 = androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setLocale$10(this.a, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$setLocale$10;
    }
}
