package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jg {
    android.content.Context a;
    private com.amap.api.mapcore.util.in e;
    private com.amap.api.mapcore.util.jw f;
    private com.amap.api.mapcore.util.ip h;
    private android.net.ConnectivityManager i;
    private com.amap.api.mapcore.util.ir j;
    private com.autonavi.amap.mapcore.Inner_3dMap_locationOption l;
    private com.amap.api.mapcore.util.jg.a g = null;
    boolean b = false;
    private java.lang.StringBuilder k = new java.lang.StringBuilder();
    java.lang.String c = null;
    private com.amap.api.mapcore.util.je m = null;
    long d = 0;
    private final java.lang.String n = "\"status\":\"0\"";
    private final java.lang.String o = "</body></html>";

    public class a extends android.content.BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(com.amap.api.mapcore.util.jg jgVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (context == null || intent == null) {
                return;
            }
            try {
                java.lang.String action = intent.getAction();
                if (android.text.TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (com.amap.api.mapcore.util.jg.this.e != null) {
                        com.amap.api.mapcore.util.jg.this.e.c();
                    }
                } else {
                    if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || com.amap.api.mapcore.util.jg.this.e == null) {
                        return;
                    }
                    com.amap.api.mapcore.util.jg.this.e.d();
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "MapNetLocation", "onReceive");
            }
        }
    }

    public jg(android.content.Context context) {
        this.a = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            com.amap.api.mapcore.util.ix.b(applicationContext);
            a(this.a);
            this.l = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
            if (this.e == null) {
                com.amap.api.mapcore.util.in inVar = new com.amap.api.mapcore.util.in(this.a, (android.net.wifi.WifiManager) com.amap.api.mapcore.util.ix.a(this.a, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI));
                this.e = inVar;
                inVar.a(this.b);
            }
            if (this.f == null) {
                this.f = new com.amap.api.mapcore.util.jw(this.a);
            }
            if (this.h == null) {
                com.amap.api.mapcore.util.ew.a(this.a);
                this.h = com.amap.api.mapcore.util.ip.a(this.a);
            }
            if (this.i == null) {
                this.i = (android.net.ConnectivityManager) com.amap.api.mapcore.util.ix.a(this.a, "connectivity");
            }
            this.j = new com.amap.api.mapcore.util.ir();
            c();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapNetLocation", "<init>");
        }
    }

    private static com.amap.api.mapcore.util.je a(com.amap.api.mapcore.util.je jeVar) {
        return com.amap.api.mapcore.util.ja.a().a(jeVar);
    }

    private void a(android.content.Context context) {
        try {
            if (context.checkCallingOrSelfPermission(com.amap.api.mapcore.util.fi.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.b = true;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean a(long j) {
        if (com.amap.api.mapcore.util.ix.b() - j < 800) {
            if ((com.amap.api.mapcore.util.ji.a(this.m) ? com.amap.api.mapcore.util.ix.a() - this.m.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        try {
            if (this.g == null) {
                this.g = new com.amap.api.mapcore.util.jg.a(this, (byte) 0);
            }
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.a.registerReceiver(this.g, intentFilter);
            this.e.b(false);
            this.f.b();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    private com.amap.api.mapcore.util.je d() throws java.lang.Exception {
        byte[] bArr;
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        com.amap.api.mapcore.util.je jeVar = new com.amap.api.mapcore.util.je("");
        com.amap.api.mapcore.util.in inVar = this.e;
        if (inVar != null && inVar.g()) {
            jeVar.setErrorCode(15);
            return jeVar;
        }
        try {
            if (this.j == null) {
                this.j = new com.amap.api.mapcore.util.ir();
            }
            this.j.a(this.a, this.l.isNeedAddress(), this.l.isOffset(), this.f, this.e, this.i, this.c);
            com.amap.api.mapcore.util.jh jhVar = new com.amap.api.mapcore.util.jh();
            try {
                try {
                    com.amap.api.mapcore.util.hj a2 = this.h.a(this.h.a(this.a, this.j.a(), com.amap.api.mapcore.util.it.a(), com.amap.api.mapcore.util.it.b()));
                    if (a2 != null) {
                        bArr = a2.a;
                        str = a2.c;
                    } else {
                        bArr = null;
                        str = "";
                    }
                    if (bArr == null || bArr.length == 0) {
                        jeVar.setErrorCode(4);
                        this.k.append("please check the network");
                        if (!android.text.TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(java.lang.String.valueOf(str)));
                        }
                        jeVar.setLocationDetail(this.k.toString());
                        return jeVar;
                    }
                    java.lang.String str3 = new java.lang.String(bArr, "UTF-8");
                    if (str3.contains("\"status\":\"0\"")) {
                        return jhVar.a(str3, this.a, a2);
                    }
                    if (str3.contains("</body></html>")) {
                        jeVar.setErrorCode(5);
                        com.amap.api.mapcore.util.in inVar2 = this.e;
                        if (inVar2 == null || !inVar2.a(this.i)) {
                            sb = this.k;
                            str2 = "request may be intercepted";
                        } else {
                            sb = this.k;
                            str2 = "make sure you are logged in to the network";
                        }
                        sb.append(str2);
                        if (!android.text.TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(java.lang.String.valueOf(str)));
                        }
                        jeVar.setLocationDetail(this.k.toString());
                        return jeVar;
                    }
                    byte[] a3 = com.amap.api.mapcore.util.io.a(bArr);
                    if (a3 == null) {
                        jeVar.setErrorCode(5);
                        this.k.append("decrypt response data error");
                        if (!android.text.TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(java.lang.String.valueOf(str)));
                        }
                        jeVar.setLocationDetail(this.k.toString());
                        return jeVar;
                    }
                    com.amap.api.mapcore.util.je a4 = jhVar.a(a3);
                    this.c = a4.a();
                    if (a4.getErrorCode() != 0) {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            a4.setLocationDetail(a4.getLocationDetail() + " #csid:" + str);
                        }
                        return a4;
                    }
                    if (!com.amap.api.mapcore.util.ji.a(a4)) {
                        java.lang.String b = a4.b();
                        a4.setErrorCode(6);
                        java.lang.StringBuilder sb2 = this.k;
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder("location faile retype:");
                        sb3.append(a4.d());
                        sb3.append(" rdesc:");
                        if (b == null) {
                            b = com.igexin.push.core.b.m;
                        }
                        sb3.append(b);
                        sb2.append(sb3.toString());
                        if (!android.text.TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(java.lang.String.valueOf(str)));
                        }
                        a4.setLocationDetail(this.k.toString());
                        return a4;
                    }
                    a4.e();
                    if (a4.getErrorCode() == 0 && a4.getLocationType() == 0) {
                        if ("-5".equals(a4.d()) || "1".equals(a4.d()) || "2".equals(a4.d()) || com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(a4.d()) || com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(a4.d()) || "-1".equals(a4.d())) {
                            a4.setLocationType(5);
                        } else {
                            a4.setLocationType(6);
                        }
                        this.k.append(a4.d());
                        if (!android.text.TextUtils.isEmpty(str)) {
                            this.k.append(" #csid:".concat(java.lang.String.valueOf(str)));
                        }
                        a4.setLocationDetail(this.k.toString());
                    }
                    return a4;
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.it.a(th, "MapNetLocation", "getApsLoc req");
                    jeVar.setErrorCode(4);
                    this.k.append("please check the network");
                    jeVar.setLocationDetail(this.k.toString());
                    return jeVar;
                }
            } catch (java.lang.Throwable th2) {
                com.amap.api.mapcore.util.it.a(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                jeVar.setErrorCode(3);
                this.k.append("buildV4Dot2 error " + th2.getMessage());
                jeVar.setLocationDetail(this.k.toString());
                return jeVar;
            }
        } catch (java.lang.Throwable th3) {
            com.amap.api.mapcore.util.it.a(th3, "MapNetLocation", "getApsLoc");
            this.k.append("get parames error:" + th3.getMessage());
            jeVar.setErrorCode(3);
            jeVar.setLocationDetail(this.k.toString());
            return jeVar;
        }
    }

    public final com.autonavi.amap.mapcore.Inner_3dMap_location a() {
        if (this.k.length() > 0) {
            java.lang.StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
        if (a(this.d) && com.amap.api.mapcore.util.ji.a(this.m)) {
            return this.m;
        }
        this.d = com.amap.api.mapcore.util.ix.b();
        if (this.a == null) {
            this.k.append(com.anythink.expressad.foundation.g.b.b.a);
            com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location = new com.autonavi.amap.mapcore.Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.k.toString());
            return inner_3dMap_location;
        }
        try {
            this.f.b();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.e.b(true);
        } catch (java.lang.Throwable th2) {
            com.amap.api.mapcore.util.it.a(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            com.amap.api.mapcore.util.je d = d();
            this.m = d;
            this.m = a(d);
        } catch (java.lang.Throwable th3) {
            com.amap.api.mapcore.util.it.a(th3, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.m;
    }

    public final void a(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.l = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.l = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption();
        }
        try {
            com.amap.api.mapcore.util.in inVar = this.e;
            this.l.isWifiActiveScan();
            inVar.c(this.l.isWifiScan());
        } catch (java.lang.Throwable unused) {
        }
        try {
            this.h.a(this.l.getHttpTimeOut(), this.l.getLocationProtocol().equals(com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS));
        } catch (java.lang.Throwable unused2) {
        }
    }

    public final void b() {
        com.amap.api.mapcore.util.jg.a aVar;
        this.b = false;
        this.c = null;
        try {
            android.content.Context context = this.a;
            if (context != null && (aVar = this.g) != null) {
                context.unregisterReceiver(aVar);
            }
            com.amap.api.mapcore.util.jw jwVar = this.f;
            if (jwVar != null) {
                jwVar.h();
            }
            com.amap.api.mapcore.util.in inVar = this.e;
            if (inVar != null) {
                inVar.h();
            }
            this.g = null;
        } catch (java.lang.Throwable unused) {
            this.g = null;
        }
    }
}
