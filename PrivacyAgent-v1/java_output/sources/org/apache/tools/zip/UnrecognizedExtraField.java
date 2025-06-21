package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class UnrecognizedExtraField implements org.apache.tools.zip.CentralDirectoryParsingZipExtraField {
    public org.apache.tools.zip.ZipShort n;
    public byte[] t;
    public byte[] u;

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.u;
        return bArr != null ? org.apache.tools.zip.ZipUtil.c(bArr) : getLocalFileDataData();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        byte[] bArr = this.u;
        return bArr != null ? new org.apache.tools.zip.ZipShort(bArr.length) : getLocalFileDataLength();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return this.n;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return org.apache.tools.zip.ZipUtil.c(this.t);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        return new org.apache.tools.zip.ZipShort(this.t.length);
    }

    @Override // org.apache.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        setCentralDirectoryData(bArr2);
        if (this.t == null) {
            setLocalFileDataData(bArr2);
        }
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        setLocalFileDataData(bArr2);
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.u = org.apache.tools.zip.ZipUtil.c(bArr);
    }

    public void setHeaderId(org.apache.tools.zip.ZipShort zipShort) {
        this.n = zipShort;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.t = org.apache.tools.zip.ZipUtil.c(bArr);
    }
}
