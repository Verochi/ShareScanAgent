package com.igexin.push.core.c;

import com.igexin.push.core.e.f.AnonymousClass12;

/* loaded from: classes23.dex */
public final class a implements com.igexin.push.core.e.a {
    private static final java.lang.String a = "BIDataManager";
    private static com.igexin.push.core.c.a b;

    /* renamed from: com.igexin.push.core.c.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.g.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.g.d
        public final void b() {
            try {
                com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis != com.igexin.push.core.e.R) {
                    com.igexin.push.core.e.R = currentTimeMillis;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass12(), false, true);
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.igexin.push.core.c.a.a(com.igexin.push.core.c.a.this, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("action", "reportapplist");
                    jSONObject.put("session_last", com.igexin.push.core.e.z);
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        jSONObject2.put("appid", ((com.igexin.push.core.b.v) arrayList.get(i)).c);
                        jSONObject2.put("name", ((com.igexin.push.core.b.v) arrayList.get(i)).a);
                        jSONObject2.put("version", ((com.igexin.push.core.b.v) arrayList.get(i)).b);
                        jSONObject2.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME, ((com.igexin.push.core.b.v) arrayList.get(i)).d);
                        jSONObject2.put("notificationEnabled", ((com.igexin.push.core.b.v) arrayList.get(i)).e);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("applist", jSONArray);
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.g.a.a(new com.igexin.push.core.h.a(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
                com.igexin.c.a.c.a.a("reportAL", new java.lang.Object[0]);
                if (com.igexin.push.config.d.ak) {
                    com.igexin.c.a.c.a.a("reportAL = " + jSONObject.toString(), new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.core.c.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.igexin.push.core.b.v> {
        public AnonymousClass2() {
        }

        private static int a(com.igexin.push.core.b.v vVar, com.igexin.push.core.b.v vVar2) {
            if (vVar.c.equals(vVar2.c)) {
                return 0;
            }
            return vVar.c.compareTo(vVar2.c);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.igexin.push.core.b.v vVar, com.igexin.push.core.b.v vVar2) {
            com.igexin.push.core.b.v vVar3 = vVar;
            com.igexin.push.core.b.v vVar4 = vVar2;
            if (vVar3.c.equals(vVar4.c)) {
                return 0;
            }
            return vVar3.c.compareTo(vVar4.c);
        }
    }

    private static int a(android.content.pm.ApplicationInfo applicationInfo, android.app.AppOpsManager appOpsManager, android.content.pm.PackageManager packageManager) {
        try {
            if (applicationInfo.packageName.equals(com.igexin.push.core.e.g)) {
                return com.igexin.push.h.c.b(com.igexin.push.core.e.l) ? 1 : 0;
            }
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 31 || !com.igexin.push.config.d.ai) {
                return -1;
            }
            if (i >= 33 && applicationInfo.targetSdkVersion >= 33) {
                try {
                    return packageManager.checkPermission("android.permission.POST_NOTIFICATIONS", applicationInfo.packageName) == 0 ? 1 : 0;
                } catch (java.lang.Throwable unused) {
                    java.lang.String[] strArr = com.igexin.push.h.k.a(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr == null || !new java.util.HashSet(java.util.Arrays.asList(strArr)).contains("android.permission.POST_NOTIFICATIONS")) {
                        return 0;
                    }
                }
            }
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            int intValue = ((java.lang.Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(java.lang.Integer.class)).intValue();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(intValue), java.lang.Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue() != 0 ? 0 : 1;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static long a(java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("type", (java.lang.Integer) 10);
        contentValues.put("data", str);
        contentValues.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        return com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, contentValues);
    }

    public static com.igexin.push.core.c.a a() {
        if (b == null) {
            b = new com.igexin.push.core.c.a();
        }
        return b;
    }

    public static /* synthetic */ void a(com.igexin.push.core.c.a aVar, java.util.List list) {
        com.igexin.push.core.c.a.AnonymousClass2 anonymousClass2 = aVar.new AnonymousClass2();
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) com.igexin.push.core.e.l.getSystemService("appops");
        android.content.pm.PackageManager packageManager = com.igexin.push.core.e.l.getPackageManager();
        java.util.List<android.content.pm.PackageInfo> a2 = com.igexin.push.h.n.a();
        for (int i = 0; i < a2.size(); i++) {
            try {
                android.content.pm.PackageInfo packageInfo = a2.get(i);
                android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    com.igexin.push.core.b.v vVar = new com.igexin.push.core.b.v();
                    vVar.a = applicationInfo.loadLabel(packageManager).toString();
                    vVar.c = applicationInfo.packageName;
                    vVar.b = java.lang.String.valueOf(packageInfo.versionCode);
                    vVar.d = packageInfo.versionName;
                    vVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(vVar);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        java.util.Collections.sort(list, anonymousClass2);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            if (android.text.TextUtils.isEmpty(str) || com.igexin.push.core.b.m.equals(str) || !com.igexin.push.config.d.R.booleanValue()) {
                return;
            }
            if ((java.lang.System.currentTimeMillis() - com.igexin.push.core.e.aw) - (com.igexin.push.config.d.S * 1000) < 0) {
                com.igexin.c.a.c.a.b(a, "type253 in Interval = " + com.igexin.push.config.d.S);
                return;
            }
            com.igexin.c.a.c.a.a(a, "start up id type253Enable = " + com.igexin.push.config.d.R + " ，type253Interval = " + com.igexin.push.config.d.S);
            java.lang.String m = com.igexin.push.h.n.m();
            java.lang.String h = com.igexin.push.h.n.h();
            java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(format);
            sb.append("|");
            sb.append(com.igexin.push.core.e.C);
            sb.append("|");
            sb.append(com.igexin.push.core.e.a);
            sb.append("|");
            sb.append(str);
            sb.append("|");
            if (h == null || com.igexin.push.core.b.m.equals(h)) {
                h = "";
            }
            sb.append(h);
            sb.append("|");
            if (m == null || com.igexin.push.core.b.m.equals(m)) {
                m = "";
            }
            sb.append(m);
            sb.append("|");
            sb.append(str2);
            java.lang.String sb2 = sb.toString();
            com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl();
            com.igexin.c.a.c.a.a("BIDataManager| upload253 = ".concat(java.lang.String.valueOf(sb2)), new java.lang.Object[0]);
            byte[] bytes = sb2.getBytes();
            com.igexin.push.core.e.f.a().d(java.lang.System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.g.a.a(new com.igexin.push.core.h.d(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), bytes, com.igexin.push.config.c.E)), false, true);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.util.ArrayList<java.lang.String> arrayList) {
        com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{"id"}, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    private void a(java.util.List<com.igexin.push.core.b.v> list) {
        com.igexin.push.core.c.a.AnonymousClass2 anonymousClass2 = new com.igexin.push.core.c.a.AnonymousClass2();
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) com.igexin.push.core.e.l.getSystemService("appops");
        android.content.pm.PackageManager packageManager = com.igexin.push.core.e.l.getPackageManager();
        java.util.List<android.content.pm.PackageInfo> a2 = com.igexin.push.h.n.a();
        for (int i = 0; i < a2.size(); i++) {
            try {
                android.content.pm.PackageInfo packageInfo = a2.get(i);
                android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    com.igexin.push.core.b.v vVar = new com.igexin.push.core.b.v();
                    vVar.a = applicationInfo.loadLabel(packageManager).toString();
                    vVar.c = applicationInfo.packageName;
                    vVar.b = java.lang.String.valueOf(packageInfo.versionCode);
                    vVar.d = packageInfo.versionName;
                    vVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(vVar);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        java.util.Collections.sort(list, anonymousClass2);
    }

    public static void b() {
        java.lang.String str;
        if (!com.igexin.push.h.c.e()) {
            str = " upload type144 network false";
        } else if (com.igexin.push.config.d.V) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if ((currentTimeMillis - com.igexin.push.core.e.ay) - (com.igexin.push.config.d.W * 1000) >= 0) {
                try {
                    java.lang.String[] b2 = com.igexin.assist.sdk.a.a().b();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.A);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.a);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.C);
                    sb.append("|");
                    sb.append(com.igexin.push.config.d.T ? com.igexin.push.h.n.q() : "");
                    sb.append("|");
                    sb.append(com.igexin.push.h.n.d());
                    sb.append("|");
                    sb.append(com.igexin.assist.util.AssistUtils.getDeviceBrand().toLowerCase());
                    sb.append("|");
                    sb.append(b2[0]);
                    sb.append("|");
                    sb.append(b2[1]);
                    sb.append("|");
                    sb.append(com.igexin.push.h.n.n());
                    sb.append("|");
                    sb.append(com.igexin.push.h.n.o());
                    com.igexin.push.core.e.f.a().e(currentTimeMillis);
                    com.igexin.c.a.c.a.b("UploadBITask", "upload type144 data = " + sb.toString());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.g.a.a(new com.igexin.push.core.h.d(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes(), 144)), false, true);
                    return;
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
            }
            str = "type144 in Interval = " + com.igexin.push.config.d.W;
        } else {
            str = " isUpload type144 Enable false";
        }
        com.igexin.c.a.c.a.b(a, str);
    }

    private static void b(java.util.ArrayList<java.lang.String> arrayList) {
        com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{"rowid"}, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
    
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.igexin.push.core.b.c> c() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            cursor = com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{"type"}, new java.lang.String[]{com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ}, null, "");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.c(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3)));
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    private static void d() {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor a2 = com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, null, null, new java.lang.String[]{"COUNT(*)"}, null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            a2.moveToNext();
            long j = a2.getLong(0);
            a2.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(a, "delete bidata " + j2 + " old expired data");
            }
            a2.close();
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(boolean z) {
        long currentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.R;
        if (!z || currentTimeMillis - 86400000 >= 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(a);
            sb.append(z ? ", over 24h, start upload AL" : "data change start upload AL");
            com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.c.a.AnonymousClass1(), false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor a2 = com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, null, null, new java.lang.String[]{"COUNT(*)"}, null);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            a2.moveToNext();
            long j = a2.getLong(0);
            a2.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(a, "delete bidata " + j2 + " old expired data");
            }
            a2.close();
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
