package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class vl {
    private static java.lang.Object[] wg = new java.lang.Object[0];
    private static java.lang.Object[] t = new java.lang.Object[73];
    static final char[] vw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static java.lang.String v = null;

    public static android.content.Intent bt(android.content.Context context, java.lang.String str) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static java.io.File es(android.content.Context context, java.lang.String str) {
        java.io.File parentFile = context.getExternalFilesDir(null).getParentFile();
        java.io.File file = new java.io.File((parentFile != null ? parentFile.getParent() : null) + java.io.File.separator + str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.ss.android.socialbase.downloader.logger.Logger.d("ToolUtils", sb.toString());
        return file;
    }

    public static boolean kz(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageArchiveInfo;
        android.content.pm.PackageInfo packageInfo;
        if (context == null || str == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            java.lang.String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static android.content.pm.Signature[] o(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String t(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static void t() {
        android.content.ComponentName componentName;
        try {
            if (com.ss.android.downloadlib.addownload.z.yl().vw(com.ss.android.downloadlib.addownload.z.getContext(), "android.permission.REORDER_TASKS")) {
                android.app.ActivityManager activityManager = (android.app.ActivityManager) com.ss.android.downloadlib.addownload.z.getContext().getSystemService("activity");
                for (android.app.ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    java.lang.String packageName = com.ss.android.downloadlib.addownload.z.getContext().getPackageName();
                    componentName = runningTaskInfo.topActivity;
                    if (packageName.equals(componentName.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r3 != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r1 > 29) goto L16;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean t(java.lang.String str) {
        boolean isExternalStorageLegacy;
        android.content.Context context = com.ss.android.downloadlib.addownload.z.getContext();
        if (android.text.TextUtils.isEmpty(str) || !yl(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.z.x().optInt("get_ext_dir_mode") == 0 && android.os.Build.VERSION.SDK_INT >= 29) {
            if (i == 29) {
                isExternalStorageLegacy = android.os.Environment.isExternalStorageLegacy();
            }
        }
        try {
            java.io.File file = (android.os.Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29 || com.ss.android.downloadlib.addownload.z.x().optInt("get_ext_dir_mode") != 1) ? new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(java.lang.String.valueOf(str))) : es(context, str);
            if (!file.exists()) {
                return false;
            }
            long vw2 = com.ss.android.downloadlib.bt.bt.vw(file);
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < vw2) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static android.graphics.drawable.Drawable v(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static int vw(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int vw(java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                java.lang.String[] split = str.split("\\.");
                java.lang.String[] split2 = str2.split("\\.");
                int min = java.lang.Math.min(split.length, split2.length);
                int i = 0;
                int i2 = 0;
                while (i < min) {
                    i2 = java.lang.Integer.parseInt(split[i]) - java.lang.Integer.parseInt(split2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < split.length; i3++) {
                    if (java.lang.Integer.parseInt(split[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < split2.length) {
                    if (java.lang.Integer.parseInt(split2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (java.lang.Exception unused) {
        }
        return -2;
    }

    public static long vw(java.io.File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new android.os.StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static long vw(java.io.File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long vw(org.json.JSONObject jSONObject, java.lang.String str) {
        return com.ss.android.download.api.t.wg.vw(jSONObject, str);
    }

    public static android.content.pm.PackageInfo vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        if (wgVar == null || (downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.downloadlib.addownload.z.getContext()).getDownloadInfo(wgVar.tq())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.t.vw(com.ss.android.downloadlib.addownload.z.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static android.graphics.drawable.Drawable vw(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager;
        android.content.pm.PackageInfo packageArchiveInfo;
        if (context != null && !android.text.TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            android.content.pm.ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static com.ss.android.downloadlib.addownload.wg.t vw(java.lang.String str, int i, java.lang.String str2) {
        com.ss.android.downloadlib.addownload.wg.t tVar = new com.ss.android.downloadlib.addownload.wg.t();
        if (android.text.TextUtils.isEmpty(str)) {
            return tVar;
        }
        try {
            android.content.pm.PackageInfo packageInfo = com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                tVar.wg(packageInfo.versionCode);
                tVar.vw(com.ss.android.downloadlib.addownload.wg.t.wg);
                com.ss.android.download.api.config.d bt = com.ss.android.downloadlib.addownload.z.bt();
                if (bt != null && bt.vw() && !vw(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    tVar.vw(com.ss.android.downloadlib.addownload.wg.t.t);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return tVar;
    }

    @androidx.annotation.NonNull
    public static <T> T vw(T... tArr) {
        if (tArr == null) {
            throw new java.lang.IllegalArgumentException("args is null");
        }
        for (T t2 : tArr) {
            if (t2 != null) {
                return t2;
            }
        }
        throw new java.lang.IllegalArgumentException("args is null");
    }

    public static java.lang.String vw(long j) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= 1048576) {
            return (j / 1048576) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static java.lang.String vw(java.lang.String str, int i) {
        return i == 0 ? "" : (android.text.TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static java.lang.String vw(java.lang.String... strArr) {
        return com.ss.android.download.api.t.wg.vw(strArr);
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject vw(org.json.JSONObject jSONObject) {
        return com.ss.android.download.api.t.wg.vw(jSONObject);
    }

    public static org.json.JSONObject vw(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        return com.ss.android.download.api.t.wg.vw(jSONObject, jSONObject2);
    }

    @androidx.annotation.NonNull
    public static org.json.JSONObject vw(org.json.JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.t.wg.vw(jSONObjectArr);
    }

    public static void vw(org.json.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (jSONObject == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean vw() {
        try {
            if (com.ss.android.downloadlib.addownload.z.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.z.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return android.os.Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean vw(int i, int i2, java.lang.String str, java.lang.String str2) {
        if (i2 == 0 && android.text.TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || vw(str, str2) >= 0;
    }

    public static boolean vw(android.content.Context context, android.content.Intent intent) {
        try {
            java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                if (!queryIntentActivities.isEmpty()) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static boolean vw(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.pm.PackageInfo packageArchiveInfo;
        android.content.pm.PackageInfo packageInfo;
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return vw(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).vw();
    }

    public static boolean vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    public static boolean vw(android.content.pm.Signature[] signatureArr, android.content.pm.Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            android.content.pm.Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static int wg(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static long wg(long j) {
        try {
            return vw(android.os.Environment.getExternalStorageDirectory(), j);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    @androidx.annotation.NonNull
    public static java.util.HashMap<java.lang.String, java.lang.String> wg(org.json.JSONObject jSONObject) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        if (jSONObject != null) {
            try {
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static boolean wg() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    public static boolean wg(android.content.Context context, android.content.Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.z.getContext();
        }
        java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean wg(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return false;
        }
        return vw(wgVar.yl(), wgVar.oo(), wgVar.ao()).vw();
    }

    public static boolean wg(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && new java.io.File(str).exists();
    }

    public static android.content.pm.Signature[] x(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean yl(android.content.Context context, java.lang.String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.z.getContext();
        }
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
