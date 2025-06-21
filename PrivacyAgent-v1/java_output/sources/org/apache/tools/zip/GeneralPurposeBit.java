package org.apache.tools.zip;

/* loaded from: classes26.dex */
public final class GeneralPurposeBit implements java.lang.Cloneable {
    public static final int UFT8_NAMES_FLAG = 2048;
    public boolean n = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;

    public static org.apache.tools.zip.GeneralPurposeBit parse(byte[] bArr, int i) {
        int value = org.apache.tools.zip.ZipShort.getValue(bArr, i);
        org.apache.tools.zip.GeneralPurposeBit generalPurposeBit = new org.apache.tools.zip.GeneralPurposeBit();
        generalPurposeBit.useDataDescriptor((value & 8) != 0);
        generalPurposeBit.useUTF8ForNames((value & 2048) != 0);
        generalPurposeBit.useStrongEncryption((value & 64) != 0);
        generalPurposeBit.useEncryption((value & 1) != 0);
        return generalPurposeBit;
    }

    public java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException("GeneralPurposeBit is not Cloneable?", e);
        }
    }

    public void encode(byte[] bArr, int i) {
        org.apache.tools.zip.ZipShort.putShort((this.t ? 8 : 0) | (this.n ? 2048 : 0) | (this.u ? 1 : 0) | (this.v ? 64 : 0), bArr, i);
    }

    public byte[] encode() {
        byte[] bArr = new byte[2];
        encode(bArr, 0);
        return bArr;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof org.apache.tools.zip.GeneralPurposeBit)) {
            return false;
        }
        org.apache.tools.zip.GeneralPurposeBit generalPurposeBit = (org.apache.tools.zip.GeneralPurposeBit) obj;
        return generalPurposeBit.u == this.u && generalPurposeBit.v == this.v && generalPurposeBit.n == this.n && generalPurposeBit.t == this.t;
    }

    public int hashCode() {
        return (((((((this.u ? 1 : 0) * 17) + (this.v ? 1 : 0)) * 13) + (this.n ? 1 : 0)) * 7) + (this.t ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean z) {
        this.t = z;
    }

    public void useEncryption(boolean z) {
        this.u = z;
    }

    public void useStrongEncryption(boolean z) {
        this.v = z;
        if (z) {
            useEncryption(true);
        }
    }

    public void useUTF8ForNames(boolean z) {
        this.n = z;
    }

    public boolean usesDataDescriptor() {
        return this.t;
    }

    public boolean usesEncryption() {
        return this.u;
    }

    public boolean usesStrongEncryption() {
        return this.u && this.v;
    }

    public boolean usesUTF8ForNames() {
        return this.n;
    }
}
