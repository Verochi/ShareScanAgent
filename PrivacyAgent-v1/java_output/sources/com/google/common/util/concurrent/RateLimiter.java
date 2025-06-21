package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public abstract class RateLimiter {
    public final com.google.common.util.concurrent.RateLimiter.SleepingStopwatch a;

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public volatile java.lang.Object b;

    public static abstract class SleepingStopwatch {

        /* renamed from: com.google.common.util.concurrent.RateLimiter$SleepingStopwatch$1, reason: invalid class name */
        public static class AnonymousClass1 extends com.google.common.util.concurrent.RateLimiter.SleepingStopwatch {
            public final com.google.common.base.Stopwatch a = com.google.common.base.Stopwatch.createStarted();

            @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
            public long b() {
                return this.a.elapsed(java.util.concurrent.TimeUnit.MICROSECONDS);
            }

            @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
            public void c(long j) {
                if (j > 0) {
                    com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly(j, java.util.concurrent.TimeUnit.MICROSECONDS);
                }
            }
        }

        public static com.google.common.util.concurrent.RateLimiter.SleepingStopwatch a() {
            return new com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.AnonymousClass1();
        }

        public abstract long b();

        public abstract void c(long j);
    }

    public RateLimiter(com.google.common.util.concurrent.RateLimiter.SleepingStopwatch sleepingStopwatch) {
        this.a = (com.google.common.util.concurrent.RateLimiter.SleepingStopwatch) com.google.common.base.Preconditions.checkNotNull(sleepingStopwatch);
    }

    public static void b(int i) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "Requested permits (%s) must be positive", i);
    }

    @com.google.common.annotations.VisibleForTesting
    public static com.google.common.util.concurrent.RateLimiter c(double d, long j, java.util.concurrent.TimeUnit timeUnit, double d2, com.google.common.util.concurrent.RateLimiter.SleepingStopwatch sleepingStopwatch) {
        com.google.common.util.concurrent.SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new com.google.common.util.concurrent.SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j, timeUnit, d2);
        smoothWarmingUp.setRate(d);
        return smoothWarmingUp;
    }

    public static com.google.common.util.concurrent.RateLimiter create(double d) {
        return d(d, com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.a());
    }

    public static com.google.common.util.concurrent.RateLimiter create(double d, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkArgument(j >= 0, "warmupPeriod must not be negative: %s", j);
        return c(d, j, timeUnit, 3.0d, com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.a());
    }

    @com.google.common.annotations.VisibleForTesting
    public static com.google.common.util.concurrent.RateLimiter d(double d, com.google.common.util.concurrent.RateLimiter.SleepingStopwatch sleepingStopwatch) {
        com.google.common.util.concurrent.SmoothRateLimiter.SmoothBursty smoothBursty = new com.google.common.util.concurrent.SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d);
        return smoothBursty;
    }

    public final boolean a(long j, long j2) {
        return h(j) - j2 <= j;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public double acquire(int i) {
        long i2 = i(i);
        this.a.c(i2);
        return (i2 * 1.0d) / java.util.concurrent.TimeUnit.SECONDS.toMicros(1L);
    }

    public abstract double e();

    public abstract void f(double d, long j);

    public final java.lang.Object g() {
        java.lang.Object obj = this.b;
        if (obj == null) {
            synchronized (this) {
                obj = this.b;
                if (obj == null) {
                    obj = new java.lang.Object();
                    this.b = obj;
                }
            }
        }
        return obj;
    }

    public final double getRate() {
        double e;
        synchronized (g()) {
            e = e();
        }
        return e;
    }

    public abstract long h(long j);

    public final long i(int i) {
        long j;
        b(i);
        synchronized (g()) {
            j = j(i, this.a.b());
        }
        return j;
    }

    public final long j(int i, long j) {
        return java.lang.Math.max(k(i, j) - j, 0L);
    }

    public abstract long k(int i, long j);

    public final void setRate(double d) {
        com.google.common.base.Preconditions.checkArgument(d > 0.0d && !java.lang.Double.isNaN(d), "rate must be positive");
        synchronized (g()) {
            f(d, this.a.b());
        }
    }

    public java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", java.lang.Double.valueOf(getRate()));
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i) {
        return tryAcquire(i, 0L, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, java.util.concurrent.TimeUnit timeUnit) {
        long max = java.lang.Math.max(timeUnit.toMicros(j), 0L);
        b(i);
        synchronized (g()) {
            long b = this.a.b();
            if (!a(b, max)) {
                return false;
            }
            this.a.c(j(i, b));
            return true;
        }
    }

    public boolean tryAcquire(long j, java.util.concurrent.TimeUnit timeUnit) {
        return tryAcquire(1, j, timeUnit);
    }
}
