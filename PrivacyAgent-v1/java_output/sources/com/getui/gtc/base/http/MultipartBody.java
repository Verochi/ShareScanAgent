package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public final class MultipartBody extends com.getui.gtc.base.http.RequestBody {
    private final java.lang.String boundary;
    private long contentLength = -1;
    private final com.getui.gtc.base.http.MediaType contentType;
    private final com.getui.gtc.base.http.MediaType originalType;
    private final java.util.List<com.getui.gtc.base.http.MultipartBody.Part> parts;
    public static final com.getui.gtc.base.http.MediaType MIXED = com.getui.gtc.base.http.MediaType.get("multipart/mixed");
    public static final com.getui.gtc.base.http.MediaType ALTERNATIVE = com.getui.gtc.base.http.MediaType.get("multipart/alternative");
    public static final com.getui.gtc.base.http.MediaType DIGEST = com.getui.gtc.base.http.MediaType.get("multipart/digest");
    public static final com.getui.gtc.base.http.MediaType PARALLEL = com.getui.gtc.base.http.MediaType.get("multipart/parallel");
    public static final com.getui.gtc.base.http.MediaType FORM = com.getui.gtc.base.http.MediaType.get("multipart/form-data");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    public static final class Builder {
        private final java.lang.String boundary;
        private final java.util.List<com.getui.gtc.base.http.MultipartBody.Part> parts;
        private com.getui.gtc.base.http.MediaType type;

        public Builder() {
            this(java.util.UUID.randomUUID().toString());
        }

        public Builder(java.lang.String str) {
            this.type = com.getui.gtc.base.http.MultipartBody.FORM;
            this.parts = new java.util.ArrayList();
            this.boundary = str;
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder addFormDataPart(java.lang.String str, java.lang.String str2) {
            return addPart(com.getui.gtc.base.http.MultipartBody.Part.createFormData(str, str2));
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder addFormDataPart(java.lang.String str, java.lang.String str2, com.getui.gtc.base.http.RequestBody requestBody) {
            return addPart(com.getui.gtc.base.http.MultipartBody.Part.createFormData(str, str2, requestBody));
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder addPart(com.getui.gtc.base.http.Headers headers, com.getui.gtc.base.http.RequestBody requestBody) {
            return addPart(com.getui.gtc.base.http.MultipartBody.Part.create(headers, requestBody));
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder addPart(com.getui.gtc.base.http.MultipartBody.Part part) {
            if (part == null) {
                throw new java.lang.NullPointerException("part == null");
            }
            this.parts.add(part);
            return this;
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder addPart(com.getui.gtc.base.http.RequestBody requestBody) {
            return addPart(com.getui.gtc.base.http.MultipartBody.Part.create(requestBody));
        }

        public final com.getui.gtc.base.http.MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new java.lang.IllegalStateException("Multipart body must have at least one part.");
            }
            return new com.getui.gtc.base.http.MultipartBody(this.boundary, this.type, this.parts);
        }

        public final com.getui.gtc.base.http.MultipartBody.Builder setType(com.getui.gtc.base.http.MediaType mediaType) {
            if (mediaType == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (!mediaType.type().equals("multipart")) {
                throw new java.lang.IllegalArgumentException("multipart != ".concat(java.lang.String.valueOf(mediaType)));
            }
            this.type = mediaType;
            return this;
        }
    }

    public static final class Part {
        final com.getui.gtc.base.http.RequestBody body;
        final com.getui.gtc.base.http.Headers headers;

        private Part(com.getui.gtc.base.http.Headers headers, com.getui.gtc.base.http.RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static com.getui.gtc.base.http.MultipartBody.Part create(com.getui.gtc.base.http.Headers headers, com.getui.gtc.base.http.RequestBody requestBody) {
            if (requestBody == null) {
                throw new java.lang.NullPointerException("body == null");
            }
            if (headers != null && headers.get("Content-Type") != null) {
                throw new java.lang.IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new com.getui.gtc.base.http.MultipartBody.Part(headers, requestBody);
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static com.getui.gtc.base.http.MultipartBody.Part create(com.getui.gtc.base.http.RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static com.getui.gtc.base.http.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2) {
            return createFormData(str, null, com.getui.gtc.base.http.RequestBody.create((com.getui.gtc.base.http.MediaType) null, str2));
        }

        public static com.getui.gtc.base.http.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2, com.getui.gtc.base.http.RequestBody requestBody) {
            return createFormData(str, str2, requestBody, null);
        }

        public static com.getui.gtc.base.http.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2, com.getui.gtc.base.http.RequestBody requestBody, java.lang.String str3) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("form-data; name=");
            com.getui.gtc.base.http.MultipartBody.appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                com.getui.gtc.base.http.MultipartBody.appendQuotedString(sb, str2);
            }
            com.getui.gtc.base.http.Headers.Builder addUnsafeNonAscii = new com.getui.gtc.base.http.Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString());
            if (str3 != null) {
                addUnsafeNonAscii.add("Content-Transfer-Encoding", str3);
            }
            return create(addUnsafeNonAscii.build(), requestBody);
        }

        public final com.getui.gtc.base.http.RequestBody body() {
            return this.body;
        }

        public final com.getui.gtc.base.http.Headers headers() {
            return this.headers;
        }
    }

    public MultipartBody(java.lang.String str, com.getui.gtc.base.http.MediaType mediaType, java.util.List<com.getui.gtc.base.http.MultipartBody.Part> list) {
        this.boundary = str;
        this.originalType = mediaType;
        this.contentType = com.getui.gtc.base.http.MediaType.get(mediaType + "; boundary=" + str);
        this.parts = java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public static void appendQuotedString(java.lang.StringBuilder sb, java.lang.String str) {
        java.lang.String str2;
        sb.append(kotlin.text.Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                str2 = "%0A";
            } else if (charAt == '\r') {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append(kotlin.text.Typography.quote);
    }

    private long writeOrCountBytes(java.io.OutputStream outputStream, boolean z) throws java.io.IOException {
        com.getui.gtc.base.http.BufferedSink bufferedSink;
        com.getui.gtc.base.http.BufferedSink bufferedSink2;
        if (z) {
            bufferedSink = new com.getui.gtc.base.http.BufferedSink(new java.io.ByteArrayOutputStream());
            bufferedSink2 = bufferedSink;
        } else {
            bufferedSink = new com.getui.gtc.base.http.BufferedSink(outputStream);
            bufferedSink2 = bufferedSink;
            bufferedSink = null;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            com.getui.gtc.base.http.MultipartBody.Part part = this.parts.get(i);
            com.getui.gtc.base.http.Headers headers = part.headers;
            com.getui.gtc.base.http.RequestBody requestBody = part.body;
            bufferedSink2.write(DASHDASH);
            bufferedSink2.write(this.boundary);
            bufferedSink2.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink2.writeUtf8(headers.name(i2)).write(COLONSPACE).writeUtf8(headers.value(i2)).write(CRLF);
                }
            }
            com.getui.gtc.base.http.MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                bufferedSink2.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(CRLF);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                bufferedSink2.writeUtf8("Content-Length: ").writeLong(contentLength).write(CRLF);
            } else if (z) {
                bufferedSink.close();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink2.write(bArr);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(outputStream);
            }
            bufferedSink2.write(bArr);
        }
        byte[] bArr2 = DASHDASH;
        bufferedSink2.write(bArr2);
        bufferedSink2.write(this.boundary);
        bufferedSink2.write(bArr2);
        bufferedSink2.write(CRLF);
        if (!z) {
            return j;
        }
        long size3 = j + bufferedSink.size();
        bufferedSink.close();
        return size3;
    }

    public final java.lang.String boundary() {
        return this.boundary;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final long contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        try {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final com.getui.gtc.base.http.MediaType contentType() {
        return this.contentType;
    }

    public final com.getui.gtc.base.http.MultipartBody.Part part(int i) {
        return this.parts.get(i);
    }

    public final java.util.List<com.getui.gtc.base.http.MultipartBody.Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final com.getui.gtc.base.http.MediaType type() {
        return this.originalType;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public final void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        writeOrCountBytes(outputStream, false);
    }
}
