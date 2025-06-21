package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class CommandLauncherProxy extends org.apache.tools.ant.taskdefs.launcher.CommandLauncher {
    public final org.apache.tools.ant.taskdefs.launcher.CommandLauncher c;

    public CommandLauncherProxy(org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        this.c = commandLauncher;
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.io.IOException {
        return this.c.exec(project, strArr, strArr2);
    }
}
