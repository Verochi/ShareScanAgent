package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class LogOutputStream extends org.apache.tools.ant.util.LineOrientedOutputStream {
    public org.apache.tools.ant.ProjectComponent u;
    public int v;

    public LogOutputStream(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.v = 2;
        this.u = projectComponent;
    }

    public LogOutputStream(org.apache.tools.ant.ProjectComponent projectComponent, int i) {
        this(projectComponent);
        this.v = i;
    }

    public LogOutputStream(org.apache.tools.ant.Task task, int i) {
        this((org.apache.tools.ant.ProjectComponent) task, i);
    }

    public int getMessageLevel() {
        return this.v;
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream
    public void processBuffer() {
        try {
            super.processBuffer();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException("Impossible IOException caught: " + e);
        }
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream
    public void processLine(java.lang.String str) {
        processLine(str, this.v);
    }

    public void processLine(java.lang.String str, int i) {
        this.u.log(str, i);
    }
}
