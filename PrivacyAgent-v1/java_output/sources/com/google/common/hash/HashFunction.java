package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface HashFunction {
    int bits();

    com.google.common.hash.HashCode hashBytes(java.nio.ByteBuffer byteBuffer);

    com.google.common.hash.HashCode hashBytes(byte[] bArr);

    com.google.common.hash.HashCode hashBytes(byte[] bArr, int i, int i2);

    com.google.common.hash.HashCode hashInt(int i);

    com.google.common.hash.HashCode hashLong(long j);

    <T> com.google.common.hash.HashCode hashObject(T t, com.google.common.hash.Funnel<? super T> funnel);

    com.google.common.hash.HashCode hashString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset);

    com.google.common.hash.HashCode hashUnencodedChars(java.lang.CharSequence charSequence);

    com.google.common.hash.Hasher newHasher();

    com.google.common.hash.Hasher newHasher(int i);
}
