package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class DefaultLogger implements org.apache.tools.ant.BuildLogger {
    public static final int LEFT_COLUMN_SIZE = 12;
    protected static final java.lang.String lSep = org.apache.tools.ant.util.StringUtils.LINE_SEP;
    protected java.io.PrintStream err;
    protected java.io.PrintStream out;
    protected int msgOutputLevel = 0;
    public long n = java.lang.System.currentTimeMillis();
    protected boolean emacsMode = false;

    public static void a(java.lang.StringBuffer stringBuffer, java.lang.Throwable th, boolean z) {
        boolean z2;
        java.lang.Throwable cause;
        while (true) {
            z2 = th instanceof org.apache.tools.ant.BuildException;
            if (!z2 || (cause = th.getCause()) == null) {
                break;
            }
            java.lang.String th2 = th.toString();
            java.lang.String th3 = cause.toString();
            if (!th2.endsWith(th3)) {
                break;
            }
            stringBuffer.append(th2.substring(0, th2.length() - th3.length()));
            th = cause;
        }
        if (z || !z2) {
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.getStackTrace(th));
        } else {
            stringBuffer.append(th);
            stringBuffer.append(lSep);
        }
    }

    public static java.lang.String formatTime(long j) {
        return org.apache.tools.ant.util.DateUtils.formatElapsedTime(j);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.Throwable exception = buildEvent.getException();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (exception == null) {
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
            stringBuffer.append(getBuildSuccessfulMessage());
        } else {
            java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
            stringBuffer.append(str);
            stringBuffer.append(getBuildFailedMessage());
            stringBuffer.append(str);
            a(stringBuffer, exception, 3 <= this.msgOutputLevel);
        }
        stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        stringBuffer.append("Total time: ");
        stringBuffer.append(formatTime(java.lang.System.currentTimeMillis() - this.n));
        java.lang.String stringBuffer2 = stringBuffer.toString();
        if (exception == null) {
            printMessage(stringBuffer2, this.out, 3);
        } else {
            printMessage(stringBuffer2, this.err, 0);
        }
        log(stringBuffer2);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        this.n = java.lang.System.currentTimeMillis();
    }

    public java.lang.String extractProjectName(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.Project project = buildEvent.getProject();
        if (project != null) {
            return project.getName();
        }
        return null;
    }

    public java.lang.String getBuildFailedMessage() {
        return "BUILD FAILED";
    }

    public java.lang.String getBuildSuccessfulMessage() {
        return "BUILD SUCCESSFUL";
    }

    public java.lang.String getTimestamp() {
        return java.text.DateFormat.getDateTimeInstance(3, 3).format(new java.util.Date(java.lang.System.currentTimeMillis()));
    }

    public void log(java.lang.String str) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006c, code lost:
    
        r1.append(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // org.apache.tools.ant.BuildListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.Throwable exception;
        java.io.BufferedReader bufferedReader;
        int priority = buildEvent.getPriority();
        if (priority <= this.msgOutputLevel) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (buildEvent.getTask() == null || this.emacsMode) {
                stringBuffer.append(buildEvent.getMessage());
            } else {
                java.lang.String str = "[" + buildEvent.getTask().getTaskName() + "] ";
                int length = 12 - str.length();
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                for (int i = 0; i < length; i++) {
                    stringBuffer2.append(" ");
                }
                stringBuffer2.append(str);
                java.lang.String stringBuffer3 = stringBuffer2.toString();
                ?? r5 = 0;
                java.io.BufferedReader bufferedReader2 = null;
                try {
                    try {
                        bufferedReader = new java.io.BufferedReader(new java.io.StringReader(buildEvent.getMessage()));
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                } catch (java.io.IOException unused) {
                }
                try {
                    boolean z = true;
                    java.lang.String str2 = bufferedReader.readLine();
                    while (true) {
                        if (z) {
                            if (str2 == null) {
                                break;
                            }
                        } else {
                            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
                        }
                        stringBuffer.append(stringBuffer3);
                        stringBuffer.append(str2);
                        str2 = bufferedReader.readLine();
                        if (str2 == null) {
                            break;
                        }
                        z = false;
                        str2 = str2;
                    }
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    r5 = str2;
                } catch (java.io.IOException unused2) {
                    bufferedReader2 = bufferedReader;
                    stringBuffer.append(stringBuffer3);
                    stringBuffer.append(buildEvent.getMessage());
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                    r5 = bufferedReader2;
                    exception = buildEvent.getException();
                    if (4 <= this.msgOutputLevel) {
                        stringBuffer.append(java.lang.String.format("%n%s: ", exception.getClass().getSimpleName()));
                        stringBuffer.append(org.apache.tools.ant.util.StringUtils.getStackTrace(exception));
                    }
                    java.lang.String stringBuffer4 = stringBuffer.toString();
                    if (priority == 0) {
                    }
                    log(stringBuffer4);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r5 = bufferedReader;
                    org.apache.tools.ant.util.FileUtils.close((java.io.Reader) r5);
                    throw th;
                }
            }
            exception = buildEvent.getException();
            if (4 <= this.msgOutputLevel && exception != null) {
                stringBuffer.append(java.lang.String.format("%n%s: ", exception.getClass().getSimpleName()));
                stringBuffer.append(org.apache.tools.ant.util.StringUtils.getStackTrace(exception));
            }
            java.lang.String stringBuffer42 = stringBuffer.toString();
            if (priority == 0) {
                printMessage(stringBuffer42, this.out, priority);
            } else {
                printMessage(stringBuffer42, this.err, priority);
            }
            log(stringBuffer42);
        }
    }

    public void printMessage(java.lang.String str, java.io.PrintStream printStream, int i) {
        printStream.println(str);
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setEmacsMode(boolean z) {
        this.emacsMode = z;
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setErrorPrintStream(java.io.PrintStream printStream) {
        this.err = new java.io.PrintStream((java.io.OutputStream) printStream, true);
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setMessageOutputLevel(int i) {
        this.msgOutputLevel = i;
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setOutputPrintStream(java.io.PrintStream printStream) {
        this.out = new java.io.PrintStream((java.io.OutputStream) printStream, true);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        if (2 > this.msgOutputLevel || buildEvent.getTarget().getName().equals("")) {
            return;
        }
        java.lang.String format = java.lang.String.format("%n%s:", buildEvent.getTarget().getName());
        printMessage(format, this.out, buildEvent.getPriority());
        log(format);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }
}
