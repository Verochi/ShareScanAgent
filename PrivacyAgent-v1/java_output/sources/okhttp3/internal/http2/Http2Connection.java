package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Http2Connection implements java.io.Closeable {
    public static final java.util.concurrent.ExecutorService R = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), okhttp3.internal.Util.threadFactory("OkHttp Http2Connection", true));
    public final java.util.concurrent.ExecutorService A;
    public final okhttp3.internal.http2.PushObserver B;
    public long K;
    public final okhttp3.internal.http2.Settings M;
    public final java.net.Socket N;
    public final okhttp3.internal.http2.Http2Writer O;
    public final okhttp3.internal.http2.Http2Connection.ReaderRunnable P;
    public final java.util.Set<java.lang.Integer> Q;
    public final boolean n;
    public final okhttp3.internal.http2.Http2Connection.Listener t;
    public final java.lang.String v;
    public int w;
    public int x;
    public boolean y;
    public final java.util.concurrent.ScheduledExecutorService z;
    public final java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> u = new java.util.LinkedHashMap();
    public long C = 0;
    public long D = 0;
    public long E = 0;
    public long F = 0;
    public long G = 0;
    public long H = 0;
    public long I = 0;
    public long J = 0;
    public okhttp3.internal.http2.Settings L = new okhttp3.internal.http2.Settings();

    /* renamed from: okhttp3.internal.http2.Http2Connection$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ okhttp3.internal.http2.ErrorCode t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.lang.Object[] objArr, int i, okhttp3.internal.http2.ErrorCode errorCode) {
            super(str, objArr);
            this.n = i;
            this.t = errorCode;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            try {
                okhttp3.internal.http2.Http2Connection.this.D(this.n, this.t);
            } catch (java.io.IOException e) {
                okhttp3.internal.http2.Http2Connection.this.o(e);
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$2, reason: invalid class name */
    public class AnonymousClass2 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ long t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, java.lang.Object[] objArr, int i, long j) {
            super(str, objArr);
            this.n = i;
            this.t = j;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            try {
                okhttp3.internal.http2.Http2Connection.this.O.o(this.n, this.t);
            } catch (java.io.IOException e) {
                okhttp3.internal.http2.Http2Connection.this.o(e);
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$3, reason: invalid class name */
    public class AnonymousClass3 extends okhttp3.internal.NamedRunnable {
        public AnonymousClass3(java.lang.String str, java.lang.Object... objArr) {
            super(str, objArr);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            okhttp3.internal.http2.Http2Connection.this.C(false, 2, 0);
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$4, reason: invalid class name */
    public class AnonymousClass4 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ java.util.List t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.lang.String str, java.lang.Object[] objArr, int i, java.util.List list) {
            super(str, objArr);
            this.n = i;
            this.t = list;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            if (okhttp3.internal.http2.Http2Connection.this.B.onRequest(this.n, this.t)) {
                try {
                    okhttp3.internal.http2.Http2Connection.this.O.m(this.n, okhttp3.internal.http2.ErrorCode.CANCEL);
                    synchronized (okhttp3.internal.http2.Http2Connection.this) {
                        okhttp3.internal.http2.Http2Connection.this.Q.remove(java.lang.Integer.valueOf(this.n));
                    }
                } catch (java.io.IOException unused) {
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$5, reason: invalid class name */
    public class AnonymousClass5 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ java.util.List t;
        public final /* synthetic */ boolean u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(java.lang.String str, java.lang.Object[] objArr, int i, java.util.List list, boolean z) {
            super(str, objArr);
            this.n = i;
            this.t = list;
            this.u = z;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean onHeaders = okhttp3.internal.http2.Http2Connection.this.B.onHeaders(this.n, this.t, this.u);
            if (onHeaders) {
                try {
                    okhttp3.internal.http2.Http2Connection.this.O.m(this.n, okhttp3.internal.http2.ErrorCode.CANCEL);
                } catch (java.io.IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.u) {
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    okhttp3.internal.http2.Http2Connection.this.Q.remove(java.lang.Integer.valueOf(this.n));
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$6, reason: invalid class name */
    public class AnonymousClass6 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ okio.Buffer t;
        public final /* synthetic */ int u;
        public final /* synthetic */ boolean v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(java.lang.String str, java.lang.Object[] objArr, int i, okio.Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.n = i;
            this.t = buffer;
            this.u = i2;
            this.v = z;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            try {
                boolean onData = okhttp3.internal.http2.Http2Connection.this.B.onData(this.n, this.t, this.u, this.v);
                if (onData) {
                    okhttp3.internal.http2.Http2Connection.this.O.m(this.n, okhttp3.internal.http2.ErrorCode.CANCEL);
                }
                if (onData || this.v) {
                    synchronized (okhttp3.internal.http2.Http2Connection.this) {
                        okhttp3.internal.http2.Http2Connection.this.Q.remove(java.lang.Integer.valueOf(this.n));
                    }
                }
            } catch (java.io.IOException unused) {
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Connection$7, reason: invalid class name */
    public class AnonymousClass7 extends okhttp3.internal.NamedRunnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ okhttp3.internal.http2.ErrorCode t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(java.lang.String str, java.lang.Object[] objArr, int i, okhttp3.internal.http2.ErrorCode errorCode) {
            super(str, objArr);
            this.n = i;
            this.t = errorCode;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            okhttp3.internal.http2.Http2Connection.this.B.onReset(this.n, this.t);
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                okhttp3.internal.http2.Http2Connection.this.Q.remove(java.lang.Integer.valueOf(this.n));
            }
        }
    }

    public static class Builder {
        public java.net.Socket a;
        public java.lang.String b;
        public okio.BufferedSource c;
        public okio.BufferedSink d;
        public okhttp3.internal.http2.Http2Connection.Listener e = okhttp3.internal.http2.Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
        public okhttp3.internal.http2.PushObserver f = okhttp3.internal.http2.PushObserver.CANCEL;
        public boolean g;
        public int h;

        public Builder(boolean z) {
            this.g = z;
        }

        public okhttp3.internal.http2.Http2Connection build() {
            return new okhttp3.internal.http2.Http2Connection(this);
        }

        public okhttp3.internal.http2.Http2Connection.Builder listener(okhttp3.internal.http2.Http2Connection.Listener listener) {
            this.e = listener;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder pingIntervalMillis(int i) {
            this.h = i;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder pushObserver(okhttp3.internal.http2.PushObserver pushObserver) {
            this.f = pushObserver;
            return this;
        }

        public okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket) throws java.io.IOException {
            java.net.SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            return socket(socket, remoteSocketAddress instanceof java.net.InetSocketAddress ? ((java.net.InetSocketAddress) remoteSocketAddress).getHostName() : remoteSocketAddress.toString(), okio.Okio.buffer(okio.Okio.source(socket)), okio.Okio.buffer(okio.Okio.sink(socket)));
        }

        public okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket, java.lang.String str, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
            this.a = socket;
            this.b = str;
            this.c = bufferedSource;
            this.d = bufferedSink;
            return this;
        }
    }

    public final class IntervalPingRunnable extends okhttp3.internal.NamedRunnable {
        public IntervalPingRunnable() {
            super("OkHttp %s ping", okhttp3.internal.http2.Http2Connection.this.v);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                if (okhttp3.internal.http2.Http2Connection.this.D < okhttp3.internal.http2.Http2Connection.this.C) {
                    z = true;
                } else {
                    okhttp3.internal.http2.Http2Connection.e(okhttp3.internal.http2.Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                okhttp3.internal.http2.Http2Connection.this.o(null);
            } else {
                okhttp3.internal.http2.Http2Connection.this.C(false, 1, 0);
            }
        }
    }

    public static abstract class Listener {
        public static final okhttp3.internal.http2.Http2Connection.Listener REFUSE_INCOMING_STREAMS = new okhttp3.internal.http2.Http2Connection.Listener.AnonymousClass1();

        /* renamed from: okhttp3.internal.http2.Http2Connection$Listener$1, reason: invalid class name */
        public class AnonymousClass1 extends okhttp3.internal.http2.Http2Connection.Listener {
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
                http2Stream.close(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM, null);
            }
        }

        public void onSettings(okhttp3.internal.http2.Http2Connection http2Connection) {
        }

        public abstract void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException;
    }

    public final class PingRunnable extends okhttp3.internal.NamedRunnable {
        public final boolean n;
        public final int t;
        public final int u;

        public PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", okhttp3.internal.http2.Http2Connection.this.v, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            this.n = z;
            this.t = i;
            this.u = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            okhttp3.internal.http2.Http2Connection.this.C(this.n, this.t, this.u);
        }
    }

    public class ReaderRunnable extends okhttp3.internal.NamedRunnable implements okhttp3.internal.http2.Http2Reader.Handler {
        public final okhttp3.internal.http2.Http2Reader n;

        /* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$1, reason: invalid class name */
        public class AnonymousClass1 extends okhttp3.internal.NamedRunnable {
            public final /* synthetic */ okhttp3.internal.http2.Http2Stream n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.lang.String str, java.lang.Object[] objArr, okhttp3.internal.http2.Http2Stream http2Stream) {
                super(str, objArr);
                this.n = http2Stream;
            }

            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                try {
                    okhttp3.internal.http2.Http2Connection.this.t.onStream(this.n);
                } catch (java.io.IOException e) {
                    okhttp3.internal.platform.Platform.get().log(4, "Http2Connection.Listener failure for " + okhttp3.internal.http2.Http2Connection.this.v, e);
                    try {
                        this.n.close(okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR, e);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        }

        /* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$2, reason: invalid class name */
        public class AnonymousClass2 extends okhttp3.internal.NamedRunnable {
            public final /* synthetic */ boolean n;
            public final /* synthetic */ okhttp3.internal.http2.Settings t;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(java.lang.String str, java.lang.Object[] objArr, boolean z, okhttp3.internal.http2.Settings settings) {
                super(str, objArr);
                this.n = z;
                this.t = settings;
            }

            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                okhttp3.internal.http2.Http2Connection.ReaderRunnable.this.k(this.n, this.t);
            }
        }

        /* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$3, reason: invalid class name */
        public class AnonymousClass3 extends okhttp3.internal.NamedRunnable {
            public AnonymousClass3(java.lang.String str, java.lang.Object... objArr) {
                super(str, objArr);
            }

            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                okhttp3.internal.http2.Http2Connection http2Connection = okhttp3.internal.http2.Http2Connection.this;
                http2Connection.t.onSettings(http2Connection);
            }
        }

        public ReaderRunnable(okhttp3.internal.http2.Http2Reader http2Reader) {
            super("OkHttp %s", okhttp3.internal.http2.Http2Connection.this.v);
            this.n = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, int i2, java.util.List<okhttp3.internal.http2.Header> list) {
            okhttp3.internal.http2.Http2Connection.this.u(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void b(boolean z, int i, int i2) {
            if (!z) {
                try {
                    okhttp3.internal.http2.Http2Connection.this.z.execute(okhttp3.internal.http2.Http2Connection.this.new PingRunnable(true, i, i2));
                    return;
                } catch (java.util.concurrent.RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                try {
                    if (i == 1) {
                        okhttp3.internal.http2.Http2Connection.c(okhttp3.internal.http2.Http2Connection.this);
                    } else if (i == 2) {
                        okhttp3.internal.http2.Http2Connection.l(okhttp3.internal.http2.Http2Connection.this);
                    } else if (i == 3) {
                        okhttp3.internal.http2.Http2Connection.m(okhttp3.internal.http2.Http2Connection.this);
                        okhttp3.internal.http2.Http2Connection.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void c(int i, okhttp3.internal.http2.ErrorCode errorCode) {
            if (okhttp3.internal.http2.Http2Connection.this.w(i)) {
                okhttp3.internal.http2.Http2Connection.this.v(i, errorCode);
                return;
            }
            okhttp3.internal.http2.Http2Stream x = okhttp3.internal.http2.Http2Connection.this.x(i);
            if (x != null) {
                x.g(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void d(int i, okhttp3.internal.http2.ErrorCode errorCode, okio.ByteString byteString) {
            okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) okhttp3.internal.http2.Http2Connection.this.u.values().toArray(new okhttp3.internal.http2.Http2Stream[okhttp3.internal.http2.Http2Connection.this.u.size()]);
                okhttp3.internal.http2.Http2Connection.this.y = true;
            }
            for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.g(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                    okhttp3.internal.http2.Http2Connection.this.x(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void e(boolean z, okhttp3.internal.http2.Settings settings) {
            try {
                okhttp3.internal.http2.Http2Connection.this.z.execute(new okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass2("OkHttp %s ACK Settings", new java.lang.Object[]{okhttp3.internal.http2.Http2Connection.this.v}, z, settings));
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            okhttp3.internal.http2.ErrorCode errorCode;
            okhttp3.internal.http2.ErrorCode errorCode2 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            java.io.IOException e = null;
            try {
                try {
                    this.n.c(this);
                    while (this.n.b(false, this)) {
                    }
                    okhttp3.internal.http2.ErrorCode errorCode3 = okhttp3.internal.http2.ErrorCode.NO_ERROR;
                    try {
                        okhttp3.internal.http2.Http2Connection.this.n(errorCode3, okhttp3.internal.http2.ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        okhttp3.internal.http2.ErrorCode errorCode4 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
                        okhttp3.internal.http2.Http2Connection http2Connection = okhttp3.internal.http2.Http2Connection.this;
                        http2Connection.n(errorCode4, errorCode4, e);
                        errorCode = http2Connection;
                        errorCode2 = this.n;
                        okhttp3.internal.Util.closeQuietly((java.io.Closeable) errorCode2);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    okhttp3.internal.http2.Http2Connection.this.n(errorCode, errorCode2, e);
                    okhttp3.internal.Util.closeQuietly(this.n);
                    throw th;
                }
            } catch (java.io.IOException e3) {
                e = e3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                okhttp3.internal.http2.Http2Connection.this.n(errorCode, errorCode2, e);
                okhttp3.internal.Util.closeQuietly(this.n);
                throw th;
            }
            errorCode2 = this.n;
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) errorCode2);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void f(boolean z, int i, int i2, java.util.List<okhttp3.internal.http2.Header> list) {
            if (okhttp3.internal.http2.Http2Connection.this.w(i)) {
                okhttp3.internal.http2.Http2Connection.this.t(i, list, z);
                return;
            }
            synchronized (okhttp3.internal.http2.Http2Connection.this) {
                okhttp3.internal.http2.Http2Stream p = okhttp3.internal.http2.Http2Connection.this.p(i);
                if (p != null) {
                    p.f(okhttp3.internal.Util.toHeaders(list), z);
                    return;
                }
                if (okhttp3.internal.http2.Http2Connection.this.y) {
                    return;
                }
                okhttp3.internal.http2.Http2Connection http2Connection = okhttp3.internal.http2.Http2Connection.this;
                if (i <= http2Connection.w) {
                    return;
                }
                if (i % 2 == http2Connection.x % 2) {
                    return;
                }
                okhttp3.internal.http2.Http2Stream http2Stream = new okhttp3.internal.http2.Http2Stream(i, okhttp3.internal.http2.Http2Connection.this, false, z, okhttp3.internal.Util.toHeaders(list));
                okhttp3.internal.http2.Http2Connection http2Connection2 = okhttp3.internal.http2.Http2Connection.this;
                http2Connection2.w = i;
                http2Connection2.u.put(java.lang.Integer.valueOf(i), http2Stream);
                okhttp3.internal.http2.Http2Connection.R.execute(new okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass1("OkHttp %s stream %d", new java.lang.Object[]{okhttp3.internal.http2.Http2Connection.this.v, java.lang.Integer.valueOf(i)}, http2Stream));
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void g(int i, long j) {
            if (i == 0) {
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    okhttp3.internal.http2.Http2Connection http2Connection = okhttp3.internal.http2.Http2Connection.this;
                    http2Connection.K += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            okhttp3.internal.http2.Http2Stream p = okhttp3.internal.http2.Http2Connection.this.p(i);
            if (p != null) {
                synchronized (p) {
                    p.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void h() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void i(boolean z, int i, okio.BufferedSource bufferedSource, int i2) throws java.io.IOException {
            if (okhttp3.internal.http2.Http2Connection.this.w(i)) {
                okhttp3.internal.http2.Http2Connection.this.r(i, bufferedSource, i2, z);
                return;
            }
            okhttp3.internal.http2.Http2Stream p = okhttp3.internal.http2.Http2Connection.this.p(i);
            if (p == null) {
                okhttp3.internal.http2.Http2Connection.this.E(i, okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                okhttp3.internal.http2.Http2Connection.this.A(j);
                bufferedSource.skip(j);
                return;
            }
            p.e(bufferedSource, i2);
            if (z) {
                p.f(okhttp3.internal.Util.EMPTY_HEADERS, true);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void j(int i, int i2, int i3, boolean z) {
        }

        public void k(boolean z, okhttp3.internal.http2.Settings settings) {
            okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            long j;
            synchronized (okhttp3.internal.http2.Http2Connection.this.O) {
                synchronized (okhttp3.internal.http2.Http2Connection.this) {
                    int d = okhttp3.internal.http2.Http2Connection.this.M.d();
                    if (z) {
                        okhttp3.internal.http2.Http2Connection.this.M.a();
                    }
                    okhttp3.internal.http2.Http2Connection.this.M.h(settings);
                    int d2 = okhttp3.internal.http2.Http2Connection.this.M.d();
                    http2StreamArr = null;
                    if (d2 == -1 || d2 == d) {
                        j = 0;
                    } else {
                        j = d2 - d;
                        if (!okhttp3.internal.http2.Http2Connection.this.u.isEmpty()) {
                            http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) okhttp3.internal.http2.Http2Connection.this.u.values().toArray(new okhttp3.internal.http2.Http2Stream[okhttp3.internal.http2.Http2Connection.this.u.size()]);
                        }
                    }
                }
                try {
                    okhttp3.internal.http2.Http2Connection http2Connection = okhttp3.internal.http2.Http2Connection.this;
                    http2Connection.O.a(http2Connection.M);
                } catch (java.io.IOException e) {
                    okhttp3.internal.http2.Http2Connection.this.o(e);
                }
            }
            if (http2StreamArr != null) {
                for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.a(j);
                    }
                }
            }
            okhttp3.internal.http2.Http2Connection.R.execute(new okhttp3.internal.http2.Http2Connection.ReaderRunnable.AnonymousClass3("OkHttp %s settings", okhttp3.internal.http2.Http2Connection.this.v));
        }
    }

    public Http2Connection(okhttp3.internal.http2.Http2Connection.Builder builder) {
        okhttp3.internal.http2.Settings settings = new okhttp3.internal.http2.Settings();
        this.M = settings;
        this.Q = new java.util.LinkedHashSet();
        this.B = builder.f;
        boolean z = builder.g;
        this.n = z;
        this.t = builder.e;
        int i = z ? 1 : 2;
        this.x = i;
        if (z) {
            this.x = i + 2;
        }
        if (z) {
            this.L.i(7, 16777216);
        }
        java.lang.String str = builder.b;
        this.v = str;
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, okhttp3.internal.Util.threadFactory(okhttp3.internal.Util.format("OkHttp %s Writer", str), false));
        this.z = scheduledThreadPoolExecutor;
        if (builder.h != 0) {
            okhttp3.internal.http2.Http2Connection.IntervalPingRunnable intervalPingRunnable = new okhttp3.internal.http2.Http2Connection.IntervalPingRunnable();
            int i2 = builder.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i2, i2, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        this.A = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), okhttp3.internal.Util.threadFactory(okhttp3.internal.Util.format("OkHttp %s Push Observer", str), true));
        settings.i(7, 65535);
        settings.i(5, 16384);
        this.K = settings.d();
        this.N = builder.a;
        this.O = new okhttp3.internal.http2.Http2Writer(builder.d, z);
        this.P = new okhttp3.internal.http2.Http2Connection.ReaderRunnable(new okhttp3.internal.http2.Http2Reader(builder.c, z));
    }

    public static /* synthetic */ long c(okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.D;
        http2Connection.D = 1 + j;
        return j;
    }

    public static /* synthetic */ long e(okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.C;
        http2Connection.C = 1 + j;
        return j;
    }

    public static /* synthetic */ long l(okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.F;
        http2Connection.F = 1 + j;
        return j;
    }

    public static /* synthetic */ long m(okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.H;
        http2Connection.H = 1 + j;
        return j;
    }

    public synchronized void A(long j) {
        long j2 = this.J + j;
        this.J = j2;
        if (j2 >= this.L.d() / 2) {
            F(0, this.J);
            this.J = 0L;
        }
    }

    public void B(int i, boolean z, java.util.List<okhttp3.internal.http2.Header> list) throws java.io.IOException {
        this.O.h(z, i, list);
    }

    public void C(boolean z, int i, int i2) {
        try {
            this.O.k(z, i, i2);
        } catch (java.io.IOException e) {
            o(e);
        }
    }

    public void D(int i, okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        this.O.m(i, errorCode);
    }

    public void E(int i, okhttp3.internal.http2.ErrorCode errorCode) {
        try {
            this.z.execute(new okhttp3.internal.http2.Http2Connection.AnonymousClass1("OkHttp %s stream %d", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, errorCode));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    public void F(int i, long j) {
        try {
            this.z.execute(new okhttp3.internal.http2.Http2Connection.AnonymousClass2("OkHttp Window Update %s stream %d", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, j));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n(okhttp3.internal.http2.ErrorCode.NO_ERROR, okhttp3.internal.http2.ErrorCode.CANCEL, null);
    }

    public void flush() throws java.io.IOException {
        this.O.flush();
    }

    public synchronized boolean isHealthy(long j) {
        if (this.y) {
            return false;
        }
        if (this.F < this.E) {
            if (j >= this.I) {
                return false;
            }
        }
        return true;
    }

    public synchronized int maxConcurrentStreams() {
        return this.M.e(Integer.MAX_VALUE);
    }

    public void n(okhttp3.internal.http2.ErrorCode errorCode, okhttp3.internal.http2.ErrorCode errorCode2, @javax.annotation.Nullable java.io.IOException iOException) {
        okhttp3.internal.http2.Http2Stream[] http2StreamArr;
        try {
            shutdown(errorCode);
        } catch (java.io.IOException unused) {
        }
        synchronized (this) {
            if (this.u.isEmpty()) {
                http2StreamArr = null;
            } else {
                http2StreamArr = (okhttp3.internal.http2.Http2Stream[]) this.u.values().toArray(new okhttp3.internal.http2.Http2Stream[this.u.size()]);
                this.u.clear();
            }
        }
        if (http2StreamArr != null) {
            for (okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2, iOException);
                } catch (java.io.IOException unused2) {
                }
            }
        }
        try {
            this.O.close();
        } catch (java.io.IOException unused3) {
        }
        try {
            this.N.close();
        } catch (java.io.IOException unused4) {
        }
        this.z.shutdown();
        this.A.shutdown();
    }

    public okhttp3.internal.http2.Http2Stream newStream(java.util.List<okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        return q(0, list, z);
    }

    public final void o(@javax.annotation.Nullable java.io.IOException iOException) {
        okhttp3.internal.http2.ErrorCode errorCode = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
        n(errorCode, errorCode, iOException);
    }

    public synchronized int openStreamCount() {
        return this.u.size();
    }

    public synchronized okhttp3.internal.http2.Http2Stream p(int i) {
        return this.u.get(java.lang.Integer.valueOf(i));
    }

    public okhttp3.internal.http2.Http2Stream pushStream(int i, java.util.List<okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        if (this.n) {
            throw new java.lang.IllegalStateException("Client cannot push requests.");
        }
        return q(i, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final okhttp3.internal.http2.Http2Stream q(int i, java.util.List<okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        int i2;
        okhttp3.internal.http2.Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.O) {
            synchronized (this) {
                if (this.x > 1073741823) {
                    shutdown(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                }
                if (this.y) {
                    throw new okhttp3.internal.http2.ConnectionShutdownException();
                }
                i2 = this.x;
                this.x = i2 + 2;
                http2Stream = new okhttp3.internal.http2.Http2Stream(i2, this, z3, false, null);
                if (z && this.K != 0 && http2Stream.b != 0) {
                    z2 = false;
                    if (http2Stream.isOpen()) {
                        this.u.put(java.lang.Integer.valueOf(i2), http2Stream);
                    }
                }
                z2 = true;
                if (http2Stream.isOpen()) {
                }
            }
            if (i == 0) {
                this.O.h(z3, i2, list);
            } else {
                if (this.n) {
                    throw new java.lang.IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.O.l(i, i2, list);
            }
        }
        if (z2) {
            this.O.flush();
        }
        return http2Stream;
    }

    public void r(int i, okio.BufferedSource bufferedSource, int i2, boolean z) throws java.io.IOException {
        okio.Buffer buffer = new okio.Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            s(new okhttp3.internal.http2.Http2Connection.AnonymousClass6("OkHttp %s Push Data[%s]", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new java.io.IOException(buffer.size() + " != " + i2);
    }

    public final synchronized void s(okhttp3.internal.NamedRunnable namedRunnable) {
        if (!this.y) {
            this.A.execute(namedRunnable);
        }
    }

    public void setSettings(okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        synchronized (this.O) {
            synchronized (this) {
                if (this.y) {
                    throw new okhttp3.internal.http2.ConnectionShutdownException();
                }
                this.L.h(settings);
            }
            this.O.n(settings);
        }
    }

    public void shutdown(okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        synchronized (this.O) {
            synchronized (this) {
                if (this.y) {
                    return;
                }
                this.y = true;
                this.O.g(this.w, errorCode, okhttp3.internal.Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start() throws java.io.IOException {
        z(true);
    }

    public void t(int i, java.util.List<okhttp3.internal.http2.Header> list, boolean z) {
        try {
            s(new okhttp3.internal.http2.Http2Connection.AnonymousClass5("OkHttp %s Push Headers[%s]", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, list, z));
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    public void u(int i, java.util.List<okhttp3.internal.http2.Header> list) {
        synchronized (this) {
            if (this.Q.contains(java.lang.Integer.valueOf(i))) {
                E(i, okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.Q.add(java.lang.Integer.valueOf(i));
            try {
                s(new okhttp3.internal.http2.Http2Connection.AnonymousClass4("OkHttp %s Push Request[%s]", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, list));
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }
    }

    public void v(int i, okhttp3.internal.http2.ErrorCode errorCode) {
        s(new okhttp3.internal.http2.Http2Connection.AnonymousClass7("OkHttp %s Push Reset[%s]", new java.lang.Object[]{this.v, java.lang.Integer.valueOf(i)}, i, errorCode));
    }

    public boolean w(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.O.j());
        r6 = r3;
        r8.K -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeData(int i, boolean z, okio.Buffer buffer, long j) throws java.io.IOException {
        int min;
        long j2;
        if (j == 0) {
            this.O.d(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j3 = this.K;
                        if (j3 > 0) {
                            break;
                        } else {
                            if (!this.u.containsKey(java.lang.Integer.valueOf(i))) {
                                throw new java.io.IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                        throw new java.io.InterruptedIOException();
                    }
                }
            }
            j -= j2;
            this.O.d(z && j == 0, i, buffer, min);
        }
    }

    public synchronized okhttp3.internal.http2.Http2Stream x(int i) {
        okhttp3.internal.http2.Http2Stream remove;
        remove = this.u.remove(java.lang.Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void y() {
        synchronized (this) {
            long j = this.F;
            long j2 = this.E;
            if (j < j2) {
                return;
            }
            this.E = j2 + 1;
            this.I = java.lang.System.nanoTime() + 1000000000;
            try {
                this.z.execute(new okhttp3.internal.http2.Http2Connection.AnonymousClass3("OkHttp %s ping", this.v));
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }
    }

    public void z(boolean z) throws java.io.IOException {
        if (z) {
            this.O.c();
            this.O.n(this.L);
            if (this.L.d() != 65535) {
                this.O.o(0, r5 - 65535);
            }
        }
        new java.lang.Thread(this.P).start();
    }
}
