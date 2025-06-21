package com.igexin.push.core.e;

/* loaded from: classes23.dex */
public class c implements com.igexin.push.core.e.a {
    private static com.igexin.push.core.e.c c;
    private java.util.ArrayList<com.igexin.push.core.b.k> d;
    private boolean e;
    private java.lang.String b = "MessageDataManager";
    public int a = -1;

    /* renamed from: com.igexin.push.core.e.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            android.database.Cursor cursor = null;
            try {
                com.igexin.push.b.b bVar = com.igexin.push.core.d.a.a.i;
                cursor = bVar.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        byte[] blob = cursor.getBlob(cursor.getColumnIndex("info"));
                        long j = cursor.getLong(cursor.getColumnIndex("createtime"));
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(blob)));
                            java.lang.String string = jSONObject.getString("taskid");
                            if (jSONObject.has("condition") && !com.igexin.push.core.e.c.b(jSONObject) && java.lang.System.currentTimeMillis() - j > 259200000) {
                                java.lang.String unused = com.igexin.push.core.e.c.this.b;
                                com.igexin.c.a.c.a.a(com.igexin.push.core.e.c.this.b + "|del condition taskid = " + string, new java.lang.Object[0]);
                                bVar.a("message", new java.lang.String[]{"taskid"}, new java.lang.String[]{string});
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                try {
                    com.igexin.c.a.c.a.a(th2);
                    if (cursor != null) {
                        cursor.close();
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    }

    /* renamed from: com.igexin.push.core.e.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.igexin.push.b.d {
        public AnonymousClass2() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            com.igexin.push.core.d.a.a.i.a("message", "createtime <= ".concat(java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 604800000)));
        }
    }

    public static com.igexin.push.core.e.c a() {
        if (c == null) {
            synchronized (com.igexin.push.core.e.c.class) {
                if (c == null) {
                    c = new com.igexin.push.core.e.c();
                }
            }
        }
        return c;
    }

    public static void a(int i, java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", java.lang.Integer.valueOf(i));
        com.igexin.push.core.d.a.a.i.a("message", contentValues, new java.lang.String[]{"taskid"}, new java.lang.String[]{str});
    }

    private void a(android.content.ContentValues contentValues) {
        try {
            if (this.a == -1) {
                this.a = b();
            }
            if (this.a < 1000) {
                if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                    this.a++;
                    return;
                }
                return;
            }
            int a = com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
            this.a -= a;
            if (a < 250) {
                this.a -= com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - a) + ")");
            }
            if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                this.a++;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.util.ArrayList<com.igexin.push.core.b.k> arrayList) {
        try {
            java.util.Iterator<com.igexin.push.core.b.k> it = arrayList.iterator();
            while (it.hasNext()) {
                com.igexin.push.core.b.k next = it.next();
                byte[] bArr = next.e;
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("id", java.lang.Long.valueOf(next.a));
                contentValues.put("messageid", next.b);
                contentValues.put("taskid", next.c);
                contentValues.put("appid", next.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                byte[] bArr2 = next.f;
                if (bArr2 != null) {
                    contentValues.put("msgextra", bArr2);
                }
                contentValues.put("key", next.g);
                contentValues.put("status", java.lang.Integer.valueOf(next.h));
                contentValues.put("createtime", java.lang.Long.valueOf(next.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.lang.String str, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        android.database.Cursor cursor = null;
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("notify_status", java.lang.Integer.valueOf(i));
            if (i == com.igexin.push.core.b.ai) {
                cursor = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID}, new java.lang.String[]{str}, new java.lang.String[]{"redisplay_num", "redisplay_duration", "redisplay_freq"}, null);
                if (cursor != null && cursor.getCount() != 0) {
                    if (cursor.moveToFirst()) {
                        int i3 = cursor.getInt(cursor.getColumnIndex("redisplay_num"));
                        long j = cursor.getLong(cursor.getColumnIndex("redisplay_duration"));
                        contentValues.put("redisplay_num", java.lang.Integer.valueOf(i3 + 1));
                        contentValues.put("expect_redisplay_time", java.lang.Long.valueOf((java.lang.System.currentTimeMillis() / 1000) + j));
                    }
                }
                return;
            }
            com.igexin.push.core.d.a.a.i.a("message", contentValues, new java.lang.String[]{"taskid"}, new java.lang.String[]{str});
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static boolean a(java.lang.String str) {
        boolean z = false;
        android.database.Cursor cursor = null;
        try {
            cursor = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid"}, new java.lang.String[]{str}, null, null);
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static int b() {
        android.database.Cursor cursor = null;
        try {
            cursor = com.igexin.push.core.d.a.a.i.a("message", null, null, null, null);
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor == null) {
                    return 0;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (cursor != null) {
            int count = cursor.getCount();
            cursor.close();
            return count;
        }
        if (cursor == null) {
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            if (jSONObject2.has(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI) || jSONObject2.has("screenOn") || jSONObject2.has("ssid") || jSONObject2.has("duration")) {
                return false;
            }
            return !jSONObject2.has("netConnected");
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }

    private static void e() {
    }

    private void e(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("message", null, "status =?", new java.lang.String[]{"0"}, null, null, null, null);
            if (cursor != null) {
                java.util.ArrayList<com.igexin.push.core.b.k> arrayList = new java.util.ArrayList<>();
                while (cursor.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.k(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("messageid")), cursor.getString(cursor.getColumnIndex("taskid")), cursor.getString(cursor.getColumnIndex("appid")), cursor.getBlob(cursor.getColumnIndexOrThrow("info")), cursor.getBlob(cursor.getColumnIndex("msgextra")), cursor.getString(cursor.getColumnIndex("key")), cursor.getInt(cursor.getColumnIndex("status")), cursor.getLong(cursor.getColumnIndex("createtime"))));
                }
                try {
                    this.d = arrayList;
                    arrayList.size();
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.igexin.c.a.c.a.a(th);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        java.util.ArrayList<com.igexin.push.core.b.k> arrayList;
        if (!this.e || (arrayList = this.d) == null || arrayList.size() <= 0) {
            return;
        }
        java.util.ArrayList<com.igexin.push.core.b.k> arrayList2 = this.d;
        try {
            java.util.Iterator<com.igexin.push.core.b.k> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.igexin.push.core.b.k next = it.next();
                byte[] bArr = next.e;
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("id", java.lang.Long.valueOf(next.a));
                contentValues.put("messageid", next.b);
                contentValues.put("taskid", next.c);
                contentValues.put("appid", next.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                byte[] bArr2 = next.f;
                if (bArr2 != null) {
                    contentValues.put("msgextra", bArr2);
                }
                contentValues.put("key", next.g);
                contentValues.put("status", java.lang.Integer.valueOf(next.h));
                contentValues.put("createtime", java.lang.Long.valueOf(next.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList2.clear();
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.c.AnonymousClass1(), false, true);
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.c.AnonymousClass2(), false, true);
    }

    public final void d(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.e = true;
        android.database.Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("message", null, "status =?", new java.lang.String[]{"0"}, null, null, null, null);
            if (cursor != null) {
                java.util.ArrayList<com.igexin.push.core.b.k> arrayList = new java.util.ArrayList<>();
                while (cursor.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.k(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("messageid")), cursor.getString(cursor.getColumnIndex("taskid")), cursor.getString(cursor.getColumnIndex("appid")), cursor.getBlob(cursor.getColumnIndexOrThrow("info")), cursor.getBlob(cursor.getColumnIndex("msgextra")), cursor.getString(cursor.getColumnIndex("key")), cursor.getInt(cursor.getColumnIndex("status")), cursor.getLong(cursor.getColumnIndex("createtime"))));
                }
                this.d = arrayList;
                arrayList.size();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursor != null) {
                    cursor.close();
                }
            } finally {
            }
        }
    }
}
