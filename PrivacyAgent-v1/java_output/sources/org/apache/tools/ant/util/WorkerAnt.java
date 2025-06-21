package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class WorkerAnt extends java.lang.Thread {
    public static final java.lang.String ERROR_NO_TASK = "No task defined";
    public org.apache.tools.ant.Task n;
    public java.lang.Object t;
    public volatile boolean u;
    public volatile org.apache.tools.ant.BuildException v;
    public volatile java.lang.Throwable w;

    public WorkerAnt(org.apache.tools.ant.Task task) {
        this(task, null);
    }

    public WorkerAnt(org.apache.tools.ant.Task task, java.lang.Object obj) {
        this.u = false;
        this.n = task;
        this.t = obj == null ? this : obj;
    }

    public final synchronized void a(java.lang.Throwable th) {
        this.w = th;
        this.v = th instanceof org.apache.tools.ant.BuildException ? (org.apache.tools.ant.BuildException) th : new org.apache.tools.ant.BuildException(th);
    }

    public synchronized org.apache.tools.ant.BuildException getBuildException() {
        return this.v;
    }

    public synchronized java.lang.Throwable getException() {
        return this.w;
    }

    public org.apache.tools.ant.Task getTask() {
        return this.n;
    }

    public synchronized boolean isFinished() {
        return this.u;
    }

    public void rethrowAnyBuildException() {
        org.apache.tools.ant.BuildException buildException = getBuildException();
        if (buildException != null) {
            throw buildException;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            org.apache.tools.ant.Task task = this.n;
            if (task != null) {
                task.execute();
            }
            synchronized (this.t) {
                this.u = true;
                this.t.notifyAll();
            }
        } catch (java.lang.Throwable th) {
            try {
                a(th);
                synchronized (this.t) {
                    this.u = true;
                    this.t.notifyAll();
                }
            } catch (java.lang.Throwable th2) {
                synchronized (this.t) {
                    this.u = true;
                    this.t.notifyAll();
                    throw th2;
                }
            }
        }
    }

    public void waitUntilFinished(long j) throws java.lang.InterruptedException {
        long currentTimeMillis = java.lang.System.currentTimeMillis() + j;
        synchronized (this.t) {
            for (long currentTimeMillis2 = java.lang.System.currentTimeMillis(); !this.u && currentTimeMillis2 < currentTimeMillis; currentTimeMillis2 = java.lang.System.currentTimeMillis()) {
                this.t.wait(currentTimeMillis - currentTimeMillis2);
            }
        }
    }
}
