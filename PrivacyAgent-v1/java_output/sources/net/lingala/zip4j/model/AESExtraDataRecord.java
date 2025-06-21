package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class AESExtraDataRecord {
    public long a = -1;
    public int b = -1;
    public int c = -1;
    public java.lang.String d = null;
    public int e = -1;
    public int f = -1;

    public int getAesStrength() {
        return this.e;
    }

    public int getCompressionMethod() {
        return this.f;
    }

    public int getDataSize() {
        return this.b;
    }

    public long getSignature() {
        return this.a;
    }

    public java.lang.String getVendorID() {
        return this.d;
    }

    public int getVersionNumber() {
        return this.c;
    }

    public void setAesStrength(int i) {
        this.e = i;
    }

    public void setCompressionMethod(int i) {
        this.f = i;
    }

    public void setDataSize(int i) {
        this.b = i;
    }

    public void setSignature(long j) {
        this.a = j;
    }

    public void setVendorID(java.lang.String str) {
        this.d = str;
    }

    public void setVersionNumber(int i) {
        this.c = i;
    }
}
