package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
abstract class AbstractHashFunction implements com.google.common.hash.HashFunction {
    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashBytes(java.nio.ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashBytes(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return newHasher(i2).putBytes(bArr, i, i2).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashInt(int i) {
        return newHasher(4).putInt(i).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashLong(long j) {
        return newHasher(8).putLong(j).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public <T> com.google.common.hash.HashCode hashObject(T t, com.google.common.hash.Funnel<? super T> funnel) {
        return newHasher().putObject(t, funnel).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashUnencodedChars(java.lang.CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).putUnencodedChars(charSequence).hash();
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }
}
