package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Dirname extends org.apache.tools.ant.Task {
    public java.io.File u;
    public java.lang.String v;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("property attribute required", getLocation());
        }
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("file attribute required", getLocation());
        }
        getProject().setNewProperty(this.v, file.getParent());
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setProperty(java.lang.String str) {
        this.v = str;
    }
}
