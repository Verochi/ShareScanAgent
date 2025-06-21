package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class HashingInputStream extends java.io.FilterInputStream {
    public final com.google.common.hash.Hasher n;

    public HashingInputStream(com.google.common.hash.HashFunction hashFunction, java.io.InputStream inputStream) {
        super((java.io.InputStream) com.google.common.base.Preconditions.checkNotNull(inputStream));
        this.n = (com.google.common.hash.Hasher) com.google.common.base.Preconditions.checkNotNull(hashFunction.newHasher());
    }

    public com.google.common.hash.HashCode hash() {
        return this.n.hash();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int read() throws java.io.IOException {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (read != -1) {
            this.n.putByte((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = ((java.io.FilterInputStream) this).in.read(bArr, i, i2);
        if (read != -1) {
            this.n.putBytes(bArr, i, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws java.io.IOException {
        throw new java.io.IOException("reset not supported");
    }
}
