package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class vw {

    /* renamed from: com.ss.android.downloadlib.bt.vw$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.kz.yl.o();
            com.ss.android.downloadlib.bt.vw.t();
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.vw$vw, reason: collision with other inner class name */
    public static class C0471vw implements java.lang.reflect.InvocationHandler {
        private java.lang.Object vw;

        private C0471vw(java.lang.Object obj) {
            this.vw = obj;
        }

        public /* synthetic */ C0471vw(java.lang.Object obj, com.ss.android.downloadlib.bt.vw.AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    com.ss.android.downloadlib.bt.vw.vw(objArr);
                }
            } catch (java.lang.Throwable unused) {
            }
            return method.invoke(this.vw, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        try {
            java.lang.reflect.Field declaredField = android.os.Build.VERSION.SDK_INT < 26 ? java.lang.Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : java.lang.Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(null);
            java.lang.reflect.Field declaredField2 = java.lang.Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            java.lang.Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            declaredField2.set(obj, java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{java.lang.Class.forName("android.app.IActivityManager")}, new com.ss.android.downloadlib.bt.vw.C0471vw(obj2, null)));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static int vw(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.vw.t.vw(str, new java.io.File(str2));
    }

    public static java.lang.String vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.vw.t.vw(new java.io.File(str));
    }

    public static void vw() {
        if (com.ss.android.downloadlib.addownload.z.x().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.vw.AnonymousClass1(), 10000L);
    }

    public static void vw(java.lang.Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.z.x().optInt("hook", 0) == 1 && (objArr[1] instanceof java.lang.String)) {
            java.lang.Object obj = objArr[2];
            if (obj instanceof android.content.Intent) {
                android.content.Intent intent = (android.content.Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.DownloadConstants.MIME_APK.equals(intent.getType())) {
                    if (com.ss.android.socialbase.appdownloader.kz.yl.v()) {
                        java.lang.String optString = com.ss.android.downloadlib.addownload.z.x().optString("hook_vivo_arg", "com.android.settings");
                        if (com.igexin.push.core.b.m.equals(optString)) {
                            return;
                        }
                        objArr[1] = optString;
                        return;
                    }
                    if (!com.ss.android.socialbase.appdownloader.kz.yl.yl()) {
                        if (com.ss.android.socialbase.appdownloader.kz.yl.vw()) {
                            java.lang.String optString2 = com.ss.android.downloadlib.addownload.z.x().optString("hook_huawei_arg1", "com.huawei.appmarket");
                            if (!com.igexin.push.core.b.m.equals(optString2)) {
                                objArr[1] = optString2;
                            }
                            intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.z.x().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                            return;
                        }
                        return;
                    }
                    java.lang.String optString3 = com.ss.android.downloadlib.addownload.z.x().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + ".market");
                    if (!com.igexin.push.core.b.m.equals(optString3)) {
                        objArr[1] = optString3;
                    }
                    java.lang.String optString4 = com.ss.android.downloadlib.addownload.z.x().optString("hook_kllk_arg2", "com.android.browser");
                    java.lang.String optString5 = com.ss.android.downloadlib.addownload.z.x().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + "mobile.com");
                    intent.putExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + "_extra_pkg_name", optString4);
                    intent.putExtra("refererHost", optString5);
                    if (com.ss.android.downloadlib.addownload.z.x().optInt("hook_kllk_arg4", 0) == 1) {
                        android.content.Intent intent2 = new android.content.Intent();
                        intent2.putExtra(com.ss.android.socialbase.downloader.constants.DownloadConstants.LOWER_OPPO + "_extra_pkg_name", optString4);
                        intent2.putExtra("refererHost", optString5);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                }
            }
        }
    }

    public static java.lang.String wg(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }
}
