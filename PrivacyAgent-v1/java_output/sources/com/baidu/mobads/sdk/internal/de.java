package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class de extends com.baidu.mobads.sdk.internal.bi {
    private int A;
    private com.baidu.mobads.sdk.api.RequestParameters B;
    private boolean C;
    private com.baidu.mobads.sdk.internal.g.a D;
    private com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener E;
    private com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener F;
    private com.baidu.mobads.sdk.internal.g.b G;
    private int H;
    private int I;
    private int J;
    private java.util.List<com.baidu.mobads.sdk.api.NativeResponse> a;
    private java.util.List<com.baidu.mobads.sdk.api.ExpressResponse> t;
    private java.util.List<com.baidu.mobads.sdk.api.EntryResponse> u;
    private int v;
    private boolean w;
    private java.lang.String x;
    private java.lang.String y;
    private int z;

    public de(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, int i) {
        super(context);
        this.C = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.y = str;
        this.x = str2;
        this.w = z;
        this.v = i;
        this.z = 600;
        this.A = 500;
    }

    public android.view.ViewGroup a(com.baidu.mobads.sdk.internal.a aVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.I());
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        a(jSONObject, hashMap);
        java.lang.Object obj = hashMap.get("container");
        if (obj instanceof android.view.ViewGroup) {
            return (android.view.ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener == null) {
            this.n = false;
        } else {
            this.n = true;
            iAdInterListener.loadAd(j(), k());
        }
    }

    public void a(int i) {
        this.H = i;
    }

    public void a(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(int i, java.lang.String str, java.lang.String str2) {
        if (this.D != null) {
            com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = new com.baidu.mobads.sdk.api.XAdNativeResponse(this.i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.a(i, str, xAdNativeResponse);
        }
        if (this.E != null) {
            com.baidu.mobads.sdk.internal.bq bqVar = new com.baidu.mobads.sdk.internal.bq(this.i, this, null);
            bqVar.a(str2);
            this.E.onNoAd(i, str, bqVar);
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i, str);
        }
    }

    public void a(android.view.ViewGroup viewGroup, com.baidu.mobads.sdk.internal.a aVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.I());
            hashMap.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, java.lang.Integer.valueOf(this.I));
            hashMap.put("h", java.lang.Integer.valueOf(this.J));
            hashMap.put("container", viewGroup);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    public void a(com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener) {
        this.F = entryAdListener;
    }

    public void a(com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.E = expressAdListener;
    }

    public void a(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.z = width;
            this.A = height;
        }
        this.B = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    public void a(com.baidu.mobads.sdk.internal.g.a aVar) {
        this.D = aVar;
    }

    public void a(com.baidu.mobads.sdk.internal.g.b bVar) {
        this.G = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        if (this.D != null) {
            com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = new com.baidu.mobads.sdk.api.XAdNativeResponse(this.i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.b(i, str, xAdNativeResponse);
        }
        if (this.E != null) {
            com.baidu.mobads.sdk.internal.bq bqVar = new com.baidu.mobads.sdk.internal.bq(this.i, this, null);
            bqVar.a(str2);
            this.E.onNativeFail(i, str, bqVar);
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, boolean z) {
        if (!android.text.TextUtils.isEmpty(str) && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i2);
            if (android.text.TextUtils.equals(str, bqVar.a())) {
                bqVar.a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap(map);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
        int i = 0;
        for (java.lang.String str : com.baidu.mobads.sdk.api.ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                java.lang.String str2 = (java.lang.String) hashMap.remove(str);
                if (!android.text.TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                    hashMap2.put(str, str2);
                    i = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (java.lang.String str3 : hashMap.keySet()) {
                if (!android.text.TextUtils.isEmpty(str3)) {
                    java.lang.String str4 = (java.lang.String) hashMap.get(str3);
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        int length2 = i + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.o = hashMap2;
    }

    public boolean a(android.view.View view, com.baidu.mobads.sdk.internal.a aVar, int i) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put(com.anythink.expressad.a.B, view);
            hashMap.put("code", java.lang.Integer.valueOf(i));
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        a(jSONObject, hashMap);
        java.lang.Object obj = hashMap.get("result");
        if (obj instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b() {
        com.baidu.mobads.sdk.internal.g.a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void b(android.app.Activity activity) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put("activity", activity);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (this.G == null || iOAdEvent == null || this.a == null) {
            return;
        }
        java.lang.String message = iOAdEvent.getMessage();
        for (int i = 0; i < this.a.size(); i++) {
            com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.G.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void b(java.lang.String str, boolean z) {
        if (!android.text.TextUtils.isEmpty(str) && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i2);
            if (android.text.TextUtils.equals(str, bqVar.a())) {
                bqVar.b(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c() {
        com.baidu.mobads.sdk.internal.g.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void c(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) data.get("uniqueId");
        java.lang.String str2 = (java.lang.String) data.get("type");
        int i = 0;
        if (this.E != null && this.t != null) {
            while (i < this.t.size()) {
                com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
                if (android.text.TextUtils.equals(bqVar.a(), str)) {
                    if (android.text.TextUtils.equals("show", str2)) {
                        bqVar.d();
                    } else if (android.text.TextUtils.equals(com.anythink.expressad.foundation.d.c.ca, str2)) {
                        java.lang.Object obj = data.get("reason");
                        bqVar.b(obj instanceof java.lang.String ? (java.lang.String) obj : "");
                    } else if (android.text.TextUtils.equals("close", str2)) {
                        bqVar.e();
                    }
                }
                i++;
            }
            return;
        }
        if (this.a != null) {
            while (i < this.a.size()) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (android.text.TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    if (android.text.TextUtils.equals("show", str2)) {
                        xAdNativeResponse.onDislikeShow();
                    } else if (android.text.TextUtils.equals(com.anythink.expressad.foundation.d.c.ca, str2)) {
                        java.lang.Object obj2 = data.get("reason");
                        xAdNativeResponse.onDislikeClick(obj2 instanceof java.lang.String ? (java.lang.String) obj2 : "");
                    } else if (android.text.TextUtils.equals("close", str2)) {
                        xAdNativeResponse.onDislikeClose();
                    }
                }
                i++;
            }
        }
    }

    public void c(java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            java.util.HashMap<java.lang.String, java.lang.String> a = com.baidu.mobads.sdk.internal.m.a(map);
            if (this.o == null) {
                this.o = new java.util.HashMap<>();
            }
            if (a.isEmpty()) {
                return;
            }
            for (java.lang.String str : a.keySet()) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String str2 = a.get(str);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        this.o.put(str, str2);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void c(boolean z) {
        this.C = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d() {
        com.baidu.mobads.sdk.internal.g.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void d(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str) && this.t != null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i2);
                if (android.text.TextUtils.equals(str, bqVar.a())) {
                    bqVar.f();
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str) || this.u == null) {
            return;
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            com.baidu.mobads.sdk.api.XAdEntryResponse xAdEntryResponse = (com.baidu.mobads.sdk.api.XAdEntryResponse) this.u.get(i3);
            if (android.text.TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public java.lang.String e() {
        return this.x;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.lang.String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.D != null && !android.text.TextUtils.isEmpty(message) && this.a != null) {
            while (i < this.a.size()) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.a(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.E != null && !android.text.TextUtils.isEmpty(message) && this.t != null) {
            while (i < this.t.size()) {
                com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
                if (android.text.TextUtils.equals(message, bqVar.a())) {
                    bqVar.c();
                }
                i++;
            }
            return;
        }
        if (this.F == null || android.text.TextUtils.isEmpty(message) || this.u == null) {
            return;
        }
        while (i < this.u.size()) {
            com.baidu.mobads.sdk.api.XAdEntryResponse xAdEntryResponse = (com.baidu.mobads.sdk.api.XAdEntryResponse) this.u.get(i);
            if (android.text.TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i2);
            if (android.text.TextUtils.equals(str, bqVar.a())) {
                bqVar.g();
            }
        }
    }

    public com.baidu.mobads.sdk.api.RequestParameters f() {
        return this.B;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> data = iOAdEvent.getData();
        int i = 0;
        if (this.D != null && data != null && this.a != null) {
            java.lang.String str = (java.lang.String) data.get("instanceInfo");
            while (i < this.a.size()) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.D.a(xAdNativeResponse, java.lang.Integer.parseInt((java.lang.String) data.get("showState")));
                }
                i++;
            }
            return;
        }
        if (this.F == null || data == null || this.u == null) {
            return;
        }
        java.lang.String str2 = (java.lang.String) data.get("instanceInfo");
        while (i < this.u.size()) {
            com.baidu.mobads.sdk.api.XAdEntryResponse xAdEntryResponse = (com.baidu.mobads.sdk.api.XAdEntryResponse) this.u.get(i);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(java.lang.Integer.parseInt((java.lang.String) data.get("showState")));
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void f(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i2);
            if (android.text.TextUtils.equals(str, bqVar.a())) {
                bqVar.h();
            }
        }
    }

    public java.lang.String g() {
        return this.y;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void g(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) data.get("uniqueId");
        int i = 0;
        if (this.E != null && this.t != null) {
            while (i < this.t.size()) {
                com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
                if (android.text.TextUtils.equals(bqVar.a(), str)) {
                    bqVar.a(bqVar);
                }
                i++;
            }
            return;
        }
        if (this.a != null) {
            while (i < this.a.size()) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (android.text.TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    xAdNativeResponse.onAdClose(xAdNativeResponse);
                }
                i++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.lang.String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.D != null && !android.text.TextUtils.isEmpty(message) && this.a != null) {
            while (i < this.a.size()) {
                com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.b(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.E != null && !android.text.TextUtils.isEmpty(message) && this.t != null) {
            while (i < this.t.size()) {
                com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
                if (android.text.TextUtils.equals(message, bqVar.a())) {
                    bqVar.b();
                }
                i++;
            }
            return;
        }
        if (this.F == null || android.text.TextUtils.isEmpty(message) || this.u == null) {
            return;
        }
        while (i < this.u.size()) {
            com.baidu.mobads.sdk.api.XAdEntryResponse xAdEntryResponse = (com.baidu.mobads.sdk.api.XAdEntryResponse) this.u.get(i);
            if (android.text.TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void i(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (this.E == null || iOAdEvent == null || this.t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) data.get("uniqueId");
        android.view.View view = (android.view.View) data.get("expressView");
        int intValue = ((java.lang.Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((java.lang.Integer) data.get("viewHeight")).intValue();
        for (int i = 0; i < this.t.size(); i++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
            if (android.text.TextUtils.equals(bqVar.a(), str)) {
                bqVar.a(view, intValue, intValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject j() {
        this.f295s = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, this.x);
            this.m.createProdHandler(jSONObject2);
            this.m.setAdContainer(this.h);
            m();
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, this.x);
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.APID, this.y);
            if (com.baidu.mobads.sdk.internal.cq.a().b()) {
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "1");
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            if ("video".equals(this.x)) {
                jSONObject.put("at", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "" + this.z);
            jSONObject.put("h", "" + this.A);
            jSONObject.put("msa", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
            jSONObject = com.baidu.mobads.sdk.internal.m.a(jSONObject, b(this.o));
            jSONObject.put("opt", this.H);
            if (this.H == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void j(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (this.E == null || iOAdEvent == null || this.t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) data.get("uniqueId");
        android.view.View view = (android.view.View) data.get("expressView");
        int intValue = ((java.lang.Integer) data.get("error_code")).intValue();
        java.lang.String str2 = (java.lang.String) data.get("error_message");
        for (int i = 0; i < this.t.size(); i++) {
            com.baidu.mobads.sdk.internal.bq bqVar = (com.baidu.mobads.sdk.internal.bq) this.t.get(i);
            if (android.text.TextUtils.equals(bqVar.a(), str)) {
                bqVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public org.json.JSONObject k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("timeout", this.v);
            jSONObject.put("isCacheVideo", this.w);
            jSONObject.put("cacheVideoOnlyWifi", this.C);
            com.baidu.mobads.sdk.api.RequestParameters requestParameters = this.B;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void k(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (iOAdEvent == null || this.a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        java.lang.String str = (java.lang.String) data.get("uniqueId");
        java.lang.String str2 = (java.lang.String) data.get("type");
        for (int i = 0; i < this.a.size(); i++) {
            com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = (com.baidu.mobads.sdk.api.XAdNativeResponse) this.a.get(i);
            if (android.text.TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (android.text.TextUtils.equals("dismiss", str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (android.text.TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.bu.a(r16.i, r9) != false) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    @Override // com.baidu.mobads.sdk.internal.bi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q() {
        int i;
        int i2;
        boolean z;
        if (this.D == null && this.E == null && this.F == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        com.baidu.mobads.sdk.internal.b a = com.baidu.mobads.sdk.internal.b.a(this.p);
        java.util.HashSet hashSet = new java.util.HashSet();
        int i3 = 0;
        int i4 = 0;
        while (i4 < a.a().size()) {
            com.baidu.mobads.sdk.internal.a aVar = a.a().get(i4);
            java.lang.String m = aVar.m();
            if (aVar.p() != 1) {
                i = 3;
                if (aVar.p() != 2) {
                    if (aVar.p() == 512) {
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(aVar.q());
                            i2 = jSONObject.optInt("fb_act", i3);
                            try {
                                z = com.baidu.mobads.sdk.internal.bu.b(this.i, jSONObject.optString("page", ""));
                            } catch (java.lang.Throwable unused) {
                                z = false;
                                if (!z) {
                                }
                                i3 = 0;
                                if (i3 == 0) {
                                }
                                i4++;
                                i3 = 0;
                            }
                        } catch (java.lang.Throwable unused2) {
                            i2 = 0;
                        }
                        if (!z) {
                            if (i2 != 1 && i2 == 2) {
                                if (android.text.TextUtils.isEmpty(m) || !com.baidu.mobads.sdk.internal.bu.a(this.i, m)) {
                                    i3 = 0;
                                    i = 2;
                                }
                            }
                        }
                        i3 = 0;
                    }
                    i3 = 0;
                } else if (m == null || m.equals("") || m.equals(com.igexin.push.core.b.m) || hashSet.contains(m)) {
                    i3 = 1;
                } else {
                    hashSet.add(m);
                }
                if (i3 == 0) {
                    if (this.D != null) {
                        com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse = new com.baidu.mobads.sdk.api.XAdNativeResponse(this.i, this, aVar);
                        xAdNativeResponse.setIsDownloadApp(i == 2);
                        xAdNativeResponse.setAdActionType(i);
                        arrayList.add(xAdNativeResponse);
                    } else if (this.E != null) {
                        com.baidu.mobads.sdk.internal.bq bqVar = new com.baidu.mobads.sdk.internal.bq(this.i, this, aVar);
                        bqVar.a(i);
                        arrayList2.add(bqVar);
                    } else if (this.F != null) {
                        arrayList3.add(new com.baidu.mobads.sdk.api.XAdEntryResponse(this.i, this, aVar));
                    }
                }
                i4++;
                i3 = 0;
            }
            i = 1;
            if (i3 == 0) {
            }
            i4++;
            i3 = 0;
        }
        com.baidu.mobads.sdk.internal.g.a aVar2 = this.D;
        if (aVar2 != null) {
            this.a = arrayList;
            aVar2.a(arrayList);
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            this.t = arrayList2;
            expressAdListener.onNativeLoad(arrayList2);
            return;
        }
        com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            this.u = arrayList3;
            entryAdListener.onNativeLoad(arrayList3);
        }
    }
}
