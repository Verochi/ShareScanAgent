package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class JarMarker implements org.apache.tools.zip.ZipExtraField {
    public static final org.apache.tools.zip.ZipShort n = new org.apache.tools.zip.ZipShort(51966);
    public static final org.apache.tools.zip.ZipShort t = new org.apache.tools.zip.ZipShort(0);
    public static final byte[] u = new byte[0];
    public static final org.apache.tools.zip.JarMarker v = new org.apache.tools.zip.JarMarker();

    public static org.apache.tools.zip.JarMarker getInstance() {
        return v;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return u;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getCentralDirectoryLength() {
        return t;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getHeaderId() {
        return n;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return u;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public org.apache.tools.zip.ZipShort getLocalFileDataLength() {
        return t;
    }

    @Override // org.apache.tools.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException {
        if (i2 != 0) {
            throw new java.util.zip.ZipException("JarMarker doesn't expect any data");
        }
    }
}
