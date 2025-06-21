package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class Watchdog implements java.lang.Runnable {
    public static final java.lang.String ERROR_INVALID_TIMEOUT = "timeout less than 1.";
    public long t;
    public java.util.Vector n = new java.util.Vector(1);
    public volatile boolean u = false;

    public Watchdog(long j) {
        this.t = -1L;
        if (j < 1) {
            throw new java.lang.IllegalArgumentException(ERROR_INVALID_TIMEOUT);
        }
        this.t = j;
    }

    public void addTimeoutObserver(org.apache.tools.ant.util.TimeoutObserver timeoutObserver) {
        this.n.addElement(timeoutObserver);
    }

    public final void fireTimeoutOccured() {
        java.util.Enumeration elements = this.n.elements();
        while (elements.hasMoreElements()) {
            ((org.apache.tools.ant.util.TimeoutObserver) elements.nextElement()).timeoutOccured(this);
        }
    }

    public void removeTimeoutObserver(org.apache.tools.ant.util.TimeoutObserver timeoutObserver) {
        this.n.removeElement(timeoutObserver);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.t + currentTimeMillis;
        while (!this.u && j > currentTimeMillis) {
            try {
                wait(j - currentTimeMillis);
                currentTimeMillis = java.lang.System.currentTimeMillis();
            } catch (java.lang.InterruptedException unused) {
            }
        }
        if (!this.u) {
            fireTimeoutOccured();
        }
    }

    public synchronized void start() {
        this.u = false;
        java.lang.Thread thread = new java.lang.Thread(this, "WATCHDOG");
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void stop() {
        this.u = true;
        notifyAll();
    }
}
