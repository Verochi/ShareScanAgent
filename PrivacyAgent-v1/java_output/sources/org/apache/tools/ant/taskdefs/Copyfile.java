package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Copyfile extends org.apache.tools.ant.Task {
    public java.io.File u;
    public java.io.File v;
    public boolean w = false;
    public boolean x = false;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        log("DEPRECATED - The copyfile task is deprecated.  Use copy instead.");
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The src attribute must be present.", getLocation());
        }
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("src " + this.u.toString() + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX, getLocation());
        }
        java.io.File file2 = this.v;
        if (file2 == null) {
            throw new org.apache.tools.ant.BuildException("The dest attribute must be present.", getLocation());
        }
        if (this.u.equals(file2)) {
            log("Warning: src == dest", 1);
        }
        if (this.x || this.u.lastModified() > this.v.lastModified()) {
            try {
                getProject().copyFile(this.u, this.v, this.w, this.x);
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Error copying file: " + this.u.getAbsolutePath() + " due to " + e.getMessage());
            }
        }
    }

    public void setDest(java.io.File file) {
        this.v = file;
    }

    public void setFiltering(java.lang.String str) {
        this.w = org.apache.tools.ant.Project.toBoolean(str);
    }

    public void setForceoverwrite(boolean z) {
        this.x = z;
    }

    public void setSrc(java.io.File file) {
        this.u = file;
    }
}
