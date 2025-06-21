package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class SilentLogger extends org.apache.tools.ant.DefaultLogger {
    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        if (buildEvent.getException() != null) {
            super.buildFinished(buildEvent);
        }
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
    }
}
