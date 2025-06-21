package com.tanx.onlyid.api;

/* loaded from: classes19.dex */
public final class DeviceID implements com.tanx.onlyid.api.IGetter {
    public android.app.Application a;
    public java.lang.String b;
    public java.lang.String c;

    public static class Holder {
        public static final com.tanx.onlyid.api.DeviceID a = new com.tanx.onlyid.api.DeviceID(null);
    }

    public DeviceID() {
    }

    public /* synthetic */ DeviceID(com.tanx.onlyid.api.DeviceID.AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r4 == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.io.File a(android.content.Context context) {
        int checkSelfPermission;
        int i = android.os.Build.VERSION.SDK_INT;
        boolean z = true;
        if (i >= 23) {
            if (i < 30 && context != null) {
                checkSelfPermission = context.checkSelfPermission(com.anythink.china.common.d.b);
            }
            z = false;
        }
        if (z && "mounted".equals(android.os.Environment.getExternalStorageState())) {
            return new java.io.File(android.os.Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    @android.annotation.SuppressLint({"HardwareIds", "MissingPermission"})
    public static java.lang.String b(android.content.Context context) {
        java.lang.String imei;
        com.tanx.onlyid.api.OAIDLog.print("OnlyId", "getIMEI");
        if (context == null) {
            return "";
        }
        try {
            imei = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getImei();
            return android.text.TextUtils.isEmpty(imei) ? c(context, 0) : imei;
        } catch (java.lang.Error e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return "";
        } catch (java.lang.Exception e2) {
            com.tanx.onlyid.api.OAIDLog.print(e2);
            return "";
        }
    }

    public static java.lang.String c(android.content.Context context, int i) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            return (java.lang.String) telephonyManager.getClass().getMethod("getImei", java.lang.Integer.TYPE).invoke(telephonyManager, java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return "";
        }
    }

    public static java.lang.String calculateHash(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = java.security.MessageDigest.getInstance(str2).digest(str.getBytes());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return "";
        }
    }

    public static java.lang.String d(android.content.Context context) {
        java.lang.String str = "";
        if (context == null) {
            return "";
        }
        java.io.File a = a(context);
        if (a != null) {
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(a));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (java.lang.Exception e) {
                com.tanx.onlyid.api.OAIDLog.print(e);
            }
        }
        com.tanx.onlyid.api.OAIDLog.print("Get uuid from external storage: " + str);
        return str;
    }

    public static java.lang.String e(android.content.Context context) {
        if (context == null) {
            return "";
        }
        java.lang.String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        com.tanx.onlyid.api.OAIDLog.print("Get uuid from shared preferences: " + string);
        return string;
    }

    public static java.lang.String f(android.content.Context context) {
        if (context == null) {
            return "";
        }
        java.lang.String string = android.provider.Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        com.tanx.onlyid.api.OAIDLog.print("Get uuid from system settings: " + string);
        return string;
    }

    public static void g(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return;
        }
        java.io.File a = a(context);
        if (a == null) {
            com.tanx.onlyid.api.OAIDLog.print("UUID file in external storage is null");
            return;
        }
        try {
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(a));
            try {
                if (!a.exists()) {
                    a.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                com.tanx.onlyid.api.OAIDLog.print("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
        }
    }

    @android.annotation.SuppressLint({"HardwareIds"})
    public static java.lang.String getAndroidID(android.content.Context context) {
        java.lang.String string;
        return (context == null || (string = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static java.lang.String getClientId() {
        java.lang.String str = com.tanx.onlyid.api.DeviceID.Holder.a.b;
        return str == null ? "" : str;
    }

    public static java.lang.String getClientIdMD5() {
        return calculateHash(getClientId(), "MD5");
    }

    public static java.lang.String getClientIdSHA1() {
        return calculateHash(getClientId(), "SHA-1");
    }

    public static java.lang.String getGUID(android.content.Context context) {
        java.lang.String f = f(context);
        if (android.text.TextUtils.isEmpty(f)) {
            f = d(context);
        }
        if (android.text.TextUtils.isEmpty(f)) {
            f = e(context);
        }
        if (!android.text.TextUtils.isEmpty(f)) {
            return f;
        }
        java.lang.String uuid = java.util.UUID.randomUUID().toString();
        com.tanx.onlyid.api.OAIDLog.print("Generate uuid by random: " + uuid);
        h(context, uuid);
        i(context, uuid);
        g(context, uuid);
        return uuid;
    }

    public static java.lang.String getOAID() {
        java.lang.String str = com.tanx.onlyid.api.DeviceID.Holder.a.c;
        return str == null ? "" : str;
    }

    public static void getOAID(android.content.Context context, com.tanx.onlyid.api.IGetter iGetter) {
        com.tanx.onlyid.api.impl.OAIDFactory.create(context).doGet(iGetter);
    }

    public static java.lang.String getPseudoID() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(android.os.Build.BOARD.length() % 10);
        sb.append(java.util.Arrays.deepToString(android.os.Build.SUPPORTED_ABIS).length() % 10);
        sb.append(android.os.Build.DEVICE.length() % 10);
        sb.append(android.os.Build.DISPLAY.length() % 10);
        sb.append(android.os.Build.HOST.length() % 10);
        sb.append(android.os.Build.ID.length() % 10);
        sb.append(android.os.Build.MANUFACTURER.length() % 10);
        sb.append(android.os.Build.BRAND.length() % 10);
        sb.append(android.os.Build.MODEL.length() % 10);
        sb.append(android.os.Build.PRODUCT.length() % 10);
        sb.append(android.os.Build.BOOTLOADER.length() % 10);
        sb.append(android.os.Build.HARDWARE.length() % 10);
        sb.append(android.os.Build.TAGS.length() % 10);
        sb.append(android.os.Build.TYPE.length() % 10);
        sb.append(android.os.Build.USER.length() % 10);
        return sb.toString();
    }

    public static java.lang.String getUniqueID(android.content.Context context) {
        int checkSelfPermission;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            com.tanx.onlyid.api.OAIDLog.print("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i >= 23) {
            checkSelfPermission = context.checkSelfPermission(com.anythink.china.common.d.a);
            if (checkSelfPermission != 0) {
                com.tanx.onlyid.api.OAIDLog.print("android.permission.READ_PHONE_STATE not granted");
                return "";
            }
        }
        return b(context);
    }

    public static java.lang.String getWidevineID() {
        try {
            byte[] propertyByteArray = new android.media.MediaDrm(new java.util.UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (java.lang.Error e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
            return "";
        } catch (java.lang.Exception e2) {
            com.tanx.onlyid.api.OAIDLog.print(e2);
            return "";
        }
    }

    public static void h(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        com.tanx.onlyid.api.OAIDLog.print("Save uuid to shared preferences: " + str);
    }

    public static void i(android.content.Context context, java.lang.String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            canWrite = android.provider.Settings.System.canWrite(context);
            if (!canWrite) {
                com.tanx.onlyid.api.OAIDLog.print("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            android.provider.Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            com.tanx.onlyid.api.OAIDLog.print("Save uuid to system settings: " + str);
        } catch (java.lang.Exception e) {
            com.tanx.onlyid.api.OAIDLog.print(e);
        }
    }

    public static void init(android.app.Application application) {
        if (application == null) {
            return;
        }
        com.tanx.onlyid.api.DeviceID.Holder.a.a = application;
    }

    public static boolean supportedOAID(android.content.Context context) {
        return com.tanx.onlyid.api.impl.OAIDFactory.create(context).supported();
    }

    @Override // com.tanx.onlyid.api.IGetter
    public void oaidError(java.lang.Exception exc) {
        java.lang.String widevineID = getWidevineID();
        if (!android.text.TextUtils.isEmpty(widevineID)) {
            this.b = widevineID;
            com.tanx.onlyid.api.OAIDLog.print("Client id is WidevineID: " + this.b);
            return;
        }
        java.lang.String androidID = getAndroidID(this.a);
        if (android.text.TextUtils.isEmpty(androidID)) {
            this.b = getGUID(this.a);
            com.tanx.onlyid.api.OAIDLog.print("Client id is GUID: " + this.b);
            return;
        }
        this.b = androidID;
        com.tanx.onlyid.api.OAIDLog.print("Client id is AndroidID: " + this.b);
    }

    @Override // com.tanx.onlyid.api.IGetter
    public void oaidSucc(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            oaidError(new com.tanx.onlyid.api.OAIDException("OAID is empty"));
            return;
        }
        this.b = str;
        this.c = str;
        com.tanx.onlyid.api.OAIDLog.print("Client id is OAID/AAID: " + this.b);
        com.tanx.onlyid.api.IdStorageManager.getInstance(this.a).putId(com.tanx.onlyid.api.IdStorageManager.KEY_OAID, this.c);
    }
}
