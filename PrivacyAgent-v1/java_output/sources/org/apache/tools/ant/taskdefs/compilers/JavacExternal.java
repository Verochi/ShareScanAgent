package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class JavacExternal extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using external javac compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(getJavac().getJavacExecutable());
        if (assumeJava11() || assumeJava12()) {
            setupJavacCommandlineSwitches(commandline, true);
        } else {
            setupModernJavacCommandlineSwitches(commandline);
        }
        int size = assumeJava11() ? -1 : commandline.size();
        logAndAddFilesToCompile(commandline);
        return org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS) ? f(commandline, size) : executeExternalCompile(commandline.getCommandline(), size, true) == 0;
    }

    public final boolean f(org.apache.tools.ant.types.Commandline commandline, int i) {
        java.io.File file = null;
        try {
            try {
                file = org.apache.tools.ant.util.JavaEnvUtils.createVmsJavaOptionFile(commandline.getArguments());
                return executeExternalCompile(new java.lang.String[]{commandline.getExecutable(), org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_VERSION, file.getPath()}, i, true) == 0;
            } catch (java.io.IOException unused) {
                throw new org.apache.tools.ant.BuildException("Failed to create a temporary file for \"-V\" switch");
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.delete(file);
        }
    }
}
