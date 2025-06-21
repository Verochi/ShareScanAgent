package cn.fly.verify;

/* loaded from: classes.dex */
public class fi {
    public static java.lang.String a(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] a = a(fileInputStream);
                cn.fly.verify.dw.a(fileInputStream);
                if (a == null) {
                    return null;
                }
                return c(a);
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    cn.fly.verify.ed.a().b(th);
                    cn.fly.verify.dw.a(fileInputStream);
                    return null;
                } catch (java.lang.Throwable th2) {
                    cn.fly.verify.dw.a(fileInputStream);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr) throws java.lang.Throwable {
        if (str == null || bArr == null) {
            return null;
        }
        return new java.lang.String(b(str.getBytes("UTF-8"), bArr), "UTF-8").trim();
    }

    public static java.lang.String a(byte[] bArr, int i, int i2) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(bArr[i])));
            i++;
        }
        return stringBuffer.toString();
    }

    public static void a(java.lang.String str, java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.lang.Throwable {
        if (str == null) {
            return;
        }
        a(str.getBytes("UTF-8"), inputStream, outputStream);
    }

    public static void a(byte[] bArr, java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.lang.Throwable {
        if (bArr == null || inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr2 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, cn.fly.verify.bj.a("003Gfmhifk"));
        javax.crypto.Cipher b = b(cn.fly.verify.bj.a("003 fmhifk") + cn.fly.verify.bj.a("003m+hihl") + cn.fly.verify.bj.a("008 gj>m=hmjdhlfkjkhm") + cn.fly.verify.bj.a("006e]ededejNfCff"), cn.fly.verify.bj.a("002Lgjhl"));
        b.init(2, secretKeySpec);
        javax.crypto.CipherInputStream cipherInputStream = null;
        try {
            javax.crypto.CipherInputStream cipherInputStream2 = new javax.crypto.CipherInputStream(inputStream, b);
            try {
                byte[] bArr3 = new byte[1024];
                while (true) {
                    int read = cipherInputStream2.read(bArr3);
                    if (read == -1) {
                        outputStream.flush();
                        cn.fly.verify.dw.a(cipherInputStream2);
                        return;
                    }
                    outputStream.write(bArr3, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                cipherInputStream = cipherInputStream2;
                cn.fly.verify.dw.a(cipherInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(java.io.InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(cn.fly.verify.bj.a("0031idglij"));
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static byte[] a(java.lang.String str) throws java.lang.Throwable {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    public static byte[] a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        java.lang.System.arraycopy(bytes, 0, bArr, 0, java.lang.Math.min(bytes.length, 16));
        return a(bArr, str2);
    }

    public static byte[] a(byte[] bArr) throws java.lang.Throwable {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(cn.fly.verify.bj.a("005Hfkgkfmilig"));
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] a(byte[] bArr, java.lang.String str) throws java.lang.Throwable {
        if (bArr == null || str == null) {
            return null;
        }
        return a(bArr, str.getBytes("UTF-8"));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, cn.fly.verify.bj.a("003Ifmhifk"));
        javax.crypto.Cipher b = b(cn.fly.verify.bj.a("003<fmhifk") + cn.fly.verify.bj.a("003mYhihl") + cn.fly.verify.bj.a("008Jgj1mThmjdhlfkjkhm") + cn.fly.verify.bj.a("006e)ededej1f-ff"), cn.fly.verify.bj.a("0025gjhl"));
        b.init(1, secretKeySpec);
        byte[] bArr3 = new byte[b.getOutputSize(bArr2.length)];
        b.doFinal(bArr3, b.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static java.lang.String b(java.lang.String str) {
        byte[] c;
        if (str == null || (c = c(str)) == null) {
            return null;
        }
        return c(c);
    }

    public static java.lang.String b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static java.lang.String b(byte[] bArr, int i, int i2) {
        byte[] c;
        if (bArr == null || (c = c(bArr, i, i2)) == null) {
            return null;
        }
        return c(c);
    }

    public static javax.crypto.Cipher b(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        javax.crypto.Cipher cipher = null;
        if (!android.text.TextUtils.isEmpty(str2)) {
            try {
                java.security.Provider provider = java.security.Security.getProvider(str2);
                if (provider != null) {
                    cipher = javax.crypto.Cipher.getInstance(str, provider);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return cipher == null ? javax.crypto.Cipher.getInstance(str, str2) : cipher;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr3, cn.fly.verify.bj.a("003)fmhifk"));
        javax.crypto.Cipher b = b(cn.fly.verify.bj.a("0038fmhifk") + cn.fly.verify.bj.a("003m4hihl") + cn.fly.verify.bj.a("0053gj9m^fifehm") + cn.fly.verify.bj.a("006eJededejNf6ff"), cn.fly.verify.bj.a("002+gjhl"));
        b.init(2, secretKeySpec);
        byte[] bArr4 = new byte[b.getOutputSize(bArr2.length)];
        b.doFinal(bArr4, b.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String encode = android.text.TextUtils.isEmpty(str) ? "" : java.net.URLEncoder.encode(str, str2);
        return android.text.TextUtils.isEmpty(encode) ? encode : encode.replace("+", "%20");
    }

    public static java.lang.String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            cArr2[i] = cArr[(b >>> 4) & 15];
            int i2 = i + 1;
            cArr2[i2] = cArr[b & 15];
            i = i2 + 1;
        }
        return new java.lang.String(cArr2);
    }

    public static java.lang.String c(byte[] bArr, byte[] bArr2) throws java.lang.Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        java.lang.System.arraycopy(bArr, 0, bArr3, 0, java.lang.Math.min(bArr.length, 16));
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr3, cn.fly.verify.bj.a("0032fmhifk"));
        javax.crypto.Cipher b = b(cn.fly.verify.bj.a("003^fmhifk") + cn.fly.verify.bj.a("003mKhihl") + cn.fly.verify.bj.a("008]gj.m,hmjdhlfkjkhm") + cn.fly.verify.bj.a("006e?ededej.f*ff"), cn.fly.verify.bj.a("0024gjhl"));
        b.init(2, secretKeySpec);
        return new java.lang.String(b.doFinal(bArr2), "UTF-8").trim();
    }

    public static byte[] c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            return e(str.getBytes("utf-8"));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static byte[] c(byte[] bArr, int i, int i2) {
        java.io.ByteArrayInputStream byteArrayInputStream;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr, i, i2);
            try {
                bArr2 = a(byteArrayInputStream);
                cn.fly.verify.dw.a(byteArrayInputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    cn.fly.verify.ed.a().b(th);
                    cn.fly.verify.dw.a(byteArrayInputStream);
                    return bArr2;
                } catch (java.lang.Throwable th2) {
                    cn.fly.verify.dw.a(byteArrayInputStream);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
        }
        return bArr2;
    }

    public static java.lang.String d(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String encodeToString = android.util.Base64.encodeToString(a(str2, str), 0);
            return encodeToString.contains("\n") ? encodeToString.replace("\n", "") : encodeToString;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
            return null;
        }
    }

    public static java.lang.String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return b(bArr, 0, bArr.length);
    }

    public static byte[] e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return c(bArr, 0, bArr.length);
    }

    public static java.lang.String f(byte[] bArr) throws java.lang.Throwable {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 56)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 48)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 40)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 32)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 24)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 16)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) (value >>> 8)) & 255)));
        sb.append(java.lang.String.format("%02x", java.lang.Integer.valueOf(((byte) value) & 255)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }
}
