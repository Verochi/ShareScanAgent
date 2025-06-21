package com.igexin.push.h;

/* loaded from: classes23.dex */
public class n {
    public static final java.lang.String a = "PhoneInfoUtils";
    public static final java.lang.String b = "";
    static boolean c;
    private static volatile android.content.pm.PackageInfo d;
    private static java.lang.String e;

    /* renamed from: com.igexin.push.h.n$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.api.OnDycEnableChangedListener.Stub {

        /* renamed from: com.igexin.push.h.n$1$1, reason: invalid class name and collision with other inner class name */
        public class C03741 extends com.igexin.push.g.d {
            final /* synthetic */ java.util.Map a;

            public C03741(java.util.Map map) {
                this.a = map;
            }

            @Override // com.igexin.push.g.d
            public final void b() {
                try {
                    java.util.Iterator it = this.a.keySet().iterator();
                    while (it.hasNext()) {
                        com.igexin.c.a.c.a.b(com.igexin.push.h.n.a, java.lang.String.valueOf(it.next()));
                    }
                    java.lang.Object obj = this.a.get(com.igexin.push.h.f.a.l);
                    java.lang.Boolean bool = java.lang.Boolean.TRUE;
                    if (java.util.Objects.equals(obj, bool)) {
                        if (com.igexin.push.core.e.u) {
                            com.igexin.push.core.a.b.d().i();
                        } else {
                            com.igexin.push.core.e.aM = true;
                        }
                    }
                    if (java.util.Objects.equals(this.a.get(com.igexin.push.h.f.a.O), bool)) {
                        com.igexin.push.core.c.a.a().a(false);
                    }
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }

        @Override // com.getui.gtc.api.OnDycEnableChangedListener
        public final void onDycEnableChanged(java.util.Map map) throws android.os.RemoteException {
            if (map == null || com.igexin.push.h.n.c) {
                return;
            }
            com.igexin.push.h.n.c = true;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.h.n.AnonymousClass1.C03741(map), false, true);
        }
    }

