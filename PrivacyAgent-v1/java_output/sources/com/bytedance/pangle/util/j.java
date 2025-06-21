package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class j {
    static volatile java.util.ArrayList<java.lang.String> a;
    private static java.lang.String b;

    public static java.util.List<java.lang.String> a() {
        android.content.res.AssetManager assetManager;
        try {
            assetManager = (android.content.res.AssetManager) android.content.res.AssetManager.class.newInstance();
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static java.util.List<java.lang.String> a(android.content.res.AssetManager assetManager) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (com.bytedance.pangle.util.i.j()) {
                java.lang.Object[] objArr = (java.lang.Object[]) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getApkAssets", new java.lang.Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (java.lang.Object obj : objArr) {
                        arrayList.add((java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getAssetPath", new java.lang.Object[0]));
                    }
                }
            } else {
                int intValue = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new java.lang.Object[0])).intValue();
                for (int i = 0; i < intValue; i++) {
                    try {
                        java.lang.String str = (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getCookieName", java.lang.Integer.valueOf(i + 1));
                        if (!android.text.TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (java.lang.IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th);
        }
        return arrayList;
    }

    public static boolean a(android.content.res.AssetManager assetManager, java.lang.String str) {
        try {
            if (com.bytedance.pangle.util.i.j()) {
                java.lang.Object[] objArr = (java.lang.Object[]) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getApkAssets", new java.lang.Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (java.lang.Object obj : objArr) {
                        if (android.text.TextUtils.equals((java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getAssetPath", new java.lang.Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new java.lang.Object[0])).intValue();
                int i = 0;
                while (i < intValue) {
                    i++;
                    if (android.text.TextUtils.equals((java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getCookieName", java.lang.Integer.valueOf(i)), str)) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
        }
        return false;
    }

    @androidx.annotation.RequiresApi(api = 21)
    private static java.lang.String[] a(android.content.pm.ApplicationInfo applicationInfo) {
        java.lang.String[] strArr;
        try {
            strArr = (java.lang.String[]) com.bytedance.pangle.b.b.a.a((java.lang.Class<?>) android.content.pm.ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (java.lang.Throwable th) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
            strArr = new java.lang.String[0];
        }
        java.lang.String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        java.util.ArrayList arrayList = new java.util.ArrayList(10);
        java.lang.String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i = 0; i < 3; i++) {
            java.lang.String[] strArr3 = strArr2[i];
            if (strArr3 != null) {
                arrayList.addAll(java.util.Arrays.asList(strArr3));
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
    }

    public static java.lang.String b(android.content.res.AssetManager assetManager) {
        java.util.List<java.lang.String> a2 = a(assetManager);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
        if (a2.size() > 0) {
            java.util.Iterator<java.lang.String> it = a2.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(" , ");
            }
            sb.delete(sb.lastIndexOf(" , "), sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
    
        if (r4 > 0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: Exception -> 0x00a4, all -> 0x00ae, TryCatch #3 {, blocks: (B:9:0x001a, B:11:0x001e, B:30:0x002c, B:14:0x005f, B:17:0x0065, B:21:0x007d, B:24:0x0086, B:25:0x0096, B:28:0x00a5, B:33:0x0057, B:34:0x00ac), top: B:8:0x001a, outer: #0, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[Catch: Exception -> 0x00a4, all -> 0x00ae, TRY_LEAVE, TryCatch #3 {, blocks: (B:9:0x001a, B:11:0x001e, B:30:0x002c, B:14:0x005f, B:17:0x0065, B:21:0x007d, B:24:0x0086, B:25:0x0096, B:28:0x00a5, B:33:0x0057, B:34:0x00ac), top: B:8:0x001a, outer: #0, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.util.List<java.lang.String> b() {
        java.util.ArrayList<java.lang.String> arrayList;
        int i;
        synchronized (com.bytedance.pangle.util.j.class) {
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_WEB, com.anythink.expressad.foundation.d.c.bT);
            if (a == null) {
                synchronized (com.bytedance.pangle.util.j.class) {
                    if (a == null) {
                        a = new java.util.ArrayList<>();
                        boolean z = false;
                        if (com.bytedance.pangle.util.i.c()) {
                            try {
                                android.content.res.Resources resources = com.bytedance.pangle.Zeus.getAppApplication().getResources();
                                a.add(com.bytedance.pangle.Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", com.anythink.expressad.foundation.h.i.g, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)), 0).getApplicationInfo().sourceDir);
                            } catch (java.lang.Exception e) {
                                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e);
                            }
                        } else if (com.bytedance.pangle.util.i.h()) {
                            try {
                                java.lang.Object invokeStaticMethod = com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(java.lang.Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new java.lang.Object[0]);
                                int i2 = android.os.Build.VERSION.SDK_INT;
                                if (i2 < 29) {
                                    if (i2 == 28) {
                                        i = android.os.Build.VERSION.PREVIEW_SDK_INT;
                                    }
                                    if (z) {
                                        a.add(((android.content.Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                    } else {
                                        java.util.Collections.addAll(a, a(((android.content.Context) invokeStaticMethod).getApplicationInfo()));
                                    }
                                }
                                z = true;
                                if (z) {
                                }
                            } catch (java.lang.Exception e2) {
                                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e2);
                            }
                        }
                    }
                }
            }
            com.bytedance.pangle.GlobalParam.getInstance().getReporter().saveRecord(com.bytedance.pangle.log.IZeusReporter.ZEUS_STAGE_WEB, "finish :" + a);
            arrayList = a;
        }
        return arrayList;
    }
}
