package androidx.room;

/* loaded from: classes.dex */
final class AutoClosingRoomOpenHelper implements androidx.sqlite.db.SupportSQLiteOpenHelper, androidx.room.DelegatingOpenHelper {

    @androidx.annotation.NonNull
    private final androidx.room.AutoCloser mAutoCloser;

    @androidx.annotation.NonNull
    private final androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase mAutoClosingDb;

    @androidx.annotation.NonNull
    private final androidx.sqlite.db.SupportSQLiteOpenHelper mDelegateOpenHelper;

    public static final class AutoClosingSupportSQLiteDatabase implements androidx.sqlite.db.SupportSQLiteDatabase {

        @androidx.annotation.NonNull
        private final androidx.room.AutoCloser mAutoCloser;

        public AutoClosingSupportSQLiteDatabase(@androidx.annotation.NonNull androidx.room.AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Integer lambda$delete$5(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Integer.valueOf(supportSQLiteDatabase.delete(str, str2, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$execSQL$7(java.lang.String str, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$execSQL$8(java.lang.String str, java.lang.Object[] objArr, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str, objArr);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Long lambda$insert$4(java.lang.String str, int i, android.content.ContentValues contentValues, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Long.valueOf(supportSQLiteDatabase.insert(str, i, contentValues));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Boolean lambda$isWriteAheadLoggingEnabled$13(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Boolean lambda$needUpgrade$9(int i, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Boolean.valueOf(supportSQLiteDatabase.needUpgrade(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$pokeOpen$0(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$setForeignKeyConstraintsEnabled$12(boolean z, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$setLocale$10(java.util.Locale locale, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setLocale(locale);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$setMaxSqlCacheSize$11(int i, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setMaxSqlCacheSize(i);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Long lambda$setMaximumSize$2(long j, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Long.valueOf(supportSQLiteDatabase.setMaximumSize(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$setPageSize$3(long j, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setPageSize(j);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$setVersion$1(int i, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setVersion(i);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Integer lambda$update$6(java.lang.String str, int i, android.content.ContentValues contentValues, java.lang.String str2, java.lang.Object[] objArr, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            return java.lang.Integer.valueOf(supportSQLiteDatabase.update(str, i, contentValues, str2, objArr));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public androidx.sqlite.db.SupportSQLiteStatement compileStatement(java.lang.String str) {
            return new androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement(str, this.mAutoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
            return ((java.lang.Integer) this.mAutoCloser.executeRefCountingFunction(new androidx.room.e(str, str2, objArr))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new java.lang.UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new java.lang.UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                throw new java.lang.IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                this.mAutoCloser.getDelegateDatabase().endTransaction();
            } finally {
                this.mAutoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void execPerConnectionSQL(java.lang.String str, java.lang.Object[] objArr) {
            defpackage.mu2.a(this, str, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(java.lang.String str) throws android.database.SQLException {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.c(str));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(java.lang.String str, java.lang.Object[] objArr) throws android.database.SQLException {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.j(str, objArr));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() {
            return (java.util.List) this.mAutoCloser.executeRefCountingFunction(new defpackage.bf());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((java.lang.Long) this.mAutoCloser.executeRefCountingFunction(new defpackage.se())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((java.lang.Long) this.mAutoCloser.executeRefCountingFunction(new defpackage.ue())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public java.lang.String getPath() {
            return (java.lang.String) this.mAutoCloser.executeRefCountingFunction(new defpackage.ve());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((java.lang.Integer) this.mAutoCloser.executeRefCountingFunction(new defpackage.xe())).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.af())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(java.lang.String str, int i, android.content.ContentValues contentValues) throws android.database.SQLException {
            return ((java.lang.Long) this.mAutoCloser.executeRefCountingFunction(new androidx.room.k(str, i, contentValues))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.te())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.ye())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return defpackage.mu2.b(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            androidx.sqlite.db.SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.ze())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @androidx.annotation.RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new androidx.room.a())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(int i) {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new androidx.room.g(i))).booleanValue();
        }

        public void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.b());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new androidx.room.AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.mAutoCloser);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @androidx.annotation.RequiresApi(api = 24)
        public android.database.Cursor query(androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, android.os.CancellationSignal cancellationSignal) {
            try {
                return new androidx.room.AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.mAutoCloser);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public android.database.Cursor query(java.lang.String str) {
            try {
                return new androidx.room.AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.mAutoCloser);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public android.database.Cursor query(java.lang.String str, java.lang.Object[] objArr) {
            try {
                return new androidx.room.AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.mAutoCloser);
            } catch (java.lang.Throwable th) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @androidx.annotation.RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(boolean z) {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.i(z));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(java.util.Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.n(locale));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(int i) {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.l(i));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(long j) {
            return ((java.lang.Long) this.mAutoCloser.executeRefCountingFunction(new androidx.room.f(j))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(long j) {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.h(j));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            androidx.sqlite.db.SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                throw new java.lang.IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
            delegateDatabase.setTransactionSuccessful();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(int i) {
            this.mAutoCloser.executeRefCountingFunction(new androidx.room.d(i));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(java.lang.String str, int i, android.content.ContentValues contentValues, java.lang.String str2, java.lang.Object[] objArr) {
            return ((java.lang.Integer) this.mAutoCloser.executeRefCountingFunction(new androidx.room.m(str, i, contentValues, str2, objArr))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.we())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long j) {
            return ((java.lang.Boolean) this.mAutoCloser.executeRefCountingFunction(new defpackage.we())).booleanValue();
        }
    }

    public static class AutoClosingSupportSqliteStatement implements androidx.sqlite.db.SupportSQLiteStatement {
        private final androidx.room.AutoCloser mAutoCloser;
        private final java.util.ArrayList<java.lang.Object> mBinds = new java.util.ArrayList<>();
        private final java.lang.String mSql;

        public AutoClosingSupportSqliteStatement(java.lang.String str, androidx.room.AutoCloser autoCloser) {
            this.mSql = str;
            this.mAutoCloser = autoCloser;
        }

        private void doBinds(androidx.sqlite.db.SupportSQLiteStatement supportSQLiteStatement) {
            int i = 0;
            while (i < this.mBinds.size()) {
                int i2 = i + 1;
                java.lang.Object obj = this.mBinds.get(i);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i2);
                } else if (obj instanceof java.lang.Long) {
                    supportSQLiteStatement.bindLong(i2, ((java.lang.Long) obj).longValue());
                } else if (obj instanceof java.lang.Double) {
                    supportSQLiteStatement.bindDouble(i2, ((java.lang.Double) obj).doubleValue());
                } else if (obj instanceof java.lang.String) {
                    supportSQLiteStatement.bindString(i2, (java.lang.String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i2, (byte[]) obj);
                }
                i = i2;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(androidx.arch.core.util.Function<androidx.sqlite.db.SupportSQLiteStatement, T> function) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new androidx.room.o(this, function));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ java.lang.Object lambda$execute$1(androidx.sqlite.db.SupportSQLiteStatement supportSQLiteStatement) {
            supportSQLiteStatement.execute();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ java.lang.Object lambda$executeSqliteStatementWithRefCount$0(androidx.arch.core.util.Function function, androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            androidx.sqlite.db.SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(compileStatement);
            return function.apply(compileStatement);
        }

        private void saveBinds(int i, java.lang.Object obj) {
            int i2 = i - 1;
            if (i2 >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i2; size++) {
                    this.mBinds.add(null);
                }
            }
            this.mBinds.set(i2, obj);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i, byte[] bArr) {
            saveBinds(i, bArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i, double d) {
            saveBinds(i, java.lang.Double.valueOf(d));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i, long j) {
            saveBinds(i, java.lang.Long.valueOf(j));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i) {
            saveBinds(i, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i, java.lang.String str) {
            saveBinds(i, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(new androidx.room.p());
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((java.lang.Long) executeSqliteStatementWithRefCount(new defpackage.ef())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((java.lang.Integer) executeSqliteStatementWithRefCount(new defpackage.cf())).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((java.lang.Long) executeSqliteStatementWithRefCount(new defpackage.ff())).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public java.lang.String simpleQueryForString() {
            return (java.lang.String) executeSqliteStatementWithRefCount(new defpackage.df());
        }
    }

    public static final class KeepAliveCursor implements android.database.Cursor {
        private final androidx.room.AutoCloser mAutoCloser;
        private final android.database.Cursor mDelegate;

        public KeepAliveCursor(android.database.Cursor cursor, androidx.room.AutoCloser autoCloser) {
            this.mDelegate = cursor;
            this.mAutoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i, android.database.CharArrayBuffer charArrayBuffer) {
            this.mDelegate.copyStringToBuffer(i, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @java.lang.Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i) {
            return this.mDelegate.getBlob(i);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(java.lang.String str) {
            return this.mDelegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(java.lang.String str) throws java.lang.IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public java.lang.String getColumnName(int i) {
            return this.mDelegate.getColumnName(i);
        }

        @Override // android.database.Cursor
        public java.lang.String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i) {
            return this.mDelegate.getDouble(i);
        }

        @Override // android.database.Cursor
        public android.os.Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i) {
            return this.mDelegate.getFloat(i);
        }

        @Override // android.database.Cursor
        public int getInt(int i) {
            return this.mDelegate.getInt(i);
        }

        @Override // android.database.Cursor
        public long getLong(int i) {
            return this.mDelegate.getLong(i);
        }

        @Override // android.database.Cursor
        @androidx.annotation.RequiresApi(api = 19)
        public android.net.Uri getNotificationUri() {
            return androidx.sqlite.db.SupportSQLiteCompat.Api19Impl.getNotificationUri(this.mDelegate);
        }

        @Override // android.database.Cursor
        @androidx.annotation.Nullable
        @androidx.annotation.RequiresApi(api = 29)
        public java.util.List<android.net.Uri> getNotificationUris() {
            return androidx.sqlite.db.SupportSQLiteCompat.Api29Impl.getNotificationUris(this.mDelegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i) {
            return this.mDelegate.getShort(i);
        }

        @Override // android.database.Cursor
        public java.lang.String getString(int i) {
            return this.mDelegate.getString(i);
        }

        @Override // android.database.Cursor
        public int getType(int i) {
            return this.mDelegate.getType(i);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i) {
            return this.mDelegate.isNull(i);
        }

        @Override // android.database.Cursor
        public boolean move(int i) {
            return this.mDelegate.move(i);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i) {
            return this.mDelegate.moveToPosition(i);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(android.database.ContentObserver contentObserver) {
            this.mDelegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            this.mDelegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @java.lang.Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public android.os.Bundle respond(android.os.Bundle bundle) {
            return this.mDelegate.respond(bundle);
        }

        @Override // android.database.Cursor
        @androidx.annotation.RequiresApi(api = 23)
        public void setExtras(android.os.Bundle bundle) {
            androidx.sqlite.db.SupportSQLiteCompat.Api23Impl.setExtras(this.mDelegate, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(android.content.ContentResolver contentResolver, android.net.Uri uri) {
            this.mDelegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @androidx.annotation.RequiresApi(api = 29)
        public void setNotificationUris(@androidx.annotation.NonNull android.content.ContentResolver contentResolver, @androidx.annotation.NonNull java.util.List<android.net.Uri> list) {
            androidx.sqlite.db.SupportSQLiteCompat.Api29Impl.setNotificationUris(this.mDelegate, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(android.database.ContentObserver contentObserver) {
            this.mDelegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            this.mDelegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper, @androidx.annotation.NonNull androidx.room.AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(supportSQLiteOpenHelper);
        this.mAutoClosingDb = new androidx.room.AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.mAutoClosingDb.close();
        } catch (java.io.IOException e) {
            androidx.room.util.SneakyThrow.reThrow(e);
        }
    }

    @androidx.annotation.NonNull
    public androidx.room.AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.Nullable
    public java.lang.String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(api = 24)
    public androidx.sqlite.db.SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(api = 24)
    public androidx.sqlite.db.SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(z);
    }
}
