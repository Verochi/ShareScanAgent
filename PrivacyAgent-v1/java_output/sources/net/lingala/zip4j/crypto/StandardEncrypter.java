package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public class StandardEncrypter implements net.lingala.zip4j.crypto.IEncrypter {
    public net.lingala.zip4j.crypto.engine.ZipCryptoEngine a;
    public byte[] b;

    public StandardEncrypter(char[] cArr, int i) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("input password is null or empty in standard encrpyter constructor");
        }
        this.a = new net.lingala.zip4j.crypto.engine.ZipCryptoEngine();
        this.b = new byte[12];
        a(cArr, i);
    }

    public final void a(char[] cArr, int i) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.a.initKeys(cArr);
        this.b = generateRandomBytes(12);
        this.a.initKeys(cArr);
        byte[] bArr = this.b;
        bArr[11] = (byte) (i >>> 24);
        bArr[10] = (byte) (i >>> 16);
        if (bArr.length < 12) {
            throw new net.lingala.zip4j.exception.ZipException("invalid header bytes generated, cannot perform standard encryption");
        }
        encryptData(bArr);
    }

    public byte encryptByte(byte b) {
        byte decryptByte = (byte) ((this.a.decryptByte() & 255) ^ b);
        this.a.updateKeys(b);
        return decryptByte;
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        bArr.getClass();
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        if (i2 < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invalid length specified to decrpyt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                bArr[i3] = encryptByte(bArr[i3]);
            } catch (java.lang.Exception e) {
                throw new net.lingala.zip4j.exception.ZipException(e);
            }
        }
        return i2;
    }

    public byte[] generateRandomBytes(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
        }
        byte[] bArr = new byte[i];
        java.util.Random random = new java.util.Random();
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = encryptByte((byte) random.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.b;
    }
}
