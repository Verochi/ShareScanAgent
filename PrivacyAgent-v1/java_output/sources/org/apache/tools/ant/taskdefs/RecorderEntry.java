package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class RecorderEntry implements org.apache.tools.ant.BuildLogger, org.apache.tools.ant.SubBuildListener {
    public java.lang.String n;
    public long w;
    public org.apache.tools.ant.Project y;
    public boolean t = true;
    public int u = 2;
    public java.io.PrintStream v = null;
    public boolean x = false;

    public RecorderEntry(java.lang.String str) {
        this.n = null;
        this.w = 0L;
        this.w = java.lang.System.currentTimeMillis();
        this.n = str;
    }

    public static java.lang.String c(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        if (j3 <= 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.Long.toString(j2));
            sb.append(" second");
            sb.append(j2 % 60 != 1 ? "s" : "");
            return sb.toString();
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(java.lang.Long.toString(j3));
        sb2.append(" minute");
        sb2.append(j3 == 1 ? " " : "s ");
        long j4 = j2 % 60;
        sb2.append(java.lang.Long.toString(j4));
        sb2.append(" second");
        sb2.append(j4 != 1 ? "s" : "");
        return sb2.toString();
    }

    public void a() {
        java.io.PrintStream printStream = this.v;
        if (printStream != null) {
            printStream.close();
            this.v = null;
        }
    }

    public final void b() {
        java.io.PrintStream printStream;
        if (!this.t || (printStream = this.v) == null) {
            return;
        }
        printStream.flush();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        d("< BUILD FINISHED", 4);
        if (this.t && this.v != null) {
            java.lang.Throwable exception = buildEvent.getException();
            if (exception == null) {
                this.v.println(org.apache.tools.ant.util.StringUtils.LINE_SEP + "BUILD SUCCESSFUL");
            } else {
                java.io.PrintStream printStream = this.v;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
                sb.append(str);
                sb.append("BUILD FAILED");
                sb.append(str);
                printStream.println(sb.toString());
                exception.printStackTrace(this.v);
            }
        }
        cleanup();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        d("> BUILD STARTED", 4);
    }

    public void cleanup() {
        a();
        org.apache.tools.ant.Project project = this.y;
        if (project != null) {
            project.removeBuildListener(this);
        }
        this.y = null;
    }

    public final void d(java.lang.String str, int i) {
        java.io.PrintStream printStream;
        if (!this.t || i > this.u || (printStream = this.v) == null) {
            return;
        }
        printStream.println(str);
    }

    public void e(boolean z) throws org.apache.tools.ant.BuildException {
        f(z);
    }

    public final void f(boolean z) throws org.apache.tools.ant.BuildException {
        if (this.v == null) {
            try {
                this.v = new java.io.PrintStream(new java.io.FileOutputStream(this.n, z));
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Problems opening file using a recorder entry", e);
            }
        }
    }

    public void g() throws org.apache.tools.ant.BuildException {
        f(true);
    }

    public java.lang.String getFilename() {
        return this.n;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.y;
    }

    @Override // org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
        d("--- MESSAGE LOGGED", 4);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (buildEvent.getTask() != null) {
            java.lang.String taskName = buildEvent.getTask().getTaskName();
            if (!this.x) {
                java.lang.String str = "[" + taskName + "] ";
                int length = 12 - str.length();
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(str);
            }
        }
        stringBuffer.append(buildEvent.getMessage());
        d(stringBuffer.toString(), buildEvent.getPriority());
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setEmacsMode(boolean z) {
        this.x = z;
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setErrorPrintStream(java.io.PrintStream printStream) {
        setOutputPrintStream(printStream);
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setMessageOutputLevel(int i) {
        if (i < 0 || i > 4) {
            return;
        }
        this.u = i;
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setOutputPrintStream(java.io.PrintStream printStream) {
        a();
        this.v = printStream;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.y = project;
        if (project != null) {
            project.addBuildListener(this);
        }
    }

    public void setRecordState(java.lang.Boolean bool) {
        if (bool != null) {
            b();
            this.t = bool.booleanValue();
        }
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (buildEvent.getProject() == this.y) {
            cleanup();
        }
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        d("<< TARGET FINISHED -- " + buildEvent.getTarget(), 4);
        d(buildEvent.getTarget() + ":  duration " + c(java.lang.System.currentTimeMillis() - this.w), 3);
        b();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        d(">> TARGET STARTED -- " + buildEvent.getTarget(), 4);
        d(org.apache.tools.ant.util.StringUtils.LINE_SEP + buildEvent.getTarget().getName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, 2);
        this.w = java.lang.System.currentTimeMillis();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        d("<<< TASK FINISHED -- " + buildEvent.getTask(), 4);
        b();
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        d(">>> TASK STARTED -- " + buildEvent.getTask(), 4);
    }
}
