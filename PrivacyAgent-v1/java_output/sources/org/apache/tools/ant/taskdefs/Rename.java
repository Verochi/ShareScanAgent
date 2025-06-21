package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class Rename extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils x = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File u;
    public java.io.File v;
    public boolean w = true;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        log("DEPRECATED - The rename task is deprecated.  Use move instead.");
        java.io.File file = this.v;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("dest attribute is required", getLocation());
        }
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("src attribute is required", getLocation());
        }
        if (!this.w && file.exists()) {
            throw new org.apache.tools.ant.BuildException(this.v + " already exists.");
        }
        try {
            x.rename(this.u, this.v);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Unable to rename " + this.u + " to " + this.v, e, getLocation());
        }
    }

    public void setDest(java.io.File file) {
        this.v = file;
    }

    public void setReplace(java.lang.String str) {
        this.w = org.apache.tools.ant.Project.toBoolean(str);
    }

    public void setSrc(java.io.File file) {
        this.u = file;
    }
}
