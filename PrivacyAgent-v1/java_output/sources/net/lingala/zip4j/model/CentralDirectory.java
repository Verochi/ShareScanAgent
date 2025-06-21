package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class CentralDirectory {
    public java.util.ArrayList a;
    public net.lingala.zip4j.model.DigitalSignature b;

    public net.lingala.zip4j.model.DigitalSignature getDigitalSignature() {
        return this.b;
    }

    public java.util.ArrayList getFileHeaders() {
        return this.a;
    }

    public void setDigitalSignature(net.lingala.zip4j.model.DigitalSignature digitalSignature) {
        this.b = digitalSignature;
    }

    public void setFileHeaders(java.util.ArrayList arrayList) {
        this.a = arrayList;
    }
}
