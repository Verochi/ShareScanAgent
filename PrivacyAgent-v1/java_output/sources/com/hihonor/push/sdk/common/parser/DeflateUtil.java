package com.hihonor.push.sdk.common.parser;

/* loaded from: classes22.dex */
public class DeflateUtil {
    public static java.lang.String unZipString(byte[] bArr) {
        java.util.zip.Inflater inflater = new java.util.zip.Inflater();
        inflater.setInput(bArr);
        byte[] bArr2 = new byte[256];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(256);
        while (!inflater.finished()) {
            try {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            } catch (java.util.zip.DataFormatException unused) {
                inflater.end();
                return null;
            } catch (java.lang.Throwable th) {
                inflater.end();
                throw th;
            }
        }
        inflater.end();
        return byteArrayOutputStream.toString("utf-8");
    }

    public static byte[] zipByte(java.lang.String str) {
        java.util.zip.Deflater deflater = new java.util.zip.Deflater(9);
        deflater.setInput(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        deflater.finish();
        byte[] bArr = new byte[256];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(256);
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
