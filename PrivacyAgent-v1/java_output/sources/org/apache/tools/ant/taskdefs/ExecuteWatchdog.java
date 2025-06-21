package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ExecuteWatchdog implements org.apache.tools.ant.util.TimeoutObserver {
    public java.lang.Process n;
    public volatile boolean t;
    public java.lang.Exception u;
    public volatile boolean v;
    public org.apache.tools.ant.util.Watchdog w;

    public ExecuteWatchdog(int i) {
        this(i);
    }

    public ExecuteWatchdog(long j) {
        this.t = false;
        this.u = null;
        this.v = false;
        org.apache.tools.ant.util.Watchdog watchdog = new org.apache.tools.ant.util.Watchdog(j);
        this.w = watchdog;
        watchdog.addTimeoutObserver(this);
    }

    public synchronized void checkException() throws org.apache.tools.ant.BuildException {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("Exception in ExecuteWatchdog.run: " + this.u.getMessage(), this.u);
        }
    }

    public synchronized void cleanUp() {
        this.t = false;
        this.n = null;
    }

    public boolean isWatching() {
        return this.t;
    }

    public boolean killedProcess() {
        return this.v;
    }

    public synchronized void start(java.lang.Process process) {
        try {
            if (process == null) {
                throw new java.lang.NullPointerException("process is null.");
            }
            if (this.n != null) {
                throw new java.lang.IllegalStateException("Already running.");
            }
            this.u = null;
            this.v = false;
            this.t = true;
            this.n = process;
            this.w.start();
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public synchronized void stop() {
        this.w.stop();
        cleanUp();
    }

    @Override // org.apache.tools.ant.util.TimeoutObserver
    public synchronized void timeoutOccured(org.apache.tools.ant.util.Watchdog watchdog) {
        try {
            try {
                try {
                    this.n.exitValue();
                } catch (java.lang.IllegalThreadStateException unused) {
                    if (this.t) {
                        this.v = true;
                        this.n.destroy();
                    }
                }
            } catch (java.lang.Exception e) {
                this.u = e;
            }
        } finally {
            cleanUp();
        }
    }
}
