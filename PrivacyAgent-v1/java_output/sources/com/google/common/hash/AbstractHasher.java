package com.google.common.hash;

@com.google.errorprone.annotations.CanIgnoreReturnValue
/* loaded from: classes22.dex */
abstract class AbstractHasher implements com.google.common.hash.Hasher {
    @Override // com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2) {
        com.google.common.base.Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            putByte(bArr[i + i3]);
        }
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putChar(char c) {
        putByte((byte) c);
        putByte((byte) (c >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putDouble(double d) {
        return putLong(java.lang.Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final com.google.common.hash.Hasher putFloat(float f) {
        return putInt(java.lang.Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putInt(int i) {
        putByte((byte) i);
        putByte((byte) (i >>> 8));
        putByte((byte) (i >>> 16));
        putByte((byte) (i >>> 24));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putLong(long j) {
        for (int i = 0; i < 64; i += 8) {
            putByte((byte) (j >>> i));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public <T> com.google.common.hash.Hasher putObject(T t, com.google.common.hash.Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putShort(short s2) {
        putByte((byte) s2);
        putByte((byte) (s2 >>> 8));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public com.google.common.hash.Hasher putUnencodedChars(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }
}
