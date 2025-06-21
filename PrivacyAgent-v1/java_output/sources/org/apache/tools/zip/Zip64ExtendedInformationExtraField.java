package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class Zip64ExtendedInformationExtraField implements org.apache.tools.zip.CentralDirectoryParsingZipExtraField {
    public static final org.apache.tools.zip.ZipShort x = new org.apache.tools.zip.ZipShort(1);
    public static final byte[] y = new byte[0];
    public org.apache.tools.zip.ZipEightByteInteger n;
    public org.apache.tools.zip.ZipEightByteInteger t;
    public org.apache.tools.zip.ZipEightByteInteger u;
    public org.apache.tools.zip.ZipLong v;
    public byte[] w;

    public Zip64ExtendedInformationExtraField() {
    }

    public Zip64ExtendedInformationExtraField(org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger, org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger2) {
        this(zipEightByteInteger, zipEightByteInteger2, null, null);
    }

    public Zip64ExtendedInformationExtraField(org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger, org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger2, org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger3, org.apache.tools.zip.ZipLong zipLong) {
        this.n = zipEightByteInteger;
        this.t = zipEightByteInteger2;
        this.u = zipEightByteInteger3;
        this.v = zipLong;
    }

    public final int a(byte[] bArr) {
        int i;
        org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger = this.n;
        if (zipEightByteInteger != null) {
            java.lang.System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, 0, 8);
            i = 8;
        } else {
            i = 0;
        }
        org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger2 = this.t;
        if (zipEightByteInteger2 == null) {
            return i;
        }
        java.lang.System.arraycopy(zipEightByteInteger2.getBytes(), 0, bArr, i, 8);
        return i + 8;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] bArr = new byte[getCentralDirectoryLength().getValue()];
        int a = a(bArr);
        org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger = this.u;
        if (zipEightByteInteger != null) {
            java.lang.System.arraycopy(zipEightByteInteger.getBytes(), 0, bArr, a, 8);
            a += 8;
        }
        org.apache.tools.zip.ZipLong zipLong = this.v;
        if (zipLong != null) {
            java.lang.System.arraycopy(zipLong.getBytes(), 0, bArr, a, 4);
        }
        return bArr;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        return new org.apache.tools.zip.ZipShort((this.n != null ? 8 : 0) + (this.t != null ? 8 : 0) + (this.u == null ? 0 : 8) + (this.v != null ? 4 : 0));
    }

    public org.apache.tools.zip.ZipEightByteInteger getCompressedSize() {
        return this.t;
    }

    public org.apache.tools.zip.ZipLong getDiskStartNumber() {
        return this.v;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return x;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger = this.n;
        if (zipEightByteInteger == null && this.t == null) {
            return y;
        }
        if (zipEightByteInteger == null || this.t == null) {
            throw new java.lang.IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        a(bArr);
        return bArr;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        return new org.apache.tools.zip.ZipShort(this.n != null ? 16 : 0);
    }

    public org.apache.tools.zip.ZipEightByteInteger getRelativeHeaderOffset() {
        return this.u;
    }

    public org.apache.tools.zip.ZipEightByteInteger getSize() {
        return this.n;
    }

    @Override // org.apache.tools.zip.CentralDirectoryParsingZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException {
        byte[] bArr2 = new byte[i2];
        this.w = bArr2;
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        if (i2 >= 28) {
            parseFromLocalFileData(bArr, i, i2);
            return;
        }
        if (i2 != 24) {
            if (i2 % 8 == 4) {
                this.v = new org.apache.tools.zip.ZipLong(bArr, (i + i2) - 4);
            }
        } else {
            this.n = new org.apache.tools.zip.ZipEightByteInteger(bArr, i);
            int i3 = i + 8;
            this.t = new org.apache.tools.zip.ZipEightByteInteger(bArr, i3);
            this.u = new org.apache.tools.zip.ZipEightByteInteger(bArr, i3 + 8);
        }
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException {
        if (i2 == 0) {
            return;
        }
        if (i2 < 16) {
            throw new java.util.zip.ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.n = new org.apache.tools.zip.ZipEightByteInteger(bArr, i);
        int i3 = i + 8;
        this.t = new org.apache.tools.zip.ZipEightByteInteger(bArr, i3);
        int i4 = i3 + 8;
        int i5 = i2 - 16;
        if (i5 >= 8) {
            this.u = new org.apache.tools.zip.ZipEightByteInteger(bArr, i4);
            i4 += 8;
            i5 -= 8;
        }
        if (i5 >= 4) {
            this.v = new org.apache.tools.zip.ZipLong(bArr, i4);
        }
    }

    public void reparseCentralDirectoryData(boolean z, boolean z2, boolean z3, boolean z4) throws java.util.zip.ZipException {
        byte[] bArr = this.w;
        if (bArr != null) {
            int i = 0;
            int i2 = (z ? 8 : 0) + (z2 ? 8 : 0) + (z3 ? 8 : 0) + (z4 ? 4 : 0);
            if (bArr.length < i2) {
                throw new java.util.zip.ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + i2 + " but is " + this.w.length);
            }
            if (z) {
                this.n = new org.apache.tools.zip.ZipEightByteInteger(this.w, 0);
                i = 8;
            }
            if (z2) {
                this.t = new org.apache.tools.zip.ZipEightByteInteger(this.w, i);
                i += 8;
            }
            if (z3) {
                this.u = new org.apache.tools.zip.ZipEightByteInteger(this.w, i);
                i += 8;
            }
            if (z4) {
                this.v = new org.apache.tools.zip.ZipLong(this.w, i);
            }
        }
    }

    public void setCompressedSize(org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger) {
        this.t = zipEightByteInteger;
    }

    public void setDiskStartNumber(org.apache.tools.zip.ZipLong zipLong) {
        this.v = zipLong;
    }

    public void setRelativeHeaderOffset(org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger) {
        this.u = zipEightByteInteger;
    }

    public void setSize(org.apache.tools.zip.ZipEightByteInteger zipEightByteInteger) {
        this.n = zipEightByteInteger;
    }
}
