package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class CommandLauncherTask extends org.apache.tools.ant.Task {
    public boolean u;
    public org.apache.tools.ant.taskdefs.launcher.CommandLauncher v;

    public synchronized void addConfigured(org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("Only one CommandLauncher can be installed");
        }
        this.v = commandLauncher;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.v != null) {
            if (this.u) {
                org.apache.tools.ant.taskdefs.launcher.CommandLauncher.setVMLauncher(getProject(), this.v);
            } else {
                org.apache.tools.ant.taskdefs.launcher.CommandLauncher.setShellLauncher(getProject(), this.v);
            }
        }
    }

    public void setVmLauncher(boolean z) {
        this.u = z;
    }
}
