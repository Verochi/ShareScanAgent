package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCCheckout extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_BRANCH = "-branch";
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public static final java.lang.String FLAG_NODATA = "-ndata";
    public static final java.lang.String FLAG_NOWARN = "-nwarn";
    public static final java.lang.String FLAG_OUT = "-out";
    public static final java.lang.String FLAG_RESERVED = "-reserved";
    public static final java.lang.String FLAG_UNRESERVED = "-unreserved";
    public static final java.lang.String FLAG_VERSION = "-version";
    public boolean z = true;
    public java.lang.String A = null;
    public boolean B = false;
    public java.lang.String C = null;
    public boolean D = false;
    public boolean E = false;
    public java.lang.String F = null;
    public java.lang.String G = null;
    public boolean H = true;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getReserved()) {
            commandline.createArgument().setValue(FLAG_RESERVED);
        } else {
            commandline.createArgument().setValue(FLAG_UNRESERVED);
        }
        if (getOut() != null) {
            g(commandline);
        } else if (getNoData()) {
            commandline.createArgument().setValue(FLAG_NODATA);
        }
        if (getBranch() != null) {
            d(commandline);
        } else if (getVersion()) {
            commandline.createArgument().setValue("-version");
        }
        if (getNoWarn()) {
            commandline.createArgument().setValue("-nwarn");
        }
        if (getComment() != null) {
            e(commandline);
        } else if (getCommentFile() != null) {
            f(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        commandline.createArgument().setValue(getViewPath());
    }

    public final void d(org.apache.tools.ant.types.Commandline commandline) {
        if (getBranch() != null) {
            commandline.createArgument().setValue(FLAG_BRANCH);
            commandline.createArgument().setValue(getBranch());
        }
    }

    public final void e(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() != null) {
            commandline.createArgument().setValue("-c");
            commandline.createArgument().setValue(getComment());
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
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_CHECKOUT);
        c(commandline);
        if (!getNotco() && h()) {
            getProject().log("Already checked out in this view: " + getViewPathBasename(), 3);
            return;
        }
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final void f(org.apache.tools.ant.types.Commandline commandline) {
        if (getCommentFile() != null) {
            commandline.createArgument().setValue("-cfile");
            commandline.createArgument().setValue(getCommentFile());
        }
    }

    public final void g(org.apache.tools.ant.types.Commandline commandline) {
        if (getOut() != null) {
            commandline.createArgument().setValue(FLAG_OUT);
            commandline.createArgument().setValue(getOut());
        }
    }

    public java.lang.String getBranch() {
        return this.C;
    }

    public java.lang.String getComment() {
        return this.F;
    }

    public java.lang.String getCommentFile() {
        return this.G;
    }

    public boolean getNoData() {
        return this.B;
    }

    public boolean getNoWarn() {
        return this.E;
    }

    public boolean getNotco() {
        return this.H;
    }

    public java.lang.String getOut() {
        return this.A;
    }

    public boolean getReserved() {
        return this.z;
    }

    public boolean getVersion() {
        return this.D;
    }

    public final boolean h() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LSCO);
        commandline.createArgument().setValue("-cview");
        commandline.createArgument().setValue("-short");
        commandline.createArgument().setValue("-d");
        commandline.createArgument().setValue(getViewPath());
        java.lang.String runS = runS(commandline, getFailOnErr());
        return runS != null && runS.length() > 0;
    }

    public void setBranch(java.lang.String str) {
        this.C = str;
    }

    public void setComment(java.lang.String str) {
        this.F = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.G = str;
    }

    public void setNoData(boolean z) {
        this.B = z;
    }

    public void setNoWarn(boolean z) {
        this.E = z;
    }

    public void setNotco(boolean z) {
        this.H = z;
    }

    public void setOut(java.lang.String str) {
        this.A = str;
    }

    public void setReserved(boolean z) {
        this.z = z;
    }

    public void setVersion(boolean z) {
        this.D = z;
    }
}
