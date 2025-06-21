package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Java extends org.apache.tools.ant.Task {
    public java.lang.String B;
    public java.io.File C;
    public java.io.File D;
    public java.io.File E;
    public java.lang.String F;
    protected org.apache.tools.ant.types.RedirectorElement redirectorElement;
    public org.apache.tools.ant.types.CommandlineJava u = new org.apache.tools.ant.types.CommandlineJava();
    public org.apache.tools.ant.types.Environment v = new org.apache.tools.ant.types.Environment();
    public boolean w = false;
    public boolean x = false;
    public java.io.File y = null;
    public boolean z = false;
    public java.lang.Long A = null;
    protected org.apache.tools.ant.taskdefs.Redirector redirector = new org.apache.tools.ant.taskdefs.Redirector((org.apache.tools.ant.Task) this);
    public org.apache.tools.ant.types.Permissions G = null;
    public boolean H = false;
    public boolean I = false;

    public Java() {
    }

    public Java(org.apache.tools.ant.Task task) {
        bindToOwner(task);
    }

    public void addAssertions(org.apache.tools.ant.types.Assertions assertions) {
        if (getCommandLine().getAssertions() != null) {
            throw new org.apache.tools.ant.BuildException("Only one assertion declaration is allowed");
        }
        getCommandLine().setAssertions(assertions);
    }

    public void addConfiguredRedirector(org.apache.tools.ant.types.RedirectorElement redirectorElement) {
        if (this.redirectorElement != null) {
            throw new org.apache.tools.ant.BuildException("cannot have > 1 nested redirectors");
        }
        this.redirectorElement = redirectorElement;
        this.I = true;
    }

    public void addEnv(org.apache.tools.ant.types.Environment.Variable variable) {
        this.v.addVariable(variable);
    }

    public void addSysproperty(org.apache.tools.ant.types.Environment.Variable variable) {
        getCommandLine().addSysproperty(variable);
    }

    public void addSyspropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        getCommandLine().addSyspropertyset(propertySet);
    }

    public final int c(java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(this.redirector.createHandler(), createWatchdog());
        i(execute, strArr);
        try {
            int execute2 = execute.execute();
            this.redirector.complete();
            if (execute.killedProcess()) {
                throw new org.apache.tools.ant.BuildException("Timeout: killed the sub-process");
            }
            return execute2;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void checkConfiguration() throws org.apache.tools.ant.BuildException {
        java.lang.String classname = getCommandLine().getClassname();
        java.lang.String module = getCommandLine().getModule();
        if (classname == null && getCommandLine().getJar() == null && module == null) {
            throw new org.apache.tools.ant.BuildException("Classname must not be null.");
        }
        if (!this.w && getCommandLine().getJar() != null) {
            throw new org.apache.tools.ant.BuildException("Cannot execute a jar in non-forked mode. Please set fork='true'. ");
        }
        if (!this.w && getCommandLine().getModule() != null) {
            throw new org.apache.tools.ant.BuildException("Cannot execute a module in non-forked mode. Please set fork='true'. ");
        }
        if (this.H && !this.w) {
            throw new org.apache.tools.ant.BuildException("Cannot spawn a java process in non-forked mode. Please set fork='true'. ");
        }
        if (getCommandLine().getClasspath() != null && getCommandLine().getJar() != null) {
            log("When using 'jar' attribute classpath-settings are ignored. See the manual for more information.", 3);
        }
        if (this.H && this.I) {
            getProject().log("spawn does not allow attributes related to input, output, error, result", 0);
            getProject().log("spawn also does not allow timeout", 0);
            getProject().log("finally, spawn is not compatible with a nested I/O <redirector>", 0);
            throw new org.apache.tools.ant.BuildException("You have used an attribute or nested element which is not compatible with spawn");
        }
        if (getCommandLine().getAssertions() != null && !this.w) {
            log("Assertion statements are currently ignored in non-forked mode");
        }
        if (this.w) {
            if (this.G != null) {
                log("Permissions can not be set this way in forked mode.", 1);
            }
            log(getCommandLine().describeCommand(), 3);
        } else {
            if (getCommandLine().getVmCommand().size() > 1) {
                log("JVM args ignored when same JVM is used.", 1);
            }
            if (this.y != null) {
                log("Working directory ignored when same JVM is used.", 1);
            }
            if (this.x || this.v.getVariables() != null) {
                log("Changes to environment variables are ignored when same JVM is used.", 1);
            }
            if (getCommandLine().getBootclasspath() != null) {
                log("bootclasspath ignored when same JVM is used.", 1);
            }
            if (this.G == null) {
                this.G = new org.apache.tools.ant.types.Permissions(true);
                log("running " + getCommandLine().getClassname() + " with default permissions (exit forbidden)", 3);
            }
            log("Running in same VM " + getCommandLine().describeJavaCommand(), 3);
        }
        setupRedirector();
    }

    public void clearArgs() {
        getCommandLine().clearJavaArgs();
    }

    public org.apache.tools.ant.types.Commandline.Argument createArg() {
        return getCommandLine().createArgument();
    }

    public org.apache.tools.ant.types.Path createBootclasspath() {
        return getCommandLine().createBootclasspath(getProject()).createPath();
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return getCommandLine().createClasspath(getProject()).createPath();
    }

    public org.apache.tools.ant.types.Commandline.Argument createJvmarg() {
        return getCommandLine().createVmArgument();
    }

    public org.apache.tools.ant.types.Path createModulepath() {
        return getCommandLine().createModulepath(getProject()).createPath();
    }

    public org.apache.tools.ant.types.Permissions createPermissions() {
        org.apache.tools.ant.types.Permissions permissions = this.G;
        if (permissions == null) {
            permissions = new org.apache.tools.ant.types.Permissions();
        }
        this.G = permissions;
        return permissions;
    }

    public org.apache.tools.ant.types.Path createUpgrademodulepath() {
        return getCommandLine().createUpgrademodulepath(getProject()).createPath();
    }

    public org.apache.tools.ant.taskdefs.ExecuteWatchdog createWatchdog() throws org.apache.tools.ant.BuildException {
        java.lang.Long l = this.A;
        if (l == null) {
            return null;
        }
        return new org.apache.tools.ant.taskdefs.ExecuteWatchdog(l.longValue());
    }

    public final void d(java.lang.Throwable th) {
        log(org.apache.tools.ant.util.StringUtils.getStackTrace(th), 0);
    }

    public final void e(org.apache.tools.ant.types.CommandlineJava commandlineJava) throws org.apache.tools.ant.BuildException {
        try {
            org.apache.tools.ant.taskdefs.ExecuteJava executeJava = new org.apache.tools.ant.taskdefs.ExecuteJava();
            executeJava.setJavaCommand(commandlineJava.getJavaCommand());
            executeJava.setClasspath(commandlineJava.getClasspath());
            executeJava.setSystemProperties(commandlineJava.getSystemProperties());
            executeJava.setPermissions(this.G);
            executeJava.setTimeout(this.A);
            this.redirector.createStreams();
            executeJava.execute(getProject());
            this.redirector.complete();
            if (executeJava.killedProcess()) {
                throw new org.apache.tools.ant.BuildException("Timeout: killed the sub-process");
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.y;
        org.apache.tools.ant.types.Permissions permissions = this.G;
        try {
            checkConfiguration();
            int executeJava = executeJava();
            if (executeJava != 0) {
                if (this.z) {
                    throw new org.apache.tools.ant.ExitStatusException("Java returned: " + executeJava, executeJava, getLocation());
                }
                log("Java Result: " + executeJava, 0);
            }
            maybeSetResultPropertyValue(executeJava);
        } finally {
            this.y = file;
            this.G = permissions;
        }
    }

    public int executeJava() throws org.apache.tools.ant.BuildException {
        return executeJava(getCommandLine());
    }

    public int executeJava(org.apache.tools.ant.types.CommandlineJava commandlineJava) {
        try {
            if (this.w) {
                if (!this.H) {
                    return c(commandlineJava.getCommandline());
                }
                k(commandlineJava.getCommandline());
                return 0;
            }
            try {
                e(commandlineJava);
                return 0;
            } catch (org.apache.tools.ant.ExitException e) {
                return e.getStatus();
            }
        } catch (java.lang.ThreadDeath e2) {
            throw e2;
        } catch (org.apache.tools.ant.BuildException e3) {
            if (e3.getLocation() == null && getLocation() != null) {
                e3.setLocation(getLocation());
            }
            if (this.z) {
                throw e3;
            }
            if ("Timeout: killed the sub-process".equals(e3.getMessage())) {
                log("Timeout: killed the sub-process");
            } else {
                d(e3);
            }
            return -1;
        } catch (java.lang.Throwable th) {
            if (this.z) {
                throw new org.apache.tools.ant.BuildException(th, getLocation());
            }
            d(th);
            return -1;
        }
    }

    public final void f(org.apache.tools.ant.taskdefs.Execute execute, java.lang.String[] strArr) {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            g(execute, strArr);
        } else {
            execute.setCommandline(strArr);
        }
    }

    public final void g(org.apache.tools.ant.taskdefs.Execute execute, java.lang.String[] strArr) {
        org.apache.tools.ant.taskdefs.ExecuteJava.setupCommandLineForVMS(execute, strArr);
    }

    public org.apache.tools.ant.types.CommandlineJava getCommandLine() {
        return this.u;
    }

    public org.apache.tools.ant.types.CommandlineJava.SysProperties getSysProperties() {
        return getCommandLine().getSystemProperties();
    }

    public final void h(org.apache.tools.ant.taskdefs.Execute execute) {
        java.lang.String[] variables = this.v.getVariables();
        if (variables != null) {
            for (java.lang.String str : variables) {
                log("Setting environment variable: " + str, 3);
            }
        }
        execute.setNewenvironment(this.x);
        execute.setEnvironment(variables);
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorFlush(java.lang.String str) {
        if (this.redirector.getErrorStream() != null) {
            this.redirector.handleErrorFlush(str);
        } else {
            super.handleErrorFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorOutput(java.lang.String str) {
        if (this.redirector.getErrorStream() != null) {
            this.redirector.handleErrorOutput(str);
        } else {
            super.handleErrorOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleFlush(java.lang.String str) {
        if (this.redirector.getOutputStream() != null) {
            this.redirector.handleFlush(str);
        } else {
            super.handleFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.redirector.handleInput(bArr, i, i2);
    }

    @Override // org.apache.tools.ant.Task
    public void handleOutput(java.lang.String str) {
        if (this.redirector.getOutputStream() != null) {
            this.redirector.handleOutput(str);
        } else {
            super.handleOutput(str);
        }
    }

    public final void i(org.apache.tools.ant.taskdefs.Execute execute, java.lang.String[] strArr) {
        execute.setAntRun(getProject());
        j(execute);
        h(execute);
        f(execute, strArr);
    }

    public final void j(org.apache.tools.ant.taskdefs.Execute execute) {
        java.io.File file = this.y;
        if (file == null) {
            this.y = getProject().getBaseDir();
        } else if (!file.exists() || !this.y.isDirectory()) {
            throw new org.apache.tools.ant.BuildException(this.y.getAbsolutePath() + " is not a valid directory", getLocation());
        }
        execute.setWorkingDirectory(this.y);
    }

    public final void k(java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute();
        i(execute, strArr);
        try {
            execute.spawn();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void maybeSetResultPropertyValue(int i) {
        java.lang.String num = java.lang.Integer.toString(i);
        if (this.F != null) {
            getProject().setNewProperty(this.F, num);
        }
    }

    public void run(java.lang.String str, java.util.Vector<java.lang.String> vector) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.CommandlineJava commandlineJava = new org.apache.tools.ant.types.CommandlineJava();
        commandlineJava.setClassname(str);
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            commandlineJava.createArgument().setValue(vector.elementAt(i));
        }
        e(commandlineJava);
    }

    public void setAppend(boolean z) {
        this.redirector.setAppend(z);
        this.I = z | this.I;
    }

    public void setArgs(java.lang.String str) {
        log("The args attribute is deprecated. Please use nested arg elements.", 1);
        getCommandLine().createArgument().setLine(str);
    }

    public void setClassname(java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (getCommandLine().getJar() != null) {
            throw new org.apache.tools.ant.BuildException("Cannot use 'jar' and 'classname' attributes in same command");
        }
        getCommandLine().setClassname(str);
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        createClasspath().append(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setCloneVm(boolean z) {
        getCommandLine().setCloneVm(z);
    }

    public void setDir(java.io.File file) {
        this.y = file;
    }

    public void setError(java.io.File file) {
        this.E = file;
        this.I = true;
    }

    public void setErrorProperty(java.lang.String str) {
        this.redirector.setErrorProperty(str);
        this.I = true;
    }

    public void setFailonerror(boolean z) {
        this.z = z;
        this.I = z | this.I;
    }

    public void setFork(boolean z) {
        this.w = z;
    }

    public void setInput(java.io.File file) {
        if (this.B != null) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.C = file;
        this.I = true;
    }

    public void setInputString(java.lang.String str) {
        if (this.C != null) {
            throw new org.apache.tools.ant.BuildException("The \"input\" and \"inputstring\" attributes cannot both be specified");
        }
        this.B = str;
        this.I = true;
    }

    public void setJVMVersion(java.lang.String str) {
        getCommandLine().setVmversion(str);
    }

    public void setJar(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (getCommandLine().getClassname() != null || getCommandLine().getModule() != null) {
            throw new org.apache.tools.ant.BuildException("Cannot use 'jar' with 'classname' or 'module' attributes in same command.");
        }
        getCommandLine().setJar(file.getAbsolutePath());
    }

    public void setJvm(java.lang.String str) {
        getCommandLine().setVm(str);
    }

    public void setJvmargs(java.lang.String str) {
        log("The jvmargs attribute is deprecated. Please use nested jvmarg elements.", 1);
        getCommandLine().createVmArgument().setLine(str);
    }

    public void setLogError(boolean z) {
        this.redirector.setLogError(z);
        this.I = z | this.I;
    }

    public void setMaxmemory(java.lang.String str) {
        getCommandLine().setMaxmemory(str);
    }

    public void setModule(java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (getCommandLine().getJar() != null) {
            throw new org.apache.tools.ant.BuildException("Cannot use 'jar' and 'module' attributes in same command");
        }
        getCommandLine().setModule(str);
    }

    public void setModulepath(org.apache.tools.ant.types.Path path) {
        createModulepath().append(path);
    }

    public void setModulepathRef(org.apache.tools.ant.types.Reference reference) {
        createModulepath().setRefid(reference);
    }

    public void setNewenvironment(boolean z) {
        this.x = z;
    }

    public void setOutput(java.io.File file) {
        this.D = file;
        this.I = true;
    }

    public void setOutputproperty(java.lang.String str) {
        this.redirector.setOutputProperty(str);
        this.I = true;
    }

    public void setResultProperty(java.lang.String str) {
        this.F = str;
        this.I = true;
    }

    public void setSpawn(boolean z) {
        this.H = z;
    }

    public void setTimeout(java.lang.Long l) {
        this.A = l;
        this.I = (l != null) | this.I;
    }

    public void setupRedirector() {
        this.redirector.setInput(this.C);
        this.redirector.setInputString(this.B);
        this.redirector.setOutput(this.D);
        this.redirector.setError(this.E);
        org.apache.tools.ant.types.RedirectorElement redirectorElement = this.redirectorElement;
        if (redirectorElement != null) {
            redirectorElement.configure(this.redirector);
        }
        if (!this.H && this.C == null && this.B == null) {
            this.redirector.h(new org.apache.tools.ant.util.KeepAliveInputStream(getProject().getDefaultInputStream()));
        }
    }
}
