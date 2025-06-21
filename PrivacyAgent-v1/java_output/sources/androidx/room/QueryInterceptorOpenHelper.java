package androidx.room;

/* loaded from: classes.dex */
final class QueryInterceptorOpenHelper implements androidx.sqlite.db.SupportSQLiteOpenHelper, androidx.room.DelegatingOpenHelper {
    private final androidx.sqlite.db.SupportSQLiteOpenHelper mDelegate;
    private final androidx.room.RoomDatabase.QueryCallback mQueryCallback;
    private final java.util.concurrent.Executor mQueryCallbackExecutor;

    public QueryInterceptorOpenHelper(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper, @androidx.annotation.NonNull androidx.room.RoomDatabase.QueryCallback queryCallback, @androidx.annotation.NonNull java.util.concurrent.Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.Nullable
    public java.lang.String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public androidx.sqlite.db.SupportSQLiteDatabase getReadableDatabase() {
        return new androidx.room.QueryInterceptorDatabase(this.mDelegate.getReadableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public androidx.sqlite.db.SupportSQLiteDatabase getWritableDatabase() {
        return new androidx.room.QueryInterceptorDatabase(this.mDelegate.getWritableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }
}
