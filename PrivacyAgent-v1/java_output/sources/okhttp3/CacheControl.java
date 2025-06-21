package okhttp3;

/* loaded from: classes23.dex */
public final class CacheControl {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;

    @javax.annotation.Nullable
    public java.lang.String m;
    public static final okhttp3.CacheControl FORCE_NETWORK = new okhttp3.CacheControl.Builder().noCache().build();
    public static final okhttp3.CacheControl FORCE_CACHE = new okhttp3.CacheControl.Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, java.util.concurrent.TimeUnit.SECONDS).build();

    public static final class Builder {
        public boolean a;
        public boolean b;
        public int c = -1;
        public int d = -1;
        public int e = -1;
        public boolean f;
        public boolean g;
        public boolean h;

        public okhttp3.CacheControl build() {
            return new okhttp3.CacheControl(this);
        }

        public okhttp3.CacheControl.Builder immutable() {
            this.h = true;
            return this;
        }

        public okhttp3.CacheControl.Builder maxAge(int i, java.util.concurrent.TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new java.lang.IllegalArgumentException("maxAge < 0: " + i);
        }

        public okhttp3.CacheControl.Builder maxStale(int i, java.util.concurrent.TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new java.lang.IllegalArgumentException("maxStale < 0: " + i);
        }

        public okhttp3.CacheControl.Builder minFresh(int i, java.util.concurrent.TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new java.lang.IllegalArgumentException("minFresh < 0: " + i);
        }

        public okhttp3.CacheControl.Builder noCache() {
            this.a = true;
            return this;
        }

        public okhttp3.CacheControl.Builder noStore() {
            this.b = true;
            return this;
        }

        public okhttp3.CacheControl.Builder noTransform() {
            this.g = true;
            return this;
        }

        public okhttp3.CacheControl.Builder onlyIfCached() {
            this.f = true;
            return this;
        }
    }

    public CacheControl(okhttp3.CacheControl.Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = builder.d;
        this.i = builder.e;
        this.j = builder.f;
        this.k = builder.g;
        this.l = builder.h;
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @javax.annotation.Nullable java.lang.String str) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static okhttp3.CacheControl parse(okhttp3.Headers headers) {
        int i;
        int i2;
        java.lang.String str;
        okhttp3.Headers headers2 = headers;
        int size = headers.size();
        int i3 = 0;
        boolean z = true;
        java.lang.String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = -1;
        int i5 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = -1;
        int i7 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i3 < size) {
            java.lang.String name = headers2.name(i3);
            java.lang.String value = headers2.value(i3);
            if (name.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = value;
                    for (i = 0; i < value.length(); i = i2) {
                        int skipUntil = okhttp3.internal.http.HttpHeaders.skipUntil(value, i, "=,;");
                        java.lang.String trim = value.substring(i, skipUntil).trim();
                        if (skipUntil == value.length() || value.charAt(skipUntil) == ',' || value.charAt(skipUntil) == ';') {
                            i2 = skipUntil + 1;
                            str = null;
                        } else {
                            int skipWhitespace = okhttp3.internal.http.HttpHeaders.skipWhitespace(value, skipUntil + 1);
                            if (skipWhitespace >= value.length() || value.charAt(skipWhitespace) != '\"') {
                                i2 = okhttp3.internal.http.HttpHeaders.skipUntil(value, skipWhitespace, ",;");
                                str = value.substring(skipWhitespace, i2).trim();
                            } else {
                                int i8 = skipWhitespace + 1;
                                int skipUntil2 = okhttp3.internal.http.HttpHeaders.skipUntil(value, i8, "\"");
                                str = value.substring(i8, skipUntil2);
                                i2 = skipUntil2 + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(trim)) {
                            i4 = okhttp3.internal.http.HttpHeaders.parseSeconds(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i5 = okhttp3.internal.http.HttpHeaders.parseSeconds(str, -1);
                        } else if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i6 = okhttp3.internal.http.HttpHeaders.parseSeconds(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i7 = okhttp3.internal.http.HttpHeaders.parseSeconds(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                    }
                    i3++;
                    headers2 = headers;
                }
            } else if (!name.equalsIgnoreCase(com.google.common.net.HttpHeaders.PRAGMA)) {
                i3++;
                headers2 = headers;
            }
            z = false;
            while (i < value.length()) {
            }
            i3++;
            headers2 = headers;
        }
        return new okhttp3.CacheControl(z2, z3, i4, i5, z4, z5, z6, i6, i7, z7, z8, z9, !z ? null : str2);
    }

    public final java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean immutable() {
        return this.l;
    }

    public boolean isPrivate() {
        return this.e;
    }

    public boolean isPublic() {
        return this.f;
    }

    public int maxAgeSeconds() {
        return this.c;
    }

    public int maxStaleSeconds() {
        return this.h;
    }

    public int minFreshSeconds() {
        return this.i;
    }

    public boolean mustRevalidate() {
        return this.g;
    }

    public boolean noCache() {
        return this.a;
    }

    public boolean noStore() {
        return this.b;
    }

    public boolean noTransform() {
        return this.k;
    }

    public boolean onlyIfCached() {
        return this.j;
    }

    public int sMaxAgeSeconds() {
        return this.d;
    }

    public java.lang.String toString() {
        java.lang.String str = this.m;
        if (str != null) {
            return str;
        }
        java.lang.String a = a();
        this.m = a;
        return a;
    }
}
