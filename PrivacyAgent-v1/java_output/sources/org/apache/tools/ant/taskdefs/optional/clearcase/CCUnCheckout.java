package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCUnCheckout extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_KEEPCOPY = "-keep";
    public static final java.lang.String FLAG_RM = "-rm";
    public boolean z = false;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getKeepCopy()) {
            commandline.createArgument().setValue("-keep");
        } else {
            commandline.createArgument().setValue(FLAG_RM);
        }
        commandline.createArgument().setValue(getViewPath());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.Project project = getProject();
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_UNCHECKOUT);
        c(commandline);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public boolean getKeepCopy() {
        return this.z;
    }

    public void setKeepCopy(boolean z) {
        this.z = z;
    }
}
