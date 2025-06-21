package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class k {
    public static final int a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static android.content.Context d = null;
    private static java.lang.String e = null;
    private static final java.lang.String f = "umeng+";
    private static final java.lang.String g = "ek__id";
    private static final java.lang.String h = "ek_key";
    private java.util.List<java.lang.String> i;
    private java.util.List<java.lang.Integer> j;
    private java.lang.String k;
    private java.util.List<java.lang.String> l;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    public static class b {
        private static final com.umeng.analytics.pro.k a = new com.umeng.analytics.pro.k(null);

        private b() {
        }
    }

    private k() {
        this.i = new java.util.ArrayList();
        this.j = new java.util.ArrayList();
        this.k = null;
        this.l = new java.util.ArrayList();
    }

    public /* synthetic */ k(com.umeng.analytics.pro.k.AnonymousClass1 anonymousClass1) {
        this();
    }

    private android.database.Cursor a(java.lang.String str, android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static com.umeng.analytics.pro.k a(android.content.Context context) {
        com.umeng.analytics.pro.k kVar = com.umeng.analytics.pro.k.b.a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            kVar.k();
        }
        return kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x022e, code lost:
    
        if (r12 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x021f, code lost:
    
        if (r12 == null) goto L99;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0243: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:131:0x0248, block:B:130:0x0243 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x023e: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:130:0x0243, block:B:128:0x023e */
    /* JADX WARN: Removed duplicated region for block: B:23:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(org.json.JSONObject jSONObject, boolean z) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor;
        android.database.Cursor cursor2;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2;
        org.json.JSONArray jSONArray;
        java.lang.String str;
        org.json.JSONArray jSONArray2;
        java.lang.String str2 = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    android.database.Cursor a2 = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a2 != null) {
                        try {
                            org.json.JSONArray jSONArray3 = new org.json.JSONArray();
                            while (true) {
                                if (!a2.moveToNext()) {
                                    cursor = a2;
                                    jSONArray = jSONArray3;
                                    break;
                                }
                                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                java.lang.String string = a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.g));
                                java.lang.String string2 = a2.getString(a2.getColumnIndex("__e"));
                                java.lang.String string3 = a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.h));
                                str2 = a2.getString(a2.getColumnIndex("__ii"));
                                try {
                                    if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(string2)) {
                                        str = str2;
                                        cursor = a2;
                                        jSONArray = jSONArray3;
                                    } else {
                                        if (java.lang.Long.parseLong(string) - java.lang.Long.parseLong(string2) > 0) {
                                            java.lang.String string4 = a2.getString(a2.getColumnIndex("__a"));
                                            java.lang.String string5 = a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.c));
                                            java.lang.String string6 = a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.d));
                                            java.lang.String string7 = a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.e));
                                            this.i.add(str2);
                                            java.lang.String string8 = a2.getString(a2.getColumnIndex("__sp"));
                                            java.lang.String string9 = a2.getString(a2.getColumnIndex("__pp"));
                                            jSONObject2.put("id", str2);
                                            jSONObject2.put("start_time", string2);
                                            jSONObject2.put("end_time", string);
                                            str = str2;
                                            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                try {
                                                    if (java.lang.Long.parseLong(string3) <= 0) {
                                                        jSONObject2.put("duration", java.lang.Long.parseLong(string) - java.lang.Long.parseLong(string2));
                                                        cursor = a2;
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        cursor = a2;
                                                        jSONArray2 = jSONArray3;
                                                        jSONObject2.put("duration", java.lang.Long.parseLong(string3));
                                                        jSONObject2.put(com.umeng.analytics.pro.f.f447s, java.lang.Long.parseLong(string) - java.lang.Long.parseLong(string2));
                                                    }
                                                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                                                    cursor = a2;
                                                    str2 = str;
                                                    com.umeng.analytics.pro.j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                } catch (java.lang.Throwable unused2) {
                                                    cursor = a2;
                                                    str2 = str;
                                                    com.umeng.analytics.pro.j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                }
                                            } else {
                                                cursor = a2;
                                                jSONArray2 = jSONArray3;
                                                jSONObject2.put("duration", java.lang.Long.parseLong(string) - java.lang.Long.parseLong(string2));
                                            }
                                            if (!android.text.TextUtils.isEmpty(string4)) {
                                                try {
                                                    jSONObject2.put(com.umeng.analytics.pro.f.t, new org.json.JSONArray(d(string4)));
                                                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused3) {
                                                    str2 = str;
                                                    com.umeng.analytics.pro.j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                } catch (java.lang.Throwable unused4) {
                                                    str2 = str;
                                                    com.umeng.analytics.pro.j.a(d);
                                                    if (cursor != null) {
                                                    }
                                                }
                                            }
                                            boolean z2 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == com.umeng.analytics.MobclickAgent.PageMode.AUTO;
                                            if (!android.text.TextUtils.isEmpty(string5) && z2) {
                                                org.json.JSONArray jSONArray4 = new org.json.JSONArray(d(string5));
                                                org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                                                if (jSONArray4.length() > 0) {
                                                    jSONArray5 = b(jSONArray4);
                                                }
                                                jSONObject2.put(com.umeng.analytics.pro.f.u, jSONArray5);
                                            }
                                            if (!android.text.TextUtils.isEmpty(string6)) {
                                                jSONObject2.put(com.umeng.analytics.pro.f.F, new org.json.JSONObject(d(string6)));
                                            }
                                            if (!android.text.TextUtils.isEmpty(string7)) {
                                                jSONObject2.put(com.umeng.analytics.pro.f.B, new org.json.JSONArray(d(string7)));
                                            }
                                            if (!android.text.TextUtils.isEmpty(string8)) {
                                                jSONObject2.put(com.umeng.analytics.pro.f.aA, new org.json.JSONObject(d(string8)));
                                            }
                                            if (!android.text.TextUtils.isEmpty(string9)) {
                                                jSONObject2.put(com.umeng.analytics.pro.f.aB, new org.json.JSONObject(d(string9)));
                                            }
                                            if (jSONObject2.length() > 0) {
                                                jSONArray = jSONArray2;
                                                jSONArray.put(jSONObject2);
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                        } else {
                                            str = str2;
                                            cursor = a2;
                                            jSONArray = jSONArray3;
                                        }
                                        if (z) {
                                            str2 = str;
                                            break;
                                        }
                                    }
                                    jSONArray3 = jSONArray;
                                    a2 = cursor;
                                    str2 = str;
                                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused5) {
                                    cursor = a2;
                                    com.umeng.analytics.pro.j.a(d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                } catch (java.lang.Throwable unused6) {
                                    cursor = a2;
                                    com.umeng.analytics.pro.j.a(d);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            }
                        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused7) {
                        } catch (java.lang.Throwable unused8) {
                        }
                        try {
                            if (this.i.size() < 1) {
                                cursor.close();
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (java.lang.Throwable unused9) {
                                }
                                com.umeng.analytics.pro.i.a(d).b();
                                return str2;
                            }
                            if (jSONArray.length() > 0) {
                                jSONObject.put(com.umeng.analytics.pro.f.n, jSONArray);
                            }
                        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused10) {
                            com.umeng.analytics.pro.j.a(d);
                            if (cursor != null) {
                            }
                        } catch (java.lang.Throwable unused11) {
                            com.umeng.analytics.pro.j.a(d);
                            if (cursor != null) {
                            }
                        }
                    } else {
                        cursor = a2;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused12) {
                    cursor = null;
                } catch (java.lang.Throwable unused13) {
                    cursor = null;
                }
            } catch (java.lang.Throwable th) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (java.lang.Throwable unused14) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
                throw th;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused15) {
            sQLiteDatabase = null;
            cursor = null;
        } catch (java.lang.Throwable unused16) {
            sQLiteDatabase = null;
            cursor = null;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (java.lang.Throwable unused17) {
        }
        com.umeng.analytics.pro.i.a(d).b();
        return str2;
    }

    private void a(java.lang.String str, org.json.JSONObject jSONObject, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((java.lang.Long) jSONObject.opt(com.umeng.analytics.pro.g.d.a.g)).longValue();
            java.lang.Object opt = jSONObject.opt(com.umeng.analytics.pro.g.d.a.h);
            long longValue2 = (opt == null || !(opt instanceof java.lang.Long)) ? 0L : ((java.lang.Long) opt).longValue();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            java.lang.String str2 = "";
            java.lang.String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + com.umeng.analytics.pro.g.d.a.h + "=\"" + longValue2 + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078 A[Catch: all -> 0x0069, TryCatch #1 {all -> 0x0069, blocks: (B:52:0x0056, B:54:0x005c, B:15:0x006d, B:17:0x0078, B:18:0x007d, B:26:0x008c, B:29:0x0092, B:31:0x0098, B:38:0x009e, B:40:0x00ac, B:33:0x009b), top: B:51:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x0056->B:54:0x005c, LOOP_START, PHI: r14
  0x0056: PHI (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:14:0x0054, B:54:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @android.annotation.SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str, org.json.JSONObject jSONObject, android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str2) throws org.json.JSONException {
        org.json.JSONArray jSONArray;
        org.json.JSONArray optJSONArray;
        android.database.Cursor a2;
        org.json.JSONArray jSONArray2;
        android.database.Cursor cursor = null;
        r14 = null;
        java.lang.String str3 = null;
        try {
            if ("__a".equals(str2)) {
                optJSONArray = jSONObject.optJSONArray("__a");
                if (optJSONArray == null) {
                    return;
                }
                if (optJSONArray.length() <= 0) {
                    return;
                }
            } else {
                if (!com.umeng.analytics.pro.g.d.a.c.equals(str2)) {
                    jSONArray = null;
                    a2 = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, new java.lang.String[]{str2}, "__ii=? ", new java.lang.String[]{str}, null, null, null, null);
                    if (a2 != null) {
                        while (a2.moveToNext()) {
                            try {
                                str3 = d(a2.getString(a2.getColumnIndex(str2)));
                            } catch (java.lang.Throwable unused) {
                                cursor = a2;
                                if (cursor != null) {
                                    cursor.close();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    jSONArray2 = new org.json.JSONArray();
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        jSONArray2 = new org.json.JSONArray(str3);
                    }
                    if (jSONArray2.length() <= 1000) {
                        if (a2 != null) {
                            a2.close();
                            return;
                        }
                        return;
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            if (jSONObject2 != null) {
                                jSONArray2.put(jSONObject2);
                            }
                        } catch (org.json.JSONException unused2) {
                        }
                    }
                    java.lang.String c2 = c(jSONArray2.toString());
                    if (!android.text.TextUtils.isEmpty(c2)) {
                        sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + c2 + "\" where __ii=\"" + str + "\"");
                    }
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                }
                optJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.g.d.a.c);
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
            }
            jSONArray = optJSONArray;
            a2 = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, new java.lang.String[]{str2}, "__ii=? ", new java.lang.String[]{str}, null, null, null, null);
            if (a2 != null) {
            }
            jSONArray2 = new org.json.JSONArray();
            if (!android.text.TextUtils.isEmpty(str3)) {
            }
            if (jSONArray2.length() <= 1000) {
            }
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x018e, code lost:
    
        if (r1 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0180, code lost:
    
        if (r1 != null) goto L89;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01a3: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:114:0x01a8, block:B:113:0x01a3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(org.json.JSONObject jSONObject, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2;
        android.database.Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
                throw th;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            sQLiteDatabase = null;
        } catch (java.lang.Throwable unused3) {
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = !android.text.TextUtils.isEmpty(str) ? a(com.umeng.analytics.pro.g.b.a, sQLiteDatabase, null, "__i=? ", new java.lang.String[]{str}, null, null, null, null) : a(com.umeng.analytics.pro.g.b.a, sQLiteDatabase, null, null, null, null, null, null, null);
            if (cursor != null) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                java.lang.String b2 = com.umeng.analytics.pro.w.a().b();
                while (cursor.moveToNext()) {
                    int i = cursor.getInt(cursor.getColumnIndex("__t"));
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("__i"));
                    java.lang.String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                    if (android.text.TextUtils.isEmpty(string) || "-1".equals(string)) {
                        if (!android.text.TextUtils.isEmpty(b2)) {
                            string = b2;
                        }
                    }
                    this.j.add(java.lang.Integer.valueOf(cursor.getInt(0)));
                    if (i != 2049) {
                        if (i == 2050 && !android.text.TextUtils.isEmpty(string2)) {
                            org.json.JSONObject jSONObject4 = new org.json.JSONObject(d(string2));
                            org.json.JSONArray optJSONArray = jSONObject3.has(string) ? jSONObject3.optJSONArray(string) : new org.json.JSONArray();
                            optJSONArray.put(jSONObject4);
                            jSONObject3.put(string, optJSONArray);
                        }
                    } else if (!android.text.TextUtils.isEmpty(string2)) {
                        org.json.JSONObject jSONObject5 = new org.json.JSONObject(d(string2));
                        org.json.JSONArray optJSONArray2 = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new org.json.JSONArray();
                        optJSONArray2.put(jSONObject5);
                        jSONObject2.put(string, optJSONArray2);
                    }
                }
                if (jSONObject2.length() > 0) {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                        java.lang.String next = keys.next();
                        jSONObject6.put(next, new org.json.JSONArray(jSONObject2.optString(next)));
                        if (jSONObject6.length() > 0) {
                            jSONArray.put(jSONObject6);
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("ekv", jSONArray);
                    }
                }
                if (jSONObject3.length() > 0) {
                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                    java.util.Iterator<java.lang.String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                        java.lang.String next2 = keys2.next();
                        jSONObject7.put(next2, new org.json.JSONArray(jSONObject3.optString(next2)));
                        if (jSONObject7.length() > 0) {
                            jSONArray2.put(jSONObject7);
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        jSONObject.put(com.umeng.analytics.pro.f.Z, jSONArray2);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
            com.umeng.analytics.pro.j.a(d);
            if (cursor != null) {
                cursor.close();
            }
        } catch (java.lang.Throwable unused5) {
            com.umeng.analytics.pro.j.a(d);
            if (cursor != null) {
                cursor.close();
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (java.lang.Throwable unused6) {
        }
        com.umeng.analytics.pro.i.a(d).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e4, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String b(org.json.JSONObject jSONObject, boolean z) {
        java.lang.Object obj;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        ?? r0 = 0;
        java.lang.String str = null;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = null;
        r0 = null;
        android.database.Cursor cursor = null;
        android.database.Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    android.database.Cursor a2 = a(com.umeng.analytics.pro.g.c.a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a2 != null) {
                        try {
                            org.json.JSONArray jSONArray = new org.json.JSONArray();
                            while (a2.moveToNext()) {
                                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                java.lang.String string = a2.getString(a2.getColumnIndex("__e"));
                                str = a2.getString(a2.getColumnIndex("__ii"));
                                this.l.add(str);
                                java.lang.String string2 = a2.getString(a2.getColumnIndex("__sp"));
                                java.lang.String string3 = a2.getString(a2.getColumnIndex("__pp"));
                                if (!android.text.TextUtils.isEmpty(string2)) {
                                    jSONObject2.put(com.umeng.analytics.pro.f.aA, new org.json.JSONObject(d(string2)));
                                }
                                if (!android.text.TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(com.umeng.analytics.pro.f.aB, new org.json.JSONObject(d(string3)));
                                }
                                if (!android.text.TextUtils.isEmpty(string)) {
                                    jSONObject2.put("id", str);
                                    jSONObject2.put("start_time", string);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            r0 = str;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(com.umeng.analytics.pro.f.n, jSONArray);
                                r0 = str;
                            }
                        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                            obj = r0;
                            cursor = a2;
                            com.umeng.analytics.pro.j.a(d);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (java.lang.Throwable unused2) {
                            obj = r0;
                            cursor2 = a2;
                            com.umeng.analytics.pro.j.a(d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (a2 != null) {
                        a2.close();
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused3) {
                    }
                    com.umeng.analytics.pro.i.a(d).b();
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
                    obj = null;
                } catch (java.lang.Throwable unused5) {
                    obj = null;
                }
            } catch (java.lang.Throwable th) {
                if (r0 != 0) {
                    r0.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused6) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
                throw th;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused7) {
            obj = null;
            sQLiteDatabase = null;
        } catch (java.lang.Throwable unused8) {
            obj = null;
            sQLiteDatabase = null;
        }
        return r0;
        com.umeng.analytics.pro.i.a(d).b();
        r0 = obj;
        return r0;
    }

    private org.json.JSONArray b(org.json.JSONArray jSONArray) {
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    private void b(java.lang.String str, org.json.JSONObject jSONObject, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((java.lang.Long) jSONObject.get("__e")).longValue();
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            java.lang.String str2 = "";
            java.lang.String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", java.lang.String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", com.umeng.commonsdk.service.UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(com.umeng.analytics.pro.g.c.a, null, contentValues);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0083, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a6: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:51:0x00ab, block:B:50:0x00a6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(org.json.JSONObject jSONObject, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase2;
        android.database.Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = !android.text.TextUtils.isEmpty(str) ? a(com.umeng.analytics.pro.g.a.a, sQLiteDatabase, null, "__i=? ", new java.lang.String[]{str}, null, null, null, null) : a(com.umeng.analytics.pro.g.a.a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (cursor != null) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        while (cursor.moveToNext()) {
                            java.lang.String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!android.text.TextUtils.isEmpty(string)) {
                                jSONArray.put(new org.json.JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                    com.umeng.analytics.pro.j.a(d);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (java.lang.Throwable unused2) {
                    com.umeng.analytics.pro.j.a(d);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (java.lang.Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
                throw th;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = null;
        } catch (java.lang.Throwable unused5) {
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (java.lang.Throwable unused6) {
        }
        com.umeng.analytics.pro.i.a(d).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(java.lang.String str, org.json.JSONObject jSONObject, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursor;
        org.json.JSONObject jSONObject2;
        java.lang.String str2;
        android.database.Cursor cursor2;
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.analytics.pro.g.d.a.e);
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
                android.database.Cursor a2 = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, new java.lang.String[]{com.umeng.analytics.pro.g.d.a.e}, "__ii=? ", new java.lang.String[]{str}, null, null, null, null);
                if (a2 != null) {
                    java.lang.String str3 = null;
                    while (a2.moveToNext()) {
                        try {
                            str3 = d(a2.getString(a2.getColumnIndex(com.umeng.analytics.pro.g.d.a.e)));
                        } catch (java.lang.Throwable unused) {
                            cursor = a2;
                            if (cursor == null) {
                            }
                        }
                    }
                    java.lang.String str4 = str3;
                    cursor2 = a2;
                    str2 = str4;
                } else {
                    cursor2 = a2;
                    str2 = null;
                }
            } else {
                jSONObject2 = optJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        jSONArray = new org.json.JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    java.lang.String c2 = c(jSONArray.toString());
                    if (!android.text.TextUtils.isEmpty(c2)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + c2 + "\" where __ii=\"" + str + "\"");
                    }
                } catch (java.lang.Throwable unused2) {
                    cursor = cursor2;
                    if (cursor == null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
            }
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(com.umeng.analytics.pro.g.d.a.d);
            if (optJSONObject2 != null) {
                java.lang.String c3 = c(optJSONObject2.toString());
                if (!android.text.TextUtils.isEmpty(c3)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + c3 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + java.lang.String.valueOf(jSONObject.optLong(com.umeng.analytics.pro.g.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (android.text.TextUtils.isEmpty(e)) {
                java.lang.String multiProcessSP = com.umeng.commonsdk.utils.UMUtils.getMultiProcessSP(d, g);
                if (android.text.TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(d).getString(g, null);
                    if (android.text.TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = com.umeng.commonsdk.utils.UMUtils.genId();
                    }
                    if (!android.text.TextUtils.isEmpty(multiProcessSP)) {
                        com.umeng.commonsdk.utils.UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!android.text.TextUtils.isEmpty(multiProcessSP)) {
                    java.lang.String substring = multiProcessSP.substring(1, 9);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!java.lang.Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (java.lang.Integer.parseInt(java.lang.Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - java.lang.Integer.parseInt(java.lang.Character.toString(charAt)));
                        }
                    }
                    e = sb.toString();
                }
                if (android.text.TextUtils.isEmpty(e)) {
                    return;
                }
                e += new java.lang.StringBuilder(e).reverse().toString();
                java.lang.String multiProcessSP2 = com.umeng.commonsdk.utils.UMUtils.getMultiProcessSP(d, h);
                if (android.text.TextUtils.isEmpty(multiProcessSP2)) {
                    com.umeng.commonsdk.utils.UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r4 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor = null;
        long j = 0;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, new java.lang.String[]{com.umeng.analytics.pro.g.d.a.g}, "__ii=? ", new java.lang.String[]{str}, null, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        j = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.g.d.a.g));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (java.lang.Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (java.lang.Exception unused2) {
                            com.umeng.analytics.pro.i.a(d).b();
                            throw th;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    com.umeng.analytics.pro.i.a(d).b();
                    throw th;
                }
            } catch (java.lang.Exception unused3) {
            }
        } catch (java.lang.Exception unused4) {
            sQLiteDatabase = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        sQLiteDatabase.endTransaction();
        com.umeng.analytics.pro.i.a(d).b();
        return j;
    }

    public org.json.JSONObject a(boolean z) {
        a();
        this.j.clear();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (z) {
            java.lang.String a2 = a(jSONObject, z);
            if (!android.text.TextUtils.isEmpty(a2)) {
                b(jSONObject, a2);
                a(jSONObject, a2);
            }
        } else {
            a(jSONObject, z);
            b(jSONObject, (java.lang.String) null);
            a(jSONObject, (java.lang.String) null);
        }
        return jSONObject;
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0098, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(org.json.JSONArray jSONArray) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                android.database.sqlite.SQLiteDatabase a2 = com.umeng.analytics.pro.i.a(d).a();
                try {
                    try {
                        a2.beginTransaction();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                                android.content.ContentValues contentValues = new android.content.ContentValues();
                                java.lang.String optString = jSONObject.optString("__i");
                                if (android.text.TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                                    optString = com.umeng.analytics.pro.w.a().b();
                                    if (android.text.TextUtils.isEmpty(optString)) {
                                        optString = "-1";
                                    }
                                }
                                contentValues.put("__i", optString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", java.lang.Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", com.umeng.commonsdk.utils.UMUtils.getAppVersionName(d));
                                contentValues.put("__vc", com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", c(jSONObject.toString()));
                                a2.insert(com.umeng.analytics.pro.g.b.a, null, contentValues);
                            } catch (java.lang.Exception unused) {
                            }
                        }
                        a2.setTransactionSuccessful();
                        a2.endTransaction();
                    } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
                        sQLiteDatabase = a2;
                        try {
                            com.umeng.analytics.pro.j.a(d);
                        } catch (java.lang.Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            com.umeng.analytics.pro.i.a(d).b();
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable unused4) {
                    sQLiteDatabase = a2;
                }
            } catch (java.lang.Throwable unused5) {
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused6) {
        } catch (java.lang.Throwable unused7) {
        }
        com.umeng.analytics.pro.i.a(d).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0078, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                if (!android.text.TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.j.clear();
                    sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                    sQLiteDatabase.beginTransaction();
                    if (!z2) {
                        int size = this.l.size();
                        int i = 0;
                        if (size > 0) {
                            int i2 = 0;
                            while (i < size) {
                                java.lang.String str = this.l.get(i);
                                if (str == null) {
                                    i2 = 1;
                                }
                                sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i++;
                            }
                            i = i2;
                        }
                        if (i != 0) {
                            sQLiteDatabase.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z) {
                        sQLiteDatabase.execSQL("delete from __is");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (java.lang.Throwable unused) {
                    com.umeng.analytics.pro.j.a(d);
                    if (sQLiteDatabase != null) {
                    }
                }
            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
                com.umeng.analytics.pro.j.a(d);
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (java.lang.Throwable unused3) {
            }
            com.umeng.analytics.pro.i.a(d).b();
        } catch (java.lang.Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (java.lang.Throwable unused4) {
                }
            }
            com.umeng.analytics.pro.i.a(d).b();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(java.lang.String str, java.lang.String str2, int i) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                android.database.sqlite.SQLiteDatabase a2 = com.umeng.analytics.pro.i.a(d).a();
                try {
                    a2.beginTransaction();
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("__i", str);
                    java.lang.String c2 = c(str2);
                    if (!android.text.TextUtils.isEmpty(c2)) {
                        contentValues.put("__a", c2);
                        contentValues.put("__t", java.lang.Integer.valueOf(i));
                        contentValues.put("__av", com.umeng.commonsdk.utils.UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(d));
                        a2.insert(com.umeng.analytics.pro.g.a.a, null, contentValues);
                    }
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a2;
                    try {
                        com.umeng.analytics.pro.j.a(d);
                    } catch (java.lang.Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        com.umeng.analytics.pro.i.a(d).b();
                        throw th;
                    }
                } catch (java.lang.Throwable unused3) {
                    sQLiteDatabase = a2;
                }
            } catch (java.lang.Throwable unused4) {
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused5) {
        } catch (java.lang.Throwable unused6) {
        }
        com.umeng.analytics.pro.i.a(d).b();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0099, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0085, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(java.lang.String str, org.json.JSONObject jSONObject, com.umeng.analytics.pro.k.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                android.database.sqlite.SQLiteDatabase a2 = com.umeng.analytics.pro.i.a(d).a();
                try {
                    a2.beginTransaction();
                    if (aVar == com.umeng.analytics.pro.k.a.BEGIN) {
                        long longValue = ((java.lang.Long) jSONObject.opt("__e")).longValue();
                        android.content.ContentValues contentValues = new android.content.ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", java.lang.String.valueOf(longValue));
                        contentValues.put("__av", com.umeng.commonsdk.utils.UMUtils.getAppVersionName(d));
                        contentValues.put("__vc", com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(d));
                        a2.insert(com.umeng.analytics.pro.g.d.a, null, contentValues);
                    } else if (aVar == com.umeng.analytics.pro.k.a.INSTANTSESSIONBEGIN) {
                        b(str, jSONObject, a2);
                    } else if (aVar == com.umeng.analytics.pro.k.a.END) {
                        a(str, jSONObject, a2);
                    } else if (aVar == com.umeng.analytics.pro.k.a.PAGE) {
                        a(str, jSONObject, a2, "__a");
                    } else if (aVar == com.umeng.analytics.pro.k.a.AUTOPAGE) {
                        a(str, jSONObject, a2, com.umeng.analytics.pro.g.d.a.c);
                    } else if (aVar == com.umeng.analytics.pro.k.a.NEWSESSION) {
                        c(str, jSONObject, a2);
                    }
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a2;
                    try {
                        com.umeng.analytics.pro.j.a(d);
                    } catch (java.lang.Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        com.umeng.analytics.pro.i.a(d).b();
                        throw th;
                    }
                } catch (java.lang.Throwable unused3) {
                    sQLiteDatabase = a2;
                }
            } catch (java.lang.Throwable unused4) {
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused5) {
        } catch (java.lang.Throwable unused6) {
        }
        com.umeng.analytics.pro.i.a(d).b();
        return false;
    }

    public org.json.JSONObject b(boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    public void b() {
        this.l.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r0 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                if (!android.text.TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z, boolean z2) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabase.execSQL("delete from __sd");
                    }
                } else if (this.i.size() > 0) {
                    for (int i = 0; i < this.i.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.i.get(i) + "\"");
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
    }

    public java.lang.String c(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(e) ? str : android.util.Base64.encodeToString(com.umeng.commonsdk.statistics.common.DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    public java.lang.String d(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(e) ? str : new java.lang.String(com.umeng.commonsdk.statistics.common.DataHelper.decrypt(android.util.Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (java.lang.Exception unused) {
            if (android.os.Build.VERSION.SDK_INT >= 29 && !android.text.TextUtils.isEmpty(str)) {
                try {
                    new org.json.JSONObject(str);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (java.lang.Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        java.lang.String c2;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                c2 = com.umeng.analytics.pro.w.a().c();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
        if (android.text.TextUtils.isEmpty(c2)) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (java.lang.Throwable unused4) {
            }
            com.umeng.analytics.pro.i.a(d).b();
            return;
        }
        java.lang.String[] strArr = {"", "-1"};
        for (int i = 0; i < 2; i++) {
            sQLiteDatabase.execSQL("update __et set __i=\"" + c2 + "\" where __i=\"" + strArr[i] + "\"");
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.json.JSONObject f() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        org.json.JSONObject jSONObject;
        android.database.Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        org.json.JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        android.database.Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                android.database.Cursor a2 = a(com.umeng.analytics.pro.g.c.a, sQLiteDatabase, null, "__ii=? ", new java.lang.String[]{this.l.get(0)}, null, null, null, null);
                if (a2 != null) {
                    try {
                        if (a2.moveToNext()) {
                            jSONObject = new org.json.JSONObject();
                            try {
                                java.lang.String string = a2.getString(a2.getColumnIndex("__av"));
                                java.lang.String string2 = a2.getString(a2.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                                cursor2 = a2;
                                try {
                                    com.umeng.analytics.pro.j.a(d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (java.lang.Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (java.lang.Throwable unused2) {
                                        }
                                    }
                                    com.umeng.analytics.pro.i.a(d).b();
                                    throw th;
                                }
                            } catch (java.lang.Throwable unused3) {
                                cursor = a2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (java.lang.Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a2 != null) {
                    a2.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (java.lang.Throwable unused6) {
                }
                com.umeng.analytics.pro.i.a(d).b();
                return jSONObject2;
            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (java.lang.Throwable unused8) {
                jSONObject = null;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (java.lang.Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        com.umeng.analytics.pro.i.a(d).b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public org.json.JSONObject g() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        org.json.JSONObject jSONObject;
        android.database.Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        org.json.JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        android.database.Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
            try {
                sQLiteDatabase.beginTransaction();
                android.database.Cursor a2 = a(com.umeng.analytics.pro.g.d.a, sQLiteDatabase, null, "__ii=? ", new java.lang.String[]{this.i.get(0)}, null, null, null, null);
                if (a2 != null) {
                    try {
                        if (a2.moveToNext()) {
                            jSONObject = new org.json.JSONObject();
                            try {
                                java.lang.String string = a2.getString(a2.getColumnIndex("__av"));
                                java.lang.String string2 = a2.getString(a2.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                                cursor2 = a2;
                                try {
                                    com.umeng.analytics.pro.j.a(d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (java.lang.Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (java.lang.Throwable unused2) {
                                        }
                                    }
                                    com.umeng.analytics.pro.i.a(d).b();
                                    throw th;
                                }
                            } catch (java.lang.Throwable unused3) {
                                cursor = a2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (java.lang.Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a2 != null) {
                    a2.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (java.lang.Throwable unused6) {
                }
                com.umeng.analytics.pro.i.a(d).b();
                return jSONObject2;
            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (java.lang.Throwable unused8) {
                jSONObject = null;
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (java.lang.Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        com.umeng.analytics.pro.i.a(d).b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                if (this.j.size() > 0) {
                    for (int i = 0; i < this.j.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __et where rowid=" + this.j.get(i));
                    }
                }
                this.j.clear();
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("delete from __er");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (java.lang.Throwable unused) {
                    }
                }
                com.umeng.analytics.pro.i.a(d).b();
            }
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused2) {
            com.umeng.analytics.pro.j.a(d);
        } catch (java.lang.Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        if (!android.text.TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabase = com.umeng.analytics.pro.i.a(d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + this.k + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + this.k + "\"");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
                    try {
                        com.umeng.analytics.pro.j.a(d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        com.umeng.analytics.pro.i.a(d).b();
                    }
                } catch (java.lang.Throwable unused3) {
                }
            } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabase = null;
            } catch (java.lang.Throwable unused5) {
                sQLiteDatabase = null;
            }
        }
        this.k = null;
    }
}
