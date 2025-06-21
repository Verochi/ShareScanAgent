package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class OkHttpTask {
    public static final java.lang.String DEFAULT_HTTP_TASK_KEY = "default_http_task_key";
    private com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback callback;
    private android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private okhttp3.Headers headers;
    private com.aliyun.vod.qupaiokhttp.Method method;
    private okhttp3.OkHttpClient okHttpClient;
    private com.aliyun.vod.qupaiokhttp.RequestParams params;
    private java.lang.String requestKey;
    private java.lang.String url;

    /* renamed from: com.aliyun.vod.qupaiokhttp.OkHttpTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ boolean val$done;
        final /* synthetic */ long val$networkSpeed;
        final /* synthetic */ int val$progress;

        public AnonymousClass1(int i, long j, boolean z) {
            this.val$progress = i;
            this.val$networkSpeed = j;
            this.val$done = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.vod.qupaiokhttp.OkHttpTask.this.callback != null) {
                com.aliyun.vod.qupaiokhttp.OkHttpTask.this.callback.onProgress(this.val$progress, this.val$networkSpeed, this.val$done);
            }
        }
    }

    /* renamed from: com.aliyun.vod.qupaiokhttp.OkHttpTask$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.qupaiokhttp.ResponseData val$responseData;

        public AnonymousClass2(com.aliyun.vod.qupaiokhttp.ResponseData responseData) {
            this.val$responseData = responseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.vod.qupaiokhttp.OkHttpTask.this.onPostExecute(this.val$responseData);
        }
    }

    /* renamed from: com.aliyun.vod.qupaiokhttp.OkHttpTask$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$vod$qupaiokhttp$Method;

        static {
            int[] iArr = new int[com.aliyun.vod.qupaiokhttp.Method.values().length];
            $SwitchMap$com$aliyun$vod$qupaiokhttp$Method = iArr;
            try {
                iArr[com.aliyun.vod.qupaiokhttp.Method.GET.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[com.aliyun.vod.qupaiokhttp.Method.DELETE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[com.aliyun.vod.qupaiokhttp.Method.HEAD.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[com.aliyun.vod.qupaiokhttp.Method.POST.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[com.aliyun.vod.qupaiokhttp.Method.PUT.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$aliyun$vod$qupaiokhttp$Method[com.aliyun.vod.qupaiokhttp.Method.PATCH.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public static class MyOkHttpCallBack implements okhttp3.Callback, com.aliyun.vod.qupaiokhttp.ProgressCallback {
        private java.lang.ref.WeakReference<com.aliyun.vod.qupaiokhttp.OkHttpTask> ref;

        public MyOkHttpCallBack(com.aliyun.vod.qupaiokhttp.OkHttpTask okHttpTask) {
            this.ref = new java.lang.ref.WeakReference<>(okHttpTask);
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            com.aliyun.vod.qupaiokhttp.OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.onFailure(call, iOException);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            com.aliyun.vod.qupaiokhttp.OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.onResponse(call, response);
            }
        }

        @Override // com.aliyun.vod.qupaiokhttp.ProgressCallback
        public void updateProgress(int i, long j, boolean z) {
            com.aliyun.vod.qupaiokhttp.OkHttpTask okHttpTask = this.ref.get();
            if (okHttpTask != null) {
                okHttpTask.updateProgress(i, j, z);
            }
        }
    }

    public OkHttpTask(com.aliyun.vod.qupaiokhttp.Method method, java.lang.String str, com.aliyun.vod.qupaiokhttp.RequestParams requestParams, okhttp3.OkHttpClient.Builder builder, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        this.method = method;
        this.url = str;
        this.callback = baseHttpRequestCallback;
        if (requestParams == null) {
            this.params = new com.aliyun.vod.qupaiokhttp.RequestParams();
        } else {
            this.params = requestParams;
        }
        java.lang.String httpTaskKey = this.params.getHttpTaskKey();
        this.requestKey = httpTaskKey;
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(httpTaskKey)) {
            this.requestKey = "default_http_task_key";
        }
        com.aliyun.vod.qupaiokhttp.HttpTaskHandler.getInstance().addTask(this.requestKey, this);
        this.okHttpClient = builder.build();
    }

    private void handlerResponse(com.aliyun.vod.qupaiokhttp.ResponseData responseData, okhttp3.Response response) {
        java.lang.String str;
        if (response != null) {
            responseData.setResponseNull(false);
            responseData.setCode(response.code());
            responseData.setMessage(response.message());
            responseData.setSuccess(response.isSuccessful());
            try {
                str = response.body().string();
            } catch (java.io.IOException e) {
                com.aliyun.vod.qupaiokhttp.ILogger.e(e);
                str = "";
            }
            responseData.setResponse(str);
            responseData.setHeaders(response.headers());
        } else {
            responseData.setResponseNull(true);
            responseData.setCode(1003);
            if (responseData.isTimeout()) {
                responseData.setMessage("request timeout");
            } else {
                responseData.setMessage("http exception");
            }
        }
        responseData.setHttpResponse(response);
        this.handler.post(new com.aliyun.vod.qupaiokhttp.OkHttpTask.AnonymousClass2(responseData));
    }

    private void parseResponseBody(com.aliyun.vod.qupaiokhttp.ResponseData responseData, com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback) {
        if (baseHttpRequestCallback == null) {
            return;
        }
        java.lang.String response = responseData.getResponse();
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(response)) {
            com.aliyun.vod.qupaiokhttp.ILogger.e("response empty!!!", new java.lang.Object[0]);
        }
        java.lang.reflect.Type type = baseHttpRequestCallback.type;
        if (type != java.lang.String.class && type != java.lang.Object.class) {
            baseHttpRequestCallback.onFailure(1002, "Data parse exception");
        } else {
            baseHttpRequestCallback.onSuccess(responseData.getHeaders(), response);
            baseHttpRequestCallback.onSuccess(response);
        }
    }

    public void execute() {
        okhttp3.Headers.Builder builder = this.params.headers;
        if (builder != null) {
            this.headers = builder.build();
        }
        com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback = this.callback;
        if (baseHttpRequestCallback != null) {
            baseHttpRequestCallback.onStart();
        }
        try {
            run();
        } catch (java.lang.Exception e) {
            com.aliyun.vod.qupaiokhttp.ILogger.e(e);
        }
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
        com.aliyun.vod.qupaiokhttp.ResponseData responseData = new com.aliyun.vod.qupaiokhttp.ResponseData();
        if (iOException instanceof java.net.SocketTimeoutException) {
            responseData.setTimeout(true);
        } else if ((iOException instanceof java.io.InterruptedIOException) && android.text.TextUtils.equals(iOException.getMessage(), "timeout")) {
            responseData.setTimeout(true);
        }
        handlerResponse(responseData, null);
    }

    public void onPostExecute(com.aliyun.vod.qupaiokhttp.ResponseData responseData) {
        okhttp3.Headers headers;
        com.aliyun.vod.qupaiokhttp.OkHttpCallManager.getInstance().removeCall(this.url);
        com.aliyun.vod.qupaiokhttp.HttpTaskHandler.getInstance().removeTask(this.requestKey);
        com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback = this.callback;
        if (baseHttpRequestCallback != null) {
            baseHttpRequestCallback.setResponseHeaders(responseData.getHeaders());
            this.callback.onResponse(responseData.getHttpResponse(), responseData.getResponse(), responseData.getHeaders());
            this.callback.onResponse(responseData.getResponse(), responseData.getHeaders());
        }
        int code = responseData.getCode();
        java.lang.String message = responseData.getMessage();
        if (responseData.isResponseNull()) {
            if (com.aliyun.vod.qupaiokhttp.Constants.DEBUG) {
                com.aliyun.vod.qupaiokhttp.ILogger.d("url=" + this.url + "\n response failure code=" + code + " msg=" + message, new java.lang.Object[0]);
            }
            com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback2 = this.callback;
            if (baseHttpRequestCallback2 != null) {
                baseHttpRequestCallback2.onFailure(code, message);
            }
        } else if (responseData.isSuccess()) {
            responseData.getResponse();
            if (com.aliyun.vod.qupaiokhttp.Constants.DEBUG && (headers = responseData.getHeaders()) != null) {
                headers.toString();
            }
            parseResponseBody(responseData, this.callback);
        } else {
            if (com.aliyun.vod.qupaiokhttp.Constants.DEBUG) {
                com.aliyun.vod.qupaiokhttp.ILogger.d("url=" + this.url + "\n response failure code=" + code + " msg=" + message, new java.lang.Object[0]);
            }
            com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback3 = this.callback;
            if (baseHttpRequestCallback3 != null) {
                baseHttpRequestCallback3.onFailure(code, message);
            }
        }
        com.aliyun.vod.qupaiokhttp.BaseHttpRequestCallback baseHttpRequestCallback4 = this.callback;
        if (baseHttpRequestCallback4 != null) {
            baseHttpRequestCallback4.onFinish();
        }
    }

    public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
        handlerResponse(new com.aliyun.vod.qupaiokhttp.ResponseData(), response);
    }

    public void run() throws java.lang.Exception {
        java.lang.String str = this.url;
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        com.aliyun.vod.qupaiokhttp.OkHttpTask.MyOkHttpCallBack myOkHttpCallBack = new com.aliyun.vod.qupaiokhttp.OkHttpTask.MyOkHttpCallBack(this);
        switch (com.aliyun.vod.qupaiokhttp.OkHttpTask.AnonymousClass3.$SwitchMap$com$aliyun$vod$qupaiokhttp$Method[this.method.ordinal()]) {
            case 1:
                this.url = com.aliyun.vod.qupaiokhttp.Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.get();
                break;
            case 2:
                this.url = com.aliyun.vod.qupaiokhttp.Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.delete();
                break;
            case 3:
                this.url = com.aliyun.vod.qupaiokhttp.Utils.getFullUrl(this.url, this.params.getFormParams(), this.params.isUrlEncoder());
                builder.head();
                break;
            case 4:
                okhttp3.RequestBody requestBody = this.params.getRequestBody();
                if (requestBody != null) {
                    builder.post(new com.aliyun.vod.qupaiokhttp.ProgressRequestBody(requestBody, myOkHttpCallBack));
                    break;
                }
                break;
            case 5:
                okhttp3.RequestBody requestBody2 = this.params.getRequestBody();
                if (requestBody2 != null) {
                    builder.put(new com.aliyun.vod.qupaiokhttp.ProgressRequestBody(requestBody2, myOkHttpCallBack));
                    break;
                }
                break;
            case 6:
                okhttp3.RequestBody requestBody3 = this.params.getRequestBody();
                if (requestBody3 != null) {
                    builder.put(new com.aliyun.vod.qupaiokhttp.ProgressRequestBody(requestBody3, myOkHttpCallBack));
                    break;
                }
                break;
        }
        okhttp3.CacheControl cacheControl = this.params.cacheControl;
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }
        builder.url(this.url).tag(str).headers(this.headers);
        okhttp3.Request build = builder.build();
        if (com.aliyun.vod.qupaiokhttp.Constants.DEBUG) {
            com.aliyun.vod.qupaiokhttp.ILogger.d("url=" + str + "?" + this.params.toString() + "\n header=" + this.headers.toString(), new java.lang.Object[0]);
        }
        okhttp3.Call newCall = this.okHttpClient.newCall(build);
        com.aliyun.vod.qupaiokhttp.OkHttpCallManager.getInstance().addCall(this.url, newCall);
        newCall.enqueue(myOkHttpCallBack);
    }

    public void updateProgress(int i, long j, boolean z) {
        this.handler.post(new com.aliyun.vod.qupaiokhttp.OkHttpTask.AnonymousClass1(i, j, z));
    }
}
