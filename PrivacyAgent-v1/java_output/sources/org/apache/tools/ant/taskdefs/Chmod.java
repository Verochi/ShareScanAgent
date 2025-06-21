package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Chmod extends org.apache.tools.ant.taskdefs.ExecuteOn {
    public org.apache.tools.ant.types.FileSet W = new org.apache.tools.ant.types.FileSet();
    public boolean X = false;
    public boolean Y = false;

    public Chmod() {
        super.setExecutable("chmod");
        super.setParallel(true);
        super.setSkipEmptyFilesets(true);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn, org.apache.tools.ant.taskdefs.ExecTask
    public void checkConfiguration() {
        if (!this.Y) {
            throw new org.apache.tools.ant.BuildException("Required attribute perm not set in chmod", getLocation());
        }
        if (this.X && this.W.getDir(getProject()) != null) {
            addFileset(this.W);
        }
        super.checkConfiguration();
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createExclude() {
        this.X = true;
        return this.W.createExclude();
    }

    public org.apache.tools.ant.types.PatternSet.NameEntry createInclude() {
        this.X = true;
        return this.W.createInclude();
    }

    public org.apache.tools.ant.types.PatternSet createPatternSet() {
        this.X = true;
        return this.W.createPatternSet();
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask, org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        boolean z;
        java.io.File dir;
        if (this.X || this.W.getDir(getProject()) == null) {
            try {
                super.execute();
                if (z) {
                    if (dir != null) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } finally {
                if (this.X && this.W.getDir(getProject()) != null) {
                    this.filesets.removeElement(this.W);
                }
            }
        }
        if (isValidOs()) {
            org.apache.tools.ant.taskdefs.Execute prepareExec = prepareExec();
            org.apache.tools.ant.types.Commandline commandline = (org.apache.tools.ant.types.Commandline) this.cmdl.clone();
            commandline.createArgument().setValue(this.W.getDir(getProject()).getPath());
            try {
                try {
                    prepareExec.setCommandline(commandline.getCommandline());
                    runExecute(prepareExec);
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("Execute failed: " + e, e, getLocation());
                }
            } finally {
                logFlush();
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public boolean isValidOs() {
        return (getOs() == null && getOsFamily() == null) ? org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX) : super.isValidOs();
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setAddsourcefile(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the addsourcefile attribute", getLocation());
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setCommand(org.apache.tools.ant.types.Commandline commandline) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the command attribute", getLocation());
    }

    public void setDefaultexcludes(boolean z) {
        this.X = true;
        this.W.setDefaultexcludes(z);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setDir(java.io.File file) {
        this.W.setDir(file);
    }

    public void setExcludes(java.lang.String str) {
        this.X = true;
        this.W.setExcludes(str);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setExecutable(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the executable attribute", getLocation());
    }

    public void setFile(java.io.File file) {
        org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
        fileSet.setFile(file);
        addFileset(fileSet);
    }

    public void setIncludes(java.lang.String str) {
        this.X = true;
        this.W.setIncludes(str);
    }

    public void setPerm(java.lang.String str) {
        createArg().setValue(str);
        this.Y = true;
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.W.setProject(project);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn
    public void setSkipEmptyFilesets(boolean z) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the skipemptyfileset attribute", getLocation());
    }
}
