package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class OutputStreamFunneler {
    public static final long DEFAULT_TIMEOUT_MILLIS = 1000;
    public java.io.OutputStream a;
    public int b;
    public boolean c;
    public long d;

    public final class Funnel extends java.io.OutputStream {
        public boolean n;

        public Funnel() {
            this.n = false;
            synchronized (org.apache.tools.ant.util.OutputStreamFunneler.this) {
                org.apache.tools.ant.util.OutputStreamFunneler.a(org.apache.tools.ant.util.OutputStreamFunneler.this);
            }
        }

        public /* synthetic */ Funnel(org.apache.tools.ant.util.OutputStreamFunneler outputStreamFunneler, org.apache.tools.ant.util.OutputStreamFunneler.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            org.apache.tools.ant.util.OutputStreamFunneler.this.g(this);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws java.io.IOException {
            synchronized (org.apache.tools.ant.util.OutputStreamFunneler.this) {
                org.apache.tools.ant.util.OutputStreamFunneler.this.f();
                org.apache.tools.ant.util.OutputStreamFunneler.this.a.flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws java.io.IOException {
            synchronized (org.apache.tools.ant.util.OutputStreamFunneler.this) {
                org.apache.tools.ant.util.OutputStreamFunneler.this.f();
                org.apache.tools.ant.util.OutputStreamFunneler.this.a.write(i);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws java.io.IOException {
            synchronized (org.apache.tools.ant.util.OutputStreamFunneler.this) {
                org.apache.tools.ant.util.OutputStreamFunneler.this.f();
                org.apache.tools.ant.util.OutputStreamFunneler.this.a.write(bArr);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            synchronized (org.apache.tools.ant.util.OutputStreamFunneler.this) {
                org.apache.tools.ant.util.OutputStreamFunneler.this.f();
                org.apache.tools.ant.util.OutputStreamFunneler.this.a.write(bArr, i, i2);
            }
        }
    }

    public OutputStreamFunneler(java.io.OutputStream outputStream) {
        this(outputStream, 1000L);
    }

    public OutputStreamFunneler(java.io.OutputStream outputStream, long j) {
        this.b = 0;
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("OutputStreamFunneler.<init>:  out == null");
        }
        this.a = outputStream;
        this.c = false;
        setTimeout(j);
    }

    public static /* synthetic */ int a(org.apache.tools.ant.util.OutputStreamFunneler outputStreamFunneler) {
        int i = outputStreamFunneler.b + 1;
        outputStreamFunneler.b = i;
        return i;
    }

    public final synchronized void e() throws java.io.IOException {
        try {
            f();
            this.a.close();
        } finally {
            this.c = true;
        }
    }

    public final synchronized void f() throws java.io.IOException {
        if (this.c) {
            throw new java.io.IOException("The funneled OutputStream has been closed.");
        }
    }

    public final synchronized void g(org.apache.tools.ant.util.OutputStreamFunneler.Funnel funnel) throws java.io.IOException {
        if (!funnel.n) {
            try {
                if (this.d > 0) {
                    long currentTimeMillis = java.lang.System.currentTimeMillis() + this.d;
                    for (long currentTimeMillis2 = java.lang.System.currentTimeMillis(); currentTimeMillis2 < currentTimeMillis; currentTimeMillis2 = java.lang.System.currentTimeMillis()) {
                        try {
                            wait(currentTimeMillis - currentTimeMillis2);
                        } catch (java.lang.InterruptedException unused) {
                        }
                    }
                }
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    e();
                }
                funnel.n = true;
            } catch (java.lang.Throwable th) {
                funnel.n = true;
                throw th;
            }
        }
    }

    public synchronized java.io.OutputStream getFunnelInstance() throws java.io.IOException {
        f();
        try {
        } finally {
            notifyAll();
        }
        return new org.apache.tools.ant.util.OutputStreamFunneler.Funnel(this, null);
    }

    public synchronized void setTimeout(long j) {
        this.d = j;
    }
}
