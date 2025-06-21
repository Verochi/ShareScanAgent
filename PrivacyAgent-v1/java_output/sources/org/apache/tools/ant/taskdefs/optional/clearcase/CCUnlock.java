package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCUnlock extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_COMMENT = "-comment";
    public static final java.lang.String FLAG_PNAME = "-pname";
    public java.lang.String z = null;
    public java.lang.String A = null;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        d(commandline);
        if (getObjSelect() == null && getPname() == null) {
            throw new org.apache.tools.ant.BuildException("Should select either an element (pname) or an object (objselect)");
        }
        f(commandline);
        if (getObjSelect() != null) {
            commandline.createArgument().setValue(getObjSelect());
        }
    }

    public final void d(org.apache.tools.ant.types.Commandline commandline) {
        if (getComment() == null) {
            return;
        }
        commandline.createArgument().setValue("-comment");
        commandline.createArgument().setValue(getComment());
    }

    public final java.lang.String e() {
        return getPname() != null ? getPname() : getObjSelect();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.Project project = getProject();
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_UNLOCK);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + e(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public final void f(org.apache.tools.ant.types.Commandline commandline) {
        if (getPname() == null) {
            return;
        }
        commandline.createArgument().setValue("-pname");
        commandline.createArgument().setValue(getPname());
    }

    public java.lang.String getComment() {
        return this.z;
    }

    public java.lang.String getObjselect() {
        return getObjSelect();
    }

    public java.lang.String getPname() {
        return this.A;
    }

    public void setComment(java.lang.String str) {
        this.z = str;
    }

    public void setObjSel(java.lang.String str) {
        setObjSelect(str);
    }

    public void setObjselect(java.lang.String str) {
        setObjSelect(str);
    }

    public void setPname(java.lang.String str) {
        this.A = str;
    }
}
