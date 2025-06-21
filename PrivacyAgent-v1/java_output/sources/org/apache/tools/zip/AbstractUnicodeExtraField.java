package org.apache.tools.zip;

/* loaded from: classes26.dex */
public abstract class AbstractUnicodeExtraField implements org.apache.tools.zip.ZipExtraField {
    public long n;
    public byte[] t;
    public byte[] u;

    public AbstractUnicodeExtraField() {
    }

    public AbstractUnicodeExtraField(java.lang.String str, byte[] bArr) {
        this(str, bArr, 0, bArr.length);
    }

    public AbstractUnicodeExtraField(java.lang.String str, byte[] bArr, int i, int i2) {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(bArr, i, i2);
        this.n = crc32.getValue();
        try {
            this.t = str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("FATAL: UTF-8 encoding not supported.", e);
        }
    }

    public final void a() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length + 5];
        this.u = bArr2;
        bArr2[0] = 1;
        java.lang.System.arraycopy(org.apache.tools.zip.ZipLong.getBytes(this.n), 0, this.u, 1, 4);
        byte[] bArr3 = this.t;
        java.lang.System.arraycopy(bArr3, 0, this.u, 5, bArr3.length);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.u == null) {
            a();
        }
        byte[] bArr = this.u;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        if (this.u == null) {
            a();
        }
        return new org.apache.tools.zip.ZipShort(this.u.length);
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return getCentralDirectoryData();
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        return getCentralDirectoryLength();
    }

    public long getNameCRC32() {
        return this.n;
    }

    public byte[] getUnicodeName() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException {
        if (i2 < 5) {
            throw new java.util.zip.ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b = bArr[i];
        if (b != 1) {
            throw new java.util.zip.ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        this.n = org.apache.tools.zip.ZipLong.getValue(bArr, i + 1);
        int i3 = i2 - 5;
        byte[] bArr2 = new byte[i3];
        this.t = bArr2;
        java.lang.System.arraycopy(bArr, i + 5, bArr2, 0, i3);
        this.u = null;
    }

    public void setNameCRC32(long j) {
        this.n = j;
        this.u = null;
    }

    public void setUnicodeName(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.t = bArr2;
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            this.t = null;
        }
        this.u = null;
    }
}
