package net.lingala.zip4j.crypto.PBKDF2;

/* loaded from: classes23.dex */
public class PBKDF2Engine {
    protected net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters parameters;
    protected net.lingala.zip4j.crypto.PBKDF2.PRF prf;

    public PBKDF2Engine() {
        this.parameters = null;
        this.prf = null;
    }

    public PBKDF2Engine(net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
        this.prf = null;
    }

    public PBKDF2Engine(net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters pBKDF2Parameters, net.lingala.zip4j.crypto.PBKDF2.PRF prf) {
        this.parameters = pBKDF2Parameters;
        this.prf = prf;
    }

    public void INT(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public byte[] PBKDF2(net.lingala.zip4j.crypto.PBKDF2.PRF prf, byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int hLen = prf.getHLen();
        int ceil = ceil(i2, hLen);
        int i3 = i2 - ((ceil - 1) * hLen);
        byte[] bArr3 = new byte[ceil * hLen];
        int i4 = 0;
        for (int i5 = 1; i5 <= ceil; i5++) {
            _F(bArr3, i4, prf, bArr2, i, i5);
            i4 += hLen;
        }
        if (i3 >= hLen) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i2];
        java.lang.System.arraycopy(bArr3, 0, bArr4, 0, i2);
        return bArr4;
    }

    public void _F(byte[] bArr, int i, net.lingala.zip4j.crypto.PBKDF2.PRF prf, byte[] bArr2, int i2, int i3) {
        int hLen = prf.getHLen();
        byte[] bArr3 = new byte[hLen];
        byte[] bArr4 = new byte[bArr2.length + 4];
        java.lang.System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        INT(bArr4, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4 = prf.doFinal(bArr4);
            xor(bArr3, bArr4);
        }
        java.lang.System.arraycopy(bArr3, 0, bArr, i, hLen);
    }

    public void assertPRF(byte[] bArr) {
        if (this.prf == null) {
            this.prf = new net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF(this.parameters.getHashAlgorithm());
        }
        this.prf.init(bArr);
    }

    public int ceil(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    public byte[] deriveKey(char[] cArr) {
        return deriveKey(cArr, 0);
    }

    public byte[] deriveKey(char[] cArr, int i) {
        cArr.getClass();
        assertPRF(net.lingala.zip4j.util.Raw.convertCharArrayToByteArray(cArr));
        if (i == 0) {
            i = this.prf.getHLen();
        }
        return PBKDF2(this.prf, this.parameters.getSalt(), this.parameters.getIterationCount(), i);
    }

    public net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters getParameters() {
        return this.parameters;
    }

    public net.lingala.zip4j.crypto.PBKDF2.PRF getPseudoRandomFunction() {
        return this.prf;
    }

    public void setParameters(net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
    }

    public void setPseudoRandomFunction(net.lingala.zip4j.crypto.PBKDF2.PRF prf) {
        this.prf = prf;
    }

    public boolean verifyKey(char[] cArr) {
        byte[] deriveKey;
        byte[] derivedKey = getParameters().getDerivedKey();
        if (derivedKey == null || derivedKey.length == 0 || (deriveKey = deriveKey(cArr, derivedKey.length)) == null || deriveKey.length != derivedKey.length) {
            return false;
        }
        for (int i = 0; i < deriveKey.length; i++) {
            if (deriveKey[i] != derivedKey[i]) {
                return false;
            }
        }
        return true;
    }

    public void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }
}
