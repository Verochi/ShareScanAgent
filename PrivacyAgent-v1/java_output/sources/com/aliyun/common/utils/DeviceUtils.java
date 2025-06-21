package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class DeviceUtils {
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 1;

    /* renamed from: com.aliyun.common.utils.DeviceUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.View val$activityRootView;
        final /* synthetic */ boolean[] val$isSoftkey;

        public AnonymousClass1(android.view.View view, boolean[] zArr) {
            this.val$activityRootView = view;
            this.val$isSoftkey = zArr;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.val$activityRootView.getRootView().getHeight() - this.val$activityRootView.getHeight() > 100) {
                this.val$isSoftkey[0] = true;
            }
        }
    }

    @android.annotation.TargetApi(11)
    public static void coptyToClipBoard(android.content.Context context, java.lang.String str) {
        ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText("label", str));
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean existSDCard() {
        return android.os.Environment.getExternalStorageState().equals("mounted");
    }

    public static long getAllSize() {
        if (!existSDCard()) {
            return 0L;
        }
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static long getAvailaleSize() {
        if (!existSDCard()) {
            return 0L;
        }
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static java.lang.String getExternalStorageDirectory() {
        java.util.Map<java.lang.String, java.lang.String> map = java.lang.System.getenv();
        int size = map.values().size();
        java.lang.String[] strArr = new java.lang.String[size];
        map.values().toArray(strArr);
        java.lang.String str = strArr[size - 1];
        if (!str.startsWith("/mnt/") || android.os.Environment.getExternalStorageDirectory().getAbsolutePath().equals(str)) {
            return null;
        }
        return str;
    }

    public static java.lang.String getLatestCameraPicture(android.content.Context context) {
        if (!existSDCard()) {
            return null;
        }
        android.database.Cursor query = context.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query.moveToFirst()) {
            return query.getString(1);
        }
        return null;
    }

    public static java.lang.String getLocalIPAddress() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    java.net.InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "0.0.0.0";
        } catch (java.net.SocketException unused) {
            return "0.0.0.0";
        }
    }

    public static int getNavigationBarHeight(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNetType(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        switch (((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static int getPhoneType(android.content.Context context) {
        return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getPhoneType();
    }

    public static android.util.DisplayMetrics getScreenPix(android.app.Activity activity) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getTopBarHeight(android.app.Activity activity) {
        return activity.getWindow().findViewById(android.R.id.content).getTop();
    }

    public static java.lang.String getUDID(android.content.Context context) {
        java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (com.aliyun.common.utils.StringUtils.isEmpty(string) || string.equals("9774d56d682e549c") || string.length() < 15) {
            string = new java.math.BigInteger(64, new java.security.SecureRandom()).toString(16);
        }
        return com.aliyun.common.utils.StringUtils.isEmpty(string) ? "" : string;
    }

    public static void goHome(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addFlags(270532608);
        context.startActivity(intent);
    }

    public static void hideInputSoftFromWindowMethod(android.content.Context context, android.view.View view) {
        try {
            ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isActiveSoftInput(android.content.Context context) {
        return ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).isActive();
    }

    public static boolean isOnline(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isPhone(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getPhoneType() != 0;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isProessRunning(android.content.Context context, java.lang.String str) {
        java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (it.hasNext()) {
            if (it.next().processName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isServiceRunning(android.content.Context context, java.lang.String str) {
        java.util.List<android.app.ActivityManager.RunningServiceInfo> runningServices = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() == 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void showInputSoftFromWindowMethod(android.content.Context context, android.view.View view) {
        try {
            ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean startActivityForPackage(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN", (android.net.Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setFlags(131072);
            intent.setPackage(packageInfo.packageName);
            android.content.pm.ResolveInfo next = context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (next == null) {
                return false;
            }
            android.content.pm.ActivityInfo activityInfo = next.activityInfo;
            java.lang.String str2 = activityInfo.packageName;
            java.lang.String str3 = activityInfo.name;
            android.content.Intent intent2 = new android.content.Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setFlags(270532608);
            intent2.setComponent(new android.content.ComponentName(str2, str3));
            context.startActivity(intent2);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void vibrate(android.content.Context context, long j) {
        ((android.os.Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{0, j}, -1);
    }

    public boolean isSoftKeyAvail(android.app.Activity activity) {
        boolean[] zArr = {false};
        android.view.View findViewById = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new com.aliyun.common.utils.DeviceUtils.AnonymousClass1(findViewById, zArr));
        return zArr[0];
    }
}
