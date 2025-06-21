package org.apache.tools.ant.taskdefs;

@java.lang.Deprecated
/* loaded from: classes25.dex */
public class TaskOutputStream extends java.io.OutputStream {
    public org.apache.tools.ant.Task n;
    public java.lang.StringBuffer t;
    public int u;

    public final void a() {
        this.n.log(this.t.toString(), this.u);
        this.t = new java.lang.StringBuffer();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        char c = (char) i;
        if (c != '\r' && c != '\n') {
            this.t.append(c);
        } else if (this.t.length() > 0) {
            a();
        }
    }
}
