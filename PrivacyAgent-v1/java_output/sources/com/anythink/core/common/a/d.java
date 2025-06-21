package com.anythink.core.common.a;

/* loaded from: classes12.dex */
public final class d {
    public static com.anythink.core.common.f.j a(java.lang.String str, org.json.JSONObject jSONObject, int i) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.anythink.core.common.b.h.d.e);
            if (optJSONObject != null) {
                jSONObject = optJSONObject;
            } else if (!jSONObject.has("seatbid")) {
                return null;
            }
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONArray("seatbid").optJSONObject(0);
            com.anythink.core.common.f.j jVar = new com.anythink.core.common.f.j();
            jVar.b(str);
            jVar.k(optJSONObject2.optString(com.anythink.core.common.j.af));
            jVar.l(optJSONObject2.optString(com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_CID));
            jVar.x(optJSONObject2.optString("pkg"));
            jVar.m(optJSONObject2.optString("title"));
            jVar.n(optJSONObject2.optString("desc"));
            jVar.h(optJSONObject2.optInt(com.anythink.expressad.foundation.d.c.Y));
            jVar.o(optJSONObject2.optString("icon_u"));
            jVar.q(optJSONObject2.optString("full_u"));
            jVar.f(optJSONObject2.optInt("unit_type"));
            jVar.r(optJSONObject2.optString("tp_logo_u"));
            jVar.s(optJSONObject2.optString(com.anythink.basead.b.a.C0131a.k));
            jVar.t(optJSONObject2.optString("video_u"));
            jVar.d(optJSONObject2.optInt("video_l"));
            jVar.K(optJSONObject2.optString("video_r"));
            jVar.L(optJSONObject2.optString("ec_u"));
            jVar.u(optJSONObject2.optString("store_u"));
            jVar.g(optJSONObject2.optInt("link_type"));
            jVar.w(optJSONObject2.optString("click_u"));
            jVar.v(optJSONObject2.optString("deeplink"));
            jVar.n(optJSONObject2.optInt("crt_type", 1));
            jVar.M(optJSONObject2.optString("img_list"));
            jVar.N(optJSONObject2.optString("banner_xhtml"));
            jVar.e(optJSONObject2.optInt("offer_firm_id"));
            jVar.j(optJSONObject2.optString("jump_url"));
            try {
                java.lang.String optString = optJSONObject2.optString("sdk_resp");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    jVar.a(new org.json.JSONObject(optString).optString("data"));
                }
            } catch (java.lang.Throwable unused) {
            }
            jVar.O(optJSONObject2.optString("app_name"));
            jVar.z(optJSONObject2.optString(com.aliyun.vod.log.core.AliyunLogCommon.Module.PUBLISHER));
            jVar.A(optJSONObject2.optString("app_version"));
            jVar.B(optJSONObject2.optString("privacy"));
            jVar.C(optJSONObject2.optString("permission"));
            jVar.c(optJSONObject2.optString("app_desc"));
            jVar.i(optJSONObject2.optString("mtr_ver"));
            jVar.o(optJSONObject2.optInt("o_im_cap_sw", 2));
            jVar.p(optJSONObject2.optInt("o_cl_cap_sw", 2));
            jVar.q(optJSONObject2.optInt("c_im_cap_sw", 2));
            jVar.r(optJSONObject2.optInt("c_cl_cap_sw", 2));
            if (i == 67) {
                jVar.a(2);
            } else {
                jVar.a(1);
            }
            jVar.a((com.anythink.core.common.f.n) com.anythink.core.common.f.aj.i(optJSONObject2.optString("ctrl")));
            jVar.a(com.anythink.core.common.f.ak.a(optJSONObject2.optString("tk")));
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(optJSONObject2.optString("nw_info"));
                jVar.F(jSONObject2.optString("app_id"));
                jVar.G(jSONObject2.optString("app_key"));
                jVar.H(jSONObject2.optString("unit_id"));
            } catch (java.lang.Throwable unused2) {
            }
            jVar.I(optJSONObject2.optString("dsp_id", ""));
            jVar.J(optJSONObject2.optString("dsp_oid", ""));
            jVar.l(optJSONObject2.optInt(com.anythink.expressad.foundation.d.c.T, -1));
            jVar.m(optJSONObject2.optInt("install_sw", -1));
            jVar.D(optJSONObject2.optString("wv_ctrl"));
            jVar.d(optJSONObject2.optInt("adp_type"));
            jVar.f(optJSONObject2.optString("offer_html"));
            jVar.g(optJSONObject2.optString(com.anythink.expressad.foundation.d.r.ab));
            jVar.d(optJSONObject2.optString("wx_username"));
            jVar.e(optJSONObject2.optString("wx_path"));
            jVar.b(optJSONObject2.optInt("o_w"));
            jVar.c(optJSONObject2.optInt("o_h"));
            return jVar;
        } catch (java.lang.Throwable unused3) {
            return null;
        }
    }
}
