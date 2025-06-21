package org.apache.tools.ant.taskdefs.launcher;

/* loaded from: classes25.dex */
public class VmsCommandLauncher extends org.apache.tools.ant.taskdefs.launcher.Java13CommandLauncher {

    /* renamed from: org.apache.tools.ant.taskdefs.launcher.VmsCommandLauncher$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ java.lang.Process n;
        public final /* synthetic */ java.io.File t;

        public AnonymousClass1(java.lang.Process process, java.io.File file) {
            this.n = process;
            this.t = file;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.n.waitFor();
            } catch (java.lang.InterruptedException unused) {
            }
            org.apache.tools.ant.util.FileUtils.delete(this.t);
        }
    }

    public final java.io.File c(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.io.IOException {
        java.io.File createTempFile = org.apache.tools.ant.taskdefs.launcher.CommandLauncher.FILE_UTILS.createTempFile(project, "ANT", ".COM", null, true, true);
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile));
            if (strArr2 != null) {
                try {
                    for (java.lang.String str : strArr2) {
                        int indexOf = str.indexOf(61);
                        if (indexOf != -1) {
                            bufferedWriter2.write("$ DEFINE/NOLOG ");
                            bufferedWriter2.write(str.substring(0, indexOf));
                            bufferedWriter2.write(" \"");
                            bufferedWriter2.write(str.substring(indexOf + 1));
                            bufferedWriter2.write(34);
                            bufferedWriter2.newLine();
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    throw th;
                }
            }
            bufferedWriter2.write("$ " + strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                bufferedWriter2.write(" -");
                bufferedWriter2.newLine();
                bufferedWriter2.write(strArr[i]);
            }
            org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
            return createTempFile;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void d(java.io.File file, java.lang.Process process) {
        new org.apache.tools.ant.taskdefs.launcher.VmsCommandLauncher.AnonymousClass1(process, file).start();
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.io.IOException {
        java.io.File c = c(project, strArr, strArr2);
        java.lang.Process exec = super.exec(project, new java.lang.String[]{c.getPath()}, strArr2);
        d(c, exec);
        return exec;
    }

    @Override // org.apache.tools.ant.taskdefs.launcher.Java13CommandLauncher, org.apache.tools.ant.taskdefs.launcher.CommandLauncher
    public java.lang.Process exec(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) throws java.io.IOException {
        java.io.File c = c(project, strArr, strArr2);
        java.lang.Process exec = super.exec(project, new java.lang.String[]{c.getPath()}, strArr2, file);
        d(c, exec);
        return exec;
    }
}
