package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class ZipModel implements java.lang.Cloneable {
    public long A = -1;
    public java.lang.String B;
    public boolean C;
    public boolean D;
    public long E;
    public long F;
    public java.lang.String G;
    public java.util.List n;
    public java.util.List t;
    public net.lingala.zip4j.model.ArchiveExtraDataRecord u;
    public net.lingala.zip4j.model.CentralDirectory v;
    public net.lingala.zip4j.model.EndCentralDirRecord w;
    public net.lingala.zip4j.model.Zip64EndCentralDirLocator x;
    public net.lingala.zip4j.model.Zip64EndCentralDirRecord y;
    public boolean z;

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return super.clone();
    }

    public net.lingala.zip4j.model.ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.u;
    }

    public net.lingala.zip4j.model.CentralDirectory getCentralDirectory() {
        return this.v;
    }

    public java.util.List getDataDescriptorList() {
        return this.t;
    }

    public long getEnd() {
        return this.F;
    }

    public net.lingala.zip4j.model.EndCentralDirRecord getEndCentralDirRecord() {
        return this.w;
    }

    public java.lang.String getFileNameCharset() {
        return this.G;
    }

    public java.util.List getLocalFileHeaderList() {
        return this.n;
    }

    public long getSplitLength() {
        return this.A;
    }

    public long getStart() {
        return this.E;
    }

    public net.lingala.zip4j.model.Zip64EndCentralDirLocator getZip64EndCentralDirLocator() {
        return this.x;
    }

    public net.lingala.zip4j.model.Zip64EndCentralDirRecord getZip64EndCentralDirRecord() {
        return this.y;
    }

    public java.lang.String getZipFile() {
        return this.B;
    }

    public boolean isNestedZipFile() {
        return this.D;
    }

    public boolean isSplitArchive() {
        return this.z;
    }

    public boolean isZip64Format() {
        return this.C;
    }

    public void setArchiveExtraDataRecord(net.lingala.zip4j.model.ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.u = archiveExtraDataRecord;
    }

    public void setCentralDirectory(net.lingala.zip4j.model.CentralDirectory centralDirectory) {
        this.v = centralDirectory;
    }

    public void setDataDescriptorList(java.util.List list) {
        this.t = list;
    }

    public void setEnd(long j) {
        this.F = j;
    }

    public void setEndCentralDirRecord(net.lingala.zip4j.model.EndCentralDirRecord endCentralDirRecord) {
        this.w = endCentralDirRecord;
    }

    public void setFileNameCharset(java.lang.String str) {
        this.G = str;
    }

    public void setLocalFileHeaderList(java.util.List list) {
        this.n = list;
    }

    public void setNestedZipFile(boolean z) {
        this.D = z;
    }

    public void setSplitArchive(boolean z) {
        this.z = z;
    }

    public void setSplitLength(long j) {
        this.A = j;
    }

    public void setStart(long j) {
        this.E = j;
    }

    public void setZip64EndCentralDirLocator(net.lingala.zip4j.model.Zip64EndCentralDirLocator zip64EndCentralDirLocator) {
        this.x = zip64EndCentralDirLocator;
    }

    public void setZip64EndCentralDirRecord(net.lingala.zip4j.model.Zip64EndCentralDirRecord zip64EndCentralDirRecord) {
        this.y = zip64EndCentralDirRecord;
    }

    public void setZip64Format(boolean z) {
        this.C = z;
    }

    public void setZipFile(java.lang.String str) {
        this.B = str;
    }
}
