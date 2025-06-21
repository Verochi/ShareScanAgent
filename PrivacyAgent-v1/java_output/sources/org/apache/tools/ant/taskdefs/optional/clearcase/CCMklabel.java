package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCMklabel extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-c";
    public static final java.lang.String FLAG_COMMENTFILE = "-cfile";
    public static final java.lang.String FLAG_NOCOMMENT = "-nc";
    public static final java.lang.String FLAG_RECURSE = "-recurse";
    public static final java.lang.String FLAG_REPLACE = "-replace";
    public static final java.lang.String FLAG_VERSION = "-version";
    public boolean z = false;
    public boolean A = false;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public java.lang.String E = null;
    public java.lang.String F = null;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getReplace()) {
            commandline.createArgument().setValue("-replace");
        }
        if (getRecurse()) {
            commandline.createArgument().setValue("-recurse");
        }
        if (getVersion() != null) {
            g(commandline);
        }
        if (getComment() != null) {
            d(commandline);
        } else if (getCommentFile() != null) {
            e(commandline);
        } else {
            commandline.createArgument().setValue("-nc");
        }
        if (getTypeName() != null) {
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
        if (getTypeName() == null) {
            throw new org.apache.tools.ant.BuildException("Required attribute TypeName not specified");
        }
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_MKLABEL);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final void f(org.apache.tools.ant.types.Commandline commandline) {
        if (getTypeName() != null) {
            java.lang.String typeName = getTypeName();
            if (getVOB() != null) {
                typeName = typeName + "@" + getVOB();
            }
            commandline.createArgument().setValue(typeName);
        }
    }

    public final void g(org.apache.tools.ant.types.Commandline commandline) {
        if (getVersion() != null) {
            commandline.createArgument().setValue("-version");
            commandline.createArgument().setValue(getVersion());
        }
    }

    public java.lang.String getComment() {
        return this.E;
    }

    public java.lang.String getCommentFile() {
        return this.F;
    }

    public boolean getRecurse() {
        return this.A;
    }

    public boolean getReplace() {
        return this.z;
    }

    public java.lang.String getTypeName() {
        return this.C;
    }

    public java.lang.String getVOB() {
        return this.D;
    }

    public java.lang.String getVersion() {
        return this.B;
    }

    public void setComment(java.lang.String str) {
        this.E = str;
    }

    public void setCommentFile(java.lang.String str) {
        this.F = str;
    }

    public void setRecurse(boolean z) {
        this.A = z;
    }

    public void setReplace(boolean z) {
        this.z = z;
    }

    public void setTypeName(java.lang.String str) {
        this.C = str;
    }

    public void setVOB(java.lang.String str) {
        this.D = str;
    }

    public void setVersion(java.lang.String str) {
        this.B = str;
    }
}
