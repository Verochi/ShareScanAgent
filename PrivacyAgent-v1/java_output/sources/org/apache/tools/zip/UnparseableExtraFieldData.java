package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class UnparseableExtraFieldData implements org.apache.tools.zip.CentralDirectoryParsingZipExtraField {
    public static final org.apache.tools.zip.ZipShort u = new org.apache.tools.zip.ZipShort(44225);
    public byte[] n;
    public byte[] t;

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.t;
        return bArr == null ? getLocalFileDataData() : org.apache.tools.zip.ZipUtil.c(bArr);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.t;
        return bArr == null ? getLocalFileDataLength() : new org.apache.tools.zip.ZipShort(bArr.length);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return u;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return org.apache.tools.zip.ZipUtil.c(this.n);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        byte[] bArr = this.n;
        return new org.apache.tools.zip.ZipShort(bArr == null ? 0 : bArr.length);
    }

    @Override // org.apache.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.t = bArr2;
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        if (this.n == null) {
            parseFromLocalFileData(bArr, i, i2);
        }
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.n = bArr2;
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
