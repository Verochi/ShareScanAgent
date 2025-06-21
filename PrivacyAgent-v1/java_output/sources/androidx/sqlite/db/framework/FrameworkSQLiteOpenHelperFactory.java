package androidx.sqlite.db.framework;

/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelperFactory implements androidx.sqlite.db.SupportSQLiteOpenHelper.Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper create(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration configuration) {
        return new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory);
    }
}
