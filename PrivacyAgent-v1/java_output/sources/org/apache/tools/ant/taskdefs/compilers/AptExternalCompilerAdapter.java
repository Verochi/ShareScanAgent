package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public class AptExternalCompilerAdapter extends org.apache.tools.ant.taskdefs.compilers.DefaultCompilerAdapter {
    @Override // org.apache.tools.ant.taskdefs.compilers.CompilerAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        this.attributes.log("Using external apt compiler", 3);
        org.apache.tools.ant.taskdefs.Apt apt = getApt();
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(apt.getAptExecutable());
        setupModernJavacCommandlineSwitches(commandline);
        org.apache.tools.ant.taskdefs.compilers.AptCompilerAdapter.f(apt, commandline);
        int size = commandline.size();
        logAndAddFilesToCompile(commandline);
        return executeExternalCompile(commandline.getCommandline(), size, true) == 0;
    }

    public org.apache.tools.ant.taskdefs.Apt getApt() {
        return (org.apache.tools.ant.taskdefs.Apt) getJavac();
    }
}
