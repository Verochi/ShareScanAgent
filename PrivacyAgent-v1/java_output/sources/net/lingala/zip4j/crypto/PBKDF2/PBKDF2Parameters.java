package net.lingala.zip4j.crypto.PBKDF2;

/* loaded from: classes23.dex */
public class PBKDF2Parameters {
    protected byte[] derivedKey;
    protected java.lang.String hashAlgorithm;
    protected java.lang.String hashCharset;
    protected int iterationCount;
    protected byte[] salt;

    public PBKDF2Parameters() {
        this.hashAlgorithm = null;
        this.hashCharset = "UTF-8";
        this.salt = null;
        this.iterationCount = 1000;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(java.lang.String str, java.lang.String str2, byte[] bArr, int i) {
        this.hashAlgorithm = str;
        this.hashCharset = str2;
        this.salt = bArr;
        this.iterationCount = i;
        this.derivedKey = null;
    }

    public PBKDF2Parameters(java.lang.String str, java.lang.String str2, byte[] bArr, int i, byte[] bArr2) {
        this.hashAlgorithm = str;
        this.hashCharset = str2;
        this.salt = bArr;
        this.iterationCount = i;
        this.derivedKey = bArr2;
    }

    public byte[] getDerivedKey() {
        return this.derivedKey;
    }

    public java.lang.String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public java.lang.String getHashCharset() {
        return this.hashCharset;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void setDerivedKey(byte[] bArr) {
        this.derivedKey = bArr;
    }

    public void setHashAlgorithm(java.lang.String str) {
        this.hashAlgorithm = str;
    }

    public void setHashCharset(java.lang.String str) {
        this.hashCharset = str;
    }

    public void setIterationCount(int i) {
        this.iterationCount = i;
    }

    public void setSalt(byte[] bArr) {
        this.salt = bArr;
    }
}
