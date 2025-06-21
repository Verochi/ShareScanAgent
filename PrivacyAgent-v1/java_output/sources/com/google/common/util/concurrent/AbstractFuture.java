package com.google.common.util.concurrent;

@com.google.j2objc.annotations.ReflectionSupport(com.google.j2objc.annotations.ReflectionSupport.Level.FULL)
@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class AbstractFuture<V> extends com.google.common.util.concurrent.internal.InternalFutureFailureAccess implements com.google.common.util.concurrent.ListenableFuture<V> {
    public static final boolean v = java.lang.Boolean.parseBoolean(java.lang.System.getProperty("guava.concurrent.generate_cancellation_cause", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
    public static final java.util.logging.Logger w = java.util.logging.Logger.getLogger(com.google.common.util.concurrent.AbstractFuture.class.getName());
    public static final com.google.common.util.concurrent.AbstractFuture.AtomicHelper x;
    public static final java.lang.Object y;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public volatile java.lang.Object n;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public volatile com.google.common.util.concurrent.AbstractFuture.Listener t;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public volatile com.google.common.util.concurrent.AbstractFuture.Waiter u;

    public static abstract class AtomicHelper {
        public AtomicHelper() {
        }

        public /* synthetic */ AtomicHelper(com.google.common.util.concurrent.AbstractFuture.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract boolean a(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener listener, com.google.common.util.concurrent.AbstractFuture.Listener listener2);

        public abstract boolean b(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, java.lang.Object obj, java.lang.Object obj2);

        public abstract boolean c(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2);

        public abstract void d(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2);

        public abstract void e(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, java.lang.Thread thread);
    }

    public static final class Cancellation {
        public static final com.google.common.util.concurrent.AbstractFuture.Cancellation c;
        public static final com.google.common.util.concurrent.AbstractFuture.Cancellation d;
        public final boolean a;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public final java.lang.Throwable b;

        static {
            if (com.google.common.util.concurrent.AbstractFuture.v) {
                d = null;
                c = null;
            } else {
                d = new com.google.common.util.concurrent.AbstractFuture.Cancellation(false, null);
                c = new com.google.common.util.concurrent.AbstractFuture.Cancellation(true, null);
            }
        }

        public Cancellation(boolean z, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    public static final class Failure {
        public static final com.google.common.util.concurrent.AbstractFuture.Failure b = new com.google.common.util.concurrent.AbstractFuture.Failure(new com.google.common.util.concurrent.AbstractFuture.Failure.AnonymousClass1("Failure occurred while trying to finish a future."));
        public final java.lang.Throwable a;

        /* renamed from: com.google.common.util.concurrent.AbstractFuture$Failure$1, reason: invalid class name */
        public static class AnonymousClass1 extends java.lang.Throwable {
            public AnonymousClass1(java.lang.String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized java.lang.Throwable fillInStackTrace() {
                return this;
            }
        }

        public Failure(java.lang.Throwable th) {
            this.a = (java.lang.Throwable) com.google.common.base.Preconditions.checkNotNull(th);
        }
    }

    public static final class Listener {
        public static final com.google.common.util.concurrent.AbstractFuture.Listener d = new com.google.common.util.concurrent.AbstractFuture.Listener(null, null);
        public final java.lang.Runnable a;
        public final java.util.concurrent.Executor b;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public com.google.common.util.concurrent.AbstractFuture.Listener c;

        public Listener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    public static final class SafeAtomicHelper extends com.google.common.util.concurrent.AbstractFuture.AtomicHelper {
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture.Waiter, java.lang.Thread> a;
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture.Waiter, com.google.common.util.concurrent.AbstractFuture.Waiter> b;
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter> c;
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener> d;
        public final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, java.lang.Object> e;

        public SafeAtomicHelper(java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture.Waiter, java.lang.Thread> atomicReferenceFieldUpdater, java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture.Waiter, com.google.common.util.concurrent.AbstractFuture.Waiter> atomicReferenceFieldUpdater2, java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter> atomicReferenceFieldUpdater3, java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener> atomicReferenceFieldUpdater4, java.util.concurrent.atomic.AtomicReferenceFieldUpdater<com.google.common.util.concurrent.AbstractFuture, java.lang.Object> atomicReferenceFieldUpdater5) {
            super(null);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener listener, com.google.common.util.concurrent.AbstractFuture.Listener listener2) {
            return defpackage.q1.a(this.d, abstractFuture, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, java.lang.Object obj, java.lang.Object obj2) {
            return defpackage.q1.a(this.e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            return defpackage.q1.a(this.c, abstractFuture, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            this.b.lazySet(waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, java.lang.Thread thread) {
            this.a.lazySet(waiter, thread);
        }
    }

    public static final class SetFuture<V> implements java.lang.Runnable {
        public final com.google.common.util.concurrent.AbstractFuture<V> n;
        public final com.google.common.util.concurrent.ListenableFuture<? extends V> t;

        public SetFuture(com.google.common.util.concurrent.AbstractFuture<V> abstractFuture, com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture) {
            this.n = abstractFuture;
            this.t = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.n.n != this) {
                return;
            }
            if (com.google.common.util.concurrent.AbstractFuture.x.b(this.n, this, com.google.common.util.concurrent.AbstractFuture.q(this.t))) {
                com.google.common.util.concurrent.AbstractFuture.n(this.n);
            }
        }
    }

    public static final class SynchronizedHelper extends com.google.common.util.concurrent.AbstractFuture.AtomicHelper {
        public SynchronizedHelper() {
            super(null);
        }

        public /* synthetic */ SynchronizedHelper(com.google.common.util.concurrent.AbstractFuture.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener listener, com.google.common.util.concurrent.AbstractFuture.Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.t != listener) {
                    return false;
                }
                abstractFuture.t = listener2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, java.lang.Object obj, java.lang.Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.n != obj) {
                    return false;
                }
                abstractFuture.n = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.u != waiter) {
                    return false;
                }
                abstractFuture.u = waiter2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            waiter.b = waiter2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, java.lang.Thread thread) {
            waiter.a = thread;
        }
    }

    public interface Trusted<V> extends com.google.common.util.concurrent.ListenableFuture<V> {
    }

    public static abstract class TrustedFuture<V> extends com.google.common.util.concurrent.AbstractFuture<V> implements com.google.common.util.concurrent.AbstractFuture.Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        public final V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
            return (V) super.get(j, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    public static final class UnsafeAtomicHelper extends com.google.common.util.concurrent.AbstractFuture.AtomicHelper {
        public static final sun.misc.Unsafe a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;
        public static final long f;

        /* renamed from: com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1, reason: invalid class name */
        public static class AnonymousClass1 implements java.security.PrivilegedExceptionAction<sun.misc.Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public sun.misc.Unsafe run() throws java.lang.Exception {
                for (java.lang.reflect.Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    java.lang.Object obj = field.get(null);
                    if (sun.misc.Unsafe.class.isInstance(obj)) {
                        return (sun.misc.Unsafe) sun.misc.Unsafe.class.cast(obj);
                    }
                }
                throw new java.lang.NoSuchFieldError("the Unsafe");
            }
        }

        static {
            sun.misc.Unsafe unsafe;
            try {
                try {
                    unsafe = sun.misc.Unsafe.getUnsafe();
                } catch (java.security.PrivilegedActionException e2) {
                    throw new java.lang.RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (java.lang.SecurityException unused) {
                unsafe = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
            }
            try {
                c = unsafe.objectFieldOffset(com.google.common.util.concurrent.AbstractFuture.class.getDeclaredField(com.umeng.analytics.pro.bo.aN));
                b = unsafe.objectFieldOffset(com.google.common.util.concurrent.AbstractFuture.class.getDeclaredField("t"));
                d = unsafe.objectFieldOffset(com.google.common.util.concurrent.AbstractFuture.class.getDeclaredField(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT));
                e = unsafe.objectFieldOffset(com.google.common.util.concurrent.AbstractFuture.Waiter.class.getDeclaredField("a"));
                f = unsafe.objectFieldOffset(com.google.common.util.concurrent.AbstractFuture.Waiter.class.getDeclaredField("b"));
                a = unsafe;
            } catch (java.lang.Exception e3) {
                com.google.common.base.Throwables.throwIfUnchecked(e3);
                throw new java.lang.RuntimeException(e3);
            }
        }

        public UnsafeAtomicHelper() {
            super(null);
        }

        public /* synthetic */ UnsafeAtomicHelper(com.google.common.util.concurrent.AbstractFuture.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean a(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Listener listener, com.google.common.util.concurrent.AbstractFuture.Listener listener2) {
            return defpackage.r1.a(a, abstractFuture, b, listener, listener2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean b(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, java.lang.Object obj, java.lang.Object obj2) {
            return defpackage.r1.a(a, abstractFuture, d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public boolean c(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture, com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            return defpackage.r1.a(a, abstractFuture, c, waiter, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void d(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, com.google.common.util.concurrent.AbstractFuture.Waiter waiter2) {
            a.putObject(waiter, f, waiter2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.AtomicHelper
        public void e(com.google.common.util.concurrent.AbstractFuture.Waiter waiter, java.lang.Thread thread) {
            a.putObject(waiter, e, thread);
        }
    }

    public static final class Waiter {
        public static final com.google.common.util.concurrent.AbstractFuture.Waiter c = new com.google.common.util.concurrent.AbstractFuture.Waiter(false);

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public volatile java.lang.Thread a;

        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        public volatile com.google.common.util.concurrent.AbstractFuture.Waiter b;

        public Waiter() {
            com.google.common.util.concurrent.AbstractFuture.x.e(this, java.lang.Thread.currentThread());
        }

        public Waiter(boolean z) {
        }

        public void a(com.google.common.util.concurrent.AbstractFuture.Waiter waiter) {
            com.google.common.util.concurrent.AbstractFuture.x.d(this, waiter);
        }

        public void b() {
            java.lang.Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                java.util.concurrent.locks.LockSupport.unpark(thread);
            }
        }
    }

    static {
        com.google.common.util.concurrent.AbstractFuture.AtomicHelper synchronizedHelper;
        java.lang.Throwable th = null;
        try {
            synchronizedHelper = new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper(null);
            th = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            try {
                synchronizedHelper = new com.google.common.util.concurrent.AbstractFuture.SafeAtomicHelper(java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AbstractFuture.Waiter.class, java.lang.Thread.class, "a"), java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AbstractFuture.Waiter.class, com.google.common.util.concurrent.AbstractFuture.Waiter.class, "b"), java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AbstractFuture.class, com.google.common.util.concurrent.AbstractFuture.Waiter.class, com.umeng.analytics.pro.bo.aN), java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AbstractFuture.class, com.google.common.util.concurrent.AbstractFuture.Listener.class, "t"), java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(com.google.common.util.concurrent.AbstractFuture.class, java.lang.Object.class, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT));
            } catch (java.lang.Throwable th3) {
                synchronizedHelper = new com.google.common.util.concurrent.AbstractFuture.SynchronizedHelper(null);
                th = th3;
            }
        }
        x = synchronizedHelper;
        if (th != null) {
            java.util.logging.Logger logger = w;
            java.util.logging.Level level = java.util.logging.Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        y = new java.lang.Object();
    }

    public static java.util.concurrent.CancellationException l(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Throwable th) {
        java.util.concurrent.CancellationException cancellationException = new java.util.concurrent.CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void n(com.google.common.util.concurrent.AbstractFuture<?> abstractFuture) {
        com.google.common.util.concurrent.AbstractFuture.Listener listener = null;
        while (true) {
            abstractFuture.t();
            abstractFuture.afterDone();
            com.google.common.util.concurrent.AbstractFuture.Listener m = abstractFuture.m(listener);
            while (m != null) {
                listener = m.c;
                java.lang.Runnable runnable = m.a;
                if (runnable instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture) {
                    com.google.common.util.concurrent.AbstractFuture.SetFuture setFuture = (com.google.common.util.concurrent.AbstractFuture.SetFuture) runnable;
                    abstractFuture = setFuture.n;
                    if (abstractFuture.n == setFuture) {
                        if (x.b(abstractFuture, setFuture, q(setFuture.t))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    o(runnable, m.b);
                }
                m = listener;
            }
            return;
        }
    }

    public static void o(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        try {
            executor.execute(runnable);
        } catch (java.lang.RuntimeException e) {
            w.log(java.util.logging.Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (java.lang.Throwable) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.Object q(com.google.common.util.concurrent.ListenableFuture<?> listenableFuture) {
        java.lang.Throwable tryInternalFastPathGetFailure;
        if (listenableFuture instanceof com.google.common.util.concurrent.AbstractFuture.Trusted) {
            java.lang.Object obj = ((com.google.common.util.concurrent.AbstractFuture) listenableFuture).n;
            if (!(obj instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation)) {
                return obj;
            }
            com.google.common.util.concurrent.AbstractFuture.Cancellation cancellation = (com.google.common.util.concurrent.AbstractFuture.Cancellation) obj;
            return cancellation.a ? cancellation.b != null ? new com.google.common.util.concurrent.AbstractFuture.Cancellation(false, cancellation.b) : com.google.common.util.concurrent.AbstractFuture.Cancellation.d : obj;
        }
        if ((listenableFuture instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess) && (tryInternalFastPathGetFailure = com.google.common.util.concurrent.internal.InternalFutures.tryInternalFastPathGetFailure((com.google.common.util.concurrent.internal.InternalFutureFailureAccess) listenableFuture)) != null) {
            return new com.google.common.util.concurrent.AbstractFuture.Failure(tryInternalFastPathGetFailure);
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!v) && isCancelled) {
            return com.google.common.util.concurrent.AbstractFuture.Cancellation.d;
        }
        try {
            java.lang.Object r = r(listenableFuture);
            if (!isCancelled) {
                return r == null ? y : r;
            }
            return new com.google.common.util.concurrent.AbstractFuture.Cancellation(false, new java.lang.IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
        } catch (java.util.concurrent.CancellationException e) {
            if (isCancelled) {
                return new com.google.common.util.concurrent.AbstractFuture.Cancellation(false, e);
            }
            return new com.google.common.util.concurrent.AbstractFuture.Failure(new java.lang.IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e));
        } catch (java.util.concurrent.ExecutionException e2) {
            if (!isCancelled) {
                return new com.google.common.util.concurrent.AbstractFuture.Failure(e2.getCause());
            }
            return new com.google.common.util.concurrent.AbstractFuture.Cancellation(false, new java.lang.IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
        } catch (java.lang.Throwable th) {
            return new com.google.common.util.concurrent.AbstractFuture.Failure(th);
        }
    }

    public static <V> V r(java.util.concurrent.Future<V> future) throws java.util.concurrent.ExecutionException {
        V v2;
        boolean z = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (java.lang.InterruptedException unused) {
                z = true;
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
        return v2;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(java.lang.Runnable runnable, java.util.concurrent.Executor executor) {
        com.google.common.util.concurrent.AbstractFuture.Listener listener;
        com.google.common.base.Preconditions.checkNotNull(runnable, "Runnable was null.");
        com.google.common.base.Preconditions.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (listener = this.t) != com.google.common.util.concurrent.AbstractFuture.Listener.d) {
            com.google.common.util.concurrent.AbstractFuture.Listener listener2 = new com.google.common.util.concurrent.AbstractFuture.Listener(runnable, executor);
            do {
                listener2.c = listener;
                if (x.a(this, listener, listener2)) {
                    return;
                } else {
                    listener = this.t;
                }
            } while (listener != com.google.common.util.concurrent.AbstractFuture.Listener.d);
        }
        o(runnable, executor);
    }

    @com.google.common.annotations.Beta
    @com.google.errorprone.annotations.ForOverride
    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        java.lang.Object obj = this.n;
        if (!(obj == null) && !(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture)) {
            return false;
        }
        com.google.common.util.concurrent.AbstractFuture.Cancellation cancellation = v ? new com.google.common.util.concurrent.AbstractFuture.Cancellation(z, new java.util.concurrent.CancellationException("Future.cancel() was called.")) : z ? com.google.common.util.concurrent.AbstractFuture.Cancellation.c : com.google.common.util.concurrent.AbstractFuture.Cancellation.d;
        boolean z2 = false;
        com.google.common.util.concurrent.AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (x.b(abstractFuture, obj, cancellation)) {
                if (z) {
                    abstractFuture.interruptTask();
                }
                n(abstractFuture);
                if (!(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture)) {
                    return true;
                }
                com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture = ((com.google.common.util.concurrent.AbstractFuture.SetFuture) obj).t;
                if (!(listenableFuture instanceof com.google.common.util.concurrent.AbstractFuture.Trusted)) {
                    listenableFuture.cancel(z);
                    return true;
                }
                abstractFuture = (com.google.common.util.concurrent.AbstractFuture) listenableFuture;
                obj = abstractFuture.n;
                if (!(obj == null) && !(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.n;
                if (!(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V get() throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        java.lang.Object obj;
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        java.lang.Object obj2 = this.n;
        if ((obj2 != null) && (!(obj2 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture))) {
            return p(obj2);
        }
        com.google.common.util.concurrent.AbstractFuture.Waiter waiter = this.u;
        if (waiter != com.google.common.util.concurrent.AbstractFuture.Waiter.c) {
            com.google.common.util.concurrent.AbstractFuture.Waiter waiter2 = new com.google.common.util.concurrent.AbstractFuture.Waiter();
            do {
                waiter2.a(waiter);
                if (x.c(this, waiter, waiter2)) {
                    do {
                        java.util.concurrent.locks.LockSupport.park(this);
                        if (java.lang.Thread.interrupted()) {
                            u(waiter2);
                            throw new java.lang.InterruptedException();
                        }
                        obj = this.n;
                    } while (!((obj != null) & (!(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture))));
                    return p(obj);
                }
                waiter = this.u;
            } while (waiter != com.google.common.util.concurrent.AbstractFuture.Waiter.c);
        }
        return p(this.n);
    }

    @Override // java.util.concurrent.Future
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException, java.util.concurrent.ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        java.lang.Object obj = this.n;
        if ((obj != null) && (!(obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture))) {
            return p(obj);
        }
        long nanoTime = nanos > 0 ? java.lang.System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            com.google.common.util.concurrent.AbstractFuture.Waiter waiter = this.u;
            if (waiter != com.google.common.util.concurrent.AbstractFuture.Waiter.c) {
                com.google.common.util.concurrent.AbstractFuture.Waiter waiter2 = new com.google.common.util.concurrent.AbstractFuture.Waiter();
                do {
                    waiter2.a(waiter);
                    if (x.c(this, waiter, waiter2)) {
                        do {
                            java.util.concurrent.locks.LockSupport.parkNanos(this, nanos);
                            if (java.lang.Thread.interrupted()) {
                                u(waiter2);
                                throw new java.lang.InterruptedException();
                            }
                            java.lang.Object obj2 = this.n;
                            if ((obj2 != null) && (!(obj2 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture))) {
                                return p(obj2);
                            }
                            nanos = nanoTime - java.lang.System.nanoTime();
                        } while (nanos >= 1000);
                        u(waiter2);
                    } else {
                        waiter = this.u;
                    }
                } while (waiter != com.google.common.util.concurrent.AbstractFuture.Waiter.c);
            }
            return p(this.n);
        }
        while (nanos > 0) {
            java.lang.Object obj3 = this.n;
            if ((obj3 != null) && (!(obj3 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture))) {
                return p(obj3);
            }
            if (java.lang.Thread.interrupted()) {
                throw new java.lang.InterruptedException();
            }
            nanos = nanoTime - java.lang.System.nanoTime();
        }
        java.lang.String abstractFuture = toString();
        java.lang.String obj4 = timeUnit.toString();
        java.util.Locale locale = java.util.Locale.ROOT;
        java.lang.String lowerCase = obj4.toLowerCase(locale);
        java.lang.String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            java.lang.String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, java.util.concurrent.TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                java.lang.String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new java.util.concurrent.TimeoutException(str + " but future completed as timeout expired");
        }
        throw new java.util.concurrent.TimeoutException(str + " for " + abstractFuture);
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.n instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture)) & (this.n != null);
    }

    public final void k(java.lang.StringBuilder sb) {
        try {
            java.lang.Object r = r(this);
            sb.append("SUCCESS, result=[");
            sb.append(v(r));
            sb.append("]");
        } catch (java.util.concurrent.CancellationException unused) {
            sb.append("CANCELLED");
        } catch (java.lang.RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (java.util.concurrent.ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    public final com.google.common.util.concurrent.AbstractFuture.Listener m(com.google.common.util.concurrent.AbstractFuture.Listener listener) {
        com.google.common.util.concurrent.AbstractFuture.Listener listener2;
        do {
            listener2 = this.t;
        } while (!x.a(this, listener2, com.google.common.util.concurrent.AbstractFuture.Listener.d));
        com.google.common.util.concurrent.AbstractFuture.Listener listener3 = listener;
        com.google.common.util.concurrent.AbstractFuture.Listener listener4 = listener2;
        while (listener4 != null) {
            com.google.common.util.concurrent.AbstractFuture.Listener listener5 = listener4.c;
            listener4.c = listener3;
            listener3 = listener4;
            listener4 = listener5;
        }
        return listener3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V p(java.lang.Object obj) throws java.util.concurrent.ExecutionException {
        if (obj instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation) {
            throw l("Task was cancelled.", ((com.google.common.util.concurrent.AbstractFuture.Cancellation) obj).b);
        }
        if (obj instanceof com.google.common.util.concurrent.AbstractFuture.Failure) {
            throw new java.util.concurrent.ExecutionException(((com.google.common.util.concurrent.AbstractFuture.Failure) obj).a);
        }
        if (obj == y) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public java.lang.String pendingToString() {
        java.lang.Object obj = this.n;
        if (obj instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture) {
            return "setFuture=[" + v(((com.google.common.util.concurrent.AbstractFuture.SetFuture) obj).t) + "]";
        }
        if (!(this instanceof java.util.concurrent.ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((java.util.concurrent.ScheduledFuture) this).getDelay(java.util.concurrent.TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void s(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.util.concurrent.Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean set(@org.checkerframework.checker.nullness.compatqual.NullableDecl V v2) {
        if (v2 == null) {
            v2 = (V) y;
        }
        if (!x.b(this, null, v2)) {
            return false;
        }
        n(this);
        return true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public boolean setException(java.lang.Throwable th) {
        if (!x.b(this, null, new com.google.common.util.concurrent.AbstractFuture.Failure((java.lang.Throwable) com.google.common.base.Preconditions.checkNotNull(th)))) {
            return false;
        }
        n(this);
        return true;
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    @com.google.common.annotations.Beta
    public boolean setFuture(com.google.common.util.concurrent.ListenableFuture<? extends V> listenableFuture) {
        com.google.common.util.concurrent.AbstractFuture.Failure failure;
        com.google.common.base.Preconditions.checkNotNull(listenableFuture);
        java.lang.Object obj = this.n;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!x.b(this, null, q(listenableFuture))) {
                    return false;
                }
                n(this);
                return true;
            }
            com.google.common.util.concurrent.AbstractFuture.SetFuture setFuture = new com.google.common.util.concurrent.AbstractFuture.SetFuture(this, listenableFuture);
            if (x.b(this, null, setFuture)) {
                try {
                    listenableFuture.addListener(setFuture, com.google.common.util.concurrent.DirectExecutor.INSTANCE);
                } catch (java.lang.Throwable th) {
                    try {
                        failure = new com.google.common.util.concurrent.AbstractFuture.Failure(th);
                    } catch (java.lang.Throwable unused) {
                        failure = com.google.common.util.concurrent.AbstractFuture.Failure.b;
                    }
                    x.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.n;
        }
        if (obj instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation) {
            listenableFuture.cancel(((com.google.common.util.concurrent.AbstractFuture.Cancellation) obj).a);
        }
        return false;
    }

    public final void t() {
        com.google.common.util.concurrent.AbstractFuture.Waiter waiter;
        do {
            waiter = this.u;
        } while (!x.c(this, waiter, com.google.common.util.concurrent.AbstractFuture.Waiter.c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.b;
        }
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            try {
                str = pendingToString();
            } catch (java.lang.RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                k(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final java.lang.Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof com.google.common.util.concurrent.AbstractFuture.Trusted)) {
            return null;
        }
        java.lang.Object obj = this.n;
        if (obj instanceof com.google.common.util.concurrent.AbstractFuture.Failure) {
            return ((com.google.common.util.concurrent.AbstractFuture.Failure) obj).a;
        }
        return null;
    }

    public final void u(com.google.common.util.concurrent.AbstractFuture.Waiter waiter) {
        waiter.a = null;
        while (true) {
            com.google.common.util.concurrent.AbstractFuture.Waiter waiter2 = this.u;
            if (waiter2 == com.google.common.util.concurrent.AbstractFuture.Waiter.c) {
                return;
            }
            com.google.common.util.concurrent.AbstractFuture.Waiter waiter3 = null;
            while (waiter2 != null) {
                com.google.common.util.concurrent.AbstractFuture.Waiter waiter4 = waiter2.b;
                if (waiter2.a != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.b = waiter4;
                    if (waiter3.a == null) {
                        break;
                    }
                } else if (!x.c(this, waiter2, waiter4)) {
                    break;
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    public final java.lang.String v(java.lang.Object obj) {
        return obj == this ? "this future" : java.lang.String.valueOf(obj);
    }

    public final boolean wasInterrupted() {
        java.lang.Object obj = this.n;
        return (obj instanceof com.google.common.util.concurrent.AbstractFuture.Cancellation) && ((com.google.common.util.concurrent.AbstractFuture.Cancellation) obj).a;
    }
}
