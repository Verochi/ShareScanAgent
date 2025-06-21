package com.commonsware.cwac.netsecurity.luni;

/* loaded from: classes22.dex */
public final class Base64 {
    private static final byte[] BASE_64_ALPHABET = initializeBase64Alphabet();
    private static final byte END_OF_INPUT = -3;
    private static final int FIRST_OUTPUT_BYTE_MASK = 16515072;
    private static final int FOURTH_OUTPUT_BYTE_MASK = 63;
    private static final byte PAD_AS_BYTE = -1;
    private static final int SECOND_OUTPUT_BYTE_MASK = 258048;
    private static final int THIRD_OUTPUT_BYTE_MASK = 4032;
    private static final byte WHITESPACE_AS_BYTE = -2;

    public static class InvalidBase64ByteException extends java.lang.Exception {
        private InvalidBase64ByteException() {
        }

        public /* synthetic */ InvalidBase64ByteException(com.commonsware.cwac.netsecurity.luni.Base64.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private Base64() {
    }

    private static byte base64AlphabetToNumericalValue(byte b) throws com.commonsware.cwac.netsecurity.luni.Base64.InvalidBase64ByteException {
        int i;
        if (65 <= b && b <= 90) {
            i = b - 65;
        } else if (97 <= b && b <= 122) {
            i = (b - 97) + 26;
        } else {
            if (48 > b || b > 57) {
                if (b == 43) {
                    return (byte) 62;
                }
                if (b == 47) {
                    return (byte) 63;
                }
                if (b == 61) {
                    return (byte) -1;
                }
                if (b == 32 || b == 9 || b == 13 || b == 10) {
                    return (byte) -2;
                }
                throw new com.commonsware.cwac.netsecurity.luni.Base64.InvalidBase64ByteException(null);
            }
            i = (b - org.apache.tools.tar.TarConstants.LF_NORMAL) + 52;
        }
        return (byte) i;
    }

    private static byte[] checkNoTrailingAndReturn(java.io.ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, int i, int i2) throws com.commonsware.cwac.netsecurity.luni.Base64.InvalidBase64ByteException {
        while (i < i2) {
            byte base64AlphabetToNumericalValue = base64AlphabetToNumericalValue(bArr[i]);
            if (base64AlphabetToNumericalValue != -2 && base64AlphabetToNumericalValue != -1) {
                return null;
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int computeEncodingOutputLen(int i) {
        int i2 = i % 3;
        int i3 = (i / 3) * 4;
        return (i2 == 2 || i2 == 1) ? i3 + 4 : i3;
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r6 == 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r6 == 2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r6 == 3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r9 != (-1)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r1 = r7 >> 2;
        r0.write(r1 >> 8);
        r0.write(r1 & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        return checkNoTrailingAndReturn(r0, r13, r3[0], r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r9 != (-3)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        return checkNoTrailingAndReturn(r0, r13, r3[0], r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        r3[0] = r3[0] + 1;
        r1 = getNextByte(r13, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        if (r1 != (-3)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
    
        return checkNoTrailingAndReturn(r0, r13, r3[0], r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        if (r1 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        r0.write(r7 >> 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
    
        return checkNoTrailingAndReturn(r0, r13, r3[0], r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        if (r9 != (-3)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
    
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] decode(byte[] bArr, int i) {
        int min = java.lang.Math.min(bArr.length, i);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(((min / 4) * 3) + 3);
        int[] iArr = new int[1];
        loop0: while (true) {
            try {
                int i2 = iArr[0];
                if (i2 >= min) {
                    return checkNoTrailingAndReturn(byteArrayOutputStream, bArr, i2, min);
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < 4) {
                    byte nextByte = getNextByte(bArr, iArr, min);
                    if (nextByte != -3 && nextByte != -1) {
                        i4 = (i4 << 6) + (nextByte & 255);
                        iArr[0] = iArr[0] + 1;
                        i3++;
                    }
                }
                byteArrayOutputStream.write(i4 >> 16);
                byteArrayOutputStream.write((i4 >> 8) & 255);
                byteArrayOutputStream.write(i4 & 255);
            } catch (com.commonsware.cwac.netsecurity.luni.Base64.InvalidBase64ByteException unused) {
                return null;
            }
        }
    }

    public static java.lang.String encode(byte[] bArr) {
        int i;
        int length = bArr.length;
        byte[] bArr2 = new byte[computeEncodingOutputLen(length)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int i4 = bArr[i3] & 255;
            int i5 = i3 + 1;
            if (i5 < length) {
                int i6 = (i4 << 8) | (bArr[i5] & 255);
                int i7 = i3 + 2;
                i = i7 < length ? (i6 << 8) | (bArr[i7] & 255) : i6 << 2;
            } else {
                i = i4 << 4;
            }
            if (i3 + 2 < length) {
                bArr2[i2] = BASE_64_ALPHABET[(FIRST_OUTPUT_BYTE_MASK & i) >>> 18];
                i2++;
            }
            if (i5 < length) {
                bArr2[i2] = BASE_64_ALPHABET[(SECOND_OUTPUT_BYTE_MASK & i) >>> 12];
                i2++;
            }
            int i8 = i2 + 1;
            byte[] bArr3 = BASE_64_ALPHABET;
            bArr2[i2] = bArr3[(i & THIRD_OUTPUT_BYTE_MASK) >>> 6];
            i2 = i8 + 1;
            bArr2[i8] = bArr3[i & 63];
        }
        int i9 = length % 3;
        if (i9 > 0) {
            int i10 = i2 + 1;
            bArr2[i2] = 61;
            if (i9 == 1) {
                bArr2[i10] = 61;
            }
        }
        return new java.lang.String(bArr2);
    }

    private static byte getNextByte(byte[] bArr, int[] iArr, int i) throws com.commonsware.cwac.netsecurity.luni.Base64.InvalidBase64ByteException {
        while (true) {
            int i2 = iArr[0];
            if (i2 >= i) {
                return (byte) -3;
            }
            byte base64AlphabetToNumericalValue = base64AlphabetToNumericalValue(bArr[i2]);
            if (base64AlphabetToNumericalValue != -2) {
                return base64AlphabetToNumericalValue;
            }
            iArr[0] = iArr[0] + 1;
        }
    }

    private static byte[] initializeBase64Alphabet() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes();
    }
}
