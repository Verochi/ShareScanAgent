package androidx.sqlite.db;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SupportSQLiteCompat {

    @androidx.annotation.RequiresApi(16)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void cancel(@androidx.annotation.NonNull android.os.CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static android.os.CancellationSignal createCancellationSignal() {
            return new android.os.CancellationSignal();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean deleteDatabase(@androidx.annotation.NonNull java.io.File file) {
            return android.database.sqlite.SQLiteDatabase.deleteDatabase(file);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void disableWriteAheadLogging(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isWriteAheadLoggingEnabled(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static android.database.Cursor rawQueryWithFactory(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase sQLiteDatabase, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.NonNull android.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory) {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void setForeignKeyConstraintsEnabled(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase sQLiteDatabase, boolean z) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void setWriteAheadLoggingEnabled(@androidx.annotation.NonNull android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
    }

    @androidx.annotation.RequiresApi(19)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api19Impl {
        private Api19Impl() {
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static android.net.Uri getNotificationUri(@androidx.annotation.NonNull android.database.Cursor cursor) {
            return cursor.getNotificationUri();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isLowRamDevice(@androidx.annotation.NonNull android.app.ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    @androidx.annotation.RequiresApi(21)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {
        private Api21Impl() {
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static java.io.File getNoBackupFilesDir(@androidx.annotation.NonNull android.content.Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @androidx.annotation.RequiresApi(23)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void setExtras(@androidx.annotation.NonNull android.database.Cursor cursor, @androidx.annotation.NonNull android.os.Bundle bundle) {
            cursor.setExtras(bundle);
        }
    }

    @androidx.annotation.RequiresApi(29)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {
        private Api29Impl() {
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static java.util.List<android.net.Uri> getNotificationUris(@androidx.annotation.NonNull android.database.Cursor cursor) {
            java.util.List<android.net.Uri> notificationUris;
            notificationUris = cursor.getNotificationUris();
            return notificationUris;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static void setNotificationUris(@androidx.annotation.NonNull android.database.Cursor cursor, @androidx.annotation.NonNull android.content.ContentResolver contentResolver, @androidx.annotation.NonNull java.util.List<android.net.Uri> list) {
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    private SupportSQLiteCompat() {
    }
}
