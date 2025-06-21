package com.ss.android.socialbase.appdownloader;

/* loaded from: classes19.dex */
public class t {
    private static int vw;
    private static android.app.NotificationChannel wg;

    /* renamed from: com.ss.android.socialbase.appdownloader.t$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.t.x {
        final /* synthetic */ boolean t;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ int wg;

        public AnonymousClass1(android.content.Context context, int i, boolean z) {
            this.vw = context;
            this.wg = i;
            this.t = z;
        }

        @Override // com.ss.android.socialbase.appdownloader.t.x
        public void vw() {
            int unused = com.ss.android.socialbase.appdownloader.t.vw = com.ss.android.socialbase.appdownloader.t.v(this.vw, this.wg, this.t);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.t$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ boolean t;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo v;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ int wg;
        final /* synthetic */ java.io.File yl;

        public AnonymousClass2(android.content.Context context, int i, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.io.File file) {
            this.vw = context;
            this.wg = i;
            this.t = z;
            this.v = downloadInfo;
            this.yl = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.appdownloader.v.es().z();
            int vw = com.ss.android.socialbase.appdownloader.t.vw(this.vw, this.wg, this.t, this.v, this.yl);
            if (vw == 1 && com.ss.android.socialbase.appdownloader.v.es().k() != null) {
                com.ss.android.socialbase.appdownloader.v.es().k().onOpenInstaller(this.v, null);
            }
            com.ss.android.socialbase.appdownloader.t.wg(this.v, this.t, vw);
        }
    }

