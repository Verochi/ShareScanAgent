package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class Loader implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
    public final java.util.concurrent.ExecutorService a;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> b;

    @androidx.annotation.Nullable
    public java.io.IOException c;
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction RETRY = createRetryAction(false, -9223372036854775807L);
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, -9223372036854775807L);
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction DONT_RETRY = new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(2, -9223372036854775807L, null);
    public static final com.google.android.exoplayer2.upstream.Loader.LoadErrorAction DONT_RETRY_FATAL = new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(3, -9223372036854775807L, null);

    public interface Callback<T extends com.google.android.exoplayer2.upstream.Loader.Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(T t, long j, long j2, java.io.IOException iOException, int i);
    }

    public static final class LoadErrorAction {
        public final int a;
        public final long b;

        public LoadErrorAction(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public /* synthetic */ LoadErrorAction(int i, long j, com.google.android.exoplayer2.upstream.Loader.AnonymousClass1 anonymousClass1) {
            this(i, j);
        }

        public boolean isRetry() {
            int i = this.a;
            return i == 0 || i == 1;
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public final class LoadTask<T extends com.google.android.exoplayer2.upstream.Loader.Loadable> extends android.os.Handler implements java.lang.Runnable {
        public volatile boolean A;
        public final int n;
        public final T t;
        public final long u;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.Loader.Callback<T> v;

        @androidx.annotation.Nullable
        public java.io.IOException w;
        public int x;

        @androidx.annotation.Nullable
        public java.lang.Thread y;
        public boolean z;

        public LoadTask(android.os.Looper looper, T t, com.google.android.exoplayer2.upstream.Loader.Callback<T> callback, int i, long j) {
            super(looper);
            this.t = t;
            this.v = callback;
            this.n = i;
            this.u = j;
        }

        public void a(boolean z) {
            this.A = z;
            this.w = null;
            if (hasMessages(0)) {
                this.z = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.z = true;
                    this.t.cancelLoad();
                    java.lang.Thread thread = this.y;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                c();
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                ((com.google.android.exoplayer2.upstream.Loader.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.v)).onLoadCanceled(this.t, elapsedRealtime, elapsedRealtime - this.u, true);
                this.v = null;
            }
        }

        public final void b() {
            this.w = null;
            com.google.android.exoplayer2.upstream.Loader.this.a.execute((java.lang.Runnable) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.upstream.Loader.this.b));
        }

        public final void c() {
            com.google.android.exoplayer2.upstream.Loader.this.b = null;
        }

        public final long d() {
            return java.lang.Math.min((this.x - 1) * 1000, 5000);
        }

        public void e(int i) throws java.io.IOException {
            java.io.IOException iOException = this.w;
            if (iOException != null && this.x > i) {
                throw iOException;
            }
        }

        public void f(long j) {
            com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.upstream.Loader.this.b == null);
            com.google.android.exoplayer2.upstream.Loader.this.b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (this.A) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                b();
                return;
            }
            if (i == 3) {
                throw ((java.lang.Error) message.obj);
            }
            c();
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.u;
            com.google.android.exoplayer2.upstream.Loader.Callback callback = (com.google.android.exoplayer2.upstream.Loader.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.v);
            if (this.z) {
                callback.onLoadCanceled(this.t, elapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    callback.onLoadCompleted(this.t, elapsedRealtime, j);
                    return;
                } catch (java.lang.RuntimeException e) {
                    com.google.android.exoplayer2.util.Log.e("LoadTask", "Unexpected exception handling load completed", e);
                    com.google.android.exoplayer2.upstream.Loader.this.c = new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            java.io.IOException iOException = (java.io.IOException) message.obj;
            this.w = iOException;
            int i3 = this.x + 1;
            this.x = i3;
            com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError = callback.onLoadError(this.t, elapsedRealtime, j, iOException, i3);
            if (onLoadError.a == 3) {
                com.google.android.exoplayer2.upstream.Loader.this.c = this.w;
            } else if (onLoadError.a != 2) {
                if (onLoadError.a == 1) {
                    this.x = 1;
                }
                f(onLoadError.b != -9223372036854775807L ? onLoadError.b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.z;
                    this.y = java.lang.Thread.currentThread();
                }
                if (z) {
                    java.lang.String simpleName = this.t.getClass().getSimpleName();
                    com.google.android.exoplayer2.util.TraceUtil.beginSection(simpleName.length() != 0 ? "load:".concat(simpleName) : new java.lang.String("load:"));
                    try {
                        this.t.load();
                        com.google.android.exoplayer2.util.TraceUtil.endSection();
                    } catch (java.lang.Throwable th) {
                        com.google.android.exoplayer2.util.TraceUtil.endSection();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.y = null;
                    java.lang.Thread.interrupted();
                }
                if (this.A) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (java.io.IOException e) {
                if (this.A) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (java.lang.Error e2) {
                com.google.android.exoplayer2.util.Log.e("LoadTask", "Unexpected error loading stream", e2);
                if (!this.A) {
                    obtainMessage(3, e2).sendToTarget();
                }
                throw e2;
            } catch (java.lang.Exception e3) {
                com.google.android.exoplayer2.util.Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (this.A) {
                    return;
                }
                obtainMessage(2, new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e3)).sendToTarget();
            } catch (java.lang.OutOfMemoryError e4) {
                com.google.android.exoplayer2.util.Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (this.A) {
                    return;
                }
                obtainMessage(2, new com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws java.io.IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class ReleaseTask implements java.lang.Runnable {
        public final com.google.android.exoplayer2.upstream.Loader.ReleaseCallback n;

        public ReleaseTask(com.google.android.exoplayer2.upstream.Loader.ReleaseCallback releaseCallback) {
            this.n = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.n.onLoaderReleased();
        }
    }

    public static final class UnexpectedLoaderException extends java.io.IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UnexpectedLoaderException(java.lang.Throwable th) {
            super(r3.toString(), th);
            java.lang.String simpleName = th.getClass().getSimpleName();
            java.lang.String message = th.getMessage();
            java.lang.StringBuilder sb = new java.lang.StringBuilder(simpleName.length() + 13 + java.lang.String.valueOf(message).length());
            sb.append("Unexpected ");
            sb.append(simpleName);
            sb.append(": ");
            sb.append(message);
        }
    }

    public Loader(java.lang.String str) {
        this.a = com.google.android.exoplayer2.util.Util.newSingleThreadExecutor(str);
    }

    public static com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction(boolean z, long j) {
        return new com.google.android.exoplayer2.upstream.Loader.LoadErrorAction(z ? 1 : 0, j, null);
    }

    public void cancelLoading() {
        ((com.google.android.exoplayer2.upstream.Loader.LoadTask) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b)).a(false);
    }

    public void clearFatalError() {
        this.c = null;
    }

    public boolean hasFatalError() {
        return this.c != null;
    }

    public boolean isLoading() {
        return this.b != null;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws java.io.IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) throws java.io.IOException {
        java.io.IOException iOException = this.c;
        if (iOException != null) {
            throw iOException;
        }
        com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> loadTask = this.b;
        if (loadTask != null) {
            if (i == Integer.MIN_VALUE) {
                i = loadTask.n;
            }
            loadTask.e(i);
        }
    }

    public void release() {
        release(null);
    }

    public void release(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.Loader.ReleaseCallback releaseCallback) {
        com.google.android.exoplayer2.upstream.Loader.LoadTask<? extends com.google.android.exoplayer2.upstream.Loader.Loadable> loadTask = this.b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        if (releaseCallback != null) {
            this.a.execute(new com.google.android.exoplayer2.upstream.Loader.ReleaseTask(releaseCallback));
        }
        this.a.shutdown();
    }

    public <T extends com.google.android.exoplayer2.upstream.Loader.Loadable> long startLoading(T t, com.google.android.exoplayer2.upstream.Loader.Callback<T> callback, int i) {
        android.os.Looper looper = (android.os.Looper) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(android.os.Looper.myLooper());
        this.c = null;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        new com.google.android.exoplayer2.upstream.Loader.LoadTask(looper, t, callback, i, elapsedRealtime).f(0L);
        return elapsedRealtime;
    }
}
