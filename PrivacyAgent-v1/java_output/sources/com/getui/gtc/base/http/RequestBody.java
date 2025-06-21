package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public abstract class RequestBody {

    /* renamed from: com.getui.gtc.base.http.RequestBody$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.base.http.RequestBody {
        final /* synthetic */ int val$bytecount;
        final /* synthetic */ byte[] val$content;
        final /* synthetic */ com.getui.gtc.base.http.MediaType val$contentType;
        final /* synthetic */ int val$offset;

        public AnonymousClass1(com.getui.gtc.base.http.MediaType mediaType, int i, byte[] bArr, int i2) {
            this.val$contentType = mediaType;
            this.val$bytecount = i;
            this.val$content = bArr;
            this.val$offset = i2;
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final long contentLength() {
            return this.val$bytecount;
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final com.getui.gtc.base.http.MediaType contentType() {
            return this.val$contentType;
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
            outputStream.write(this.val$content, this.val$offset, this.val$bytecount);
        }
    }

    /* renamed from: com.getui.gtc.base.http.RequestBody$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.getui.gtc.base.http.RequestBody {
        final /* synthetic */ com.getui.gtc.base.http.MediaType val$contentType;
        final /* synthetic */ java.io.File val$file;

        public AnonymousClass2(com.getui.gtc.base.http.MediaType mediaType, java.io.File file) {
            this.val$contentType = mediaType;
            this.val$file = file;
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final long contentLength() {
            return this.val$file.length();
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final com.getui.gtc.base.http.MediaType contentType() {
            return this.val$contentType;
        }

        @Override // com.getui.gtc.base.http.RequestBody
        public final void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
            java.io.FileInputStream fileInputStream = null;
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(this.val$file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            com.getui.gtc.base.http.Util.closeQuietly(fileInputStream2);
                            return;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.getui.gtc.base.http.Util.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public static com.getui.gtc.base.http.RequestBody create(com.getui.gtc.base.http.MediaType mediaType, java.io.File file) {
        if (file != null) {
            return new com.getui.gtc.base.http.RequestBody.AnonymousClass2(mediaType, file);
        }
        throw new java.lang.NullPointerException("content == null");
    }

    public static com.getui.gtc.base.http.RequestBody create(com.getui.gtc.base.http.MediaType mediaType, java.lang.String str) {
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

    public static com.getui.gtc.base.http.RequestBody create(com.getui.gtc.base.http.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static com.getui.gtc.base.http.RequestBody create(com.getui.gtc.base.http.MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("content == null");
        }
        com.getui.gtc.base.http.Util.checkOffsetAndCount(bArr.length, i, i2);
        return new com.getui.gtc.base.http.RequestBody.AnonymousClass1(mediaType, i2, bArr, i);
    }

    public abstract long contentLength();

    public abstract com.getui.gtc.base.http.MediaType contentType();

    public abstract void writeTo(java.io.OutputStream outputStream) throws java.io.IOException;
}
