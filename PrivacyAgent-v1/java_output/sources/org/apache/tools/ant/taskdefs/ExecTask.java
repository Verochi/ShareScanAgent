package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ExecTask extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils L = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.String B;
    public java.lang.String G;
    public java.io.File H;
    public java.io.File I;
    public java.io.File J;
    protected org.apache.tools.ant.types.RedirectorElement redirectorElement;
    public java.lang.String u;
    public java.lang.String v;
    public java.io.File w;
    public java.lang.String z;
    protected boolean failOnError = false;
    protected boolean newEnvironment = false;
    public java.lang.Long x = null;
    public org.apache.tools.ant.types.Environment y = new org.apache.tools.ant.types.Environment();
    protected org.apache.tools.ant.types.Commandline cmdl = new org.apache.tools.ant.types.Commandline();
    public boolean A = true;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    protected org.apache.tools.ant.taskdefs.Redirector redirector = new org.apache.tools.ant.taskdefs.Redirector((org.apache.tools.ant.Task) this);
    public boolean K = true;

    public ExecTask() {
    }

    public ExecTask(org.apache.tools.ant.Task task) {
        bindToOwner(task);
    }

    public void addConfiguredRedirector(org.apache.tools.ant.types.RedirectorElement redirectorElement) {
        if (this.redirectorElement != null) {
            throw new org.apache.tools.ant.BuildException("cannot have > 1 nested <redirector>s");
        }
        this.redirectorElement = redirectorElement;
        this.F = true;
    }

    public void addEnv(org.apache.tools.ant.types.Environment.Variable variable) {
        this.y.addVariable(variable);
    }

    public final java.lang.String c(java.lang.String str) {
        return str.substring(5);
    }

    public void checkConfiguration() throws org.apache.tools.ant.BuildException {
        if (this.cmdl.getExecutable() == null) {
            throw new org.apache.tools.ant.BuildException("no executable specified", getLocation());
        }
        java.io.File file = this.w;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException("The directory " + this.w + " does not exist");
        }
        java.io.File file2 = this.w;
        if (file2 != null && !file2.isDirectory()) {
            throw new org.apache.tools.ant.BuildException(this.w + " is not a directory");
        }
        if (!this.E || !this.F) {
            setupRedirector();
            return;
        }
        getProject().log("spawn does not allow attributes related to input, output, error, result", 0);
        getProject().log("spawn also does not allow timeout", 0);
        getProject().log("finally, spawn is not compatible with a nested I/O <redirector>", 0);
        throw new org.apache.tools.ant.BuildException("You have used an attribute or nested element which is not compatible with spawn");
    }

    public org.apache.tools.ant.types.Commandline.Argument createArg() {
        return this.cmdl.createArgument();
    }

    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler createHandler() throws org.apache.tools.ant.BuildException {
        return this.redirector.createHandler();
    }

    public org.apache.tools.ant.taskdefs.ExecuteWatchdog createWatchdog() throws org.apache.tools.ant.BuildException {
        java.lang.Long l = this.x;
        if (l == null) {
            return null;
        }
        return new org.apache.tools.ant.taskdefs.ExecuteWatchdog(l.longValue());
    }

    public final java.lang.String d(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str = map.get("PATH");
        return str != null ? str : map.get("Path");
    }

    public final boolean e(java.lang.String str) {
        return str.startsWith("PATH=") || str.startsWith("Path=");
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (isValidOs()) {
            java.io.File file = this.w;
            this.cmdl.setExecutable(resolveExecutable(this.B, this.D));
            checkConfiguration();
            try {
                runExec(prepareExec());
            } finally {
                this.w = file;
            }
        }
    }

    public final java.lang.String getOs() {
        return this.u;
    }

    public final java.lang.String getOsFamily() {
        return this.v;
    }

    public boolean getResolveExecutable() {
        return this.C;
    }

    public boolean isValidOs() {
        java.lang.String str = this.v;
        if (str != null && !org.apache.tools.ant.taskdefs.condition.Os.isFamily(str)) {
            return false;
        }
        java.lang.String property = java.lang.System.getProperty("os.name");
        log("Current OS is " + property, 3);
        java.lang.String str2 = this.u;
        if (str2 == null || str2.contains(property)) {
            return true;
        }
        log("This OS, " + property + " was not found in the specified list of valid OSes: " + this.u, 3);
        return false;
    }

    public void logFlush() {
    }

    public void maybeSetResultPropertyValue(int i) {
        if (this.z != null) {
            getProject().setNewProperty(this.z, java.lang.Integer.toString(i));
        }
    }

    public org.apache.tools.ant.taskdefs.Execute prepareExec() throws org.apache.tools.ant.BuildException {
        if (this.w == null) {
            this.w = getProject().getBaseDir();
        }
        org.apache.tools.ant.types.RedirectorElement redirectorElement = this.redirectorElement;
        if (redirectorElement != null) {
            redirectorElement.configure(this.redirector);
        }
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(createHandler(), createWatchdog());
        execute.setAntRun(getProject());
        execute.setWorkingDirectory(this.w);
        execute.setVMLauncher(this.K);
        java.lang.String[] variables = this.y.getVariables();
        if (variables != null) {
            for (java.lang.String str : variables) {
                log("Setting environment variable: " + str, 3);
            }
        }
        execute.setNewenvironment(this.newEnvironment);
        execute.setEnvironment(variables);
        return execute;
    }

    public java.lang.String resolveExecutable(java.lang.String str, boolean z) {
        org.apache.tools.ant.types.Path path;
        java.lang.String d;
        if (!this.C) {
            return str;
        }
        java.io.File resolveFile = getProject().resolveFile(str);
        if (resolveFile.exists()) {
            return resolveFile.getAbsolutePath();
        }
        java.io.File file = this.w;
        if (file != null) {
            java.io.File resolveFile2 = L.resolveFile(file, str);
            if (resolveFile2.exists()) {
                return resolveFile2.getAbsolutePath();
            }
        }
        if (z) {
            java.lang.String[] variables = this.y.getVariables();
            if (variables != null) {
                for (java.lang.String str2 : variables) {
                    if (e(str2)) {
                        path = new org.apache.tools.ant.types.Path(getProject(), c(str2));
                        break;
                    }
                }
            }
            path = null;
            if (path == null && (d = d(org.apache.tools.ant.taskdefs.Execute.getEnvironmentVariables())) != null) {
                path = new org.apache.tools.ant.types.Path(getProject(), d);
            }
            if (path != null) {
                for (java.lang.String str3 : path.list()) {
                    java.io.File resolveFile3 = L.resolveFile(new java.io.File(str3), str);
                    if (resolveFile3.exists()) {
                        return resolveFile3.getAbsolutePath();
                    }
                }
            }
        }
        return str;
    }

    public void runExec(org.apache.tools.ant.taskdefs.Execute execute) throws org.apache.tools.ant.BuildException {
        log(this.cmdl.describeCommand(), 3);
        execute.setCommandline(this.cmdl.getCommandline());
        try {
            try {
                runExecute(execute);
            } catch (java.io.IOException e) {
                if (this.A) {
                    throw new org.apache.tools.ant.BuildException("Execute failed: " + e.toString(), e, getLocation());
                }
                log("Execute failed: " + e.toString(), 0);
            }
        } finally {
            logFlush();
        }
    }

    public final void runExecute(org.apache.tools.ant.taskdefs.Execute execute) throws java.io.IOException {
        if (this.E) {
            execute.spawn();
            return;
        }
        int execute2 = execute.execute();
        if (execute.killedProcess()) {
            if (this.failOnError) {
                throw new org.apache.tools.ant.BuildException("Timeout: killed the sub-process");
            }
            log("Timeout: killed the sub-process", 1);
        }
        maybeSetResultPropertyValue(execute2);
        this.redirector.complete();
        if (org.apache.tools.ant.taskdefs.Execute.isFailure(execute2)) {
            if (this.failOnError) {
                throw new org.apache.tools.ant.BuildException(getTaskType() + " returned: " + execute2, getLocation());
            }
            log("Result: " + execute2, 0);
        }
    }

    public void setAppend(boolean z) {
        this.redirector.setAppend(z);
        this.F = z | this.F;
    }

    public void setCommand(org.apache.tools.ant.types.Commandline commandline) {
        log("The command attribute is deprecated.\nPlease use the executable attribute and nested arg elements.", 1);
        this.cmdl = commandline;
    }

    public void setDir(java.io.File file) {
        this.w = file;
    }

    public void setError(java.io.File file) {
        this.J = file;
        this.F = true;
    }

    public void setErrorProperty(java.lang.String str) {
        this.redirector.setErrorProperty(str);
        this.F = true;
    }

    public void setExecutable(java.lang.String str) {
        this.B = str;
        this.cmdl.setExecutable(str);
    }

    public void setFailIfExecutionFails(boolean z) {
        this.A = z;
        this.F = z | this.F;
    }

    public void setFailonerror(boolean z) {
        this.failOnError = z;
        this.F = z | this.F;
    }

    public void setInput(java.io.File file) {
        if (this.G != null) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.H = file;
        this.F = true;
    }

    public void setInputString(java.lang.String str) {
        if (this.H != null) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.G = str;
        this.F = true;
    }

    public void setLogError(boolean z) {
        this.redirector.setLogError(z);
        this.F = z | this.F;
    }

    public void setNewenvironment(boolean z) {
        this.newEnvironment = z;
    }

    public void setOs(java.lang.String str) {
        this.u = str;
    }

    public void setOsFamily(java.lang.String str) {
        this.v = str.toLowerCase(java.util.Locale.ENGLISH);
    }

    public void setOutput(java.io.File file) {
        this.I = file;
        this.F = true;
    }

    public void setOutputproperty(java.lang.String str) {
        this.redirector.setOutputProperty(str);
        this.F = true;
    }

    public void setResolveExecutable(boolean z) {
        this.C = z;
    }

    public void setResultProperty(java.lang.String str) {
        this.z = str;
        this.F = true;
    }

    public void setSearchPath(boolean z) {
        this.D = z;
    }

    public void setSpawn(boolean z) {
        this.E = z;
    }

    public void setTimeout(java.lang.Integer num) {
        setTimeout(num == null ? null : new java.lang.Long(num.intValue()));
    }

    public void setTimeout(java.lang.Long l) {
        this.x = l;
        this.F = (l != null) | this.F;
    }

    public void setVMLauncher(boolean z) {
        this.K = z;
    }

    public void setupRedirector() {
        this.redirector.setInput(this.H);
        this.redirector.setInputString(this.G);
        this.redirector.setOutput(this.I);
        this.redirector.setError(this.J);
    }
}
