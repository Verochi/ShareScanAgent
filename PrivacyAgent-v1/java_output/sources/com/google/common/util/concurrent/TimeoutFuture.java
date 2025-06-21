package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class TimeoutFuture<V> extends com.google.common.util.concurrent.FluentFuture.TrustedFuture<V> {

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.util.concurrent.ScheduledFuture<?> A;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public com.google.common.util.concurrent.ListenableFuture<V> z;

    public static final class Fire<V> implements java.lang.Runnable {

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.util.concurrent.TimeoutFuture<V> n;

        public Fire(com.google.common.util.concurrent.TimeoutFuture<V> timeoutFuture) {
            this.n = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture;
            com.google.common.util.concurrent.TimeoutFuture<V> timeoutFuture = this.n;
            if (timeoutFuture == null || (listenableFuture = timeoutFuture.z) == null) {
                return;
            }
            this.n = null;
            if (listenableFuture.isDone()) {
                timeoutFuture.setFuture(listenableFuture);
                return;
            }
            try {
                java.util.concurrent.ScheduledFuture scheduledFuture = timeoutFuture.A;
                java.lang.String str = "Timed out";
                if (scheduledFuture != null) {
                    long abs = java.lang.Math.abs(scheduledFuture.getDelay(java.util.concurrent.TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                timeoutFuture.A = null;
                timeoutFuture.setException(new com.google.common.util.concurrent.TimeoutFuture.TimeoutFutureException(str + ": " + listenableFuture, null));
            } finally {
                listenableFuture.cancel(true);
            }
        }
    }

    public static final class TimeoutFutureException extends java.util.concurrent.TimeoutException {
        private TimeoutFutureException(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ TimeoutFutureException(java.lang.String str, com.google.common.util.concurrent.TimeoutFuture.AnonymousClass1 anonymousClass1) {
            this(str);
        }

        @Override // java.lang.Throwable
        public synchronized java.lang.Throwable fillInStackTrace() {
            setStackTrace(new java.lang.StackTraceElement[0]);
            return this;
        }
    }

    public TimeoutFuture(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture) {
        this.z = (com.google.common.util.concurrent.ListenableFuture) com.google.common.base.Preconditions.checkNotNull(listenableFuture);
    }

    public static <V> com.google.common.util.concurrent.ListenableFuture<V> z(com.google.common.util.concurrent.ListenableFuture<V> listenableFuture, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        com.google.common.util.concurrent.TimeoutFuture timeoutFuture = new com.google.common.util.concurrent.TimeoutFuture(listenableFuture);
        com.google.common.util.concurrent.TimeoutFuture.Fire fire = new com.google.common.util.concurrent.TimeoutFuture.Fire(timeoutFuture);
        timeoutFuture.A = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, com.google.common.util.concurrent.MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        s(this.z);
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.A;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.z = null;
        this.A = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public java.lang.String pendingToString() {
        com.google.common.util.concurrent.ListenableFuture<V> listenableFuture = this.z;
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.A;
        if (listenableFuture == null) {
            return null;
        }
        java.lang.String str = "inputFuture=[" + listenableFuture + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(java.util.concurrent.TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
