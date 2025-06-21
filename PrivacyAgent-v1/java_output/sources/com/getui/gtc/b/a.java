package com.getui.gtc.b;

/* loaded from: classes22.dex */
public final class a {
    private static com.getui.gtc.b.a.C0294a a;

    /* renamed from: com.getui.gtc.b.a$a, reason: collision with other inner class name */
    public static class C0294a extends android.database.sqlite.SQLiteOpenHelper {
        public C0294a(android.content.Context context) {
            super(context, "gtc.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor;
        byte[] blob;
        android.database.Cursor cursor2 = null;
        if (!context.getDatabasePath("gtc.db").exists()) {
            return null;
        }
        if (a == null) {
            a = new com.getui.gtc.b.a.C0294a(context);
        }
        try {
            sQLiteDatabase = a.getReadableDatabase();
        } catch (java.lang.Exception e) {
            e = e;
            sQLiteDatabase = null;
            cursor = null;
        } catch (java.lang.Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            cursor = sQLiteDatabase.query("i", new java.lang.String[]{"b"}, "a=?", new java.lang.String[]{"100"}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToNext() && (blob = cursor.getBlob(0)) != null) {
                            java.lang.String str = new java.lang.String(com.getui.gtc.h.a.b.a(blob, com.getui.gtc.h.a.a.a(context.getPackageName())));
                            cursor.close();
                            sQLiteDatabase.close();
                            return str;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.getui.gtc.h.c.a.b(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            throw th;
        }
        sQLiteDatabase.close();
        return null;
    }
}
