package androidx.sqlite.db.framework;

/* loaded from: classes.dex */
class FrameworkSQLiteDatabase implements androidx.sqlite.db.SupportSQLiteDatabase {
    private static final java.lang.String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final java.lang.String[] EMPTY_STRING_ARRAY = new java.lang.String[0];
    private final android.database.sqlite.SQLiteDatabase mDelegate;

    /* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$1, reason: invalid class name */
    public class AnonymousClass1 implements android.database.sqlite.SQLiteDatabase.CursorFactory {
        final /* synthetic */ androidx.sqlite.db.SupportSQLiteQuery val$supportQuery;

        public AnonymousClass1(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery) {
            this.val$supportQuery = supportSQLiteQuery;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.database.sqlite.SQLiteCursorDriver sQLiteCursorDriver, java.lang.String str, android.database.sqlite.SQLiteQuery sQLiteQuery) {
            this.val$supportQuery.bindTo(new androidx.sqlite.db.framework.FrameworkSQLiteProgram(sQLiteQuery));
            return new android.database.sqlite.SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$2, reason: invalid class name */
    public class AnonymousClass2 implements android.database.sqlite.SQLiteDatabase.CursorFactory {
        final /* synthetic */ androidx.sqlite.db.SupportSQLiteQuery val$supportQuery;

        public AnonymousClass2(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery) {
            this.val$supportQuery = supportSQLiteQuery;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.database.sqlite.SQLiteCursorDriver sQLiteCursorDriver, java.lang.String str, android.database.sqlite.SQLiteQuery sQLiteQuery) {
            this.val$supportQuery.bindTo(new androidx.sqlite.db.framework.FrameworkSQLiteProgram(sQLiteQuery));
            return new android.database.sqlite.SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public FrameworkSQLiteDatabase(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.mDelegate = sQLiteDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public androidx.sqlite.db.SupportSQLiteStatement compileStatement(java.lang.String str) {
        return new androidx.sqlite.db.framework.FrameworkSQLiteStatement(this.mDelegate.compileStatement(str));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb.append(str3);
        androidx.sqlite.db.SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        androidx.sqlite.db.SimpleSQLiteQuery.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @androidx.annotation.RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.mDelegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object[] objArr) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.mDelegate.execPerConnectionSQL(str, objArr);
            return;
        }
        throw new java.lang.UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(java.lang.String str) throws android.database.SQLException {
        this.mDelegate.execSQL(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(java.lang.String str, java.lang.Object[] objArr) throws android.database.SQLException {
        this.mDelegate.execSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public java.lang.String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(java.lang.String str, int i, android.content.ContentValues contentValues) throws android.database.SQLException {
        return this.mDelegate.insertWithOnConflict(str, null, contentValues, i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public boolean isDelegate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        return this.mDelegate == sQLiteDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @androidx.annotation.RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.mDelegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        return this.mDelegate.needUpgrade(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery) {
        return this.mDelegate.rawQueryWithFactory(new androidx.sqlite.db.framework.FrameworkSQLiteDatabase.AnonymousClass1(supportSQLiteQuery), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @androidx.annotation.RequiresApi(api = 16)
    public android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, android.os.CancellationSignal cancellationSignal) {
        return androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(this.mDelegate, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null, cancellationSignal, new androidx.sqlite.db.framework.FrameworkSQLiteDatabase.AnonymousClass2(supportSQLiteQuery));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(java.lang.String str) {
        return query(new androidx.sqlite.db.SimpleSQLiteQuery(str));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(java.lang.String str, java.lang.Object[] objArr) {
        return query(new androidx.sqlite.db.SimpleSQLiteQuery(str, objArr));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @androidx.annotation.RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.mDelegate, z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(java.util.Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        this.mDelegate.setMaxSqlCacheSize(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        return this.mDelegate.setMaximumSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        this.mDelegate.setPageSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) {
        this.mDelegate.setVersion(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(java.lang.String str, int i, android.content.ContentValues contentValues, java.lang.String str2, java.lang.Object[] objArr) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new java.lang.IllegalArgumentException("Empty values");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(CONFLICT_VALUES[i]);
        sb.append(str);
        sb.append(" SET ");
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        java.lang.Object[] objArr2 = new java.lang.Object[length];
        int i2 = 0;
        for (java.lang.String str3 : contentValues.keySet()) {
            sb.append(i2 > 0 ? "," : "");
            sb.append(str3);
            objArr2[i2] = contentValues.get(str3);
            sb.append("=?");
            i2++;
        }
        if (objArr != null) {
            for (int i3 = size; i3 < length; i3++) {
                objArr2[i3] = objArr[i3 - size];
            }
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        androidx.sqlite.db.SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        androidx.sqlite.db.SimpleSQLiteQuery.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        return this.mDelegate.yieldIfContendedSafely(j);
    }
}
