package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class JikesOutputParser implements org.apache.tools.ant.taskdefs.ExecuteStreamHandler {
    protected java.io.BufferedReader br;
    protected boolean emacsMode;
    protected int errors;
    protected org.apache.tools.ant.Task task;
    protected int warnings;
    protected boolean errorFlag = false;
    protected boolean error = false;

    public JikesOutputParser(org.apache.tools.ant.Task task, boolean z) {
        java.lang.System.err.println("As of Ant 1.2 released in October 2000, the JikesOutputParser class");
        java.lang.System.err.println("is considered to be dead code by the Ant developers and is unmaintained.");
        java.lang.System.err.println("Don't use it!");
        this.task = task;
        this.emacsMode = z;
    }

    public final void a(java.lang.String str) {
        if (!this.emacsMode) {
            this.task.log("", !this.error ? 1 : 0);
        }
        this.task.log(str, !this.error ? 1 : 0);
    }

    public final void b(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        c(bufferedReader);
    }

    public final void c(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            java.lang.String lowerCase = readLine.toLowerCase();
            if (!readLine.trim().equals("")) {
                if (lowerCase.contains("error")) {
                    d(true);
                } else if (lowerCase.contains("warning")) {
                    d(false);
                } else if (this.emacsMode) {
                    d(true);
                }
                a(readLine);
            }
        }
    }

    public final void d(boolean z) {
        this.error = z;
        if (z) {
            this.errorFlag = true;
        }
    }

    public boolean getErrorFlag() {
        return this.errorFlag;
    }

    public void parseOutput(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        if (this.emacsMode) {
            b(bufferedReader);
        } else {
            c(bufferedReader);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessErrorStream(java.io.InputStream inputStream) {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessInputStream(java.io.OutputStream outputStream) {
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessOutputStream(java.io.InputStream inputStream) throws java.io.IOException {
        this.br = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void start() throws java.io.IOException {
        parseOutput(this.br);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void stop() {
    }
}
