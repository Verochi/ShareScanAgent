package androidx.room;

/* loaded from: classes.dex */
final class QueryInterceptorOpenHelperFactory implements androidx.sqlite.db.SupportSQLiteOpenHelper.Factory {
    private final androidx.sqlite.db.SupportSQLiteOpenHelper.Factory mDelegate;
    private final androidx.room.RoomDatabase.QueryCallback mQueryCallback;
    private final java.util.concurrent.Executor mQueryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.QueryCallback queryCallback, @androidx.annotation.NonNull java.util.concurrent.Executor executor) {
        this.mDelegate = factory;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper create(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration configuration) {
        return new androidx.room.QueryInterceptorOpenHelper(this.mDelegate.create(configuration), this.mQueryCallback, this.mQueryCallbackExecutor);
    }
}
