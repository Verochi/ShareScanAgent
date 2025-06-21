package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class ExtraAttribute {
    public java.lang.String a;
    public java.lang.String b;

    public java.lang.String a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    public void setValue(java.lang.String str) {
        this.b = str;
    }

    public void validate() throws org.apache.tools.ant.BuildException {
        if (this.a == null) {
            throw new org.apache.tools.ant.BuildException("Missing name from parameter.");
        }
        if (this.b != null) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Missing value from parameter " + this.a + ".");
    }
}
