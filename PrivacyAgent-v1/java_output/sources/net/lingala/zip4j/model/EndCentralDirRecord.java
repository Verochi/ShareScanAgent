package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class EndCentralDirRecord {
    public long a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public java.lang.String i;
    public byte[] j;

    public java.lang.String getComment() {
        return this.i;
    }

    public byte[] getCommentBytes() {
        return this.j;
    }

    public int getCommentLength() {
        return this.h;
    }

    public int getNoOfThisDisk() {
        return this.b;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.c;
    }

    public long getOffsetOfStartOfCentralDir() {
        return this.g;
    }

    public long getSignature() {
        return this.a;
    }

    public int getSizeOfCentralDir() {
        return this.f;
    }

    public int getTotNoOfEntriesInCentralDir() {
        return this.e;
    }

    public int getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.d;
    }

    public void setComment(java.lang.String str) {
        this.i = str;
    }

    public void setCommentBytes(byte[] bArr) {
        this.j = bArr;
    }

    public void setCommentLength(int i) {
        this.h = i;
    }

    public void setNoOfThisDisk(int i) {
        this.b = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i) {
        this.c = i;
    }

    public void setOffsetOfStartOfCentralDir(long j) {
        this.g = j;
    }

    public void setSignature(long j) {
        this.a = j;
    }

    public void setSizeOfCentralDir(int i) {
        this.f = i;
    }

    public void setTotNoOfEntriesInCentralDir(int i) {
        this.e = i;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(int i) {
        this.d = i;
    }
}
