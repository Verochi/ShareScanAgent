package com.loc;

/* loaded from: classes23.dex */
public final class gb {
    public android.util.SparseArray<java.lang.Long> a = new android.util.SparseArray<>();
    public int b = -1;
    public long c = 0;
    java.lang.String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;
    private static java.util.List<com.loc.cb> i = new java.util.ArrayList();
    private static org.json.JSONArray j = null;
    static com.amap.api.location.AMapLocation g = null;
    static boolean h = false;

    /* renamed from: com.loc.gb$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private static java.lang.String a(int i2) {
        if (i2 == 2011) {
            return "ContextIsNull";
        }
        if (i2 == 2031) {
            return "CreateApsReqException";
        }
        if (i2 == 2041) {
            return "ResponseResultIsNull";
        }
        if (i2 == 2081) {
            return "LocalLocException";
        }
        if (i2 == 2091) {
            return "InitException";
        }
        if (i2 == 2111) {
            return "ErrorCgiInfo";
        }
        if (i2 == 2121) {
            return "NotLocPermission";
        }
        if (i2 == 2141) {
            return "NoEnoughStatellites";
        }
        if (i2 == 2021) {
            return "OnlyMainWifi";
        }
        if (i2 == 2022) {
            return "OnlyOneWifiButNotMain";
        }
        if (i2 == 2061) {
            return "ServerRetypeError";
        }
        if (i2 == 2062) {
            return "ServerLocFail";
        }
        switch (i2) {
            case 2051:
                return "NeedLoginNetWork\t";
            case 2052:
                return "MaybeIntercepted";
            case 2053:
                return "DecryptResponseException";
            case 2054:
                return "ParserDataException";
            default:
                switch (i2) {
                    case com.amap.api.services.core.AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND /* 2101 */:
                        return "BindAPSServiceException";
                    case 2102:
                        return "AuthClientScodeFail";
                    case 2103:
                        return "NotConfigAPSService";
                    default:
                        switch (i2) {
                            case 2131:
                                return "NoCgiOAndWifiInfo";
                            case 2132:
                                return "AirPlaneModeAndWifiOff";
                            case 2133:
                                return "NoCgiAndWifiOff";
                            default:
                                switch (i2) {
                                    case 2151:
                                        return "MaybeMockNetLoc";
                                    case 2152:
                                        return "MaybeMockGPSLoc";
                                    case 2153:
                                        return "UNSUPPORT_COARSE_LBSLOC";
                                    case 2154:
                                        return "UNSUPPORT_CONTINUE_LOC";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public static void a(long j2, long j3) {
        try {
            if (h) {
                return;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("gpsTime:");
            stringBuffer.append(com.loc.gd.a(j2, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            stringBuffer.append("sysTime:");
            stringBuffer.append(com.loc.gd.a(j3, "yyyy-MM-dd HH:mm:ss.SSS"));
            stringBuffer.append(",");
            long u = com.loc.fu.u();
            java.lang.String a = 0 != u ? com.loc.gd.a(u, "yyyy-MM-dd HH:mm:ss.SSS") : "0";
            stringBuffer.append("serverTime:");
            stringBuffer.append(a);
            a("checkgpstime", stringBuffer.toString());
            if (0 != u && java.lang.Math.abs(j2 - u) < 31536000000L) {
                stringBuffer.append(", correctError");
                a("checkgpstimeerror", stringBuffer.toString());
            }
            stringBuffer.delete(0, stringBuffer.length());
            h = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.loc.gb.class) {
            if (context != null) {
                try {
                    if (com.loc.fu.a()) {
                        java.util.List<com.loc.cb> list = i;
                        if (list != null && list.size() > 0) {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            arrayList.addAll(i);
                            com.loc.cc.b(arrayList, context);
                            i.clear();
                        }
                        f(context);
                    }
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "ReportUtil", "destroy");
                }
            }
        }
    }

    public static void a(android.content.Context context, int i2, int i3, long j2, long j3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        try {
            a(context, "O012", i2, i3, j2, j3);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "reportServiceAliveTime");
        }
    }

    public static void a(android.content.Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (com.loc.fu.a()) {
                    a(context, j2, z, "O015");
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    private static void a(android.content.Context context, long j2, boolean z, java.lang.String str) {
        a(context, str, !z ? "abroad" : "domestic", java.lang.Long.valueOf(j2).intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034 A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:4:0x0003, B:9:0x000b, B:21:0x0034, B:31:0x0047, B:33:0x004b, B:34:0x0052, B:36:0x008b, B:38:0x0098, B:39:0x00d9, B:41:0x00eb, B:43:0x0091), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(android.content.Context context, com.amap.api.location.AMapLocation aMapLocation) {
        int i2;
        synchronized (com.loc.gb.class) {
            try {
                if (com.loc.gd.a(aMapLocation)) {
                    int locationType = aMapLocation.getLocationType();
                    boolean z = false;
                    if (locationType == 1) {
                        i2 = 0;
                    } else if (locationType == 2 || locationType == 4) {
                        i2 = 1;
                    } else if (locationType == 11) {
                        i2 = 4;
                    } else if (locationType == 8) {
                        i2 = 3;
                    } else {
                        if (locationType != 9) {
                            i2 = 0;
                            if (z) {
                                int c = com.loc.fu.c();
                                if (c != 0) {
                                    if (i2 == 0 || i2 == 4) {
                                        if (c == 2) {
                                            return;
                                        }
                                    } else if (c == 1) {
                                        return;
                                    }
                                }
                                if (j == null) {
                                    j = new org.json.JSONArray();
                                }
                                org.json.JSONObject jSONObject = new org.json.JSONObject();
                                jSONObject.put(com.anythink.core.common.h.c.C, com.loc.gd.b(aMapLocation.getLongitude()));
                                jSONObject.put("lat", com.loc.gd.b(aMapLocation.getLatitude()));
                                jSONObject.put("type", i2);
                                jSONObject.put("timestamp", com.loc.gd.a());
                                if (aMapLocation.getCoordType().equalsIgnoreCase("WGS84")) {
                                    jSONObject.put("coordType", 1);
                                } else {
                                    jSONObject.put("coordType", 2);
                                }
                                if (i2 == 0) {
                                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                    jSONObject2.put("accuracy", com.loc.gd.c(aMapLocation.getAccuracy()));
                                    jSONObject2.put("altitude", com.loc.gd.c(aMapLocation.getAltitude()));
                                    jSONObject2.put("bearing", com.loc.gd.c(aMapLocation.getBearing()));
                                    jSONObject2.put("speed", com.loc.gd.c(aMapLocation.getSpeed()));
                                    jSONObject.put("extension", jSONObject2);
                                }
                                org.json.JSONArray put = j.put(jSONObject);
                                j = put;
                                if (put.length() >= com.loc.fu.b()) {
                                    f(context);
                                }
                            }
                        }
                        i2 = 2;
                    }
                    z = true;
                    if (z) {
                    }
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "recordOfflineLocLog");
            }
        }
    }

    public static void a(android.content.Context context, com.amap.api.location.AMapLocation aMapLocation, com.loc.es esVar) {
        int i2;
        if (aMapLocation == null) {
            return;
        }
        try {
            if (!com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                java.lang.String str = a(aMapLocation) ? "abroad" : "domestic";
                java.lang.String str2 = "cache";
                if (aMapLocation.getErrorCode() != 0) {
                    int errorCode = aMapLocation.getErrorCode();
                    if (errorCode == 4 || errorCode == 5 || errorCode == 6 || errorCode == 11) {
                        str2 = com.alipay.sdk.m.k.b.k;
                    }
                    i2 = 0;
                } else {
                    int locationType = aMapLocation.getLocationType();
                    if (locationType == 5 || locationType == 6) {
                        str2 = com.alipay.sdk.m.k.b.k;
                    }
                    i2 = 1;
                }
                a(context, "O016", str2, str, i2, aMapLocation.getErrorCode(), esVar);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "reportBatting");
        }
    }

    private static void a(android.content.Context context, java.lang.String str, int i2, int i3, long j2, long j3) {
        if (context != null) {
            try {
                if (com.loc.fu.a()) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j2);
                    jSONObject.put("param_long_second", j3);
                    a(context, str, jSONObject);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i2) {
        if (context != null) {
            try {
                if (com.loc.fu.a()) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!android.text.TextUtils.isEmpty(null)) {
                        jSONObject.put("param_string_second", (java.lang.Object) null);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i2, int i3, com.loc.es esVar) {
        if (context != null) {
            try {
                if (com.loc.fu.a()) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    if (esVar != null) {
                        if (!android.text.TextUtils.isEmpty(esVar.d())) {
                            jSONObject.put("dns", esVar.d());
                        }
                        if (!android.text.TextUtils.isEmpty(esVar.e())) {
                            jSONObject.put("domain", esVar.e());
                        }
                        if (!android.text.TextUtils.isEmpty(esVar.f())) {
                            jSONObject.put("type", esVar.f());
                        }
                        if (!android.text.TextUtils.isEmpty(esVar.g())) {
                            jSONObject.put("reason", esVar.g());
                        }
                        if (!android.text.TextUtils.isEmpty(esVar.c())) {
                            jSONObject.put("ip", esVar.c());
                        }
                        if (!android.text.TextUtils.isEmpty(esVar.b())) {
                            jSONObject.put("stack", esVar.b());
                        }
                        if (esVar.h() > 0) {
                            jSONObject.put("ctime", java.lang.String.valueOf(esVar.h()));
                        }
                        if (esVar.a() > 0) {
                            jSONObject.put("ntime", java.lang.String.valueOf(esVar.a()));
                        }
                    }
                    a(context, str, jSONObject);
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject) {
        synchronized (com.loc.gb.class) {
            if (context != null) {
                try {
                    if (com.loc.fu.a()) {
                        com.loc.cb cbVar = new com.loc.cb(context, "loc", "6.4.5", str);
                        if (jSONObject != null) {
                            cbVar.a(jSONObject.toString());
                        }
                        i.add(cbVar);
                        if (i.size() >= 30) {
                            java.util.ArrayList arrayList = new java.util.ArrayList();
                            arrayList.addAll(i);
                            com.loc.cc.b(arrayList, context);
                            i.clear();
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
    }

    public static void a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!com.loc.gd.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.m13clone();
            }
            if (com.loc.gd.a(g) && com.loc.gd.a(aMapLocation2)) {
                com.amap.api.location.AMapLocation m13clone = aMapLocation2.m13clone();
                if (g.getLocationType() != 1 && g.getLocationType() != 9 && !com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(g.getProvider()) && g.getLocationType() != 7 && m13clone.getLocationType() != 1 && m13clone.getLocationType() != 9 && !com.amap.api.services.geocoder.GeocodeSearch.GPS.equalsIgnoreCase(m13clone.getProvider()) && m13clone.getLocationType() != 7) {
                    long abs = java.lang.Math.abs(m13clone.getTime() - g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= com.anythink.expressad.d.a.b.aC) {
                        float a = com.loc.gd.a(g, m13clone);
                        float f = a / abs;
                        if (a > 30000.0f && f > 1000.0f) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(com.loc.gd.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(m13clone.getLatitude());
                            sb.append(",");
                            sb.append(m13clone.getLongitude());
                            sb.append(",");
                            sb.append(m13clone.getAccuracy());
                            sb.append(",");
                            sb.append(m13clone.getLocationType());
                            sb.append(",");
                            if (m13clone.getTime() != 0) {
                                sb.append(com.loc.gd.a(m13clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(m13clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = m13clone;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, int i2) {
        a(str, java.lang.String.valueOf(i2), a(i2));
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            com.loc.aw.b(com.loc.fv.c(), str2, str);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "reportLog");
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            com.loc.aw.a(com.loc.fv.c(), "/mobile/binary", str3, str, str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.Throwable th) {
        try {
            if (th instanceof com.loc.l) {
                com.loc.aw.a(com.loc.fv.c(), str, (com.loc.l) th);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(com.amap.api.location.AMapLocation aMapLocation) {
        return com.loc.gd.a(aMapLocation) ? !com.loc.fv.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(com.loc.fv.c);
    }

    public static void b(android.content.Context context, long j2, boolean z) {
        if (context != null) {
            try {
                if (com.loc.fu.a()) {
                    a(context, j2, z, "O024");
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "ReportUtil", "reportCoarseLocUseTime");
            }
        }
    }

    private static void f(android.content.Context context) {
        try {
            org.json.JSONArray jSONArray = j;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            com.loc.ca.a(new com.loc.bz(context, com.loc.fv.c(), j.toString()), context);
            j = null;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void a(android.content.Context context, int i2) {
        try {
            int i3 = this.b;
            if (i3 == i2) {
                return;
            }
            if (i3 != -1 && i3 != i2) {
                this.a.append(this.b, java.lang.Long.valueOf((com.loc.gd.b() - this.c) + this.a.get(this.b, 0L).longValue()));
            }
            this.c = com.loc.gd.b() - com.loc.gc.a(context, "pref1", this.d[i2], 0L);
            this.b = i2;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(android.content.Context context, com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        int i2;
        try {
            int i3 = com.loc.gb.AnonymousClass1.a[aMapLocationClientOption.getLocationMode().ordinal()];
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 != 2) {
                i2 = 3;
                if (i3 != 3) {
                    i2 = -1;
                }
            } else {
                i2 = 5;
            }
            int i4 = this.e;
            if (i4 == i2) {
                return;
            }
            if (i4 != -1 && i4 != i2) {
                this.a.append(this.e, java.lang.Long.valueOf((com.loc.gd.b() - this.f) + this.a.get(this.e, 0L).longValue()));
            }
            this.f = com.loc.gd.b() - com.loc.gc.a(context, "pref1", this.d[i2], 0L);
            this.e = i2;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void b(android.content.Context context) {
        try {
            long b = com.loc.gd.b() - this.c;
            int i2 = this.b;
            if (i2 != -1) {
                this.a.append(this.b, java.lang.Long.valueOf(b + this.a.get(i2, 0L).longValue()));
            }
            long b2 = com.loc.gd.b() - this.f;
            int i3 = this.e;
            if (i3 != -1) {
                this.a.append(this.e, java.lang.Long.valueOf(b2 + this.a.get(i3, 0L).longValue()));
            }
            android.content.SharedPreferences.Editor a = com.loc.gc.a(context, "pref1");
            for (int i4 = 0; i4 < this.d.length; i4++) {
                long longValue = this.a.get(i4, 0L).longValue();
                if (longValue > 0 && longValue > com.loc.gc.a(context, "pref1", this.d[i4], 0L)) {
                    com.loc.gc.a(a, this.d[i4], longValue);
                }
            }
            com.loc.gc.a(a);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int c(android.content.Context context) {
        try {
            long a = com.loc.gc.a(context, "pref1", this.d[2], 0L);
            long a2 = com.loc.gc.a(context, "pref1", this.d[0], 0L);
            long a3 = com.loc.gc.a(context, "pref1", this.d[1], 0L);
            if (a == 0 && a2 == 0 && a3 == 0) {
                return -1;
            }
            long j2 = a2 - a;
            long j3 = a3 - a;
            return a > j2 ? a > j3 ? 2 : 1 : j2 > j3 ? 0 : 1;
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public final int d(android.content.Context context) {
        try {
            long a = com.loc.gc.a(context, "pref1", this.d[3], 0L);
            long a2 = com.loc.gc.a(context, "pref1", this.d[4], 0L);
            long a3 = com.loc.gc.a(context, "pref1", this.d[5], 0L);
            if (a == 0 && a2 == 0 && a3 == 0) {
                return -1;
            }
            return a > a2 ? a > a3 ? 3 : 5 : a2 > a3 ? 4 : 5;
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public final void e(android.content.Context context) {
        try {
            android.content.SharedPreferences.Editor a = com.loc.gc.a(context, "pref1");
            int i2 = 0;
            while (true) {
                java.lang.String[] strArr = this.d;
                if (i2 >= strArr.length) {
                    com.loc.gc.a(a);
                    return;
                } else {
                    com.loc.gc.a(a, strArr[i2], 0L);
                    i2++;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
