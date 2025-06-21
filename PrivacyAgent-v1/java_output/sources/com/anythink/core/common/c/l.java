package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class l extends com.anythink.core.common.c.a<com.anythink.core.common.f.an> {
    private static volatile com.anythink.core.common.c.l c;
    private final java.lang.String b;

    public static class a {
        public static final java.lang.String a = "placement_ad_impression";
        public static final java.lang.String b = "format";
        public static final java.lang.String c = "placement_id";
        public static final java.lang.String d = "adsource_id";
        public static final java.lang.String e = "hour_time";
        public static final java.lang.String f = "hour_imp";
        public static final java.lang.String g = "date_time";
        public static final java.lang.String h = "date_imp";
        public static final java.lang.String i = "show_time";
        public static final java.lang.String j = "CREATE TABLE IF NOT EXISTS placement_ad_impression(format INTEGER ,placement_id TEXT ,adsource_id TEXT ,hour_time TEXT ,hour_imp INTEGER ,date_time TEXT ,date_imp INTEGER , show_time INTEGER)";
    }

    private l(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.l.class.getName();
    }

    public static com.anythink.core.common.c.l a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.l.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.l(bVar);
                }
            }
        }
        return c;
    }

    private static com.anythink.core.common.f.an a(android.database.Cursor cursor, java.lang.String str, java.lang.String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        com.anythink.core.common.f.an anVar = new com.anythink.core.common.f.an();
        anVar.h = new java.util.concurrent.ConcurrentHashMap<>();
        while (cursor.moveToNext()) {
            anVar.a = cursor.getInt(cursor.getColumnIndex("format"));
            anVar.b = cursor.getString(cursor.getColumnIndex("placement_id"));
            com.anythink.core.common.f.an.a aVar = new com.anythink.core.common.f.an.a();
            aVar.a = cursor.getString(cursor.getColumnIndex("adsource_id"));
            aVar.b = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.l.a.e));
            aVar.c = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.l.a.g));
            if (android.text.TextUtils.equals(aVar.b, str2)) {
                aVar.e = cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.l.a.f));
            } else {
                aVar.e = 0;
            }
            anVar.d += aVar.e;
            if (android.text.TextUtils.equals(aVar.c, str)) {
                aVar.d = cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.l.a.h));
            } else {
                aVar.d = 0;
            }
            anVar.c += aVar.d;
            long j = cursor.getLong(cursor.getColumnIndex("show_time"));
            aVar.f = j;
            if (j >= anVar.e) {
                anVar.e = j;
            }
            anVar.h.put(aVar.a, aVar);
        }
        return anVar;
    }

    private boolean b(java.lang.String str) {
        android.database.Cursor query = a().query(com.anythink.core.common.c.l.a.a, new java.lang.String[]{"adsource_id"}, "adsource_id=?", new java.lang.String[]{str}, "adsource_id", null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    public final synchronized long a(int i, java.lang.String str, com.anythink.core.common.f.an.a aVar) {
        boolean z;
        if (b() == null || aVar == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("format", java.lang.Integer.valueOf(i));
            contentValues.put("placement_id", str);
            contentValues.put("adsource_id", aVar.a);
            contentValues.put(com.anythink.core.common.c.l.a.e, aVar.b);
            contentValues.put(com.anythink.core.common.c.l.a.f, java.lang.Integer.valueOf(aVar.e));
            contentValues.put(com.anythink.core.common.c.l.a.g, aVar.c);
            contentValues.put(com.anythink.core.common.c.l.a.h, java.lang.Integer.valueOf(aVar.d));
            contentValues.put("show_time", java.lang.Long.valueOf(aVar.f));
            android.database.Cursor query = a().query(com.anythink.core.common.c.l.a.a, new java.lang.String[]{"adsource_id"}, "adsource_id=?", new java.lang.String[]{aVar.a}, "adsource_id", null, null);
            if (query == null || query.getCount() <= 0) {
                if (query != null) {
                    query.close();
                }
                z = false;
            } else {
                query.close();
                z = true;
            }
            if (z) {
                return b().update(com.anythink.core.common.c.l.a.a, contentValues, "adsource_id = ? ", new java.lang.String[]{aVar.a});
            }
            return b().insert(com.anythink.core.common.c.l.a.a, null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00f4, code lost:
    
        if (r11 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00fb, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00e7, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e5, code lost:
    
        if (r11 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00de, code lost:
    
        if (r11 == null) goto L47;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized com.anythink.core.common.f.an a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.database.Cursor cursor;
        com.anythink.core.common.f.an anVar;
        try {
            cursor = a().query(com.anythink.core.common.c.l.a.a, null, "placement_id=? AND date_time=?", new java.lang.String[]{str, str2}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        anVar = new com.anythink.core.common.f.an();
                        anVar.h = new java.util.concurrent.ConcurrentHashMap<>();
                        while (cursor.moveToNext()) {
                            anVar.a = cursor.getInt(cursor.getColumnIndex("format"));
                            anVar.b = cursor.getString(cursor.getColumnIndex("placement_id"));
                            com.anythink.core.common.f.an.a aVar = new com.anythink.core.common.f.an.a();
                            aVar.a = cursor.getString(cursor.getColumnIndex("adsource_id"));
                            aVar.b = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.l.a.e));
                            aVar.c = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.l.a.g));
                            if (android.text.TextUtils.equals(aVar.b, str3)) {
                                aVar.e = cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.l.a.f));
                            } else {
                                aVar.e = 0;
                            }
                            anVar.d += aVar.e;
                            if (android.text.TextUtils.equals(aVar.c, str2)) {
                                aVar.d = cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.l.a.h));
                            } else {
                                aVar.d = 0;
                            }
                            anVar.c += aVar.d;
                            long j = cursor.getLong(cursor.getColumnIndex("show_time"));
                            aVar.f = j;
                            if (j >= anVar.e) {
                                anVar.e = j;
                            }
                            anVar.h.put(aVar.a, aVar);
                        }
                        cursor.close();
                        cursor.close();
                        return anVar;
                    }
                } catch (java.lang.Exception unused) {
                } catch (java.lang.OutOfMemoryError unused2) {
                    try {
                        java.lang.System.gc();
                    } catch (java.lang.Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
            anVar = null;
            cursor.close();
            cursor.close();
            return anVar;
        } catch (java.lang.Exception unused4) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused5) {
            cursor = null;
        } catch (java.lang.Throwable unused6) {
            cursor = null;
        }
    }

    public final void a(java.lang.String str) {
        java.lang.String str2;
        synchronized (this) {
            try {
                str2 = "date_time!='" + str + "'";
            } catch (java.lang.Exception unused) {
            }
            if (b() == null) {
                return;
            }
            b().delete(com.anythink.core.common.c.l.a.a, str2, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r4 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        r4 = a().query(com.anythink.core.common.c.l.a.a, new java.lang.String[]{"sum(hour_imp)"}, "format=? AND hour_time=?", new java.lang.String[]{java.lang.String.valueOf(r14), r16}, null, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
    
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
    
        if (r4.getCount() <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        r4.moveToNext();
        r1[1] = r4.getInt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
    
        if (r4 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
    
        if (r4.getCount() <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009e, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
    
        java.lang.System.gc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ad, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a7, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x005e, code lost:
    
        if (r4 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0053, code lost:
    
        if (r4 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x004d, code lost:
    
        if (r4 == null) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized int[] a(int i, java.lang.String str, java.lang.String str2) {
        int[] iArr;
        iArr = new int[2];
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.l.a.a, new java.lang.String[]{"sum(date_imp)"}, "format=? AND date_time=?", new java.lang.String[]{java.lang.String.valueOf(i), str}, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToNext();
                    iArr[0] = cursor.getInt(0);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.close();
                }
            } finally {
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
        } catch (java.lang.Throwable unused3) {
        }
        return iArr;
    }
}
