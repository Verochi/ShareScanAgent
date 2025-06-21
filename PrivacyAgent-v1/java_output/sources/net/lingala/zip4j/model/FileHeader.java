package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class FileHeader {
    public java.util.ArrayList A;
    public boolean B;
    public int a;
    public int b;
    public int c;
    public byte[] d;
    public int e;
    public int f;
    public byte[] h;
    public long i;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public byte[] p;
    public long q;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.String f499s;
    public boolean t;
    public boolean u;
    public char[] w;
    public boolean x;
    public net.lingala.zip4j.model.Zip64ExtendedInfo y;
    public net.lingala.zip4j.model.AESExtraDataRecord z;
    public int v = -1;
    public long g = 0;
    public long j = 0;

    public void extractFile(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("input zipModel is null");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkOutputFolder(str)) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid output path");
        }
        new net.lingala.zip4j.unzip.Unzip(zipModel).extractFile(this, str, unzipParameters, str2, progressMonitor, z);
    }

    public void extractFile(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        extractFile(zipModel, str, unzipParameters, null, progressMonitor, z);
    }

    public void extractFile(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        extractFile(zipModel, str, null, progressMonitor, z);
    }

    public net.lingala.zip4j.model.AESExtraDataRecord getAesExtraDataRecord() {
        return this.z;
    }

    public long getCompressedSize() {
        return this.i;
    }

    public int getCompressionMethod() {
        return this.e;
    }

    public long getCrc32() {
        return this.g & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }

    public byte[] getCrcBuff() {
        return this.h;
    }

    public int getDiskNumberStart() {
        return this.n;
    }

    public int getEncryptionMethod() {
        return this.v;
    }

    public byte[] getExternalFileAttr() {
        return this.p;
    }

    public java.util.ArrayList getExtraDataRecords() {
        return this.A;
    }

    public int getExtraFieldLength() {
        return this.l;
    }

    public java.lang.String getFileComment() {
        return this.f499s;
    }

    public int getFileCommentLength() {
        return this.m;
    }

    public java.lang.String getFileName() {
        return this.r;
    }

    public int getFileNameLength() {
        return this.k;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.d;
    }

    public byte[] getInternalFileAttr() {
        return this.o;
    }

    public int getLastModFileTime() {
        return this.f;
    }

    public long getOffsetLocalHeader() {
        return this.q;
    }

    public char[] getPassword() {
        return this.w;
    }

    public int getSignature() {
        return this.a;
    }

    public long getUncompressedSize() {
        return this.j;
    }

    public int getVersionMadeBy() {
        return this.b;
    }

    public int getVersionNeededToExtract() {
        return this.c;
    }

    public net.lingala.zip4j.model.Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.y;
    }

    public boolean isDataDescriptorExists() {
        return this.x;
    }

    public boolean isDirectory() {
        return this.t;
    }

    public boolean isEncrypted() {
        return this.u;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.B;
    }

    public void setAesExtraDataRecord(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord) {
        this.z = aESExtraDataRecord;
    }

    public void setCompressedSize(long j) {
        this.i = j;
    }

    public void setCompressionMethod(int i) {
        this.e = i;
    }

    public void setCrc32(long j) {
        this.g = j;
    }

    public void setCrcBuff(byte[] bArr) {
        this.h = bArr;
    }

    public void setDataDescriptorExists(boolean z) {
        this.x = z;
    }

    public void setDirectory(boolean z) {
        this.t = z;
    }

    public void setDiskNumberStart(int i) {
        this.n = i;
    }

    public void setEncrypted(boolean z) {
        this.u = z;
    }

    public void setEncryptionMethod(int i) {
        this.v = i;
    }

    public void setExternalFileAttr(byte[] bArr) {
        this.p = bArr;
    }

    public void setExtraDataRecords(java.util.ArrayList arrayList) {
        this.A = arrayList;
    }

    public void setExtraFieldLength(int i) {
        this.l = i;
    }

    public void setFileComment(java.lang.String str) {
        this.f499s = str;
    }

    public void setFileCommentLength(int i) {
        this.m = i;
    }

    public void setFileName(java.lang.String str) {
        this.r = str;
    }

    public void setFileNameLength(int i) {
        this.k = i;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.B = z;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.d = bArr;
    }

    public void setInternalFileAttr(byte[] bArr) {
        this.o = bArr;
    }

    public void setLastModFileTime(int i) {
        this.f = i;
    }

    public void setOffsetLocalHeader(long j) {
        this.q = j;
    }

    public void setPassword(char[] cArr) {
        this.w = cArr;
    }

    public void setSignature(int i) {
        this.a = i;
    }

    public void setUncompressedSize(long j) {
        this.j = j;
    }

    public void setVersionMadeBy(int i) {
        this.b = i;
    }

    public void setVersionNeededToExtract(int i) {
        this.c = i;
    }

    public void setZip64ExtendedInfo(net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo) {
        this.y = zip64ExtendedInfo;
    }
}
