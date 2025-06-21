package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class l {
    private static final java.lang.String a = "GBD_Utils";
    private static final java.lang.String b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
    private static final java.lang.String c = "com.google.android.gms.ads.identifier.service.START";
    private static final java.lang.String d = "com.google.android.gms";
    private static final java.lang.String e = "com.android.vending";
    private static final java.lang.String f = "checkOpNoThrow";
    private static final java.lang.String g = "OP_POST_NOTIFICATION";
    private static final int h = 8192;
    private static final java.lang.String i = " -f inet addr show %s";
    private static final java.lang.String j = "\\s*inet [0-9\\.]+\\/([0-9]+) brd [0-9\\.]+ scope global %s$";
    private static final java.lang.String k = "\\s*inet [0-9\\.]+ peer [0-9\\.]+\\/([0-9]+) scope global %s$";
    private static final java.lang.String l = "^%s: ip [0-9\\.]+ mask ([0-9\\.]+) flags.*";
    private static java.lang.String m = "eth0";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file.exists() && file.isFile();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$10, reason: invalid class name */
    public static class AnonymousClass10 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$11, reason: invalid class name */
    public static class AnonymousClass11 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$12, reason: invalid class name */
    public static class AnonymousClass12 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.lang.String> {
        private static java.lang.String a() {
            try {
                java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().toLowerCase().contains("wlan")) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress nextElement2 = inetAddresses.nextElement();
                            java.lang.String a = com.getui.gtc.extension.distribution.gbd.n.l.a(nextElement2);
                            if (!nextElement2.isLoopbackAddress() && com.getui.gtc.extension.distribution.gbd.n.l.c(a)) {
                                return a;
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            }
            return "";
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String str) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$13, reason: invalid class name */
    public static class AnonymousClass13 implements com.getui.gtc.extension.distribution.gbd.f.j<java.net.InetAddress, java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(java.net.InetAddress inetAddress) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("java.net.InetAddress");
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("holder", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    java.lang.Object invoke = declaredMethod.invoke(inetAddress, new java.lang.Object[0]);
                    java.lang.reflect.Field declaredField = invoke.getClass().getDeclaredField("address");
                    declaredField.setAccessible(true);
                    int intValue = ((java.lang.Integer) declaredField.get(invoke)).intValue();
                    java.lang.String str = ((intValue >>> 24) & 255) + "." + ((intValue >>> 16) & 255) + "." + ((intValue >>> 8) & 255) + "." + (intValue & 255);
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.l.a, "i new Str: ".concat(java.lang.String.valueOf(str)));
                    return str;
                }
                java.lang.reflect.Field declaredField2 = cls.getDeclaredField("ipaddress");
                declaredField2.setAccessible(true);
                byte[] bArr = (byte[]) declaredField2.get(inetAddress);
                if (bArr.length < 4) {
                    return "";
                }
                java.lang.String str2 = (bArr[3] & 255) + "." + (bArr[2] & 255) + "." + (bArr[1] & 255) + "." + (bArr[0] & 255);
                com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.l.a, "i old Str: ".concat(java.lang.String.valueOf(str2)));
                return str2;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.l.a, "get i e = ".concat(java.lang.String.valueOf(th)));
                return "";
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.net.InetAddress inetAddress) {
            return a2(inetAddress);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$14, reason: invalid class name */
    public static class AnonymousClass14 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.Object, java.lang.String> {
        private static java.lang.String a() {
            java.lang.StringBuilder sb;
            try {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                    java.lang.String lowerCase = nextElement.getName().toLowerCase();
                    if (lowerCase.contains("rmnet") || lowerCase.contains("ccmni") || lowerCase.contains("wlan0")) {
                        java.util.Iterator<java.net.InterfaceAddress> it = nextElement.getInterfaceAddresses().iterator();
                        while (it.hasNext()) {
                            java.lang.String hostAddress = it.next().getAddress().getHostAddress();
                            if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                int indexOf = hostAddress.indexOf("%");
                                if (indexOf > 0) {
                                    hostAddress = hostAddress.substring(0, indexOf);
                                }
                                if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                    if (com.getui.gtc.extension.distribution.gbd.d.d.du) {
                                        sb = new java.lang.StringBuilder();
                                        sb.append(lowerCase);
                                        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                        sb.append(hostAddress);
                                        sb.append("#");
                                    } else if (!hostAddress.startsWith("fe80") && !hostAddress.startsWith("FE80")) {
                                        sb = new java.lang.StringBuilder();
                                        sb.append(lowerCase);
                                        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                        sb.append(hostAddress);
                                        sb.append("#");
                                    }
                                    sb2.append(sb.toString());
                                }
                            }
                        }
                        if (sb2.toString().endsWith("#")) {
                            sb2.deleteCharAt(sb2.length() - 1);
                        }
                        if (!android.text.TextUtils.isEmpty(sb2) && !sb2.toString().endsWith(",")) {
                            sb2.append(",");
                        }
                    }
                }
                if (sb2.toString().endsWith(",")) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
                return sb2.toString();
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.Object obj) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$15, reason: invalid class name */
    public static class AnonymousClass15 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$16, reason: invalid class name */
    public static class AnonymousClass16 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$17, reason: invalid class name */
    public static class AnonymousClass17 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$18, reason: invalid class name */
    public static class AnonymousClass18 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$19, reason: invalid class name */
    public static class AnonymousClass19 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$20, reason: invalid class name */
    public static class AnonymousClass20 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$21, reason: invalid class name */
    public static class AnonymousClass21 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).useExpiredCacheForReserve(true);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, android.net.NetworkInfo> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static android.net.NetworkInfo a2(android.content.Context context) {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ android.net.NetworkInfo a(android.content.Context context) {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, android.net.NetworkInfo> {
        final /* synthetic */ int a = 17;

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private android.net.NetworkInfo a2(android.content.Context context) {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(this.a);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ android.net.NetworkInfo a(android.content.Context context) {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(this.a);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.lang.Integer> {
        private static java.lang.Integer a() {
            int i = 24;
            try {
                java.lang.String b = com.getui.gtc.extension.distribution.gbd.n.l.b("/system/xbin/ip", java.lang.String.format(com.getui.gtc.extension.distribution.gbd.n.l.i, com.getui.gtc.extension.distribution.gbd.n.l.m), java.lang.String.format(com.getui.gtc.extension.distribution.gbd.n.l.j, com.getui.gtc.extension.distribution.gbd.n.l.m));
                if (b != null) {
                    i = java.lang.Integer.parseInt(b);
                } else {
                    java.lang.String b2 = com.getui.gtc.extension.distribution.gbd.n.l.b("/system/xbin/ip", java.lang.String.format(com.getui.gtc.extension.distribution.gbd.n.l.i, com.getui.gtc.extension.distribution.gbd.n.l.m), java.lang.String.format(com.getui.gtc.extension.distribution.gbd.n.l.k, com.getui.gtc.extension.distribution.gbd.n.l.m));
                    if (b2 != null) {
                        i = java.lang.Integer.parseInt(b2);
                    } else {
                        java.lang.String b3 = com.getui.gtc.extension.distribution.gbd.n.l.b("/system/bin/ifconfig", " " + com.getui.gtc.extension.distribution.gbd.n.l.m, java.lang.String.format(com.getui.gtc.extension.distribution.gbd.n.l.l, com.getui.gtc.extension.distribution.gbd.n.l.m));
                        if (b3 != null) {
                            double d = -2.0d;
                            for (java.lang.String str : b3.split("\\.")) {
                                d += 256.0d - java.lang.Double.parseDouble(str);
                            }
                            i = 32 - ((int) (java.lang.Math.log(d) / java.lang.Math.log(2.0d)));
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            }
            return java.lang.Integer.valueOf(i);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.Integer a(java.lang.String str) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.lang.Boolean> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.Boolean a2(android.content.Context context) {
            try {
                android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
                if (wifiManager != null && wifiManager.isWifiEnabled()) {
                    return java.lang.Boolean.TRUE;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            return java.lang.Boolean.FALSE;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.Boolean a(android.content.Context context) {
            return a2(context);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$7, reason: invalid class name */
    public static class AnonymousClass7 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file.isDirectory();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$8, reason: invalid class name */
    public static class AnonymousClass8 implements java.io.FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(java.io.File file, java.lang.String str) {
            return str.endsWith(".bin");
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.l$9, reason: invalid class name */
    public static class AnonymousClass9 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.useExpiredCacheForReserve(true);
        }
    }

    public static boolean A() {
        int intValue = java.lang.Integer.valueOf(com.getui.gtc.extension.distribution.gbd.d.c.e.substring(34), 16).intValue();
        int intValue2 = java.lang.Integer.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cd, 16).intValue();
        for (int i2 = 0; i2 < 16; i2++) {
            int i3 = 1 << i2;
            if ((intValue2 & i3) != 0 && (i3 & intValue) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean B() {
        if (!com.getui.gtc.extension.distribution.gbd.d.h.az) {
            com.getui.gtc.extension.distribution.gbd.d.h.aA = aa();
            com.getui.gtc.extension.distribution.gbd.d.h.az = true;
        }
        return com.getui.gtc.extension.distribution.gbd.d.d.bL && com.getui.gtc.extension.distribution.gbd.d.h.aA;
    }

    public static long C() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            return !l(com.getui.gtc.extension.distribution.gbd.d.c.d) ? currentTimeMillis + com.getui.gtc.extension.distribution.gbd.d.h.an : currentTimeMillis;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return currentTimeMillis;
        }
    }

    public static java.util.LinkedHashMap<java.lang.Long, java.lang.Long> D() {
        java.util.LinkedHashMap<java.lang.Long, java.lang.Long> linkedHashMap = new java.util.LinkedHashMap<>();
        boolean a2 = a(com.getui.gtc.extension.distribution.gbd.d.c.d);
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "has s. permission read s. = ".concat(java.lang.String.valueOf(a2)));
        if (!a2) {
            return linkedHashMap;
        }
        java.util.Iterator<java.lang.String> it = ab().iterator();
        while (it.hasNext()) {
            android.os.StatFs statFs = new android.os.StatFs(it.next());
            long blockSizeLong = statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            long b2 = b((((blockCountLong * blockSizeLong) / 1024) / 1024) / 1024) * 1024;
            long j2 = ((blockSizeLong * availableBlocksLong) / 1024) / 1024;
            linkedHashMap.put(java.lang.Long.valueOf(b2), java.lang.Long.valueOf(j2));
            com.getui.gtc.extension.distribution.gbd.n.j.b("sd ", "total = " + b2 + " MB, avail = " + j2 + " MB");
        }
        return linkedHashMap;
    }

    public static boolean E() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "SLMA watchoutAs " + com.getui.gtc.extension.distribution.gbd.d.d.aB);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "SLMA watchoutBrand " + com.getui.gtc.extension.distribution.gbd.d.d.aG);
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.aG) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.aG)) {
                java.lang.String w = w();
                for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.aG.split(",")) {
                    if (!android.text.TextUtils.isEmpty(str) && str.equalsIgnoreCase(w)) {
                        return ac();
                    }
                }
            }
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.aB)) {
                return true;
            }
            if ("none".equals(com.getui.gtc.extension.distribution.gbd.d.d.aB)) {
                return false;
            }
            for (java.lang.String str2 : com.getui.gtc.extension.distribution.gbd.d.d.aB.split(",")) {
                java.lang.String str3 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                if (e(str2)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a("27-", "check = " + str2 + " exist");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean F() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "SLMA watchoutForMac " + com.getui.gtc.extension.distribution.gbd.d.d.aC);
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.aC)) {
                return true;
            }
            if ("none".equals(com.getui.gtc.extension.distribution.gbd.d.d.aC)) {
                return false;
            }
            for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.aC.split(",")) {
                java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                if (e(str) && android.os.Build.VERSION.SDK_INT <= 23) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a("27mac-", "check = " + str + " exist, and SDK<=23.");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean G() {
        android.content.Context context = com.getui.gtc.extension.distribution.gbd.d.c.d;
        boolean z = false;
        try {
            java.lang.Class.forName("android.bluetooth.BluetoothManager");
            java.lang.Class.forName("android.bluetooth.BluetoothAdapter");
            if (b(context, "android.permission.BLUETOOTH") && b(context, "android.permission.BLUETOOTH_ADMIN")) {
                if (com.getui.gtc.extension.distribution.gbd.d.h.h < 31 || (a(context, "android.permission.BLUETOOTH_SCAN") && a(context, "android.permission.BLUETOOTH_ADVERTISE") && a(context, "android.permission.BLUETOOTH_CONNECT"))) {
                    z = true;
                }
                if (z) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "check bl perm success");
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean H() {
        try {
            java.lang.String str = (java.lang.String) com.getui.gtc.BuildConfig.class.getField("VERSION_NAME").get(null);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gtc version = ".concat(java.lang.String.valueOf(str)));
            if (!android.text.TextUtils.isEmpty(str) && str.startsWith("GTC-")) {
                java.lang.String[] split = str.substring(4).split("\\.");
                if (split.length >= 4) {
                    int parseInt = java.lang.Integer.parseInt(split[0]);
                    int parseInt2 = java.lang.Integer.parseInt(split[1]);
                    return (parseInt == 3 && parseInt2 == 2 && java.lang.Integer.parseInt(split[2]) >= 3 && java.lang.Integer.parseInt(split[3]) >= 0) || (parseInt == 3 && parseInt2 > 2) || parseInt > 3;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return false;
    }

    public static boolean I() {
        return c(com.getui.gtc.extension.distribution.gbd.d.d.cp);
    }

    public static boolean J() {
        return c(com.getui.gtc.extension.distribution.gbd.d.d.f323s);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:2|3)|(3:5|(3:7|(1:9)(1:11)|10)|(9:13|(2:15|(1:17))|20|21|22|23|(1:32)|26|(1:31)(2:28|29)))|37|21|22|23|(0)|32|26|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (d() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        r4 = r3;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.l.a, "throwable = ".concat(java.lang.String.valueOf(r3)));
        r3 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String K() {
        boolean z;
        com.getui.gtc.extension.distribution.gbd.f.d a2;
        java.util.Map<java.lang.String, java.lang.Integer> map;
        try {
            a2 = com.getui.gtc.extension.distribution.gbd.f.d.a();
            map = a2.c;
        } catch (java.lang.Throwable th) {
            th = th;
            boolean z2 = false;
        }
        if (map != null) {
            java.lang.Integer num = map.get(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
            if (num == null) {
                num = a2.e ? a2.c.get("dim-2-2-0-1") : a2.c.get("dim-2-2-3-1");
            }
            if (num != null) {
                if (num.intValue() != 2) {
                    if (num.intValue() == 1) {
                    }
                }
                z = true;
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "isIpAllow = ".concat(java.lang.String.valueOf(z)));
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(!com.getui.gtc.extension.distribution.gbd.d.d.dt && z, com.getui.gtc.extension.distribution.gbd.f.b.x, "", new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass14());
                return android.text.TextUtils.isEmpty(str) ? "" : str;
            }
        }
        z = false;
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "isIpAllow = ".concat(java.lang.String.valueOf(z)));
        com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str2 = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(!com.getui.gtc.extension.distribution.gbd.d.d.dt && z, com.getui.gtc.extension.distribution.gbd.f.b.x, "", new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass14());
        if (android.text.TextUtils.isEmpty(str2)) {
        }
    }

    public static java.lang.String L() {
        java.lang.String str;
        try {
            str = java.util.Locale.getDefault().getCountry();
        } catch (java.lang.Throwable unused) {
            str = "";
        }
        return android.text.TextUtils.isEmpty(str) ? "" : str;
    }

    private static boolean N() {
        int i2 = -1;
        if (c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)) {
            try {
                i2 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "wifi_on", -1);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return i2 == 1;
    }

    private static java.lang.String O() {
        return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.b).ramCacheValidTime(0L).useExpiredCacheForReserve(true).build());
    }

    private static boolean P() {
        try {
            return ((java.lang.Boolean) java.lang.Class.forName("com.igexin.push.util.EncryptUtils").getMethod("isLoadSuccess", new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static boolean Q() {
        java.lang.String str = android.os.Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean R() {
        java.lang.String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new java.io.File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean S() {
        java.io.BufferedReader bufferedReader;
        java.lang.Process process = null;
        try {
            java.lang.Process exec = java.lang.Runtime.getRuntime().exec(new java.lang.String[]{"/system/xbin/which", com.getui.gtc.extension.distribution.gbd.n.aa.a});
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(exec.getInputStream()));
                try {
                    if (android.text.TextUtils.isEmpty(bufferedReader.readLine())) {
                        try {
                            exec.destroy();
                        } catch (java.lang.Throwable th) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        }
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e2) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                        }
                        return false;
                    }
                    try {
                        exec.destroy();
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                    }
                    try {
                        bufferedReader.close();
                        return true;
                    } catch (java.io.IOException e3) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                        return true;
                    }
                } catch (java.lang.Throwable unused) {
                    process = exec;
                    if (process != null) {
                        try {
                            process.destroy();
                        } catch (java.lang.Throwable th3) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                        }
                    }
                    return false;
                }
            } catch (java.lang.Throwable unused2) {
                bufferedReader = null;
            }
        } catch (java.lang.Throwable unused3) {
            bufferedReader = null;
        }
    }

    private static long T() {
        try {
            java.lang.String a2 = a(new java.io.FileInputStream(new java.io.File("/proc/net/dev")));
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(" \\d+ ").matcher(a2.substring(a2.indexOf("rmnet0:")));
            if (matcher.find()) {
                return java.lang.Long.parseLong(matcher.group().trim());
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0L;
        }
    }

    private static long U() {
        try {
            java.lang.String a2 = a(new java.io.FileInputStream(new java.io.File("/proc/net/dev")));
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(" \\d+ ").matcher(a2.substring(a2.indexOf("rmnet0:")));
            int i2 = 0;
            while (matcher.find()) {
                if (i2 == 8) {
                    return java.lang.Long.parseLong(matcher.group().trim());
                }
                i2++;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return 0L;
    }

    private static long V() {
        try {
            java.lang.String a2 = a(new java.io.FileInputStream(new java.io.File("/proc/net/dev")));
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(" \\d+ ").matcher(a2.substring(a2.indexOf("wlan0:")));
            if (matcher.find()) {
                return java.lang.Long.parseLong(matcher.group().trim());
            }
            return 0L;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0L;
        }
    }

    private static long W() {
        try {
            java.lang.String a2 = a(new java.io.FileInputStream(new java.io.File("/proc/net/dev")));
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(" \\d+ ").matcher(a2.substring(a2.indexOf("wlan0:")));
            int i2 = 0;
            while (matcher.find()) {
                if (i2 == 8) {
                    return java.lang.Long.parseLong(matcher.group().trim());
                }
                i2++;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r0 = r0[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.a(r2);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x007e -> B:34:0x0081). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String X() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Process process;
        java.lang.String str;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec("cat /proc/version");
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable th2) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                                }
                                process.destroy();
                                break;
                            }
                            java.lang.String[] split = readLine.split(" +");
                            if (split.length >= 3 && "Linux".equalsIgnoreCase(split[0]) && "version".equalsIgnoreCase(split[1])) {
                                break;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            try {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.lang.Throwable th4) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                                    }
                                }
                                if (process == null) {
                                    return "unknown";
                                }
                                process.destroy();
                                return "unknown";
                            } finally {
                            }
                        }
                    }
                    return str;
                    try {
                        process.destroy();
                    } catch (java.lang.Throwable th5) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                    }
                    return str;
                } catch (java.lang.Throwable th6) {
                    bufferedReader = null;
                    th = th6;
                }
            } catch (java.lang.Throwable th7) {
                bufferedReader = null;
                th = th7;
                process = null;
            }
        } catch (java.lang.Throwable th8) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th8);
        }
    }

    private static java.lang.String Y() {
        return android.os.Build.MANUFACTURER;
    }

    private static boolean Z() {
        return !a(3, 2, 11, 0) && com.getui.gtc.extension.distribution.gbd.d.d.dn && t("HONOR") && com.getui.gtc.extension.distribution.gbd.n.r.g.a();
    }

    public static int a(boolean z, android.content.pm.PackageInfo packageInfo, android.app.AppOpsManager appOpsManager, android.content.pm.PackageManager packageManager) {
        int i2;
        android.content.pm.ApplicationInfo applicationInfo;
        if (!z || (i2 = android.os.Build.VERSION.SDK_INT) < 31 || packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || appOpsManager == null || packageManager == null) {
            return -1;
        }
        if (i2 >= 33) {
            try {
                if (applicationInfo.targetSdkVersion >= 33) {
                    try {
                        return packageManager.checkPermission("android.permission.POST_NOTIFICATIONS", applicationInfo.packageName) == 0 ? 1 : 0;
                    } catch (java.lang.Throwable unused) {
                        java.lang.String[] strArr = packageInfo.requestedPermissions;
                        if (strArr == null || !new java.util.HashSet(java.util.Arrays.asList(strArr)).contains("android.permission.POST_NOTIFICATIONS")) {
                            return 0;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return -1;
            }
        }
        java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
        int intValue = ((java.lang.Integer) cls.getDeclaredField(g).get(java.lang.Integer.class)).intValue();
        java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
        return ((java.lang.Integer) cls.getMethod(f, cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(intValue), java.lang.Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue() == 0 ? 1 : 0;
    }

    public static long a(long j2, int i2) {
        int i3 = 32 - i2;
        long j3 = (j2 >> i3) << i3;
        return i2 < 31 ? j3 + 1 : j3;
    }

    public static long a(long j2, long j3, long j4) {
        java.lang.String[] split = a(j2).split("\\.");
        split[2] = java.lang.String.valueOf(j3);
        split[3] = java.lang.String.valueOf(j4);
        return h(split[0] + "." + split[1] + "." + split[2] + "." + split[3]);
    }

    public static android.content.pm.PackageInfo a(java.lang.String str, int i2) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str, i2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String a(long j2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 3; i2 >= 0; i2--) {
            sb.append((j2 >> (i2 * 8)) & 255);
            sb.append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static java.lang.String a(android.content.pm.PackageInfo packageInfo) {
        int i2 = packageInfo.applicationInfo.uid;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(android.net.TrafficStats.getUidTxBytes(i2));
        java.lang.String sb2 = sb.toString();
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(android.net.TrafficStats.getUidRxBytes(i2));
        return sb2 + "&" + sb3.toString();
    }

    public static java.lang.String a(android.content.pm.PackageInfo packageInfo, java.lang.String str) {
        if (packageInfo == null) {
            return "";
        }
        try {
            android.os.Bundle bundle = packageInfo.applicationInfo.metaData;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (bundle != null) {
                java.util.Set<java.lang.String> keySet = bundle.keySet();
                if (keySet != null && keySet.size() > 0) {
                    if (com.getui.gtc.extension.distribution.gbd.d.d.cu.equals("*")) {
                        for (java.lang.String str2 : keySet) {
                            java.lang.String encode = java.net.URLEncoder.encode(java.lang.String.valueOf(bundle.get(str2)), "UTF-8");
                            sb.append(str2);
                            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                            sb.append(encode);
                            sb.append("&");
                        }
                    } else if (!android.text.TextUtils.isEmpty(str)) {
                        for (java.lang.String str3 : keySet) {
                            for (java.lang.String str4 : str.split("&")) {
                                if (str3.contains(str4)) {
                                    java.lang.String encode2 = java.net.URLEncoder.encode(java.lang.String.valueOf(bundle.get(str3)), "UTF-8");
                                    sb.append(str3);
                                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb.append(encode2);
                                    sb.append("&");
                                }
                            }
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(sb) && sb.toString().endsWith("&")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                return sb.toString();
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return "";
    }

    private static java.lang.String a(java.io.FileInputStream fileInputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception e2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                }
                try {
                    fileInputStream.close();
                } catch (java.lang.Exception e3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                }
                return byteArrayOutputStream2;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Exception e5) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e5);
                    }
                    return null;
                } finally {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    private static java.lang.String a(java.lang.String str, boolean z) {
        java.lang.String[] strArr;
        java.lang.String[] split;
        java.lang.String[] split2;
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (!str.endsWith("_.db") && (str.endsWith(com.umeng.analytics.process.a.d) || str.endsWith(".data"))) {
            byte[] j2 = j(str);
            if (j2 == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBDUtils getCid", str + " file not exist, not get cid.");
                return "";
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                if (a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a)) {
                    java.lang.String a2 = a(true);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.ad.a(a2);
                        if (!android.text.TextUtils.isEmpty(a3) && !a3.equals(com.getui.gtc.extension.distribution.gbd.d.c.h)) {
                            arrayList.add(a3);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
            arrayList.add(com.getui.gtc.extension.distribution.gbd.d.c.h);
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a(""));
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a("000000000000000"));
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a("cantgetimei"));
            java.lang.String a4 = a(false);
            if (!android.text.TextUtils.isEmpty(a4) && (split = a4.split("#")) != null && split.length == 2 && (split2 = split[1].split(",")) != null && split2.length > 0) {
                for (java.lang.String str2 : split2) {
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a(str2));
                    }
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    strArr = null;
                    break;
                }
                java.lang.String str3 = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.t.a(j2, (java.lang.String) it.next()));
                if (java.util.regex.Pattern.matches("[\\.:0-9a-zA-Z_\\|]+", str3)) {
                    strArr = str3.split("\\|");
                    break;
                }
            }
            if (z) {
                if (strArr != null && strArr.length >= 3) {
                    return strArr[2];
                }
            } else if (strArr != null && strArr.length >= 2) {
                return strArr[1];
            }
            return "";
        }
        return "";
    }

    public static java.lang.String a(java.net.InetAddress inetAddress) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(c(com.getui.gtc.extension.distribution.gbd.d.d.f323s), com.getui.gtc.extension.distribution.gbd.f.b.n, inetAddress, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass13());
        return str == null ? "" : str;
    }

    public static synchronized java.lang.String a(boolean z) {
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.b, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass16());
            if (z) {
                return a2;
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.c, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass17());
            com.getui.gtc.extension.distribution.gbd.f.c unused3 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.d, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass18());
            java.lang.String str = "";
            if (!android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(a3) || !android.text.TextUtils.isEmpty(a4)) {
                str = a2 + "#" + a3 + "," + a4;
            }
            return str;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        try {
            int i2 = (bArr[56] * com.google.common.base.Ascii.DC2) + 56;
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(17);
            for (int i3 = 1; i3 < 7; i3++) {
                java.lang.String hexString = java.lang.Integer.toHexString(bArr[i2 + i3] & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString.toUpperCase());
                if (i3 < 6) {
                    stringBuffer.append(':');
                }
            }
            return stringBuffer.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #0 {all -> 0x00db, blocks: (B:13:0x004a, B:18:0x00aa, B:21:0x00b7, B:24:0x00c5, B:27:0x00cf, B:30:0x0077), top: B:12:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.Set<java.lang.String> a(java.util.TimeZone timeZone, java.util.Locale locale) {
        java.lang.String[] split;
        boolean z;
        java.lang.String str;
        java.lang.String str2;
        if ("*".equals(com.getui.gtc.extension.distribution.gbd.d.d.bY) || "*&*&*&*".equals(com.getui.gtc.extension.distribution.gbd.d.d.bY)) {
            return null;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        if ("none".equals(com.getui.gtc.extension.distribution.gbd.d.d.bY)) {
            return hashSet;
        }
        if (!v(com.getui.gtc.extension.distribution.gbd.d.d.bY)) {
            com.getui.gtc.extension.distribution.gbd.d.d.bY = com.getui.gtc.extension.distribution.gbd.d.d.bX;
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "timeZoneTypeMap format error, use default value: " + com.getui.gtc.extension.distribution.gbd.d.d.bY);
        }
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "current timeZone : " + timeZone + ", locale : " + locale);
            split = com.getui.gtc.extension.distribution.gbd.d.d.bY.split("&");
            z = false;
            str = split[0];
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (!"*".equals(str)) {
            java.lang.String[] split2 = str.split("\\|");
            java.lang.String id = timeZone.getID();
            java.lang.String str3 = split2[0];
            java.lang.String str4 = split2[1];
            java.util.TimeZone timeZone2 = java.util.TimeZone.getTimeZone(id);
            java.util.TimeZone timeZone3 = java.util.TimeZone.getTimeZone(str3);
            java.util.TimeZone timeZone4 = java.util.TimeZone.getTimeZone(str4);
            int rawOffset = timeZone2.getRawOffset();
            int rawOffset2 = timeZone3.getRawOffset();
            int rawOffset3 = timeZone4.getRawOffset();
            if (rawOffset2 > rawOffset3) {
                rawOffset2 = rawOffset3;
                rawOffset3 = rawOffset2;
            }
            if (rawOffset >= rawOffset2 && rawOffset <= rawOffset3) {
            }
            if (z || !a(split[1], "#", "*", locale.getLanguage()) || !a(split[2], "#", "*", locale.getCountry())) {
                return hashSet;
            }
            str2 = split[3];
            if (!"*".equals(str2)) {
                return null;
            }
            hashSet.addAll(java.util.Arrays.asList(str2.split("#")));
            return hashSet;
        }
        z = true;
        if (z) {
            return hashSet;
        }
        str2 = split[3];
        if (!"*".equals(str2)) {
        }
    }

    public static boolean a() {
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.b.b()) {
                return com.getui.gtc.base.util.CommonUtil.isAppDebugEnable();
            }
            return (com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageManager().getPackageInfo(com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName(), 0).applicationInfo.flags & 2) > 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }

    public static synchronized boolean a(int i2) {
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            if (i2 == 0) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gbd system task, not judge foreground or back.");
                return true;
            }
            if (!f(i2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "type = " + i2 + " allows both foreground and background.");
                return true;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "type = " + i2 + " only allows foreground.");
            return d();
        }
    }

    public static boolean a(android.content.Context context) {
        return a(context, "android.permission.READ_EXTERNAL_STORAGE") || a(context, com.anythink.china.common.d.b);
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean a(android.content.Context context, boolean z) {
        android.content.pm.ServiceInfo[] serviceInfoArr;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "check safe = " + com.getui.gtc.extension.distribution.gbd.d.d.bZ);
            if (!com.getui.gtc.extension.distribution.gbd.d.d.bZ && z) {
                return true;
            }
            if (p(context)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "is v. connected");
                return false;
            }
            if (n(context) || !d(context) || "none".equals(com.getui.gtc.extension.distribution.gbd.d.d.at)) {
                return false;
            }
            for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.at.split(",")) {
                if (e(str)) {
                    return false;
                }
            }
            if (com.getui.gtc.extension.distribution.gbd.d.d.ag) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "check s allow watchout s.");
                if ("none".equals(com.getui.gtc.extension.distribution.gbd.d.d.aA)) {
                    return false;
                }
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.aA.split(",");
                java.util.Iterator<android.content.pm.PackageInfo> it = com.getui.gtc.extension.distribution.gbd.n.b.a().iterator();
                while (it.hasNext()) {
                    java.lang.String str2 = it.next().packageName;
                    java.lang.String str3 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    android.content.pm.PackageInfo g2 = g(str2);
                    if (g2 != null && (serviceInfoArr = g2.services) != null && serviceInfoArr.length > 0) {
                        for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                            for (java.lang.String str4 : split) {
                                if (str4.equals(serviceInfo.name)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "check s not allow watchout s.");
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static boolean a(android.content.Intent intent, android.content.Context context) {
        if (intent != null && context != null) {
            try {
                java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                if (queryIntentServices != null) {
                    if (queryIntentServices.size() > 0) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return false;
    }

    public static boolean a(java.lang.String str) {
        android.os.Bundle bundle;
        try {
            android.content.pm.PackageInfo a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 128);
            if (a2 != null && (bundle = a2.applicationInfo.metaData) != null) {
                java.lang.String str2 = (java.lang.String) bundle.get(com.igexin.push.core.b.b);
                java.lang.String str3 = (java.lang.String) bundle.get("com.sdk.plus.appid");
                if (android.text.TextUtils.isEmpty(str2)) {
                    return !android.text.TextUtils.isEmpty(str3);
                }
                return true;
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(str2) && !"none".equalsIgnoreCase(str2)) {
                java.lang.String[] split = str2.split(",");
                if (split.length < 3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(str, "hc config len err.");
                    return false;
                }
                boolean z = com.getui.gtc.extension.distribution.gbd.d.h.bb >= java.lang.Integer.parseInt(split[0]);
                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.bc;
                boolean z2 = currentTimeMillis >= java.lang.Long.parseLong(split[1]) * 1000;
                boolean z3 = com.getui.gtc.extension.distribution.gbd.d.h.be >= java.lang.Long.parseLong(split[2]) * 1000;
                com.getui.gtc.extension.distribution.gbd.n.j.b(str, "LT: " + com.getui.gtc.extension.distribution.gbd.d.h.bb + ", IT: " + currentTimeMillis + ", RT: " + com.getui.gtc.extension.distribution.gbd.d.h.be);
                return z && z2 && z3;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(str, "hc config empty.");
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (str.equals(str3)) {
            return true;
        }
        for (java.lang.String str5 : str.split(str2)) {
            if (str4.equals(str5)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(int... iArr) {
        try {
            java.lang.String[] split = ((java.lang.String) com.getui.gtc.BuildConfig.class.getField("VERSION_NAME").get(null)).substring(4).split("\\.");
            if (split.length >= 4) {
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int parseInt = java.lang.Integer.parseInt(split[i2]);
                    int i3 = iArr[i2];
                    if (parseInt != i3) {
                        return parseInt > i3;
                    }
                    if (i2 == length - 1) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return false;
    }

    private static boolean aa() {
        try {
            java.lang.String str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.getui.gtc.extension.distribution.gbd.f.e.b.b).ramCacheValidTime(0L).useExpiredCacheForReserve(true).build());
            if (android.text.TextUtils.isEmpty(str)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "mei empty.");
                return false;
            }
            int intValue = java.lang.Integer.valueOf(str.substring(str.length() - 4), 16).intValue();
            int intValue2 = java.lang.Integer.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.cc, 16).intValue();
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, " 43 dynamic= " + com.getui.gtc.extension.distribution.gbd.d.d.cc);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "imei= " + intValue + "  43mask= " + intValue2);
            for (int i2 = 0; i2 < 16; i2++) {
                int i3 = 1 << i2;
                if ((intValue2 & i3) != 0 && (i3 & intValue) == 0) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "mei not match.");
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static java.util.List<java.lang.String> ab() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
            java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
            if (externalStorageState.equals("mounted") && externalStorageDirectory.exists() && externalStorageDirectory.isDirectory()) {
                arrayList.add(externalStorageDirectory.getAbsolutePath());
                com.getui.gtc.extension.distribution.gbd.n.j.b("getSDCardPathList", "primary sdcard path: " + externalStorageDirectory.getAbsolutePath());
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:3:0x0001, B:5:0x000c, B:9:0x0018, B:12:0x0028, B:14:0x0030, B:18:0x003f, B:20:0x004d, B:24:0x005d, B:26:0x006b, B:38:0x0076, B:41:0x0059, B:42:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:3:0x0001, B:5:0x000c, B:9:0x0018, B:12:0x0028, B:14:0x0030, B:18:0x003f, B:20:0x004d, B:24:0x005d, B:26:0x006b, B:38:0x0076, B:41:0x0059, B:42:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean ac() {
        boolean z;
        java.lang.String displayName;
        boolean z2;
        java.lang.String language;
        boolean z3;
        java.lang.String country;
        boolean z4;
        try {
            java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.c.a;
            if (!e("com.google.android.gms") && !e("com.android.vending")) {
                z = false;
                displayName = java.util.TimeZone.getDefault().getDisplayName(false, 0);
                if (!android.text.TextUtils.isEmpty(displayName) && (displayName.equals("GMT+08:00") || displayName.contains("+08"))) {
                    z2 = false;
                    language = java.util.Locale.getDefault().getLanguage();
                    if (!android.text.TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.Q)) {
                        z3 = false;
                        country = java.util.Locale.getDefault().getCountry();
                        if (!android.text.TextUtils.isEmpty(country) && country.equals("CN")) {
                            z4 = false;
                            return ((!z2 || z3 || z4) && z) ? false : true;
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
                        z4 = true;
                        if (!z2) {
                        }
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, language);
                    z3 = true;
                    country = java.util.Locale.getDefault().getCountry();
                    if (!android.text.TextUtils.isEmpty(country)) {
                        z4 = false;
                        if (!z2) {
                        }
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
                    z4 = true;
                    if (!z2) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, displayName);
                z2 = true;
                language = java.util.Locale.getDefault().getLanguage();
                if (!android.text.TextUtils.isEmpty(language)) {
                    z3 = false;
                    country = java.util.Locale.getDefault().getCountry();
                    if (!android.text.TextUtils.isEmpty(country)) {
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
                    z4 = true;
                    if (!z2) {
                    }
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, language);
                z3 = true;
                country = java.util.Locale.getDefault().getCountry();
                if (!android.text.TextUtils.isEmpty(country)) {
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
                z4 = true;
                if (!z2) {
                }
            }
            z = true;
            displayName = java.util.TimeZone.getDefault().getDisplayName(false, 0);
            if (!android.text.TextUtils.isEmpty(displayName)) {
                z2 = false;
                language = java.util.Locale.getDefault().getLanguage();
                if (!android.text.TextUtils.isEmpty(language)) {
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, language);
                z3 = true;
                country = java.util.Locale.getDefault().getCountry();
                if (!android.text.TextUtils.isEmpty(country)) {
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
                z4 = true;
                if (!z2) {
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, displayName);
            z2 = true;
            language = java.util.Locale.getDefault().getLanguage();
            if (!android.text.TextUtils.isEmpty(language)) {
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, language);
            z3 = true;
            country = java.util.Locale.getDefault().getCountry();
            if (!android.text.TextUtils.isEmpty(country)) {
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, country);
            z4 = true;
            if (!z2) {
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static boolean ad() {
        return c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn);
    }

    public static int b(int i2) {
        if (i2 == 1) {
            return 111;
        }
        if (i2 == 3) {
            return 114;
        }
        if (i2 == 7) {
            return 127;
        }
        if (i2 == 17) {
            return com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE;
        }
        if (i2 == 13) {
            return 131;
        }
        if (i2 != 14) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID;
    }

    private static long b(long j2) {
        long j3 = 1;
        do {
            j3 *= 2;
            j2 /= 2;
        } while (j2 > 0);
        return j3;
    }

    public static long b(long j2, int i2) {
        int i3 = 32 - i2;
        return i2 < 31 ? (j2 | ((1 << i3) - 1)) - 1 : j2 | ((1 << i3) - 1);
    }

    private static java.lang.String b(android.content.Context context, boolean z) {
        if ((!a(context, com.anythink.china.common.d.b) && !a(context, "android.permission.READ_EXTERNAL_STORAGE")) || !com.getui.gtc.extension.distribution.gbd.n.x.a(2, 2)) {
            return "";
        }
        java.io.File[] listFiles = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + (z ? "/libs" : "/libs/w")).listFiles(new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass1());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (listFiles != null && listFiles.length > 0) {
            for (java.io.File file : listFiles) {
                java.lang.String a2 = a(file.getAbsolutePath(), z);
                if (!android.text.TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    sb.append(",");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static java.lang.String b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "g4code start : ".concat(java.lang.String.valueOf(str)));
        if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aH)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "g4code end : " + str + ", use cache value");
            return com.getui.gtc.extension.distribution.gbd.d.h.aH;
        }
        try {
            com.getui.gtc.extension.distribution.gbd.d.h.aH = a(false) + "|" + b(false) + "|" + com.getui.gtc.extension.distribution.gbd.n.o.c() + "|" + l(str);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "g4code end : ".concat(java.lang.String.valueOf(str)));
            return com.getui.gtc.extension.distribution.gbd.d.h.aH;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "|||";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Process process;
        java.io.BufferedReader bufferedReader;
        java.util.regex.Matcher matcher;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            if (new java.io.File(str).exists()) {
                java.util.regex.Pattern compile = java.util.regex.Pattern.compile(str3);
                process = java.lang.Runtime.getRuntime().exec(str + str2);
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()), 8192);
                    do {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                matcher = compile.matcher(readLine);
                            }
                        } catch (java.lang.Exception unused) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e2) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (java.lang.Throwable th) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                }
                            }
                            return null;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (java.io.IOException e3) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                                }
                            }
                            if (process == null) {
                                throw th;
                            }
                            try {
                                process.destroy();
                                throw th;
                            } catch (java.lang.Throwable th3) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                                throw th;
                            }
                        }
                    } while (!matcher.matches());
                    java.lang.String group = matcher.group(1);
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e4) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                    }
                    try {
                        process.destroy();
                    } catch (java.lang.Throwable th4) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                    }
                    return group;
                } catch (java.lang.Exception unused2) {
                    bufferedReader = null;
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } else {
                process = null;
                bufferedReader = null;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e5) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e5);
                }
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (java.lang.Throwable th6) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th6);
                }
            }
            return null;
        } catch (java.lang.Exception unused3) {
            process = null;
            bufferedReader = null;
        } catch (java.lang.Throwable th7) {
            th = th7;
            process = null;
        }
    }

    public static synchronized java.lang.String b(boolean z) {
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.e, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass19());
            if (z) {
                return a2;
            }
            com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.f, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass20());
            com.getui.gtc.extension.distribution.gbd.f.c unused3 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.g, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass21());
            java.lang.String str = "";
            if (!android.text.TextUtils.isEmpty(a2) || !android.text.TextUtils.isEmpty(a3) || !android.text.TextUtils.isEmpty(a4)) {
                str = a2 + "#" + a3 + "," + a4;
            }
            return str;
        }
    }

    public static boolean b() {
        try {
            android.content.pm.PackageInfo a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName(), 0);
            if (a2 != null) {
                boolean z = (a2.applicationInfo.flags & 2) > 0;
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "self APP is debug = ".concat(java.lang.String.valueOf(z)));
                return z;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return true;
    }

    public static boolean b(android.content.Context context) {
        return a(context, "android.permission.READ_EXTERNAL_STORAGE") || a(context, com.anythink.china.common.d.b);
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        try {
            for (java.lang.String str2 : com.getui.gtc.extension.distribution.gbd.n.k.a(context.getPackageName(), 4096).requestedPermissions) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return false;
    }

    private static boolean b(android.content.Intent intent, android.content.Context context) {
        if (intent != null && context != null) {
            try {
                java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers != null) {
                    if (queryBroadcastReceivers.size() > 0) {
                        return true;
                    }
                }
                return false;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return false;
    }

    public static long c(long j2, int i2) {
        return (j2 >> (i2 * 8)) & 255;
    }

    public static java.lang.String c() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.m, "", new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass12());
        return str == null ? "" : str;
    }

    public static boolean c(int i2) {
        boolean g2 = g(i2);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, i2 + " inGBDTypeBlackList " + g2);
        return g2;
    }

    public static boolean c(android.content.Context context) {
        if (c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)) {
            try {
                boolean z = android.provider.Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
                android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null && registerReceiver.getExtras() != null) {
                    return z && registerReceiver.getExtras().getInt("plugged") == 2;
                }
                return true;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return true;
    }

    public static boolean c(java.lang.String str) {
        return java.util.regex.Pattern.compile("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$").matcher(str).matches();
    }

    private static boolean c(boolean z) {
        return z || d();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:11:0x0049, B:13:0x0059, B:15:0x005f, B:16:0x0069, B:18:0x006f, B:21:0x009a), top: B:10:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d() {
        boolean z;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z2 = false;
        try {
            z = ((java.lang.Boolean) com.getui.gtc.base.util.CommonUtil.class.getMethod("isAppForeground", new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).booleanValue();
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "is in fg = ".concat(java.lang.String.valueOf(z)));
                z2 = true;
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "new check fg ex=" + th.toString());
                if (!z2) {
                    try {
                        runningAppProcesses = ((android.app.ActivityManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("activity")).getRunningAppProcesses();
                        if (runningAppProcesses != null) {
                            java.lang.String packageName = com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName();
                            while (r2.hasNext()) {
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "old check fg ex=" + th2.toString());
                    }
                }
                return z;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            z = false;
        }
        if (!z2 && com.getui.gtc.extension.distribution.gbd.d.d.N) {
            runningAppProcesses = ((android.app.ActivityManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                java.lang.String packageName2 = com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName();
                for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "RAP:  " + runningAppProcessInfo.processName + " importance " + runningAppProcessInfo.importance);
                    if (packageName2.equals(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return z;
    }

    public static synchronized boolean d(int i2) {
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            try {
                if (com.getui.gtc.extension.distribution.gbd.d.h.L == null) {
                    com.getui.gtc.extension.distribution.gbd.d.h.L = new java.util.concurrent.CopyOnWriteArrayList<>();
                }
                if (com.getui.gtc.extension.distribution.gbd.d.h.L.size() > 0) {
                    return com.getui.gtc.extension.distribution.gbd.d.h.L.contains(java.lang.Integer.valueOf(i2));
                }
                if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cl) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.cl)) {
                    for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.cl.split(",")) {
                        com.getui.gtc.extension.distribution.gbd.d.h.L.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(str)));
                    }
                }
                return com.getui.gtc.extension.distribution.gbd.d.h.L.contains(java.lang.Integer.valueOf(i2));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return false;
            }
        }
    }

    public static boolean d(android.content.Context context) {
        try {
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if ((memoryInfo.availMem / 1024) / 1024 < com.getui.gtc.extension.distribution.gbd.d.d.br) {
                return false;
            }
            return (((java.lang.Runtime.getRuntime().maxMemory() - java.lang.Runtime.getRuntime().totalMemory()) + java.lang.Runtime.getRuntime().freeMemory()) / 1024) / 1024 > ((long) com.getui.gtc.extension.distribution.gbd.d.d.bs);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String upperCase = str.toUpperCase();
        upperCase.hashCode();
        switch (upperCase) {
        }
        return false;
    }

    public static int e() {
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(nextElement.getName())) {
                    for (java.net.InterfaceAddress interfaceAddress : nextElement.getInterfaceAddresses()) {
                        java.net.InetAddress address = interfaceAddress.getAddress();
                        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        if (!address.isLoopbackAddress() && (address instanceof java.net.Inet4Address)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "IPv4 maskLength: ".concat(java.lang.String.valueOf((int) networkPrefixLength)));
                            if (networkPrefixLength > 0) {
                                return networkPrefixLength;
                            }
                            return 24;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return 24;
    }

    public static java.lang.String e(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static boolean e(android.content.Context context) {
        try {
            return ((android.os.PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static boolean e(java.lang.String str) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static android.content.pm.PackageInfo f(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static synchronized java.lang.String f() {
        java.lang.String str;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.b, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass15());
        }
        return str;
    }

    private static synchronized boolean f(int i2) {
        synchronized (com.getui.gtc.extension.distribution.gbd.n.l.class) {
            try {
                if (com.getui.gtc.extension.distribution.gbd.d.h.A == null) {
                    com.getui.gtc.extension.distribution.gbd.d.h.A = new java.util.concurrent.CopyOnWriteArrayList<>();
                }
                if (com.getui.gtc.extension.distribution.gbd.d.h.A.size() > 0) {
                    return com.getui.gtc.extension.distribution.gbd.d.h.A.contains(java.lang.Integer.valueOf(i2));
                }
                if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.h) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.h)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "newly typeCollectOnlyForeground: " + com.getui.gtc.extension.distribution.gbd.d.d.h);
                    for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.h.split(",")) {
                        com.getui.gtc.extension.distribution.gbd.d.h.A.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(str)));
                    }
                }
                return com.getui.gtc.extension.distribution.gbd.d.h.A.contains(java.lang.Integer.valueOf(i2));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return true;
            }
        }
    }

    public static boolean f(android.content.Context context) {
        android.net.NetworkInfo r = r(context);
        return r != null && r.getType() == 0;
    }

    public static android.content.pm.PackageInfo g(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str, 4);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public static java.lang.String g() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.j, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    private static boolean g(int i2) {
        try {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.ay) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.ay)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "typeBrandSdkRomBlackList = " + com.getui.gtc.extension.distribution.gbd.d.d.ay);
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.ay.split(",");
                if (split.length > 0) {
                    java.lang.String w = w();
                    int i3 = com.getui.gtc.extension.distribution.gbd.d.h.h;
                    java.lang.String lowerCase = z().toLowerCase();
                    for (java.lang.String str : split) {
                        java.lang.String[] split2 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        if (split2.length >= 4) {
                            java.lang.String str2 = split2[0];
                            int parseInt = java.lang.Integer.parseInt(split2[1]);
                            java.lang.String str3 = split2[2];
                            java.lang.String str4 = split2[3];
                            if (w.equalsIgnoreCase(str2) && i3 >= parseInt) {
                                java.util.List asList = java.util.Arrays.asList(str4.split("&"));
                                if ("*".equals(str3)) {
                                    return asList.contains(java.lang.String.valueOf(i2));
                                }
                                java.lang.String[] split3 = str3.split("&");
                                if (split3.length > 0) {
                                    for (java.lang.String str5 : split3) {
                                        if (lowerCase.contains(str5.toLowerCase())) {
                                            return asList.contains(java.lang.String.valueOf(i2));
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }

    public static boolean g(android.content.Context context) {
        android.net.NetworkInfo r = r(context);
        return r != null && r.getType() == 1;
    }

    public static int h(android.content.Context context) {
        return r(context).getType();
    }

    public static long h(java.lang.String str) {
        java.lang.String[] split = str.split("\\.");
        return (java.lang.Integer.parseInt(split[0]) * 16777216) + (java.lang.Integer.parseInt(split[1]) * 65536) + (java.lang.Integer.parseInt(split[2]) * 256) + java.lang.Integer.parseInt(split[3]);
    }

    public static java.lang.String h() {
        try {
            java.lang.String[] strArr = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= 4) {
                    break;
                }
                if (!a(com.getui.gtc.extension.distribution.gbd.d.c.d, strArr[i2])) {
                    i3 = 0;
                }
                sb.append(i3);
                sb.append(",");
                i2++;
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "checkType11Permission: " + sb.toString());
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "-1,-1,-1,-1";
        }
    }

    private static java.lang.String h(int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i3 = 0; i3 < 4; i3++) {
            sb.append((i2 >> (i3 * 8)) & 255);
            sb.append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static java.lang.String i() {
        int i2;
        int i3;
        int i4;
        int i5 = -1;
        if (c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)) {
            try {
                i2 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "bluetooth_on", -1);
                try {
                    i3 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "location_mode", -1);
                    try {
                        i5 = i2;
                        i4 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "wifi_on", -1);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        i5 = i2;
                        i4 = -1;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "bluetoothStatus: " + i5 + ", locationStatus: " + i3 + ", wifiStatus: " + i4);
                        return i5 + "," + i3 + "," + i4;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    i3 = -1;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    i5 = i2;
                    i4 = -1;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "bluetoothStatus: " + i5 + ", locationStatus: " + i3 + ", wifiStatus: " + i4);
                    return i5 + "," + i3 + "," + i4;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                i2 = -1;
            }
        } else {
            i4 = -1;
            i3 = -1;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "bluetoothStatus: " + i5 + ", locationStatus: " + i3 + ", wifiStatus: " + i4);
        return i5 + "," + i3 + "," + i4;
    }

    public static java.lang.String i(java.lang.String str) {
        android.os.Bundle bundle;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bD)) {
            for (java.lang.String str2 : com.getui.gtc.extension.distribution.gbd.d.d.bD.split(",")) {
                try {
                    android.content.pm.PackageInfo a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 128);
                    if (a2 != null && (bundle = a2.applicationInfo.metaData) != null) {
                        java.lang.String str3 = (java.lang.String) bundle.get(str2);
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            java.lang.String replace = str3.replace("|", "$");
                            sb.append(str2);
                            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                            sb.append(replace);
                            sb.append("&");
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            if (sb.length() > 0 && sb.toString().endsWith("&")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static boolean i(android.content.Context context) {
        try {
            android.net.NetworkInfo r = r(context);
            if (r != null) {
                if (r.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static int j(android.content.Context context) {
        android.net.NetworkInfo r = r(context);
        if (r == null || android.text.TextUtils.isEmpty(r.getExtraInfo())) {
            return 4;
        }
        java.lang.String extraInfo = r.getExtraInfo();
        if (extraInfo.equalsIgnoreCase("3gwap") || extraInfo.equalsIgnoreCase("uniwap") || extraInfo.equalsIgnoreCase("3gnet") || extraInfo.equalsIgnoreCase("uninet")) {
            return 2;
        }
        if (extraInfo.equalsIgnoreCase("cmnet") || extraInfo.equalsIgnoreCase("cmwap")) {
            return 1;
        }
        return (extraInfo.equalsIgnoreCase("ctnet") || extraInfo.equalsIgnoreCase("ctwap") || extraInfo.equalsIgnoreCase("ctlte")) ? 3 : 4;
    }

    public static java.lang.String j() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.aM, com.getui.gtc.extension.distribution.gbd.f.e.b.i, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass2());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0041 -> B:23:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] j(java.lang.String str) {
        ?? r5;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        java.io.FileInputStream fileInputStream2 = null;
        if (!b(com.getui.gtc.extension.distribution.gbd.d.c.d) || !new java.io.File(str).exists()) {
            return null;
        }
        byte[] bArr2 = new byte[1024];
        try {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
            } catch (java.lang.Exception e2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r5 = 0;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.lang.Exception e4) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                }
            }
            if (r5 != 0) {
                throw th;
            }
            try {
                r5.close();
                throw th;
            } catch (java.lang.Exception e5) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e5);
                throw th;
            }
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                try {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (java.lang.Exception e6) {
                    e = e6;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception e7) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e7);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                fileInputStream.close();
            } catch (java.lang.Exception e8) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e8);
            }
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e9) {
            e = e9;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            str = null;
            fileInputStream2 = fileInputStream;
            r5 = str;
            if (fileInputStream2 != null) {
            }
            if (r5 != 0) {
            }
        }
        return bArr;
    }

    public static java.lang.String k(java.lang.String str) {
        java.lang.String str2;
        if (!t("HONOR")) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-s : " + str + ", without brand(h)");
            return "";
        }
        boolean a2 = a(3, 2, 11, 0);
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        if (a2) {
            str2 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.l, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass9());
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-2-s : " + str + ", collect by gtc");
        } else {
            java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.k, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass10());
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-s : " + str + ", collect by gtc");
            java.lang.String u = u(str);
            if (a3 == null) {
                a3 = "";
            }
            str2 = a3 + "#" + (u != null ? u : "");
        }
        java.lang.String str3 = android.text.TextUtils.isEmpty(str2) ? "#" : str2;
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-s : " + str + ", final value : " + str3);
        return str3;
    }

    public static boolean k() {
        return a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_FINE_LOCATION") && a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public static boolean k(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.Boolean bool = (java.lang.Boolean) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "wi", context, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass6());
        return bool != null && bool.booleanValue();
    }

    public static java.lang.String l(java.lang.String str) {
        java.lang.String u = u(str);
        if (android.text.TextUtils.isEmpty(u)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1 : " + str + ", hValue is empty, collect by gtc");
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            u = com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.ck, com.getui.gtc.extension.distribution.gbd.f.e.b.k, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass11());
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1 : " + str + ", final value : " + u);
        return u;
    }

    public static boolean l() {
        android.content.Context context;
        java.lang.String str;
        if (android.os.Build.VERSION.SDK_INT >= 29 && com.getui.gtc.extension.distribution.gbd.d.c.d.getApplicationInfo().targetSdkVersion >= 29) {
            context = com.getui.gtc.extension.distribution.gbd.d.c.d;
            str = "android.permission.ACCESS_FINE_LOCATION";
        } else {
            context = com.getui.gtc.extension.distribution.gbd.d.c.d;
            str = "android.permission.ACCESS_COARSE_LOCATION";
        }
        return a(context, str);
    }

    public static boolean l(android.content.Context context) {
        return c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn) && android.provider.Settings.System.getInt(context.getContentResolver(), "auto_time", 1) == 1;
    }

    public static int m(android.content.Context context) {
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        java.lang.String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod(f, cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(((java.lang.Integer) cls.getDeclaredField(g).get(java.lang.Integer.class)).intValue()), java.lang.Integer.valueOf(i2), packageName)).intValue() == 0 ? 1 : 0;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0;
        }
    }

    public static java.lang.String m() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.p, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    public static boolean m(java.lang.String str) {
        try {
            int i2 = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0).applicationInfo.flags;
            return !((i2 & 1) == 0 || (i2 & 128) != 0);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static java.lang.String n() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.q, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    public static java.lang.String n(java.lang.String str) {
        java.lang.String[] strArr;
        java.lang.String[] split;
        java.lang.String[] split2;
        if (!com.getui.gtc.extension.distribution.gbd.n.x.a(2, 2)) {
            return "";
        }
        try {
            byte[] j2 = j("/sdcard/libs/" + str + com.umeng.analytics.process.a.d);
            if (j2 == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.a("GBDUtils", str + ".db not exist");
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBDUtils", str + ".db not exist");
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                if (a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a)) {
                    java.lang.String a2 = a(true);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.ad.a(a2);
                        if (!android.text.TextUtils.isEmpty(a3) && !a3.equals(com.getui.gtc.extension.distribution.gbd.d.c.h)) {
                            arrayList.add(a3);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            arrayList.add(com.getui.gtc.extension.distribution.gbd.d.c.h);
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a(""));
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a("000000000000000"));
            arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a("cantgetimei"));
            java.lang.String a4 = a(false);
            if (!android.text.TextUtils.isEmpty(a4) && (split = a4.split("#")) != null && split.length == 2 && (split2 = split[1].split(",")) != null && split2.length > 0) {
                for (java.lang.String str2 : split2) {
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        arrayList.add(com.getui.gtc.extension.distribution.gbd.n.ad.a(str2));
                    }
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    strArr = null;
                    break;
                }
                java.lang.String str3 = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.t.a(j2, (java.lang.String) it.next()));
                if (java.util.regex.Pattern.matches("[\\.:0-9a-zA-Z_\\|]+", str3)) {
                    strArr = str3.split("\\|");
                    break;
                }
            }
            if (strArr == null || strArr.length < 3 || strArr.length <= 3) {
                return null;
            }
            java.lang.String str4 = strArr[3];
            if (str4 != null) {
                try {
                    if (str4.equals(com.igexin.push.core.b.m)) {
                        return null;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            return str4;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public static boolean n(android.content.Context context) {
        try {
            if (!c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)) {
                android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
                return registerReceiver == null || registerReceiver.getExtras() == null || registerReceiver.getExtras().getInt("plugged") == 2;
            }
            boolean z = android.provider.Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            android.content.Intent registerReceiver2 = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver2 != null && registerReceiver2.getExtras() != null) {
                return z && registerReceiver2.getExtras().getInt("plugged") == 2;
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }

    public static int o() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.Integer num = (java.lang.Integer) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.o, "", new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass5());
        if (num == null) {
            return 24;
        }
        return num.intValue();
    }

    public static java.lang.String o(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            android.content.pm.PackageInfo a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 64);
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            byte[] byteArray = a2.signatures[0].toByteArray();
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            for (int i2 = 0; i2 < digest.length; i2++) {
                java.lang.String num = java.lang.Integer.toString(digest[i2] & 255, 16);
                if (num.length() == 1) {
                    num = "0".concat(num);
                }
                if (i2 != digest.length - 1) {
                    num = num + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
                }
                sb2.append(num);
            }
            java.lang.String upperCase = sb2.toString().toUpperCase();
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(byteArray));
            java.lang.String bigInteger = x509Certificate.getSerialNumber().toString();
            java.lang.String principal = x509Certificate.getSubjectDN().toString();
            java.lang.String b2 = com.getui.gtc.extension.distribution.gbd.n.b.b(a2);
            sb.append(upperCase);
            sb.append("&");
            sb.append(principal);
            sb.append("&");
            sb.append(bigInteger);
            sb.append("&");
            if (!android.text.TextUtils.isEmpty(b2)) {
                try {
                    java.io.File file = new java.io.File(b2);
                    if (file.exists()) {
                        sb.append(file.length());
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return sb.toString();
    }

    public static boolean o(android.content.Context context) {
        try {
            if (!com.getui.gtc.extension.distribution.gbd.d.d.bZ) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "close cs.");
                return true;
            }
            if (p(context)) {
                return false;
            }
            java.lang.String language = java.util.Locale.getDefault().getLanguage();
            if (!android.text.TextUtils.isEmpty(language) && language.equals(com.anythink.expressad.video.dynview.a.a.Q)) {
                java.lang.String country = java.util.Locale.getDefault().getCountry();
                if (!android.text.TextUtils.isEmpty(country) && country.equals("CN")) {
                    return (((com.getui.gtc.extension.distribution.gbd.d.c.d.getApplicationInfo().flags & 2) > 0) || n(context)) ? false : true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static java.lang.String p(java.lang.String str) {
        try {
            android.os.Bundle bundle = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 128).applicationInfo.metaData;
            if (bundle == null) {
                return "";
            }
            for (java.lang.String str2 : bundle.keySet()) {
                if ("com.sdk.plus.appid".equals(str2)) {
                    return bundle.get(str2).toString();
                }
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> p() {
        return com.getui.gtc.extension.distribution.gbd.b.a.b.a.a();
    }

    public static boolean p(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "check v. need = " + com.getui.gtc.extension.distribution.gbd.d.d.ca);
        if (!com.getui.gtc.extension.distribution.gbd.d.d.ca) {
            return false;
        }
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            android.net.NetworkInfo networkInfo = (android.net.NetworkInfo) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.h, context, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass4());
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static int q(android.content.Context context) {
        try {
            android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && registerReceiver.getExtras() != null) {
                return registerReceiver.getExtras().getInt(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1);
            }
            return -1;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "power p e = ".concat(java.lang.String.valueOf(th)));
            return -1;
        }
    }

    public static java.lang.String q() {
        try {
            java.lang.String[] strArr = {"android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= 3) {
                    break;
                }
                if (!a(com.getui.gtc.extension.distribution.gbd.d.c.d, strArr[i2])) {
                    i3 = 0;
                }
                sb.append(i3);
                sb.append("#");
                i2++;
            }
            if (sb.toString().endsWith("#")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "checkType27 Permission: " + sb.toString());
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "-1#-1#-1";
        }
    }

    private static java.lang.String q(java.lang.String str) {
        try {
            android.os.Bundle bundle = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 128).applicationInfo.metaData;
            if (bundle == null) {
                return "";
            }
            for (java.lang.String str2 : bundle.keySet()) {
                if (str2.equals(com.igexin.push.core.b.b) || str2.equals("appid")) {
                    return bundle.get(str2).toString();
                }
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static android.net.NetworkInfo r(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (android.net.NetworkInfo) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.h, context, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass3());
    }

    public static java.lang.String r() {
        int i2;
        int i3;
        int i4 = -1;
        if (c(com.getui.gtc.extension.distribution.gbd.d.d.f322cn)) {
            try {
                i2 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "location_mode", -1);
                try {
                    i4 = i2;
                    i3 = android.provider.Settings.Secure.getInt(com.getui.gtc.extension.distribution.gbd.d.c.d.getContentResolver(), "wifi_on", -1);
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    i4 = i2;
                    i3 = -1;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "type27: locationStatus: " + i4 + ", wifiStatus: " + i3);
                    return i4 + "#" + i3;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                i2 = -1;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "type27: locationStatus: " + i4 + ", wifiStatus: " + i3);
            return i4 + "#" + i3;
        }
        i3 = -1;
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "type27: locationStatus: " + i4 + ", wifiStatus: " + i3);
        return i4 + "#" + i3;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0080 -> B:13:0x0083). Please report as a decompilation issue!!! */
    private static boolean r(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Process process;
        java.lang.String replaceAll;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec("ping -c 1 -W 1 ".concat(java.lang.String.valueOf(str)));
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                    while (true) {
                        try {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e2) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                                }
                                process.destroy();
                                break;
                            }
                            try {
                                replaceAll = readLine.replaceAll(" ", "");
                            } catch (java.lang.Throwable th2) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                            }
                            if (replaceAll.contains("1packetstransmitted,1packetsreceived") || replaceAll.contains("1packetstransmitted,1received")) {
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException e3) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                                }
                                try {
                                    process.destroy();
                                    return true;
                                } catch (java.lang.Throwable th3) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                                    return true;
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            try {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (java.io.IOException e4) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                                    }
                                }
                                if (process == null) {
                                    return false;
                                }
                                process.destroy();
                                return false;
                            } finally {
                            }
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    bufferedReader = null;
                    th = th5;
                }
            } catch (java.lang.Throwable th6) {
                bufferedReader = null;
                th = th6;
                process = null;
            }
        } catch (java.lang.Throwable th7) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th7);
        }
    }

    private static android.net.NetworkInfo s(android.content.Context context) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (android.net.NetworkInfo) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.h, context, new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass4());
    }

    private static java.lang.String s(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Process process;
        try {
            process = java.lang.Runtime.getRuntime().exec(str);
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    java.lang.String str2 = android.text.TextUtils.isEmpty(readLine) ? "0" : readLine;
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                    }
                    try {
                        process.destroy();
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                    }
                    return str2;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e3) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                            }
                        }
                        if (process != null) {
                            try {
                                process.destroy();
                            } catch (java.lang.Throwable th4) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                            }
                        }
                        return "0";
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (java.lang.Throwable th6) {
            bufferedReader = null;
            th = th6;
            process = null;
        }
    }

    public static boolean s() {
        try {
            android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.isEnabled();
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static java.util.ArrayList<java.lang.Long> t() {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Process process;
        java.io.BufferedReader bufferedReader2;
        try {
            try {
                process = java.lang.Runtime.getRuntime().exec("cat /proc/net/arp");
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            process = null;
            bufferedReader2 = null;
        } catch (java.lang.Throwable th3) {
            bufferedReader = null;
            th = th3;
            process = null;
        }
        try {
            bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
            try {
                java.util.ArrayList<java.lang.Long> arrayList = new java.util.ArrayList<>();
                while (true) {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        try {
                            if (!readLine.contains("IP") && !readLine.contains(com.alipay.sdk.m.u.c.b)) {
                                java.lang.Long valueOf = java.lang.Long.valueOf(c(h(readLine.split(" +")[0]), 1));
                                if (!arrayList.contains(valueOf)) {
                                    arrayList.add(valueOf);
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
                        }
                    } else {
                        try {
                            break;
                        } catch (java.io.IOException e3) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                        }
                    }
                }
                bufferedReader2.close();
                try {
                    process.destroy();
                } catch (java.lang.Throwable th5) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th5);
                }
                return arrayList;
            } catch (java.lang.Exception e4) {
                e = e4;
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e5) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e5);
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (java.lang.Throwable th6) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th6);
                    }
                }
                return null;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
            bufferedReader2 = null;
        } catch (java.lang.Throwable th7) {
            bufferedReader = null;
            th = th7;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e7) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e7);
                }
            }
            if (process == null) {
                throw th;
            }
            try {
                process.destroy();
                throw th;
            } catch (java.lang.Throwable th8) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th8);
                throw th;
            }
        }
    }

    private static boolean t(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        return !android.text.TextUtils.isEmpty(str2) && str2.toUpperCase().equalsIgnoreCase(str.toUpperCase());
    }

    public static java.lang.String u() {
        java.io.File[] listFiles;
        android.os.Bundle bundle;
        if (!com.getui.gtc.extension.distribution.gbd.n.x.a(2, 1)) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            for (android.content.pm.PackageInfo packageInfo : com.getui.gtc.extension.distribution.gbd.n.b.a()) {
                try {
                    android.content.pm.PackageInfo a2 = com.getui.gtc.extension.distribution.gbd.n.k.a(packageInfo.packageName, 128);
                    if (a2 != null && (bundle = a2.applicationInfo.metaData) != null) {
                        java.lang.String str = (java.lang.String) (bundle.get(com.igexin.push.core.b.b) == null ? "" : bundle.get(com.igexin.push.core.b.b));
                        java.lang.String str2 = (java.lang.String) (bundle.get("PUSH_APPKEY") == null ? "" : bundle.get("PUSH_APPKEY"));
                        java.lang.String str3 = (java.lang.String) (bundle.get("PUSH_APPSECRET") == null ? "" : bundle.get("PUSH_APPSECRET"));
                        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3)) {
                            sb.append(packageInfo.packageName);
                            sb.append("|");
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            if (b(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                java.io.File file = new java.io.File("/sdcard/libs/");
                if (file.exists() && (listFiles = file.listFiles(new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass7())) != null) {
                    for (java.io.File file2 : listFiles) {
                        java.io.File[] listFiles2 = file2.listFiles(new com.getui.gtc.extension.distribution.gbd.n.l.AnonymousClass8());
                        if (listFiles2 != null) {
                            for (java.io.File file3 : listFiles2) {
                                java.lang.String name = file3.getName();
                                if (!android.text.TextUtils.isEmpty(name) && name.contains(".bin")) {
                                    sb.append(name.substring(0, name.lastIndexOf(".")));
                                    sb.append("|");
                                }
                            }
                        }
                    }
                }
            }
            if (!android.text.TextUtils.isEmpty(sb.toString()) && sb.toString().endsWith("|")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
        return sb.toString();
    }

    private static java.lang.String u(java.lang.String str) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-h : " + str + ",  enable : " + com.getui.gtc.extension.distribution.gbd.d.d.dn + ",  interval : " + (com.getui.gtc.extension.distribution.gbd.d.d.f3do * 1000));
            android.content.Context context = com.getui.gtc.extension.distribution.gbd.d.c.d;
            boolean z = false;
            if (!a(3, 2, 11, 0) && com.getui.gtc.extension.distribution.gbd.d.d.dn && t("HONOR") && com.getui.gtc.extension.distribution.gbd.n.r.g.a()) {
                z = true;
            }
            if (!z) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-h : " + str + ",  not meet the conditions");
                return "";
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long j2 = com.getui.gtc.extension.distribution.gbd.d.h.k;
            if (j2 > 0 && currentTimeMillis - j2 < com.getui.gtc.extension.distribution.gbd.d.d.f3do * 1000) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-h : " + str + ", collect time(" + com.getui.gtc.extension.distribution.gbd.d.h.k + "),  diff(" + (currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.k) + ")，collect by gbd cache");
                return com.getui.gtc.extension.distribution.gbd.d.h.l;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dim-2-1-5-1-h : " + str + ", collect by gbd");
            com.getui.gtc.extension.distribution.gbd.n.r.g gVar = new com.getui.gtc.extension.distribution.gbd.n.r.g();
            gVar.c(context);
            java.lang.String b2 = gVar.b(context);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.d.h.l = b2;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(190, com.getui.gtc.extension.distribution.gbd.n.ad.a(b2.getBytes()));
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            long currentTimeMillis2 = java.lang.System.currentTimeMillis();
            com.getui.gtc.extension.distribution.gbd.d.h.k = currentTimeMillis2;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.google.android.exoplayer2.extractor.ts.PsExtractor.PRIVATE_STREAM_1, java.lang.String.valueOf(currentTimeMillis2));
            return b2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static boolean v() {
        boolean z;
        java.lang.String str = android.os.Build.TAGS;
        if (!(str != null && str.contains("test-keys"))) {
            java.lang.String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            int i2 = 0;
            while (true) {
                if (i2 >= 9) {
                    z = false;
                    break;
                }
                if (new java.io.File(strArr[i2]).exists()) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z && !S()) {
                return false;
            }
        }
        return true;
    }

    private static boolean v(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            return java.util.regex.Pattern.compile("^(\\*|(GMT|UTC)[+-](0[0-9]|1[0-4]):([0-5][0-9])\\|(GMT|UTC)[+-](0[0-9]|1[0-4]):([0-5][0-9]))&(\\*|[^#]+(?:#[^#]+)*)&(\\*|[^#]+(?:#[^#]+)*)&(\\*|[^#]+(?:#[^#]+)*)$").matcher(str).find();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public static java.lang.String w() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.r, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    public static java.lang.String x() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.f330s, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    public static java.lang.String y() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.P, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }

    public static java.lang.String z() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.e.b.t, (com.getui.gtc.extension.distribution.gbd.f.f) null);
    }
}
