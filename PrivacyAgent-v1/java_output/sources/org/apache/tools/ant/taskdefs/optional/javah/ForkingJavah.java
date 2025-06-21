package org.apache.tools.ant.taskdefs.optional.javah;

/* loaded from: classes25.dex */
public class ForkingJavah implements org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter {
    public static final java.lang.String IMPLEMENTATION_NAME = "forking";

    @Override // org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter
    public boolean compile(org.apache.tools.ant.taskdefs.optional.Javah javah) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Commandline a = org.apache.tools.ant.taskdefs.optional.javah.SunJavah.a(javah);
        org.apache.tools.ant.Project project = javah.getProject();
        java.lang.String jdkExecutable = org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable("javah");
        javah.log("Running " + jdkExecutable, 3);
        a.setExecutable(jdkExecutable);
        java.lang.String[] commandline = a.getCommandline();
        try {
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) javah, 2, 1));
            execute.setAntRun(project);
            execute.setWorkingDirectory(project.getBaseDir());
            execute.setCommandline(commandline);
            execute.execute();
            return !execute.isFailure();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Error running " + jdkExecutable + " -maybe it is not on the path", e);
        }
    }
}
