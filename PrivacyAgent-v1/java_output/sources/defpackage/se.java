package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class se implements androidx.arch.core.util.Function {
    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        return java.lang.Long.valueOf(((androidx.sqlite.db.SupportSQLiteDatabase) obj).getMaximumSize());
    }
}
