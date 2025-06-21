package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class j {
    public static java.lang.String a(java.util.List<java.lang.String> list) {
        return android.text.TextUtils.join("!", list);
    }

    public static java.util.List<java.lang.String> a(java.lang.String str) {
        return new java.util.ArrayList(java.util.Arrays.asList(str.split("!")));
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            java.io.File databasePath = context.getDatabasePath(com.umeng.analytics.pro.g.b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            com.umeng.analytics.pro.h.a(context).a();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r9.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r9.isClosed() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.lang.String str2) {
        boolean z = false;
        android.database.Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(str, null, null, null, null, null, "LIMIT 0");
            if (cursor != null) {
                if (cursor.getColumnIndex(str2) != -1) {
                    z = true;
                }
            }
            if (cursor != null) {
            }
        } catch (java.lang.Exception unused) {
            if (cursor != null) {
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if (r1 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(java.lang.String str, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        android.database.Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("sqlite_master", new java.lang.String[]{"count(*)"}, "type=? and name=?", new java.lang.String[]{"table", str.trim()}, null, null, null, null);
            if (cursor.moveToNext()) {
                if (cursor.getInt(0) > 0) {
                    z = true;
                }
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
        return z;
    }

    public static java.lang.String b(android.content.Context context) {
        return context.getDatabasePath(com.umeng.analytics.pro.g.b).getParent() + java.io.File.separator;
    }

    public static java.util.List<java.lang.String> b(java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            for (java.lang.String str : list) {
                if (java.util.Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static java.lang.String c(android.content.Context context) {
        return b(context) + com.umeng.analytics.pro.g.a;
    }
}
