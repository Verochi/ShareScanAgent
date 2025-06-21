package com.loc;

/* loaded from: classes23.dex */
public final class fl {
    java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.fl.a>> a = new java.util.Hashtable<>();
    private long i = 0;
    private boolean j = false;
    private java.lang.String k = "2.0.201501131131".replace(".", "");
    private java.lang.String l = null;
    boolean b = true;
    long c = 0;
    java.lang.String d = null;
    com.loc.fc e = null;
    private java.lang.String m = null;
    private long n = 0;
    boolean f = true;
    boolean g = true;
    java.lang.String h = java.lang.String.valueOf(com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT);

    public static class a {
        private com.loc.ey a = null;
        private java.lang.String b = null;

        public final com.loc.ey a() {
            return this.a;
        }

        public final void a(com.loc.ey eyVar) {
            this.a = eyVar;
        }

        public final void a(java.lang.String str) {
            this.b = android.text.TextUtils.isEmpty(str) ? null : str.replace("##", "#");
        }

        public final java.lang.String b() {
            return this.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0012, B:10:0x001a, B:12:0x0022, B:14:0x0030, B:16:0x0048, B:18:0x0052, B:20:0x0064, B:23:0x006f, B:25:0x0073, B:27:0x0079, B:28:0x0085, B:30:0x008b, B:31:0x008f, B:36:0x0042), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.loc.ey a(java.lang.String str, java.lang.StringBuilder sb, boolean z) {
        com.loc.fl.a a2;
        com.loc.ey a3;
        java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.fl.a>> hashtable;
        try {
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Cache", "get1");
        }
        if (!str.contains("cgiwifi") && !str.contains(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)) {
            a2 = (str.contains("cgi") && this.a.containsKey(str) && this.a.get(str).size() > 0) ? this.a.get(str).get(0) : null;
            if (a2 != null && com.loc.gd.a(a2.a())) {
                a3 = a2.a();
                a3.e("mem");
                a3.h(a2.b());
                if (!z && !com.loc.fu.a(a3.getTime())) {
                    hashtable = this.a;
                    if (hashtable != null && hashtable.containsKey(str)) {
                        this.a.get(str).remove(a2);
                    }
                }
                if (com.loc.gd.a(a3)) {
                    this.c = 0L;
                }
                a3.setLocationType(4);
                return a3;
            }
            return null;
        }
        a2 = a(sb, str);
        if (a2 != null) {
            a3 = a2.a();
            a3.e("mem");
            a3.h(a2.b());
            if (!z) {
                hashtable = this.a;
                if (hashtable != null) {
                    this.a.get(str).remove(a2);
                }
            }
            if (com.loc.gd.a(a3)) {
            }
            a3.setLocationType(4);
            return a3;
        }
        return null;
    }

