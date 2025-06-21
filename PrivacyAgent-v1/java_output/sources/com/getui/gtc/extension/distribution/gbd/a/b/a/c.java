package com.getui.gtc.extension.distribution.gbd.a.b.a;

/* loaded from: classes22.dex */
public final class c {
    private static final java.lang.String a = "G_E_M";
    private java.lang.String b;
    private final byte[] c;
    private final char[] d;

    public static class a {
        private static final com.getui.gtc.extension.distribution.gbd.a.b.a.c a = new com.getui.gtc.extension.distribution.gbd.a.b.a.c((byte) 0);

        private a() {
        }
    }

    private c() {
        this.b = null;
        this.c = new byte[128];
        this.d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            this.b = a("MD5", "");
            for (int i = 0; i < 128; i++) {
                this.c[i] = -1;
            }
            for (int i2 = 65; i2 <= 90; i2++) {
                this.c[i2] = (byte) (i2 - 65);
            }
            for (int i3 = 97; i3 <= 122; i3++) {
                this.c[i3] = (byte) ((i3 - 97) + 26);
            }
            for (int i4 = 48; i4 <= 57; i4++) {
                this.c[i4] = (byte) ((i4 - 48) + 52);
            }
            byte[] bArr = this.c;
            bArr[43] = 62;
            bArr[47] = 63;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private static com.getui.gtc.extension.distribution.gbd.a.b.a.c a() {
        return com.getui.gtc.extension.distribution.gbd.a.b.a.c.a.a;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            byte[] a2 = a(str2.getBytes("UTF-8"), str);
            int length = a2.length;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(length * 2);
            for (int i = 0; i < length; i++) {
                sb.append(this.d[(a2[i] >> 4) & 15]);
                sb.append(this.d[a2[i] & 15]);
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private java.lang.String a(byte[] bArr) {
        int length = bArr.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            sb.append(this.d[(bArr[i] >> 4) & 15]);
            sb.append(this.d[bArr[i] & 15]);
        }
        return sb.toString();
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> b() {
        java.util.Map<java.lang.String, java.lang.String> b = com.getui.gtc.extension.distribution.gbd.a.b.a.b.a().b();
        java.lang.String str = b.get("a2");
        java.lang.String str2 = b.get("a4");
        java.lang.String a2 = a(str);
        java.lang.String a3 = a(str2);
        b.put("a2", a2);
        b.put("a4", a3);
        return b;
    }

    private static javax.crypto.spec.SecretKeySpec b(java.lang.String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (java.lang.Throwable unused) {
            bArr = null;
        }
        return new javax.crypto.spec.SecretKeySpec(bArr, "AES");
    }

    private byte[] b(byte[] bArr, java.lang.String str) {
        try {
            javax.crypto.spec.SecretKeySpec b = b(str);
            javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec(c());
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, b, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private byte[] c() {
        try {
            java.lang.String[] split = new java.lang.StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = java.lang.Byte.parseByte(split[i]);
            }
            java.lang.String[] split2 = new java.lang.StringBuffer(new java.lang.String(c(new java.lang.String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = java.lang.Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (java.lang.Throwable unused) {
            return new byte[16];
        }
    }

    private byte[] c(java.lang.String str) {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] d = d(str);
        int length = d.length;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(length);
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b = this.c[d[i3]];
                if (i >= length || b != -1) {
                    break;
                }
                i3 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = this.c[d[i]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & org.apache.tools.tar.TarConstants.LF_NORMAL) >>> 4));
            while (i2 != length) {
                int i4 = i2 + 1;
                byte b3 = d[i2];
                if (b3 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b4 = this.c[b3];
                if (i4 >= length || b4 != -1) {
                    if (b4 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b4 & 60) >>> 2));
                    while (i4 != length) {
                        int i5 = i4 + 1;
                        byte b5 = d[i4];
                        if (b5 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b6 = this.c[b5];
                        if (i5 < length && b6 == -1) {
                            i4 = i5;
                        } else {
                            if (b6 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b6 | ((b4 & 3) << 6));
                            i3 = i5;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i2 = i4;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public final java.lang.String a(java.lang.String str) {
        return new java.lang.String(b(c(str), this.b));
    }
}
