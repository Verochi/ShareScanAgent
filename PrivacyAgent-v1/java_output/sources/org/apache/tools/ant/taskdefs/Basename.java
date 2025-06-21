package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Basename extends org.apache.tools.ant.Task {
    public java.io.File u;
    public java.lang.String v;
    public java.lang.String w;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("property attribute required", getLocation());
        }
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("file attribute required", getLocation());
        }
        java.lang.String name = file.getName();
        java.lang.String str = this.w;
        if (str != null && name.endsWith(str)) {
            int length = name.length() - this.w.length();
            if (length > 0 && this.w.charAt(0) != '.' && name.charAt(length - 1) == '.') {
                length--;
            }
            name = name.substring(0, length);
        }
        getProject().setNewProperty(this.v, name);
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setProperty(java.lang.String str) {
        this.v = str;
    }

    public void setSuffix(java.lang.String str) {
        this.w = str;
    }
}
