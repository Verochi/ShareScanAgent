package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ix {
    static android.net.wifi.WifiManager a;
    private static int b;
    private static java.lang.String[] c;
    private static boolean d;

    public static double a(double d2) {
        return c(d2);
    }

    public static float a(float f) {
        return (float) (((long) (f * 100.0d)) / 100.0d);
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        android.location.Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i) {
        return (i * 2) - 113;
    }

    public static int a(android.net.NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return java.lang.System.currentTimeMillis();
    }

    public static java.lang.Object a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static boolean a(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? b(context, "android.provider.Settings$System") : b(context, "android.provider.Settings$Global");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean a(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || com.alipay.sdk.m.u.c.b.equals(str) || str.contains(" :")) ? false : true;
    }

    public static boolean a(org.json.JSONObject jSONObject, java.lang.String str) {
        return com.amap.api.mapcore.util.fi.a(jSONObject, str);
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (i * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return com.amap.api.mapcore.util.fi.b(bArr);
    }

    public static java.lang.String[] a(android.telephony.TelephonyManager telephonyManager) {
        int i;
        java.lang.String[] strArr;
        java.lang.String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        java.lang.String[] strArr2 = {"0", "0"};
        if (!android.text.TextUtils.isEmpty(networkOperator) && android.text.TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && java.lang.Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = java.lang.Integer.parseInt(strArr2[0]);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = c) != null) ? strArr : strArr2;
        }
        c = strArr2;
        return strArr2;
    }

    public static double b(double d2) {
        return ((long) (d2 * 100.0d)) / 100.0d;
    }

    public static long b() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public static java.lang.String b(int i) {
        if (i == 18) {
            return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
        }
        if (i == 19) {
            return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
        if (i == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
            default:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
        }
    }

    public static java.lang.String b(android.content.Context context) {
        android.content.pm.PackageInfo packageInfo;
        if (!android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.j)) {
            return com.amap.api.mapcore.util.it.j;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(com.amap.api.mapcore.util.ev.c(context), 64);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.k)) {
                com.amap.api.mapcore.util.it.k = null;
            }
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.it.a(th2, "Utils", "getAppName");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (packageInfo != null) {
            android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            java.lang.CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
            if (loadLabel != null) {
                sb.append(loadLabel.toString());
            }
            if (!android.text.TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        java.lang.String c2 = com.amap.api.mapcore.util.ev.c(context);
        if (!android.text.TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.k)) {
            sb.append(",");
            sb.append(com.amap.api.mapcore.util.it.k);
        }
        java.lang.String sb2 = sb.toString();
        com.amap.api.mapcore.util.it.j = sb2;
        return sb2;
    }

    public static java.lang.String b(android.telephony.TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            try {
                i = telephonyManager.getNetworkType();
            } catch (java.lang.Throwable unused) {
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    private static boolean b(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        return ((java.lang.Integer) com.amap.api.mapcore.util.iv.a(str, "getInt", new java.lang.Object[]{context.getContentResolver(), ((java.lang.String) com.amap.api.mapcore.util.iv.a(str, "AIRPLANE_MODE_ON")).toString()}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class})).intValue() == 1;
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] b(java.lang.String str) {
        return a(d(str), (byte[]) null);
    }

    private static double c(double d2) {
        return ((long) (d2 * 1000000.0d)) / 1000000.0d;
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            try {
                return com.amap.api.mapcore.util.iv.b("android.os.Build$VERSION", "SDK_INT");
            } catch (java.lang.Throwable unused) {
                return 0;
            }
        } catch (java.lang.Throwable unused2) {
            return java.lang.Integer.parseInt(com.amap.api.mapcore.util.iv.a("android.os.Build$VERSION", "SDK").toString());
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean c(android.content.Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (a == null) {
            a = (android.net.wifi.WifiManager) a(context, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
        }
        try {
            z = a.isWifiEnabled();
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        if (z || c() <= 17) {
            return z;
        }
        try {
            return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(java.lang.String.valueOf(com.amap.api.mapcore.util.iv.a(a, "isScanAlwaysAvailable", new java.lang.Object[0])));
        } catch (java.lang.Throwable unused2) {
            return z;
        }
    }

    public static byte[] c(java.lang.String str) {
        return b(d(str), (byte[]) null);
    }

    public static int d() {
        return new java.util.Random().nextInt(65536) - 32768;
    }

    public static int d(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Integer.parseInt(str);
    }

    public static java.lang.String d(android.content.Context context) {
        java.lang.String k = com.amap.api.mapcore.util.ez.k(context);
        boolean isEmpty = android.text.TextUtils.isEmpty(k);
        java.lang.String str = com.alipay.sdk.m.u.c.b;
        if (isEmpty || k.equals(com.alipay.sdk.m.u.c.b)) {
            k = com.amap.api.mapcore.util.iw.a(context);
        }
        if (!android.text.TextUtils.isEmpty(k)) {
            str = k;
        }
        if (!d) {
            com.amap.api.mapcore.util.iw.a(context, str);
            d = true;
        }
        return str;
    }

    public static byte e(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Byte.parseByte(str);
    }
}
