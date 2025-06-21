package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class AbstractJarSignerTask extends org.apache.tools.ant.Task {
    public static final java.lang.String ERROR_NO_SOURCE = "jar must be set through jar attribute or nested filesets";
    protected static final java.lang.String JARSIGNER_COMMAND = "jarsigner";
    public java.lang.String A;
    protected java.lang.String alias;
    protected java.io.File jar;
    protected java.lang.String keypass;
    protected java.lang.String keystore;
    protected java.lang.String maxMemory;
    protected java.lang.String storepass;
    protected java.lang.String storetype;
    public org.apache.tools.ant.types.RedirectorElement u;
    protected boolean verbose;
    public java.lang.String x;
    public java.lang.String y;
    public java.lang.String z;
    protected boolean strict = false;
    protected java.util.Vector<org.apache.tools.ant.types.FileSet> filesets = new java.util.Vector<>();
    public org.apache.tools.ant.types.Environment v = new org.apache.tools.ant.types.Environment();
    public org.apache.tools.ant.types.Path w = null;
    public java.util.List<org.apache.tools.ant.types.Commandline.Argument> B = new java.util.ArrayList();

    public void addArg(org.apache.tools.ant.types.Commandline.Argument argument) {
        this.B.add(argument);
    }

    public void addArgument(org.apache.tools.ant.taskdefs.ExecTask execTask, org.apache.tools.ant.types.Commandline.Argument argument) {
        execTask.createArg().copyFrom(argument);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.filesets.addElement(fileSet);
    }

    public void addSysproperty(org.apache.tools.ant.types.Environment.Variable variable) {
        this.v.addVariable(variable);
    }

    public void addValue(org.apache.tools.ant.taskdefs.ExecTask execTask, java.lang.String str) {
        execTask.createArg().setValue(str);
    }

    public void beginExecution() {
        this.u = c();
    }

    public void bindToKeystore(org.apache.tools.ant.taskdefs.ExecTask execTask) {
        if (this.keystore != null) {
            addValue(execTask, "-keystore");
            java.io.File resolveFile = getProject().resolveFile(this.keystore);
            addValue(execTask, resolveFile.exists() ? resolveFile.getPath() : this.keystore);
        }
        if (this.storetype != null) {
            addValue(execTask, "-storetype");
            addValue(execTask, this.storetype);
        }
        if (this.y != null) {
            addValue(execTask, "-providerName");
            addValue(execTask, this.y);
        }
        if (this.z == null) {
            if (this.A != null) {
                log("Ignoring providerArg as providerClass has not been set");
            }
        } else {
            addValue(execTask, "-providerClass");
            addValue(execTask, this.z);
            if (this.A != null) {
                addValue(execTask, "-providerArg");
                addValue(execTask, this.A);
            }
        }
    }

    public final org.apache.tools.ant.types.RedirectorElement c() {
        org.apache.tools.ant.types.RedirectorElement redirectorElement = new org.apache.tools.ant.types.RedirectorElement();
        java.lang.String str = this.storepass;
        if (str != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
            stringBuffer.append('\n');
            java.lang.String str2 = this.keypass;
            if (str2 != null) {
                stringBuffer.append(str2);
                stringBuffer.append('\n');
            }
            redirectorElement.setInputString(stringBuffer.toString());
            redirectorElement.setLogInputString(false);
            org.apache.tools.ant.filters.LineContainsRegExp lineContainsRegExp = new org.apache.tools.ant.filters.LineContainsRegExp();
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            regularExpression.setPattern("^(Enter Passphrase for keystore: |Enter key password for .+: )$");
            lineContainsRegExp.addConfiguredRegexp(regularExpression);
            lineContainsRegExp.setNegate(true);
            redirectorElement.createErrorFilterChain().addLineContainsRegExp(lineContainsRegExp);
        }
        return redirectorElement;
    }

    public org.apache.tools.ant.taskdefs.ExecTask createJarSigner() {
        org.apache.tools.ant.taskdefs.ExecTask execTask = new org.apache.tools.ant.taskdefs.ExecTask(this);
        java.lang.String str = this.x;
        if (str == null) {
            execTask.setExecutable(org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable(JARSIGNER_COMMAND));
        } else {
            execTask.setExecutable(str);
        }
        execTask.setTaskType(JARSIGNER_COMMAND);
        execTask.setFailonerror(true);
        execTask.addConfiguredRedirector(this.u);
        return execTask;
    }

    public org.apache.tools.ant.types.Path createPath() {
        if (this.w == null) {
            this.w = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.w.createPath();
    }

    public org.apache.tools.ant.types.Path createUnifiedSourcePath() {
        org.apache.tools.ant.types.Path path = this.w;
        org.apache.tools.ant.types.Path path2 = path == null ? new org.apache.tools.ant.types.Path(getProject()) : (org.apache.tools.ant.types.Path) path.clone();
        java.util.Iterator<org.apache.tools.ant.types.FileSet> it = createUnifiedSources().iterator();
        while (it.hasNext()) {
            path2.add(it.next());
        }
        return path2;
    }

    public java.util.Vector<org.apache.tools.ant.types.FileSet> createUnifiedSources() {
        java.util.Vector<org.apache.tools.ant.types.FileSet> vector = (java.util.Vector) this.filesets.clone();
        if (this.jar != null) {
            org.apache.tools.ant.types.FileSet fileSet = new org.apache.tools.ant.types.FileSet();
            fileSet.setProject(getProject());
            fileSet.setFile(this.jar);
            vector.add(fileSet);
        }
        return vector;
    }

    public void declareSysProperty(org.apache.tools.ant.taskdefs.ExecTask execTask, org.apache.tools.ant.types.Environment.Variable variable) throws org.apache.tools.ant.BuildException {
        addValue(execTask, "-J-D" + variable.getContent());
    }

    public void endExecution() {
        this.u = null;
    }

    public org.apache.tools.ant.types.RedirectorElement getRedirector() {
        return this.u;
    }

    public boolean hasResources() {
        return this.w != null || this.filesets.size() > 0;
    }

    public void setAlias(java.lang.String str) {
        this.alias = str;
    }

    public void setCommonOptions(org.apache.tools.ant.taskdefs.ExecTask execTask) {
        if (this.maxMemory != null) {
            addValue(execTask, "-J-Xmx" + this.maxMemory);
        }
        if (this.verbose) {
            addValue(execTask, org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
        }
        if (this.strict) {
            addValue(execTask, "-strict");
        }
        java.util.Iterator<org.apache.tools.ant.types.Environment.Variable> it = this.v.getVariablesVector().iterator();
        while (it.hasNext()) {
            declareSysProperty(execTask, it.next());
        }
        java.util.Iterator<org.apache.tools.ant.types.Commandline.Argument> it2 = this.B.iterator();
        while (it2.hasNext()) {
            addArgument(execTask, it2.next());
        }
    }

    public void setExecutable(java.lang.String str) {
        this.x = str;
    }

    public void setJar(java.io.File file) {
        this.jar = file;
    }

    public void setKeypass(java.lang.String str) {
        this.keypass = str;
    }

    public void setKeystore(java.lang.String str) {
        this.keystore = str;
    }

    public void setMaxmemory(java.lang.String str) {
        this.maxMemory = str;
    }

    public void setProviderArg(java.lang.String str) {
        this.A = str;
    }

    public void setProviderClass(java.lang.String str) {
        this.z = str;
    }

    public void setProviderName(java.lang.String str) {
        this.y = str;
    }

    public void setStorepass(java.lang.String str) {
        this.storepass = str;
    }

    public void setStoretype(java.lang.String str) {
        this.storetype = str;
    }

    public void setStrict(boolean z) {
        this.strict = z;
    }

    public void setVerbose(boolean z) {
        this.verbose = z;
    }
}
