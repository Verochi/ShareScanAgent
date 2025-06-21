package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
public class HttpRequest {
    private static final java.lang.String TAG = "HttpRequest";
    private final java.lang.String body;
    private final int connectTimeout;
    private final java.util.Map<java.lang.String, java.lang.String> headers;
    private final java.lang.String method;
    private final int readTimeout;
    private final java.util.Map<java.lang.String, java.lang.String> requestParameters;
    private final java.lang.String url;
    private final boolean useCaches;

    public static class Builder {
        private java.lang.String body;
        private java.lang.String url;
        private boolean useCaches;
        private java.lang.String method = "GET";
        private java.util.Map<java.lang.String, java.lang.String> headers = new java.util.HashMap();
        private java.util.Map<java.lang.String, java.lang.String> requestParameters = new java.util.HashMap();
        private int connectTimeout = 30000;
        private int readTimeout = 30000;

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder appendRequestParameter(java.lang.String str, java.lang.String str2) {
            this.requestParameters.put(str, str2);
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest build() {
            if (this.url != null) {
                return new com.sensorsdata.sf.core.http.internal.HttpRequest(this, null);
            }
            throw new java.lang.IllegalStateException("The value url is null.");
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder connectTimeout(int i) {
            if (i < 0) {
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.http.internal.HttpRequest.TAG, "connectTimeout < 0");
                i = 30000;
            }
            this.connectTimeout = i;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder get() {
            this.method = "GET";
            this.body = null;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder headers(java.util.Map<java.lang.String, java.lang.String> map) {
            this.headers = map;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder post(java.lang.String str) {
            this.method = "POST";
            this.body = str;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder readTimeout(int i) {
            if (i < 0) {
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.core.http.internal.HttpRequest.TAG, "readTimeout < 0");
                i = 30000;
            }
            this.readTimeout = i;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder requestParameters(java.util.Map<java.lang.String, java.lang.String> map) {
            this.requestParameters = map;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder url(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("The value url is null.");
            }
            this.url = str;
            return this;
        }

        public com.sensorsdata.sf.core.http.internal.HttpRequest.Builder useCaches(boolean z) {
            this.useCaches = z;
            return this;
        }
    }

    private HttpRequest(com.sensorsdata.sf.core.http.internal.HttpRequest.Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.requestParameters = builder.requestParameters;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.useCaches = builder.useCaches;
    }

    public /* synthetic */ HttpRequest(com.sensorsdata.sf.core.http.internal.HttpRequest.Builder builder, com.sensorsdata.sf.core.http.internal.HttpRequest.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.lang.String body() {
        return this.body;
    }

    public int connectTimeout() {
        return this.connectTimeout;
    }

    public java.util.Map<java.lang.String, java.lang.String> headers() {
        return this.headers;
    }

    public boolean isUseCaches() {
        return this.useCaches;
    }

    public java.lang.String method() {
        return this.method;
    }

    public int readTimeout() {
        return this.readTimeout;
    }

    public java.util.Map<java.lang.String, java.lang.String> requestParameters() {
        return this.requestParameters;
    }

    public java.lang.String toString() {
        return "HttpRequest{method = " + this.method + ", url = " + this.url;
    }

    public java.lang.String url() {
        return this.url;
    }
}
