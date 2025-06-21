package net.lingala.zip4j.crypto.PBKDF2;

/* loaded from: classes23.dex */
public class MacBasedPRF implements net.lingala.zip4j.crypto.PBKDF2.PRF {
    protected int hLen;
    protected javax.crypto.Mac mac;
    protected java.lang.String macAlgorithm;

    public MacBasedPRF(java.lang.String str) {
        this.macAlgorithm = str;
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            this.mac = mac;
            this.hLen = mac.getMacLength();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public MacBasedPRF(java.lang.String str, java.lang.String str2) {
        this.macAlgorithm = str;
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str, str2);
            this.mac = mac;
            this.hLen = mac.getMacLength();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.security.NoSuchProviderException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public byte[] doFinal() {
        return this.mac.doFinal();
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public byte[] doFinal(byte[] bArr) {
        return this.mac.doFinal(bArr);
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public int getHLen() {
        return this.hLen;
    }

    @Override // net.lingala.zip4j.crypto.PBKDF2.PRF
    public void init(byte[] bArr) {
        try {
            this.mac.init(new javax.crypto.spec.SecretKeySpec(bArr, this.macAlgorithm));
        } catch (java.security.InvalidKeyException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void update(byte[] bArr) {
        try {
            this.mac.update(bArr);
        } catch (java.lang.IllegalStateException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        try {
            this.mac.update(bArr, i, i2);
        } catch (java.lang.IllegalStateException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
