package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class FilesMatch implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final org.apache.tools.ant.util.FileUtils v = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File n;
    public java.io.File t;
    public boolean u = false;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.io.File file;
        java.io.File file2 = this.n;
        if (file2 == null || (file = this.t) == null) {
            throw new org.apache.tools.ant.BuildException("both file1 and file2 are required in filesmatch");
        }
        try {
            return v.contentEquals(file2, file, this.u);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("when comparing files: " + e.getMessage(), e);
        }
    }

    public void setFile1(java.io.File file) {
        this.n = file;
    }

    public void setFile2(java.io.File file) {
        this.t = file;
    }

    public void setTextfile(boolean z) {
        this.u = z;
    }
}
