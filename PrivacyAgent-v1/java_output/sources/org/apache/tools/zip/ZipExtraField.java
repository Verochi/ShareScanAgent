package org.apache.tools.zip;

/* loaded from: classes26.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    org.apache.tools.zip.ZipShort getCentralDirectoryLength();

    org.apache.tools.zip.ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    org.apache.tools.zip.ZipShort getLocalFileDataLength();

    void parseFromLocalFileData(byte[] bArr, int i, int i2) throws java.util.zip.ZipException;
}
