package com.loc;

/* loaded from: classes23.dex */
public final class gd {
    static android.net.wifi.WifiManager a;
    private static int b;
    private static java.lang.String[] c;
    private static java.lang.String d;

    public static double a(double d2) {
        return b(d2);
    }

    public static float a(float f) {
        return (float) (((long) (f * 100.0d)) / 100.0d);
    }

    public static float a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.AMapLocation aMapLocation2) {
        return a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    public static float a(com.amap.api.location.DPoint dPoint, com.amap.api.location.DPoint dPoint2) {
        return a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), dPoint2.getLatitude(), dPoint2.getLongitude()});
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        android.location.Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
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
            com.loc.fv.a(th, "Utils", "getServ");
            return null;
        }
    }

    public static java.lang.String a(int i) {
        if (i == 33) {
            return "补偿定位失败，未命中缓存";
        }
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            default:
                switch (i) {
                }
        }
        return "其他错误";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(long j, java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat;
        if (android.text.TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        java.text.SimpleDateFormat simpleDateFormat2 = null;
        try {
            simpleDateFormat = new java.text.SimpleDateFormat(str, java.util.Locale.CHINA);
            try {
                simpleDateFormat.applyPattern(str);
            } catch (java.lang.Throwable th) {
                th = th;
                simpleDateFormat2 = simpleDateFormat;
                com.loc.fv.a(th, "Utils", "formatUTC");
                simpleDateFormat = simpleDateFormat2;
                if (j <= 0) {
                }
                if (simpleDateFormat != null) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (j <= 0) {
            j = a();
        }
        return simpleDateFormat != null ? "NULL" : simpleDateFormat.format(java.lang.Long.valueOf(j));
    }

    public static java.lang.String a(android.net.ConnectivityManager connectivityManager) {
        int i = 0;
        if (connectivityManager != null) {
            try {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    i = activeNetworkInfo.getSubtype();
                }
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

    public static java.util.List<java.lang.String> a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        java.io.InputStreamReader inputStreamReader;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = b(file);
                try {
                    inputStreamReader = new java.io.InputStreamReader(fileInputStream, java.nio.charset.Charset.defaultCharset());
                    try {
                        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (java.lang.Throwable unused) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return arrayList;
                            }
                        }
                        bufferedReader2.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                    } catch (java.lang.Throwable unused2) {
                    }
                } catch (java.lang.Throwable unused3) {
                    inputStreamReader = null;
                }
            } catch (java.lang.Throwable unused4) {
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void a(java.io.File file, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = c(file);
                if (str != null) {
                    fileOutputStream.write(str.getBytes());
                }
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean a(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? d(context, "android.provider.Settings$System") : d(context, "android.provider.Settings$Global");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
        android.database.Cursor cursor;
        boolean z = false;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String replace = "2.0.201501131131".replace(".", "");
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    cursor = sQLiteDatabase.query("sqlite_master", new java.lang.String[]{"count(*) as c"}, "type = 'table' AND name = '" + str.trim() + replace + "'", null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(0) > 0) {
                                    z = true;
                                }
                            }
                        } catch (java.lang.Throwable unused) {
                            if (cursor == null) {
                                return true;
                            }
                            cursor.close();
                            return true;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                }
            } catch (java.lang.Throwable unused2) {
                cursor = null;
            }
        }
        return false;
    }

    public static boolean a(android.location.Location location, int i) {
        boolean z;
        android.os.Bundle extras;
        try {
            z = location.isFromMockProvider();
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        if (z) {
            return true;
        }
        try {
            extras = location.getExtras();
        } catch (java.lang.Throwable unused2) {
        }
        if ((extras != null ? extras.getInt("satellites") : 0) <= 0) {
            return true;
        }
        if (i == 0 && location.getAltitude() == 0.0d && location.getBearing() == 0.0f) {
            if (location.getSpeed() == 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return b(aMapLocation);
        }
        return false;
    }

    public static boolean a(com.loc.ey eyVar) {
        if (eyVar == null || "8".equals(eyVar.d()) || "5".equals(eyVar.d()) || "6".equals(eyVar.d())) {
            return false;
        }
        return b(eyVar);
    }

    public static boolean a(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || com.alipay.sdk.m.u.c.b.equals(str) || "02:00:00:00:00:00".equals(str) || str.contains(" :")) ? false : true;
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            java.util.ArrayList<java.lang.String> b2 = b(str);
            java.lang.String[] split = str2.toString().split("#");
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].contains(",nb") || split[i3].contains(",access")) {
                    i++;
                    if (b2.contains(split[i3])) {
                        i2++;
                    }
                }
            }
            if (i2 * 2 >= (b2.size() + i) * 0.618d) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(org.json.JSONObject jSONObject, java.lang.String str) {
        return com.loc.y.a(jSONObject, str);
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
        return com.loc.y.b(bArr);
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
            com.loc.fv.a(th, "Utils", "getMccMnc");
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
        return ((long) (d2 * 1000000.0d)) / 1000000.0d;
    }

    public static int b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i |= (bArr[i2] & 255) << ((1 - i2) * 8);
        }
        return i;
    }

    public static long b() {
        return android.os.SystemClock.elapsedRealtime();
    }

    private static java.io.FileInputStream b(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new java.io.IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new java.io.FileInputStream(file);
        }
        throw new java.io.IOException("File '" + file + "' cannot be read");
    }

    public static java.lang.String b(android.content.Context context) {
        android.content.pm.PackageInfo packageInfo;
        if (!android.text.TextUtils.isEmpty(com.loc.fv.j)) {
            return com.loc.fv.j;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(com.loc.m.c(context), 64);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (android.text.TextUtils.isEmpty(com.loc.fv.k)) {
                com.loc.fv.k = null;
            }
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "Utils", "getAppName");
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
        java.lang.String c2 = com.loc.m.c(context);
        if (!android.text.TextUtils.isEmpty(c2)) {
            sb.append(",");
            sb.append(c2);
        }
        if (!android.text.TextUtils.isEmpty(com.loc.fv.k)) {
            sb.append(",");
            sb.append(com.loc.fv.k);
        }
        java.lang.String sb2 = sb.toString();
        com.loc.fv.j = sb2;
        return sb2;
    }

    public static java.util.ArrayList<java.lang.String> b(java.lang.String str) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] split = str.split("#");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(",nb") || split[i].contains(",access")) {
                    arrayList.add(split[i]);
                }
            }
        }
        return arrayList;
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str, 256);
        } catch (java.lang.Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean b(com.amap.api.location.AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
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

    public static double c(double d2) {
        return ((long) (d2 * 100.0d)) / 100.0d;
    }

    public static double c(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Double.parseDouble(str);
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            try {
                return com.loc.fz.b("android.os.Build$VERSION", "SDK_INT");
            } catch (java.lang.Throwable unused) {
                return 0;
            }
        } catch (java.lang.Throwable unused2) {
            return java.lang.Integer.parseInt(com.loc.fz.a("android.os.Build$VERSION", "SDK").toString());
        }
    }

    public static android.net.NetworkInfo c(android.content.Context context) {
        try {
            return com.loc.p.k(context);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    private static java.io.FileOutputStream c(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null) {
                if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                    throw new java.io.IOException("Directory '" + parentFile + "' could not be created");
                }
                file.createNewFile();
            }
        } else {
            if (file.isDirectory()) {
                throw new java.io.IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new java.io.IOException("File '" + file + "' cannot be written to");
            }
        }
        return new java.io.FileOutputStream(file, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (r4.checkCallingOrSelfPermission(com.loc.y.c(r5)) == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r4 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(android.content.Context context, java.lang.String str) {
        int checkSelfPermission;
        boolean z = false;
        try {
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            if (context != null) {
            }
            return z;
        }
        if (context != null) {
            checkSelfPermission = context.checkSelfPermission(com.loc.y.c(str));
        }
        return z;
        com.loc.fx.b();
        return z;
    }

    public static float d(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Float.parseFloat(str);
    }

    public static int d() {
        return new java.util.Random().nextInt(65536) - 32768;
    }

    public static boolean d(android.content.Context context) {
        try {
            android.net.NetworkInfo c2 = c(context);
            if (c2 != null) {
                if (c2.isConnectedOrConnecting()) {
                    return true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    private static boolean d(android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        return ((java.lang.Integer) com.loc.fz.a(str, "getInt", new java.lang.Object[]{context.getContentResolver(), ((java.lang.String) com.loc.fz.a(str, "AIRPLANE_MODE_ON")).toString()}, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.ContentResolver.class, java.lang.String.class})).intValue() == 1;
    }

    public static int e(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Integer.parseInt(str);
    }

    public static java.lang.String e() {
        try {
            return com.loc.q.b("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean e(android.content.Context context) {
        int i;
        if (android.os.Build.VERSION.SDK_INT < 23 || context.getApplicationInfo().targetSdkVersion < 23) {
            for (java.lang.String str : com.loc.et.D) {
                if (context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                }
            }
        } else {
            android.app.Application application = (android.app.Application) context;
            for (java.lang.String str2 : com.loc.et.D) {
                try {
                    i = com.loc.fz.b(application.getBaseContext(), "checkSelfPermission", str2);
                } catch (java.lang.Throwable unused) {
                    i = 0;
                }
                if (i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int f(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Integer.parseInt(str, 16);
    }

    public static boolean f(android.content.Context context) {
        int i;
        if (context.getApplicationInfo().targetSdkVersion < 29 || android.os.Build.VERSION.SDK_INT < 29) {
            return true;
        }
        try {
            i = com.loc.fz.b(((android.app.Application) context).getBaseContext(), "checkSelfPermission", com.loc.et.E);
        } catch (java.lang.Throwable unused) {
            i = 0;
        }
        return i == 0;
    }

    public static byte g(java.lang.String str) throws java.lang.NumberFormatException {
        return java.lang.Byte.parseByte(str);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static boolean g(android.content.Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (a == null) {
            a = (android.net.wifi.WifiManager) a(context, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
        }
        try {
            if (c(context, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                z = a.isWifiEnabled();
            } else {
                com.loc.fv.a(new java.lang.Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");
                z = false;
            }
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        try {
            com.loc.fx.b();
        } catch (java.lang.Throwable unused2) {
            com.loc.fx.d();
            return z ? z : z;
        }
        if (z && c() > 17) {
            try {
                return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(java.lang.String.valueOf(com.loc.fz.a(a, "isScanAlwaysAvailable", new java.lang.Object[0])));
            } catch (java.lang.Throwable unused3) {
                return z;
            }
        }
    }

    public static java.lang.String h(android.content.Context context) {
        android.net.NetworkInfo c2 = c(context);
        if (c2 == null || !c2.isConnectedOrConnecting()) {
            return "DISCONNECTED";
        }
        int type = c2.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        java.lang.String subtypeName = c2.getSubtypeName();
        switch (c2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!"GSM".equalsIgnoreCase(subtypeName)) {
                    if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) {
                        return subtypeName;
                    }
                    return "3G";
                }
                return "2G";
        }
    }

    private static boolean h(java.lang.String str) {
        try {
            java.lang.String str2 = android.os.Build.MANUFACTURER;
            java.lang.String str3 = android.os.Build.BRAND;
            if (!str2.equalsIgnoreCase(str)) {
                if (!str3.toLowerCase().contains(str)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
            return false;
        }
    }

    public static java.lang.String i(android.content.Context context) {
        java.lang.String h = com.loc.p.h();
        if (android.text.TextUtils.isEmpty(h) || h.equals(com.alipay.sdk.m.u.c.b)) {
            h = com.loc.gc.a(context);
        }
        return android.text.TextUtils.isEmpty(h) ? com.alipay.sdk.m.u.c.b : h;
    }

    public static boolean j(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }

    public static boolean k(android.content.Context context) {
        android.content.pm.ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new android.content.ComponentName(context, "com.amap.api.location.APSService"), 128);
        } catch (java.lang.Throwable unused) {
            serviceInfo = null;
        }
        return serviceInfo != null;
    }

    public static java.lang.String l(android.content.Context context) {
        if (d == null) {
            d = com.loc.fk.a("MD5", com.loc.m.c(context));
        }
        return d;
    }

    public static boolean m(android.content.Context context) {
        try {
            if (!p(context) && !o(context)) {
                if (!n(context)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
            return false;
        }
    }

    private static boolean n(android.content.Context context) {
        return h(com.igexin.assist.util.AssistUtils.BRAND_HW) && q(context) && s(context);
    }

    private static boolean o(android.content.Context context) {
        return h(com.igexin.assist.util.AssistUtils.BRAND_VIVO) && q(context) && r(context);
    }

    private static boolean p(android.content.Context context) {
        int checkSelfPermission;
        int checkSelfPermission2;
        try {
            if (android.os.Build.VERSION.SDK_INT < 31 || context == null) {
                return false;
            }
            checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
            if (checkSelfPermission == 0) {
                return false;
            }
            checkSelfPermission2 = context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
            return checkSelfPermission2 == 0;
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
            return false;
        }
    }

    private static boolean q(android.content.Context context) {
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            int i2 = context.getApplicationInfo().targetSdkVersion;
            return ((i == 30) && (i2 >= 23)) || ((i == 31) && (i2 <= 30 && i2 >= 23));
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
            return false;
        }
    }

    private static boolean r(android.content.Context context) {
        android.database.Cursor cursor;
        boolean z = false;
        try {
            cursor = context.getContentResolver().query(android.net.Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new java.lang.String[]{"package_name", "selected_fuzzy"}, "package_name=?", new java.lang.String[]{context.getPackageName()}, null);
            boolean z2 = false;
            while (cursor != null) {
                try {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    if (cursor.getString(0) != null && cursor.getInt(1) == 1) {
                        z2 = true;
                    }
                } catch (java.lang.Throwable unused) {
                    z = z2;
                    try {
                        com.loc.fx.b();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    } catch (java.lang.Throwable unused2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return z2;
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
    }

    private static boolean s(android.content.Context context) {
        int checkSelfPermission;
        try {
            try {
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    if (context == null) {
                        return false;
                    }
                    checkSelfPermission = context.checkSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION");
                    if (checkSelfPermission != 0) {
                        return false;
                    }
                } else if (context == null || context.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) {
                    return false;
                }
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        } catch (java.lang.Throwable unused2) {
            com.loc.fx.b();
            return false;
        }
    }
}
