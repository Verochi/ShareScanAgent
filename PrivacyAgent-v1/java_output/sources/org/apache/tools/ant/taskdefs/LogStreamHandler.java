package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class LogStreamHandler extends org.apache.tools.ant.taskdefs.PumpStreamHandler {
    public LogStreamHandler(org.apache.tools.ant.ProjectComponent projectComponent, int i, int i2) {
        super(new org.apache.tools.ant.taskdefs.LogOutputStream(projectComponent, i), new org.apache.tools.ant.taskdefs.LogOutputStream(projectComponent, i2));
    }

    public LogStreamHandler(org.apache.tools.ant.Task task, int i, int i2) {
        this((org.apache.tools.ant.ProjectComponent) task, i, i2);
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
