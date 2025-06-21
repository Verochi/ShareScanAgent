package com.google.common.hash;

@com.google.errorprone.annotations.CanIgnoreReturnValue
/* loaded from: classes22.dex */
abstract class AbstractByteHasher extends com.google.common.hash.AbstractHasher {
    public final java.nio.ByteBuffer a = java.nio.ByteBuffer.allocate(8).order(java.nio.ByteOrder.LITTLE_ENDIAN);

    private com.google.common.hash.Hasher update(int i) {
        try {
            update(this.a.array(), 0, i);
            return this;
        } finally {
            this.a.clear();
        }
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putByte(byte b) {
        update(b);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(byte[] bArr) {
        com.google.common.base.Preconditions.checkNotNull(bArr);
        update(bArr);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        update(bArr, i, i2);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putChar(char c) {
        this.a.putChar(c);
        return update(2);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putInt(int i) {
        this.a.putInt(i);
        return update(4);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putLong(long j) {
        this.a.putLong(j);
        return update(8);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putShort(short s2) {
        this.a.putShort(s2);
        return update(2);
    }

    public abstract void update(byte b);

    public void update(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                update(byteBuffer.get());
            }
        }
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            update(bArr[i3]);
        }
    }
}
