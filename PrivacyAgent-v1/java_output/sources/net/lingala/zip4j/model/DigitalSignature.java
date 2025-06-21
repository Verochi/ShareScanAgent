package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class DigitalSignature {
    public int a;
    public int b;
    public java.lang.String c;

    public int getHeaderSignature() {
        return this.a;
    }

    public java.lang.String getSignatureData() {
        return this.c;
    }

    public int getSizeOfData() {
        return this.b;
    }

    public void setHeaderSignature(int i) {
        this.a = i;
    }

    public void setSignatureData(java.lang.String str) {
        this.c = str;
    }

    public void setSizeOfData(int i) {
        this.b = i;
    }
}
