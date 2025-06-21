package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCMkelem extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_CHECKIN = "-ci";
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_ELTYPE = "-eltype";
    public static final java.lang.String FLAG_MASTER = "-master";
    public static final java.lang.String FLAG_NOCHECKOUT = "-nco";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public static final java.lang.String FLAG_NOWARN = "-nwarn";
    public static final java.lang.String FLAG_PRESERVETIME = "-ptime";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public java.lang.String G = null;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            d(commandline);
        } else if (getCommentFile() != null) {
            e(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        if (getNoWarn()) {
            commandline.createArgument().setValue("-nwarn");
        }
        if (getNoCheckout() && getCheckin()) {
            throw new org.apache.tools.ant.BuildException("Should choose either [nocheckout | checkin]");
        }
        if (getNoCheckout()) {
            commandline.createArgument().setValue("-nco");
        }
        if (getCheckin()) {
            commandline.createArgument().setValue(FLAG_CHECKIN);
            if (getPreserveTime()) {
                commandline.createArgument().setValue("-ptime");
            }
        }
        if (getMaster()) {
            commandline.createArgument().setValue(FLAG_MASTER);
        }
        if (getEltype() != null) {
            f(commandline);
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
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_MKELEM);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final void f(org.apache.tools.ant.types.Commandline commandline) {
        if (getEltype() != null) {
            commandline.createArgument().setValue(FLAG_ELTYPE);
            commandline.createArgument().setValue(getEltype());
        }
    }

    public boolean getCheckin() {
        return this.E;
    }

    public java.lang.String getComment() {
        return this.z;
    }

    public java.lang.String getCommentFile() {
        return this.A;
    }

    public java.lang.String getEltype() {
        return this.G;
    }

    public boolean getMaster() {
        return this.F;
    }

    public boolean getNoCheckout() {
        return this.D;
    }

    public boolean getNoWarn() {
        return this.B;
    }

    public boolean getPreserveTime() {
        return this.C;
    }

    public void setCheckin(boolean z) {
        this.E = z;
    }

    public void setComment(java.lang.String str) {
        this.z = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.A = str;
    }

    public void setEltype(java.lang.String str) {
        this.G = str;
    }

    public void setMaster(boolean z) {
        this.F = z;
    }

    public void setNoCheckout(boolean z) {
        this.D = z;
    }

    public void setNoWarn(boolean z) {
        this.B = z;
    }

    public void setPreserveTime(boolean z) {
        this.C = z;
    }
}
