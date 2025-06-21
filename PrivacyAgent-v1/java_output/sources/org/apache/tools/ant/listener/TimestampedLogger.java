package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class TimestampedLogger extends org.apache.tools.ant.DefaultLogger {
    public static final java.lang.String SPACER = " - at ";

    @Override // org.apache.tools.ant.DefaultLogger
    public java.lang.String getBuildFailedMessage() {
        return super.getBuildFailedMessage() + SPACER + getTimestamp();
    }

    @Override // org.apache.tools.ant.DefaultLogger
    public java.lang.String getBuildSuccessfulMessage() {
        return super.getBuildSuccessfulMessage() + SPACER + getTimestamp();
    }
}
