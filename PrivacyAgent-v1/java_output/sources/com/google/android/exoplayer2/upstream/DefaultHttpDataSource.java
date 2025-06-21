package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public class DefaultHttpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource implements com.google.android.exoplayer2.upstream.HttpDataSource {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 8000;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 8000;
    public static final java.util.regex.Pattern u = java.util.regex.Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final java.util.concurrent.atomic.AtomicReference<byte[]> v = new java.util.concurrent.atomic.AtomicReference<>();
    public final boolean e;
    public final int f;
    public final int g;
    public final java.lang.String h;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties i;
    public final com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties j;

    @androidx.annotation.Nullable
    public com.google.common.base.Predicate<java.lang.String> k;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.DataSpec l;

    @androidx.annotation.Nullable
    public java.net.HttpURLConnection m;

    @androidx.annotation.Nullable
    public java.io.InputStream n;
    public boolean o;
    public int p;
    public long q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f368s;
    public long t;

    public DefaultHttpDataSource() {
        this(com.google.android.exoplayer2.ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, 8000, 8000);
    }

    public DefaultHttpDataSource(java.lang.String str) {
        this(str, 8000, 8000);
    }

    public DefaultHttpDataSource(java.lang.String str, int i, int i2) {
        this(str, i, i2, false, null);
    }

    public DefaultHttpDataSource(java.lang.String str, int i, int i2, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.h = com.google.android.exoplayer2.util.Assertions.checkNotEmpty(str);
        this.j = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();
        this.f = i;
        this.g = i2;
        this.e = z;
        this.i = requestProperties;
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, @androidx.annotation.Nullable com.google.common.base.Predicate<java.lang.String> predicate) {
        this(str, predicate, 8000, 8000);
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, @androidx.annotation.Nullable com.google.common.base.Predicate<java.lang.String> predicate, int i, int i2) {
        this(str, predicate, i, i2, false, null);
    }

    @java.lang.Deprecated
    public DefaultHttpDataSource(java.lang.String str, @androidx.annotation.Nullable com.google.common.base.Predicate<java.lang.String> predicate, int i, int i2, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.h = com.google.android.exoplayer2.util.Assertions.checkNotEmpty(str);
        this.k = predicate;
        this.j = new com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties();
        this.f = i;
        this.g = i2;
        this.e = z;
        this.i = requestProperties;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(java.net.HttpURLConnection httpURLConnection) {
        long parseLong;
        java.lang.String headerField;
        java.lang.String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!android.text.TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = java.lang.Long.parseLong(headerField2);
            } catch (java.lang.NumberFormatException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(headerField2).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField2);
                sb.append("]");
                com.google.android.exoplayer2.util.Log.e("DefaultHttpDataSource", sb.toString());
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!android.text.TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            java.util.regex.Matcher matcher = u.matcher(headerField);
            if (!matcher.find()) {
                return parseLong;
            }
            try {
                long parseLong2 = (java.lang.Long.parseLong(matcher.group(2)) - java.lang.Long.parseLong(matcher.group(1))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(headerField2).length() + 26 + java.lang.String.valueOf(headerField).length());
                sb2.append("Inconsistent headers [");
                sb2.append(headerField2);
                sb2.append("] [");
                sb2.append(headerField);
                sb2.append("]");
                com.google.android.exoplayer2.util.Log.w("DefaultHttpDataSource", sb2.toString());
                return java.lang.Math.max(parseLong, parseLong2);
            } catch (java.lang.NumberFormatException unused2) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(headerField).length() + 27);
                sb3.append("Unexpected Content-Range [");
                sb3.append(headerField);
                sb3.append("]");
                com.google.android.exoplayer2.util.Log.e("DefaultHttpDataSource", sb3.toString());
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!android.text.TextUtils.isEmpty(headerField)) {
        }
    }

    public static java.net.URL c(java.net.URL url, @androidx.annotation.Nullable java.lang.String str) throws java.io.IOException {
        if (str == null) {
            throw new java.net.ProtocolException("Null location redirect");
        }
        java.net.URL url2 = new java.net.URL(url, str);
        java.lang.String protocol = url2.getProtocol();
        if ("https".equals(protocol) || com.alipay.sdk.m.l.a.q.equals(protocol)) {
            return url2;
        }
        java.lang.String valueOf = java.lang.String.valueOf(protocol);
        throw new java.net.ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new java.lang.String("Unsupported protocol redirect: "));
    }

    public static boolean d(java.net.HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    public static void g(java.net.HttpURLConnection httpURLConnection, long j) {
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i == 19 || i == 20) {
            try {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                java.lang.String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    java.lang.reflect.Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new java.lang.Object[0]);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public final void a() {
        java.net.HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Exception e) {
                com.google.android.exoplayer2.util.Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.m = null;
        }
    }

    public final long bytesRead() {
        return this.t;
    }

    public final long bytesRemaining() {
        long j = this.r;
        return j == -1 ? j : j - this.t;
    }

    public final long bytesSkipped() {
        return this.f368s;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.j.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        this.j.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        try {
            if (this.n != null) {
                g(this.m, bytesRemaining());
                try {
                    this.n.close();
                } catch (java.io.IOException e) {
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e, this.l, 3);
                }
            }
        } finally {
            this.n = null;
            a();
            if (this.o) {
                this.o = false;
                transferEnded();
            }
        }
    }

    public final java.net.HttpURLConnection e(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        java.net.HttpURLConnection f;
        com.google.android.exoplayer2.upstream.DataSpec dataSpec2 = dataSpec;
        java.net.URL url = new java.net.URL(dataSpec2.uri.toString());
        int i = dataSpec2.httpMethod;
        byte[] bArr = dataSpec2.httpBody;
        long j = dataSpec2.position;
        long j2 = dataSpec2.length;
        boolean isFlagSet = dataSpec2.isFlagSet(1);
        if (!this.e) {
            return f(url, i, bArr, j, j2, isFlagSet, true, dataSpec2.httpRequestHeaders);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 > 20) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(31);
                sb.append("Too many redirects: ");
                sb.append(i3);
                throw new java.net.NoRouteToHostException(sb.toString());
            }
            byte[] bArr2 = bArr;
            long j3 = j2;
            long j4 = j;
            f = f(url, i, bArr, j, j2, isFlagSet, false, dataSpec2.httpRequestHeaders);
            int responseCode = f.getResponseCode();
            java.lang.String headerField = f.getHeaderField("Location");
            if ((i == 1 || i == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                f.disconnect();
                url = c(url, headerField);
            } else {
                if (i != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                f.disconnect();
                url = c(url, headerField);
                bArr2 = null;
                i = 1;
            }
            i2 = i3;
            bArr = bArr2;
            j2 = j3;
            j = j4;
            dataSpec2 = dataSpec;
        }
        return f;
    }

    public final java.net.HttpURLConnection f(java.net.URL url, int i, @androidx.annotation.Nullable byte[] bArr, long j, long j2, boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        java.net.HttpURLConnection h = h(url);
        h.setConnectTimeout(this.f);
        h.setReadTimeout(this.g);
        java.util.HashMap hashMap = new java.util.HashMap();
        com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties = this.i;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.getSnapshot());
        }
        hashMap.putAll(this.j.getSnapshot());
        hashMap.putAll(map);
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            h.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            java.lang.String sb2 = sb.toString();
            if (j2 != -1) {
                java.lang.String valueOf = java.lang.String.valueOf(sb2);
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            h.setRequestProperty("Range", sb2);
        }
        h.setRequestProperty("User-Agent", this.h);
        h.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, z ? "gzip" : "identity");
        h.setInstanceFollowRedirects(z2);
        h.setDoOutput(bArr != null);
        h.setRequestMethod(com.google.android.exoplayer2.upstream.DataSpec.getStringForHttpMethod(i));
        if (bArr != null) {
            h.setFixedLengthStreamingMode(bArr.length);
            h.connect();
            java.io.OutputStream outputStream = h.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            h.connect();
        }
        return h;
    }

    @androidx.annotation.Nullable
    public final java.net.HttpURLConnection getConnection() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        int i;
        if (this.m == null || (i = this.p) <= 0) {
            return -1;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.upstream.BaseDataSource, com.google.android.exoplayer2.upstream.DataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        java.net.HttpURLConnection httpURLConnection = this.m;
        return httpURLConnection == null ? java.util.Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @androidx.annotation.Nullable
    public android.net.Uri getUri() {
        java.net.HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return android.net.Uri.parse(httpURLConnection.getURL().toString());
    }

    @androidx.annotation.VisibleForTesting
    public java.net.HttpURLConnection h(java.net.URL url) throws java.io.IOException {
        return (java.net.HttpURLConnection) url.openConnection();
    }

    public final int i(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.r;
        if (j != -1) {
            long j2 = j - this.t;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) java.lang.Math.min(i2, j2);
        }
        int read = this.n.read(bArr, i, i2);
        if (read == -1) {
            if (this.r == -1) {
                return -1;
            }
            throw new java.io.EOFException();
        }
        this.t += read;
        bytesTransferred(read);
        return read;
    }

    public final void j() throws java.io.IOException {
        if (this.f368s == this.q) {
            return;
        }
        byte[] andSet = v.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.f368s;
            long j2 = this.q;
            if (j == j2) {
                v.set(andSet);
                return;
            }
            int read = this.n.read(andSet, 0, (int) java.lang.Math.min(j2 - j, andSet.length));
            if (java.lang.Thread.currentThread().isInterrupted()) {
                throw new java.io.InterruptedIOException();
            }
            if (read == -1) {
                throw new java.io.EOFException();
            }
            this.f368s += read;
            bytesTransferred(read);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        this.l = dataSpec;
        long j = 0;
        this.t = 0L;
        this.f368s = 0L;
        transferInitializing(dataSpec);
        try {
            java.net.HttpURLConnection e = e(dataSpec);
            this.m = e;
            try {
                this.p = e.getResponseCode();
                java.lang.String responseMessage = this.m.getResponseMessage();
                int i = this.p;
                if (i < 200 || i > 299) {
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = this.m.getHeaderFields();
                    java.io.InputStream errorStream = this.m.getErrorStream();
                    try {
                        byte[] byteArray = errorStream != null ? com.google.android.exoplayer2.util.Util.toByteArray(errorStream) : com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
                        a();
                        com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException(this.p, responseMessage, headerFields, dataSpec, byteArray);
                        dataSpec = this.p;
                        if (dataSpec != 416) {
                            throw invalidResponseCodeException;
                        }
                        invalidResponseCodeException.initCause(new com.google.android.exoplayer2.upstream.DataSourceException(0));
                        throw invalidResponseCodeException;
                    } catch (java.io.IOException e2) {
                        throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Error reading non-2xx response body", e2, dataSpec, 1);
                    }
                }
                java.lang.String contentType = this.m.getContentType();
                com.google.common.base.Predicate<java.lang.String> predicate = this.k;
                if (predicate != null && !predicate.apply(contentType)) {
                    a();
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
                }
                if (this.p == 200) {
                    long j2 = dataSpec.position;
                    if (j2 != 0) {
                        j = j2;
                    }
                }
                this.q = j;
                boolean d = d(this.m);
                if (d) {
                    this.r = dataSpec.length;
                } else {
                    long j3 = dataSpec.length;
                    if (j3 != -1) {
                        this.r = j3;
                    } else {
                        long b = b(this.m);
                        this.r = b != -1 ? b - this.q : -1L;
                    }
                }
                try {
                    this.n = this.m.getInputStream();
                    if (d) {
                        this.n = new java.util.zip.GZIPInputStream(this.n);
                    }
                    this.o = true;
                    transferStarted(dataSpec);
                    return this.r;
                } catch (java.io.IOException e3) {
                    a();
                    throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e3, dataSpec, 1);
                }
            } catch (java.io.IOException e4) {
                a();
                throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Unable to connect", e4, dataSpec, 1);
            }
        } catch (java.io.IOException e5) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException("Unable to connect", e5, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        try {
            j();
            return i(bArr, i, i2);
        } catch (java.io.IOException e) {
            throw new com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException(e, this.l, 2);
        }
    }

    public void setContentTypePredicate(@androidx.annotation.Nullable com.google.common.base.Predicate<java.lang.String> predicate) {
        this.k = predicate;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(java.lang.String str, java.lang.String str2) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
        this.j.set(str, str2);
    }
}
