package org.apache.commons.codec.net;

/* loaded from: classes24.dex */
public class QuotedPrintableCodec implements org.apache.commons.codec.BinaryEncoder, org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.StringEncoder, org.apache.commons.codec.StringDecoder {
    public static final java.util.BitSet b = new java.util.BitSet(256);
    public final java.lang.String a;

    static {
        for (int i = 33; i <= 60; i++) {
            b.set(i);
        }
        for (int i2 = 62; i2 <= 126; i2++) {
            b.set(i2);
        }
        java.util.BitSet bitSet = b;
        bitSet.set(9);
        bitSet.set(32);
    }

    public QuotedPrintableCodec() {
        this("UTF-8");
    }

    public QuotedPrintableCodec(java.lang.String str) {
        this.a = str;
    }

    public static final void a(int i, java.io.ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = java.lang.Character.toUpperCase(java.lang.Character.forDigit((i >> 4) & 15, 16));
        char upperCase2 = java.lang.Character.toUpperCase(java.lang.Character.forDigit(i & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b2 = bArr[i];
            if (b2 == 61) {
                int i2 = i + 1;
                try {
                    int a = org.apache.commons.codec.net.Utils.a(bArr[i2]);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((a << 4) + org.apache.commons.codec.net.Utils.a(bArr[i])));
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    throw new org.apache.commons.codec.DecoderException("Invalid quoted-printable encoding", e);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] encodeQuotedPrintable(java.util.BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = b;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i];
            if (i2 < 0) {
                i2 += 256;
            }
            if (bitSet.get(i2)) {
                byteArrayOutputStream.write(i2);
            } else {
                a(i2, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return decode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.DecoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
    }

    @Override // org.apache.commons.codec.StringDecoder
    public java.lang.String decode(java.lang.String str) throws org.apache.commons.codec.DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.apache.commons.codec.DecoderException(e.getMessage(), e);
        }
    }

    public java.lang.String decode(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.DecoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new java.lang.String(decode(org.apache.commons.codec.binary.StringUtils.getBytesUsAscii(str)), str2);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        return decodeQuotedPrintable(bArr);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return encode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) throws org.apache.commons.codec.EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (java.io.UnsupportedEncodingException e) {
            throw new org.apache.commons.codec.EncoderException(e.getMessage(), e);
        }
    }

    public java.lang.String encode(java.lang.String str, java.lang.String str2) throws java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return org.apache.commons.codec.binary.StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeQuotedPrintable(b, bArr);
    }

    public java.lang.String getDefaultCharset() {
        return this.a;
    }
}
