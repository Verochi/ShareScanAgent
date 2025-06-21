package androidx.room;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements androidx.arch.core.util.Function {
    public final /* synthetic */ androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement a;
    public final /* synthetic */ androidx.arch.core.util.Function b;

    public /* synthetic */ o(androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, androidx.arch.core.util.Function function) {
        this.a = autoClosingSupportSqliteStatement;
        this.b = function;
    }

    @Override // androidx.arch.core.util.Function
    public final java.lang.Object apply(java.lang.Object obj) {
        java.lang.Object lambda$executeSqliteStatementWithRefCount$0;
        lambda$executeSqliteStatementWithRefCount$0 = this.a.lambda$executeSqliteStatementWithRefCount$0(this.b, (androidx.sqlite.db.SupportSQLiteDatabase) obj);
        return lambda$executeSqliteStatementWithRefCount$0;
    }
}
