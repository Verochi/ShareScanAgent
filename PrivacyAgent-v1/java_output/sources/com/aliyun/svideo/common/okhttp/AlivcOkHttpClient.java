package com.aliyun.svideo.common.okhttp;

/* loaded from: classes.dex */
public class AlivcOkHttpClient {
    private static com.aliyun.svideo.common.okhttp.AlivcOkHttpClient alivcOkHttpClient;
    private okhttp3.OkHttpClient okHttpClient;
    private okhttp3.OkHttpClient.Builder okHttpBuilder = new okhttp3.OkHttpClient.Builder().addNetworkInterceptor(new com.aliyun.svideo.common.okhttp.interceptor.LoggingIntcepetor());
    private android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());

    public interface HttpCallBack {
        void onError(okhttp3.Request request, java.io.IOException iOException);

        void onSuccess(okhttp3.Request request, java.lang.String str);
    }

    public class StringCallBack implements okhttp3.Callback {
        private com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.HttpCallBack httpCallBack;
        private okhttp3.Request request;

        /* renamed from: com.aliyun.svideo.common.okhttp.AlivcOkHttpClient$StringCallBack$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.IOException val$fe;

            public AnonymousClass1(java.io.IOException iOException) {
                this.val$fe = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.httpCallBack.onError(com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.request, this.val$fe);
            }
        }

        /* renamed from: com.aliyun.svideo.common.okhttp.AlivcOkHttpClient$StringCallBack$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String val$result;

            public AnonymousClass2(java.lang.String str) {
                this.val$result = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.httpCallBack.onSuccess(com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.request, this.val$result);
            }
        }

        /* renamed from: com.aliyun.svideo.common.okhttp.AlivcOkHttpClient$StringCallBack$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.httpCallBack.onError(com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.this.request, new java.io.IOException("json error"));
            }
        }

        public StringCallBack(okhttp3.Request request, com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.HttpCallBack httpCallBack) {
            this.request = request;
            this.httpCallBack = httpCallBack;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            if (this.httpCallBack != null) {
                com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.this.handler.post(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.AnonymousClass1(iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            java.lang.String string = response.body().string();
            try {
                if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(new org.json.JSONObject(string).getString("code"))) {
                    if (this.httpCallBack != null) {
                        com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.this.handler.post(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.AnonymousClass2(string));
                    } else {
                        com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.this.handler.post(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack.AnonymousClass3());
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private AlivcOkHttpClient() {
        build();
    }

    private void build() {
        okhttp3.OkHttpClient.Builder builder = this.okHttpBuilder;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        builder.connectTimeout(10L, timeUnit);
        this.okHttpBuilder.writeTimeout(10L, timeUnit);
        this.okHttpBuilder.readTimeout(10L, timeUnit);
        this.okHttpClient = this.okHttpBuilder.build();
    }

    public static com.aliyun.svideo.common.okhttp.AlivcOkHttpClient getInstance() {
        if (alivcOkHttpClient == null) {
            synchronized (com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.class) {
                if (alivcOkHttpClient == null) {
                    alivcOkHttpClient = new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient();
                }
            }
        }
        return alivcOkHttpClient;
    }

    public okhttp3.FormBody formBody(java.util.Map<java.lang.String, java.lang.String> map) {
        okhttp3.FormBody.Builder builder = new okhttp3.FormBody.Builder();
        if (map != null) {
            java.util.Set<java.lang.String> keySet = map.keySet();
            if (!keySet.isEmpty()) {
                for (java.lang.String str : keySet) {
                    java.lang.String str2 = map.get(str);
                    if (str2 != null) {
                        builder.add(str, str2);
                    }
                }
            }
        }
        return builder.build();
    }

    public void get(java.lang.String str, com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.HttpCallBack httpCallBack) {
        okhttp3.Request build = new okhttp3.Request.Builder().url(str).build();
        this.okHttpClient.newCall(build).enqueue(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack(build, httpCallBack));
    }

    public void get(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap, com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.HttpCallBack httpCallBack) {
        okhttp3.Request build = new okhttp3.Request.Builder().url(urlWithParam(str, hashMap)).build();
        this.okHttpClient.newCall(build).enqueue(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack(build, httpCallBack));
    }

    public void post(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.HttpCallBack httpCallBack) {
        okhttp3.Request build = new okhttp3.Request.Builder().url(str).post(formBody(map)).build();
        this.okHttpClient.newCall(build).enqueue(new com.aliyun.svideo.common.okhttp.AlivcOkHttpClient.StringCallBack(build, httpCallBack));
    }

    public java.lang.String urlWithParam(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return str;
        }
        java.util.Set<java.lang.String> keySet = map.keySet();
        if (keySet.isEmpty()) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (java.lang.String str2 : keySet) {
            if (z) {
                sb.append("&");
            }
            sb.append(str2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(map.get(str2));
            z = true;
        }
        return str + "?" + sb.toString();
    }
}
