package com.getui.gtc.dim.c;

/* loaded from: classes22.dex */
public final class a {
    private static final java.util.Map<java.lang.String, java.lang.String> c = new com.getui.gtc.dim.c.a.AnonymousClass1();
    public static final java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();
    private static final java.util.Map<java.lang.String, java.lang.String> d = new com.getui.gtc.dim.c.a.AnonymousClass2();
    public static final java.util.Map<java.lang.String, java.lang.String> b = new java.util.HashMap();

    /* renamed from: com.getui.gtc.dim.c.a$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
            put(com.igexin.assist.util.AssistUtils.BRAND_HW, com.alipay.sdk.m.c.a.a);
            put(com.igexin.assist.util.AssistUtils.BRAND_HON, "ro.build.version.magic#ro.build.version.emui");
            put(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI, "ro.build.version.incremental");
            put("redmi", "ro.build.version.incremental");
            put("blackshark", "ro.build.version.incremental");
            put("samsang", "ro.build.version.incremental");
            put(com.igexin.assist.util.AssistUtils.BRAND_VIVO, "ro.vivo.os.version");
            put(com.igexin.assist.util.AssistUtils.BRAND_OPPO, "ro.build.version.opporom#ro.build.version.oplusrom");
            put(com.igexin.assist.util.AssistUtils.BRAND_MZ, "ro.build.display.id");
            put("lenovo", "ro.build.version.incremental");
            put("smartisan", "ro.modversion");
            put("htc", "ro.build.sense.version");
            put("oneplus", "ro.rom.version");
            put("yunos", "ro.cta.yunos.version");
            put("360", "ro.build.uiversion");
            put("nubia", "ro.build.rom.internal.id");
        }
    }

    /* renamed from: com.getui.gtc.dim.c.a$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass2() {
            put(com.igexin.assist.util.AssistUtils.BRAND_HW, "com.android.permission.GET_INSTALLED_APP");
            put(com.igexin.assist.util.AssistUtils.BRAND_HON, "com.android.permission.GET_INSTALLED_APPS");
        }
    }

    /* renamed from: com.getui.gtc.dim.c.a$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.io.FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(java.io.File file, java.lang.String str) {
            try {
                if (file.isDirectory()) {
                    if (str.contains(".")) {
                        return true;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            return false;
        }
    }

    /* renamed from: com.getui.gtc.dim.c.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0300a implements android.content.ServiceConnection {
        boolean a = false;
        final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public class b implements android.os.IInterface {
        private final android.os.IBinder a;

        public b(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public final java.lang.String a() throws android.os.RemoteException {
            java.lang.String str;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (java.lang.Exception e) {
                    com.getui.gtc.dim.e.b.a(e);
                    obtain2.recycle();
                    obtain.recycle();
                    str = null;
                }
                return str;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return this.a;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static android.location.Location a(android.content.Context context, java.lang.String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "network".equals(str) ? "android.permission.ACCESS_COARSE_LOCATION" : "android.permission.ACCESS_FINE_LOCATION", true);
            return ((android.location.LocationManager) context.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION)).getLastKnownLocation(str);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String a() {
        java.lang.Process process;
        java.io.BufferedReader bufferedReader = null;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            process = com.getui.gtc.dim.e.c.a(new java.lang.String(android.util.Base64.decode("aXAgYWRkcg==", 0)));
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (java.util.regex.Pattern.matches("^\\d+: ((wlan\\d+)|(eth\\d+)): .*", readLine)) {
                            java.lang.String substring = readLine.substring(readLine.indexOf(": ") + 2);
                            sb.append(sb.length() == 0 ? "" : ",");
                            sb.append(substring.substring(0, substring.indexOf(": ")));
                            sb.append("#");
                            java.lang.String readLine2 = bufferedReader2.readLine();
                            if (readLine2 != null) {
                                sb.append(readLine2.substring(readLine2.indexOf("link/ether ") + 11, readLine2.indexOf(" brd")));
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (java.lang.Throwable unused2) {
                                }
                            }
                            return "";
                        } finally {
                        }
                    }
                }
                java.lang.String sb2 = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (java.lang.Throwable unused3) {
                }
                try {
                    process.destroy();
                } catch (java.lang.Throwable unused4) {
                }
                return sb2;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            process = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        r3 = r4.getDeviceId(r3);
     */
    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(int i, android.content.Context context) {
        java.lang.String deviceId;
        try {
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                throw new java.lang.RuntimeException("can not get imei above 29");
            }
            if (com.igexin.assist.util.AssistUtils.BRAND_VIVO.equalsIgnoreCase(b()) && i2 < 26) {
                throw new java.lang.RuntimeException("do not get imei from vivo below 29");
            }
            if (i2 < 23) {
                return "";
            }
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            return (telephonyManager == null || i < 0 || deviceId == null) ? "" : deviceId;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                throw new java.lang.RuntimeException("can not get imei above 29");
            }
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            java.lang.String deviceId = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
            return !android.text.TextUtils.isEmpty(deviceId) ? deviceId : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String a(android.content.Context context, boolean z) {
        try {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                throw new java.lang.RuntimeException("can not get oaid at main thread");
            }
            com.getui.gtc.dim.c.d.a();
            com.getui.gtc.dim.c.d.a aVar = com.getui.gtc.dim.c.d.a;
            if (aVar != null && context != null) {
                com.getui.gtc.dim.c.d.b = context.getApplicationContext();
                if (com.getui.gtc.dim.c.d.b()) {
                    com.getui.gtc.dim.c.d.c = aVar.c(com.getui.gtc.dim.c.d.b);
                }
            }
            java.lang.String c2 = com.getui.gtc.dim.c.d.c ? com.getui.gtc.dim.c.d.c() : null;
            if (!"HONOR".equals(com.getui.gtc.dim.c.d.d)) {
                return c2;
            }
            java.lang.String b2 = b(context, z);
            if (b2 == null) {
                b2 = "";
            }
            return b2 + '#' + c2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0168 A[Catch: all -> 0x019d, TryCatch #3 {all -> 0x019d, blocks: (B:6:0x0009, B:9:0x0011, B:10:0x0021, B:12:0x0027, B:19:0x0033, B:21:0x0037, B:23:0x0162, B:25:0x0168, B:26:0x016d, B:28:0x0060, B:30:0x0064, B:31:0x0085, B:33:0x0089, B:34:0x00a7, B:36:0x00ab, B:37:0x00c9, B:54:0x0156, B:65:0x0192, B:67:0x0198), top: B:5:0x0009 }] */
    @com.getui.gtc.base.annotation.MutableMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.util.List<android.telephony.CellInfo> list) {
        java.lang.String str;
        java.util.Iterator<android.telephony.CellInfo> it;
        long j;
        int mcc;
        int mnc;
        int tac;
        long ci;
        java.lang.String str2 = "android.telephony.CellInfoNr";
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.util.Iterator<android.telephony.CellInfo> it2 = list.iterator();
                    long j2 = 0;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (it2.hasNext()) {
                        android.telephony.CellInfo next = it2.next();
                        if (next.isRegistered()) {
                            if (next instanceof android.telephony.CellInfoGsm) {
                                android.telephony.CellIdentityGsm cellIdentity = ((android.telephony.CellInfoGsm) next).getCellIdentity();
                                mcc = cellIdentity.getMcc();
                                mnc = cellIdentity.getMnc();
                                tac = cellIdentity.getLac();
                                ci = cellIdentity.getCid();
                                str = str2;
                                it = it2;
                                i4 = 1;
                            } else {
                                if (next instanceof android.telephony.CellInfoCdma) {
                                    android.telephony.CellIdentityCdma cellIdentity2 = ((android.telephony.CellInfoCdma) next).getCellIdentity();
                                    str = str2;
                                    it = it2;
                                    i4 = 2;
                                    i2 = cellIdentity2.getSystemId();
                                    i3 = cellIdentity2.getNetworkId();
                                    j2 = cellIdentity2.getBasestationId();
                                } else if (next instanceof android.telephony.CellInfoWcdma) {
                                    android.telephony.CellIdentityWcdma cellIdentity3 = ((android.telephony.CellInfoWcdma) next).getCellIdentity();
                                    mcc = cellIdentity3.getMcc();
                                    mnc = cellIdentity3.getMnc();
                                    tac = cellIdentity3.getLac();
                                    ci = cellIdentity3.getCid();
                                    str = str2;
                                    it = it2;
                                    i4 = 4;
                                } else if (next instanceof android.telephony.CellInfoLte) {
                                    android.telephony.CellIdentityLte cellIdentity4 = ((android.telephony.CellInfoLte) next).getCellIdentity();
                                    mcc = cellIdentity4.getMcc();
                                    mnc = cellIdentity4.getMnc();
                                    tac = cellIdentity4.getTac();
                                    ci = cellIdentity4.getCi();
                                    str = str2;
                                    it = it2;
                                    i4 = 3;
                                } else if (str2.equals(next.getClass().getName())) {
                                    try {
                                        java.lang.reflect.Method method = java.lang.Class.forName(str2).getMethod("getCellIdentity", new java.lang.Class[0]);
                                        java.lang.Class<?> cls = java.lang.Class.forName("android.telephony.CellIdentityNr");
                                        str = str2;
                                        try {
                                            java.lang.reflect.Method method2 = cls.getMethod("getMccString", new java.lang.Class[0]);
                                            it = it2;
                                            try {
                                                java.lang.reflect.Method method3 = cls.getMethod("getMncString", new java.lang.Class[0]);
                                                j = j2;
                                                try {
                                                    java.lang.reflect.Method method4 = cls.getMethod("getTac", new java.lang.Class[0]);
                                                    java.lang.reflect.Method method5 = cls.getMethod("getNci", new java.lang.Class[0]);
                                                    java.lang.Object invoke = method.invoke(next, new java.lang.Object[0]);
                                                    java.lang.String str3 = (java.lang.String) method2.invoke(invoke, new java.lang.Object[0]);
                                                    java.lang.String str4 = (java.lang.String) method3.invoke(invoke, new java.lang.Object[0]);
                                                    i = java.lang.Integer.parseInt(str3);
                                                    i2 = java.lang.Integer.parseInt(str4);
                                                    i3 = ((java.lang.Integer) method4.invoke(invoke, new java.lang.Object[0])).intValue();
                                                    j2 = ((java.lang.Long) method5.invoke(invoke, new java.lang.Object[0])).longValue();
                                                    i4 = 6;
                                                } catch (java.lang.Throwable th) {
                                                    th = th;
                                                    com.getui.gtc.dim.e.b.b(th);
                                                    j2 = j;
                                                    if (sb.length() != 0) {
                                                    }
                                                    sb.append(i);
                                                    sb.append("|");
                                                    sb.append(i2);
                                                    sb.append("|");
                                                    sb.append(i3);
                                                    sb.append("|");
                                                    sb.append(j2);
                                                    sb.append("|");
                                                    sb.append(i4);
                                                    it2 = it;
                                                    str2 = str;
                                                }
                                            } catch (java.lang.Throwable th2) {
                                                th = th2;
                                                j = j2;
                                                com.getui.gtc.dim.e.b.b(th);
                                                j2 = j;
                                                if (sb.length() != 0) {
                                                }
                                                sb.append(i);
                                                sb.append("|");
                                                sb.append(i2);
                                                sb.append("|");
                                                sb.append(i3);
                                                sb.append("|");
                                                sb.append(j2);
                                                sb.append("|");
                                                sb.append(i4);
                                                it2 = it;
                                                str2 = str;
                                            }
                                        } catch (java.lang.Throwable th3) {
                                            th = th3;
                                            it = it2;
                                            j = j2;
                                            com.getui.gtc.dim.e.b.b(th);
                                            j2 = j;
                                            if (sb.length() != 0) {
                                            }
                                            sb.append(i);
                                            sb.append("|");
                                            sb.append(i2);
                                            sb.append("|");
                                            sb.append(i3);
                                            sb.append("|");
                                            sb.append(j2);
                                            sb.append("|");
                                            sb.append(i4);
                                            it2 = it;
                                            str2 = str;
                                        }
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        str = str2;
                                    }
                                } else {
                                    str = str2;
                                    it = it2;
                                }
                                if (sb.length() != 0) {
                                    sb.append(",");
                                }
                                sb.append(i);
                                sb.append("|");
                                sb.append(i2);
                                sb.append("|");
                                sb.append(i3);
                                sb.append("|");
                                sb.append(j2);
                                sb.append("|");
                                sb.append(i4);
                                it2 = it;
                                str2 = str;
                            }
                            int i5 = tac;
                            i = mcc;
                            long j3 = ci;
                            i2 = mnc;
                            i3 = i5;
                            j2 = j3;
                            if (sb.length() != 0) {
                            }
                            sb.append(i);
                            sb.append("|");
                            sb.append(i2);
                            sb.append("|");
                            sb.append(i3);
                            sb.append("|");
                            sb.append(j2);
                            sb.append("|");
                            sb.append(i4);
                            it2 = it;
                            str2 = str;
                        }
                    }
                    if (sb.length() > 0) {
                        return sb.toString();
                    }
                }
            } catch (java.lang.Throwable th5) {
                com.getui.gtc.dim.e.b.a(th5);
            }
        }
        return "0|0|0|0|0";
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String b() {
        try {
            return android.os.Build.BRAND;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String b(int i, android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                throw new java.lang.RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            java.lang.Object a2 = com.getui.gtc.dim.e.c.a(i, "getSubscriberId", context);
            return a2 != null ? (java.lang.String) a2 : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String b(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                throw new java.lang.RuntimeException("can not get imsi above 29");
            }
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            java.lang.String subscriberId = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
            return !android.text.TextUtils.isEmpty(subscriberId) ? subscriberId : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
            if (!com.getui.gtc.dim.e.c.c(context)) {
                return "2##";
            }
            int i = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo().gateway;
            java.lang.String b2 = com.getui.gtc.dim.e.c.b((i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255));
            return "1#" + str.replace("\"", "") + "#" + b2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    private static java.lang.String b(android.content.Context context, boolean z) {
        if (!z) {
            try {
                if (com.getui.gtc.dim.c.d.i.c()) {
                    com.getui.gtc.dim.e.b.a("support honor oaid");
                    return "";
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.a(th);
            }
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.RuntimeException("can not get oaid at main thread");
        }
        com.getui.gtc.dim.c.d.h hVar = new com.getui.gtc.dim.c.d.h();
        if (hVar.a(context)) {
            hVar.c(context);
            return hVar.b(context);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(int i, android.content.Context context) {
        int i2;
        android.telephony.SubscriptionManager from;
        android.telephony.SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        android.database.Cursor cursor = null;
        int i3 = -1;
        try {
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            try {
                if (android.os.Build.VERSION.SDK_INT >= 22) {
                    from = android.telephony.SubscriptionManager.from(context);
                    activeSubscriptionInfoForSimSlotIndex = from.getActiveSubscriptionInfoForSimSlotIndex(i);
                    i2 = activeSubscriptionInfoForSimSlotIndex.getSubscriptionId();
                } else {
                    i2 = -1;
                }
                if (i2 == -1) {
                    try {
                        throw new java.lang.RuntimeException("invalid subId");
                    } catch (java.lang.Throwable unused) {
                        i3 = i2;
                        cursor = context.getContentResolver().query(android.net.Uri.parse("content://telephony/siminfo"), new java.lang.String[]{"_id", "sim_id"}, "sim_id = ?", new java.lang.String[]{java.lang.String.valueOf(i)}, null);
                        i2 = (cursor == null || !cursor.moveToFirst()) ? i3 : cursor.getInt(cursor.getColumnIndex("_id"));
                        if (cursor != null) {
                        }
                    }
                }
            } catch (java.lang.Throwable unused2) {
            }
            if (cursor != null) {
                return i2;
            }
            cursor.close();
            return i2;
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.dim.e.b.a(th);
                return i3;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String c() {
        try {
            return android.os.Build.MODEL;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String c(android.content.Context context) {
        java.lang.Throwable th;
        java.lang.String str;
        try {
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            str = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimSerialNumber();
            if (android.text.TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    if (str.length() < 20) {
                        return "";
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.getui.gtc.dim.e.b.a(th);
                return str;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            str = "";
        }
        return str;
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String d() {
        try {
            java.lang.String b2 = b();
            if (!android.text.TextUtils.isEmpty(b2)) {
                java.lang.String lowerCase = b2.toLowerCase();
                java.util.Map<java.lang.String, java.lang.String> map = a;
                if (map.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map.get(lowerCase), "");
                }
                java.util.Map<java.lang.String, java.lang.String> map2 = c;
                if (map2.containsKey(lowerCase)) {
                    return com.getui.gtc.dim.e.c.a(map2.get(lowerCase), "");
                }
            }
            java.lang.String e = e();
            if (!android.text.TextUtils.isEmpty(e)) {
                java.lang.String lowerCase2 = e.toLowerCase();
                java.util.Map<java.lang.String, java.lang.String> map3 = a;
                if (map3.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map3.get(lowerCase2), "");
                }
                java.util.Map<java.lang.String, java.lang.String> map4 = c;
                if (map4.containsKey(lowerCase2)) {
                    return com.getui.gtc.dim.e.c.a(map4.get(lowerCase2), "");
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return "";
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String d(int i, android.content.Context context) {
        java.lang.String str = "";
        try {
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            java.lang.Object a2 = com.getui.gtc.dim.e.c.a(i, "getSimSerialNumber", context);
            java.lang.String str2 = a2 != null ? (java.lang.String) a2 : "";
            try {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    if (str2.length() < 20) {
                        return "";
                    }
                }
                return str2;
            } catch (java.lang.Throwable th) {
                str = str2;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                return str;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String d(android.content.Context context) {
        try {
            return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String e() {
        try {
            return android.os.Build.MANUFACTURER;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String e(android.content.Context context) {
        try {
            if (com.getui.gtc.base.util.CommonUtil.isMainThread()) {
                throw new java.lang.RuntimeException("cannot get advertisingId from main thread");
            }
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            com.getui.gtc.dim.c.a.ServiceConnectionC0300a serviceConnectionC0300a = new com.getui.gtc.dim.c.a.ServiceConnectionC0300a();
            if (!context.bindService(intent, serviceConnectionC0300a, 1)) {
                throw new java.io.IOException("Google Play connection failed");
            }
            try {
                if (serviceConnectionC0300a.a) {
                    throw new java.lang.IllegalStateException();
                }
                serviceConnectionC0300a.a = true;
                return new com.getui.gtc.dim.c.a.b(serviceConnectionC0300a.b.poll(3000L, java.util.concurrent.TimeUnit.MILLISECONDS)).a();
            } finally {
                context.unbindService(serviceConnectionC0300a);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String f() {
        try {
            return android.os.Build.VERSION.RELEASE;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String f(android.content.Context context) {
        java.lang.Object invoke;
        try {
            com.getui.gtc.dim.e.c.a(context, com.anythink.china.common.d.a, true);
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 26) {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                invoke = cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, "ro.serialno");
            } else {
                if (i >= 29) {
                    throw new java.lang.RuntimeException("can not get serialnumber above 29");
                }
                java.lang.Class<?> cls2 = java.lang.Class.forName("android.os.Build");
                invoke = cls2.getMethod("getSerial", new java.lang.Class[0]).invoke(cls2, new java.lang.Object[0]);
            }
            return (java.lang.String) invoke;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String g(android.content.Context context) {
        byte[] hardwareAddress;
        java.lang.String str = "";
        try {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
                return ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo().getMacAddress();
            }
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(nextElement.getName()) && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(java.lang.String.format("%02X:", java.lang.Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    str = sb.toString();
                }
            }
            return str;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.getui.gtc.base.annotation.MutableMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<android.content.pm.PackageInfo> g() {
        java.lang.Process process;
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                throw new java.lang.RuntimeException("can not get al by pm above 33");
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            process = com.getui.gtc.dim.e.c.a(new java.lang.String(android.util.Base64.decode("cG0gbGlzdCBwYWNrYWdlcw==", 0)));
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            try {
                                arrayList.add(com.getui.gtc.dim.e.d.a(readLine.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1], 0));
                            } catch (java.lang.Throwable unused) {
                            }
                        } else {
                            try {
                                break;
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            com.getui.gtc.dim.e.b.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (java.lang.Throwable unused4) {
                                }
                            }
                            return java.util.Collections.emptyList();
                        } finally {
                        }
                    }
                }
                bufferedReader.close();
                try {
                    process.destroy();
                } catch (java.lang.Throwable unused5) {
                }
                return arrayList;
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = null;
                th = th;
                com.getui.gtc.dim.e.b.a(th);
                if (bufferedReader != null) {
                }
                if (process != null) {
                }
                return java.util.Collections.emptyList();
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            process = null;
            bufferedReader = null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098 A[RETURN] */
    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String h(android.content.Context context) {
        char c2;
        try {
            java.lang.String simOperator = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
            if (android.text.TextUtils.isEmpty(simOperator)) {
                return "";
            }
            int hashCode = simOperator.hashCode();
            if (hashCode == 49679479) {
                if (simOperator.equals("46009")) {
                    c2 = 6;
                    switch (c2) {
                    }
                }
                c2 = 65535;
                switch (c2) {
                }
            } else {
                if (hashCode != 49679502) {
                    switch (hashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679474:
                            if (simOperator.equals("46004")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679475:
                            if (simOperator.equals("46005")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679476:
                            if (simOperator.equals("46006")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 49679477:
                            if (simOperator.equals("46007")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            return "中国移动";
                        case 4:
                        case 5:
                        case 6:
                            return "中国联通";
                        case 7:
                        case '\b':
                        case '\t':
                            return "中国电信";
                        default:
                            return simOperator;
                    }
                }
                if (simOperator.equals("46011")) {
                    c2 = '\t';
                    switch (c2) {
                    }
                }
                c2 = 65535;
                switch (c2) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.util.List<android.content.pm.PackageInfo> h() {
        try {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                throw new java.lang.RuntimeException("can not get al by us at main thread");
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 10000; i <= 19999; i++) {
                android.content.pm.PackageInfo a2 = com.getui.gtc.dim.e.d.a(i);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return java.util.Collections.emptyList();
        }
    }

    @java.lang.Deprecated
    public static java.lang.String i() {
        return "";
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String i(android.content.Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_NETWORK_STATE", true);
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                throw new java.lang.IllegalStateException("getSystemService: CONNECTIVITY_SERVICE failed");
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                throw new java.lang.IllegalStateException("getActiveNetworkInfo failed");
            }
            if (!activeNetworkInfo.isAvailable()) {
                throw new java.lang.IllegalStateException("no available activeNetwork");
            }
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return "WIFI";
            }
            int subtype = activeNetworkInfo.getSubtype();
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null) {
                subtype = telephonyManager.getNetworkType();
            }
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
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
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "NULL";
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "NULL";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String j(android.content.Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new java.lang.IllegalStateException("network not connected");
            }
            boolean b2 = com.getui.gtc.dim.e.c.b(context);
            boolean c2 = com.getui.gtc.dim.e.c.c(context);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if ((b2 && nextElement.getName().toLowerCase().contains("rmnet")) || (c2 && nextElement.getName().toLowerCase().contains("wlan0"))) {
                    java.util.List<java.net.InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    java.util.Iterator<java.net.InterfaceAddress> it = interfaceAddresses.iterator();
                    while (it.hasNext()) {
                        java.net.InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            arrayList3.add(address.getHostAddress());
                        }
                    }
                    if (b2) {
                        arrayList.addAll(arrayList3);
                    }
                    if (c2) {
                        arrayList2.addAll(arrayList3);
                    }
                }
            }
            if (b2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((java.lang.String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!c2) {
                return "";
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.util.Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((java.lang.String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.lang.String k(android.content.Context context) {
        try {
            if (!com.getui.gtc.dim.e.c.a(context)) {
                throw new java.lang.IllegalStateException("network not connected");
            }
            boolean b2 = com.getui.gtc.dim.e.c.b(context);
            boolean c2 = com.getui.gtc.dim.e.c.c(context);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                java.lang.String lowerCase = nextElement.getName().toLowerCase();
                if ((b2 && (lowerCase.contains("rmnet") || lowerCase.contains("ccmni"))) || (c2 && lowerCase.contains("wlan0"))) {
                    java.util.List<java.net.InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    java.util.Iterator<java.net.InterfaceAddress> it = interfaceAddresses.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        java.net.InetAddress address = it.next().getAddress();
                        if (!address.isLoopbackAddress()) {
                            if (address instanceof java.net.Inet6Address) {
                                arrayList3.add(address.getHostAddress());
                            } else if (address instanceof java.net.Inet4Address) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        if (b2) {
                            arrayList.addAll(arrayList3);
                        }
                        if (c2) {
                            arrayList2.addAll(arrayList3);
                        }
                    }
                }
            }
            if (b2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    sb.append((java.lang.String) it2.next());
                    sb.append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            if (!c2) {
                return "";
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.util.Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                sb2.append((java.lang.String) it3.next());
                sb2.append(",");
            }
            if (sb2.toString().endsWith(",")) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static android.net.wifi.WifiInfo l(android.content.Context context) {
        try {
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_WIFI_STATE", true);
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    java.lang.reflect.Field declaredField = android.net.wifi.WifiInfo.class.getDeclaredField("mIpAddress");
                    declaredField.setAccessible(true);
                    declaredField.set(connectionInfo, null);
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.dim.e.b.a(th);
                }
            }
            return connectionInfo;
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.dim.e.b.a(th2);
            return null;
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.util.List<android.net.wifi.ScanResult> m(android.content.Context context) {
        try {
            if (com.getui.gtc.base.util.CommonUtil.isMainThread()) {
                throw new java.lang.IllegalStateException("cannot get wifi list from the main thread");
            }
            com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION", true);
            java.util.List<android.net.wifi.ScanResult> scanResults = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getScanResults();
            if (scanResults == null || scanResults.size() <= 0) {
                return null;
            }
            return scanResults;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:3:0x0003, B:6:0x000c, B:7:0x0027, B:9:0x0038, B:11:0x003e, B:13:0x0045, B:20:0x0094, B:23:0x00b3, B:25:0x00d2, B:27:0x00d8, B:29:0x00ec, B:31:0x00f1, B:34:0x00f4, B:38:0x0099, B:47:0x0090, B:52:0x0010, B:54:0x0018, B:57:0x001f, B:58:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:3:0x0003, B:6:0x000c, B:7:0x0027, B:9:0x0038, B:11:0x003e, B:13:0x0045, B:20:0x0094, B:23:0x00b3, B:25:0x00d2, B:27:0x00d8, B:29:0x00ec, B:31:0x00f1, B:34:0x00f4, B:38:0x0099, B:47:0x0090, B:52:0x0010, B:54:0x0018, B:57:0x001f, B:58:0x0026), top: B:2:0x0003 }] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String n(android.content.Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        java.lang.StringBuilder sb;
        boolean z;
        int i5;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION", true);
            } else if (!com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !com.getui.gtc.dim.e.c.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                throw new java.lang.IllegalStateException("permission coarse/fine location not granted");
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            java.util.List list = null;
            if (telephonyManager.getSimState() == 5) {
                java.lang.String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator == null || networkOperator.length() < 3) {
                    i = 0;
                    i2 = 0;
                } else {
                    i2 = java.lang.Integer.parseInt(networkOperator.substring(0, 3));
                    i = java.lang.Integer.parseInt(networkOperator.substring(3));
                }
                try {
                    android.telephony.CellLocation cellLocation = telephonyManager.getCellLocation();
                    z = cellLocation instanceof android.telephony.gsm.GsmCellLocation;
                    try {
                        if (z != 0) {
                            int lac = ((android.telephony.gsm.GsmCellLocation) cellLocation).getLac();
                            i3 = ((android.telephony.gsm.GsmCellLocation) cellLocation).getCid();
                            i5 = lac;
                        } else if (cellLocation instanceof android.telephony.cdma.CdmaCellLocation) {
                            int networkId = ((android.telephony.cdma.CdmaCellLocation) cellLocation).getNetworkId();
                            if (i == 0) {
                                i = ((android.telephony.cdma.CdmaCellLocation) cellLocation).getSystemId();
                            }
                            i3 = ((android.telephony.cdma.CdmaCellLocation) cellLocation).getBaseStationId();
                            i5 = networkId;
                        } else {
                            i3 = 0;
                            i5 = 0;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.getui.gtc.dim.e.b.a(th);
                        i3 = 0;
                        i5 = z;
                        if (android.os.Build.VERSION.SDK_INT < 29) {
                        }
                        sb = new java.lang.StringBuilder();
                        sb.append(i2);
                        sb.append("|");
                        sb.append(i);
                        sb.append("|");
                        sb.append(i4);
                        sb.append("|");
                        sb.append(i3);
                        sb.append("|");
                        while (list != null) {
                            sb.append(((android.telephony.NeighboringCellInfo) list.get(r6)).getCid());
                            if (r6 >= list.size() - 1) {
                            }
                        }
                        return sb.toString();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    z = 0;
                }
                if (android.os.Build.VERSION.SDK_INT < 29) {
                    i4 = i5;
                } else {
                    list = (java.util.List) telephonyManager.getClass().getMethod("getNeighboringCellInfo", new java.lang.Class[0]).invoke(telephonyManager, new java.lang.Object[0]);
                    i4 = i5;
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            sb = new java.lang.StringBuilder();
            sb.append(i2);
            sb.append("|");
            sb.append(i);
            sb.append("|");
            sb.append(i4);
            sb.append("|");
            sb.append(i3);
            sb.append("|");
            for (int i6 = 0; list != null && i6 < list.size(); i6++) {
                sb.append(((android.telephony.NeighboringCellInfo) list.get(i6)).getCid());
                if (i6 >= list.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.dim.e.b.a(th3);
            return "0|0|0|0|";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    @android.annotation.SuppressLint({"MissingPermission"})
    public static java.lang.String o(android.content.Context context) {
        try {
            if (com.getui.gtc.base.util.CommonUtil.hasPermission(context, android.os.Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", true)) {
                return a(((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getAllCellInfo());
            }
            throw new java.lang.RuntimeException("not has location permission");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return "0|0|0|0|0";
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.util.List<android.content.pm.PackageInfo> p(android.content.Context context) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(com.getui.gtc.dim.e.d.a(it.next().activityInfo.packageName, 0));
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return java.util.Collections.emptyList();
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.util.List<android.content.pm.PackageInfo> q(android.content.Context context) {
        java.lang.String str;
        try {
            java.lang.String lowerCase = b().toLowerCase();
            java.util.Map<java.lang.String, java.lang.String> map = b;
            if (map.containsKey(lowerCase)) {
                str = map.get(lowerCase);
            } else {
                java.util.Map<java.lang.String, java.lang.String> map2 = d;
                if (!map2.containsKey(lowerCase)) {
                    throw new java.lang.RuntimeException("not support brand: ".concat(java.lang.String.valueOf(lowerCase)));
                }
                str = map2.get(lowerCase);
            }
            com.getui.gtc.dim.e.c.a(context, str, false);
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return (java.util.List) packageManager.getClass().getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 0)), java.lang.Integer.TYPE).invoke(packageManager, 5);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return java.util.Collections.emptyList();
        }
    }

    @com.getui.gtc.base.annotation.MutableMethod
    public static java.util.List<android.content.pm.PackageInfo> r(android.content.Context context) {
        java.lang.String[] list;
        java.io.File parentFile;
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            throw new java.lang.RuntimeException("can not get localDirs above 29");
        }
        java.io.File externalCacheDir = context.getExternalCacheDir();
        java.io.File parentFile2 = (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null) ? null : parentFile.getParentFile();
        if (parentFile2 != null && parentFile2.isDirectory() && (list = parentFile2.list(new com.getui.gtc.dim.c.a.AnonymousClass3())) != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : list) {
                try {
                    arrayList.add(com.getui.gtc.dim.e.d.a(str, 0));
                } catch (java.lang.Throwable unused) {
                }
            }
            return arrayList;
        }
        return java.util.Collections.emptyList();
    }
}
