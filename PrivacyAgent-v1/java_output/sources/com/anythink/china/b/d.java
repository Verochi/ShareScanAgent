package com.anythink.china.b;

/* loaded from: classes12.dex */
public final class d {
    public static java.lang.String a() {
        try {
            for (java.net.NetworkInterface networkInterface : java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
                    }
                    if (!android.text.TextUtils.isEmpty(sb)) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static java.lang.String a(android.content.Context context) {
        android.net.wifi.WifiInfo wifiInfo;
        if (context == null) {
            return "";
        }
        try {
            wifiInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        java.lang.String macAddress = wifiInfo.getMacAddress();
        return !android.text.TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(java.util.Locale.ENGLISH) : macAddress;
    }

    private static java.lang.String b(android.content.Context context) {
        return com.anythink.core.common.b.o.a().c("mac") ? "" : android.os.Build.VERSION.SDK_INT < 23 ? a(context) : a();
    }
}
