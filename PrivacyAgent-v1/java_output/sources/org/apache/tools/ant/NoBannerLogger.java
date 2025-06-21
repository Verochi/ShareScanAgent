package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class NoBannerLogger extends org.apache.tools.ant.DefaultLogger {
    protected java.lang.String targetName;

    public java.lang.String extractTargetName(org.apache.tools.ant.BuildEvent buildEvent) {
        return buildEvent.getTarget().getName();
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
        if (buildEvent.getPriority() > this.msgOutputLevel || buildEvent.getMessage() == null || "".equals(buildEvent.getMessage().trim())) {
            return;
        }
        synchronized (this) {
            if (this.targetName != null) {
                this.out.println(org.apache.tools.ant.util.StringUtils.LINE_SEP + this.targetName + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                this.targetName = null;
            }
        }
        super.messageLogged(buildEvent);
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public synchronized void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        this.targetName = null;
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public synchronized void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        this.targetName = extractTargetName(buildEvent);
    }
}
