package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class PumpStreamHandler implements org.apache.tools.ant.taskdefs.ExecuteStreamHandler {
    public java.lang.Thread n;
    public java.lang.Thread t;
    public java.lang.Thread u;
    public java.io.OutputStream v;
    public java.io.OutputStream w;
    public java.io.InputStream x;
    public final boolean y;

    public static class ThreadWithPumper extends java.lang.Thread {
        public final org.apache.tools.ant.taskdefs.StreamPumper n;

        public ThreadWithPumper(org.apache.tools.ant.taskdefs.StreamPumper streamPumper) {
            super(streamPumper);
            this.n = streamPumper;
        }

        public org.apache.tools.ant.taskdefs.StreamPumper getPumper() {
            return this.n;
        }
    }

    public PumpStreamHandler() {
        this(java.lang.System.out, java.lang.System.err);
    }

    public PumpStreamHandler(java.io.OutputStream outputStream) {
        this(outputStream, outputStream);
    }

    public PumpStreamHandler(java.io.OutputStream outputStream, java.io.OutputStream outputStream2) {
        this(outputStream, outputStream2, null);
    }

    public PumpStreamHandler(java.io.OutputStream outputStream, java.io.OutputStream outputStream2, java.io.InputStream inputStream) {
        this(outputStream, outputStream2, inputStream, false);
    }

    public PumpStreamHandler(java.io.OutputStream outputStream, java.io.OutputStream outputStream2, java.io.InputStream inputStream, boolean z) {
        if (outputStream == null) {
            throw new java.lang.NullPointerException("out must not be null");
        }
        if (outputStream2 == null) {
            throw new java.lang.NullPointerException("err must not be null");
        }
        this.v = outputStream;
        this.w = outputStream2;
        this.x = inputStream;
        this.y = z;
    }

    public final void a(java.lang.Thread thread) {
        if (thread != null) {
            thread.start();
        }
    }

    public void createProcessErrorPump(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        this.t = createPump(inputStream, outputStream);
    }

    public void createProcessOutputPump(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        this.n = createPump(inputStream, outputStream);
    }

    public java.lang.Thread createPump(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        return createPump(inputStream, outputStream, false);
    }

    public java.lang.Thread createPump(java.io.InputStream inputStream, java.io.OutputStream outputStream, boolean z) {
        return createPump(inputStream, outputStream, z, true);
    }

    public java.lang.Thread createPump(java.io.InputStream inputStream, java.io.OutputStream outputStream, boolean z, boolean z2) {
        org.apache.tools.ant.taskdefs.StreamPumper streamPumper = new org.apache.tools.ant.taskdefs.StreamPumper(inputStream, outputStream, z, z2);
        streamPumper.b(true);
        org.apache.tools.ant.taskdefs.PumpStreamHandler.ThreadWithPumper threadWithPumper = new org.apache.tools.ant.taskdefs.PumpStreamHandler.ThreadWithPumper(streamPumper);
        threadWithPumper.setDaemon(true);
        return threadWithPumper;
    }

    public final void finish(java.lang.Thread thread) {
        if (thread == null) {
            return;
        }
        try {
            org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle postStopHandle = null;
            org.apache.tools.ant.taskdefs.StreamPumper pumper = thread instanceof org.apache.tools.ant.taskdefs.PumpStreamHandler.ThreadWithPumper ? ((org.apache.tools.ant.taskdefs.PumpStreamHandler.ThreadWithPumper) thread).getPumper() : null;
            if ((pumper != null && pumper.isFinished()) || !thread.isAlive()) {
                return;
            }
            if (pumper != null && !pumper.isFinished()) {
                postStopHandle = pumper.c();
            }
            if (postStopHandle != null && postStopHandle.d()) {
                postStopHandle.c(2L, java.util.concurrent.TimeUnit.SECONDS);
            }
            while (true) {
                if (pumper != null) {
                    if (pumper.isFinished()) {
                        return;
                    }
                }
                if (!thread.isAlive()) {
                    return;
                }
                thread.interrupt();
                thread.join(200L);
            }
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public java.io.OutputStream getErr() {
        return this.w;
    }

    public java.io.OutputStream getOut() {
        return this.v;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessErrorStream(java.io.InputStream inputStream) {
        createProcessErrorPump(inputStream, this.w);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessInputStream(java.io.OutputStream outputStream) {
        java.io.InputStream inputStream = this.x;
        if (inputStream != null) {
            this.u = createPump(inputStream, outputStream, true, this.y);
        } else {
            org.apache.tools.ant.util.FileUtils.close(outputStream);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void setProcessOutputStream(java.io.InputStream inputStream) {
        createProcessOutputPump(inputStream, this.v);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void start() {
        a(this.n);
        a(this.t);
        a(this.u);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteStreamHandler
    public void stop() {
        finish(this.u);
        try {
            this.w.flush();
        } catch (java.io.IOException unused) {
        }
        try {
            this.v.flush();
        } catch (java.io.IOException unused2) {
        }
        finish(this.n);
        finish(this.t);
    }
}
