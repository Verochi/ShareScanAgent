package com.google.common.hash;

@com.google.errorprone.annotations.CanIgnoreReturnValue
/* loaded from: classes22.dex */
abstract class AbstractStreamingHasher extends com.google.common.hash.AbstractHasher {
    public final java.nio.ByteBuffer a;
    public final int b;
    public final int c;

    public AbstractStreamingHasher(int i) {
        this(i, i);
    }

    public AbstractStreamingHasher(int i, int i2) {
        com.google.common.base.Preconditions.checkArgument(i2 % i == 0);
        this.a = java.nio.ByteBuffer.allocate(i2 + 7).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    public abstract com.google.common.hash.HashCode a();

    public final void b() {
        this.a.flip();
        while (this.a.remaining() >= this.c) {
            d(this.a);
        }
        this.a.compact();
    }

    public final void c() {
        if (this.a.remaining() < 8) {
            b();
        }
    }

    public abstract void d(java.nio.ByteBuffer byteBuffer);

    public void e(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.position(byteBuffer.limit());
        byteBuffer.limit(this.c + 7);
        while (true) {
            int position = byteBuffer.position();
            int i = this.c;
            if (position >= i) {
                byteBuffer.limit(i);
                byteBuffer.flip();
                d(byteBuffer);
                return;
            }
            byteBuffer.putLong(0L);
        }
    }

    public final com.google.common.hash.Hasher f(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            c();
            return this;
        }
        int position = this.b - this.a.position();
        for (int i = 0; i < position; i++) {
            this.a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.c) {
            d(byteBuffer);
        }
        this.a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final com.google.common.hash.HashCode hash() {
        b();
        this.a.flip();
        if (this.a.remaining() > 0) {
            e(this.a);
            java.nio.ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return a();
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putByte(byte b) {
        this.a.put(b);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer) {
        java.nio.ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
            return f(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2) {
        return f(java.nio.ByteBuffer.wrap(bArr, i, i2).order(java.nio.ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putChar(char c) {
        this.a.putChar(c);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putShort(short s2) {
        this.a.putShort(s2);
        c();
        return this;
    }
}
