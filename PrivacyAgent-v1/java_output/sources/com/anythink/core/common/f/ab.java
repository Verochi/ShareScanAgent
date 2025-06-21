package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class ab extends com.anythink.core.common.f.n {
    protected int n;

    private void X(int i) {
        this.n = i;
    }

    public static com.anythink.core.common.f.ab i(java.lang.String str) {
        com.anythink.core.common.f.ab abVar = new com.anythink.core.common.f.ab();
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                abVar.s(jSONObject.optInt("f_t"));
                abVar.t(jSONObject.optInt("v_c"));
                abVar.u(jSONObject.optInt("s_b_t"));
                abVar.w(jSONObject.optInt("e_c_a"));
                abVar.x(jSONObject.optInt("v_m"));
                abVar.y(jSONObject.optInt("s_c_t"));
                abVar.n(jSONObject.optInt("m_t"));
                abVar.c(jSONObject.optLong("o_c_t"));
                abVar.o(jSONObject.optInt("ak_cfm"));
                abVar.b(jSONObject.optLong("ctdown_time"));
                abVar.p(jSONObject.optInt("sk_able"));
                abVar.q(jSONObject.optInt("orient"));
                abVar.e(jSONObject.optString(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE));
                abVar.r(jSONObject.optInt("cl_btn"));
                abVar.z(jSONObject.optInt("ec_r"));
                abVar.A(jSONObject.optInt("ec_s_t"));
                abVar.B(jSONObject.optInt("ec_l_t"));
                abVar.f(jSONObject.optString("inter_type"));
                abVar.n = jSONObject.optInt("spl_type");
                abVar.a(jSONObject.optLong("or_t"));
                abVar.g(jSONObject.optInt("rv_fail_reward"));
                abVar.h(jSONObject.optInt("cl_sz"));
                abVar.k(jSONObject.optInt("si_fit"));
                if (jSONObject.has("at_cl_sw")) {
                    abVar.C(jSONObject.optInt("at_cl_sw"));
                }
                if (jSONObject.has("at_ct_ti")) {
                    abVar.D(jSONObject.optInt("at_ct_ti"));
                }
                if (jSONObject.has("int_cl_sw")) {
                    abVar.E(jSONObject.optInt("int_cl_sw"));
                }
                if (jSONObject.has("int_cl_ti")) {
                    abVar.F(jSONObject.optInt("int_cl_ti"));
                }
                if (jSONObject.has("sh_ec")) {
                    abVar.G(jSONObject.optInt("sh_ec"));
                }
                if (jSONObject.has("ipua")) {
                    abVar.e(jSONObject.optInt("ipua"));
                }
                if (jSONObject.has("clua")) {
                    abVar.f(jSONObject.optInt("clua"));
                }
                if (jSONObject.has("ap_arpt")) {
                    abVar.H(jSONObject.optInt("ap_arpt"));
                }
                if (jSONObject.has("ap_pasbl")) {
                    abVar.I(jSONObject.optInt("ap_pasbl"));
                }
                if (jSONObject.has("shk_sw")) {
                    abVar.J(jSONObject.optInt("shk_sw"));
                }
                if (jSONObject.has("shk_strength_and")) {
                    abVar.K(jSONObject.optInt("shk_strength_and"));
                }
                if (jSONObject.has("shk_time")) {
                    abVar.d(jSONObject.optLong("shk_time"));
                }
                if (jSONObject.has("click_cache_time")) {
                    abVar.L(jSONObject.optInt("click_cache_time"));
                } else {
                    abVar.L(3600000);
                }
                boolean z = true;
                if (jSONObject.has("click_nt_sw")) {
                    abVar.M(jSONObject.optInt("click_nt_sw"));
                } else {
                    abVar.M(1);
                }
                if (jSONObject.has("ft_cl_sz")) {
                    abVar.i(jSONObject.optInt("ft_cl_sz"));
                } else {
                    abVar.i(1);
                }
                if (jSONObject.has("sh_cl_itp")) {
                    abVar.j(jSONObject.optInt("sh_cl_itp"));
                } else {
                    abVar.j(2);
                }
                abVar.N(jSONObject.optInt("shm_t", -1));
                if (jSONObject.has("ready_rate")) {
                    abVar.O(jSONObject.optInt("ready_rate"));
                } else {
                    abVar.O(100);
                }
                if (jSONObject.has("rsdl_rate")) {
                    abVar.P(jSONObject.optInt("rsdl_rate"));
                } else {
                    abVar.P(0);
                }
                if (jSONObject.has("video_ctn_type")) {
                    abVar.Q(jSONObject.optInt("video_ctn_type"));
                } else {
                    abVar.Q(2);
                }
                abVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
                abVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
                if (jSONObject.optInt("at_cl_ec", 2) != 1) {
                    z = false;
                }
                abVar.e(z);
                abVar.e(jSONObject.optLong("at_cl_pt", 5000L));
                abVar.f(jSONObject.optLong("at_cl_pct", 5000L));
                abVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
                abVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return abVar;
    }

    public final int as() {
        return this.n;
    }
}
