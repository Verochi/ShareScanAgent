package com.google.common.hash;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public interface PrimitiveSink {
    com.google.common.hash.PrimitiveSink putBoolean(boolean z);

    com.google.common.hash.PrimitiveSink putByte(byte b);

    com.google.common.hash.PrimitiveSink putBytes(java.nio.ByteBuffer byteBuffer);

    com.google.common.hash.PrimitiveSink putBytes(byte[] bArr);

    com.google.common.hash.PrimitiveSink putBytes(byte[] bArr, int i, int i2);

    com.google.common.hash.PrimitiveSink putChar(char c);

    com.google.common.hash.PrimitiveSink putDouble(double d);

    com.google.common.hash.PrimitiveSink putFloat(float f);

    com.google.common.hash.PrimitiveSink putInt(int i);

    com.google.common.hash.PrimitiveSink putLong(long j);

    com.google.common.hash.PrimitiveSink putShort(short s2);

    com.google.common.hash.PrimitiveSink putString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset);

    com.google.common.hash.PrimitiveSink putUnencodedChars(java.lang.CharSequence charSequence);
}
