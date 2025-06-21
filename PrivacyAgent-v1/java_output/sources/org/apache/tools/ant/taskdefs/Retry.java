package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Retry extends org.apache.tools.ant.Task implements org.apache.tools.ant.TaskContainer {
    public org.apache.tools.ant.Task u;
    public int v = 1;
    public int w = 0;

    @Override // org.apache.tools.ant.TaskContainer
    public synchronized void addTask(org.apache.tools.ant.Task task) {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("The retry task container accepts a single nested task (which may be a sequential task container)");
        }
        this.u = task;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i <= this.v; i++) {
            try {
                this.u.perform();
                return;
            } catch (java.lang.Exception e) {
                stringBuffer.append(e.getMessage());
                if (i >= this.v) {
                    java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                    stringBuffer2.append("Task [");
                    stringBuffer2.append(this.u.getTaskName());
                    stringBuffer2.append("] failed after [");
                    stringBuffer2.append(this.v);
                    stringBuffer2.append("] attempts; giving up.");
                    java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
                    stringBuffer2.append(str);
                    stringBuffer2.append("Error messages:");
                    stringBuffer2.append(str);
                    stringBuffer2.append(stringBuffer);
                    throw new org.apache.tools.ant.BuildException(stringBuffer2.toString(), getLocation());
                }
                log(this.w > 0 ? "Attempt [" + i + "]: error occurred; retrying after " + this.w + " ms..." : "Attempt [" + i + "]: error occurred; retrying...", e, 2);
                stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
                int i2 = this.w;
                if (i2 > 0) {
                    try {
                        java.lang.Thread.sleep(i2);
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
            }
        }
    }

    public void setRetryCount(int i) {
        this.v = i;
    }

    public void setRetryDelay(int i) {
        if (i < 0) {
            throw new org.apache.tools.ant.BuildException("retryDelay must be a non-negative number");
        }
        this.w = i;
    }
}
