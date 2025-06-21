package com.loc;

/* loaded from: classes23.dex */
public final class i {
    com.loc.i.a c;
    private android.content.Context d;
    private android.webkit.WebView f;
    java.lang.Object a = new java.lang.Object();
    private com.amap.api.location.AMapLocationClient e = null;
    private java.lang.String g = "AMap.Geolocation.cbk";
    com.amap.api.location.AMapLocationClientOption b = null;
    private volatile boolean h = false;

    /* renamed from: com.loc.i$1, reason: invalid class name */
    public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
        public AnonymousClass1() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
        }
    }

    /* renamed from: com.loc.i$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.webkit.WebView webView = com.loc.i.this.f;
            java.lang.String str = "javascript:" + com.loc.i.this.g + "('" + this.a + "')";
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
        }
    }

    public class a implements com.amap.api.location.AMapLocationListener {
        public a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(com.amap.api.location.AMapLocation aMapLocation) {
            if (com.loc.i.this.h) {
                com.loc.i.this.b(com.loc.i.b(aMapLocation));
            }
        }
    }

    public i(android.content.Context context, android.webkit.WebView webView) {
        this.f = null;
        this.c = null;
        this.d = context.getApplicationContext();
        this.f = webView;
        this.c = new com.loc.i.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x004c, B:20:0x0053, B:21:0x0057, B:22:0x0060, B:25:0x0066, B:27:0x006b, B:33:0x005b), top: B:17:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x004c, B:20:0x0053, B:21:0x0057, B:22:0x0060, B:25:0x0066, B:27:0x006b, B:33:0x005b), top: B:17:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:18:0x004c, B:20:0x0053, B:21:0x0057, B:22:0x0060, B:25:0x0066, B:27:0x006b, B:33:0x005b), top: B:17:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str) {
        boolean z;
        boolean z2;
        com.amap.api.location.AMapLocationClientOption aMapLocationClientOption;
        com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        org.json.JSONObject jSONObject;
        if (this.b == null) {
            this.b = new com.amap.api.location.AMapLocationClientOption();
        }
        int i = 5;
        long j = 30000;
        boolean z3 = true;
        try {
            jSONObject = new org.json.JSONObject(str);
            j = jSONObject.optLong(com.huawei.hms.push.constant.RemoteMessageConst.TO, 30000L);
            z = jSONObject.optInt("useGPS", 1) == 1;
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        try {
            try {
                z2 = jSONObject.optInt("watch", 0) == 1;
                try {
                    i = jSONObject.optInt(com.umeng.analytics.pro.bo.ba, 5);
                    java.lang.String optString = jSONObject.optString("callback", null);
                    if (android.text.TextUtils.isEmpty(optString)) {
                        optString = "AMap.Geolocation.cbk";
                    }
                    this.g = optString;
                } catch (java.lang.Throwable unused2) {
                }
            } catch (java.lang.Throwable unused3) {
                z2 = false;
                this.b.setHttpTimeOut(j);
                if (z) {
                }
                aMapLocationClientOption.setLocationMode(aMapLocationMode);
                com.amap.api.location.AMapLocationClientOption aMapLocationClientOption2 = this.b;
                if (!z2) {
                }
                aMapLocationClientOption2.setOnceLocation(z3);
                if (z2) {
                }
            }
            this.b.setHttpTimeOut(j);
            if (z) {
                aMapLocationClientOption = this.b;
                aMapLocationMode = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving;
            } else {
                aMapLocationClientOption = this.b;
                aMapLocationMode = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
            }
            aMapLocationClientOption.setLocationMode(aMapLocationMode);
            com.amap.api.location.AMapLocationClientOption aMapLocationClientOption22 = this.b;
            if (!z2) {
                z3 = false;
            }
            aMapLocationClientOption22.setOnceLocation(z3);
            if (z2) {
                return;
            }
            this.b.setInterval(i * 1000);
        } catch (java.lang.Throwable unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(com.amap.api.location.AMapLocation aMapLocation) {
        java.lang.String locationDetail;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String str = com.amap.api.maps.model.MyLocationStyle.ERROR_INFO;
        if (aMapLocation == null) {
            jSONObject.put("errorCode", -1);
            locationDetail = "unknownError";
        } else {
            if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put(com.anythink.core.common.j.R, aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
                jSONObject2.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
                return jSONObject.toString();
            }
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(com.amap.api.maps.model.MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            str = "locationDetail";
            locationDetail = aMapLocation.getLocationDetail();
        }
        jSONObject.put(str, locationDetail);
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"NewApi"})
    public void b(java.lang.String str) {
        try {
            android.webkit.WebView webView = this.f;
            if (webView != null) {
                webView.evaluateJavascript("javascript:" + this.g + "('" + str + "')", new com.loc.i.AnonymousClass1());
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void a() {
        if (this.f == null || this.d == null || this.h) {
            return;
        }
        try {
            this.f.getSettings().setJavaScriptEnabled(true);
            this.f.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!android.text.TextUtils.isEmpty(this.f.getUrl())) {
                this.f.reload();
            }
            if (this.e == null) {
                com.amap.api.location.AMapLocationClient aMapLocationClient = new com.amap.api.location.AMapLocationClient(this.d);
                this.e = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.c);
            }
            this.h = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.h = false;
            com.amap.api.location.AMapLocationClient aMapLocationClient = this.e;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.c);
                this.e.stopLocation();
                this.e.onDestroy();
                this.e = null;
            }
            this.b = null;
        }
    }

    @android.webkit.JavascriptInterface
    public final void getLocation(java.lang.String str) {
        synchronized (this.a) {
            if (this.h) {
                a(str);
                com.amap.api.location.AMapLocationClient aMapLocationClient = this.e;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.b);
                    this.e.stopLocation();
                    this.e.startLocation();
                }
            }
        }
    }

    @android.webkit.JavascriptInterface
    public final void stopLocation() {
        com.amap.api.location.AMapLocationClient aMapLocationClient;
        if (this.h && (aMapLocationClient = this.e) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
