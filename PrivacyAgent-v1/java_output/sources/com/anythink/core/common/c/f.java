package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class f extends com.anythink.core.common.c.a<com.anythink.core.common.a.g> {
    private static volatile com.anythink.core.common.c.f d;
    private final java.lang.String b;
    private final long c;

    public static class a {
        public static final java.lang.String a = "dsp_offer_show_record";
        public static final java.lang.String b = "dsp_id";
        public static final java.lang.String c = "dsp_offer_id";
        public static final java.lang.String d = "show_limit";
        public static final java.lang.String e = "show_count";
        public static final java.lang.String f = "create_time";
        public static final java.lang.String g = "last_update_time";
        public static final java.lang.String h = "CREATE TABLE IF NOT EXISTS dsp_offer_show_record(dsp_id TEXT ,dsp_offer_id TEXT ,show_limit INTEGER ,show_count INTEGER ,create_time INTEGER ,last_update_time INTEGER)";
    }

    private f(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.f.class.getName();
        this.c = 86400000L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r11 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized com.anythink.core.common.a.g a(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.f.a.a, null, "dsp_id = ?  AND dsp_offer_id = ? ", new java.lang.String[]{str, str2}, null, null, null);
        } catch (java.lang.Exception unused) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused2) {
            cursor = null;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
        try {
            java.util.List<com.anythink.core.common.a.g> a2 = a(cursor);
            cursor.close();
            if (a2.size() > 0) {
                com.anythink.core.common.a.g gVar = a2.get(0);
                cursor.close();
                return gVar;
            }
        } catch (java.lang.Exception unused4) {
        } catch (java.lang.OutOfMemoryError unused5) {
            try {
                java.lang.System.gc();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (java.lang.Throwable unused6) {
        }
        return null;
    }

    public static com.anythink.core.common.c.f a(com.anythink.core.common.c.b bVar) {
        if (d == null) {
            synchronized (com.anythink.core.common.c.f.class) {
                if (d == null) {
                    d = new com.anythink.core.common.c.f(bVar);
                }
            }
        }
        return d;
    }

    private synchronized java.util.List<com.anythink.core.common.a.g> a(android.database.Cursor cursor) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    try {
                        com.anythink.core.common.a.g gVar = new com.anythink.core.common.a.g();
                        gVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                        gVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                        gVar.a(cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.f.a.d)));
                        gVar.b(cursor.getInt(cursor.getColumnIndex("show_count")));
                        arrayList.add(gVar);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized long a(com.anythink.core.common.a.g gVar) {
        if (b() == null) {
            return -1L;
        }
        if (gVar.c() <= 0) {
            return -1L;
        }
        if (a(gVar.a(), gVar.b()) != null) {
            gVar.a();
            gVar.b();
            return -1L;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("dsp_id", gVar.a());
        contentValues.put("dsp_offer_id", gVar.b());
        contentValues.put(com.anythink.core.common.c.f.a.d, java.lang.Integer.valueOf(gVar.c()));
        contentValues.put("show_count", (java.lang.Integer) 0);
        contentValues.put(com.anythink.core.common.c.f.a.f, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        contentValues.put("last_update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        gVar.a();
        gVar.b();
        return b().insert(com.anythink.core.common.c.f.a.a, null, contentValues);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
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
                cursor = a().query(com.anythink.core.common.c.f.a.a, null, "show_count > show_limit", null, null, null, "last_update_time DESC", java.lang.String.valueOf(i));
                java.util.List<com.anythink.core.common.a.g> a2 = a(cursor);
                a2.size();
                cursor.close();
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

    public final synchronized long b(com.anythink.core.common.a.g gVar) {
        if (b() == null) {
            return -1L;
        }
        if (gVar.c() <= 0) {
            return -1L;
        }
        com.anythink.core.common.a.g a2 = a(gVar.a(), gVar.b());
        if (a2 != null) {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("dsp_id", gVar.a());
                contentValues.put("dsp_offer_id", gVar.b());
                contentValues.put(com.anythink.core.common.c.f.a.d, java.lang.Integer.valueOf(gVar.c()));
                contentValues.put("show_count", java.lang.Integer.valueOf(a2.d() + 1));
                contentValues.put("last_update_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                gVar.a();
                gVar.b();
                a2.d();
                gVar.c();
                return b().update(com.anythink.core.common.c.f.a.a, contentValues, "dsp_id = ? and dsp_offer_id = ? ", new java.lang.String[]{gVar.a(), gVar.b()});
            } catch (java.lang.Exception unused) {
            }
        }
        return -1L;
    }

    public final void c() {
        try {
            java.lang.String str = "create_time < " + (java.lang.System.currentTimeMillis() - 86400000);
            if (b() == null) {
                return;
            }
            b().delete(com.anythink.core.common.c.f.a.a, str, null);
        } catch (java.lang.Exception unused) {
        }
    }
}
