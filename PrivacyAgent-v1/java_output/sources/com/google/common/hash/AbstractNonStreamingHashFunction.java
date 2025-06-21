package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
abstract class AbstractNonStreamingHashFunction extends com.google.common.hash.AbstractHashFunction {

    public final class BufferingHasher extends com.google.common.hash.AbstractHasher {
        public final com.google.common.hash.AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream a;

        public BufferingHasher(int i) {
            this.a = new com.google.common.hash.AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(i);
        }

        @Override // com.google.common.hash.Hasher
        public com.google.common.hash.HashCode hash() {
            return com.google.common.hash.AbstractNonStreamingHashFunction.this.hashBytes(this.a.a(), 0, this.a.c());
        }

        @Override // com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putByte(byte b) {
            this.a.write(b);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBytes(java.nio.ByteBuffer byteBuffer) {
            this.a.d(byteBuffer);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public com.google.common.hash.Hasher putBytes(byte[] bArr, int i, int i2) {
            this.a.write(bArr, i, i2);
            return this;
        }
    }

    public static final class ExposedByteArrayOutputStream extends java.io.ByteArrayOutputStream {
        public ExposedByteArrayOutputStream(int i) {
            super(i);
        }

        public byte[] a() {
            return ((java.io.ByteArrayOutputStream) this).buf;
        }

        public int c() {
            return ((java.io.ByteArrayOutputStream) this).count;
        }

        public void d(java.nio.ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i = ((java.io.ByteArrayOutputStream) this).count;
            int i2 = i + remaining;
            byte[] bArr = ((java.io.ByteArrayOutputStream) this).buf;
            if (i2 > bArr.length) {
                ((java.io.ByteArrayOutputStream) this).buf = java.util.Arrays.copyOf(bArr, i + remaining);
            }
            byteBuffer.get(((java.io.ByteArrayOutputStream) this).buf, ((java.io.ByteArrayOutputStream) this).count, remaining);
            ((java.io.ByteArrayOutputStream) this).count += remaining;
        }
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashBytes(java.nio.ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public abstract com.google.common.hash.HashCode hashBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashInt(int i) {
        return hashBytes(java.nio.ByteBuffer.allocate(4).order(java.nio.ByteOrder.LITTLE_ENDIAN).putInt(i).array());
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashLong(long j) {
        return hashBytes(java.nio.ByteBuffer.allocate(8).order(java.nio.ByteOrder.LITTLE_ENDIAN).putLong(j).array());
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashString(java.lang.CharSequence charSequence, java.nio.charset.Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.HashCode hashUnencodedChars(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        java.nio.ByteBuffer order = java.nio.ByteBuffer.allocate(length * 2).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < length; i++) {
            order.putChar(charSequence.charAt(i));
        }
        return hashBytes(order.array());
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        return newHasher(32);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher(int i) {
        com.google.common.base.Preconditions.checkArgument(i >= 0);
        return new com.google.common.hash.AbstractNonStreamingHashFunction.BufferingHasher(i);
    }
}
