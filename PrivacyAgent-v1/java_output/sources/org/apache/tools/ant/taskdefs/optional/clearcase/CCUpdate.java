package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public class CCUpdate extends org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase {
    public static final java.lang.String FLAG_CURRENTTIME = "-ctime";
    public static final java.lang.String FLAG_GRAPHICAL = "-graphical";
    public static final java.lang.String FLAG_LOG = "-log";
    public static final java.lang.String FLAG_NOVERWRITE = "-noverwrite";
    public static final java.lang.String FLAG_OVERWRITE = "-overwrite";
    public static final java.lang.String FLAG_PRESERVETIME = "-ptime";
    public static final java.lang.String FLAG_RENAME = "-rename";
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public java.lang.String E = null;

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (getGraphical()) {
            commandline.createArgument().setValue(FLAG_GRAPHICAL);
        } else {
            if (getOverwrite()) {
                commandline.createArgument().setValue(FLAG_OVERWRITE);
            } else if (getRename()) {
                commandline.createArgument().setValue(FLAG_RENAME);
            } else {
                commandline.createArgument().setValue(FLAG_NOVERWRITE);
            }
            if (getCurrentTime()) {
                commandline.createArgument().setValue(FLAG_CURRENTTIME);
            } else if (getPreserveTime()) {
                commandline.createArgument().setValue("-ptime");
            }
            d(commandline);
        }
        commandline.createArgument().setValue(getViewPath());
    }

    public final void d(org.apache.tools.ant.types.Commandline commandline) {
        if (getLog() == null) {
            return;
        }
        commandline.createArgument().setValue("-log");
        commandline.createArgument().setValue(getLog());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        org.apache.tools.ant.Project project = getProject();
        if (getViewPath() == null) {
            setViewPath(project.getBaseDir().getPath());
        }
        commandline.setExecutable(getClearToolCommand());
        commandline.createArgument().setValue("update");
        c(commandline);
        getProject().log(commandline.toString(), 4);
        if (!getFailOnErr()) {
            getProject().log("Ignoring any errors that occur for: " + getViewPathBasename(), 3);
        }
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(run(commandline)) && getFailOnErr()) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
        }
    }

    public boolean getCurrentTime() {
        return this.C;
    }

    public boolean getGraphical() {
        return this.z;
    }

    public java.lang.String getLog() {
        return this.E;
    }

    public boolean getOverwrite() {
        return this.A;
    }

    public boolean getPreserveTime() {
        return this.D;
    }

    public boolean getRename() {
        return this.B;
    }

    public void setCurrentTime(boolean z) {
        this.C = z;
    }

    public void setGraphical(boolean z) {
        this.z = z;
    }

    public void setLog(java.lang.String str) {
        this.E = str;
    }

    public void setOverwrite(boolean z) {
        this.A = z;
    }

    public void setPreserveTime(boolean z) {
        this.D = z;
    }

    public void setRename(boolean z) {
        this.B = z;
    }
}
