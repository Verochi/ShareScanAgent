package okhttp3;

/* loaded from: classes23.dex */
final class RealCall implements okhttp3.Call {
    public final okhttp3.OkHttpClient n;
    public okhttp3.internal.connection.Transmitter t;
    public final okhttp3.Request u;
    public final boolean v;
    public boolean w;

    public final class AsyncCall extends okhttp3.internal.NamedRunnable {
        public final okhttp3.Callback n;
        public volatile java.util.concurrent.atomic.AtomicInteger t;

        public AsyncCall(okhttp3.Callback callback) {
            super("OkHttp %s", okhttp3.RealCall.this.e());
            this.t = new java.util.concurrent.atomic.AtomicInteger(0);
            this.n = callback;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            java.lang.Throwable th;
            boolean z;
            java.io.IOException e;
            okhttp3.RealCall.this.t.timeoutEnter();
            try {
                try {
                    z = true;
                    try {
                        this.n.onResponse(okhttp3.RealCall.this, okhttp3.RealCall.this.c());
                    } catch (java.io.IOException e2) {
                        e = e2;
                        if (z) {
                            okhttp3.internal.platform.Platform.get().log(4, "Callback failure for " + okhttp3.RealCall.this.f(), e);
                        } else {
                            this.n.onFailure(okhttp3.RealCall.this, e);
                        }
                        okhttp3.RealCall.this.n.dispatcher().e(this);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        okhttp3.RealCall.this.cancel();
                        if (!z) {
                            java.io.IOException iOException = new java.io.IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.n.onFailure(okhttp3.RealCall.this, iOException);
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    okhttp3.RealCall.this.n.dispatcher().e(this);
                    throw th3;
                }
            } catch (java.io.IOException e3) {
                e = e3;
                z = false;
            } catch (java.lang.Throwable th4) {
                th = th4;
                z = false;
            }
            okhttp3.RealCall.this.n.dispatcher().e(this);
        }

        public java.util.concurrent.atomic.AtomicInteger k() {
            return this.t;
        }

        public void l(java.util.concurrent.ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (java.util.concurrent.RejectedExecutionException e) {
                    java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    okhttp3.RealCall.this.t.noMoreExchanges(interruptedIOException);
                    this.n.onFailure(okhttp3.RealCall.this, interruptedIOException);
                    okhttp3.RealCall.this.n.dispatcher().e(this);
                }
            } catch (java.lang.Throwable th) {
                okhttp3.RealCall.this.n.dispatcher().e(this);
                throw th;
            }
        }

        public okhttp3.RealCall m() {
            return okhttp3.RealCall.this;
        }

        public java.lang.String n() {
            return okhttp3.RealCall.this.u.url().host();
        }

        public void o(okhttp3.RealCall.AsyncCall asyncCall) {
            this.t = asyncCall.t;
        }
    }

    public RealCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request, boolean z) {
        this.n = okHttpClient;
        this.u = request;
        this.v = z;
    }

    public static okhttp3.RealCall d(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request, boolean z) {
        okhttp3.RealCall realCall = new okhttp3.RealCall(okHttpClient, request, z);
        realCall.t = new okhttp3.internal.connection.Transmitter(okHttpClient, realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public okhttp3.RealCall mo839clone() {
        return d(this.n, this.u, this.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public okhttp3.Response c() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.n.interceptors());
        arrayList.add(new okhttp3.internal.http.RetryAndFollowUpInterceptor(this.n));
        arrayList.add(new okhttp3.internal.http.BridgeInterceptor(this.n.cookieJar()));
        arrayList.add(new okhttp3.internal.cache.CacheInterceptor(this.n.a()));
        arrayList.add(new okhttp3.internal.connection.ConnectInterceptor(this.n));
        if (!this.v) {
            arrayList.addAll(this.n.networkInterceptors());
        }
        arrayList.add(new okhttp3.internal.http.CallServerInterceptor(this.v));
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = new okhttp3.internal.http.RealInterceptorChain(arrayList, this.t, null, 0, this.u, this, this.n.connectTimeoutMillis(), this.n.readTimeoutMillis(), this.n.writeTimeoutMillis());
        boolean z = false;
        try {
            okhttp3.Response proceed = realInterceptorChain.proceed(this.u);
            if (this.t.isCanceled()) {
                okhttp3.internal.Util.closeQuietly(proceed);
                throw new java.io.IOException("Canceled");
            }
            this.t.noMoreExchanges(null);
            return proceed;
        } catch (java.io.IOException e) {
            try {
                throw this.t.noMoreExchanges(e);
            } catch (java.lang.Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.t.noMoreExchanges(null);
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (!z) {
            }
            throw th;
        }
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.t.cancel();
    }

    public java.lang.String e() {
        return this.u.url().redact();
    }

    @Override // okhttp3.Call
    public void enqueue(okhttp3.Callback callback) {
        synchronized (this) {
            if (this.w) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.w = true;
        }
        this.t.callStart();
        this.n.dispatcher().a(new okhttp3.RealCall.AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public okhttp3.Response execute() throws java.io.IOException {
        synchronized (this) {
            if (this.w) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.w = true;
        }
        this.t.timeoutEnter();
        this.t.callStart();
        try {
            this.n.dispatcher().b(this);
            return c();
        } finally {
            this.n.dispatcher().f(this);
        }
    }

    public java.lang.String f() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.v ? "web socket" : androidx.core.app.NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.t.isCanceled();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.w;
    }

    @Override // okhttp3.Call
    public okhttp3.Request request() {
        return this.u;
    }

    @Override // okhttp3.Call
    public okio.Timeout timeout() {
        return this.t.timeout();
    }
}
