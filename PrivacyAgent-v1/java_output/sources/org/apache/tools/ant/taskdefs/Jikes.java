package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class Jikes {
    protected java.lang.String command;
    protected org.apache.tools.ant.taskdefs.JikesOutputParser jop;
    protected org.apache.tools.ant.Project project;

    public Jikes(org.apache.tools.ant.taskdefs.JikesOutputParser jikesOutputParser, java.lang.String str, org.apache.tools.ant.Project project) {
        java.lang.System.err.println("As of Ant 1.2 released in October 2000, the Jikes class");
        java.lang.System.err.println("is considered to be dead code by the Ant developers and is unmaintained.");
        java.lang.System.err.println("Don't use it!");
        this.jop = jikesOutputParser;
        this.command = str;
        this.project = project;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public void compile(java.lang.String[] strArr) {
        java.lang.String[] strArr2;
        java.io.File createTempFile;
        java.io.BufferedWriter bufferedWriter;
        java.io.File file = null;
        r0 = null;
        java.io.BufferedWriter bufferedWriter2 = null;
        file = null;
        try {
            try {
                if (java.lang.System.getProperty("os.name").toLowerCase(java.util.Locale.ENGLISH).contains(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
                    ?? length = strArr.length;
                    try {
                        try {
                            if (length > 250) {
                                try {
                                    createTempFile = org.apache.tools.ant.util.FileUtils.getFileUtils().createTempFile(this.project, "jikes", "tmp", null, false, true);
                                    try {
                                        bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile));
                                    } catch (java.io.IOException e) {
                                        e = e;
                                    }
                                } catch (java.io.IOException e2) {
                                    e = e2;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                }
                                try {
                                    for (java.lang.String str : strArr) {
                                        bufferedWriter.write(str);
                                        bufferedWriter.newLine();
                                    }
                                    bufferedWriter.flush();
                                    strArr2 = new java.lang.String[]{this.command, "@" + createTempFile.getAbsolutePath()};
                                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                                    file = createTempFile;
                                    org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(this.jop);
                                    execute.setAntRun(this.project);
                                    execute.setWorkingDirectory(this.project.getBaseDir());
                                    execute.setCommandline(strArr2);
                                    execute.execute();
                                    if (file != null || file.delete()) {
                                        return;
                                    }
                                    file.deleteOnExit();
                                    return;
                                } catch (java.io.IOException e3) {
                                    e = e3;
                                    throw new org.apache.tools.ant.BuildException("Error creating temporary file", e);
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    bufferedWriter2 = bufferedWriter;
                                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        file = length;
                        if (file != null && !file.delete()) {
                            file.deleteOnExit();
                        }
                        throw th;
                    }
                }
                org.apache.tools.ant.taskdefs.Execute execute2 = new org.apache.tools.ant.taskdefs.Execute(this.jop);
                execute2.setAntRun(this.project);
                execute2.setWorkingDirectory(this.project.getBaseDir());
                execute2.setCommandline(strArr2);
                execute2.execute();
                if (file != null) {
                    return;
                } else {
                    return;
                }
            } catch (java.io.IOException e4) {
                throw new org.apache.tools.ant.BuildException("Error running Jikes compiler", e4);
            }
            java.lang.String[] strArr3 = new java.lang.String[strArr.length + 1];
            strArr3[0] = this.command;
            java.lang.System.arraycopy(strArr, 0, strArr3, 1, strArr.length);
            strArr2 = strArr3;
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }
}
