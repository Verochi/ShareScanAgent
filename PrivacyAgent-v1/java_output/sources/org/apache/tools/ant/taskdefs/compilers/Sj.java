package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class Sj extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using symantec java compiler", 3);
        org.apache.tools.ant.types.Commandline commandline = setupJavacCommand();
        java.lang.String executable = getJavac().getExecutable();
        if (executable == null) {
            executable = "sj";
        }
        commandline.setExecutable(executable);
        return executeExternalCompile(commandline.getCommandline(), commandline.size() - this.compileList.length) == 0;
    }

    @Override // org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter
    public java.lang.String getNoDebugArgument() {
        return null;
    }
}
