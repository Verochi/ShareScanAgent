package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public abstract class DefaultCompilerAdapter implements org.apache.tools.ant.taskdefs.compilers.CompilerAdapter, org.apache.tools.ant.taskdefs.compilers.CompilerAdapterExtension {
    public static final int a;
    public static final org.apache.tools.ant.util.FileUtils b;
    protected static final java.lang.String lSep;
    protected org.apache.tools.ant.taskdefs.Javac attributes;
    protected org.apache.tools.ant.types.Path bootclasspath;
    protected org.apache.tools.ant.types.Path compileClasspath;
    protected java.io.File[] compileList;
    protected org.apache.tools.ant.types.Path compileSourcepath;
    protected java.io.File destDir;
    protected java.lang.String encoding;
    protected org.apache.tools.ant.types.Path extdirs;
    protected boolean includeAntRuntime;
    protected boolean includeJavaRuntime;
    protected org.apache.tools.ant.Location location;
    protected java.lang.String memoryInitialSize;
    protected java.lang.String memoryMaximumSize;
    protected org.apache.tools.ant.types.Path moduleSourcepath;
    protected org.apache.tools.ant.types.Path modulepath;
    protected org.apache.tools.ant.Project project;
    protected java.lang.String release;
    protected org.apache.tools.ant.types.Path src;
    protected java.lang.String target;
    protected org.apache.tools.ant.types.Path upgrademodulepath;
    protected boolean debug = false;
    protected boolean optimize = false;
    protected boolean deprecation = false;
    protected boolean depend = false;
    protected boolean verbose = false;

    static {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS2)) {
            a = 1000;
        } else {
            a = 4096;
        }
        b = org.apache.tools.ant.util.FileUtils.getFileUtils();
        lSep = org.apache.tools.ant.util.StringUtils.LINE_SEP;
    }

    public final java.lang.String a(java.lang.String str) {
        return (str.equals("1.1") || str.equals("1.2")) ? "1.3" : str;
    }

    public void addCurrentCompilerArgs(org.apache.tools.ant.types.Commandline commandline) {
        commandline.addArguments(getJavac().getCurrentCompilerArgs());
    }

    @java.lang.Deprecated
    public void addExtdirsToClasspath(org.apache.tools.ant.types.Path path) {
        path.addExtdirs(this.extdirs);
    }

    public boolean assumeJava11() {
        return "javac1.1".equals(this.attributes.getCompilerVersion());
    }

    public boolean assumeJava12() {
        return "javac1.2".equals(this.attributes.getCompilerVersion());
    }

    public boolean assumeJava13() {
        return "javac1.3".equals(this.attributes.getCompilerVersion());
    }

    public boolean assumeJava14() {
        return b("javac1.4", "1.4");
    }

    public boolean assumeJava15() {
        return b("javac1.5", org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5);
    }

    public boolean assumeJava16() {
        return b("javac1.6", org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6);
    }

    public boolean assumeJava17() {
        return b("javac1.7", org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7);
    }

    public boolean assumeJava18() {
        return b("javac1.8", org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_8);
    }

    public boolean assumeJava19() {
        return b("javac1.9", "9") || b("javac9", "9");
    }

    public boolean assumeJava9() {
        return assumeJava19();
    }

    public boolean assumeJava9Plus() {
        return "javac1.9".equals(this.attributes.getCompilerVersion()) || "javac9".equals(this.attributes.getCompilerVersion()) || "javac10+".equals(this.attributes.getCompilerVersion()) || (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9") && ("classic".equals(this.attributes.getCompilerVersion()) || "modern".equals(this.attributes.getCompilerVersion()) || "extJavac".equals(this.attributes.getCompilerVersion())));
    }

    public final boolean b(java.lang.String str, java.lang.String str2) {
        return str.equals(this.attributes.getCompilerVersion()) || (org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(str2) && ("classic".equals(this.attributes.getCompilerVersion()) || "modern".equals(this.attributes.getCompilerVersion()) || "extJavac".equals(this.attributes.getCompilerVersion())));
    }

    public final java.lang.String c() {
        return (assumeJava15() || assumeJava16()) ? "1.5 in JDK 1.5 and 1.6" : assumeJava17() ? "1.7 in JDK 1.7" : assumeJava18() ? "1.8 in JDK 1.8" : assumeJava9Plus() ? "9 in JDK 9" : "";
    }

    public final boolean d(java.lang.String str) {
        if (assumeJava14()) {
            return false;
        }
        if (str.startsWith("1.")) {
            str = str.substring(2);
        }
        return str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || !((!str.equals("5") && !str.equals("6")) || assumeJava15() || assumeJava16()) || ((str.equals("7") && !assumeJava17()) || ((str.equals("8") && !assumeJava18()) || (str.equals("9") && !assumeJava9Plus())));
    }

    public final void e(org.apache.tools.ant.types.Commandline commandline, java.lang.String str, java.lang.String str2) {
        this.attributes.log("", 1);
        this.attributes.log("          WARNING", 1);
        this.attributes.log("", 1);
        this.attributes.log("The -source switch defaults to " + c() + ".", 1);
        this.attributes.log("If you specify -target " + str + " you now must also specify -source " + str2 + ".", 1);
        org.apache.tools.ant.taskdefs.Javac javac = this.attributes;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Ant will implicitly add -source ");
        sb.append(str2);
        sb.append(" for you.  Please change your build file.");
        javac.log(sb.toString(), 1);
        commandline.createArgument().setValue("-source");
        commandline.createArgument().setValue(str2);
    }

    public int executeExternalCompile(java.lang.String[] strArr, int i) {
        return executeExternalCompile(strArr, i, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00cf A[Catch: IOException -> 0x00f0, all -> 0x0111, TryCatch #6 {IOException -> 0x00f0, blocks: (B:8:0x00b9, B:10:0x00cf, B:11:0x00d2), top: B:7:0x00b9, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ec  */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int executeExternalCompile(java.lang.String[] strArr, int i, boolean z) {
        java.io.BufferedWriter bufferedWriter;
        java.lang.String[] strArr2;
        java.io.File file = null;
        file = null;
        r1 = null;
        java.io.File file2 = null;
        java.io.BufferedWriter bufferedWriter2 = null;
        try {
            ?? length = org.apache.tools.ant.types.Commandline.toString(strArr).length();
            try {
                if (length > a) {
                    try {
                        if (i >= 0) {
                            try {
                                java.io.File createTempFile = b.createTempFile(getProject(), "files", "", getJavac().getTempdir(), true, true);
                                try {
                                    bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile));
                                    for (int i2 = i; i2 < strArr.length; i2++) {
                                        try {
                                            if (z && strArr[i2].contains(" ")) {
                                                strArr[i2] = strArr[i2].replace(java.io.File.separatorChar, '/');
                                                bufferedWriter.write("\"" + strArr[i2] + "\"");
                                            } else {
                                                bufferedWriter.write(strArr[i2]);
                                            }
                                            bufferedWriter.newLine();
                                        } catch (java.io.IOException e) {
                                            e = e;
                                            file2 = createTempFile;
                                            try {
                                                throw new org.apache.tools.ant.BuildException("Error creating temporary file", e, this.location);
                                            } catch (java.lang.Throwable th) {
                                                th = th;
                                                bufferedWriter2 = bufferedWriter;
                                                org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                                                throw th;
                                            }
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            bufferedWriter2 = bufferedWriter;
                                            org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                                            throw th;
                                        }
                                    }
                                    bufferedWriter.flush();
                                    strArr2 = new java.lang.String[i + 1];
                                    java.lang.System.arraycopy(strArr, 0, strArr2, 0, i);
                                    strArr2[i] = "@" + createTempFile;
                                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                                    file = createTempFile;
                                    org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this.attributes, 2, 1));
                                    if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
                                        execute.setVMLauncher(true);
                                    }
                                    execute.setAntRun(this.project);
                                    execute.setWorkingDirectory(this.project.getBaseDir());
                                    execute.setCommandline(strArr2);
                                    execute.execute();
                                    int exitValue = execute.getExitValue();
                                    if (file != null) {
                                        file.delete();
                                    }
                                    return exitValue;
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                    bufferedWriter = null;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                                    throw th;
                                }
                            } catch (java.io.IOException e3) {
                                e = e3;
                                bufferedWriter = null;
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        file = length;
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                }
                org.apache.tools.ant.taskdefs.Execute execute2 = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this.attributes, 2, 1));
                if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
                }
                execute2.setAntRun(this.project);
                execute2.setWorkingDirectory(this.project.getBaseDir());
                execute2.setCommandline(strArr2);
                execute2.execute();
                int exitValue2 = execute2.getExitValue();
                if (file != null) {
                }
                return exitValue2;
            } catch (java.io.IOException e4) {
                throw new org.apache.tools.ant.BuildException("Error running " + strArr[0] + " compiler", e4, this.location);
            }
            strArr2 = strArr;
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
    }

    public org.apache.tools.ant.types.Path getBootClassPath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.project);
        org.apache.tools.ant.types.Path path2 = this.bootclasspath;
        if (path2 != null) {
            path.append(path2);
        }
        return path.concatSystemBootClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
    }

    public org.apache.tools.ant.types.Path getCompileClasspath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.project);
        if (this.destDir != null && getJavac().isIncludeDestClasses()) {
            path.setLocation(this.destDir);
        }
        org.apache.tools.ant.types.Path path2 = this.compileClasspath;
        if (path2 == null) {
            path2 = new org.apache.tools.ant.types.Path(this.project);
        }
        if (this.includeAntRuntime) {
            path.addExisting(path2.concatSystemClasspath("last"));
        } else {
            path.addExisting(path2.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE));
        }
        if (this.includeJavaRuntime) {
            path.addJavaRuntime();
        }
        return path;
    }

    public org.apache.tools.ant.taskdefs.Javac getJavac() {
        return this.attributes;
    }

    public org.apache.tools.ant.types.Path getModulepath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        org.apache.tools.ant.types.Path path2 = this.modulepath;
        if (path2 != null) {
            path.addExisting(path2);
        }
        return path;
    }

    public org.apache.tools.ant.types.Path getModulesourcepath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        org.apache.tools.ant.types.Path path2 = this.moduleSourcepath;
        if (path2 != null) {
            path.add(path2);
        }
        return path;
    }

    public java.lang.String getNoDebugArgument() {
        if (assumeJava11()) {
            return null;
        }
        return "-g:none";
    }

    public org.apache.tools.ant.Project getProject() {
        return this.project;
    }

    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapterExtension
    public java.lang.String[] getSupportedFileExtensions() {
        return new java.lang.String[]{com.uc.crashsdk.export.LogType.JAVA_TYPE};
    }

    public org.apache.tools.ant.types.Path getUpgrademodulepath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
        org.apache.tools.ant.types.Path path2 = this.upgrademodulepath;
        if (path2 != null) {
            path.addExisting(path2);
        }
        return path;
    }

    public void logAndAddFilesToCompile(org.apache.tools.ant.types.Commandline commandline) {
        this.attributes.log("Compilation " + commandline.describeArguments(), 3);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("File");
        if (this.compileList.length != 1) {
            stringBuffer.append("s");
        }
        stringBuffer.append(" to be compiled:");
        stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        int i = 0;
        while (true) {
            java.io.File[] fileArr = this.compileList;
            if (i >= fileArr.length) {
                this.attributes.log(stringBuffer.toString(), 3);
                return;
            }
            java.lang.String absolutePath = fileArr[i].getAbsolutePath();
            commandline.createArgument().setValue(absolutePath);
            stringBuffer.append("    ");
            stringBuffer.append(absolutePath);
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
            i++;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public void setJavac(org.apache.tools.ant.taskdefs.Javac javac) {
        this.attributes = javac;
        this.src = javac.getSrcdir();
        this.destDir = javac.getDestdir();
        this.encoding = javac.getEncoding();
        this.debug = javac.getDebug();
        this.optimize = javac.getOptimize();
        this.deprecation = javac.getDeprecation();
        this.depend = javac.getDepend();
        this.verbose = javac.getVerbose();
        this.target = javac.getTarget();
        this.release = javac.getRelease();
        this.bootclasspath = javac.getBootclasspath();
        this.extdirs = javac.getExtdirs();
        this.compileList = javac.getFileList();
        this.compileClasspath = javac.getClasspath();
        this.modulepath = javac.getModulepath();
        this.upgrademodulepath = javac.getUpgrademodulepath();
        this.compileSourcepath = javac.getSourcepath();
        this.moduleSourcepath = javac.getModulesourcepath();
        this.project = javac.getProject();
        this.location = javac.getLocation();
        this.includeAntRuntime = javac.getIncludeantruntime();
        this.includeJavaRuntime = javac.getIncludejavaruntime();
        this.memoryInitialSize = javac.getMemoryInitialSize();
        this.memoryMaximumSize = javac.getMemoryMaximumSize();
        if (this.moduleSourcepath != null && this.src == null && this.compileSourcepath == null) {
            this.compileSourcepath = new org.apache.tools.ant.types.Path(getProject());
        }
    }

    public org.apache.tools.ant.types.Commandline setupJavacCommand() {
        return setupJavacCommand(false);
    }

    public org.apache.tools.ant.types.Commandline setupJavacCommand(boolean z) {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        setupJavacCommandlineSwitches(commandline, z);
        logAndAddFilesToCompile(commandline);
        return commandline;
    }

    public org.apache.tools.ant.types.Commandline setupJavacCommandlineSwitches(org.apache.tools.ant.types.Commandline commandline) {
        return setupJavacCommandlineSwitches(commandline, false);
    }

    public org.apache.tools.ant.types.Commandline setupJavacCommandlineSwitches(org.apache.tools.ant.types.Commandline commandline, boolean z) {
        org.apache.tools.ant.types.Path compileClasspath = getCompileClasspath();
        org.apache.tools.ant.types.Path path = this.compileSourcepath;
        if (path == null) {
            path = this.src;
        }
        java.lang.String str = assumeJava11() ? "-J-" : "-J-X";
        if (this.memoryInitialSize != null) {
            if (this.attributes.isForkedJavac()) {
                commandline.createArgument().setValue(str + "ms" + this.memoryInitialSize);
            } else {
                this.attributes.log("Since fork is false, ignoring memoryInitialSize setting.", 1);
            }
        }
        if (this.memoryMaximumSize != null) {
            if (this.attributes.isForkedJavac()) {
                commandline.createArgument().setValue(str + "mx" + this.memoryMaximumSize);
            } else {
                this.attributes.log("Since fork is false, ignoring memoryMaximumSize setting.", 1);
            }
        }
        if (this.attributes.getNowarn()) {
            commandline.createArgument().setValue("-nowarn");
        }
        if (this.deprecation) {
            commandline.createArgument().setValue("-deprecation");
        }
        if (this.destDir != null) {
            commandline.createArgument().setValue("-d");
            commandline.createArgument().setFile(this.destDir);
        }
        commandline.createArgument().setValue("-classpath");
        if (assumeJava11()) {
            org.apache.tools.ant.types.Path path2 = new org.apache.tools.ant.types.Path(this.project);
            org.apache.tools.ant.types.Path bootClassPath = getBootClassPath();
            if (bootClassPath.size() > 0) {
                path2.append(bootClassPath);
            }
            org.apache.tools.ant.types.Path path3 = this.extdirs;
            if (path3 != null) {
                path2.addExtdirs(path3);
            }
            path2.append(compileClasspath);
            path2.append(path);
            commandline.createArgument().setPath(path2);
        } else {
            commandline.createArgument().setPath(compileClasspath);
            if (path.size() > 0) {
                commandline.createArgument().setValue("-sourcepath");
                commandline.createArgument().setPath(path);
            }
            if (this.release == null || !assumeJava9Plus()) {
                if (this.target != null) {
                    commandline.createArgument().setValue("-target");
                    commandline.createArgument().setValue(this.target);
                }
                org.apache.tools.ant.types.Path bootClassPath2 = getBootClassPath();
                if (bootClassPath2.size() > 0) {
                    commandline.createArgument().setValue("-bootclasspath");
                    commandline.createArgument().setPath(bootClassPath2);
                }
            }
            org.apache.tools.ant.types.Path path4 = this.extdirs;
            if (path4 != null && path4.size() > 0) {
                commandline.createArgument().setValue("-extdirs");
                commandline.createArgument().setPath(this.extdirs);
            }
        }
        if (this.encoding != null) {
            commandline.createArgument().setValue("-encoding");
            commandline.createArgument().setValue(this.encoding);
        }
        if (this.debug) {
            if (!z || assumeJava11()) {
                commandline.createArgument().setValue("-g");
            } else {
                java.lang.String debugLevel = this.attributes.getDebugLevel();
                if (debugLevel != null) {
                    commandline.createArgument().setValue("-g:" + debugLevel);
                } else {
                    commandline.createArgument().setValue("-g");
                }
            }
        } else if (getNoDebugArgument() != null) {
            commandline.createArgument().setValue(getNoDebugArgument());
        }
        if (this.optimize) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_OUTPUT);
        }
        if (this.depend) {
            if (assumeJava11()) {
                commandline.createArgument().setValue("-depend");
            } else if (assumeJava12()) {
                commandline.createArgument().setValue("-Xdepend");
            } else {
                this.attributes.log("depend attribute is not supported by the modern compiler", 1);
            }
        }
        if (this.verbose) {
            commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
        }
        addCurrentCompilerArgs(commandline);
        return commandline;
    }

    public org.apache.tools.ant.types.Commandline setupModernJavacCommand() {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        setupModernJavacCommandlineSwitches(commandline);
        logAndAddFilesToCompile(commandline);
        return commandline;
    }

    public org.apache.tools.ant.types.Commandline setupModernJavacCommandlineSwitches(org.apache.tools.ant.types.Commandline commandline) {
        setupJavacCommandlineSwitches(commandline, true);
        if (!assumeJava13()) {
            java.lang.String target = this.attributes.getTarget();
            java.lang.String source = this.attributes.getSource();
            if (this.release == null || !assumeJava9Plus()) {
                if (this.release != null) {
                    this.attributes.log("Support for javac --release has been added in Java9 ignoring it");
                }
                if (source != null) {
                    commandline.createArgument().setValue("-source");
                    commandline.createArgument().setValue(a(source));
                } else if (target != null && d(target)) {
                    e(commandline, target, a(target));
                }
            } else {
                if (target != null || source != null || getBootClassPath().size() > 0) {
                    this.attributes.log("Ignoring source, target and bootclasspath as release has been set", 1);
                }
                commandline.createArgument().setValue("--release");
                commandline.createArgument().setValue(this.release);
            }
        }
        org.apache.tools.ant.types.Path modulesourcepath = getModulesourcepath();
        if (modulesourcepath.size() > 0) {
            commandline.createArgument().setValue("--module-source-path");
            commandline.createArgument().setPath(modulesourcepath);
        }
        org.apache.tools.ant.types.Path modulepath = getModulepath();
        if (modulepath.size() > 0) {
            commandline.createArgument().setValue("--module-path");
            commandline.createArgument().setPath(modulepath);
        }
        org.apache.tools.ant.types.Path upgrademodulepath = getUpgrademodulepath();
        if (upgrademodulepath.size() > 0) {
            commandline.createArgument().setValue("--upgrade-module-path");
            commandline.createArgument().setPath(upgrademodulepath);
        }
        if (this.attributes.getNativeHeaderDir() != null) {
            if (assumeJava13() || assumeJava14() || assumeJava15() || assumeJava16() || assumeJava17()) {
                this.attributes.log("Support for javac -h has been added in Java8, ignoring it");
            } else {
                commandline.createArgument().setValue("-h");
                commandline.createArgument().setFile(this.attributes.getNativeHeaderDir());
            }
        }
        return commandline;
    }
}
