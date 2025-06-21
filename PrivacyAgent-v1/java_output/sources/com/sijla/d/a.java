package com.sijla.d;

/* loaded from: classes19.dex */
public final class a {
    private static final char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static int a(char c) {
        int i;
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            i = c - 'a';
        } else {
            if (c < '0' || c > '9') {
                if (c == '+') {
                    return 62;
                }
                if (c == '/') {
                    return 63;
                }
                if (c == '=') {
                    return 0;
                }
                throw new java.lang.RuntimeException("unexpected code: ".concat(java.lang.String.valueOf(c)));
            }
            i = (c - '0') + 26;
        }
        return i + 26;
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.String str;
        int length = bArr.length;
        java.lang.StringBuilder sb = new java.lang.StringBuilder((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        loop0: while (true) {
            int i3 = 0;
            while (i2 <= i) {
                int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                char[] cArr = a;
                sb.append(cArr[(i4 >> 18) & 63]);
                sb.append(cArr[(i4 >> 12) & 63]);
                sb.append(cArr[(i4 >> 6) & 63]);
                sb.append(cArr[i4 & 63]);
                i2 += 3;
                int i5 = i3 + 1;
                if (i3 >= 14) {
                    break;
                }
                i3 = i5;
            }
            sb.append(" ");
        }
        if (i2 != length - 2) {
            if (i2 == length - 1) {
                int i6 = (bArr[i2] & 255) << 16;
                char[] cArr2 = a;
                sb.append(cArr2[(i6 >> 18) & 63]);
                sb.append(cArr2[(i6 >> 12) & 63]);
                str = "==";
            }
            return sb.toString();
        }
        int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
        char[] cArr3 = a;
        sb.append(cArr3[(i7 >> 18) & 63]);
        sb.append(cArr3[(i7 >> 12) & 63]);
        sb.append(cArr3[(i7 >> 6) & 63]);
        str = com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER;
        sb.append(str);
        return sb.toString();
    }

    private static void a(java.lang.String str, java.io.OutputStream outputStream) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else {
                if (i == length) {
                    return;
                }
                int i2 = i + 2;
                int i3 = i + 3;
                int a2 = (a(str.charAt(i)) << 18) + (a(str.charAt(i + 1)) << 12) + (a(str.charAt(i2)) << 6) + a(str.charAt(i3));
                outputStream.write((a2 >> 16) & 255);
                if (str.charAt(i2) == '=') {
                    return;
                }
                outputStream.write((a2 >> 8) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write(a2 & 255);
                i += 4;
            }
        }
    }

    public static byte[] a(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                a(str, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (java.io.IOException unused) {
                    return byteArray;
                }
            } catch (java.io.IOException unused2) {
                return null;
            }
        } catch (java.lang.Exception unused3) {
            byteArrayOutputStream.close();
            return null;
        } catch (java.lang.Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (java.io.IOException unused4) {
            }
            throw th;
        }
    }
}
