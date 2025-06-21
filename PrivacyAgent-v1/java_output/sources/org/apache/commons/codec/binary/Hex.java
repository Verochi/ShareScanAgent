package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Hex implements org.apache.commons.codec.BinaryEncoder, org.apache.commons.codec.BinaryDecoder {
    public static final java.lang.String DEFAULT_CHARSET_NAME = "UTF-8";
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final java.lang.String a;

    public Hex() {
        this.a = "UTF-8";
    }

    public Hex(java.lang.String str) {
        this.a = str;
    }

    public static byte[] decodeHex(char[] cArr) throws org.apache.commons.codec.DecoderException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new org.apache.commons.codec.DecoderException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int digit = toDigit(cArr[i], i) << 4;
            int i3 = i + 1;
            int digit2 = digit | toDigit(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (digit2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? b : c);
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static java.lang.String encodeHexString(byte[] bArr) {
        return new java.lang.String(encodeHex(bArr));
    }

    public static int toDigit(char c2, int i) throws org.apache.commons.codec.DecoderException {
        int digit = java.lang.Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new org.apache.commons.codec.DecoderException("Illegal hexadecimal character " + c2 + " at index " + i);
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        try {
            return decodeHex(obj instanceof java.lang.String ? ((java.lang.String) obj).toCharArray() : (char[]) obj);
        } catch (java.lang.ClassCastException e) {
            throw new org.apache.commons.codec.DecoderException(e.getMessage(), e);
        }
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        try {
            return decodeHex(new java.lang.String(bArr, getCharsetName()).toCharArray());
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.apache.commons.codec.DecoderException(e.getMessage(), e);
        }
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        try {
            return encodeHex(obj instanceof java.lang.String ? ((java.lang.String) obj).getBytes(getCharsetName()) : (byte[]) obj);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.apache.commons.codec.EncoderException(e.getMessage(), e);
        } catch (java.lang.ClassCastException e2) {
            throw new org.apache.commons.codec.EncoderException(e2.getMessage(), e2);
        }
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.getBytesUnchecked(encodeHexString(bArr), getCharsetName());
    }

    public java.lang.String getCharsetName() {
        return this.a;
    }

    public java.lang.String toString() {
        return super.toString() + "[charsetName=" + this.a + "]";
    }
}
