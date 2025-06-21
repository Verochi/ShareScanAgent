package com.umeng.commonsdk.utils;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes19.dex */
public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final java.lang.String KEY_APP_KEY = "appkey";
    private static final java.lang.String KEY_CHANNEL = "channel";
    private static final java.lang.String KEY_LAST_APP_KEY = "last_appkey";
    private static final java.lang.String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final java.lang.String KEY_SESSION_ID = "session_id";
    public static final java.lang.String MOBILE_NETWORK = "2G/3G";
    private static final java.lang.String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final java.lang.String TAG = "UMUtils";
    public static final java.lang.String UNKNOW = "";
    public static final java.lang.String WIFI = "Wi-Fi";
    private static final java.lang.String KEY_SHARED_PREFERENCES_NAME = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.i);
    private static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("UTDID\">([^<]+)");
    private static final java.lang.String SP_FILE_NAME = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.k);
    private static java.lang.Object spLock = new java.lang.Object();
    public static java.lang.String VALUE_ANALYTICS_VERSION = "";
    public static java.lang.String VALUE_GAME_VERSION = "";
    public static java.lang.String VALUE_PUSH_VERSION = "";
    public static java.lang.String VALUE_SHARE_VERSION = "";
    public static java.lang.String VALUE_APM_VERSION = "";
    public static java.lang.String VALUE_VERIFY_VERSION = "";
    public static java.lang.String VALUE_SMS_VERSION = "";
    public static java.lang.String VALUE_REC_VERSION_NAME = "";
    public static java.lang.String VALUE_VISUAL_VERSION = "";
    public static java.lang.String VALUE_ASMS_VERSION = "";
    public static java.lang.String VALUE_LINK_VERSION = "";
    public static java.lang.String VALUE_ABTEST_VERSION = "";
    public static java.lang.String VALUE_ANTI_VERSION = "";
    private static volatile java.lang.String sAppVersionName = "";
    private static volatile java.lang.String sAppVersionCode = "";

    public static java.lang.String MD5(java.lang.String str) {
        try {
            if (str == null) {
                return null;
            }
            try {
                try {
                    byte[] bytes = str.getBytes();
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.reset();
                    messageDigest.update(bytes);
                    byte[] digest = messageDigest.digest();
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    for (byte b : digest) {
                        stringBuffer.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(b)));
                    }
                    return stringBuffer.toString();
                } catch (java.lang.Exception e) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("MD5 e is ");
                        sb.append(e);
                    }
                    return null;
                }
            } catch (java.lang.Exception unused) {
                return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("MD5 e is ");
                sb2.append(th);
            }
            return null;
        }
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    private static java.lang.String byte2HexFormatted(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            java.lang.String hexString = java.lang.Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    private static java.lang.String bytes2Hex(byte[] bArr) {
        java.lang.String str = "";
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static boolean checkAndroidManifest(android.content.Context context, java.lang.String str) {
        try {
            context.getApplicationContext().getPackageManager().getActivityInfo(new android.content.ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(android.net.Uri.parse("tencent" + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR));
            java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities.size() > 0) {
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    android.content.pm.ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static boolean checkMetaData(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(java.lang.String str) {
        try {
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", java.lang.String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (java.lang.Exception e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkResource(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.getApplicationContext().getResources().getIdentifier(str, str2, context.getApplicationContext().getPackageName()) > 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String encryptBySHA1(java.lang.String str) {
        try {
            try {
                byte[] bytes = str.getBytes();
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                    messageDigest.update(bytes);
                    return bytes2Hex(messageDigest.digest());
                } catch (java.lang.Exception unused) {
                    return null;
                }
            } catch (java.lang.Exception e) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("encrypt by SHA1 e is ");
                    sb.append(e);
                }
                return null;
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("encrypt by SHA1 e is ");
                sb2.append(th);
            }
            return null;
        }
    }

    public static java.lang.String genId() {
        return "1234567890";
    }

    public static byte[] genIv() {
        byte[] miniArray = getMiniArray();
        return new byte[]{10, 1, (byte) (10 + 1), 5, 4, (byte) (10 + 5), 7, 9, com.google.common.base.Ascii.ETB, 3, miniArray[0], miniArray[1], miniArray[2], miniArray[3], miniArray[4], (byte) (100 - 9)};
    }

    public static byte[] genSin() {
        byte[] miniArray = getMiniArray();
        return new byte[]{org.apache.tools.tar.TarConstants.LF_CONTIG, 69, (byte) (miniArray[4] + org.apache.tools.tar.TarConstants.LF_FIFO), org.apache.tools.tar.TarConstants.LF_SYMLINK, (byte) (55 + 57), 97, (byte) (69 + 43), org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 57, 97, (byte) (97 + 2), 90, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, (byte) (97 + miniArray[1]), (byte) (69 + miniArray[0] + 3), (byte) (90 + miniArray[2])};
    }

    public static byte[] genUmc() {
        return new byte[]{com.google.common.base.Ascii.US, -117, 8, 0, 0, 0, 0, 0, 0, 0, 1, -27, 0, com.google.common.base.Ascii.SUB, -1, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 102, 34, 19, 78, 70, com.google.common.base.Ascii.ETB, 58, 85, com.google.common.base.Ascii.SUB, 6, 56, 16, 68, 36, 2, 73, 32, org.apache.tools.tar.TarConstants.LF_BLK, 79, 16, 90, 37, 43, 79, 12, com.google.common.base.Ascii.FS, 57, 16, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 123, 95, 100, 70, 91, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_CHR, 33, 34, 39, 104, 59, 61, com.google.common.base.Ascii.DC4, 57, com.google.common.base.Ascii.EM, 2, 63, 113, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.DC2, 100, 102, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 100, 5, 35, 98, 123, 0, 39, 57, com.google.common.base.Ascii.CAN, 40, com.google.common.base.Ascii.EM, 112, 35, 93, com.google.common.base.Ascii.SYN, 73, com.google.common.base.Ascii.DC4, 46, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 73, 71, 117, 70, 69, 110, 73, 73, 117, 114, 2, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 65, 72, 112, com.google.common.base.Ascii.DC2, com.google.common.base.Ascii.SYN, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 98, 71, 85, 98, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 35, 105, com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO, 63, 117, 99, 115, 70, 115, 36, 43, 73, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_NORMAL, 5, 108, 35, 80, 112, 34, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 123, 115, 74, org.apache.tools.tar.TarConstants.LF_DIR, 58, org.apache.tools.tar.TarConstants.LF_DIR, 3, 98, 56, 13, 63, -42, -86, -91, -61, -101, -115, -110, -6, -48, -117, -118, -66, -127, -124, -77, -98, -119, -107, -78, -62, -117, -127, -120, -80, -20, -103, -105, -96, -125, -97, -91, -69, -30, -112, -108, -29, -79, -26, -6, -42, -29, -22, -13, -45, -77, -81, -109, -97, -30, -121, -124, -19, -80, -10, -22, -58, -5, -6, -29, -61, -91, -76, -109, -81, -104, -19, -27, -33, -43, -57, -43, -5, -124, -58, -35, -30, -102, -21, -28, -50, -120, -31, -1, -107, -23, -43, -56, -27, -122, -35, -53, -62, -59, -42, -5, -33, -74, -57, -54, -13, -23, -88, -43, 111, org.apache.tools.tar.TarConstants.LF_DIR, -27, 0, 0, 0};
    }

    public static java.lang.String[] getActiveUser(android.content.Context context) {
        return com.umeng.analytics.c.a(context);
    }

    public static java.lang.String getApmFlag() {
        java.lang.reflect.Method declaredMethod;
        try {
            java.lang.Class<?> cls = getClass("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getUMAPMFlag", new java.lang.Class[0])) == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(cls, new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getAppHashKey(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(context);
    }

    public static java.lang.String getAppMD5Signature(android.content.Context context) {
        java.lang.String str = "";
        try {
            java.lang.String appMD5Signature = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(context);
            try {
                if (android.text.TextUtils.isEmpty(appMD5Signature)) {
                    return appMD5Signature;
                }
                str = appMD5Signature.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
                return str.toLowerCase();
            } catch (java.lang.Throwable unused) {
                return appMD5Signature;
            }
        } catch (java.lang.Throwable unused2) {
            return str;
        }
    }

    public static java.lang.String getAppName(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(context);
    }

    public static java.lang.String getAppSHA1Key(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(context);
    }

    public static java.lang.String getAppVersinoCode(android.content.Context context, java.lang.String str) {
        if (context != null && str != null) {
            try {
                android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
                if (a != null) {
                    return java.lang.String.valueOf(a.versionCode);
                }
            } catch (java.lang.Exception e) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get app version code e is ");
                    sb.append(e);
                }
            } catch (java.lang.Throwable th) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("get app version code e is ");
                    sb2.append(th);
                }
            }
        }
        return "";
    }

    public static java.lang.String getAppVersionCode(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sAppVersionCode)) {
            return sAppVersionCode;
        }
        if (context == null) {
            return "";
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
            if (a == null) {
                return "";
            }
            java.lang.String valueOf = java.lang.String.valueOf(a.versionCode);
            sAppVersionCode = valueOf;
            return valueOf;
        } catch (java.lang.Exception e) {
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("get app version code e is ");
            sb.append(e);
            return "";
        } catch (java.lang.Throwable th) {
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("get app version code e is ");
            sb2.append(th);
            return "";
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sAppVersionName)) {
            return sAppVersionName;
        }
        if (context == null) {
            return "";
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
            if (a == null) {
                return "";
            }
            java.lang.String str = a.versionName;
            sAppVersionName = str;
            return str;
        } catch (java.lang.Throwable th) {
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("get app version name e is ");
            sb.append(th);
            return "";
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context, java.lang.String str) {
        if (context != null && str != null) {
            try {
                android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
                if (a != null) {
                    return a.versionName;
                }
            } catch (java.lang.Throwable th) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get app version name e is ");
                    sb.append(th);
                }
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            }
        }
        return "";
    }

    public static java.lang.String getAppkey(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !android.text.TextUtils.isEmpty(com.umeng.commonsdk.UMConfigure.sAppkey) ? com.umeng.commonsdk.UMConfigure.sAppkey : getMultiProcessSP(context, "appkey");
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get app key e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get app key e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getAppkeyByXML(android.content.Context context) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            java.lang.String string = applicationInfo.metaData.getString("UMENG_APPKEY");
            if (string != null) {
                return string.trim();
            }
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            com.umeng.commonsdk.statistics.common.MLog.i(com.umeng.commonsdk.statistics.AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.util.Properties getBuildProp() {
        java.io.FileInputStream fileInputStream;
        java.util.Properties properties = new java.util.Properties();
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop"));
            } catch (java.io.IOException unused) {
            }
        } catch (java.io.IOException unused2) {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (java.io.IOException unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException unused4) {
                }
            }
            throw th;
        }
        return properties;
    }

    public static java.lang.String getCPU() {
        java.lang.String str = null;
        try {
            try {
                java.io.FileReader fileReader = new java.io.FileReader("/proc/cpuinfo");
                try {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader, 1024);
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (java.io.IOException e) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Could not read from file /proc/cpuinfo, e is ");
                        sb.append(e);
                    }
                }
            } catch (java.io.FileNotFoundException e2) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Could not read from file /proc/cpuinfo, e is ");
                    sb2.append(e2);
                }
            }
            return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
        } catch (java.lang.Exception e3) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("get cpu e is ");
                sb3.append(e3);
            }
            return "";
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("get cpu e is ");
                sb4.append(th);
            }
            return "";
        }
    }

    public static java.lang.String getChannel(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return !android.text.TextUtils.isEmpty(com.umeng.commonsdk.UMConfigure.sChannel) ? com.umeng.commonsdk.UMConfigure.sChannel : getMultiProcessSP(context, "channel");
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get channel e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get channel e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getChannelByXML(android.content.Context context) {
        android.os.Bundle bundle;
        java.lang.Object obj;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("UMENG_CHANNEL")) == null) {
                return null;
            }
            java.lang.String obj2 = obj.toString();
            if (obj2 != null) {
                return obj2.trim();
            }
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            com.umeng.commonsdk.statistics.common.MLog.i(com.umeng.commonsdk.statistics.AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.Class<?> getClass(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getDeviceToken(android.content.Context context) {
        java.lang.Object invoke;
        java.lang.reflect.Method method;
        java.lang.Object invoke2;
        if (context == null) {
            return null;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.umeng.message.PushAgent");
            java.lang.reflect.Method method2 = cls.getMethod("getInstance", android.content.Context.class);
            if (method2 == null || (invoke = method2.invoke(cls, applicationContext)) == null || (method = cls.getMethod("getRegistrationId", new java.lang.Class[0])) == null || (invoke2 = method.invoke(invoke, new java.lang.Object[0])) == null || !(invoke2 instanceof java.lang.String)) {
                return null;
            }
            return (java.lang.String) invoke2;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getDeviceType(android.content.Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get device type e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get device type e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getDisplayResolution(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            return java.lang.String.valueOf(displayMetrics.heightPixels) + "*" + java.lang.String.valueOf(i);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get display resolution e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return "";
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get display resolution e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static java.lang.String getFileMD5(java.io.File file) {
        try {
            try {
                byte[] bArr = new byte[1024];
                try {
                    if (!file.isFile()) {
                        return "";
                    }
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            fileInputStream.close();
                            return java.lang.String.format("%1$032x", new java.math.BigInteger(1, messageDigest.digest()));
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                } catch (java.lang.Exception unused) {
                    return null;
                }
            } catch (java.lang.Throwable th) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get file MD5 e is ");
                    sb.append(th);
                }
                return null;
            }
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get file MD5 e is ");
                sb2.append(e);
            }
            return null;
        }
    }

    private static java.lang.String getFlymeVersion(java.util.Properties properties) {
        try {
            java.lang.String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(java.util.Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String[] getGPU(javax.microedition.khronos.opengles.GL10 gl10) {
        try {
            return new java.lang.String[]{gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VENDOR), gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER)};
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Could not read gpu infor, e is ");
                sb.append(e);
            }
            return new java.lang.String[0];
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Could not read gpu infor, e is ");
                sb2.append(th);
            }
            return new java.lang.String[0];
        }
    }

    public static java.lang.String getLastAppkey(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get last app key e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get last app key e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.util.Locale getLocale(android.content.Context context) {
        java.util.Locale locale;
        if (context == null) {
            return null;
        }
        try {
            try {
                android.content.res.Configuration configuration = new android.content.res.Configuration();
                configuration.setToDefaults();
                android.provider.Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (java.lang.Exception e) {
                try {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("fail to read user config locale, e is ");
                        sb.append(e);
                    }
                    locale = null;
                } catch (java.lang.Exception e2) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("get locale e is ");
                        sb2.append(e2);
                    }
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
                    return null;
                }
            }
            return locale == null ? java.util.Locale.getDefault() : locale;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("get locale e is ");
                sb3.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getMac(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            boolean z = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
            return "";
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get mac e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get mac e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    private static byte[] getMiniArray() {
        return new byte[]{1, 6, 8, 12, 13};
    }

    public static org.json.JSONObject getModuleVer() {
        org.json.JSONObject jSONObject = null;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put(com.umeng.analytics.pro.bo.bi, com.umeng.commonsdk.internal.a.e);
                if (!android.text.TextUtils.isEmpty(VALUE_ANALYTICS_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bj, VALUE_ANALYTICS_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_GAME_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bk, VALUE_GAME_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_PUSH_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bl, VALUE_PUSH_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bm, VALUE_SHARE_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_APM_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bn, VALUE_APM_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_VERIFY_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bo, VALUE_VERIFY_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_SMS_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bp, VALUE_SMS_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bq, VALUE_REC_VERSION_NAME);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_VISUAL_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.br, VALUE_VISUAL_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_ASMS_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bs, VALUE_ASMS_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_LINK_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bt, VALUE_LINK_VERSION);
                }
                if (!android.text.TextUtils.isEmpty(VALUE_ABTEST_VERSION)) {
                    jSONObject2.put(com.umeng.analytics.pro.bo.bu, VALUE_ABTEST_VERSION);
                }
                if (android.text.TextUtils.isEmpty(VALUE_ANTI_VERSION)) {
                    return jSONObject2;
                }
                jSONObject2.put(com.umeng.analytics.pro.bo.bv, VALUE_ANTI_VERSION);
                return jSONObject2;
            } catch (java.lang.Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static java.lang.String getMultiProcessSP(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        if (isMainProgress(context)) {
                            sharedPreferences = context.getApplicationContext().getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                        } else {
                            java.lang.String subProcessName = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(context);
                            sharedPreferences = context.getApplicationContext().getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                        }
                        if (sharedPreferences == null) {
                            return null;
                        }
                        return sharedPreferences.getString(str, null);
                    }
                }
                return null;
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String[] getNetworkAccessMode(android.content.Context context) {
        java.lang.String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("get network access mode e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get network access mode e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == android.net.NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == android.net.NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
            return strArr;
        }
        return strArr;
    }

    public static java.lang.String getNetworkOperatorName(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(context);
    }

    public static java.lang.String getOaidRequiredTime(android.content.Context context) {
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(com.umeng.commonsdk.statistics.idtracking.i.c, "");
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getOperator(android.content.Context context) {
        java.lang.String registeredOperator = com.umeng.commonsdk.statistics.common.DeviceConfig.getRegisteredOperator(context);
        return android.text.TextUtils.isEmpty(registeredOperator) ? "Unknown" : registeredOperator;
    }

    public static java.lang.String getRegisteredOperator(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getRegisteredOperator(context);
    }

    public static java.lang.String getSubOSName(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return null;
        }
        try {
            try {
                java.util.Properties buildProp = getBuildProp();
                try {
                    java.lang.String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (!android.text.TextUtils.isEmpty(property)) {
                        str = "MIUI";
                    } else if (isFlyMe()) {
                        str = "Flyme";
                    } else {
                        if (android.text.TextUtils.isEmpty(getYunOSVersion(buildProp))) {
                            return property;
                        }
                        str = "YunOS";
                    }
                    return str;
                } catch (java.lang.Exception e) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (java.lang.Exception e2) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get sub os name e is ");
                    sb.append(e2);
                }
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
                return null;
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get sub os name e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getSubOSVersion(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            try {
                java.util.Properties buildProp = getBuildProp();
                try {
                    java.lang.String property = buildProp.getProperty("ro.miui.ui.version.name");
                    if (android.text.TextUtils.isEmpty(property)) {
                        try {
                            return isFlyMe() ? getFlymeVersion(buildProp) : getYunOSVersion(buildProp);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    return property;
                } catch (java.lang.Exception e) {
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                    return null;
                }
            } catch (java.lang.Exception e2) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("get sub os version e is ");
                    sb.append(e2);
                }
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e2);
                return null;
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("get sub os version e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String getSystemProperty(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static int getTargetSdkVersion(android.content.Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    public static java.lang.String getUMId(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), com.umeng.analytics.pro.bo.g, null);
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static java.lang.String getUUIDForZid(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString("session_id", "") : "";
    }

    public static java.lang.String getUmengToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            return com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "ztoken", null);
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    private static java.lang.String getYunOSVersion(java.util.Properties properties) {
        try {
            java.lang.String property = properties.getProperty("ro.yunos.version");
            if (android.text.TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getZid(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(applicationContext)) {
            return null;
        }
        return com.umeng.commonsdk.internal.b.a(applicationContext).a().a();
    }

    public static boolean isAppInstalled(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        try {
            return com.umeng.commonsdk.utils.b.a().a(context, str, 0) != null;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean isApplication(android.content.Context context) {
        try {
            java.lang.String name = context.getApplicationContext().getClass().getSuperclass().getName();
            if (android.text.TextUtils.isEmpty(name)) {
                return false;
            }
            return name.equals("android.app.Application");
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            android.os.Build.class.getMethod("hasSmartBar", new java.lang.Class[0]);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(android.content.Context context) {
        try {
            java.lang.String currentProcessName = com.umeng.commonsdk.framework.UMFrUtils.getCurrentProcessName(context);
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        try {
            return android.os.Environment.getExternalStorageState().equals("mounted");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static java.lang.String parseId(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.util.regex.Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private static java.lang.String readStreamToString(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static void safeClose(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void saveSDKComponent() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("a");
        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "统计SDK版本号: 9.7.5");
        }
        VALUE_ANALYTICS_VERSION = "9.7.5";
        java.lang.String b = com.umeng.commonsdk.internal.c.b();
        if (!android.text.TextUtils.isEmpty(b)) {
            VALUE_ASMS_VERSION = b;
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "ZID SDK版本号: " + b);
            }
        }
        java.lang.Class<?> cls = getClass("com.umeng.analytics.game.GameSdkVersion");
        if (cls != null) {
            stringBuffer.append("g");
            try {
                java.lang.String str = (java.lang.String) cls.getDeclaredField("SDK_VERSION").get(cls);
                if (!android.text.TextUtils.isEmpty(str)) {
                    VALUE_GAME_VERSION = str;
                    if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "游戏统计SDK版本号: " + str);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        java.lang.Class<?> cls2 = getClass("com.umeng.vt.V");
        if (cls2 != null) {
            stringBuffer.append("v");
            try {
                java.lang.String str2 = (java.lang.String) cls2.getDeclaredField("VERSION").get(cls2);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    VALUE_VISUAL_VERSION = str2;
                    if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "可视化埋点SDK版本号: " + str2);
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append("p");
            java.lang.Class<?> cls3 = getClass("com.umeng.message.MsgConstant");
            if (cls3 != null) {
                try {
                    java.lang.String str3 = (java.lang.String) cls3.getDeclaredField("SDK_VERSION").get(cls3);
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        VALUE_PUSH_VERSION = str3;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "推送SDK版本号: " + str3);
                        }
                    }
                } catch (java.lang.Throwable unused3) {
                }
            }
        }
        java.lang.Class<?> cls4 = getClass("com.umeng.socialize.UMShareAPI");
        if (cls4 != null) {
            stringBuffer.append("s");
            java.lang.Class<?> cls5 = getClass("com.umeng.a");
            if (cls5 != null) {
                try {
                    java.lang.String str4 = (java.lang.String) cls5.getDeclaredField("g").get(cls5);
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        VALUE_SHARE_VERSION = str4;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "分享SDK版本号: " + str4);
                        }
                    }
                } catch (java.lang.Throwable unused4) {
                }
            }
            if (android.text.TextUtils.isEmpty(VALUE_SHARE_VERSION)) {
                try {
                    java.lang.reflect.Method declaredMethod = cls4.getDeclaredMethod("getSdkVersion", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    VALUE_SHARE_VERSION = (java.lang.String) declaredMethod.invoke(cls4, new java.lang.Object[0]);
                } catch (java.lang.Throwable unused5) {
                }
            }
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.umzid.ZIDManager") != null) {
            stringBuffer.append(com.umeng.analytics.pro.bo.aJ);
        }
        stringBuffer.append("i");
        if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE != 1 && getClass("com.umeng.commonsdk.internal.UMOplus") != null) {
            stringBuffer.append("o");
        }
        if (getClass("com.umeng.airec.RecAgent") != null) {
            stringBuffer.append(com.umeng.analytics.pro.bo.aN);
            java.lang.Class<?> cls6 = getClass("com.umeng.airec.BuildConfig");
            if (cls6 != null) {
                try {
                    java.lang.String str5 = (java.lang.String) cls6.getDeclaredField("VERSION_NAME").get(cls6);
                    if (!android.text.TextUtils.isEmpty(str5)) {
                        VALUE_REC_VERSION_NAME = str5;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "智能推荐SDK版本号: " + str5);
                        }
                    }
                } catch (java.lang.Throwable unused6) {
                }
            }
        }
        if (getClass("com.umeng.umverify.UMVerifyHelper") != null) {
            stringBuffer.append(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT);
        }
        java.lang.Class<?> cls7 = getClass("com.umeng.sms.UMSMS");
        if (cls7 != null) {
            stringBuffer.append(com.anythink.expressad.d.a.b.dH);
            try {
                java.lang.reflect.Method declaredMethod2 = cls7.getDeclaredMethod("getVersion", new java.lang.Class[0]);
                if (declaredMethod2 != null) {
                    java.lang.String str6 = (java.lang.String) declaredMethod2.invoke(cls7, new java.lang.Object[0]);
                    if (!android.text.TextUtils.isEmpty(str6)) {
                        VALUE_SMS_VERSION = str6;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "短信验证码SDK版本号: " + str6);
                        }
                    }
                }
            } catch (java.lang.Throwable unused7) {
            }
        }
        try {
            java.lang.Class<?> cls8 = getClass("com.umeng.umcrash.UMCrash");
            if (cls8 != null) {
                stringBuffer.append("c");
                java.lang.reflect.Field declaredField = cls8.getDeclaredField("crashSdkVersion");
                declaredField.setAccessible(true);
                java.lang.String str7 = (java.lang.String) declaredField.get(cls8);
                if (!android.text.TextUtils.isEmpty(str7)) {
                    VALUE_APM_VERSION = str7;
                    if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                        com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "APM SDK版本号: " + str7);
                    }
                }
            }
        } catch (java.lang.Throwable unused8) {
        }
        java.lang.Class<?> cls9 = getClass("com.umeng.umlink.MobclickLink");
        if (cls9 != null) {
            stringBuffer.append("l");
            try {
                java.lang.reflect.Method declaredMethod3 = cls9.getDeclaredMethod("getVersion", new java.lang.Class[0]);
                if (declaredMethod3 != null) {
                    java.lang.String str8 = (java.lang.String) declaredMethod3.invoke(cls9, new java.lang.Object[0]);
                    if (!android.text.TextUtils.isEmpty(str8)) {
                        VALUE_LINK_VERSION = str8;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "ULink SDK版本号: " + str8);
                        }
                    }
                }
            } catch (java.lang.Throwable unused9) {
            }
        }
        java.lang.Class<?> cls10 = getClass("com.umeng.cconfig.UMRemoteConfig");
        if (cls10 != null) {
            try {
                java.lang.reflect.Method declaredMethod4 = cls10.getDeclaredMethod("getVersion", new java.lang.Class[0]);
                if (declaredMethod4 != null) {
                    stringBuffer.append("t");
                    java.lang.String str9 = (java.lang.String) declaredMethod4.invoke(cls10, new java.lang.Object[0]);
                    if (!android.text.TextUtils.isEmpty(str9)) {
                        VALUE_ABTEST_VERSION = str9;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "UABTEST SDK版本号: " + str9);
                        }
                    }
                }
            } catch (java.lang.Throwable unused10) {
            }
        }
        java.lang.Class<?> cls11 = getClass("com.uyumao.sdk.UYMManager");
        if (cls11 != null) {
            try {
                java.lang.reflect.Method declaredMethod5 = cls11.getDeclaredMethod("getSdkVersion", new java.lang.Class[0]);
                if (declaredMethod5 != null) {
                    stringBuffer.append("r");
                    java.lang.String str10 = (java.lang.String) declaredMethod5.invoke(cls11, new java.lang.Object[0]);
                    if (!android.text.TextUtils.isEmpty(str10)) {
                        VALUE_ANTI_VERSION = str10;
                        if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                            com.umeng.commonsdk.debug.UMLog.mutlInfo(2, "ANTI SDK版本号: " + str10);
                        }
                    }
                }
            } catch (java.lang.Throwable unused11) {
            }
        }
        if (android.text.TextUtils.isEmpty(stringBuffer)) {
            return;
        }
        com.umeng.commonsdk.statistics.b.a = stringBuffer.toString();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("module init:");
        sb.append(com.umeng.commonsdk.statistics.b.a);
    }

    public static void setAppkey(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "appkey", str);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("set app key e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("set app key e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setChannel(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, "channel", str);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("set channel e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("set channel e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setLastAppkey(android.content.Context context, java.lang.String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
        } catch (java.lang.Exception e) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("set last app key e is ");
                sb.append(e);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("set last app key e is ");
                sb2.append(th);
            }
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static void setMultiProcessSP(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences;
        try {
            synchronized (spLock) {
                if (context != null) {
                    if (!android.text.TextUtils.isEmpty(str) && str2 != null) {
                        if (isMainProgress(context)) {
                            sharedPreferences = context.getApplicationContext().getSharedPreferences(KEY_SHARED_PREFERENCES_NAME, 0);
                        } else {
                            java.lang.String subProcessName = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(context);
                            sharedPreferences = context.getApplicationContext().getSharedPreferences(subProcessName + "_" + KEY_SHARED_PREFERENCES_NAME, 0);
                        }
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putString(str, str2).commit();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void setUUIDForZid(android.content.Context context) {
        java.lang.String str;
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, 0);
        try {
            str = java.util.UUID.randomUUID().toString();
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("session_id", str).commit();
        }
    }
}
