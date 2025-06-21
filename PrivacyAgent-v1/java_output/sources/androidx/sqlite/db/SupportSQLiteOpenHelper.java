package androidx.sqlite.db;

/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends java.io.Closeable {

    public static abstract class Callback {
        private static final java.lang.String TAG = "SupportSQLite";
        public final int version;

        public Callback(int i) {
            this.version = i;
        }

        private void deleteDatabaseFile(java.lang.String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("deleting the database file: ");
            sb.append(str);
            try {
                androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.deleteDatabase(new java.io.File(str));
            } catch (java.lang.Exception unused) {
            }
        }

        public void onConfigure(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onCorruption(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Corruption reported by sqlite on database: ");
            sb.append(supportSQLiteDatabase.getPath());
            if (!supportSQLiteDatabase.isOpen()) {
                deleteDatabaseFile(supportSQLiteDatabase.getPath());
                return;
            }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list = null;
            try {
                try {
                    list = supportSQLiteDatabase.getAttachedDbs();
                } catch (android.database.sqlite.SQLiteException unused) {
                }
                try {
                    supportSQLiteDatabase.close();
                } catch (java.io.IOException unused2) {
                }
            } finally {
                if (list != null) {
                    java.util.Iterator<android.util.Pair<java.lang.String, java.lang.String>> it = list.iterator();
                    while (it.hasNext()) {
                        deleteDatabaseFile((java.lang.String) it.next().second);
                    }
                } else {
                    deleteDatabaseFile(supportSQLiteDatabase.getPath());
                }
            }
        }

        public abstract void onCreate(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new android.database.sqlite.SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void onOpen(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    public static class Configuration {

        @androidx.annotation.NonNull
        public final androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback;

        @androidx.annotation.NonNull
        public final android.content.Context context;

        @androidx.annotation.Nullable
        public final java.lang.String name;
        public final boolean useNoBackupDirectory;

        public static class Builder {
            androidx.sqlite.db.SupportSQLiteOpenHelper.Callback mCallback;
            android.content.Context mContext;
            java.lang.String mName;
            boolean mUseNoBackupDirectory;

            public Builder(@androidx.annotation.NonNull android.content.Context context) {
                this.mContext = context;
            }

            @androidx.annotation.NonNull
            public androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration build() {
                if (this.mCallback == null) {
                    throw new java.lang.IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.mContext == null) {
                    throw new java.lang.IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.mUseNoBackupDirectory && android.text.TextUtils.isEmpty(this.mName)) {
                    throw new java.lang.IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackupDirectory);
            }

            @androidx.annotation.NonNull
            public androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder callback(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback) {
                this.mCallback = callback;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder name(@androidx.annotation.Nullable java.lang.String str) {
                this.mName = str;
                return this;
            }

            @androidx.annotation.NonNull
            public androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder noBackupDirectory(boolean z) {
                this.mUseNoBackupDirectory = z;
                return this;
            }
        }

        public Configuration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback) {
            this(context, str, callback, false);
        }

        public Configuration(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback, boolean z) {
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z;
        }

        @androidx.annotation.NonNull
        public static androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder builder(@androidx.annotation.NonNull android.content.Context context) {
            return new androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder(context);
        }
    }

    public interface Factory {
        @androidx.annotation.NonNull
        androidx.sqlite.db.SupportSQLiteOpenHelper create(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @androidx.annotation.Nullable
    java.lang.String getDatabaseName();

    androidx.sqlite.db.SupportSQLiteDatabase getReadableDatabase();

    androidx.sqlite.db.SupportSQLiteDatabase getWritableDatabase();

    @androidx.annotation.RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
