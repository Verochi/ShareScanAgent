package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public class ForkingSunRmic extends org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter {
    public static final java.lang.String COMPILER_NAME = "forking";

    @Override // org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter
    public boolean areIiopAndIdlSupported() {
        boolean z = !org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
        if (z || getRmic().getExecutable() == null) {
            return z;
        }
        getRmic().getProject().log("Allowing -iiop and -idl for forked rmic even though this version of Java doesn't support it.", 2);
        return true;
    }

    @Override // org.apache.tools.ant.taskdefs.rmic.RmicAdapter
    public boolean execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Rmic rmic = getRmic();
        org.apache.tools.ant.types.Commandline commandline = setupRmicCommand();
        org.apache.tools.ant.Project project = rmic.getProject();
        java.lang.String executable = rmic.getExecutable();
        if (executable == null) {
            if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                throw new org.apache.tools.ant.BuildException("rmic does not exist under Java 15 and higher, use rmic of an older JDK and explicitly set the executable attribute");
            }
            executable = org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable(getExecutableName());
        }
        commandline.setExecutable(executable);
        java.lang.String[] commandline2 = commandline.getCommandline();
        try {
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) rmic, 2, 1));
            execute.setAntRun(project);
            execute.setWorkingDirectory(project.getBaseDir());
            execute.setCommandline(commandline2);
            execute.execute();
            return !execute.isFailure();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Error running " + getExecutableName() + " -maybe it is not on the path", e);
        }
    }

    public java.lang.String getExecutableName() {
        return org.apache.tools.ant.taskdefs.rmic.SunRmic.RMIC_EXECUTABLE;
    }
}
