package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarUtils {
    public static final org.apache.tools.zip.ZipEncoding a = org.apache.tools.zip.ZipEncodingHelper.getZipEncoding(null);
    public static final org.apache.tools.zip.ZipEncoding b = new org.apache.tools.tar.TarUtils.AnonymousClass1();

    /* renamed from: org.apache.tools.tar.TarUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.zip.ZipEncoding {
        @Override // org.apache.tools.zip.ZipEncoding
        public boolean canEncode(java.lang.String str) {
            return true;
        }

        @Override // org.apache.tools.zip.ZipEncoding
        public java.lang.String decode(byte[] bArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length);
            for (byte b : bArr) {
                if (b == 0) {
                    break;
                }
                sb.append((char) (b & 255));
            }
            return sb.toString();
        }

        @Override // org.apache.tools.zip.ZipEncoding
        public java.nio.ByteBuffer encode(java.lang.String str) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            return java.nio.ByteBuffer.wrap(bArr);
        }
    }

    public static java.lang.String a(byte[] bArr, int i, int i2, int i3, byte b2) {
        return java.lang.String.format("Invalid byte %s at offset %d in '%s' len=%d", java.lang.Byte.valueOf(b2), java.lang.Integer.valueOf(i3 - i), new java.lang.String(bArr, i, i2).replaceAll("\u0000", "{NUL}"), java.lang.Integer.valueOf(i2));
    }

    public static void b(long j, byte[] bArr, int i, int i2, boolean z) {
        byte[] byteArray = java.math.BigInteger.valueOf(j).toByteArray();
        int length = byteArray.length;
        int i3 = (i2 + i) - length;
        java.lang.System.arraycopy(byteArray, 0, bArr, i3, length);
        byte b2 = (byte) (z ? 255 : 0);
        while (true) {
            i++;
            if (i >= i3) {
                return;
            } else {
                bArr[i] = b2;
            }
        }
    }

    public static void c(long j, byte[] bArr, int i, int i2, boolean z) {
        long j2 = 1 << ((i2 - 1) * 8);
        long abs = java.lang.Math.abs(j);
        if (abs >= j2) {
            throw new java.lang.IllegalArgumentException("Value " + j + " is too large for " + i2 + " byte field.");
        }
        if (z) {
            abs = ((abs ^ (j2 - 1)) | (255 << r0)) + 1;
        }
        for (int i3 = (i2 + i) - 1; i3 >= i; i3--) {
            bArr[i3] = (byte) abs;
            abs >>= 8;
        }
    }

    public static long computeCheckSum(byte[] bArr) {
        long j = 0;
        for (byte b2 : bArr) {
            j += b2 & 255;
        }
        return j;
    }

    public static long d(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - 1;
        byte[] bArr2 = new byte[i3];
        java.lang.System.arraycopy(bArr, i + 1, bArr2, 0, i3);
        java.math.BigInteger bigInteger = new java.math.BigInteger(bArr2);
        if (z) {
            bigInteger = bigInteger.add(java.math.BigInteger.valueOf(-1L)).not();
        }
        if (bigInteger.bitLength() > 63) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("At offset %d, %d byte binary number exceeds maximum signed long value", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
        long longValue = bigInteger.longValue();
        return z ? -longValue : longValue;
    }

    public static long e(byte[] bArr, int i, int i2, boolean z) {
        if (i2 >= 9) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("At offset %d, %d byte binary number exceeds maximum signed long value", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }
        long j = 0;
        for (int i3 = 1; i3 < i2; i3++) {
            j = (j << 8) + (bArr[i + i3] & 255);
        }
        if (z) {
            j = (j - 1) ^ (((long) java.lang.Math.pow(2.0d, (i2 - 1) * 8.0d)) - 1);
        }
        return z ? -j : j;
    }

    public static int formatCheckSumOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 0;
        bArr[i3 + 1 + i] = 32;
        return i + i2;
    }

    public static int formatLongOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        return i + i2;
    }

    public static int formatLongOctalOrBinaryBytes(long j, byte[] bArr, int i, int i2) {
        long j2 = i2 == 8 ? org.apache.tools.tar.TarConstants.MAXID : org.apache.tools.tar.TarConstants.MAXSIZE;
        boolean z = j < 0;
        if (!z && j <= j2) {
            return formatLongOctalBytes(j, bArr, i, i2);
        }
        if (i2 < 9) {
            c(j, bArr, i, i2, z);
        }
        b(j, bArr, i, i2, z);
        bArr[i] = (byte) (z ? 255 : 128);
        return i + i2;
    }

    public static int formatNameBytes(java.lang.String str, byte[] bArr, int i, int i2) {
        try {
            try {
                return formatNameBytes(str, bArr, i, i2, a);
            } catch (java.io.IOException unused) {
                return formatNameBytes(str, bArr, i, i2, b);
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static int formatNameBytes(java.lang.String str, byte[] bArr, int i, int i2, org.apache.tools.zip.ZipEncoding zipEncoding) throws java.io.IOException {
        int length = str.length();
        java.nio.ByteBuffer encode = zipEncoding.encode(str);
        while (encode.limit() > i2 && length > 0) {
            length--;
            encode = zipEncoding.encode(str.substring(0, length));
        }
        int limit = encode.limit() - encode.position();
        java.lang.System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i, limit);
        while (limit < i2) {
            bArr[i + limit] = 0;
            limit++;
        }
        return i + i2;
    }

    public static int formatOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        bArr[i3 + 1 + i] = 0;
        return i + i2;
    }

    public static void formatUnsignedOctalString(long j, byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 - 1;
        if (j == 0) {
            i3 = i4 - 1;
            bArr[i4 + i] = org.apache.tools.tar.TarConstants.LF_NORMAL;
        } else {
            long j2 = j;
            while (i4 >= 0 && j2 != 0) {
                bArr[i + i4] = (byte) (((byte) (7 & j2)) + org.apache.tools.tar.TarConstants.LF_NORMAL);
                j2 >>>= 3;
                i4--;
            }
            if (j2 != 0) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("%d=%s will not fit in octal number buffer of length %d", java.lang.Long.valueOf(j), java.lang.Long.toOctalString(j), java.lang.Integer.valueOf(i2)));
            }
            i3 = i4;
        }
        while (i3 >= 0) {
            bArr[i + i3] = org.apache.tools.tar.TarConstants.LF_NORMAL;
            i3--;
        }
    }

    public static boolean parseBoolean(byte[] bArr, int i) {
        return bArr[i] == 1;
    }

    public static java.lang.String parseName(byte[] bArr, int i, int i2) {
        try {
            try {
                return parseName(bArr, i, i2, a);
            } catch (java.io.IOException unused) {
                return parseName(bArr, i, i2, b);
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String parseName(byte[] bArr, int i, int i2, org.apache.tools.zip.ZipEncoding zipEncoding) throws java.io.IOException {
        while (i2 > 0 && bArr[(i + i2) - 1] == 0) {
            i2--;
        }
        if (i2 <= 0) {
            return "";
        }
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        return zipEncoding.decode(bArr2);
    }

    public static long parseOctal(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i2 < 2) {
            throw new java.lang.IllegalArgumentException("Length " + i2 + " must be at least 2");
        }
        long j = 0;
        if (bArr[i] == 0) {
            return 0L;
        }
        int i4 = i;
        while (i4 < i3 && bArr[i4] == 32) {
            i4++;
        }
        byte b2 = bArr[i3 - 1];
        while (i4 < i3 && (b2 == 0 || b2 == 32)) {
            i3--;
            b2 = bArr[i3 - 1];
        }
        while (i4 < i3) {
            byte b3 = bArr[i4];
            if (b3 < 48 || b3 > 55) {
                throw new java.lang.IllegalArgumentException(a(bArr, i, i2, i4, b3));
            }
            j = (j << 3) + (b3 - 48);
            i4++;
        }
        return j;
    }

    public static long parseOctalOrBinary(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        if ((b2 & 128) == 0) {
            return parseOctal(bArr, i, i2);
        }
        boolean z = b2 == -1;
        return i2 < 9 ? e(bArr, i, i2, z) : d(bArr, i, i2, z);
    }
}
