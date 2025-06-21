package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public class AESDecrypter implements net.lingala.zip4j.crypto.IDecrypter {
    public net.lingala.zip4j.model.LocalFileHeader a;
    public net.lingala.zip4j.crypto.engine.AESEngine b;
    public net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF c;
    public int e;
    public int f;
    public int g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] m;
    public byte[] n;
    public final int d = 2;
    public int l = 1;
    public int o = 0;

    public AESDecrypter(net.lingala.zip4j.model.LocalFileHeader localFileHeader, byte[] bArr, byte[] bArr2) throws net.lingala.zip4j.exception.ZipException {
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null in AESDecryptor Constructor");
        }
        this.a = localFileHeader;
        this.k = null;
        this.m = new byte[16];
        this.n = new byte[16];
        b(bArr, bArr2);
    }

    public final byte[] a(byte[] bArr, char[] cArr) throws net.lingala.zip4j.exception.ZipException {
        try {
            return new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine(new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters("HmacSHA1", "ISO-8859-1", bArr, 1000)).deriveKey(cArr, this.e + this.f + 2);
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final void b(byte[] bArr, byte[] bArr2) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = this.a;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid file header in init method of AESDecryptor");
        }
        net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord = localFileHeader.getAesExtraDataRecord();
        if (aesExtraDataRecord == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid aes extra data record - in init method of AESDecryptor");
        }
        int aesStrength = aesExtraDataRecord.getAesStrength();
        if (aesStrength == 1) {
            this.e = 16;
            this.f = 16;
            this.g = 8;
        } else if (aesStrength == 2) {
            this.e = 24;
            this.f = 24;
            this.g = 12;
        } else {
            if (aesStrength != 3) {
                throw new net.lingala.zip4j.exception.ZipException("invalid aes key strength for file: " + this.a.getFileName());
            }
            this.e = 32;
            this.f = 32;
            this.g = 16;
        }
        if (this.a.getPassword() == null || this.a.getPassword().length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("empty or null password provided for AES Decryptor");
        }
        byte[] a = a(bArr, this.a.getPassword());
        if (a != null) {
            int length = a.length;
            int i = this.e;
            int i2 = this.f;
            if (length == i + i2 + 2) {
                byte[] bArr3 = new byte[i];
                this.h = bArr3;
                this.i = new byte[i2];
                this.j = new byte[2];
                java.lang.System.arraycopy(a, 0, bArr3, 0, i);
                java.lang.System.arraycopy(a, this.e, this.i, 0, this.f);
                java.lang.System.arraycopy(a, this.e + this.f, this.j, 0, 2);
                byte[] bArr4 = this.j;
                if (bArr4 == null) {
                    throw new net.lingala.zip4j.exception.ZipException("invalid derived password verifier for AES");
                }
                if (!java.util.Arrays.equals(bArr2, bArr4)) {
                    throw new net.lingala.zip4j.exception.ZipException("Wrong Password for file: " + this.a.getFileName(), 5);
                }
                this.b = new net.lingala.zip4j.crypto.engine.AESEngine(this.h);
                net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF macBasedPRF = new net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF("HmacSHA1");
                this.c = macBasedPRF;
                macBasedPRF.init(this.i);
                return;
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("invalid derived key");
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        return decryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.IDecrypter
    public int decryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        if (this.b == null) {
            throw new net.lingala.zip4j.exception.ZipException("AES not initialized properly");
        }
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            try {
                this.o = i6;
                this.c.update(bArr, i3, i6);
                net.lingala.zip4j.util.Raw.prepareBuffAESIVBytes(this.m, this.l, 16);
                this.b.processBlock(this.m, this.n);
                for (int i7 = 0; i7 < this.o; i7++) {
                    int i8 = i3 + i7;
                    bArr[i8] = (byte) (bArr[i8] ^ this.n[i7]);
                }
                this.l++;
                i3 = i5;
            } catch (net.lingala.zip4j.exception.ZipException e) {
                throw e;
            } catch (java.lang.Exception e2) {
                throw new net.lingala.zip4j.exception.ZipException(e2);
            }
        }
    }

    public byte[] getCalculatedAuthenticationBytes() {
        return this.c.doFinal();
    }

    public int getPasswordVerifierLength() {
        return 2;
    }

    public int getSaltLength() {
        return this.g;
    }

    public byte[] getStoredMac() {
        return this.k;
    }

    public void setStoredMac(byte[] bArr) {
        this.k = bArr;
    }
}
