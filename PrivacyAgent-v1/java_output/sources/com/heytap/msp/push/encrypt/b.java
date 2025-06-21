package com.heytap.msp.push.encrypt;

/* loaded from: classes22.dex */
public abstract class b implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder {
    private static final int a = 2;
    public static final int b = 76;
    public static final int c = 64;
    protected static final int d = 255;
    protected static final byte e = 61;
    private static final int m = 8192;
    protected final byte f = e;
    protected final int g;
    protected byte[] h;
    protected int i;
    protected boolean j;
    protected int k;
    protected int l;
    private final int n;
    private final int o;
    private final int p;
    private int q;

    public b(int i, int i2, int i3, int i4) {
        this.n = i;
        this.o = i2;
        this.g = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.p = i4;
    }

    private void a() {
        byte[] bArr = this.h;
        if (bArr == null) {
            this.h = new byte[d()];
            this.i = 0;
            this.q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.h = bArr2;
        }
    }

    public static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.h = null;
        this.i = 0;
        this.q = 0;
        this.k = 0;
        this.l = 0;
        this.j = false;
    }

    public void a(int i) {
        byte[] bArr = this.h;
        if (bArr == null || bArr.length < this.i + i) {
            a();
        }
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void b(byte[] bArr, int i, int i2);

    public boolean b() {
        return this.h != null;
    }

    public abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        byte b2;
        for (int i = 0; i < bArr.length; i++) {
            if (!b(bArr[i]) && (!z || ((b2 = bArr[i]) != 61 && !c(b2)))) {
                return false;
            }
        }
        return true;
    }

    public int c() {
        if (this.h != null) {
            return this.i - this.q;
        }
        return 0;
    }

    public int c(byte[] bArr, int i, int i2) {
        if (this.h == null) {
            return this.j ? -1 : 0;
        }
        int min = java.lang.Math.min(c(), i2);
        java.lang.System.arraycopy(this.h, this.q, bArr, i, min);
        int i3 = this.q + min;
        this.q = i3;
        if (i3 >= this.i) {
            this.h = null;
        }
        return min;
    }

    public byte[] c(java.lang.String str) {
        return decode(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str));
    }

    public int d() {
        return 8192;
    }

    public boolean d(java.lang.String str) {
        return b(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return c((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i = this.i;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i);
        return bArr2;
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i = this.i - this.q;
        byte[] bArr2 = new byte[i];
        c(bArr2, 0, i);
        return bArr2;
    }

    public java.lang.String j(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    public java.lang.String k(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.newStringUtf8(encode(bArr));
    }

    public boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        int i = this.n;
        long j = (((length + i) - 1) / i) * this.o;
        int i2 = this.g;
        return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.p) : j;
    }
}
