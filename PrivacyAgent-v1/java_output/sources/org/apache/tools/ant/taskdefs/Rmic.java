package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Rmic extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final java.lang.String ERROR_BASE_NOT_SET = "base or destdir attribute must be set!";
    public static final java.lang.String ERROR_LOADING_CAUSED_EXCEPTION = ". Loading caused Exception: ";
    public static final java.lang.String ERROR_NOT_A_DIR = "base or destdir is not a directory:";
    public static final java.lang.String ERROR_NOT_DEFINED = ". It is not defined.";
    public static final java.lang.String ERROR_NOT_FOUND = ". It could not be found.";
    public static final java.lang.String ERROR_NO_BASE_EXISTS = "base or destdir does not exist: ";
    public static final java.lang.String ERROR_RMIC_FAILED = "Rmic failed; see the compiler error output for details.";
    public static final java.lang.String ERROR_UNABLE_TO_VERIFY_CLASS = "Unable to verify class ";
    public static final org.apache.tools.ant.util.FileUtils Q = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.types.Path A;
    public java.lang.String E;
    public java.lang.String G;
    public java.io.File u;
    public java.io.File v;
    public java.lang.String w;
    public java.io.File x;
    public java.lang.String y;
    public org.apache.tools.ant.types.Path z;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean F = false;
    public boolean H = false;
    public boolean I = true;
    public boolean J = false;
    public java.util.Vector K = new java.util.Vector();
    public org.apache.tools.ant.AntClassLoader L = null;
    public java.lang.String N = null;
    public boolean O = false;
    public org.apache.tools.ant.taskdefs.rmic.RmicAdapter P = null;
    public org.apache.tools.ant.util.facade.FacadeTaskHelper M = new org.apache.tools.ant.util.facade.FacadeTaskHelper("default");

    public class ImplementationSpecificArgument extends org.apache.tools.ant.util.facade.ImplementationSpecificArgument {
        public ImplementationSpecificArgument() {
        }

        public void setCompiler(java.lang.String str) {
            super.setImplementation(str);
        }
    }

    public void add(org.apache.tools.ant.taskdefs.rmic.RmicAdapter rmicAdapter) {
        if (this.P != null) {
            throw new org.apache.tools.ant.BuildException("Can't have more than one rmic adapter");
        }
        this.P = rmicAdapter;
    }

    public final boolean c(java.lang.Class cls) {
        return getRemoteInterface(cls) != null;
    }

    public void cleanup() {
        org.apache.tools.ant.AntClassLoader antClassLoader = this.L;
        if (antClassLoader != null) {
            antClassLoader.cleanup();
            this.L = null;
        }
    }

    public synchronized org.apache.tools.ant.types.Path createClasspath() {
        if (this.z == null) {
            this.z = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.z.createPath();
    }

    public org.apache.tools.ant.taskdefs.Rmic.ImplementationSpecificArgument createCompilerArg() {
        org.apache.tools.ant.taskdefs.Rmic.ImplementationSpecificArgument implementationSpecificArgument = new org.apache.tools.ant.taskdefs.Rmic.ImplementationSpecificArgument();
        this.M.addImplementationArgument(implementationSpecificArgument);
        return implementationSpecificArgument;
    }

    public org.apache.tools.ant.types.Path createCompilerClasspath() {
        return this.M.getImplementationClasspath(getProject());
    }

    public synchronized org.apache.tools.ant.types.Path createExtdirs() {
        if (this.A == null) {
            this.A = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.A.createPath();
    }

    public final void d(java.io.File file, java.io.File file2, java.lang.String str, org.apache.tools.ant.taskdefs.rmic.RmicAdapter rmicAdapter) throws org.apache.tools.ant.BuildException {
        java.lang.String[] mapFileName = rmicAdapter.getMapper().mapFileName(str.replace('.', java.io.File.separatorChar) + ".class");
        if (mapFileName == null) {
            return;
        }
        for (java.lang.String str2 : mapFileName) {
            if (str2.endsWith(".class")) {
                java.lang.String str3 = org.apache.tools.ant.util.StringUtils.removeSuffix(str2, ".class") + ".java";
                java.io.File file3 = new java.io.File(file, str3);
                if (file3.exists()) {
                    java.io.File file4 = new java.io.File(file2, str3);
                    try {
                        if (this.C) {
                            Q.copyFile(file3, file4, new org.apache.tools.ant.types.FilterSetCollection(getProject().getGlobalFilterSet()));
                        } else {
                            Q.copyFile(file3, file4);
                        }
                        file3.delete();
                    } catch (java.io.IOException e) {
                        throw new org.apache.tools.ant.BuildException("Failed to copy " + file3 + " to " + file4 + " due to " + e.getMessage(), e, getLocation());
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            this.K.clear();
            java.io.File outputDir = getOutputDir();
            if (outputDir == null) {
                throw new org.apache.tools.ant.BuildException(ERROR_BASE_NOT_SET, getLocation());
            }
            if (!outputDir.exists()) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_BASE_EXISTS + outputDir, getLocation());
            }
            if (!outputDir.isDirectory()) {
                throw new org.apache.tools.ant.BuildException(ERROR_NOT_A_DIR + outputDir, getLocation());
            }
            if (this.B) {
                log("Verify has been turned on.", 3);
            }
            org.apache.tools.ant.taskdefs.rmic.RmicAdapter rmicAdapter = this.P;
            if (rmicAdapter == null) {
                rmicAdapter = org.apache.tools.ant.taskdefs.rmic.RmicAdapterFactory.getRmic(getCompiler(), this, createCompilerClasspath());
            }
            rmicAdapter.setRmic(this);
            this.L = getProject().createClassLoader(rmicAdapter.getClasspath());
            if (this.w == null) {
                scanDir(this.u, getDirectoryScanner(this.u).getIncludedFiles(), rmicAdapter.getMapper());
            } else {
                java.lang.String str = this.w.replace('.', java.io.File.separatorChar) + ".class";
                if (new java.io.File(this.u, str).isFile()) {
                    scanDir(this.u, new java.lang.String[]{str}, rmicAdapter.getMapper());
                } else {
                    this.K.add(this.w);
                }
            }
            int size = this.K.size();
            if (size > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("RMI Compiling ");
                sb.append(size);
                sb.append(" class");
                sb.append(size > 1 ? "es" : "");
                sb.append(" to ");
                sb.append(outputDir);
                log(sb.toString(), 2);
                if (this.O) {
                    for (int i = 0; i < size; i++) {
                        log(this.K.get(i).toString());
                    }
                }
                if (!rmicAdapter.execute()) {
                    throw new org.apache.tools.ant.BuildException(ERROR_RMIC_FAILED, getLocation());
                }
            }
            java.io.File file = this.x;
            if (file != null && !outputDir.equals(file) && size > 0) {
                if (this.F) {
                    log("Cannot determine sourcefiles in idl mode, ", 1);
                    log("sourcebase attribute will be ignored.", 1);
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        d(outputDir, this.x, (java.lang.String) this.K.elementAt(i2), rmicAdapter);
                    }
                }
            }
        } finally {
            cleanup();
        }
    }

    public java.io.File getBase() {
        return this.u;
    }

    public java.lang.String getClassname() {
        return this.w;
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.z;
    }

    public java.util.Vector getCompileList() {
        return this.K;
    }

    public java.lang.String getCompiler() {
        this.M.setMagicValue(getProject().getProperty("build.rmic"));
        return this.M.getImplementation();
    }

    public java.lang.String[] getCurrentCompilerArgs() {
        getCompiler();
        return this.M.getArgs();
    }

    public boolean getDebug() {
        return this.H;
    }

    public java.io.File getDestdir() {
        return this.v;
    }

    public java.lang.String getExecutable() {
        return this.N;
    }

    public org.apache.tools.ant.types.Path getExtdirs() {
        return this.A;
    }

    public java.util.Vector getFileList() {
        return this.K;
    }

    public boolean getFiltering() {
        return this.C;
    }

    public boolean getIdl() {
        return this.F;
    }

    public java.lang.String getIdlopts() {
        return this.G;
    }

    public boolean getIiop() {
        return this.D;
    }

    public java.lang.String getIiopopts() {
        return this.E;
    }

    public boolean getIncludeantruntime() {
        return this.I;
    }

    public boolean getIncludejavaruntime() {
        return this.J;
    }

    public java.lang.ClassLoader getLoader() {
        return this.L;
    }

    public java.io.File getOutputDir() {
        return getDestdir() != null ? getDestdir() : getBase();
    }

    public java.lang.Class getRemoteInterface(java.lang.Class cls) {
        java.lang.Class<?>[] interfaces;
        if (!java.rmi.Remote.class.isAssignableFrom(cls) || (interfaces = cls.getInterfaces()) == null) {
            return null;
        }
        for (int i = 0; i < interfaces.length; i++) {
            if (java.rmi.Remote.class.isAssignableFrom(interfaces[i])) {
                return interfaces[i];
            }
        }
        return null;
    }

    public java.io.File getSourceBase() {
        return this.x;
    }

    public java.lang.String getStubVersion() {
        return this.y;
    }

    public boolean getVerify() {
        return this.B;
    }

    public boolean isValidRmiRemote(java.lang.String str) {
        try {
            java.lang.Class<?> loadClass = this.L.loadClass(str);
            if (!loadClass.isInterface() || this.D || this.F) {
                return c(loadClass);
            }
            return false;
        } catch (java.lang.ClassNotFoundException unused) {
            log(ERROR_UNABLE_TO_VERIFY_CLASS + str + ERROR_NOT_FOUND, 1);
            return false;
        } catch (java.lang.NoClassDefFoundError unused2) {
            log(ERROR_UNABLE_TO_VERIFY_CLASS + str + ERROR_NOT_DEFINED, 1);
            return false;
        } catch (java.lang.Throwable th) {
            log(ERROR_UNABLE_TO_VERIFY_CLASS + str + ERROR_LOADING_CAUSED_EXCEPTION + th.getMessage(), 1);
            return false;
        }
    }

    public void scanDir(java.io.File file, java.lang.String[] strArr, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        java.lang.String str;
        if (this.F) {
            log("will leave uptodate test to rmic implementation in idl mode.", 3);
        } else if (this.D && (str = this.E) != null && str.contains("-always")) {
            log("no uptodate test as -always option has been specified", 3);
        } else {
            strArr = new org.apache.tools.ant.util.SourceFileScanner(this).restrict(strArr, file, getOutputDir(), fileNameMapper);
        }
        for (java.lang.String str2 : strArr) {
            java.lang.String replace = str2.replace(java.io.File.separatorChar, '.');
            this.K.addElement(replace.substring(0, replace.lastIndexOf(".class")));
        }
    }

    public void setBase(java.io.File file) {
        this.u = file;
    }

    public void setClassname(java.lang.String str) {
        this.w = str;
    }

    public synchronized void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.z;
        if (path2 == null) {
            this.z = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setCompiler(java.lang.String str) {
        if (str.length() > 0) {
            this.M.setImplementation(str);
        }
    }

    public void setDebug(boolean z) {
        this.H = z;
    }

    public void setDestdir(java.io.File file) {
        this.v = file;
    }

    public void setExecutable(java.lang.String str) {
        this.N = str;
    }

    public synchronized void setExtdirs(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.A;
        if (path2 == null) {
            this.A = path;
        } else {
            path2.append(path);
        }
    }

    public void setFiltering(boolean z) {
        this.C = z;
    }

    public void setIdl(boolean z) {
        this.F = z;
    }

    public void setIdlopts(java.lang.String str) {
        this.G = str;
    }

    public void setIiop(boolean z) {
        this.D = z;
    }

    public void setIiopopts(java.lang.String str) {
        this.E = str;
    }

    public void setIncludeantruntime(boolean z) {
        this.I = z;
    }

    public void setIncludejavaruntime(boolean z) {
        this.J = z;
    }

    public void setListfiles(boolean z) {
        this.O = z;
    }

    public void setSourceBase(java.io.File file) {
        this.x = file;
    }

    public void setStubVersion(java.lang.String str) {
        this.y = str;
    }

    public void setVerify(boolean z) {
        this.B = z;
    }
}
