package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class d extends com.anythink.core.common.c.a<com.anythink.core.common.f.ar> {
    private static final java.lang.String b = "com.anythink.core.common.c.d";
    private static volatile com.anythink.core.common.c.d c;

    public static class a {
        public static final java.lang.String a = "sdkconfig";
        public static final java.lang.String b = "key";
        public static final java.lang.String c = "type";
        public static final java.lang.String d = "value";
        public static final java.lang.String e = "lastupdatetime";
        public static final java.lang.String f = "CREATE TABLE IF NOT EXISTS sdkconfig(key TEXT ,type TEXT ,lastupdatetime TEXT ,value TEXT )";
    }

    private d(com.anythink.core.common.c.b bVar) {
        super(bVar);
    }

    private synchronized long a(com.anythink.core.common.f.ar arVar) {
        if (b() == null || arVar == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("key", arVar.b());
            contentValues.put("type", arVar.c());
            contentValues.put("value", arVar.d());
            contentValues.put(com.anythink.core.common.c.d.a.e, arVar.a());
            if (b(arVar.b(), arVar.a(), arVar.c())) {
                return b().update("sdkconfig", contentValues, "key = ? AND type = ? AND lastupdatetime = ?  ", new java.lang.String[]{arVar.b(), arVar.c(), arVar.a()});
            }
            return b().insert("sdkconfig", null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    public static com.anythink.core.common.c.d a(com.anythink.core.common.c.b bVar) {
        if (c == null) {
            synchronized (com.anythink.core.common.c.d.class) {
                if (c == null) {
                    c = new com.anythink.core.common.c.d(bVar);
                }
            }
        }
        return c;
    }

    private synchronized java.util.List<com.anythink.core.common.f.ar> a(android.database.Cursor cursor) {
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (cursor.moveToNext()) {
                    com.anythink.core.common.f.ar arVar = new com.anythink.core.common.f.ar();
                    arVar.b(cursor.getString(cursor.getColumnIndex("key")));
                    arVar.c(cursor.getString(cursor.getColumnIndex("type")));
                    arVar.d(cursor.getString(cursor.getColumnIndex("value")));
                    arVar.a(cursor.getString(cursor.getColumnIndex(com.anythink.core.common.c.d.a.e)));
                    arrayList.add(arVar);
                }
                cursor.close();
                return arrayList;
            }
        }
        return null;
    }

    private synchronized void a(java.lang.String str) {
        try {
            if (b() == null) {
                return;
            }
            b().delete("sdkconfig", "lastupdatetime< ? and type = ?", new java.lang.String[]{str, com.anythink.core.common.f.ar.a.a});
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0029, code lost:
    
        if (r10 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized java.util.List<com.anythink.core.common.f.ar> b(java.lang.String str) {
        android.database.Cursor cursor;
        try {
            cursor = a().query("sdkconfig", null, "type = ?", new java.lang.String[]{str}, null, null, null);
        } catch (java.lang.Exception unused) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused2) {
            cursor = null;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
        try {
            return a(cursor);
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
    }

    private synchronized boolean b(java.lang.String str, java.lang.String str2) {
        android.database.Cursor query = a().query("sdkconfig", new java.lang.String[]{"key"}, "key=? AND type=?", new java.lang.String[]{str, str2}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    private synchronized boolean b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.database.Cursor query = a().query("sdkconfig", new java.lang.String[]{"key"}, "key=? AND type=? AND lastupdatetime=?", new java.lang.String[]{str, str3, str2}, null, null, null);
        if (query != null && query.getCount() > 0) {
            query.close();
            return true;
        }
        if (query != null) {
            query.close();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002f, code lost:
    
        if (r10 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized java.util.List<com.anythink.core.common.f.ar> c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.database.Cursor cursor;
        try {
            cursor = a().query("sdkconfig", null, "key = ? and type = ? and lastupdatetime = ?", new java.lang.String[]{str, str3, str2}, null, null, null);
        } catch (java.lang.Exception unused) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused2) {
            cursor = null;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
        try {
            return a(cursor);
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
    }

    private synchronized void c(java.lang.String str, java.lang.String str2) {
        java.util.List<com.anythink.core.common.f.ar> c2 = c(str, str2, com.anythink.core.common.f.ar.a.a);
        if (c2 == null || c2.size() <= 0) {
            com.anythink.core.common.f.ar arVar = new com.anythink.core.common.f.ar();
            arVar.a(str2);
            arVar.d("1");
            arVar.c(com.anythink.core.common.f.ar.a.a);
            arVar.b(str);
            a(arVar);
            return;
        }
        for (com.anythink.core.common.f.ar arVar2 : c2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.Integer.parseInt(arVar2.d()) + 1);
            arVar2.d(sb.toString());
            a(arVar2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        if (r10 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized java.util.List<com.anythink.core.common.f.ar> d(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor;
        try {
            cursor = a().query("sdkconfig", null, "key != ? and type = ?", new java.lang.String[]{str, str2}, null, null, null);
        } catch (java.lang.Exception unused) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused2) {
            cursor = null;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
        try {
            return a(cursor);
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
    }

    public final synchronized long a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (b() == null) {
            return -1L;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("key", str);
            contentValues.put("type", str3);
            contentValues.put("value", str2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            contentValues.put(com.anythink.core.common.c.d.a.e, sb.toString());
            if (b(str, str3)) {
                return b().update("sdkconfig", contentValues, "key = ? AND type = ?", new java.lang.String[]{str, str3});
            }
            return b().insert("sdkconfig", null, contentValues);
        } catch (java.lang.Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        if (r10 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized java.util.List<com.anythink.core.common.f.ar> a(java.lang.String str, java.lang.String str2) {
        android.database.Cursor cursor;
        try {
            cursor = a().query("sdkconfig", null, "key = ? and type = ?", new java.lang.String[]{str, str2}, null, null, null);
        } catch (java.lang.Exception unused) {
            cursor = null;
        } catch (java.lang.OutOfMemoryError unused2) {
            cursor = null;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
        try {
            return a(cursor);
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
    }
}
