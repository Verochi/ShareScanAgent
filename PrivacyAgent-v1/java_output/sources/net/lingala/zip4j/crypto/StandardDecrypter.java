package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public class StandardDecrypter implements net.lingala.zip4j.crypto.IDecrypter {
    public net.lingala.zip4j.model.FileHeader a;
    public byte[] b = new byte[4];
    public net.lingala.zip4j.crypto.engine.ZipCryptoEngine c;

    public StandardDecrypter(net.lingala.zip4j.model.FileHeader fileHeader, byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of more of the input parameters were null in StandardDecryptor");
        }
        this.a = fileHeader;
        this.c = new net.lingala.zip4j.crypto.engine.ZipCryptoEngine();
        init(bArr);
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        return decryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        if (i < 0 || i2 < 0) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters were null in standard decrpyt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                byte decryptByte = (byte) (((bArr[i3] & 255) ^ this.c.decryptByte()) & 255);
                this.c.updateKeys(decryptByte);
                bArr[i3] = decryptByte;
            } catch (java.lang.Exception e) {
                throw new net.lingala.zip4j.exception.ZipException(e);
            }
        }
        return i2;
    }

    public void init(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        byte[] crcBuff = this.a.getCrcBuff();
        byte[] bArr2 = this.b;
        bArr2[3] = (byte) (crcBuff[3] & 255);
        byte b = crcBuff[3];
        byte b2 = (byte) ((b >> 8) & 255);
        bArr2[2] = b2;
        byte b3 = (byte) ((b >> 16) & 255);
        bArr2[1] = b3;
        byte b4 = (byte) ((b >> com.google.common.base.Ascii.CAN) & 255);
        int i = 0;
        bArr2[0] = b4;
        if (b2 > 0 || b3 > 0 || b4 > 0) {
            throw new java.lang.IllegalStateException("Invalid CRC in File Header");
        }
        if (this.a.getPassword() == null || this.a.getPassword().length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("Wrong password!", 5);
        }
        this.c.initKeys(this.a.getPassword());
        try {
            byte b5 = bArr[0];
            while (i < 12) {
                net.lingala.zip4j.crypto.engine.ZipCryptoEngine zipCryptoEngine = this.c;
                zipCryptoEngine.updateKeys((byte) (zipCryptoEngine.decryptByte() ^ b5));
                i++;
                if (i != 12) {
                    b5 = bArr[i];
                }
            }
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }
}
