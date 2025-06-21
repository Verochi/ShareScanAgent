package com.igexin.push.core.b;

/* loaded from: classes23.dex */
public final class a {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f = com.igexin.sdk.PushBuildConfig.sdk_conf_channelid;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public java.lang.String m;
    public long n;
    public java.lang.String o;

    public a() {
        if (com.igexin.push.core.e.g != null) {
            this.f += com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + com.igexin.push.core.e.g;
        }
        this.e = "3.3.7.2";
        this.b = com.igexin.push.core.e.E;
        this.c = com.igexin.push.core.e.D;
        this.d = com.igexin.push.h.n.c();
        this.a = com.igexin.push.core.e.F;
        this.h = com.sensorsdata.sf.ui.view.UIProperty.action_android;
        this.j = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE;
        this.k = "MDP";
        this.g = com.igexin.push.core.e.H;
        this.n = java.lang.System.currentTimeMillis();
        this.l = com.igexin.push.core.e.I;
        this.m = com.igexin.push.core.e.G;
        this.o = com.igexin.push.core.e.C;
        if (!com.igexin.assist.sdk.a.a().c() || com.igexin.assist.sdk.AssistPushManager.checkSupportDevice(com.igexin.push.core.e.l)) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("FCM-");
        java.lang.String str = this.m;
        sb.append(str == null ? "" : str);
        this.m = sb.toString();
    }

    private static java.lang.String a(com.igexin.push.core.b.a aVar) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String str = aVar.a;
        if (str == null) {
            str = "";
        }
        jSONObject.put("model", str);
        java.lang.String str2 = aVar.b;
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("sim", str2);
        java.lang.String str3 = aVar.c;
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("imei", str3);
        jSONObject.put("mac", aVar.d == null ? "" : com.igexin.push.h.n.c());
        java.lang.String str4 = aVar.e;
        if (str4 == null) {
            str4 = "";
        }
        jSONObject.put("version", str4);
        java.lang.String str5 = aVar.f;
        if (str5 == null) {
            str5 = "";
        }
        jSONObject.put("channelid", str5);
        jSONObject.put("type", com.sensorsdata.sf.ui.view.UIProperty.action_android);
        java.lang.String str6 = aVar.k;
        if (str6 == null) {
            str6 = "";
        }
        jSONObject.put("app", str6);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ANDROID-");
        java.lang.String str7 = aVar.g;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        jSONObject.put("deviceid", sb.toString());
        java.lang.String str8 = aVar.l;
        if (str8 == null) {
            str8 = "";
        }
        jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, str8);
        java.lang.String str9 = aVar.m;
        if (str9 == null) {
            str9 = "";
        }
        jSONObject.put("brand", str9);
        java.lang.String str10 = aVar.j;
        if (str10 == null) {
            str10 = "";
        }
        jSONObject.put("system_version", str10);
        java.lang.String str11 = aVar.i;
        if (str11 == null) {
            str11 = "";
        }
        jSONObject.put("cell", str11);
        jSONObject.put("aid", com.igexin.push.h.n.h());
        jSONObject.put("adid", com.igexin.push.h.n.i());
        jSONObject.put("gtcid", android.text.TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
        java.lang.String str12 = com.igexin.push.core.e.h;
        if (str12 == null) {
            str12 = "";
        }
        jSONObject.put("oaid", str12);
        com.igexin.push.core.ServiceManager.getInstance();
        java.lang.String e = com.igexin.push.core.ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.ao.equals(e)) {
            jSONObject.put("us", e);
        }
        com.igexin.push.core.ServiceManager.getInstance();
        jSONObject.put("ua", com.igexin.push.core.ServiceManager.d(com.igexin.push.core.e.l));
        jSONObject.put("notification_enabled", com.igexin.push.h.c.b(com.igexin.push.core.e.l) ? 1 : 0);
        jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("action", "addphoneinfo");
        jSONObject2.put("id", java.lang.String.valueOf(aVar.n));
        jSONObject2.put("info", jSONObject);
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        jSONObject3.put("guardMe", java.lang.String.valueOf(com.igexin.push.config.e.b()));
        jSONObject3.put("guardOthers", java.lang.String.valueOf(com.igexin.push.config.e.c()));
        jSONObject2.put("extra", jSONObject3);
        return jSONObject2.toString();
    }
}
