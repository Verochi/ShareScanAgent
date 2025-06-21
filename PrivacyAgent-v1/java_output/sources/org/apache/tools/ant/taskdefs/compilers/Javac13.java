package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Javac13 extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using modern compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupModernJavacCommand();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.sun.tools.javac.Main");
            return ((java.lang.Integer) cls.getMethod("compile", new java.lang.String[0].getClass()).invoke(cls.newInstance(), commandline.getArguments())).intValue() == 0;
        } catch (java.lang.Exception e) {
            if (e instanceof org.apache.tools.ant.BuildException) {
                throw ((org.apache.tools.ant.BuildException) e);
            }
            throw new org.apache.tools.ant.BuildException("Error starting modern compiler", e, this.location);
        }
    }
}
