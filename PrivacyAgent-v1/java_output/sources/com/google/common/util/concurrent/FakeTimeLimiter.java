package com.google.common.util.concurrent;

@com.google.errorprone.annotations.CanIgnoreReturnValue
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class FakeTimeLimiter implements com.google.common.util.concurrent.TimeLimiter {
    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(java.util.concurrent.Callable<T> callable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException {
        return (T) callWithTimeout(callable, j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(java.util.concurrent.Callable<T> callable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkNotNull(callable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (java.lang.Error e) {
            throw new com.google.common.util.concurrent.ExecutionError(e);
        } catch (java.lang.RuntimeException e2) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(e2);
        } catch (java.lang.Exception e3) {
            throw new java.util.concurrent.ExecutionException(e3);
        } catch (java.lang.Throwable th) {
            throw new java.util.concurrent.ExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t, java.lang.Class<T> cls, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkNotNull(t);
        com.google.common.base.Preconditions.checkNotNull(cls);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        return t;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        runWithTimeout(runnable, j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkNotNull(runnable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (java.lang.Error e) {
            throw new com.google.common.util.concurrent.ExecutionError(e);
        } catch (java.lang.RuntimeException e2) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(e2);
        } catch (java.lang.Throwable th) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(th);
        }
    }
}
