package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class BigProjectLogger extends org.apache.tools.ant.listener.SimpleBigProjectLogger implements org.apache.tools.ant.SubBuildListener {
    public static final java.lang.String FOOTER = "======================================================================";
    public static final java.lang.String HEADER = "======================================================================";
    public volatile boolean t = false;
    public final java.lang.Object u = new java.lang.Object();

    public final void b(org.apache.tools.ant.BuildEvent buildEvent) {
        if (this.t) {
            return;
        }
        synchronized (this.u) {
            if (!this.t) {
                this.t = true;
                subBuildStarted(buildEvent);
            }
        }
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent);
        subBuildFinished(buildEvent);
        super.buildFinished(buildEvent);
    }

    public java.lang.String extractNameOrDefault(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.String extractProjectName = extractProjectName(buildEvent);
        if (extractProjectName == null) {
            return "";
        }
        return kotlin.text.Typography.quote + extractProjectName + kotlin.text.Typography.quote;
    }

    @Override // org.apache.tools.ant.DefaultLogger
    public java.lang.String getBuildFailedMessage() {
        return super.getBuildFailedMessage() + org.apache.tools.ant.listener.TimestampedLogger.SPACER + getTimestamp();
    }

    @Override // org.apache.tools.ant.DefaultLogger
    public java.lang.String getBuildSuccessfulMessage() {
        return super.getBuildSuccessfulMessage() + org.apache.tools.ant.listener.TimestampedLogger.SPACER + getTimestamp();
    }

    public java.lang.String getFooter() {
        return "======================================================================";
    }

    public java.lang.String getHeader() {
        return "======================================================================";
    }

    @Override // org.apache.tools.ant.NoBannerLogger, org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent);
        super.messageLogged(buildEvent);
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.String extractNameOrDefault = extractNameOrDefault(buildEvent);
        java.lang.String str = buildEvent.getException() != null ? "failing " : "";
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        sb.append(str2);
        sb.append(getHeader());
        sb.append(str2);
        sb.append("Exiting ");
        sb.append(str);
        sb.append("project ");
        sb.append(extractNameOrDefault);
        sb.append(str2);
        sb.append(getFooter());
        printMessage(sb.toString(), this.out, buildEvent.getPriority());
    }

    @Override // org.apache.tools.ant.SubBuildListener
    public void subBuildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.String str;
        java.lang.String extractNameOrDefault = extractNameOrDefault(buildEvent);
        org.apache.tools.ant.Project project = buildEvent.getProject();
        java.io.File baseDir = project == null ? null : project.getBaseDir();
        if (baseDir == null) {
            str = "With no base directory";
        } else {
            str = "In " + baseDir.getAbsolutePath();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        sb.append(str2);
        sb.append(getHeader());
        sb.append(str2);
        sb.append("Entering project ");
        sb.append(extractNameOrDefault);
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append(getFooter());
        printMessage(sb.toString(), this.out, buildEvent.getPriority());
    }

    @Override // org.apache.tools.ant.NoBannerLogger, org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent);
        super.targetStarted(buildEvent);
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent);
        super.taskStarted(buildEvent);
    }
}
