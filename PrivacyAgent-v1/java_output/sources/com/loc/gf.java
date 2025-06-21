package com.loc;

/* loaded from: classes23.dex */
public class gf {
    static final java.nio.charset.Charset c = java.nio.charset.Charset.forName("UTF-8");
    static final /* synthetic */ boolean p = true;
    java.nio.ByteBuffer a;
    int b;
    int d;
    int[] e;
    int f;
    boolean g;
    boolean h;
    int i;
    int[] j;
    int k;
    int l;
    boolean m;
    java.nio.charset.CharsetEncoder n;
    java.nio.ByteBuffer o;

    private gf() {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        this.b = 1024;
        this.a = d(1024);
    }

    public gf(java.nio.ByteBuffer byteBuffer) {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        a(byteBuffer);
    }

    private void a(long j) {
        java.nio.ByteBuffer byteBuffer = this.a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    private void a(short s2) {
        java.nio.ByteBuffer byteBuffer = this.a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s2);
    }

    private static java.nio.ByteBuffer b(java.nio.ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) != 0) {
            throw new java.lang.AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i = capacity << 1;
        byteBuffer.position(0);
        java.nio.ByteBuffer d = d(i);
        d.position(i - capacity);
        d.put(byteBuffer);
        return d;
    }

    private void b(byte b) {
        java.nio.ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    private void b(long j) {
        c(8, 0);
        a(j);
    }

    private void b(short s2) {
        c(2, 0);
        a(s2);
    }

    private void b(boolean z) {
        java.nio.ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    private int c(java.nio.ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        a((byte) 0);
        a(1, remaining, 1);
        java.nio.ByteBuffer byteBuffer2 = this.a;
        int i = this.b - remaining;
        this.b = i;
        byteBuffer2.position(i);
        this.a.put(byteBuffer);
        return a();
    }

    private void c(int i, int i2) {
        if (i > this.d) {
            this.d = i;
        }
        int i3 = ((~((this.a.capacity() - this.b) + i2)) + 1) & (i - 1);
        while (this.b < i3 + i + i2) {
            int capacity = this.a.capacity();
            java.nio.ByteBuffer b = b(this.a);
            this.a = b;
            this.b += b.capacity() - capacity;
        }
        e(i3);
    }

    private void c(boolean z) {
        c(1, 0);
        b(z);
    }

    private int d() {
        return this.a.capacity() - this.b;
    }

    private static java.nio.ByteBuffer d(int i) {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(i);
        allocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private byte[] d(int i, int i2) {
        e();
        byte[] bArr = new byte[i2];
        this.a.position(i);
        this.a.get(bArr);
        return bArr;
    }

    private void e() {
        if (!this.h) {
            throw new java.lang.AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    private void e(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            java.nio.ByteBuffer byteBuffer = this.a;
            int i3 = this.b - 1;
            this.b = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    private void f() {
        if (this.g) {
            throw new java.lang.AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void f(int i) {
        java.nio.ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    private void g(int i) {
        c(4, 0);
        f(i);
    }

    private void h(int i) {
        this.e[i] = d();
    }

    public final int a() {
        if (!this.g) {
            throw new java.lang.AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.g = false;
        f(this.l);
        return d();
    }

    public int a(java.lang.CharSequence charSequence) {
        int length = (int) (charSequence.length() * this.n.maxBytesPerChar());
        java.nio.ByteBuffer byteBuffer = this.o;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.o = java.nio.ByteBuffer.allocate(java.lang.Math.max(128, length));
        }
        this.o.clear();
        java.nio.charset.CoderResult encode = this.n.encode(charSequence instanceof java.nio.CharBuffer ? (java.nio.CharBuffer) charSequence : java.nio.CharBuffer.wrap(charSequence), this.o, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (java.nio.charset.CharacterCodingException e) {
                throw new java.lang.Error(e);
            }
        }
        this.o.flip();
        return c(this.o);
    }

    public final com.loc.gf a(java.nio.ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.clear();
        this.a.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.d = 1;
        this.b = this.a.capacity();
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = 0;
        this.l = 0;
        return this;
    }

    public final void a(byte b) {
        c(1, 0);
        b(b);
    }

    public final void a(int i) {
        c(4, 0);
        if (!p && i > d()) {
            throw new java.lang.AssertionError();
        }
        f((d() - i) + 4);
    }

    public final void a(int i, byte b) {
        if (this.m || b != 0) {
            a(b);
            h(i);
        }
    }

    public final void a(int i, int i2) {
        if (this.m || i2 != 0) {
            g(i2);
            h(i);
        }
    }

    public final void a(int i, int i2, int i3) {
        f();
        this.l = i2;
        int i4 = i * i2;
        c(4, i4);
        c(i3, i4);
        this.g = true;
    }

    public final void a(int i, long j) {
        if (this.m || j != 0) {
            b(j);
            h(i);
        }
    }

    public final void a(int i, short s2) {
        if (this.m || s2 != 0) {
            b(s2);
            h(i);
        }
    }

    public final void a(boolean z) {
        if (this.m || z) {
            c(z);
            h(0);
        }
    }

    public final int b() {
        int i;
        int i2;
        if (this.e == null || !this.g) {
            throw new java.lang.AssertionError("FlatBuffers: endObject called without startObject");
        }
        g(0);
        int d = d();
        for (int i3 = this.f - 1; i3 >= 0; i3--) {
            int i4 = this.e[i3];
            b((short) (i4 != 0 ? d - i4 : 0));
        }
        b((short) (d - this.i));
        b((short) ((this.f + 2) * 2));
        int i5 = 0;
        loop1: while (true) {
            if (i5 >= this.k) {
                i = 0;
                break;
            }
            int capacity = this.a.capacity() - this.j[i5];
            int i6 = this.b;
            short s2 = this.a.getShort(capacity);
            if (s2 == this.a.getShort(i6)) {
                while (i2 < s2) {
                    i2 = this.a.getShort(capacity + i2) == this.a.getShort(i6 + i2) ? i2 + 2 : 2;
                }
                i = this.j[i5];
                break loop1;
            }
            i5++;
        }
        if (i != 0) {
            int capacity2 = this.a.capacity() - d;
            this.b = capacity2;
            this.a.putInt(capacity2, i - d);
        } else {
            int i7 = this.k;
            int[] iArr = this.j;
            if (i7 == iArr.length) {
                this.j = java.util.Arrays.copyOf(iArr, i7 * 2);
            }
            int[] iArr2 = this.j;
            int i8 = this.k;
            this.k = i8 + 1;
            iArr2[i8] = d();
            java.nio.ByteBuffer byteBuffer = this.a;
            byteBuffer.putInt(byteBuffer.capacity() - d, d() - d);
        }
        this.g = false;
        return d;
    }

    public final void b(int i) {
        f();
        int[] iArr = this.e;
        if (iArr == null || iArr.length < i) {
            this.e = new int[i];
        }
        this.f = i;
        java.util.Arrays.fill(this.e, 0, i, 0);
        this.g = true;
        this.i = d();
    }

    public final void b(int i, int i2) {
        if (this.m || i2 != 0) {
            a(i2);
            h(i);
        }
    }

    public final void c(int i) {
        c(this.d, 4);
        a(i);
        this.a.position(this.b);
        this.h = true;
    }

    public final byte[] c() {
        return d(this.b, this.a.capacity() - this.b);
    }
}
