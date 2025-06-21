package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Nice extends org.apache.tools.ant.Task {
    public java.lang.Integer u;
    public java.lang.String v;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.Thread currentThread = java.lang.Thread.currentThread();
        int priority = currentThread.getPriority();
        if (this.v != null) {
            getProject().setNewProperty(this.v, java.lang.Integer.toString(priority));
        }
        java.lang.Integer num = this.u;
        if (num == null || priority == num.intValue()) {
            return;
        }
        try {
            currentThread.setPriority(this.u.intValue());
        } catch (java.lang.IllegalArgumentException e) {
            throw new org.apache.tools.ant.BuildException("Priority out of range", e);
        } catch (java.lang.SecurityException unused) {
            log("Unable to set new priority -a security manager is in the way", 1);
        }
    }

    public void setCurrentPriority(java.lang.String str) {
        this.v = str;
    }

    public void setNewPriority(int i) {
        if (i < 1 || i > 10) {
            throw new org.apache.tools.ant.BuildException("The thread priority is out of the range 1-10");
        }
        this.u = new java.lang.Integer(i);
    }
}
