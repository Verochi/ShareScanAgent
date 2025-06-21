package androidx.room;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    private final androidx.room.RoomDatabase mDatabase;
    private final java.util.concurrent.atomic.AtomicBoolean mLock = new java.util.concurrent.atomic.AtomicBoolean(false);
    private volatile androidx.sqlite.db.SupportSQLiteStatement mStmt;

    public SharedSQLiteStatement(androidx.room.RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    private androidx.sqlite.db.SupportSQLiteStatement createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private androidx.sqlite.db.SupportSQLiteStatement getStmt(boolean z) {
        if (!z) {
            return createNewStatement();
        }
        if (this.mStmt == null) {
            this.mStmt = createNewStatement();
        }
        return this.mStmt;
    }

    public androidx.sqlite.db.SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    public abstract java.lang.String createQuery();

    public void release(androidx.sqlite.db.SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
