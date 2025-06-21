package com.anythink.expressad.mbbanner.a.a;

/* loaded from: classes12.dex */
public final class c extends com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp {
    private static final java.lang.String b = "BannerJSBridgeImpl";
    private java.lang.ref.WeakReference<android.content.Context> c;
    private java.util.List<com.anythink.expressad.foundation.d.c> d;
    private java.lang.String e;
    private java.lang.String f;
    private int g;
    private com.anythink.expressad.mbbanner.a.c.a h;
    private com.anythink.expressad.mbbanner.a.a.b i;
    private boolean j = false;

    public c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.e = str;
        this.f = str2;
        this.c = new java.lang.ref.WeakReference<>(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, org.json.JSONObject] */
    private static void a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.Object obj2;
        java.lang.String str2;
        java.lang.String str3;
        java.io.File file;
        ?? r3 = "message";
        java.lang.String str4 = "code";
        ?? jSONObject2 = new org.json.JSONObject();
        int i = 1;
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                ?? jSONArray2 = new org.json.JSONArray();
                int length = jSONArray.length();
                int i2 = 0;
                r3 = r3;
                while (i2 < length) {
                    org.json.JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    java.lang.String optString = jSONObject3.optString("ref", "");
                    int i3 = jSONObject3.getInt("type");
                    ?? jSONObject4 = new org.json.JSONObject();
                    if (i3 != i || android.text.TextUtils.isEmpty(optString)) {
                        obj2 = r3;
                        str2 = str4;
                        if (i3 == 2 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", com.anythink.expressad.videocommon.b.i.a().a(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i3 == 3 && !android.text.TextUtils.isEmpty(optString)) {
                            try {
                                file = new java.io.File(optString);
                            } catch (java.lang.Throwable th) {
                                if (com.anythink.expressad.a.a) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                str3 = "file:////".concat(java.lang.String.valueOf(optString));
                                org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put("path", str3);
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            }
                            str3 = "";
                            org.json.JSONObject jSONObject62 = new org.json.JSONObject();
                            jSONObject62.put("type", 3);
                            jSONObject62.put("path", str3);
                            jSONObject4.put(optString, jSONObject62);
                            jSONArray2.put(jSONObject4);
                        } else if (i3 == 4 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", com.anythink.expressad.foundation.h.s.a(optString) == null ? "" : com.anythink.expressad.foundation.h.s.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                        i2++;
                        r3 = obj2;
                        str4 = str2;
                        i = 1;
                    } else {
                        org.json.JSONObject jSONObject8 = new org.json.JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        com.anythink.core.common.a.j b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            jSONObject8.put("type", i);
                            obj2 = r3;
                            str2 = str4;
                            try {
                                jSONObject8.put("videoDataLength", b2.d());
                                java.lang.String b3 = b2.b();
                                if (android.text.TextUtils.isEmpty(b3)) {
                                    jSONObject8.put("path", "");
                                    jSONObject8.put("path4Web", "");
                                } else {
                                    jSONObject8.put("path", b3);
                                    jSONObject8.put("path4Web", b3);
                                }
                                if (b2.c() == 100) {
                                    jSONObject8.put("downloaded", 1);
                                } else {
                                    jSONObject8.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject4);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                r3 = obj2;
                                str = str2;
                            }
                        } else {
                            obj2 = r3;
                            str2 = str4;
                        }
                        i2++;
                        r3 = obj2;
                        str4 = str2;
                        i = 1;
                    }
                }
                obj2 = r3;
                str2 = str4;
                jSONObject2.put("resource", jSONArray2);
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            r3 = 1;
            try {
                try {
                    jSONObject2.put(str, 1);
                    try {
                        jSONObject2.put("message", "resource is null");
                        com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (org.json.JSONException e) {
                        e = e;
                        e.getMessage();
                        return;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (org.json.JSONException e2) {
                e = e2;
            } catch (java.lang.Throwable th4) {
                th = th4;
                r3 = "message";
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            str = str4;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(r3, th.getLocalizedMessage());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (org.json.JSONException e3) {
            e3.getMessage();
        }
    }

    public final void a() {
        if (this.h != null) {
            this.h = null;
        }
        if (this.i != null) {
            this.i = null;
        }
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(com.anythink.expressad.mbbanner.a.c.a aVar) {
        if (aVar != null) {
            this.h = aVar;
        }
    }

    public final void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.d = list;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void click(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
            if (list == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = (list == null || list.size() <= 0) ? null : this.d.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject a = com.anythink.expressad.foundation.d.c.a(cVar);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    a.put(next, jSONObject.getString(next));
                }
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(a);
                java.lang.String optString = a.optString("unitId");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    b2.l(optString);
                }
                cVar = b2;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(cVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void close() {
        try {
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.b();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void expand(java.lang.String str, boolean z) {
        android.content.Context context;
        try {
            java.lang.String str2 = "";
            if (getMraidCampaign() != null) {
                if (android.text.TextUtils.isEmpty(getMraidCampaign().q())) {
                    str2 = getMraidCampaign().p();
                } else {
                    str2 = "file:////" + getMraidCampaign().q();
                }
            }
            android.os.Bundle bundle = new android.os.Bundle();
            if (android.text.TextUtils.isEmpty(str)) {
                str = str2;
            }
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            java.lang.ref.WeakReference<android.content.Context> weakReference = this.c;
            if (weakReference != null && (context = weakReference.get()) != null) {
                com.anythink.expressad.mbbanner.a.a.b bVar = this.i;
                if (bVar != null && bVar.isShowing()) {
                    return;
                }
                com.anythink.expressad.mbbanner.a.a.b bVar2 = new com.anythink.expressad.mbbanner.a.a.b(context, bundle, this.h);
                this.i = bVar2;
                bVar2.a(this.f, this.d);
                this.i.show();
            }
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(true);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getFileInfo(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "params is empty");
            return;
        }
        try {
            a(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.d.get(0);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void init(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.o.a().f());
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.p, cVar.a());
            jSONObject.put("campaignList", com.anythink.expressad.foundation.d.c.b(this.d));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f);
            if (c == null) {
                c = com.anythink.expressad.d.c.c(this.f);
            }
            if (!android.text.TextUtils.isEmpty(this.e)) {
                c.e(this.e);
            }
            jSONObject.put("unitSetting", c.s());
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
            jSONObject.put("appSetting", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void open(java.lang.String str) {
        try {
            if (this.d.size() > 1) {
                com.anythink.core.common.b.o.a().f().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                str = null;
            }
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void readyStatus(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            try {
                int optInt = new org.json.JSONObject(str).optInt("isReady", 1);
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(0));
                com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
                if (aVar != null) {
                    aVar.b(optInt);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void sendImpressions(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String string = jSONArray.getString(i);
                for (com.anythink.expressad.foundation.d.c cVar : this.d) {
                    if (cVar.aZ().equals(string)) {
                        com.anythink.expressad.foundation.g.a.f.a(this.f, cVar, "banner");
                        arrayList.add(string);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(optInt);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            new org.json.JSONObject(str).optString(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(0));
        } catch (java.lang.Throwable unused) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.codeToJsonString(-1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            com.anythink.expressad.mbbanner.a.c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
