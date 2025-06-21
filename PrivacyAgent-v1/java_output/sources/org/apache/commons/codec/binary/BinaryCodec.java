package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class BinaryCodec implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder {
    public static final char[] a = new char[0];
    public static final byte[] b = new byte[0];
    public static final int[] c = {1, 2, 4, 8, 16, 32, 64, 128};

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] fromAscii(byte[] bArr) {
        if (a(bArr)) {
            return b;
        }
        int length = bArr.length >> 3;
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (true) {
                int[] iArr = c;
                if (i2 < iArr.length) {
                    if (bArr[length2 - i2] == 49) {
                        bArr2[i] = (byte) (iArr[i2] | bArr2[i]);
                    }
                    i2++;
                }
            }
            i++;
            length2 -= 8;
        }
        return bArr2;
    }

    public static byte[] fromAscii(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return b;
        }
        int length = cArr.length >> 3;
        byte[] bArr = new byte[length];
        int length2 = cArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (true) {
                int[] iArr = c;
                if (i2 < iArr.length) {
                    if (cArr[length2 - i2] == '1') {
                        bArr[i] = (byte) (iArr[i2] | bArr[i]);
                    }
                    i2++;
                }
            }
            i++;
            length2 -= 8;
        }
        return bArr;
    }

    public static byte[] toAsciiBytes(byte[] bArr) {
        if (a(bArr)) {
            return b;
        }
        int length = bArr.length << 3;
        byte[] bArr2 = new byte[length];
        int i = length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = c;
                if (i3 < iArr.length) {
                    if ((iArr[i3] & bArr[i2]) == 0) {
                        bArr2[i - i3] = org.apache.tools.tar.TarConstants.LF_NORMAL;
                    } else {
                        bArr2[i - i3] = org.apache.tools.tar.TarConstants.LF_LINK;
                    }
                    i3++;
                }
            }
            i2++;
            i -= 8;
        }
        return bArr2;
    }

    public static char[] toAsciiChars(byte[] bArr) {
        if (a(bArr)) {
            return a;
        }
        int length = bArr.length << 3;
        char[] cArr = new char[length];
        int i = length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = c;
                if (i3 < iArr.length) {
                    if ((iArr[i3] & bArr[i2]) == 0) {
                        cArr[i - i3] = '0';
                    } else {
                        cArr[i - i3] = '1';
                    }
                    i3++;
                }
            }
            i2++;
            i -= 8;
        }
        return cArr;
    }

    public static java.lang.String toAsciiString(byte[] bArr) {
        return new java.lang.String(toAsciiChars(bArr));
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj == null) {
            return b;
        }
        if (obj instanceof byte[]) {
            return fromAscii((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return fromAscii((char[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return fromAscii(((java.lang.String) obj).toCharArray());
        }
        throw new org.apache.commons.codec.DecoderException("argument not a byte array");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return fromAscii(bArr);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof byte[]) {
            return toAsciiChars((byte[]) obj);
        }
        throw new org.apache.commons.codec.EncoderException("argument not a byte array");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return toAsciiBytes(bArr);
    }

    public byte[] toByteArray(java.lang.String str) {
        return str == null ? b : fromAscii(str.toCharArray());
    }
}
