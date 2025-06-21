package androidx.room;

/* loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @androidx.annotation.NonNull
    public final java.util.List<androidx.room.migration.AutoMigrationSpec> autoMigrationSpecs;

    @androidx.annotation.Nullable
    public final java.util.List<androidx.room.RoomDatabase.Callback> callbacks;

    @androidx.annotation.NonNull
    public final android.content.Context context;

    @androidx.annotation.Nullable
    public final java.lang.String copyFromAssetPath;

    @androidx.annotation.Nullable
    public final java.io.File copyFromFile;

    @androidx.annotation.Nullable
    public final java.util.concurrent.Callable<java.io.InputStream> copyFromInputStream;
    public final androidx.room.RoomDatabase.JournalMode journalMode;
    private final java.util.Set<java.lang.Integer> mMigrationNotRequiredFrom;

    @androidx.annotation.NonNull
    public final androidx.room.RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @androidx.annotation.Nullable
    public final java.lang.String name;

    @androidx.annotation.Nullable
    public final androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @androidx.annotation.NonNull
    public final java.util.concurrent.Executor queryExecutor;
    public final boolean requireMigration;

    @androidx.annotation.NonNull
    public final androidx.sqlite.db.SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @androidx.annotation.NonNull
    public final java.util.concurrent.Executor transactionExecutor;

    @androidx.annotation.NonNull
    public final java.util.List<java.lang.Object> typeConverters;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, null, null, null, null, null, null);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.io.File file) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, null, null, null, null);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, @androidx.annotation.NonNull androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, callable, null, null, null);
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, @androidx.annotation.NonNull androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable, @androidx.annotation.Nullable androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, null, null);
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, @androidx.annotation.NonNull androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable, @androidx.annotation.Nullable androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @androidx.annotation.Nullable java.util.List<java.lang.Object> list2) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor2, z2, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, list2, null);
    }

    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, @androidx.annotation.NonNull androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.util.concurrent.Executor executor2, boolean z2, boolean z3, boolean z4, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable, @androidx.annotation.Nullable androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @androidx.annotation.Nullable java.util.List<java.lang.Object> list2, @androidx.annotation.Nullable java.util.List<androidx.room.migration.AutoMigrationSpec> list3) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidation = z2;
        this.requireMigration = z3;
        this.allowDestructiveMigrationOnDowngrade = z4;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2 == null ? java.util.Collections.emptyList() : list2;
        this.autoMigrationSpecs = list3 == null ? java.util.Collections.emptyList() : list3;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public DatabaseConfiguration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory, @androidx.annotation.NonNull androidx.room.RoomDatabase.MigrationContainer migrationContainer, @androidx.annotation.Nullable java.util.List<androidx.room.RoomDatabase.Callback> list, boolean z, androidx.room.RoomDatabase.JournalMode journalMode, @androidx.annotation.NonNull java.util.concurrent.Executor executor, boolean z2, @androidx.annotation.Nullable java.util.Set<java.lang.Integer> set) {
        this(context, str, factory, migrationContainer, list, z, journalMode, executor, executor, false, z2, false, set, null, null, null, null, null, null);
    }

    public boolean isMigrationRequired(int i, int i2) {
        java.util.Set<java.lang.Integer> set;
        return !((i > i2) && this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(java.lang.Integer.valueOf(i)));
    }

    @java.lang.Deprecated
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }
}
