package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class HashingOutputStream extends java.io.FilterOutputStream {
    public final com.google.common.hash.Hasher n;

    public HashingOutputStream(com.google.common.hash.HashFunction hashFunction, java.io.OutputStream outputStream) {
        super((java.io.OutputStream) com.google.common.base.Preconditions.checkNotNull(outputStream));
        this.n = (com.google.common.hash.Hasher) com.google.common.base.Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.close();
    }

    public com.google.common.hash.HashCode hash() {
        return this.n.hash();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.n.putByte((byte) i);
        ((java.io.FilterOutputStream) this).out.write(i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.n.putBytes(bArr, i, i2);
        ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
    }
}
