package com.getui.gtc.h.c;

/* loaded from: classes22.dex */
public final class b {
    private static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: com.getui.gtc.h.c.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;

        public AnonymousClass1(org.json.JSONObject jSONObject, long j, long j2) {
            this.a = jSONObject;
            this.b = j;
            this.c = j2;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(13:13|(10:14|15|16|17|18|19|20|21|22|23)|(7:27|28|(11:118|119|120|121|122|123|124|(1:126)|106|107|54)(4:30|31|32|(9:98|99|101|(1:103)|104|(1:108)|106|107|54)(19:34|35|36|37|38|39|40|41|42|43|44|45|46|(3:55|56|57)|48|(2:50|51)|52|53|54))|109|106|107|54)|138|139|140|141|(2:143|51)|52|53|54|9|10) */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x02c0, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x02f3, code lost:
        
            r21.delete();
            r0 = "file log upload delete old log file, fileName:" + r21.getName();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x02ea, code lost:
        
            r15.delete();
         */
        /* JADX WARN: Removed duplicated region for block: B:67:0x02f3 A[Catch: all -> 0x0309, TryCatch #5 {all -> 0x0309, blocks: (B:71:0x02ea, B:65:0x02ed, B:67:0x02f3, B:51:0x0306, B:48:0x0253, B:50:0x025c, B:141:0x02a6, B:143:0x02ac), top: B:70:0x02ea }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x02ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            java.lang.String str;
            java.lang.String[] strArr;
            java.io.File file;
            java.text.SimpleDateFormat simpleDateFormat;
            java.lang.String str2;
            java.text.SimpleDateFormat simpleDateFormat2;
            java.io.File file2;
            java.io.File file3;
            java.lang.String str3;
            java.lang.String format;
            java.io.File file4;
            java.io.File file5;
            java.lang.String str4;
            java.io.File b;
            com.getui.gtc.e.c cVar;
            java.lang.String str5 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            try {
                java.lang.String[] split = this.a.optString("suffixes").split(",");
                java.io.File externalFilesDir = com.getui.gtc.base.util.CommonUtil.getExternalFilesDir(com.getui.gtc.base.GtcProvider.context());
                java.lang.String packageName = com.getui.gtc.base.GtcProvider.context().getPackageName();
                java.text.SimpleDateFormat simpleDateFormat3 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
                java.text.SimpleDateFormat simpleDateFormat4 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
                java.lang.String str6 = "";
                try {
                    str6 = com.getui.gtc.h.d.a.a(packageName).versionName;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.b(th);
                }
                int length = split.length;
                boolean z = false;
                int i = 0;
                while (i < length) {
                    java.lang.String str7 = split[i];
                    boolean z2 = z;
                    int i2 = length;
                    int i3 = i;
                    long j = this.b;
                    int i4 = 7;
                    while (j > this.c && i4 > 0) {
                        int i5 = i4 - 1;
                        try {
                            format = simpleDateFormat3.format(new java.util.Date(j));
                            strArr = split;
                            try {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append(packageName);
                                sb.append(str5);
                                sb.append(str7);
                                sb.append(str5);
                                sb.append(format);
                                str = str5;
                                try {
                                    sb.append(com.anythink.china.common.a.a.f);
                                    file4 = new java.io.File(externalFilesDir, sb.toString());
                                    try {
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        file = externalFilesDir;
                                    }
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    file = externalFilesDir;
                                    simpleDateFormat = simpleDateFormat3;
                                    str2 = str7;
                                    simpleDateFormat2 = simpleDateFormat4;
                                    file2 = null;
                                    file3 = null;
                                    try {
                                        com.getui.gtc.h.c.a.a("file log upload http error", th);
                                        if (j != this.b) {
                                        }
                                        j -= 86400000;
                                        simpleDateFormat4 = simpleDateFormat2;
                                        i4 = i5;
                                        split = strArr;
                                        str5 = str;
                                        externalFilesDir = file;
                                        simpleDateFormat3 = simpleDateFormat;
                                        str7 = str2;
                                    } finally {
                                        if (file2 != null) {
                                            try {
                                                file2.delete();
                                            } catch (java.lang.Throwable unused) {
                                            }
                                        }
                                        if (j != this.b) {
                                            file3.delete();
                                            com.getui.gtc.h.c.a.a("file log upload delete old log file, fileName:" + file3.getName());
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                str = str5;
                            }
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            str = str5;
                            strArr = split;
                        }
                        if (file4.exists() && file4.isFile()) {
                            if (file4.length() > 52428800) {
                                try {
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("file log is too large,length=");
                                    file5 = externalFilesDir;
                                    try {
                                        sb2.append(file4.length());
                                        com.getui.gtc.h.c.a.b(sb2.toString());
                                        try {
                                            if (j != this.b) {
                                                file4.delete();
                                                str4 = "file log upload delete old log file, fileName:" + file4.getName();
                                            }
                                        } catch (java.lang.Throwable unused2) {
                                        }
                                        j -= 86400000;
                                        externalFilesDir = file5;
                                        i4 = i5;
                                        split = strArr;
                                        str5 = str;
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                        file = file5;
                                        simpleDateFormat = simpleDateFormat3;
                                        str2 = str7;
                                        file3 = file4;
                                        file2 = null;
                                        simpleDateFormat2 = simpleDateFormat4;
                                        com.getui.gtc.h.c.a.a("file log upload http error", th);
                                        if (j != this.b) {
                                        }
                                        j -= 86400000;
                                        simpleDateFormat4 = simpleDateFormat2;
                                        i4 = i5;
                                        split = strArr;
                                        str5 = str;
                                        externalFilesDir = file;
                                        simpleDateFormat3 = simpleDateFormat;
                                        str7 = str2;
                                    }
                                } catch (java.lang.Throwable th7) {
                                    th = th7;
                                    file = externalFilesDir;
                                }
                            } else {
                                file5 = externalFilesDir;
                                try {
                                    b = com.getui.gtc.h.c.b.b(file4);
                                } catch (java.lang.Throwable th8) {
                                    th = th8;
                                    file = file5;
                                    simpleDateFormat = simpleDateFormat3;
                                    str2 = str7;
                                    simpleDateFormat2 = simpleDateFormat4;
                                    file3 = file4;
                                    file2 = null;
                                    com.getui.gtc.h.c.a.a("file log upload http error", th);
                                    if (j != this.b) {
                                    }
                                    j -= 86400000;
                                    simpleDateFormat4 = simpleDateFormat2;
                                    i4 = i5;
                                    split = strArr;
                                    str5 = str;
                                    externalFilesDir = file;
                                    simpleDateFormat3 = simpleDateFormat;
                                    str7 = str2;
                                }
                                if (b == null) {
                                    try {
                                        com.getui.gtc.h.c.a.b("file log to zip error,fileName:" + file4.getName());
                                        if (b != null) {
                                            b.delete();
                                        }
                                        if (j != this.b) {
                                            file4.delete();
                                            str4 = "file log upload delete old log file, fileName:" + file4.getName();
                                        }
                                        j -= 86400000;
                                        externalFilesDir = file5;
                                        i4 = i5;
                                        split = strArr;
                                        str5 = str;
                                    } catch (java.lang.Throwable th9) {
                                        th = th9;
                                        file = file5;
                                        simpleDateFormat = simpleDateFormat3;
                                        str2 = str7;
                                        file3 = file4;
                                        file2 = b;
                                        simpleDateFormat2 = simpleDateFormat4;
                                        com.getui.gtc.h.c.a.a("file log upload http error", th);
                                        if (j != this.b) {
                                        }
                                        j -= 86400000;
                                        simpleDateFormat4 = simpleDateFormat2;
                                        i4 = i5;
                                        split = strArr;
                                        str5 = str;
                                        externalFilesDir = file;
                                        simpleDateFormat3 = simpleDateFormat;
                                        str7 = str2;
                                    }
                                } else {
                                    try {
                                        com.getui.gtc.base.http.MultipartBody.Builder builder = new com.getui.gtc.base.http.MultipartBody.Builder();
                                        file = file5;
                                        try {
                                            builder.setType(com.getui.gtc.base.http.MultipartBody.FORM);
                                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                                            simpleDateFormat = simpleDateFormat3;
                                            str2 = str7;
                                            try {
                                                jSONObject.put("gtcid", com.getui.gtc.c.b.d);
                                                jSONObject.put("cid", com.getui.gtc.h.c.b.b(com.getui.gtc.base.GtcProvider.context()));
                                                jSONObject.put("gtcVersion", com.getui.gtc.BuildConfig.VERSION_NAME);
                                                jSONObject.put("date", simpleDateFormat4.format(new java.util.Date()));
                                                jSONObject.put("createDate", format);
                                                simpleDateFormat2 = simpleDateFormat4;
                                                try {
                                                    jSONObject.put("lastModified", file4.lastModified());
                                                    jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME, str6);
                                                    jSONObject.put("packageName", packageName);
                                                    jSONObject.put("brand", android.os.Build.BRAND);
                                                    jSONObject.put("model", android.os.Build.MODEL);
                                                    int i6 = android.os.Build.VERSION.SDK_INT;
                                                    jSONObject.put("abi", java.util.Arrays.toString(android.os.Build.SUPPORTED_ABIS));
                                                    jSONObject.put("androidVersion", i6);
                                                    builder.addFormDataPart("content", jSONObject.toString());
                                                    builder.addFormDataPart("packageName", packageName);
                                                    builder.addFormDataPart("logFile", b.getName(), com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.get(com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE), b));
                                                    com.getui.gtc.h.c.a.a("file log upload result:" + com.getui.gtc.g.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().url(this.a.getString("url")).method("POST").logFlags(1).body(builder.build()).build()).execute().body().string() + ", logFile:" + file4.getName());
                                                    if (!z2) {
                                                        try {
                                                            this.a.put("reportTime", this.b);
                                                            cVar = com.getui.gtc.e.c.a.a;
                                                            cVar.a.a(this.a);
                                                            com.getui.gtc.h.c.a.a("file log update report time");
                                                            z2 = true;
                                                        } catch (java.lang.Throwable th10) {
                                                            th = th10;
                                                            file3 = file4;
                                                            z2 = true;
                                                            file2 = b;
                                                            com.getui.gtc.h.c.a.a("file log upload http error", th);
                                                            if (j != this.b) {
                                                            }
                                                            j -= 86400000;
                                                            simpleDateFormat4 = simpleDateFormat2;
                                                            i4 = i5;
                                                            split = strArr;
                                                            str5 = str;
                                                            externalFilesDir = file;
                                                            simpleDateFormat3 = simpleDateFormat;
                                                            str7 = str2;
                                                        }
                                                    }
                                                    b.delete();
                                                } catch (java.lang.Throwable th11) {
                                                    th = th11;
                                                    file3 = file4;
                                                    file2 = b;
                                                    com.getui.gtc.h.c.a.a("file log upload http error", th);
                                                    if (j != this.b) {
                                                    }
                                                    j -= 86400000;
                                                    simpleDateFormat4 = simpleDateFormat2;
                                                    i4 = i5;
                                                    split = strArr;
                                                    str5 = str;
                                                    externalFilesDir = file;
                                                    simpleDateFormat3 = simpleDateFormat;
                                                    str7 = str2;
                                                }
                                            } catch (java.lang.Throwable th12) {
                                                th = th12;
                                                simpleDateFormat2 = simpleDateFormat4;
                                                file3 = file4;
                                                file2 = b;
                                                com.getui.gtc.h.c.a.a("file log upload http error", th);
                                                if (j != this.b) {
                                                }
                                                j -= 86400000;
                                                simpleDateFormat4 = simpleDateFormat2;
                                                i4 = i5;
                                                split = strArr;
                                                str5 = str;
                                                externalFilesDir = file;
                                                simpleDateFormat3 = simpleDateFormat;
                                                str7 = str2;
                                            }
                                        } catch (java.lang.Throwable th13) {
                                            th = th13;
                                            simpleDateFormat = simpleDateFormat3;
                                            str2 = str7;
                                            simpleDateFormat2 = simpleDateFormat4;
                                            file3 = file4;
                                            file2 = b;
                                            com.getui.gtc.h.c.a.a("file log upload http error", th);
                                            if (j != this.b) {
                                            }
                                            j -= 86400000;
                                            simpleDateFormat4 = simpleDateFormat2;
                                            i4 = i5;
                                            split = strArr;
                                            str5 = str;
                                            externalFilesDir = file;
                                            simpleDateFormat3 = simpleDateFormat;
                                            str7 = str2;
                                        }
                                    } catch (java.lang.Throwable th14) {
                                        th = th14;
                                        file = file5;
                                    }
                                    if (j != this.b) {
                                        file4.delete();
                                        str3 = "file log upload delete old log file, fileName:" + file4.getName();
                                        com.getui.gtc.h.c.a.a(str3);
                                    }
                                    j -= 86400000;
                                    simpleDateFormat4 = simpleDateFormat2;
                                    i4 = i5;
                                    split = strArr;
                                    str5 = str;
                                    externalFilesDir = file;
                                    simpleDateFormat3 = simpleDateFormat;
                                    str7 = str2;
                                }
                            }
                            com.getui.gtc.h.c.a.a(str4);
                            j -= 86400000;
                            externalFilesDir = file5;
                            i4 = i5;
                            split = strArr;
                            str5 = str;
                        }
                        file = externalFilesDir;
                        simpleDateFormat = simpleDateFormat3;
                        str2 = str7;
                        simpleDateFormat2 = simpleDateFormat4;
                        com.getui.gtc.h.c.a.a("file log not exists :" + file4.getName());
                        if (j != this.b) {
                            file4.delete();
                            str3 = "file log upload delete old log file, fileName:" + file4.getName();
                            com.getui.gtc.h.c.a.a(str3);
                        }
                        j -= 86400000;
                        simpleDateFormat4 = simpleDateFormat2;
                        i4 = i5;
                        split = strArr;
                        str5 = str;
                        externalFilesDir = file;
                        simpleDateFormat3 = simpleDateFormat;
                        str7 = str2;
                    }
                    i = i3 + 1;
                    simpleDateFormat4 = simpleDateFormat4;
                    z = z2;
                    length = i2;
                    split = split;
                    str5 = str5;
                    externalFilesDir = externalFilesDir;
                    simpleDateFormat3 = simpleDateFormat3;
                }
            } catch (java.lang.Throwable th15) {
                com.getui.gtc.h.c.a.a("file log upload unknown error", th15);
            }
        }
    }

    private static java.io.File a() {
        return new java.io.File(com.getui.gtc.base.util.CommonUtil.getExternalFilesDir(com.getui.gtc.base.GtcProvider.context()), com.getui.gtc.base.GtcProvider.context().getPackageName() + "-online.properties");
    }

    private static org.json.JSONObject a(java.lang.String str) {
        com.getui.gtc.e.c cVar;
        org.json.JSONObject a2;
        int i;
        boolean z;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        com.getui.gtc.e.c cVar4;
        try {
            com.getui.gtc.h.c.a.a("update file log config:".concat(java.lang.String.valueOf(str)));
            cVar = com.getui.gtc.e.c.a.a;
            a2 = cVar.a.a();
            i = 0;
            z = a2 != null && a2.length() > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (z) {
                a().delete();
                cVar4 = com.getui.gtc.e.c.a.a;
                cVar4.a.a((org.json.JSONObject) null);
                com.getui.gtc.h.c.a.a("file log clear old config and properties");
            }
            return null;
        }
        if (z && a2.optString("dycConfig").equals(str)) {
            com.getui.gtc.h.c.a.a("file log same config");
            return a2;
        }
        cVar2 = com.getui.gtc.e.c.a.a;
        cVar2.a.a((org.json.JSONObject) null);
        a().delete();
        com.getui.gtc.h.c.a.a("file log clear old config and properties");
        java.lang.String[] split = str.split("\\|");
        if (split.length < 8) {
            throw new java.lang.IllegalStateException("file log dyc error");
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String[] split2 = split[0].split(",");
        java.lang.String str2 = com.getui.gtc.c.b.d;
        int length = split2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            java.lang.String str3 = split2[i2];
            if (!android.text.TextUtils.isEmpty(str3) && str3.equals(str2)) {
                jSONObject.put("gtcid", str2);
                break;
            }
            i2++;
        }
        java.lang.String[] split3 = split[1].split(",");
        java.lang.String b = b(com.getui.gtc.base.GtcProvider.context());
        int length2 = split3.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            java.lang.String str4 = split3[i];
            if (!android.text.TextUtils.isEmpty(str4) && str4.equals(b)) {
                jSONObject.put("cid", b);
                break;
            }
            i++;
        }
        if (!jSONObject.has("gtcid") && !jSONObject.has("cid")) {
            com.getui.gtc.h.c.a.a("file upload not match cur user");
            return null;
        }
        long time = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).parse(split[2]).getTime();
        long parseLong = java.lang.Long.parseLong(split[3]);
        if (parseLong <= 0) {
            com.getui.gtc.h.c.a.a("file upload interval=" + parseLong + " not valid");
        }
        jSONObject.put("allowMobile", "1".equals(split[6]));
        jSONObject.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, time);
        jSONObject.put(com.umeng.analytics.pro.bo.ba, parseLong);
        jSONObject.put("suffixes", split[4]);
        jSONObject.put("enableKeys", split[5]);
        jSONObject.put("url", split[7]);
        if (a(jSONObject)) {
            jSONObject.put("lastModified", a().lastModified());
        }
        jSONObject.put("dycConfig", str);
        cVar3 = com.getui.gtc.e.c.a.a;
        cVar3.a.a(jSONObject);
        com.getui.gtc.h.c.a.a("save file log dyc to db: " + jSONObject.toString());
        return jSONObject;
    }

    public static void a(java.util.Map<java.lang.String, java.lang.String> map) {
        com.getui.gtc.e.c cVar;
        try {
            if (a.getAndSet(true)) {
                return;
            }
            org.json.JSONObject a2 = a(map != null ? map.get("sdk.gtc.fileLog.upload") : null);
            if (a2 != null && a2.length() != 0) {
                long optLong = a2.optLong(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
                java.lang.String optString = a2.optString("gtcid");
                java.lang.String optString2 = a2.optString("cid");
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis >= optLong && currentTimeMillis <= 604800000 + optLong) {
                    if ((!android.text.TextUtils.isEmpty(optString) && optString.equals(com.getui.gtc.c.b.d)) || (!android.text.TextUtils.isEmpty(optString2) && optString2.equals(b(com.getui.gtc.base.GtcProvider.context())))) {
                        if (com.getui.gtc.base.util.CommonUtil.isAppDebugEnable()) {
                            com.getui.gtc.h.c.a.b("file log upload is debug, disallow");
                            return;
                        }
                        boolean optBoolean = a2.optBoolean("allowMobile");
                        if (!a(optBoolean)) {
                            com.getui.gtc.h.c.a.b("file log upload network is not allowed, allowMobile:".concat(java.lang.String.valueOf(optBoolean)));
                            return;
                        }
                        java.io.File a3 = a();
                        long optLong2 = a2.optLong("lastModified");
                        if (optLong2 == 0 || optLong2 != a3.lastModified()) {
                            if (!a(a2)) {
                                return;
                            }
                            a2.put("lastModified", a3.lastModified());
                            cVar = com.getui.gtc.e.c.a.a;
                            cVar.a.a(a2);
                        }
                        if (currentTimeMillis - a2.optLong("reportTime") < a2.optLong(com.umeng.analytics.pro.bo.ba) * 1000) {
                            com.getui.gtc.h.c.a.c("file log report time not expired");
                            return;
                        }
                        java.lang.Thread thread = new java.lang.Thread(new com.getui.gtc.h.c.b.AnonymousClass1(a2, currentTimeMillis, optLong));
                        thread.setName("GTC_fileLogUploadThread");
                        thread.start();
                        return;
                    }
                    a().delete();
                    com.getui.gtc.h.c.a.a("file log upload gtcid or cid changed");
                    return;
                }
                com.getui.gtc.h.c.a.a("current time is not in file log upload time range");
                a().delete();
                return;
            }
            com.getui.gtc.h.c.a.a("file log upload no dyc config in db");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
    }

    private static boolean a(org.json.JSONObject jSONObject) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            long optLong = jSONObject.optLong(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis >= optLong && currentTimeMillis <= optLong + 604800000) {
                java.lang.String[] split = jSONObject.optString("enableKeys").split(",");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (java.lang.String str : split) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        sb.append(str);
                        sb.append(com.alipay.sdk.m.n.a.h);
                        sb.append("true\n");
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(a(), false);
                try {
                    fileOutputStream2.write(sb.toString().getBytes());
                    fileOutputStream2.flush();
                    com.getui.gtc.h.c.a.a("file log write enableKeys success.");
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.h.c.a.c(th);
                        return true;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.getui.gtc.h.c.a.c(th);
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.lang.Throwable th3) {
                                com.getui.gtc.h.c.a.c(th3);
                            }
                        }
                    }
                }
            }
            com.getui.gtc.h.c.a.a("current time is not in file log upload time range");
            return false;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    private static boolean a(boolean z) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.getui.gtc.base.GtcProvider.context().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            if (!z) {
                if (activeNetworkInfo.getType() != 1) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.File b(java.io.File file) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        if (!file.exists()) {
            return null;
        }
        java.io.File file2 = new java.io.File(file + ".zip");
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                gZIPOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (java.lang.Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        gZIPOutputStream.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return file2;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (gZIPOutputStream != null) {
                                try {
                                } catch (java.lang.Throwable th3) {
                                    return null;
                                }
                            }
                            return null;
                        } finally {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (java.lang.Throwable th32) {
                                    th32.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    gZIPOutputStream = null;
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
                fileOutputStream = null;
                gZIPOutputStream = null;
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            fileOutputStream = null;
            fileInputStream = null;
            gZIPOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(android.content.Context context) {
        java.lang.String str = "";
        try {
            java.lang.Object invoke = com.igexin.sdk.PushManager.class.getDeclaredMethod("getClientid", android.content.Context.class).invoke(com.igexin.sdk.PushManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), context);
            if (invoke != null) {
                str = (java.lang.String) invoke;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.a("reflect cid", th);
        }
        com.getui.gtc.h.c.a.a("reflect cid:".concat(str));
        return str;
    }
}
