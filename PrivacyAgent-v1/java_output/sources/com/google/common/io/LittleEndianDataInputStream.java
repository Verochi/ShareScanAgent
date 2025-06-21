package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class LittleEndianDataInputStream extends java.io.FilterInputStream implements java.io.DataInput {
    public LittleEndianDataInputStream(java.io.InputStream inputStream) {
        super((java.io.InputStream) com.google.common.base.Preconditions.checkNotNull(inputStream));
    }

    public final byte a() throws java.io.IOException, java.io.EOFException {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new java.io.EOFException();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean readBoolean() throws java.io.IOException {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public byte readByte() throws java.io.IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public char readChar() throws java.io.IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public double readDouble() throws java.io.IOException {
        return java.lang.Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public float readFloat() throws java.io.IOException {
        return java.lang.Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws java.io.IOException {
        com.google.common.io.ByteStreams.readFully(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.google.common.io.ByteStreams.readFully(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int readInt() throws java.io.IOException {
        byte a = a();
        byte a2 = a();
        return com.google.common.primitives.Ints.fromBytes(a(), a(), a2, a);
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.lang.String readLine() {
        throw new java.lang.UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public long readLong() throws java.io.IOException {
        byte a = a();
        byte a2 = a();
        byte a3 = a();
        byte a4 = a();
        byte a5 = a();
        byte a6 = a();
        return com.google.common.primitives.Longs.fromBytes(a(), a(), a6, a5, a4, a3, a2, a);
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public short readShort() throws java.io.IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public java.lang.String readUTF() throws java.io.IOException {
        return new java.io.DataInputStream(((java.io.FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int readUnsignedByte() throws java.io.IOException {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new java.io.EOFException();
    }

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int readUnsignedShort() throws java.io.IOException {
        return com.google.common.primitives.Ints.fromBytes((byte) 0, (byte) 0, a(), a());
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws java.io.IOException {
        return (int) ((java.io.FilterInputStream) this).in.skip(i);
    }
}
