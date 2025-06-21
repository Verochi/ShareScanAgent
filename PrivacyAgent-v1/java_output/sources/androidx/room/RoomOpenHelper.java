package androidx.room;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomOpenHelper extends androidx.sqlite.db.SupportSQLiteOpenHelper.Callback {

    @androidx.annotation.Nullable
    private androidx.room.DatabaseConfiguration mConfiguration;

    @androidx.annotation.NonNull
    private final androidx.room.RoomOpenHelper.Delegate mDelegate;

    @androidx.annotation.NonNull
    private final java.lang.String mIdentityHash;

    @androidx.annotation.NonNull
    private final java.lang.String mLegacyHash;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomOpenHelper.ValidationResult onValidateSchema(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            validateMigration(supportSQLiteDatabase);
            return new androidx.room.RoomOpenHelper.ValidationResult(true, null);
        }

        @java.lang.Deprecated
        public void validateMigration(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new java.lang.UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @androidx.annotation.Nullable
        public final java.lang.String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, @androidx.annotation.Nullable java.lang.String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(@androidx.annotation.NonNull androidx.room.DatabaseConfiguration databaseConfiguration, @androidx.annotation.NonNull androidx.room.RoomOpenHelper.Delegate delegate, @androidx.annotation.NonNull java.lang.String str) {
        this(databaseConfiguration, delegate, "", str);
    }

    public RoomOpenHelper(@androidx.annotation.NonNull androidx.room.DatabaseConfiguration databaseConfiguration, @androidx.annotation.NonNull androidx.room.RoomOpenHelper.Delegate delegate, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        super(delegate.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = delegate;
        this.mIdentityHash = str;
        this.mLegacyHash = str2;
    }

    private void checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!hasRoomMasterTable(supportSQLiteDatabase)) {
            androidx.room.RoomOpenHelper.ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.mDelegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            } else {
                throw new java.lang.IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        android.database.Cursor query = supportSQLiteDatabase.query(new androidx.sqlite.db.SimpleSQLiteQuery(androidx.room.RoomMasterTable.READ_QUERY));
        try {
            java.lang.String string = query.moveToFirst() ? query.getString(0) : null;
            query.close();
            if (!this.mIdentityHash.equals(string) && !this.mLegacyHash.equals(string)) {
                throw new java.lang.IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
            }
        } catch (java.lang.Throwable th) {
            query.close();
            throw th;
        }
    }

    private void createMasterTableIfNotExists(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(androidx.room.RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasEmptySchema(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        android.database.Cursor query = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            query.close();
        }
    }

    private static boolean hasRoomMasterTable(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        android.database.Cursor query = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (query.moveToFirst()) {
                if (query.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            query.close();
        }
    }

    private void updateIdentity(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(androidx.room.RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onConfigure(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean hasEmptySchema = hasEmptySchema(supportSQLiteDatabase);
        this.mDelegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema) {
            androidx.room.RoomOpenHelper.ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new java.lang.IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.mDelegate.onCreate(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        onUpgrade(supportSQLiteDatabase, i, i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.mDelegate.onOpen(supportSQLiteDatabase);
        this.mConfiguration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        boolean z;
        java.util.List<androidx.room.migration.Migration> findMigrationPath;
        androidx.room.DatabaseConfiguration databaseConfiguration = this.mConfiguration;
        if (databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i, i2)) == null) {
            z = false;
        } else {
            this.mDelegate.onPreMigrate(supportSQLiteDatabase);
            java.util.Iterator<androidx.room.migration.Migration> it = findMigrationPath.iterator();
            while (it.hasNext()) {
                it.next().migrate(supportSQLiteDatabase);
            }
            androidx.room.RoomOpenHelper.ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new java.lang.IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
            this.mDelegate.onPostMigrate(supportSQLiteDatabase);
            updateIdentity(supportSQLiteDatabase);
            z = true;
        }
        if (z) {
            return;
        }
        androidx.room.DatabaseConfiguration databaseConfiguration2 = this.mConfiguration;
        if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(i, i2)) {
            this.mDelegate.dropAllTables(supportSQLiteDatabase);
            this.mDelegate.createAllTables(supportSQLiteDatabase);
            return;
        }
        throw new java.lang.IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
