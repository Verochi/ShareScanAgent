package com.anythink.core.c.b;

/* loaded from: classes12.dex */
public class d extends com.anythink.core.common.c.a<com.anythink.core.c.a.a> {
    private static final java.lang.String b = "PlacementStatisticsDao";
    private static final int c = 50;
    private static volatile com.anythink.core.c.b.d d;

    public static class a {
        public static final java.lang.String a = "user_value_placement";
        public static final java.lang.String b = "type";
        public static final java.lang.String c = "placement_id";
        public static final java.lang.String d = "request_id";
        public static final java.lang.String e = "network_firm_id";
        public static final java.lang.String f = "ad_source_id";
        public static final java.lang.String g = "dsp_id";
        public static final java.lang.String h = "price";
        public static final java.lang.String i = "record_time";
        public static final java.lang.String j = "ps_id";
        public static final java.lang.String k = "CREATE TABLE IF NOT EXISTS user_value_placement(type INTEGER, placement_id TEXT, request_id TEXT, network_firm_id INTEGER, ad_source_id TEXT, dsp_id TEXT, price DOUBLE, record_time INTEGER, ps_id TEXT )";
    }

    private d(com.anythink.core.common.c.b bVar) {
        super(bVar);
    }

    private synchronized int a(int i, java.lang.String str) {
        int count;
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = b().query(com.anythink.core.c.b.d.a.a, new java.lang.String[]{com.anythink.core.c.b.d.a.i}, "type = ? AND placement_id = ?", new java.lang.String[]{java.lang.String.valueOf(i), str}, null, null, null);
                count = cursor.getCount();
                cursor.close();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return 0;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return count;
    }

    public static com.anythink.core.c.b.d c() {
        if (d == null) {
            synchronized (com.anythink.core.c.b.d.class) {
                if (d == null) {
                    d = new com.anythink.core.c.b.d(com.anythink.core.common.c.c.a(com.anythink.core.common.b.o.a().f()));
                }
            }
        }
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d8 A[Catch: all -> 0x00dc, TRY_ENTER, TryCatch #2 {, blocks: (B:11:0x00b8, B:19:0x00cf, B:26:0x00d8, B:27:0x00db), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.c.a.a> a(int i, java.lang.String str, int i2) {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            cursor = a().query(com.anythink.core.c.b.d.a.a, null, "type = ? AND placement_id = ?", new java.lang.String[]{java.lang.String.valueOf(i), str}, null, null, "record_time DESC", java.lang.String.valueOf(i2));
            while (cursor.moveToNext()) {
                try {
                    try {
                        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
                        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("type"));
                        java.lang.String string = cursor.getString(cursor.getColumnIndexOrThrow("placement_id"));
                        java.lang.String string2 = cursor.getString(cursor.getColumnIndexOrThrow("request_id"));
                        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("network_firm_id"));
                        java.lang.String string3 = cursor.getString(cursor.getColumnIndexOrThrow("ad_source_id"));
                        java.lang.String string4 = cursor.getString(cursor.getColumnIndexOrThrow("dsp_id"));
                        double d2 = cursor.getDouble(cursor.getColumnIndexOrThrow(com.anythink.core.c.b.d.a.h));
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow(com.anythink.core.c.b.d.a.i));
                        java.lang.String string5 = cursor.getString(cursor.getColumnIndexOrThrow("ps_id"));
                        aVar.b(i3);
                        aVar.e(string);
                        aVar.a(string2);
                        aVar.a(i4);
                        aVar.b(string3);
                        aVar.c(string4);
                        aVar.a(d2);
                        aVar.a(j);
                        aVar.d(string5);
                        arrayList.add(aVar);
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.getMessage();
                        java.lang.Thread.currentThread().getName();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            arrayList.size();
            java.lang.Thread.currentThread().getId();
            cursor.close();
            return arrayList;
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final synchronized void a(com.anythink.core.c.a.a aVar) {
        android.database.sqlite.SQLiteDatabase b2;
        android.database.Cursor query;
        int j = aVar.j();
        android.database.Cursor cursor = null;
        try {
            try {
                b2 = b();
                query = b2.query(com.anythink.core.c.b.d.a.a, new java.lang.String[]{com.anythink.core.c.b.d.a.i}, "type = ? AND placement_id = ?", new java.lang.String[]{java.lang.String.valueOf(j), aVar.i()}, null, null, "record_time ASC");
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            if (query.getCount() > 50) {
                long j2 = query.moveToNext() ? query.getLong(query.getColumnIndexOrThrow(com.anythink.core.c.b.d.a.i)) : 0L;
                if (j2 != 0) {
                    b2.delete(com.anythink.core.c.b.d.a.a, "record_time = ?", new java.lang.String[]{java.lang.String.valueOf(j2)});
                }
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("type", java.lang.Integer.valueOf(j));
            contentValues.put("placement_id", aVar.i());
            contentValues.put("request_id", aVar.a());
            contentValues.put("ad_source_id", aVar.c());
            contentValues.put("network_firm_id", java.lang.Integer.valueOf(aVar.b()));
            contentValues.put("dsp_id", aVar.d());
            contentValues.put(com.anythink.core.c.b.d.a.h, java.lang.Double.valueOf(aVar.e()));
            contentValues.put(com.anythink.core.c.b.d.a.i, java.lang.Long.valueOf(aVar.f()));
            contentValues.put("ps_id", aVar.g());
            b2.insertOrThrow(com.anythink.core.c.b.d.a.a, null, contentValues);
            java.lang.Thread.currentThread().getName();
            query.close();
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = query;
            e.getMessage();
            java.lang.Thread.currentThread().getName();
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final synchronized void a(java.lang.String str) {
        try {
            b().delete(com.anythink.core.c.b.d.a.a, "placement_id = ?", new java.lang.String[]{str});
        } catch (java.lang.Exception e) {
            e.getMessage();
            java.lang.Thread.currentThread().getName();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized double[] a(java.lang.String[] strArr, java.lang.String str) {
        double[] dArr;
        dArr = new double[2];
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(str, strArr, null, null, null, null, null, null);
                if (cursor.moveToNext()) {
                    dArr[0] = cursor.getDouble(0);
                    dArr[1] = cursor.getInt(1);
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
                java.lang.Thread.currentThread().getName();
            }
            cursor.close();
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return dArr;
    }
}
