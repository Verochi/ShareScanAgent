package com.getui.gtc.dim.c;

/* loaded from: classes22.dex */
public final class b {
    private static final java.util.Map<java.lang.String, java.lang.String> a = new com.getui.gtc.dim.c.b.AnonymousClass1();

    /* renamed from: com.getui.gtc.dim.c.b$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.E);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.G, com.getui.gtc.extension.distribution.gbd.f.e.b.H);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.C, com.getui.gtc.extension.distribution.gbd.f.e.b.A);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.D, com.getui.gtc.extension.distribution.gbd.f.e.b.B);
            put(com.getui.gtc.extension.distribution.gbd.f.e.b.l, com.getui.gtc.extension.distribution.gbd.f.e.b.k);
        }
    }

    public static java.lang.Object a(com.getui.gtc.dim.DimRequest dimRequest) {
        return !"HONOR".equals(com.getui.gtc.dim.c.d.d) ? "" : b(dimRequest);
    }

    public static java.lang.String a(android.content.Context context, com.getui.gtc.dim.DimRequest dimRequest) {
        try {
            com.getui.gtc.dim.bean.GtWifiInfo parseJson = com.getui.gtc.dim.bean.GtWifiInfo.parseJson((java.lang.String) b(dimRequest));
            return com.getui.gtc.dim.c.a.b(context, parseJson != null ? parseJson.getSSID() : "");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static java.lang.String a(com.getui.gtc.dim.DimRequest dimRequest, int i) {
        java.lang.String str = null;
        try {
            com.getui.gtc.dim.e.b.a("get " + dimRequest.getKey() + " policy:" + i);
            android.net.wifi.WifiInfo wifiInfo = (android.net.wifi.WifiInfo) b(dimRequest);
            if (wifiInfo != null) {
                if (i == 0) {
                    return new com.getui.gtc.dim.bean.GtWifiInfo(wifiInfo).toJsonString();
                }
                if (i == 1) {
                    return com.getui.gtc.dim.c.e.a(wifiInfo);
                }
                try {
                    str = com.getui.gtc.dim.c.e.a(wifiInfo);
                    if (android.text.TextUtils.isEmpty(str)) {
                        return new com.getui.gtc.dim.bean.GtWifiInfo(wifiInfo).toJsonString();
                    }
                } catch (java.lang.Throwable th) {
                    if (android.text.TextUtils.isEmpty(null)) {
                        new com.getui.gtc.dim.bean.GtWifiInfo(wifiInfo).toJsonString();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.dim.e.b.b(th2);
        }
        return str;
    }

    private static java.lang.Object b(com.getui.gtc.dim.DimRequest dimRequest) {
        com.getui.gtc.dim.a aVar;
        java.lang.String str = a.get(dimRequest.getKey());
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.getui.gtc.dim.DimRequest build = new com.getui.gtc.dim.DimRequest.Builder(dimRequest).key(str).build();
        aVar = com.getui.gtc.dim.a.C0298a.a;
        return aVar.a(build, false);
    }

    /* JADX WARN: Finally extract failed */
    public static java.lang.String b(com.getui.gtc.dim.DimRequest dimRequest, int i) {
        java.lang.String str = null;
        try {
            com.getui.gtc.dim.e.b.a("get " + dimRequest.getKey() + " policy:" + i);
            android.location.Location location = (android.location.Location) b(dimRequest);
            if (location != null) {
                if (i == 0) {
                    return new com.getui.gtc.dim.bean.GtLocation(location).toJsonString();
                }
                if (i == 1) {
                    return com.getui.gtc.dim.c.c.a(location);
                }
                try {
                    str = com.getui.gtc.dim.c.c.a(location);
                    if (android.text.TextUtils.isEmpty(str)) {
                        return new com.getui.gtc.dim.bean.GtLocation(location).toJsonString();
                    }
                } catch (java.lang.Throwable th) {
                    if (android.text.TextUtils.isEmpty(null)) {
                        new com.getui.gtc.dim.bean.GtLocation(location).toJsonString();
                    }
                    throw th;
                }
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.dim.e.b.b(th2);
        }
        return str;
    }
}
