package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class SendEmail extends org.apache.tools.ant.taskdefs.email.EmailTask {
    @java.lang.Deprecated
    public void setMailport(java.lang.Integer num) {
        setMailport(num.intValue());
    }
}
