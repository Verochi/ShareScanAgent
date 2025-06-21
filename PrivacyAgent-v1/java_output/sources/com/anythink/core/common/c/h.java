package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class h extends com.anythink.core.common.c.a<com.anythink.core.common.f.w> {
    private static final java.lang.String b = "com.anythink.core.common.c.h";
    private static volatile com.anythink.core.common.c.h c;
    private int d;

    public static class a {
        public static final java.lang.String a = "inspect_info";
        public static final java.lang.String b = "inspect_id";
        public static final java.lang.String c = "update_time";
        public static final java.lang.String d = "CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, update_time INTEGER )";
    }

    private h(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.d = 500;
    }

    public static com.anythink.core.common.c.h a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.h.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.h(bVar);
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        if (r11 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r11 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean b(java.lang.String str) {
        android.database.Cursor cursor;
        if (str == null) {
            return false;
        }
        try {
            cursor = a().query(com.anythink.core.common.c.h.a.a, new java.lang.String[]{com.anythink.core.common.c.h.a.b}, "inspect_id=?", new java.lang.String[]{str}, null, null, null);
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

    public final synchronized long a(java.lang.String str) {
        if (b() == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.anythink.core.common.c.h.a.b, str);
            contentValues.put("update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            if (b(str)) {
                return b().update(com.anythink.core.common.c.h.a.a, contentValues, "inspect_id = ? ", new java.lang.String[]{str});
            }
            return b().insert(com.anythink.core.common.c.h.a.a, null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005a, code lost:
    
        if (r1 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        b().delete(com.anythink.core.common.c.h.a.a, "update_time<?", new java.lang.String[]{java.lang.String.valueOf(r1)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r0 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c() {
        android.database.Cursor cursor = null;
        long j = -1;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.h.a.a, null, null, null, null, null, "update_time DESC", java.lang.String.valueOf(this.d));
                if (cursor != null && cursor.getCount() >= this.d) {
                    cursor.moveToLast();
                    j = cursor.getLong(cursor.getColumnIndex("update_time"));
                    cursor.close();
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

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0055, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0077, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.f.w> d() {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.h.a.a, null, null, null, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        while (cursor.moveToNext()) {
                            com.anythink.core.common.f.w wVar = new com.anythink.core.common.f.w();
                            java.lang.String string = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.h.a.b));
                            long j = cursor.getLong(cursor.getColumnIndex("update_time"));
                            wVar.a(string);
                            wVar.a(j);
                            arrayList.add(wVar);
                        }
                        cursor.close();
                        cursor.close();
                        return arrayList;
                    }
                } catch (java.lang.Exception unused) {
                } catch (java.lang.OutOfMemoryError unused2) {
                    try {
                        java.lang.System.gc();
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
        } catch (java.lang.Exception unused4) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused5) {
            cursor = null;
        } catch (java.lang.Throwable unused6) {
            cursor = null;
        }
    }
}
