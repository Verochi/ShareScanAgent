package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class StreamPumper implements java.lang.Runnable {
    public boolean A;
    public final boolean B;
    public org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle C;
    public final java.io.InputStream n;
    public final java.io.OutputStream t;
    public volatile boolean u;
    public volatile boolean v;
    public final boolean w;
    public boolean x;
    public java.lang.Exception y;
    public int z;

    public final class PostStopHandle {
        public boolean a = true;
        public final java.util.concurrent.CountDownLatch b = new java.util.concurrent.CountDownLatch(1);

        public PostStopHandle() {
        }

        public boolean c(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return this.b.await(j, timeUnit);
        }

        public boolean d() {
            return this.a;
        }
    }

    public StreamPumper(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        this(inputStream, outputStream, false);
    }

    public StreamPumper(java.io.InputStream inputStream, java.io.OutputStream outputStream, boolean z) {
        this(inputStream, outputStream, z, false);
    }

    public StreamPumper(java.io.InputStream inputStream, java.io.OutputStream outputStream, boolean z, boolean z2) {
        this.x = false;
        this.y = null;
        this.z = 128;
        this.A = false;
        this.n = inputStream;
        this.t = outputStream;
        this.w = z;
        this.B = z2;
    }

    /* JADX WARN: Finally extract failed */
    public final void a() throws java.io.IOException {
        int read;
        try {
            int i = this.z;
            byte[] bArr = new byte[i];
            if (this.u) {
                while (true) {
                    int available = this.n.available();
                    if (available <= 0 || (read = this.n.read(bArr, 0, java.lang.Math.min(available, i))) <= 0) {
                        break;
                    } else {
                        this.t.write(bArr, 0, read);
                    }
                }
            }
            this.t.flush();
            org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle postStopHandle = this.C;
            if (postStopHandle != null) {
                postStopHandle.b.countDown();
                this.C.a = false;
            }
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle postStopHandle2 = this.C;
            if (postStopHandle2 != null) {
                postStopHandle2.b.countDown();
                this.C.a = false;
            }
            throw th;
        }
    }

    public void b(boolean z) {
        this.x = z;
    }

    public synchronized org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle c() {
        this.u = true;
        this.C = new org.apache.tools.ant.taskdefs.StreamPumper.PostStopHandle();
        notifyAll();
        return this.C;
    }

    public final void d(java.io.InputStream inputStream) throws java.io.IOException, java.lang.InterruptedException {
        if (this.B) {
            while (!this.u && inputStream.available() == 0) {
                if (java.lang.Thread.interrupted()) {
                    throw new java.lang.InterruptedException();
                }
                synchronized (this) {
                    wait(100L);
                }
            }
        }
    }

    public synchronized int getBufferSize() {
        return this.z;
    }

    public synchronized java.lang.Exception getException() {
        return this.y;
    }

    public boolean isFinished() {
        return this.v;
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        synchronized (this) {
            this.A = true;
        }
        this.v = false;
        byte[] bArr = new byte[this.z];
        while (!this.u && !java.lang.Thread.interrupted()) {
            try {
                try {
                    d(this.n);
                    if (this.u || java.lang.Thread.interrupted() || (read = this.n.read(bArr)) < 0) {
                        break;
                    }
                    if (read > 0) {
                        this.t.write(bArr, 0, read);
                        if (this.x) {
                            this.t.flush();
                        }
                    }
                } catch (java.lang.InterruptedException unused) {
                    if (this.w) {
                        org.apache.tools.ant.util.FileUtils.close(this.t);
                    }
                    this.v = true;
                    this.u = false;
                    synchronized (this) {
                        notifyAll();
                        return;
                    }
                } catch (java.lang.Exception e) {
                    synchronized (this) {
                        this.y = e;
                        if (this.w) {
                            org.apache.tools.ant.util.FileUtils.close(this.t);
                        }
                        this.v = true;
                        this.u = false;
                        synchronized (this) {
                            notifyAll();
                            return;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (this.w) {
                    org.apache.tools.ant.util.FileUtils.close(this.t);
                }
                this.v = true;
                this.u = false;
                synchronized (this) {
                    notifyAll();
                    throw th;
                }
            }
        }
        a();
        if (this.w) {
            org.apache.tools.ant.util.FileUtils.close(this.t);
        }
        this.v = true;
        this.u = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized void setBufferSize(int i) {
        if (this.A) {
            throw new java.lang.IllegalStateException("Cannot set buffer size on a running StreamPumper");
        }
        this.z = i;
    }

    public synchronized void waitFor() throws java.lang.InterruptedException {
        while (!isFinished()) {
            wait();
        }
    }
}
