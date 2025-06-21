package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class LittleEndianDataOutputStream extends java.io.FilterOutputStream implements java.io.DataOutput {
    public LittleEndianDataOutputStream(java.io.OutputStream outputStream) {
        super(new java.io.DataOutputStream((java.io.OutputStream) com.google.common.base.Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) throws java.io.IOException {
        ((java.io.DataOutputStream) ((java.io.FilterOutputStream) this).out).writeBoolean(z);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) throws java.io.IOException {
        ((java.io.DataOutputStream) ((java.io.FilterOutputStream) this).out).writeByte(i);
    }

    @Override // java.io.DataOutput
    @java.lang.Deprecated
    public void writeBytes(java.lang.String str) throws java.io.IOException {
        ((java.io.DataOutputStream) ((java.io.FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) throws java.io.IOException {
        writeShort(i);
    }

    @Override // java.io.DataOutput
    public void writeChars(java.lang.String str) throws java.io.IOException {
        for (int i = 0; i < str.length(); i++) {
            writeChar(str.charAt(i));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) throws java.io.IOException {
        writeLong(java.lang.Double.doubleToLongBits(d));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) throws java.io.IOException {
        writeInt(java.lang.Float.floatToIntBits(f));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.write(i & 255);
        ((java.io.FilterOutputStream) this).out.write((i >> 8) & 255);
        ((java.io.FilterOutputStream) this).out.write((i >> 16) & 255);
        ((java.io.FilterOutputStream) this).out.write((i >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) throws java.io.IOException {
        byte[] byteArray = com.google.common.primitives.Longs.toByteArray(java.lang.Long.reverseBytes(j));
        write(byteArray, 0, byteArray.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) throws java.io.IOException {
        ((java.io.FilterOutputStream) this).out.write(i & 255);
        ((java.io.FilterOutputStream) this).out.write((i >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(java.lang.String str) throws java.io.IOException {
        ((java.io.DataOutputStream) ((java.io.FilterOutputStream) this).out).writeUTF(str);
    }
}
