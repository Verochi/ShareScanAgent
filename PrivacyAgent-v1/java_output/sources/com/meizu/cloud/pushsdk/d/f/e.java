package com.meizu.cloud.pushsdk.d.f;

/* loaded from: classes23.dex */
public class e {
    private static final java.lang.String a = "e";

    public static long a(java.lang.String str) {
        long j;
        long j2 = 0;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                j = 1;
            } else if (charAt <= 2047) {
                j = 2;
            } else {
                if (charAt >= 55296 && charAt <= 57343) {
                    j2 += 4;
                    i++;
                } else if (charAt < 65535) {
                    j = 3;
                } else {
                    j2 += 4;
                }
                i++;
            }
            j2 += j;
            i++;
        }
        return j2;
    }

    private static java.lang.Object a(java.lang.Object obj) {
        return obj;
    }

    public static java.lang.String a() {
        return java.lang.Long.toString(java.lang.System.currentTimeMillis());
    }

    public static org.json.JSONObject a(java.util.Map map) {
        return new org.json.JSONObject(map);
    }

    public static boolean a(long j, long j2, long j3) {
        return j > j2 - j3;
    }

    public static boolean a(android.content.Context context) {
        try {
            java.lang.String str = a;
            com.meizu.cloud.pushsdk.d.f.c.c(str, "Checking tracker internet connectivity.", new java.lang.Object[0]);
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            com.meizu.cloud.pushsdk.d.f.c.b(str, "Tracker connection online: %s", java.lang.Boolean.valueOf(z));
            return z;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, "Security exception checking connection: %s", e.toString());
            return true;
        }
    }

    public static java.lang.String b() {
        return java.util.UUID.randomUUID().toString();
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, "getCarrier: %s", e.toString());
            return null;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, "getOperator error " + e.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    @android.annotation.TargetApi(19)
    public static android.graphics.Point d(android.content.Context context) {
        android.view.WindowManager windowManager;
        android.graphics.Point point = new android.graphics.Point();
        android.view.Display display = null;
        try {
            windowManager = (android.view.WindowManager) context.getSystemService("window");
        } catch (java.lang.Exception unused) {
            java.lang.String str = a;
            com.meizu.cloud.pushsdk.d.f.c.a(str, "Display.getSize isn't available on older devices.", new java.lang.Object[0]);
            if (display != null) {
                point.x = display.getWidth();
                point.y = display.getHeight();
            } else {
                com.meizu.cloud.pushsdk.d.f.c.a(str, "error get display", new java.lang.Object[0]);
            }
        }
        if (windowManager == null) {
            return null;
        }
        display = windowManager.getDefaultDisplay();
        android.view.Display.class.getMethod("getSize", android.graphics.Point.class);
        display.getSize(point);
        return point;
    }
}
