package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class AsiExtraField implements org.apache.tools.zip.ZipExtraField, org.apache.tools.zip.UnixStat, java.lang.Cloneable {
    public static final org.apache.tools.zip.ZipShort y = new org.apache.tools.zip.ZipShort(30062);
    public int n = 0;
    public int t = 0;
    public int u = 0;
    public java.lang.String v = "";
    public boolean w = false;
    public java.util.zip.CRC32 x = new java.util.zip.CRC32();

    public java.lang.Object clone() {
        try {
            org.apache.tools.zip.AsiExtraField asiExtraField = (org.apache.tools.zip.AsiExtraField) super.clone();
            asiExtraField.x = new java.util.zip.CRC32();
            return asiExtraField;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public int getGroupId() {
        return this.u;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return y;
    }

    public java.lang.String getLinkedFile() {
        return this.v;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        int value = getLocalFileDataLength().getValue() - 4;
        byte[] bArr = new byte[value];
        java.lang.System.arraycopy(org.apache.tools.zip.ZipShort.getBytes(getMode()), 0, bArr, 0, 2);
        byte[] bytes = getLinkedFile().getBytes();
        java.lang.System.arraycopy(org.apache.tools.zip.ZipLong.getBytes(bytes.length), 0, bArr, 2, 4);
        java.lang.System.arraycopy(org.apache.tools.zip.ZipShort.getBytes(getUserId()), 0, bArr, 6, 2);
        java.lang.System.arraycopy(org.apache.tools.zip.ZipShort.getBytes(getGroupId()), 0, bArr, 8, 2);
        java.lang.System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.x.reset();
        this.x.update(bArr);
        byte[] bArr2 = new byte[value + 4];
        java.lang.System.arraycopy(org.apache.tools.zip.ZipLong.getBytes(this.x.getValue()), 0, bArr2, 0, 4);
        java.lang.System.arraycopy(bArr, 0, bArr2, 4, value);
        return bArr2;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        return new org.apache.tools.zip.ZipShort(getLinkedFile().getBytes().length + 14);
    }

    public int getMode() {
        return this.n;
    }

    public int getMode(int i) {
        return (i & org.apache.tools.zip.UnixStat.PERM_MASK) | (isLink() ? org.apache.tools.zip.UnixStat.LINK_FLAG : isDirectory() ? 16384 : 32768);
    }

    public int getUserId() {
        return this.t;
    }

    public boolean isDirectory() {
        return this.w && !isLink();
    }

    public boolean isLink() {
        return getLinkedFile().length() != 0;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException {
        long value = org.apache.tools.zip.ZipLong.getValue(bArr, i);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        java.lang.System.arraycopy(bArr, i + 4, bArr2, 0, i3);
        this.x.reset();
        this.x.update(bArr2);
        long value2 = this.x.getValue();
        if (value != value2) {
            throw new java.util.zip.ZipException("bad CRC checksum " + java.lang.Long.toHexString(value) + " instead of " + java.lang.Long.toHexString(value2));
        }
        int value3 = org.apache.tools.zip.ZipShort.getValue(bArr2, 0);
        int value4 = (int) org.apache.tools.zip.ZipLong.getValue(bArr2, 2);
        if (value4 < 0 || value4 > i3 - 10) {
            throw new java.util.zip.ZipException("Bad symbolic link name length " + value4 + " in ASI extra field");
        }
        this.t = org.apache.tools.zip.ZipShort.getValue(bArr2, 6);
        this.u = org.apache.tools.zip.ZipShort.getValue(bArr2, 8);
        if (value4 == 0) {
            this.v = "";
        } else {
            byte[] bArr3 = new byte[value4];
            java.lang.System.arraycopy(bArr2, 10, bArr3, 0, value4);
            this.v = new java.lang.String(bArr3);
        }
        setDirectory((value3 & 16384) != 0);
        setMode(value3);
    }

    public void setDirectory(boolean z) {
        this.w = z;
        this.n = getMode(this.n);
    }

    public void setGroupId(int i) {
        this.u = i;
    }

    public void setLinkedFile(java.lang.String str) {
        this.v = str;
        this.n = getMode(this.n);
    }

    public void setMode(int i) {
        this.n = getMode(i);
    }

    public void setUserId(int i) {
        this.t = i;
    }
}
