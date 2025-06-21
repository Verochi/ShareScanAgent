package okhttp3;

/* loaded from: classes23.dex */
public final class Request {
    public final okhttp3.HttpUrl a;
    public final java.lang.String b;
    public final okhttp3.Headers c;

    @javax.annotation.Nullable
    public final okhttp3.RequestBody d;
    public final java.util.Map<java.lang.Class<?>, java.lang.Object> e;

    @javax.annotation.Nullable
    public volatile okhttp3.CacheControl f;

    public static class Builder {

        @javax.annotation.Nullable
        public okhttp3.HttpUrl a;
        public java.lang.String b;
        public okhttp3.Headers.Builder c;

        @javax.annotation.Nullable
        public okhttp3.RequestBody d;
        public java.util.Map<java.lang.Class<?>, java.lang.Object> e;

        public Builder() {
            this.e = java.util.Collections.emptyMap();
            this.b = "GET";
            this.c = new okhttp3.Headers.Builder();
        }

        public Builder(okhttp3.Request request) {
            this.e = java.util.Collections.emptyMap();
            this.a = request.a;
            this.b = request.b;
            this.d = request.d;
            this.e = request.e.isEmpty() ? java.util.Collections.emptyMap() : new java.util.LinkedHashMap<>(request.e);
            this.c = request.c.newBuilder();
        }

        public okhttp3.Request.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.c.add(str, str2);
            return this;
        }

        public okhttp3.Request build() {
            if (this.a != null) {
                return new okhttp3.Request(this);
            }
            throw new java.lang.IllegalStateException("url == null");
        }

        public okhttp3.Request.Builder cacheControl(okhttp3.CacheControl cacheControl) {
            java.lang.String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public okhttp3.Request.Builder delete() {
            return delete(okhttp3.internal.Util.EMPTY_REQUEST);
        }

        public okhttp3.Request.Builder delete(@javax.annotation.Nullable okhttp3.RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public okhttp3.Request.Builder get() {
            return method("GET", null);
        }

        public okhttp3.Request.Builder head() {
            return method("HEAD", null);
        }

        public okhttp3.Request.Builder header(java.lang.String str, java.lang.String str2) {
            this.c.set(str, str2);
            return this;
        }

        public okhttp3.Request.Builder headers(okhttp3.Headers headers) {
            this.c = headers.newBuilder();
            return this;
        }

        public okhttp3.Request.Builder method(java.lang.String str, @javax.annotation.Nullable okhttp3.RequestBody requestBody) {
            if (str == null) {
                throw new java.lang.NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new java.lang.IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !okhttp3.internal.http.HttpMethod.permitsRequestBody(str)) {
                throw new java.lang.IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !okhttp3.internal.http.HttpMethod.requiresRequestBody(str)) {
                this.b = str;
                this.d = requestBody;
                return this;
            }
            throw new java.lang.IllegalArgumentException("method " + str + " must have a request body.");
        }

        public okhttp3.Request.Builder patch(okhttp3.RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public okhttp3.Request.Builder post(okhttp3.RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public okhttp3.Request.Builder put(okhttp3.RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public okhttp3.Request.Builder removeHeader(java.lang.String str) {
            this.c.removeAll(str);
            return this;
        }

        public <T> okhttp3.Request.Builder tag(java.lang.Class<? super T> cls, @javax.annotation.Nullable T t) {
            if (cls == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new java.util.LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public okhttp3.Request.Builder tag(@javax.annotation.Nullable java.lang.Object obj) {
            return tag(java.lang.Object.class, obj);
        }

        public okhttp3.Request.Builder url(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return url(okhttp3.HttpUrl.get(str));
        }

        public okhttp3.Request.Builder url(java.net.URL url) {
            if (url != null) {
                return url(okhttp3.HttpUrl.get(url.toString()));
            }
            throw new java.lang.NullPointerException("url == null");
        }

        public okhttp3.Request.Builder url(okhttp3.HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            this.a = httpUrl;
            return this;
        }
    }

    public Request(okhttp3.Request.Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c.build();
        this.d = builder.d;
        this.e = okhttp3.internal.Util.immutableMap(builder.e);
    }

    @javax.annotation.Nullable
    public okhttp3.RequestBody body() {
        return this.d;
    }

    public okhttp3.CacheControl cacheControl() {
        okhttp3.CacheControl cacheControl = this.f;
        if (cacheControl != null) {
            return cacheControl;
        }
        okhttp3.CacheControl parse = okhttp3.CacheControl.parse(this.c);
        this.f = parse;
        return parse;
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str) {
        return this.c.get(str);
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.c.values(str);
    }

    public okhttp3.Headers headers() {
        return this.c;
    }

    public boolean isHttps() {
        return this.a.isHttps();
    }

    public java.lang.String method() {
        return this.b;
    }

    public okhttp3.Request.Builder newBuilder() {
        return new okhttp3.Request.Builder(this);
    }

    @javax.annotation.Nullable
    public java.lang.Object tag() {
        return tag(java.lang.Object.class);
    }

    @javax.annotation.Nullable
    public <T> T tag(java.lang.Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public java.lang.String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }

    public okhttp3.HttpUrl url() {
        return this.a;
    }
}