    private com.loc.fl.a a(java.lang.StringBuilder sb, java.lang.String str) {
        com.loc.fl.a aVar;
        boolean z;
        com.loc.fl.a aVar2;
        if (this.a.isEmpty() || android.text.TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.a.containsKey(str)) {
            return null;
        }
        java.util.Hashtable hashtable = new java.util.Hashtable();
        java.util.Hashtable hashtable2 = new java.util.Hashtable();
        java.util.Hashtable hashtable3 = new java.util.Hashtable();
        java.util.ArrayList<com.loc.fl.a> arrayList = this.a.get(str);
        char c = 1;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            com.loc.fl.a aVar3 = arrayList.get(size);
            if (!android.text.TextUtils.isEmpty(aVar3.b())) {
                if (!a(aVar3.b(), sb)) {
                    z = false;
                } else {
                    if (com.loc.gd.a(aVar3.b(), sb.toString())) {
                        aVar2 = aVar3;
                        aVar = aVar2;
                        break;
                    }
                    z = true;
                }
                a(aVar3.b(), (java.util.Hashtable<java.lang.String, java.lang.String>) hashtable);
                a(sb.toString(), (java.util.Hashtable<java.lang.String, java.lang.String>) hashtable2);
                hashtable3.clear();
                java.util.Iterator it = hashtable.keySet().iterator();
                while (it.hasNext()) {
                    hashtable3.put((java.lang.String) it.next(), "");
                }
                java.util.Iterator it2 = hashtable2.keySet().iterator();
                while (it2.hasNext()) {
                    hashtable3.put((java.lang.String) it2.next(), "");
                }
                java.util.Set keySet = hashtable3.keySet();
                double[] dArr = new double[keySet.size()];
                double[] dArr2 = new double[keySet.size()];
                java.util.Iterator it3 = keySet.iterator();
                int i = 0;
                while (it3 != null && it3.hasNext()) {
                    java.lang.String str2 = (java.lang.String) it3.next();
                    double d = 1.0d;
                    dArr[i] = hashtable.containsKey(str2) ? 1.0d : 0.0d;
                    if (!hashtable2.containsKey(str2)) {
                        d = 0.0d;
                    }
                    dArr2[i] = d;
                    i++;
                }
                keySet.clear();
                double[] a2 = a(dArr, dArr2);
                if (a2[0] < 0.800000011920929d) {
                    aVar2 = aVar3;
                    if (a2[c] < java.lang.Math.min(com.loc.fu.g(), 0.618d)) {
                        if (z && a2[0] >= java.lang.Math.min(com.loc.fu.g(), 0.618d)) {
                        }
                    }
                    aVar = aVar2;
                    break;
                }
                aVar2 = aVar3;
                aVar = aVar2;
                break;
            }
            size--;
            c = 1;
        }
        aVar = null;
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return aVar;
    }

