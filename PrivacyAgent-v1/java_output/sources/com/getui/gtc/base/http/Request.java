package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class Request {
    private com.getui.gtc.base.http.RequestBody body;
    private com.getui.gtc.base.http.Interceptor cryptInterceptor;
    private java.util.Map<java.lang.String, java.lang.String> headers;
    private int logFlags;
    private java.lang.String method;
    private android.net.Network network;
    private java.lang.String tag;
    private java.net.URL url;

    public static class Builder {
        com.getui.gtc.base.http.RequestBody body;
        com.getui.gtc.base.http.Interceptor cryptInterceptor;
        java.util.Map<java.lang.String, java.lang.String> headers;
        int logFlags;
        java.lang.String method;
        android.net.Network network;
        java.lang.String tag;
        java.net.URL url;

        public Builder() {
            this.method = "GET";
            this.headers = new java.util.HashMap();
            this.tag = "";
            this.logFlags = -1;
        }

        public Builder(com.getui.gtc.base.http.Request request) {
            this.url = request.url;
            this.method = request.method;
            this.network = request.network;
            this.body = request.body;
            this.headers = request.headers;
            this.tag = request.tag;
            this.logFlags = request.logFlags;
        }

        public com.getui.gtc.base.http.Request.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder body(com.getui.gtc.base.http.RequestBody requestBody) {
            this.body = requestBody;
            return this;
        }

        @java.lang.Deprecated
        public com.getui.gtc.base.http.Request.Builder body(byte[] bArr) {
            if (bArr == null) {
                return this;
            }
            this.body = com.getui.gtc.base.http.RequestBody.create(com.getui.gtc.base.http.MediaType.parse("application/json; charset=utf-8"), bArr);
            return this;
        }

        public com.getui.gtc.base.http.Request build() {
            return new com.getui.gtc.base.http.Request(this, null);
        }

        public com.getui.gtc.base.http.Request.Builder cryptInterceptor(com.getui.gtc.base.http.Interceptor interceptor) {
            this.cryptInterceptor = interceptor;
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder headers(java.util.Map<java.lang.String, java.lang.String> map) {
            this.headers.clear();
            this.headers.putAll(map);
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder logFlags(int i) {
            this.logFlags = i;
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder method(java.lang.String str) {
            this.method = str;
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder network(android.net.Network network) {
            this.network = network;
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder removeHeader(java.lang.String str) {
            this.headers.remove(str);
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder tag(java.lang.String str) {
            this.tag = str;
            return this;
        }

        public com.getui.gtc.base.http.Request.Builder url(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            try {
                return url(new java.net.URL(str));
            } catch (java.net.MalformedURLException e) {
                throw new java.lang.IllegalArgumentException(e);
            }
        }

        public com.getui.gtc.base.http.Request.Builder url(java.net.URL url) {
            if (url == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            this.url = url;
            return this;
        }
    }

    private Request() {
    }

    private Request(com.getui.gtc.base.http.Request.Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.network = builder.network;
        java.util.HashMap hashMap = new java.util.HashMap();
        this.headers = hashMap;
        hashMap.putAll(builder.headers);
        this.body = builder.body;
        this.cryptInterceptor = builder.cryptInterceptor;
        this.tag = builder.tag;
        this.logFlags = builder.logFlags;
    }

    public /* synthetic */ Request(com.getui.gtc.base.http.Request.Builder builder, com.getui.gtc.base.http.Request.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public com.getui.gtc.base.http.RequestBody body() {
        return this.body;
    }

    public com.getui.gtc.base.http.Interceptor cryptInterceptor() {
        return this.cryptInterceptor;
    }

    public java.lang.String header(java.lang.String str) {
        return this.headers.get(str);
    }

    public java.util.Map<java.lang.String, java.lang.String> headers() {
        return this.headers;
    }

    public int logFlags() {
        return this.logFlags;
    }

    public java.lang.String method() {
        return this.method;
    }

    public android.net.Network network() {
        return this.network;
    }

    public com.getui.gtc.base.http.Request.Builder newBuilder() {
        return new com.getui.gtc.base.http.Request.Builder(this);
    }

    public java.lang.String tag() {
        return this.tag;
    }

    public java.net.URL url() {
        return this.url;
    }
}
