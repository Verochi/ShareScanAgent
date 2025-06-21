package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public interface IEncrypter {
    int encryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException;

    int encryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException;
}
