package okhttp3.internal.cache2;

/* loaded from: classes23.dex */
final class Relay {
    public static final okio.ByteString k = okio.ByteString.encodeUtf8("OkHttp cache v1\n");
    public static final okio.ByteString l = okio.ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    public java.io.RandomAccessFile a;
    public java.lang.Thread b;
    public okio.Source c;
    public final okio.Buffer d;
    public long e;
    public boolean f;
    public final okio.ByteString g;
    public final okio.Buffer h;
    public final long i;
    public int j;

    public class RelaySource implements okio.Source {
        public final okio.Timeout n;
        public okhttp3.internal.cache2.FileOperator t;
        public long u;
        public final /* synthetic */ okhttp3.internal.cache2.Relay v;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t == null) {
                return;
            }
            java.io.RandomAccessFile randomAccessFile = null;
            this.t = null;
            synchronized (this.v) {
                okhttp3.internal.cache2.Relay relay = this.v;
                int i = relay.j - 1;
                relay.j = i;
                if (i == 0) {
                    java.io.RandomAccessFile randomAccessFile2 = relay.a;
                    relay.a = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                okhttp3.internal.Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
        
            if (r0 != 2) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            r2 = java.lang.Math.min(r23, r7 - r21.u);
            r21.t.a(r21.u + 32, r22, r2);
            r21.u += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        
            r0 = r21.v;
            r12 = r0.c.read(r0.d, r0.i);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        
            if (r12 != (-1)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        
            r21.v.a(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
        
            r2 = r21.v;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        
            r0 = r21.v;
            r0.b = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
        
            r2 = java.lang.Math.min(r12, r23);
            r21.v.d.copyTo(r22, 0, r2);
            r21.u += r2;
            r21.t.b(r7 + 32, r21.v.d.clone(), r12);
            r4 = r21.v;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ac, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
        
            r0 = r21.v;
            r0.h.write(r0.d, r12);
            r7 = r21.v.h.size();
            r0 = r21.v;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c4, code lost:
        
            if (r7 <= r0.i) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
        
            r0 = r0.h;
            r0.skip(r0.size() - r21.v.i);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
        
            r5 = r21.v;
            r5.e += r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00dc, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        
            r0 = r21.v;
            r0.b = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00e4, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00e5, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ec, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ef, code lost:
        
            monitor-enter(r21.v);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f0, code lost:
        
            r3 = r21.v;
            r3.b = null;
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f8, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            char c;
            if (this.t == null) {
                throw new java.lang.IllegalStateException("closed");
            }
            synchronized (this.v) {
                while (true) {
                    long j2 = this.u;
                    okhttp3.internal.cache2.Relay relay = this.v;
                    long j3 = relay.e;
                    if (j2 != j3) {
                        long size = j3 - relay.h.size();
                        long j4 = this.u;
                        if (j4 >= size) {
                            long min = java.lang.Math.min(j, j3 - j4);
                            this.v.h.copyTo(buffer, this.u - size, min);
                            this.u += min;
                            return min;
                        }
                        c = 2;
                    } else if (!relay.f) {
                        if (relay.b == null) {
                            relay.b = java.lang.Thread.currentThread();
                            c = 1;
                            break;
                        }
                        this.n.waitUntilNotified(relay);
                    } else {
                        return -1L;
                    }
                }
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.n;
        }
    }

    public void a(long j) throws java.io.IOException {
        c(j);
        this.a.getChannel().force(false);
        b(k, j, this.g.size());
        this.a.getChannel().force(false);
        synchronized (this) {
            this.f = true;
        }
        okhttp3.internal.Util.closeQuietly(this.c);
        this.c = null;
    }

    public final void b(okio.ByteString byteString, long j, long j2) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new java.lang.IllegalArgumentException();
        }
        new okhttp3.internal.cache2.FileOperator(this.a.getChannel()).b(0L, buffer, 32L);
    }

    public final void c(long j) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        buffer.write(this.g);
        new okhttp3.internal.cache2.FileOperator(this.a.getChannel()).b(32 + j, buffer, this.g.size());
    }
}
