package org.apache.tools.zip;

/* loaded from: classes26.dex */
public class ZipEntry extends java.util.zip.ZipEntry implements java.lang.Cloneable {
    public static final int CRC_UNKNOWN = -1;
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    public byte[] A;
    public org.apache.tools.zip.GeneralPurposeBit B;
    public int n;
    public long t;
    public int u;
    public int v;
    public long w;
    public org.apache.tools.zip.ZipExtraField[] x;
    public org.apache.tools.zip.UnparseableExtraFieldData y;
    public java.lang.String z;
    public static final byte[] C = new byte[0];
    public static final org.apache.tools.zip.ZipExtraField[] D = new org.apache.tools.zip.ZipExtraField[0];

    public ZipEntry() {
        this("");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZipEntry(java.io.File file, java.lang.String str) {
        this(str);
        if (file.isDirectory() && !str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (file.isFile()) {
            setSize(file.length());
        }
        setTime(file.lastModified());
    }

    public ZipEntry(java.lang.String str) {
        super(str);
        this.n = -1;
        this.t = -1L;
        this.u = 0;
        this.v = 0;
        this.w = 0L;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = new org.apache.tools.zip.GeneralPurposeBit();
        setName(str);
    }

    public ZipEntry(java.util.zip.ZipEntry zipEntry) throws java.util.zip.ZipException {
        super(zipEntry);
        this.n = -1;
        this.t = -1L;
        this.u = 0;
        this.v = 0;
        this.w = 0L;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = new org.apache.tools.zip.GeneralPurposeBit();
        setName(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(org.apache.tools.zip.ExtraFieldUtils.parse(extra, true, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField.READ));
        } else {
            setExtra();
        }
        setMethod(zipEntry.getMethod());
        this.t = zipEntry.getSize();
    }

    public ZipEntry(org.apache.tools.zip.ZipEntry zipEntry) throws java.util.zip.ZipException {
        this((java.util.zip.ZipEntry) zipEntry);
        setInternalAttributes(zipEntry.getInternalAttributes());
        setExternalAttributes(zipEntry.getExternalAttributes());
        setExtraFields(d());
        setPlatform(zipEntry.getPlatform());
        org.apache.tools.zip.GeneralPurposeBit generalPurposeBit = zipEntry.getGeneralPurposeBit();
        setGeneralPurposeBit(generalPurposeBit == null ? null : (org.apache.tools.zip.GeneralPurposeBit) generalPurposeBit.clone());
    }

    public final org.apache.tools.zip.ZipExtraField[] a(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) {
        return b(zipExtraFieldArr, zipExtraFieldArr.length);
    }

    public void addAsFirstExtraField(org.apache.tools.zip.ZipExtraField zipExtraField) {
        if (zipExtraField instanceof org.apache.tools.zip.UnparseableExtraFieldData) {
            this.y = (org.apache.tools.zip.UnparseableExtraFieldData) zipExtraField;
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
            org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr2 = new org.apache.tools.zip.ZipExtraField[zipExtraFieldArr != null ? zipExtraFieldArr.length + 1 : 1];
            this.x = zipExtraFieldArr2;
            zipExtraFieldArr2[0] = zipExtraField;
            if (zipExtraFieldArr != null) {
                java.lang.System.arraycopy(zipExtraFieldArr, 0, zipExtraFieldArr2, 1, zipExtraFieldArr2.length - 1);
            }
        }
        setExtra();
    }

    public void addExtraField(org.apache.tools.zip.ZipExtraField zipExtraField) {
        if (zipExtraField instanceof org.apache.tools.zip.UnparseableExtraFieldData) {
            this.y = (org.apache.tools.zip.UnparseableExtraFieldData) zipExtraField;
        } else if (this.x == null) {
            this.x = new org.apache.tools.zip.ZipExtraField[]{zipExtraField};
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
            org.apache.tools.zip.ZipExtraField[] b = b(zipExtraFieldArr, zipExtraFieldArr.length + 1);
            b[this.x.length] = zipExtraField;
            this.x = b;
        }
        setExtra();
    }

    public final org.apache.tools.zip.ZipExtraField[] b(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr, int i) {
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr2 = new org.apache.tools.zip.ZipExtraField[i];
        java.lang.System.arraycopy(zipExtraFieldArr, 0, zipExtraFieldArr2, 0, java.lang.Math.min(zipExtraFieldArr.length, i));
        return zipExtraFieldArr2;
    }

    public final org.apache.tools.zip.ZipExtraField[] c() {
        org.apache.tools.zip.ZipExtraField[] d = d();
        return d == this.x ? a(d) : d;
    }

    @Override // java.util.zip.ZipEntry
    public java.lang.Object clone() {
        org.apache.tools.zip.ZipEntry zipEntry = (org.apache.tools.zip.ZipEntry) super.clone();
        zipEntry.setInternalAttributes(getInternalAttributes());
        zipEntry.setExternalAttributes(getExternalAttributes());
        zipEntry.setExtraFields(d());
        return zipEntry;
    }

    public final org.apache.tools.zip.ZipExtraField[] d() {
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
        return zipExtraFieldArr == null ? h() : this.y != null ? e() : zipExtraFieldArr;
    }

    public final org.apache.tools.zip.ZipExtraField[] e() {
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
        org.apache.tools.zip.ZipExtraField[] b = b(zipExtraFieldArr, zipExtraFieldArr.length + 1);
        b[this.x.length] = this.y;
        return b;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        org.apache.tools.zip.ZipEntry zipEntry = (org.apache.tools.zip.ZipEntry) obj;
        java.lang.String name = getName();
        java.lang.String name2 = zipEntry.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        java.lang.String comment = getComment();
        java.lang.String comment2 = zipEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        return getTime() == zipEntry.getTime() && comment.equals(comment2) && getInternalAttributes() == zipEntry.getInternalAttributes() && getPlatform() == zipEntry.getPlatform() && getExternalAttributes() == zipEntry.getExternalAttributes() && getMethod() == zipEntry.getMethod() && getSize() == zipEntry.getSize() && getCrc() == zipEntry.getCrc() && getCompressedSize() == zipEntry.getCompressedSize() && java.util.Arrays.equals(getCentralDirectoryExtra(), zipEntry.getCentralDirectoryExtra()) && java.util.Arrays.equals(getLocalFileDataExtra(), zipEntry.getLocalFileDataExtra()) && this.B.equals(zipEntry.B);
    }

    public final org.apache.tools.zip.ZipExtraField[] f() {
        org.apache.tools.zip.ZipExtraField[] g = g();
        return g == this.x ? a(g) : g;
    }

    public final org.apache.tools.zip.ZipExtraField[] g() {
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
        return zipExtraFieldArr == null ? D : zipExtraFieldArr;
    }

    public byte[] getCentralDirectoryExtra() {
        return org.apache.tools.zip.ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields(true));
    }

    public long getExternalAttributes() {
        return this.w;
    }

    public org.apache.tools.zip.ZipExtraField getExtraField(org.apache.tools.zip.ZipShort zipShort) {
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.x;
        if (zipExtraFieldArr == null) {
            return null;
        }
        for (org.apache.tools.zip.ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipShort.equals(zipExtraField.getHeaderId())) {
                return zipExtraField;
            }
        }
        return null;
    }

