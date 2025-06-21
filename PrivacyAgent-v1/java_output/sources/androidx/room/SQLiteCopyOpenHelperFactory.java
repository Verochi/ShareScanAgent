package androidx.room;

/* loaded from: classes.dex */
class SQLiteCopyOpenHelperFactory implements androidx.sqlite.db.SupportSQLiteOpenHelper.Factory {

    @androidx.annotation.Nullable
    private final java.lang.String mCopyFromAssetPath;

    @androidx.annotation.Nullable
    private final java.io.File mCopyFromFile;

    @androidx.annotation.Nullable
    private final java.util.concurrent.Callable<java.io.InputStream> mCopyFromInputStream;

    @androidx.annotation.NonNull
    private final androidx.sqlite.db.SupportSQLiteOpenHelper.Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory) {
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper create(androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration configuration) {
        return new androidx.room.SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
