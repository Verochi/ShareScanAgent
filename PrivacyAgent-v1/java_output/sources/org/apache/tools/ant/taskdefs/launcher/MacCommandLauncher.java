package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class MacCommandLauncher extends org.apache.tools.ant.taskdefs.launcher.CommandLauncherProxy {
    public MacCommandLauncher(org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        super(commandLauncher);
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        if (file == null) {
            return exec(project, strArr, strArr2);
        }
        java.lang.System.getProperties().put("user.dir", file.getAbsolutePath());
        try {
            return exec(project, strArr, strArr2);
        } finally {
            java.lang.System.getProperties().put("user.dir", java.lang.System.getProperty("user.dir"));
        }
    }
}
