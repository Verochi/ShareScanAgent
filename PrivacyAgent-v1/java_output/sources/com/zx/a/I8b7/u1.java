package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public abstract class u1 implements java.io.Closeable {

    public class a extends com.zx.a.I8b7.u1 {
        public final /* synthetic */ com.zx.a.I8b7.x0 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ java.io.InputStream c;

        public a(com.zx.a.I8b7.x0 x0Var, long j, java.io.InputStream inputStream) {
            this.a = x0Var;
            this.b = j;
            this.c = inputStream;
        }
    }

    public static com.zx.a.I8b7.u1 a(com.zx.a.I8b7.x0 x0Var, long j, java.io.InputStream inputStream) {
        if (inputStream != null) {
            return new com.zx.a.I8b7.u1.a(x0Var, j, inputStream);
        }
        throw new java.lang.NullPointerException("byte stream is null");
    }

    public final byte[] a() throws java.io.IOException {
        com.zx.a.I8b7.u1.a aVar = (com.zx.a.I8b7.u1.a) this;
        long j = aVar.b;
        if (j > 2147483647L) {
            throw new java.io.IOException("Cannot buffer entire body for content length: ".concat(java.lang.String.valueOf(j)));
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.InputStream inputStream = aVar.c;
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c2.a(inputStream);
                throw th;
            }
        }
        com.zx.a.I8b7.c2.a(inputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (j == -1 || j == byteArray.length) {
            return byteArray;
        }
        throw new java.io.IOException("Content-Length (" + j + ") and stream length (" + byteArray.length + ") disagree");
    }

    public final java.lang.String b() throws java.io.IOException {
        return new java.lang.String(a(), java.nio.charset.StandardCharsets.UTF_8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.zx.a.I8b7.c2.a(((com.zx.a.I8b7.u1.a) this).c);
    }
}
