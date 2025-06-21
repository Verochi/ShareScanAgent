package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class Java13CommandLauncher extends org.apache.tools.ant.taskdefs.launcher.CommandLauncher {
    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        if (project != null) {
            try {
                project.log("Execute:Java13CommandLauncher: " + org.apache.tools.ant.types.Commandline.describeCommand(strArr), 4);
            } catch (java.io.IOException e) {
                throw e;
            } catch (java.lang.Exception e2) {
                throw new org.apache.tools.ant.BuildException("Unable to execute command", e2);
            }
        }
        return java.lang.Runtime.getRuntime().exec(strArr, strArr2, file);
    }
}
