package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class q {
    private static final java.lang.String a = "Task145PhoneDataUtils";

    private static int a() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(nextElement.getName())) {
                    for (java.net.InterfaceAddress interfaceAddress : nextElement.getInterfaceAddresses()) {
                        java.net.InetAddress address = interfaceAddress.getAddress();
                        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        if (!address.isLoopbackAddress() && (address instanceof java.net.Inet4Address)) {
                            com.igexin.c.a.c.a.b(a, "IPv4 maskLength: ".concat(java.lang.String.valueOf((int) networkPrefixLength)));
                            if (networkPrefixLength > 0) {
                                return networkPrefixLength;
                            }
                            return 24;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return 24;
    }

    private static java.lang.String a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2 = "";
        try {
            str = c(context).b;
            try {
                com.igexin.c.a.c.a.b(a, "new get self iv4 by dhcp, ip = ".concat(java.lang.String.valueOf(str)));
            } catch (java.lang.Throwable th) {
                th = th;
                str2 = str;
                com.igexin.c.a.c.a.a(th);
                return str2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        if (!android.text.TextUtils.isEmpty(str) && !"0.0.0.0".equalsIgnoreCase(str)) {
            return str;
        }
        for (java.lang.String str3 : b().split("#")) {
            if (str3.contains("wlan0/ipv4")) {
                java.lang.String replace = str3.replace("wlan0/ipv4=", "");
                if (replace.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    str = replace.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0];
                }
                str2 = str;
                com.igexin.c.a.c.a.b(a, "new get self iv4 by sl, ip = ".concat(java.lang.String.valueOf(str2)));
                return str2;
            }
        }
        return str;
    }

    public static com.igexin.push.core.b.d b(android.content.Context context) {
        try {
            if (com.getui.gtc.base.util.CommonUtil.hasPermission(context, android.os.Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false) && d(context)) {
                return e(context);
            }
        } catch (java.lang.Throwable unused) {
        }
        return new com.igexin.push.core.b.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0131 -> B:35:0x0135). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String b() {
        java.lang.Process process;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec("ip addr");
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                    java.lang.String str = "";
                    java.lang.String str2 = "";
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                            sb2.append("\n");
                            if (readLine.contains("link/ether")) {
                                java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                if (split.length >= 2) {
                                    java.lang.String trim = split[1].trim();
                                    sb.append(readLine.replace("brd ff:ff:ff:ff:ff:ff", "").replace("link/ether ", trim + "/mac=").trim());
                                    sb.append("#");
                                }
                            }
                            str2 = readLine;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                com.igexin.c.a.c.a.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.io.IOException e) {
                                        com.igexin.c.a.c.a.a(e);
                                    }
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                if (sb.toString().endsWith("#")) {
                                }
                                return sb.toString();
                            } finally {
                            }
                        }
                    }
                    java.util.regex.Pattern compile = java.util.regex.Pattern.compile("[0-9]+");
                    java.lang.String[] split2 = sb2.toString().split("\n");
                    int length = split2.length;
                    char c = 0;
                    int i = 0;
                    while (i < length) {
                        java.lang.String str3 = split2[i];
                        java.lang.String[] split3 = str3.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        if (split3.length >= 3 && compile.matcher(split3[c].trim()).matches()) {
                            str = split3[1].trim();
                        }
                        if (str3.contains("inet")) {
                            java.lang.String[] split4 = str3.trim().split(" ");
                            if (split4.length >= 2) {
                                sb.append(str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + split4[c].replace("inet6", "ipv6").replace("inet", "ipv4").trim() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + split4[1].trim());
                                sb.append("#");
                            }
                        }
                        i++;
                        c = 0;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                    process.destroy();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                com.igexin.c.a.c.a.a(th3);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            process = null;
        }
        if (sb.toString().endsWith("#")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static com.igexin.push.core.b.x c(android.content.Context context) {
        com.igexin.c.a.c.a.b(a, "SLMA getDhcpWifiInfo.");
        com.igexin.push.core.b.x xVar = new com.igexin.push.core.b.x();
        try {
            com.getui.gtc.base.util.CommonUtil.hasPermission(context, "android.permission.ACCESS_WIFI_STATE", false);
            android.net.DhcpInfo dhcpInfo = ((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo();
            xVar.a = a(dhcpInfo.gateway);
            xVar.b = a(dhcpInfo.ipAddress);
            xVar.c = a();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return xVar;
    }

    private static boolean d(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getSimState() == 5;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static com.igexin.push.core.b.d e(android.content.Context context) {
        java.util.List<android.telephony.CellInfo> allCellInfo = ((android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getAllCellInfo();
        if (allCellInfo == null || allCellInfo.isEmpty()) {
            return new com.igexin.push.core.b.d();
        }
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (android.telephony.CellInfo cellInfo : allCellInfo) {
            if (cellInfo.isRegistered()) {
                if (cellInfo instanceof android.telephony.CellInfoGsm) {
                    android.telephony.CellIdentityGsm cellIdentity = ((android.telephony.CellInfoGsm) cellInfo).getCellIdentity();
                    i = cellIdentity.getMcc();
                    i2 = cellIdentity.getMnc();
                    i3 = cellIdentity.getLac();
                    j = cellIdentity.getCid();
                    i4 = 1;
                } else if (cellInfo instanceof android.telephony.CellInfoCdma) {
                    android.telephony.CellIdentityCdma cellIdentity2 = ((android.telephony.CellInfoCdma) cellInfo).getCellIdentity();
                    i2 = cellIdentity2.getSystemId();
                    i3 = cellIdentity2.getNetworkId();
                    j = cellIdentity2.getBasestationId();
                    i4 = 2;
                } else if (cellInfo instanceof android.telephony.CellInfoWcdma) {
                    android.telephony.CellIdentityWcdma cellIdentity3 = ((android.telephony.CellInfoWcdma) cellInfo).getCellIdentity();
                    i = cellIdentity3.getMcc();
                    i2 = cellIdentity3.getMnc();
                    i3 = cellIdentity3.getLac();
                    j = cellIdentity3.getCid();
                    i4 = 4;
                } else if (cellInfo instanceof android.telephony.CellInfoLte) {
                    android.telephony.CellIdentityLte cellIdentity4 = ((android.telephony.CellInfoLte) cellInfo).getCellIdentity();
                    i = cellIdentity4.getMcc();
                    i2 = cellIdentity4.getMnc();
                    i3 = cellIdentity4.getTac();
                    j = cellIdentity4.getCi();
                    i4 = 3;
                } else if ("android.telephony.CellInfoNr".equals(cellInfo.getClass().getName())) {
                    try {
                        java.lang.reflect.Method method = java.lang.Class.forName("android.telephony.CellInfoNr").getMethod("getCellIdentity", new java.lang.Class[0]);
                        java.lang.Class<?> cls = java.lang.Class.forName("android.telephony.CellIdentityNr");
                        java.lang.reflect.Method method2 = cls.getMethod("getMccString", new java.lang.Class[0]);
                        java.lang.reflect.Method method3 = cls.getMethod("getMncString", new java.lang.Class[0]);
                        java.lang.reflect.Method method4 = cls.getMethod("getTac", new java.lang.Class[0]);
                        java.lang.reflect.Method method5 = cls.getMethod("getNci", new java.lang.Class[0]);
                        java.lang.Object invoke = method.invoke(cellInfo, new java.lang.Object[0]);
                        java.lang.String str = (java.lang.String) method2.invoke(invoke, new java.lang.Object[0]);
                        java.lang.String str2 = (java.lang.String) method3.invoke(invoke, new java.lang.Object[0]);
                        i = java.lang.Integer.parseInt(str);
                        i2 = java.lang.Integer.parseInt(str2);
                        i3 = ((java.lang.Integer) method4.invoke(invoke, new java.lang.Object[0])).intValue();
                        j = ((java.lang.Long) method5.invoke(invoke, new java.lang.Object[0])).longValue();
                        i4 = 6;
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        }
        com.igexin.push.core.b.d dVar = new com.igexin.push.core.b.d();
        dVar.a = i;
        dVar.b = i2;
        dVar.c = i3;
        dVar.d = j;
        dVar.e = i4;
        return dVar;
    }

    private static boolean f(android.content.Context context) {
        return com.getui.gtc.base.util.CommonUtil.hasPermission(context, android.os.Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false);
    }
}
