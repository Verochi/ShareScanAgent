package com.getui.gtc.a;

/* loaded from: classes22.dex */
public final class c implements com.getui.gtc.a.b {
    private static final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    public long a;
    public long b;
    private java.lang.String c;
    private boolean d = false;
    private final java.util.concurrent.atomic.AtomicBoolean f = new java.util.concurrent.atomic.AtomicBoolean(false);

    private c() {
        this.a = 300000L;
        this.b = 5000L;
        java.util.Map<java.lang.String, java.lang.String> a = com.getui.gtc.f.c.a(null);
        if (a == null || a.size() <= 0) {
            return;
        }
        try {
            java.lang.String str = a.get("sdk.gtc.type256.interval");
            if (str != null) {
                this.a = java.lang.Long.parseLong(str) * 1000;
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.h.c.a.b(e2);
        }
        try {
            java.lang.String str2 = a.get("sdk.gtc.type256.delay");
            if (str2 != null) {
                this.b = java.lang.Long.parseLong(str2) * 1000;
            }
        } catch (java.lang.Exception e3) {
            com.getui.gtc.h.c.a.b(e3);
        }
    }

    private static java.lang.Object a(java.lang.String str) {
        return com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().skipCache(true).key(str).caller(com.getui.gtc.dim.Caller.UNKNOWN).build());
    }

    private static java.lang.String a(android.content.Context context) {
        try {
            if (!com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(context)) {
                com.getui.gtc.h.c.a.a("Iv6 network not connected.");
                return "no network|-1";
            }
            android.net.NetworkInfo b = b(context);
            boolean z = false;
            boolean z2 = b != null && b.getType() == 0;
            if (b != null && b.getType() == 1) {
                z = true;
            }
            java.lang.String str = (java.lang.String) a(com.getui.gtc.extension.distribution.gbd.f.e.b.z);
            if (str == null) {
                str = "";
            }
            if (z2) {
                com.getui.gtc.h.c.a.a("Phone Iv6 List = ".concat(str));
                return str + "|1";
            }
            if (!z) {
                return "error|-1";
            }
            com.getui.gtc.h.c.a.a("Wifi Iv6 List = ".concat(str));
            return str + "|2";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return "error|-1";
        }
    }

    private static java.lang.String a(android.net.wifi.ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        try {
            java.lang.String str = scanResult.SSID;
            if (str == null) {
                return "";
            }
            return str.replace("|", "").replace("#", "").replace(",", "") + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + (java.lang.System.currentTimeMillis() - (((android.os.SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - (scanResult.timestamp / 1000)));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
            return "";
        }
    }

    private static java.lang.String a(java.util.List<android.net.wifi.ScanResult> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(a(list.get(i)));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static void a() {
        if (e.getAndSet(true)) {
            return;
        }
        com.getui.gtc.a.c cVar = new com.getui.gtc.a.c();
        com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(cVar, cVar.b, cVar.a);
    }

    private static android.net.NetworkInfo b(android.content.Context context) {
        try {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static android.util.Pair<java.lang.String, java.lang.String> b() {
        try {
            java.lang.String str = (java.lang.String) a(com.getui.gtc.extension.distribution.gbd.f.e.b.J);
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String[] split = str.split(",");
                if (split.length > 0) {
                    java.lang.String str2 = split[split.length - 1];
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        return new android.util.Pair<>(str2.substring(0, str2.lastIndexOf(124)), str2.substring(str2.lastIndexOf(124) + 1));
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.a(th);
        }
        return new android.util.Pair<>("0|0|0|0", "0");
    }

    private void c() {
        com.getui.gtc.e.c cVar;
        org.json.JSONArray jSONArray;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        com.getui.gtc.e.c cVar4;
        try {
            cVar = com.getui.gtc.e.c.a.a;
            java.lang.String str = cVar.a.b;
            try {
                jSONArray = !android.text.TextUtils.isEmpty(str) ? new org.json.JSONArray(str) : new org.json.JSONArray();
            } catch (java.lang.Throwable unused) {
                jSONArray = new org.json.JSONArray();
            }
            if (jSONArray.length() < 100) {
                jSONArray.put(this.c);
            }
            cVar2 = com.getui.gtc.e.c.a.a;
            cVar2.a.e(jSONArray.toString());
            for (int i = 0; i < jSONArray.length(); i++) {
                com.getui.gtc.g.a.a(jSONArray.getString(i), 256);
            }
            cVar3 = com.getui.gtc.e.c.a.a;
            com.getui.gtc.e.d dVar = cVar3.a;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (dVar.a(19, currentTimeMillis)) {
                dVar.m = currentTimeMillis;
            }
            cVar4 = com.getui.gtc.e.c.a.a;
            cVar4.a.e("");
        } catch (java.lang.Exception e2) {
            com.getui.gtc.h.c.a.c("type 256 report error: " + e2.toString());
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        float f;
        com.getui.gtc.e.c cVar;
        try {
            if (!this.f.getAndSet(true)) {
                try {
                    java.lang.String str = com.getui.gtc.f.c.a(null).get("sdk.gtc.type256.enable");
                    if (str != null) {
                        this.d = java.lang.Boolean.parseBoolean(str);
                    }
                } catch (java.lang.Exception e2) {
                    com.getui.gtc.h.c.a.b(e2);
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                cVar = com.getui.gtc.e.c.a.a;
                if (currentTimeMillis - cVar.a.m < this.a) {
                    com.getui.gtc.h.c.a.c("type 256 collect time not expired");
                    return;
                }
            }
            if (!this.d) {
                com.getui.gtc.h.c.a.b("type 256 is not enabled");
                return;
            }
            if (com.getui.gtc.base.util.CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.h.c.a.b("type 256 is debug, disallow");
                return;
            }
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);
            android.location.Location location = (android.location.Location) a(com.getui.gtc.extension.distribution.gbd.f.e.b.A);
            if (location == null) {
                location = (android.location.Location) a(com.getui.gtc.extension.distribution.gbd.f.e.b.B);
            }
            if (location != null) {
                j = location.getTime();
                f = location.getAccuracy();
            } else {
                j = 0;
                f = 0.0f;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (location == null) {
                sb.append("none");
                sb.append("|");
                sb.append("0");
                sb.append("|");
                sb.append("0");
                sb.append("|");
                sb.append("0");
            } else {
                sb.append(location.getProvider());
                sb.append("|");
                sb.append(location.getLongitude());
                sb.append("|");
                sb.append(location.getLatitude());
                sb.append("|");
                sb.append(location.getAltitude());
            }
            java.lang.String sb2 = sb.toString();
            android.util.Pair<java.lang.String, java.lang.String> b = b();
            java.lang.String a = a((java.util.List<android.net.wifi.ScanResult>) a(com.getui.gtc.extension.distribution.gbd.f.e.b.F));
            java.lang.String a2 = a(com.getui.gtc.base.GtcProvider.context());
            java.lang.String str2 = (java.lang.String) a(com.getui.gtc.extension.distribution.gbd.f.e.b.G);
            if (str2 == null) {
                str2 = "";
            }
            java.lang.String str3 = simpleDateFormat.format(new java.util.Date()) + "|" + com.getui.gtc.c.b.d + "|" + com.getui.gtc.c.b.a + "|" + sb2 + "|" + ((java.lang.String) b.first) + "|" + a + "|" + j + "|" + f + "||ANDROID|" + a2 + "|" + str2 + "|" + ((java.lang.String) b.second) + "||";
            this.c = str3;
            com.getui.gtc.h.c.a.a(str3);
            c();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.a("type 256", th);
        }
    }
}
