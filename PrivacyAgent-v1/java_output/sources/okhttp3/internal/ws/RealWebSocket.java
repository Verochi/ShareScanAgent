package okhttp3.internal.ws;

/* loaded from: classes24.dex */
public final class RealWebSocket implements okhttp3.WebSocket, okhttp3.internal.ws.WebSocketReader.FrameCallback {
    public static final java.util.List<okhttp3.Protocol> x = java.util.Collections.singletonList(okhttp3.Protocol.HTTP_1_1);
    public final okhttp3.Request a;
    public final okhttp3.WebSocketListener b;
    public final java.util.Random c;
    public final long d;
    public final java.lang.String e;
    public okhttp3.Call f;
    public final java.lang.Runnable g;
    public okhttp3.internal.ws.WebSocketReader h;
    public okhttp3.internal.ws.WebSocketWriter i;
    public java.util.concurrent.ScheduledExecutorService j;
    public okhttp3.internal.ws.RealWebSocket.Streams k;
    public long n;
    public boolean o;
    public java.util.concurrent.ScheduledFuture<?> p;
    public java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f502s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public final java.util.ArrayDeque<okio.ByteString> l = new java.util.ArrayDeque<>();
    public final java.util.ArrayDeque<java.lang.Object> m = new java.util.ArrayDeque<>();
    public int q = -1;

    /* renamed from: okhttp3.internal.ws.RealWebSocket$1, reason: invalid class name */
    public class AnonymousClass1 implements okhttp3.Callback {
        public final /* synthetic */ okhttp3.Request n;

