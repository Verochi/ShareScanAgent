package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCMklbtype extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_GLOBAL = "-global";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public static final java.lang.String FLAG_ORDINARY = "-ordinary";
    public static final java.lang.String FLAG_PBRANCH = "-pbranch";
    public static final java.lang.String FLAG_REPLACE = "-replace";
    public static final java.lang.String FLAG_SHARED = "-shared";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public boolean D = false;
    public boolean E = false;
    public boolean F = true;
    public boolean G = false;
    public boolean H = false;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getReplace()) {
            commandline.createArgument().setValue("-replace");
        }
        if (getOrdinary()) {
            commandline.createArgument().setValue(FLAG_ORDINARY);
        } else if (getGlobal()) {
            commandline.createArgument().setValue(FLAG_GLOBAL);
        }
        if (getPbranch()) {
            commandline.createArgument().setValue(FLAG_PBRANCH);
        }
        if (getShared()) {
            commandline.createArgument().setValue(FLAG_SHARED);
        }
        if (getComment() != null) {
            d(commandline);
        } else if (getCommentFile() != null) {
            e(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        commandline.createArgument().setValue(f());
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
        if (getTypeName() == null) {
            throw new org.apache.tools.ant.BuildException("Required attribute TypeName not specified");
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_MKLBTYPE);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + f(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final java.lang.String f() {
        java.lang.String typeName = getTypeName();
        if (getVOB() == null) {
            return typeName;
        }
        return typeName + "@" + getVOB();
    }

    public java.lang.String getComment() {
        return this.B;
    }

    public java.lang.String getCommentFile() {
        return this.C;
    }

    public boolean getGlobal() {
        return this.E;
    }

    public boolean getOrdinary() {
        return this.F;
    }

    public boolean getPbranch() {
        return this.G;
    }

    public boolean getReplace() {
        return this.D;
    }

    public boolean getShared() {
        return this.H;
    }

    public java.lang.String getTypeName() {
        return this.z;
    }

    public java.lang.String getVOB() {
        return this.A;
    }

    public void setComment(java.lang.String str) {
        this.B = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.C = str;
    }

    public void setGlobal(boolean z) {
        this.E = z;
    }

    public void setOrdinary(boolean z) {
        this.F = z;
    }

    public void setPbranch(boolean z) {
        this.G = z;
    }

    public void setReplace(boolean z) {
        this.D = z;
    }

    public void setShared(boolean z) {
        this.H = z;
    }

    public void setTypeName(java.lang.String str) {
        this.z = str;
    }

    public void setVOB(java.lang.String str) {
        this.A = str;
    }
}
