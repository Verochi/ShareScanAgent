package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public abstract class f implements java.io.DataInput {
    public final com.bytedance.pangle.res.a.i a;

    public f(com.bytedance.pangle.res.a.i iVar) {
        this.a = iVar;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.a.readInt();
    }

    @Override // java.io.DataInput
    public java.lang.String readLine() {
        return this.a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.a.readShort();
    }

    @Override // java.io.DataInput
    public java.lang.String readUTF() {
        return this.a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.a.skipBytes(i);
    }
}
