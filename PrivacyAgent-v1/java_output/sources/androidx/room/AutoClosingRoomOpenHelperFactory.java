package androidx.room;

/* loaded from: classes.dex */
final class AutoClosingRoomOpenHelperFactory implements androidx.sqlite.db.SupportSQLiteOpenHelper.Factory {

    @androidx.annotation.NonNull
    private final androidx.room.AutoCloser mAutoCloser;

    @androidx.annotation.NonNull
    private final androidx.sqlite.db.SupportSQLiteOpenHelper.Factory mDelegate;

    public AutoClosingRoomOpenHelperFactory(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.AutoCloser autoCloser) {
        this.mDelegate = factory;
        this.mAutoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @androidx.annotation.NonNull
    public androidx.room.AutoClosingRoomOpenHelper create(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration configuration) {
        return new androidx.room.AutoClosingRoomOpenHelper(this.mDelegate.create(configuration), this.mAutoCloser);
    }
}
