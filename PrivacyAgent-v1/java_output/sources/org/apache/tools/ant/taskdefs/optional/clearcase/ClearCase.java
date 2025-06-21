package org.apache.tools.ant.taskdefs.optional.clearcase;

/* loaded from: classes25.dex */
public abstract class ClearCase extends org.apache.tools.ant.Task {
    public static final java.lang.String COMMAND_CHECKIN = "checkin";
    public static final java.lang.String COMMAND_CHECKOUT = "checkout";
    public static final java.lang.String COMMAND_LOCK = "lock";
    public static final java.lang.String COMMAND_LSCO = "lsco";
    public static final java.lang.String COMMAND_MKATTR = "mkattr";
    public static final java.lang.String COMMAND_MKBL = "mkbl";
    public static final java.lang.String COMMAND_MKDIR = "mkdir";
    public static final java.lang.String COMMAND_MKELEM = "mkelem";
    public static final java.lang.String COMMAND_MKLABEL = "mklabel";
    public static final java.lang.String COMMAND_MKLBTYPE = "mklbtype";
    public static final java.lang.String COMMAND_RMTYPE = "rmtype";
    public static final java.lang.String COMMAND_UNCHECKOUT = "uncheckout";
    public static final java.lang.String COMMAND_UNLOCK = "unlock";
    public static final java.lang.String COMMAND_UPDATE = "update";
    public java.lang.String u = "";
    public java.lang.String v = null;
    public java.lang.String w = null;
    public int x = 0;
    public boolean y = true;

    public final java.lang.String getClearToolCommand() {
        java.lang.String str = this.u;
        if (!str.equals("") && !str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return str + "cleartool";
    }

    public boolean getFailOnErr() {
        return this.y;
    }

    public java.lang.String getObjSelect() {
        return this.w;
    }

    public java.lang.String getViewPath() {
        return this.v;
    }

    public java.lang.String getViewPathBasename() {
        return new java.io.File(this.v).getName();
    }

    public int run(org.apache.tools.ant.types.Commandline commandline) {
        try {
            org.apache.tools.ant.Project project = getProject();
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1));
            execute.setAntRun(project);
            execute.setWorkingDirectory(project.getBaseDir());
            execute.setCommandline(commandline.getCommandline());
            return execute.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    @java.lang.Deprecated
    public java.lang.String runS(org.apache.tools.ant.types.Commandline commandline) {
        return runS(commandline, false);
    }

    public java.lang.String runS(org.apache.tools.ant.types.Commandline commandline, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("opts.cc.runS.output");
        int i = this.x;
        this.x = i + 1;
        sb.append(i);
        java.lang.String sb2 = sb.toString();
        org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(this);
        org.apache.tools.ant.types.Commandline.Argument createArg = execTask.createArg();
        execTask.setExecutable(commandline.getExecutable());
        createArg.setLine(org.apache.tools.ant.types.Commandline.toString(commandline.getArguments()));
        execTask.setOutputproperty(sb2);
        execTask.setFailonerror(z);
        execTask.execute();
        return getProject().getProperty(sb2);
    }

    public final void setClearToolDir(java.lang.String str) {
        this.u = org.apache.tools.ant.util.FileUtils.translatePath(str);
    }

    public void setFailOnErr(boolean z) {
        this.y = z;
    }

    public final void setObjSelect(java.lang.String str) {
        this.w = str;
    }

    public final void setViewPath(java.lang.String str) {
        this.v = str;
    }
}
