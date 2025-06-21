package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public abstract class BaseNCodec implements org.apache.commons.codec.BinaryEncoder, org.apache.commons.codec.BinaryDecoder {
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = PAD_DEFAULT;
    public final int a;
    public final int b;
    protected byte[] buffer;
    public final int c;
    protected int currentLinePos;
    public int d;
    protected boolean eof;
    protected final int lineLength;
    protected int modulus;
    protected int pos;

    public BaseNCodec(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.lineLength = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.c = i4;
    }

    public static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    public int a() {
        if (this.buffer != null) {
            return this.pos - this.d;
        }
        return 0;
    }

    public abstract void b(byte[] bArr, int i, int i2);

    public abstract void c(byte[] bArr, int i, int i2);

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (61 == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return this.buffer != null;
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return decode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(java.lang.String str) {
        return decode(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str));
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        f();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i = this.pos;
        byte[] bArr2 = new byte[i];
        e(bArr2, 0, i);
        return bArr2;
    }

    public int e(byte[] bArr, int i, int i2) {
        if (this.buffer == null) {
            return this.eof ? -1 : 0;
        }
        int min = java.lang.Math.min(a(), i2);
        java.lang.System.arraycopy(this.buffer, this.d, bArr, i, min);
        int i3 = this.d + min;
        this.d = i3;
        if (i3 >= this.pos) {
            this.buffer = null;
        }
        return min;
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        f();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        c(bArr, 0, bArr.length);
        c(bArr, 0, -1);
        int i = this.pos - this.d;
        byte[] bArr2 = new byte[i];
        e(bArr2, 0, i);
        return bArr2;
    }

    public java.lang.String encodeAsString(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    public java.lang.String encodeToString(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    public void ensureBufferSize(int i) {
        byte[] bArr = this.buffer;
        if (bArr == null || bArr.length < this.pos + i) {
            g();
        }
    }

    public final void f() {
        this.buffer = null;
        this.pos = 0;
        this.d = 0;
        this.currentLinePos = 0;
        this.modulus = 0;
        this.eof = false;
    }

    public final void g() {
        byte[] bArr = this.buffer;
        if (bArr == null) {
            this.buffer = new byte[getDefaultBufferSize()];
            this.pos = 0;
            this.d = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.buffer = bArr2;
        }
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i = this.a;
        long j = (((length + i) - 1) / i) * this.b;
        int i2 = this.lineLength;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.c) : j;
    }

    public abstract boolean isInAlphabet(byte b);

    public boolean isInAlphabet(java.lang.String str) {
        return isInAlphabet(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str), true);
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        byte b;
        for (int i = 0; i < bArr.length; i++) {
            if (!isInAlphabet(bArr[i]) && (!z || ((b = bArr[i]) != 61 && !isWhiteSpace(b)))) {
                return false;
            }
        }
        return true;
    }
}
