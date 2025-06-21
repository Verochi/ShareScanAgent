package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
class RedirectingStreamHandler extends org.apache.tools.ant.taskdefs.PumpStreamHandler {
    public RedirectingStreamHandler(org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser changeLogParser) {
        super(new org.apache.tools.ant.taskdefs.cvslib.RedirectingOutputStream(changeLogParser), new java.io.ByteArrayOutputStream());
    }

    public java.lang.String b() {
        try {
            return ((java.io.ByteArrayOutputStream) getErr()).toString("ASCII");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.PumpStreamHandler, org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void stop() {
        super.stop();
        try {
            getErr().close();
            getOut().close();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }
}
