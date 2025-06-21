package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public class WLRmic extends org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter {
    public static final java.lang.String COMPILER_NAME = "weblogic";
    public static final java.lang.String ERROR_NO_WLRMIC_ON_CLASSPATH = "Cannot use WebLogic rmic, as it is not available. Add it to Ant's classpath with the -lib option";
    public static final java.lang.String ERROR_WLRMIC_FAILED = "Error starting WebLogic rmic: ";
    public static final java.lang.String UNSUPPORTED_STUB_OPTION = "Unsupported stub option: ";
    public static final java.lang.String WLRMIC_CLASSNAME = "weblogic.rmic";
    public static final java.lang.String WL_RMI_SKEL_SUFFIX = "_WLSkel";
    public static final java.lang.String WL_RMI_STUB_SUFFIX = "_WLStub";

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public java.lang.String addStubVersionOptions() {
        java.lang.String stubVersion = getRmic().getStubVersion();
        if (stubVersion == null) {
            return null;
        }
        getRmic().log(UNSUPPORTED_STUB_OPTION + stubVersion, 1);
        return null;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public boolean areIiopAndIdlSupported() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[Catch: all -> 0x0071, TryCatch #2 {all -> 0x0071, blocks: (B:3:0x0015, B:6:0x0022, B:19:0x0074, B:21:0x0078, B:22:0x007a, B:23:0x007b, B:24:0x008a, B:30:0x0028, B:15:0x008b, B:16:0x009a), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b A[Catch: all -> 0x0071, TryCatch #2 {all -> 0x0071, blocks: (B:3:0x0015, B:6:0x0022, B:19:0x0074, B:21:0x0078, B:22:0x007a, B:23:0x007b, B:24:0x008a, B:30:0x0028, B:15:0x008b, B:16:0x009a), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.AntClassLoader antClassLoader;
        java.lang.Class<?> cls;
        getRmic().log("Using WebLogic rmic", 3);
        org.apache.tools.ant.types.Commandline commandline = setupRmicCommand(new java.lang.String[]{"-noexit"});
        org.apache.tools.ant.AntClassLoader antClassLoader2 = null;
        try {
            try {
                if (getRmic().getClasspath() == null) {
                    cls = java.lang.Class.forName(WLRMIC_CLASSNAME);
                    antClassLoader = null;
                } else {
                    org.apache.tools.ant.AntClassLoader createClassLoader = getRmic().getProject().createClassLoader(getRmic().getClasspath());
                    try {
                        antClassLoader = createClassLoader;
                        cls = java.lang.Class.forName(WLRMIC_CLASSNAME, true, createClassLoader);
                    } catch (java.lang.ClassNotFoundException unused) {
                        throw new org.apache.tools.ant.BuildException(ERROR_NO_WLRMIC_ON_CLASSPATH, getRmic().getLocation());
                    } catch (java.lang.Exception e) {
                        e = e;
                        if (e instanceof org.apache.tools.ant.BuildException) {
                            throw new org.apache.tools.ant.BuildException(ERROR_WLRMIC_FAILED, e, getRmic().getLocation());
                        }
                        throw ((org.apache.tools.ant.BuildException) e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        antClassLoader2 = createClassLoader;
                        if (antClassLoader2 != null) {
                            antClassLoader2.cleanup();
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            try {
                cls.getMethod("main", java.lang.String[].class).invoke(null, commandline.getArguments());
                if (antClassLoader != null) {
                    antClassLoader.cleanup();
                }
                return true;
            } catch (java.lang.ClassNotFoundException unused2) {
                throw new org.apache.tools.ant.BuildException(ERROR_NO_WLRMIC_ON_CLASSPATH, getRmic().getLocation());
            } catch (java.lang.Exception e2) {
                e = e2;
                if (e instanceof org.apache.tools.ant.BuildException) {
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                antClassLoader2 = antClassLoader;
                if (antClassLoader2 != null) {
                }
                throw th;
            }
        } catch (java.lang.ClassNotFoundException unused3) {
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public java.lang.String getSkelClassSuffix() {
        return WL_RMI_SKEL_SUFFIX;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public java.lang.String getStubClassSuffix() {
        return WL_RMI_STUB_SUFFIX;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public java.lang.String[] preprocessCompilerArgs(java.lang.String[] strArr) {
        return filterJvmCompilerArgs(strArr);
    }
}
