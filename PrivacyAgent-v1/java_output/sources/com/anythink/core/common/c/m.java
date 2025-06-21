package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class m extends com.anythink.core.common.c.a<com.anythink.core.common.a.j> {
    private static volatile com.anythink.core.common.c.m c;
    private final java.lang.String b;

    public static class a {
        public static final java.lang.String a = "video_res_cache_info";
        public static final java.lang.String b = "video_url";
        public static final java.lang.String c = "file_path";
        public static final java.lang.String d = "ready_rate";
        public static final java.lang.String e = "download_size";
        public static final java.lang.String f = "total_size";
        public static final java.lang.String g = "update_time";
        public static final java.lang.String h = "CREATE TABLE IF NOT EXISTS video_res_cache_info(video_url TEXT, file_path TEXT, ready_rate INTEGER, download_size INTEGER, total_size INTEGER, update_time INTEGER )";
    }

    private m(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.m.class.getSimpleName();
    }

    public static com.anythink.core.common.c.m a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.k.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.m(bVar);
                }
            }
        }
        return c;
    }

    private void d(java.lang.String str) {
        android.database.Cursor cursor = null;
        try {
            cursor = a().query(com.anythink.core.common.c.m.a.a, null, null, null, null, null, null);
            cursor.getCount();
            cursor.close();
        } catch (java.lang.Throwable th) {
            try {
                th.getMessage();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r11 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
    
        if (r11 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(java.lang.String str) {
        android.database.Cursor cursor;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            cursor = a().query(com.anythink.core.common.c.m.a.a, new java.lang.String[]{"video_url"}, "video_url=?", new java.lang.String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.close();
                        cursor.close();
                        return true;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
            cursor = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
    
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.core.common.a.j a(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.m.a.a, null, "video_url=?", new java.lang.String[]{str}, null, null, null);
            try {
                if (cursor.moveToNext()) {
                    com.anythink.core.common.a.j jVar = new com.anythink.core.common.a.j();
                    jVar.a(str);
                    jVar.b(cursor.getString(cursor.getColumnIndex("file_path")));
                    jVar.a(cursor.getInt(cursor.getColumnIndex("ready_rate")));
                    jVar.b(cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.m.a.e)));
                    jVar.a(cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.m.a.f)));
                    jVar.c(cursor.getLong(cursor.getColumnIndex("update_time")));
                    cursor.close();
                    cursor.close();
                    return jVar;
                }
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            cursor = null;
        }
        cursor.close();
        return null;
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, long j, long j2, int i) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("video_url", str);
                    contentValues.put("file_path", str2);
                    contentValues.put("ready_rate", java.lang.Integer.valueOf(i));
                    contentValues.put(com.anythink.core.common.c.m.a.e, java.lang.Long.valueOf(j2));
                    contentValues.put(com.anythink.core.common.c.m.a.f, java.lang.Long.valueOf(j));
                    contentValues.put("update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    if (e(str)) {
                        b().update(com.anythink.core.common.c.m.a.a, contentValues, "video_url = ? ", new java.lang.String[]{str});
                    } else {
                        b().insert(com.anythink.core.common.c.m.a.a, null, contentValues);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public final void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            b().update(com.anythink.core.common.c.m.a.a, contentValues, "video_url = ? ", new java.lang.String[]{str});
        } catch (java.lang.Throwable unused) {
        }
    }

    public final long c() {
        android.database.Cursor cursor = null;
        try {
            cursor = a().query(com.anythink.core.common.c.m.a.a, new java.lang.String[]{"sum(download_size)"}, null, null, null, null, null);
            if (cursor.moveToNext()) {
                long j = cursor.getLong(0);
                cursor.close();
                cursor.close();
                return j;
            }
        } catch (java.lang.Throwable th) {
            try {
                th.getMessage();
                if (cursor == null) {
                    return 0L;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return 0L;
    }

    public final void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b().delete(com.anythink.core.common.c.m.a.a, "video_url=?", new java.lang.String[]{str});
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b1, code lost:
    
        r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bc, code lost:
    
        if (r2 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.util.List<com.anythink.core.common.a.j> d() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            cursor = a().query(com.anythink.core.common.c.m.a.a, null, null, null, null, null, "update_time DESC");
            if (cursor.getCount() > 0 && cursor.moveToPosition(((int) java.lang.Math.round(((cursor.getCount() * 1.0d) + 1.0d) / 2.0d)) - 1)) {
                long j = cursor.getLong(cursor.getColumnIndex("update_time"));
                do {
                    com.anythink.core.common.a.j jVar = new com.anythink.core.common.a.j();
                    jVar.a(cursor.getString(cursor.getColumnIndex("video_url")));
                    jVar.b(cursor.getString(cursor.getColumnIndex("file_path")));
                    jVar.a(cursor.getInt(cursor.getColumnIndex("ready_rate")));
                    jVar.b(cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.m.a.e)));
                    jVar.a(cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.m.a.f)));
                    jVar.c(cursor.getLong(cursor.getColumnIndex("update_time")));
                    arrayList.add(jVar);
                } while (cursor.moveToNext());
                b().delete(com.anythink.core.common.c.m.a.a, "update_time<=?", new java.lang.String[]{java.lang.String.valueOf(j)});
            }
        } catch (java.lang.Throwable th) {
            try {
                th.getMessage();
            } catch (java.lang.Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }
        cursor.close();
        return arrayList;
    }
}
