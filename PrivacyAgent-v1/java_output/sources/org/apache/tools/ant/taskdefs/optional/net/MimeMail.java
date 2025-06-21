package org.apache.tools.ant.taskdefs.optional.net;

/* loaded from: classes25.dex */
public class MimeMail extends org.apache.tools.ant.taskdefs.email.EmailTask {
    @Override // org.apache.tools.ant.taskdefs.email.EmailTask, org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        log("DEPRECATED - The " + getTaskName() + " task is deprecated. Use the mail task instead.");
        super.execute();
    }
}
