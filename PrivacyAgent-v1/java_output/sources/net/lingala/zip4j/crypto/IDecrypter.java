package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public interface IDecrypter {
    int decryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException;

    int decryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException;
}
