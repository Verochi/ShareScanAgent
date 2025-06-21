package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class Deltree extends org.apache.tools.ant.Task {
    public java.io.File u;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        log("DEPRECATED - The deltree task is deprecated.  Use delete instead.");
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("dir attribute must be set!", getLocation());
        }
        if (file.exists()) {
            if (!this.u.isDirectory()) {
                if (this.u.delete()) {
                    return;
                }
                throw new org.apache.tools.ant.BuildException("Unable to delete directory " + this.u.getAbsolutePath(), getLocation());
            }
            log("Deleting: " + this.u.getAbsolutePath());
            try {
                removeDir(this.u);
            } catch (java.io.IOException unused) {
                throw new org.apache.tools.ant.BuildException("Unable to delete " + this.u.getAbsolutePath(), getLocation());
            }
        }
    }

    public final void removeDir(java.io.File file) throws java.io.IOException {
        for (java.lang.String str : file.list()) {
            java.io.File file2 = new java.io.File(file, str);
            if (file2.isDirectory()) {
                removeDir(file2);
            } else if (!file2.delete()) {
                throw new org.apache.tools.ant.BuildException("Unable to delete file " + file2.getAbsolutePath());
            }
        }
        if (file.delete()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Unable to delete directory " + file.getAbsolutePath());
    }

    public void setDir(java.io.File file) {
        this.u = file;
    }
}
