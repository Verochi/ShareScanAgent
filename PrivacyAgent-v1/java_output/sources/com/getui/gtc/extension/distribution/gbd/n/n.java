package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class n {
    public static final int a = 512;
    public static final java.lang.String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    static final char c = '=';
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private static int[] m;

    private static byte a(byte[] bArr, byte b2, byte b3, byte b4) {
        if (bArr != null && bArr.length != 0) {
            if ((b3 & 255) == 255 && (b4 & 255) == 255) {
                return b2;
            }
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] & 255) ^ b2);
                b2 = (byte) (b2 < b4 ? b2 + 1 : b3);
            }
        }
        return b2;
    }

    private static int a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        return 4;
    }

    private static int a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((j2 >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 7] = (byte) (j2 & 255);
        return 8;
    }

    private static int a(java.io.InputStream inputStream) {
        int i2;
        int i3 = 0;
        do {
            try {
                int read = inputStream.read();
                i3 |= read & 127;
                i2 = read & 128;
                if (i2 != 0) {
                    i3 <<= 7;
                }
            } catch (java.lang.Exception unused) {
                return 0;
            }
        } while (i2 != 0);
        return i3;
    }

    private static int a(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int[] iArr = m;
        if (iArr == null) {
            if (iArr == null) {
                m = new int[256];
            }
            for (int i4 = 0; i4 < 256; i4++) {
                int i5 = i4;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = i5 & 1;
                    i5 >>>= 1;
                    if (i7 == 1) {
                        i5 ^= -306674912;
                    }
                }
                m[i4] = i5;
            }
        }
        int i8 = -1;
        for (int i9 = i2; i9 < i3 + i2; i9++) {
            i8 = (i8 >>> 8) ^ m[(bArr[i9] ^ i8) & 255];
        }
        return i8;
    }

    private static int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        java.lang.System.arraycopy(bArr, i2, bArr2, i3, i4);
        return i4;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(str2);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            for (byte b2 : bytes) {
                if (b2 >= 0) {
                    byteArrayOutputStream.write(b2);
                } else {
                    byteArrayOutputStream.write(61);
                    for (char c2 : java.lang.Integer.toHexString(b2 & 255).toUpperCase().toCharArray()) {
                        byteArrayOutputStream.write(c2);
                    }
                }
            }
            byteArrayOutputStream.flush();
            java.lang.String str3 = new java.lang.String(byteArrayOutputStream.toByteArray(), str2);
            byteArrayOutputStream.close();
            return str3;
        } catch (java.io.IOException unused) {
            return str;
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str3 == null || str == null || str2 == null) {
            return null;
        }
        if (!str3.contains(str)) {
            return str3;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            int indexOf = str3.indexOf(str);
            if (indexOf == -1) {
                sb.append(str3);
                return sb.toString();
            }
            sb.append(str3.substring(0, indexOf));
            sb.append(str2);
            str3 = str3.substring(indexOf + str.length());
        }
    }

    private static java.lang.String a(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]);
            sb.append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    private static void a() {
        if (m == null) {
            m = new int[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = i2;
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = i3 & 1;
                i3 >>>= 1;
                if (i5 == 1) {
                    i3 ^= -306674912;
                }
            }
            m[i2] = i3;
        }
    }

    private static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static void a(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i2) {
        com.getui.gtc.extension.distribution.gbd.n.d dVar = new com.getui.gtc.extension.distribution.gbd.n.d(outputStream, i2);
        a(inputStream, dVar);
        dVar.a();
    }

    private static boolean a(java.lang.String str) {
        if (str != null) {
            java.lang.String trim = str.trim();
            if (!trim.equals("")) {
                for (char c2 : trim.toCharArray()) {
                    if (c2 < '0' || c2 > '9') {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static byte[] a(int i2) {
        int i3;
        int i4 = 0;
        int i5 = 0;
        do {
            i3 = 24;
            i4 |= (i2 & 127) << 24;
            i2 >>>= 7;
            i5++;
            if (i2 > 0) {
                i4 = (i4 >>> 8) | Integer.MIN_VALUE;
            }
        } while (i2 > 0);
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) (i4 >>> i3);
            i3 -= 8;
        }
        return bArr;
    }

    private static byte[] a(long j2) {
        return new byte[]{(byte) ((j2 >> 56) & 255), (byte) ((j2 >> 48) & 255), (byte) ((j2 >> 40) & 255), (byte) ((j2 >> 32) & 255), (byte) ((j2 >> 24) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 8) & 255), (byte) (j2 & 255)};
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        if (r2 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr2 = null;
        try {
            gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream.close();
        } catch (java.lang.Exception unused3) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (java.lang.Exception unused4) {
        }
        return bArr2;
    }

    private static byte[] a(char[] cArr, int i2) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        char[] cArr2 = new char[4];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(cArr.length >> 1);
        while (i2 < cArr.length) {
            int i3 = 0;
            while (i2 < cArr.length) {
                int i4 = i2 + 1;
                char c2 = cArr[i2];
                if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c2) != -1 || c2 == '=') {
                    cArr2[i3] = c2;
                    i3++;
                } else if (c2 != '\r' && c2 != '\n') {
                    throw new java.io.IOException("bad BASE 64 In->");
                }
                if (i3 >= 4) {
                    boolean z = false;
                    for (int i5 = 0; i5 < 4; i5++) {
                        char c3 = cArr2[i5];
                        if (c3 != '=' && z) {
                            throw new java.io.IOException("bad BASE 64 In->");
                        }
                        if (!z && c3 == '=') {
                            z = true;
                        }
                    }
                    int i6 = 3;
                    if (cArr2[3] == '=') {
                        if (i4 < cArr.length) {
                            throw new java.io.IOException("bad BASE 64 In->");
                        }
                        i6 = 2;
                        if (cArr2[2] == '=') {
                            i6 = 1;
                        }
                    }
                    int i7 = 0;
                    for (int i8 = 0; i8 < 4; i8++) {
                        char c4 = cArr2[i8];
                        if (c4 != '=') {
                            i7 |= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c4) << ((3 - i8) * 6);
                        }
                    }
                    for (int i9 = 0; i9 < i6; i9++) {
                        byteArrayOutputStream.write((i7 >>> ((2 - i9) * 8)) & 255);
                    }
                    i2 = i4;
                } else {
                    i2 = i4;
                }
            }
            if (i3 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new java.io.IOException("bad BASE 64 In->");
        }
        byteArrayOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    private static java.lang.String[] a(java.lang.String str, java.lang.String str2, int i2) {
        return str.split(str2, i2);
    }

    private static int b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        return 2;
    }

    private static int b(byte[] bArr, int i2, int i3) {
        int[] iArr = m;
        if (iArr == null) {
            if (iArr == null) {
                m = new int[256];
            }
            for (int i4 = 0; i4 < 256; i4++) {
                int i5 = i4;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = i5 & 1;
                    i5 >>>= 1;
                    if (i7 == 1) {
                        i5 ^= -306674912;
                    }
                }
                m[i4] = i5;
            }
        }
        int i8 = -1;
        for (int i9 = i2; i9 < i3 + i2; i9++) {
            i8 = (i8 >>> 8) ^ m[(bArr[i9] ^ i8) & 255];
        }
        return ~i8;
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        int charAt;
        if (str != null && !str.equals("")) {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                try {
                    try {
                        if (str.charAt(i2) == '=') {
                            i2 += 3;
                            charAt = java.lang.Integer.parseInt(str.substring(i3, i2), 16);
                        } else {
                            charAt = str.charAt(i2);
                            i2 = i3;
                        }
                        byteArrayOutputStream.write(charAt);
                    } catch (java.io.IOException unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                    throw th;
                }
            }
            byteArrayOutputStream.flush();
            java.lang.String str3 = new java.lang.String(byteArrayOutputStream.toByteArray(), str2);
            try {
                byteArrayOutputStream.close();
            } catch (java.io.IOException unused4) {
            }
            return str3;
        }
        return null;
    }

    private static java.lang.String b(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    private static short b(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    private static void b() {
        if (m != null) {
            m = null;
        }
        java.lang.Thread.yield();
    }

    private static void b(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        a(new com.getui.gtc.extension.distribution.gbd.n.c(inputStream), outputStream);
    }

    private static byte[] b(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        if (r1 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(byte[] bArr) {
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        byte[] bArr2 = null;
        try {
            gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = gZIPInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    } catch (java.lang.Throwable unused) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception unused3) {
                }
            } catch (java.lang.Throwable unused4) {
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable unused5) {
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        try {
            gZIPInputStream.close();
        } catch (java.lang.Exception unused6) {
        }
        try {
            byteArrayInputStream.close();
        } catch (java.lang.Exception unused7) {
        }
        return bArr2;
    }

    private static java.lang.String[] b(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.toLowerCase());
        java.lang.String[] strArr = new java.lang.String[6];
        for (int i2 = 0; i2 < 6; i2++) {
            strArr[i2] = "";
        }
        int indexOf = str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        if (indexOf > 0) {
            strArr[0] = str.substring(0, indexOf);
            sb.delete(0, indexOf + 1);
        } else if (indexOf == 0) {
            throw new java.lang.IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int indexOf2 = sb.toString().indexOf(47);
            if (indexOf2 < 0) {
                indexOf2 = sb.length();
            }
            if (indexOf2 != 0) {
                int indexOf3 = sb.toString().indexOf(58);
                if (indexOf3 < 0) {
                    indexOf3 = indexOf2;
                } else {
                    if (indexOf3 > indexOf2) {
                        throw new java.lang.IllegalArgumentException("url format error - port");
                    }
                    strArr[2] = sb.toString().substring(indexOf3 + 1, indexOf2);
                }
                strArr[1] = sb.toString().substring(0, indexOf3);
                sb.delete(0, indexOf2);
            }
        }
        if (sb.length() > 0) {
            java.lang.String sb2 = sb.toString();
            int lastIndexOf = sb2.lastIndexOf(47);
            if (lastIndexOf > 0) {
                strArr[3] = sb2.substring(0, lastIndexOf);
            } else if (lastIndexOf == 0) {
                if (sb2.indexOf(63) > 0) {
                    throw new java.lang.IllegalArgumentException("url format error - path");
                }
                strArr[3] = sb2;
                return strArr;
            }
            if (lastIndexOf < sb2.length() - 1) {
                java.lang.String substring = sb2.substring(lastIndexOf + 1, sb2.length());
                int indexOf4 = substring.indexOf(63);
                if (indexOf4 >= 0) {
                    strArr[4] = substring.substring(0, indexOf4);
                    strArr[5] = substring.substring(indexOf4 + 1);
                } else {
                    strArr[4] = substring;
                }
            }
        } else {
            strArr[3] = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return strArr;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        return 1;
    }

    private static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static int c(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = 1;
        int i6 = 0;
        while (i2 < i4) {
            i5 += bArr[i2] & 255;
            i6 += i5;
            i2++;
        }
        return (((i6 % 65521) << 16) & androidx.core.internal.view.SupportMenu.CATEGORY_MASK) | (65535 & (i5 % 65521));
    }

    private static java.lang.String c(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    public static byte[] c(byte[] bArr) {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            com.getui.gtc.extension.distribution.gbd.n.d dVar = new com.getui.gtc.extension.distribution.gbd.n.d(byteArrayOutputStream, 0);
            a(byteArrayInputStream, dVar);
            dVar.a();
            try {
                byteArrayInputStream.close();
            } catch (java.lang.Throwable unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable unused2) {
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }

    private static int d(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    private static java.lang.String d(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i4 = 0;
        while (i2 < bArr.length) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < 3 && i2 < bArr.length) {
                i6 |= (bArr[i2] & 255) << (16 - (i5 << 3));
                i5++;
                i2++;
            }
            if (i3 > 0 && i4 == i3) {
                sb.append("\r\n");
                i4 = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 14) >>> 26);
            char c2 = '=';
            char charAt3 = i5 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 20) >>> 26);
            if (i5 >= 3) {
                c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i6 << 26) >>> 26);
            }
            sb.append(charAt);
            sb.append(charAt2);
            sb.append(charAt3);
            sb.append(c2);
            i4 += 4;
        }
        return sb.toString();
    }

    private static java.lang.String d(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        return sb.toString();
    }

    private static byte[] d(byte[] bArr) {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            a(new com.getui.gtc.extension.distribution.gbd.n.c(byteArrayInputStream), byteArrayOutputStream);
            try {
                byteArrayInputStream.close();
            } catch (java.lang.Throwable unused) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable unused2) {
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }

    private static long e(byte[] bArr, int i2) {
        return (bArr[i2 + 7] & 255) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
    }
}
