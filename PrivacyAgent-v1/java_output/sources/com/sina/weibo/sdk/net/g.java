package com.sina.weibo.sdk.net;

/* loaded from: classes19.dex */
public final class g implements com.sina.weibo.sdk.net.f {
    private int code;
    private java.io.InputStream q;

    public g(int i, java.io.InputStream inputStream) {
        this.code = i;
        this.q = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.f
    public final java.lang.String j() {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.q.read(bArr);
                if (read == -1) {
                    java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException e) {
            throw e;
        }
    }
}
