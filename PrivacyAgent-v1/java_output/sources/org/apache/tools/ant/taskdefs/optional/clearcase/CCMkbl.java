package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCMkbl extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_FULL = "-full";
    public static final java.lang.String FLAG_IDENTICAL = "-identical";
    public static final java.lang.String FLAG_INCREMENTAL = "-incremental";
    public static final java.lang.String FLAG_NLABEL = "-nlabel";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public boolean C = false;
    public boolean D = true;
    public boolean E = false;
    public boolean F = false;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            d(commandline);
        } else if (getCommentFile() != null) {
            e(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        if (getIdentical()) {
            commandline.createArgument().setValue("-identical");
        }
        if (getFull()) {
            commandline.createArgument().setValue(FLAG_FULL);
        } else {
            commandline.createArgument().setValue(FLAG_INCREMENTAL);
        }
        if (getNlabel()) {
            commandline.createArgument().setValue(FLAG_NLABEL);
        }
        commandline.createArgument().setValue(getBaselineRootName());
    }

    public final void d(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            commandline.createArgument().setValue("-c");
            commandline.createArgument().setValue(getComment());
        }
    }

    public final void e(org.apache.tools.ant.types.Commandline commandline) {
        if (getCommentFile() != null) {
            commandline.createArgument().setValue("-cfile");
            commandline.createArgument().setValue(getCommentFile());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.Project project = getProject();
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_MKBL);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getBaselineRootName(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public java.lang.String getBaselineRootName() {
        return this.B;
    }

    public java.lang.String getComment() {
        return this.z;
    }

    public java.lang.String getCommentFile() {
        return this.A;
    }

    public boolean getFull() {
        return this.E;
    }

    public boolean getIdentical() {
        return this.D;
    }

    public boolean getNlabel() {
        return this.F;
    }

    public boolean getNoWarn() {
        return this.C;
    }

    public void setBaselineRootName(java.lang.String str) {
        this.B = str;
    }

    public void setComment(java.lang.String str) {
        this.z = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.A = str;
    }

    public void setFull(boolean z) {
        this.E = z;
    }

    public void setIdentical(boolean z) {
        this.D = z;
    }

    public void setNlabel(boolean z) {
        this.F = z;
    }

    public void setNoWarn(boolean z) {
        this.C = z;
    }
}
