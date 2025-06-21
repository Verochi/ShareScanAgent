package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class Zip64EndCentralDirRecord {
    public long a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public byte[] k;

    public byte[] getExtensibleDataSector() {
        return this.k;
    }

    public int getNoOfThisDisk() {
        return this.e;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.f;
    }

    public long getOffsetStartCenDirWRTStartDiskNo() {
        return this.j;
    }

    public long getSignature() {
        return this.a;
    }

    public long getSizeOfCentralDir() {
        return this.i;
    }

    public long getSizeOfZip64EndCentralDirRec() {
        return this.b;
    }

    public long getTotNoOfEntriesInCentralDir() {
        return this.h;
    }

    public long getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.g;
    }

    public int getVersionMadeBy() {
        return this.c;
    }

    public int getVersionNeededToExtract() {
        return this.d;
    }

    public void setExtensibleDataSector(byte[] bArr) {
        this.k = bArr;
    }

    public void setNoOfThisDisk(int i) {
        this.e = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i) {
        this.f = i;
    }

    public void setOffsetStartCenDirWRTStartDiskNo(long j) {
        this.j = j;
    }

    public void setSignature(long j) {
        this.a = j;
    }

    public void setSizeOfCentralDir(long j) {
        this.i = j;
    }

    public void setSizeOfZip64EndCentralDirRec(long j) {
        this.b = j;
    }

    public void setTotNoOfEntriesInCentralDir(long j) {
        this.h = j;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(long j) {
        this.g = j;
    }

    public void setVersionMadeBy(int i) {
        this.c = i;
    }

    public void setVersionNeededToExtract(int i) {
        this.d = i;
    }
}
