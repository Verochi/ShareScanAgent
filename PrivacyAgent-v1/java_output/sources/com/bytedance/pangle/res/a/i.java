package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class i extends java.io.FilterInputStream implements java.io.DataInput {
    public i(com.bytedance.pangle.res.a.e eVar) {
        super(eVar);
    }

    private static int a(byte b, byte b2, byte b3, byte b4) {
        return (b << com.google.common.base.Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    private byte b() {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new java.io.EOFException();
    }

    public final com.bytedance.pangle.res.a.e a() {
        return (com.bytedance.pangle.res.a.e) ((java.io.FilterInputStream) this).in;
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return java.lang.Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return java.lang.Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        com.bytedance.pangle.res.a.d.a(this, bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        com.bytedance.pangle.res.a.d.a(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte b = b();
        byte b2 = b();
        return a(b(), b(), b2, b);
    }

    @Override // java.io.DataInput
    public final java.lang.String readLine() {
        throw new java.lang.UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public final long readLong() {
        byte b = b();
        byte b2 = b();
        byte b3 = b();
        byte b4 = b();
        byte b5 = b();
        return ((b() & 255) << 56) | ((b() & 255) << 48) | ((b() & 255) << 40) | ((b5 & 255) << 32) | ((b4 & 255) << 24) | ((b3 & 255) << 16) | ((b2 & 255) << 8) | (b & 255);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final java.lang.String readUTF() {
        return new java.io.DataInputStream(((java.io.FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        int read = ((java.io.FilterInputStream) this).in.read();
        if (read >= 0) {
            return read;
        }
        throw new java.io.EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return a((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return (int) ((java.io.FilterInputStream) this).in.skip(i);
    }
}
