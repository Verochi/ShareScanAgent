package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class DeviceUtils {
    public static java.lang.String exec(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(str).getInputStream());
            try {
                bufferedReader = new java.io.BufferedReader(inputStreamReader);
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    java.lang.String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (java.lang.Throwable th) {
                        com.sensorsdata.analytics.android.sdk.SALog.i("SA.Exec", th.getMessage());
                    }
                    try {
                        inputStreamReader.close();
                    } catch (java.io.IOException e) {
                        com.sensorsdata.analytics.android.sdk.SALog.i("SA.Exec", e.getMessage());
                    }
                    return sb2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        com.sensorsdata.analytics.android.sdk.SALog.i("SA.Exec", th.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.lang.Throwable th3) {
                                com.sensorsdata.analytics.android.sdk.SALog.i("SA.Exec", th3.getMessage());
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (java.io.IOException e2) {
                                com.sensorsdata.analytics.android.sdk.SALog.i("SA.Exec", e2.getMessage());
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static java.lang.String getBrand() {
        try {
            java.lang.String str = android.os.Build.BRAND;
            return str != null ? str.trim().toUpperCase() : com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static int[] getDeviceSize(android.content.Context context) {
        int[] iArr = new int[2];
        try {
            android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
            int rotation = defaultDisplay.getRotation();
            android.graphics.Point point = new android.graphics.Point();
            defaultDisplay.getRealSize(point);
            int i = point.x;
            int i2 = point.y;
            iArr[0] = getNaturalWidth(rotation, i, i2);
            iArr[1] = getNaturalHeight(rotation, i, i2);
        } catch (java.lang.Exception unused) {
            if (context.getResources() != null) {
                android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                iArr[0] = displayMetrics.widthPixels;
                iArr[1] = displayMetrics.heightPixels;
            }
        }
        return iArr;
    }

    public static java.lang.String getHarmonyOSVersion() {
        if (!isHarmonyOs()) {
            return null;
        }
        java.lang.String prop = getProp(com.alipay.sdk.m.c.a.b, "");
        return android.text.TextUtils.isEmpty(prop) ? exec(com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.COMMAND_HARMONYOS_VERSION) : prop;
    }

    public static java.lang.String getManufacturer() {
        try {
            java.lang.String str = android.os.Build.MANUFACTURER;
            return str != null ? str.trim().toUpperCase() : com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static java.lang.String getModel() {
        java.lang.String str = android.os.Build.MODEL;
        return android.text.TextUtils.isEmpty(str) ? com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN : str.trim();
    }

    private static int getNaturalHeight(int i, int i2, int i3) {
        return (i == 0 || i == 2) ? i3 : i2;
    }

    private static int getNaturalWidth(int i, int i2, int i3) {
        return (i == 0 || i == 2) ? i2 : i3;
    }

    public static java.lang.String getOS() {
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        return str == null ? com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN : str;
    }

    private static java.lang.String getProp(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.String str3 = (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, str);
            return android.text.TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SystemProperties", th.getMessage());
            return str2;
        }
    }

    private static boolean isHarmonyOs() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            java.lang.Object invoke = cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.HasHarmonyOS", th.getMessage());
            return false;
        }
    }
}
