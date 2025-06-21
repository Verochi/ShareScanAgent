package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class g extends com.anythink.core.common.c.a<com.anythink.core.common.f.u> {
    private static final java.lang.String b = "com.anythink.core.common.c.g";
    private static com.anythink.core.common.c.g c;
    private int d;

    public static class a {
        public static final java.lang.String a = "request_info";
        public static final java.lang.String b = "id";
        public static final java.lang.String c = "req_type";
        public static final java.lang.String d = "req_url";
        public static final java.lang.String e = "req_head";
        public static final java.lang.String f = "req_content";
        public static final java.lang.String g = "time";
        public static final java.lang.String h = "extra";
        public static final java.lang.String i = "CREATE TABLE IF NOT EXISTS request_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, req_content TEXT, time INTEGER, extra TEXT )";
    }

    private g(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.d = 1000;
    }

    public static com.anythink.core.common.c.g a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.g.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.g(bVar);
                }
            }
        }
        return c;
    }

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(com.anythink.core.common.c.g.a.a, null, null);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0036, code lost:
    
        if (r3 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized long a(com.anythink.core.common.f.u uVar) {
        android.database.Cursor cursor;
        if (b() == null) {
            return -1L;
        }
        android.database.Cursor cursor2 = null;
        try {
            cursor = a().query(com.anythink.core.common.c.g.a.a, null, null, null, null, null, null);
            try {
                if (cursor.getCount() >= this.d) {
                    d();
                }
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused3) {
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        try {
            cursor.close();
        } catch (java.lang.Exception unused4) {
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("id", uVar.a);
            contentValues.put("req_type", java.lang.Integer.valueOf(uVar.b));
            contentValues.put("req_url", uVar.d);
            contentValues.put("req_head", uVar.c);
            contentValues.put(com.anythink.core.common.c.g.a.f, uVar.e);
            contentValues.put("time", java.lang.Long.valueOf(uVar.f));
            contentValues.put("extra", uVar.g);
            return b().insert(com.anythink.core.common.c.g.a.a, null, contentValues);
        } catch (java.lang.Exception unused5) {
            return -1L;
        }
    }

    public final synchronized int b(com.anythink.core.common.f.u uVar) {
        if (b() == null || uVar == null) {
            return -1;
        }
        try {
            return b().delete(com.anythink.core.common.c.g.a.a, "id=?", new java.lang.String[]{uVar.a});
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        if (r1 == null) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.f.u> c() {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.g.a.a, null, null, null, null, null, "time", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        while (cursor.moveToNext()) {
                            com.anythink.core.common.f.u uVar = new com.anythink.core.common.f.u();
                            uVar.a = cursor.getString(cursor.getColumnIndex("id"));
                            uVar.b = cursor.getInt(cursor.getColumnIndex("req_type"));
                            uVar.d = cursor.getString(cursor.getColumnIndex("req_url"));
                            uVar.c = cursor.getString(cursor.getColumnIndex("req_head"));
                            uVar.e = cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.g.a.f));
                            uVar.f = cursor.getLong(cursor.getColumnIndex("time"));
                            uVar.g = cursor.getString(cursor.getColumnIndex("extra"));
                            arrayList.add(uVar);
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
            return null;
        } catch (java.lang.Exception unused4) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused5) {
            cursor = null;
        } catch (java.lang.Throwable unused6) {
            cursor = null;
        }
    }
}
