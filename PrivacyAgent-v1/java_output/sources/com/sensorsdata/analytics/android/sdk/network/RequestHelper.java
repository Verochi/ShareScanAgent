package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
public class RequestHelper {
    private boolean isRedirected;

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.RequestHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.network.HttpCallback val$callBack;
        final /* synthetic */ java.util.Map val$headerMap;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.network.HttpConfig val$httpConfig;
        final /* synthetic */ java.util.Map val$paramsMap;
        final /* synthetic */ int val$requestCount;
        final /* synthetic */ int val$retryCount;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.lang.String str, java.util.Map map, java.util.Map map2, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback, int i, int i2) {
            this.val$httpConfig = httpConfig;
            this.val$url = str;
            this.val$paramsMap = map;
            this.val$headerMap = map2;
            this.val$callBack = httpCallback;
            this.val$retryCount = i;
            this.val$requestCount = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.network.RealResponse data = new com.sensorsdata.analytics.android.sdk.network.RealRequest().setHttpConfig(this.val$httpConfig).getData(com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.getUrl(this.val$url, this.val$paramsMap), this.val$headerMap);
            int i = data.code;
            if (i == 200 || i == 204) {
                com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback = this.val$callBack;
                if (httpCallback != null) {
                    httpCallback.onSuccess(data);
                    return;
                }
                return;
            }
            if (!com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.isRedirected && com.sensorsdata.analytics.android.sdk.network.HttpUtils.needRedirects(data.code)) {
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.isRedirected = true;
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.urlHttpGet(data.location, this.val$httpConfig, this.val$paramsMap, this.val$headerMap, this.val$retryCount, this.val$callBack);
                return;
            }
            int i2 = this.val$requestCount;
            if (i2 != 0) {
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.urlHttpGet(this.val$url, this.val$httpConfig, this.val$paramsMap, this.val$headerMap, i2, this.val$callBack);
                return;
            }
            com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback2 = this.val$callBack;
            if (httpCallback2 != null) {
                httpCallback2.onError(data);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.RequestHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.network.HttpCallback val$callBack;
        final /* synthetic */ java.util.Map val$headerMap;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.network.HttpConfig val$httpConfig;
        final /* synthetic */ java.lang.String val$jsonData;
        final /* synthetic */ java.util.Map val$paramsMap;
        final /* synthetic */ int val$requestCount;
        final /* synthetic */ int val$retryCount;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass2(com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.lang.String str, java.util.Map map, java.lang.String str2, java.util.Map map2, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback, int i, int i2) {
            this.val$httpConfig = httpConfig;
            this.val$url = str;
            this.val$paramsMap = map;
            this.val$jsonData = str2;
            this.val$headerMap = map2;
            this.val$callBack = httpCallback;
            this.val$retryCount = i;
            this.val$requestCount = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.network.RealResponse postData = new com.sensorsdata.analytics.android.sdk.network.RealRequest().setHttpConfig(this.val$httpConfig).postData(this.val$url, com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.getPostBody(this.val$paramsMap, this.val$jsonData), com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.getPostBodyType(this.val$paramsMap, this.val$jsonData), this.val$headerMap);
            int i = postData.code;
            if (i == 200 || i == 204) {
                com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback = this.val$callBack;
                if (httpCallback != null) {
                    httpCallback.onSuccess(postData);
                    return;
                }
                return;
            }
            if (!com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.isRedirected && com.sensorsdata.analytics.android.sdk.network.HttpUtils.needRedirects(postData.code)) {
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.isRedirected = true;
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.urlHttpPost(postData.location, this.val$httpConfig, this.val$paramsMap, this.val$jsonData, this.val$headerMap, this.val$retryCount, this.val$callBack);
                return;
            }
            int i2 = this.val$requestCount;
            if (i2 != 0) {
                com.sensorsdata.analytics.android.sdk.network.RequestHelper.this.urlHttpPost(this.val$url, this.val$httpConfig, this.val$paramsMap, this.val$jsonData, this.val$headerMap, i2, this.val$callBack);
                return;
            }
            com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback2 = this.val$callBack;
            if (httpCallback2 != null) {
                httpCallback2.onError(postData);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.RequestHelper$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod;

        static {
            int[] iArr = new int[com.sensorsdata.analytics.android.sdk.network.HttpMethod.values().length];
            $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod = iArr;
            try {
                iArr[com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod[com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public static class Builder {
        private com.sensorsdata.analytics.android.sdk.network.HttpCallback callBack;
        private java.util.Map<java.lang.String, java.lang.String> headerMap;
        private com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig;
        private com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod;
        private java.lang.String httpUrl;
        private java.lang.String jsonData;
        private java.util.Map<java.lang.String, java.lang.String> paramsMap;
        private int retryCount = 1;

        public Builder(com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod, java.lang.String str) {
            this.httpMethod = httpMethod;
            this.httpUrl = str;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder callback(com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
            this.callBack = httpCallback;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder connectionTimeout(int i) {
            if (this.httpConfig == null) {
                this.httpConfig = new com.sensorsdata.analytics.android.sdk.network.HttpConfig();
            }
            this.httpConfig.setConnectionTimeout(i);
            return this;
        }

        public void execute() {
            com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod = this.httpMethod;
            if (httpMethod == com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST && this.paramsMap == null) {
                new com.sensorsdata.analytics.android.sdk.network.RequestHelper(this.httpUrl, this.httpConfig, this.jsonData, this.headerMap, this.retryCount, this.callBack, (com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass1) null);
            } else {
                new com.sensorsdata.analytics.android.sdk.network.RequestHelper(httpMethod, this.httpUrl, this.httpConfig, this.paramsMap, this.headerMap, this.retryCount, this.callBack, null);
            }
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder header(java.util.Map<java.lang.String, java.lang.String> map) {
            this.headerMap = map;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder jsonData(java.lang.String str) {
            this.jsonData = str;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder params(java.util.Map<java.lang.String, java.lang.String> map) {
            this.paramsMap = map;
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder readTimeout(int i) {
            if (this.httpConfig == null) {
                this.httpConfig = new com.sensorsdata.analytics.android.sdk.network.HttpConfig();
            }
            this.httpConfig.setReadTimeout(i);
            return this;
        }

        public com.sensorsdata.analytics.android.sdk.network.RequestHelper.Builder retryCount(int i) {
            this.retryCount = i;
            return this;
        }
    }

    private RequestHelper(com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod, java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
        this.isRedirected = false;
        int i2 = com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass3.$SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod[httpMethod.ordinal()];
        if (i2 == 1) {
            urlHttpGet(str, httpConfig, map, map2, i, httpCallback);
        } else {
            if (i2 != 2) {
                return;
            }
            urlHttpPost(str, httpConfig, map, "", map2, i, httpCallback);
        }
    }

    public /* synthetic */ RequestHelper(com.sensorsdata.analytics.android.sdk.network.HttpMethod httpMethod, java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.util.Map map, java.util.Map map2, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback, com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass1 anonymousClass1) {
        this(httpMethod, str, httpConfig, (java.util.Map<java.lang.String, java.lang.String>) map, (java.util.Map<java.lang.String, java.lang.String>) map2, i, httpCallback);
    }

    private RequestHelper(java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
        this.isRedirected = false;
        urlHttpPost(str, httpConfig, null, str2, map, i, httpCallback);
    }

    public /* synthetic */ RequestHelper(java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.lang.String str2, java.util.Map map, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback, com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass1 anonymousClass1) {
        this(str, httpConfig, str2, map, i, httpCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getPostBody(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map != null) {
            return getPostBodyFormParamsMap(map);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    private java.lang.String getPostBodyFormParamsMap(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                boolean z = true;
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(java.net.URLEncoder.encode(entry.getKey(), "UTF-8"));
                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(java.net.URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
                return sb.toString();
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getPostBodyType(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null && !android.text.TextUtils.isEmpty(str)) {
            return "application/json;charset=utf-8";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null || map == null) {
            return str;
        }
        java.lang.String str2 = str.contains("?") ? str + "&" : str + "?";
        for (java.lang.String str3 : map.keySet()) {
            str2 = str2 + str3 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + map.get(str3) + "&";
        }
        return str2.substring(0, str2.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void urlHttpGet(java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
        com.sensorsdata.analytics.android.sdk.network.HttpTaskManager.execute(new com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass1(httpConfig, str, map, map2, httpCallback, i, i - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void urlHttpPost(java.lang.String str, com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map2, int i, com.sensorsdata.analytics.android.sdk.network.HttpCallback httpCallback) {
        com.sensorsdata.analytics.android.sdk.network.HttpTaskManager.execute(new com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass2(httpConfig, str, map, str2, map2, httpCallback, i, i - 1));
    }
}
