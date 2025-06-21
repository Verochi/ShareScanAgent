package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class ArchiveExtraDataRecord {
    public int a;
    public int b;
    public java.lang.String c;

    public java.lang.String getExtraFieldData() {
        return this.c;
    }

    public int getExtraFieldLength() {
        return this.b;
    }

    public int getSignature() {
        return this.a;
    }

    public void setExtraFieldData(java.lang.String str) {
        this.c = str;
    }

    public void setExtraFieldLength(int i) {
        this.b = i;
    }

    public void setSignature(int i) {
        this.a = i;
    }
}
