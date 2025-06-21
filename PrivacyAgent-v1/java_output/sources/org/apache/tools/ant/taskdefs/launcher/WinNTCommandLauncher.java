package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class WinNTCommandLauncher extends org.apache.tools.ant.taskdefs.launcher.CommandLauncherProxy {
    public WinNTCommandLauncher(org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
        super(commandLauncher);
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        if (file == null) {
            if (project == null) {
                return exec(project, strArr, strArr2);
            }
            file = project.getBaseDir();
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length + 6];
        strArr3[0] = "cmd";
        strArr3[1] = "/c";
        strArr3[2] = com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_DURATION;
        strArr3[3] = "/d";
        strArr3[4] = file.getAbsolutePath();
        strArr3[5] = "&&";
        java.lang.System.arraycopy(strArr, 0, strArr3, 6, strArr.length);
        return exec(project, strArr3, strArr2);
    }
}
