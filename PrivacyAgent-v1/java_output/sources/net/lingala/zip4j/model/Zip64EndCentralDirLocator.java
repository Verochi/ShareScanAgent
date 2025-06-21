package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class Zip64EndCentralDirLocator {
    public long a;
    public int b;
    public long c;
    public int d;

    public int getNoOfDiskStartOfZip64EndOfCentralDirRec() {
        return this.b;
    }

    public long getOffsetZip64EndOfCentralDirRec() {
        return this.c;
    }

    public long getSignature() {
        return this.a;
    }

    public int getTotNumberOfDiscs() {
        return this.d;
    }

    public void setNoOfDiskStartOfZip64EndOfCentralDirRec(int i) {
        this.b = i;
    }

    public void setOffsetZip64EndOfCentralDirRec(long j) {
        this.c = j;
    }

    public void setSignature(long j) {
        this.a = j;
    }

    public void setTotNumberOfDiscs(int i) {
        this.d = i;
    }
}
