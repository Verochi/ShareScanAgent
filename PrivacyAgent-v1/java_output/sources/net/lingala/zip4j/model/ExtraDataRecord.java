package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class ExtraDataRecord {
    public long a;
    public int b;
    public byte[] c;

    public byte[] getData() {
        return this.c;
    }

    public long getHeader() {
        return this.a;
    }

    public int getSizeOfData() {
        return this.b;
    }

    public void setData(byte[] bArr) {
        this.c = bArr;
    }

    public void setHeader(long j) {
        this.a = j;
    }

    public void setSizeOfData(int i) {
        this.b = i;
    }
}
