package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class LocalFileHeader {
    public int a;
    public int b;
    public byte[] c;
    public int d;
    public int e;
    public byte[] g;
    public long h;
    public int j;
    public int k;
    public java.lang.String l;
    public byte[] m;
    public long n;
    public boolean o;
    public char[] q;
    public java.util.ArrayList r;

    /* renamed from: s, reason: collision with root package name */
    public net.lingala.zip4j.model.Zip64ExtendedInfo f500s;
    public net.lingala.zip4j.model.AESExtraDataRecord t;
    public boolean u;
    public boolean w;
    public int p = -1;
    public boolean v = false;
    public long f = 0;
    public long i = 0;

    public net.lingala.zip4j.model.AESExtraDataRecord getAesExtraDataRecord() {
        return this.t;
    }

    public long getCompressedSize() {
        return this.h;
    }

    public int getCompressionMethod() {
        return this.d;
    }

    public long getCrc32() {
        return this.f;
    }

    public byte[] getCrcBuff() {
        return this.g;
    }

    public int getEncryptionMethod() {
        return this.p;
    }

    public java.util.ArrayList getExtraDataRecords() {
        return this.r;
    }

    public byte[] getExtraField() {
        return this.m;
    }

    public int getExtraFieldLength() {
        return this.k;
    }

    public java.lang.String getFileName() {
        return this.l;
    }

    public int getFileNameLength() {
        return this.j;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.c;
    }

    public int getLastModFileTime() {
        return this.e;
    }

    public long getOffsetStartOfData() {
        return this.n;
    }

    public char[] getPassword() {
        return this.q;
    }

    public int getSignature() {
        return this.a;
    }

    public long getUncompressedSize() {
        return this.i;
    }

    public int getVersionNeededToExtract() {
        return this.b;
    }

    public net.lingala.zip4j.model.Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.f500s;
    }

    public boolean isDataDescriptorExists() {
        return this.u;
    }

    public boolean isEncrypted() {
        return this.o;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.w;
    }

    public boolean isWriteComprSizeInZip64ExtraRecord() {
        return this.v;
    }

    public void setAesExtraDataRecord(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord) {
        this.t = aESExtraDataRecord;
    }

    public void setCompressedSize(long j) {
        this.h = j;
    }

    public void setCompressionMethod(int i) {
        this.d = i;
    }

    public void setCrc32(long j) {
        this.f = j;
    }

    public void setCrcBuff(byte[] bArr) {
        this.g = bArr;
    }

    public void setDataDescriptorExists(boolean z) {
        this.u = z;
    }

    public void setEncrypted(boolean z) {
        this.o = z;
    }

    public void setEncryptionMethod(int i) {
        this.p = i;
    }

    public void setExtraDataRecords(java.util.ArrayList arrayList) {
        this.r = arrayList;
    }

    public void setExtraField(byte[] bArr) {
        this.m = bArr;
    }

    public void setExtraFieldLength(int i) {
        this.k = i;
    }

    public void setFileName(java.lang.String str) {
        this.l = str;
    }

    public void setFileNameLength(int i) {
        this.j = i;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.w = z;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.c = bArr;
    }

    public void setLastModFileTime(int i) {
        this.e = i;
    }

    public void setOffsetStartOfData(long j) {
        this.n = j;
    }

    public void setPassword(char[] cArr) {
        this.q = cArr;
    }

    public void setSignature(int i) {
        this.a = i;
    }

    public void setUncompressedSize(long j) {
        this.i = j;
    }

    public void setVersionNeededToExtract(int i) {
        this.b = i;
    }

    public void setWriteComprSizeInZip64ExtraRecord(boolean z) {
        this.v = z;
    }

    public void setZip64ExtendedInfo(net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo) {
        this.f500s = zip64ExtendedInfo;
    }
}
