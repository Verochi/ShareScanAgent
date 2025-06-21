package com.google.common.util.concurrent;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class SimpleTimeLimiter implements com.google.common.util.concurrent.TimeLimiter {
    public final java.util.concurrent.ExecutorService a;

    /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.reflect.InvocationHandler {
        public final /* synthetic */ java.lang.Object n;
        public final /* synthetic */ long t;
        public final /* synthetic */ java.util.concurrent.TimeUnit u;
        public final /* synthetic */ java.util.Set v;

        /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1$1, reason: invalid class name and collision with other inner class name */
        public class CallableC03551 implements java.util.concurrent.Callable<java.lang.Object> {
            public final /* synthetic */ java.lang.reflect.Method n;
            public final /* synthetic */ java.lang.Object[] t;

            public CallableC03551(java.lang.reflect.Method method, java.lang.Object[] objArr) {
                this.n = method;
                this.t = objArr;
            }

            @Override // java.util.concurrent.Callable
            public java.lang.Object call() throws java.lang.Exception {
                try {
                    return this.n.invoke(com.google.common.util.concurrent.SimpleTimeLimiter.AnonymousClass1.this.n, this.t);
                } catch (java.lang.reflect.InvocationTargetException e) {
                    throw com.google.common.util.concurrent.SimpleTimeLimiter.h(e, false);
                }
            }
        }

        public AnonymousClass1(java.lang.Object obj, long j, java.util.concurrent.TimeUnit timeUnit, java.util.Set set) {
            this.n = obj;
            this.t = j;
            this.u = timeUnit;
            this.v = set;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            return com.google.common.util.concurrent.SimpleTimeLimiter.this.c(new com.google.common.util.concurrent.SimpleTimeLimiter.AnonymousClass1.CallableC03551(method, objArr), this.t, this.u, this.v.contains(method));
        }
    }

    public SimpleTimeLimiter(java.util.concurrent.ExecutorService executorService) {
        this.a = (java.util.concurrent.ExecutorService) com.google.common.base.Preconditions.checkNotNull(executorService);
    }

    public static com.google.common.util.concurrent.SimpleTimeLimiter create(java.util.concurrent.ExecutorService executorService) {
        return new com.google.common.util.concurrent.SimpleTimeLimiter(executorService);
    }

    public static void d(long j) {
        com.google.common.base.Preconditions.checkArgument(j > 0, "timeout must be positive: %s", j);
    }

    public static boolean e(java.lang.reflect.Method method) {
        for (java.lang.Class<?> cls : method.getExceptionTypes()) {
            if (cls == java.lang.InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    public static java.util.Set<java.lang.reflect.Method> f(java.lang.Class<?> cls) {
        java.util.HashSet newHashSet = com.google.common.collect.Sets.newHashSet();
        for (java.lang.reflect.Method method : cls.getMethods()) {
            if (e(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    public static <T> T g(java.lang.Class<T> cls, java.lang.reflect.InvocationHandler invocationHandler) {
        return cls.cast(java.lang.reflect.Proxy.newProxyInstance(cls.getClassLoader(), new java.lang.Class[]{cls}, invocationHandler));
    }

    public static java.lang.Exception h(java.lang.Exception exc, boolean z) throws java.lang.Exception {
        java.lang.Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z) {
            cause.setStackTrace((java.lang.StackTraceElement[]) com.google.common.collect.ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), java.lang.StackTraceElement.class));
        }
        if (cause instanceof java.lang.Exception) {
            throw ((java.lang.Exception) cause);
        }
        if (cause instanceof java.lang.Error) {
            throw ((java.lang.Error) cause);
        }
        throw exc;
    }

    public final <T> T c(java.util.concurrent.Callable<T> callable, long j, java.util.concurrent.TimeUnit timeUnit, boolean z) throws java.lang.Exception {
        com.google.common.base.Preconditions.checkNotNull(callable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        java.util.concurrent.Future<T> submit = this.a.submit(callable);
        try {
            if (!z) {
                return (T) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
            }
            try {
                return submit.get(j, timeUnit);
            } catch (java.lang.InterruptedException e) {
                submit.cancel(true);
                throw e;
            }
        } catch (java.util.concurrent.ExecutionException e2) {
            throw h(e2, true);
        } catch (java.util.concurrent.TimeoutException e3) {
            submit.cancel(true);
            throw new com.google.common.util.concurrent.UncheckedTimeoutException(e3);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(java.util.concurrent.Callable<T> callable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkNotNull(callable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        java.util.concurrent.Future<T> submit = this.a.submit(callable);
        try {
            return (T) com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (java.util.concurrent.ExecutionException e) {
            i(e.getCause());
            throw new java.lang.AssertionError();
        } catch (java.util.concurrent.TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <T> T callWithTimeout(java.util.concurrent.Callable<T> callable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        com.google.common.base.Preconditions.checkNotNull(callable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        java.util.concurrent.Future<T> submit = this.a.submit(callable);
        try {
            return submit.get(j, timeUnit);
        } catch (java.lang.InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (java.util.concurrent.ExecutionException e2) {
            i(e2.getCause());
            throw new java.lang.AssertionError();
        } catch (java.util.concurrent.TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }

    public final void i(java.lang.Throwable th) throws java.util.concurrent.ExecutionException {
        if (th instanceof java.lang.Error) {
            throw new com.google.common.util.concurrent.ExecutionError((java.lang.Error) th);
        }
        if (!(th instanceof java.lang.RuntimeException)) {
            throw new java.util.concurrent.ExecutionException(th);
        }
        throw new com.google.common.util.concurrent.UncheckedExecutionException(th);
    }

    public final void j(java.lang.Throwable th) {
        if (!(th instanceof java.lang.Error)) {
            throw new com.google.common.util.concurrent.UncheckedExecutionException(th);
        }
        throw new com.google.common.util.concurrent.ExecutionError((java.lang.Error) th);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t, java.lang.Class<T> cls, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.google.common.base.Preconditions.checkNotNull(t);
        com.google.common.base.Preconditions.checkNotNull(cls);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        com.google.common.base.Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        return (T) g(cls, new com.google.common.util.concurrent.SimpleTimeLimiter.AnonymousClass1(t, j, timeUnit, f(cls)));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException {
        com.google.common.base.Preconditions.checkNotNull(runnable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        java.util.concurrent.Future<?> submit = this.a.submit(runnable);
        try {
            com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (java.util.concurrent.ExecutionException e) {
            j(e.getCause());
            throw new java.lang.AssertionError();
        } catch (java.util.concurrent.TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.TimeoutException, java.lang.InterruptedException {
        com.google.common.base.Preconditions.checkNotNull(runnable);
        com.google.common.base.Preconditions.checkNotNull(timeUnit);
        d(j);
        java.util.concurrent.Future<?> submit = this.a.submit(runnable);
        try {
            submit.get(j, timeUnit);
        } catch (java.lang.InterruptedException e) {
            e = e;
            submit.cancel(true);
            throw e;
        } catch (java.util.concurrent.ExecutionException e2) {
            j(e2.getCause());
            throw new java.lang.AssertionError();
        } catch (java.util.concurrent.TimeoutException e3) {
            e = e3;
            submit.cancel(true);
            throw e;
        }
    }
}
