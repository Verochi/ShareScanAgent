package org.apache.tools.ant.taskdefs.optional.ccm;

/* loaded from: classes25.dex */
public class CCMReconfigure extends org.apache.tools.ant.taskdefs.optional.ccm.Continuus {
    public static final java.lang.String FLAG_PROJECT = "/project";
    public static final java.lang.String FLAG_RECURSE = "/recurse";
    public static final java.lang.String FLAG_VERBOSE = "/verbose";
    public java.lang.String w = null;
    public boolean x = false;
    public boolean y = false;

    public CCMReconfigure() {
        setCcmAction(org.apache.tools.ant.taskdefs.optional.ccm.Continuus.COMMAND_RECONFIGURE);
    }

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (isRecurse()) {
            commandline.createArgument().setValue(FLAG_RECURSE);
        }
        if (isVerbose()) {
            commandline.createArgument().setValue(FLAG_VERBOSE);
        }
        if (getCcmProject() != null) {
            commandline.createArgument().setValue(FLAG_PROJECT);
            commandline.createArgument().setValue(getCcmProject());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getCcmCommand());
        commandline.createArgument().setValue(getCcmAction());
        c(commandline);
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline))) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public java.lang.String getCcmProject() {
        return this.w;
    }

    public boolean isRecurse() {
        return this.x;
    }

    public boolean isVerbose() {
        return this.y;
    }

    public void setCcmProject(java.lang.String str) {
        this.w = str;
    }

    public void setRecurse(boolean z) {
        this.x = z;
    }

    public void setVerbose(boolean z) {
        this.y = z;
    }
}
