package com.tencent.open.utils;

/* loaded from: classes19.dex */
public final class b {
    private static final com.tencent.open.utils.m a = new com.tencent.open.utils.m(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
    private static final com.tencent.open.utils.n b = new com.tencent.open.utils.n(38651);

    public static class a {
        java.util.Properties a;
        byte[] b;

        private a() {
            this.a = new java.util.Properties();
        }

        public /* synthetic */ a(com.tencent.open.utils.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(byte[] bArr) throws java.io.IOException {
            if (bArr == null) {
                return;
            }
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
            int length = com.tencent.open.utils.b.b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!com.tencent.open.utils.b.b.equals(new com.tencent.open.utils.n(bArr2))) {
                throw new java.net.ProtocolException("unknow protocl [" + java.util.Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b = new com.tencent.open.utils.n(bArr3).b();
            if ((bArr.length - length) - 2 < b) {
                return;
            }
            byte[] bArr4 = new byte[b];
            wrap.get(bArr4);
            this.a.load(new java.io.ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - b) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.b = bArr5;
                wrap.get(bArr5);
            }
        }

        public java.lang.String toString() {
            return "ApkExternalInfo [p=" + this.a + ", otherData=" + java.util.Arrays.toString(this.b) + "]";
        }
    }

    public static java.lang.String a(java.io.File file) throws java.io.IOException {
        return a(file, "channelNo");
    }

    public static java.lang.String a(java.io.File file, java.lang.String str) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "r");
            try {
                byte[] a2 = a(randomAccessFile2);
                if (a2 == null) {
                    randomAccessFile2.close();
                    return null;
                }
                com.tencent.open.utils.b.a aVar = new com.tencent.open.utils.b.a(null);
                aVar.a(a2);
                java.lang.String property = aVar.a.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = false;
            if (read == -1) {
                break;
            }
            if (read == a2[0]) {
                z = true;
                if (randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                    break;
                }
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (!z) {
            throw new java.util.zip.ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int b2 = new com.tencent.open.utils.n(bArr).b();
        if (b2 == 0) {
            return null;
        }
        byte[] bArr2 = new byte[b2];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