    public static int a(android.content.Context context) {
        try {
            return c(context).applicationInfo.targetSdkVersion;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0;
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            java.lang.String str3 = "";
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str3;
                }
                str3 = str3 + readLine;
            }
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }

    public static java.util.List<android.content.pm.PackageInfo> a() {
        java.util.List<android.content.pm.PackageInfo> list;
        try {
            list = (java.util.List) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.O).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            list = null;
        }
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public static android.content.pm.ApplicationInfo b(android.content.Context context) {
        try {
            return c(context).applicationInfo;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static android.util.Pair<java.lang.String, java.lang.String> b() {
        try {
            if (!com.igexin.push.config.d.X || com.igexin.push.h.d.b("3.1.12.0")) {
                com.igexin.c.a.c.a.b(a, "use wf");
                android.net.wifi.WifiInfo wifiInfo = (android.net.wifi.WifiInfo) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.F).caller(com.getui.gtc.dim.Caller.PUSH).build());
                if (wifiInfo == null) {
                    return null;
                }
                return android.util.Pair.create(wifiInfo.getSSID(), wifiInfo.getBSSID());
            }
            com.igexin.c.a.c.a.b(a, "use gt wf");
            com.getui.gtc.dim.bean.GtWifiInfo parseJson = com.getui.gtc.dim.bean.GtWifiInfo.parseJson((java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.I).caller(com.getui.gtc.dim.Caller.PUSH).build()));
            if (parseJson == null) {
                return null;
            }
            return android.util.Pair.create(parseJson.getSSID(), parseJson.getBSSID());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static android.content.pm.PackageInfo c(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        if (d != null) {
            com.igexin.c.a.c.a.b(a, "getSelfPackageInfo cache");
            return d;
        }
        synchronized (com.igexin.push.h.n.class) {
            if (d == null) {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                com.igexin.c.a.c.a.b(a, "getSelfPackageInfo");
            }
        }
        return d;
    }

    public static java.lang.String c() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.j).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String d() {
        return android.os.Build.BRAND;
    }

    public static java.lang.String e() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String f() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.f).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String g() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.b).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String h() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.q).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String i() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.r).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.util.List<android.net.wifi.ScanResult> j() {
        try {
            return (java.util.List) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.G).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static java.lang.String k() {
        try {
            return android.os.Build.SUPPORTED_ABIS[0];
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean l() {
        try {
            if (!com.igexin.push.config.d.G.contains("*")) {
                return java.util.Arrays.asList(com.igexin.push.config.d.G.toUpperCase().split(",")).contains(android.os.Build.BRAND.toUpperCase());
            }
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm all", new java.lang.Object[0]);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm " + com.igexin.push.config.d.G + " err " + e2.toString(), new java.lang.Object[0]);
            return false;
        }
    }

    public static java.lang.String m() {
        java.lang.String str;
        try {
            str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.l).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            str = null;
        }
        if (!android.text.TextUtils.isEmpty(str) && !str.equals(com.igexin.push.core.e.h)) {
            com.igexin.push.core.e.h = str;
        }
        return str;
    }

    public static java.lang.String n() {
        try {
            return c(com.igexin.push.core.e.l).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static long o() {
        try {
            return c(com.igexin.push.core.e.l).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0L;
        }
    }

    public static java.lang.String p() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.H).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a("PhoneInfoUtils|".concat(java.lang.String.valueOf(th)), new java.lang.Object[0]);
            return "";
        }
    }

    public static java.lang.String q() {
        byte[] propertyByteArray;
        try {
            if (android.os.Build.VERSION.SDK_INT < 23 || (propertyByteArray = new android.media.MediaDrm(new java.util.UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId")) == null) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : propertyByteArray) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (java.lang.Error | java.lang.Exception unused) {
            return "";
        }
    }

    public static android.location.Location r() {
        try {
            return (android.location.Location) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.B).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static android.location.Location s() {
        try {
            return (android.location.Location) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.C).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String t() {
        try {
            android.content.Context context = com.igexin.push.core.e.l;
            if (!com.getui.gtc.base.util.CommonUtil.hasPermission(context, com.anythink.china.common.d.a, false)) {
                return "";
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            switch (telephonyManager != null ? android.os.Build.VERSION.SDK_INT >= 24 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType() : 0) {
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static void u() {
        if (com.igexin.push.h.d.b("3.2.16.0")) {
            return;
        }
        com.getui.gtc.api.GtcManager.getInstance().addOnDycEnableChangedListener(com.igexin.push.core.e.l, new com.igexin.push.h.n.AnonymousClass1());
    }

    private static java.lang.String v() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.e).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    private static java.lang.String w() {
        java.lang.String str;
        if (!android.text.TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            str = android.os.Build.BRAND;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String lowerCase = str.toLowerCase();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.igexin.assist.util.AssistUtils.BRAND_HW, com.alipay.sdk.m.c.a.a);
        hashMap.put("blackshark", "ro.build.version.incremental");
        hashMap.put("redmi", "ro.build.version.incremental");
        hashMap.put(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI, "ro.build.version.incremental");
        hashMap.put("samsang", "ro.build.version.incremental");
        hashMap.put(com.igexin.assist.util.AssistUtils.BRAND_VIVO, "ro.vivo.os.version");
        hashMap.put(com.igexin.assist.util.AssistUtils.BRAND_OPPO, "ro.build.version.opporom");
        hashMap.put(com.igexin.assist.util.AssistUtils.BRAND_MZ, "ro.build.display.id");
        hashMap.put("lenovo", "ro.build.version.incremental");
        hashMap.put("smartisan", "ro.modversion");
        hashMap.put("htc", "ro.build.sense.version");
        hashMap.put("oneplus", "ro.rom.version");
        hashMap.put("yunos", "ro.cta.yunos.version");
        hashMap.put("360", "ro.build.uiversion");
        hashMap.put("nubia", "ro.build.rom.internal.id");
        if (hashMap.containsKey(lowerCase)) {
            java.lang.String a2 = a((java.lang.String) hashMap.get(lowerCase), "");
            e = a2;
            return a2;
        }
        return "";
    }

    private static boolean x() {
        return android.os.Build.VERSION.SDK_INT > 28;
    }

    private static java.lang.String y() {
        return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.u).caller(com.getui.gtc.dim.Caller.PUSH).build());
    }

    private static java.lang.String z() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.h.f.a.J).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }
}
