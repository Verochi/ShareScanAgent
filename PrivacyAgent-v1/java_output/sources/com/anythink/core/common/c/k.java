package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class k extends com.anythink.core.common.c.a<com.anythink.core.common.a.i> {
    private static volatile com.anythink.core.common.c.k c;
    private final java.lang.String b;

    public static class a {
        public static final java.lang.String a = "offer_data_cache";
        public static final java.lang.String b = "placement_id";
        public static final java.lang.String c = "bid_id";
        public static final java.lang.String d = "adsource_id";
        public static final java.lang.String e = "network_firm_id";
        public static final java.lang.String f = "bid_result";
        public static final java.lang.String g = "offer_data";
        public static final java.lang.String h = "out_date_timestamp";
        public static final java.lang.String i = "CREATE TABLE IF NOT EXISTS offer_data_cache(placement_id TEXT ,bid_id TEXT ,adsource_id TEXT ,network_firm_id INTEGER ,bid_result TEXT ,offer_data TEXT ,out_date_timestamp INTEGER)";
    }

    private k(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.k.class.getName();
    }

    public static com.anythink.core.common.c.k a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.k.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.k(bVar);
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r11 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        if (r11 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean d(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.k.a.a, new java.lang.String[]{com.anythink.core.common.c.k.a.g}, "bid_id=?", new java.lang.String[]{str}, null, null, null);
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

    public final synchronized int a(com.anythink.core.common.f.q qVar) {
        if (d(qVar.token)) {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.anythink.core.common.c.k.a.f, qVar.b());
                return b().update(com.anythink.core.common.c.k.a.a, contentValues, "bid_id = ? ", new java.lang.String[]{qVar.token});
            } catch (java.lang.Throwable unused) {
            }
        }
        return -1;
    }

    public final synchronized long a(java.lang.String str, com.anythink.core.common.f.q qVar) {
        if (b() == null || qVar == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("placement_id", str);
            contentValues.put("adsource_id", qVar.k);
            contentValues.put("network_firm_id", java.lang.Integer.valueOf(qVar.d));
            contentValues.put(com.anythink.core.common.c.k.a.c, qVar.token);
            contentValues.put(com.anythink.core.common.c.k.a.f, qVar.b());
            contentValues.put(com.anythink.core.common.c.k.a.h, java.lang.Long.valueOf(qVar.f));
            if (!android.text.TextUtils.isEmpty(qVar.i)) {
                contentValues.put(com.anythink.core.common.c.k.a.g, qVar.i);
            }
            if (d(qVar.token)) {
                return b().update(com.anythink.core.common.c.k.a.a, contentValues, "bid_id = ? ", new java.lang.String[]{qVar.token});
            }
            return b().insert(com.anythink.core.common.c.k.a.a, null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public final synchronized long a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (b() == null) {
            return -1L;
        }
        try {
            new android.content.ContentValues().put(com.anythink.core.common.c.k.a.g, str3);
            if (!d(str2)) {
                return -1L;
            }
            return b().update(com.anythink.core.common.c.k.a.a, r7, "bid_id = ? ", new java.lang.String[]{str2});
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public final synchronized void a(java.lang.String str) {
        try {
            b().delete(com.anythink.core.common.c.k.a.a, "bid_id = ? ", new java.lang.String[]{str});
        } catch (java.lang.Throwable th) {
            com.anythink.core.common.n.c.a("Error_SQL_DELETE", th.getMessage(), com.anythink.core.common.b.o.a().q());
        }
    }

    public final synchronized com.anythink.core.common.f.r b(java.lang.String str) {
        com.anythink.core.common.f.r rVar;
        android.database.Cursor cursor;
        rVar = new com.anythink.core.common.f.r();
        try {
            cursor = a().query(com.anythink.core.common.c.k.a.a, new java.lang.String[]{"placement_id", "adsource_id", com.anythink.core.common.c.k.a.f}, "out_date_timestamp>? AND placement_id=?", new java.lang.String[]{java.lang.String.valueOf(java.lang.System.currentTimeMillis()), str}, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("adsource_id"));
                    com.anythink.core.common.f.q a2 = com.anythink.core.common.f.q.a(cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.k.a.f)));
                    if (a2 != null) {
                        rVar.a(string, a2);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
            cursor = null;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Throwable unused3) {
            }
        }
        return rVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        if (r12 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
    
        if (r12 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized com.anythink.core.common.f.ag c(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.k.a.a, new java.lang.String[]{com.anythink.core.common.c.k.a.g, com.anythink.core.common.c.k.a.h}, "bid_id=?", new java.lang.String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        com.anythink.core.common.f.ag agVar = new com.anythink.core.common.f.ag(cursor.getString(0), cursor.getLong(1));
                        cursor.close();
                        cursor.close();
                        return agVar;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
            cursor = null;
        }
    }
}