        public AnonymousClass1(okhttp3.Request request) {
            this.n = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            okhttp3.internal.ws.RealWebSocket.this.failWebSocket(iOException, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) {
            okhttp3.internal.connection.Exchange exchange = okhttp3.internal.Internal.instance.exchange(response);
            try {
                okhttp3.internal.ws.RealWebSocket.this.b(response, exchange);
                try {
                    okhttp3.internal.ws.RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + this.n.url().redact(), exchange.newWebSocketStreams());
                    okhttp3.internal.ws.RealWebSocket realWebSocket = okhttp3.internal.ws.RealWebSocket.this;
                    realWebSocket.b.onOpen(realWebSocket, response);
                    okhttp3.internal.ws.RealWebSocket.this.loopReader();
                } catch (java.lang.Exception e) {
                    okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e, null);
                }
            } catch (java.io.IOException e2) {
                if (exchange != null) {
                    exchange.webSocketUpgradeFailed();
                }
                okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e2, response);
                okhttp3.internal.Util.closeQuietly(response);
            }
        }
    }

    public final class CancelRunnable implements java.lang.Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            okhttp3.internal.ws.RealWebSocket.this.cancel();
        }
    }

    public static final class Close {
        public final int a;
        public final okio.ByteString b;
        public final long c;

        public Close(int i, okio.ByteString byteString, long j) {
            this.a = i;
            this.b = byteString;
            this.c = j;
        }
    }

    public static final class Message {
        public final int a;
        public final okio.ByteString b;

        public Message(int i, okio.ByteString byteString) {
            this.a = i;
            this.b = byteString;
        }
    }

    public final class PingRunnable implements java.lang.Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            okhttp3.internal.ws.RealWebSocket.this.h();
        }
    }

    public static abstract class Streams implements java.io.Closeable {
        public final boolean client;
        public final okio.BufferedSink sink;
        public final okio.BufferedSource source;

        public Streams(boolean z, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener, java.util.Random random, long j) {
        if (!"GET".equals(request.method())) {
            throw new java.lang.IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.a = request;
        this.b = webSocketListener;
        this.c = random;
        this.d = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.e = okio.ByteString.of(bArr).base64();
        this.g = new defpackage.ka2(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        do {
            try {
            } catch (java.io.IOException e) {
                failWebSocket(e, null);
                return;
            }
        } while (g());
    }

    public void b(okhttp3.Response response, @javax.annotation.Nullable okhttp3.internal.connection.Exchange exchange) throws java.io.IOException {
        if (response.code() != 101) {
            throw new java.net.ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        java.lang.String header = response.header(com.google.common.net.HttpHeaders.CONNECTION);
        if (!com.google.common.net.HttpHeaders.UPGRADE.equalsIgnoreCase(header)) {
            throw new java.net.ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        java.lang.String header2 = response.header(com.google.common.net.HttpHeaders.UPGRADE);
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new java.net.ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
        }
        java.lang.String header3 = response.header("Sec-WebSocket-Accept");
        java.lang.String base64 = okio.ByteString.encodeUtf8(this.e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(header3)) {
            if (exchange == null) {
                throw new java.net.ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new java.net.ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
    }

    public synchronized boolean c(int i, java.lang.String str, long j) {
        okio.ByteString byteString;
        okhttp3.internal.ws.WebSocketProtocol.c(i);
        if (str != null) {
            byteString = okio.ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new java.lang.IllegalArgumentException("reason.size() > 123: " + str);
            }
        } else {
            byteString = null;
        }
        if (!this.f502s && !this.o) {
            this.o = true;
            this.m.add(new okhttp3.internal.ws.RealWebSocket.Close(i, byteString, j));
            e();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.f.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, java.lang.String str) {
        return c(i, str, 60000L);
    }

    public void connect(okhttp3.OkHttpClient okHttpClient) {
        okhttp3.OkHttpClient build = okHttpClient.newBuilder().eventListener(okhttp3.EventListener.NONE).protocols(x).build();
        okhttp3.Request build2 = this.a.newBuilder().header(com.google.common.net.HttpHeaders.UPGRADE, "websocket").header(com.google.common.net.HttpHeaders.CONNECTION, com.google.common.net.HttpHeaders.UPGRADE).header("Sec-WebSocket-Key", this.e).header("Sec-WebSocket-Version", "13").build();
        okhttp3.Call newWebSocketCall = okhttp3.internal.Internal.instance.newWebSocketCall(build, build2);
        this.f = newWebSocketCall;
        newWebSocketCall.enqueue(new okhttp3.internal.ws.RealWebSocket.AnonymousClass1(build2));
    }

    public final void e() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.g);
        }
    }

    public final synchronized boolean f(okio.ByteString byteString, int i) {
        if (!this.f502s && !this.o) {
            if (this.n + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.n += byteString.size();
            this.m.add(new okhttp3.internal.ws.RealWebSocket.Message(i, byteString));
            e();
            return true;
        }
        return false;
    }

    public void failWebSocket(java.lang.Exception exc, @javax.annotation.Nullable okhttp3.Response response) {
        synchronized (this) {
            if (this.f502s) {
                return;
            }
            this.f502s = true;
            okhttp3.internal.ws.RealWebSocket.Streams streams = this.k;
            this.k = null;
            java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.p;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.b.onFailure(this, exc, response);
            } finally {
                okhttp3.internal.Util.closeQuietly(streams);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[Catch: all -> 0x00a8, TRY_ENTER, TryCatch #1 {all -> 0x00a8, blocks: (B:19:0x0055, B:22:0x0059, B:24:0x005d, B:25:0x0079, B:33:0x0088, B:34:0x0089, B:36:0x008d, B:38:0x0098, B:39:0x00a2, B:40:0x00a7, B:27:0x007a, B:28:0x0084), top: B:17:0x0053, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:19:0x0055, B:22:0x0059, B:24:0x005d, B:25:0x0079, B:33:0x0088, B:34:0x0089, B:36:0x008d, B:38:0x0098, B:39:0x00a2, B:40:0x00a7, B:27:0x007a, B:28:0x0084), top: B:17:0x0053, inners: #0 }] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g() throws java.io.IOException {
        okhttp3.internal.ws.RealWebSocket.Streams streams;
        java.lang.String str;
        int i;
        okhttp3.internal.ws.RealWebSocket.Message message;
        synchronized (this) {
            if (this.f502s) {
                return false;
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.i;
            okio.ByteString poll = this.l.poll();
            java.lang.Object obj = null;
            try {
                if (poll == null) {
                    java.lang.Object poll2 = this.m.poll();
                    if (poll2 instanceof okhttp3.internal.ws.RealWebSocket.Close) {
                        i = this.q;
                        str = this.r;
                        if (i != -1) {
                            streams = this.k;
                            this.k = null;
                            this.j.shutdown();
                        } else {
                            this.p = this.j.schedule(new okhttp3.internal.ws.RealWebSocket.CancelRunnable(), ((okhttp3.internal.ws.RealWebSocket.Close) poll2).c, java.util.concurrent.TimeUnit.MILLISECONDS);
                            streams = null;
                        }
                        message = poll2;
                        if (poll == null) {
                            webSocketWriter.f(poll);
                        } else if (message instanceof okhttp3.internal.ws.RealWebSocket.Message) {
                            okio.ByteString byteString = message.b;
                            okio.BufferedSink buffer = okio.Okio.buffer(webSocketWriter.a(message.a, byteString.size()));
                            buffer.write(byteString);
                            buffer.close();
                            synchronized (this) {
                                this.n -= byteString.size();
                            }
                        } else {
                            if (!(message instanceof okhttp3.internal.ws.RealWebSocket.Close)) {
                                throw new java.lang.AssertionError();
                            }
                            okhttp3.internal.ws.RealWebSocket.Close close = (okhttp3.internal.ws.RealWebSocket.Close) message;
                            webSocketWriter.b(close.a, close.b);
                            if (streams != null) {
                                this.b.onClosed(this, i, str);
                            }
                        }
                        okhttp3.internal.Util.closeQuietly(streams);
                        return true;
                    }
                    if (poll2 == null) {
                        return false;
                    }
                    streams = null;
                    str = null;
                    obj = poll2;
                } else {
                    streams = null;
                    str = null;
                }
                if (poll == null) {
                }
                okhttp3.internal.Util.closeQuietly(streams);
                return true;
            } catch (java.lang.Throwable th) {
                okhttp3.internal.Util.closeQuietly(streams);
                throw th;
            }
            i = -1;
            message = obj;
        }
    }

    public void h() {
        synchronized (this) {
            if (this.f502s) {
                return;
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.i;
            int i = this.w ? this.t : -1;
            this.t++;
            this.w = true;
            if (i == -1) {
                try {
                    webSocketWriter.e(okio.ByteString.EMPTY);
                    return;
                } catch (java.io.IOException e) {
                    failWebSocket(e, null);
                    return;
                }
            }
            failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    public void initReaderAndWriter(java.lang.String str, okhttp3.internal.ws.RealWebSocket.Streams streams) throws java.io.IOException {
        synchronized (this) {
            this.k = streams;
            this.i = new okhttp3.internal.ws.WebSocketWriter(streams.client, streams.sink, this.c);
            java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, okhttp3.internal.Util.threadFactory(str, false));
            this.j = scheduledThreadPoolExecutor;
            if (this.d != 0) {
                okhttp3.internal.ws.RealWebSocket.PingRunnable pingRunnable = new okhttp3.internal.ws.RealWebSocket.PingRunnable();
                long j = this.d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            if (!this.m.isEmpty()) {
                e();
            }
        }
        this.h = new okhttp3.internal.ws.WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws java.io.IOException {
        while (this.q == -1) {
            this.h.a();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, java.lang.String str) {
        okhttp3.internal.ws.RealWebSocket.Streams streams;
        if (i == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        synchronized (this) {
            if (this.q != -1) {
                throw new java.lang.IllegalStateException("already closed");
            }
            this.q = i;
            this.r = str;
            streams = null;
            if (this.o && this.m.isEmpty()) {
                okhttp3.internal.ws.RealWebSocket.Streams streams2 = this.k;
                this.k = null;
                java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.j.shutdown();
                streams = streams2;
            }
        }
        try {
            this.b.onClosing(this, i, str);
            if (streams != null) {
                this.b.onClosed(this, i, str);
            }
        } finally {
            okhttp3.internal.Util.closeQuietly(streams);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(java.lang.String str) throws java.io.IOException {
        this.b.onMessage(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(okio.ByteString byteString) throws java.io.IOException {
        this.b.onMessage(this, byteString);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(okio.ByteString byteString) {
        if (!this.f502s && (!this.o || !this.m.isEmpty())) {
            this.l.add(byteString);
            e();
            this.u++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(okio.ByteString byteString) {
        this.v++;
        this.w = false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.n;
    }

    @Override // okhttp3.WebSocket
    public okhttp3.Request request() {
        return this.a;
    }

    @Override // okhttp3.WebSocket
    public boolean send(java.lang.String str) {
        if (str != null) {
            return f(okio.ByteString.encodeUtf8(str), 1);
        }
        throw new java.lang.NullPointerException("text == null");
    }

    @Override // okhttp3.WebSocket
    public boolean send(okio.ByteString byteString) {
        if (byteString != null) {
            return f(byteString, 2);
        }
        throw new java.lang.NullPointerException("bytes == null");
    }
}
