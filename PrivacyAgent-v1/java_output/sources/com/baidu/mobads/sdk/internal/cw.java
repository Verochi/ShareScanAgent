package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cw implements com.baidu.mobads.sdk.internal.w {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ java.lang.String c;
    final /* synthetic */ com.baidu.mobads.sdk.internal.cs d;

    public cw(com.baidu.mobads.sdk.internal.cs csVar, int i, int i2, java.lang.String str) {
        this.d = csVar;
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String i = this.d.i("get_cuid");
        java.lang.String i2 = this.d.i("get_imei");
        java.lang.String i3 = this.d.i("get_oaid");
        try {
            jSONObject.put("cuid", i);
            jSONObject.put("imei", i2);
            jSONObject.put("oaid", i3);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(long j) {
        this.d.k.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(android.view.ViewGroup viewGroup) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", this.d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        this.d.a(com.baidu.mobads.sdk.internal.cx.u, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(android.view.ViewGroup viewGroup, int i) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", this.d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", java.lang.Boolean.valueOf(this.d.f()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("count_down", java.lang.Integer.valueOf(i));
        this.d.a(com.baidu.mobads.sdk.internal.cx.A, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(android.view.ViewGroup viewGroup, android.view.ViewGroup viewGroup2, int i) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", this.d.e());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", java.lang.Boolean.valueOf(this.d.f()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor, java.lang.Integer.valueOf(i));
        this.d.a(com.baidu.mobads.sdk.internal.cx.z, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(android.view.ViewGroup viewGroup, org.json.JSONObject jSONObject) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", this.d.e());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", java.lang.Boolean.valueOf(this.d.f()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(com.baidu.mobads.sdk.internal.cx.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(org.json.JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(android.view.ViewGroup viewGroup) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        this.d.a(com.baidu.mobads.sdk.internal.cx.y, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(android.view.ViewGroup viewGroup, org.json.JSONObject jSONObject) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("novel_activity", this.d.e());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", java.lang.Boolean.valueOf(this.d.f()));
        hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.a));
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b));
        hashMap.put("novel_id", this.c);
        hashMap.put("novel_info", jSONObject);
        this.d.a(com.baidu.mobads.sdk.internal.cx.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(org.json.JSONObject jSONObject) {
    }
}
