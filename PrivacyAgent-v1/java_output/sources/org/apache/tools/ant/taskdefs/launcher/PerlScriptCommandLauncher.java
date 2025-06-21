package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class PerlScriptCommandLauncher extends org.apache.tools.ant.taskdefs.launcher.CommandLauncherProxy {
    public final java.lang.String d;

    public PerlScriptCommandLauncher(java.lang.String str, org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        super(commandLauncher);
        this.d = str;
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        if (project == null) {
            if (file == null) {
                return exec(project, strArr, strArr2);
            }
            throw new java.io.IOException("Cannot locate antRun script: No project provided");
        }
        java.lang.String property = project.getProperty("ant.home");
        if (property == null) {
            throw new java.io.IOException("Cannot locate antRun script: Property 'ant.home' not found");
        }
        java.lang.String file2 = org.apache.tools.ant.taskdefs.launcher.CommandLauncher.FILE_UTILS.resolveFile(project.getBaseDir(), property + java.io.File.separator + this.d).toString();
        if (file == null) {
            file = project.getBaseDir();
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length + 3];
        strArr3[0] = "perl";
        strArr3[1] = file2;
        strArr3[2] = file.getAbsolutePath();
        java.lang.System.arraycopy(strArr, 0, strArr3, 3, strArr.length);
        return exec(project, strArr3, strArr2);
    }
}
