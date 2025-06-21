package org.apache.tools.ant.taskdefs.compilers;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class Javac12 extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    protected static final java.lang.String CLASSIC_COMPILER_CLASSNAME = "sun.tools.javac.Main";

    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using classic compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupJavacCommand(true);
        org.apache.tools.ant.taskdefs.LogOutputStream logOutputStream = new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this.attributes, 1);
        try {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(CLASSIC_COMPILER_CLASSNAME);
                return ((java.lang.Boolean) cls.getMethod("compile", java.lang.String[].class).invoke(cls.getConstructor(java.io.OutputStream.class, java.lang.String.class).newInstance(logOutputStream, "javac"), commandline.getArguments())).booleanValue();
            } catch (java.lang.ClassNotFoundException unused) {
                throw new org.apache.tools.ant.BuildException("Cannot use classic compiler, as it is not available. \n A common solution is to set the environment variable JAVA_HOME to your jdk directory.\nIt is currently set to \"" + org.apache.tools.ant.util.JavaEnvUtils.getJavaHome() + "\"", this.location);
            } catch (java.lang.Exception e) {
                if (e instanceof org.apache.tools.ant.BuildException) {
                    throw ((org.apache.tools.ant.BuildException) e);
                }
                throw new org.apache.tools.ant.BuildException("Error starting classic compiler: ", e, this.location);
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(logOutputStream);
        }
    }
}
