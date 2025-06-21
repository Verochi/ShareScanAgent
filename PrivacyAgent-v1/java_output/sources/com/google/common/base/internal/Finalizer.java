package com.google.common.base.internal;

/* loaded from: classes22.dex */
public class Finalizer implements java.lang.Runnable {
    public static final java.util.logging.Logger v = java.util.logging.Logger.getLogger(com.google.common.base.internal.Finalizer.class.getName());

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static final java.lang.reflect.Constructor<java.lang.Thread> w;

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static final java.lang.reflect.Field x;
    public final java.lang.ref.WeakReference<java.lang.Class<?>> n;
    public final java.lang.ref.PhantomReference<java.lang.Object> t;
    public final java.lang.ref.ReferenceQueue<java.lang.Object> u;

    static {
        java.lang.reflect.Constructor<java.lang.Thread> b = b();
        w = b;
        x = b == null ? d() : null;
    }

    public Finalizer(java.lang.Class<?> cls, java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue, java.lang.ref.PhantomReference<java.lang.Object> phantomReference) {
        this.u = referenceQueue;
        this.n = new java.lang.ref.WeakReference<>(cls);
        this.t = phantomReference;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.reflect.Constructor<java.lang.Thread> b() {
        try {
            return java.lang.Thread.class.getConstructor(java.lang.ThreadGroup.class, java.lang.Runnable.class, java.lang.String.class, java.lang.Long.TYPE, java.lang.Boolean.TYPE);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public static java.lang.reflect.Field d() {
        try {
            java.lang.reflect.Field declaredField = java.lang.Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Throwable unused) {
            v.log(java.util.logging.Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(10:5|6|7|(1:9)|10|11|12|(1:14)|16|17)|24|(0)|10|11|12|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        com.google.common.base.internal.Finalizer.v.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: all -> 0x005a, TRY_LEAVE, TryCatch #0 {all -> 0x005a, blocks: (B:12:0x0052, B:14:0x0056), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void startFinalizer(java.lang.Class<?> cls, java.lang.ref.ReferenceQueue<java.lang.Object> referenceQueue, java.lang.ref.PhantomReference<java.lang.Object> phantomReference) {
        java.lang.Thread thread;
        java.lang.reflect.Field field;
        if (!cls.getName().equals("com.google.common.base.FinalizableReference")) {
            throw new java.lang.IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        com.google.common.base.internal.Finalizer finalizer = new com.google.common.base.internal.Finalizer(cls, referenceQueue, phantomReference);
        java.lang.String name = com.google.common.base.internal.Finalizer.class.getName();
        java.lang.reflect.Constructor<java.lang.Thread> constructor = w;
        if (constructor != null) {
            try {
                thread = constructor.newInstance(null, finalizer, name, 0L, java.lang.Boolean.FALSE);
            } catch (java.lang.Throwable th) {
                v.log(java.util.logging.Level.INFO, "Failed to create a thread without inherited thread-local values", th);
            }
            if (thread == null) {
                thread = new java.lang.Thread(null, finalizer, name);
            }
            thread.setDaemon(true);
            field = x;
            if (field != null) {
                field.set(thread, null);
            }
            thread.start();
        }
        thread = null;
        if (thread == null) {
        }
        thread.setDaemon(true);
        field = x;
        if (field != null) {
        }
        thread.start();
    }

    public final boolean a(java.lang.ref.Reference<?> reference) {
        java.lang.reflect.Method c = c();
        if (c == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.t) {
                return false;
            }
            try {
                c.invoke(reference, new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                v.log(java.util.logging.Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.u.poll();
        } while (reference != null);
        return true;
    }

    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    public final java.lang.reflect.Method c() {
        java.lang.Class<?> cls = this.n.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new java.lang.Class[0]);
        } catch (java.lang.NoSuchMethodException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.u.remove())) {
        }
    }
}
