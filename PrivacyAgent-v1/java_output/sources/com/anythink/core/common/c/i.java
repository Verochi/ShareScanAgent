package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class i extends com.anythink.core.common.c.a<com.anythink.core.common.c.i> {
    private static final java.lang.String b = "com.anythink.core.common.c.i";
    private static com.anythink.core.common.c.i c;

    public static class a {
        public java.util.List<com.anythink.core.common.f.ad> a;
        public java.util.Map<java.lang.String, com.anythink.core.common.f.ad> b;
    }

    public static class b {
        public static final java.lang.String a = "notice_url_fail_info";
        public static final java.lang.String b = "id";
        public static final java.lang.String c = "req_type";
        public static final java.lang.String d = "req_url";
        public static final java.lang.String e = "req_head";
        public static final java.lang.String f = "first_fail_time";
        public static final java.lang.String g = "offer_out_date_time";
        public static final java.lang.String h = "retry_count";
        public static final java.lang.String i = "CREATE TABLE IF NOT EXISTS notice_url_fail_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, first_fail_time INTEGER, offer_out_date_time INTEGER, retry_count INTEGER )";
    }

    private i(com.anythink.core.common.c.b bVar) {
        super(bVar);
    }

    public static com.anythink.core.common.c.i a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.i.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.i(bVar);
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r11 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002d, code lost:
    
        if (r11 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0036, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.i.b.a, new java.lang.String[]{"id"}, "id=?", new java.lang.String[]{str}, "id", null, null);
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

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(com.anythink.core.common.c.i.b.a, null, null);
        } catch (java.lang.Exception unused) {
        }
    }

    public final synchronized long a(com.anythink.core.common.f.ad adVar) {
        if (b() == null || adVar == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("id", adVar.a);
            contentValues.put("req_type", java.lang.Integer.valueOf(adVar.b));
            contentValues.put("req_url", adVar.d);
            contentValues.put("req_head", adVar.c);
            contentValues.put(com.anythink.core.common.c.i.b.f, java.lang.Long.valueOf(adVar.e));
            contentValues.put(com.anythink.core.common.c.i.b.g, java.lang.Long.valueOf(adVar.f));
            contentValues.put("retry_count", java.lang.Integer.valueOf(adVar.g));
            if (a(adVar.a)) {
                return b().update(com.anythink.core.common.c.i.b.a, contentValues, "id = ? ", new java.lang.String[]{adVar.a});
            }
            return b().insert(com.anythink.core.common.c.i.b.a, null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public final synchronized int b(com.anythink.core.common.f.ad adVar) {
        if (b() == null || adVar == null) {
            return -1;
        }
        try {
            return b().delete(com.anythink.core.common.c.i.b.a, "id=?", new java.lang.String[]{adVar.a});
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f3, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ef, code lost:
    
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
    
        if (r2 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00df, code lost:
    
        if (r2 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized com.anythink.core.common.c.i.a c() {
        com.anythink.core.common.c.i.a aVar = new com.anythink.core.common.c.i.a();
        java.util.List<com.anythink.core.common.f.ad> synchronizedList = java.util.Collections.synchronizedList(new java.util.ArrayList(8));
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(8);
        aVar.a = synchronizedList;
        aVar.b = concurrentHashMap;
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.i.b.a, null, null, null, null, null, com.anythink.core.common.c.i.b.f);
                if (cursor != null && cursor.getCount() > 0) {
                    java.util.ArrayList<com.anythink.core.common.f.ad> arrayList = new java.util.ArrayList(4);
                    while (cursor.moveToNext()) {
                        com.anythink.core.common.f.ad adVar = new com.anythink.core.common.f.ad();
                        adVar.a = cursor.getString(cursor.getColumnIndex("id"));
                        adVar.b = cursor.getInt(cursor.getColumnIndex("req_type"));
                        adVar.d = cursor.getString(cursor.getColumnIndex("req_url"));
                        adVar.c = cursor.getString(cursor.getColumnIndex("req_head"));
                        adVar.e = cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.i.b.f));
                        adVar.f = cursor.getLong(cursor.getColumnIndex(com.anythink.core.common.c.i.b.g));
                        adVar.g = cursor.getInt(cursor.getColumnIndex("retry_count"));
                        if (java.lang.System.currentTimeMillis() < adVar.f) {
                            synchronizedList.add(adVar);
                            concurrentHashMap.put(adVar.a, adVar);
                        } else {
                            arrayList.add(adVar);
                        }
                    }
                    cursor.close();
                    if (arrayList.size() > 0) {
                        for (com.anythink.core.common.f.ad adVar2 : arrayList) {
                            adVar2.a();
                            b(adVar2);
                        }
                    }
                    cursor.close();
                    return aVar;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
        } catch (java.lang.Throwable unused3) {
        }
    }
}
