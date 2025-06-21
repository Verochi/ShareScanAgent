package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCLock extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-comment";
    public static final java.lang.String FLAG_NUSERS = "-nusers";
    public static final java.lang.String FLAG_OBSOLETE = "-obsolete";
    public static final java.lang.String FLAG_PNAME = "-pname";
    public static final java.lang.String FLAG_REPLACE = "-replace";
    public boolean z = false;
    public boolean A = false;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public java.lang.String E = null;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getReplace()) {
            commandline.createArgument().setValue("-replace");
        }
        if (getObsolete()) {
            commandline.createArgument().setValue(FLAG_OBSOLETE);
        } else {
            e(commandline);
        }
        d(commandline);
        if (getObjselect() == null && getPname() == null) {
            throw new org.apache.tools.ant.BuildException("Should select either an element (pname) or an object (objselect)");
        }
        g(commandline);
        if (getObjselect() != null) {
            commandline.createArgument().setValue(getObjselect());
        }
    }

    public final void d(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() == null) {
            return;
        }
        commandline.createArgument().setValue("-comment");
        commandline.createArgument().setValue(getComment());
    }

    public final void e(org.apache.tools.ant.types.Commandline commandline) {
        if (getNusers() == null) {
            return;
        }
        commandline.createArgument().setValue(FLAG_NUSERS);
        commandline.createArgument().setValue(getNusers());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.Project project = getProject();
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + f(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final java.lang.String f() {
        return getPname() != null ? getPname() : getObjselect();
    }

    public final void g(org.apache.tools.ant.types.Commandline commandline) {
        if (getPname() == null) {
            return;
        }
        commandline.createArgument().setValue("-pname");
        commandline.createArgument().setValue(getPname());
    }

    public java.lang.String getComment() {
        return this.B;
    }

    public java.lang.String getNusers() {
        return this.C;
    }

    public java.lang.String getObjselect() {
        return this.E;
    }

    public boolean getObsolete() {
        return this.A;
    }

    public java.lang.String getPname() {
        return this.D;
    }

    public boolean getReplace() {
        return this.z;
    }

    public void setComment(java.lang.String str) {
        this.B = str;
    }

    public void setNusers(java.lang.String str) {
        this.C = str;
    }

    public void setObjSel(java.lang.String str) {
        this.E = str;
    }

    public void setObjselect(java.lang.String str) {
        this.E = str;
    }

    public void setObsolete(boolean z) {
        this.A = z;
    }

    public void setPname(java.lang.String str) {
        this.D = str;
    }

    public void setReplace(boolean z) {
        this.z = z;
    }
}
