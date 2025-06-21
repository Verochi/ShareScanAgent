package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class e extends com.anythink.core.common.c.a<com.anythink.core.common.a.f> {
    private static volatile com.anythink.core.common.c.e c;
    private final java.lang.String b;

    public static class a {
        public static final java.lang.String a = "dsp_offer_install_record";
        public static final java.lang.String b = "dsp_id";
        public static final java.lang.String c = "dsp_offer_id";
        public static final java.lang.String d = "package_name";
        public static final java.lang.String e = "last_update_time";
        public static final java.lang.String f = "CREATE TABLE IF NOT EXISTS dsp_offer_install_record(dsp_id TEXT ,dsp_offer_id TEXT ,package_name TEXT ,last_update_time INTEGER)";
    }

    private e(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.e.class.getName();
    }

    public static com.anythink.core.common.c.e a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.e.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.e(bVar);
                }
            }
        }
        return c;
    }

    private synchronized java.util.List<com.anythink.core.common.a.f> a(android.database.Cursor cursor) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    try {
                        com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
                        fVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                        fVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                        fVar.c(cursor.getString(cursor.getColumnIndex("package_name")));
                        arrayList.add(fVar);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r1 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean a(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.e.a.a, null, "dsp_id = ?  AND dsp_offer_id = ? ", new java.lang.String[]{str, str2}, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.close();
                    cursor.close();
                    return true;
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

    public final synchronized long a(com.anythink.core.common.a.f fVar) {
        if (b() == null) {
            return -1L;
        }
        if (a(fVar.a(), fVar.b())) {
            fVar.a();
            fVar.b();
            fVar.c();
        } else {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("dsp_id", fVar.a());
                contentValues.put("dsp_offer_id", fVar.b());
                contentValues.put("package_name", fVar.c());
                contentValues.put("last_update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                fVar.a();
                fVar.b();
                fVar.c();
                return b().insert(com.anythink.core.common.c.e.a.a, null, contentValues);
            } catch (java.lang.Exception unused) {
            }
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        if (r1 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.a.e> a(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.e.a.a, null, null, null, null, null, "last_update_time DESC", java.lang.String.valueOf(i));
                java.util.List<com.anythink.core.common.a.f> a2 = a(cursor);
                cursor.close();
                a2.size();
                arrayList.addAll(a2);
            } catch (java.lang.Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (java.lang.Exception unused) {
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
        } catch (java.lang.Throwable unused3) {
        }
        cursor.close();
        return arrayList;
    }
}
