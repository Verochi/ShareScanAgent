package okhttp3;

/* loaded from: classes23.dex */
public final class MultipartBody extends okhttp3.RequestBody {
    public final okio.ByteString a;
    public final okhttp3.MediaType b;
    public final okhttp3.MediaType c;
    public final java.util.List<okhttp3.MultipartBody.Part> d;
    public long e = -1;
    public static final okhttp3.MediaType MIXED = okhttp3.MediaType.get("multipart/mixed");
    public static final okhttp3.MediaType ALTERNATIVE = okhttp3.MediaType.get("multipart/alternative");
    public static final okhttp3.MediaType DIGEST = okhttp3.MediaType.get("multipart/digest");
    public static final okhttp3.MediaType PARALLEL = okhttp3.MediaType.get("multipart/parallel");
    public static final okhttp3.MediaType FORM = okhttp3.MediaType.get("multipart/form-data");
    public static final byte[] f = {58, 32};
    public static final byte[] g = {13, 10};
    public static final byte[] h = {45, 45};

    public static final class Builder {
        public final okio.ByteString a;
        public okhttp3.MediaType b;
        public final java.util.List<okhttp3.MultipartBody.Part> c;

        public Builder() {
            this(java.util.UUID.randomUUID().toString());
        }

        public Builder(java.lang.String str) {
            this.b = okhttp3.MultipartBody.MIXED;
            this.c = new java.util.ArrayList();
            this.a = okio.ByteString.encodeUtf8(str);
        }

        public okhttp3.MultipartBody.Builder addFormDataPart(java.lang.String str, java.lang.String str2) {
            return addPart(okhttp3.MultipartBody.Part.createFormData(str, str2));
        }

        public okhttp3.MultipartBody.Builder addFormDataPart(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, okhttp3.RequestBody requestBody) {
            return addPart(okhttp3.MultipartBody.Part.createFormData(str, str2, requestBody));
        }

        public okhttp3.MultipartBody.Builder addPart(@javax.annotation.Nullable okhttp3.Headers headers, okhttp3.RequestBody requestBody) {
            return addPart(okhttp3.MultipartBody.Part.create(headers, requestBody));
        }

        public okhttp3.MultipartBody.Builder addPart(okhttp3.MultipartBody.Part part) {
            if (part == null) {
                throw new java.lang.NullPointerException("part == null");
            }
            this.c.add(part);
            return this;
        }

        public okhttp3.MultipartBody.Builder addPart(okhttp3.RequestBody requestBody) {
            return addPart(okhttp3.MultipartBody.Part.create(requestBody));
        }

        public okhttp3.MultipartBody build() {
            if (this.c.isEmpty()) {
                throw new java.lang.IllegalStateException("Multipart body must have at least one part.");
            }
            return new okhttp3.MultipartBody(this.a, this.b, this.c);
        }

        public okhttp3.MultipartBody.Builder setType(okhttp3.MediaType mediaType) {
            if (mediaType == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (mediaType.type().equals("multipart")) {
                this.b = mediaType;
                return this;
            }
            throw new java.lang.IllegalArgumentException("multipart != " + mediaType);
        }
    }

    public static final class Part {

        @javax.annotation.Nullable
        public final okhttp3.Headers a;
        public final okhttp3.RequestBody b;

        public Part(@javax.annotation.Nullable okhttp3.Headers headers, okhttp3.RequestBody requestBody) {
            this.a = headers;
            this.b = requestBody;
        }

        public static okhttp3.MultipartBody.Part create(@javax.annotation.Nullable okhttp3.Headers headers, okhttp3.RequestBody requestBody) {
            if (requestBody == null) {
                throw new java.lang.NullPointerException("body == null");
            }
            if (headers != null && headers.get("Content-Type") != null) {
                throw new java.lang.IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new okhttp3.MultipartBody.Part(headers, requestBody);
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static okhttp3.MultipartBody.Part create(okhttp3.RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static okhttp3.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2) {
            return createFormData(str, null, okhttp3.RequestBody.create((okhttp3.MediaType) null, str2));
        }

        public static okhttp3.MultipartBody.Part createFormData(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, okhttp3.RequestBody requestBody) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("form-data; name=");
            okhttp3.MultipartBody.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                okhttp3.MultipartBody.a(sb, str2);
            }
            return create(new okhttp3.Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), requestBody);
        }

        public okhttp3.RequestBody body() {
            return this.b;
        }

        @javax.annotation.Nullable
        public okhttp3.Headers headers() {
            return this.a;
        }
    }

    public MultipartBody(okio.ByteString byteString, okhttp3.MediaType mediaType, java.util.List<okhttp3.MultipartBody.Part> list) {
        this.a = byteString;
        this.b = mediaType;
        this.c = okhttp3.MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.d = okhttp3.internal.Util.immutableList(list);
    }

    public static void a(java.lang.StringBuilder sb, java.lang.String str) {
        sb.append(kotlin.text.Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(kotlin.text.Typography.quote);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b(@javax.annotation.Nullable okio.BufferedSink bufferedSink, boolean z) throws java.io.IOException {
        okio.Buffer buffer;
        if (z) {
            bufferedSink = new okio.Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.d.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            okhttp3.MultipartBody.Part part = this.d.get(i);
            okhttp3.Headers headers = part.a;
            okhttp3.RequestBody requestBody = part.b;
            bufferedSink.write(h);
            bufferedSink.write(this.a);
            bufferedSink.write(g);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(headers.name(i2)).write(f).writeUtf8(headers.value(i2)).write(g);
                }
            }
            okhttp3.MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(g);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(g);
            } else if (z) {
                buffer.clear();
                return -1L;
            }
            byte[] bArr = g;
            bufferedSink.write(bArr);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = h;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.a);
        bufferedSink.write(bArr2);
        bufferedSink.write(g);
        if (!z) {
            return j;
        }
        long size3 = j + buffer.size();
        buffer.clear();
        return size3;
    }

    public java.lang.String boundary() {
        return this.a.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws java.io.IOException {
        long j = this.e;
        if (j != -1) {
            return j;
        }
        long b = b(null, true);
        this.e = b;
        return b;
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return this.c;
    }

    public okhttp3.MultipartBody.Part part(int i) {
        return this.d.get(i);
    }

    public java.util.List<okhttp3.MultipartBody.Part> parts() {
        return this.d;
    }

    public int size() {
        return this.d.size();
    }

    public okhttp3.MediaType type() {
        return this.b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        b(bufferedSink, false);
    }
}
