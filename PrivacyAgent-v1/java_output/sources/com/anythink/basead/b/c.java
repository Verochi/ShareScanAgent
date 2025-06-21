package com.anythink.basead.b;

/* loaded from: classes12.dex */
public final class c {
    private static com.anythink.basead.b.c a;
    private android.content.Context b;

    public static class a {
        public static final java.lang.String a = "my_offer_cap_pacing";
        public static final java.lang.String b = "offer_id";
        public static final java.lang.String c = "offer_cap";
        public static final java.lang.String d = "offer_pacing";
        public static final java.lang.String e = "show_num";
        public static final java.lang.String f = "show_time";
        public static final java.lang.String g = "record_date";
        public static final java.lang.String h = "CREATE TABLE IF NOT EXISTS my_offer_cap_pacing (offer_id TEXT,offer_cap INTEGER,offer_pacing INTEGER,show_num INTEGER,show_time INTEGER,record_date INTEGER )";
    }

    private c(android.content.Context context) {
        this.b = context;
    }

    public static com.anythink.basead.b.c a(android.content.Context context) {
        if (a == null) {
            a = new com.anythink.basead.b.c(context);
        }
        return a;
    }

    private static com.anythink.basead.c.c a(android.database.Cursor cursor) {
        com.anythink.basead.c.c cVar = new com.anythink.basead.c.c();
        cVar.a = cursor.getString(cursor.getColumnIndex("offer_id"));
        cVar.d = cursor.getInt(cursor.getColumnIndex(com.anythink.basead.b.c.a.e));
        cVar.e = cursor.getLong(cursor.getColumnIndex("show_time"));
        cVar.f = cursor.getString(cursor.getColumnIndex(com.anythink.basead.b.c.a.g));
        cVar.b = cursor.getInt(cursor.getColumnIndex(com.anythink.basead.b.c.a.c));
        cVar.c = cursor.getLong(cursor.getColumnIndex(com.anythink.basead.b.c.a.d));
        return cVar;
    }

    private synchronized boolean d(java.lang.String str) {
        android.database.Cursor query = com.anythink.basead.b.b.a(this.b).getReadableDatabase().query(com.anythink.basead.b.c.a.a, new java.lang.String[]{"offer_id"}, "offer_id=?", new java.lang.String[]{str}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    public final synchronized long a(com.anythink.basead.c.c cVar) {
        synchronized (this) {
            if (cVar == null) {
                return 0L;
            }
            try {
                if (com.anythink.basead.b.b.a(this.b).getWritableDatabase() == null) {
                    return -1L;
                }
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("offer_id", cVar.a);
                contentValues.put(com.anythink.basead.b.c.a.e, java.lang.Integer.valueOf(cVar.d));
                contentValues.put("show_time", java.lang.Long.valueOf(cVar.e));
                contentValues.put(com.anythink.basead.b.c.a.g, cVar.f);
                contentValues.put(com.anythink.basead.b.c.a.c, java.lang.Integer.valueOf(cVar.b));
                contentValues.put(com.anythink.basead.b.c.a.d, java.lang.Long.valueOf(cVar.c));
                if (!d(cVar.a)) {
                    return com.anythink.basead.b.b.a(this.b).getWritableDatabase().insert(com.anythink.basead.b.c.a.a, null, contentValues);
                }
                return com.anythink.basead.b.b.a(this.b).getWritableDatabase().update(com.anythink.basead.b.c.a.a, contentValues, "offer_id = '" + cVar.a + "'", null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return -1L;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r11 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r11 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0039, code lost:
    
        if (r11 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x005b, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized com.anythink.basead.c.c a(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = com.anythink.basead.b.b.a(this.b).getReadableDatabase().query(com.anythink.basead.b.c.a.a, null, "offer_id=?", new java.lang.String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        com.anythink.basead.c.c a2 = a(cursor);
                        cursor.close();
                        cursor.close();
                        return a2;
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

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if (r11 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        if (r11 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004a, code lost:
    
        if (r11 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x006c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.basead.c.c> b(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = com.anythink.basead.b.b.a(this.b).getReadableDatabase().query(com.anythink.basead.b.c.a.a, null, "offer_cap <= show_num AND record_date=? AND offer_cap !=?", new java.lang.String[]{str, "-1"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        while (cursor.moveToNext()) {
                            arrayList.add(a(cursor));
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

    public final synchronized void c(java.lang.String str) {
        java.lang.String str2;
        synchronized (this) {
            try {
                str2 = "record_date != '" + str + "'";
            } catch (java.lang.Exception unused) {
            }
            if (com.anythink.basead.b.b.a(this.b).getWritableDatabase() == null) {
                return;
            }
            com.anythink.basead.b.b.a(this.b).getWritableDatabase().delete(com.anythink.basead.b.c.a.a, str2, null);
        }
    }
}
