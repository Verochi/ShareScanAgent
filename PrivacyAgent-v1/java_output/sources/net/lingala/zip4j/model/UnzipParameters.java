package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class UnzipParameters {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    public boolean isIgnoreAllFileAttributes() {
        return this.e;
    }

    public boolean isIgnoreArchiveFileAttribute() {
        return this.c;
    }

    public boolean isIgnoreDateTimeAttributes() {
        return this.f;
    }

    public boolean isIgnoreHiddenFileAttribute() {
        return this.b;
    }

    public boolean isIgnoreReadOnlyFileAttribute() {
        return this.a;
    }

    public boolean isIgnoreSystemFileAttribute() {
        return this.d;
    }

    public void setIgnoreAllFileAttributes(boolean z) {
        this.e = z;
    }

    public void setIgnoreArchiveFileAttribute(boolean z) {
        this.c = z;
    }

    public void setIgnoreDateTimeAttributes(boolean z) {
        this.f = z;
    }

    public void setIgnoreHiddenFileAttribute(boolean z) {
        this.b = z;
    }

    public void setIgnoreReadOnlyFileAttribute(boolean z) {
        this.a = z;
    }

    public void setIgnoreSystemFileAttribute(boolean z) {
        this.d = z;
    }
}
