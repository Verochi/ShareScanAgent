package com.getui.gtc.a;

/* loaded from: classes22.dex */
public final class f implements com.getui.gtc.a.b {
    private java.lang.String a;
    private boolean b = false;
    private long c = 86400000;
    private java.lang.String[] d = {"com.huawei.appmarket", "com.bbk.launcher2", "net.oneplus.launcher", "com.android.deskclock", "com.heytap.market", "com.oppo.market"};
    private java.lang.String[] e = {"com.tencent.mm", "com.tencent.mobileqq", com.alipay.sdk.m.u.n.b, "com.jingdong.app.mall", "com.ss.android.article.news", "com.taobao.taobao", "com.tmall.wireless", "com.sankuai.meituan", "com.xunmeng.pinduoduo", "com.ss.android.ugc.aweme"};

    private java.lang.String a() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : this.d) {
                try {
                    sb.append(str + "#,");
                } catch (java.lang.Throwable unused) {
                    com.getui.gtc.h.c.a.b(str + " not found");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
            return "";
        }
    }

    @android.annotation.TargetApi(26)
    private java.lang.String b() {
        java.io.File parentFile;
        java.nio.file.Path path;
        java.nio.file.attribute.BasicFileAttributes readAttributes;
        java.nio.file.attribute.FileTime creationTime;
        long millis;
        java.nio.file.attribute.FileTime lastAccessTime;
        long millis2;
        java.io.File parentFile2;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            com.getui.gtc.h.c.a.a("type304 get hot info failed, api<26");
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.File externalCacheDir = com.getui.gtc.base.GtcProvider.context().getExternalCacheDir();
            parentFile = (externalCacheDir == null || (parentFile2 = externalCacheDir.getParentFile()) == null) ? null : parentFile2.getParentFile();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
        }
        if (parentFile == null) {
            return "";
        }
        for (java.lang.String str : this.e) {
            try {
                path = new java.io.File(parentFile, str).toPath();
                readAttributes = java.nio.file.Files.readAttributes(path, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
                creationTime = readAttributes.creationTime();
                millis = creationTime.toMillis();
                lastAccessTime = readAttributes.lastAccessTime();
                millis2 = lastAccessTime.toMillis();
                sb.append(str + "#0#" + millis + "#" + millis2);
                sb.append(",");
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.h.c.a.b(th2);
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        try {
            java.util.Map<java.lang.String, java.lang.String> a = com.getui.gtc.f.c.a(null);
            if (a != null && a.size() > 0) {
                try {
                    java.lang.String str = a.get("sdk.gtc.type304.enable");
                    if (str != null) {
                        this.b = java.lang.Boolean.parseBoolean(str);
                    }
                } catch (java.lang.Exception e) {
                    com.getui.gtc.h.c.a.b(e);
                }
                try {
                    java.lang.String str2 = a.get("sdk.gtc.type304.interval");
                    if (str2 != null) {
                        this.c = java.lang.Long.parseLong(str2) * 1000;
                    }
                } catch (java.lang.Exception e2) {
                    com.getui.gtc.h.c.a.b(e2);
                }
                try {
                    java.lang.String str3 = a.get("sdk.gtc.type304.sys_al");
                    if (!android.text.TextUtils.isEmpty(str3) && !"none".equalsIgnoreCase(str3)) {
                        java.lang.String[] split = str3.split(",");
                        if (split.length > 0) {
                            this.d = split;
                            com.getui.gtc.h.c.a.a("type304 dyc sysApp:" + java.util.Arrays.toString(split));
                        }
                    }
                } catch (java.lang.Exception e3) {
                    com.getui.gtc.h.c.a.b(e3);
                }
                try {
                    java.lang.String str4 = a.get("sdk.gtc.type304.hot_al");
                    if (!android.text.TextUtils.isEmpty(str4) && !"none".equalsIgnoreCase(str4)) {
                        java.lang.String[] split2 = str4.split(",");
                        if (split2.length > 0) {
                            this.e = split2;
                            com.getui.gtc.h.c.a.a("type304 dyc hotApp:" + java.util.Arrays.toString(split2));
                        }
                    }
                } catch (java.lang.Exception e4) {
                    com.getui.gtc.h.c.a.b(e4);
                }
            }
            if (!this.b) {
                com.getui.gtc.h.c.a.b("type 304 is not enabled");
                return;
            }
            if (com.getui.gtc.base.util.CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.h.c.a.b("type 304 is debug, disallow");
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            cVar = com.getui.gtc.e.c.a.a;
            if (currentTimeMillis - cVar.a.l < this.c) {
                return;
            }
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
            java.lang.String str5 = com.getui.gtc.a.a.a(simpleDateFormat.format(new java.util.Date())) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.d) + "|" + com.getui.gtc.a.a.a(com.getui.gtc.c.b.a) + "|android|" + com.getui.gtc.base.GtcProvider.context().getPackageName() + "|GTC-3.2.16.5|" + a() + "|" + b();
            this.a = str5;
            try {
                com.getui.gtc.g.a.a(str5, 304);
                cVar2 = com.getui.gtc.e.c.a.a;
                com.getui.gtc.e.d dVar = cVar2.a;
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                if (dVar.a(16, currentTimeMillis2)) {
                    dVar.l = currentTimeMillis2;
                }
            } catch (java.lang.Exception e5) {
                com.getui.gtc.h.c.a.c("type 304 report error: " + e5.toString());
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.a("type 304", th);
        }
    }
}
