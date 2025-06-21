package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class SimpleBigProjectLogger extends org.apache.tools.ant.NoBannerLogger {
    @Override // org.apache.tools.ant.NoBannerLogger
    public java.lang.String extractTargetName(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.String extractTargetName = super.extractTargetName(buildEvent);
        java.lang.String extractProjectName = extractProjectName(buildEvent);
        if (extractProjectName == null || extractTargetName == null) {
            return extractTargetName;
        }
        return extractProjectName + '.' + extractTargetName;
    }
}
