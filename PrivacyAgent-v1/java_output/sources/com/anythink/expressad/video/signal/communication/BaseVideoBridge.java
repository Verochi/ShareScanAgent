package com.anythink.expressad.video.signal.communication;

/* loaded from: classes12.dex */
public class BaseVideoBridge extends com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5 implements com.anythink.expressad.video.signal.communication.IVideoBridge {
    protected static final java.lang.String h = "JS-Video-Brigde";
    private static final int j = 1;
    private static final int k = 2;
    private static final java.lang.String l = "showTransparent";
    private static final java.lang.String m = "mute";
    private static final java.lang.String n = "closeType";
    private static final java.lang.String o = "orientationType";
    private static final java.lang.String p = "type";
    private static final java.lang.String q = "h5cbp";
    private static final java.lang.String r = "webfront";

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f280s = "showAlertRole";
    protected com.anythink.expressad.video.signal.factory.IJSFactory i;

    private static java.lang.String a(int i) {
        switch (i) {
            case 1:
                return com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO;
            case 2:
                return "unit_id";
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return com.alipay.sdk.m.p.e.p;
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    private static void a(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private static java.lang.String b(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendSubView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().i(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendViewTo(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().j(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void bringViewToFront(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().m(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void broadcast(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().M(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void cai(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                java.lang.String optString = new org.json.JSONObject(str).optString("packageName");
                if (android.text.TextUtils.isEmpty(optString)) {
                    com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "packageName is empty");
                }
                int i = com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), optString) ? 1 : 2;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
                    e.getMessage();
                }
            } catch (java.lang.Throwable th) {
                com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
            }
        } catch (org.json.JSONException e2) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e2.getLocalizedMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void clearAllCache(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.core.common.b.o.a().f().getSharedPreferences(com.anythink.expressad.foundation.g.a.p, 0).edit().clear().apply();
            if (obj != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void click(java.lang.Object obj, java.lang.String str) {
        java.lang.String str2;
        int i;
        com.anythink.expressad.video.signal.a.j jVar;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                i = jSONObject.optInt("type");
                str2 = jSONObject.optString(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME);
            } catch (org.json.JSONException e) {
                str2 = "";
                e.printStackTrace();
                i = 1;
            }
            com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory = this.i;
            if (iJSFactory != null) {
                iJSFactory.getJSCommon().click(i, str2);
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (!(aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) || (jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject()) == null) {
                    return;
                }
                jVar.click(i, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeAd(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().L(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeVideoOperte(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.i.getJSVideoModule().closeVideoOperate(jSONObject.optInt("close"), jSONObject.optInt("view_visible"));
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeWeb(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new org.json.JSONObject(str).optInt("status");
            this.i.getJSContainerModule().hideAlertWebview();
            this.i.getJSVideoModule().hideAlertView(optInt);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createNativeEC(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().Q(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createPlayerView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().c(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createSubPlayTemplateView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().d(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().a(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createWebview(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().b(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void destroyComponent(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().e(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #1 {all -> 0x008b, blocks: (B:13:0x0058, B:16:0x006b, B:18:0x0076, B:23:0x006f), top: B:12:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076 A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #1 {all -> 0x008b, blocks: (B:13:0x0058, B:16:0x006b, B:18:0x0076, B:23:0x006f), top: B:12:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[Catch: all -> 0x008b, TryCatch #1 {all -> 0x008b, blocks: (B:13:0x0058, B:16:0x006b, B:18:0x0076, B:23:0x006f), top: B:12:0x0058 }] */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getAllCache(java.lang.Object obj, java.lang.String str) {
        org.json.JSONObject jSONObject;
        java.lang.Throwable th;
        java.lang.String str2;
        android.content.SharedPreferences sharedPreferences;
        try {
            sharedPreferences = com.anythink.core.common.b.o.a().f().getSharedPreferences(com.anythink.expressad.foundation.g.a.p, 0);
            jSONObject = new org.json.JSONObject();
        } catch (java.lang.Throwable th2) {
            jSONObject = null;
            th = th2;
        }
        try {
            try {
                for (java.util.Map.Entry<java.lang.String, ?> entry : sharedPreferences.getAll().entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                str2 = "getAllCache Success";
            } catch (java.lang.Throwable th3) {
                th = th3;
                th.toString();
                str2 = "getAllCache Error, reason is : " + th.getMessage();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("message", str2);
                if (jSONObject == null) {
                }
                if (obj == null) {
                }
            }
            org.json.JSONObject jSONObject22 = new org.json.JSONObject();
            jSONObject22.put("code", 0);
            jSONObject22.put("message", str2);
            if (jSONObject == null) {
                jSONObject22.put("data", jSONObject);
            } else {
                jSONObject22.put("data", "{}");
            }
            if (obj == null) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject22.toString().getBytes(), 2));
            }
        } catch (java.lang.Throwable th4) {
            th4.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAppSetting(java.lang.Object obj, java.lang.String str) {
        org.json.JSONObject jSONObject;
        try {
            java.lang.String optString = new org.json.JSONObject(str).optString("appid", "");
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (android.text.TextUtils.isEmpty(optString)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            } else {
                com.anythink.expressad.d.b.a();
                java.lang.String a = com.anythink.expressad.d.b.a(optString);
                if (android.text.TextUtils.isEmpty(a)) {
                    com.anythink.expressad.d.b.a();
                    jSONObject = new org.json.JSONObject(com.anythink.expressad.d.b.c().R());
                } else {
                    jSONObject = new org.json.JSONObject(a);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getComponentOptions(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCurrentProgress(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory = this.i;
            if (iJSFactory != null) {
                java.lang.String currentProgress = iJSFactory.getJSVideoModule().getCurrentProgress();
                if (!android.text.TextUtils.isEmpty(currentProgress)) {
                    currentProgress = android.util.Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, currentProgress);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCutout(java.lang.Object obj, java.lang.String str) {
        try {
            java.lang.String o2 = this.i.getJSCommon().o();
            if (obj != null && !android.text.TextUtils.isEmpty(o2)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(o2.getBytes(), 2));
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "No notch data, plz try again later.");
            com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getEncryptPrice(java.lang.Object obj, java.lang.String str) {
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getFileInfo(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.P(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardSetting(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject k2 = com.anythink.expressad.videocommon.e.c.a().b().k();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (obj != null) {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put("data", k2);
            } else {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardUnitSetting(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("appid", "");
            java.lang.String optString2 = jSONObject.optString("unitid", "");
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            if (android.text.TextUtils.isEmpty(optString) || android.text.TextUtils.isEmpty(optString2)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            } else {
                org.json.JSONObject R = com.anythink.expressad.videocommon.e.c.a().a(optString, optString2).R();
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", R);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getSDKInfo(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, "params is null");
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONObject(str).getJSONArray("type");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            int i = 0;
            if (this.i != null) {
                while (i < jSONArray.length()) {
                    int i2 = jSONArray.getInt(i);
                    jSONObject.put(a(i2), this.i.getJSCommon().h(i2));
                    i++;
                }
            } else if (obj != null) {
                while (i < jSONArray.length()) {
                    int i3 = jSONArray.getInt(i);
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                        jSONObject.put(a(i3), ((com.anythink.expressad.video.signal.a.j) aVar.a.getObject()).h(i3));
                    }
                    i++;
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable unused) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, "exception");
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getUnitSetting(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void gial(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("packageNameList", "[]");
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, e.getMessage());
            e.getMessage();
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handleNativeObject(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.b.a().a(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handlerH5Exception(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.i.getJSCommon().handlerH5Exception(jSONObject.optInt("code", com.anythink.expressad.video.bt.a.c.a), jSONObject.optString("message", "h5 error"));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void hideView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().n(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void increaseOfferFrequence(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            new org.json.JSONObject(str);
            com.anythink.expressad.video.bt.a.c.a(obj);
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void init(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory = this.i;
            int i = 1;
            if (iJSFactory != null) {
                java.lang.String i2 = iJSFactory.getJSCommon().i();
                if (!android.text.TextUtils.isEmpty(i2)) {
                    i2 = android.util.Base64.encodeToString(i2.getBytes(), 2);
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, i2);
                this.i.getJSCommon().h();
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int optInt = jSONObject.optInt(l);
                int optInt2 = jSONObject.optInt("mute");
                int optInt3 = jSONObject.optInt(n);
                int optInt4 = jSONObject.optInt(o);
                int optInt5 = jSONObject.optInt(q);
                int optInt6 = jSONObject.optInt(r);
                int optInt7 = jSONObject.optInt(f280s);
                this.i.getJSCommon().a(optInt == 1);
                this.i.getJSCommon().b(optInt2);
                this.i.getJSCommon().c(optInt3);
                this.i.getJSCommon().d(optInt4);
                this.i.getJSCommon().e(optInt5);
                this.i.getJSCommon().f(optInt6);
                com.anythink.expressad.video.signal.c jSCommon = this.i.getJSCommon();
                if (optInt7 != 0) {
                    i = optInt7;
                }
                jSCommon.i(i);
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject();
                    java.lang.String i3 = jVar.i();
                    if (!android.text.TextUtils.isEmpty(str)) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
                        int optInt8 = jSONObject2.optInt(l);
                        int optInt9 = jSONObject2.optInt("mute");
                        int optInt10 = jSONObject2.optInt(n);
                        int optInt11 = jSONObject2.optInt(o);
                        int optInt12 = jSONObject2.optInt(q);
                        int optInt13 = jSONObject2.optInt(r);
                        int optInt14 = jSONObject2.optInt(f280s);
                        jVar.a(optInt8 == 1);
                        jVar.b(optInt9);
                        jVar.c(optInt10);
                        jVar.d(optInt11);
                        jVar.e(optInt12);
                        jVar.f(optInt13);
                        if (optInt14 != 0) {
                            i = optInt14;
                        }
                        jVar.i(i);
                    }
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(i3.getBytes(), 2));
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof com.anythink.expressad.video.signal.factory.IJSFactory) {
            this.i = (com.anythink.expressad.video.signal.factory.IJSFactory) obj;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewAbove(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().s(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewBelow(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().t(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void isSystemResume(java.lang.Object obj, java.lang.String str) {
        try {
            com.anythink.expressad.video.signal.factory.IJSFactory iJSFactory = this.i;
            if (iJSFactory != null) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(iJSFactory.getActivityProxy().h()));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void ivRewardAdsWithoutVideo(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadads(java.lang.Object obj, java.lang.String str) {
        java.lang.String str2;
        int i;
        int i2;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                str2 = "";
                i = 1;
                i2 = 1;
            } else {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                str2 = jSONObject.optString("unitId");
                i2 = jSONObject.optInt("type", 1);
                if (i2 > 2) {
                    i2 = 1;
                }
                i = jSONObject.optInt("adtype", 1);
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if ((windVaneWebView instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) && windVaneWebView.getWebViewListener() != null) {
                    ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(str2, i2, i);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(1));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadingResourceStatus(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        if (obj != null) {
            try {
                int optInt = new org.json.JSONObject(str).optInt("isReady", 1);
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().loadingResourceStatus(windVaneWebView, optInt);
            } catch (java.lang.Throwable th) {
                th.toString();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void notifyCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().notifyCloseBtn(new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendSubView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().k(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendViewTo(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().l(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewAbove(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().u(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewBelow(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().v(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void openURL(java.lang.Object obj, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.anythink.core.common.o.m.a(optString);
            } else if (optInt == 2) {
                com.anythink.core.common.o.m.a(this.e, optString);
            }
        } catch (org.json.JSONException e) {
            e.getMessage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playVideoFinishOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSCommon().g(new org.json.JSONObject(str).optInt("type"));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerGetMuteState(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().H(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerMute(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().F(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPause(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().B(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPlay(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().A(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerResume(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().C(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetRenderType(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.J(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetSource(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.I(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerStop(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().D(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUnmute(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().G(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUpdateFrame(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.E(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void preloadSubPlayTemplateView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            if (this.i != null) {
                com.anythink.expressad.video.bt.a.c.a().K(obj, new org.json.JSONObject(str));
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
            if (!(windVaneWebView instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) || windVaneWebView.getWebViewListener() == null) {
                return;
            }
            ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(obj, str);
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressBarOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().progressBarOperate(new org.json.JSONObject(str).optInt("view_visible"));
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.i.getJSVideoModule().progressOperate(jSONObject.optInt(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS), jSONObject.optInt("view_visible"));
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reactDeveloper(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, b(1));
            } else {
                this.i.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void readyStatus(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                int optInt = new org.json.JSONObject(str).optInt("isReady", 1);
                if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    ((com.anythink.expressad.video.signal.a.j) aVar.a.getObject()).j(optInt);
                }
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
                if (windVaneWebView == null || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, optInt);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void removeCacheItem(java.lang.Object obj, java.lang.String str) {
        java.lang.String str2;
        boolean z;
        org.json.JSONObject jSONObject;
        android.content.SharedPreferences sharedPreferences;
        try {
            sharedPreferences = com.anythink.core.common.b.o.a().f().getSharedPreferences(com.anythink.expressad.foundation.g.a.p, 0);
        } catch (java.lang.Throwable th) {
            th.toString();
            str2 = "Delete Error, reason is : " + th.getMessage();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "";
            z = false;
            jSONObject = new org.json.JSONObject();
            jSONObject.put("code", z ? 0 : 1);
            jSONObject.put("message", str2);
            if (obj == null) {
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        java.lang.String string = new org.json.JSONObject(str).getString("key");
        if (!android.text.TextUtils.isEmpty(string)) {
            sharedPreferences.edit().remove(string).apply();
        }
        str2 = "Delete Success";
        z = true;
        try {
            jSONObject = new org.json.JSONObject();
            jSONObject.put("code", z ? 0 : 1);
            jSONObject.put("message", str2);
            if (obj == null && z) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } else {
                com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeFromSuperView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().h(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reportUrls(java.lang.Object obj, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, b(1));
            } else {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.b(obj, str);
            }
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCacheItem(java.lang.Object obj, java.lang.String str) {
        java.lang.String str2;
        boolean z;
        org.json.JSONObject jSONObject;
        android.content.SharedPreferences sharedPreferences;
        try {
            sharedPreferences = com.anythink.core.common.b.o.a().f().getSharedPreferences(com.anythink.expressad.foundation.g.a.p, 0);
        } catch (java.lang.Throwable th) {
            th.toString();
            str2 = "Save Error, reason is : " + th.getMessage();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "";
            z = false;
            jSONObject = new org.json.JSONObject();
            jSONObject.put("code", z ? 0 : 1);
            jSONObject.put("message", str2);
            if (obj == null) {
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject(str);
        java.lang.String string = jSONObject2.getString("key");
        java.lang.String string2 = jSONObject2.getString("value");
        if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2)) {
            sharedPreferences.edit().putString(string, string2).apply();
        }
        str2 = "Save Success";
        z = true;
        try {
            jSONObject = new org.json.JSONObject();
            jSONObject.put("code", z ? 0 : 1);
            jSONObject.put("message", str2);
            if (obj == null && z) {
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } else {
                com.anythink.expressad.atsignalcommon.windvane.j.a().b(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setScaleFitXY(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().setScaleFitXY(new org.json.JSONObject(str).optInt("fitxy"));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setSubPlayTemplateInfo(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().N(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewAlpha(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().q(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewBgColor(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().p(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewRect(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().g(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewScale(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().r(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showAlertView(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().showIVRewardAlertView(str);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, "showAlertView", "");
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoClickView(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSContainerModule().showVideoClickView(new org.json.JSONObject(str).optInt("type"));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoLocation(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.i.getJSVideoModule().showVideoLocation(jSONObject.optInt("margin_top", 0), jSONObject.optInt("margin_left", 0), jSONObject.optInt("view_width", 0), jSONObject.optInt("view_height", 0), jSONObject.optInt("radius", 0), jSONObject.optInt("border_top", 0), jSONObject.optInt("border_left", 0), jSONObject.optInt("border_width", 0), jSONObject.optInt("border_height", 0));
            this.i.getJSCommon().l();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showView(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().o(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void soundOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int optInt = jSONObject.optInt("mute");
            int optInt2 = jSONObject.optInt("view_visible");
            java.lang.String optString = jSONObject.optString(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.PRIORITY_VALID_TIME, "");
            if (android.text.TextUtils.isEmpty(optString)) {
                this.i.getJSVideoModule().soundOperate(optInt, optInt2);
            } else {
                this.i.getJSVideoModule().soundOperate(optInt, optInt2, optString);
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void statistics(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.i.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void toggleCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new org.json.JSONObject(str).optInt(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
            int i = 2;
            if (optInt != 1) {
                i = optInt == 2 ? 1 : 0;
            }
            this.i.getJSVideoModule().closeVideoOperate(0, i);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void triggerCloseBtn(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str) || !new org.json.JSONObject(str).optString(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b).equals(com.anythink.expressad.foundation.d.c.ca)) {
                return;
            }
            this.i.getJSVideoModule().closeVideoOperate(1, -1);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void videoOperate(java.lang.Object obj, java.lang.String str) {
        try {
            if (this.i == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.i.getJSVideoModule().videoOperate(new org.json.JSONObject(str).optInt("pause_or_resume"));
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, b(0));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewFireEvent(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().O(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoBack(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().y(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoForward(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().z(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewLoad(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().w(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewReload(java.lang.Object obj, java.lang.String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.c.a().x(obj, new org.json.JSONObject(str));
        } catch (java.lang.Throwable th) {
            th.toString();
        }
    }
}
