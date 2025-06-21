package com.sensorsdata.analytics.android.sdk.visual.view;

/* loaded from: classes19.dex */
public class PairingCodeRequestHelper {
    private static final java.lang.String TAG = "SA.ParingCodeHttpRequest";
    private static final java.lang.String URL_VERIFY_SUFFIX = "api/sdk/heat_maps/scanning/pairing_code";

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback val$callback;
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback iApiCallback, android.content.Context context) {
            this.val$callback = iApiCallback;
            this.val$context = context;
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback.JsonCallback, com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onAfter() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onFailure(int i, java.lang.String str) {
            com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback iApiCallback = this.val$callback;
            if (iApiCallback != null) {
                iApiCallback.onFailure(str);
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onResponse(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.TAG, "verifyParingCodeRequest onResponse | response: " + jSONObject.toString());
            if (!jSONObject.optBoolean("is_success")) {
                com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback iApiCallback = this.val$callback;
                if (iApiCallback != null) {
                    iApiCallback.onFailure(jSONObject.optString("error_msg"));
                    return;
                }
                return;
            }
            java.lang.String optString = jSONObject.optString("url");
            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.TAG, "verifyParingCodeRequest onResponse | url: " + optString);
            if (!android.text.TextUtils.isEmpty(optString)) {
                com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.handleSchemeUrl((android.app.Activity) this.val$context, new android.content.Intent().setData(android.net.Uri.parse(optString)));
            }
            com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback iApiCallback2 = this.val$callback;
            if (iApiCallback2 != null) {
                iApiCallback2.onSuccess();
            }
        }
    }

    public interface IApiCallback {
        void onFailure(java.lang.String str);

        void onSuccess();
    }

    public void verifyPairingCodeRequest(android.content.Context context, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback iApiCallback) {
        try {
            if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl())) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "verifyParingCodeRequest | server url is null and return");
                return;
            }
            android.net.Uri parse = android.net.Uri.parse(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl());
            android.net.Uri.Builder builder = new android.net.Uri.Builder();
            builder.scheme(parse.getScheme()).encodedAuthority(parse.getAuthority());
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("pairing_code", str);
            java.util.HashMap hashMap2 = new java.util.HashMap();
            hashMap2.put("sensorsdata-project", parse.getQueryParameter("project"));
            new com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET, builder.appendEncodedPath(URL_VERIFY_SUFFIX).toString()).params(hashMap).header(hashMap2).callback(new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.AnonymousClass1(iApiCallback, context)).execute();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
