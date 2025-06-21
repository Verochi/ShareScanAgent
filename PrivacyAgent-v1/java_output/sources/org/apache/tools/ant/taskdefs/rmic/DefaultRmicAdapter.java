package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public abstract class DefaultRmicAdapter implements org.apache.tools.ant.taskdefs.rmic.RmicAdapter {
    public static final java.lang.String RMI_SKEL_SUFFIX = "_Skel";
    public static final java.lang.String RMI_STUB_SUFFIX = "_Stub";
    public static final java.lang.String RMI_TIE_SUFFIX = "_Tie";
    public static final java.lang.String STUB_1_1 = "-v1.1";
    public static final java.lang.String STUB_1_2 = "-v1.2";
    public static final java.lang.String STUB_COMPAT = "-vcompat";
    public static final java.lang.String STUB_OPTION_1_1 = "1.1";
    public static final java.lang.String STUB_OPTION_1_2 = "1.2";
    public static final java.lang.String STUB_OPTION_COMPAT = "compat";
    public static final java.util.Random c = new java.util.Random();
    public org.apache.tools.ant.taskdefs.Rmic a;
    public org.apache.tools.ant.util.FileNameMapper b;

    public class RmicFileNameMapper implements org.apache.tools.ant.util.FileNameMapper {
        public RmicFileNameMapper() {
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public java.lang.String[] mapFileName(java.lang.String str) {
            int i;
            java.lang.String substring;
            int i2;
            if (str != null && str.endsWith(".class")) {
                if (!str.endsWith(org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getStubClassSuffix() + ".class")) {
                    if (!str.endsWith(org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getSkelClassSuffix() + ".class")) {
                        if (!str.endsWith(org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getTieClassSuffix() + ".class")) {
                            java.lang.String removeSuffix = org.apache.tools.ant.util.StringUtils.removeSuffix(str, ".class");
                            java.lang.String replace = removeSuffix.replace(java.io.File.separatorChar, '.');
                            if (org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getVerify() && !org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.isValidRmiRemote(replace)) {
                                return null;
                            }
                            java.lang.String[] strArr = {str + ".tmp." + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.c.nextLong()};
                            if (!org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getIiop() && !org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getIdl()) {
                                if ("1.2".equals(org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getStubVersion())) {
                                    return new java.lang.String[]{removeSuffix + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getStubClassSuffix() + ".class"};
                                }
                                return new java.lang.String[]{removeSuffix + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getStubClassSuffix() + ".class", removeSuffix + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getSkelClassSuffix() + ".class"};
                            }
                            if (org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getIdl()) {
                                return strArr;
                            }
                            int lastIndexOf = removeSuffix.lastIndexOf(java.io.File.separatorChar);
                            java.lang.String str2 = "";
                            if (lastIndexOf == -1) {
                                substring = "";
                                i = 0;
                            } else {
                                i = lastIndexOf + 1;
                                substring = removeSuffix.substring(0, i);
                            }
                            java.lang.String substring2 = removeSuffix.substring(i);
                            try {
                                java.lang.Class<?> loadClass = org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getLoader().loadClass(replace);
                                if (loadClass.isInterface()) {
                                    return new java.lang.String[]{substring + "_" + substring2 + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getStubClassSuffix() + ".class"};
                                }
                                java.lang.String name = org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.getRemoteInterface(loadClass).getName();
                                int lastIndexOf2 = name.lastIndexOf(".");
                                if (lastIndexOf2 == -1) {
                                    i2 = 0;
                                } else {
                                    i2 = lastIndexOf2 + 1;
                                    str2 = name.substring(0, i2).replace('.', java.io.File.separatorChar);
                                }
                                return new java.lang.String[]{substring + "_" + substring2 + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getTieClassSuffix() + ".class", str2 + "_" + name.substring(i2) + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.getStubClassSuffix() + ".class"};
                            } catch (java.lang.ClassNotFoundException unused) {
                                org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.log(org.apache.tools.ant.taskdefs.Rmic.ERROR_UNABLE_TO_VERIFY_CLASS + replace + org.apache.tools.ant.taskdefs.Rmic.ERROR_NOT_FOUND, 1);
                                return strArr;
                            } catch (java.lang.NoClassDefFoundError unused2) {
                                org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.log(org.apache.tools.ant.taskdefs.Rmic.ERROR_UNABLE_TO_VERIFY_CLASS + replace + org.apache.tools.ant.taskdefs.Rmic.ERROR_NOT_DEFINED, 1);
                                return strArr;
                            } catch (java.lang.Throwable th) {
                                org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.this.a.log(org.apache.tools.ant.taskdefs.Rmic.ERROR_UNABLE_TO_VERIFY_CLASS + replace + org.apache.tools.ant.taskdefs.Rmic.ERROR_LOADING_CAUSED_EXCEPTION + th.getMessage(), 1);
                                return strArr;
                            }
                        }
                    }
                }
            }
            return null;
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setFrom(java.lang.String str) {
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setTo(java.lang.String str) {
        }
    }

    public java.lang.String addStubVersionOptions() {
        java.lang.String str;
        java.lang.String stubVersion = this.a.getStubVersion();
        if (stubVersion != null) {
            if ("1.1".equals(stubVersion)) {
                str = STUB_1_1;
            } else if ("1.2".equals(stubVersion)) {
                str = STUB_1_2;
            } else if (STUB_OPTION_COMPAT.equals(stubVersion)) {
                str = STUB_COMPAT;
            } else {
                this.a.log("Unknown stub option " + stubVersion);
            }
            return (str == null || this.a.getIiop() || this.a.getIdl()) ? str : STUB_COMPAT;
        }
        str = null;
        if (str == null) {
        }
    }

    public boolean areIiopAndIdlSupported() {
        return !org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
    }

    public final void c(org.apache.tools.ant.types.Commandline commandline) {
        if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9")) {
            for (java.lang.String str : commandline.getArguments()) {
                if ("-Xnew".equals(str)) {
                    throw new org.apache.tools.ant.BuildException("JDK9 has removed support for -Xnew");
                }
            }
        }
    }

    public java.lang.String[] filterJvmCompilerArgs(java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            if (str.startsWith("-J")) {
                this.a.log("Dropping " + str + " from compiler arguments");
            } else {
                arrayList.add(str);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public org.apache.tools.ant.types.Path getClasspath() {
        return getCompileClasspath();
    }

    public org.apache.tools.ant.types.Path getCompileClasspath() {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(this.a.getProject());
        path.setLocation(this.a.getBase());
        org.apache.tools.ant.types.Path classpath = this.a.getClasspath();
        if (classpath == null) {
            classpath = new org.apache.tools.ant.types.Path(this.a.getProject());
        }
        if (this.a.getIncludeantruntime()) {
            path.addExisting(classpath.concatSystemClasspath("last"));
        } else {
            path.addExisting(classpath.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE));
        }
        if (this.a.getIncludejavaruntime()) {
            path.addJavaRuntime();
        }
        return path;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public org.apache.tools.ant.util.FileNameMapper getMapper() {
        return this.b;
    }

    public org.apache.tools.ant.taskdefs.Rmic getRmic() {
        return this.a;
    }

    public java.lang.String getSkelClassSuffix() {
        return RMI_SKEL_SUFFIX;
    }

    public java.lang.String getStubClassSuffix() {
        return RMI_STUB_SUFFIX;
    }

    public java.lang.String getTieClassSuffix() {
        return RMI_TIE_SUFFIX;
    }

    public void logAndAddFilesToCompile(org.apache.tools.ant.types.Commandline commandline) {
        java.util.Vector compileList = this.a.getCompileList();
        this.a.log("Compilation " + commandline.describeArguments(), 3);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("File");
        int size = compileList.size();
        if (size != 1) {
            stringBuffer.append("s");
        }
        stringBuffer.append(" to be compiled:");
        for (int i = 0; i < size; i++) {
            java.lang.String str = (java.lang.String) compileList.elementAt(i);
            commandline.createArgument().setValue(str);
            stringBuffer.append("    ");
            stringBuffer.append(str);
        }
        this.a.log(stringBuffer.toString(), 3);
    }

    public java.lang.String[] preprocessCompilerArgs(java.lang.String[] strArr) {
        return strArr;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public void setRmic(org.apache.tools.ant.taskdefs.Rmic rmic) {
        this.a = rmic;
        this.b = new org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RmicFileNameMapper();
    }

    public org.apache.tools.ant.types.Commandline setupRmicCommand() {
        return setupRmicCommand(null);
    }

    public org.apache.tools.ant.types.Commandline setupRmicCommand(java.lang.String[] strArr) {
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                commandline.createArgument().setValue(str);
            }
        }
        org.apache.tools.ant.types.Path compileClasspath = getCompileClasspath();
        commandline.createArgument().setValue("-d");
        commandline.createArgument().setFile(this.a.getOutputDir());
        if (this.a.getExtdirs() != null) {
            commandline.createArgument().setValue("-extdirs");
            commandline.createArgument().setPath(this.a.getExtdirs());
        }
        commandline.createArgument().setValue("-classpath");
        commandline.createArgument().setPath(compileClasspath);
        java.lang.String addStubVersionOptions = addStubVersionOptions();
        if (addStubVersionOptions != null) {
            commandline.createArgument().setValue(addStubVersionOptions);
        }
        if (this.a.getSourceBase() != null) {
            commandline.createArgument().setValue("-keepgenerated");
        }
        if (this.a.getIiop()) {
            if (!areIiopAndIdlSupported()) {
                throw new org.apache.tools.ant.BuildException("this rmic implementation doesn't support the -iiop switch");
            }
            this.a.log("IIOP has been turned on.", 2);
            commandline.createArgument().setValue("-iiop");
            if (this.a.getIiopopts() != null) {
                this.a.log("IIOP Options: " + this.a.getIiopopts(), 2);
                commandline.createArgument().setValue(this.a.getIiopopts());
            }
        }
        if (this.a.getIdl()) {
            if (!areIiopAndIdlSupported()) {
                throw new org.apache.tools.ant.BuildException("this rmic implementation doesn't support the -idl switch");
            }
            commandline.createArgument().setValue("-idl");
            this.a.log("IDL has been turned on.", 2);
            if (this.a.getIdlopts() != null) {
                commandline.createArgument().setValue(this.a.getIdlopts());
                this.a.log("IDL Options: " + this.a.getIdlopts(), 2);
            }
        }
        if (this.a.getDebug()) {
            commandline.createArgument().setValue("-g");
        }
        commandline.addArguments(preprocessCompilerArgs(this.a.getCurrentCompilerArgs()));
        c(commandline);
        logAndAddFilesToCompile(commandline);
        return commandline;
    }
}
