package okhttp3;

/* loaded from: classes23.dex */
public abstract class RequestBody {

    /* renamed from: okhttp3.RequestBody$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.RequestBody {
        public final /* synthetic */ okhttp3.MediaType a;
        public final /* synthetic */ okio.ByteString b;

        public AnonymousClass1(okhttp3.MediaType mediaType, okio.ByteString byteString) {
            this.a = mediaType;
            this.b = byteString;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws java.io.IOException {
            return this.b.size();
        }

        @Override // okhttp3.RequestBody
        @javax.annotation.Nullable
        public okhttp3.MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
            bufferedSink.write(this.b);
        }
    }

    /* renamed from: okhttp3.RequestBody$2, reason: invalid class name */
    public class AnonymousClass2 extends okhttp3.RequestBody {
        public final /* synthetic */ okhttp3.MediaType a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ int d;

        public AnonymousClass2(okhttp3.MediaType mediaType, int i, byte[] bArr, int i2) {
            this.a = mediaType;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.b;
        }

        @Override // okhttp3.RequestBody
        @javax.annotation.Nullable
        public okhttp3.MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
            bufferedSink.write(this.c, this.d, this.b);
        }
    }

    /* renamed from: okhttp3.RequestBody$3, reason: invalid class name */
    public class AnonymousClass3 extends okhttp3.RequestBody {
        public final /* synthetic */ okhttp3.MediaType a;
        public final /* synthetic */ java.io.File b;

        public AnonymousClass3(okhttp3.MediaType mediaType, java.io.File file) {
            this.a = mediaType;
            this.b = file;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.b.length();
        }

        @Override // okhttp3.RequestBody
        @javax.annotation.Nullable
        public okhttp3.MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
            okio.Source source = okio.Okio.source(this.b);
            try {
                bufferedSink.writeAll(source);
                if (source != null) {
                    source.close();
                }
            } catch (java.lang.Throwable th) {
                try {
                    throw th;
                } catch (java.lang.Throwable th2) {
                    if (source != null) {
                        try {
                            source.close();
                        } catch (java.lang.Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, java.io.File file) {
        if (file != null) {
            return new okhttp3.RequestBody.AnonymousClass3(mediaType, file);
        }
        throw new java.lang.NullPointerException("file == null");
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = java.nio.charset.StandardCharsets.UTF_8;
            mediaType = okhttp3.MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, okio.ByteString byteString) {
        return new okhttp3.RequestBody.AnonymousClass1(mediaType, byteString);
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static okhttp3.RequestBody create(@javax.annotation.Nullable okhttp3.MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("content == null");
        }
        okhttp3.internal.Util.checkOffsetAndCount(bArr.length, i, i2);
        return new okhttp3.RequestBody.AnonymousClass2(mediaType, i2, bArr, i);
    }

    public long contentLength() throws java.io.IOException {
        return -1L;
    }

    @javax.annotation.Nullable
    public abstract okhttp3.MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException;
}
