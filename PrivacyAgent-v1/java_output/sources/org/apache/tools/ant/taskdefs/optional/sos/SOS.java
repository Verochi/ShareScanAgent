package org.apache.tools.ant.taskdefs.optional.sos;

/* loaded from: classes25.dex */
public abstract class SOS extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.optional.sos.SOSCmd {
    protected org.apache.tools.ant.types.Commandline commandLine;
    public java.lang.String u = null;
    public java.lang.String v = null;
    public java.lang.String w = null;
    public java.lang.String x = null;
    public java.lang.String y = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public java.lang.String C = null;
    public java.lang.String D = null;
    public java.lang.String E = null;
    public java.lang.String F = null;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;

    public abstract org.apache.tools.ant.types.Commandline buildCmdLine();

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        buildCmdLine();
        if (run(this.commandLine) != 255) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Failed executing: " + this.commandLine.toString(), getLocation());
    }

    public java.lang.String getComment() {
        return this.E;
    }

    public java.lang.String getFilename() {
        return this.F;
    }

    public java.lang.String getLabel() {
        return this.D;
    }

    public java.lang.String getLocalPath() {
        if (this.B == null) {
            return getProject().getBaseDir().getAbsolutePath();
        }
        java.io.File resolveFile = getProject().resolveFile(this.B);
        if (!resolveFile.exists()) {
            if (!(resolveFile.mkdirs() || resolveFile.isDirectory())) {
                throw new org.apache.tools.ant.BuildException("Directory " + this.B + " creation was not successful for an unknown reason", getLocation());
            }
            getProject().log("Created dir: " + resolveFile.getAbsolutePath());
        }
        return resolveFile.getAbsolutePath();
    }

    public java.lang.String getNoCache() {
        return this.H ? org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_NO_CACHE : "";
    }

    public java.lang.String getNoCompress() {
        return this.G ? org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_NO_COMPRESSION : "";
    }

    public void getOptionalAttributes() {
        this.commandLine.createArgument().setValue(getVerbose());
        this.commandLine.createArgument().setValue(getNoCompress());
        if (getSosHome() == null) {
            this.commandLine.createArgument().setValue(getNoCache());
        } else {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_SOS_HOME);
            this.commandLine.createArgument().setValue(getSosHome());
        }
        if (getLocalPath() != null) {
            this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_WORKING_DIR);
            this.commandLine.createArgument().setValue(getLocalPath());
        }
    }

    public java.lang.String getPassword() {
        java.lang.String str = this.w;
        return str == null ? "" : str;
    }

    public java.lang.String getProjectPath() {
        return this.x;
    }

    public java.lang.String getRecursive() {
        return this.I ? org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_RECURSION : "";
    }

    public void getRequiredAttributes() {
        this.commandLine.setExecutable(getSosCommand());
        if (getSosServerPath() == null) {
            throw new org.apache.tools.ant.BuildException("sosserverpath attribute must be set!", getLocation());
        }
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_SOS_SERVER);
        this.commandLine.createArgument().setValue(getSosServerPath());
        if (getUsername() == null) {
            throw new org.apache.tools.ant.BuildException("username attribute must be set!", getLocation());
        }
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_USERNAME);
        this.commandLine.createArgument().setValue(getUsername());
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_PASSWORD);
        this.commandLine.createArgument().setValue(getPassword());
        if (getVssServerPath() == null) {
            throw new org.apache.tools.ant.BuildException("vssserverpath attribute must be set!", getLocation());
        }
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VSS_SERVER);
        this.commandLine.createArgument().setValue(getVssServerPath());
        if (getProjectPath() == null) {
            throw new org.apache.tools.ant.BuildException("projectpath attribute must be set!", getLocation());
        }
        this.commandLine.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_PROJECT);
        this.commandLine.createArgument().setValue(getProjectPath());
    }

    public java.lang.String getSosCommand() {
        if (this.u == null) {
            return org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_SOS_EXE;
        }
        return this.u + java.io.File.separator + org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.COMMAND_SOS_EXE;
    }

    public java.lang.String getSosHome() {
        return this.A;
    }

    public java.lang.String getSosServerPath() {
        return this.z;
    }

    public java.lang.String getUsername() {
        return this.v;
    }

    public java.lang.String getVerbose() {
        return this.J ? org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE : "";
    }

    public java.lang.String getVersion() {
        return this.C;
    }

    public java.lang.String getVssServerPath() {
        return this.y;
    }

    public int run(org.apache.tools.ant.types.Commandline commandline) {
        try {
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1));
            execute.setAntRun(getProject());
            execute.setWorkingDirectory(getProject().getBaseDir());
            execute.setCommandline(commandline.getCommandline());
            execute.setVMLauncher(false);
            return execute.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setInternalComment(java.lang.String str) {
        this.E = str;
    }

    public void setInternalFilename(java.lang.String str) {
        this.F = str;
    }

    public void setInternalLabel(java.lang.String str) {
        this.D = str;
    }

    public void setInternalRecursive(boolean z) {
        this.I = z;
    }

    public void setInternalVersion(java.lang.String str) {
        this.C = str;
    }

    public final void setLocalPath(org.apache.tools.ant.types.Path path) {
        this.B = path.toString();
    }

    public final void setNoCache(boolean z) {
        this.H = z;
    }

    public final void setNoCompress(boolean z) {
        this.G = z;
    }

    public final void setPassword(java.lang.String str) {
        this.w = str;
    }

    public final void setProjectPath(java.lang.String str) {
        if (str.startsWith("$")) {
            this.x = str;
            return;
        }
        this.x = "$" + str;
    }

    public final void setSosCmd(java.lang.String str) {
        this.u = org.apache.tools.ant.util.FileUtils.translatePath(str);
    }

    public final void setSosHome(java.lang.String str) {
        this.A = str;
    }

    public final void setSosServerPath(java.lang.String str) {
        this.z = str;
    }

    public final void setUsername(java.lang.String str) {
        this.v = str;
    }

    public void setVerbose(boolean z) {
        this.J = z;
    }

    public final void setVssServerPath(java.lang.String str) {
        this.y = str;
    }
}
