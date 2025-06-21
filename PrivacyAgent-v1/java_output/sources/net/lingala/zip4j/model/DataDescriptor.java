package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class DataDescriptor {
    public java.lang.String a;
    public int b;
    public int c;

    public int getCompressedSize() {
        return this.b;
    }

    public java.lang.String getCrc32() {
        return this.a;
    }

    public int getUncompressedSize() {
        return this.c;
    }

    public void setCompressedSize(int i) {
        this.b = i;
    }

    public void setCrc32(java.lang.String str) {
        this.a = str;
    }

    public void setUncompressedSize(int i) {
        this.c = i;
    }
}
