package com.anythink.expressad.video.signal.a;

/* loaded from: classes12.dex */
public final class m extends com.anythink.expressad.video.signal.a.f {
    private android.app.Activity b;
    private com.anythink.expressad.video.module.AnythinkContainerView c;

    public m(android.app.Activity activity, com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView) {
        this.b = activity;
        this.c = anythinkContainerView;
    }

    private static java.lang.String a(java.util.List<com.anythink.expressad.foundation.d.c> list, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        try {
            if (list.size() <= 0) {
                return null;
            }
            com.anythink.expressad.foundation.h.b bVar = new com.anythink.expressad.foundation.h.b(com.anythink.expressad.foundation.b.a.b().d());
            java.lang.Object b = com.anythink.expressad.foundation.d.c.b(list);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("campaignList", b);
            jSONObject2.put(com.alipay.sdk.m.p.e.p, bVar.a());
            jSONObject2.put("unit_id", str);
            jSONObject2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, str2);
            jSONObject2.put("unitSetting", jSONObject);
            if (com.anythink.expressad.d.b.a() != null) {
                com.anythink.expressad.d.b.a();
                java.lang.String a = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
                if (!android.text.TextUtils.isEmpty(a)) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject(a);
                    try {
                        android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
                        java.lang.String obj = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmTitle".concat(java.lang.String.valueOf(str)), "").toString();
                        java.lang.String obj2 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmContent".concat(java.lang.String.valueOf(str)), "").toString();
                        java.lang.String obj3 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_CancelText".concat(java.lang.String.valueOf(str)), "").toString();
                        java.lang.String obj4 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmText".concat(java.lang.String.valueOf(str)), "").toString();
                        if (!android.text.TextUtils.isEmpty(obj)) {
                            jSONObject3.put(com.anythink.expressad.d.a.b.ct, obj);
                        }
                        if (!android.text.TextUtils.isEmpty(obj2)) {
                            jSONObject3.put(com.anythink.expressad.d.a.b.cu, obj2);
                        }
                        if (!android.text.TextUtils.isEmpty(obj3)) {
                            jSONObject3.put(com.anythink.expressad.d.a.b.cv, obj3);
                        }
                        if (!android.text.TextUtils.isEmpty(obj4)) {
                            jSONObject3.put(com.anythink.expressad.d.a.b.cx, obj4);
                        }
                        if (!android.text.TextUtils.isEmpty(obj4)) {
                            jSONObject3.put(com.anythink.expressad.d.a.b.cw, obj4);
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    com.anythink.expressad.d.b.a();
                    java.lang.String b2 = com.anythink.expressad.d.b.b(str);
                    if (!android.text.TextUtils.isEmpty(b2)) {
                        jSONObject3.put("ivreward", new org.json.JSONObject(b2));
                    }
                    jSONObject2.put("appSetting", jSONObject3);
                }
            }
            return jSONObject2.toString();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void a(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            android.content.Context d = com.anythink.expressad.foundation.b.a.b().d();
            java.lang.String obj = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmTitle".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj2 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmContent".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj3 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_CancelText".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj4 = com.anythink.expressad.foundation.h.v.b(d, "Anythink_ConfirmText".concat(java.lang.String.valueOf(str)), "").toString();
            if (!android.text.TextUtils.isEmpty(obj)) {
                jSONObject.put(com.anythink.expressad.d.a.b.ct, obj);
            }
            if (!android.text.TextUtils.isEmpty(obj2)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cu, obj2);
            }
            if (!android.text.TextUtils.isEmpty(obj3)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cv, obj3);
            }
            if (!android.text.TextUtils.isEmpty(obj4)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cx, obj4);
            }
            if (android.text.TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put(com.anythink.expressad.d.a.b.cw, obj4);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static com.anythink.expressad.videocommon.e.d c(java.lang.String str) {
        if (com.anythink.expressad.videocommon.e.c.a() == null) {
            return null;
        }
        return com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str);
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final java.lang.String a() {
        if (this.c == null) {
            super.a();
        } else {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(this.c.getCampaign());
                java.lang.String unitID = this.c.getUnitID();
                java.lang.String str = com.anythink.expressad.out.b.a + ",3.0.1";
                com.anythink.expressad.videocommon.e.d a = com.anythink.expressad.videocommon.e.c.a() == null ? null : com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), unitID);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (a != null) {
                    jSONObject = a.R();
                }
                java.util.Objects.toString(this.c.getCampaign());
                return a(arrayList, unitID, str, jSONObject);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return super.a();
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final void a(java.lang.String str) {
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView;
        super.a(str);
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str) || !str.equals(com.anythink.expressad.foundation.d.c.ca) || (anythinkContainerView = this.c) == null) {
                return;
            }
            anythinkContainerView.triggerCloseBtn(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i
    public final void b(java.lang.String str) {
        super.b(str);
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("landscape")) {
                this.b.setRequestedOrientation(0);
            } else if (str.equals("portrait")) {
                this.b.setRequestedOrientation(1);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.i, com.anythink.expressad.video.signal.h
    public final void handlerPlayableException(java.lang.String str) {
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView;
        super.handlerPlayableException(str);
        try {
            if (this.b == null || android.text.TextUtils.isEmpty(str) || (anythinkContainerView = this.c) == null) {
                return;
            }
            anythinkContainerView.handlerPlayableException(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void install(com.anythink.expressad.foundation.d.c cVar) {
        super.install(cVar);
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.c;
        if (anythinkContainerView != null) {
            anythinkContainerView.install(cVar);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void notifyCloseBtn(int i) {
        super.notifyCloseBtn(i);
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.c;
        if (anythinkContainerView != null) {
            anythinkContainerView.notifyCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void orientation(android.content.res.Configuration configuration) {
        super.orientation(configuration);
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.c;
            if (anythinkContainerView != null) {
                anythinkContainerView.orientation(configuration);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.c;
        if (anythinkContainerView != null) {
            anythinkContainerView.toggleCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.f, com.anythink.expressad.video.signal.h
    public final void webviewshow() {
        super.webviewshow();
        try {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.c;
            if (anythinkContainerView != null) {
                anythinkContainerView.webviewshow();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
