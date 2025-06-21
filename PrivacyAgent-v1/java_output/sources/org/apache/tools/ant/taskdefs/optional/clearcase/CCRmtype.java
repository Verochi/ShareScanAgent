package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCRmtype extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_FORCE = "-force";
    public static final java.lang.String FLAG_IGNORE = "-ignore";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public static final java.lang.String FLAG_RMALL = "-rmall";
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public boolean E = false;
    public boolean F = false;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getIgnore()) {
            commandline.createArgument().setValue(FLAG_IGNORE);
        }
        if (getRmAll()) {
            commandline.createArgument().setValue(FLAG_RMALL);
            commandline.createArgument().setValue(FLAG_FORCE);
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
        if (getTypeKind() == null) {
            throw new org.apache.tools.ant.BuildException("Required attribute TypeKind not specified");
        }
        if (getTypeName() == null) {
            throw new org.apache.tools.ant.BuildException("Required attribute TypeName not specified");
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_RMTYPE);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + f(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final java.lang.String f() {
        java.lang.String str = getTypeKind() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + getTypeName();
        if (getVOB() == null) {
            return str;
        }
        return str + "@" + getVOB();
    }

    public java.lang.String getComment() {
        return this.C;
    }

    public java.lang.String getCommentFile() {
        return this.D;
    }

    public boolean getIgnore() {
        return this.F;
    }

    public boolean getRmAll() {
        return this.E;
    }

    public java.lang.String getTypeKind() {
        return this.z;
    }

    public java.lang.String getTypeName() {
        return this.A;
    }

    public java.lang.String getVOB() {
        return this.B;
    }

    public void setComment(java.lang.String str) {
        this.C = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.D = str;
    }

    public void setIgnore(boolean z) {
        this.F = z;
    }

    public void setRmAll(boolean z) {
        this.E = z;
    }

    public void setTypeKind(java.lang.String str) {
        this.z = str;
    }

    public void setTypeName(java.lang.String str) {
        this.A = str;
    }

    public void setVOB(java.lang.String str) {
        this.B = str;
    }
}
