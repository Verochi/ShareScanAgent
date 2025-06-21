package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Mkdir extends org.apache.tools.ant.Task {
    public java.io.File u;

    public final boolean c(java.io.File file) {
        if (file.mkdirs()) {
            return true;
        }
        try {
            java.lang.Thread.sleep(10L);
            return file.mkdirs();
        } catch (java.lang.InterruptedException unused) {
            return file.mkdirs();
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("dir attribute is required", getLocation());
        }
        if (file.isFile()) {
            throw new org.apache.tools.ant.BuildException("Unable to create directory as a file already exists with that name: " + this.u.getAbsolutePath());
        }
        if (this.u.exists()) {
            log("Skipping " + this.u.getAbsolutePath() + " because it already exists.", 3);
            return;
        }
        if (c(this.u)) {
            log("Created dir: " + this.u.getAbsolutePath());
            return;
        }
        if (this.u.exists()) {
            log("A different process or task has already created dir " + this.u.getAbsolutePath(), 3);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Directory " + this.u.getAbsolutePath() + " creation was not successful for an unknown reason", getLocation());
    }

    public java.io.File getDir() {
        return this.u;
    }

    public void setDir(java.io.File file) {
        this.u = file;
    }
}
