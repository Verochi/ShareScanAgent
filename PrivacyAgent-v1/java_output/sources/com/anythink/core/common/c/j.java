package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class j extends com.anythink.core.common.c.a<com.anythink.core.common.f.ae> {
    private static com.anythink.core.common.c.j c;
    private final java.lang.String b;

    public static class a {
        public static final java.lang.String a = "offer_action_record";
        public static final java.lang.String b = "adsource_id";
        public static final java.lang.String c = "type";
        public static final java.lang.String d = "unit_id";
        public static final java.lang.String e = "click_count";
        public static final java.lang.String f = "show_count";
        public static final java.lang.String g = "expire_time";
        public static final java.lang.String h = "CREATE TABLE IF NOT EXISTS offer_action_record(adsource_id TEXT ,type INTEGER ,unit_id TEXT ,click_count INTEGER ,show_count INTEGER ,expire_time INTEGER )";
    }

    private j(com.anythink.core.common.c.b bVar) {
        super(bVar);
        this.b = com.anythink.core.common.c.j.class.getName();
    }

    private synchronized long a(com.anythink.core.common.f.ae aeVar) {
        if (b() == null || aeVar == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("type", java.lang.Integer.valueOf(aeVar.e()));
            contentValues.put("unit_id", aeVar.a());
            contentValues.put(com.anythink.core.common.c.j.a.e, java.lang.Integer.valueOf(aeVar.d()));
            contentValues.put("show_count", java.lang.Integer.valueOf(aeVar.c()));
            contentValues.put("expire_time", java.lang.Long.valueOf(aeVar.b()));
            return b().update(com.anythink.core.common.c.j.a.a, contentValues, "type = ? and unit_id = ?", new java.lang.String[]{java.lang.String.valueOf(aeVar.e()), aeVar.a()});
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public static com.anythink.core.common.c.j a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.j.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.j(bVar);
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0081, code lost:
    
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
    
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        if (r1 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized com.anythink.core.common.f.ae a(int i, java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query(com.anythink.core.common.c.j.a.a, null, "type=? and unit_id = ?", new java.lang.String[]{java.lang.String.valueOf(i), str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        com.anythink.core.common.f.ae aeVar = new com.anythink.core.common.f.ae(i, str);
                        aeVar.b(cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.j.a.e)));
                        aeVar.a(cursor.getInt(cursor.getColumnIndex("show_count")));
                        aeVar.a(cursor.getLong(cursor.getColumnIndex("expire_time")));
                        cursor.close();
                        cursor.close();
                        return aeVar;
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

    private synchronized long b(java.lang.String str, int i, java.lang.String str2) {
        if (b() == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("adsource_id", str);
            contentValues.put("type", java.lang.Integer.valueOf(i));
            contentValues.put("unit_id", str2);
            com.anythink.core.common.f.ae a2 = a(i, str2);
            if (a2 != null) {
                contentValues.put(com.anythink.core.common.c.j.a.e, java.lang.Integer.valueOf(a2.d()));
                contentValues.put("show_count", java.lang.Integer.valueOf(a2.c()));
                contentValues.put("expire_time", java.lang.Long.valueOf(a2.b()));
            } else {
                contentValues.put(com.anythink.core.common.c.j.a.e, (java.lang.Integer) 0);
                contentValues.put("show_count", (java.lang.Integer) 0);
                contentValues.put("expire_time", (java.lang.Integer) (-1));
            }
            return b().insert(com.anythink.core.common.c.j.a.a, null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    private static java.lang.String b(int i) {
        if (i <= 0) {
            throw new java.lang.RuntimeException("No placeholders");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((i * 2) - 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    private boolean b(int i, java.lang.String str) {
        android.database.Cursor query = a().query(com.anythink.core.common.c.j.a.a, null, "type = ? and unit_id = ?", new java.lang.String[]{java.lang.String.valueOf(i), str}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    private boolean c(java.lang.String str, int i, java.lang.String str2) {
        android.database.Cursor query = a().query(com.anythink.core.common.c.j.a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new java.lang.String[]{str, java.lang.String.valueOf(i), str2}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
    
        if (r1 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.f.ae> a(int i) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = a().query(com.anythink.core.common.c.j.a.a, null, "type = ? and expire_time > ?", new java.lang.String[]{java.lang.String.valueOf(i), java.lang.String.valueOf(java.lang.System.currentTimeMillis())}, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        com.anythink.core.common.f.ae aeVar = new com.anythink.core.common.f.ae(i, cursor.getString(cursor.getColumnIndex("unit_id")));
                        aeVar.b(cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.j.a.e)));
                        aeVar.a(cursor.getInt(cursor.getColumnIndex("show_count")));
                        aeVar.a(cursor.getLong(cursor.getColumnIndex("expire_time")));
                        arrayList.add(aeVar);
                    }
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
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00be, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
    
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
    
        if (r1 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.f.ae> a(java.util.List<java.lang.String> list, int i) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        b(list.size());
        android.database.Cursor cursor = null;
        try {
            try {
                java.lang.String[] strArr = new java.lang.String[list.size() + 2];
                list.toArray(strArr);
                strArr[list.size()] = java.lang.String.valueOf(i);
                strArr[list.size() + 1] = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                cursor = a().query(com.anythink.core.common.c.j.a.a, null, "adsource_id IN (" + b(list.size()) + ") and type = ? and expire_time > ?", strArr, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        com.anythink.core.common.f.ae aeVar = new com.anythink.core.common.f.ae(i, cursor.getString(cursor.getColumnIndex("unit_id")));
                        aeVar.b(cursor.getInt(cursor.getColumnIndex(com.anythink.core.common.c.j.a.e)));
                        aeVar.a(cursor.getInt(cursor.getColumnIndex("show_count")));
                        aeVar.a(cursor.getLong(cursor.getColumnIndex("expire_time")));
                        arrayList.add(aeVar);
                    }
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
        return arrayList;
    }

    public final synchronized void a(int i, java.lang.String str, int i2, int i3) {
        com.anythink.core.common.f.ae a2 = a(i, str);
        if (a2 != null) {
            a2.b(a2.d() + i2);
            a2.a(a2.c() + i3);
            a(a2);
        }
    }

    public final synchronized void a(int i, java.lang.String str, long j) {
        com.anythink.core.common.f.ae a2 = a(i, str);
        if (a2 != null) {
            a2.a(j);
            a(a2);
        }
    }

    public final synchronized void a(java.lang.String str, int i, java.lang.String str2) {
        boolean z = false;
        android.database.Cursor query = a().query(com.anythink.core.common.c.j.a.a, null, "adsource_id = ? and type = ? and unit_id = ?", new java.lang.String[]{str, java.lang.String.valueOf(i), str2}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            z = true;
        } else if (query != null) {
            query.close();
        }
        if (!z) {
            b(str, i, str2);
        }
    }
}
