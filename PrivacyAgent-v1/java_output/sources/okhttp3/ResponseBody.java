package okhttp3;

/* loaded from: classes23.dex */
public abstract class ResponseBody implements java.io.Closeable {

    @javax.annotation.Nullable
    private java.io.Reader reader;

    /* renamed from: okhttp3.ResponseBody$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.ResponseBody {
        public final /* synthetic */ okhttp3.MediaType n;
        public final /* synthetic */ long t;
        public final /* synthetic */ okio.BufferedSource u;

        public AnonymousClass1(okhttp3.MediaType mediaType, long j, okio.BufferedSource bufferedSource) {
            this.n = mediaType;
            this.t = j;
            this.u = bufferedSource;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.t;
        }

        @Override // okhttp3.ResponseBody
        @javax.annotation.Nullable
        public okhttp3.MediaType contentType() {
            return this.n;
        }

        @Override // okhttp3.ResponseBody
        public okio.BufferedSource source() {
            return this.u;
        }
    }

    public static final class BomAwareReader extends java.io.Reader {
        public final okio.BufferedSource n;
        public final java.nio.charset.Charset t;
        public boolean u;

        @javax.annotation.Nullable
        public java.io.Reader v;

        public BomAwareReader(okio.BufferedSource bufferedSource, java.nio.charset.Charset charset) {
            this.n = bufferedSource;
            this.t = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.u = true;
            java.io.Reader reader = this.v;
            if (reader != null) {
                reader.close();
            } else {
                this.n.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            if (this.u) {
                throw new java.io.IOException("Stream closed");
            }
            java.io.Reader reader = this.v;
            if (reader == null) {
                java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(this.n.inputStream(), okhttp3.internal.Util.bomAwareCharset(this.n, this.t));
                this.v = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private static /* synthetic */ void $closeResource(java.lang.Throwable th, java.lang.AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (java.lang.Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private java.nio.charset.Charset charset() {
        okhttp3.MediaType contentType = contentType();
        return contentType != null ? contentType.charset(java.nio.charset.StandardCharsets.UTF_8) : java.nio.charset.StandardCharsets.UTF_8;
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, long j, okio.BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new okhttp3.ResponseBody.AnonymousClass1(mediaType, j, bufferedSource);
        }
        throw new java.lang.NullPointerException("source == null");
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = java.nio.charset.StandardCharsets.UTF_8;
            mediaType = okhttp3.MediaType.parse(mediaType + "; charset=utf-8");
        }
        okio.Buffer writeString = new okio.Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, okio.ByteString byteString) {
        return create(mediaType, byteString.size(), new okio.Buffer().write(byteString));
    }

    public static okhttp3.ResponseBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new okio.Buffer().write(bArr));
    }

    public final java.io.InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws java.io.IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new java.io.IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        okio.BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            $closeResource(null, source);
            if (contentLength == -1 || contentLength == readByteArray.length) {
                return readByteArray;
            }
            throw new java.io.IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
        } finally {
        }
    }

    public final java.io.Reader charStream() {
        java.io.Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        okhttp3.ResponseBody.BomAwareReader bomAwareReader = new okhttp3.ResponseBody.BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @javax.annotation.Nullable
    public abstract okhttp3.MediaType contentType();

    public abstract okio.BufferedSource source();

    public final java.lang.String string() throws java.io.IOException {
        okio.BufferedSource source = source();
        try {
            java.lang.String readString = source.readString(okhttp3.internal.Util.bomAwareCharset(source, charset()));
            $closeResource(null, source);
            return readString;
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Throwable th2) {
                if (source != null) {
                    $closeResource(th, source);
                }
                throw th2;
            }
        }
    }
}
