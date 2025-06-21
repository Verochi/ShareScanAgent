package com.getui.gtc.extension.distribution.gbd.a.b.a;

/* loaded from: classes22.dex */
public final class b extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String a = "G_D_M";
    private static final java.lang.String b = "c";
    private static final int c = 1;

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.a.b.a.b a;

        static {
            a = new com.getui.gtc.extension.distribution.gbd.a.b.a.b(com.getui.gtc.extension.distribution.gbd.d.c.d, com.getui.gtc.extension.distribution.gbd.d.h.at.size() >= 2 ? com.getui.gtc.extension.distribution.gbd.d.h.at.get(1) : "table.db", (byte) 0);
        }

        private a() {
        }
    }

    private b(android.content.Context context, java.lang.String str) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    public /* synthetic */ b(android.content.Context context, java.lang.String str, byte b2) {
        this(context, str);
    }

    public static com.getui.gtc.extension.distribution.gbd.a.b.a.b a() {
        return com.getui.gtc.extension.distribution.gbd.a.b.a.b.a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0034, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003a, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        android.database.Cursor cursor;
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            cursor = getReadableDatabase().query("c", null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        int columnCount = cursor.getColumnCount();
                        for (int i = 1; i < columnCount; i++) {
                            hashMap.put(cursor.getColumnName(i), cursor.getString(i));
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        } catch (java.lang.Throwable unused2) {
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
