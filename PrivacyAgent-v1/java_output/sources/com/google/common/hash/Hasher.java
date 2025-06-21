package com.google.common.hash;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface Hasher extends com.google.common.hash.PrimitiveSink {
    com.google.common.hash.HashCode hash();

    @java.lang.Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putBoolean(boolean z);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putByte(byte b);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putChar(char c);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putDouble(double d);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putFloat(float f);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putInt(int i);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putLong(long j);

    <T> com.google.common.hash.Hasher putObject(T t, com.google.common.hash.Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putShort(short s2);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    com.google.common.hash.Hasher putUnencodedChars(java.lang.CharSequence charSequence);
}
