package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final java.lang.String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final java.lang.String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final java.lang.String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final java.lang.String MOBILE_NETWORK = "2G/3G";
    public static final java.lang.String UNKNOW = "";
    public static final java.lang.String WIFI = "Wi-Fi";
    private static com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.DEFAULT;
    private static volatile java.lang.String sWifiMac = "";
    private static volatile java.lang.String sImei = "";
    private static volatile java.lang.String sMeid = "";
    private static volatile java.lang.String sImsi = "";
    private static volatile java.lang.String sSerialNo = "";
    private static volatile java.lang.String sAndroidID = "";
    private static volatile java.lang.String sIDFA = "";
    private static volatile java.lang.String sOAID = "";
    private static volatile java.lang.String sHonorOAID = "";
    private static volatile java.lang.String sSecondImei = "";
    private static volatile java.lang.String sSimSerialNumber = "";
    private static volatile boolean hasReadImeiOrMeid = false;
    private static volatile boolean hasReadSimSerialNumber = false;
    private static volatile boolean hasReadIMEI2 = false;
    private static volatile boolean hasReadSerialNo = false;
    private static volatile boolean hasReadAndroidID = false;
    private static volatile boolean hasReadMac = false;
    private static volatile boolean hasReadImsi = false;
    private static volatile boolean hasReadOAID = false;
    private static volatile boolean hasReadHonorOAID = false;
    private static volatile boolean hasReadIDFA = false;
    private static volatile java.lang.String sAppName = "";
    private static volatile java.lang.String sAppPkgName = "";
    private static volatile boolean hasReadOperator = false;
    private static volatile java.lang.String sOperator = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile java.lang.String sOperatorName = "";
    private static volatile java.lang.String sCustomAgt = "";

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
            sb.append(hexString.toUpperCase(java.util.Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
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
            } catch (java.lang.Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static java.lang.String getAndroidId(android.content.Context context) {
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectAid()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read aid.");
            return null;
        }
        if (!android.text.TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        if (hasReadAndroidID) {
            return null;
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i) && context != null) {
            try {
                try {
                    sAndroidID = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                } finally {
                    hasReadAndroidID = true;
                }
            } catch (java.lang.Throwable unused) {
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    com.umeng.commonsdk.statistics.common.MLog.w("can't read android id");
                }
            }
        }
        return sAndroidID;
    }

    public static java.lang.String getAppHashKey(android.content.Context context) {
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a == null) {
                return null;
            }
            android.content.pm.Signature[] signatureArr = a.signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            android.content.pm.Signature signature = signatureArr[0];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(com.huawei.secure.android.common.encrypt.hash.SHA.a);
            messageDigest.update(signature.toByteArray());
            return android.util.Base64.encodeToString(messageDigest.digest(), 0).trim();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getAppMD5Signature(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a == null) {
                return null;
            }
            return byte2HexFormatted(java.security.MessageDigest.getInstance("MD5").digest(((java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X509").generateCertificate(new java.io.ByteArrayInputStream(a.signatures[0].toByteArray()))).getEncoded()));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getAppName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sAppName)) {
            return sAppName;
        }
        if (context == null) {
            return null;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, context.getPackageName(), 64);
            if (a != null) {
                sAppName = a.applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, th);
            }
        }
        return sAppName;
    }

    public static java.lang.String getAppSHA1Key(android.content.Context context) {
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 64);
            if (a == null) {
                return null;
            }
            return byte2HexFormatted(java.security.MessageDigest.getInstance("SHA1").digest(((java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X509").generateCertificate(new java.io.ByteArrayInputStream(a.signatures[0].toByteArray()))).getEncoded()));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getAppVersionCode(android.content.Context context) {
        return com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(context);
    }

    public static java.lang.String getAppVersionName(android.content.Context context) {
        return com.umeng.commonsdk.utils.UMUtils.getAppVersionName(context);
    }

    public static java.lang.String getApplicationLable(android.content.Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private static java.util.Properties getBuildProp() {
        java.io.FileInputStream fileInputStream;
        java.util.Properties properties = new java.util.Properties();
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(new java.io.File(android.os.Environment.getRootDirectory(), "build.prop"));
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (java.lang.Throwable unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        }
        return properties;
    }

    public static java.lang.String getCPU() {
        java.lang.String str = null;
        try {
            java.io.FileReader fileReader = new java.io.FileReader("/proc/cpuinfo");
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (java.lang.Throwable th) {
                com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (java.io.FileNotFoundException e) {
            com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static java.lang.String getCustomAgt() {
        if (!android.text.TextUtils.isEmpty(sCustomAgt)) {
            return sCustomAgt;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        sb.append("Dalvik/");
        sb.append(java.lang.System.getProperty("java.vm.version"));
        sb.append(" (Linux; U; Android ");
        sb.append(")");
        sCustomAgt = sb.toString();
        return sCustomAgt;
    }

    public static java.lang.String getDBencryptID(android.content.Context context) {
        return com.umeng.commonsdk.utils.UMUtils.genId();
    }

    public static java.lang.String getDeviceId(android.content.Context context) {
        return com.umeng.commonsdk.statistics.AnalyticsConstants.getDeviceType() == 2 ? getDeviceIdForBox(context) : getDeviceIdForGeneral(context);
    }

    public static java.lang.String getDeviceIdForBox(android.content.Context context) {
        java.lang.String str = "";
        if (context == null) {
            return "";
        }
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 23) {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    return str;
                }
                java.lang.String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface);
                }
                if (!android.text.TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                java.lang.String serialNo = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                if (!android.text.TextUtils.isEmpty(serialNo)) {
                    return serialNo;
                }
                java.lang.String imei = getIMEI(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
                return imei;
            }
            if (i == 23) {
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    return str;
                }
                java.lang.String macByJavaAPI = getMacByJavaAPI();
                com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum2 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (android.text.TextUtils.isEmpty(macByJavaAPI)) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!android.text.TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                java.lang.String serialNo2 = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                if (!android.text.TextUtils.isEmpty(serialNo2)) {
                    return serialNo2;
                }
                java.lang.String imei2 = getIMEI(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
                return imei2;
            }
            if (i >= 29) {
                java.lang.String oaid = getOaid(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.OAID;
                if (!android.text.TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                java.lang.String idfa = getIdfa(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IDFA;
                if (!android.text.TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                java.lang.String androidId = getAndroidId(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                if (!android.text.TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                java.lang.String serialNo3 = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                if (!android.text.TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                java.lang.String macByJavaAPI2 = getMacByJavaAPI();
                com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum3 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!android.text.TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                java.lang.String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            }
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                str = getAndroidId(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId: ANDROID_ID: " + str);
                }
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
            java.lang.String serialNo4 = getSerialNo();
            deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
            if (!android.text.TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            java.lang.String imei3 = getIMEI(context);
            deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
            if (!android.text.TextUtils.isEmpty(imei3)) {
                return imei3;
            }
            java.lang.String macByJavaAPI3 = getMacByJavaAPI();
            com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum4 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum4;
            if (!android.text.TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            java.lang.String macBySystemInterface3 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum4;
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface3;
            }
            com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface3);
            return macBySystemInterface3;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getDeviceIdForGeneral(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 23) {
                java.lang.String imei = getIMEI(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
                if (!android.text.TextUtils.isEmpty(imei)) {
                    return imei;
                }
                boolean z = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
                if (z) {
                    com.umeng.commonsdk.statistics.common.MLog.w(LOG_TAG, "No IMEI.");
                }
                java.lang.String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                if (!android.text.TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    macBySystemInterface = getAndroidId(context);
                    deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                    if (z) {
                        com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                    }
                }
                if (!android.text.TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                java.lang.String serialNo = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                return serialNo;
            }
            if (i == 23) {
                java.lang.String imei2 = getIMEI(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
                if (!android.text.TextUtils.isEmpty(imei2)) {
                    return imei2;
                }
                java.lang.String macByJavaAPI = getMacByJavaAPI();
                com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum2 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (android.text.TextUtils.isEmpty(macByJavaAPI)) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                boolean z2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
                if (z2) {
                    com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!android.text.TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                    macByJavaAPI = getAndroidId(context);
                    deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                    if (z2) {
                        com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                    }
                }
                if (!android.text.TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                java.lang.String serialNo2 = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                return serialNo2;
            }
            if (i >= 29) {
                java.lang.String oaid = getOaid(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.OAID;
                if (!android.text.TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                java.lang.String idfa = getIdfa(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IDFA;
                if (!android.text.TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                java.lang.String androidId = getAndroidId(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                if (!android.text.TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                java.lang.String serialNo3 = getSerialNo();
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
                if (!android.text.TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                java.lang.String macByJavaAPI2 = getMacByJavaAPI();
                com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum3 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!android.text.TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                java.lang.String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            }
            java.lang.String imei3 = getIMEI(context);
            deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.IMEI;
            if (!android.text.TextUtils.isEmpty(imei3)) {
                return imei3;
            }
            java.lang.String serialNo4 = getSerialNo();
            deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.SERIALNO;
            if (!android.text.TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
                serialNo4 = getAndroidId(context);
                deviceTypeEnum = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.ANDROIDID;
                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                    com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + serialNo4);
                }
            }
            if (!android.text.TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            java.lang.String macByJavaAPI3 = getMacByJavaAPI();
            com.umeng.commonsdk.statistics.common.DeviceTypeEnum deviceTypeEnum4 = com.umeng.commonsdk.statistics.common.DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum4;
            if (!android.text.TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            java.lang.String macBySystemInterface3 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum4;
            if (!com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface3;
            }
            com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface3);
            return macBySystemInterface3;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static java.lang.String getDeviceIdUmengMD5(android.content.Context context) {
        return com.umeng.commonsdk.statistics.common.HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static java.lang.String getDeviceType(android.content.Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (java.lang.Throwable unused) {
            return "Phone";
        }
    }

    public static java.lang.String getDisplayResolution(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                return java.lang.String.valueOf(displayMetrics.heightPixels) + "*" + java.lang.String.valueOf(i);
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    private static java.lang.String getEmuiVersion(java.util.Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (java.lang.Exception unused) {
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
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String[] getGPU(javax.microedition.khronos.opengles.GL10 gl10) {
        try {
            return new java.lang.String[]{gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_VENDOR), gl10.glGetString(com.badlogic.gdx.graphics.GL20.GL_RENDERER)};
        } catch (java.lang.Throwable th) {
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new java.lang.String[0];
        }
    }

    public static android.app.Activity getGlobleActivity(android.content.Context context) {
        android.app.Activity activity = null;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.Object invoke = cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (java.lang.Object obj : ((java.util.Map) declaredField.get(invoke)).values()) {
                java.lang.Class<?> cls2 = obj.getClass();
                java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    activity = (android.app.Activity) declaredField3.get(obj);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return activity;
    }

    public static java.lang.String getHonorOaid(android.content.Context context) {
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
            return "";
        }
        if (!android.text.TextUtils.isEmpty(sHonorOAID)) {
            return sHonorOAID;
        }
        if (hasReadHonorOAID) {
            return "";
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.c.a, 0);
                if (sharedPreferences != null) {
                    sHonorOAID = sharedPreferences.getString(com.umeng.commonsdk.statistics.idtracking.c.b, "");
                }
            } catch (java.lang.Throwable unused) {
            }
            hasReadHonorOAID = true;
        }
        return sHonorOAID;
    }

    private static java.lang.String getIMEI(android.content.Context context) {
        java.lang.String str = "";
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectImei()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read IMEI.");
            return "";
        }
        if (!android.text.TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        if (hasReadImeiOrMeid) {
            return "";
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
            if (context == null) {
                return "";
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null) {
                try {
                    if (checkPermission(context, com.anythink.china.common.d.a)) {
                        java.lang.String deviceId = telephonyManager.getDeviceId();
                        try {
                            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                                com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "getDeviceId, IMEI: " + deviceId);
                            }
                            str = deviceId;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            str = deviceId;
                            try {
                                if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                                    com.umeng.commonsdk.statistics.common.MLog.w(LOG_TAG, "No IMEI.", th);
                                }
                                sImei = str;
                                return sImei;
                            } finally {
                                hasReadImeiOrMeid = true;
                            }
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
        sImei = str;
        return sImei;
    }

    public static java.lang.String getIdfa(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        if (hasReadIDFA) {
            return "";
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
                sIDFA = com.umeng.commonsdk.statistics.common.a.a(context);
            }
        } catch (java.lang.Throwable unused) {
        }
        hasReadIDFA = true;
        return sIDFA;
    }

    public static java.lang.String getImei(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String str = null;
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectImei()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read IMEI.");
            return null;
        }
        if (!android.text.TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.g) && context != null && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) != null && checkPermission(context, com.anythink.china.common.d.a)) {
                str = telephonyManager.getDeviceId();
            }
        } finally {
            try {
                sImei = str;
                return str;
            } finally {
            }
        }
        sImei = str;
        return str;
    }

    public static java.lang.String getImeiNew(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String str = null;
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectImei()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read IMEI.");
            return null;
        }
        if (!android.text.TextUtils.isEmpty(sImei)) {
            return sImei;
        }
        if (hasReadImeiOrMeid) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.g) && context != null && (telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) != null && checkPermission(context, com.anythink.china.common.d.a)) {
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    try {
                        java.lang.reflect.Method method = telephonyManager.getClass().getMethod("getImei", new java.lang.Class[0]);
                        method.setAccessible(true);
                        str = (java.lang.String) method.invoke(telephonyManager, new java.lang.Object[0]);
                    } catch (java.lang.Throwable unused) {
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        str = telephonyManager.getDeviceId();
                    }
                } else {
                    str = telephonyManager.getDeviceId();
                }
            }
        } finally {
            try {
                sImei = str;
                return str;
            } finally {
            }
        }
        sImei = str;
        return str;
    }

    public static java.lang.String getImsi(android.content.Context context) {
        java.lang.String str = null;
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectImsi()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read IMSI.");
            return null;
        }
        if (!android.text.TextUtils.isEmpty(sImsi)) {
            return sImsi;
        }
        if (hasReadImsi || context == null) {
            return null;
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.al)) {
            try {
                if (checkPermission(context, com.anythink.china.common.d.a) && telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (java.lang.Throwable unused) {
            }
            hasReadImsi = true;
        }
        sImsi = str;
        return sImsi;
    }

    private static java.util.Locale getLocale(android.content.Context context) {
        java.util.Locale locale;
        if (context == null) {
            return java.util.Locale.getDefault();
        }
        try {
            android.content.res.Configuration configuration = new android.content.res.Configuration();
            configuration.setToDefaults();
            android.provider.Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (java.lang.Throwable unused) {
            com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? java.util.Locale.getDefault() : locale;
    }

    public static java.lang.String[] getLocaleInfo(android.content.Context context) {
        java.lang.String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            java.util.Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (android.text.TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (android.text.TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    @android.annotation.SuppressLint({"DefaultLocale"})
    public static java.lang.String getMCCMNC(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (getImsi(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i != 0) {
            java.lang.String valueOf = java.lang.String.valueOf(i2);
            if (i2 < 10) {
                valueOf = java.lang.String.format(com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(i2));
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append(java.lang.String.valueOf(i));
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static java.lang.String getMac(android.content.Context context) {
        java.lang.String macBySystemInterface;
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectWifiMac()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read WiFi Mac.");
            return "";
        }
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.h) || context == null) {
            return "";
        }
        try {
            java.lang.String str = android.os.Build.VERSION.SDK_INT;
            if (str >= 23) {
                if (str != 23) {
                    str = getMacByJavaAPI();
                    if (android.text.TextUtils.isEmpty(str)) {
                        macBySystemInterface = getMacBySystemInterface(context);
                        str = str;
                    }
                    return str;
                }
                str = getMacByJavaAPI();
                if (android.text.TextUtils.isEmpty(str)) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.CHECK_DEVICE) {
                        macBySystemInterface = getMacShell();
                        str = str;
                    } else {
                        macBySystemInterface = getMacBySystemInterface(context);
                        str = str;
                    }
                }
                return str;
            }
            macBySystemInterface = getMacBySystemInterface(context);
            return macBySystemInterface;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    @android.annotation.TargetApi(9)
    private static java.lang.String getMacByJavaAPI() {
        if (!android.text.TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        if (hardwareAddress == null || hardwareAddress.length == 0) {
                            sWifiMac = "";
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        sWifiMac = sb.toString().toLowerCase(java.util.Locale.getDefault());
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        hasReadMac = true;
        return sWifiMac;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static java.lang.String getMacBySystemInterface(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac || context == null) {
            return "";
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                        com.umeng.commonsdk.statistics.common.MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                    }
                    sWifiMac = "";
                } else if (wifiManager != null) {
                    sWifiMac = wifiManager.getConnectionInfo().getMacAddress();
                } else {
                    sWifiMac = "";
                }
            }
        } finally {
            try {
                return sWifiMac;
            } finally {
            }
        }
        return sWifiMac;
    }

    private static java.lang.String getMacShell() {
        if (!android.text.TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        if (hasReadMac) {
            return "";
        }
        try {
            if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
                java.lang.String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
                for (int i = 0; i < 3; i++) {
                    try {
                        java.lang.String reaMac = reaMac(strArr[i]);
                        if (reaMac != null) {
                            sWifiMac = reaMac;
                        }
                    } catch (java.lang.Throwable th) {
                        if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG) {
                            com.umeng.commonsdk.statistics.common.MLog.e(LOG_TAG, "open file  Failed", th);
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        hasReadMac = true;
        return sWifiMac;
    }

    public static java.lang.String getMeid(android.content.Context context) {
        java.lang.String str = null;
        if (context == null || ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) == null) {
            return null;
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.am)) {
            try {
                if (checkPermission(context, com.anythink.china.common.d.a)) {
                    if (android.os.Build.VERSION.SDK_INT < 26) {
                        str = getIMEI(context);
                    } else {
                        str = meid(context);
                        if (android.text.TextUtils.isEmpty(str)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return str;
    }

    public static java.lang.String[] getNetworkAccessMode(android.content.Context context) {
        java.lang.String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
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
        }
        return strArr;
    }

    public static java.lang.String getNetworkOperatorName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (checkPermission(context, com.anythink.china.common.d.a) && telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (java.lang.Throwable unused) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static int getNetworkType(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (checkPermission(context, com.anythink.china.common.d.a)) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (java.lang.Exception unused) {
            return -100;
        }
    }

    public static java.lang.String getNotificationStatus(android.content.Context context) {
        boolean areNotificationsEnabled;
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.J)) {
            return "unknown";
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                areNotificationsEnabled = ((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled();
                return java.lang.Boolean.toString(areNotificationsEnabled);
            } catch (java.lang.Throwable unused) {
                return "unknown";
            }
        }
        try {
            android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return java.lang.Boolean.toString(((java.lang.Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), java.lang.Integer.valueOf(i), packageName)).intValue() == 0);
        } catch (java.lang.Throwable unused2) {
            return "unknown";
        }
    }

    public static java.lang.String getOaid(android.content.Context context) {
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
            return "";
        }
        if (!android.text.TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (hasReadOAID) {
            return "";
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(com.umeng.commonsdk.statistics.idtracking.i.a, 0);
                if (sharedPreferences != null) {
                    sOAID = sharedPreferences.getString(com.umeng.commonsdk.statistics.idtracking.i.b, "");
                }
            } catch (java.lang.Throwable unused) {
            }
            hasReadOAID = true;
        }
        return sOAID;
    }

    public static java.lang.String getPackageName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sAppPkgName)) {
            return sAppPkgName;
        }
        if (context == null) {
            return null;
        }
        sAppPkgName = context.getPackageName();
        return sAppPkgName;
    }

    public static int getRandNumber(int i, int i2) {
        return new java.util.Random().nextInt((i2 - i) + 1) + i;
    }

    public static java.lang.String getRegisteredOperator(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sOperator)) {
            return sOperator;
        }
        if (hasReadOperator || context == null) {
            return null;
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (checkPermission(context, com.anythink.china.common.d.a) && telephonyManager != null) {
                sOperator = telephonyManager.getNetworkOperator();
            }
        } catch (java.lang.Throwable unused) {
        }
        hasReadOperator = true;
        return sOperator;
    }

    public static int[] getResolutionArray(android.content.Context context) {
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            try {
                java.lang.reflect.Method method = java.lang.Class.forName("android.view.Display").getMethod("getRealMetrics", android.util.DisplayMetrics.class);
                if (method != null) {
                    method.invoke(defaultDisplay, displayMetrics);
                    int i = displayMetrics.widthPixels;
                    int i2 = displayMetrics.heightPixels;
                    if (i > i2) {
                        iArr[0] = i2;
                        iArr[1] = i;
                    } else {
                        iArr[0] = i;
                        iArr[1] = i2;
                    }
                    iArr[0] = i;
                    iArr[1] = i2;
                    return iArr;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    public static int getRingerMode(android.content.Context context) {
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.K)) {
            return -1;
        }
        try {
            return ((android.media.AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static java.lang.String getSecondSimIMEi(android.content.Context context) {
        return null;
    }

    public static java.lang.String getSerial() {
        return getSerialNo();
    }

    @android.annotation.TargetApi(9)
    private static java.lang.String getSerialNo() {
        return "";
    }

    public static java.lang.String getSid(android.content.Context context) {
        return com.umeng.analytics.pro.aa.a().d(context);
    }

    public static java.lang.String getSimICCID(android.content.Context context) {
        if (!com.umeng.commonsdk.UMConfigure.shouldCollectIccid()) {
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "disallow read ICCID.");
            return null;
        }
        if (!android.text.TextUtils.isEmpty(sSimSerialNumber)) {
            return sSimSerialNumber;
        }
        if (hasReadSimSerialNumber) {
            return null;
        }
        if (com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.ap)) {
            if (context != null) {
                try {
                    if (com.umeng.commonsdk.utils.UMUtils.checkPermission(context, com.anythink.china.common.d.a)) {
                        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                        if (telephonyManager == null) {
                            hasReadSimSerialNumber = true;
                            return null;
                        }
                        sSimSerialNumber = telephonyManager.getSimSerialNumber();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            hasReadSimSerialNumber = true;
        }
        return sSimSerialNumber;
    }

    public static java.lang.String getSubOSName(android.content.Context context) {
        java.util.Properties buildProp = getBuildProp();
        try {
            java.lang.String property = buildProp.getProperty("ro.miui.ui.version.name");
            return android.text.TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : isEmui(buildProp) ? "Emui" : !android.text.TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String getSubOSVersion(android.content.Context context) {
        java.util.Properties buildProp = getBuildProp();
        try {
            java.lang.String property = buildProp.getProperty("ro.miui.ui.version.name");
            if (!android.text.TextUtils.isEmpty(property)) {
                return property;
            }
            try {
                property = isFlyMe() ? getFlymeVersion(buildProp) : isEmui(buildProp) ? getEmuiVersion(buildProp) : getYunOSVersion(buildProp);
                return property;
            } catch (java.lang.Throwable unused) {
                return property;
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(android.content.Context context) {
        if (context == null) {
            return 8;
        }
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.statistics.common.MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
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

    public static boolean hasOpsPermission(android.content.Context context) {
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.av)) {
            return false;
        }
        try {
            return ((android.app.AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", android.os.Process.myUid(), getPackageName(context)) == 0;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean hasRequestPermission(android.content.Context context, java.lang.String str) {
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.av)) {
            return false;
        }
        try {
            for (java.lang.String str2 : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str2.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean isChineseAera(android.content.Context context) {
        java.lang.String imprintProperty;
        if (context == null) {
            return false;
        }
        try {
            imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "country", "");
        } catch (java.lang.Throwable unused) {
        }
        if (!android.text.TextUtils.isEmpty(imprintProperty)) {
            return imprintProperty.equals(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION);
        }
        if (getImsi(context) != null) {
            int i = context.getResources().getConfiguration().mcc;
            if (i != 460 && i != 461) {
                if (i == 0) {
                    java.lang.String str = getLocaleInfo(context)[0];
                    if (android.text.TextUtils.isEmpty(str) || !str.equalsIgnoreCase(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION)) {
                    }
                }
            }
            return true;
        }
        java.lang.String str2 = getLocaleInfo(context)[0];
        if (!android.text.TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION)) {
            return true;
        }
        return false;
    }

    private static boolean isEmui(java.util.Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    private static boolean isFlyMe() {
        try {
            android.os.Build.class.getMethod("hasSmartBar", new java.lang.Class[0]);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean isHarmony(android.content.Context context) {
        try {
            return context.getString(android.content.res.Resources.getSystem().getIdentifier("config_os_brand", com.anythink.expressad.foundation.h.i.g, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)).equals("harmony");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean isHonorDevice() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean isOnline(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static boolean isSystemApp(android.content.Context context) {
        if (!com.umeng.commonsdk.config.FieldManager.allow(com.umeng.commonsdk.utils.d.au)) {
            return false;
        }
        try {
            android.content.pm.PackageInfo a = com.umeng.commonsdk.utils.b.a().a(context, getPackageName(context), 1048576);
            if (a != null) {
                return (a.applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean isWiFiAvailable(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    private static java.lang.String meid(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(sMeid)) {
            return sMeid;
        }
        java.lang.String str = null;
        if (hasReadImeiOrMeid || context == null) {
            return null;
        }
        try {
            java.lang.Object invoke = java.lang.Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            if (invoke != null && (invoke instanceof java.lang.String)) {
                str = (java.lang.String) invoke;
            }
        } finally {
            try {
                hasReadImeiOrMeid = true;
                sMeid = str;
                return sMeid;
            } catch (java.lang.Throwable th) {
            }
        }
        hasReadImeiOrMeid = true;
        sMeid = str;
        return sMeid;
    }

    private static java.lang.String reaMac(java.lang.String str) {
        java.io.FileReader fileReader;
        java.io.BufferedReader bufferedReader;
        java.lang.String str2 = null;
        try {
            fileReader = new java.io.FileReader(str);
        } catch (java.lang.Throwable unused) {
        }
        try {
            bufferedReader = new java.io.BufferedReader(fileReader, 1024);
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (java.lang.Throwable unused2) {
                }
                bufferedReader.close();
                return str2;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    fileReader.close();
                } catch (java.lang.Throwable unused3) {
                }
                if (bufferedReader == null) {
                    throw th;
                }
                try {
                    bufferedReader.close();
                    throw th;
                } catch (java.lang.Throwable unused4) {
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private static int reflectMetrics(java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.reflect.Field declaredField = android.util.DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }
}
