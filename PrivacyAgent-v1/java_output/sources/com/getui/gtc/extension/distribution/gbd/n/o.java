package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class o {
    private static final java.lang.String a = "L_Utils";
    private static java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(true);

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.lang.Object> {
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.c.t a;

        public AnonymousClass2(com.getui.gtc.extension.distribution.gbd.c.t tVar) {
            this.a = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.Object a(android.content.Context context) {
            try {
                android.net.DhcpInfo dhcpInfo = ((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo();
                this.a.d = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.gateway);
                this.a.e = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.ipAddress);
                this.a.f = com.getui.gtc.extension.distribution.gbd.n.l.e();
                return null;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return null;
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.lang.Object> {
        final /* synthetic */ com.getui.gtc.extension.distribution.gbd.c.t a;

        public AnonymousClass3(com.getui.gtc.extension.distribution.gbd.c.t tVar) {
            this.a = tVar;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.lang.Object a2(android.content.Context context) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.o.a, "SLMA getDhcp.");
            android.net.DhcpInfo dhcpInfo = ((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo();
            this.a.d = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.gateway);
            this.a.e = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.ipAddress);
            return null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Object a(android.content.Context context) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.o.a, "SLMA getDhcp.");
            android.net.DhcpInfo dhcpInfo = ((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo();
            this.a.d = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.gateway);
            this.a.e = com.getui.gtc.extension.distribution.gbd.n.l.e(dhcpInfo.ipAddress);
            return null;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$4, reason: invalid class name */
    public static class AnonymousClass4 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$5, reason: invalid class name */
    public static class AnonymousClass5 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.o$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.Object, java.lang.String> {
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0058 -> B:15:0x005b). Please report as a decompilation issue!!! */
        private static java.lang.String a() {
            java.io.BufferedReader bufferedReader;
            java.lang.Throwable th;
            java.lang.Process process;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                try {
                    process = java.lang.Runtime.getRuntime().exec("ip addr");
                    try {
                        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb.append(readLine);
                                    sb.append("###");
                                } else {
                                    try {
                                        break;
                                    } catch (java.io.IOException e) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                                    }
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                try {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (java.io.IOException e2) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                                        }
                                    }
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    return sb.toString();
                                } finally {
                                }
                            }
                        }
                        bufferedReader.close();
                        process.destroy();
                    } catch (java.lang.Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (java.lang.Throwable th4) {
                    bufferedReader = null;
                    th = th4;
                    process = null;
                }
            } catch (java.lang.Throwable th5) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.Object obj) {
            return a();
        }
    }

    public static com.getui.gtc.extension.distribution.gbd.c.t a() {
        android.net.wifi.WifiInfo wifiInfo;
        java.lang.String str;
        java.lang.String str2;
        com.getui.gtc.extension.distribution.gbd.c.t tVar = new com.getui.gtc.extension.distribution.gbd.c.t();
        boolean equalsIgnoreCase = com.getui.gtc.extension.distribution.gbd.d.g.h.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.m);
        boolean equalsIgnoreCase2 = com.getui.gtc.extension.distribution.gbd.d.g.i.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.m);
        boolean equalsIgnoreCase3 = com.getui.gtc.extension.distribution.gbd.d.g.k.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.m);
        boolean equalsIgnoreCase4 = com.getui.gtc.extension.distribution.gbd.d.g.j.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.m);
        boolean z = equalsIgnoreCase || !(equalsIgnoreCase2 || equalsIgnoreCase3 || equalsIgnoreCase4);
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            wifiInfo = (android.net.wifi.WifiInfo) com.getui.gtc.extension.distribution.gbd.f.c.b(!z, com.getui.gtc.extension.distribution.gbd.f.e.b.E, new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (wifiInfo == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wifi info is null.");
            return tVar;
        }
        boolean z2 = equalsIgnoreCase2 || (equalsIgnoreCase3 && b.getAndSet(false));
        java.lang.String str3 = "";
        if (z2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wifi info api.");
            str = wifiInfo.getSSID();
            str2 = wifiInfo.getBSSID();
        } else {
            str = "";
            str2 = str;
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || equalsIgnoreCase4) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wifi info toString.");
            java.lang.String str4 = "";
            for (java.lang.String str5 : wifiInfo.toString().split(",")) {
                if (str5.contains("SSID:") && !str5.contains("BSSID:")) {
                    str = str5.replace("SSID:", "").trim();
                } else if (str5.contains("BSSID:")) {
                    str2 = str5.replace("BSSID:", "").trim();
                } else if (str5.contains("MAC:")) {
                    str4 = str5.replace("MAC:", "").trim();
                }
            }
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && !str.contains("*") && !str2.contains("*")) {
                str3 = str4;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wifi info parcel.");
            android.os.Parcel obtain = android.os.Parcel.obtain();
            wifiInfo.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            obtain.readInt();
            obtain.readInt();
            obtain.readInt();
            obtain.readInt();
            obtain.readInt();
            java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.w().toLowerCase();
            java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.n.split(",")));
            if (arrayList.contains(lowerCase)) {
                obtain.readInt();
            }
            obtain.readInt();
            if (obtain.readByte() == 1) {
                obtain.createByteArray();
            }
            if (obtain.readInt() == 1) {
                byte[] bArr = new byte[obtain.readInt()];
                obtain.readByteArray(bArr);
                str = new java.lang.String(bArr);
            }
            if (arrayList.contains(lowerCase)) {
                obtain.readInt();
            }
            str2 = obtain.readString();
            str3 = obtain.readString();
        }
        tVar.b = str;
        tVar.a = str2;
        tVar.c = str3;
        return tVar;
    }

    public static com.getui.gtc.extension.distribution.gbd.c.t a(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "SLMA getDhcpWifiInfo.");
        com.getui.gtc.extension.distribution.gbd.c.t tVar = new com.getui.gtc.extension.distribution.gbd.c.t();
        if (com.getui.gtc.extension.distribution.gbd.n.l.a(context, "android.permission.ACCESS_WIFI_STATE")) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.n.l.J(), com.getui.gtc.extension.distribution.gbd.f.b.k, context, new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass2(tVar));
        }
        return tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.o.a, "SLMA getMac new.");
        r0.c = c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.getui.gtc.extension.distribution.gbd.c.t b(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "SLMA getLan SSID/MAC.");
        com.getui.gtc.extension.distribution.gbd.c.t a2 = a();
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            boolean z = true;
            com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.n.l.F() && com.getui.gtc.extension.distribution.gbd.n.l.J(), com.getui.gtc.extension.distribution.gbd.f.b.k, context, new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass3(a2));
            if (android.os.Build.VERSION.SDK_INT < 23 && !com.getui.gtc.extension.distribution.gbd.d.d.z) {
                z = false;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return a2;
    }

    public static java.lang.String b() {
        java.lang.String concat;
        java.lang.String str = "";
        try {
            if (!com.getui.gtc.extension.distribution.gbd.d.d.O) {
                java.lang.String str2 = a(com.getui.gtc.extension.distribution.gbd.d.c.d).e;
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "new get self iv4 by dhcp, ip = ".concat(java.lang.String.valueOf(str2)));
                    if (android.text.TextUtils.isEmpty(str2) || "0.0.0.0".equalsIgnoreCase(str2)) {
                        for (java.lang.String str3 : f().split("#")) {
                            if (str3.contains("wlan0/ipv4")) {
                                java.lang.String replace = str3.replace("wlan0/ipv4=", "");
                                str = replace.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) ? replace.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0] : str2;
                                concat = "new get self iv4 by sl, ip = ".concat(java.lang.String.valueOf(str));
                            }
                        }
                    }
                    return str2;
                } catch (java.lang.Throwable th) {
                    th = th;
                    str = str2;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    return str;
                }
            }
            str = com.getui.gtc.extension.distribution.gbd.n.l.c();
            concat = "old get self iv4, ip = ".concat(java.lang.String.valueOf(str));
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, concat);
            return str;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static synchronized java.lang.String c() {
        java.lang.String a2;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.o.class) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.h, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass4());
        }
        return a2;
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            if (!com.getui.gtc.extension.distribution.gbd.n.l.i(context)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "Iv6 network not connected.");
                return "no network|-1";
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.as, com.getui.gtc.extension.distribution.gbd.f.e.b.z, (com.getui.gtc.extension.distribution.gbd.f.f) null);
            boolean f = com.getui.gtc.extension.distribution.gbd.n.l.f(context);
            boolean g = com.getui.gtc.extension.distribution.gbd.n.l.g(context);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (f) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "Phone Iv6 List = ".concat(java.lang.String.valueOf(a2)));
                sb.append(a2);
                sb.append("|");
                sb.append(1);
            } else if (g) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "Wifi Iv6 List = ".concat(java.lang.String.valueOf(a2)));
                sb.append(a2);
                sb.append("|");
                sb.append(2);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error|-1";
        }
    }

    public static java.lang.String d() {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.G, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass5());
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static java.lang.String e() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.ai, "i-m", "", new com.getui.gtc.extension.distribution.gbd.n.o.AnonymousClass6());
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x014c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x013e -> B:41:0x0142). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String f() {
        java.lang.Process process;
        java.lang.String str = "";
        if (!com.getui.gtc.extension.distribution.gbd.n.l.J()) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "m and i get is bg");
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec("ip addr");
                try {
                    java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
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
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.io.IOException e) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(e);
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
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                    }
                    process.destroy();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                process = null;
            }
        } catch (java.lang.Throwable th4) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
        }
        if (sb.toString().endsWith("#")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
