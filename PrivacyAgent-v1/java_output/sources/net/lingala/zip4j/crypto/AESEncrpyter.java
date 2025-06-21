package net.lingala.zip4j.crypto;

/* loaded from: classes23.dex */
public class AESEncrpyter implements net.lingala.zip4j.crypto.IEncrypter {
    public char[] a;
    public int b;
    public net.lingala.zip4j.crypto.engine.AESEngine c;
    public net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF d;
    public int e;
    public int f;
    public int g;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public boolean m;
    public byte[] p;
    public byte[] q;
    public final int h = 2;
    public int n = 1;
    public int o = 0;

    public AESEncrpyter(char[] cArr, int i) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length == 0) {
            throw new net.lingala.zip4j.exception.ZipException("input password is empty or null in AES encrypter constructor");
        }
        if (i != 1 && i != 3) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid key strength in AES encrypter constructor");
        }
        this.a = cArr;
        this.b = i;
        this.m = false;
        this.q = new byte[16];
        this.p = new byte[16];
        c();
    }

    public static byte[] b(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i != 8 && i != 16) {
            throw new net.lingala.zip4j.exception.ZipException("invalid salt size, cannot generate salt");
        }
        int i2 = i == 8 ? 2 : 0;
        if (i == 16) {
            i2 = 4;
        }
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i2; i3++) {
            int nextInt = new java.util.Random().nextInt();
            int i4 = i3 * 4;
            bArr[i4 + 0] = (byte) (nextInt >> 24);
            bArr[i4 + 1] = (byte) (nextInt >> 16);
            bArr[i4 + 2] = (byte) (nextInt >> 8);
            bArr[i4 + 3] = (byte) nextInt;
        }
        return bArr;
    }

    public final byte[] a(byte[] bArr, char[] cArr) throws net.lingala.zip4j.exception.ZipException {
        try {
            return new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine(new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters("HmacSHA1", "ISO-8859-1", bArr, 1000)).deriveKey(cArr, this.e + this.f + 2);
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final void c() throws net.lingala.zip4j.exception.ZipException {
        int i = this.b;
        if (i == 1) {
            this.e = 16;
            this.f = 16;
            this.g = 8;
        } else {
            if (i != 3) {
                throw new net.lingala.zip4j.exception.ZipException("invalid aes key strength, cannot determine key sizes");
            }
            this.e = 32;
            this.f = 32;
            this.g = 16;
        }
        byte[] b = b(this.g);
        this.l = b;
        byte[] a = a(b, this.a);
        if (a != null) {
            int length = a.length;
            int i2 = this.e;
            int i3 = this.f;
            if (length == i2 + i3 + 2) {
                byte[] bArr = new byte[i2];
                this.i = bArr;
                this.j = new byte[i3];
                this.k = new byte[2];
                java.lang.System.arraycopy(a, 0, bArr, 0, i2);
                java.lang.System.arraycopy(a, this.e, this.j, 0, this.f);
                java.lang.System.arraycopy(a, this.e + this.f, this.k, 0, 2);
                this.c = new net.lingala.zip4j.crypto.engine.AESEngine(this.i);
                net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF macBasedPRF = new net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF("HmacSHA1");
                this.d = macBasedPRF;
                macBasedPRF.init(this.j);
                return;
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("invalid key generated, cannot decrypt file");
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        if (bArr != null) {
            return encryptData(bArr, 0, bArr.length);
        }
        throw new net.lingala.zip4j.exception.ZipException("input bytes are null, cannot perform AES encrpytion");
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        int i3;
        if (this.m) {
            throw new net.lingala.zip4j.exception.ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (i2 % 16 != 0) {
            this.m = true;
        }
        int i4 = i;
        while (true) {
            int i5 = i + i2;
            if (i4 >= i5) {
                return i2;
            }
            int i6 = i4 + 16;
            this.o = i6 <= i5 ? 16 : i5 - i4;
            net.lingala.zip4j.util.Raw.prepareBuffAESIVBytes(this.p, this.n, 16);
            this.c.processBlock(this.p, this.q);
            int i7 = 0;
            while (true) {
                i3 = this.o;
                if (i7 < i3) {
                    int i8 = i4 + i7;
                    bArr[i8] = (byte) (bArr[i8] ^ this.q[i7]);
                    i7++;
                }
            }
            this.d.update(bArr, i4, i3);
            this.n++;
            i4 = i6;
        }
    }

    public byte[] getDerivedPasswordVerifier() {
        return this.k;
    }

    public byte[] getFinalMac() {
        byte[] bArr = new byte[10];
        java.lang.System.arraycopy(this.d.doFinal(), 0, bArr, 0, 10);
        return bArr;
    }

    public int getPasswordVeriifierLength() {
        return 2;
    }

    public byte[] getSaltBytes() {
        return this.l;
    }

    public int getSaltLength() {
        return this.g;
    }

    public void setDerivedPasswordVerifier(byte[] bArr) {
        this.k = bArr;
    }

    public void setSaltBytes(byte[] bArr) {
        this.l = bArr;
    }
}
