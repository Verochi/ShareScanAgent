package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public class SunRmic extends org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter {
    public static final java.lang.String COMPILER_NAME = "sun";
    public static final java.lang.String ERROR_NO_RMIC_ON_CLASSPATH = "Cannot use SUN rmic, as it is not available.  A common solution is to set the environment variable JAVA_HOME";
    public static final java.lang.String ERROR_NO_RMIC_ON_CLASSPATH_JAVA_9 = "Cannot use SUN rmic, as it is not available.  The class we try to use is part of the jdk.rmic module which may not be. Please use the 'forking' compiler for JDK 9+";
    public static final java.lang.String ERROR_RMIC_FAILED = "Error starting SUN rmic: ";
    public static final java.lang.String RMIC_CLASSNAME = "sun.rmi.rmic.Main";
    public static final java.lang.String RMIC_EXECUTABLE = "rmic";

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        getRmic().log("Using SUN rmic compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupRmicCommand();
        boolean z = true;
        org.apache.tools.ant.taskdefs.LogOutputStream logOutputStream = new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) getRmic(), 1);
        try {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(RMIC_CLASSNAME);
                try {
                    boolean booleanValue = ((java.lang.Boolean) cls.getMethod("compile", java.lang.String[].class).invoke(cls.getConstructor(java.io.OutputStream.class, java.lang.String.class).newInstance(logOutputStream, RMIC_EXECUTABLE), commandline.getArguments())).booleanValue();
                    try {
                        logOutputStream.close();
                        return booleanValue;
                    } catch (java.io.IOException e) {
                        throw new org.apache.tools.ant.BuildException(e);
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                    if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion("9")) {
                        throw new org.apache.tools.ant.BuildException(ERROR_NO_RMIC_ON_CLASSPATH_JAVA_9, getRmic().getLocation());
                    }
                    throw new org.apache.tools.ant.BuildException(ERROR_NO_RMIC_ON_CLASSPATH, getRmic().getLocation());
                } catch (java.lang.Exception e2) {
                    e = e2;
                    if (e instanceof org.apache.tools.ant.BuildException) {
                        throw ((org.apache.tools.ant.BuildException) e);
                    }
                    throw new org.apache.tools.ant.BuildException(ERROR_RMIC_FAILED, e, getRmic().getLocation());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    logOutputStream.close();
                } catch (java.io.IOException e3) {
                    if (z) {
                        throw new org.apache.tools.ant.BuildException(e3);
                    }
                }
                throw th;
            }
        } catch (java.lang.ClassNotFoundException unused2) {
        } catch (java.lang.Exception e4) {
            e = e4;
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = false;
            logOutputStream.close();
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public java.lang.String[] preprocessCompilerArgs(java.lang.String[] strArr) {
        return filterJvmCompilerArgs(strArr);
    }
}
