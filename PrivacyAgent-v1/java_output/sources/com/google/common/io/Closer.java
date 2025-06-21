package com.google.common.io;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public final class Closer implements java.io.Closeable {
    public static final com.google.common.io.Closer.Suppressor v;

    @com.google.common.annotations.VisibleForTesting
    public final com.google.common.io.Closer.Suppressor n;
    public final java.util.Deque<java.io.Closeable> t = new java.util.ArrayDeque(4);

    @org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl
    public java.lang.Throwable u;

    @com.google.common.annotations.VisibleForTesting
    public static final class LoggingSuppressor implements com.google.common.io.Closer.Suppressor {
        public static final com.google.common.io.Closer.LoggingSuppressor a = new com.google.common.io.Closer.LoggingSuppressor();

        @Override // com.google.common.io.Closer.Suppressor
        public void a(java.io.Closeable closeable, java.lang.Throwable th, java.lang.Throwable th2) {
            com.google.common.io.Closeables.a.log(java.util.logging.Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class SuppressingSuppressor implements com.google.common.io.Closer.Suppressor {
        public static final com.google.common.io.Closer.SuppressingSuppressor a = new com.google.common.io.Closer.SuppressingSuppressor();
        public static final java.lang.reflect.Method b = b();

        public static java.lang.reflect.Method b() {
            try {
                return java.lang.Throwable.class.getMethod("addSuppressed", java.lang.Throwable.class);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        public static boolean c() {
            return b != null;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void a(java.io.Closeable closeable, java.lang.Throwable th, java.lang.Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                b.invoke(th, th2);
            } catch (java.lang.Throwable unused) {
                com.google.common.io.Closer.LoggingSuppressor.a.a(closeable, th, th2);
            }
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public interface Suppressor {
        void a(java.io.Closeable closeable, java.lang.Throwable th, java.lang.Throwable th2);
    }

    static {
        v = com.google.common.io.Closer.SuppressingSuppressor.c() ? com.google.common.io.Closer.SuppressingSuppressor.a : com.google.common.io.Closer.LoggingSuppressor.a;
    }

    @com.google.common.annotations.VisibleForTesting
    public Closer(com.google.common.io.Closer.Suppressor suppressor) {
        this.n = (com.google.common.io.Closer.Suppressor) com.google.common.base.Preconditions.checkNotNull(suppressor);
    }

    public static com.google.common.io.Closer create() {
        return new com.google.common.io.Closer(v);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.lang.Throwable th = this.u;
        while (!this.t.isEmpty()) {
            java.io.Closeable removeFirst = this.t.removeFirst();
            try {
                removeFirst.close();
            } catch (java.lang.Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.n.a(removeFirst, th, th2);
                }
            }
        }
        if (this.u != null || th == null) {
            return;
        }
        com.google.common.base.Throwables.propagateIfPossible(th, java.io.IOException.class);
        throw new java.lang.AssertionError(th);
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public <C extends java.io.Closeable> C register(@org.checkerframework.checker.nullness.compatqual.NullableDecl C c) {
        if (c != null) {
            this.t.addFirst(c);
        }
        return c;
    }

    public java.lang.RuntimeException rethrow(java.lang.Throwable th) throws java.io.IOException {
        com.google.common.base.Preconditions.checkNotNull(th);
        this.u = th;
        com.google.common.base.Throwables.propagateIfPossible(th, java.io.IOException.class);
        throw new java.lang.RuntimeException(th);
    }

    public <X extends java.lang.Exception> java.lang.RuntimeException rethrow(java.lang.Throwable th, java.lang.Class<X> cls) throws java.io.IOException, java.lang.Exception {
        com.google.common.base.Preconditions.checkNotNull(th);
        this.u = th;
        com.google.common.base.Throwables.propagateIfPossible(th, java.io.IOException.class);
        com.google.common.base.Throwables.propagateIfPossible(th, cls);
        throw new java.lang.RuntimeException(th);
    }

    public <X1 extends java.lang.Exception, X2 extends java.lang.Exception> java.lang.RuntimeException rethrow(java.lang.Throwable th, java.lang.Class<X1> cls, java.lang.Class<X2> cls2) throws java.io.IOException, java.lang.Exception, java.lang.Exception {
        com.google.common.base.Preconditions.checkNotNull(th);
        this.u = th;
        com.google.common.base.Throwables.propagateIfPossible(th, java.io.IOException.class);
        com.google.common.base.Throwables.propagateIfPossible(th, cls, cls2);
        throw new java.lang.RuntimeException(th);
    }
}
