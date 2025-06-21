package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class TempFile extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils A = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.String u;
    public java.lang.String w;
    public boolean y;
    public boolean z;
    public java.io.File v = null;
    public java.lang.String x = "";

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.u;
        if (str == null || str.length() == 0) {
            throw new org.apache.tools.ant.BuildException("no property specified");
        }
        if (this.v == null) {
            this.v = getProject().resolveFile(".");
        }
        getProject().setNewProperty(this.u, A.createTempFile(getProject(), this.w, this.x, this.v, this.y, this.z).toString());
    }

    public boolean isCreateFile() {
        return this.z;
    }

    public boolean isDeleteOnExit() {
        return this.y;
    }

    public void setCreateFile(boolean z) {
        this.z = z;
    }

    public void setDeleteOnExit(boolean z) {
        this.y = z;
    }

    public void setDestDir(java.io.File file) {
        this.v = file;
    }

    public void setPrefix(java.lang.String str) {
        this.w = str;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public void setSuffix(java.lang.String str) {
        this.x = str;
    }
}
