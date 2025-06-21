package okhttp3.internal.cache;

/* loaded from: classes23.dex */
public final class CacheStrategy {

    @javax.annotation.Nullable
    public final okhttp3.Response cacheResponse;

    @javax.annotation.Nullable
    public final okhttp3.Request networkRequest;

    public static class Factory {
        public final long a;
        public final okhttp3.Request b;
        public final okhttp3.Response c;
        public java.util.Date d;
        public java.lang.String e;
        public java.util.Date f;
        public java.lang.String g;
        public java.util.Date h;
        public long i;
        public long j;
        public java.lang.String k;
        public int l;

        public Factory(long j, okhttp3.Request request, okhttp3.Response response) {
            this.l = -1;
            this.a = j;
            this.b = request;
            this.c = response;
            if (response != null) {
                this.i = response.sentRequestAtMillis();
                this.j = response.receivedResponseAtMillis();
                okhttp3.Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    java.lang.String name = headers.name(i);
                    java.lang.String value = headers.value(i);
                    if ("Date".equalsIgnoreCase(name)) {
                        this.d = okhttp3.internal.http.HttpDate.parse(value);
                        this.e = value;
                    } else if ("Expires".equalsIgnoreCase(name)) {
                        this.h = okhttp3.internal.http.HttpDate.parse(value);
                    } else if ("Last-Modified".equalsIgnoreCase(name)) {
                        this.f = okhttp3.internal.http.HttpDate.parse(value);
                        this.g = value;
                    } else if ("ETag".equalsIgnoreCase(name)) {
                        this.k = value;
                    } else if (com.google.common.net.HttpHeaders.AGE.equalsIgnoreCase(name)) {
                        this.l = okhttp3.internal.http.HttpHeaders.parseSeconds(value, -1);
                    }
                }
            }
        }

        public static boolean d(okhttp3.Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        public final long a() {
            java.util.Date date = this.d;
            long max = date != null ? java.lang.Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = java.lang.Math.max(max, java.util.concurrent.TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.a - j);
        }

        public final long b() {
            if (this.c.cacheControl().maxAgeSeconds() != -1) {
                return java.util.concurrent.TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.h != null) {
                java.util.Date date = this.d;
                long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f == null || this.c.request().url().query() != null) {
                return 0L;
            }
            java.util.Date date2 = this.d;
            long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        public final okhttp3.internal.cache.CacheStrategy c() {
            java.lang.String str;
            if (this.c == null) {
                return new okhttp3.internal.cache.CacheStrategy(this.b, null);
            }
            if ((!this.b.isHttps() || this.c.handshake() != null) && okhttp3.internal.cache.CacheStrategy.isCacheable(this.c, this.b)) {
                okhttp3.CacheControl cacheControl = this.b.cacheControl();
                if (cacheControl.noCache() || d(this.b)) {
                    return new okhttp3.internal.cache.CacheStrategy(this.b, null);
                }
                okhttp3.CacheControl cacheControl2 = this.c.cacheControl();
                long a = a();
                long b = b();
                if (cacheControl.maxAgeSeconds() != -1) {
                    b = java.lang.Math.min(b, java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long j = 0;
                long millis = cacheControl.minFreshSeconds() != -1 ? java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                    j = java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache()) {
                    long j2 = millis + a;
                    if (j2 < j + b) {
                        okhttp3.Response.Builder newBuilder = this.c.newBuilder();
                        if (j2 >= b) {
                            newBuilder.addHeader(com.google.common.net.HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a > 86400000 && e()) {
                            newBuilder.addHeader(com.google.common.net.HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new okhttp3.internal.cache.CacheStrategy(null, newBuilder.build());
                    }
                }
                java.lang.String str2 = this.k;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f != null) {
                        str2 = this.g;
                    } else {
                        if (this.d == null) {
                            return new okhttp3.internal.cache.CacheStrategy(this.b, null);
                        }
                        str2 = this.e;
                    }
                    str = "If-Modified-Since";
                }
                okhttp3.Headers.Builder newBuilder2 = this.b.headers().newBuilder();
                okhttp3.internal.Internal.instance.addLenient(newBuilder2, str, str2);
                return new okhttp3.internal.cache.CacheStrategy(this.b.newBuilder().headers(newBuilder2.build()).build(), this.c);
            }
            return new okhttp3.internal.cache.CacheStrategy(this.b, null);
        }

        public final boolean e() {
            return this.c.cacheControl().maxAgeSeconds() == -1 && this.h == null;
        }

        public okhttp3.internal.cache.CacheStrategy get() {
            okhttp3.internal.cache.CacheStrategy c = c();
            return (c.networkRequest == null || !this.b.cacheControl().onlyIfCached()) ? c : new okhttp3.internal.cache.CacheStrategy(null, null);
        }
    }

    public CacheStrategy(okhttp3.Request request, okhttp3.Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCacheable(okhttp3.Response response, okhttp3.Request request) {
        int code = response.code();
        if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
            if (code != 307) {
                if (code != 308 && code != 404 && code != 405) {
                    switch (code) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (response.header("Expires") == null) {
                if (response.cacheControl().maxAgeSeconds() == -1) {
                    if (!response.cacheControl().isPublic()) {
                    }
                }
            }
        }
        return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
    }
}
