package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class o {
    public static final java.lang.String a = "anythink_bidding";

    public static void a(com.anythink.core.common.f.h hVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (!com.anythink.core.api.ATSDK.isNetworkLogDebug() || hVar == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            if (hVar.d() == 2) {
                jSONObject.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "shared placement");
            }
            if (hVar.D() != 0) {
                jSONObject.put("defaultAdSourceType", hVar.D());
            }
            jSONObject.put(com.anythink.expressad.videocommon.e.b.v, hVar.ac());
            jSONObject.put("adType", hVar.af());
            jSONObject.put("mixedFormatAdType", hVar.Q());
            jSONObject.put("action", str);
            jSONObject.put(com.alipay.sdk.m.x.d.w, hVar.K());
            jSONObject.put("result", str2);
            jSONObject.put("segmentId", hVar.N());
            jSONObject.put("adSourceId", hVar.C());
            jSONObject.put(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, hVar.E());
            jSONObject.put("networkType", hVar.M());
            jSONObject.put("networkName", hVar.Z());
            jSONObject.put("networkVersion", hVar.u);
            jSONObject.put("networkUnit", hVar.L());
            if (hVar.A() == 1) {
                java.lang.String a2 = com.anythink.core.common.o.h.a(hVar.f());
                if (android.text.TextUtils.isEmpty(a2)) {
                    jSONObject.put("isHB", 1);
                } else {
                    jSONObject.put("isHB", "1 (" + a2 + ")");
                }
            } else {
                jSONObject.put("isHB", 0);
            }
            jSONObject.put("msg", str3);
            jSONObject.put("hourly_frequency", hVar.G());
            jSONObject.put("daily_frequency", hVar.H());
            jSONObject.put("network_list", hVar.I());
            jSONObject.put("request_network_num", hVar.J());
            jSONObject.put("handle_class", hVar.n());
        } catch (java.lang.Throwable unused) {
        }
        a("network", jSONObject.toString());
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.h hVar, java.lang.String str2, com.anythink.core.common.f.au auVar, int i, int i2) {
        a(str, hVar, str2, auVar, i, i2, null);
    }

    public static void a(java.lang.String str, com.anythink.core.common.f.h hVar, java.lang.String str2, com.anythink.core.common.f.au auVar, int i, int i2, java.util.List<java.lang.String> list) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("reason", str2);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str);
                jSONObject.put("adtype", hVar.af());
                jSONObject.put("adsourceId", auVar.u());
                jSONObject.put("networkFirmId", auVar.d());
                jSONObject.put("content", hVar.L());
                jSONObject.put("hourly_frequency", i);
                jSONObject.put("hourly_limit", auVar.g());
                jSONObject.put("daily_frequency", i2);
                jSONObject.put("daily_limit", auVar.f());
                jSONObject.put("pacing_limit", auVar.t());
                jSONObject.put("request_fail_interval", auVar.H());
                jSONObject.put("filter_source_ids", list != null ? list : "");
                a("anythink_network", jSONObject.toString(), true);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            a("anythink_".concat(java.lang.String.valueOf(str)), str2, false);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.core.common.f.au auVar) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("action", com.anythink.core.common.b.h.m.B);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put("adsourceId", auVar.u());
                jSONObject.put("networkFirmId", auVar.d());
                jSONObject.put("content", auVar.h());
                jSONObject.put("msg", auVar.A());
                a(a, jSONObject.toString(), android.text.TextUtils.equals(com.anythink.core.common.b.h.m.m, str));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("action", com.anythink.core.common.b.h.m.C);
                jSONObject.put("result", str);
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str2);
                jSONObject.put("adtype", str3);
                jSONObject.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, str4);
                a("anythink_network", jSONObject.toString(), android.text.TextUtils.equals(com.anythink.core.common.b.h.m.m, str));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String str6;
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            str2.hashCode();
            switch (str2) {
                case "0":
                    str6 = com.anythink.core.common.b.h.m.r;
                    break;
                case "1":
                    str6 = com.anythink.core.common.b.h.m.q;
                    break;
                case "2":
                    str6 = com.anythink.core.common.b.h.m.o;
                    break;
                case "3":
                    str6 = com.anythink.core.common.b.h.m.p;
                    break;
                case "4":
                    str6 = com.anythink.core.common.b.h.m.f162s;
                    break;
                default:
                    str6 = "";
                    break;
            }
            a(str, str6, str3, str4, str5, false);
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z) {
        java.lang.String str6;
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str);
                jSONObject.put("adtype", str2);
                jSONObject.put("api", str3);
                jSONObject.put("result", str4);
                jSONObject.put("reason", str5);
                if (z) {
                    if (!android.text.TextUtils.isEmpty(str)) {
                        java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(str);
                        if (b.size() > 0) {
                            java.lang.String str7 = "";
                            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : b.entrySet()) {
                                str7 = str7 + "key=" + entry.getKey() + ",value=" + entry.getValue().toString() + com.alipay.sdk.m.u.i.b;
                            }
                            str6 = "[" + str7 + "]";
                            jSONObject.put("extra", str6);
                        }
                    }
                    str6 = "";
                    jSONObject.put("extra", str6);
                }
                new java.lang.StringBuilder("anythink_network").append(com.anythink.core.common.b.o.a().v() ? "(DebuggerMode)" : "");
                jSONObject.toString();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String property = java.lang.System.getProperty("line.separator");
        try {
            if (str2.startsWith("{")) {
                str2 = new org.json.JSONObject(str2).toString(4);
            } else if (str2.startsWith("[")) {
                str2 = new org.json.JSONArray(str2).toString(4);
            }
        } catch (org.json.JSONException unused) {
        }
        java.lang.String str3 = "╔═══════════════════════════════════════════════════════════════════════════════════════";
        for (java.lang.String str4 : str2.split(property)) {
            str3 = (str3 + "\n") + "║ " + str4;
        }
        java.lang.String str5 = str3 + "\n╚═══════════════════════════════════════════════════════════════════════════════════════";
        if (z) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(com.anythink.core.common.b.o.a().v() ? "(DebuggerMode)" : "");
            " \n".concat(java.lang.String.valueOf(str5));
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append(com.anythink.core.common.b.o.a().v() ? "(DebuggerMode)" : "");
        " \n".concat(java.lang.String.valueOf(str5));
    }

    public static void b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(str, str2, str3, str4, str5, false);
    }
}
