package org.apache.tools.ant.listener;

/* loaded from: classes25.dex */
public class ProfileLogger extends org.apache.tools.ant.DefaultLogger {
    public java.util.Map<java.lang.Object, java.util.Date> t = new java.util.concurrent.ConcurrentHashMap();

    public final void b(org.apache.tools.ant.BuildEvent buildEvent, java.util.Date date, java.lang.String str) {
        java.lang.String str2;
        java.util.Date date2 = new java.util.Date();
        if (date != null) {
            str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP + str + ": finished " + date2 + " (" + (date2.getTime() - date.getTime()) + "ms)";
        } else {
            str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP + str + ": finished " + date2 + " (unknown duration, start not detected)";
        }
        printMessage(str2, this.out, buildEvent.getPriority());
        log(str2);
    }

    public final void c(org.apache.tools.ant.BuildEvent buildEvent, java.util.Date date, java.lang.String str) {
        java.lang.String str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP + str + ": started " + date;
        printMessage(str2, this.out, buildEvent.getPriority());
        log(str2);
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent, this.t.remove(buildEvent.getTarget()), "Target " + buildEvent.getTarget().getName());
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        java.util.Date date = new java.util.Date();
        c(buildEvent, date, "Target " + buildEvent.getTarget().getName());
        this.t.put(buildEvent.getTarget(), date);
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        b(buildEvent, this.t.remove(buildEvent.getTask()), buildEvent.getTask().getTaskName());
    }

    @Override // org.apache.tools.ant.DefaultLogger, org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        java.lang.String taskName = buildEvent.getTask().getTaskName();
        java.util.Date date = new java.util.Date();
        c(buildEvent, date, taskName);
        this.t.put(buildEvent.getTask(), date);
    }
}
