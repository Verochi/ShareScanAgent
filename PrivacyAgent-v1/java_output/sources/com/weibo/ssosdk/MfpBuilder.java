package com.weibo.ssosdk;

/* loaded from: classes19.dex */
public class MfpBuilder {
    public static final java.lang.String AID_TAG = "weibo_aid_value";
    private static final java.lang.String TAG = "MfpBuilder";

    public static final class BatteryInfo {
        private android.content.Intent batteryInfoIntent;

        private BatteryInfo(android.content.Context context) {
            this.batteryInfoIntent = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        public /* synthetic */ BatteryInfo(android.content.Context context, com.weibo.ssosdk.MfpBuilder.AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private int getHealth() {
            return this.batteryInfoIntent.getIntExtra("health", 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getLevel() {
            return this.batteryInfoIntent.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, 0);
        }

        private int getPlugged() {
            return this.batteryInfoIntent.getIntExtra("plugged", 0);
        }

        private boolean getPresent() {
            return this.batteryInfoIntent.getBooleanExtra("present", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getScale() {
            return this.batteryInfoIntent.getIntExtra("scale", 0);
        }

        private int getStatus() {
            return this.batteryInfoIntent.getIntExtra("status", 0);
        }

        private java.lang.String getTechnology() {
            return this.batteryInfoIntent.getStringExtra("technology");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTemperature() {
            return this.batteryInfoIntent.getIntExtra("temperature", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getVoltage() {
            return this.batteryInfoIntent.getIntExtra("voltage", 0);
        }
    }

    private static void LogD(java.lang.String str) {
    }

    private static void LogE(java.lang.String str) {
    }

    private static java.lang.String bytesToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static java.lang.String genMfpString(android.content.Context context) {
        java.lang.String str;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String os = getOS();
            if (!android.text.TextUtils.isEmpty(os)) {
                jSONObject.put("os", os);
            }
            java.lang.String imei = getImei(context);
            if (!android.text.TextUtils.isEmpty(imei)) {
                jSONObject.put("imei", imei);
            }
            java.lang.String meid = getMeid(context);
            if (!android.text.TextUtils.isEmpty(meid)) {
                jSONObject.put("meid", meid);
            }
            java.lang.String imsi = getImsi(context);
            if (!android.text.TextUtils.isEmpty(imsi)) {
                jSONObject.put("imsi", imsi);
            }
            java.lang.String mac = getMac(context);
            if (!android.text.TextUtils.isEmpty(mac)) {
                jSONObject.put("mac", mac);
            }
            java.lang.String iccid = getIccid(context);
            if (!android.text.TextUtils.isEmpty(iccid)) {
                jSONObject.put(com.umeng.analytics.pro.bo.aa, iccid);
            }
            java.lang.String serialNo = getSerialNo();
            if (!android.text.TextUtils.isEmpty(serialNo)) {
                jSONObject.put("serial", serialNo);
            }
            java.lang.String androidId = getAndroidId(context);
            if (!android.text.TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            java.lang.String cpu = getCpu();
            if (!android.text.TextUtils.isEmpty(cpu)) {
                jSONObject.put("cpu", cpu);
            }
            java.lang.String model = getModel();
            if (!android.text.TextUtils.isEmpty(model)) {
                jSONObject.put("model", model);
            }
            java.lang.String sdSize = getSdSize();
            if (!android.text.TextUtils.isEmpty(sdSize)) {
                jSONObject.put("sdcard", sdSize);
            }
            java.lang.String resolution = getResolution(context);
            if (!android.text.TextUtils.isEmpty(resolution)) {
                jSONObject.put("resolution", resolution);
            }
            java.lang.String ssid = getSsid(context);
            if (!android.text.TextUtils.isEmpty(ssid)) {
                jSONObject.put("ssid", ssid);
            }
            java.lang.String wifiBssid = getWifiBssid(context);
            if (!android.text.TextUtils.isEmpty(wifiBssid)) {
                jSONObject.put("bssid", wifiBssid);
            }
            java.lang.String deviceName = getDeviceName();
            if (!android.text.TextUtils.isEmpty(deviceName)) {
                jSONObject.put("deviceName", deviceName);
            }
            java.lang.String connectType = getConnectType(context);
            if (!android.text.TextUtils.isEmpty(connectType)) {
                jSONObject.put("connecttype", connectType);
            }
            try {
                str = generateUAAid(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double batteryCapacity = getBatteryCapacity(context);
            jSONObject.put("batterymaxcapacity", java.lang.String.valueOf(batteryCapacity));
            jSONObject.put("batterycurrentcapacity", java.lang.String.valueOf(batteryCapacity));
            com.weibo.ssosdk.MfpBuilder.BatteryInfo batteryInfo = new com.weibo.ssosdk.MfpBuilder.BatteryInfo(context, null);
            jSONObject.put("batterycurrentvoltage", batteryInfo.getVoltage());
            jSONObject.put("batterycurrenttemperature", batteryInfo.getTemperature());
            jSONObject.put("batterycurrentcapacity", (batteryCapacity * batteryInfo.getLevel()) / batteryInfo.getScale());
            return jSONObject.toString();
        } catch (org.json.JSONException unused) {
            return "";
        }
    }

    private static java.lang.String generateUAAid(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String packageName = context.getPackageName();
        java.lang.String str = (android.text.TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb.append(android.os.Build.MANUFACTURER);
        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(android.os.Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (java.lang.Exception unused) {
            sb.append("unknown");
        }
        sb.append("__android__android");
        sb.append(android.os.Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static java.lang.String getAndroidId(android.content.Context context) {
        try {
            return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static double getBatteryCapacity(android.content.Context context) {
        java.lang.Object obj;
        try {
            obj = java.lang.Class.forName("com.android.internal.os.PowerProfile").getConstructor(android.content.Context.class).newInstance(context);
        } catch (java.lang.Exception unused) {
            obj = null;
        }
        try {
            return ((java.lang.Double) java.lang.Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", java.lang.String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (java.lang.Exception unused2) {
            return 0.0d;
        }
    }

    private static java.lang.String getConnectType(android.content.Context context) {
        java.lang.String str = "none";
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return str;
    }

    private static java.lang.String getCpu() {
        try {
            return android.os.Build.CPU_ABI;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getDeviceName() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getIccid(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimSerialNumber();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getImei(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getImsi(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getMac(android.content.Context context) {
        android.net.wifi.WifiInfo connectionInfo;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return getMacAddr();
        }
        try {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (java.lang.Exception unused) {
        }
        return "";
    }

    private static java.lang.String getMacAddr() {
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
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getMeid(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getMfp(android.content.Context context) {
        try {
            return new java.lang.String(genMfpString(context).getBytes(), "UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static java.lang.String getModel() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getOS() {
        try {
            return "Android " + android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.security.PublicKey getPublicKey(java.lang.String str) {
        return java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str.getBytes(), 2)));
    }

    private static java.lang.String getResolution(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return java.lang.String.valueOf(displayMetrics.widthPixels) + "*" + java.lang.String.valueOf(displayMetrics.heightPixels);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getSdSize() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return java.lang.Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private static java.lang.String getSerialNo() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return getSerialNoForO();
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @android.annotation.TargetApi(26)
    private static java.lang.String getSerialNoForO() {
        java.lang.String serial;
        try {
            serial = android.os.Build.getSerial();
            return serial;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getSsid(android.content.Context context) {
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getWifiBssid(android.content.Context context) {
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (java.lang.SecurityException unused) {
            return "";
        }
    }

    public static void init(android.content.Context context) {
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return java.lang.Math.min(bArr.length - i, i2);
    }
}
