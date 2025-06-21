package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class TaskLogger {
    public org.apache.tools.ant.Task a;

    public TaskLogger(org.apache.tools.ant.Task task) {
        this.a = task;
    }

    public void debug(java.lang.String str) {
        this.a.log(str, 4);
    }

    public void error(java.lang.String str) {
        this.a.log(str, 0);
    }

    public void info(java.lang.String str) {
        this.a.log(str, 2);
    }

    public void verbose(java.lang.String str) {
        this.a.log(str, 3);
    }

    public void warning(java.lang.String str) {
        this.a.log(str, 1);
    }
}
