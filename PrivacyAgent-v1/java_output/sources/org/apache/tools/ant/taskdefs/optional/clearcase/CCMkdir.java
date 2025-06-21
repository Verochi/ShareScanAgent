package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCMkdir extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_NOCHECKOUT = "-nco";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public boolean B = false;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            d(commandline);
        } else if (getCommentFile() != null) {
            e(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        if (getNoCheckout()) {
            commandline.createArgument().setValue("-nco");
        }
        commandline.createArgument().setValue(getViewPath());
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
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_MKDIR);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public java.lang.String getComment() {
        return this.z;
    }

    public java.lang.String getCommentFile() {
        return this.A;
    }

    public boolean getNoCheckout() {
        return this.B;
    }

    public void setComment(java.lang.String str) {
        this.z = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.A = str;
    }

    public void setNoCheckout(boolean z) {
        this.B = z;
    }
}
