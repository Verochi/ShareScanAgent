package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class ATBidRequestInfo {
    public static final java.lang.String BIDDING_REQUEST_TIMEOUT_TYPE = "Request Timeout.";
    public static final java.lang.String BIDTOKEN_EMPTY_ERROR_TYPE = "Network BidToken or Custom bid info is Empty.";
    public static final java.lang.String BIDTOKEN_OBTAIN_TIMEOUT_TYPE = "Request Token or Custom bid info Timeout.";
    public static final java.lang.String BID_TYPE_ERROR_TYPE = "cpc bid type";
    public static final java.lang.String INIT_ERROR_TYPE = "Network init error.";
    public static final java.lang.String LESS_THAN_BID_FLOOR_TYPE = "less than bid floor";
    public static final java.lang.String NO_ADAPTER_ERROR_TYPE = "There is no Network Adapter.";
    public static final java.lang.String NO_SUPPORT_BIDDING_TYPE = "This network don't support header bidding in current AT's version.";
    public static final java.lang.String RETURN_PARAMS_ERROR_TYPE = "The parameter is abnormal.";

    public static void fillBaseCommonParams(org.json.JSONObject jSONObject, java.lang.String str, com.anythink.core.d.e eVar, com.anythink.core.common.f.au auVar) {
        if (jSONObject != null) {
            try {
                if (auVar.W() == -1) {
                    jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, str);
                } else {
                    jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, java.lang.String.valueOf(auVar.W()));
                }
                jSONObject.put("ad_source_id", auVar.u());
                jSONObject.put("nw_firm_id", auVar.d());
                jSONObject.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, auVar.ad());
                if (com.anythink.core.common.b.o.a().u()) {
                    jSONObject.put("test", 1);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public abstract org.json.JSONObject toRequestJSONObject();
}
