package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATCustomAdSlotBuilder extends com.bytedance.sdk.openadsdk.AdSlot.Builder {
    private final java.lang.String a = getClass().getSimpleName();

    private TTATCustomAdSlotBuilder() {
    }

    public TTATCustomAdSlotBuilder(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        setCodeId(str);
        try {
            if (map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ)) {
                int intValue = ((java.lang.Integer) map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ)).intValue();
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    "adLoadSeq: ".concat(java.lang.String.valueOf(intValue));
                }
                setAdloadSeq(intValue);
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            if (map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT)) {
                java.lang.String optString = new org.json.JSONObject((java.lang.String) map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT)).optString("slot_id", "");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                        "primeRit: ".concat(java.lang.String.valueOf(optString));
                    }
                    setPrimeRit(optString);
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
        if (map2 == null || !map2.containsKey(com.anythink.network.toutiao.TTATConst.AD_LOAD_TYPE)) {
            return;
        }
        java.lang.Object obj = map2.get(com.anythink.network.toutiao.TTATConst.AD_LOAD_TYPE);
        if (obj instanceof com.bytedance.sdk.openadsdk.TTAdLoadType) {
            setAdLoadType((com.bytedance.sdk.openadsdk.TTAdLoadType) obj);
        }
    }
}
