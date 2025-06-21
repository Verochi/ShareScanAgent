package com.anythink.core.common.k;

/* loaded from: classes12.dex */
public final class a {
    private static java.util.Map<java.lang.Character, java.lang.Character> a;
    private static char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static char[] c = {'5', 'P', 'V', 'u', '3', 'J', 'j', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'e', 'Q', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'H', '9', 'A', 'v', 'h', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 's', 'g', 'W', 'I', 'C', 'U', 'i', 'F', '2', 'a', 'd', 'M', '8', 'D', 'y', 'Z', 'O', 'N', 'k', '/', '4', 'R', '7', '0', 'f', 'n', '+', 'z', 'G', 'Y', 'L', 'X', 'p', 'm', '1', 'E', 'K', 'S', 'T', 'o', 'x', '6', 'q', 'w', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'c', 'B'};
    private static byte[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -1, -1, -1, -1, -1, -1, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, -1, -1, -1, -1, -1};

    public static com.anythink.core.common.k.b a(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.k.b bVar = new com.anythink.core.common.k.b();
        try {
            java.security.PublicKey generatePublic = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str.getBytes(), 2)));
            int bitLength = generatePublic instanceof java.security.interfaces.RSAPublicKey ? ((java.security.interfaces.RSAPublicKey) generatePublic).getModulus().bitLength() : 0;
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            int i = (bitLength / 8) - 11;
            bVar.a(new java.lang.String(android.util.Base64.encode(i > 0 ? a(cipher, str2.getBytes(), i) : cipher.doFinal(str2.getBytes()), 2)));
        } catch (java.lang.Throwable th) {
            bVar.b(th.getMessage());
        }
        return bVar;
    }

    private static java.lang.Character a(char c2) {
        if (a == null) {
            a = new java.util.HashMap();
            for (int i = 0; i < b.length; i++) {
                a.put(java.lang.Character.valueOf(c[i]), java.lang.Character.valueOf(b[i]));
            }
        }
        return a.containsKey(java.lang.Character.valueOf(c2)) ? a.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2);
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2 = "";
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            if (charArray != null && charArray.length > 0) {
                char[] cArr = new char[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    char c2 = charArray[i];
                    if (a == null) {
                        a = new java.util.HashMap();
                        for (int i2 = 0; i2 < b.length; i2++) {
                            a.put(java.lang.Character.valueOf(c[i2]), java.lang.Character.valueOf(b[i2]));
                        }
                    }
                    cArr[i] = (a.containsKey(java.lang.Character.valueOf(c2)) ? a.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2)).charValue();
                }
                str2 = new java.lang.String(cArr);
            }
            return new java.lang.String(b(str2));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private static byte[] a(javax.crypto.Cipher cipher, byte[] bArr, int i) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = length - i2;
            if (i4 <= 0) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byte[] doFinal = i4 > i ? cipher.doFinal(bArr, i2, i) : cipher.doFinal(bArr, i2, i4);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i3++;
            i2 = i3 * i;
        }
    }

    private static byte[] b(java.lang.String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(length);
        int i5 = 0;
        while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b2 = d[bytes[i5]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i5 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = d[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & org.apache.tools.tar.TarConstants.LF_NORMAL) >>> 4));
            while (true) {
                i3 = i2 + 1;
                byte b6 = bytes[i2];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = d[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = d[b7];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
            i5 = i4;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
