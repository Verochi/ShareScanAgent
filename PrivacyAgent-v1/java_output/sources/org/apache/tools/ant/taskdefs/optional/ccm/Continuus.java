package org.apache.tools.ant.taskdefs.optional.ccm;

/* loaded from: classes25.dex */
public abstract class Continuus extends org.apache.tools.ant.Task {
    public static final java.lang.String COMMAND_CHECKIN = "ci";
    public static final java.lang.String COMMAND_CHECKOUT = "co";
    public static final java.lang.String COMMAND_CREATE_TASK = "create_task";
    public static final java.lang.String COMMAND_DEFAULT_TASK = "default_task";
    public static final java.lang.String COMMAND_RECONFIGURE = "reconfigure";
    public java.lang.String u = "";
    public java.lang.String v = "";

    public java.lang.String getCcmAction() {
        return this.v;
    }

    public final java.lang.String getCcmCommand() {
        java.lang.String str = this.u;
        if (!str.equals("") && !str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return str + "ccm";
    }

    public int run(org.apache.tools.ant.types.Commandline commandline) {
        return run(commandline, new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 3, 1));
    }

    public int run(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        try {
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(executeStreamHandler);
            execute.setAntRun(getProject());
            execute.setWorkingDirectory(getProject().getBaseDir());
            execute.setCommandline(commandline.getCommandline());
            return execute.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setCcmAction(java.lang.String str) {
        this.v = str;
    }

    public final void setCcmDir(java.lang.String str) {
        this.u = org.apache.tools.ant.util.FileUtils.translatePath(str);
    }
}
