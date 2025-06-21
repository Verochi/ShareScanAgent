package com.google.android.exoplayer2.database;

/* loaded from: classes22.dex */
public final class ExoDatabaseProvider extends android.database.sqlite.SQLiteOpenHelper implements com.google.android.exoplayer2.database.DatabaseProvider {
    public static final java.lang.String DATABASE_NAME = "exoplayer_internal.db";

    public ExoDatabaseProvider(android.content.Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor query = sQLiteDatabase.query("sqlite_master", new java.lang.String[]{"type", "name"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                java.lang.String string = query.getString(0);
                java.lang.String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(string).length() + 16 + java.lang.String.valueOf(string2).length());
                    sb.append("DROP ");
                    sb.append(string);
                    sb.append(" IF EXISTS ");
                    sb.append(string2);
                    java.lang.String sb2 = sb.toString();
                    try {
                        sQLiteDatabase.execSQL(sb2);
                    } catch (android.database.SQLException e) {
                        java.lang.String valueOf = java.lang.String.valueOf(sb2);
                        com.google.android.exoplayer2.util.Log.e("ExoDatabaseProvider", valueOf.length() != 0 ? "Error executing ".concat(valueOf) : new java.lang.String("Error executing "), e);
                    }
                }
            } catch (java.lang.Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        query.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
