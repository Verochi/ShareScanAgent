package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class ExtensionAdapter extends org.apache.tools.ant.types.DataType {
    public java.lang.String n;
    public org.apache.tools.ant.util.DeweyDecimal t;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.String w;
    public org.apache.tools.ant.util.DeweyDecimal x;
    public java.lang.String y;

    public org.apache.tools.ant.taskdefs.optional.extension.Extension b() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            return ((org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter) getCheckedRef()).b();
        }
        dieOnCircularReference();
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("Extension is missing name.");
        }
        org.apache.tools.ant.util.DeweyDecimal deweyDecimal = this.t;
        java.lang.String deweyDecimal2 = deweyDecimal != null ? deweyDecimal.toString() : null;
        org.apache.tools.ant.util.DeweyDecimal deweyDecimal3 = this.x;
        return new org.apache.tools.ant.taskdefs.optional.extension.Extension(this.n, deweyDecimal2, this.u, deweyDecimal3 != null ? deweyDecimal3.toString() : null, this.w, this.v, this.y);
    }

    public final void c() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw tooManyAttributes();
        }
    }

    public void setExtensionName(java.lang.String str) {
        c();
        this.n = str;
    }

    public void setImplementationUrl(java.lang.String str) {
        c();
        this.y = str;
    }

    public void setImplementationVendor(java.lang.String str) {
        c();
        this.w = str;
    }

    public void setImplementationVendorId(java.lang.String str) {
        c();
        this.v = str;
    }

    public void setImplementationVersion(java.lang.String str) {
        c();
        this.x = new org.apache.tools.ant.util.DeweyDecimal(str);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.n != null || this.t != null || this.u != null || this.x != null || this.v != null || this.w != null || this.y != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setSpecificationVendor(java.lang.String str) {
        c();
        this.u = str;
    }

    public void setSpecificationVersion(java.lang.String str) {
        c();
        this.t = new org.apache.tools.ant.util.DeweyDecimal(str);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "{" + b().toString() + com.alipay.sdk.m.u.i.d;
    }
}
