package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public class jad_jt {
    public static byte[] jad_an(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
            byteArrayOutputStream.flush();
        }
    }
}
