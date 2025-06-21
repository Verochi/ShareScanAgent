package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
public abstract class HttpCallback<T> {
    static android.os.Handler sMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.HttpCallback$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$errorMessage;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.network.RealResponse val$response;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse, java.lang.String str) {
            this.val$response = realResponse;
            this.val$errorMessage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.network.HttpCallback.this.onFailure(this.val$response.code, this.val$errorMessage);
            com.sensorsdata.analytics.android.sdk.network.HttpCallback.this.onAfter();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.HttpCallback$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object val$obj;

        public AnonymousClass2(java.lang.Object obj) {
            this.val$obj = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.network.HttpCallback.this.onResponse(this.val$obj);
            com.sensorsdata.analytics.android.sdk.network.HttpCallback.this.onAfter();
        }
    }

    public static abstract class JsonCallback extends com.sensorsdata.analytics.android.sdk.network.HttpCallback<org.json.JSONObject> {
        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public void onAfter() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public org.json.JSONObject onParseResponse(java.lang.String str) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                return new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }
    }

    public static abstract class StringCallback extends com.sensorsdata.analytics.android.sdk.network.HttpCallback<java.lang.String> {
        @Override // com.sensorsdata.analytics.android.sdk.network.HttpCallback
        public java.lang.String onParseResponse(java.lang.String str) {
            return str;
        }
    }

    public abstract void onAfter();

    public void onError(com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse) {
        java.lang.String obj;
        if (!android.text.TextUtils.isEmpty(realResponse.result)) {
            obj = realResponse.result;
        } else if (android.text.TextUtils.isEmpty(realResponse.errorMsg)) {
            java.lang.Exception exc = realResponse.exception;
            obj = exc != null ? exc.toString() : "unknown error";
        } else {
            obj = realResponse.errorMsg;
        }
        sMainHandler.post(new com.sensorsdata.analytics.android.sdk.network.HttpCallback.AnonymousClass1(realResponse, obj));
    }

    public abstract void onFailure(int i, java.lang.String str);

    public abstract T onParseResponse(java.lang.String str);

    public abstract void onResponse(T t);

    public void onSuccess(com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse) {
        sMainHandler.post(new com.sensorsdata.analytics.android.sdk.network.HttpCallback.AnonymousClass2(onParseResponse(realResponse.result)));
    }
}
