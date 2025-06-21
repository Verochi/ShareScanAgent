package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public interface ByteArrayDataInput extends java.io.DataInput {
    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    boolean readBoolean();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    byte readByte();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    char readChar();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    double readDouble();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    float readFloat();

    @Override // java.io.DataInput
    void readFully(byte[] bArr);

    @Override // java.io.DataInput
    void readFully(byte[] bArr, int i, int i2);

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int readInt();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.lang.String readLine();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    long readLong();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    short readShort();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    java.lang.String readUTF();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int readUnsignedByte();

    @Override // java.io.DataInput
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    int readUnsignedShort();

    @Override // java.io.DataInput
    int skipBytes(int i);
}
