package org.apache.tools.zip;

/* loaded from: classes26.dex */
public abstract class ZipEncodingHelper {
    public static final java.util.Map<java.lang.String, org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder> a;
    public static final byte[] b;
    public static final org.apache.tools.zip.ZipEncoding c;

    public static class SimpleEncodingHolder {
        public final char[] a;
        public org.apache.tools.zip.Simple8BitZipEncoding b;

        public SimpleEncodingHolder(char[] cArr) {
            this.a = cArr;
        }

        public synchronized org.apache.tools.zip.Simple8BitZipEncoding a() {
            if (this.b == null) {
                this.b = new org.apache.tools.zip.Simple8BitZipEncoding(this.a);
            }
            return this.b;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder simpleEncodingHolder = new org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, kotlin.text.Typography.cent, kotlin.text.Typography.pound, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, kotlin.text.Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, kotlin.text.Typography.plusMinus, kotlin.text.Typography.greaterOrEqual, kotlin.text.Typography.lessOrEqual, 8992, 8993, 247, kotlin.text.Typography.almostEqual, kotlin.text.Typography.degree, 8729, kotlin.text.Typography.middleDot, 8730, 8319, 178, 9632, kotlin.text.Typography.nbsp});
        hashMap.put("CP437", simpleEncodingHolder);
        hashMap.put("Cp437", simpleEncodingHolder);
        hashMap.put("cp437", simpleEncodingHolder);
        hashMap.put("IBM437", simpleEncodingHolder);
        hashMap.put("ibm437", simpleEncodingHolder);
        org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder simpleEncodingHolder2 = new org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 248, kotlin.text.Typography.pound, 216, kotlin.text.Typography.times, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, kotlin.text.Typography.registered, 172, kotlin.text.Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 193, 194, 192, kotlin.text.Typography.copyright, 9571, 9553, 9559, 9565, kotlin.text.Typography.cent, 165, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 227, 195, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 164, 240, 208, 202, 203, 200, 305, 205, 206, 207, 9496, 9484, 9608, 9604, 166, 204, 9600, 211, 223, 212, 210, 245, 213, 181, 254, 222, 218, 219, 217, 253, 221, 175, 180, 173, kotlin.text.Typography.plusMinus, 8215, 190, kotlin.text.Typography.paragraph, kotlin.text.Typography.section, 247, 184, kotlin.text.Typography.degree, 168, kotlin.text.Typography.middleDot, 185, 179, 178, 9632, kotlin.text.Typography.nbsp});
        hashMap.put("CP850", simpleEncodingHolder2);
        hashMap.put(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850, simpleEncodingHolder2);
        hashMap.put("cp850", simpleEncodingHolder2);
        hashMap.put("IBM850", simpleEncodingHolder2);
        hashMap.put("ibm850", simpleEncodingHolder2);
        a = java.util.Collections.unmodifiableMap(hashMap);
        b = new byte[]{org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70};
        c = new org.apache.tools.zip.FallbackZipEncoding(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
    }

    public static void a(java.nio.ByteBuffer byteBuffer, char c2) {
        byteBuffer.put((byte) 37);
        byteBuffer.put((byte) 85);
        byte[] bArr = b;
        byteBuffer.put(bArr[(c2 >> '\f') & 15]);
        byteBuffer.put(bArr[(c2 >> '\b') & 15]);
        byteBuffer.put(bArr[(c2 >> 4) & 15]);
        byteBuffer.put(bArr[c2 & 15]);
    }

    public static java.nio.ByteBuffer b(java.nio.ByteBuffer byteBuffer, int i) {
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.rewind();
        int capacity = byteBuffer.capacity() * 2;
        if (capacity >= i) {
            i = capacity;
        }
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        allocate.put(byteBuffer);
        return allocate;
    }

    public static boolean c(java.lang.String str) {
        if (str == null) {
            str = java.lang.System.getProperty("file.encoding");
        }
        return net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8.equalsIgnoreCase(str) || "utf-8".equalsIgnoreCase(str);
    }

    public static org.apache.tools.zip.ZipEncoding getZipEncoding(java.lang.String str) {
        if (c(str)) {
            return c;
        }
        if (str == null) {
            return new org.apache.tools.zip.FallbackZipEncoding();
        }
        org.apache.tools.zip.ZipEncodingHelper.SimpleEncodingHolder simpleEncodingHolder = a.get(str);
        if (simpleEncodingHolder != null) {
            return simpleEncodingHolder.a();
        }
        try {
            return new org.apache.tools.zip.NioZipEncoding(java.nio.charset.Charset.forName(str));
        } catch (java.nio.charset.UnsupportedCharsetException unused) {
            return new org.apache.tools.zip.FallbackZipEncoding(str);
        }
    }
}
