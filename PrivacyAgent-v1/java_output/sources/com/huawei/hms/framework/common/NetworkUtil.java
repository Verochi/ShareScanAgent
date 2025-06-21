package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final java.lang.String STR_NSA = "5G_NSA";
    private static final java.lang.String STR_SA = "5G_SA";
    private static final java.lang.String TAG = "NetworkUtil";
    private static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;

    /* renamed from: com.huawei.hms.framework.common.NetworkUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.security.PrivilegedAction {
        final /* synthetic */ java.lang.reflect.Method val$method;

        public AnonymousClass1(java.lang.reflect.Method method) {
            this.val$method = method;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            this.val$method.setAccessible(true);
            return null;
        }
    }

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static final class SignalType {
        public static final java.lang.String LTE_CQI = "lteCqi";
        public static final java.lang.String LTE_DBM = "lteDbm";
        public static final java.lang.String LTE_RSRP = "lteRsrp";
        public static final java.lang.String LTE_RSRQ = "lteRsrq";
        public static final java.lang.String LTE_RSSI = "lteRssi";
        public static final java.lang.String LTE_RSSNR = "lteRssnr";
        public static final java.lang.String NR_CSIRSRP = "nrCSIRsrp";
        public static final java.lang.String NR_CSIRSRQ = "nrCSIRsrq";
        public static final java.lang.String NR_CSISINR = "nrCSISinr";
        public static final java.lang.String NR_DBM = "nrDbm";
        public static final java.lang.String NR_SSRSRP = "nrSSRsrp";
        public static final java.lang.String NR_SSRSRQ = "nrSSRsrq";
        public static final java.lang.String NR_SSSINR = "nrSSSinr";
    }

    public static java.lang.String getDnsServerIps(android.content.Context context) {
        return java.util.Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private static java.lang.String[] getDnsServerIpsFromConnectionManager(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        android.net.NetworkInfo networkInfo;
        android.net.LinkProperties linkProperties;
        java.util.LinkedList linkedList = new java.util.LinkedList();
        if (context != null && (connectivityManager = (android.net.ConnectivityManager) com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "connectivity")) != null) {
            try {
                android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    for (android.net.Network network : connectivityManager.getAllNetworks()) {
                        if (network != null && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType() && (linkProperties = connectivityManager.getLinkProperties(network)) != null) {
                            java.util.Iterator<java.net.InetAddress> it = linkProperties.getDnsServers().iterator();
                            while (it.hasNext()) {
                                linkedList.add(it.next().getHostAddress());
                            }
                        }
                    }
                }
            } catch (java.lang.SecurityException e) {
                com.huawei.hms.framework.common.Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName());
            } catch (java.lang.RuntimeException e2) {
                com.huawei.hms.framework.common.Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e2.getClass().getSimpleName());
            }
        }
        return linkedList.isEmpty() ? new java.lang.String[0] : (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
    }

    public static java.lang.String getHost(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new java.net.URI(str).getHost();
        } catch (java.net.URISyntaxException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, e.getClass().getSimpleName());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        r3 = r3.getServiceState();
     */
    @android.annotation.SuppressLint({"MissingPermission", "NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getHwNetworkType(android.content.Context context) {
        android.telephony.ServiceState serviceState;
        if (!com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(com.huawei.hms.framework.common.EmuiUtil.BUILDEX_VERSION) || context == null || (r3 = (android.telephony.TelephonyManager) com.huawei.hms.framework.common.ContextCompat.getSystemService(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)) == null) {
            return 0;
        }
        try {
            if (com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT < 21 || serviceState == null) {
                return 0;
            }
            return com.huawei.android.telephony.ServiceStateEx.getConfigRadioTechnology(serviceState);
        } catch (java.lang.NoClassDefFoundError unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "NoClassDefFoundError occur in method getHwNetworkType.");
            return 0;
        } catch (java.lang.NoSuchMethodError unused2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "NoSuchMethodError occur in method getHwNetworkType.");
            return 0;
        } catch (java.lang.SecurityException unused3) {
            com.huawei.hms.framework.common.Logger.w(TAG, "requires permission maybe missing.");
            return 0;
        }
    }

    public static int getInfoWithReflect(android.telephony.SignalStrength signalStrength, java.lang.String str) {
        try {
            if (android.os.Build.VERSION.SDK_INT > 28) {
                return Integer.MAX_VALUE;
            }
            java.lang.reflect.Method declaredMethod = android.telephony.SignalStrength.class.getDeclaredMethod(str, new java.lang.Class[0]);
            java.security.AccessController.doPrivileged(new com.huawei.hms.framework.common.NetworkUtil.AnonymousClass1(declaredMethod));
            return ((java.lang.Integer) declaredMethod.invoke(signalStrength, new java.lang.Object[0])).intValue();
        } catch (java.lang.IllegalAccessException unused) {
            com.huawei.hms.framework.common.Logger.i(TAG, str + " : cannot access");
            return Integer.MAX_VALUE;
        } catch (java.lang.NoSuchMethodException unused2) {
            com.huawei.hms.framework.common.Logger.i(TAG, str + " : function not found");
            return Integer.MAX_VALUE;
        } catch (java.lang.reflect.InvocationTargetException unused3) {
            com.huawei.hms.framework.common.Logger.i(TAG, str + " : InvocationTargetException");
            return Integer.MAX_VALUE;
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, str + " : throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    public static int getLteCqi(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int cqi;
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteCqi: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            return getInfoWithReflect(signalStrength, "getLteCqi");
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
        if (cellSignalStrengths.size() > 0) {
            cqi = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
            return cqi;
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrp(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int rsrp;
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRsrp: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            return getInfoWithReflect(signalStrength, "getLteRsrp");
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
        if (cellSignalStrengths.size() > 0) {
            rsrp = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
            return rsrp;
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRsrq(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int rsrq;
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRsrq: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            return getInfoWithReflect(signalStrength, "getLteRsrq");
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
        if (cellSignalStrengths.size() > 0) {
            rsrq = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
            return rsrq;
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssi(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int rssi;
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            if (android.os.Build.VERSION.SDK_INT > 28) {
                cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    rssi = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                    return rssi;
                }
            }
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
        }
        return Integer.MAX_VALUE;
    }

    public static int getLteRssnr(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int rssnr;
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRssnr: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            return getInfoWithReflect(signalStrength, "getLteRssnr");
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
        if (cellSignalStrengths.size() > 0) {
            rssnr = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
            return rssnr;
        }
        return Integer.MAX_VALUE;
    }

    public static java.util.Map<java.lang.String, java.lang.Integer> getLteSignalInfo(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int rsrp;
        int rsrq;
        int rssnr;
        int cqi;
        int rssi;
        java.util.HashMap hashMap = new java.util.HashMap();
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return hashMap;
        }
        try {
            if (android.os.Build.VERSION.SDK_INT > 28) {
                cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
                if (cellSignalStrengths.size() > 0) {
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_DBM, java.lang.Integer.valueOf(((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getDbm()));
                    rsrp = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrp();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSRP, java.lang.Integer.valueOf(rsrp));
                    rsrq = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRsrq();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSRQ, java.lang.Integer.valueOf(rsrq));
                    rssnr = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssnr();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSSNR, java.lang.Integer.valueOf(rssnr));
                    cqi = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getCqi();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_CQI, java.lang.Integer.valueOf(cqi));
                    rssi = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths.get(0)).getRssi();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSSI, java.lang.Integer.valueOf(rssi));
                }
            } else {
                hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_DBM, java.lang.Integer.valueOf(getInfoWithReflect(signalStrength, "getDbm")));
                hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSRP, java.lang.Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrp")));
                hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSRQ, java.lang.Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRsrq")));
                hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_RSSNR, java.lang.Integer.valueOf(getInfoWithReflect(signalStrength, "getLteRssnr")));
                hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.LTE_CQI, java.lang.Integer.valueOf(getInfoWithReflect(signalStrength, "getLteCqi")));
            }
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
        }
        return hashMap;
    }

    public static java.lang.String getMNC(android.content.Context context) {
        if (context == null || !isSimReady(context)) {
            return "unknown";
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        android.telephony.TelephonyManager telephonyManager = systemService instanceof android.telephony.TelephonyManager ? (android.telephony.TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            com.huawei.hms.framework.common.Logger.e(TAG, "getSubscriptionOperatorType: other error!");
            return "unknown";
        }
        java.lang.String networkOperator = telephonyManager.getNetworkOperator();
        return ("46001".equals(networkOperator) || "46006".equals(networkOperator) || "46009".equals(networkOperator)) ? "China_Unicom" : ("46000".equals(networkOperator) || "46002".equals(networkOperator) || "46004".equals(networkOperator) || "46007".equals(networkOperator)) ? "China_Mobile" : ("46003".equals(networkOperator) || "46005".equals(networkOperator) || "46011".equals(networkOperator)) ? "China_Telecom" : "other";
    }

    public static int getMobileRsrp(android.content.Context context) {
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return Integer.MAX_VALUE;
        }
        try {
            return android.os.Build.VERSION.SDK_INT > 28 ? getMobileSingalStrengthUpPPlatfrom(context) : getInfoWithReflect(signalStrength, "getDbm");
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getDbm: throwable:" + th.getClass());
            return Integer.MAX_VALUE;
        }
    }

    private static int getMobileSingalStrengthUpPPlatfrom(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        java.util.List cellSignalStrengths2;
        java.util.List cellSignalStrengths3;
        int dbm;
        java.util.List cellSignalStrengths4;
        java.util.List cellSignalStrengths5;
        int i = Integer.MAX_VALUE;
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        int networkType = getNetworkType(context);
        try {
            if (networkType == 3) {
                cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthCdma.class);
                if (cellSignalStrengths.size() > 0) {
                    dbm = ((android.telephony.CellSignalStrengthCdma) cellSignalStrengths.get(0)).getDbm();
                } else {
                    cellSignalStrengths2 = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthTdscdma.class);
                    if (cellSignalStrengths2.size() > 0) {
                        dbm = ((android.telephony.CellSignalStrengthTdscdma) cellSignalStrengths2.get(0)).getDbm();
                    } else {
                        cellSignalStrengths3 = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthWcdma.class);
                        if (cellSignalStrengths3.size() <= 0) {
                            return Integer.MAX_VALUE;
                        }
                        dbm = ((android.telephony.CellSignalStrengthWcdma) cellSignalStrengths3.get(0)).getDbm();
                    }
                }
            } else if (networkType == 4) {
                cellSignalStrengths4 = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthLte.class);
                if (cellSignalStrengths4.size() <= 0) {
                    return Integer.MAX_VALUE;
                }
                dbm = ((android.telephony.CellSignalStrengthLte) cellSignalStrengths4.get(0)).getDbm();
            } else {
                if (networkType != 5) {
                    return Integer.MAX_VALUE;
                }
                cellSignalStrengths5 = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
                if (cellSignalStrengths5.size() <= 0) {
                    return Integer.MAX_VALUE;
                }
                dbm = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths5.get(0)).getDbm();
            }
            i = dbm;
            return i;
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getMobileSingalStrength: throwable:" + th.getClass());
            return i;
        }
    }

    public static java.lang.String getNetWorkNSAorSA() {
        try {
            android.telephony.HwTelephonyManager hwTelephonyManager = android.telephony.HwTelephonyManager.getDefault();
            int default4GSlotId = hwTelephonyManager.getDefault4GSlotId();
            java.lang.String str = TAG;
            com.huawei.hms.framework.common.Logger.v(str, "phoneId " + default4GSlotId);
            boolean isNsaState = hwTelephonyManager.isNsaState(default4GSlotId);
            com.huawei.hms.framework.common.Logger.v(str, "isNsa " + isNsaState);
            return isNsaState ? STR_NSA : STR_SA;
        } catch (java.lang.Throwable unused) {
            com.huawei.hms.framework.common.Logger.v(TAG, "isNsaState error");
            return null;
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static android.net.NetworkInfo getNetworkInfo(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager;
        if (!com.huawei.hms.framework.common.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (android.net.ConnectivityManager) com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
            return null;
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static android.net.NetworkInfo.DetailedState getNetworkStatus(android.content.Context context) {
        android.net.NetworkInfo.DetailedState detailedState = android.net.NetworkInfo.DetailedState.IDLE;
        if (context != null) {
            java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof android.net.ConnectivityManager) {
                try {
                    if (!com.huawei.hms.framework.common.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                        return detailedState;
                    }
                    android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        detailedState = activeNetworkInfo.getDetailedState();
                    } else {
                        com.huawei.hms.framework.common.Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
                    }
                } catch (java.lang.RuntimeException e) {
                    com.huawei.hms.framework.common.Logger.i(TAG, "getNetworkStatus exception" + e.getClass().getSimpleName() + e.getMessage());
                }
            } else {
                com.huawei.hms.framework.common.Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
            }
        }
        return detailedState;
    }

    public static int getNetworkType(android.content.Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context), context);
        }
        return 0;
    }

    public static int getNetworkType(android.net.NetworkInfo networkInfo) {
        return getNetworkType(networkInfo, null);
    }

    public static int getNetworkType(android.net.NetworkInfo networkInfo, android.content.Context context) {
        int i;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int hwNetworkType = getHwNetworkType(context);
        com.huawei.hms.framework.common.Logger.v(TAG, "getHwNetworkType return is: " + hwNetworkType);
        if (hwNetworkType == 0) {
            hwNetworkType = networkInfo.getSubtype();
        }
        if (hwNetworkType != 20) {
            switch (hwNetworkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i = 2;
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
                    i = 3;
                    break;
                case 13:
                    i = 4;
                    break;
                default:
                    i = 0;
                    break;
            }
        } else {
            i = 5;
        }
        if (i != 0 || android.os.Build.VERSION.SDK_INT < 25) {
            return i;
        }
        if (hwNetworkType != 16) {
            return hwNetworkType != 17 ? 0 : 3;
        }
        return 2;
    }

    public static int getNrCsiRsrp(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int csiRsrp;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrCsiRsrp: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            csiRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp();
            return csiRsrp;
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiRsrq(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int csiRsrq;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrCsiRsrq: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            csiRsrq = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq();
            return csiRsrq;
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrCsiSinr(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int csiSinr;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrCsiSinr: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            csiSinr = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr();
            return csiSinr;
        }
        return Integer.MAX_VALUE;
    }

    public static java.util.Map<java.lang.String, java.lang.Integer> getNrSignalInfo(android.content.Context context) {
        java.util.List cellSignalStrengths;
        int dbm;
        int csiRsrp;
        int csiRsrq;
        int csiSinr;
        int ssRsrp;
        int ssRsrq;
        int ssSinr;
        java.util.HashMap hashMap = new java.util.HashMap();
        android.telephony.SignalStrength signalStrength = getSignalStrength(context);
        if (signalStrength == null) {
            return hashMap;
        }
        try {
            if (android.os.Build.VERSION.SDK_INT > 28) {
                cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
                if (cellSignalStrengths.size() > 0) {
                    dbm = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getDbm();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_DBM, java.lang.Integer.valueOf(dbm));
                    csiRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrp();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_CSIRSRP, java.lang.Integer.valueOf(csiRsrp));
                    csiRsrq = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiRsrq();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_CSIRSRQ, java.lang.Integer.valueOf(csiRsrq));
                    csiSinr = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getCsiSinr();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_CSISINR, java.lang.Integer.valueOf(csiSinr));
                    ssRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_SSRSRP, java.lang.Integer.valueOf(ssRsrp));
                    ssRsrq = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_SSRSRQ, java.lang.Integer.valueOf(ssRsrq));
                    ssSinr = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr();
                    hashMap.put(com.huawei.hms.framework.common.NetworkUtil.SignalType.NR_SSSINR, java.lang.Integer.valueOf(ssSinr));
                }
            }
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
        }
        return hashMap;
    }

    public static int getNrSsRsrp(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int ssRsrp;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrSsRsrp: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            ssRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrp();
            return ssRsrp;
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsRsrq(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int ssRsrq;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrSsRsrq: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            ssRsrq = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsRsrq();
            return ssRsrq;
        }
        return Integer.MAX_VALUE;
    }

    public static int getNrSsSinr(android.content.Context context) {
        android.telephony.SignalStrength signalStrength;
        java.util.List cellSignalStrengths;
        int ssSinr;
        try {
        } catch (java.lang.Throwable th) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getNrSsSinr: throwable:" + th.getClass());
        }
        if (android.os.Build.VERSION.SDK_INT <= 28 || (signalStrength = getSignalStrength(context)) == null) {
            return Integer.MAX_VALUE;
        }
        cellSignalStrengths = signalStrength.getCellSignalStrengths(android.telephony.CellSignalStrengthNr.class);
        if (cellSignalStrengths.size() > 0) {
            ssSinr = ((android.telephony.CellSignalStrengthNr) cellSignalStrengths.get(0)).getSsSinr();
            return ssSinr;
        }
        return Integer.MAX_VALUE;
    }

    public static int getPrimaryNetworkType(android.content.Context context) {
        return groupNetworkType(getNetworkType(getNetworkInfo(context), context));
    }

    public static int getPrimaryNetworkType(android.net.NetworkInfo networkInfo) {
        return groupNetworkType(getNetworkType(networkInfo));
    }

    private static android.telephony.SignalStrength getSignalStrength(android.content.Context context) {
        int defaultDataSubscriptionId;
        android.telephony.TelephonyManager createForSubscriptionId;
        android.telephony.SignalStrength signalStrength;
        if (context == null || android.os.Build.VERSION.SDK_INT < 28) {
            return null;
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (!(systemService instanceof android.telephony.TelephonyManager)) {
            return null;
        }
        defaultDataSubscriptionId = android.telephony.SubscriptionManager.getDefaultDataSubscriptionId();
        createForSubscriptionId = ((android.telephony.TelephonyManager) systemService).createForSubscriptionId(defaultDataSubscriptionId);
        signalStrength = createForSubscriptionId.getSignalStrength();
        return signalStrength;
    }

    public static java.lang.String getWifiGatewayIp(android.content.Context context) {
        if (context == null) {
            return " ";
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context.getApplicationContext(), com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
        if (!(systemService instanceof android.net.wifi.WifiManager)) {
            return " ";
        }
        try {
            int i = ((android.net.wifi.WifiManager) systemService).getDhcpInfo().gateway;
            return java.net.InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)}).getHostAddress();
        } catch (java.lang.RuntimeException | java.net.UnknownHostException e) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getWifiGatewayIp error!" + e.getClass().getSimpleName() + e.getMessage());
            return " ";
        }
    }

    public static int getWifiRssi(android.content.Context context) {
        if (context == null) {
            return INVALID_RSSI;
        }
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context.getApplicationContext(), com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
        if (!(systemService instanceof android.net.wifi.WifiManager)) {
            return INVALID_RSSI;
        }
        try {
            android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) systemService).getConnectionInfo();
            return (connectionInfo == null || connectionInfo.getBSSID() == null) ? INVALID_RSSI : connectionInfo.getRssi();
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.i(TAG, "getWifiRssiLevel did not has permission!" + e.getClass().getSimpleName() + e.getMessage());
            return INVALID_RSSI;
        }
    }

    public static int getWifiRssiLevel(android.content.Context context) {
        return android.net.wifi.WifiManager.calculateSignalLevel(getWifiRssi(context), 5);
    }

    private static int groupNetworkType(int i) {
        if (i == -1) {
            return -1;
        }
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4 || i == 5) ? 6 : 0;
        }
        return 1;
    }

    public static boolean isChangeToConnected(android.net.NetworkInfo networkInfo, android.net.NetworkInfo networkInfo2) {
        if ((networkInfo != null && networkInfo.isConnected()) || !networkInfo2.isConnected()) {
            return false;
        }
        com.huawei.hms.framework.common.Logger.v(TAG, "Find network state changed to connected");
        return true;
    }

    public static boolean isConnectTypeChange(android.net.NetworkInfo networkInfo, android.net.NetworkInfo networkInfo2) {
        if (networkInfo == null || !networkInfo.isConnected() || !networkInfo2.isConnected() || getPrimaryNetworkType(networkInfo) == getPrimaryNetworkType(networkInfo2)) {
            return false;
        }
        com.huawei.hms.framework.common.Logger.v(TAG, "Find activity network changed");
        return true;
    }

    @java.lang.Deprecated
    public static boolean isForeground(android.content.Context context) {
        return com.huawei.hms.framework.common.ActivityUtil.isForeground(context);
    }

    public static boolean isNetworkAvailable(android.content.Context context) {
        if (!com.huawei.hms.framework.common.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        android.net.NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isSimReady(android.content.Context context) {
        java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        android.telephony.TelephonyManager telephonyManager = systemService instanceof android.telephony.TelephonyManager ? (android.telephony.TelephonyManager) systemService : null;
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }

    public static boolean isUserUnlocked(android.content.Context context) {
        android.os.UserManager userManager;
        boolean isUserUnlocked;
        if (android.os.Build.VERSION.SDK_INT < 24 || (userManager = (android.os.UserManager) com.huawei.hms.framework.common.ContextCompat.getSystemService(context, com.umeng.analytics.pro.ay.m)) == null) {
            return true;
        }
        try {
            isUserUnlocked = userManager.isUserUnlocked();
            return isUserUnlocked;
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.framework.common.Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
            return true;
        }
    }

    public static int netWork(android.content.Context context) {
        int networkType = getNetworkType(context);
        com.huawei.hms.framework.common.Logger.v(TAG, "newWorkType " + networkType);
        if (networkType == 4) {
            if (android.text.TextUtils.equals(STR_NSA, getNetWorkNSAorSA())) {
                return 7;
            }
            return networkType;
        }
        if (networkType == 5 && android.text.TextUtils.equals(STR_SA, getNetWorkNSAorSA())) {
            return 8;
        }
        return networkType;
    }

    @java.lang.Deprecated
    public static android.net.NetworkInfo.DetailedState networkStatus(android.content.Context context) {
        return getNetworkStatus(context);
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(android.content.Context context) {
        int restrictBackgroundStatus;
        int i = 0;
        if (context != null && android.os.Build.VERSION.SDK_INT >= 24 && com.huawei.hms.framework.common.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            java.lang.Object systemService = com.huawei.hms.framework.common.ContextCompat.getSystemService(context, "connectivity");
            if (systemService instanceof android.net.ConnectivityManager) {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) systemService;
                try {
                    if (connectivityManager.isActiveNetworkMetered()) {
                        restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
                        i = restrictBackgroundStatus;
                    } else {
                        com.huawei.hms.framework.common.Logger.v(TAG, "ConnectType is not Mobile Network!");
                    }
                } catch (java.lang.RuntimeException e) {
                    com.huawei.hms.framework.common.Logger.e(TAG, "SystemServer error:", e);
                }
            }
        }
        return i;
    }
}
