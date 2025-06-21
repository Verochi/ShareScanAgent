package com.tanx.exposer.tanxc_do.tanxc_try;

/* loaded from: classes19.dex */
public class tanxc_for {
    public static int a = 9004;

    public static int tanxc_do() {
        return a;
    }

    public static void tanxc_do(int i) {
        a = i;
    }

    public static void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, int i, java.lang.String str, boolean z, java.lang.String str2) {
        if (tanxc_ifVar == null || tanxc_ifVar.tanxc_int() == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("exposeRequestFail", "wrapper is null");
            return;
        }
        java.lang.String str3 = tanxc_ifVar.tanxc_int() == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_request_fail" : tanxc_ifVar.tanxc_int() == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_request_fail" : "tanx_interact_request_fail";
        if (tanxc_ifVar.tanxc_goto() == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str3, "AdMonitorExtraParams is null");
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar.tanxc_goto());
        tanxc_do.put(com.alipay.sdk.m.l.c.f, tanxc_ifVar.tanxc_try());
        tanxc_do.put("url_hash", tanxc_ifVar.tanxc_new());
        tanxc_do.put("isRetry", java.lang.String.valueOf(z));
        tanxc_do.put("retryType", str2);
        tanxc_do.put("url", tanxc_ifVar.tanxc_if());
        tanxc_do.put("errorCode", java.lang.String.valueOf(i));
        tanxc_do.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, str);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str3, tanxc_do, false);
    }

    public static void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar, boolean z, java.lang.String str) {
        if (tanxc_ifVar == null || tanxc_ifVar.tanxc_int() == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("exposeRequestSuccess", "wrapper is null");
            return;
        }
        java.lang.String str2 = tanxc_ifVar.tanxc_int() == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_request_success" : tanxc_ifVar.tanxc_int() == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_request_success" : "tanx_interact_request_success";
        if (tanxc_ifVar.tanxc_goto() == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str2, "AdMonitorExtraParams is null");
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar.tanxc_goto());
        tanxc_do.put(com.alipay.sdk.m.l.c.f, tanxc_ifVar.tanxc_try());
        tanxc_do.put("url_hash", tanxc_ifVar.tanxc_new());
        tanxc_do.put("isRetry", java.lang.String.valueOf(z));
        tanxc_do.put("retryType", str);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str2, tanxc_do, false);
    }

    public static void tanxc_do(com.tanx.exposer.tanxc_if tanxc_ifVar, com.tanx.exposer.achieve.AdMonitorType adMonitorType) {
        java.lang.String str = adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_invoke_success" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_invoke_success" : "tanx_interact_invoke_success";
        if (tanxc_ifVar == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str, "AdMonitorExtraParams is null");
        } else {
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str, com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar), true);
        }
    }

    public static void tanxc_do(com.tanx.exposer.tanxc_if tanxc_ifVar, com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str) {
        java.lang.String str2 = adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_invoke_error" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_invoke_error" : "tanx_interact_invoke_error";
        if (tanxc_ifVar == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str2, "AdMonitorExtraParams is null");
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar);
        tanxc_do.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, str);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str2, tanxc_do, true);
    }

    public static void tanxc_do(com.tanx.exposer.tanxc_if tanxc_ifVar, com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_request" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_request" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION ? "tanx_interact_deduplication_request" : "tanx_interact_request";
        if (tanxc_ifVar == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str3, "AdMonitorExtraParams is null");
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar);
        tanxc_do.put(com.alipay.sdk.m.l.c.f, str);
        tanxc_do.put("url_hash", str2);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str3, tanxc_do, true);
    }

    public static void tanxc_if(com.tanx.exposer.tanxc_if tanxc_ifVar, com.tanx.exposer.achieve.AdMonitorType adMonitorType) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("tanx_request_duplicated_");
        sb.append(adMonitorType != null ? adMonitorType.name() : "");
        java.lang.String sb2 = sb.toString();
        if (tanxc_ifVar == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(sb2, "AdMonitorExtraParams is null");
        } else {
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(sb2, com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar), true);
        }
    }

    public static void tanxc_if(com.tanx.exposer.tanxc_if tanxc_ifVar, com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str) {
        java.lang.String str2 = adMonitorType == com.tanx.exposer.achieve.AdMonitorType.CLICK ? "tanx_click_invalid_url" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.EXPOSE ? "tanx_expose_invalid_url" : adMonitorType == com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION ? "tanx_interact_deduplication_invalid_url" : "tanx_interact_invalid_url";
        if (tanxc_ifVar == null) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do(str2, "AdMonitorExtraParams is null");
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> tanxc_do = com.tanx.exposer.tanxc_if.tanxc_if.tanxc_do(tanxc_ifVar);
        tanxc_do.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, str);
        com.tanx.exposer.tanxc_do.tanxc_try.tanxc_if.tanxc_do(str2, tanxc_do, true);
    }
}
