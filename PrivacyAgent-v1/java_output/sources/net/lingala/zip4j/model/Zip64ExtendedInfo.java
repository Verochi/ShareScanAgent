package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class Zip64ExtendedInfo {
    public int a;
    public int b;
    public long c = -1;
    public long d = -1;
    public long e = -1;
    public int f = -1;

    public long getCompressedSize() {
        return this.c;
    }

    public int getDiskNumberStart() {
        return this.f;
    }

    public int getHeader() {
        return this.a;
    }

    public long getOffsetLocalHeader() {
        return this.e;
    }

    public int getSize() {
        return this.b;
    }

    public long getUnCompressedSize() {
        return this.d;
    }

    public void setCompressedSize(long j) {
        this.c = j;
    }

    public void setDiskNumberStart(int i) {
        this.f = i;
    }

    public void setHeader(int i) {
        this.a = i;
    }

    public void setOffsetLocalHeader(long j) {
        this.e = j;
    }

    public void setSize(int i) {
        this.b = i;
    }

    public void setUnCompressedSize(long j) {
        this.d = j;
    }
}