    public org.apache.tools.zip.ZipExtraField[] getExtraFields() {
        return f();
    }

    public org.apache.tools.zip.ZipExtraField[] getExtraFields(boolean z) {
        return z ? c() : f();
    }

    public org.apache.tools.zip.GeneralPurposeBit getGeneralPurposeBit() {
        return this.B;
    }

    public int getInternalAttributes() {
        return this.u;
    }

    public java.util.Date getLastModifiedDate() {
        return new java.util.Date(getTime());
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        return extra != null ? extra : C;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.n;
    }

    @Override // java.util.zip.ZipEntry
    public java.lang.String getName() {
        java.lang.String str = this.z;
        return str == null ? super.getName() : str;
    }

    public int getPlatform() {
        return this.v;
    }

    public byte[] getRawName() {
        byte[] bArr = this.A;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.t;
    }

    public int getUnixMode() {
        if (this.v != 3) {
            return 0;
        }
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    public org.apache.tools.zip.UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.y;
    }

    public final org.apache.tools.zip.ZipExtraField[] h() {
        org.apache.tools.zip.UnparseableExtraFieldData unparseableExtraFieldData = this.y;
        return unparseableExtraFieldData == null ? D : new org.apache.tools.zip.ZipExtraField[]{unparseableExtraFieldData};
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    public final void i(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr, boolean z) throws java.util.zip.ZipException {
        if (this.x == null) {
            setExtraFields(zipExtraFieldArr);
            return;
        }
        for (org.apache.tools.zip.ZipExtraField zipExtraField : zipExtraFieldArr) {
            org.apache.tools.zip.ZipExtraField extraField = zipExtraField instanceof org.apache.tools.zip.UnparseableExtraFieldData ? this.y : getExtraField(zipExtraField.getHeaderId());
            if (extraField == null) {
                addExtraField(zipExtraField);
            } else if (z || !(extraField instanceof org.apache.tools.zip.CentralDirectoryParsingZipExtraField)) {
                byte[] localFileDataData = zipExtraField.getLocalFileDataData();
                extraField.parseFromLocalFileData(localFileDataData, 0, localFileDataData.length);
            } else {
                byte[] centralDirectoryData = zipExtraField.getCentralDirectoryData();
                ((org.apache.tools.zip.CentralDirectoryParsingZipExtraField) extraField).parseFromCentralDirectoryData(centralDirectoryData, 0, centralDirectoryData.length);
            }
        }
        setExtra();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    public void removeExtraField(org.apache.tools.zip.ZipShort zipShort) {
        if (this.x == null) {
            throw new java.util.NoSuchElementException();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.apache.tools.zip.ZipExtraField zipExtraField : this.x) {
            if (!zipShort.equals(zipExtraField.getHeaderId())) {
                arrayList.add(zipExtraField);
            }
        }
        if (this.x.length == arrayList.size()) {
            throw new java.util.NoSuchElementException();
        }
        this.x = (org.apache.tools.zip.ZipExtraField[]) arrayList.toArray(new org.apache.tools.zip.ZipExtraField[arrayList.size()]);
        setExtra();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.y == null) {
            throw new java.util.NoSuchElementException();
        }
        this.y = null;
        setExtra();
    }

    public void setCentralDirectoryExtra(byte[] bArr) {
        try {
            i(org.apache.tools.zip.ExtraFieldUtils.parse(bArr, false, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField.READ), false);
        } catch (java.util.zip.ZipException e) {
            throw new java.lang.RuntimeException(e.getMessage(), e);
        }
    }

    @java.lang.Deprecated
    public void setComprSize(long j) {
        setCompressedSize(j);
    }

    public void setExternalAttributes(long j) {
        this.w = j;
    }

    public void setExtra() {
        super.setExtra(org.apache.tools.zip.ExtraFieldUtils.mergeLocalFileDataData(getExtraFields(true)));
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws java.lang.RuntimeException {
        try {
            i(org.apache.tools.zip.ExtraFieldUtils.parse(bArr, true, org.apache.tools.zip.ExtraFieldUtils.UnparseableExtraField.READ), true);
        } catch (java.util.zip.ZipException e) {
            throw new java.lang.RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    public void setExtraFields(org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.apache.tools.zip.ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipExtraField instanceof org.apache.tools.zip.UnparseableExtraFieldData) {
                this.y = (org.apache.tools.zip.UnparseableExtraFieldData) zipExtraField;
            } else {
                arrayList.add(zipExtraField);
            }
        }
        this.x = (org.apache.tools.zip.ZipExtraField[]) arrayList.toArray(new org.apache.tools.zip.ZipExtraField[arrayList.size()]);
        setExtra();
    }

    public void setGeneralPurposeBit(org.apache.tools.zip.GeneralPurposeBit generalPurposeBit) {
        this.B = generalPurposeBit;
    }

    public void setInternalAttributes(int i) {
        this.u = i;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i) {
        if (i >= 0) {
            this.n = i;
            return;
        }
        throw new java.lang.IllegalArgumentException("ZIP compression method can not be negative: " + i);
    }

    public void setName(java.lang.String str) {
        if (str != null && getPlatform() == 0 && !str.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str.replace('\\', '/');
        }
        this.z = str;
    }

    public void setName(java.lang.String str, byte[] bArr) {
        setName(str);
        this.A = bArr;
    }

    public void setPlatform(int i) {
        this.v = i;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("invalid entry size");
        }
        this.t = j;
    }

    public void setUnixMode(int i) {
        setExternalAttributes(((i & 128) == 0 ? 1 : 0) | (i << 16) | (isDirectory() ? 16 : 0));
        this.v = 3;
    }
}
