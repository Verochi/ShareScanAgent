package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface ByteArrayDataOutput extends java.io.DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i, int i2);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z);

    @Override // java.io.DataOutput
    void writeByte(int i);

    @Override // java.io.DataOutput
    @java.lang.Deprecated
    void writeBytes(java.lang.String str);

    @Override // java.io.DataOutput
    void writeChar(int i);

    @Override // java.io.DataOutput
    void writeChars(java.lang.String str);

    @Override // java.io.DataOutput
    void writeDouble(double d);

    @Override // java.io.DataOutput
    void writeFloat(float f);

    @Override // java.io.DataOutput
    void writeInt(int i);

    @Override // java.io.DataOutput
    void writeLong(long j);

    @Override // java.io.DataOutput
    void writeShort(int i);

    @Override // java.io.DataOutput
    void writeUTF(java.lang.String str);
}
