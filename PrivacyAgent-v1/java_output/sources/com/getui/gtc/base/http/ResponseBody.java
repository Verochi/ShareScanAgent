package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public abstract class ResponseBody implements java.io.Closeable {

    /* renamed from: com.getui.gtc.base.http.ResponseBody$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.base.http.ResponseBody {
        final /* synthetic */ java.io.InputStream val$byteStream;
        final /* synthetic */ long val$contentLength;
        final /* synthetic */ com.getui.gtc.base.http.MediaType val$mediaType;

        public AnonymousClass1(com.getui.gtc.base.http.MediaType mediaType, long j, java.io.InputStream inputStream) {
            this.val$mediaType = mediaType;
            this.val$contentLength = j;
            this.val$byteStream = inputStream;
        }

        @Override // com.getui.gtc.base.http.ResponseBody
        public final java.io.InputStream byteStream() {
            return this.val$byteStream;
        }

        @Override // com.getui.gtc.base.http.ResponseBody
        public final long contentLength() {
            return this.val$contentLength;
        }

        @Override // com.getui.gtc.base.http.ResponseBody
        public final com.getui.gtc.base.http.MediaType contentType() {
            return this.val$mediaType;
        }
    }

    public static com.getui.gtc.base.http.ResponseBody create(com.getui.gtc.base.http.MediaType mediaType, long j, java.io.InputStream inputStream) {
        if (inputStream != null) {
            return new com.getui.gtc.base.http.ResponseBody.AnonymousClass1(mediaType, j, inputStream);
        }
        throw new java.lang.NullPointerException("byte stream is null");
    }

    public static com.getui.gtc.base.http.ResponseBody create(com.getui.gtc.base.http.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset = com.getui.gtc.base.http.Util.UTF_8;
        if (mediaType != null) {
            java.nio.charset.Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = com.getui.gtc.base.http.MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static com.getui.gtc.base.http.ResponseBody create(com.getui.gtc.base.http.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new java.io.ByteArrayInputStream(bArr));
    }

    public abstract java.io.InputStream byteStream();

    public final byte[] bytes() throws java.io.IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new java.io.IOException("Cannot buffer entire body for content length: ".concat(java.lang.String.valueOf(contentLength)));
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.InputStream byteStream = byteStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = byteStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.base.http.Util.closeQuietly(byteStream);
                throw th;
            }
        }
        com.getui.gtc.base.http.Util.closeQuietly(byteStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (contentLength == -1 || contentLength == byteArray.length) {
            return byteArray;
        }
        throw new java.io.IOException("Content-Length (" + contentLength + ") and stream length (" + byteArray.length + ") disagree");
    }

    public final java.io.Reader charStream() {
        return new java.io.InputStreamReader(byteStream(), charset());
    }

    public java.nio.charset.Charset charset() {
        com.getui.gtc.base.http.MediaType contentType = contentType();
        return contentType != null ? contentType.charset(com.getui.gtc.base.http.Util.UTF_8) : com.getui.gtc.base.http.Util.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.getui.gtc.base.http.Util.closeQuietly(byteStream());
    }

    public abstract long contentLength();

    public abstract com.getui.gtc.base.http.MediaType contentType();

    public final void file(java.io.File file) throws java.io.IOException {
        com.getui.gtc.base.util.io.IOUtils.saveToFile(byteStream(), file);
    }

    public final java.lang.String string() throws java.io.IOException {
        return new java.lang.String(bytes(), charset());
    }
}
