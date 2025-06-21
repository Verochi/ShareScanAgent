package androidx.room.util;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DBUtil {
    private DBUtil() {
    }

    @androidx.annotation.Nullable
    public static android.os.CancellationSignal createCancellationSignal() {
        return androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static void dropFtsSyncTriggers(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        android.database.Cursor query = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(0));
            } catch (java.lang.Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        for (java.lang.String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static void foreignKeyCheck(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, @androidx.annotation.NonNull java.lang.String str) {
        android.database.Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (query.getCount() <= 0) {
            } else {
                throw new java.lang.IllegalStateException(processForeignKeyCheckFailure(query));
            }
        } finally {
            query.close();
        }
    }

    private static java.lang.String processForeignKeyCheckFailure(android.database.Cursor cursor) {
        int count = cursor.getCount();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str = null;
        while (cursor.moveToNext()) {
            if (str == null) {
                str = cursor.getString(0);
            }
            java.lang.String string = cursor.getString(3);
            if (!hashMap.containsKey(string)) {
                hashMap.put(string, cursor.getString(2));
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Foreign key violation(s) detected in '");
        sb.append(str);
        sb.append("'.\n");
        sb.append("Number of different violations discovered: ");
        sb.append(hashMap.keySet().size());
        sb.append("\n");
        sb.append("Number of rows in violation: ");
        sb.append(count);
        sb.append("\n");
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            sb.append("\tParent Table = ");
            sb.append((java.lang.String) entry.getValue());
            sb.append(", Foreign Key Constraint Index = ");
            sb.append((java.lang.String) entry.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static android.database.Cursor query(androidx.room.RoomDatabase roomDatabase, androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, boolean z) {
        return query(roomDatabase, supportSQLiteQuery, z, null);
    }

    @androidx.annotation.NonNull
    public static android.database.Cursor query(@androidx.annotation.NonNull androidx.room.RoomDatabase roomDatabase, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, boolean z, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        android.database.Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z || !(query instanceof android.database.AbstractWindowedCursor)) {
            return query;
        }
        android.database.AbstractWindowedCursor abstractWindowedCursor = (android.database.AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (android.os.Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? androidx.room.util.CursorUtil.copyAndClose(abstractWindowedCursor) : query;
    }

    public static int readVersion(@androidx.annotation.NonNull java.io.File file) throws java.io.IOException {
        java.nio.channels.spi.AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(4);
            java.nio.channels.FileChannel channel = new java.io.FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new java.io.IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i = allocate.getInt();
            channel.close();
            return i;
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}