    private java.lang.String a(java.lang.String str, java.lang.StringBuilder sb, android.content.Context context) {
        java.lang.String str2;
        if (context == null) {
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            this.l = com.loc.gd.l(context);
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            java.lang.String substring = str.substring(str.lastIndexOf("#") + 1);
            if (substring.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!android.text.TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
                java.lang.String[] split = sb.toString().split(",access");
                if (split[0].contains("#")) {
                    java.lang.String str3 = split[0];
                    str2 = str3.substring(str3.lastIndexOf("#") + 1);
                } else {
                    str2 = split[0];
                }
                jSONObject.put("mmac", str2);
            }
            return com.loc.q.b(com.loc.fk.a(jSONObject.toString().getBytes("UTF-8"), this.l));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01a0 A[Catch: all -> 0x00c4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:121:0x00bd, B:39:0x00e6, B:41:0x0100, B:42:0x0104, B:43:0x0119, B:45:0x0129, B:49:0x01b8, B:51:0x01be, B:53:0x01ea, B:54:0x01f7, B:93:0x01fc, B:100:0x0108, B:102:0x010e, B:108:0x0159, B:109:0x016c, B:113:0x01a0, B:117:0x0176), top: B:120:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #1 {all -> 0x00c4, blocks: (B:121:0x00bd, B:39:0x00e6, B:41:0x0100, B:42:0x0104, B:43:0x0119, B:45:0x0129, B:49:0x01b8, B:51:0x01be, B:53:0x01ea, B:54:0x01f7, B:93:0x01fc, B:100:0x0108, B:102:0x010e, B:108:0x0159, B:109:0x016c, B:113:0x01a0, B:117:0x0176), top: B:120:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0271 A[LOOP:0: B:36:0x00cf->B:60:0x0271, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0261 A[EDGE_INSN: B:61:0x0261->B:62:0x0261 BREAK  A[LOOP:0: B:36:0x00cf->B:60:0x0271], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x029b A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a0 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(android.content.Context context, java.lang.String str, boolean z) throws java.lang.Exception {
        android.database.Cursor cursor;
        int i;
        android.database.sqlite.SQLiteDatabase openOrCreateDatabase;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        java.lang.String str2;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        java.lang.StringBuilder sb;
        java.lang.String str3;
        java.lang.StringBuilder sb2;
        if (com.loc.fu.e() && context != null) {
            android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = null;
            try {
                i = 0;
                openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                try {
                    try {
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor = null;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    sQLiteDatabase = openOrCreateDatabase;
                    cursor = null;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (!com.loc.gd.a(openOrCreateDatabase, "hist")) {
                if (openOrCreateDatabase == null || !openOrCreateDatabase.isOpen()) {
                    return;
                }
                openOrCreateDatabase.close();
                return;
            }
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            if (z) {
                long a2 = com.loc.gd.a() - com.baidu.mobads.sdk.internal.bm.e;
                sb3.append("time >");
                sb3.append(a2);
                if (str != null) {
                    sb3.append(" and feature = '");
                    str2 = str + "'";
                    sb3.append(str2);
                }
                cursor = openOrCreateDatabase.query("hist" + this.k, new java.lang.String[]{org.apache.tools.ant.taskdefs.condition.ParserSupports.FEATURE, " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                if (this.l == null) {
                }
                if (cursor == null) {
                }
                sQLiteDatabase = openOrCreateDatabase;
                if (cursor != null) {
                }
                if (sQLiteDatabase.isOpen()) {
                }
            } else {
                long a3 = com.loc.gd.a() - com.loc.fu.d();
                sb3.append("time >");
                sb3.append(a3);
                if (str != null) {
                    sb3.append(" and feature = '");
                    str2 = str + "'";
                    sb3.append(str2);
                }
                cursor = openOrCreateDatabase.query("hist" + this.k, new java.lang.String[]{org.apache.tools.ant.taskdefs.condition.ParserSupports.FEATURE, " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                try {
                    java.lang.StringBuilder sb42 = new java.lang.StringBuilder();
                    if (this.l == null) {
                        try {
                            this.l = com.loc.gd.l(context);
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            sQLiteDatabase2 = openOrCreateDatabase;
                            com.loc.fv.a(th, "DB", "fetchHist p2");
                        }
                    }
                    if (cursor == null && cursor.moveToFirst()) {
                        while (true) {
                            java.lang.String str4 = ",access";
                            if (cursor.getString(i).startsWith("{")) {
                                jSONObject2 = new org.json.JSONObject(cursor.getString(i));
                                sb42.delete(i, sb42.length());
                                if (android.text.TextUtils.isEmpty(cursor.getString(1))) {
                                    if (com.loc.gd.a(jSONObject2, "mmac")) {
                                        sb42.append("#");
                                        sb42.append(jSONObject2.getString("mmac"));
                                    }
                                    jSONObject = new org.json.JSONObject(cursor.getString(2));
                                    if (com.loc.gd.a(jSONObject, "type")) {
                                        jSONObject.put("type", "new");
                                    }
                                } else {
                                    str4 = cursor.getString(1);
                                }
                                sb42.append(str4);
                                jSONObject = new org.json.JSONObject(cursor.getString(2));
                                if (com.loc.gd.a(jSONObject, "type")) {
                                }
                            } else {
                                org.json.JSONObject jSONObject3 = new org.json.JSONObject(new java.lang.String(com.loc.fk.b(com.loc.q.b(cursor.getString(i)), this.l), "UTF-8"));
                                sb42.delete(0, sb42.length());
                                if (android.text.TextUtils.isEmpty(cursor.getString(1))) {
                                    if (com.loc.gd.a(jSONObject3, "mmac")) {
                                        sb42.append("#");
                                        sb42.append(jSONObject3.getString("mmac"));
                                    }
                                    jSONObject = new org.json.JSONObject(new java.lang.String(com.loc.fk.b(com.loc.q.b(cursor.getString(2)), this.l), "UTF-8"));
                                    if (com.loc.gd.a(jSONObject, "type")) {
                                        jSONObject.put("type", "new");
                                    }
                                    jSONObject2 = jSONObject3;
                                } else {
                                    str4 = new java.lang.String(com.loc.fk.b(com.loc.q.b(cursor.getString(1)), this.l), "UTF-8");
                                }
                                sb42.append(str4);
                                jSONObject = new org.json.JSONObject(new java.lang.String(com.loc.fk.b(com.loc.q.b(cursor.getString(2)), this.l), "UTF-8"));
                                if (com.loc.gd.a(jSONObject, "type")) {
                                }
                                jSONObject2 = jSONObject3;
                            }
                            com.loc.ey eyVar = new com.loc.ey("");
                            eyVar.b(jSONObject);
                            try {
                                if (com.loc.gd.a(jSONObject2, "mmac") && com.loc.gd.a(jSONObject2, "cgi")) {
                                    java.lang.String str5 = (jSONObject2.getString("cgi") + "#") + "network#";
                                    if (jSONObject2.getString("cgi").contains("#")) {
                                        sb2 = new java.lang.StringBuilder();
                                        sb2.append(str5);
                                        sb2.append("cgiwifi");
                                    } else {
                                        sb2 = new java.lang.StringBuilder();
                                        sb2.append(str5);
                                        sb2.append(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                                    }
                                    str3 = sb2.toString();
                                } else {
                                    if (com.loc.gd.a(jSONObject2, "cgi")) {
                                        java.lang.String str6 = (jSONObject2.getString("cgi") + "#") + "network#";
                                        if (jSONObject2.getString("cgi").contains("#")) {
                                            str3 = str6 + "cgi";
                                        }
                                    }
                                    sb = sb3;
                                    sQLiteDatabase = openOrCreateDatabase;
                                    if (cursor.moveToNext()) {
                                        break;
                                    }
                                    sb3 = sb;
                                    openOrCreateDatabase = sQLiteDatabase;
                                    i = 0;
                                }
                                a(str3, sb42, eyVar, context, false);
                                if (cursor.moveToNext()) {
                                }
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                            }
                            sb = sb3;
                            sQLiteDatabase = openOrCreateDatabase;
                        }
                        sb42.delete(0, sb42.length());
                        sb.delete(0, sb.length());
                    } else {
                        sQLiteDatabase = openOrCreateDatabase;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase.isOpen()) {
                        return;
                    }
                    sQLiteDatabase.close();
                    return;
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    sQLiteDatabase = openOrCreateDatabase;
                }
            }
            th = th2;
            sQLiteDatabase = openOrCreateDatabase;
            cursor = null;
            sQLiteDatabase2 = sQLiteDatabase;
            try {
                com.loc.fv.a(th, "DB", "fetchHist p2");
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                    sQLiteDatabase2.close();
                }
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    private void a(java.lang.String str, com.amap.api.location.AMapLocation aMapLocation, java.lang.StringBuilder sb, android.content.Context context) throws java.lang.Exception {
        if (context == null) {
            return;
        }
        if (this.l == null) {
            this.l = com.loc.gd.l(context);
        }
        java.lang.String a2 = a(str, sb, context);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            java.lang.Object[] objArr = new java.lang.Object[4];
            objArr[0] = a2;
            byte[] a3 = com.loc.fk.a(sb.toString().getBytes("UTF-8"), this.l);
            objArr[1] = a3;
            objArr[2] = com.loc.fk.a(aMapLocation.toStr().getBytes("UTF-8"), this.l);
            objArr[3] = java.lang.Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = com.loc.q.b((byte[]) objArr[i]);
            }
            sQLiteDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.loc.fv.a(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (java.lang.Throwable th2) {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    private static void a(java.lang.String str, java.util.Hashtable<java.lang.String, java.lang.String> hashtable) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (java.lang.String str2 : str.split("#")) {
            if (!android.text.TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    private boolean a(com.loc.ey eyVar, boolean z) {
        if (a(z)) {
            return eyVar == null || com.loc.fu.a(eyVar.getTime()) || z;
        }
        return false;
    }

    private static boolean a(java.lang.String str, com.loc.ey eyVar) {
        if (android.text.TextUtils.isEmpty(str) || !com.loc.gd.a(eyVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private static boolean a(java.lang.String str, java.lang.StringBuilder sb) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        java.lang.String[] split = str.split(",access");
        if (split[0].contains("#")) {
            java.lang.String str3 = split[0];
            str2 = str3.substring(str3.lastIndexOf("#") + 1);
        } else {
            str2 = split[0];
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return sb.toString().contains(str2 + ",access");
    }

    private boolean a(boolean z) {
        if (com.loc.fu.e() || z) {
            return this.b || com.loc.fu.f() || z;
        }
        return false;
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            double d4 = dArr[i3];
            d2 += d4 * d4;
            double d5 = dArr2[i3];
            d3 += d5 * d5;
            d += d4 * d5;
            if (d5 == 1.0d) {
                i2++;
                if (d4 == 1.0d) {
                    i++;
                }
            }
        }
        dArr3[0] = d / (java.lang.Math.sqrt(d2) * java.lang.Math.sqrt(d3));
        double d6 = i;
        dArr3[1] = (d6 * 1.0d) / i2;
        dArr3[2] = d6;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    private boolean b() {
        long b = com.loc.gd.b();
        long j = this.i;
        long j2 = b - j;
        if (j == 0) {
            return false;
        }
        return this.a.size() > 360 || j2 > com.baidu.mobads.sdk.internal.bm.e;
    }

    private void c() {
        this.i = 0L;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.j = false;
    }

    private void c(android.content.Context context) throws java.lang.Exception {
        boolean isOpen;
        if (context == null) {
            return;
        }
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!com.loc.gd.a(sQLiteDatabase, "hist")) {
                if (sQLiteDatabase != null) {
                    if (isOpen) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            try {
                sQLiteDatabase.delete("hist" + this.k, "time<?", new java.lang.String[]{java.lang.String.valueOf(com.loc.gd.a() - com.baidu.mobads.sdk.internal.bm.e)});
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "DB", "clearHist");
                java.lang.String message = th.getMessage();
                if (!android.text.TextUtils.isEmpty(message)) {
                    message.contains("no such table");
                }
            }
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
            sQLiteDatabase.close();
        } catch (java.lang.Throwable th2) {
            try {
                com.loc.fv.a(th2, "DB", "clearHist p2");
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabase.close();
            } finally {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    public final com.loc.ey a(android.content.Context context, java.lang.String str, java.lang.StringBuilder sb, boolean z, boolean z2) {
        if (android.text.TextUtils.isEmpty(str) || !com.loc.fu.e()) {
            return null;
        }
        java.lang.String str2 = str + "&" + this.f + "&" + this.g + "&" + this.h;
        if (str2.contains(com.amap.api.services.geocoder.GeocodeSearch.GPS) || !com.loc.fu.e() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.j) {
            try {
                java.lang.String a2 = a(str2, sb, context);
                c();
                a(context, a2, z2);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        return a(str2, sb, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00df A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008d A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:6:0x000f, B:8:0x0015, B:12:0x0029, B:20:0x004b, B:24:0x0053, B:26:0x0061, B:32:0x0086, B:33:0x008f, B:35:0x0093, B:37:0x0099, B:39:0x00a4, B:42:0x00c5, B:44:0x00d4, B:52:0x00e5, B:57:0x00a8, B:58:0x00ac, B:60:0x00b1, B:62:0x00b5, B:63:0x00ba, B:64:0x008d, B:65:0x0073, B:67:0x0079, B:73:0x0019, B:75:0x001d), top: B:5:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.loc.ey a(com.loc.fd fdVar, boolean z, com.loc.ey eyVar, com.loc.fj fjVar, java.lang.StringBuilder sb, java.lang.String str, android.content.Context context, boolean z2) {
        com.loc.fc e;
        com.loc.fc fcVar;
        boolean z3;
        boolean z4;
        boolean z5;
        java.lang.String str2;
        long a2;
        java.lang.String str3;
        com.loc.ey a3;
        java.lang.String str4;
        if (!a(eyVar, z2)) {
            return null;
        }
        try {
            e = fdVar.e();
        } catch (java.lang.Throwable unused) {
        }
        if ((e == null && this.e == null) || ((fcVar = this.e) != null && fcVar.equals(e))) {
            z3 = false;
            if (eyVar == null) {
                z4 = eyVar.getAccuracy() > 299.0f && fjVar.e().size() > 5;
            } else {
                z4 = false;
            }
            if (eyVar != null || (str4 = this.d) == null || z4 || z3) {
                z5 = false;
            } else {
                z5 = com.loc.gd.a(str4, sb.toString());
                boolean z6 = this.c != 0 && com.loc.gd.b() - this.c < 3000;
                if ((z5 || z6) && com.loc.gd.a(eyVar)) {
                    eyVar.e("mem");
                    eyVar.setLocationType(2);
                    return eyVar;
                }
            }
            if (z5) {
                this.c = com.loc.gd.b();
            } else {
                this.c = 0L;
            }
            str2 = this.m;
            if (str2 != null || str.equals(str2)) {
                if (this.m == null) {
                    this.n = com.loc.gd.a();
                    str3 = str;
                    a3 = (!z4 || z) ? null : a(context, str3, sb, false, false);
                    if (!(z && !com.loc.gd.a(a3)) || z4 || z) {
                        return null;
                    }
                    this.c = 0L;
                    a3.setLocationType(4);
                    return a3;
                }
                a2 = com.loc.gd.a();
            } else {
                if (com.loc.gd.a() - this.n < 3000) {
                    str3 = this.m;
                    if (z4) {
                    }
                    if (z && !com.loc.gd.a(a3)) {
                    }
                    return null;
                }
                a2 = com.loc.gd.a();
            }
            this.n = a2;
            this.m = str;
            str3 = str;
            if (z4) {
            }
            if (z && !com.loc.gd.a(a3)) {
            }
            return null;
        }
        z3 = true;
        if (eyVar == null) {
        }
        if (eyVar != null) {
        }
        z5 = false;
        if (z5) {
        }
        str2 = this.m;
        if (str2 != null) {
        }
        if (this.m == null) {
        }
    }

    public final void a() {
        this.c = 0L;
        this.d = null;
    }

    public final void a(android.content.Context context) {
        if (this.j) {
            return;
        }
        try {
            c();
            a(context, (java.lang.String) null, false);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Cache", "loadDB");
        }
        this.j = true;
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = java.lang.String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(com.loc.fc fcVar) {
        this.e = fcVar;
    }

    public final void a(java.lang.String str) {
        this.d = str;
    }

    public final void a(java.lang.String str, java.lang.StringBuilder sb, com.loc.ey eyVar, android.content.Context context, boolean z) {
        try {
            if (com.loc.gd.a(eyVar)) {
                java.lang.String str2 = str + "&" + eyVar.isOffset() + "&" + eyVar.i() + "&" + eyVar.j();
                if (!a(str2, eyVar) || eyVar.e().equals("mem") || eyVar.e().equals("file") || eyVar.e().equals("wifioff") || "-3".equals(eyVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                org.json.JSONObject f = eyVar.f();
                if (com.loc.gd.a(f, "offpct")) {
                    f.remove("offpct");
                    eyVar.a(f);
                }
                if (str2.contains(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)) {
                    if (android.text.TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (eyVar.getAccuracy() >= 300.0f) {
                        int i = 0;
                        for (java.lang.String str3 : sb.toString().split("#")) {
                            if (str3.contains(",")) {
                                i++;
                            }
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (eyVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !android.text.TextUtils.isEmpty(eyVar.g())) {
                        java.lang.String replace = str2.replace("cgiwifi", "cgi");
                        com.loc.ey h = eyVar.h();
                        if (com.loc.gd.a(h)) {
                            a(replace, new java.lang.StringBuilder(), h, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(eyVar.d()))) {
                    return;
                }
                com.loc.ey a2 = a(str2, sb, false);
                if (com.loc.gd.a(a2) && a2.toStr().equals(eyVar.toStr(3))) {
                    return;
                }
                this.i = com.loc.gd.b();
                com.loc.fl.a aVar = new com.loc.fl.a();
                aVar.a(eyVar);
                aVar.a(android.text.TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.a.containsKey(str2)) {
                    this.a.get(str2).add(aVar);
                } else {
                    java.util.ArrayList<com.loc.fl.a> arrayList = new java.util.ArrayList<>();
                    arrayList.add(aVar);
                    this.a.put(str2, arrayList);
                }
                if (z) {
                    try {
                        a(str2, eyVar, sb, context);
                    } catch (java.lang.Throwable th) {
                        com.loc.fv.a(th, "Cache", com.anythink.expressad.d.a.b.ay);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "Cache", com.anythink.expressad.d.a.b.ay);
        }
    }

    public final void b(android.content.Context context) {
        try {
            c();
            c(context);
            this.j = false;
            this.d = null;
            this.n = 0L;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Cache", "destroy part");
        }
    }
}