    public static java.util.List<java.lang.String> t() {
        java.util.ArrayList arrayList = new java.util.ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static boolean t(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) || android.text.TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return wg(context, downloadInfo, vw(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static boolean t(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int v(android.content.Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance().cancelNotification(i);
        }
        vw((android.app.Activity) com.ss.android.socialbase.appdownloader.o.vw().wg());
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("install_queue_enable", 0) == 1 ? com.ss.android.socialbase.appdownloader.o.vw().vw(context, i, z) : wg(context, i, z);
    }

    private static org.json.JSONObject v(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static int vw() {
        return com.ss.android.socialbase.appdownloader.v.es().kz() ? 16384 : 0;
    }

    public static int vw(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return com.ss.android.socialbase.downloader.constants.DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    public static int vw(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int vw(android.content.Context context, int i, boolean z) {
        com.ss.android.socialbase.appdownloader.t.es bt = com.ss.android.socialbase.appdownloader.v.es().bt();
        if (bt == null) {
            return v(context, i, z);
        }
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i);
        vw = 1;
        bt.vw(downloadInfo, new com.ss.android.socialbase.appdownloader.t.AnonymousClass1(context, i, z));
        return vw;
    }

    public static int vw(android.content.Context context, int i, boolean z, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.io.File file) {
        android.content.pm.PackageInfo packageInfo;
        android.content.Intent vw2;
        java.lang.Process process;
        if (file.getPath().startsWith(android.os.Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = java.lang.Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    process.waitFor();
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (process != null) {
                            process.destroy();
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                process = null;
            }
        }
        try {
            packageInfo = vw(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (com.ss.android.socialbase.appdownloader.v.es().t() != null) {
            if (packageInfo == null) {
                com.ss.android.socialbase.downloader.exception.BaseException baseException = new com.ss.android.socialbase.downloader.exception.BaseException(2001, th);
                com.ss.android.socialbase.appdownloader.v.es().t().vw(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                com.ss.android.socialbase.appdownloader.v.es().t().vw(downloadInfo, null, 11);
            }
        }
        if (vw(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", java.lang.Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (wg(context, downloadInfo, packageInfo)) {
            vw2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z && vw(context, i, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", java.lang.Boolean.TRUE);
                return 1;
            }
            vw2 = vw(context, downloadInfo, file, z, iArr);
        }
        if (vw2 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        vw2.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) == 1) {
            vw2.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && com.ss.android.socialbase.appdownloader.wg.vw(context, downloadInfo, vw2, z)) {
            return 1;
        }
        return vw(context, vw2);
    }

    public static int vw(android.content.Context context, android.content.Intent intent) {
        try {
            if (com.ss.android.socialbase.appdownloader.v.es().j() != null) {
                if (com.ss.android.socialbase.appdownloader.v.es().j().installApp(intent)) {
                    return 1;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (java.lang.Throwable unused2) {
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static android.content.Intent vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, @androidx.annotation.NonNull java.io.File file, boolean z, int[] iArr) {
        android.net.Uri vw2 = vw(downloadInfo.getId(), com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.v.es().v(), file);
        if (vw2 == null) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(vw2, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.t.v wg2 = com.ss.android.socialbase.appdownloader.v.es().wg();
        int vw3 = wg2 != null ? wg2.vw(downloadInfo.getId(), z) : 0;
        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i = vw3;
        if (downloadNotificationEventListener != null) {
            i = downloadNotificationEventListener.interceptAfterNotificationSuccess(z);
        }
        iArr[0] = i;
        if (i != 0) {
            return null;
        }
        return intent;
    }

    public static android.content.pm.PackageInfo vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        java.io.File file = new java.io.File(str, str2);
        if (!file.exists()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("isApkInstalled apkFileSize：fileName:");
        sb.append(file.getPath());
        sb.append(" apkFileSize");
        sb.append(file.length());
        return vw(downloadInfo, file);
    }

    public static android.content.pm.PackageInfo vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.io.File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.kz.vw.yl.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), file, vw());
        }
        android.content.pm.PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        android.content.pm.PackageInfo vw2 = com.ss.android.socialbase.appdownloader.kz.vw.yl.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), file, vw());
        downloadInfo.setPackageInfo(vw2);
        return vw2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.net.Uri vw(int i, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider, android.content.Context context, java.lang.String str, java.io.File file) {
        android.net.Uri uri;
        if (iDownloadFileUriProvider == null) {
            com.ss.android.socialbase.appdownloader.t.kz yl = com.ss.android.socialbase.appdownloader.v.es().yl();
            if (yl != null) {
                uri = yl.vw(i, str, file.getAbsolutePath());
            }
            uri = null;
            if (uri == null) {
                try {
                    uri = (android.os.Build.VERSION.SDK_INT < 24 || android.text.TextUtils.isEmpty(str)) ? android.net.Uri.fromFile(file) : androidx.core.content.FileProvider.getUriForFile(context, str, file);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            return uri;
        }
        uri = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
        if (uri == null) {
        }
        return uri;
    }

    public static java.lang.String vw(long j) {
        return vw(j, true);
    }

    private static java.lang.String vw(long j, long j2, java.lang.String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new java.text.DecimalFormat("#").format(d) + str;
        }
        return new java.text.DecimalFormat("#.##").format(d) + str;
    }

    private static java.lang.String vw(long j, long j2, java.lang.String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new java.text.DecimalFormat("#.##").format(d) + " " + str;
        }
        return new java.text.DecimalFormat("#").format(d) + " " + str;
    }

    public static java.lang.String vw(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        java.lang.String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return vw(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    public static java.lang.String vw(java.lang.String str, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        org.json.JSONObject optJSONObject;
        java.lang.String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        java.lang.String optString = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!android.text.TextUtils.isEmpty(optString) && optString.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            optString = optString.substring(1);
        }
        if (android.text.TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (optString.contains("%s")) {
            try {
                format = java.lang.String.format(optString, str);
            } catch (java.lang.Throwable unused) {
            }
        } else {
            format = optString + str;
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String vw(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        java.lang.String str4 = "";
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        android.net.Uri parse = android.net.Uri.parse(str);
        if (!z) {
            if (!android.text.TextUtils.isEmpty(parse.getLastPathSegment()) && !parse.getLastPathSegment().contains("..")) {
                str4 = parse.getLastPathSegment();
            }
            if (!android.text.TextUtils.isEmpty(str4)) {
                str2 = str4;
            }
            return !t(str3) ? str2 : str2;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            if (!android.text.TextUtils.isEmpty(parse.getLastPathSegment()) && !parse.getLastPathSegment().contains("..")) {
                str2 = parse.getLastPathSegment();
            }
            str2 = "default.apk";
        }
        if (!t(str3) && !str2.endsWith(com.anythink.china.common.a.a.g)) {
            return str2 + com.anythink.china.common.a.a.g;
        }
    }

    public static void vw(android.app.Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, boolean z2) {
        com.ss.android.socialbase.appdownloader.v.es().vw(new com.ss.android.socialbase.appdownloader.kz(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).vw(downloadInfo.getTitle()).wg(downloadInfo.getName()).t(downloadInfo.getSavePath()).vw(downloadInfo.isShowNotification()).wg(downloadInfo.isAutoInstallWithoutNotification()).t(downloadInfo.isOnlyWifi() || z2).yl(downloadInfo.getExtra()).kz(downloadInfo.getMimeType()).vw(downloadInfo.getExtraHeaders()).yl(true).wg(downloadInfo.getRetryCount()).t(downloadInfo.getBackUpUrlRetryCount()).wg(downloadInfo.getBackUpUrls()).v(downloadInfo.getMinProgressTimeMsInterval()).yl(downloadInfo.getMaxProgressCount()).kz(z).v(downloadInfo.isNeedHttpsToHttpRetry()).bt(downloadInfo.getPackageName()).o(downloadInfo.getMd5()).vw(downloadInfo.getExpectFileLength()).x(downloadInfo.isNeedDefaultHttpServiceBackUp()).es(downloadInfo.isNeedReuseFirstConnection()).vl(downloadInfo.isNeedIndependentProcess()).vw(downloadInfo.getEnqueueType()).cp(downloadInfo.isForce()).u(downloadInfo.isHeadConnectionAvailable()).bt(downloadInfo.isNeedRetryDelay()).x(downloadInfo.getRetryDelayTimeArray()).vw(v(downloadInfo.getDownloadSettingString())).z(downloadInfo.getIconUrl()).kz(downloadInfo.getExecutorGroup()).j(downloadInfo.isAutoInstall()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        if (r5 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vw(android.content.Context context) {
        android.content.res.TypedArray typedArray;
        if (context == null) {
            return false;
        }
        try {
            int color = context.getResources().getColor(com.ss.android.socialbase.appdownloader.yl.wg());
            typedArray = context.obtainStyledAttributes(com.ss.android.socialbase.appdownloader.yl.yl(), new int[]{com.ss.android.socialbase.appdownloader.yl.t(), com.ss.android.socialbase.appdownloader.yl.v()});
            try {
                if (color == typedArray.getColor(0, 0)) {
                    try {
                        typedArray.recycle();
                    } catch (java.lang.Throwable unused) {
                    }
                    return true;
                }
            } catch (java.lang.Throwable unused2) {
            }
        } catch (java.lang.Throwable unused3) {
            typedArray = null;
        }
        try {
            typedArray.recycle();
        } catch (java.lang.Throwable unused4) {
        }
        return false;
    }

    public static boolean vw(android.content.Context context, int i, java.io.File file) {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.kz.yl.u() || com.ss.android.socialbase.appdownloader.kz.yl.cp()) && com.ss.android.socialbase.downloader.utils.SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            android.content.Intent intent = new android.content.Intent();
            intent.setComponent(new android.content.ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return vw(context, downloadInfo, true);
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.pm.PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.t.v wg2 = com.ss.android.socialbase.appdownloader.v.es().wg();
        if (wg2 != null) {
            wg2.vw(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (wg2.vw()) {
                return true;
            }
        }
        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener downloadNotificationEventListener = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.t.t vw2 = com.ss.android.socialbase.appdownloader.v.es().vw();
        return (vw2 instanceof com.ss.android.socialbase.appdownloader.t.vw) && ((com.ss.android.socialbase.appdownloader.t.vw) vw2).t();
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.pm.PackageInfo packageInfo, boolean z) {
        android.content.pm.PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        java.lang.String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, vw());
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
        if (context == null) {
            return false;
        }
        try {
            java.io.File file = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
            android.content.pm.PackageInfo packageInfo = null;
            if (file.exists()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("isPackageNameEqualsWithApk fileName:");
                sb.append(downloadInfo.getName());
                sb.append(" apkFileSize：");
                sb.append(file.length());
                sb.append(" fileUrl：");
                sb.append(downloadInfo.getUrl());
                android.content.pm.PackageInfo vw2 = vw(downloadInfo, file);
                if (vw2 == null || !vw2.packageName.equals(str)) {
                    return false;
                }
                int i = vw2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, vw());
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    return false;
                }
                java.lang.String string = com.ss.android.socialbase.downloader.utils.DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                int i2 = com.ss.android.socialbase.downloader.utils.DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (string == null || android.text.TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, vw());
                } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vw(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        android.content.pm.PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        java.lang.String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return t(context, downloadInfo);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, vw());
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static boolean vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (android.text.TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !android.text.TextUtils.isEmpty(downloadInfo.getName()) && vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return new org.json.JSONObject(str).optBoolean("bind_app", false);
    }

    public static int wg(android.content.Context context, int i, boolean z) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) && !android.text.TextUtils.isEmpty(downloadInfo.getName())) {
            java.io.File file = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.submitIOTask(new com.ss.android.socialbase.appdownloader.t.AnonymousClass2(context, i, z, downloadInfo, file));
                return 1;
            }
        }
        wg(downloadInfo, z, 2);
        return 2;
    }

    public static int wg(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) && !android.text.TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                android.content.pm.PackageInfo vw2 = vw(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (vw2 != null) {
                    int i = vw2.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return 0;
    }

    public static java.lang.String wg() {
        return com.ss.android.socialbase.downloader.utils.DownloadUtils.getDownloadPath();
    }

    public static java.lang.String wg(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        java.lang.String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return vw(j, j2, strArr[i]);
            }
        }
        return null;
    }

    @android.annotation.TargetApi(26)
    public static java.lang.String wg(@androidx.annotation.NonNull android.content.Context context) {
        try {
            if (wg == null) {
                android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel("111111", "channel_appdownloader", 3);
                wg = notificationChannel;
                notificationChannel.setSound(null, null);
                wg.setShowBadge(false);
                ((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).createNotificationChannel(wg);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), com.ss.android.socialbase.downloader.constants.MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static boolean wg(android.content.Context context, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, android.content.pm.PackageInfo packageInfo) {
        return vw(context, downloadInfo, packageInfo, false);
    }

    public static boolean wg(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }
}
