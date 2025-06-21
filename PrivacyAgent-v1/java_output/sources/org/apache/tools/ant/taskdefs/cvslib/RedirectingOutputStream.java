package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
class RedirectingOutputStream extends org.apache.tools.ant.util.LineOrientedOutputStream {
    public final org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser u;

    public RedirectingOutputStream(org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser changeLogParser) {
        this.u = changeLogParser;
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream
    public void processLine(java.lang.String str) {
        this.u.j(str);
    }
}
