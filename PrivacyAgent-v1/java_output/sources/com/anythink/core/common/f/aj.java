package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class aj extends com.anythink.core.common.f.n {
    private int n;
    private int o;
    private int p;

    private void X(int i) {
        this.o = i;
    }

    private void Y(int i) {
        this.n = i;
    }

    private void Z(int i) {
        this.p = i;
    }

    public static com.anythink.core.common.f.aj i(java.lang.String str) {
        int i;
        com.anythink.core.common.f.aj ajVar = new com.anythink.core.common.f.aj();
        if (android.text.TextUtils.isEmpty(str)) {
            return ajVar;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            ajVar.s(jSONObject.optInt("f_t"));
            int optInt = jSONObject.optInt("v_c");
            if (optInt == 1) {
                optInt = 0;
            } else if (optInt == 2) {
                optInt = 1;
            }
            ajVar.t(optInt);
            ajVar.u(jSONObject.optInt("s_b_t"));
            if (jSONObject.has("s_b_d")) {
                ajVar.v(jSONObject.optInt("s_b_d"));
            }
            int optInt2 = jSONObject.optInt("e_c_a");
            if (optInt2 == 1) {
                optInt2 = 0;
            } else if (optInt2 == 2) {
                optInt2 = 1;
            } else if (optInt2 == 3) {
                optInt2 = 2;
            }
            ajVar.w(optInt2);
            int optInt3 = jSONObject.optInt("ak_cfm");
            if (optInt3 == 1) {
                optInt3 = 0;
            } else if (optInt3 == 2) {
                optInt3 = 1;
            }
            ajVar.o(optInt3);
            ajVar.n(jSONObject.optInt("m_t"));
            int optInt4 = jSONObject.optInt(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_MODE);
            if (optInt4 == 1) {
                optInt4 = 0;
            } else if (optInt4 == 2) {
                optInt4 = 1;
            }
            ajVar.n = optInt4;
            ajVar.e(jSONObject.optInt("ipua"));
            ajVar.f(jSONObject.optInt("clua"));
            ajVar.m(jSONObject.optInt("dp_cm"));
            ajVar.o = jSONObject.optInt("l_o_num");
            ajVar.l(jSONObject.optInt("ld_t"));
            ajVar.z(jSONObject.optInt("ec_r"));
            ajVar.A(jSONObject.optInt("ec_s_t"));
            ajVar.B(jSONObject.optInt("ec_l_t"));
            ajVar.a(jSONObject.optLong("or_t"));
            ajVar.g(jSONObject.optInt("rv_fail_reward"));
            ajVar.h(jSONObject.optInt("cl_sz"));
            ajVar.k(jSONObject.optInt("si_fit"));
            if (jSONObject.has("at_cl_sw")) {
                ajVar.C(jSONObject.optInt("at_cl_sw"));
            }
            if (jSONObject.has("at_ct_ti")) {
                ajVar.D(jSONObject.optInt("at_ct_ti"));
            }
            if (jSONObject.has("int_cl_sw")) {
                ajVar.E(jSONObject.optInt("int_cl_sw"));
            }
            if (jSONObject.has("int_cl_ti")) {
                ajVar.F(jSONObject.optInt("int_cl_ti"));
            }
            if (jSONObject.has("sh_ec")) {
                ajVar.G(jSONObject.optInt("sh_ec"));
            }
            if (jSONObject.has("ap_arpt")) {
                ajVar.H(jSONObject.optInt("ap_arpt"));
            }
            if (jSONObject.has("ap_pasbl")) {
                ajVar.I(jSONObject.optInt("ap_pasbl"));
            }
            if (jSONObject.has("inter_type")) {
                ajVar.f(jSONObject.optString("inter_type"));
            }
            if (jSONObject.has("shk_sw")) {
                ajVar.J(jSONObject.optInt("shk_sw"));
            }
            if (jSONObject.has("shk_strength_and")) {
                ajVar.K(jSONObject.optInt("shk_strength_and"));
            }
            if (jSONObject.has("shk_time")) {
                ajVar.d(jSONObject.optLong("shk_time"));
            }
            if (jSONObject.has("click_cache_time")) {
                ajVar.L(jSONObject.optInt("click_cache_time"));
            }
            if (jSONObject.has("click_nt_sw")) {
                ajVar.M(jSONObject.optInt("click_nt_sw"));
            }
            if (jSONObject.has("ft_cl_sz")) {
                ajVar.i(jSONObject.optInt("ft_cl_sz"));
            } else {
                ajVar.i(1);
            }
            if (jSONObject.has("sh_cl_itp")) {
                ajVar.j(jSONObject.optInt("sh_cl_itp"));
            } else {
                ajVar.j(2);
            }
            ajVar.N(jSONObject.optInt("shm_t", -1));
            if (jSONObject.has("ready_rate")) {
                ajVar.O(jSONObject.optInt("ready_rate"));
            } else {
                ajVar.O(100);
            }
            if (jSONObject.has("rsdl_rate")) {
                ajVar.P(jSONObject.optInt("rsdl_rate"));
            } else {
                ajVar.P(0);
            }
            if (jSONObject.has("video_ctn_type")) {
                ajVar.Q(jSONObject.optInt("video_ctn_type"));
            } else {
                ajVar.Q(2);
            }
            if (jSONObject.has("preload_offer_html")) {
                ajVar.a(jSONObject.optInt("preload_offer_html") == 1);
            } else {
                ajVar.a(true);
            }
            if (jSONObject.has("re_monitor")) {
                ajVar.b(jSONObject.optInt("re_monitor") == 1);
                i = 0;
            } else {
                i = 0;
                ajVar.b(false);
            }
            ajVar.p = jSONObject.optInt(com.anythink.core.common.j.aq, i);
            ajVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
            ajVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
            ajVar.e(jSONObject.optInt("at_cl_ec", 2) == 1);
            ajVar.e(jSONObject.optLong("at_cl_pt", 5000L));
            ajVar.f(jSONObject.optLong("at_cl_pct", 5000L));
            ajVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
            ajVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
            ajVar.i(jSONObject.optLong("or_img_t", 5000L));
            ajVar.S(jSONObject.optInt("animate_type", -1));
            ajVar.R(jSONObject.optInt("render_wv_ld", 2));
            ajVar.T(jSONObject.optInt("cl_invalid_sw", 2));
            ajVar.U(jSONObject.optInt("stc_sw", 1));
            ajVar.V(jSONObject.optInt("close_button_m", 0));
            ajVar.W(jSONObject.optInt("cgf_sw", 1));
            ajVar.j(jSONObject.optLong("cgf_t", 0L));
            ajVar.g(jSONObject.optString("cgf_list", ""));
            ajVar.h(jSONObject.optString("qa_po", ""));
            ajVar.b(jSONObject.optInt("lp_pop", 2));
            try {
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("shk_obj");
                if (optJSONObject != null) {
                    ajVar.a(optJSONObject.optInt("shk_type", 1));
                    ajVar.a(optJSONObject.optString("shk_icon", ""));
                    ajVar.b(optJSONObject.optString("shk_text_l", ""));
                    ajVar.c(optJSONObject.optString("shk_text_m", ""));
                    ajVar.d(optJSONObject.optString("shk_text_s", ""));
                }
            } catch (java.lang.Throwable unused) {
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return ajVar;
    }

    public final int as() {
        return this.o;
    }

    public final int at() {
        return this.n;
    }

    public final int au() {
        return this.p;
    }
}
