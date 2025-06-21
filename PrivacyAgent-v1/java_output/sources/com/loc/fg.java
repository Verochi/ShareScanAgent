package com.loc;

/* loaded from: classes23.dex */
public final class fg {
    public static java.lang.String a(android.net.wifi.WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getBSSID();
    }

    public static java.lang.String b(android.net.wifi.WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }

    public static int c(android.net.wifi.WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        return wifiInfo.getRssi();
    }
}
