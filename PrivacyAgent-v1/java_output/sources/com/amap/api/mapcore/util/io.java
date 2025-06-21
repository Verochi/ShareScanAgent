package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class io {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static final byte[] b = {61, 61, 81, 65, 65, 69, 119, 65, 67, org.apache.tools.tar.TarConstants.LF_NORMAL, 74, 80, 115, 116, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 104, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 122, 97, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 99, org.apache.tools.tar.TarConstants.LF_DIR, 71, org.apache.tools.tar.TarConstants.LF_LINK, 122, 68, 70, 79, 104, 113, 113, 65, 97, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, org.apache.tools.tar.TarConstants.LF_FIFO, 65, 66, 87, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 85, 84, 113, 71, 68, 69, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 80, 82, 106, org.apache.tools.tar.TarConstants.LF_CHR, 66, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 69, 98, org.apache.tools.tar.TarConstants.LF_CONTIG, 84, 108, 115, 122, org.apache.tools.tar.TarConstants.LF_CHR, 106, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, org.apache.tools.tar.TarConstants.LF_CONTIG, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 122, 70, 121, 73, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_SYMLINK, 43, 101, 70, 121, 56, 105, 115, 105, 89, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 117, 112, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 119, 65, 119, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 74, 89, 81, 68, 119, 119, 70, 77};
    private static final byte[] c;
    private static final javax.crypto.spec.IvParameterSpec d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        c = bArr;
        d = new javax.crypto.spec.IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
            java.lang.System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.amap.api.mapcore.util.fi.c()));
            return cipher.doFinal(bArr3);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Encrypt", "decryptRsponse length = ".concat(java.lang.String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }
}
