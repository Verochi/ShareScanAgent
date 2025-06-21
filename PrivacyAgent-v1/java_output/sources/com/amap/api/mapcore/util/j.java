package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class j extends java.lang.Thread {
    java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> a;
    private android.content.Context b;

    /* renamed from: com.amap.api.mapcore.util.j$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.lang.String g;
        final /* synthetic */ java.lang.String h;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, boolean z, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = str3;
            this.e = str4;
            this.g = str5;
            this.h = str6;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            if (!android.text.TextUtils.isEmpty(this.a) && !android.text.TextUtils.isEmpty(this.b)) {
                boolean z = this.c;
                java.lang.String str = com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                java.lang.String str2 = this.b;
                java.lang.String str3 = this.a;
                java.lang.String str4 = this.d;
                if (z) {
                    com.amap.api.mapcore.util.k.d dVar = new com.amap.api.mapcore.util.k.d(str2, str3, str4, str);
                    dVar.a("amap_web_logo", "md5_day");
                    android.content.Context context = com.amap.api.mapcore.util.j.this.b;
                    com.amap.api.mapcore.util.dl.a();
                    new com.amap.api.mapcore.util.k(context, dVar).a();
                }
                java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference = com.amap.api.mapcore.util.j.this.a;
                if (weakReference != null && weakReference.get() != null) {
                    com.amap.api.mapcore.util.j.this.a.get().changeLogoIconStyle(str, z, 0);
                }
            }
            if (android.text.TextUtils.isEmpty(this.e) || android.text.TextUtils.isEmpty(this.g)) {
                return;
            }
            boolean z2 = this.c;
            java.lang.String str5 = com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            java.lang.String str6 = this.g;
            java.lang.String str7 = this.e;
            java.lang.String str8 = this.h;
            if (z2) {
                com.amap.api.mapcore.util.k.d dVar2 = new com.amap.api.mapcore.util.k.d(str6, str7, str8, str5);
                dVar2.a("amap_web_logo", "md5_night");
                android.content.Context context2 = com.amap.api.mapcore.util.j.this.b;
                com.amap.api.mapcore.util.dl.a();
                new com.amap.api.mapcore.util.k(context2, dVar2).a();
            }
            java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference2 = com.amap.api.mapcore.util.j.this.a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            com.amap.api.mapcore.util.j.this.a.get().changeLogoIconStyle(str5, z2, 1);
        }
    }

    public j(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.a = null;
        this.b = context;
        this.a = new java.lang.ref.WeakReference<>(iAMapDelegate);
    }

    private android.util.Pair<org.json.JSONObject, com.amap.api.mapcore.util.ew.a.C0122a> a(java.lang.StringBuilder sb) {
        java.lang.String str;
        org.json.JSONObject jSONObject;
        com.amap.api.mapcore.util.ew.a.C0122a c0122a;
        java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference;
        try {
            long longValue = com.amap.api.mapcore.util.db.a(this.b, "cloud_config_pull", "cloud_config_pull_timestamp", (java.lang.Long) 0L).longValue();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (java.lang.Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", com.alipay.sdk.m.u.i.b);
                com.amap.api.mapcore.util.db.a(this.b, "cloud_config_pull", "cloud_config_pull_timestamp", (java.lang.Object) new java.lang.Long(currentTimeMillis));
            } else {
                str = "";
            }
            com.amap.api.mapcore.util.ew.a a = com.amap.api.mapcore.util.ew.a(this.b, com.amap.api.mapcore.util.dl.a(), str, (java.util.Map<java.lang.String, java.lang.String>) null);
            if (com.amap.api.mapcore.util.ew.a != 1 && str != "" && a != null && (weakReference = this.a) != null && weakReference.get() != null) {
                android.os.Message obtainMessage = this.a.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                java.lang.String str2 = a.c;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.a.get().getMainHandler().sendMessage(obtainMessage);
            }
            java.lang.String str3 = com.autonavi.base.amap.mapcore.tools.GLFileUtil.getCacheDir(this.b).getAbsolutePath() + "/authCustomConfigName";
            if (android.text.TextUtils.isEmpty(str) || a == null || (jSONObject = a.f) == null) {
                jSONObject = new org.json.JSONObject(new java.lang.String(com.autonavi.base.amap.mapcore.tools.GLFileUtil.readFileContents(str3)));
            } else {
                com.autonavi.base.amap.mapcore.tools.GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            }
            java.lang.String str4 = com.autonavi.base.amap.mapcore.tools.GLFileUtil.getCacheDir(this.b).getAbsolutePath() + "/authLogConfigName";
            if (android.text.TextUtils.isEmpty(str) || a == null || a.g == null) {
                byte[] readFileContents = com.autonavi.base.amap.mapcore.tools.GLFileUtil.readFileContents(str4);
                com.amap.api.mapcore.util.ew.a.C0122a c0122a2 = new com.amap.api.mapcore.util.ew.a.C0122a();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(new java.lang.String(readFileContents));
                c0122a2.a = jSONObject2.getBoolean("IsExceptionUpdate");
                if (jSONObject2.has("mOfflineLoc")) {
                    c0122a2.c = jSONObject2.getJSONObject("mOfflineLoc");
                }
                c0122a = c0122a2;
            } else {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("IsExceptionUpdate", a.g.a);
                jSONObject3.put("mOfflineLoc", a.g.c);
                com.autonavi.base.amap.mapcore.tools.GLFileUtil.writeDatasToFile(str4, jSONObject3.toString().getBytes());
                c0122a = a.g;
            }
            return new android.util.Pair<>(jSONObject, c0122a);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean a = com.amap.api.mapcore.util.ew.a(optJSONObject.optString(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, ""), false);
            java.lang.String optString = optJSONObject.optString("dis", "");
            boolean a2 = com.amap.api.mapcore.util.ew.a(optJSONObject.optString("able", ""), false);
            boolean a3 = com.amap.api.mapcore.util.ew.a(optJSONObject.optString("isFilter", ""), true);
            if (!a || com.amap.api.mapcore.util.fi.f(optString)) {
                com.amap.api.mapcore.util.gl.a(fhVar).a(context, a2, a3);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void a(com.amap.api.mapcore.util.ew.a.C0122a c0122a) {
        if (c0122a != null) {
            try {
                com.amap.api.mapcore.util.dh.a(this.b, "maploc", "ue", java.lang.Boolean.valueOf(c0122a.a));
                org.json.JSONObject jSONObject = c0122a.c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                com.amap.api.mapcore.util.hp.a(optInt, com.amap.api.mapcore.util.ew.a(jSONObject.optString("igu"), false));
                com.amap.api.mapcore.util.dh.a(this.b, "maploc", "opn", java.lang.Integer.valueOf(optInt2));
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private static void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.dn.a(jSONObject.optJSONObject("17E"));
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void b(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean a = com.amap.api.mapcore.util.ew.a(optJSONObject.optString("able", ""), false);
            boolean a2 = com.amap.api.mapcore.util.ew.a(optJSONObject.optString("removeCache", ""), false);
            boolean a3 = com.amap.api.mapcore.util.ew.a(optJSONObject.optString("uploadInfo", ""), false);
            com.amap.api.mapcore.util.dc.a(a);
            com.amap.api.mapcore.util.dc.b(a2);
            com.amap.api.mapcore.util.dc.c(a3);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void c(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.db.a(this.b, "amap_param", "overlay_use_old_type", java.lang.Boolean.valueOf(com.amap.api.mapcore.util.ew.a(jSONObject.optJSONObject("17W").optString("able", ""), false) ? false : true));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02a1 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x024b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019b A[Catch: all -> 0x02b3, TRY_LEAVE, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d6 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ef A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0202 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0272 A[Catch: all -> 0x02b3, TRY_ENTER, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027d A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0288 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00bc, B:25:0x00c5, B:27:0x00c9, B:29:0x00d1, B:31:0x00db, B:34:0x00ef, B:35:0x00f4, B:37:0x00fa, B:38:0x00ff, B:40:0x0105, B:42:0x010c, B:44:0x0110, B:46:0x0116, B:48:0x0121, B:53:0x019b, B:71:0x01d1, B:73:0x01d6, B:75:0x01da, B:77:0x01e2, B:79:0x01ef, B:81:0x01f3, B:83:0x0202, B:85:0x0206, B:87:0x020e, B:90:0x0272, B:92:0x0276, B:94:0x027d, B:96:0x0281, B:98:0x0288, B:100:0x028c, B:101:0x0291, B:103:0x02a1, B:105:0x02a7, B:147:0x0193, B:56:0x019f, B:58:0x01a7, B:60:0x01ad, B:62:0x01b9, B:64:0x01bf, B:67:0x01cc), top: B:2:0x0016, inners: #0 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        java.lang.Object obj;
        org.json.JSONObject optJSONObject;
        java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference;
        java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference2;
        java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference3;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4;
        java.lang.Object obj5;
        org.json.JSONObject optJSONObject2;
        java.lang.Object obj6;
        org.json.JSONObject optJSONObject3;
        java.lang.Object obj7;
        org.json.JSONObject optJSONObject4;
        boolean a;
        java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference4;
        com.amap.api.mapcore.util.fh a2;
        java.lang.Object obj8;
        org.json.JSONObject optJSONObject5;
        try {
            if (com.amap.api.maps.MapsInitializer.getNetWorkEnable()) {
                com.amap.api.mapcore.util.fb.a().a(this.b);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("14S");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("11K");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("001");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("14M");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("14L");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("16V");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("14Z");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("154");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("156");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("15C");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("16G");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("17W");
                sb.append(com.alipay.sdk.m.u.i.b);
                sb.append("17E");
                try {
                    java.lang.ref.WeakReference<com.autonavi.base.amap.api.mapcore.IAMapDelegate> weakReference5 = this.a;
                    if (weakReference5 != null && weakReference5.get() != null) {
                        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a.get();
                        if (iAMapDelegate.getAMapExtraInterfaceManager() != null) {
                            java.lang.String g = iAMapDelegate.getAMapExtraInterfaceManager().g();
                            if (!android.text.TextUtils.isEmpty(g)) {
                                if (g.indexOf(com.alipay.sdk.m.u.i.b) == 0) {
                                    sb.append(g);
                                } else {
                                    sb.append(com.alipay.sdk.m.u.i.b);
                                    sb.append(g);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
                android.util.Pair<org.json.JSONObject, com.amap.api.mapcore.util.ew.a.C0122a> a3 = a(sb);
                if (a3 != null && (obj8 = a3.first) != null && (optJSONObject5 = ((org.json.JSONObject) obj8).optJSONObject("154")) != null && com.amap.api.mapcore.util.ew.a(optJSONObject5.getString("able"), true)) {
                    java.lang.String optString = optJSONObject5.optString(com.umeng.analytics.pro.bo.A);
                    java.lang.String optString2 = optJSONObject5.optString("si");
                    java.lang.String optString3 = optJSONObject5.optString("te");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        com.amap.api.mapcore.util.db.a(this.b, "approval_number", com.umeng.analytics.pro.bo.A, (java.lang.Object) optString);
                    }
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        com.amap.api.mapcore.util.db.a(this.b, "approval_number", "si", (java.lang.Object) optString2);
                    }
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        com.amap.api.mapcore.util.db.a(this.b, "approval_number", "te", (java.lang.Object) optString3);
                    }
                }
                if (a3 != null && a3.second != null && (a2 = com.amap.api.mapcore.util.dl.a()) != null) {
                    a2.a(((com.amap.api.mapcore.util.ew.a.C0122a) a3.second).a);
                }
                if (a3 != null) {
                    a((com.amap.api.mapcore.util.ew.a.C0122a) a3.second);
                }
                if (a3 != null) {
                    try {
                        obj = a3.first;
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                    if (obj != null && (optJSONObject = ((org.json.JSONObject) obj).optJSONObject("14M")) != null && optJSONObject.has("able")) {
                        try {
                            if (com.amap.api.mapcore.util.ew.a(optJSONObject.getString("able"), true)) {
                                if (java.lang.System.currentTimeMillis() - com.amap.api.mapcore.util.db.a(this.b, "Map3DCache", "time", (java.lang.Long) 0L).longValue() > (optJSONObject.has("time") ? java.lang.Math.max(60, optJSONObject.getInt("time")) : 2592000) * 1000 && (weakReference = this.a) != null && weakReference.get() != null) {
                                    this.a.get().clearTileCache();
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            if (a3 != null) {
                            }
                            com.amap.api.mapcore.util.gd.a(this.b, com.amap.api.mapcore.util.dl.a());
                            interrupt();
                            weakReference3 = this.a;
                            if (weakReference3 == null) {
                            }
                        }
                        if (a3 != null && (obj7 = a3.first) != null) {
                            try {
                                optJSONObject4 = ((org.json.JSONObject) obj7).optJSONObject("14L");
                                if (optJSONObject4 != null && optJSONObject4.has("able")) {
                                    a = com.amap.api.mapcore.util.ew.a(optJSONObject4.getString("able"), false);
                                    weakReference4 = this.a;
                                    if (weakReference4 != null && weakReference4.get() != null) {
                                        this.a.get().setHideLogoEnble(a);
                                    }
                                }
                            } catch (java.lang.Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (a3 != null && (obj6 = a3.first) != null && (optJSONObject3 = ((org.json.JSONObject) obj6).optJSONObject("156")) != null) {
                            com.amap.api.mapcore.util.cz.a(com.amap.api.mapcore.util.ew.a(optJSONObject3.optString("able"), false));
                        }
                        if (a3 != null && a3.first != null) {
                            a(this.b, com.amap.api.mapcore.util.dl.a(), (org.json.JSONObject) a3.first);
                        }
                        if (a3 != null && (obj5 = a3.first) != null && (optJSONObject2 = ((org.json.JSONObject) obj5).optJSONObject("15C")) != null) {
                            boolean a4 = com.amap.api.mapcore.util.ew.a(optJSONObject2.optString("able"), false);
                            com.amap.api.mapcore.util.dj.a().a(new com.amap.api.mapcore.util.j.AnonymousClass1(optJSONObject2.optString("logo_day_md5"), optJSONObject2.optString("logo_day_url"), a4, optJSONObject2.optString("logo_day_ipv6_url"), optJSONObject2.optString("logo_night_md5"), optJSONObject2.optString("logo_night_url"), optJSONObject2.optString("logo_night_ipv6_url")));
                        }
                        if (a3 != null) {
                            try {
                                if (a3.first != null && (weakReference2 = this.a) != null && weakReference2.get() != null) {
                                    com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate2 = this.a.get();
                                    if (iAMapDelegate2.getAMapExtraInterfaceManager() != null) {
                                        iAMapDelegate2.getAMapExtraInterfaceManager().h();
                                    }
                                }
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                        if (a3 != null && (obj4 = a3.first) != null) {
                            b((org.json.JSONObject) obj4);
                        }
                        if (a3 != null && (obj3 = a3.first) != null) {
                            c((org.json.JSONObject) obj3);
                        }
                        if (a3 != null && (obj2 = a3.first) != null) {
                            a((org.json.JSONObject) obj2);
                        }
                        com.amap.api.mapcore.util.gd.a(this.b, com.amap.api.mapcore.util.dl.a());
                        interrupt();
                        weakReference3 = this.a;
                        if (weakReference3 == null || weakReference3.get() == null) {
                        }
                        this.a.get().setRunLowFrame(false);
                        return;
                    }
                }
                if (a3 != null) {
                    optJSONObject4 = ((org.json.JSONObject) obj7).optJSONObject("14L");
                    if (optJSONObject4 != null) {
                        a = com.amap.api.mapcore.util.ew.a(optJSONObject4.getString("able"), false);
                        weakReference4 = this.a;
                        if (weakReference4 != null) {
                            this.a.get().setHideLogoEnble(a);
                        }
                    }
                }
                if (a3 != null) {
                    com.amap.api.mapcore.util.cz.a(com.amap.api.mapcore.util.ew.a(optJSONObject3.optString("able"), false));
                }
                if (a3 != null) {
                    a(this.b, com.amap.api.mapcore.util.dl.a(), (org.json.JSONObject) a3.first);
                }
                if (a3 != null) {
                    boolean a42 = com.amap.api.mapcore.util.ew.a(optJSONObject2.optString("able"), false);
                    com.amap.api.mapcore.util.dj.a().a(new com.amap.api.mapcore.util.j.AnonymousClass1(optJSONObject2.optString("logo_day_md5"), optJSONObject2.optString("logo_day_url"), a42, optJSONObject2.optString("logo_day_ipv6_url"), optJSONObject2.optString("logo_night_md5"), optJSONObject2.optString("logo_night_url"), optJSONObject2.optString("logo_night_ipv6_url")));
                }
                if (a3 != null) {
                }
                if (a3 != null) {
                    b((org.json.JSONObject) obj4);
                }
                if (a3 != null) {
                    c((org.json.JSONObject) obj3);
                }
                if (a3 != null) {
                    a((org.json.JSONObject) obj2);
                }
                com.amap.api.mapcore.util.gd.a(this.b, com.amap.api.mapcore.util.dl.a());
                interrupt();
                weakReference3 = this.a;
                if (weakReference3 == null) {
                }
            }
        } catch (java.lang.Throwable th4) {
            interrupt();
            com.amap.api.mapcore.util.gd.c(th4, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th4.printStackTrace();
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.e, "auth exception " + th4.getMessage());
        }
    }
}
