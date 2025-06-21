package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DataSpec {
    public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 4;
    public static final int FLAG_ALLOW_GZIP = 1;
    public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 2;
    public static final int FLAG_MIGHT_NOT_USE_FULL_NETWORK_SPEED = 8;
    public static final int HTTP_METHOD_GET = 1;
    public static final int HTTP_METHOD_HEAD = 3;
    public static final int HTTP_METHOD_POST = 2;

    @java.lang.Deprecated
    public final long absoluteStreamPosition;

    @androidx.annotation.Nullable
    public final java.lang.Object customData;
    public final int flags;

    @androidx.annotation.Nullable
    public final byte[] httpBody;
    public final int httpMethod;
    public final java.util.Map<java.lang.String, java.lang.String> httpRequestHeaders;

    @androidx.annotation.Nullable
    public final java.lang.String key;
    public final long length;
    public final long position;
    public final android.net.Uri uri;
    public final long uriPositionOffset;

    public static final class Builder {

        @androidx.annotation.Nullable
        public android.net.Uri a;
        public long b;
        public int c;

        @androidx.annotation.Nullable
        public byte[] d;
        public java.util.Map<java.lang.String, java.lang.String> e;
        public long f;
        public long g;

        @androidx.annotation.Nullable
        public java.lang.String h;
        public int i;

        @androidx.annotation.Nullable
        public java.lang.Object j;

        public Builder() {
            this.c = 1;
            this.e = java.util.Collections.emptyMap();
            this.g = -1L;
        }

        public Builder(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
            this.a = dataSpec.uri;
            this.b = dataSpec.uriPositionOffset;
            this.c = dataSpec.httpMethod;
            this.d = dataSpec.httpBody;
            this.e = dataSpec.httpRequestHeaders;
            this.f = dataSpec.position;
            this.g = dataSpec.length;
            this.h = dataSpec.key;
            this.i = dataSpec.flags;
            this.j = dataSpec.customData;
        }

        public /* synthetic */ Builder(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSpec.AnonymousClass1 anonymousClass1) {
            this(dataSpec);
        }

        public com.google.android.exoplayer2.upstream.DataSpec build() {
            com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.a, "The uri must be set.");
            return new com.google.android.exoplayer2.upstream.DataSpec(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setCustomData(@androidx.annotation.Nullable java.lang.Object obj) {
            this.j = obj;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setFlags(int i) {
            this.i = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setHttpBody(@androidx.annotation.Nullable byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setHttpMethod(int i) {
            this.c = i;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setHttpRequestHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
            this.e = map;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setKey(@androidx.annotation.Nullable java.lang.String str) {
            this.h = str;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setLength(long j) {
            this.g = j;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setPosition(long j) {
            this.f = j;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setUri(android.net.Uri uri) {
            this.a = uri;
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setUri(java.lang.String str) {
            this.a = android.net.Uri.parse(str);
            return this;
        }

        public com.google.android.exoplayer2.upstream.DataSpec.Builder setUriPositionOffset(long j) {
            this.b = j;
            return this;
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    public DataSpec(android.net.Uri uri) {
        this(uri, 0L, -1L);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, int i) {
        this(uri, 0L, -1L, null, i);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, int i, @androidx.annotation.Nullable byte[] bArr, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i2) {
        this(uri, i, bArr, j, j2, j3, str, i2, java.util.Collections.emptyMap());
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, int i, @androidx.annotation.Nullable byte[] bArr, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i2, java.util.Map<java.lang.String, java.lang.String> map) {
        this(uri, j - j2, i, bArr, map, j2, j3, str, i2, null);
    }

    public DataSpec(android.net.Uri uri, long j, int i, @androidx.annotation.Nullable byte[] bArr, java.util.Map<java.lang.String, java.lang.String> map, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        byte[] bArr2 = bArr;
        long j4 = j + j2;
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkArgument(j4 >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        this.uri = uri;
        this.uriPositionOffset = j;
        this.httpMethod = i;
        this.httpBody = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.httpRequestHeaders = java.util.Collections.unmodifiableMap(new java.util.HashMap(map));
        this.position = j2;
        this.absoluteStreamPosition = j4;
        this.length = j3;
        this.key = str;
        this.flags = i2;
        this.customData = obj;
    }

    public /* synthetic */ DataSpec(android.net.Uri uri, long j, int i, byte[] bArr, java.util.Map map, long j2, long j3, java.lang.String str, int i2, java.lang.Object obj, com.google.android.exoplayer2.upstream.DataSpec.AnonymousClass1 anonymousClass1) {
        this(uri, j, i, bArr, map, j2, j3, str, i2, obj);
    }

    public DataSpec(android.net.Uri uri, long j, long j2) {
        this(uri, 0L, 1, null, java.util.Collections.emptyMap(), j, j2, null, 0, null);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, long j, long j2, @androidx.annotation.Nullable java.lang.String str) {
        this(uri, j, j, j2, str, 0);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, long j, long j2, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, long j, long j2, @androidx.annotation.Nullable java.lang.String str, int i, java.util.Map<java.lang.String, java.lang.String> map) {
        this(uri, 1, null, j, j, j2, str, i, map);
    }

    @java.lang.Deprecated
    public DataSpec(android.net.Uri uri, @androidx.annotation.Nullable byte[] bArr, long j, long j2, long j3, @androidx.annotation.Nullable java.lang.String str, int i) {
        this(uri, bArr != null ? 2 : 1, bArr, j, j2, j3, str, i);
    }

    public static java.lang.String getStringForHttpMethod(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new java.lang.IllegalStateException();
    }

    public com.google.android.exoplayer2.upstream.DataSpec.Builder buildUpon() {
        return new com.google.android.exoplayer2.upstream.DataSpec.Builder(this, null);
    }

    public final java.lang.String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public boolean isFlagSet(int i) {
        return (this.flags & i) == i;
    }

    public com.google.android.exoplayer2.upstream.DataSpec subrange(long j) {
        long j2 = this.length;
        return subrange(j, j2 != -1 ? j2 - j : -1L);
    }

    public com.google.android.exoplayer2.upstream.DataSpec subrange(long j, long j2) {
        return (j == 0 && this.length == j2) ? this : new com.google.android.exoplayer2.upstream.DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position + j, j2, this.key, this.flags, this.customData);
    }

    public java.lang.String toString() {
        java.lang.String httpMethodString = getHttpMethodString();
        java.lang.String valueOf = java.lang.String.valueOf(this.uri);
        long j = this.position;
        long j2 = this.length;
        java.lang.String str = this.key;
        int i = this.flags;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(httpMethodString).length() + 70 + valueOf.length() + java.lang.String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(httpMethodString);
        sb.append(" ");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public com.google.android.exoplayer2.upstream.DataSpec withAdditionalHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap = new java.util.HashMap(this.httpRequestHeaders);
        hashMap.putAll(map);
        return new com.google.android.exoplayer2.upstream.DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, hashMap, this.position, this.length, this.key, this.flags, this.customData);
    }

    public com.google.android.exoplayer2.upstream.DataSpec withRequestHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        return new com.google.android.exoplayer2.upstream.DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, map, this.position, this.length, this.key, this.flags, this.customData);
    }

    public com.google.android.exoplayer2.upstream.DataSpec withUri(android.net.Uri uri) {
        return new com.google.android.exoplayer2.upstream.DataSpec(uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
    }
}
