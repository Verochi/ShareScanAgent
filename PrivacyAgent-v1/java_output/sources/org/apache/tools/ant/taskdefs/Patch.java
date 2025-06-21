package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Patch extends org.apache.tools.ant.Task {
    public java.io.File u;
    public java.io.File v;
    public boolean w = false;
    public org.apache.tools.ant.types.Commandline x = new org.apache.tools.ant.types.Commandline();
    public boolean y = false;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (!this.w) {
            throw new org.apache.tools.ant.BuildException("patchfile argument is required", getLocation());
        }
        org.apache.tools.ant.types.Commandline commandline = (org.apache.tools.ant.types.Commandline) this.x.clone();
        commandline.setExecutable("patch");
        if (this.u != null) {
            commandline.createArgument().setFile(this.u);
        }
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1), null);
        execute.setCommandline(commandline.getCommandline());
        java.io.File file = this.v;
        if (file == null) {
            execute.setWorkingDirectory(getProject().getBaseDir());
        } else {
            if (!file.exists() || !this.v.isDirectory()) {
                if (!this.v.isDirectory()) {
                    throw new org.apache.tools.ant.BuildException(this.v + " is not a directory.", getLocation());
                }
                throw new org.apache.tools.ant.BuildException("directory " + this.v + " doesn't exist", getLocation());
            }
            execute.setWorkingDirectory(this.v);
        }
        log(commandline.describeCommand(), 3);
        try {
            int execute2 = execute.execute();
            if (org.apache.tools.ant.taskdefs.Execute.isFailure(execute2)) {
                java.lang.String str = "'patch' failed with exit code " + execute2;
                if (this.y) {
                    throw new org.apache.tools.ant.BuildException(str);
                }
                log(str, 0);
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setBackups(boolean z) {
        if (z) {
            this.x.createArgument().setValue("-b");
        }
    }

    public void setDestfile(java.io.File file) {
        if (file != null) {
            this.x.createArgument().setValue("-o");
            this.x.createArgument().setFile(file);
        }
    }

    public void setDir(java.io.File file) {
        this.v = file;
    }

    public void setFailOnError(boolean z) {
        this.y = z;
    }

    public void setIgnorewhitespace(boolean z) {
        if (z) {
            this.x.createArgument().setValue("-l");
        }
    }

    public void setOriginalfile(java.io.File file) {
        this.u = file;
    }

    public void setPatchfile(java.io.File file) {
        if (file.exists()) {
            this.x.createArgument().setValue("-i");
            this.x.createArgument().setFile(file);
            this.w = true;
        } else {
            throw new org.apache.tools.ant.BuildException("patchfile " + file + " doesn't exist", getLocation());
        }
    }

    public void setQuiet(boolean z) {
        if (z) {
            this.x.createArgument().setValue("-s");
        }
    }

    public void setReverse(boolean z) {
        if (z) {
            this.x.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_RECURSION);
        }
    }

    public void setStrip(int i) throws org.apache.tools.ant.BuildException {
        if (i < 0) {
            throw new org.apache.tools.ant.BuildException("strip has to be >= 0", getLocation());
        }
        this.x.createArgument().setValue("-p" + i);
    }
}
