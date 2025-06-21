package com.getui.gtc.dim.c;

/* loaded from: classes22.dex */
public final class e {
    private static java.lang.Object a(android.os.Parcel parcel) {
        try {
            int dataPosition = parcel.dataPosition();
            int readInt = parcel.readInt();
            parcel.setDataPosition(dataPosition);
            if (readInt > 100) {
                return null;
            }
            java.lang.Class<?> cls = java.lang.Class.forName("android.net.wifi.WifiSsid");
            return ((android.os.Parcelable.Creator) cls.getDeclaredField("CREATOR").get(cls)).createFromParcel(parcel);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("getWifiSsid", th);
            return null;
        }
    }

    public static java.lang.String a(android.net.wifi.WifiInfo wifiInfo) throws org.json.JSONException {
        boolean z;
        org.json.JSONObject jSONObject;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            try {
                wifiInfo.writeToParcel(obtain, 0);
                while (i >= 28 && i <= 33) {
                    obtain.setDataPosition(0);
                    obtain.readInt();
                    obtain.readInt();
                    obtain.readInt();
                    if (i >= 29) {
                        obtain.readInt();
                        obtain.readInt();
                    }
                    if (z) {
                        obtain.readInt();
                    }
                    obtain.readInt();
                    if (obtain.readByte() == 1) {
                        obtain.createByteArray();
                    }
                    java.lang.Object a = obtain.readInt() == 1 ? a(obtain) : null;
                    z = !z && a == null;
                    jSONObject = new org.json.JSONObject();
                    if (a != null) {
                        jSONObject.put("BSSID", obtain.readString());
                    }
                    jSONObject.put("SSID", a(a));
                }
                throw new java.lang.UnsupportedOperationException("cannot read wifiInfo,API>33");
            } finally {
                obtain.recycle();
            }
        }
        jSONObject = b(wifiInfo);
        jSONObject.put("rssi", wifiInfo.getRssi());
        jSONObject.put("toString", wifiInfo.toString());
        return jSONObject.toString();
    }

    private static java.lang.String a(java.lang.Object obj) {
        if (obj != null) {
            java.lang.String obj2 = obj.toString();
            if (!android.text.TextUtils.isEmpty(obj2)) {
                return "\"" + obj2 + "\"";
            }
            java.lang.String b = b(obj);
            if (b != null) {
                return b;
            }
        }
        return "<unknown ssid>";
    }

    private static java.lang.String b(java.lang.Object obj) {
        java.lang.Class<?> cls = obj.getClass();
        try {
            if (android.os.Build.VERSION.SDK_INT < 28) {
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getHexString", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                return (java.lang.String) declaredMethod.invoke(obj, new java.lang.Object[0]);
            }
            java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod("getOctets", new java.lang.Class[0]);
            declaredMethod2.setAccessible(true);
            byte[] bArr = (byte[]) declaredMethod2.invoke(obj, new java.lang.Object[0]);
            java.lang.String str = "0x";
            for (byte b : bArr) {
                str = str + java.lang.String.format(java.util.Locale.US, "%02x", java.lang.Byte.valueOf(b));
            }
            return bArr.length > 0 ? str : "<unknown ssid>";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("getHexString ", th);
            return "<unknown ssid>";
        }
    }

    @android.annotation.SuppressLint({"SoonBlockedPrivateApi", "DiscouragedPrivateApi"})
    private static org.json.JSONObject b(android.net.wifi.WifiInfo wifiInfo) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.reflect.Field declaredField = android.net.wifi.WifiInfo.class.getDeclaredField("mBSSID");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.net.wifi.WifiInfo.class.getDeclaredField("mWifiSsid");
            declaredField2.setAccessible(true);
            jSONObject.put("BSSID", declaredField.get(wifiInfo));
            jSONObject.put("SSID", a(declaredField2.get(wifiInfo)));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("wifiInfo getBelow28", th);
        }
        return jSONObject;
    }
}
