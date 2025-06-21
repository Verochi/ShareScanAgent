package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
public class PreviewUtil {
    private static final java.lang.String TAG = "PreviewUtil";

    /* renamed from: com.sensorsdata.sf.ui.utils.PreviewUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.sensorsdata.sf.core.http.internal.HttpCallBack {
        final /* synthetic */ java.lang.Runnable val$failCallback;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.val$failCallback = runnable;
        }

        @Override // com.sensorsdata.sf.core.http.internal.HttpCallBack
        public void onFailure(com.sensorsdata.sf.core.http.internal.HttpCall httpCall, com.sensorsdata.sf.core.http.internal.ResponseBody responseBody) {
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.PreviewUtil.TAG, "showPreview fail " + responseBody.toString());
            java.lang.Runnable runnable = this.val$failCallback;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.sensorsdata.sf.core.http.internal.HttpCallBack
        public void onSuccess(com.sensorsdata.sf.core.http.internal.HttpCall httpCall, com.sensorsdata.sf.core.http.internal.ResponseBody responseBody) {
            try {
                java.lang.String body = responseBody.body();
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.PreviewUtil.TAG, "code = " + responseBody.code + "-- ui = " + body);
                org.json.JSONObject jSONObject = new org.json.JSONObject(body);
                if (this.val$failCallback == null || !android.text.TextUtils.isEmpty(jSONObject.optString("content"))) {
                    new com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder(com.sensorsdata.sf.core.SFContextManger.getInstance().getContext()).campaignStartDebug(body);
                } else {
                    this.val$failCallback.run();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.PreviewUtil.TAG, "showPreview fail, build JSONObject exception!");
                java.lang.Runnable runnable = this.val$failCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public static void showPreview(android.content.Context context, boolean z, java.lang.String str) {
        showPreview(context, z, str, null);
    }

    public static void showPreview(android.content.Context context, boolean z, java.lang.String str, java.lang.Runnable runnable) {
        try {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "showPreview {isTest = " + z + " ,popupId = " + str + com.alipay.sdk.m.u.i.d);
            if (com.sensorsdata.sf.core.SensorsFocusAPI.sharedInstance() instanceof com.sensorsdata.sf.core.SensorsFocusAPIEmpty) {
                if (runnable != null) {
                    runnable.run();
                }
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "SF SDK not ready,return");
            } else {
                if (!z || android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                com.sensorsdata.sf.core.http.HttpRequestHelper.shareInstance().pullWindowInfo(str, new com.sensorsdata.sf.ui.utils.PreviewUtil.AnonymousClass1(runnable));
            }
        } catch (java.lang.Exception e) {
            if (runnable != null) {
                runnable.run();
            }
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
