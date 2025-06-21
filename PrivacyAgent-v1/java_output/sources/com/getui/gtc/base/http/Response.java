package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class Response implements java.io.Closeable {
    final com.getui.gtc.base.http.ResponseBody body;
    final int code;
    final java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers;
    final java.lang.String message;
    final com.getui.gtc.base.http.Request request;

    public static class Builder {
        com.getui.gtc.base.http.ResponseBody body;
        int code;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers;
        java.lang.String message;
        com.getui.gtc.base.http.Request request;

        public Builder() {
            this.code = -1;
            this.headers = new java.util.HashMap();
        }

        public Builder(com.getui.gtc.base.http.Response response) {
            this.code = -1;
            this.request = response.request;
            this.code = response.code;
            this.message = response.message;
            this.headers = new java.util.HashMap(response.headers);
            this.body = response.body;
        }

        public com.getui.gtc.base.http.Response.Builder addHeader(java.lang.String str, java.lang.String str2) {
            java.util.List<java.lang.String> list = this.headers.get(str);
            if (list == null) {
                list = new java.util.ArrayList<>();
            }
            list.add(str2);
            this.headers.put(str, list);
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder body(com.getui.gtc.base.http.ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public com.getui.gtc.base.http.Response build() {
            if (this.request == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.code >= 0) {
                if (this.message != null) {
                    return new com.getui.gtc.base.http.Response(this);
                }
                throw new java.lang.IllegalStateException("message == null");
            }
            throw new java.lang.IllegalStateException("code < 0: " + this.code);
        }

        public com.getui.gtc.base.http.Response.Builder code(int i) {
            this.code = i;
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder headers(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            this.headers = new java.util.HashMap(map);
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder message(java.lang.String str) {
            this.message = str;
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder removeHeader(java.lang.String str) {
            this.headers.remove(str);
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder request(com.getui.gtc.base.http.Request request) {
            this.request = request;
            return this;
        }

        public com.getui.gtc.base.http.Response.Builder setHeader(java.lang.String str, java.lang.String str2) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(str2);
            this.headers.put(str, arrayList);
            return this;
        }
    }

    public Response(com.getui.gtc.base.http.Response.Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.message = builder.message;
        this.headers = new java.util.HashMap(builder.headers);
        this.body = builder.body;
    }

    public com.getui.gtc.base.http.ResponseBody body() {
        return this.body;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.getui.gtc.base.http.ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new java.lang.IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.code;
    }

    @java.lang.Deprecated
    public byte[] getBody() {
        try {
            return this.body.bytes();
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getHeaders() {
        return this.headers;
    }

    public java.lang.String header(java.lang.String str) {
        java.util.List<java.lang.String> list = this.headers.get(str);
        if (list == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers() {
        return this.headers;
    }

    public java.lang.String message() {
        return this.message;
    }

    public com.getui.gtc.base.http.Response.Builder newBuilder() {
        return new com.getui.gtc.base.http.Response.Builder(this);
    }

    public com.getui.gtc.base.http.Request request() {
        return this.request;
    }
}
