package org.apache.tools.ant.taskdefs.optional.ccm;

/* loaded from: classes25.dex */
public class CCMCheck extends org.apache.tools.ant.taskdefs.optional.ccm.Continuus {
    public static final java.lang.String FLAG_COMMENT = "/comment";
    public static final java.lang.String FLAG_TASK = "/task";
    public java.io.File w = null;
    public java.lang.String x = null;
    public java.lang.String y = null;
    protected java.util.Vector filesets = new java.util.Vector();

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.filesets.addElement(fileSet);
    }

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            commandline.createArgument().setValue(FLAG_COMMENT);
            commandline.createArgument().setValue(getComment());
        }
        if (getTask() != null) {
            commandline.createArgument().setValue("/task");
            commandline.createArgument().setValue(getTask());
        }
        if (getFile() != null) {
            commandline.createArgument().setValue(this.w.getAbsolutePath());
        }
    }

    public final void d() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getCcmCommand());
        commandline.createArgument().setValue(getCcmAction());
        c(commandline);
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline))) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.w == null && this.filesets.size() == 0) {
            throw new org.apache.tools.ant.BuildException("Specify at least one source - a file or a fileset.");
        }
        java.io.File file = this.w;
        if (file != null && file.exists() && this.w.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("CCMCheck cannot be generated for directories");
        }
        if (this.w != null && this.filesets.size() > 0) {
            throw new org.apache.tools.ant.BuildException("Choose between file and fileset !");
        }
        if (getFile() != null) {
            d();
            return;
        }
        int size = this.filesets.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) this.filesets.elementAt(i);
            for (java.lang.String str : fileSet.getDirectoryScanner(getProject()).getIncludedFiles()) {
                setFile(new java.io.File(fileSet.getDir(getProject()), str));
                d();
            }
        }
    }

    public java.lang.String getComment() {
        return this.x;
    }

    public java.io.File getFile() {
        return this.w;
    }

    public java.lang.String getTask() {
        return this.y;
    }

    public void setComment(java.lang.String str) {
        this.x = str;
    }

    public void setFile(java.io.File file) {
        log("working file " + file, 3);
        this.w = file;
    }

    public void setTask(java.lang.String str) {
        this.y = str;
    }
}
