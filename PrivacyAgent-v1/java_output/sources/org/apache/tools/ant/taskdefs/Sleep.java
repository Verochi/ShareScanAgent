package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Sleep extends org.apache.tools.ant.Task {
    public boolean u = true;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int y = 0;

    public final long c() {
        return (((((this.w * 60) + this.x) * 60) + this.v) * 1000) + this.y;
    }

    public void doSleep(long j) {
        try {
            java.lang.Thread.sleep(j);
        } catch (java.lang.InterruptedException unused) {
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            validate();
            long c = c();
            log("sleeping for " + c + " milliseconds", 3);
            doSleep(c);
        } catch (java.lang.Exception e) {
            if (this.u) {
                throw new org.apache.tools.ant.BuildException(e);
            }
            log(e.toString(), 0);
        }
    }

    public void setFailOnError(boolean z) {
        this.u = z;
    }

    public void setHours(int i) {
        this.w = i;
    }

    public void setMilliseconds(int i) {
        this.y = i;
    }

    public void setMinutes(int i) {
        this.x = i;
    }

    public void setSeconds(int i) {
        this.v = i;
    }

    public void validate() throws org.apache.tools.ant.BuildException {
        if (c() < 0) {
            throw new org.apache.tools.ant.BuildException("Negative sleep periods are not supported");
        }
    }
}
