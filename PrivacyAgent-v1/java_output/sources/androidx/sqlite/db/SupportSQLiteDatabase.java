package androidx.sqlite.db;

/* loaded from: classes.dex */
public interface SupportSQLiteDatabase extends java.io.Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener);

    void beginTransactionWithListenerNonExclusive(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener);

    androidx.sqlite.db.SupportSQLiteStatement compileStatement(java.lang.String str);

    int delete(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr);

    @androidx.annotation.RequiresApi(api = 16)
    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    void execPerConnectionSQL(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable @android.annotation.SuppressLint({"ArrayReturn"}) java.lang.Object[] objArr);

    void execSQL(java.lang.String str) throws android.database.SQLException;

    void execSQL(java.lang.String str, java.lang.Object[] objArr) throws android.database.SQLException;

    java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    java.lang.String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(java.lang.String str, int i, android.content.ContentValues contentValues) throws android.database.SQLException;

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    boolean isExecPerConnectionSQLSupported();

    boolean isOpen();

    boolean isReadOnly();

    @androidx.annotation.RequiresApi(api = 16)
    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int i);

    android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery);

    @androidx.annotation.RequiresApi(api = 16)
    android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, android.os.CancellationSignal cancellationSignal);

    android.database.Cursor query(java.lang.String str);

    android.database.Cursor query(java.lang.String str, java.lang.Object[] objArr);

    @androidx.annotation.RequiresApi(api = 16)
    void setForeignKeyConstraintsEnabled(boolean z);

    void setLocale(java.util.Locale locale);

    void setMaxSqlCacheSize(int i);

    long setMaximumSize(long j);

    void setPageSize(long j);

    void setTransactionSuccessful();

    void setVersion(int i);

    int update(java.lang.String str, int i, android.content.ContentValues contentValues, java.lang.String str2, java.lang.Object[] objArr);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long j);
}
