package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class OS2CommandLauncher extends org.apache.tools.ant.taskdefs.launcher.CommandLauncherProxy {
    public OS2CommandLauncher(org.apache.tools.ant.taskdefs.launcher.CommandLauncher commandLauncher) {
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
        java.lang.String absolutePath = file.getAbsolutePath();
        java.lang.String[] strArr3 = new java.lang.String[strArr.length + 7];
        strArr3[0] = "cmd";
        strArr3[1] = "/c";
        strArr3[2] = absolutePath.substring(0, 2);
        strArr3[3] = "&&";
        strArr3[4] = com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_DURATION;
        strArr3[5] = absolutePath.substring(2);
        strArr3[6] = "&&";
        java.lang.System.arraycopy(strArr, 0, strArr3, 7, strArr.length);
        return exec(project, strArr3, strArr2);
    }
}
