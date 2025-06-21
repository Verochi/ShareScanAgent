package com.anythink.basead.d.b;

/* loaded from: classes12.dex */
public final class b {
    public static final java.lang.String a = "sdk_updatetime";

    public static final com.anythink.core.common.f.ah a(com.anythink.core.common.f.m mVar, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.anythink.core.common.b.h.d.e);
            if (optJSONObject == null) {
                return null;
            }
            org.json.JSONObject optJSONObject2 = optJSONObject.optJSONArray("offers").optJSONObject(0);
            com.anythink.core.common.f.ah ahVar = new com.anythink.core.common.f.ah();
            ahVar.a(mVar.f);
            ahVar.k(optJSONObject2.optString(com.anythink.core.common.j.af));
            ahVar.l(optJSONObject2.optString(com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_CID));
            ahVar.x(optJSONObject2.optString("pkg"));
            ahVar.m(optJSONObject2.optString("title"));
            ahVar.n(optJSONObject2.optString("desc"));
            ahVar.h(optJSONObject2.optInt(com.anythink.expressad.foundation.d.c.Y));
            ahVar.o(optJSONObject2.optString("icon_u"));
            ahVar.q(optJSONObject2.optString("full_u"));
            ahVar.f(optJSONObject2.optInt("unit_type"));
            ahVar.r(optJSONObject2.optString("tp_logo_u"));
            ahVar.s(optJSONObject2.optString(com.anythink.basead.b.a.C0131a.k));
            ahVar.t(optJSONObject2.optString("video_u"));
            ahVar.d(optJSONObject2.optInt("video_l"));
            ahVar.K(optJSONObject2.optString("video_r"));
            ahVar.L(optJSONObject2.optString("ec_u"));
            ahVar.u(optJSONObject2.optString("store_u"));
            ahVar.g(optJSONObject2.optInt("link_type"));
            ahVar.w(optJSONObject2.optString("click_u"));
            ahVar.v(optJSONObject2.optString("deeplink"));
            ahVar.k(optJSONObject2.optInt("r_target"));
            ahVar.a(optJSONObject2.optLong("expire"));
            ahVar.y(optJSONObject2.optString("ad_logo_title"));
            ahVar.n(optJSONObject2.optInt("crt_type", 1));
            ahVar.M(optJSONObject2.optString("img_list"));
            ahVar.N(optJSONObject2.optString("banner_xhtml"));
            ahVar.b(jSONObject.optLong(a));
            ahVar.e(optJSONObject2.optInt("offer_firm_id"));
            ahVar.j(optJSONObject2.optString("jump_url"));
            ahVar.O(optJSONObject2.optString("app_name"));
            ahVar.z(optJSONObject2.optString(com.aliyun.vod.log.core.AliyunLogCommon.Module.PUBLISHER));
            ahVar.A(optJSONObject2.optString("app_version"));
            ahVar.B(optJSONObject2.optString("privacy"));
            ahVar.C(optJSONObject2.optString("permission"));
            ahVar.c(optJSONObject2.optString("app_desc"));
            ahVar.D(optJSONObject2.optString("wv_ctrl"));
            ahVar.a((com.anythink.core.common.f.n) com.anythink.core.common.f.aj.i(optJSONObject2.optString("ctrl")));
            ahVar.a(com.anythink.core.common.f.ak.a(optJSONObject2.optString("tk")));
            ahVar.d(optJSONObject2.optInt("adp_type"));
            ahVar.f(optJSONObject2.optString("offer_html"));
            ahVar.g(optJSONObject2.optString(com.anythink.expressad.foundation.d.r.ab));
            ahVar.d(optJSONObject2.optString("wx_username"));
            ahVar.e(optJSONObject2.optString("wx_path"));
            ahVar.b(optJSONObject2.optInt("o_w"));
            ahVar.c(optJSONObject2.optInt("o_h"));
            return ahVar;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
