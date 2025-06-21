package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class LibFileSet extends org.apache.tools.ant.types.FileSet {
    public boolean D;
    public boolean E;
    public java.lang.String F;

    public boolean c() {
        return this.E;
    }

    public boolean d() {
        return this.D;
    }

    public void setIncludeImpl(boolean z) {
        this.E = z;
    }

    public void setIncludeUrl(boolean z) {
        this.D = z;
    }

    public void setUrlBase(java.lang.String str) {
        this.F = str;
    }
}
