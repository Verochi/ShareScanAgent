package okhttp3;

/* loaded from: classes23.dex */
public final class Cache implements java.io.Closeable, java.io.Flushable {
    public final okhttp3.internal.cache.InternalCache n;
    public final okhttp3.internal.cache.DiskLruCache t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;

    /* renamed from: okhttp3.Cache$1, reason: invalid class name */
    public class AnonymousClass1 implements okhttp3.internal.cache.InternalCache {
        public AnonymousClass1() {
        }

        @Override // okhttp3.internal.cache.InternalCache
        @javax.annotation.Nullable
        public okhttp3.Response get(okhttp3.Request request) throws java.io.IOException {
            return okhttp3.Cache.this.b(request);
        }

        @Override // okhttp3.internal.cache.InternalCache
        @javax.annotation.Nullable
        public okhttp3.internal.cache.CacheRequest put(okhttp3.Response response) throws java.io.IOException {
            return okhttp3.Cache.this.c(response);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void remove(okhttp3.Request request) throws java.io.IOException {
            okhttp3.Cache.this.e(request);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackConditionalCacheHit() {
            okhttp3.Cache.this.f();
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void trackResponse(okhttp3.internal.cache.CacheStrategy cacheStrategy) {
            okhttp3.Cache.this.g(cacheStrategy);
        }

        @Override // okhttp3.internal.cache.InternalCache
        public void update(okhttp3.Response response, okhttp3.Response response2) {
            okhttp3.Cache.this.update(response, response2);
        }
    }

    /* renamed from: okhttp3.Cache$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Iterator<java.lang.String> {
        public final java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> n;

        @javax.annotation.Nullable
        public java.lang.String t;
        public boolean u;

        public AnonymousClass2() throws java.io.IOException {
            this.n = okhttp3.Cache.this.t.snapshots();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.lang.String str = this.t;
            this.t = null;
            this.u = true;
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.t != null) {
                return true;
            }
            this.u = false;
            while (this.n.hasNext()) {
                try {
                    okhttp3.internal.cache.DiskLruCache.Snapshot next = this.n.next();
                    try {
                        continue;
                        this.t = okio.Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        next.close();
                        return true;
                    } finally {
                        try {
                            continue;
                        } finally {
                        }
                    }
                } catch (java.io.IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.u) {
                throw new java.lang.IllegalStateException("remove() before next()");
            }
            this.n.remove();
        }
    }

    public final class CacheRequestImpl implements okhttp3.internal.cache.CacheRequest {
        public final okhttp3.internal.cache.DiskLruCache.Editor a;
        public okio.Sink b;
        public okio.Sink c;
        public boolean d;

        /* renamed from: okhttp3.Cache$CacheRequestImpl$1, reason: invalid class name */
        public class AnonymousClass1 extends okio.ForwardingSink {
            public final /* synthetic */ okhttp3.Cache n;
            public final /* synthetic */ okhttp3.internal.cache.DiskLruCache.Editor t;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(okio.Sink sink, okhttp3.Cache cache, okhttp3.internal.cache.DiskLruCache.Editor editor) {
                super(sink);
                this.n = cache;
                this.t = editor;
            }

            @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                synchronized (okhttp3.Cache.this) {
                    okhttp3.Cache.CacheRequestImpl cacheRequestImpl = okhttp3.Cache.CacheRequestImpl.this;
                    if (cacheRequestImpl.d) {
                        return;
                    }
                    cacheRequestImpl.d = true;
                    okhttp3.Cache.this.u++;
                    super.close();
                    this.t.commit();
                }
            }
        }

        public CacheRequestImpl(okhttp3.internal.cache.DiskLruCache.Editor editor) {
            this.a = editor;
            okio.Sink newSink = editor.newSink(1);
            this.b = newSink;
            this.c = new okhttp3.Cache.CacheRequestImpl.AnonymousClass1(newSink, okhttp3.Cache.this, editor);
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (okhttp3.Cache.this) {
                if (this.d) {
                    return;
                }
                this.d = true;
                okhttp3.Cache.this.v++;
                okhttp3.internal.Util.closeQuietly(this.b);
                try {
                    this.a.abort();
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public okio.Sink body() {
            return this.c;
        }
    }

    public static class CacheResponseBody extends okhttp3.ResponseBody {
        public final okhttp3.internal.cache.DiskLruCache.Snapshot n;
        public final okio.BufferedSource t;

        @javax.annotation.Nullable
        public final java.lang.String u;

        @javax.annotation.Nullable
        public final java.lang.String v;

        /* renamed from: okhttp3.Cache$CacheResponseBody$1, reason: invalid class name */
        public class AnonymousClass1 extends okio.ForwardingSource {
            public final /* synthetic */ okhttp3.internal.cache.DiskLruCache.Snapshot n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(okio.Source source, okhttp3.internal.cache.DiskLruCache.Snapshot snapshot) {
                super(source);
                this.n = snapshot;
            }

            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                this.n.close();
                super.close();
            }
        }

        public CacheResponseBody(okhttp3.internal.cache.DiskLruCache.Snapshot snapshot, java.lang.String str, java.lang.String str2) {
            this.n = snapshot;
            this.u = str;
            this.v = str2;
            this.t = okio.Okio.buffer(new okhttp3.Cache.CacheResponseBody.AnonymousClass1(snapshot.getSource(1), snapshot));
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            try {
                java.lang.String str = this.v;
                if (str != null) {
                    return java.lang.Long.parseLong(str);
                }
                return -1L;
            } catch (java.lang.NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // okhttp3.ResponseBody
        public okhttp3.MediaType contentType() {
            java.lang.String str = this.u;
            if (str != null) {
                return okhttp3.MediaType.parse(str);
            }
            return null;
        }

        @Override // okhttp3.ResponseBody
        public okio.BufferedSource source() {
            return this.t;
        }
    }

    public static final class Entry {
        public static final java.lang.String k = okhttp3.internal.platform.Platform.get().getPrefix() + "-Sent-Millis";
        public static final java.lang.String l = okhttp3.internal.platform.Platform.get().getPrefix() + "-Received-Millis";
        public final java.lang.String a;
        public final okhttp3.Headers b;
        public final java.lang.String c;
        public final okhttp3.Protocol d;
        public final int e;
        public final java.lang.String f;
        public final okhttp3.Headers g;

        @javax.annotation.Nullable
        public final okhttp3.Handshake h;
        public final long i;
        public final long j;

        public Entry(okhttp3.Response response) {
            this.a = response.request().url().toString();
            this.b = okhttp3.internal.http.HttpHeaders.varyHeaders(response);
            this.c = response.request().method();
            this.d = response.protocol();
            this.e = response.code();
            this.f = response.message();
            this.g = response.headers();
            this.h = response.handshake();
            this.i = response.sentRequestAtMillis();
            this.j = response.receivedResponseAtMillis();
        }

        public Entry(okio.Source source) throws java.io.IOException {
            try {
                okio.BufferedSource buffer = okio.Okio.buffer(source);
                this.a = buffer.readUtf8LineStrict();
                this.c = buffer.readUtf8LineStrict();
                okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
                int d = okhttp3.Cache.d(buffer);
                for (int i = 0; i < d; i++) {
                    builder.a(buffer.readUtf8LineStrict());
                }
                this.b = builder.build();
                okhttp3.internal.http.StatusLine parse = okhttp3.internal.http.StatusLine.parse(buffer.readUtf8LineStrict());
                this.d = parse.protocol;
                this.e = parse.code;
                this.f = parse.message;
                okhttp3.Headers.Builder builder2 = new okhttp3.Headers.Builder();
                int d2 = okhttp3.Cache.d(buffer);
                for (int i2 = 0; i2 < d2; i2++) {
                    builder2.a(buffer.readUtf8LineStrict());
                }
                java.lang.String str = k;
                java.lang.String str2 = builder2.get(str);
                java.lang.String str3 = l;
                java.lang.String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.i = str2 != null ? java.lang.Long.parseLong(str2) : 0L;
                this.j = str4 != null ? java.lang.Long.parseLong(str4) : 0L;
                this.g = builder2.build();
                if (a()) {
                    java.lang.String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new java.io.IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.h = okhttp3.Handshake.get(!buffer.exhausted() ? okhttp3.TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : okhttp3.TlsVersion.SSL_3_0, okhttp3.CipherSuite.forJavaName(buffer.readUtf8LineStrict()), c(buffer), c(buffer));
                } else {
                    this.h = null;
                }
            } finally {
                source.close();
            }
        }

        public final boolean a() {
            return this.a.startsWith("https://");
        }

        public boolean b(okhttp3.Request request, okhttp3.Response response) {
            return this.a.equals(request.url().toString()) && this.c.equals(request.method()) && okhttp3.internal.http.HttpHeaders.varyMatches(response, this.b, request);
        }

        public final java.util.List<java.security.cert.Certificate> c(okio.BufferedSource bufferedSource) throws java.io.IOException {
            int d = okhttp3.Cache.d(bufferedSource);
            if (d == -1) {
                return java.util.Collections.emptyList();
            }
            try {
                java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                java.util.ArrayList arrayList = new java.util.ArrayList(d);
                for (int i = 0; i < d; i++) {
                    java.lang.String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    okio.Buffer buffer = new okio.Buffer();
                    buffer.write(okio.ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (java.security.cert.CertificateException e) {
                throw new java.io.IOException(e.getMessage());
            }
        }

        public okhttp3.Response d(okhttp3.internal.cache.DiskLruCache.Snapshot snapshot) {
            java.lang.String str = this.g.get("Content-Type");
            java.lang.String str2 = this.g.get("Content-Length");
            return new okhttp3.Response.Builder().request(new okhttp3.Request.Builder().url(this.a).method(this.c, null).headers(this.b).build()).protocol(this.d).code(this.e).message(this.f).headers(this.g).body(new okhttp3.Cache.CacheResponseBody(snapshot, str, str2)).handshake(this.h).sentRequestAtMillis(this.i).receivedResponseAtMillis(this.j).build();
        }

        public final void e(okio.BufferedSink bufferedSink, java.util.List<java.security.cert.Certificate> list) throws java.io.IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(okio.ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (java.security.cert.CertificateEncodingException e) {
                throw new java.io.IOException(e.getMessage());
            }
        }

        public void f(okhttp3.internal.cache.DiskLruCache.Editor editor) throws java.io.IOException {
            okio.BufferedSink buffer = okio.Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.a).writeByte(10);
            buffer.writeUtf8(this.c).writeByte(10);
            buffer.writeDecimalLong(this.b.size()).writeByte(10);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.b.name(i)).writeUtf8(": ").writeUtf8(this.b.value(i)).writeByte(10);
            }
            buffer.writeUtf8(new okhttp3.internal.http.StatusLine(this.d, this.e, this.f).toString()).writeByte(10);
            buffer.writeDecimalLong(this.g.size() + 2).writeByte(10);
            int size2 = this.g.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.g.name(i2)).writeUtf8(": ").writeUtf8(this.g.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.i).writeByte(10);
            buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.h.cipherSuite().javaName()).writeByte(10);
                e(buffer, this.h.peerCertificates());
                e(buffer, this.h.localCertificates());
                buffer.writeUtf8(this.h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }
    }

    public Cache(java.io.File file, long j) {
        this(file, j, okhttp3.internal.io.FileSystem.SYSTEM);
    }

    public Cache(java.io.File file, long j, okhttp3.internal.io.FileSystem fileSystem) {
        this.n = new okhttp3.Cache.AnonymousClass1();
        this.t = okhttp3.internal.cache.DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    public static int d(okio.BufferedSource bufferedSource) throws java.io.IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            java.lang.String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new java.io.IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (java.lang.NumberFormatException e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    public static java.lang.String key(okhttp3.HttpUrl httpUrl) {
        return okio.ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    public final void a(@javax.annotation.Nullable okhttp3.internal.cache.DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (java.io.IOException unused) {
            }
        }
    }

    @javax.annotation.Nullable
    public okhttp3.Response b(okhttp3.Request request) {
        try {
            okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.t.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(snapshot.getSource(0));
                okhttp3.Response d = entry.d(snapshot);
                if (entry.b(request, d)) {
                    return d;
                }
                okhttp3.internal.Util.closeQuietly(d.body());
                return null;
            } catch (java.io.IOException unused) {
                okhttp3.internal.Util.closeQuietly(snapshot);
                return null;
            }
        } catch (java.io.IOException unused2) {
        }
    }

    @javax.annotation.Nullable
    public okhttp3.internal.cache.CacheRequest c(okhttp3.Response response) {
        okhttp3.internal.cache.DiskLruCache.Editor editor;
        java.lang.String method = response.request().method();
        if (okhttp3.internal.http.HttpMethod.invalidatesCache(response.request().method())) {
            try {
                e(response.request());
            } catch (java.io.IOException unused) {
            }
            return null;
        }
        if (!method.equals("GET") || okhttp3.internal.http.HttpHeaders.hasVaryAll(response)) {
            return null;
        }
        okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(response);
        try {
            editor = this.t.edit(key(response.request().url()));
            if (editor == null) {
                return null;
            }
            try {
                entry.f(editor);
                return new okhttp3.Cache.CacheRequestImpl(editor);
            } catch (java.io.IOException unused2) {
                a(editor);
                return null;
            }
        } catch (java.io.IOException unused3) {
            editor = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.t.close();
    }

    public void delete() throws java.io.IOException {
        this.t.delete();
    }

    public java.io.File directory() {
        return this.t.getDirectory();
    }

    public void e(okhttp3.Request request) throws java.io.IOException {
        this.t.remove(key(request.url()));
    }

    public void evictAll() throws java.io.IOException {
        this.t.evictAll();
    }

    public synchronized void f() {
        this.x++;
    }

    @Override // java.io.Flushable
    public void flush() throws java.io.IOException {
        this.t.flush();
    }

    public synchronized void g(okhttp3.internal.cache.CacheStrategy cacheStrategy) {
        this.y++;
        if (cacheStrategy.networkRequest != null) {
            this.w++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.x++;
        }
    }

    public synchronized int hitCount() {
        return this.x;
    }

    public void initialize() throws java.io.IOException {
        this.t.initialize();
    }

    public boolean isClosed() {
        return this.t.isClosed();
    }

    public long maxSize() {
        return this.t.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.w;
    }

    public synchronized int requestCount() {
        return this.y;
    }

    public long size() throws java.io.IOException {
        return this.t.size();
    }

    public void update(okhttp3.Response response, okhttp3.Response response2) {
        okhttp3.internal.cache.DiskLruCache.Editor editor;
        okhttp3.Cache.Entry entry = new okhttp3.Cache.Entry(response2);
        try {
            editor = ((okhttp3.Cache.CacheResponseBody) response.body()).n.edit();
            if (editor != null) {
                try {
                    entry.f(editor);
                    editor.commit();
                } catch (java.io.IOException unused) {
                    a(editor);
                }
            }
        } catch (java.io.IOException unused2) {
            editor = null;
        }
    }

    public java.util.Iterator<java.lang.String> urls() throws java.io.IOException {
        return new okhttp3.Cache.AnonymousClass2();
    }

    public synchronized int writeAbortCount() {
        return this.v;
    }

    public synchronized int writeSuccessCount() {
        return this.u;
    }
}
